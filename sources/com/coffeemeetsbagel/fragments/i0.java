package com.coffeemeetsbagel.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.d;
import androidx.core.app.j0;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivitySettings;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.deactivate.DeactivateScreenComponentActivity;
import com.coffeemeetsbagel.dialogs.s;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.ProfileQuestion;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.Units;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.coffeemeetsbagel.qna.SaveAnswerUseCase;
import com.coffeemeetsbagel.qna.i;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.utils.model.Optional;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.uber.autodispose.m;
import com.uber.autodispose.n;
import com.uber.autodispose.p;
import com.uber.autodispose.t;
import j5.x;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lc.l;
import q5.f;
import r7.h;
import z9.j;

public class i0 extends r7.b implements j {
    /* access modifiers changed from: private */
    public Switch B;
    private Switch C;
    private Switch D;
    private Switch E;
    /* access modifiers changed from: private */
    public h F;
    private CmbTextView G;
    private LinearLayout H;
    private TextView I;
    private View J;
    private View K;
    private View L;
    private vb.a M = null;
    wb.c N;
    i O;
    SaveAnswerUseCase P;

    /* renamed from: d  reason: collision with root package name */
    private jc.b<Void> f13705d;

    /* renamed from: e  reason: collision with root package name */
    private s f13706e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public s f13707f;

    /* renamed from: g  reason: collision with root package name */
    private s f13708g;

    /* renamed from: h  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f13709h;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public NetworkProfile f13710j;

    /* renamed from: k  reason: collision with root package name */
    private jc.b f13711k;

    /* renamed from: l  reason: collision with root package name */
    protected View f13712l;

    /* renamed from: m  reason: collision with root package name */
    private View f13713m;

    /* renamed from: n  reason: collision with root package name */
    private View f13714n;

    /* renamed from: p  reason: collision with root package name */
    private CmbTextView f13715p;

    /* renamed from: q  reason: collision with root package name */
    private CmbTextView f13716q;

    /* renamed from: t  reason: collision with root package name */
    private CmbTextView f13717t;

    /* renamed from: w  reason: collision with root package name */
    private CmbTextView f13718w;

    /* renamed from: x  reason: collision with root package name */
    private CmbTextView f13719x;

    /* renamed from: y  reason: collision with root package name */
    private Switch f13720y;

