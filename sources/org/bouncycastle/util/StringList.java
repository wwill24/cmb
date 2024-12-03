package org.bouncycastle.util;

public interface StringList extends Iterable<String> {
    boolean add(String str);

    String get(int i10);

    int size();

    String[] toStringArray();

    String[] toStringArray(int i10, int i11);
}
