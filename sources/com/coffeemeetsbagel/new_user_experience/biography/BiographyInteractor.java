package com.coffeemeetsbagel.new_user_experience.biography;

import b6.s;
import com.coffeemeetsbagel.bakery.m1;
import com.coffeemeetsbagel.dialogs.k0;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig;
import com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.coffeemeetsbagel.utils.model.Optional;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.t;
import d7.g;
import fa.a;
import gk.h;
import j5.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import pa.c;
import qj.b0;
import qj.w;

public final class BiographyInteractor extends s<BiographyPresenter, y0> implements BiographyPresenter.a {
    private BiographyNavigationConfig B;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f34810f = "BiographyInteractor";

    /* renamed from: g  reason: collision with root package name */
    public s9.a f34811g;

    /* renamed from: h  reason: collision with root package name */
    public ProfileRepository f34812h;

    /* renamed from: j  reason: collision with root package name */
    public na.b f34813j;

    /* renamed from: k  reason: collision with root package name */
    public g f34814k;

    /* renamed from: l  reason: collision with root package name */
    public ProfileManager f34815l;

    /* renamed from: m  reason: collision with root package name */
    public a7.a f34816m;

    /* renamed from: n  reason: collision with root package name */
    public m1 f34817n;

    /* renamed from: p  reason: collision with root package name */
    public c9.a f34818p;

    /* renamed from: q  reason: collision with root package name */
    public GetSingleSchoolsUseCase f34819q;

    /* renamed from: t  reason: collision with root package name */
    public SaveAnswerUseCase f34820t;

    /* renamed from: w  reason: collision with root package name */
    public QuestionRepository f34821w;

    /* renamed from: x  reason: collision with root package name */
    public UserRepository f34822x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public ProfileDtoImplementation f34823y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public final HashMap<String, String> f34824z = new HashMap<>();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34825a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34826b;

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0057 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005f */
        static {
            /*
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages[] r0 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r2 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.HEADER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r3 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.HEIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r4 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.ETHNICITY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r4 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.RELIGION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r4 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.JOB_TITLE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r4 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.DEGREE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r5 = 6
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig$Pages r4 = com.coffeemeetsbagel.new_user_experience.biography.BiographyNavigationConfig.Pages.SCHOOL     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r5 = 7
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                f34825a = r0
                com.coffeemeetsbagel.models.enums.ProfileQuestion[] r0 = com.coffeemeetsbagel.models.enums.ProfileQuestion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.ProfileQuestion r4 = com.coffeemeetsbagel.models.enums.ProfileQuestion.DEGREE_ONE     // Catch:{ NoSuchFieldError -> 0x0057 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                com.coffeemeetsbagel.models.enums.ProfileQuestion r1 = com.coffeemeetsbagel.models.enums.ProfileQuestion.SCHOOL_ONE     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.coffeemeetsbagel.models.enums.ProfileQuestion r1 = com.coffeemeetsbagel.models.enums.ProfileQuestion.UNITS     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                f34826b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor.a.<clinit>():void");
        }
    }

    public static final class b implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BiographyInteractor f34827a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HashMap<String, String> f34828b;

        b(BiographyInteractor biographyInteractor, HashMap<String, String> hashMap) {
            this.f34827a = biographyInteractor;
            this.f34828b = hashMap;
        }

        public void a() {
            String format2 = String.format("Personal Info Skip Prompt - %s", Arrays.copyOf(new Object[]{"Skip Button Tapped"}, 1));
            j.f(format2, "format(this, *args)");
            this.f34827a.z2().trackEvent(format2, this.f34828b);
            this.f34827a.L2();
        }

        public void b() {
            String format2 = String.format("Personal Info Skip Prompt - %s", Arrays.copyOf(new Object[]{"Hardware Back Button Tapped"}, 1));
            j.f(format2, "format(this, *args)");
            this.f34827a.z2().trackEvent(format2, this.f34828b);
        }

        public void onCancel() {
            String format2 = String.format("Personal Info Skip Prompt - %s", Arrays.copyOf(new Object[]{"Continue Button Tapped"}, 1));
            j.f(format2, "format(this, *args)");
            this.f34827a.z2().trackEvent(format2, this.f34828b);
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void B3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void C3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void D3(String str, String str2, Boolean bool) {
        String str3;
        String format2 = String.format(str, Arrays.copyOf(new Object[]{str2}, 1));
        j.f(format2, "format(this, *args)");
        HashMap hashMap = new HashMap();
        if (bool != null) {
            if (bool.booleanValue()) {
                str3 = "Y";
            } else {
                str3 = "N";
            }
            hashMap.put("completed", str3);
        }
        z2().trackEvent(format2, hashMap);
    }

    static /* synthetic */ void E3(BiographyInteractor biographyInteractor, String str, String str2, Boolean bool, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bool = null;
        }
        biographyInteractor.D3(str, str2, bool);
    }

