package com.google.firebase.database;

import androidx.annotation.NonNull;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MutableData {
    /* access modifiers changed from: private */
    public final SnapshotHolder holder;
    /* access modifiers changed from: private */
    public final Path prefixPath;

    @NonNull
    public MutableData child(@NonNull String str) {
        Validation.validatePathString(str);
        return new MutableData(this.holder, this.prefixPath.child(new Path(str)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableData) {
            MutableData mutableData = (MutableData) obj;
            if (!this.holder.equals(mutableData.holder) || !this.prefixPath.equals(mutableData.prefixPath)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @NonNull
    public Iterable<MutableData> getChildren() {
        Node node = getNode();
        if (node.isEmpty() || node.isLeafNode()) {
            return new Iterable<MutableData>() {
                public Iterator<MutableData> iterator() {
                    return new Iterator<MutableData>() {
                        public boolean hasNext() {
                            return false;
                        }

                        public void remove() {
                            throw new UnsupportedOperationException("remove called on immutable collection");
                        }

                        @NonNull
                        public MutableData next() {
                            throw new NoSuchElementException();
                        }
                    };
                }
            };
        }
        final Iterator<NamedNode> it = IndexedNode.from(node).iterator();
        return new Iterable<MutableData>() {
            public Iterator<MutableData> iterator() {
                return new Iterator<MutableData>() {
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException("remove called on immutable collection");
                    }

                    @NonNull
                    public MutableData next() {
                        return new MutableData(MutableData.this.holder, MutableData.this.prefixPath.child(((NamedNode) it.next()).getName()));
                    }
                };
            }
        };
    }

    public long getChildrenCount() {
        return (long) getNode().getChildCount();
    }

    public String getKey() {
        if (this.prefixPath.getBack() != null) {
            return this.prefixPath.getBack().asString();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public Object getValue() {
        return getNode().getValue();
    }

    public boolean hasChild(@NonNull String str) {
        return !getNode().getChild(new Path(str)).isEmpty();
    }

    public boolean hasChildren() {
        Node node = getNode();
        if (node.isLeafNode() || node.isEmpty()) {
            return false;
        }
        return true;
    }

    public void setPriority(Object obj) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, obj)));
    }

    public void setValue(Object obj) throws DatabaseException {
        ValidationPath.validateWithObject(this.prefixPath, obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(convertToPlainJavaTypes));
    }

    public String toString() {
        String str;
        ChildKey front = this.prefixPath.getFront();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("MutableData { key = ");
        if (front != null) {
            str = front.asString();
        } else {
            str = "<none>";
        }
        sb2.append(str);
        sb2.append(", value = ");
        sb2.append(this.holder.getRootNode().getValue(true));
        sb2.append(" }");
        return sb2.toString();
    }

    MutableData(Node node) {
        this(new SnapshotHolder(node), new Path(""));
    }

    public <T> T getValue(@NonNull Class<T> cls) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), cls);
    }

    private MutableData(SnapshotHolder snapshotHolder, Path path) {
        this.holder = snapshotHolder;
        this.prefixPath = path;
        ValidationPath.validateWithObject(path, getValue());
    }

    public <T> T getValue(@NonNull GenericTypeIndicator<T> genericTypeIndicator) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), genericTypeIndicator);
    }
}
