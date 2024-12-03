package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.widget.CompoundButton;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;

public final /* synthetic */ class h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UiComponent.InputCheckbox f27582a;

    public /* synthetic */ h(UiComponent.InputCheckbox inputCheckbox) {
        this.f27582a = inputCheckbox;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        InputsKt.i(this.f27582a, compoundButton, z10);
    }
}
