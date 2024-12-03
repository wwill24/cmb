package org.jivesoftware.smack.fsm;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;
import org.jivesoftware.smack.c2s.internal.ModularXmppClientToServerConnectionInternal;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.MultiMap;

public class StateDescriptorGraph {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER = Logger.getLogger(StateDescriptorGraph.class.getName());

    private interface DfsEdgeFound<E> {
        void onEdgeFound(GraphVertex<E> graphVertex, GraphVertex<E> graphVertex2, int i10, int i11);
    }

    public static final class GraphVertex<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public VertexColor color;
        /* access modifiers changed from: private */
        public final E element;
        private final List<GraphVertex<E>> outgoingEdges;

        private enum VertexColor {
            white,
            grey,
            black
        }

        /* access modifiers changed from: private */
        public void addOutgoingEdge(GraphVertex<E> graphVertex) {
            if (!this.outgoingEdges.contains(graphVertex)) {
                this.outgoingEdges.add(graphVertex);
                return;
            }
            throw new IllegalArgumentException("This " + this + " already has an outgoing edge to " + graphVertex);
        }

        public E getElement() {
            return this.element;
        }

        public List<GraphVertex<E>> getOutgoingEdges() {
            return Collections.unmodifiableList(this.outgoingEdges);
        }

        public String toString() {
            return toString(true);
        }

        private GraphVertex(E e10) {
            this.outgoingEdges = new ArrayList();
            this.color = VertexColor.white;
            this.element = e10;
        }

