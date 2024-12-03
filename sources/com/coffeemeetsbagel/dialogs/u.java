package com.coffeemeetsbagel.dialogs;

import android.view.View;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f12159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogPrimarySecondaryVertical f12160b;

    public /* synthetic */ u(Function0 function0, DialogPrimarySecondaryVertical dialogPrimarySecondaryVertical) {
        this.f12159a = function0;
        this.f12160b = dialogPrimarySecondaryVertical;
    }

    public final void onClick(View view) {
        DialogPrimarySecondaryVertical.e(this.f12159a, this.f12160b, view);
    }
}
