package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.k;
import android.widget.RadioGroup;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class f implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f27578a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UiComponent.InputRadioGroup f27579b;

    public /* synthetic */ f(k kVar, UiComponent.InputRadioGroup inputRadioGroup) {
        this.f27578a = kVar;
        this.f27579b = inputRadioGroup;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
        InputsKt.o(this.f27578a, this.f27579b, radioGroup, i10);
    }
}
