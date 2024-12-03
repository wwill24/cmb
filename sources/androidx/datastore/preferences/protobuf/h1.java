package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class h1 extends AbstractList<String> implements a0, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a0 f5286a;

    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f5287a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5288b;

        a(int i10) {
            this.f5288b = i10;
            this.f5287a = h1.this.f5286a.listIterator(i10);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public String next() {
            return this.f5287a.next();
        }

        /* renamed from: d */
        public String previous() {
            return this.f5287a.previous();
        }

        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.f5287a.hasNext();
        }

        public boolean hasPrevious() {
            return this.f5287a.hasPrevious();
        }

        public int nextIndex() {
            return this.f5287a.nextIndex();
        }

        public int previousIndex() {
            return this.f5287a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f5290a;

        b() {
            this.f5290a = h1.this.f5286a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f5290a.next();
        }

        public boolean hasNext() {
            return this.f5290a.hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public h1(a0 a0Var) {
        this.f5286a = a0Var;
    }

    public void b1(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public List<?> e() {
        return this.f5286a.e();
    }

    public Iterator<String> iterator() {
        return new b();
    }

    public a0 k() {
        return this;
    }

    public Object l(int i10) {
        return this.f5286a.l(i10);
    }

    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    public int size() {
        return this.f5286a.size();
    }

    public String get(int i10) {
        return (String) this.f5286a.get(i10);
    }
}
