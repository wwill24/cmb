package com.coffeemeetsbagel.new_user_experience.match_prefs.distance;

import b6.s;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.new_user_experience.match_prefs.answerable_question.DealbreakerVariant;
import com.coffeemeetsbagel.new_user_experience.match_prefs.k;
import com.coffeemeetsbagel.new_user_experience.match_prefs.l;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import s9.a;

public final class DistanceMatchPreferenceInteractor extends s<s, t> {

    /* renamed from: f  reason: collision with root package name */
    public ProfileManager f35288f;

    /* renamed from: g  reason: collision with root package name */
    public k f35289g;

    /* renamed from: h  reason: collision with root package name */
    public l f35290h;

    /* renamed from: j  reason: collision with root package name */
    public i f35291j;

    /* renamed from: k  reason: collision with root package name */
    public a f35292k;

    /* renamed from: l  reason: collision with root package name */
    public UserRepository f35293l;

    /* renamed from: m  reason: collision with root package name */
    public SaveAnswerUseCase f35294m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final String f35295n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Question f35296p;

    public DistanceMatchPreferenceInteractor() {
        String simpleName = DistanceMatchPreferenceInteractor.class.getSimpleName();
        j.f(simpleName, "DistanceMatchPreferenceI…or::class.java.simpleName");
        this.f35295n = simpleName;
    }

    /* access modifiers changed from: private */
    public static final void V1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 W1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X1(DistanceMatchPreferenceInteractor distanceMatchPreferenceInteractor, Object obj) {
        j.g(distanceMatchPreferenceInteractor, "this$0");
        distanceMatchPreferenceInteractor.f2().onSuccess("distance");
    }

    /* access modifiers changed from: private */
    public static final void Y1(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void Z1() {
        ((t) l2().p().L().g(com.uber.autodispose.a.a(this))).b(new l(new DistanceMatchPreferenceInteractor$displayProfileDistance$1(this)), new m(new DistanceMatchPreferenceInteractor$displayProfileDistance$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void a2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void b2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void c2() {
        DealbreakerVariant dealbreakerVariant;
        if (h2().a("DealbreakersV2.VariantA.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_A;
        } else if (h2().a("DealbreakersV2.VariantB.Android")) {
            dealbreakerVariant = DealbreakerVariant.VARIANT_B;
        } else {
            dealbreakerVariant = DealbreakerVariant.DISABLED;
        }
        ((n) l2().p().M(new j(new DistanceMatchPreferenceInteractor$displayQuestionDistance$1(this))).o0(dk.a.c()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new k(new DistanceMatchPreferenceInteractor$displayQuestionDistance$2(this, dealbreakerVariant)));
    }

    /* access modifiers changed from: private */
    public static final rn.a d2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<Unit> m2() {
        w<R> v10 = l2().p().L().v(new n(new DistanceMatchPreferenceInteractor$updateProfileService$1(this)));
        j.f(v10, "private fun updateProfil…    }\n            }\n    }");
        return v10;
    }

    /* access modifiers changed from: private */
    public static final b0 n2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final w<Integer> o2(int i10) {
        SaveAnswerUseCase k22 = k2();
        Question question = this.f35296p;
        j.d(question);
        String questionGroupApiString = question.getGroup().getQuestionGroupApiString();
        Question question2 = this.f35296p;
        j.d(question2);
        w<Integer> J = SaveAnswerUseCase.d(k22, (List) null, (String) null, question2.getId(), questionGroupApiString, Integer.valueOf(i10), (Float) null, (Float) null, (Float) null, ((s) this.f7875e).k(), (Location) null, 739, (Object) null).J(Integer.valueOf(i10));
        j.f(J, "saveAnswerUseCase.invoke…toSingleDefault(distance)");
        return J;
    }

    public final k f2() {
        k kVar = this.f35289g;
        if (kVar != null) {
            return kVar;
        }
        j.y("dataListener");
        return null;
    }

    public final l g2() {
        l lVar = this.f35290h;
        if (lVar != null) {
            return lVar;
        }
        j.y("dataStream");
        return null;
    }

    public final a h2() {
        a aVar = this.f35292k;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final i i2() {
        i iVar = this.f35291j;
        if (iVar != null) {
            return iVar;
        }
        j.y("getQuestionUseCase");
        return null;
    }

    public final ProfileManager j2() {
        ProfileManager profileManager = this.f35288f;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("profileManager");
        return null;
    }

    public final SaveAnswerUseCase k2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f35294m;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final UserRepository l2() {
        UserRepository userRepository = this.f35293l;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        if (h2().a("ProfileMigration.Enabled.Android")) {
            c2();
        } else {
            Z1();
        }
        ((p) ((s) this.f7875e).n().g(com.uber.autodispose.a.a(this))).c(new f(new DistanceMatchPreferenceInteractor$didBecomeActive$1(this)));
        ((p) g2().a().K(new g(new DistanceMatchPreferenceInteractor$didBecomeActive$2(this))).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h(this), new i(new DistanceMatchPreferenceInteractor$didBecomeActive$4(this)));
    }
}
