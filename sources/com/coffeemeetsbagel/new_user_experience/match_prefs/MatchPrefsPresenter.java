package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.match_prefs.MatchPreferenceQuestions;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import nc.d;
import r7.g;
import r7.h;
import x1.k;
import x1.m;

public final class MatchPrefsPresenter extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35147e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f35148f;

    /* renamed from: g  reason: collision with root package name */
    private final f f35149g;

    /* renamed from: h  reason: collision with root package name */
    private final f f35150h;

    /* renamed from: j  reason: collision with root package name */
    private final f f35151j;

    /* renamed from: k  reason: collision with root package name */
    private final String f35152k = MatchPrefsPresenter.class.getName();

    /* renamed from: l  reason: collision with root package name */
    private final d f35153l;

    public interface a {
        void D();

        void E0();

        void U0();

        void Z(com.coffeemeetsbagel.match_prefs.f fVar, boolean z10);

        void e0();

        void v1(String str);
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35154a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35155b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f35156c;

        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|28|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|(2:29|30)|31|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x006b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ac */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b4 */
        static {
            /*
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type[] r0 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r2 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.SECTION_HEADER_BASIC     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r3 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.AGE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r4 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.DISTANCE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r5 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.ETHNICITY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r6 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.GENDER     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r7 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.HEIGHT_IMPERIAL     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r7 = 7
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r8 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.HEIGHT_METRIC     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r8 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.RELIGION     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r9 = 8
                r0[r8] = r9     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.coffeemeetsbagel.match_prefs.MatchPreference$Type r8 = com.coffeemeetsbagel.match_prefs.MatchPreference$Type.SECTION_HEADER_PREMIUM     // Catch:{ NoSuchFieldError -> 0x005a }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r9 = 9
                r0[r8] = r9     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                f35154a = r0
                com.coffeemeetsbagel.models.entities.GenderType[] r0 = com.coffeemeetsbagel.models.entities.GenderType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.entities.GenderType r8 = com.coffeemeetsbagel.models.entities.GenderType.FEMALE     // Catch:{ NoSuchFieldError -> 0x006b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x006b }
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x006b }
            L_0x006b:
                com.coffeemeetsbagel.models.entities.GenderType r8 = com.coffeemeetsbagel.models.entities.GenderType.MALE     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r8] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.coffeemeetsbagel.models.entities.GenderType r8 = com.coffeemeetsbagel.models.entities.GenderType.BISEXUAL     // Catch:{ NoSuchFieldError -> 0x007b }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r8] = r3     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                f35155b = r0
                com.coffeemeetsbagel.models.enums.QuestionType[] r0 = com.coffeemeetsbagel.models.enums.QuestionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionType r8 = com.coffeemeetsbagel.models.enums.QuestionType.TEXT     // Catch:{ NoSuchFieldError -> 0x008c }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.SINGLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.MULTIPLE_CHOICE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.INTEGER     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00ac }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ac }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00ac }
            L_0x00ac:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.NUMERIC     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.coffeemeetsbagel.models.enums.QuestionType r1 = com.coffeemeetsbagel.models.enums.QuestionType.RANGE     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                f35156c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.MatchPrefsPresenter.b.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MatchPrefsPresenter(ViewGroup viewGroup, a aVar, boolean z10) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(aVar, "listener");
        this.f35147e = aVar;
        this.f35148f = z10;
        this.f35149g = b.b(new MatchPrefsPresenter$genderRequirementError$2(viewGroup));
        this.f35150h = b.b(new MatchPrefsPresenter$serverError$2(viewGroup));
        this.f35151j = b.b(new MatchPrefsPresenter$progressDialog$2(viewGroup));
        Resources resources = viewGroup.getResources();
        j.f(resources, "view.resources");
        this.f35153l = new d(resources);
    }

    /* access modifiers changed from: private */
    public static final void C(MatchPrefsPresenter matchPrefsPresenter, com.coffeemeetsbagel.match_prefs.f fVar, boolean z10, View view) {
        j.g(matchPrefsPresenter, "this$0");
        j.g(fVar, "$preference");
        matchPrefsPresenter.f35147e.Z(fVar, z10);
    }

    /* access modifiers changed from: private */
    public static final void D(MatchPrefsPresenter matchPrefsPresenter, View view) {
        j.g(matchPrefsPresenter, "this$0");
        matchPrefsPresenter.f35147e.D();
    }

    private final void E(TableRow tableRow, boolean z10, boolean z11) {
        View childAt = tableRow.getChildAt(1);
        j.e(childAt, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) childAt;
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, e.a.b(tableRow.getContext(), R.drawable.ic_lock), (Drawable) null);
            textView.setText((CharSequence) null);
        }
        if (z10) {
            textView.setText(tableRow.getContext().getText(R.string.match_prefs_dealbreaker));
        }
    }

    private final void F(TableRow tableRow, String str) {
        boolean z10 = false;
        tableRow.setVisibility(0);
        View childAt = tableRow.getChildAt(0);
        j.e(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt2 = ((ViewGroup) childAt).getChildAt(1);
        j.e(childAt2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) childAt2;
        if (str == null || str.length() == 0) {
            z10 = true;
        }
        if (!z10) {
            textView.setText(str);
        } else {
            textView.setText(tableRow.getContext().getString(R.string.match_prefs_open));
        }
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [android.view.View, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void G(ja.b r5, com.coffeemeetsbagel.match_prefs.f r6, boolean r7, android.view.ViewGroup r8, boolean r9) {
        /*
            r4 = this;
            com.coffeemeetsbagel.qna.QuestionWAnswers r0 = r6.a()
            if (r0 == 0) goto L_0x0149
            com.coffeemeetsbagel.models.dto.Question r0 = r0.e()
            if (r0 == 0) goto L_0x0149
            V r1 = r4.f7869c
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.content.Context r1 = r1.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            java.lang.String r2 = "from(view.context)"
            kotlin.jvm.internal.j.f(r1, r2)
            java.lang.String r2 = r0.getId()
            android.view.View r2 = r8.findViewWithTag(r2)
            android.widget.TableRow r2 = (android.widget.TableRow) r2
            r3 = 0
            if (r2 != 0) goto L_0x0060
            r2 = 2131492963(0x7f0c0063, float:1.8609393E38)
            android.view.View r1 = r1.inflate(r2, r8, r3)
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TableRow"
            kotlin.jvm.internal.j.e(r1, r2)
            r2 = r1
            android.widget.TableRow r2 = (android.widget.TableRow) r2
            java.lang.String r1 = r0.getId()
            r2.setTag(r1)
            r8.addView(r2)
            android.view.View r8 = r2.getChildAt(r3)
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup"
            kotlin.jvm.internal.j.e(r8, r1)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            android.view.View r8 = r8.getChildAt(r3)
            java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
            kotlin.jvm.internal.j.e(r8, r1)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r0 = r0.getLabel()
            r8.setText(r0)
        L_0x0060:
            com.coffeemeetsbagel.new_user_experience.match_prefs.z r8 = new com.coffeemeetsbagel.new_user_experience.match_prefs.z
            r8.<init>(r4, r6)
            r2.setOnClickListener(r8)
            r8 = 1
            r0 = 0
            if (r9 == 0) goto L_0x007f
            com.coffeemeetsbagel.qna.QuestionWAnswers r9 = r6.a()
            if (r9 == 0) goto L_0x007a
            boolean r5 = r5.x()
            java.lang.String r0 = r4.q(r9, r5)
        L_0x007a:
            r4.F(r2, r0)
            goto L_0x0120
        L_0x007f:
            com.coffeemeetsbagel.match_prefs.MatchPreference$Type r9 = r6.b()
            int[] r1 = com.coffeemeetsbagel.new_user_experience.match_prefs.MatchPrefsPresenter.b.f35154a
            int r9 = r9.ordinal()
            r9 = r1[r9]
            switch(r9) {
                case 2: goto L_0x0119;
                case 3: goto L_0x0114;
                case 4: goto L_0x010b;
                case 5: goto L_0x00aa;
                case 6: goto L_0x00a4;
                case 7: goto L_0x00a4;
                case 8: goto L_0x009a;
                default: goto L_0x008e;
            }
        L_0x008e:
            com.coffeemeetsbagel.qna.QuestionWAnswers r5 = r6.a()
            if (r5 == 0) goto L_0x011d
            java.lang.String r0 = r(r4, r5, r3, r8, r0)
            goto L_0x011d
        L_0x009a:
            ja.a r5 = r5.q()
            java.lang.String r0 = r5.m()
            goto L_0x011d
        L_0x00a4:
            java.lang.String r0 = r4.v(r5)
            goto L_0x011d
        L_0x00aa:
            ja.a r5 = r5.q()
            java.lang.String r5 = r5.d()
            if (r5 == 0) goto L_0x011d
            com.coffeemeetsbagel.models.entities.GenderType$Companion r9 = com.coffeemeetsbagel.models.entities.GenderType.Companion
            com.coffeemeetsbagel.models.entities.GenderType r5 = r9.fromApiKey(r5)
            int[] r9 = com.coffeemeetsbagel.new_user_experience.match_prefs.MatchPrefsPresenter.b.f35155b
            int r5 = r5.ordinal()
            r5 = r9[r5]
            if (r5 == r8) goto L_0x00fa
            r9 = 2
            if (r5 == r9) goto L_0x00ea
            r9 = 3
            if (r5 == r9) goto L_0x00da
            V r5 = r4.f7869c
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131887147(0x7f12042b, float:1.9408893E38)
            java.lang.String r5 = r5.getString(r9)
            goto L_0x0109
        L_0x00da:
            V r5 = r4.f7869c
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131886722(0x7f120282, float:1.940803E38)
            java.lang.String r5 = r5.getString(r9)
            goto L_0x0109
        L_0x00ea:
            V r5 = r4.f7869c
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131886723(0x7f120283, float:1.9408033E38)
            java.lang.String r5 = r5.getString(r9)
            goto L_0x0109
        L_0x00fa:
            V r5 = r4.f7869c
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.content.res.Resources r5 = r5.getResources()
            r9 = 2131886724(0x7f120284, float:1.9408035E38)
            java.lang.String r5 = r5.getString(r9)
        L_0x0109:
            r0 = r5
            goto L_0x011d
        L_0x010b:
            ja.a r5 = r5.q()
            java.lang.String r0 = r5.c()
            goto L_0x011d
        L_0x0114:
            java.lang.String r0 = r4.u(r5)
            goto L_0x011d
        L_0x0119:
            java.lang.String r0 = r4.t(r5)
        L_0x011d:
            r4.F(r2, r0)
        L_0x0120:
            com.coffeemeetsbagel.qna.QuestionWAnswers r5 = r6.a()
            if (r5 == 0) goto L_0x013f
            java.util.List r5 = r5.d()
            if (r5 == 0) goto L_0x013f
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.P(r5)
            com.coffeemeetsbagel.models.dto.Answer r5 = (com.coffeemeetsbagel.models.dto.Answer) r5
            if (r5 == 0) goto L_0x013f
            java.lang.Boolean r5 = r5.isDealbreaker()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.j.b(r5, r6)
            goto L_0x0140
        L_0x013f:
            r5 = r3
        L_0x0140:
            if (r5 == 0) goto L_0x0145
            if (r7 == 0) goto L_0x0145
            goto L_0x0146
        L_0x0145:
            r8 = r3
        L_0x0146:
            r4.E(r2, r8, r3)
        L_0x0149:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.match_prefs.MatchPrefsPresenter.G(ja.b, com.coffeemeetsbagel.match_prefs.f, boolean, android.view.ViewGroup, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final void H(MatchPrefsPresenter matchPrefsPresenter, com.coffeemeetsbagel.match_prefs.f fVar, View view) {
        j.g(matchPrefsPresenter, "this$0");
        j.g(fVar, "$preference");
        matchPrefsPresenter.f35147e.Z(fVar, false);
    }

    /* access modifiers changed from: private */
    public static final void J(MatchPrefsPresenter matchPrefsPresenter, View view) {
        j.g(matchPrefsPresenter, "this$0");
        matchPrefsPresenter.f35147e.E0();
    }

    /* access modifiers changed from: private */
    public static final void K(MatchPrefsPresenter matchPrefsPresenter, String str, View view) {
        j.g(matchPrefsPresenter, "this$0");
        j.g(str, "$questionText");
        matchPrefsPresenter.f35147e.v1(str);
    }

    /* access modifiers changed from: private */
    public static final void N(MatchPrefsPresenter matchPrefsPresenter, View view) {
        j.g(matchPrefsPresenter, "this$0");
        matchPrefsPresenter.f35147e.U0();
    }

    /* access modifiers changed from: private */
    public static final void O(MatchPrefsPresenter matchPrefsPresenter, View view) {
        j.g(matchPrefsPresenter, "this$0");
        matchPrefsPresenter.f35147e.e0();
    }

    private final void P(ViewGroup viewGroup, boolean z10) {
        ((ViewGroup) this.f7869c).removeAllViews();
        if (z10) {
            x1.p.e(new k((ViewGroup) this.f7869c, viewGroup), new m(8388613));
        } else {
            ((ViewGroup) this.f7869c).addView(viewGroup);
        }
    }

    private final void Q(ViewGroup viewGroup) {
        ((ViewGroup) this.f7869c).removeAllViews();
        x1.p.e(new k((ViewGroup) this.f7869c, viewGroup), new m(8388611));
    }

    private final String q(QuestionWAnswers questionWAnswers, boolean z10) {
        String str;
        Integer integerValue;
        Float floatValue;
        Integer num;
        Integer num2;
        int i10;
        Float maxValue;
        Float minValue;
        Integer num3 = null;
        if (questionWAnswers.d().isEmpty()) {
            return null;
        }
        switch (b.f35156c[questionWAnswers.e().getType().ordinal()]) {
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
                Answer answer2 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer2 == null || (floatValue = answer2.getFloatValue()) == null) {
                    return null;
                }
                return floatValue.toString();
            case 6:
                Answer answer3 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer3 != null) {
                    num = answer3.getIntegerValue();
                } else {
                    num = null;
                }
                if (j.b(questionWAnswers.e().getName(), MatchPreferenceQuestions.DISTANCE.b()) && num != null) {
                    return this.f35153l.a(z10, num.intValue(), true);
                }
                if (num != null) {
                    return num.toString();
                }
                return null;
            case 7:
                if (j.b(questionWAnswers.e().getName(), MatchPreferenceQuestions.HEIGHT.b())) {
                    Context context = ((ViewGroup) this.f7869c).getContext();
                    Answer answer4 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                    int i11 = 0;
                    if (answer4 == null || (minValue = answer4.getMinValue()) == null) {
                        i10 = 0;
                    } else {
                        i10 = (int) minValue.floatValue();
                    }
                    Answer answer5 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                    if (!(answer5 == null || (maxValue = answer5.getMaxValue()) == null)) {
                        i11 = (int) maxValue.floatValue();
                    }
                    return g.b(context, z10, i10, i11);
                }
                Answer answer6 = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
                if (answer6 == null) {
                    return null;
                }
                Float minValue2 = answer6.getMinValue();
                if (minValue2 != null) {
                    num2 = Integer.valueOf((int) minValue2.floatValue());
                } else {
                    num2 = null;
                }
                Float maxValue2 = answer6.getMaxValue();
                if (maxValue2 != null) {
                    num3 = Integer.valueOf((int) maxValue2.floatValue());
                }
                return num2 + " - " + num3;
            default:
                return null;
        }
    }

    static /* synthetic */ String r(MatchPrefsPresenter matchPrefsPresenter, QuestionWAnswers questionWAnswers, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return matchPrefsPresenter.q(questionWAnswers, z10);
    }

    private final String t(ja.b bVar) {
        int i10;
        String string = ((ViewGroup) this.f7869c).getResources().getString(R.string.match_prefs_range_divider);
        j.f(string, "view.resources.getString…atch_prefs_range_divider)");
        Integer a10 = bVar.q().a();
        int i11 = 0;
        if (a10 != null) {
            i10 = a10.intValue();
        } else {
            i10 = 0;
        }
        if (i10 <= 0) {
            return "";
        }
        Object[] objArr = new Object[3];
        objArr[0] = bVar.q().a();
        objArr[1] = string;
        Integer b10 = bVar.q().b();
        if (b10 != null) {
            i11 = b10.intValue();
        }
        objArr[2] = Integer.valueOf(i11);
        String format2 = String.format("%s %s %s", Arrays.copyOf(objArr, 3));
        j.f(format2, "format(this, *args)");
        return format2;
    }

    private final String u(ja.b bVar) {
        if (bVar.x() && bVar.q().k() > 0) {
            return this.f35153l.a(true, bVar.q().k(), true);
        }
        if (bVar.q().l() > 0) {
            return this.f35153l.a(bVar.x(), bVar.q().l(), false);
        }
        return "";
    }

    private final String v(ja.b bVar) {
        int i10;
        Integer e10 = bVar.q().e();
        int i11 = 0;
        if (e10 != null) {
            i10 = e10.intValue();
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            Integer f10 = bVar.q().f();
            if (f10 != null) {
                i11 = f10.intValue();
            }
            if (i11 != 0) {
                Context context = ((ViewGroup) this.f7869c).getContext();
                boolean x10 = bVar.x();
                Integer e11 = bVar.q().e();
                j.d(e11);
                int intValue = e11.intValue();
                Integer f11 = bVar.q().f();
                j.d(f11);
                return g.b(context, x10, intValue, f11.intValue());
            }
        }
        return null;
    }

    private final h y() {
        return (h) this.f35151j.getValue();
    }

    public final void A(List<com.coffeemeetsbagel.match_prefs.f> list, ja.b bVar, boolean z10, boolean z11) {
        j.g(list, "list");
        j.g(bVar, "user");
        TableLayout tableLayout = (TableLayout) ((ViewGroup) this.f7869c).findViewById(R.id.summary_table);
        if (tableLayout != null) {
            for (com.coffeemeetsbagel.match_prefs.f fVar : list) {
                if (b.f35154a[fVar.b().ordinal()] != 1) {
                    G(bVar, fVar, z10, tableLayout, z11);
                }
            }
        }
    }

    public final void B(List<com.coffeemeetsbagel.match_prefs.f> list, ja.b bVar, boolean z10, boolean z11) {
        Question e10;
        boolean z12;
        List<Answer> d10;
        Answer answer;
        j.g(list, "list");
        j.g(bVar, "user");
        TableLayout tableLayout = (TableLayout) ((ViewGroup) this.f7869c).findViewById(R.id.summary_table_premium);
        if (tableLayout != null) {
            LayoutInflater from = LayoutInflater.from(((ViewGroup) this.f7869c).getContext());
            j.f(from, "from(view.context)");
            for (com.coffeemeetsbagel.match_prefs.f fVar : list) {
                boolean z13 = false;
                String str = null;
                if (b.f35154a[fVar.b().ordinal()] == 9) {
                    TextView textView = (TextView) tableLayout.findViewById(R.id.section_header_premium);
                    TextView textView2 = (TextView) tableLayout.findViewById(R.id.cta_upsell);
                    if (z10) {
                        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        lc.m mVar = lc.m.f41114a;
                        Context context = ((ViewGroup) this.f7869c).getContext();
                        j.f(context, "view.context");
                        textView.setCompoundDrawablePadding(mVar.a(context, 8.0f));
                        textView2.setVisibility(0);
                        textView2.setOnClickListener(new c0(this));
                    } else {
                        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                        textView2.setVisibility(8);
                    }
                } else {
                    QuestionWAnswers a10 = fVar.a();
                    if (!(a10 == null || (e10 = a10.e()) == null)) {
                        TableRow tableRow = (TableRow) tableLayout.findViewWithTag(e10.getId());
                        if (tableRow == null) {
                            View inflate = from.inflate(R.layout.component_onboarding_vertical_list_row, tableLayout, false);
                            j.e(inflate, "null cannot be cast to non-null type android.widget.TableRow");
                            tableRow = (TableRow) inflate;
                            tableRow.setTag(e10.getId());
                            tableLayout.addView(tableRow);
                            View childAt = tableRow.getChildAt(0);
                            j.e(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                            j.e(childAt2, "null cannot be cast to non-null type android.widget.TextView");
                            ((TextView) childAt2).setText(e10.getLabel());
                        }
                        tableRow.setOnClickListener(new d0(this, fVar, z10));
                        QuestionWAnswers a11 = fVar.a();
                        if (a11 != null) {
                            str = q(a11, bVar.x());
                        }
                        F(tableRow, str);
                        QuestionWAnswers a12 = fVar.a();
                        if (a12 == null || (d10 = a12.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.P(d10)) == null) {
                            z12 = false;
                        } else {
                            z12 = j.b(answer.isDealbreaker(), Boolean.TRUE);
                        }
                        if (z12 && z11) {
                            z13 = true;
                        }
                        E(tableRow, z13, z10);
                    }
                }
            }
        }
    }

    public final void I(ViewGroup viewGroup, String str) {
        j.g(viewGroup, "childView");
        j.g(str, "questionText");
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_match_preferences_template, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        ((ScrollView) viewGroup2.findViewById(R.id.content_container)).addView(viewGroup);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.onboarding_back_button);
        imageView.setOnClickListener(new e0(this));
        imageView.setVisibility(0);
        ((CmbButton) viewGroup2.findViewById(R.id.primary_cta)).setOnClickListener(new f0(this, str));
        P(viewGroup2, true);
    }

    public final void L(boolean z10) {
        if (z10) {
            y().show();
        } else {
            y().hide();
        }
    }

    public final void M(boolean z10) {
        int i10;
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_onboarding_match_prefs, (ViewGroup) this.f7869c, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        View findViewById = viewGroup.findViewById(R.id.next_button);
        if (this.f35148f) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        findViewById.setVisibility(i10);
        findViewById.setOnClickListener(new a0(this));
        View findViewById2 = viewGroup.findViewById(R.id.onboarding_back_button);
        findViewById2.setOnClickListener(new b0(this));
        findViewById2.setVisibility(0);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        if (textView != null) {
            textView.setText(t9.a.onboardingDealbreakersHeader);
        }
        if (z10) {
            P(viewGroup, false);
        } else {
            Q(viewGroup);
        }
    }

    public final String w() {
        return (String) this.f35149g.getValue();
    }

    public final String z() {
        return (String) this.f35150h.getValue();
    }
}