        public String toString(boolean z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GraphVertex " + this.element + " [color=" + this.color + ", identityHashCode=" + System.identityHashCode(this) + ", outgoingEdgeCount=" + this.outgoingEdges.size());
            if (z10) {
                sb2.append(", outgoingEdges={");
                Iterator<GraphVertex<E>> it = this.outgoingEdges.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next().toString(false));
                    if (it.hasNext()) {
                        sb2.append(", ");
                    }
                }
                sb2.append('}');
            }
            sb2.append(PropertyUtils.INDEXED_DELIM2);
            return sb2.toString();
        }
    }

    private static final class HandleStateDescriptorGraphVertexContext {
        Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> graphVertexes;
        private final Set<Class<? extends StateDescriptor>> handledStateDescriptors;
        MultiMap<Class<? extends StateDescriptor>, Class<? extends StateDescriptor>> inferredForwardEdges;

        /* access modifiers changed from: private */
        public GraphVertex<StateDescriptor> getOrConstruct(Class<? extends StateDescriptor> cls) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
            GraphVertex<StateDescriptor> graphVertex = this.graphVertexes.get(cls);
            if (graphVertex == null) {
                graphVertex = StateDescriptorGraph.addNewStateDescriptorGraphVertex(cls, this.graphVertexes);
                for (V addSuccessor : this.inferredForwardEdges.getAll(cls)) {
                    graphVertex.getElement().addSuccessor(addSuccessor);
                }
            }
            return graphVertex;
        }

        /* access modifiers changed from: private */
        public boolean recurseInto(Class<? extends StateDescriptor> cls) {
            return !this.handledStateDescriptors.add(cls);
        }

        private HandleStateDescriptorGraphVertexContext(Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> map, MultiMap<Class<? extends StateDescriptor>, Class<? extends StateDescriptor>> multiMap) {
            this.handledStateDescriptors = new HashSet();
            this.graphVertexes = map;
            this.inferredForwardEdges = multiMap;
        }
    }

    /* access modifiers changed from: private */
    public static GraphVertex<StateDescriptor> addNewStateDescriptorGraphVertex(Class<? extends StateDescriptor> cls, Map<Class<? extends StateDescriptor>, GraphVertex<StateDescriptor>> map) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Constructor<? extends StateDescriptor> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        GraphVertex<StateDescriptor> graphVertex = new GraphVertex<>((StateDescriptor) declaredConstructor.newInstance(new Object[0]));
        GraphVertex put = map.put(cls, graphVertex);
        return graphVertex;
    }

    public static GraphVertex<StateDescriptor> constructStateDescriptorGraph(Set<Class<? extends StateDescriptor>> set) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        HashMap hashMap = new HashMap();
        Class<ModularXmppClientToServerConnection.DisconnectedStateDescriptor> cls = ModularXmppClientToServerConnection.DisconnectedStateDescriptor.class;
        GraphVertex<StateDescriptor> addNewStateDescriptorGraphVertex = addNewStateDescriptorGraphVertex(cls, hashMap);
        MultiMap multiMap = new MultiMap();
        for (Class next : set) {
            for (Class<? extends StateDescriptor> put : addNewStateDescriptorGraphVertex(next, hashMap).getElement().getPredeccessors()) {
                multiMap.put(put, next);
            }
        }
        for (V addSuccessor : multiMap.getAll(cls)) {
            addNewStateDescriptorGraphVertex.getElement().addSuccessor(addSuccessor);
        }
        handleStateDescriptorGraphVertex(addNewStateDescriptorGraphVertex, new HandleStateDescriptorGraphVertexContext(hashMap, multiMap));
        return addNewStateDescriptorGraphVertex;
    }

    private static GraphVertex<State> convertToStateGraph(GraphVertex<StateDescriptor> graphVertex, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal, Map<StateDescriptor, GraphVertex<State>> map) {
        StateDescriptor element = graphVertex.getElement();
        GraphVertex<State> graphVertex2 = map.get(element);
        if (graphVertex2 != null) {
            return graphVertex2;
        }
        GraphVertex<State> graphVertex3 = new GraphVertex<>(element.constructState(modularXmppClientToServerConnectionInternal));
        map.put(element, graphVertex3);
        for (GraphVertex<StateDescriptor> convertToStateGraph : graphVertex.getOutgoingEdges()) {
            graphVertex3.addOutgoingEdge(convertToStateGraph(convertToStateGraph, modularXmppClientToServerConnectionInternal, map));
        }
        return graphVertex3;
    }

    private static <E> void dfs(Collection<GraphVertex<E>> collection, Consumer<GraphVertex<E>> consumer, DfsEdgeFound<E> dfsEdgeFound) {
        for (GraphVertex next : collection) {
            if (next.color == GraphVertex.VertexColor.white) {
                dfsVisit(next, consumer, dfsEdgeFound);
            }
        }
    }

    private static <E> void dfsVisit(GraphVertex<E> graphVertex, Consumer<GraphVertex<E>> consumer, DfsEdgeFound<E> dfsEdgeFound) {
        GraphVertex.VertexColor unused = graphVertex.color = GraphVertex.VertexColor.grey;
        int size = graphVertex.getOutgoingEdges().size();
        int i10 = 0;
        for (GraphVertex next : graphVertex.getOutgoingEdges()) {
            i10++;
            if (dfsEdgeFound != null) {
                dfsEdgeFound.onEdgeFound(graphVertex, next, i10, size);
            }
            if (next.color == GraphVertex.VertexColor.white) {
                dfsVisit(next, consumer, dfsEdgeFound);
            }
        }
        GraphVertex.VertexColor unused2 = graphVertex.color = GraphVertex.VertexColor.black;
        if (consumer != null) {
            consumer.accept(graphVertex);
        }
    }

    private static void handleStateDescriptorGraphVertex(GraphVertex<StateDescriptor> graphVertex, HandleStateDescriptorGraphVertexContext handleStateDescriptorGraphVertexContext) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> cls = ((StateDescriptor) graphVertex.element).getClass();
        if (!handleStateDescriptorGraphVertexContext.recurseInto(cls)) {
            Set<Class<? extends StateDescriptor>> successors = ((StateDescriptor) graphVertex.element).getSuccessors();
            int size = successors.size();
            HashMap hashMap = new HashMap(size);
            for (Class next : successors) {
                hashMap.put(next, handleStateDescriptorGraphVertexContext.getOrConstruct(next));
            }
            if (size == 0) {
                throw new IllegalStateException("State " + cls + " has no successor");
            } else if (size != 1) {
                HashMap hashMap2 = new HashMap(size);
                for (GraphVertex access$200 : hashMap.values()) {
                    StateDescriptor stateDescriptor = (StateDescriptor) access$200.element;
                    Class<?> cls2 = stateDescriptor.getClass();
                    for (Class next2 : stateDescriptor.getSubordinates()) {
                        if (!successors.contains(next2)) {
                            Logger logger = LOGGER;
                            logger.severe(stateDescriptor + " points to a subordinate '" + next2 + "' which is not part of the successor set");
                        } else {
                            lookupAndCreateIfRequired(hashMap2, cls2).addOutgoingEdge(lookupAndCreateIfRequired(hashMap2, next2));
                        }
                    }
                    for (Class next3 : stateDescriptor.getSuperiors()) {
                        if (!successors.contains(next3)) {
                            Logger logger2 = LOGGER;
                            logger2.severe(stateDescriptor + " points to a superior '" + next3 + "' which is not part of the successor set");
                        } else {
                            lookupAndCreateIfRequired(hashMap2, next3).addOutgoingEdge(lookupAndCreateIfRequired(hashMap2, cls2));
                        }
                    }
                }
                List<GraphVertex> list = topologicalSort(hashMap2.values());
                for (Class next4 : successors) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((GraphVertex) it.next()).getElement() == next4) {
                                break;
                            }
                        } else {
                            list.add(new GraphVertex(next4));
                            break;
                        }
                    }
                }
                for (GraphVertex access$2002 : list) {
                    GraphVertex graphVertex2 = (GraphVertex) hashMap.get(access$2002.element);
                    graphVertex.addOutgoingEdge(graphVertex2);
                    handleStateDescriptorGraphVertex(graphVertex2, handleStateDescriptorGraphVertexContext);
                }
            } else {
                GraphVertex graphVertex3 = (GraphVertex) hashMap.values().iterator().next();
                graphVertex.addOutgoingEdge(graphVertex3);
                handleStateDescriptorGraphVertex(graphVertex3, handleStateDescriptorGraphVertexContext);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stateDescriptorGraphToDot$1(PrintWriter printWriter, boolean z10, GraphVertex graphVertex) {
        String str;
        boolean isMultiVisitState = ((StateDescriptor) graphVertex.element).isMultiVisitState();
        boolean isFinalState = ((StateDescriptor) graphVertex.element).isFinalState();
        boolean isNotImplemented = ((StateDescriptor) graphVertex.element).isNotImplemented();
        if (isMultiVisitState) {
            str = "bold";
        } else if (isFinalState) {
            str = "filled";
        } else if (isNotImplemented) {
            str = "dashed";
        } else {
            str = null;
        }
        if (str != null) {
            printWriter.append('\"').append(((StateDescriptor) graphVertex.element).getFullStateName(z10)).append("\" [ ").append("style=").append(str).append(" ]\n");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stateDescriptorGraphToDot$2(PrintWriter printWriter, boolean z10, GraphVertex graphVertex, GraphVertex graphVertex2, int i10, int i11) {
        printWriter.append("  \"").append(((StateDescriptor) graphVertex.element).getFullStateName(z10)).append("\" -> \"").append(((StateDescriptor) graphVertex2.element).getFullStateName(z10)).append('\"');
        if (i11 > 1) {
            printWriter.append(" [xlabel=\"").append(Integer.toString(i10)).append("\"]");
        }
        printWriter.append(";\n");
    }

    private static GraphVertex<Class<? extends StateDescriptor>> lookupAndCreateIfRequired(Map<Class<? extends StateDescriptor>, GraphVertex<Class<? extends StateDescriptor>>> map, Class<? extends StateDescriptor> cls) {
        GraphVertex<Class<? extends StateDescriptor>> graphVertex = map.get(cls);
        if (graphVertex != null) {
            return graphVertex;
        }
        GraphVertex<Class<? extends StateDescriptor>> graphVertex2 = new GraphVertex<>(cls);
        map.put(cls, graphVertex2);
        return graphVertex2;
    }

    public static <E> void stateDescriptorGraphToDot(Collection<GraphVertex<StateDescriptor>> collection, PrintWriter printWriter, boolean z10) {
        printWriter.append("digraph {\n");
        dfs(collection, new a(printWriter, z10), new b(printWriter, z10));
        printWriter.append("}\n");
    }

    private static <E> List<GraphVertex<E>> topologicalSort(Collection<GraphVertex<E>> collection) {
        ArrayList arrayList = new ArrayList();
        dfs(collection, new c(arrayList), (DfsEdgeFound) null);
        return arrayList;
    }

    public static GraphVertex<State> convertToStateGraph(GraphVertex<StateDescriptor> graphVertex, ModularXmppClientToServerConnectionInternal modularXmppClientToServerConnectionInternal) {
        return convertToStateGraph(graphVertex, modularXmppClientToServerConnectionInternal, new HashMap());
    }
}
