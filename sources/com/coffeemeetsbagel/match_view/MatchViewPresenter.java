package com.coffeemeetsbagel.match_view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.ChipSelectQuestionDialog;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.MatchContext;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ActivityReportViewedState;
import com.coffeemeetsbagel.profile.ProfileView;
import com.coffeemeetsbagel.profile.m;
import com.coffeemeetsbagel.qna.GetGroupOptionsRemainingUseCase;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.google.firebase.database.core.ValidationPath;
import com.mparticle.kits.ReportingMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import lc.x;
import qj.q;
import y6.n;

public final class MatchViewPresenter extends p<ProfileView> {

    /* renamed from: l  reason: collision with root package name */
    public static final a f34643l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34644e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f34645f;

    /* renamed from: g  reason: collision with root package name */
    private final d f34646g = new d();

    /* renamed from: h  reason: collision with root package name */
    private int f34647h;

    /* renamed from: j  reason: collision with root package name */
    private final String f34648j = "ic_heart_with_checkmark_purple";
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ChipSelectQuestionDialog f34649k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void G0(boolean z10);

        void K(boolean z10);

        void K0();

        void Q0();

        void S(Bagel.STAMP stamp);

        void S0();

        void b(String str);

        void c();

        void c1();

        void m0(int i10);

        void q0();

        void u();

        void w(QuestionGroupType questionGroupType);
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34650a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34651b;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                com.coffeemeetsbagel.profile.ActivityReportViewedState[] r0 = com.coffeemeetsbagel.profile.ActivityReportViewedState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.coffeemeetsbagel.profile.ActivityReportViewedState r2 = com.coffeemeetsbagel.profile.ActivityReportViewedState.VIEWED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.coffeemeetsbagel.profile.ActivityReportViewedState r3 = com.coffeemeetsbagel.profile.ActivityReportViewedState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f34650a = r0
                com.coffeemeetsbagel.models.enums.QuestionGroupType[] r0 = com.coffeemeetsbagel.models.enums.QuestionGroupType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionGroupType r3 = com.coffeemeetsbagel.models.enums.QuestionGroupType.INTERESTS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.VALUES     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.PERSONALITY     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                f34651b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.match_view.MatchViewPresenter.c.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MatchViewPresenter(ProfileView profileView, boolean z10, b bVar) {
        super(profileView);
        j.g(profileView, "view");
        j.g(bVar, "listener");
        this.f34644e = z10;
        this.f34645f = bVar;
    }

    /* access modifiers changed from: private */
    public final void K(boolean z10) {
        this.f34645f.K(z10);
    }

