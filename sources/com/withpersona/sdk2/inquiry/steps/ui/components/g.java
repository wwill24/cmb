package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class g implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f27580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f27581b;

    public /* synthetic */ g(EditText editText, Function0 function0) {
        this.f27580a = editText;
        this.f27581b = function0;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return InputsKt.u(this.f27580a, this.f27581b, view, i10, keyEvent);
    }
}
