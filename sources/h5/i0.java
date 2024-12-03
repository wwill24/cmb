package h5;

import com.coffeemeetsbagel.database.CmbDatabase;
import fj.d;
import fj.g;
import fk.a;
import u6.c;

public final class i0 implements d<c> {

    /* renamed from: a  reason: collision with root package name */
    private final a<CmbDatabase> f15360a;

    public i0(a<CmbDatabase> aVar) {
        this.f15360a = aVar;
    }

    public static c a(CmbDatabase cmbDatabase) {
        return (c) g.e(d0.f15347a.e(cmbDatabase));
    }

    public static i0 b(a<CmbDatabase> aVar) {
        return new i0(aVar);
    }

    /* renamed from: c */
    public c get() {
        return a(this.f15360a.get());
    }
}
