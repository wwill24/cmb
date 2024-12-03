package com.coffeemeetsbagel.phone_login.country_code_picker;

import a7.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.country.CmbCountry;
import com.coffeemeetsbagel.country.CountryConstants;
import com.coffeemeetsbagel.phone_login.PhoneCodeViewModel;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

public final class CountryCodePickerFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public a f35698a;

    /* renamed from: b  reason: collision with root package name */
    public CountryCodePickerView f35699b;

    /* renamed from: c  reason: collision with root package name */
    private final f f35700c = FragmentViewModelLazyKt.a(this, l.b(PhoneCodeViewModel.class), new CountryCodePickerFragment$special$$inlined$activityViewModels$default$1(this), new CountryCodePickerFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new CountryCodePickerFragment$special$$inlined$activityViewModels$default$3(this));

    /* renamed from: d  reason: collision with root package name */
    private boolean f35701d = true;

    /* access modifiers changed from: private */
    public static final void E0(CountryCodePickerFragment countryCodePickerFragment, CmbCountry cmbCountry) {
        j.g(countryCodePickerFragment, "this$0");
        PhoneCodeViewModel D0 = countryCodePickerFragment.D0();
        j.f(cmbCountry, "it");
        D0.w(cmbCountry);
        countryCodePickerFragment.f35701d = false;
        countryCodePickerFragment.D0().C(PhoneCodeViewModel.ViewState.PHONE);
    }

    /* access modifiers changed from: private */
    public static final void F0(CountryCodePickerFragment countryCodePickerFragment, View view) {
        j.g(countryCodePickerFragment, "this$0");
        countryCodePickerFragment.D0().C(PhoneCodeViewModel.ViewState.PHONE);
    }

    public final a B0() {
        a aVar = this.f35698a;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final CountryCodePickerView C0() {
        CountryCodePickerView countryCodePickerView = this.f35699b;
        if (countryCodePickerView != null) {
            return countryCodePickerView;
        }
        j.y("countryCodePickView");
        return null;
    }

    public final PhoneCodeViewModel D0() {
        return (PhoneCodeViewModel) this.f35700c.getValue();
    }

    public final void G0(CountryCodePickerView countryCodePickerView) {
        j.g(countryCodePickerView, "<set-?>");
        this.f35699b = countryCodePickerView;
    }

    public void onAttach(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        Bakery.j().E1(this);
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.country_code_picker_view, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type com.coffeemeetsbagel.phone_login.country_code_picker.CountryCodePickerView");
        G0((CountryCodePickerView) inflate);
        return C0();
    }

    public void onResume() {
        super.onResume();
        B0().g("Phone Login Country Code Picker");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        b bVar = new b(CountryConstants.f11583a.h(), new c(this));
        RecyclerView recyclerView = (RecyclerView) C0().findViewById(R.id.country_code_picker_recycler);
        j.e(recyclerView, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.h(new i(recyclerView.getContext(), linearLayoutManager.n2()));
        recyclerView.setAdapter(bVar);
        C0().setBackButtonEnabled(true);
        C0().f35643a.setOnClickListener(new d(this));
    }
}
