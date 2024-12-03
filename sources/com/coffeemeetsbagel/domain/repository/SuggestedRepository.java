package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.match.l;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.suggested.models.SuggestedLimitsNetworkResponse;
import com.coffeemeetsbagel.utils.model.Optional;
import fa.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ma.k;
import qj.b0;
import qj.f;
import qj.h;
import qj.w;
import yb.c;

public final class SuggestedRepository {

    /* renamed from: i  reason: collision with root package name */
    public static final a f12450i = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final k f12451a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f12452b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final hb.c f12453c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ProfileRepositoryV2 f12454d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final PhotoRepository f12455e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final QuestionRepository f12456f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final l f12457g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f12458h = "SuggestedRepository";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SuggestedRepository(k kVar, c cVar, hb.c cVar2, ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository, l lVar) {
        j.g(kVar, "network");
        j.g(cVar, "limitsDao");
        j.g(cVar2, "sharedPrefsManager");
        j.g(profileRepositoryV2, "profileRepository");
        j.g(photoRepository, "photoRepository");
        j.g(questionRepository, "qnaRepo");
        j.g(lVar, "legacyMatchDb");
        this.f12451a = kVar;
        this.f12452b = cVar;
        this.f12453c = cVar2;
        this.f12454d = profileRepositoryV2;
        this.f12455e = photoRepository;
        this.f12456f = questionRepository;
        this.f12457g = lVar;
    }

    /* access modifiers changed from: private */
    public static final List A(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 B(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 C(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List D(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void E(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair G(SuggestedRepository suggestedRepository) {
        j.g(suggestedRepository, "this$0");
        return new Pair(Boolean.valueOf(suggestedRepository.f12453c.p("OUT_OF_BAGELS")), Long.valueOf(suggestedRepository.f12453c.t("LAST_REFILL_DATETIME")));
    }

    /* access modifiers changed from: private */
    public static final b0 H(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final qj.a I(long j10) {
        fa.a.f40771d.a(this.f12458h, "saveSuggestedLimitsFromNetwork()");
        qj.a w10 = this.f12451a.a().D(new a2(SuggestedRepository$saveSuggestedLimitsFromNetwork$1.f12460a)).r(new b2(new SuggestedRepository$saveSuggestedLimitsFromNetwork$2(this))).G(new c2()).w(new d2(new SuggestedRepository$saveSuggestedLimitsFromNetwork$4(j10, this)));
        j.f(w10, "private fun saveSuggeste…    }\n            }\n    }");
        return w10;
    }

    /* access modifiers changed from: private */
    public static final Pair J(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void K(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Pair L(Throwable th2) {
        j.g(th2, "it");
        return new Pair(new SuggestedLimitsNetworkResponse(5, 40, 20), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public static final f M(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Long O(SuggestedRepository suggestedRepository) {
        j.g(suggestedRepository, "this$0");
        return Long.valueOf(suggestedRepository.f12453c.t("last_fetch_suggested_limits_timestamps"));
    }

    /* access modifiers changed from: private */
    public static final f P(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<List<Bagel>> z(long j10) {
        fa.a.f40771d.a(this.f12458h, "refill()");
        w<R> D = this.f12451a.b(String.valueOf(j10)).K(dk.a.c()).r(new g2(new SuggestedRepository$refill$1(this, j10))).D(new h2(new SuggestedRepository$refill$2(this))).v(new i2(new SuggestedRepository$refill$3(this))).v(new j2(new SuggestedRepository$refill$4(this))).D(new k2(new SuggestedRepository$refill$5(this)));
        j.f(D, "private fun refill(times…agels\n            }\n    }");
        return D;
    }

    public final w<List<Bagel>> F(int i10, Optional<SuggestedLimitsEntity> optional) {
        Integer numBagelsRequiredForUpsell;
        j.g(optional, "limitsOptional");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12458h;
        aVar.a(str, "refillIfApplicable(): currentBagelListSize=" + i10);
        int i11 = 20;
        if (optional.d() && (numBagelsRequiredForUpsell = optional.c().getNumBagelsRequiredForUpsell()) != null) {
            i11 = numBagelsRequiredForUpsell.intValue();
        }
        if (i10 > i11 + 2) {
            w<List<Bagel>> C = w.C(q.j());
            j.f(C, "just(emptyList())");
            return C;
        }
        w<List<Bagel>> v10 = w.A(new z1(this)).K(dk.a.c()).v(new e2(new SuggestedRepository$refillIfApplicable$2(this, System.currentTimeMillis())));
        j.f(v10, "fun refillIfApplicable(\n…        }\n        }\n    }");
        return v10;
    }

    public final qj.a N() {
        qj.a w10 = w.A(new l2(this)).K(dk.a.c()).w(new m2(new SuggestedRepository$syncSuggestedLimitsFromNetwork$2(this)));
        j.f(w10, "fun syncSuggestedLimitsF…llis)\n            }\n    }");
        return w10;
    }

    public final w<Integer> Q(SuggestedLimitsEntity suggestedLimitsEntity) {
        j.g(suggestedLimitsEntity, "newLimits");
        fa.a.f40771d.a(this.f12458h, "updateLimits()");
        w<Integer> K = this.f12452b.f(suggestedLimitsEntity).K(dk.a.c());
        j.f(K, "limitsDao.updateLimits(n…scribeOn(Schedulers.io())");
        return K;
    }

    public final h<Optional<SuggestedLimitsEntity>> x() {
        h<R> M = this.f12452b.a().o0(dk.a.c()).M(new f2(SuggestedRepository$getSuggestedLimits$1.f12459a));
        j.f(M, "limitsDao\n            .g…          }\n            }");
        return M;
    }
}
