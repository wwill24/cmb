package com.coffeemeetsbagel.suggested_history;

import com.coffeemeetsbagel.match.BagelRepository;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class GetHistoryBagelUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final BagelRepository f37105a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ProfileRepositoryV2 f37106b;

    public GetHistoryBagelUseCase(BagelRepository bagelRepository, ProfileRepositoryV2 profileRepositoryV2) {
        j.g(bagelRepository, "bagelRepository");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        this.f37105a = bagelRepository;
        this.f37106b = profileRepositoryV2;
    }

    /* access modifiers changed from: private */
    public static final b0 d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<List<Bagel>> c() {
        w<R> v10 = this.f37105a.n().v(new g(new GetHistoryBagelUseCase$invoke$1(this)));
        j.f(v10, "operator fun invoke(): S…    }\n            }\n    }");
        return v10;
    }
}
