package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

public final class g extends j implements Iterable<j> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<j> f21308a = new ArrayList<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof g) && ((g) obj).f21308a.equals(this.f21308a));
    }

    public int hashCode() {
        return this.f21308a.hashCode();
    }

    public Iterator<j> iterator() {
        return this.f21308a.iterator();
    }

    public void n(j jVar) {
        if (jVar == null) {
            jVar = k.f21376a;
        }
        this.f21308a.add(jVar);
    }
}