    /* access modifiers changed from: private */
    public static final void L(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void M(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void N(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void O(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void P0(int i10, int i11, int i12, Function0<Unit> function0) {
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        Context context = ((ProfileView) this.f7869c).getContext();
        j.f(context, "view.context");
        DialogPrimarySecondaryVertical.a.c(aVar, context, DialogPrimarySecondaryVertical.PrimaryCtaStyle.DESTRUCTIVE, Integer.valueOf(i10), i11, i12, R.string.continue_lc, function0, Integer.valueOf(R.string.cancel), (Function0) null, (Function0) null, ValidationPath.MAX_PATH_LENGTH_BYTES, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void Q(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R0(View view, View view2) {
        j.g(view2, ReportingMessage.MessageType.SCREEN_VIEW);
        view.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void S(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void U(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void V(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void W(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void X(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Y(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final int Z(int i10) {
        if (i10 > 0) {
            switch (i10) {
                case 1:
                    return R.drawable.woo_flower_dls01;
                case 2:
                    return R.drawable.woo_flower_dls02;
                case 3:
                    break;
                case 4:
                    return R.drawable.woo_flower_dls04;
                case 5:
                    return R.drawable.woo_flower_dls05;
                case 6:
                    return R.drawable.woo_flower_dls06;
                case 7:
                    return R.drawable.woo_flower_dls07;
                case 8:
                    return R.drawable.woo_flower_dls08;
                case 9:
                    return R.drawable.woo_flower_dls09;
                case 10:
                    return R.drawable.woo_flower_dls10;
                case 11:
                    return R.drawable.woo_flower_dls11;
                default:
                    return R.drawable.woo_flower_dls12;
            }
        }
        return R.drawable.woo_flower_dls03;
    }

    private final String a0(int i10) {
        if (i10 <= 0) {
            String string = ((ProfileView) this.f7869c).getContext().getString(R.string.they_sent_flowers);
            j.f(string, "{\n            view.conte…y_sent_flowers)\n        }");
            return string;
        }
        String quantityString = ((ProfileView) this.f7869c).getContext().getResources().getQuantityString(R.plurals.they_sent_you_flower, i10, new Object[]{Integer.valueOf(i10)});
        j.f(quantityString, "{\n            view.conte…d\n            )\n        }");
        return quantityString;
    }

    /* access modifiers changed from: private */
    public static final void b1(MatchViewPresenter matchViewPresenter, View view) {
        j.g(matchViewPresenter, "this$0");
        matchViewPresenter.f34645f.S0();
    }

    /* access modifiers changed from: private */
    public final void c0(Bagel.STAMP stamp) {
        this.f34645f.S(stamp);
    }

    /* access modifiers changed from: private */
    public final void d0(ActivityReportViewedState activityReportViewedState) {
        int i10 = c.f34650a[activityReportViewedState.ordinal()];
        if (i10 == 1) {
            this.f34645f.q0();
        } else if (i10 == 2) {
            this.f34645f.u();
        }
    }

    public final void A0() {
        ((ProfileView) this.f7869c).f0();
    }

    public final void B0() {
        ((ProfileView) this.f7869c).g0();
    }

    public final void C0() {
        ((ProfileView) this.f7869c).h0();
    }

    public final void D0() {
        ((ProfileView) this.f7869c).i0();
    }

    public final void E0() {
        V v10 = this.f7869c;
        ((ProfileView) v10).s0(((ProfileView) v10).getContext().getString(R.string.like_indicator_undeclared_boosted));
    }

    public final void F0(String str) {
        j.g(str, "text");
        ((ProfileView) this.f7869c).u();
        String string = ((ProfileView) g()).getResources().getString(R.string.sent_a_message);
        o oVar = o.f32141a;
        String string2 = ((ProfileView) g()).getResources().getString(R.string.like_comment_with_quotations);
        j.f(string2, "getView().resources.getS…_comment_with_quotations)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
        j.f(format2, "format(format, *args)");
        ((ProfileView) this.f7869c).j0(string, format2);
    }

    public final void G0() {
        CommonInterestDialog commonInterestDialog = CommonInterestDialog.f34595a;
        Context context = ((ProfileView) g()).getContext();
        j.f(context, "getView().context");
        commonInterestDialog.a(context);
    }

    public final void H0() {
        ((ProfileView) this.f7869c).k0();
    }

    public final void I0(MatchContext matchContext) {
        j.g(matchContext, "matchContext");
        if (!((ProfileView) this.f7869c).F()) {
            ((ProfileView) this.f7869c).l0(matchContext.getIcon(), matchContext.getTitle(), matchContext.getBody());
        }
    }

    public final void J0(List<m> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ((ProfileView) this.f7869c).m0(list);
        } else {
            ((ProfileView) this.f7869c).v();
        }
    }

    public final void K0(String str, QuestionGroupType questionGroupType, com.coffeemeetsbagel.qna.j jVar, SaveAnswerUseCase saveAnswerUseCase, GetGroupOptionsRemainingUseCase getGroupOptionsRemainingUseCase) {
        int i10;
        int i11;
        int i12;
        j.g(str, "profileId");
        j.g(questionGroupType, "questionGroupType");
        j.g(jVar, "getQuestionsUseCase");
        j.g(saveAnswerUseCase, "saveAnswerUseCase");
        j.g(getGroupOptionsRemainingUseCase, "getCounterUseCase");
        ChipSelectQuestionDialog chipSelectQuestionDialog = this.f34649k;
        if (chipSelectQuestionDialog != null) {
            chipSelectQuestionDialog.dismiss();
        }
        MatchViewPresenter$showEditAnswerDialog$primaryClickListener$1 matchViewPresenter$showEditAnswerDialog$primaryClickListener$1 = new MatchViewPresenter$showEditAnswerDialog$primaryClickListener$1(this, str, questionGroupType, jVar, saveAnswerUseCase);
        int i13 = c.f34651b[questionGroupType.ordinal()];
        if (i13 == 1) {
            i12 = R.string.profile_interest_edit_title;
            i11 = R.string.profile_interest_edit_body;
            i10 = R.string.profile_interest_primary_cta;
        } else if (i13 == 2) {
            i12 = R.string.values_edit_title;
            i11 = R.string.profile_values_edit_body;
            i10 = R.string.profile_values_primary_cta;
        } else if (i13 == 3) {
            i12 = R.string.personality_edit_title;
            i11 = R.string.profile_personality_edit_body;
            i10 = R.string.profile_personality_primary_cta;
        } else {
            return;
        }
        int i14 = i11;
        int i15 = i10;
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        Context context = ((ProfileView) g()).getContext();
        j.f(context, "getView().context");
        DialogPrimarySecondaryVertical.a.c(aVar, context, DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, i12, i14, i15, matchViewPresenter$showEditAnswerDialog$primaryClickListener$1, Integer.valueOf(R.string.profile_answer_secondary_cta), (Function0) null, (Function0) null, 772, (Object) null);
    }

    public final void L0() {
        ((ProfileView) this.f7869c).n0();
    }

    public final void M0(int i10) {
        int Z = Z(j.g(i10, 12));
        ((ProfileView) this.f7869c).z0(a0(i10), Z);
    }

    public final void N0(boolean z10) {
        ((ProfileView) this.f7869c).findViewById(R.id.focus_shadow).setVisibility(z10 ? 0 : 8);
    }

    public final void O0() {
        ((ProfileView) this.f7869c).w0();
    }

    public final void Q0() {
        View findViewById = ((ProfileView) this.f7869c).findViewById(R.id.instant_like_sender_stamp);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new k0(findViewById));
        ((TextView) ((ProfileView) this.f7869c).findViewById(R.id.text_instant_like)).setText(((ProfileView) this.f7869c).getResources().getString(R.string.instant_like_they_sent));
        ((ProfileView) this.f7869c).findViewById(R.id.cta_close_instant_like_overly).setVisibility(0);
    }

    public final void S0() {
        ((ProfileView) this.f7869c).findViewById(R.id.instant_like_sender_stamp).setVisibility(0);
        ((TextView) ((ProfileView) this.f7869c).findViewById(R.id.text_instant_like)).setText(((ProfileView) this.f7869c).getResources().getString(R.string.instant_like_sent));
    }

    public final void T0(List<m> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ((ProfileView) this.f7869c).o0(list);
        } else {
            ((ProfileView) this.f7869c).y();
        }
    }

    public final void U0(boolean z10, boolean z11) {
        ((ProfileView) this.f7869c).p0(z10, z11);
    }

    public final void V0() {
        V v10 = this.f7869c;
        ((ProfileView) v10).s0(((ProfileView) v10).getContext().getString(R.string.like_indicator_undeclared));
    }

    public final void W0() {
        ((ProfileView) this.f7869c).q0();
    }

    public final void X0(List<m> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ((ProfileView) this.f7869c).r0(list);
        } else {
            ((ProfileView) this.f7869c).z();
        }
    }

    public final void Y0() {
        TextView textView = (TextView) ((ProfileView) this.f7869c).findViewById(R.id.profile_photo_bottom_text);
        textView.setText(((ProfileView) this.f7869c).getResources().getString(R.string.instant_like_they_sent));
        ((ProfileView) this.f7869c).findViewById(R.id.profile_photo_bottom_container).setVisibility(0);
        x xVar = x.f41117a;
        j.f(textView, "textView");
        xVar.a(textView, Integer.valueOf(R.drawable.ic_star), R.color.white, 16);
    }

    public final void Z0(boolean z10) {
        if (z10) {
            ((ProfileView) this.f7869c).findViewById(R.id.cta_add_new_prompt).setVisibility(0);
            ((ProfileView) this.f7869c).findViewById(R.id.add_prompt_button).setOnClickListener(new j0(this));
            return;
        }
        ((ProfileView) this.f7869c).findViewById(R.id.cta_add_new_prompt).setVisibility(8);
    }

    public final int b0() {
        return ((ProfileView) this.f7869c).getPhotoPosition();
    }

    public final void c1() {
        ((ProfileView) this.f7869c).u0();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        RecyclerView recyclerView = (RecyclerView) ((ProfileView) this.f7869c).findViewById(R.id.dynamic_label_values);
        recyclerView.setItemAnimator((RecyclerView.l) null);
        recyclerView.setAdapter(this.f34646g);
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).o().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new e0(new MatchViewPresenter$didLoad$2(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).m().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new p0(new MatchViewPresenter$didLoad$3(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).n().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new q0(new MatchViewPresenter$didLoad$4(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).B0().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new r0(new MatchViewPresenter$didLoad$5(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).l().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s0(new MatchViewPresenter$didLoad$6(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).Q().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new t0(new MatchViewPresenter$didLoad$7(this)));
        if (this.f34644e) {
            ((com.uber.autodispose.p) ((ProfileView) this.f7869c).P().g(com.uber.autodispose.a.a(this))).c(new f0(new MatchViewPresenter$didLoad$8(this)));
            ((com.uber.autodispose.p) ((ProfileView) this.f7869c).p().g(com.uber.autodispose.a.a(this))).c(new g0(new MatchViewPresenter$didLoad$9(this)));
        } else {
            ((com.uber.autodispose.p) ((ProfileView) this.f7869c).P().g(com.uber.autodispose.a.a(this))).c(new h0(new MatchViewPresenter$didLoad$10(this)));
            ((com.uber.autodispose.p) ((ProfileView) this.f7869c).p().g(com.uber.autodispose.a.a(this))).c(new i0(new MatchViewPresenter$didLoad$11(this)));
        }
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).k().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l0(new MatchViewPresenter$didLoad$12(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).r().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new m0(new MatchViewPresenter$didLoad$13(this)));
        ((com.uber.autodispose.p) ((ProfileView) this.f7869c).q().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new n0(new MatchViewPresenter$didLoad$14(this)));
        ((com.uber.autodispose.p) q.Y(((ProfileView) g()).R(), ((ProfileView) g()).G()).p0(1000, TimeUnit.MILLISECONDS).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new o0(new MatchViewPresenter$didLoad$15(this)));
    }

    public final void d1() {
        ((ProfileView) this.f7869c).x0();
    }

    public final void e0() {
        ((ProfileView) g()).t();
    }

    public final void e1(List<m> list) {
        boolean z10;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            ((ProfileView) this.f7869c).y0(list);
        } else {
            ((ProfileView) this.f7869c).E();
        }
    }

    public final void f0() {
        ((ProfileView) g()).w();
    }

    public final void f1(int i10) {
        ((ProfileView) this.f7869c).A0(i10 > 99 ? "99+" : String.valueOf(i10));
    }

    public final void g0() {
        ((ProfileView) g()).x();
    }

    public final void g1() {
        V v10 = this.f7869c;
        ((ProfileView) v10).l0(this.f34648j, ((ProfileView) v10).getContext().getString(R.string.likes_you_your_type), ((ProfileView) this.f7869c).getContext().getString(R.string.likes_you_your_type_message));
    }

    public final void h0() {
        ((ProfileView) this.f7869c).A();
    }

    public final void h1() {
        ((TextView) ((ProfileView) this.f7869c).findViewById(R.id.activity_report_title)).setText(((ProfileView) this.f7869c).getResources().getString(R.string.activity_reports_title_mine));
    }

    public final void i0() {
        ((ProfileView) this.f7869c).C();
    }

    public final void j0() {
        ((ProfileView) this.f7869c).D();
    }

    public final void k0(List<Pair<String, String>> list) {
        j.g(list, ProfileConstants.Field.QUESTIONS);
        this.f34646g.J(list);
    }

    public final void l0(String str) {
        j.g(str, "ageAndLocationString");
        ((ProfileView) g()).setAgeAndLocation(str);
    }

    public final void m0(String str) {
        j.g(str, "educationString");
        ((ProfileView) g()).setEducationHeader(str);
    }

    public final void n0(String str) {
        j.g(str, "employerString");
        ((ProfileView) g()).setEmployerHeader(str);
    }

    public final void o0(List<Photo> list) {
        j.g(list, "photos");
        ArrayList arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            ((ProfileView) g()).setMediaItems(arrayList);
            ((ProfileView) g()).setPhotoPagerToPosition(this.f34647h);
            return;
        }
        ((ProfileView) g()).B();
    }

    public final void p0(int i10) {
        this.f34647h = i10;
        ((ProfileView) this.f7869c).setPhotoPagerToPosition(i10);
    }

    public final void q0() {
        ((ProfileView) this.f7869c).W();
    }

    public final void r0(float f10) {
        ((ProfileView) this.f7869c).X(f10, true, n.b(((ProfileView) this.f7869c).getContext(), f10));
    }

    public final void s0(float f10) {
        o oVar = o.f32141a;
        String string = ((ProfileView) this.f7869c).getContext().getResources().getString(R.string.percent_of_time);
        j.f(string, "view.context.resources.g…R.string.percent_of_time)");
        String format2 = String.format(string, Arrays.copyOf(new Object[]{n.a(f10)}, 1));
        j.f(format2, "format(format, *args)");
        ((ProfileView) this.f7869c).Y(f10, true, format2);
    }

    public final void t0(float f10) {
        o oVar = o.f32141a;
        String string = ((ProfileView) this.f7869c).getContext().getResources().getString(R.string.percent_of_time);
        j.f(string, "view.context.resources.g…R.string.percent_of_time)");
        String format2 = String.format(string, Arrays.copyOf(new Object[]{n.a(f10)}, 1));
        j.f(format2, "format(format, *args)");
        ((ProfileView) this.f7869c).Z(true, format2);
    }

    public final void u0(boolean z10) {
        int i10;
        Resources resources = ((ProfileView) this.f7869c).getContext().getResources();
        if (z10) {
            i10 = R.string.yes_regular;
        } else {
            i10 = R.string.no_regular;
        }
        String string = resources.getString(i10);
        j.f(string, "if (hasLoggedInRecently)….no_regular\n            )");
        ((ProfileView) this.f7869c).a0(z10, true, string);
    }

    public final void v0() {
        ((ProfileView) this.f7869c).b0();
    }

    public final void w0() {
        ((ProfileView) this.f7869c).c0();
    }

    public final void y0() {
        ((ProfileView) this.f7869c).d0();
    }

    public final void z0() {
        ((ProfileView) this.f7869c).e0();
    }
}