    /* renamed from: z  reason: collision with root package name */
    private Switch f13721z;

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            lc.c.h(i0.this.F);
            i0.this.E2();
            if (i0.this.getActivity() != null) {
                sb.a.i(i0.this.f13712l, R.string.error_reactivation);
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            lc.c.h(i0.this.F);
            if (i0.this.f13710j == null) {
                i0 i0Var = i0.this;
                i0Var.f13710j = i0Var.M0().j();
            }
            i0.this.f13710j.setOnHold(false);
            h5.i.b(EventType.ACCOUNT_ON_HOLD_STATE_CHANGED);
            i0.this.E2();
        }
    }

    class b implements jc.b {
        b() {
        }

        public void a(Object obj, SuccessStatus successStatus) {
            i0.this.M0().f();
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }
    }

    class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(x xVar) throws Exception {
            lc.c.h(i0.this.f13707f);
            i0.this.M0().g(ProfileContract$Manager.NotificationSettingsType.CHAT, false);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(x xVar) throws Exception {
            lc.c.h(i0.this.f13707f);
            i0.this.B.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            i0.this.B.setChecked(true);
            i0.this.B.setOnCheckedChangeListener(this);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(x xVar) throws Exception {
            lc.c.h(i0.this.f13707f);
            i0.this.F1();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(x xVar) throws Exception {
            lc.c.h(i0.this.f13707f);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                i0.this.M0().g(ProfileContract$Manager.NotificationSettingsType.CHAT, true);
                if (!j0.b(i0.this.requireContext()).a() && i0.this.f13707f == null) {
                    i0.this.f13707f = new s(i0.this.requireContext(), (int) R.string.settings_chat_notifications_on_dialog_title, (int) R.string.settings_chat_notifications_on_dialog_body, (int) R.string.go_to_phone_settings_dls, (int) R.string.not_now, false);
                    ((p) i0.this.f13707f.a().g(com.uber.autodispose.a.a(i0.this))).c(new l0(this));
                    ((p) i0.this.f13707f.b().g(com.uber.autodispose.a.a(i0.this))).c(new m0(this));
                    i0.this.f13707f.show();
                    if (i0.this.f13707f.getWindow() != null) {
                        i0.this.f13707f.getWindow().setLayout(-1, -2);
                    }
                }
            } else if (i0.this.f13707f == null) {
                i0.this.f13707f = new s(i0.this.requireContext(), (int) R.string.settings_chat_notifications_off_dialog_title, (int) R.string.settings_chat_notifications_off_dialog_body, (int) R.string.turn_off_notifications_dls, (int) R.string.not_now, false);
                ((p) i0.this.f13707f.a().g(com.uber.autodispose.a.a(i0.this))).c(new j0(this));
                ((p) i0.this.f13707f.b().g(com.uber.autodispose.a.a(i0.this))).c(new k0(this));
                i0.this.f13707f.show();
                if (i0.this.f13707f.getWindow() != null) {
                    i0.this.f13707f.getWindow().setLayout(-1, -2);
                }
            }
        }
    }

    private void A2() {
        if (isAdded()) {
            h hVar = new h(getActivity());
            this.F = hVar;
            hVar.show();
        }
    }

    private void B2(boolean z10) {
        CmbTextView cmbTextView;
        CmbTextView cmbTextView2;
        if (z10) {
            cmbTextView = (CmbTextView) this.f13712l.findViewById(R.id.textView_metric);
        } else {
            cmbTextView = (CmbTextView) this.f13712l.findViewById(R.id.textView_imperial);
        }
        if (z10) {
            cmbTextView2 = (CmbTextView) this.f13712l.findViewById(R.id.textView_imperial);
        } else {
            cmbTextView2 = (CmbTextView) this.f13712l.findViewById(R.id.textView_metric);
        }
        lc.c.k(getContext(), cmbTextView);
        lc.c.b(getContext(), cmbTextView2);
    }

    private void C1() {
        ((n) this.N.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new e(this));
    }

    private void C2(CmbTextView cmbTextView, CmbTextView cmbTextView2, QuestionWAnswers questionWAnswers) {
        Units units;
        boolean z10 = false;
        if (questionWAnswers.d().isEmpty()) {
            units = Units.IMPERIAL;
        } else {
            units = (Units) questionWAnswers.e().getOptions().stream().filter(new s(questionWAnswers.d().get(0).getOptionId())).findFirst().map(new t()).orElse(Units.IMPERIAL);
        }
        if (units == Units.METRIC) {
            z10 = true;
        }
        B2(z10);
        cmbTextView.setOnClickListener(new u(this, questionWAnswers, units));
        cmbTextView2.setOnClickListener(new v(this, questionWAnswers, units));
    }

    private void D1() {
        this.f13715p.setOnClickListener((View.OnClickListener) null);
        this.f13717t.setOnClickListener((View.OnClickListener) null);
        this.B.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f13718w.setOnClickListener((View.OnClickListener) null);
    }

    private void D2() {
        if (this.f13710j.isFemale()) {
            this.f13719x.setText(getString(R.string.settings_item_title_membership_active_switch_female));
        } else {
            this.f13719x.setText(getString(R.string.settings_item_title_membership_active_switch_male));
        }
    }

    private void E1() {
        if (this.f13706e == null) {
            s sVar = new s(getContext(), (int) R.string.setting_pause_account_pop_up_title, (int) R.string.setting_pause_account_pop_up_message, (int) R.string.setting_pause_account_pop_up_cta, (int) R.string.cancel, true);
            this.f13706e = sVar;
            ((p) sVar.a().g(com.uber.autodispose.a.a(this))).c(new m(this));
            ((p) this.f13706e.b().g(com.uber.autodispose.a.a(this))).c(new n(this));
            this.f13706e.setOnCancelListener(new o(this));
        }
        this.f13706e.show();
        if (this.f13706e.getWindow() != null) {
            this.f13706e.getWindow().setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public void E2() {
        if (M0().j() != null) {
            this.f13710j = M0().j();
        }
        NetworkProfile networkProfile = this.f13710j;
        if (networkProfile == null || !networkProfile.isOnHold()) {
            this.f13720y.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            this.f13720y.setChecked(true);
            this.f13720y.setOnCheckedChangeListener(this.f13709h);
            D2();
            return;
        }
        this.f13720y.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f13720y.setChecked(false);
        this.f13720y.setOnCheckedChangeListener(this.f13709h);
        String reactivateDate = this.f13710j.getReactivateDate();
        Date date = DateUtils.getDate(reactivateDate);
        if (TextUtils.isEmpty(reactivateDate)) {
            this.f13719x.setText(R.string.paused);
            return;
        }
        this.f13719x.setText(String.format(getString(R.string.pause_until_formatted), new Object[]{DateUtils.getFormattedUtcDate(date, (String) DateUtils.DATE_PATTERN_NUMBERS_SLASHES_DEFAULT)}));
    }

    /* access modifiers changed from: private */
    public void F1() {
        Intent intent = new Intent();
        if (getContext() != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", getContext().getPackageName());
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", getContext().getPackageName());
                intent.putExtra("app_uid", getContext().getApplicationInfo().uid);
            }
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H1(Optional optional) throws Exception {
        if (optional.d()) {
            this.M = (vb.a) optional.c();
            this.H.setVisibility(0);
            return;
        }
        this.M = null;
        this.H.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(x xVar) throws Exception {
        z2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(x xVar) throws Exception {
        m2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1(DialogInterface dialogInterface) {
        m2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(boolean z10, View view) {
        B2(true);
        p2(true);
        q2(!z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(boolean z10, View view) {
        B2(false);
        p2(false);
        q2(z10);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O1() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1(a7.a aVar, x xVar) throws Exception {
        aVar.f("Delete Account");
        y2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R1(x xVar) throws Exception {
        lc.c.h(this.f13708g);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1(a7.a aVar, View view) {
        s sVar = new s(requireContext(), (int) R.string.setting_delete_account_pop_up_title, (int) R.string.setting_delete_account_pop_up_message, (int) R.string.setting_delete_account_pop_up_cta, (int) R.string.setting_delete_account_cancel, true);
        this.f13708g = sVar;
        ((p) sVar.a().g(com.uber.autodispose.a.a(this))).c(new q(this, aVar));
        ((p) this.f13708g.b().g(com.uber.autodispose.a.a(this))).c(new r(this));
        this.f13708g.show();
        if (this.f13708g.getWindow() != null) {
            this.f13708g.getWindow().setLayout(-1, -2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T1(View view) {
        new d.a().a().a(getActivity(), Uri.parse(getString(R.string.zendesk_url)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U1(View view) {
        String str;
        androidx.fragment.app.h activity = getActivity();
        if (activity != null) {
            vb.a aVar = this.M;
            if (aVar != null) {
                str = aVar.e();
            } else {
                str = "";
            }
            l.d(activity, str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V1(CmbTextView cmbTextView, CmbTextView cmbTextView2, java.util.Optional optional) throws Exception {
        if (optional.isPresent()) {
            C2(cmbTextView, cmbTextView2, (QuestionWAnswers) optional.get());
            return;
        }
        fa.a.g("FragmentSettings", "Failed to load units question.", new Exception("Missing Question"));
        k2(cmbTextView, cmbTextView2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W1(CmbTextView cmbTextView, CmbTextView cmbTextView2, Throwable th2) throws Exception {
        fa.a.g("FragmentSettings", "Failed to load units question.", th2);
        k2(cmbTextView, cmbTextView2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1() {
        lc.c.h(this.F);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y1(View view) {
        A2();
        D0().b(getActivity(), false, new i(this), AnalyticsConstants$Logout.USER_INITIATED, new String[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z1(View view) {
        CmbLinks.Companion.launchTermsAndConditions(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        lc.a.c(getActivity(), new Intent(getActivity(), OssLicensesMenuActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b2(CompoundButton compoundButton, boolean z10) {
        M0().g(ProfileContract$Manager.NotificationSettingsType.CUSTOMER_SERVICE, z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c2(CompoundButton compoundButton, boolean z10) {
        M0().g(ProfileContract$Manager.NotificationSettingsType.DAILY_NOON_ALERT, z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d2(CompoundButton compoundButton, boolean z10) {
        M0().g(ProfileContract$Manager.NotificationSettingsType.VIDEO, z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e2(CompoundButton compoundButton, boolean z10) {
        M0().g(ProfileContract$Manager.NotificationSettingsType.NEW_LIKES, z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f2(CompoundButton compoundButton, boolean z10) {
        if (z10) {
            n2();
        } else if (!this.f13710j.isOnHold()) {
            E1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g2(QuestionWAnswers questionWAnswers, Units units, View view) {
        boolean z10 = false;
        B2(false);
        o2(Units.IMPERIAL, questionWAnswers.e());
        if (units == Units.METRIC) {
            z10 = true;
        }
        q2(z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(QuestionWAnswers questionWAnswers, Units units, View view) {
        boolean z10 = true;
        B2(true);
        Units units2 = Units.METRIC;
        o2(units2, questionWAnswers.e());
        if (units == units2) {
            z10 = false;
        }
        q2(z10);
    }

    private void k2(CmbTextView cmbTextView, CmbTextView cmbTextView2) {
        boolean z10;
        NetworkProfile networkProfile = this.f13710j;
        if (networkProfile == null || !networkProfile.isHeightUnitMetric()) {
            z10 = false;
        } else {
            z10 = true;
        }
        B2(z10);
        cmbTextView.setOnClickListener(new k(this, z10));
        cmbTextView2.setOnClickListener(new l(this, z10));
    }

    private void l2() {
        E2();
    }

    private void m2() {
        lc.c.h(this.f13706e);
        this.f13720y.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f13720y.setChecked(true);
        this.f13720y.setOnCheckedChangeListener(this.f13709h);
    }

    private void n2() {
        A2();
        Bakery.w().G().d(this.f13705d);
    }

    private void o2(Units units, Question question) {
        ((m) this.P.c((List) question.getOptions().stream().filter(new w(units)).map(new x()).collect(Collectors.toList()), (String) null, question.getId(), QuestionGroupType.ORIGINAL_PROFILE.getQuestionGroupApiString(), (Integer) null, (Float) null, (Float) null, (Float) null, false, (Location) null).z(sj.a.a()).j(com.uber.autodispose.a.a(this))).f(new y(), new z());
    }

    private void p2(boolean z10) {
        this.f13710j.setHeightUnitIsMetric(z10);
        M0().j().setHeightUnitIsMetric(z10);
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateIsMetric(z10);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_metric", z10);
        h5.i.c(EventType.MEASUREMENT_UNITS_UPDATED, bundle);
        this.f13711k = new b();
        M0().p(this.f13711k, modelProfileUpdateDelta, true);
    }

    private void q2(boolean z10) {
        if (getActivity() != null && (getActivity() instanceof ActivitySettings)) {
            ((ActivitySettings) getActivity()).C1(z10);
        }
    }

    private void r2(View view) {
        this.f13716q = (CmbTextView) view.findViewById(R.id.delete_account);
        this.f13716q.setOnClickListener(new g(this, Bakery.w().z()));
    }

    private void s2() {
        this.J.setOnClickListener(new j(this));
    }

    private void t2() {
        this.G.setOnClickListener(new h(this));
    }

    private void u2() {
        if (this.f13710j.getNotificationSettings() != null) {
            this.f13721z.setChecked(this.f13710j.getNotificationSettings().dailyPush);
            this.B.setChecked(this.f13710j.getNotificationSettings().chatPush);
            this.C.setChecked(this.f13710j.getNotificationSettings().customersPush);
            this.E.setChecked(this.f13710j.getNotificationSettings().newLikesPush);
        } else {
            this.f13721z.setEnabled(false);
            this.B.setEnabled(false);
            this.C.setEnabled(false);
            this.E.setEnabled(false);
            fa.a.f("CMB", "The Profile notificationSettings field was null while in Settings.");
        }
        this.f13713m.setVisibility(8);
        this.f13714n.setVisibility(8);
    }

    private void v2(View view) {
        CmbTextView cmbTextView = (CmbTextView) view.findViewById(R.id.textView_metric);
        CmbTextView cmbTextView2 = (CmbTextView) view.findViewById(R.id.textView_imperial);
        if (M0().j() != null) {
            this.f13710j = M0().j();
        }
        if (G0().a("ProfileMigration.Enabled.Android")) {
            ((t) this.O.a(this.f13710j.getId(), ProfileQuestion.UNITS.getApiKey()).L().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new h0(this, cmbTextView, cmbTextView2), new f(this, cmbTextView, cmbTextView2));
        } else {
            k2(cmbTextView, cmbTextView2);
        }
    }

    private void w2() {
        try {
            PackageInfo packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            String str = packageInfo.versionName;
            int i10 = packageInfo.versionCode;
            this.I.setText(String.format("%s (%d)", new Object[]{str, Integer.valueOf(i10)}));
        } catch (PackageManager.NameNotFoundException e10) {
            fa.a.i(e10);
        }
    }

    private void x2() {
        this.f13715p.setOnClickListener(new p(this));
        this.f13717t.setOnClickListener(new a0(this));
        this.f13718w.setOnClickListener(new b0(this));
        this.B.setOnCheckedChangeListener(new c());
        this.C.setOnCheckedChangeListener(new c0(this));
        this.f13721z.setOnCheckedChangeListener(new d0(this));
        this.D.setOnCheckedChangeListener(new e0(this));
        this.E.setOnCheckedChangeListener(new f0(this));
        g0 g0Var = new g0(this);
        this.f13709h = g0Var;
        this.f13720y.setOnCheckedChangeListener(g0Var);
    }

    private void y2() {
        Intent intent = new Intent(getActivity(), DeactivateScreenComponentActivity.class);
        intent.putExtra(Extra.IS_ACCOUNT_DELETION, true);
        startActivityForResult(intent, 2000);
        if (getActivity() != null) {
            getActivity().overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        }
    }

    private void z2() {
        Intent intent = new Intent(getActivity(), DeactivateScreenComponentActivity.class);
        intent.putExtra(Extra.IS_ACCOUNT_DELETION, false);
        startActivityForResult(intent, 1000);
        if (getActivity() != null) {
            getActivity().overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        }
    }

    /* access modifiers changed from: protected */
    public void G1(View view) {
        this.J = view.findViewById(R.id.clickable_text_help);
        this.f13715p = (CmbTextView) view.findViewById(R.id.logout);
        this.f13717t = (CmbTextView) view.findViewById(R.id.clickable_text_privacy);
        this.f13718w = (CmbTextView) view.findViewById(R.id.clickable_text_oss);
        this.f13719x = (CmbTextView) view.findViewById(R.id.textView_membership_status);
        this.G = (CmbTextView) view.findViewById(R.id.text_subscription);
        this.I = (TextView) view.findViewById(R.id.version);
        D2();
        f.g(this.f13717t, this.f13718w, this.G, this.J);
        this.f13721z = (Switch) view.findViewById(R.id.switch_daily_noon_alert);
        this.B = (Switch) view.findViewById(R.id.switch_chats);
        this.C = (Switch) view.findViewById(R.id.switch_customer_service);
        this.D = (Switch) view.findViewById(R.id.switch_video);
        this.E = (Switch) view.findViewById(R.id.switch_new_likes);
        this.f13713m = view.findViewById(R.id.video_switch_container);
        this.f13714n = view.findViewById(R.id.video_switch_divider);
        this.f13720y = (Switch) view.findViewById(R.id.switch_membership_active);
        this.H = (LinearLayout) view.findViewById(R.id.subscription_layout);
        this.L = view.findViewById(R.id.new_likes_divider);
        this.K = view.findViewById(R.id.new_likes_container);
        if (G0().a("RealTimeLY.Enabled.Android")) {
            this.K.setVisibility(0);
            this.L.setVisibility(0);
        } else {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.E.setEnabled(false);
        }
        u2();
        v2(view);
        r2(view);
        t2();
        w2();
        s2();
        u2();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1000 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(Extra.ON_HOLD_UNTIL, false);
            if (intent.getBooleanExtra(Extra.ON_HOLD_INDEFINITELY, false) || booleanExtra) {
                if (M0().j() != null) {
                    this.f13710j = M0().j();
                }
                this.f13710j.setOnHold(true);
                h5.i.b(EventType.ACCOUNT_ON_HOLD_STATE_CHANGED);
                sb.a.i(this.f13712l, R.string.account_put_on_pause_snackbar_message);
            }
            E2();
        }
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().W0(this);
        super.onCreate(bundle);
        if (bundle == null) {
            this.f13710j = M0().j();
        } else {
            this.f13710j = (NetworkProfile) bundle.getSerializable("profile");
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_settings_dls, viewGroup, false);
        this.f13712l = inflate;
        G1(inflate);
        l2();
        x2();
        return this.f13712l;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f13709h = null;
        lc.c.h(this.F);
    }

    public void onDestroyView() {
        super.onDestroyView();
        D1();
    }

    public void onPause() {
        super.onPause();
        this.f13705d = null;
        this.f13711k = null;
        s sVar = this.f13706e;
        if (sVar != null && sVar.isShowing()) {
            this.f13706e.cancel();
            this.f13706e = null;
        }
        Bakery.w().G().l(this);
    }

    public void onResume() {
        super.onResume();
        this.f13705d = new a();
        Bakery.w().G().k(this);
        C1();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("profile", this.f13710j);
    }

    public void onStop() {
        super.onStop();
        lc.c.h(this.f13707f);
        lc.c.h(this.f13706e);
        lc.c.h(this.f13708g);
    }

    public void t() {
        E2();
        if (getActivity() != null) {
            sb.a.i(this.f13712l, R.string.reactivated);
        }
    }
}
