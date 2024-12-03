package xl;

import am.w;
import dm.a;
import dm.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class q implements a {

    /* renamed from: a  reason: collision with root package name */
    private final char f24778a;

    /* renamed from: b  reason: collision with root package name */
    private int f24779b = 0;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList<a> f24780c = new LinkedList<>();

    q(char c10) {
        this.f24778a = c10;
    }

    private a g(int i10) {
        Iterator<a> it = this.f24780c.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.c() <= i10) {
                return next;
            }
        }
        return this.f24780c.getFirst();
    }

    public int a(b bVar, b bVar2) {
        return g(bVar.length()).a(bVar, bVar2);
    }

    public char b() {
        return this.f24778a;
    }

    public int c() {
        return this.f24779b;
    }

    public char d() {
        return this.f24778a;
    }

    public void e(w wVar, w wVar2, int i10) {
        g(i10).e(wVar, wVar2, i10);
    }

    /* access modifiers changed from: package-private */
    public void f(a aVar) {
        boolean z10;
        int c10;
        int c11 = aVar.c();
        ListIterator<a> listIterator = this.f24780c.listIterator();
        do {
            if (listIterator.hasNext()) {
                c10 = listIterator.next().c();
                if (c11 > c10) {
                    listIterator.previous();
                    listIterator.add(aVar);
                    z10 = true;
                }
            } else {
                z10 = false;
            }
            if (!z10) {
                this.f24780c.add(aVar);
                this.f24779b = c11;
                return;
            }
            return;
        } while (c11 != c10);
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.f24778a + "' and minimum length " + c11);
    }
}
