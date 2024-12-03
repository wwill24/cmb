package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.ViewProcessor;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class View {
    private final EventGenerator eventGenerator;
    private final List<EventRegistration> eventRegistrations = new ArrayList();
    private final ViewProcessor processor;
    private final QuerySpec query;
    private ViewCache viewCache;

    public static class OperationResult {
        public final List<Change> changes;
        public final List<DataEvent> events;

        public OperationResult(List<DataEvent> list, List<Change> list2) {
            this.events = list;
            this.changes = list2;
        }
    }

    public View(QuerySpec querySpec, ViewCache viewCache2) {
        this.query = querySpec;
        IndexedFilter indexedFilter = new IndexedFilter(querySpec.getIndex());
        NodeFilter nodeFilter = querySpec.getParams().getNodeFilter();
        this.processor = new ViewProcessor(nodeFilter);
        CacheNode serverCache = viewCache2.getServerCache();
        CacheNode eventCache = viewCache2.getEventCache();
        IndexedNode from = IndexedNode.from(EmptyNode.Empty(), querySpec.getIndex());
        IndexedNode updateFullNode = indexedFilter.updateFullNode(from, serverCache.getIndexedNode(), (ChildChangeAccumulator) null);
        IndexedNode updateFullNode2 = nodeFilter.updateFullNode(from, eventCache.getIndexedNode(), (ChildChangeAccumulator) null);
        this.viewCache = new ViewCache(new CacheNode(updateFullNode2, eventCache.isFullyInitialized(), nodeFilter.filtersNodes()), new CacheNode(updateFullNode, serverCache.isFullyInitialized(), indexedFilter.filtersNodes()));
        this.eventGenerator = new EventGenerator(querySpec);
    }

    private List<DataEvent> generateEventsForChanges(List<Change> list, IndexedNode indexedNode, EventRegistration eventRegistration) {
        List<EventRegistration> list2;
        if (eventRegistration == null) {
            list2 = this.eventRegistrations;
        } else {
            list2 = Arrays.asList(new EventRegistration[]{eventRegistration});
        }
        return this.eventGenerator.generateEventsForChanges(list, indexedNode, list2);
    }

    public void addEventRegistration(@NotNull EventRegistration eventRegistration) {
        this.eventRegistrations.add(eventRegistration);
    }

    public OperationResult applyOperation(Operation operation, WriteTreeRef writeTreeRef, Node node) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (operation.getType() == Operation.OperationType.Merge && operation.getSource().getQueryParams() != null) {
            if (this.viewCache.getCompleteServerSnap() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Utilities.hardAssert(z10, "We should always have a full cache before handling merges");
            if (this.viewCache.getCompleteEventSnap() != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Utilities.hardAssert(z11, "Missing event cache, even though we have a server cache");
        }
        ViewCache viewCache2 = this.viewCache;
        ViewProcessor.ProcessorResult applyOperation = this.processor.applyOperation(viewCache2, operation, writeTreeRef, node);
        if (applyOperation.viewCache.getServerCache().isFullyInitialized() || !viewCache2.getServerCache().isFullyInitialized()) {
            z12 = true;
        }
        Utilities.hardAssert(z12, "Once a server snap is complete, it should never go back");
        ViewCache viewCache3 = applyOperation.viewCache;
        this.viewCache = viewCache3;
        return new OperationResult(generateEventsForChanges(applyOperation.changes, viewCache3.getEventCache().getIndexedNode(), (EventRegistration) null), applyOperation.changes);
    }

    public Node getCompleteNode() {
        return this.viewCache.getCompleteEventSnap();
    }

    public Node getCompleteServerCache(Path path) {
        Node completeServerSnap = this.viewCache.getCompleteServerSnap();
        if (completeServerSnap == null) {
            return null;
        }
        if (this.query.loadsAllData() || (!path.isEmpty() && !completeServerSnap.getImmediateChild(path.getFront()).isEmpty())) {
            return completeServerSnap.getChild(path);
        }
        return null;
    }

    public Node getEventCache() {
        return this.viewCache.getEventCache().getNode();
    }

    /* access modifiers changed from: package-private */
    public List<EventRegistration> getEventRegistrations() {
        return this.eventRegistrations;
    }

    public List<DataEvent> getInitialEvents(EventRegistration eventRegistration) {
        CacheNode eventCache = this.viewCache.getEventCache();
        ArrayList arrayList = new ArrayList();
        for (NamedNode namedNode : eventCache.getNode()) {
            arrayList.add(Change.childAddedChange(namedNode.getName(), namedNode.getNode()));
        }
        if (eventCache.isFullyInitialized()) {
            arrayList.add(Change.valueChange(eventCache.getIndexedNode()));
        }
        return generateEventsForChanges(arrayList, eventCache.getIndexedNode(), eventRegistration);
    }

    public QuerySpec getQuery() {
        return this.query;
    }

    public Node getServerCache() {
        return this.viewCache.getServerCache().getNode();
    }

    public boolean isEmpty() {
        return this.eventRegistrations.isEmpty();
    }

    public List<Event> removeEventRegistration(@Nullable EventRegistration eventRegistration, DatabaseError databaseError) {
        List<Event> list;
        boolean z10;
        int i10 = 0;
        if (databaseError != null) {
            list = new ArrayList<>();
            if (eventRegistration == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Utilities.hardAssert(z10, "A cancel should cancel all event registrations");
            Path path = this.query.getPath();
            for (EventRegistration cancelEvent : this.eventRegistrations) {
                list.add(new CancelEvent(cancelEvent, databaseError, path));
            }
        } else {
            list = Collections.emptyList();
        }
        if (eventRegistration != null) {
            int i11 = -1;
            while (true) {
                if (i10 >= this.eventRegistrations.size()) {
                    i10 = i11;
                    break;
                }
                EventRegistration eventRegistration2 = this.eventRegistrations.get(i10);
                if (eventRegistration2.isSameListener(eventRegistration)) {
                    if (eventRegistration2.isZombied()) {
                        break;
                    }
                    i11 = i10;
                }
                i10++;
            }
            if (i10 != -1) {
                this.eventRegistrations.remove(i10);
                this.eventRegistrations.get(i10).zombify();
            }
        } else {
            for (EventRegistration zombify : this.eventRegistrations) {
                zombify.zombify();
            }
            this.eventRegistrations.clear();
        }
        return list;
    }
}
