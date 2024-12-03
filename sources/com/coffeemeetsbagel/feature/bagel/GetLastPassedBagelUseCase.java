package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class GetLastPassedBagelUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final BagelRepository f12689a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ProfileRepositoryV2 f12690b;

    public GetLastPassedBagelUseCase(BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        j.g(bagelRepository, "bagelRepository");
        j.g(profileRepositoryV2, "profileRepository");
        this.f12689a = bagelRepository;
        this.f12690b = profileRepositoryV2;
    }

    /* access modifiers changed from: private */
    public static final b0 d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<Bagel> c() {
        w<R> v10 = this.f12689a.l().v(new t(new GetLastPassedBagelUseCase$invoke$1(this)));
        j.f(v10, "operator fun invoke(): S…       }\n\n        }\n    }");
        return v10;
    }
}
