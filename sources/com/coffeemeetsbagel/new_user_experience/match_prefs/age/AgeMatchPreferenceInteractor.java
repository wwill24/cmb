package com.coffeemeetsbagel.new_user_experience.match_prefs.age;

import b6.s;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.uber.autodispose.m;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.f;
import s9.a;

public final class AgeMatchPreferenceInteractor extends s<k, l> {

    /* renamed from: f  reason: collision with root package name */
    public k f35158f;

    /* renamed from: g  reason: collision with root package name */
    public l f35159g;

    /* renamed from: h  reason: collision with root package name */
    public LoadAgePreferenceUseCase f35160h;

    /* renamed from: j  reason: collision with root package name */
    public SaveAgePreferenceUseCase f35161j;

    /* renamed from: k  reason: collision with root package name */
    public a f35162k;

    /* access modifiers changed from: private */
    public static final void L1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void M1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f N1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    public final k O1() {
        k kVar = this.f35158f;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l P1() {
        l lVar = this.f35159g;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final a Q1() {
        a aVar = this.f35162k;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final LoadAgePreferenceUseCase R1() {
        LoadAgePreferenceUseCase loadAgePreferenceUseCase = this.f35160h;
        if (loadAgePreferenceUseCase != null) {
            return loadAgePreferenceUseCase;
        }
        j.y("loadAgePreferenceUseCase");
        return null;
    }

    public final SaveAgePreferenceUseCase S1() {
        SaveAgePreferenceUseCase saveAgePreferenceUseCase = this.f35161j;
        if (saveAgePreferenceUseCase != null) {
            return saveAgePreferenceUseCase;
        }
        j.y("saveAgePreferenceUseCase");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        DealbreakerVariant dealbreakerVariant;
        super.y1();
        if (Q1().a("DealbreakersV2.VariantA.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_A;
        } else if (Q1().a("DealbreakersV2.VariantB.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_B;
        } else {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        ((t) R1().t().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new c(new AgeMatchPreferenceInteractor$didBecomeActive$1(this, dealbreakerVariant)));
        ((p) ((k) this.f7875e).n().g(com.uber.autodispose.a.a(this))).c(new d(new AgeMatchPreferenceInteractor$didBecomeActive$2(this)));
        ((m) P1().a().p0(1, TimeUnit.SECONDS).H(new e(new AgeMatchPreferenceInteractor$didBecomeActive$3(this))).j(com.uber.autodispose.a.a(this))).d();
    }
}
