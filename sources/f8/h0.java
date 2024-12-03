package f8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.enums.EventType;
import h5.i;
import j5.n;
import lc.c;
import z9.h;

public class h0 extends n {

    /* renamed from: k  reason: collision with root package name */
    private CmbEditText f14895k;

    /* renamed from: l  reason: collision with root package name */
    private CmbEditText f14896l;

    /* renamed from: m  reason: collision with root package name */
    private String f14897m;

    /* renamed from: n  reason: collision with root package name */
    private String f14898n;

    /* renamed from: p  reason: collision with root package name */
    private View f14899p;

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            h0 h0Var = h0.this;
            h hVar = h0Var.f15615d;
            if (hVar != null) {
                hVar.X(h0Var.b0(false), h0.this);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public static boolean W0() {
        return !TextUtils.isEmpty(Bakery.w().G().j().getOccupation());
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Occupation";
    }

    public void V0() {
        C0().f("Onboarding - Occupation");
    }

    public boolean b0(boolean z10) {
        CmbEditText cmbEditText = this.f14895k;
        if (cmbEditText == null || this.f14896l == null) {
            return !TextUtils.isEmpty(this.f14897m);
        }
        String obj = cmbEditText.getText().toString();
        String obj2 = this.f14896l.getText().toString();
        M0().j().setEmployer(obj2);
        M0().j().setOccupation(obj);
        i.b(EventType.PROFILE_UPDATE);
        if (!TextUtils.isEmpty(obj)) {
            this.f15616e.updateOccupation(obj);
            if (!TextUtils.isEmpty(obj2)) {
                this.f15616e.updateEmployer(obj2);
                return true;
            }
            if (z10) {
                sb.a.k(this.f14899p, R.string.error_workplace_required);
            }
            return false;
        }
        if (z10) {
            sb.a.k(this.f14899p, R.string.error_occupation_required);
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f14897m = M0().j().getOccupation();
            this.f14898n = M0().j().getEmployer();
            return;
        }
        this.f14897m = bundle.getString(ProfileConstants.Field.USER_OCCUPATION);
        this.f14898n = bundle.getString(ProfileConstants.Field.USER_EMPLOYER);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_occupation_dls, viewGroup, false);
        this.f14899p = inflate;
        this.f14895k = (CmbEditText) inflate.findViewById(R.id.editText_occupation);
        this.f14896l = (CmbEditText) this.f14899p.findViewById(R.id.editText_employer);
        a aVar = new a();
        this.f14895k.addTextChangedListener(aVar);
        this.f14896l.addTextChangedListener(aVar);
        this.f14895k.setText(this.f14897m);
        this.f14896l.setText(this.f14898n);
        return this.f14899p;
    }

    public void onResume() {
        super.onResume();
        if (isAdded()) {
            c.e(requireActivity());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ProfileConstants.Field.USER_OCCUPATION, this.f14895k.getText().toString());
        bundle.putString(ProfileConstants.Field.USER_EMPLOYER, this.f14896l.getText().toString());
    }
}
