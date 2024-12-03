package g8;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityOnboardingLocation;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.profile.LoadLocationUseCase;
import com.coffeemeetsbagel.qna.UpdateLocationUseCase;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.coffeemeetsbagel.utils.model.Optional;
import com.uber.autodispose.t;
import h5.i;
import j5.m;
import lc.q;
import r7.h;
import z9.f;

public class l extends r7.b implements f {
    private Location B;
    private CmbTextView C;
    /* access modifiers changed from: private */
    public View D;
    UpdateLocationUseCase E;
    LoadLocationUseCase F;

    /* renamed from: d  reason: collision with root package name */
    private AutoCompleteTextView f15236d;

    /* renamed from: e  reason: collision with root package name */
    private CmbEditText f15237e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayAdapter<String> f15238f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f15239g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public h f15240h;

    /* renamed from: j  reason: collision with root package name */
    private jc.b<Void> f15241j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public jc.b<Void> f15242k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public jc.b<Void> f15243l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15244m;

    /* renamed from: n  reason: collision with root package name */
    private jc.b<Void> f15245n;

    /* renamed from: p  reason: collision with root package name */
    private String f15246p;

    /* renamed from: q  reason: collision with root package name */
    private String f15247q;

    /* renamed from: t  reason: collision with root package name */
    private String f15248t;

    /* renamed from: w  reason: collision with root package name */
    private ArrayAdapter<String> f15249w;

    /* renamed from: x  reason: collision with root package name */
    private String f15250x;

    /* renamed from: y  reason: collision with root package name */
    private String f15251y;

    /* renamed from: z  reason: collision with root package name */
    private android.location.Location f15252z;

