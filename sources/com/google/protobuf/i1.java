package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class i1 extends AbstractList<String> implements b0, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b0 f21864a;

    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f21865a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f21866b;

        a(int i10) {
            this.f21866b = i10;
            this.f21865a = i1.this.f21864a.listIterator(i10);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String next() {
            return this.f21865a.next();
        }

        /* renamed from: d */
        public String previous() {
            return this.f21865a.previous();
        }

        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f21865a.hasNext();
        }

        public boolean hasPrevious() {
            return this.f21865a.hasPrevious();
        }

        public int nextIndex() {
            return this.f21865a.nextIndex();
        }

        public int previousIndex() {
            return this.f21865a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f21868a;

        b() {
            this.f21868a = i1.this.f21864a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f21868a.next();
        }

        public boolean hasNext() {
            return this.f21868a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public i1(b0 b0Var) {
        this.f21864a = b0Var;
    }

    public void I(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public List<?> e() {
        return this.f21864a.e();
    }

    public Iterator<String> iterator() {
        return new b();
    }

    public b0 k() {
        return this;
    }

    public Object l(int i10) {
        return this.f21864a.l(i10);
    }

    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    public int size() {
        return this.f21864a.size();
    }

    public String get(int i10) {
        return (String) this.f21864a.get(i10);
    }
}
