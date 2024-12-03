package com.coffeemeetsbagel.match_view;

import android.text.TextUtils;
import b6.s;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.instant_like.z;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import com.coffeemeetsbagel.match.x;
import com.coffeemeetsbagel.match_view.LoadProfileUseCase;
import com.coffeemeetsbagel.match_view.MatchViewPresenter;
import com.coffeemeetsbagel.models.ActivityReport;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.MatchContext;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.ReligionType;
import com.coffeemeetsbagel.models.enums.BagelAction;
import com.coffeemeetsbagel.models.enums.MatchToMe;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.e;
import com.coffeemeetsbagel.qna.g;
import com.coffeemeetsbagel.qna.j;
import com.coffeemeetsbagel.store.PurchaseSource;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.ktx.BuildConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qj.h;
import qj.q;

public final class MatchViewInteractor extends s<MatchViewPresenter, u0> implements MatchViewPresenter.b {
    public static final a Y = new a((DefaultConstructorMarker) null);
    public GetActivityReportUseCase B;
    public y6.a C;
    public ProfileContract$Manager D;
    public a7.a E;
    public s9.a F;
    public x G;
    public c6.b H;
    public j I;
    public e J;
    public bb.a K;
    public ProfileStringFormatter L;
    public g M;
    public a6.a N;
    public SaveAnswerUseCase O;
    public GetGroupOptionsRemainingUseCase P;
    public LoadProfileUseCase Q;
    private final List<String> R = q.m(ProfileQuestion.UNITS.getApiKey(), ProfileQuestion.GENDER.getApiKey(), ProfileQuestion.GENDER_IDENTITY.getApiKey());
    private final PurchaseAttribution S;
    /* access modifiers changed from: private */
    public final com.jakewharton.rxrelay2.b<String> T;
    public List<Photo> U;
    /* access modifiers changed from: private */
    public boolean V;
    private boolean W;
    private final String X;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f34621f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f34622g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f34623h;

    /* renamed from: j  reason: collision with root package name */
    private final MatchIdAttribution f34624j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final String f34625k;

    /* renamed from: l  reason: collision with root package name */
    private final int f34626l;

    /* renamed from: m  reason: collision with root package name */
    private final int f34627m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f34628n;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final String f34629p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f34630q;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f34631t;

    /* renamed from: w  reason: collision with root package name */
    private final q<Boolean> f34632w;

    /* renamed from: x  reason: collision with root package name */
    private final b f34633x;

    /* renamed from: y  reason: collision with root package name */
    private final String f34634y;

    /* renamed from: z  reason: collision with root package name */
    private final String f34635z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void b(String str);

        void c();

        void d();

        void e();

