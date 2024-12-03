package org.commonmark.internal;

import am.o;
import am.t;
import cm.c;
import cm.h;
import java.util.List;

public class a extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final t f24094a = new t();

    /* renamed from: b  reason: collision with root package name */
    private LinkReferenceDefinitionParser f24095b = new LinkReferenceDefinitionParser();

    public c c(h hVar) {
        if (!hVar.a()) {
            return c.b(hVar.getIndex());
        }
        return c.d();
    }

    public boolean d() {
        return true;
    }

    public am.a e() {
        return this.f24094a;
    }

    public void f(CharSequence charSequence) {
        this.f24095b.f(charSequence);
    }

    public void g() {
        if (this.f24095b.d().length() == 0) {
            this.f24094a.l();
        }
    }

    public void h(bm.a aVar) {
        CharSequence d10 = this.f24095b.d();
        if (d10.length() > 0) {
            aVar.a(d10.toString(), this.f24094a);
        }
    }

    public CharSequence i() {
        return this.f24095b.d();
    }

    public List<o> j() {
        return this.f24095b.c();
    }
}
