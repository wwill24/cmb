package w5;

import android.util.Pair;
import b6.s;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.utils.model.Optional;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.List;
import oc.c;
import qj.q;
import w5.k;
import y5.a;
import y5.b;

class h extends s<k, l> implements k.a {

    /* renamed from: f  reason: collision with root package name */
    a f18254f;

    /* renamed from: g  reason: collision with root package name */
    b f18255g;

    /* renamed from: h  reason: collision with root package name */
    x5.a f18256h;

    /* renamed from: j  reason: collision with root package name */
    s9.a f18257j;

    /* renamed from: k  reason: collision with root package name */
    ProfileRepositoryV2 f18258k;

    /* renamed from: l  reason: collision with root package name */
    UserRepository f18259l;

    h() {
    }

    private qj.h<Optional<Pair<String, Boolean>>> M1() {
        if (this.f18257j.a("ProfileBottomNav.Enabled.Android")) {
            return this.f18259l.p().v().M(new e(this));
        }
        return qj.h.X(Optional.a());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Optional N1(ja.b bVar, kotlin.Pair pair) throws Exception {
        String str;
        List list = (List) pair.d();
        if (list.isEmpty()) {
            str = null;
        } else {
            str = ((Photo) list.get(0)).getUrl();
        }
        return Optional.e(new Pair(str, Boolean.valueOf(bVar.l())));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ rn.a O1(ja.b bVar) throws Exception {
        return this.f18258k.l(bVar.u()).Y(new g(bVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Q1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P1(com.coffeemeetsbagel.utils.model.Optional<java.lang.Integer> r4, com.coffeemeetsbagel.utils.model.Optional<android.util.Pair<java.lang.String, java.lang.Boolean>> r5) {
        /*
            r3 = this;
            boolean r0 = r4.d()
            r1 = 0
            if (r0 == 0) goto L_0x0026
            P r0 = r3.f7875e
            w5.k r0 = (w5.k) r0
            java.lang.Object r4 = r4.c()
            java.lang.Integer r4 = (java.lang.Integer) r4
            boolean r2 = r5.d()
            if (r2 == 0) goto L_0x0022
            java.lang.Object r5 = r5.c()
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r5 = r5.first
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x0022:
            r0.m(r4, r1)
            goto L_0x003e
        L_0x0026:
            P r4 = r3.f7875e
            w5.k r4 = (w5.k) r4
            boolean r0 = r5.d()
            if (r0 == 0) goto L_0x003b
            java.lang.Object r5 = r5.c()
            android.util.Pair r5 = (android.util.Pair) r5
            java.lang.Object r5 = r5.first
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x003b:
            r4.k(r1)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.h.P1(com.coffeemeetsbagel.utils.model.Optional, com.coffeemeetsbagel.utils.model.Optional):void");
    }

    /* access modifiers changed from: private */
    public void R1(List<x5.b> list, Optional<Pair<String, Boolean>> optional) {
        String str;
        Boolean bool;
        if (optional.d()) {
            str = (String) optional.c().first;
        } else {
            str = null;
        }
        if (optional.d()) {
            bool = (Boolean) optional.c().second;
        } else {
            bool = null;
        }
        if (this.f18257j.a("ProfileBottomNav.Enabled.Android")) {
            ((k) this.f7875e).n(list, str, Boolean.TRUE, bool);
        } else {
            ((k) this.f7875e).n(list, (String) null, Boolean.FALSE, (Boolean) null);
        }
        ((t) this.f18255g.a().C().g(com.uber.autodispose.a.a(this))).c(new f(this, optional));
    }

    public void I(int i10) {
        this.f18254f.b(Integer.valueOf(i10));
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((p) q.m(this.f18256h.a(), M1().t0().s(), new c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(oc.b.b(new c(this)));
        ((p) q.m(this.f18255g.a().s(), M1().t0().s(), new c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(oc.b.b(new d(this)));
    }
}
