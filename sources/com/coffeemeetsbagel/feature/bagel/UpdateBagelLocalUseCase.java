package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import y6.a;

public final class UpdateBagelLocalUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f12691a;

    /* renamed from: b  reason: collision with root package name */
    private final BagelRepository f12692b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ProfileRepositoryV2 f12693c;

    public UpdateBagelLocalUseCase(a aVar, BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        j.g(aVar, "activityReportManager");
        j.g(bagelRepository, "repository");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        this.f12691a = aVar;
        this.f12692b = bagelRepository;
        this.f12693c = profileRepositoryV2;
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<Bagel> e(Bagel bagel) {
        j.g(bagel, Extra.BAGEL);
        w<R> v10 = this.f12692b.q(bagel).v(new w(new UpdateBagelLocalUseCase$invoke$1(this, bagel))).v(new x(new UpdateBagelLocalUseCase$invoke$2(bagel, this)));
        j.f(v10, "operator fun invoke(bage…    }\n            }\n    }");
        return v10;
    }
}
