package com.coffeemeetsbagel.phone_login.country_code_picker;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.k0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class CountryCodePickerFragment$special$$inlined$activityViewModels$default$1 extends Lambda implements Function0<k0> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryCodePickerFragment$special$$inlined$activityViewModels$default$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* renamed from: a */
    public final k0 invoke() {
        k0 viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
        j.f(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
