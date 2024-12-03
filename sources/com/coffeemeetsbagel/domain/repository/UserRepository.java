package com.coffeemeetsbagel.domain.repository;

import android.os.Looper;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import ja.b;
import ja.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import ma.g;
import okhttp3.v;
import okhttp3.z;
import qj.b0;
import qj.f;
import qj.h;
import qj.w;
import s9.a;
import u6.q;
import za.d;

public final class UserRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final g f12461a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final q f12462b;

    /* renamed from: c  reason: collision with root package name */
    private final d f12463c;

    /* renamed from: d  reason: collision with root package name */
    private final a f12464d;

    public UserRepository(g gVar, q qVar, d dVar, a aVar) {
        j.g(gVar, "network");
        j.g(qVar, "userDao");
        j.g(dVar, "questionDao");
        j.g(aVar, "featureManager");
        this.f12461a = gVar;
        this.f12462b = qVar;
        this.f12463c = dVar;
        this.f12464d = aVar;
    }

    /* access modifiers changed from: private */
    public static final b0 A(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f C(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final String n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final h<b> r(b bVar) {
        if (this.f12464d.a("ProfileMigration.Enabled.Android")) {
            h<R> Y = this.f12463c.a(ProfileQuestion.UNITS.getApiKey(), bVar.u()).Y(new y2(new UserRepository$mapUnitQuestion$1(bVar)));
            j.f(Y, "user: User): Flowable<Us…              }\n        }");
            return Y;
        }
        h<b> X = h.X(bVar);
        j.f(X, "{\n            // If the …able.just(user)\n        }");
        return X;
    }

    /* access modifiers changed from: private */
    public static final b s(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 u(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Integer w(UserRepository userRepository, NetworkProfile networkProfile) {
        j.g(userRepository, "this$0");
        j.g(networkProfile, "$profile");
        return Integer.valueOf(userRepository.f12462b.c(w6.a.d(networkProfile)));
    }

    /* access modifiers changed from: private */
    public static final b0 y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final qj.a B(String str) {
        boolean z10;
        j.g(str, "skus");
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            qj.a m10 = qj.a.m();
            j.f(m10, "complete()");
            return m10;
        }
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updatePurchasedSubscriptionSkus(str);
        z d10 = z.d(v.g("application/json"), modelProfileUpdateDelta.flush());
        g gVar = this.f12461a;
        j.f(d10, "requestBody");
        qj.a F = gVar.b(d10).w(new v2(UserRepository$updatePurchasedSkus$1.f12466a)).F(dk.a.c());
        j.f(F, "network.updateProfile(re…scribeOn(Schedulers.io())");
        return F;
    }

    public final String l() {
        if (!Looper.getMainLooper().equals(Looper.myLooper())) {
            c a10 = this.f12462b.a();
            if (a10 != null) {
                return a10.s();
            }
            return null;
        }
        throw new Exception("Don't do this on the UI thread.");
    }

    public final h<String> m() {
        h<R> Y = this.f12462b.getUser().o0(dk.a.c()).v().Y(new w2(UserRepository$getCurrentUserId$1.f12465a));
        j.f(Y, "userDao.getUser()\n      …    .map { it.profileId }");
        return Y;
    }

    public final w<b> o() {
        w<b> L = p().L();
        j.f(L, "getUser().firstOrError()");
        return L;
    }

    public final h<b> p() {
        h<R> v10 = this.f12462b.getUser().M(new x2(new UserRepository$getUser$1(this))).o0(dk.a.c()).v();
        j.f(v10, "fun getUser(): Flowable<…tinctUntilChanged()\n    }");
        return v10;
    }

    public final w<NetworkProfile> t() {
        w<R> v10 = this.f12461a.getProfile().K(dk.a.c()).v(new a3(new UserRepository$refreshMyProfile$1(this)));
        j.f(v10, "fun refreshMyProfile() :…ile }\n            }\n    }");
        return v10;
    }

    public final w<Integer> v(NetworkProfile networkProfile) {
        j.g(networkProfile, "profile");
        w<Integer> K = w.A(new b3(this, networkProfile)).K(dk.a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Integer> x(ModelProfileUpdateDelta modelProfileUpdateDelta, NetworkProfile networkProfile) {
        j.g(modelProfileUpdateDelta, "delta");
        j.g(networkProfile, "changedProfile");
        c d10 = w6.a.d(networkProfile);
        z d11 = z.d(v.g("application/json"), modelProfileUpdateDelta.flush());
        g gVar = this.f12461a;
        j.f(d11, "requestBody");
        w<R> v10 = gVar.b(d11).K(dk.a.c()).v(new z2(new UserRepository$update$1(this, d10)));
        j.f(v10, "fun update(delta: ModelP…   }\n            }\n\n    }");
        return v10;
    }

    public final w<Integer> z(String str) {
        w<R> v10 = o().v(new u2(new UserRepository$updateAppsFlyerId$1(str, this)));
        j.f(v10, "fun updateAppsFlyerId(ap…    }\n            }\n    }");
        return v10;
    }
}