    class a implements jc.b<Void> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            l.this.k1();
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            l.this.k1();
        }
    }

    class b implements jc.b<Void> {
        b() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            if (l.this.getActivity() != null) {
                sb.a.i(l.this.D, R.string.location_lookup_error);
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            if (l.this.getActivity() != null) {
                sb.a.i(l.this.D, R.string.profile_updating_progress);
                l.this.i1();
                Bakery.w().D().b(l.this.f15242k, false);
            }
        }
    }

    class c implements jc.b<Void> {
        c() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            lc.c.h(l.this.f15240h);
            if (l.this.getActivity() != null) {
                sb.a.i(l.this.D, R.string.error_updating_location);
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            lc.c.h(l.this.f15240h);
            l.this.k1();
        }
    }

    class d implements jc.b<Void> {
        d() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("FragmentMyProfileLocation", "errorCode code=" + cmbErrorCode.getErrorCode());
            lc.c.h(l.this.f15240h);
            if (l.this.getActivity() != null) {
                sb.a.i(l.this.D, R.string.error_updating_location);
            }
        }

        /* renamed from: c */
        public void a(Void voidR, SuccessStatus successStatus) {
            l.this.i1();
            Bakery.w().D().b(l.this.f15243l, false);
        }
    }

    private void C1() {
        this.f15243l = new c();
        this.f15245n = new d();
        lc.c.a(getActivity());
    }

    private void D1() {
        boolean z10;
        boolean z11;
        String str = this.f15247q;
        if (str == null || !str.equals("US")) {
            z10 = false;
        } else {
            z10 = true;
        }
        String str2 = this.f15246p;
        if (str2 == null || !str2.equals("US")) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 || (z10 && this.f15246p == null)) {
            this.C.setText(R.string.zip_code);
            this.f15237e.setHint(R.string.type_zip_code);
            this.f15237e.setInputType(2);
            if (!this.f15244m) {
                this.f15237e.setText("");
            }
            this.f15244m = true;
            return;
        }
        this.C.setText(R.string.city);
        if (!l1()) {
            this.f15237e.setText("");
            this.f15237e.setHint(R.string.type_in_city);
        }
        this.f15237e.setInputType(8192);
        if (this.f15244m) {
            this.f15237e.setText("");
        }
        this.f15244m = false;
    }

    private void E1(View view) {
        this.D = view.findViewById(R.id.linear_location);
        CmbEditText cmbEditText = (CmbEditText) view.findViewById(R.id.editText_city_zip);
        this.f15237e = cmbEditText;
        cmbEditText.setText(this.f15248t);
        this.f15237e.setOnEditorActionListener(new f(this));
        lc.c.q(getActivity(), this.f15237e);
        this.C = (CmbTextView) view.findViewById(R.id.textView_city_zip);
        D1();
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autoComplete_country);
        this.f15236d = autoCompleteTextView;
        autoCompleteTextView.setText(this.f15247q);
        this.f15236d.setAdapter(this.f15238f);
        this.f15236d.setOnEditorActionListener(new g(this));
        lc.c.q(getActivity(), this.f15236d);
        this.f15249w = null;
        this.f15236d.setOnItemClickListener(new h(this));
        CmbTextView cmbTextView = (CmbTextView) view.findViewById(R.id.textView_current_location);
        q5.f.e(cmbTextView);
        cmbTextView.setOnClickListener(new i(this));
        ((CmbTextView) view.findViewById(R.id.textView_next)).setOnClickListener(new j(this));
    }

    private void F1(Double d10, Double d11, String str, String str2, String str3, String str4) {
        Float f10;
        boolean z10;
        Float f11 = null;
        if (d10 == null) {
            f10 = null;
        } else {
            f10 = Float.valueOf(d10.floatValue());
        }
        if (d11 != null) {
            f11 = Float.valueOf(d11.floatValue());
        }
        Float f12 = f11;
        if (d10 == null || d11 == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        ((t) this.E.f(f10, f12, str, str2, str3, str4).g(com.uber.autodispose.a.a(this))).b(new d(this, z10), new e(this, z10));
    }

    /* access modifiers changed from: private */
    public void i1() {
        P0().B("CMB_SHARED_PREFS").edit().remove("last_feature_sync").apply();
    }

    private void j1() {
        ((t) this.F.f().g(com.uber.autodispose.a.a(this))).b(new k(this), new b());
    }

    /* access modifiers changed from: private */
    public void k1() {
        if (isAdded()) {
            j1();
            lc.c.a(getActivity());
            requireActivity().setResult(-1);
            requireActivity().finish();
        }
    }

    private boolean l1() {
        return this.f15237e.getText().toString().length() > 1;
    }

    private boolean m1(String str) {
        String c10 = q.c(str);
        this.f15246p = c10;
        return c10 != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p1(Optional optional) throws Exception {
        String str;
        if (optional.d()) {
            Location location = (Location) optional.c();
            if (q.e().equals("US")) {
                this.f15237e.setText(getString(R.string.city_zip_format, location.getCity(), location.getZip()));
            } else {
                this.f15237e.setText(location.getCity());
            }
            this.f15236d.setAdapter(this.f15249w);
            AutoCompleteTextView autoCompleteTextView = this.f15236d;
            Location location2 = this.B;
            if (location2 == null) {
                str = null;
            } else {
                str = location2.getCountry();
            }
            autoCompleteTextView.setText(str);
            this.f15236d.setAdapter(this.f15238f);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(View view, Optional optional) throws Exception {
        boolean z10;
        String str;
        if (optional.d()) {
            Location location = (Location) optional.c();
            this.B = location;
            this.f15247q = location.getCountry();
            if (location.getZip() == null || location.getZip().isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f15244m = z10;
            if (z10) {
                str = location.getZip();
            } else {
                str = location.getCity();
            }
            this.f15248t = str;
        }
        E1(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean s1(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6) {
            return false;
        }
        G1();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean t1(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 5) {
            return false;
        }
        z1();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(AdapterView adapterView, View view, int i10, long j10) {
        z1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(View view) {
        ((m) requireActivity()).O1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        G1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(boolean z10, Location location) throws Exception {
        if (z10) {
            this.f15241j.a(null, new SuccessStatus("Updated location"));
        } else {
            this.f15245n.a(null, new SuccessStatus("Updated location"));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y1(boolean z10, Throwable th2) throws Exception {
        fa.a.g("FragmentMyProfileLocation", "Failed to update location. ", th2);
        if (z10) {
            this.f15241j.b(new CmbErrorCode(5));
        } else {
            this.f15245n.b(new CmbErrorCode(5));
        }
    }

    private void z1() {
        boolean z10;
        if (!TextUtils.isEmpty(this.f15236d.getText().toString())) {
            if (this.f15239g.length == q.f41115a.length) {
                z10 = true;
            } else {
                z10 = false;
            }
            ha.a.d(z10, "The size of the list of countries is not equal to the size of the list of country codes");
            int d10 = q.d(this.f15236d.getText().toString());
            if (d10 > 0) {
                this.f15246p = q.b(d10);
                D1();
                this.f15236d.clearFocus();
                this.f15237e.requestFocus();
                return;
            }
            sb.a.f(this.D, R.string.location_country_error);
            this.f15236d.setText("");
            this.f15236d.requestFocus();
        }
    }

    public void A1() {
        if (this.f15252z != null) {
            if (G0().a("ProfileMigration.Enabled.Android")) {
                F1(Double.valueOf(this.f15252z.getLatitude()), Double.valueOf(this.f15252z.getLongitude()), (String) null, (String) null, (String) null, (String) null);
                return;
            }
            ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
            modelProfileUpdateDelta.updateLatitude(this.f15252z.getLatitude());
            modelProfileUpdateDelta.updateLongitude(this.f15252z.getLongitude());
            if (getActivity() != null) {
                sb.a.i(this.D, R.string.location_lookup);
            }
            Bakery.w().G().p(this.f15241j, modelProfileUpdateDelta, false);
        } else if (getActivity() != null) {
            sb.a.i(this.D, R.string.location_unavailable);
        }
    }

    public boolean B1() {
        String str;
        if (!(getActivity() instanceof ActivityOnboardingLocation) || !this.f15250x.equals(this.f15248t)) {
            String str2 = this.f15246p;
            if (str2 == null || (str2.equals(this.f15247q) && this.f15250x.equals(this.f15248t))) {
                return false;
            }
        } else {
            requireActivity().setResult(-1);
            requireActivity().finish();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("User entered country: ");
        sb2.append(this.f15251y);
        sb2.append(", code: ");
        sb2.append(this.f15246p);
        sb2.append(", location: ");
        sb2.append(this.f15250x);
        sb2.append(". Sending...");
        C1();
        this.f15250x += ", " + this.f15246p;
        ModelProfileUpdateDelta modelProfileUpdateDelta = new ModelProfileUpdateDelta();
        modelProfileUpdateDelta.updateLocation(this.f15250x);
        if (G0().a("ProfileMigration.Enabled.Android")) {
            String str3 = null;
            if (this.f15244m) {
                str = null;
            } else {
                str = this.f15237e.getText().toString();
            }
            if (this.f15244m) {
                str3 = this.f15237e.getText().toString();
            }
            F1((Double) null, (Double) null, this.f15251y, str, (String) null, str3);
        } else {
            Bakery.w().G().p(this.f15245n, modelProfileUpdateDelta, false);
        }
        h hVar = new h(getActivity());
        this.f15240h = hVar;
        hVar.show();
        return true;
    }

    public void G1() {
        if (n1()) {
            B1();
        }
    }

    public void n0(EventType eventType, Bundle bundle) {
        if (eventType == EventType.LOCATION_UPDATED) {
            this.f15252z = (android.location.Location) bundle.getParcelable("location");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("New location available: ");
            sb2.append(this.f15252z);
            A1();
        }
    }

    public boolean n1() {
        this.f15250x = this.f15237e.getText().toString();
        String obj = this.f15236d.getText().toString();
        this.f15251y = obj;
        String c10 = q.c(obj);
        if (!TextUtils.isEmpty(this.f15250x) && this.f15250x.equals(this.f15248t) && !TextUtils.isEmpty(c10) && c10.equals(this.f15247q)) {
            return true;
        }
        if (!m1(this.f15251y)) {
            this.f15236d.setText("");
            this.f15236d.setHint(getString(R.string.location_country_not_valid));
            this.f15236d.setHintTextColor(getResources().getColor(R.color.hot_pink));
            this.f15236d.requestFocus();
            lc.c.f(requireActivity(), this.f15236d);
            return false;
        }
        if (TextUtils.isEmpty(this.f15250x)) {
            if (this.f15244m) {
                this.f15237e.setHint(getString(R.string.location_zip_not_valid));
            } else {
                this.f15237e.setHint(getString(R.string.location_city_not_valid));
            }
            this.f15237e.setHintTextColor(getResources().getColor(R.color.hot_pink));
            this.f15237e.requestFocus();
            lc.c.f(requireActivity(), this.f15237e);
        }
        if (TextUtils.isEmpty(this.f15251y) || TextUtils.isEmpty(this.f15250x)) {
            return false;
        }
        return true;
    }

    public void onAttach(@NonNull Context context) {
        Bakery.j().U0(this);
        super.onAttach(context);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15239g = getResources().getStringArray(R.array.country_names_array);
        this.f15238f = new ArrayAdapter<>(requireActivity(), 17367043, this.f15239g);
        Bakery.w().z().f("Onboarding Location Input");
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_location_dls, viewGroup, false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        lc.c.i(this.f15240h);
        this.f15245n = null;
        this.f15243l = null;
        this.f15242k = null;
        i.d(this, EventType.LOCATION_UPDATED);
    }

    public void onResume() {
        super.onResume();
        this.f15242k = new a();
        this.f15241j = new b();
        i.a(this, EventType.LOCATION_UPDATED);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((t) this.F.f().E(sj.a.a()).g(com.uber.autodispose.a.a(this))).b(new a(this, view), new c());
    }
}
