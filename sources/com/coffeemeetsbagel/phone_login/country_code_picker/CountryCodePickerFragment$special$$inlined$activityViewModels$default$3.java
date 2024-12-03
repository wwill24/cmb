package com.coffeemeetsbagel.phone_login.country_code_picker;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public final class CountryCodePickerFragment$special$$inlined$activityViewModels$default$3 extends Lambda implements Function0<i0.b> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryCodePickerFragment$special$$inlined$activityViewModels$default$3(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* renamed from: a */
    public final i0.b invoke() {
        i0.b defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        j.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
