package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class a implements c {
    a() {
    }

    private d p(b bVar) {
        return (d) bVar.d();
    }

    public void a(b bVar, float f10) {
        p(bVar).h(f10);
    }

    public float b(b bVar) {
        return p(bVar).d();
    }

    public void c(b bVar, float f10) {
        bVar.f().setElevation(f10);
    }

    public float d(b bVar) {
        return p(bVar).c();
    }

    public ColorStateList e(b bVar) {
        return p(bVar).b();
    }

    public float f(b bVar) {
        return b(bVar) * 2.0f;
    }

    public void g(b bVar) {
        o(bVar, d(bVar));
    }

    public void h(b bVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        bVar.b(new d(colorStateList, f10));
        View f13 = bVar.f();
        f13.setClipToOutline(true);
        f13.setElevation(f11);
        o(bVar, f12);
    }

    public float i(b bVar) {
        return bVar.f().getElevation();
    }

    public void j(b bVar) {
        o(bVar, d(bVar));
    }

    public void k(b bVar) {
        if (!bVar.c()) {
            bVar.a(0, 0, 0, 0);
            return;
        }
        float d10 = d(bVar);
        float b10 = b(bVar);
        int ceil = (int) Math.ceil((double) e.a(d10, b10, bVar.e()));
        int ceil2 = (int) Math.ceil((double) e.b(d10, b10, bVar.e()));
        bVar.a(ceil, ceil2, ceil, ceil2);
    }

    public void l() {
    }

    public float m(b bVar) {
        return b(bVar) * 2.0f;
    }

    public void n(b bVar, ColorStateList colorStateList) {
        p(bVar).f(colorStateList);
    }

    public void o(b bVar, float f10) {
        p(bVar).g(f10, bVar.c(), bVar.e());
        k(bVar);
    }
}
