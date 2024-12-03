package com.coffeemeetsbagel.new_user_experience.gender;

import b6.s;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.new_user_experience.gender.GenderPresenter;
import com.coffeemeetsbagel.profile.r0;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.j;
import com.uber.autodispose.m;
import com.uber.autodispose.t;
import d7.g;
import gk.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import na.b;
import qj.f;
import qj.w;

public final class GenderInteractor extends s<GenderPresenter, s> implements GenderPresenter.a {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f34981f = "GenderInteractor";

    /* renamed from: g  reason: collision with root package name */
    public b f34982g;

    /* renamed from: h  reason: collision with root package name */
    public g f34983h;

    /* renamed from: j  reason: collision with root package name */
    public j f34984j;

    /* renamed from: k  reason: collision with root package name */
    public SaveAnswerUseCase f34985k;

    /* renamed from: l  reason: collision with root package name */
    public ProfileManager f34986l;

    /* renamed from: m  reason: collision with root package name */
    public r0 f34987m;

    /* renamed from: n  reason: collision with root package name */
    public s9.a f34988n;

    /* renamed from: p  reason: collision with root package name */
    private GenderType f34989p = GenderType.UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public String f34990q = "";
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public QuestionWAnswers f34991t;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34992a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.models.entities.GenderType[] r0 = com.coffeemeetsbagel.models.entities.GenderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.MALE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.entities.GenderType r1 = com.coffeemeetsbagel.models.entities.GenderType.FEMALE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f34992a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.gender.GenderInteractor.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void U1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void V1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final f d2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e2(GenderInteractor genderInteractor) {
        String str;
        kotlin.jvm.internal.j.g(genderInteractor, "this$0");
        NetworkProfile j10 = genderInteractor.Z1().j();
        kotlin.jvm.internal.j.d(j10);
        int i10 = a.f34992a[genderInteractor.f34989p.ordinal()];
        if (i10 == 1 || i10 == 2) {
            str = genderInteractor.f34989p.getApiKey();
        } else {
            str = GenderType.UNSPECIFIED.getApiKey();
        }
        j10.setGender(str);
        genderInteractor.Y1().e(g0.f(h.a("selection", genderInteractor.f34989p.getApiKey())));
    }

    /* access modifiers changed from: private */
    public static final void f2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final w<Boolean> g2() {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateGender(this.f34989p.getApiKey());
        r0 c22 = c2();
        NetworkProfile j10 = Z1().j();
        kotlin.jvm.internal.j.d(j10);
        w<R> D = c22.a(modelProfileUpdateDelta, j10).D(new m(GenderInteractor$updateGenderOnProfile$1.f34993a));
        kotlin.jvm.internal.j.f(D, "updateMyProfileUseCase\n …          .map { it > 0 }");
        return D;
    }

    /* access modifiers changed from: private */
    public static final Boolean h2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    private final w<Boolean> i2(GenderType genderType) {
        j a22 = a2();
        String profileId = W1().getProfileId();
        kotlin.jvm.internal.j.f(profileId, "authenticationManager.profileId");
        w<Boolean> J = j.b(a22, profileId, QuestionGroupType.ONBOARDING, false, 4, (Object) null).Y(new k(GenderInteractor$updateInferredGenderQuestion$1.f34994a)).L().w(new l(new GenderInteractor$updateInferredGenderQuestion$2(genderType, this))).J(Boolean.TRUE);
        kotlin.jvm.internal.j.f(J, "private fun updateInferr…SingleDefault(true)\n    }");
        return J;
    }

    /* access modifiers changed from: private */
    public static final f j2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final QuestionWAnswers k2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return (QuestionWAnswers) function1.invoke(obj);
    }

    public final g W1() {
        g gVar = this.f34983h;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.j.y("authenticationManager");
        return null;
    }

    public final s9.a X1() {
        s9.a aVar = this.f34988n;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final b Y1() {
        b bVar = this.f34982g;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("interactionListener");
        return null;
    }

    public final ProfileManager Z1() {
        ProfileManager profileManager = this.f34986l;
        if (profileManager != null) {
            return profileManager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final j a2() {
        j jVar = this.f34984j;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("qnAUseCase");
        return null;
    }

    public final SaveAnswerUseCase b2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f34985k;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        kotlin.jvm.internal.j.y("saveAnswerUseCase");
        return null;
    }

    public final r0 c2() {
        r0 r0Var = this.f34987m;
        if (r0Var != null) {
            return r0Var;
        }
        kotlin.jvm.internal.j.y("updateMyProfileUseCase");
        return null;
    }

    public void d() {
        w<Boolean> wVar;
        if (this.f34991t != null) {
            int i10 = a.f34992a[this.f34989p.ordinal()];
            if (i10 != 1 && i10 != 2) {
                wVar = w.C(Boolean.TRUE);
            } else if (X1().a("ProfileMigration.Enabled.Android")) {
                wVar = i2(this.f34989p);
            } else {
                wVar = g2();
            }
            ((m) wVar.w(new h(new GenderInteractor$onNext$1(this))).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new i(this), new j(new GenderInteractor$onNext$3(this)));
            return;
        }
        Y1().onError(((GenderPresenter) this.f7875e).t());
    }

    public void f() {
        Y1().d();
    }

    public void o(GenderType genderType) {
        kotlin.jvm.internal.j.g(genderType, ProfileConstants.Field.GENDER);
        this.f34989p = genderType;
        QuestionWAnswers questionWAnswers = this.f34991t;
        if (questionWAnswers != null) {
            List<Option> options = questionWAnswers.e().getOptions();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = options.iterator();
            while (true) {
                boolean z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (GenderType.Companion.fromApiKey(((Option) next).getName()) != genderType) {
                    z10 = false;
                }
                if (z10) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                this.f34990q = ((Option) arrayList.get(0)).getId();
            }
        }
        ((GenderPresenter) this.f7875e).r();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        j a22 = a2();
        String profileId = W1().getProfileId();
        kotlin.jvm.internal.j.f(profileId, "authenticationManager.profileId");
        ((t) a22.a(profileId, QuestionGroupType.ONBOARDING, false).a0(sj.a.a()).L().g(com.uber.autodispose.a.a(this))).b(new f(new GenderInteractor$didBecomeActive$1(this)), new g(new GenderInteractor$didBecomeActive$2(this)));
    }
}
