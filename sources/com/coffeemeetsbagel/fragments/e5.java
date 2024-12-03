package com.coffeemeetsbagel.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.appyvet.rangebar.RangeBar;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.f0;
import com.coffeemeetsbagel.dialogs.s;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.profile.SaveProfilesLocalUseCase;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.uber.autodispose.p;
import h5.i;
import j5.n;
import j5.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z9.h;

public class e5 extends n implements z9.f {
    private CmbTextView B;
    private CmbTextView C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private RangeBar L;
    private RangeBar M;
    private RangeBar N;
    private s O;
    private s P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private CmbTextView U;
    private CmbTextView V;
    private int W;
    private int X;
    private x8.e Y;
    private f0<com.coffeemeetsbagel.dialogs.e> Z;

    /* renamed from: a0  reason: collision with root package name */
    private f0<com.coffeemeetsbagel.dialogs.e> f13656a0;

    /* renamed from: k  reason: collision with root package name */
    SaveProfilesLocalUseCase f13657k;

    /* renamed from: l  reason: collision with root package name */
    a6.a f13658l;

    /* renamed from: m  reason: collision with root package name */
    private NetworkProfile f13659m = M0().j();

    /* renamed from: n  reason: collision with root package name */
    private View f13660n;

    /* renamed from: p  reason: collision with root package name */
    private int f13661p;

    /* renamed from: q  reason: collision with root package name */
    private int f13662q;

    /* renamed from: t  reason: collision with root package name */
    private int f13663t;

    /* renamed from: w  reason: collision with root package name */
    private String f13664w;

    /* renamed from: x  reason: collision with root package name */
    private jc.b<Void> f13665x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13666y;

    /* renamed from: z  reason: collision with root package name */
    private CmbTextView f13667z;

