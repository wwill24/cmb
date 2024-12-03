package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class i1 extends AbstractList<String> implements b0, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b0 f20823a;

    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f20824a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f20825b;

        a(int i10) {
            this.f20825b = i10;
            this.f20824a = i1.this.f20823a.listIterator(i10);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String next() {
            return this.f20824a.next();
        }

        /* renamed from: d */
        public String previous() {
            return this.f20824a.previous();
        }

        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f20824a.hasNext();
        }

        public boolean hasPrevious() {
            return this.f20824a.hasPrevious();
        }

        public int nextIndex() {
            return this.f20824a.nextIndex();
        }

        public int previousIndex() {
            return this.f20824a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f20827a;

        b() {
            this.f20827a = i1.this.f20823a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f20827a.next();
        }

        public boolean hasNext() {
            return this.f20827a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public i1(b0 b0Var) {
        this.f20823a = b0Var;
    }

    public void F1(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public List<?> e() {
        return this.f20823a.e();
    }

    public Iterator<String> iterator() {
        return new b();
    }

    public b0 k() {
        return this;
    }

    public Object l(int i10) {
        return this.f20823a.l(i10);
    }

    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    public int size() {
        return this.f20823a.size();
    }

    public String get(int i10) {
        return (String) this.f20823a.get(i10);
    }
}