        void f(Bagel.STAMP stamp);
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34636a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34637b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f34638c;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006f */
        static {
            /*
                com.coffeemeetsbagel.models.enums.PurchaseAttribution[] r0 = com.coffeemeetsbagel.models.enums.PurchaseAttribution.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.models.enums.PurchaseAttribution r2 = com.coffeemeetsbagel.models.enums.PurchaseAttribution.PAID_LIKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                f34636a = r0
                com.coffeemeetsbagel.models.enums.QuestionType[] r0 = com.coffeemeetsbagel.models.enums.QuestionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionType r2 = com.coffeemeetsbagel.models.enums.QuestionType.TEXT     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                r2 = 2
                com.coffeemeetsbagel.models.enums.QuestionType r3 = com.coffeemeetsbagel.models.enums.QuestionType.SINGLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 3
                com.coffeemeetsbagel.models.enums.QuestionType r4 = com.coffeemeetsbagel.models.enums.QuestionType.MULTIPLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 4
                com.coffeemeetsbagel.models.enums.QuestionType r5 = com.coffeemeetsbagel.models.enums.QuestionType.INTEGER     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.coffeemeetsbagel.models.enums.QuestionType r5 = com.coffeemeetsbagel.models.enums.QuestionType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.coffeemeetsbagel.models.enums.QuestionType r5 = com.coffeemeetsbagel.models.enums.QuestionType.RANGE     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r6 = 6
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                f34637b = r0
                com.coffeemeetsbagel.models.enums.QuestionGroupType[] r0 = com.coffeemeetsbagel.models.enums.QuestionGroupType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionGroupType r5 = com.coffeemeetsbagel.models.enums.QuestionGroupType.INTERESTS     // Catch:{ NoSuchFieldError -> 0x005f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.VALUES     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.PERSONALITY     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.DATING_STYLE     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                f34638c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewInteractor.c.<clinit>():void");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MatchViewInteractor(boolean r9, java.lang.Integer r10, boolean r11, com.coffeemeetsbagel.match.MatchIdAttribution r12, java.lang.String r13, int r14, int r15, boolean r16, java.lang.String r17, boolean r18, boolean r19, qj.q<java.lang.Boolean> r20, com.coffeemeetsbagel.match_view.MatchViewInteractor.b r21, java.lang.String r22, java.lang.String r23) {
        /*
            r8 = this;
            r0 = r8
            r1 = r12
            r2 = r13
            r3 = r17
            r4 = r20
            r5 = r21
            r6 = r23
            java.lang.String r7 = "profileId"
            kotlin.jvm.internal.j.g(r13, r7)
            java.lang.String r7 = "matchIsSeen"
            kotlin.jvm.internal.j.g(r4, r7)
            java.lang.String r7 = "parent"
            kotlin.jvm.internal.j.g(r5, r7)
            java.lang.String r7 = "matchToMe"
            kotlin.jvm.internal.j.g(r6, r7)
            r8.<init>()
            r7 = r9
            r0.f34621f = r7
            r7 = r10
            r0.f34622g = r7
            r7 = r11
            r0.f34623h = r7
            r0.f34624j = r1
            r0.f34625k = r2
            r2 = r14
            r0.f34626l = r2
            r2 = r15
            r0.f34627m = r2
            r2 = r16
            r0.f34628n = r2
            r0.f34629p = r3
            r2 = r18
            r0.f34630q = r2
            r2 = r19
            r0.f34631t = r2
            r0.f34632w = r4
            r0.f34633x = r5
            r2 = r22
            r0.f34634y = r2
            r0.f34635z = r6
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]
            com.coffeemeetsbagel.models.enums.ProfileQuestion r4 = com.coffeemeetsbagel.models.enums.ProfileQuestion.UNITS
            java.lang.String r4 = r4.getApiKey()
            r5 = 0
            r2[r5] = r4
            com.coffeemeetsbagel.models.enums.ProfileQuestion r4 = com.coffeemeetsbagel.models.enums.ProfileQuestion.GENDER
            java.lang.String r4 = r4.getApiKey()
            r5 = 1
            r2[r5] = r4
            com.coffeemeetsbagel.models.enums.ProfileQuestion r4 = com.coffeemeetsbagel.models.enums.ProfileQuestion.GENDER_IDENTITY
            java.lang.String r4 = r4.getApiKey()
            r5 = 2
            r2[r5] = r4
            java.util.List r2 = kotlin.collections.q.m(r2)
            r0.R = r2
            r2 = 0
            if (r1 == 0) goto L_0x0079
            java.lang.Integer r4 = r12.a()
            goto L_0x007a
        L_0x0079:
            r4 = r2
        L_0x007a:
            if (r4 == 0) goto L_0x0087
            java.lang.Integer r1 = r12.a()
            kotlin.jvm.internal.j.d(r1)
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r2 = com.coffeemeetsbagel.models.enums.PurchaseAttribution.purchaseAttributionFromInteger(r1)
        L_0x0087:
            r0.S = r2
            com.jakewharton.rxrelay2.b r1 = com.jakewharton.rxrelay2.b.C0()
            java.lang.String r2 = "create()"
            kotlin.jvm.internal.j.f(r1, r2)
            r0.T = r1
            if (r3 == 0) goto L_0x00d9
            int r1 = r17.hashCode()
            switch(r1) {
                case -667925951: goto L_0x00cd;
                case -524855145: goto L_0x00c1;
                case 3052376: goto L_0x00b6;
                case 164625660: goto L_0x00aa;
                case 2096490357: goto L_0x009e;
                default: goto L_0x009d;
            }
        L_0x009d:
            goto L_0x00d9
        L_0x009e:
            java.lang.String r1 = "discover feed"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00a7
            goto L_0x00d9
        L_0x00a7:
            java.lang.String r1 = "discover_profile"
            goto L_0x00db
        L_0x00aa:
            java.lang.String r1 = "today's bagel"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00b3
            goto L_0x00d9
        L_0x00b3:
            java.lang.String r1 = "suggested_profile"
            goto L_0x00db
        L_0x00b6:
            java.lang.String r1 = "chat"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00d9
            java.lang.String r1 = "chat_profile"
            goto L_0x00db
        L_0x00c1:
            java.lang.String r1 = "suggested history"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00ca
            goto L_0x00d9
        L_0x00ca:
            java.lang.String r1 = "suggested_history_profile"
            goto L_0x00db
        L_0x00cd:
            java.lang.String r1 = "Limelight"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x00d6
            goto L_0x00d9
        L_0x00d6:
            java.lang.String r1 = "likes_you_profile"
            goto L_0x00db
        L_0x00d9:
            java.lang.String r1 = "unspecified"
        L_0x00db:
            r0.X = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewInteractor.<init>(boolean, java.lang.Integer, boolean, com.coffeemeetsbagel.match.MatchIdAttribution, java.lang.String, int, int, boolean, java.lang.String, boolean, boolean, qj.q, com.coffeemeetsbagel.match_view.MatchViewInteractor$b, java.lang.String, java.lang.String):void");
    }

    private final List<Pair<String, String>> B2(List<QuestionWAnswers> list, List<QuestionWAnswers> list2) {
        String str;
        T t10;
        String str2;
        T t11;
        String str3;
        T t12;
        String str4;
        T t13;
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (kotlin.jvm.internal.j.b(((QuestionWAnswers) t10).e().getName(), ProfileQuestion.SCHOOL_ONE.getApiKey())) {
                break;
            }
        }
        QuestionWAnswers questionWAnswers = (QuestionWAnswers) t10;
        if (questionWAnswers != null) {
            str2 = z2(this, questionWAnswers, (Boolean) null, 1, (Object) null);
        } else {
            str2 = null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (kotlin.jvm.internal.j.b(((QuestionWAnswers) t11).e().getName(), ProfileQuestion.DEGREE_ONE.getApiKey())) {
                break;
            }
        }
        QuestionWAnswers questionWAnswers2 = (QuestionWAnswers) t11;
        if (questionWAnswers2 != null) {
            str3 = z2(this, questionWAnswers2, (Boolean) null, 1, (Object) null);
        } else {
            str3 = null;
        }
        Iterator<T> it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t12 = null;
                break;
            }
            t12 = it3.next();
            if (kotlin.jvm.internal.j.b(((QuestionWAnswers) t12).e().getName(), ProfileQuestion.SCHOOL_TWO.getApiKey())) {
                break;
            }
        }
        QuestionWAnswers questionWAnswers3 = (QuestionWAnswers) t12;
        if (questionWAnswers3 != null) {
            str4 = z2(this, questionWAnswers3, (Boolean) null, 1, (Object) null);
        } else {
            str4 = null;
        }
        Iterator<T> it4 = list2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                t13 = null;
                break;
            }
            t13 = it4.next();
            if (kotlin.jvm.internal.j.b(((QuestionWAnswers) t13).e().getName(), ProfileQuestion.DEGREE_TWO.getApiKey())) {
                break;
            }
        }
        QuestionWAnswers questionWAnswers4 = (QuestionWAnswers) t13;
        if (questionWAnswers4 != null) {
            str = z2(this, questionWAnswers4, (Boolean) null, 1, (Object) null);
        }
        String W2 = CollectionsKt___CollectionsKt.W(q.m(CollectionsKt___CollectionsKt.W(q.o(str2, str3), RemoteSettings.FORWARD_SLASH_STRING, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), CollectionsKt___CollectionsKt.W(q.o(str4, str), RemoteSettings.FORWARD_SLASH_STRING, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (r.w(W2)) {
            return q.j();
        }
        return p.e(new Pair(Q2().a(R.string.label_education, new Object[0]), W2));
    }

    private final List<Pair<String, String>> G2(List<QuestionWAnswers> list, boolean z10) {
        Pair pair;
        ArrayList<QuestionWAnswers> arrayList = new ArrayList<>();
        for (T next : list) {
            if (!this.R.contains(((QuestionWAnswers) next).e().getName())) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (QuestionWAnswers questionWAnswers : arrayList) {
            String y22 = y2(questionWAnswers, Boolean.valueOf(z10));
            if (y22 != null) {
                pair = new Pair(questionWAnswers.e().getLabel(), y22);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return arrayList2;
    }

    private final List<Pair<String, String>> H2(l lVar, List<Resource> list, boolean z10) {
        Pair pair;
        Pair pair2;
        Pair pair3;
        Height i10 = lVar.i();
        Pair pair4 = null;
        if (i10 != null) {
            pair = new Pair(Q2().a(R.string.label_height, new Object[0]), O2().c(z10, new com.coffeemeetsbagel.models.Height(i10.getHeightCm())));
        } else {
            pair = null;
        }
        if (!lVar.f().isEmpty()) {
            pair2 = new Pair(Q2().a(R.string.label_ethnicity, new Object[0]), O2().b(lVar));
        } else {
            pair2 = null;
        }
        ReligionType m10 = lVar.m();
        if (m10 != null) {
            pair3 = new Pair(Q2().a(R.string.label_religion, new Object[0]), Q2().b(R.array.religion)[m10.ordinal()]);
        } else {
            pair3 = null;
        }
        if (lVar.d() != null) {
            pair4 = new Pair(Q2().a(R.string.label_education, new Object[0]), O2().a(lVar, list));
        }
        return q.o(pair, pair2, pair3, pair4);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        if (r5 != false) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void R2(java.util.List<com.coffeemeetsbagel.profile.m> r5, com.coffeemeetsbagel.models.enums.QuestionGroupType r6) {
        /*
            r4 = this;
            int[] r0 = com.coffeemeetsbagel.match_view.MatchViewInteractor.c.f34638c
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x004a
            r2 = 2
            if (r0 == r2) goto L_0x0042
            r2 = 3
            if (r0 == r2) goto L_0x003a
            r2 = 4
            if (r0 == r2) goto L_0x0032
            fa.a$a r0 = fa.a.f40771d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't show "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = " answers."
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            java.lang.String r2 = "MatchViewInteractor"
            r0.b(r2, r6)
            goto L_0x0051
        L_0x0032:
            P r6 = r4.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r6 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r6
            r6.J0(r5)
            goto L_0x0051
        L_0x003a:
            P r6 = r4.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r6 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r6
            r6.X0(r5)
            goto L_0x0051
        L_0x0042:
            P r6 = r4.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r6 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r6
            r6.e1(r5)
            goto L_0x0051
        L_0x004a:
            P r6 = r4.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r6 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r6
            r6.T0(r5)
        L_0x0051:
            a6.a r6 = r4.A2()
            java.lang.String r0 = "has_seen_common_interests_dialog"
            boolean r6 = r6.a(r0)
            r2 = 0
            if (r6 != 0) goto L_0x0084
            java.util.Iterator r5 = r5.iterator()
        L_0x0062:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0076
            java.lang.Object r6 = r5.next()
            r3 = r6
            com.coffeemeetsbagel.profile.m r3 = (com.coffeemeetsbagel.profile.m) r3
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x0062
            goto L_0x0077
        L_0x0076:
            r6 = 0
        L_0x0077:
            com.coffeemeetsbagel.profile.m r6 = (com.coffeemeetsbagel.profile.m) r6
            if (r6 == 0) goto L_0x0080
            boolean r5 = r6.b()
            goto L_0x0081
        L_0x0080:
            r5 = r2
        L_0x0081:
            if (r5 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r1 = r2
        L_0x0085:
            if (r1 == 0) goto L_0x0095
            P r5 = r4.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r5 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r5
            r5.G0()
            a6.a r5 = r4.A2()
            r5.b(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewInteractor.R2(java.util.List, com.coffeemeetsbagel.models.enums.QuestionGroupType):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r0 != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean S2() {
        /*
            r5 = this;
            s9.a r0 = r5.C2()
            java.lang.String r1 = "LYDF.Milestone4.Show.Android"
            boolean r0 = r0.a(r1)
            s9.a r1 = r5.C2()
            java.lang.String r2 = "UnblurPurchasedLikeAndroid.UnBlur.Android"
            boolean r1 = r1.a(r2)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0029
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r1 = r5.S
            if (r1 == 0) goto L_0x0024
            boolean r1 = r1.isPurchased()
            if (r1 != r3) goto L_0x0024
            r1 = r3
            goto L_0x0025
        L_0x0024:
            r1 = r2
        L_0x0025:
            if (r1 != 0) goto L_0x0029
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            if (r0 == 0) goto L_0x003c
            com.coffeemeetsbagel.models.enums.PurchaseAttribution r0 = r5.S
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.isPurchased()
            if (r0 != r3) goto L_0x0038
            r0 = r3
            goto L_0x0039
        L_0x0038:
            r0 = r2
        L_0x0039:
            if (r0 == 0) goto L_0x003c
            goto L_0x004a
        L_0x003c:
            s9.a r0 = r5.C2()
            java.lang.String r4 = "LikesYouHardPaywall.Show.Android"
            boolean r0 = r0.a(r4)
            if (r0 == 0) goto L_0x004b
            if (r1 != 0) goto L_0x004b
        L_0x004a:
            r2 = r3
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewInteractor.S2():boolean");
    }

    private final void T2(String str, int i10) {
        ((p) this.f34632w.s().o0(new a0(MatchViewInteractor$processWooReceived$1.f34641a)).g(com.uber.autodispose.a.a(this))).c(new b0(new MatchViewInteractor$processWooReceived$2(this, str, i10)));
    }

    /* access modifiers changed from: private */
    public static final boolean U2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void V2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void W2(l lVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        MatchIdAttribution matchIdAttribution;
        String c10;
        PurchaseAttribution purchaseAttribution = PurchaseAttribution.INSTANT_LIKE;
        PurchaseAttribution purchaseAttribution2 = this.S;
        boolean z14 = true;
        if (purchaseAttribution == purchaseAttribution2) {
            z10 = true;
        } else {
            z10 = false;
        }
        PurchaseAttribution purchaseAttribution3 = PurchaseAttribution.PAID_LIKE;
        if (purchaseAttribution3 == purchaseAttribution2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (PurchaseAttribution.BOOST == purchaseAttribution2) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.f34626l > this.f34627m) {
            z13 = true;
        } else {
            z13 = false;
        }
        String j10 = lVar.j();
        z zVar = z.f14047a;
        boolean contains = zVar.a().contains(j10);
        if (z10) {
            if (!contains) {
                ((MatchViewPresenter) this.f7875e).Q0();
            }
        } else if (z11 && this.f34628n) {
            ((MatchViewPresenter) this.f7875e).M0(D2(purchaseAttribution3));
        } else if (z13 && !contains && (matchIdAttribution = this.f34624j) != null && (c10 = matchIdAttribution.c()) != null) {
            int D2 = D2(PurchaseAttribution.SKIP_THE_LINE);
            ((MatchViewPresenter) this.f7875e).M0(D2);
            T2(c10, D2);
        }
        zVar.a().add(j10);
        if (!this.f34628n || S2()) {
            ((MatchViewPresenter) this.f7875e).h0();
        } else if (z10) {
            ((MatchViewPresenter) this.f7875e).Y0();
        } else if (z12) {
            ((MatchViewPresenter) this.f7875e).E0();
        } else {
            ((MatchViewPresenter) this.f7875e).V0();
        }
        String str = this.f34634y;
        if (!(str == null || str.length() == 0)) {
            z14 = false;
        }
        if (!z14) {
            ((MatchViewPresenter) this.f7875e).F0(this.f34634y);
        } else if (C2().a("LikesYouCuration.Pill.Android") && this.f34628n && kotlin.jvm.internal.j.b(this.f34635z, MatchToMe.MY_TYPE.getValue())) {
            ((MatchViewPresenter) this.f7875e).g1();
        }
    }

    /* access modifiers changed from: private */
    public final void X2(l lVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.valueOf(lVar.a()));
        if (StringUtils.isProfileStringComplete(lVar.b())) {
            sb2.append(", ");
            sb2.append(lVar.b());
        } else if (StringUtils.isProfileStringComplete(lVar.o())) {
            sb2.append(", ");
            sb2.append(lVar.o());
        } else if (StringUtils.isProfileStringComplete(lVar.c())) {
            sb2.append(", ");
            sb2.append(lVar.c());
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.j.f(sb3, "stringBuilder.toString()");
        if (TextUtils.isEmpty(sb3)) {
            ((MatchViewPresenter) this.f7875e).e0();
        } else {
            ((MatchViewPresenter) this.f7875e).l0(sb3);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0051 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y2(com.coffeemeetsbagel.qna.QuestionWAnswers r12, com.coffeemeetsbagel.profile.l r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r12 == 0) goto L_0x0038
            java.util.List r12 = r12.d()
            if (r12 == 0) goto L_0x0038
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.P(r12)
            com.coffeemeetsbagel.models.dto.Answer r12 = (com.coffeemeetsbagel.models.dto.Answer) r12
            if (r12 == 0) goto L_0x0038
            com.coffeemeetsbagel.models.dto.Location r12 = r12.getLocation()
            if (r12 == 0) goto L_0x0038
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]
            int r3 = r13.a()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2[r1] = r3
            java.lang.String r3 = r12.getCity()
            r2[r0] = r3
            r3 = 2
            java.lang.String r12 = r12.getState()
            r2[r3] = r12
            java.util.List r12 = kotlin.collections.q.m(r2)
            if (r12 != 0) goto L_0x0044
        L_0x0038:
            int r12 = r13.a()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            java.util.List r12 = kotlin.collections.p.e(r12)
        L_0x0044:
            P r13 = r11.f7875e
            com.coffeemeetsbagel.match_view.MatchViewPresenter r13 = (com.coffeemeetsbagel.match_view.MatchViewPresenter) r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x0051:
            boolean r3 = r12.hasNext()
            if (r3 == 0) goto L_0x0074
            java.lang.Object r3 = r12.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x006d
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0068
            r4 = r0
            goto L_0x0069
        L_0x0068:
            r4 = r1
        L_0x0069:
            if (r4 != r0) goto L_0x006d
            r4 = r0
            goto L_0x006e
        L_0x006d:
            r4 = r1
        L_0x006e:
            if (r4 == 0) goto L_0x0051
            r2.add(r3)
            goto L_0x0051
        L_0x0074:
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 62
            r10 = 0
            java.lang.String r3 = ", "
            java.lang.String r12 = kotlin.collections.CollectionsKt___CollectionsKt.W(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r13.l0(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewInteractor.Y2(com.coffeemeetsbagel.qna.QuestionWAnswers, com.coffeemeetsbagel.profile.l):void");
    }

    /* access modifiers changed from: private */
    public final void Z2(String str, String str2) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        if (StringUtils.isProfileStringComplete(str)) {
            sb2.append(str);
            z10 = true;
        } else {
            z10 = false;
        }
        if (StringUtils.isProfileStringComplete(str2)) {
            if (z10) {
                sb2.append(", ");
            }
            sb2.append(str2);
        }
        String sb3 = sb2.toString();
        kotlin.jvm.internal.j.f(sb3, "stringBuilder.toString()");
        if (TextUtils.isEmpty(sb3)) {
            ((MatchViewPresenter) this.f7875e).g0();
        } else {
            ((MatchViewPresenter) this.f7875e).n0(sb3);
        }
    }

    /* access modifiers changed from: private */
    public final void d3(String str) {
        boolean z10;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((MatchViewPresenter) this.f7875e).f0();
        } else {
            ((MatchViewPresenter) this.f7875e).m0(str);
        }
    }

    private final void e3() {
        ((n) v2().j(this.f34625k).t(500, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new c0(new MatchViewInteractor$setupActivityReport$1(this)), new q(new MatchViewInteractor$setupActivityReport$2(this)));
    }

    /* access modifiers changed from: private */
    public static final void f3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void g3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void h3(ActivityReport activityReport) {
        fa.a.f40771d.a("MatchViewInteractor", "setupActivityReportData");
        if (activityReport.getOverallChatActivity() == null) {
            ((MatchViewPresenter) this.f7875e).B0();
        } else {
            Float overallChatActivity = activityReport.getOverallChatActivity();
            kotlin.jvm.internal.j.d(overallChatActivity);
            ((MatchViewPresenter) this.f7875e).s0(overallChatActivity.floatValue());
        }
        if (activityReport.getChatInitiationLevel() == null) {
            ((MatchViewPresenter) this.f7875e).C0();
        } else {
            Float chatInitiationLevel = activityReport.getChatInitiationLevel();
            kotlin.jvm.internal.j.d(chatInitiationLevel);
            ((MatchViewPresenter) this.f7875e).t0(chatInitiationLevel.floatValue());
        }
        if (activityReport.getAvgResponseTime() == null) {
            ((MatchViewPresenter) this.f7875e).A0();
        } else {
            Float avgResponseTime = activityReport.getAvgResponseTime();
            kotlin.jvm.internal.j.d(avgResponseTime);
            ((MatchViewPresenter) this.f7875e).r0(avgResponseTime.floatValue());
        }
        if (activityReport.getHasLoggedInRecently() == null) {
            ((MatchViewPresenter) this.f7875e).D0();
            return;
        }
        Boolean hasLoggedInRecently = activityReport.getHasLoggedInRecently();
        kotlin.jvm.internal.j.d(hasLoggedInRecently);
        ((MatchViewPresenter) this.f7875e).u0(hasLoggedInRecently.booleanValue());
    }

    private final void i3() {
        fa.a.f40771d.a("MatchViewInteractor", "setupNullActivityReport");
        ((MatchViewPresenter) this.f7875e).B0();
        ((MatchViewPresenter) this.f7875e).C0();
        ((MatchViewPresenter) this.f7875e).A0();
        ((MatchViewPresenter) this.f7875e).D0();
    }

    private final void j2(String str, String str2) {
        h<List<String>> hVar;
        for (QuestionGroupType questionGroupType : q.m(QuestionGroupType.VALUES, QuestionGroupType.PERSONALITY, QuestionGroupType.INTERESTS, QuestionGroupType.DATING_STYLE)) {
            h<List<String>> a10 = K2().a(str2, questionGroupType);
            if (kotlin.jvm.internal.j.b(str, str2)) {
                hVar = h.X(q.j());
                kotlin.jvm.internal.j.f(hVar, "{\n                    //…stOf())\n                }");
            } else {
                hVar = K2().a(str, questionGroupType);
            }
            ((n) h.n(a10, hVar, new r(MatchViewInteractor$compareChipAnswers$1$1.f34639a)).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new s(new MatchViewInteractor$compareChipAnswers$1$2(str, str2, this, questionGroupType)), new t(new MatchViewInteractor$compareChipAnswers$1$3(questionGroupType, this)));
        }
    }

    /* access modifiers changed from: private */
    public final void j3(boolean z10, ActivityReport activityReport) {
        ((MatchViewPresenter) this.f7875e).q0();
        if (z10) {
            ((MatchViewPresenter) this.f7875e).j0();
            if (activityReport == null) {
                i3();
            } else {
                h3(activityReport);
            }
        } else {
            ((MatchViewPresenter) this.f7875e).d1();
            q3();
        }
    }

    /* access modifiers changed from: private */
    public static final Pair k2(Function2 function2, Object obj, Object obj2) {
        kotlin.jvm.internal.j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final void l2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void l3() {
        if (kotlin.jvm.internal.j.b("discover feed", this.f34629p) && this.f34630q) {
            if (C2().a("OnePaidLike.Enabled.Android")) {
                m3();
            } else {
                p3(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void m2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void n2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void q2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void q3() {
        ((MatchViewPresenter) this.f7875e).v0();
        ((MatchViewPresenter) this.f7875e).w0();
        ((MatchViewPresenter) this.f7875e).z0();
        ((MatchViewPresenter) this.f7875e).y0();
        ((MatchViewPresenter) this.f7875e).O0();
    }

    /* access modifiers changed from: private */
    public static final void r2(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void s2(ja.b bVar, l lVar, List<Photo> list) {
        c3(list);
        ((MatchViewPresenter) this.f7875e).o0(M2());
        W2(lVar);
        if (kotlin.jvm.internal.j.b(bVar.u(), lVar.j())) {
            ((MatchViewPresenter) this.f7875e).h1();
            return;
        }
        if (this.f34631t) {
            ((MatchViewPresenter) this.f7875e).c1();
        } else {
            ((MatchViewPresenter) this.f7875e).i0();
        }
        l3();
    }

    private final void s3() {
        int i10;
        if (this.f34623h) {
            k3();
            return;
        }
        int id2 = BagelAction.LIKE.getId();
        Integer num = this.f34622g;
        if (num != null && id2 == num.intValue()) {
            PurchaseAttribution purchaseAttribution = this.S;
            if (purchaseAttribution == null) {
                i10 = -1;
            } else {
                i10 = c.f34636a[purchaseAttribution.ordinal()];
            }
            if (i10 == 1) {
                m3();
            } else {
                p3(this.f34621f);
            }
        } else {
            int id3 = BagelAction.PASS.getId();
            Integer num2 = this.f34622g;
            if (num2 != null && id3 == num2.intValue()) {
                r3();
            }
        }
    }

    /* access modifiers changed from: private */
    public final QuestionWAnswers t2(List<QuestionWAnswers> list, String... strArr) {
        T t10;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (l.v(strArr, ((QuestionWAnswers) t10).e().getName())) {
                break;
            }
        }
        return (QuestionWAnswers) t10;
    }

    private final void u3() {
        ((t) this.T.C().g(com.uber.autodispose.a.a(this))).b(new y(new MatchViewInteractor$trackView$1(this)), new z(MatchViewInteractor$trackView$2.f34642a));
    }

    /* access modifiers changed from: private */
    public static final void v3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void w3(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void x3(LoadProfileUseCase.a aVar) {
        List<Pair<String, String>> list;
        boolean x10 = aVar.j().x();
        List h02 = CollectionsKt___CollectionsKt.h0(G2(aVar.i(), x10), G2(aVar.f(), x10));
        if (C2().a("ProfileMigration.Enabled.Android")) {
            list = q.j();
        } else {
            list = H2(aVar.h(), aVar.b(), x10);
        }
        ((MatchViewPresenter) this.f7875e).k0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(CollectionsKt___CollectionsKt.h0(h02, list), G2(aVar.a(), x10)), G2(aVar.e(), x10)), B2(aVar.c(), aVar.d())), q.j()));
    }

    private final String y2(QuestionWAnswers questionWAnswers, Boolean bool) {
        String str;
        Integer integerValue;
        Float floatValue;
        String str2;
        Float floatValue2;
        Float f10;
        Float f11 = null;
        if (questionWAnswers.d().isEmpty()) {
            return null;
        }
        switch (c.f34637b[questionWAnswers.e().getType().ordinal()]) {
            case 1:
                List<Answer> d10 = questionWAnswers.d();
                ArrayList arrayList = new ArrayList();
                for (Answer textValue : d10) {
                    String textValue2 = textValue.getTextValue();
                    if (textValue2 != null) {
                        arrayList.add(textValue2);
                    }
                }
                return CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            case 2:
            case 3:
                List<Option> options = questionWAnswers.e().getOptions();
                LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
                for (T next : options) {
                    linkedHashMap.put(((Option) next).getId(), next);
                }
                List<Answer> d11 = questionWAnswers.d();
                ArrayList arrayList2 = new ArrayList();
                for (Answer optionId : d11) {
                    Option option = (Option) linkedHashMap.get(optionId.getOptionId());
                    if (option != null) {
                        str = option.getTitle();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                return CollectionsKt___CollectionsKt.W(arrayList2, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            case 4:
                Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer == null || (integerValue = answer.getIntegerValue()) == null) {
                    return null;
                }
                return integerValue.toString();
            case 5:
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                    if (answer2 == null || (floatValue2 = answer2.getFloatValue()) == null) {
                        str2 = null;
                    } else {
                        str2 = O2().c(booleanValue, new com.coffeemeetsbagel.models.Height(c.b(floatValue2.floatValue())));
                    }
                    if (str2 != null) {
                        return str2;
                    }
                }
                Answer answer3 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer3 == null || (floatValue = answer3.getFloatValue()) == null) {
                    return null;
                }
                return floatValue.toString();
            case 6:
                Answer answer4 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer4 != null) {
                    f10 = answer4.getMinValue();
                } else {
                    f10 = null;
                }
                Answer answer5 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer5 != null) {
                    f11 = answer5.getMaxValue();
                }
                return f10 + " - " + f11;
            default:
                return null;
        }
    }

    static /* synthetic */ String z2(MatchViewInteractor matchViewInteractor, QuestionWAnswers questionWAnswers, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        return matchViewInteractor.y2(questionWAnswers, bool);
    }

    public final a6.a A2() {
        a6.a aVar = this.N;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("coachMarkManager");
        return null;
    }

    public final s9.a C2() {
        s9.a aVar = this.F;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("featureManager");
        return null;
    }

    public final int D2(PurchaseAttribution purchaseAttribution) {
        kotlin.jvm.internal.j.g(purchaseAttribution, "purchaseAttribution");
        if (purchaseAttribution == PurchaseAttribution.PAID_LIKE) {
            if (C2().a("OnePaidLike.Enabled.Android")) {
                return 0;
            }
            return 3;
        } else if (purchaseAttribution == PurchaseAttribution.SKIP_THE_LINE) {
            return this.f34626l;
        } else {
            return -1;
        }
    }

    public final GetGroupOptionsRemainingUseCase E2() {
        GetGroupOptionsRemainingUseCase getGroupOptionsRemainingUseCase = this.P;
        if (getGroupOptionsRemainingUseCase != null) {
            return getGroupOptionsRemainingUseCase;
        }
        kotlin.jvm.internal.j.y("getCounterUseCase");
        return null;
    }

    public final j F2() {
        j jVar = this.I;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("getMultiChoiceQnaUseCase");
        return null;
    }

    public void G0(boolean z10) {
        String str;
        Pair[] pairArr = new Pair[3];
        if (z10) {
            str = "hide";
        } else {
            str = "report";
        }
        pairArr[0] = gk.h.a(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str);
        pairArr[1] = gk.h.a(Extra.IS_CONNECTED, String.valueOf(this.f34623h));
        pairArr[2] = gk.h.a("block_source", this.X);
        x2().trackEvent("Block - Action Tapped", h0.l(pairArr));
    }

    public final LoadProfileUseCase I2() {
        LoadProfileUseCase loadProfileUseCase = this.Q;
        if (loadProfileUseCase != null) {
            return loadProfileUseCase;
        }
        kotlin.jvm.internal.j.y("loadProfileUseCase");
        return null;
    }

    public final x J2() {
        x xVar = this.G;
        if (xVar != null) {
            return xVar;
        }
        kotlin.jvm.internal.j.y("markWoosSeenUseCase");
        return null;
    }

    public void K(boolean z10) {
        if (!this.W) {
            e3();
            if (z10) {
                this.W = true;
            }
        }
    }

    public void K0() {
        this.f34633x.d();
    }

    public final e K2() {
        e eVar = this.J;
        if (eVar != null) {
            return eVar;
        }
        kotlin.jvm.internal.j.y("multiChoiceAnswersUseCase");
        return null;
    }

    public final int L2() {
        return ((MatchViewPresenter) this.f7875e).b0();
    }

    public final List<Photo> M2() {
        List<Photo> list = this.U;
        if (list != null) {
            return list;
        }
        kotlin.jvm.internal.j.y("photos");
        return null;
    }

    public final ProfileContract$Manager N2() {
        ProfileContract$Manager profileContract$Manager = this.D;
        if (profileContract$Manager != null) {
            return profileContract$Manager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public final ProfileStringFormatter O2() {
        ProfileStringFormatter profileStringFormatter = this.L;
        if (profileStringFormatter != null) {
            return profileStringFormatter;
        }
        kotlin.jvm.internal.j.y("profileStringFormatter");
        return null;
    }

    public final SaveAnswerUseCase P2() {
        SaveAnswerUseCase saveAnswerUseCase = this.O;
        if (saveAnswerUseCase != null) {
            return saveAnswerUseCase;
        }
        kotlin.jvm.internal.j.y("saveAnswerUseCase");
        return null;
    }

    public void Q0() {
        String str = this.f34629p;
        if (str == null) {
            str = BuildConfig.VERSION_NAME;
        }
        ((u0) B1()).v(new PurchaseSource(str, "activity report"));
    }

    public final bb.a Q2() {
        bb.a aVar = this.K;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("stringProvider");
        return null;
    }

    public void S(Bagel.STAMP stamp) {
        kotlin.jvm.internal.j.g(stamp, "stamp");
        this.f34633x.f(stamp);
    }

    public void S0() {
        ((u0) B1()).m();
    }

    public final void a3(MatchContext matchContext) {
        kotlin.jvm.internal.j.g(matchContext, "matchContext");
        ((MatchViewPresenter) this.f7875e).I0(matchContext);
    }

    public void b(String str) {
        kotlin.jvm.internal.j.g(str, "comment");
        this.f34633x.b(str);
    }

    public final void b3(int i10) {
        ((MatchViewPresenter) this.f7875e).p0(i10);
    }

    public void c() {
        this.f34633x.c();
    }

    public void c1() {
        this.f34633x.e();
    }

    public final void c3(List<Photo> list) {
        kotlin.jvm.internal.j.g(list, "<set-?>");
        this.U = list;
    }

    public final void k3() {
        ((MatchViewPresenter) this.f7875e).H0();
    }

    public void m0(int i10) {
        ((u0) B1()).r(M2(), i10);
    }

    public final void m3() {
        ((MatchViewPresenter) this.f7875e).L0();
    }

    public final void n3(boolean z10) {
        ((MatchViewPresenter) this.f7875e).N0(z10);
    }

    public final void o3() {
        ((MatchViewPresenter) this.f7875e).S0();
    }

    public final void p3(boolean z10) {
        boolean z11;
        if (N2().j() != null) {
            NetworkProfile j10 = N2().j();
            kotlin.jvm.internal.j.d(j10);
            if (j10.hasPrioritizedLikes()) {
                z11 = true;
                ((MatchViewPresenter) this.f7875e).U0(z11, z10);
            }
        }
        z11 = false;
        ((MatchViewPresenter) this.f7875e).U0(z11, z10);
    }

    public void q0() {
        if (!this.V) {
            String E0 = this.T.E0();
            if (E0 != null) {
                int hashCode = E0.hashCode();
                if (hashCode != -2013585622) {
                    if (hashCode == -146305277 && E0.equals("Unlocked")) {
                        u2().a(true);
                    }
                } else if (E0.equals("Locked")) {
                    u2().a(false);
                }
            }
            this.V = true;
        }
    }

    public final void r3() {
        ((MatchViewPresenter) this.f7875e).W0();
    }

    public final void t3(int i10) {
        ((MatchViewPresenter) this.f7875e).f1(i10);
    }

    public void u() {
        this.V = false;
    }

    public final y6.a u2() {
        y6.a aVar = this.C;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("activityReportManager");
        return null;
    }

    public final GetActivityReportUseCase v2() {
        GetActivityReportUseCase getActivityReportUseCase = this.B;
        if (getActivityReportUseCase != null) {
            return getActivityReportUseCase;
        }
        kotlin.jvm.internal.j.y("activityReportUseCase");
        return null;
    }

    public void w(QuestionGroupType questionGroupType) {
        kotlin.jvm.internal.j.g(questionGroupType, "questionGroupType");
        NetworkProfile j10 = N2().j();
        kotlin.jvm.internal.j.d(j10);
        String id2 = j10.getId();
        kotlin.jvm.internal.j.f(id2, "profileManager.myOwnProfile!!.id");
        ((MatchViewPresenter) this.f7875e).K0(id2, questionGroupType, F2(), P2(), E2());
    }

    public final c6.b w2() {
        c6.b bVar = this.H;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("activityResultStream");
        return null;
    }

    public final a7.a x2() {
        a7.a aVar = this.E;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    /* access modifiers changed from: protected */
    public void y1() {
        super.y1();
        ((n) I2().f(this.f34625k).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new p(new MatchViewInteractor$didBecomeActive$1(this)), new u(new MatchViewInteractor$didBecomeActive$2(this)));
        String str = this.f34625k;
        NetworkProfile j10 = N2().j();
        kotlin.jvm.internal.j.d(j10);
        String id2 = j10.getId();
        kotlin.jvm.internal.j.f(id2, "profileManager.myOwnProfile!!.id");
        j2(str, id2);
        ((n) E2().c(this.f34625k, QuestionGroupType.PROMPTS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new v(new MatchViewInteractor$didBecomeActive$3(this)), new w(MatchViewInteractor$didBecomeActive$4.f34640a));
        s3();
        e3();
        u3();
        ((p) w2().a().g(com.uber.autodispose.a.a(this))).c(new x(new MatchViewInteractor$didBecomeActive$5(this)));
    }
}