    private final void F3(Boolean bool) {
        BiographyNavigationConfig biographyNavigationConfig = this.B;
        String str = null;
        if (biographyNavigationConfig == null) {
            j.y("navigationConfig");
            biographyNavigationConfig = null;
        }
        BiographyNavigationConfig.Pages a10 = biographyNavigationConfig.a();
        if (a10 != null) {
            str = a10.b();
        }
        D3("Onboarding - %s - Next Button Tapped", str, bool);
    }

    static /* synthetic */ void G3(BiographyInteractor biographyInteractor, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = null;
        }
        biographyInteractor.F3(bool);
    }

    private final void H3(String str) {
        a7.a z22 = z2();
        String format2 = String.format("Onboarding - %s", Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "format(this, *args)");
        z22.f(format2);
    }

    private final void I3(boolean z10, List<Resource> list) {
        List list2;
        boolean z11;
        List<Resource> list3 = list;
        if (B2().a("ProfileMigration.Enabled.Android")) {
            SaveAnswerUseCase I2 = I2();
            String str = this.f34824z.get(ProfileQuestion.ETHNICITY.getApiKey());
            j.d(str);
            String str2 = str;
            if (list3 != null) {
                list2 = new ArrayList(r.t(list3, 10));
                for (Resource key : list) {
                    list2.add(key.getKey());
                }
            } else {
                list2 = q.j();
            }
            qj.a d10 = SaveAnswerUseCase.d(I2, list2, (String) null, str2, QuestionGroupType.ORIGINAL_PROFILE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
            if (list3 == null || list.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            O2(d10, z11, "Ethnicity");
            return;
        }
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        if (profileDtoImplementation != null) {
            ((t) G2().o(profileDtoImplementation).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new t(new BiographyInteractor$updateEthnicities$2$1(z10, this)), new u(new BiographyInteractor$updateEthnicities$2$2(this)));
        }
    }

    static /* synthetic */ void J3(BiographyInteractor biographyInteractor, boolean z10, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        biographyInteractor.I3(z10, list);
    }

    /* access modifiers changed from: private */
    public static final void K3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void L3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void M2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void M3(boolean z10, String str) {
        boolean z11;
        if (B2().a("ProfileMigration.Enabled.Android")) {
            SaveAnswerUseCase I2 = I2();
            String str2 = this.f34824z.get(ProfileQuestion.OCCUPATION.getApiKey());
            j.d(str2);
            qj.a d10 = SaveAnswerUseCase.d(I2, (List) null, str, str2, QuestionGroupType.ORIGINAL_PROFILE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1009, (Object) null);
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            O2(d10, z11, "Occupation");
            return;
        }
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        if (profileDtoImplementation != null) {
            ((t) G2().s(profileDtoImplementation).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new x(new BiographyInteractor$updateJobTitle$1$1(z10, this)), new z(new BiographyInteractor$updateJobTitle$1$2(this)));
        }
    }

    /* access modifiers changed from: private */
    public static final void N2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    static /* synthetic */ void N3(BiographyInteractor biographyInteractor, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        biographyInteractor.M3(z10, str);
    }

    private final void O2(qj.a aVar, boolean z10, String str) {
        ((m) aVar.z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new c0(z10, this, str), new d0(new BiographyInteractor$handleSave$2(this, str)));
    }

    /* access modifiers changed from: private */
    public static final void O3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P2(boolean z10, BiographyInteractor biographyInteractor, String str) {
        j.g(biographyInteractor, "this$0");
        j.g(str, "$source");
        if (z10) {
            biographyInteractor.R2(str);
        } else {
            biographyInteractor.L2();
        }
    }

    /* access modifiers changed from: private */
    public static final void P3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void Q3(boolean z10, Resource resource) {
        List list;
        boolean z11;
        if (B2().a("ProfileMigration.Enabled.Android")) {
            SaveAnswerUseCase I2 = I2();
            String str = this.f34824z.get(ProfileQuestion.RELIGION.getApiKey());
            j.d(str);
            String str2 = str;
            if (resource == null || (list = p.e(resource.getKey())) == null) {
                list = q.j();
            }
            qj.a d10 = SaveAnswerUseCase.d(I2, list, (String) null, str2, QuestionGroupType.ORIGINAL_PROFILE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
            if (resource == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            O2(d10, z11, "Religion");
            return;
        }
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        if (profileDtoImplementation != null) {
            ((t) G2().t(profileDtoImplementation).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new e0(new BiographyInteractor$updateReligion$2$1(z10, this)), new f0(new BiographyInteractor$updateReligion$2$2(this)));
        }
    }

    /* access modifiers changed from: private */
    public final void R2(String str) {
        HashMap k10 = h0.k(h.a("screen", "Onboarding"), h.a("source", str));
        z2().trackEvent("Personal Info Skip Prompt", k10);
        ((BiographyPresenter) this.f7875e).W(new b(this, k10), j.b(str, "Degree"));
    }

    static /* synthetic */ void R3(BiographyInteractor biographyInteractor, boolean z10, Resource resource, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        biographyInteractor.Q3(z10, resource);
    }

    private final w<QuestionWAnswers> S2(ProfileQuestion profileQuestion) {
        QuestionGroupType questionGroupType;
        int i10 = a.f34826b[profileQuestion.ordinal()];
        if (i10 == 1 || i10 == 2) {
            questionGroupType = QuestionGroupType.EDUCATION_ONE;
        } else if (i10 != 3) {
            questionGroupType = QuestionGroupType.ORIGINAL_PROFILE;
        } else {
            questionGroupType = QuestionGroupType.ONBOARDING;
        }
        QuestionGroupType questionGroupType2 = questionGroupType;
        QuestionRepository H2 = H2();
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        j.d(profileDtoImplementation);
        w<QuestionWAnswers> L = QuestionRepository.y(H2, questionGroupType2, profileDtoImplementation.getId(), false, false, 8, (Object) null).Y(new s(new BiographyInteractor$loadQuestion$1(this, profileQuestion))).L();
        j.f(L, "private fun loadQuestion…    .firstOrError()\n    }");
        return L;
    }

    /* access modifiers changed from: private */
    public static final void S3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final QuestionWAnswers T2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (QuestionWAnswers) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void U2(boolean z10) {
        if (B2().a("ProfileMigration.Enabled.Android")) {
            ((t) S2(ProfileQuestion.DEGREE_ONE).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new c(new BiographyInteractor$navigateToDegree$1(this, z10)), new n(new BiographyInteractor$navigateToDegree$2(this)));
        } else {
            ((t) C2().a(ResourceType.DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new y(new BiographyInteractor$navigateToDegree$3(this, z10)), new g0(new BiographyInteractor$navigateToDegree$4(this)));
        }
        H3("Degree");
    }

    private final void U3(boolean z10, String str) {
        if (B2().a("ProfileMigration.Enabled.Android")) {
            SaveAnswerUseCase I2 = I2();
            String str2 = this.f34824z.get(ProfileQuestion.SCHOOL_ONE.getApiKey());
            j.d(str2);
            O2(SaveAnswerUseCase.d(I2, (List) null, str, str2, QuestionGroupType.EDUCATION_ONE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1009, (Object) null), false, "Occupation");
            return;
        }
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        if (profileDtoImplementation != null) {
            ((t) G2().n(profileDtoImplementation).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new a0(new BiographyInteractor$updateSchool$1$1(z10, this)), new b0(new BiographyInteractor$updateSchool$1$2(this)));
        }
    }

    static /* synthetic */ void V2(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.U2(z10);
    }

    static /* synthetic */ void V3(BiographyInteractor biographyInteractor, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        biographyInteractor.U3(z10, str);
    }

    /* access modifiers changed from: private */
    public static final void W2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void W3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Y2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Z2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void a3(boolean z10) {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f34810f;
        aVar.a(str, "navigateToEthnicity: " + z10);
        if (B2().a("ProfileMigration.Enabled.Android")) {
            ((t) S2(ProfileQuestion.ETHNICITY).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new k0(new BiographyInteractor$navigateToEthnicity$1(this, z10)), new l0(new BiographyInteractor$navigateToEthnicity$2(this)));
        } else {
            ((t) C2().a(ResourceType.ETHNICITY).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new m0(new BiographyInteractor$navigateToEthnicity$3(this, z10)), new d(new BiographyInteractor$navigateToEthnicity$4(this)));
        }
        if (B2().a("Privacy.GdprCopy.Android")) {
            ((BiographyPresenter) this.f7875e).J();
        }
        H3("Ethnicity");
    }

    static /* synthetic */ void b3(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.a3(z10);
    }

    /* access modifiers changed from: private */
    public static final void c3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void d3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void e3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void f3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void g3(boolean r10) {
        /*
            r9 = this;
            s9.a r0 = r9.B2()
            java.lang.String r1 = "ProfileMigration.Enabled.Android"
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L_0x004e
            com.coffeemeetsbagel.models.enums.ProfileQuestion r0 = com.coffeemeetsbagel.models.enums.ProfileQuestion.HEIGHT
            qj.w r0 = r9.S2(r0)
            com.coffeemeetsbagel.domain.repository.UserRepository r1 = r9.K2()
            qj.w r1 = r1.o()
            com.coffeemeetsbagel.new_user_experience.biography.h0 r2 = new com.coffeemeetsbagel.new_user_experience.biography.h0
            r2.<init>()
            qj.w r0 = qj.w.S(r0, r1, r2)
            qj.v r1 = sj.a.a()
            qj.w r0 = r0.E(r1)
            com.uber.autodispose.d r1 = com.uber.autodispose.a.a(r9)
            java.lang.Object r0 = r0.g(r1)
            com.uber.autodispose.t r0 = (com.uber.autodispose.t) r0
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToHeight$2 r1 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToHeight$2
            r1.<init>(r9, r10)
            com.coffeemeetsbagel.new_user_experience.biography.i0 r10 = new com.coffeemeetsbagel.new_user_experience.biography.i0
            r10.<init>(r1)
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToHeight$3 r1 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToHeight$3
            r1.<init>(r9)
            com.coffeemeetsbagel.new_user_experience.biography.j0 r2 = new com.coffeemeetsbagel.new_user_experience.biography.j0
            r2.<init>(r1)
            r0.b(r10, r2)
            goto L_0x00cf
        L_0x004e:
            com.coffeemeetsbagel.models.ProfileDtoImplementation r0 = r9.f34823y
            if (r0 == 0) goto L_0x00cf
            com.coffeemeetsbagel.feature.profile.ProfileManager r1 = r9.E2()
            com.coffeemeetsbagel.models.NetworkProfile r1 = r1.j()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0065
            boolean r1 = r1.isHeightUnitMetric()
            if (r1 != r2) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r2 = r3
        L_0x0066:
            r1 = 0
            if (r2 == 0) goto L_0x008c
            P r2 = r9.f7875e
            com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter r2 = (com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter) r2
            com.coffeemeetsbagel.models.entities.Height r3 = r0.getHeight()
            r4 = 168(0xa8, float:2.35E-43)
            if (r3 == 0) goto L_0x0084
            com.coffeemeetsbagel.models.entities.Height r0 = r0.getHeight()
            if (r0 == 0) goto L_0x0088
            int r0 = r0.getHeightCm()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            goto L_0x0088
        L_0x0084:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
        L_0x0088:
            r2.M(r1, r4, r10)
            goto L_0x00cf
        L_0x008c:
            P r2 = r9.f7875e
            r3 = r2
            com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter r3 = (com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter) r3
            com.coffeemeetsbagel.models.entities.Height r2 = r0.getHeight()
            if (r2 == 0) goto L_0x00a8
            com.coffeemeetsbagel.models.entities.Height r2 = r0.getHeight()
            if (r2 == 0) goto L_0x00a6
            int r2 = r2.getHeightFeet()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x00ad
        L_0x00a6:
            r4 = r1
            goto L_0x00ae
        L_0x00a8:
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x00ad:
            r4 = r2
        L_0x00ae:
            com.coffeemeetsbagel.models.entities.Height r2 = r0.getHeight()
            if (r2 == 0) goto L_0x00c3
            com.coffeemeetsbagel.models.entities.Height r0 = r0.getHeight()
            if (r0 == 0) goto L_0x00c8
            int r0 = r0.getHeightInches()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            goto L_0x00c8
        L_0x00c3:
            r0 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
        L_0x00c8:
            r5 = r1
            r6 = 5
            r7 = 6
            r8 = r10
            r3.K(r4, r5, r6, r7, r8)
        L_0x00cf:
            java.lang.String r10 = "Height"
            r9.H3(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor.g3(boolean):void");
    }

    static /* synthetic */ void h3(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.g3(z10);
    }

    /* access modifiers changed from: private */
    public static final Pair i3(QuestionWAnswers questionWAnswers, ja.b bVar) {
        j.g(questionWAnswers, "user");
        j.g(bVar, "heightQuestion");
        return new Pair(questionWAnswers, bVar);
    }

    /* access modifiers changed from: private */
    public static final void j3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void k3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void l3(boolean r11) {
        /*
            r10 = this;
            java.lang.String r0 = t9.a.onboardingOccupationHint
            java.lang.String r6 = t9.a.onboardingOccupationHintPrefix
            java.lang.String r1 = "onboardingOccupationHint"
            kotlin.jvm.internal.j.f(r0, r1)
            int r1 = r0.length()
            r7 = 0
            r8 = 1
            if (r1 <= 0) goto L_0x0013
            r1 = r8
            goto L_0x0014
        L_0x0013:
            r1 = r7
        L_0x0014:
            r9 = 0
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = "onboardingOccupationHintPrefix"
            kotlin.jvm.internal.j.f(r6, r1)
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x0024
            r1 = r8
            goto L_0x0025
        L_0x0024:
            r1 = r7
        L_0x0025:
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = ","
            java.lang.String[] r1 = new java.lang.String[]{r1}
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            java.util.List r0 = kotlin.text.StringsKt__StringsKt.C0(r0, r1, r2, r3, r4, r5)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.r.t(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x0044:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.CharSequence r2 = kotlin.text.StringsKt__StringsKt.W0(r2)
            java.lang.String r2 = r2.toString()
            r1.add(r2)
            goto L_0x0044
        L_0x005c:
            int r0 = r1.size()
            if (r0 != r8) goto L_0x0069
            java.lang.Object r0 = r1.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x007a
        L_0x0069:
            kotlin.random.Random$Default r0 = kotlin.random.Random.f32142a
            int r2 = r1.size()
            int r2 = r2 - r8
            int r0 = r0.d(r2)
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
        L_0x007a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            java.lang.String r2 = " "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x0090
        L_0x008f:
            r0 = r9
        L_0x0090:
            s9.a r1 = r10.B2()
            java.lang.String r2 = "ProfileMigration.Enabled.Android"
            boolean r1 = r1.a(r2)
            if (r1 == 0) goto L_0x00cc
            com.coffeemeetsbagel.models.enums.ProfileQuestion r1 = com.coffeemeetsbagel.models.enums.ProfileQuestion.OCCUPATION
            qj.w r1 = r10.S2(r1)
            qj.v r2 = sj.a.a()
            qj.w r1 = r1.E(r2)
            com.uber.autodispose.d r2 = com.uber.autodispose.a.a(r10)
            java.lang.Object r1 = r1.g(r2)
            com.uber.autodispose.t r1 = (com.uber.autodispose.t) r1
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToJobTitle$1 r2 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToJobTitle$1
            r2.<init>(r10, r0, r11)
            com.coffeemeetsbagel.new_user_experience.biography.e r11 = new com.coffeemeetsbagel.new_user_experience.biography.e
            r11.<init>(r2)
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToJobTitle$2 r0 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$navigateToJobTitle$2
            r0.<init>(r10)
            com.coffeemeetsbagel.new_user_experience.biography.f r2 = new com.coffeemeetsbagel.new_user_experience.biography.f
            r2.<init>(r0)
            r1.b(r11, r2)
            goto L_0x00db
        L_0x00cc:
            com.coffeemeetsbagel.models.ProfileDtoImplementation r1 = r10.f34823y
            if (r1 == 0) goto L_0x00d4
            java.lang.String r9 = r1.getOccupation()
        L_0x00d4:
            P r1 = r10.f7875e
            com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter r1 = (com.coffeemeetsbagel.new_user_experience.biography.BiographyPresenter) r1
            r1.O(r9, r0, r11)
        L_0x00db:
            java.lang.String r11 = "Occupation"
            r10.H3(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor.l3(boolean):void");
    }

    static /* synthetic */ void m3(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.l3(z10);
    }

    /* access modifiers changed from: private */
    public static final void n3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void p3(boolean z10) {
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f34810f;
        aVar.a(str, "navigateToReligion: " + z10);
        if (B2().a("ProfileMigration.Enabled.Android")) {
            ((t) S2(ProfileQuestion.RELIGION).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new k(new BiographyInteractor$navigateToReligion$1(this, z10)), new l(new BiographyInteractor$navigateToReligion$2(this)));
        } else {
            ((t) C2().a(ResourceType.RELIGION).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new m(new BiographyInteractor$navigateToReligion$3(this, z10)), new o(new BiographyInteractor$navigateToReligion$4(this)));
        }
        if (B2().a("Privacy.GdprCopy.Android")) {
            ((BiographyPresenter) this.f7875e).J();
        }
        H3("Religion");
    }

    static /* synthetic */ void q3(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.p3(z10);
    }

    /* access modifiers changed from: private */
    public static final void r3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void s3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void t3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void u3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void v3(boolean z10) {
        w<R> wVar;
        Optional optional;
        ProfileEducationEntity education;
        String school;
        if (B2().a("ProfileMigration.Enabled.Android")) {
            wVar = S2(ProfileQuestion.SCHOOL_ONE).D(new g(BiographyInteractor$navigateToSchool$schoolNameSource$1.f34829a));
            j.f(wVar, "{\n            loadQuesti…)\n            }\n        }");
        } else {
            ProfileDtoImplementation profileDtoImplementation = this.f34823y;
            if (profileDtoImplementation == null || (education = profileDtoImplementation.getEducation()) == null || (school = education.getSchool()) == null || (optional = Optional.e(school)) == null) {
                optional = Optional.a();
            }
            wVar = w.C(optional);
            j.f(wVar, "{\n            Single.jus…ional.absent())\n        }");
        }
        ((t) wVar.E(sj.a.a()).v(new h(new BiographyInteractor$navigateToSchool$1(this, z10))).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new i(new BiographyInteractor$navigateToSchool$2(this)), new j(new BiographyInteractor$navigateToSchool$3(this)));
        H3("School Name");
    }

    static /* synthetic */ void w3(BiographyInteractor biographyInteractor, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        biographyInteractor.v3(z10);
    }

    /* access modifiers changed from: private */
    public static final Optional x3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void y2(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 y3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void z3(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final g A2() {
        g gVar = this.f34814k;
        if (gVar != null) {
            return gVar;
        }
        j.y("authenticationManager");
        return null;
    }

    public final s9.a B2() {
        s9.a aVar = this.f34811g;
        if (aVar != null) {
            return aVar;
        }
        j.y("featureManager");
        return null;
    }

    public final c9.a C2() {
        c9.a aVar = this.f34818p;
        if (aVar != null) {
            return aVar;
        }
        j.y("getResourcesUseCase");
        return null;
    }

    public final GetSingleSchoolsUseCase D2() {
        GetSingleSchoolsUseCase getSingleSchoolsUseCase = this.f34819q;
        if (getSingleSchoolsUseCase != null) {
            return getSingleSchoolsUseCase;
        }
        j.y("getSchoolsUseCase");
        return null;
    }

    public final ProfileManager E2() {
        ProfileManager profileManager = this.f34815l;
        if (profileManager != null) {
            return profileManager;
        }
        j.y("legacyProfileManager");
        return null;
    }

    public final na.b F2() {
        na.b bVar = this.f34813j;
        if (bVar != null) {
            return bVar;
        }
        j.y("onboardingInteractionListener");
        return null;
    }

    public final ProfileRepository G2() {
        ProfileRepository profileRepository = this.f34812h;
        if (profileRepository != null) {
            return profileRepository;
        }
        j.y("profileRepository");
        return null;
    }

    public final QuestionRepository H2() {
        QuestionRepository questionRepository = this.f34821w;
        if (questionRepository != null) {
            return questionRepository;
        }
        j.y("questionRepository");
        return null;
    }

    public final SaveAnswerUseCase I2() {
        SaveAnswerUseCase saveAnswerUseCase = this.f34820t;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        j.y("saveAnswerUseCase");
        return null;
    }

    public final m1 J2() {
        m1 m1Var = this.f34817n;
        if (m1Var != null) {
            return m1Var;
        }
        j.y("syncManager");
        return null;
    }

    public final UserRepository K2() {
        UserRepository userRepository = this.f34822x;
        if (userRepository != null) {
            return userRepository;
        }
        j.y("userRepository");
        return null;
    }

    public void L2() {
        int i10;
        BiographyNavigationConfig biographyNavigationConfig = this.B;
        if (biographyNavigationConfig == null) {
            j.y("navigationConfig");
            biographyNavigationConfig = null;
        }
        BiographyNavigationConfig.Pages c10 = biographyNavigationConfig.c();
        if (c10 == null) {
            i10 = -1;
        } else {
            i10 = a.f34825a[c10.ordinal()];
        }
        switch (i10) {
            case 1:
                P p10 = this.f7875e;
                j.f(p10, "presenter");
                BiographyPresenter.D((BiographyPresenter) p10, false, 1, (Object) null);
                return;
            case 2:
                h3(this, false, 1, (Object) null);
                return;
            case 3:
                b3(this, false, 1, (Object) null);
                return;
            case 4:
                q3(this, false, 1, (Object) null);
                return;
            case 5:
                m3(this, false, 1, (Object) null);
                return;
            case 6:
                V2(this, false, 1, (Object) null);
                return;
            case 7:
                w3(this, false, 1, (Object) null);
                return;
            default:
                ((BiographyPresenter) this.f7875e).Q();
                w<x> b10 = c.b(J2());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                ((t) b10.n(3, timeUnit, true).L(10, timeUnit).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new q(new BiographyInteractor$goForward$1(this)), new r(new BiographyInteractor$goForward$2(this)));
                return;
        }
    }

    public void P0() {
        ((y0) B1()).m();
    }

    public void R0(Resource resource) {
        boolean z10;
        Unit unit;
        if (resource != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        F3(Boolean.valueOf(z10));
        if (resource != null) {
            ProfileDtoImplementation profileDtoImplementation = this.f34823y;
            if (profileDtoImplementation != null) {
                profileDtoImplementation.setReligion(ReligionType.Companion.fromApiKey(resource.getValue()));
            }
            R3(this, false, resource, 1, (Object) null);
            unit = Unit.f32013a;
        } else {
            unit = null;
        }
        if (unit == null) {
            ProfileDtoImplementation profileDtoImplementation2 = this.f34823y;
            if (profileDtoImplementation2 != null) {
                profileDtoImplementation2.setReligion((ReligionType) null);
            }
            Q3(true, (Resource) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T(com.coffeemeetsbagel.models.entities.Height r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = 1
            G3(r0, r2, r3, r2)
            com.coffeemeetsbagel.models.ProfileDtoImplementation r4 = r0.f34823y
            if (r4 != 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r4.setHeight(r1)
        L_0x0011:
            s9.a r4 = r20.B2()
            java.lang.String r5 = "ProfileMigration.Enabled.Android"
            boolean r4 = r4.a(r5)
            java.lang.String r5 = "Height"
            if (r4 == 0) goto L_0x008e
            r4 = 0
            if (r1 == 0) goto L_0x002a
            int r6 = r21.getHeightCm()
            if (r6 != 0) goto L_0x002a
            r6 = r3
            goto L_0x002b
        L_0x002a:
            r6 = r4
        L_0x002b:
            if (r6 == 0) goto L_0x0043
            com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.o r6 = new com.coffeemeetsbagel.new_user_experience.match_prefs.height_imperial.o
            int r7 = r21.getHeightFeet()
            int r8 = r21.getHeightInches()
            r6.<init>(r7, r8)
            float r6 = r6.d()
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x004f
        L_0x0043:
            if (r1 == 0) goto L_0x004e
            int r6 = r21.getHeightCm()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x004f
        L_0x004e:
            r6 = r2
        L_0x004f:
            com.coffeemeetsbagel.qna.SaveAnswerUseCase r7 = r20.I2()
            r8 = 0
            r9 = 0
            java.util.HashMap<java.lang.String, java.lang.String> r10 = r0.f34824z
            com.coffeemeetsbagel.models.enums.ProfileQuestion r11 = com.coffeemeetsbagel.models.enums.ProfileQuestion.HEIGHT
            java.lang.String r11 = r11.getApiKey()
            java.lang.Object r10 = r10.get(r11)
            kotlin.jvm.internal.j.d(r10)
            java.lang.String r10 = (java.lang.String) r10
            com.coffeemeetsbagel.models.enums.QuestionGroupType r11 = com.coffeemeetsbagel.models.enums.QuestionGroupType.ORIGINAL_PROFILE
            java.lang.String r11 = r11.getQuestionGroupApiString()
            r12 = 0
            if (r6 == 0) goto L_0x0077
            float r2 = r6.floatValue()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0077:
            r13 = r2
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 979(0x3d3, float:1.372E-42)
            r19 = 0
            qj.a r2 = com.coffeemeetsbagel.qna.SaveAnswerUseCase.d(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            if (r1 != 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r3 = r4
        L_0x008a:
            r0.O2(r2, r3, r5)
            goto L_0x00d1
        L_0x008e:
            com.coffeemeetsbagel.models.ProfileDtoImplementation r1 = r0.f34823y
            if (r1 == 0) goto L_0x00cc
            com.coffeemeetsbagel.domain.repository.ProfileRepository r2 = r20.G2()
            qj.w r1 = r2.r(r1)
            qj.v r2 = dk.a.c()
            qj.w r1 = r1.K(r2)
            qj.v r2 = sj.a.a()
            qj.w r1 = r1.E(r2)
            com.uber.autodispose.d r2 = com.uber.autodispose.a.a(r20)
            java.lang.Object r1 = r1.g(r2)
            com.uber.autodispose.t r1 = (com.uber.autodispose.t) r1
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$onHeight$1$1 r2 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$onHeight$1$1
            r2.<init>(r0)
            com.coffeemeetsbagel.new_user_experience.biography.v r3 = new com.coffeemeetsbagel.new_user_experience.biography.v
            r3.<init>(r2)
            com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$onHeight$1$2 r2 = new com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor$onHeight$1$2
            r2.<init>(r0)
            com.coffeemeetsbagel.new_user_experience.biography.w r4 = new com.coffeemeetsbagel.new_user_experience.biography.w
            r4.<init>(r2)
            tj.b r2 = r1.b(r3, r4)
        L_0x00cc:
            if (r2 != 0) goto L_0x00d1
            r0.R2(r5)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.biography.BiographyInteractor.T(com.coffeemeetsbagel.models.entities.Height):void");
    }

    public void U(List<Resource> list) {
        boolean z10;
        if (list != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        F3(Boolean.valueOf(z10));
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Resource value : list) {
                EthnicityType fromApiKey = EthnicityType.Companion.fromApiKey(value.getValue());
                if (fromApiKey != null) {
                    arrayList.add(fromApiKey);
                }
            }
        }
        ProfileDtoImplementation profileDtoImplementation = this.f34823y;
        if (profileDtoImplementation != null) {
            profileDtoImplementation.setEthnicities(arrayList);
        }
        if (arrayList.size() > 0) {
            J3(this, false, list, 1, (Object) null);
        } else {
            I3(true, list);
        }
    }

    public void W(String str) {
        boolean z10;
        boolean z11;
        ProfileEducationEntity profileEducationEntity;
        ProfileEducationEntity education;
        ProfileEducationEntity profileEducationEntity2;
        ProfileEducationEntity education2;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        F3(Boolean.valueOf(!z10));
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            F2().c();
            ProfileDtoImplementation profileDtoImplementation = this.f34823y;
            if (profileDtoImplementation != null) {
                if (profileDtoImplementation == null || (education2 = profileDtoImplementation.getEducation()) == null) {
                    profileEducationEntity2 = null;
                } else {
                    profileEducationEntity2 = ProfileEducationEntity.copy$default(education2, "", (String) null, 2, (Object) null);
                }
                profileDtoImplementation.setEducation(profileEducationEntity2);
            }
            V3(this, false, str, 1, (Object) null);
            F3(Boolean.FALSE);
        } else if (lc.w.b(str)) {
            F2().onError(((BiographyPresenter) this.f7875e).y());
        } else {
            F2().c();
            ProfileDtoImplementation profileDtoImplementation2 = this.f34823y;
            if (profileDtoImplementation2 != null) {
                if (profileDtoImplementation2 == null || (education = profileDtoImplementation2.getEducation()) == null) {
                    profileEducationEntity = null;
                } else {
                    profileEducationEntity = ProfileEducationEntity.copy$default(education, str, (String) null, 2, (Object) null);
                }
                profileDtoImplementation2.setEducation(profileEducationEntity);
            }
            V3(this, false, str, 1, (Object) null);
        }
    }

    public boolean e1(boolean z10) {
        String str;
        String str2;
        int i10;
        if (z10) {
            str = "Onboarding - %s - Hardware Back Button Tapped";
        } else {
            str = "Onboarding - %s - Back Button Tapped";
        }
        String str3 = str;
        BiographyNavigationConfig biographyNavigationConfig = this.B;
        BiographyNavigationConfig biographyNavigationConfig2 = null;
        if (biographyNavigationConfig == null) {
            j.y("navigationConfig");
            biographyNavigationConfig = null;
        }
        BiographyNavigationConfig.Pages a10 = biographyNavigationConfig.a();
        if (a10 != null) {
            str2 = a10.b();
        } else {
            str2 = null;
        }
        E3(this, str3, str2, (Boolean) null, 4, (Object) null);
        BiographyNavigationConfig biographyNavigationConfig3 = this.B;
        if (biographyNavigationConfig3 == null) {
            j.y("navigationConfig");
        } else {
            biographyNavigationConfig2 = biographyNavigationConfig3;
        }
        BiographyNavigationConfig.Pages b10 = biographyNavigationConfig2.b();
        if (b10 == null) {
            i10 = -1;
        } else {
            i10 = a.f34825a[b10.ordinal()];
        }
        switch (i10) {
            case 1:
                ((BiographyPresenter) this.f7875e).C(false);
                return true;
            case 2:
                g3(false);
                return true;
            case 3:
                a3(false);
                return true;
            case 4:
                p3(false);
                return true;
            case 5:
                l3(false);
                return true;
            case 6:
                U2(false);
                return true;
            case 7:
                v3(false);
                return true;
            default:
                F2().d();
                return true;
        }
    }

    public void m1(String str) {
        boolean z10;
        boolean z11;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        F3(Boolean.valueOf(!z10));
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            F2().c();
            ProfileDtoImplementation profileDtoImplementation = this.f34823y;
            if (profileDtoImplementation != null) {
                profileDtoImplementation.setOccupation("");
            }
            M3(true, str);
        } else if (lc.w.b(str)) {
            F2().onError(((BiographyPresenter) this.f7875e).y());
        } else {
            F2().c();
            ProfileDtoImplementation profileDtoImplementation2 = this.f34823y;
            if (profileDtoImplementation2 != null) {
                profileDtoImplementation2.setOccupation(StringsKt__StringsKt.W0(str).toString());
            }
            N3(this, false, str, 1, (Object) null);
        }
    }

    public void p0() {
        G3(this, (Boolean) null, 1, (Object) null);
        L2();
    }

    public void w1(Resource resource) {
        boolean z10;
        String str;
        ProfileEducationEntity education;
        List list;
        boolean z11 = true;
        if (resource != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        F3(Boolean.valueOf(z10));
        if (B2().a("ProfileMigration.Enabled.Android")) {
            SaveAnswerUseCase I2 = I2();
            String str2 = this.f34824z.get(ProfileQuestion.DEGREE_ONE.getApiKey());
            j.d(str2);
            String str3 = str2;
            if (resource == null || (list = p.e(resource.getKey())) == null) {
                list = q.j();
            }
            qj.a d10 = SaveAnswerUseCase.d(I2, list, (String) null, str3, QuestionGroupType.EDUCATION_ONE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null, 1010, (Object) null);
            if (resource != null) {
                z11 = false;
            }
            O2(d10, z11, "Degree");
            return;
        }
        if (resource != null) {
            String key = resource.getKey();
            ProfileDtoImplementation profileDtoImplementation = this.f34823y;
            if (profileDtoImplementation == null || (education = profileDtoImplementation.getEducation()) == null) {
                str = null;
            } else {
                str = education.getDegreeId();
            }
            if (j.b(key, str)) {
                L2();
                return;
            }
        }
        if (resource != null) {
            ProfileDtoImplementation profileDtoImplementation2 = this.f34823y;
            if (profileDtoImplementation2 != null) {
                profileDtoImplementation2.setEducation(new ProfileEducationEntity("", resource.getKey()));
            }
            L2();
            return;
        }
        ProfileDtoImplementation profileDtoImplementation3 = this.f34823y;
        if (profileDtoImplementation3 != null) {
            profileDtoImplementation3.setEducation(new ProfileEducationEntity("", ""));
        }
        R2("Degree");
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        this.B = new BiographyNavigationConfig(B2().a("MoveUpEducationOnboarding.Enabled.Android"));
        P p10 = this.f7875e;
        j.f(p10, "presenter");
        BiographyPresenter.D((BiographyPresenter) p10, false, 1, (Object) null);
        H3("Personal Info Intro");
        ProfileRepository G2 = G2();
        String profileId = A2().getProfileId();
        j.f(profileId, "authenticationManager.profileId");
        ((n) G2.h(profileId).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new p(new BiographyInteractor$didBecomeActive$1(this)));
    }

    public final a7.a z2() {
        a7.a aVar = this.f34816m;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }
}
