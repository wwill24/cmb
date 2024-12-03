package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

public class KeyIndex extends Index {
    private static final KeyIndex INSTANCE = new KeyIndex();

    private KeyIndex() {
    }

    public static KeyIndex getInstance() {
        return INSTANCE;
    }

    public boolean equals(Object obj) {
        return obj instanceof KeyIndex;
    }

    public String getQueryDefinition() {
        return ".key";
    }

    public int hashCode() {
        return 37;
    }

    public boolean isDefinedOn(Node node) {
        return true;
    }

    public NamedNode makePost(ChildKey childKey, Node node) {
        Utilities.hardAssert(node instanceof StringNode);
        return new NamedNode(ChildKey.fromString((String) node.getValue()), EmptyNode.Empty());
    }

    public NamedNode maxPost() {
        return NamedNode.getMaxNode();
    }

    public String toString() {
        return "KeyIndex";
    }

    public int compare(NamedNode namedNode, NamedNode namedNode2) {
        return namedNode.getName().compareTo(namedNode2.getName());
    }
}
