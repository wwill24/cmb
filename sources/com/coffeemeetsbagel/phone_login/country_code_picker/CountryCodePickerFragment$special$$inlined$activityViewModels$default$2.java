package com.coffeemeetsbagel.phone_login.country_code_picker;

import androidx.fragment.app.Fragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import m1.a;

public final class CountryCodePickerFragment$special$$inlined$activityViewModels$default$2 extends Lambda implements Function0<a> {
    final /* synthetic */ Function0 $extrasProducer;
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryCodePickerFragment$special$$inlined$activityViewModels$default$2(Function0 function0, Fragment fragment) {
        super(0);
        this.$extrasProducer = function0;
        this.$this_activityViewModels = fragment;
    }

    /* renamed from: a */
    public final a invoke() {
        a aVar;
        Function0 function0 = this.$extrasProducer;
        if (function0 != null && (aVar = (a) function0.invoke()) != null) {
            return aVar;
        }
        a defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
        j.f(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
        return defaultViewModelCreationExtras;
    }
}