    class a implements b.C0132b<com.coffeemeetsbagel.dialogs.e> {
        a() {
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    class c implements b.C0132b<com.coffeemeetsbagel.dialogs.e> {
        c() {
        }

        /* renamed from: c */
        public void a(com.coffeemeetsbagel.dialogs.e eVar) {
        }

        /* renamed from: d */
        public void b(com.coffeemeetsbagel.dialogs.e eVar) {
        }
    }

    class d implements jc.b<Void> {
        d() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    class e extends ClickableSpan {
        e() {
        }

        public void onClick(@NonNull View view) {
            CmbLinks.Companion.launchTermsAndConditions(e5.this.requireActivity());
        }
    }

    class f implements jc.b<Void> {
        f() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("FragmentMyProfilePreference", "Could not set flag for has seen #pass #flow");
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13674a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.EventType[] r0 = com.coffeemeetsbagel.models.enums.EventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13674a = r0
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.MEASUREMENT_UNITS_UPDATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13674a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.models.enums.EventType r1 = com.coffeemeetsbagel.models.enums.EventType.HEIGHT_UPDATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.fragments.e5.g.<clinit>():void");
        }
    }

    private boolean A1() {
        return !this.Q.equals(this.R);
    }

    private void A2() {
        int i10;
        if (this.f13659m.isHeightUnitMetric()) {
            int criteriaDistanceKm = this.f13659m.getCriteriaDistanceKm();
            this.D = criteriaDistanceKm;
            if (criteriaDistanceKm == 0) {
                criteriaDistanceKm = ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM[0];
            }
            this.D = criteriaDistanceKm;
            i10 = E1(criteriaDistanceKm, ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM);
        } else {
            int criteriaDistanceMiles = this.f13659m.getCriteriaDistanceMiles();
            this.D = criteriaDistanceMiles;
            if (criteriaDistanceMiles == 0) {
                criteriaDistanceMiles = ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES[0];
            }
            this.D = criteriaDistanceMiles;
            i10 = E1(criteriaDistanceMiles, ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES);
        }
        this.B.setText(r7.g.e(getContext(), M0().j().isHeightUnitMetric(), this.D));
        this.N.setSeekPinByValue((float) i10);
    }

    private boolean B1() {
        return this.f13659m.getCriteriaAgeFrom() == 0 || this.f13659m.getCriteriaAgeTo() == 0;
    }

    private void B2() {
        int i10;
        int i11;
        if (C1()) {
            i11 = this.f13659m.getDefaultMinHeightCm();
            i10 = this.f13659m.getDefaultMaxHeightCm();
        } else {
            i11 = this.f13659m.getCriteriaHeightCentimetersFrom();
            i10 = this.f13659m.getCriteriaHeightCentimetersTo();
        }
        int max = Math.max(this.W, i11);
        int min = Math.min(this.X, i10);
        this.L.r((float) max, (float) min);
        this.C.setText(r7.g.b(getActivity(), M0().j().isHeightUnitMetric(), max, min));
    }

    private boolean C1() {
        if (this.f13659m.getCriteriaHeightCentimetersFrom() == 0 || this.f13659m.getCriteriaHeightCentimetersTo() == 0) {
            return true;
        }
        return false;
    }

    private boolean D1() {
        return !this.T.equals(this.S);
    }

    private int E1(int i10, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    private boolean F1() {
        return this.f13659m.getCriteriaAgeFrom() == 0 && this.f13659m.getCriteriaAgeTo() == 0;
    }

    private boolean G1(int i10) {
        for (int i11 : ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM) {
            if (i10 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean H1() {
        return Bakery.w().l().a("has_seen_pass_flow");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List I1(List list) throws Exception {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.coffeemeetsbagel.dialogs.e) it.next()).b());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(List list) throws Exception {
        this.Q = StringUtils.join(list);
        if (A1()) {
            y2();
            this.V.setText(z1(r7.g.c(requireActivity(), list)));
        }
        lc.c.h(this.f13656a0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List K1(List list) throws Exception {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.coffeemeetsbagel.dialogs.e) it.next()).b());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(List list) throws Exception {
        this.T = StringUtils.join(list);
        if (D1()) {
            z2();
            this.U.setText(z1(r7.g.d(requireActivity(), list)));
        }
        lc.c.h(this.Z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(x xVar) throws Exception {
        this.O.dismiss();
        u2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N1(x xVar) throws Exception {
        this.O.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1(x xVar) throws Exception {
        this.P.dismiss();
        v2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(x xVar) throws Exception {
        this.P.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1(RangeBar rangeBar, int i10, int i11, String str, String str2) {
        if (Integer.parseInt(rangeBar.getLeftPinValue()) < getResources().getInteger(R.integer.min_age)) {
            str = String.valueOf(getResources().getInteger(R.integer.min_age));
            this.M.r((float) Integer.parseInt(str), (float) Integer.parseInt(str2));
        }
        if (Integer.parseInt(rangeBar.getRightPinValue()) > getResources().getInteger(R.integer.max_age)) {
            str2 = String.valueOf(getResources().getInteger(R.integer.max_age));
            this.M.r((float) Integer.parseInt(str), (float) Integer.parseInt(str2));
        }
        this.f13662q = Integer.parseInt(str);
        this.f13662q = Math.max(getResources().getInteger(R.integer.min_age), this.f13662q);
        this.f13663t = Integer.parseInt(str2);
        this.f13663t = Math.min(getResources().getInteger(R.integer.max_age), this.f13663t);
        this.f13667z.setText(r7.g.a(requireActivity(), this.f13662q, this.f13663t));
        if (this.F) {
            this.F = false;
            h2(this.f13662q, this.f13663t, true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean R1(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.F = true;
        h2(this.f13662q, this.f13663t, true);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1(RangeBar rangeBar, int i10, int i11, String str, String str2) {
        m2(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean T1(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        i2(this.D);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U1(RangeBar rangeBar, int i10, int i11, String str, String str2) {
        int parseInt = Integer.parseInt(rangeBar.getLeftPinValue());
        int i12 = this.W;
        if (parseInt < i12) {
            str = String.valueOf(i12);
            this.L.r((float) Integer.parseInt(str), (float) Integer.parseInt(str2));
        }
        int parseInt2 = Integer.parseInt(rangeBar.getRightPinValue());
        int i13 = this.X;
        if (parseInt2 > i13) {
            str2 = String.valueOf(i13);
            this.L.r((float) Integer.parseInt(str), (float) Integer.parseInt(str2));
        }
        int parseInt3 = Integer.parseInt(str);
        this.J = parseInt3;
        this.J = Math.max(this.W, parseInt3);
        int parseInt4 = Integer.parseInt(str2);
        this.K = parseInt4;
        this.K = Math.min(this.X, parseInt4);
        this.C.setText(r7.g.b(getActivity(), M0().j().isHeightUnitMetric(), this.J, this.K));
        if (this.E) {
            this.E = false;
            j2(this.J, this.K);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean V1(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.E = true;
        j2(this.J, this.K);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W1(CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        lc.c.k(getContext(), cmbTextView);
        lc.c.b(getContext(), cmbTextView2);
        lc.c.b(getContext(), cmbTextView3);
        this.f13664w = NetworkProfile.FEMALE;
        k2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1(CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        lc.c.b(getContext(), cmbTextView);
        lc.c.k(getContext(), cmbTextView2);
        lc.c.b(getContext(), cmbTextView3);
        this.f13664w = NetworkProfile.MALE;
        k2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y1(CmbTextView cmbTextView, CmbTextView cmbTextView2, CmbTextView cmbTextView3, View view) {
        lc.c.b(getContext(), cmbTextView);
        lc.c.b(getContext(), cmbTextView2);
        lc.c.k(getContext(), cmbTextView3);
        this.f13664w = NetworkProfile.BISEXUAL;
        k2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z1(View view) {
        if (TextUtils.isEmpty(this.f13659m.getCriteriaReligion())) {
            this.P.show();
            if (this.P.getWindow() != null) {
                this.P.getWindow().setLayout(-1, -2);
                return;
            }
            return;
        }
        v2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a2(View view) {
        if (TextUtils.isEmpty(this.f13659m.getCriteriaEthnicity())) {
            this.O.show();
            if (this.O.getWindow() != null) {
                this.O.getWindow().setLayout(-1, -2);
                return;
            }
            return;
        }
        u2();
    }

    private int b2(int i10) {
        if (i10 < 18) {
            return 18;
        }
        if (i10 > 99) {
            return 99;
        }
        return i10;
    }

    private void c2() {
        NetworkProfile networkProfile = this.f13659m;
        if (networkProfile != null) {
            this.R = networkProfile.getCriteriaEthnicity();
            this.S = this.f13659m.getCriteriaReligion();
        }
    }

    public static e5 d2() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("EXTRA_SHOULD_SHOW_WHAT_DO_YOU_LIKE", true);
        e5 e5Var = new e5();
        e5Var.setArguments(bundle);
        return e5Var;
    }

    public static e5 e2() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("EXTRA_SHOULD_SHOW_LAST_STEP", true);
        e5 e5Var = new e5();
        e5Var.setArguments(bundle);
        return e5Var;
    }

    private void g2() {
        this.f13665x = null;
    }

    private void h2(int i10, int i11, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("minAge=");
        sb2.append(i10);
        sb2.append(", maxAge=");
        sb2.append(i11);
        if (this.f13659m.getCriteriaAgeFrom() != i10 || this.f13659m.getCriteriaAgeTo() != i11) {
            if (this.f13659m.getCriteriaAgeFrom() < i10 || this.f13659m.getCriteriaAgeTo() > i11) {
                this.G = true;
            }
            this.f13659m.setCriteriaAgeFrom(i10);
            this.f13659m.setCriteriaAgeTo(i11);
            this.f13666y = z10;
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.updateCriteriaAgeFrom(i10);
            modelProfileUpdateDelta.updateCriteriaAgeTo(i11);
            Bakery.w().G().p(this.f13665x, modelProfileUpdateDelta, true);
        }
    }

    private void i2(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("distance=");
        sb2.append(i10);
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        boolean G1 = G1(i10);
        int criteriaDistanceKm = this.f13659m.getCriteriaDistanceKm();
        int criteriaDistanceMiles = this.f13659m.getCriteriaDistanceMiles();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("distance=");
        sb3.append(i10);
        sb3.append(", isMetric=");
        sb3.append(G1);
        sb3.append(", oldKm=");
        sb3.append(criteriaDistanceKm);
        sb3.append(", oldMiles=");
        sb3.append(criteriaDistanceMiles);
        if (G1 && criteriaDistanceKm != i10) {
            if (this.f13659m.getCriteriaDistanceKm() > i10) {
                this.G = true;
            }
            this.f13659m.setCriteriaDistanceKm(i10);
            this.f13659m.setCriteriaDistanceMiles(y1(i10));
            this.f13666y = true;
            modelProfileUpdateDelta.updateCriteriaDistanceKm(i10);
            Bakery.w().G().p(this.f13665x, modelProfileUpdateDelta, true);
        } else if (!G1 && criteriaDistanceMiles != i10) {
            if (this.f13659m.getCriteriaDistanceMiles() > i10) {
                this.G = true;
            }
            this.f13659m.setCriteriaDistanceMiles(i10);
            this.f13659m.setCriteriaDistanceKm(x1(i10));
            this.f13666y = true;
            modelProfileUpdateDelta.updateCriteriaDistanceMiles(i10);
            Bakery.w().G().p(this.f13665x, modelProfileUpdateDelta, true);
        }
    }

    private void j2(int i10, int i11) {
        boolean z10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Selected Height min/max: ");
        sb2.append(i10);
        sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb2.append(i11);
        if (i10 == 0) {
            i10 = 122;
        }
        if (i11 == 0) {
            i11 = Height.CENTIMETRES_MAX;
        }
        if (this.f13659m.getCriteriaHeightCentimetersFrom() == i10 && this.f13659m.getCriteriaHeightCentimetersTo() == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (this.f13659m.getCriteriaHeightCentimetersFrom() < i10 || this.f13659m.getCriteriaHeightCentimetersTo() > i11) {
                this.G = true;
            }
            Height height = new Height(i10);
            this.f13659m.setCriteriaHeightFrom(height);
            Height height2 = new Height(i11);
            this.f13659m.setCriteriaHeightTo(height2);
            this.f13666y = true;
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.updateCriteriaHeightFrom(height);
            modelProfileUpdateDelta.updateCriteriaHeightTo(height2);
            Bakery.w().G().p(this.f13665x, modelProfileUpdateDelta, true);
        }
    }

    private void k2() {
        this.f13666y = true;
        this.G = true;
        this.f13659m.setCriteriaGender(this.f13664w);
        this.Y.U(this.f13664w, this.f13659m.getOrientation());
        B2();
    }

    private void l2() {
        this.f13665x = new d();
    }

    private void m2(int i10) {
        if (this.f13659m.isHeightUnitMetric()) {
            this.D = ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM[i10];
        } else {
            this.D = ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES[i10];
        }
        this.B.setText(r7.g.e(getContext(), M0().j().isHeightUnitMetric(), this.D));
    }

    private void n2() {
        this.M = (RangeBar) this.f13660n.findViewById(R.id.rangebar_age);
        this.f13667z = (CmbTextView) this.f13660n.findViewById(R.id.customTextView_my_profile_preference_agerange_value);
        this.M.setOnRangeBarChangeListener(new a5(this));
        this.M.setOnTouchListener(new b5(this));
    }

    private void o2() {
        if (G0().a("Privacy.GdprCopy.Android")) {
            TextView textView = (TextView) this.f13660n.findViewById(R.id.fragment_my_profile_prefs_disclaimer_textview);
            textView.setVisibility(0);
            String string = getString(R.string.privacy_policy);
            SpannableString spannableString = new SpannableString(getString(R.string.bagel_preference_disclaimer, string));
            int indexOf = spannableString.toString().indexOf(string);
            int length = string.length() + indexOf;
            spannableString.setSpan(new ForegroundColorSpan(-16776961), indexOf, length, 18);
            spannableString.setSpan(new e(), indexOf, length, 18);
            textView.setText(spannableString);
            textView.setClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void p2() {
        this.N = (RangeBar) this.f13660n.findViewById(R.id.rangebar_distance);
        this.B = (CmbTextView) this.f13660n.findViewById(R.id.customTextView_my_profile_preference_matchradius_value);
        this.N.setOnRangeBarChangeListener(new p4(this));
        this.N.setOnTouchListener(new q4(this));
    }

    private void q1() {
        this.O = new s(getContext(), (int) R.string.advanced_preferences_dialog_confirm_title, (int) R.string.advanced_preferences_dialog_confirm_text, (int) R.string.continue_lc, (int) R.string.not_now, false);
    }

    private void q2() {
        this.L = (RangeBar) this.f13660n.findViewById(R.id.rangebar_height);
        this.C = (CmbTextView) this.f13660n.findViewById(R.id.textView_height_value);
        this.L.setOnRangeBarChangeListener(new y4(this));
        this.L.setOnTouchListener(new z4(this));
    }

    private void r1() {
        this.P = new s(getContext(), (int) R.string.advanced_preferences_dialog_confirm_title, (int) R.string.advanced_preferences_dialog_confirm_text, (int) R.string.continue_lc, (int) R.string.not_now, false);
    }

    private void r2() {
        TextView textView = (TextView) this.f13660n.findViewById(R.id.onboarding_title);
        TextView textView2 = (TextView) this.f13660n.findViewById(R.id.onboarding_prompt);
        if (this.I) {
            textView.setVisibility(0);
            textView2.setVisibility(8);
        } else if (this.H) {
            textView.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            textView.setVisibility(8);
            textView2.setVisibility(8);
        }
    }

    private static int s1(int[] iArr, int i10) {
        int i11 = 0;
        while (i11 < iArr.length && (r1 = iArr[i11]) != i10 && r1 <= i10) {
            i11++;
        }
        return i11;
    }

    private void s2() {
        CmbTextView cmbTextView = (CmbTextView) this.f13660n.findViewById(R.id.my_profile_preference_women);
        CmbTextView cmbTextView2 = (CmbTextView) this.f13660n.findViewById(R.id.my_profile_preference_men);
        CmbTextView cmbTextView3 = (CmbTextView) this.f13660n.findViewById(R.id.my_profile_preference_both);
        String criteriaGender = this.f13659m.getCriteriaGender();
        criteriaGender.hashCode();
        char c10 = 65535;
        switch (criteriaGender.hashCode()) {
            case 98:
                if (criteriaGender.equals(NetworkProfile.BISEXUAL)) {
                    c10 = 0;
                    break;
                }
                break;
            case 102:
                if (criteriaGender.equals(NetworkProfile.FEMALE)) {
                    c10 = 1;
                    break;
                }
                break;
            case 109:
                if (criteriaGender.equals(NetworkProfile.MALE)) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                lc.c.b(getContext(), cmbTextView);
                lc.c.b(getContext(), cmbTextView2);
                lc.c.k(getContext(), cmbTextView3);
                break;
            case 1:
                lc.c.k(getContext(), cmbTextView);
                lc.c.b(getContext(), cmbTextView2);
                lc.c.b(getContext(), cmbTextView3);
                break;
            case 2:
                lc.c.b(getContext(), cmbTextView);
                lc.c.k(getContext(), cmbTextView2);
                lc.c.b(getContext(), cmbTextView3);
                break;
            default:
                fa.a.i(new Exception("Unknown gender criteria: " + criteriaGender));
                break;
        }
        cmbTextView.setOnClickListener(new c5(this, cmbTextView, cmbTextView2, cmbTextView3));
        cmbTextView2.setOnClickListener(new d5(this, cmbTextView, cmbTextView2, cmbTextView3));
        cmbTextView3.setOnClickListener(new m4(this, cmbTextView, cmbTextView2, cmbTextView3));
    }

    private Dialog t1(String[] strArr, String[] strArr2, List<String> list) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList(list.size());
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            String str2 = strArr2[i10];
            com.coffeemeetsbagel.dialogs.e eVar = new com.coffeemeetsbagel.dialogs.e(str, str2);
            if (list.contains(str2)) {
                arrayList2.add(eVar);
            }
            arrayList.add(eVar);
        }
        f0 f0Var = new f0(requireActivity(), getString(R.string.advanced_preferences_dialog_ethnicity_title), (String) null, getString(R.string.done_dls), new a(), arrayList);
        this.f13656a0 = f0Var;
        f0Var.k(arrayList2);
        ((p) this.f13656a0.i().W(new t4()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new u4(this));
        return this.f13656a0;
    }

    private void t2() {
        CmbTextView cmbTextView = (CmbTextView) this.f13660n.findViewById(R.id.textView_religion);
        this.U = cmbTextView;
        cmbTextView.setText(z1(r7.g.d(requireActivity(), this.f13659m.getCriteriaReligionAsApiParamsList())));
        this.U.setOnClickListener(new n4(this));
        CmbTextView cmbTextView2 = (CmbTextView) this.f13660n.findViewById(R.id.textView_ethnicity);
        this.V = cmbTextView2;
        cmbTextView2.setText(z1(r7.g.c(requireActivity(), this.f13659m.getCriteriaEthnicityAsApiParamsList())));
        this.V.setOnClickListener(new o4(this));
    }

    private Dialog u1(String[] strArr, String[] strArr2, List<String> list) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList(list.size());
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str = strArr[i10];
            String str2 = strArr2[i10];
            com.coffeemeetsbagel.dialogs.e eVar = new com.coffeemeetsbagel.dialogs.e(str, str2);
            if (list.contains(str2)) {
                arrayList2.add(eVar);
            }
            arrayList.add(eVar);
        }
        f0 f0Var = new f0(requireActivity(), getString(R.string.advanced_preferences_dialog_religion_title), (String) null, getString(R.string.done_dls), new c(), arrayList);
        this.Z = f0Var;
        f0Var.k(arrayList2);
        ((p) this.Z.i().W(new r4()).a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new s4(this));
        return this.Z;
    }

    private void u2() {
        Dialog t12 = t1(getResources().getStringArray(R.array.ethnicity), getResources().getStringArray(R.array.ethnicity_api), this.f13659m.getCriteriaEthnicityAsApiParamsList());
        t12.show();
        if (t12.getWindow() != null) {
            t12.getWindow().setLayout(-1, -2);
        }
    }

    private int v1(int i10) {
        if (this.f13659m.getGender().equals(NetworkProfile.FEMALE)) {
            return b2(i10 + 7);
        }
        return b2(i10 + 2);
    }

    private void v2() {
        Dialog u12 = u1(getResources().getStringArray(R.array.religion), getResources().getStringArray(R.array.religion_api), this.f13659m.getCriteriaReligionAsApiParamsList());
        u12.show();
        if (u12.getWindow() != null) {
            u12.getWindow().setLayout(-1, -2);
        }
    }

    private int w1(int i10) {
        if (this.f13659m.getGender().equals(NetworkProfile.FEMALE)) {
            return b2(i10 - 2);
        }
        return b2(i10 - 7);
    }

    private void w2() {
        int i10;
        int i11;
        if (B1()) {
            i11 = w1(this.f13661p);
            i10 = v1(this.f13661p);
        } else {
            i11 = this.f13659m.getCriteriaAgeFrom();
            i10 = this.f13659m.getCriteriaAgeTo();
        }
        this.M.r((float) i11, (float) i10);
        this.f13667z.setText(r7.g.a(requireActivity(), i11, i10));
    }

    private static int x1(int i10) {
        return ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM[s1(ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES, i10)];
    }

    private void x2(ModelProfileUpdateDelta modelProfileUpdateDelta) {
        Bakery.w().G().p(new b(), modelProfileUpdateDelta, true);
    }

    private static int y1(int i10) {
        return ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES[s1(ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM, i10)];
    }

    private void y2() {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaEthnicity(this.Q);
        this.f13659m.setCriteriaEthnicity(this.Q);
        this.R = this.Q;
        M0().j().setCriteriaEthnicity(this.Q);
        x2(modelProfileUpdateDelta);
        this.f13666y = true;
    }

    private String z1(String str) {
        return TextUtils.isEmpty(str) ? getResources().getString(R.string.no_preference) : str;
    }

    private void z2() {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateCriteriaReligion(this.T);
        this.f13659m.setCriteriaReligion(this.T);
        this.S = this.T;
        M0().j().setCriteriaReligion(this.T);
        x2(modelProfileUpdateDelta);
        this.f13666y = true;
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Preference";
    }

    public void T0() {
        lc.c.a(getActivity());
        f2();
    }

    public void V0() {
        C0().f("Onboarding - Bagel Preferences");
    }

    public boolean b0(boolean z10) {
        return Bakery.w().l().a("has_seen_pass_flow");
    }

    public void f2() {
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateHasSeenPassFlow(true);
        Bakery.w().G().p(new f(), modelProfileUpdateDelta, true);
        this.f13658l.b("has_seen_pass_flow");
        h hVar = this.f15615d;
        if (hVar != null) {
            hVar.X(true, this);
        }
    }

    public void n0(EventType eventType, Bundle bundle) {
        int i10 = g.f13674a[eventType.ordinal()];
        if (i10 == 1) {
            this.f13659m.setHeightUnitIsMetric(bundle.getBoolean("is_metric"));
        } else if (i10 == 2) {
            B2();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z10;
        Bakery.j().c1(this);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f13659m = (NetworkProfile) bundle.getSerializable("key_user_profile");
        }
        c2();
        this.f13661p = this.f13659m.getAgeInteger();
        boolean z11 = false;
        i.a(this, EventType.MEASUREMENT_UNITS_UPDATED, EventType.HEIGHT_UPDATED);
        if (getArguments() == null || !getArguments().getBoolean("EXTRA_SHOULD_SHOW_WHAT_DO_YOU_LIKE", false)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.I = z10;
        if (getArguments() != null && getArguments().getBoolean("EXTRA_SHOULD_SHOW_LAST_STEP", false)) {
            z11 = true;
        }
        this.H = z11;
        this.W = getResources().getInteger(R.integer.min_height_centimeters);
        this.X = getResources().getInteger(R.integer.max_height_centimeters);
        u8.a aVar = new u8.a(M0(), C0());
        this.Y = aVar;
        aVar.start();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f13660n = layoutInflater.inflate(R.layout.fragment_my_profile_preference_dls, viewGroup, false);
        n2();
        p2();
        q2();
        r1();
        q1();
        t2();
        r2();
        s2();
        o2();
        return this.f13660n;
    }

    public void onDestroy() {
        super.onDestroy();
        i.d(this, new EventType[0]);
        this.Y.stop();
    }

    public void onPause() {
        super.onPause();
        g2();
        if (F1()) {
            h2(w1(this.f13661p), v1(this.f13661p), false);
        }
    }

    public void onResume() {
        super.onResume();
        Bakery.w().z().f("Bagel Preferences");
        this.f13666y = false;
        this.f13663t = 0;
        this.f13662q = 0;
        w2();
        A2();
        B2();
        l2();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("key_user_profile", this.f13659m);
    }

    public void onStart() {
        super.onStart();
        ((p) this.O.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new l4(this));
        ((p) this.O.b().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new v4(this));
        ((p) this.P.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w4(this));
        ((p) this.P.b().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new x4(this));
    }

    public void onStop() {
        super.onStop();
        lc.c.h(this.O);
        lc.c.h(this.P);
        lc.c.h(this.f13656a0);
        lc.c.h(this.Z);
    }
}
