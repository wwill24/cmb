package com.google.firebase.database.snapshot;

public final class NamedNode {
    private static final NamedNode MAX_NODE = new NamedNode(ChildKey.getMaxName(), Node.MAX_NODE);
    private static final NamedNode MIN_NODE = new NamedNode(ChildKey.getMinName(), EmptyNode.Empty());
    private final ChildKey name;
    private final Node node;

    public NamedNode(ChildKey childKey, Node node2) {
        this.name = childKey;
        this.node = node2;
    }

    public static NamedNode getMaxNode() {
        return MAX_NODE;
    }

    public static NamedNode getMinNode() {
        return MIN_NODE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NamedNode.class != obj.getClass()) {
            return false;
        }
        NamedNode namedNode = (NamedNode) obj;
        if (this.name.equals(namedNode.name) && this.node.equals(namedNode.node)) {
            return true;
        }
        return false;
    }

    public ChildKey getName() {
        return this.name;
    }

    public Node getNode() {
        return this.node;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.node.hashCode();
    }

    public String toString() {
        return "NamedNode{name=" + this.name + ", node=" + this.node + '}';
    }
}
