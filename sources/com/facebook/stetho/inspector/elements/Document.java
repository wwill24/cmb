package com.facebook.stetho.inspector.elements;

import android.os.SystemClock;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ShadowDocument;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public final class Document extends ThreadBoundProxy {
    private AttributeListAccumulator mCachedAttributeAccumulator;
    private ChildEventingList mCachedChildEventingList;
    private ArrayListAccumulator<Object> mCachedChildrenAccumulator;
    private final Queue<Object> mCachedUpdateQueue = new ArrayDeque();
    /* access modifiers changed from: private */
    public DocumentProvider mDocumentProvider;
    private final DocumentProviderFactory mFactory;
    /* access modifiers changed from: private */
    public final ObjectIdMapper mObjectIdMapper = new DocumentObjectIdMapper();
    private int mReferenceCounter = 0;
    /* access modifiers changed from: private */
    public ShadowDocument mShadowDocument;
    /* access modifiers changed from: private */
    public UpdateListenerCollection mUpdateListeners = new UpdateListenerCollection();

    public static final class AttributeListAccumulator extends ArrayList<String> implements AttributeAccumulator {
        public void store(String str, String str2) {
            add(str);
            add(str2);
        }
    }

    private final class ChildEventingList extends ArrayList<Object> {
        private DocumentView mDocumentView;
        private Object mParentElement;
        private int mParentNodeId;

        private ChildEventingList() {
            this.mParentElement = null;
            this.mParentNodeId = -1;
        }

        public void acquire(Object obj, DocumentView documentView) {
            int i10;
            this.mParentElement = obj;
            if (obj == null) {
                i10 = -1;
            } else {
                i10 = Document.this.mObjectIdMapper.getIdForObject(this.mParentElement).intValue();
            }
            this.mParentNodeId = i10;
            this.mDocumentView = documentView;
        }

        public void addWithEvent(int i10, Object obj, Accumulator<Object> accumulator) {
            Object obj2;
            int i11;
            if (i10 == 0) {
                obj2 = null;
            } else {
                obj2 = get(i10 - 1);
            }
            if (obj2 == null) {
                i11 = -1;
            } else {
                i11 = Document.this.mObjectIdMapper.getIdForObject(obj2).intValue();
            }
            add(i10, obj);
            Object obj3 = obj;
            Document.this.mUpdateListeners.onChildNodeInserted(this.mDocumentView, obj3, this.mParentNodeId, i11, accumulator);
        }

        public void release() {
            clear();
            this.mParentElement = null;
            this.mParentNodeId = -1;
            this.mDocumentView = null;
        }

        public void removeWithEvent(int i10) {
            Document.this.mUpdateListeners.onChildNodeRemoved(this.mParentNodeId, Document.this.mObjectIdMapper.getIdForObject(remove(i10)).intValue());
        }
    }

    private final class DocumentObjectIdMapper extends ObjectIdMapper {
        private DocumentObjectIdMapper() {
        }

        /* access modifiers changed from: protected */
        public void onMapped(Object obj, int i10) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).hook(obj);
        }

        /* access modifiers changed from: protected */
        public void onUnmapped(Object obj, int i10) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).unhook(obj);
        }
    }

    private final class ProviderListener implements DocumentProviderListener {
        private ProviderListener() {
        }

        public void onAttributeModified(Object obj, String str, String str2) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeModified(obj, str, str2);
        }

        public void onAttributeRemoved(Object obj, String str) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeRemoved(obj, str);
        }

        public void onInspectRequested(Object obj) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onInspectRequested(obj);
        }

        public void onPossiblyChanged() {
            Document.this.updateTree();
        }
    }

    public interface UpdateListener {
        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);

        void onChildNodeInserted(DocumentView documentView, Object obj, int i10, int i11, Accumulator<Object> accumulator);

        void onChildNodeRemoved(int i10, int i11);

        void onInspectRequested(Object obj);
    }

    private class UpdateListenerCollection implements UpdateListener {
        private final List<UpdateListener> mListeners = new ArrayList();
        private volatile UpdateListener[] mListenersSnapshot;

        public UpdateListenerCollection() {
        }

        private UpdateListener[] getListenersSnapshot() {
            while (true) {
                UpdateListener[] updateListenerArr = this.mListenersSnapshot;
                if (updateListenerArr != null) {
                    return updateListenerArr;
                }
                synchronized (this) {
                    if (this.mListenersSnapshot == null) {
                        List<UpdateListener> list = this.mListeners;
                        this.mListenersSnapshot = (UpdateListener[]) list.toArray(new UpdateListener[list.size()]);
                        UpdateListener[] updateListenerArr2 = this.mListenersSnapshot;
                        return updateListenerArr2;
                    }
                }
            }
        }

        public synchronized void add(UpdateListener updateListener) {
            this.mListeners.add(updateListener);
            this.mListenersSnapshot = null;
        }

        public synchronized void clear() {
            this.mListeners.clear();
            this.mListenersSnapshot = null;
        }

        public void onAttributeModified(Object obj, String str, String str2) {
            for (UpdateListener onAttributeModified : getListenersSnapshot()) {
                onAttributeModified.onAttributeModified(obj, str, str2);
            }
        }

        public void onAttributeRemoved(Object obj, String str) {
            for (UpdateListener onAttributeRemoved : getListenersSnapshot()) {
                onAttributeRemoved.onAttributeRemoved(obj, str);
            }
        }

        public void onChildNodeInserted(DocumentView documentView, Object obj, int i10, int i11, Accumulator<Object> accumulator) {
            for (UpdateListener onChildNodeInserted : getListenersSnapshot()) {
                onChildNodeInserted.onChildNodeInserted(documentView, obj, i10, i11, accumulator);
            }
        }

        public void onChildNodeRemoved(int i10, int i11) {
            for (UpdateListener onChildNodeRemoved : getListenersSnapshot()) {
                onChildNodeRemoved.onChildNodeRemoved(i10, i11);
            }
        }

        public void onInspectRequested(Object obj) {
            for (UpdateListener onInspectRequested : getListenersSnapshot()) {
                onInspectRequested.onInspectRequested(obj);
            }
        }

        public synchronized void remove(UpdateListener updateListener) {
            this.mListeners.remove(updateListener);
            this.mListenersSnapshot = null;
        }
    }

    public Document(DocumentProviderFactory documentProviderFactory) {
        super(documentProviderFactory);
        this.mFactory = documentProviderFactory;
    }

    private AttributeListAccumulator acquireCachedAttributeAccumulator() {
        AttributeListAccumulator attributeListAccumulator = this.mCachedAttributeAccumulator;
        if (attributeListAccumulator == null) {
            attributeListAccumulator = new AttributeListAccumulator();
        }
        this.mCachedChildrenAccumulator = null;
        return attributeListAccumulator;
    }

    /* access modifiers changed from: private */
    public ChildEventingList acquireChildEventingList(Object obj, DocumentView documentView) {
        ChildEventingList childEventingList = this.mCachedChildEventingList;
        if (childEventingList == null) {
            childEventingList = new ChildEventingList();
        }
        this.mCachedChildEventingList = null;
        childEventingList.acquire(obj, documentView);
        return childEventingList;
    }

    private ArrayListAccumulator<Object> acquireChildrenAccumulator() {
        ArrayListAccumulator<Object> arrayListAccumulator = this.mCachedChildrenAccumulator;
        if (arrayListAccumulator == null) {
            arrayListAccumulator = new ArrayListAccumulator<>();
        }
        this.mCachedChildrenAccumulator = null;
        return arrayListAccumulator;
    }

    private void applyDocumentUpdate(final ShadowDocument.Update update) {
        final ArrayList arrayList = new ArrayList();
        update.getGarbageElements(new Accumulator<Object>() {
            public void store(Object obj) {
                Integer num = (Integer) Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(obj));
                if (update.getElementInfo(obj).parentElement == null) {
                    Document.this.mUpdateListeners.onChildNodeRemoved(Document.this.mObjectIdMapper.getIdForObject(Document.this.mShadowDocument.getElementInfo(obj).parentElement).intValue(), num.intValue());
                }
                arrayList.add(num);
            }
        });
        Collections.sort(arrayList);
        update.getChangedElements(new Accumulator<Object>() {
            public void store(Object obj) {
                ElementInfo elementInfo;
                Integer num = (Integer) Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(obj));
                if (Collections.binarySearch(arrayList, num) < 0 && (elementInfo = Document.this.mShadowDocument.getElementInfo(obj)) != null && update.getElementInfo(obj).parentElement != elementInfo.parentElement) {
                    Document.this.mUpdateListeners.onChildNodeRemoved(Document.this.mObjectIdMapper.getIdForObject(elementInfo.parentElement).intValue(), num.intValue());
                }
            }
        });
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mObjectIdMapper.removeObjectById(((Integer) arrayList.get(i10)).intValue());
        }
        update.getChangedElements(new Accumulator<Object>() {
            private Accumulator<Object> insertedElements = new Accumulator<Object>() {
                public void store(Object obj) {
                    if (update.isElementChanged(obj)) {
                        AnonymousClass5.this.listenerInsertedElements.add(obj);
                    }
                }
            };
            /* access modifiers changed from: private */
            public final HashSet<Object> listenerInsertedElements = new HashSet<>();

            public void store(Object obj) {
                List<Object> list;
                ElementInfo elementInfo;
                if (Document.this.mObjectIdMapper.containsObject(obj) && !this.listenerInsertedElements.contains(obj)) {
                    ElementInfo elementInfo2 = Document.this.mShadowDocument.getElementInfo(obj);
                    ElementInfo elementInfo3 = update.getElementInfo(obj);
                    if (elementInfo2 != null) {
                        list = elementInfo2.children;
                    } else {
                        list = Collections.emptyList();
                    }
                    List<Object> list2 = elementInfo3.children;
                    ChildEventingList access$900 = Document.this.acquireChildEventingList(obj, update);
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        Object obj2 = list.get(i10);
                        if (Document.this.mObjectIdMapper.containsObject(obj2) && ((elementInfo = update.getElementInfo(obj2)) == null || elementInfo.parentElement == obj)) {
                            access$900.add(obj2);
                        }
                    }
                    Document.updateListenerChildren(access$900, list2, this.insertedElements);
                    Document.this.releaseChildEventingList(access$900);
                }
            }
        });
        update.commit();
    }

    private void cleanUp() {
        this.mDocumentProvider.postAndWait((Runnable) new Runnable() {
            public void run() {
                Document.this.mDocumentProvider.setListener((DocumentProviderListener) null);
                ShadowDocument unused = Document.this.mShadowDocument = null;
                Document.this.mObjectIdMapper.clear();
                Document.this.mDocumentProvider.dispose();
                DocumentProvider unused2 = Document.this.mDocumentProvider = null;
            }
        });
        this.mUpdateListeners.clear();
    }

    /* access modifiers changed from: private */
    public ShadowDocument.Update createShadowDocumentUpdate() {
        verifyThreadAccess();
        if (this.mDocumentProvider.getRootElement() == this.mShadowDocument.getRootElement()) {
            ArrayListAccumulator<Object> acquireChildrenAccumulator = acquireChildrenAccumulator();
            ShadowDocument.UpdateBuilder beginUpdate = this.mShadowDocument.beginUpdate();
            this.mCachedUpdateQueue.add(this.mDocumentProvider.getRootElement());
            while (!this.mCachedUpdateQueue.isEmpty()) {
                Object remove = this.mCachedUpdateQueue.remove();
                NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(remove);
                this.mObjectIdMapper.putObject(remove);
                nodeDescriptor.getChildren(remove, acquireChildrenAccumulator);
                int size = acquireChildrenAccumulator.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = acquireChildrenAccumulator.get(i10);
                    if (obj != null) {
                        this.mCachedUpdateQueue.add(obj);
                    } else {
                        LogUtil.e("%s.getChildren() emitted a null child at position %s for element %s", nodeDescriptor.getClass().getName(), Integer.toString(i10), remove);
                        acquireChildrenAccumulator.remove(i10);
                        i10--;
                        size--;
                    }
                    i10++;
                }
                beginUpdate.setElementChildren(remove, acquireChildrenAccumulator);
                acquireChildrenAccumulator.clear();
            }
            releaseChildrenAccumulator(acquireChildrenAccumulator);
            return beginUpdate.build();
        }
        throw new IllegalStateException();
    }

    private boolean doesElementMatch(Object obj, Pattern pattern) {
        AttributeListAccumulator acquireCachedAttributeAccumulator = acquireCachedAttributeAccumulator();
        NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(obj);
        nodeDescriptor.getAttributes(obj, acquireCachedAttributeAccumulator);
        int size = acquireCachedAttributeAccumulator.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (pattern.matcher((CharSequence) acquireCachedAttributeAccumulator.get(i10)).find()) {
                releaseCachedAttributeAccumulator(acquireCachedAttributeAccumulator);
                return true;
            }
        }
        releaseCachedAttributeAccumulator(acquireCachedAttributeAccumulator);
        return pattern.matcher(nodeDescriptor.getNodeName(obj)).find();
    }

    private void findMatches(Object obj, Pattern pattern, Accumulator<Integer> accumulator) {
        ElementInfo elementInfo = this.mShadowDocument.getElementInfo(obj);
        int size = elementInfo.children.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj2 = elementInfo.children.get(i10);
            if (doesElementMatch(obj2, pattern)) {
                accumulator.store(this.mObjectIdMapper.getIdForObject(obj2));
            }
            findMatches(obj2, pattern, accumulator);
        }
    }

    private void init() {
        DocumentProvider create = this.mFactory.create();
        this.mDocumentProvider = create;
        create.postAndWait((Runnable) new Runnable() {
            public void run() {
                Document document = Document.this;
                ShadowDocument unused = document.mShadowDocument = new ShadowDocument(document.mDocumentProvider.getRootElement());
                Document.this.createShadowDocumentUpdate().commit();
                Document.this.mDocumentProvider.setListener(new ProviderListener());
            }
        });
    }

    private void releaseCachedAttributeAccumulator(AttributeListAccumulator attributeListAccumulator) {
        attributeListAccumulator.clear();
        if (this.mCachedAttributeAccumulator == null) {
            this.mCachedAttributeAccumulator = attributeListAccumulator;
        }
    }

    /* access modifiers changed from: private */
    public void releaseChildEventingList(ChildEventingList childEventingList) {
        childEventingList.release();
        if (this.mCachedChildEventingList == null) {
            this.mCachedChildEventingList = childEventingList;
        }
    }

    private void releaseChildrenAccumulator(ArrayListAccumulator<Object> arrayListAccumulator) {
        arrayListAccumulator.clear();
        if (this.mCachedChildrenAccumulator == null) {
            this.mCachedChildrenAccumulator = arrayListAccumulator;
        }
    }

    /* access modifiers changed from: private */
    public static void updateListenerChildren(ChildEventingList childEventingList, List<Object> list, Accumulator<Object> accumulator) {
        int i10 = 0;
        while (i10 <= childEventingList.size()) {
            if (i10 == childEventingList.size()) {
                if (i10 != list.size()) {
                    childEventingList.addWithEvent(i10, list.get(i10), accumulator);
                } else {
                    return;
                }
            } else if (i10 == list.size()) {
                childEventingList.removeWithEvent(i10);
            } else {
                Object obj = childEventingList.get(i10);
                Object obj2 = list.get(i10);
                if (obj != obj2) {
                    int indexOf = childEventingList.indexOf(obj2);
                    if (indexOf == -1) {
                        childEventingList.addWithEvent(i10, obj2, accumulator);
                    } else {
                        childEventingList.removeWithEvent(indexOf);
                        childEventingList.addWithEvent(i10, obj2, accumulator);
                    }
                }
            }
            i10++;
        }
    }

    /* access modifiers changed from: private */
    public void updateTree() {
        String str;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ShadowDocument.Update createShadowDocumentUpdate = createShadowDocumentUpdate();
        boolean isEmpty = createShadowDocumentUpdate.isEmpty();
        if (isEmpty) {
            createShadowDocumentUpdate.abandon();
        } else {
            applyDocumentUpdate(createShadowDocumentUpdate);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        Object[] objArr = new Object[2];
        objArr[0] = Long.toString(elapsedRealtime2);
        if (isEmpty) {
            str = " (no changes)";
        } else {
            str = "";
        }
        objArr[1] = str;
        LogUtil.d("Document.updateTree() completed in %s ms%s", objArr);
    }

    public synchronized void addRef() {
        int i10 = this.mReferenceCounter;
        this.mReferenceCounter = i10 + 1;
        if (i10 == 0) {
            init();
        }
    }

    public void addUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.add(updateListener);
    }

    public void findMatchingElements(String str, Accumulator<Integer> accumulator) {
        verifyThreadAccess();
        findMatches(this.mDocumentProvider.getRootElement(), Pattern.compile(Pattern.quote(str), 2), accumulator);
    }

    public DocumentView getDocumentView() {
        verifyThreadAccess();
        return this.mShadowDocument;
    }

    public void getElementComputedStyles(Object obj, ComputedStyleAccumulator computedStyleAccumulator) {
        getNodeDescriptor(obj).getComputedStyles(obj, computedStyleAccumulator);
    }

    public Object getElementForNodeId(int i10) {
        return this.mObjectIdMapper.getObjectForId(i10);
    }

    public void getElementStyleRuleNames(Object obj, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        getNodeDescriptor(obj).getStyleRuleNames(obj, styleRuleNameAccumulator);
    }

    public void getElementStyles(Object obj, String str, StyleAccumulator styleAccumulator) {
        getNodeDescriptor(obj).getStyles(obj, str, styleAccumulator);
    }

    public NodeDescriptor getNodeDescriptor(Object obj) {
        verifyThreadAccess();
        return this.mDocumentProvider.getNodeDescriptor(obj);
    }

    public Integer getNodeIdForElement(Object obj) {
        return this.mObjectIdMapper.getIdForObject(obj);
    }

    public Object getRootElement() {
        verifyThreadAccess();
        Object rootElement = this.mDocumentProvider.getRootElement();
        if (rootElement == null) {
            throw new IllegalStateException();
        } else if (rootElement == this.mShadowDocument.getRootElement()) {
            return rootElement;
        } else {
            throw new IllegalStateException();
        }
    }

    public void hideHighlight() {
        verifyThreadAccess();
        this.mDocumentProvider.hideHighlight();
    }

    public void highlightElement(Object obj, int i10) {
        verifyThreadAccess();
        this.mDocumentProvider.highlightElement(obj, i10);
    }

    public synchronized void release() {
        int i10 = this.mReferenceCounter;
        if (i10 > 0) {
            int i11 = i10 - 1;
            this.mReferenceCounter = i11;
            if (i11 == 0) {
                cleanUp();
            }
        }
    }

    public void removeUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.remove(updateListener);
    }

    public void setAttributesAsText(Object obj, String str) {
        verifyThreadAccess();
        this.mDocumentProvider.setAttributesAsText(obj, str);
    }

    public void setElementStyle(Object obj, String str, String str2, String str3) {
        getNodeDescriptor(obj).setStyle(obj, str, str2, str3);
    }

    public void setInspectModeEnabled(boolean z10) {
        verifyThreadAccess();
        this.mDocumentProvider.setInspectModeEnabled(z10);
    }
}
