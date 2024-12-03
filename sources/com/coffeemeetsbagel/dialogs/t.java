package com.coffeemeetsbagel.dialogs;

import android.view.View;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f12157a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogPrimarySecondaryVertical f12158b;

    public /* synthetic */ t(Function0 function0, DialogPrimarySecondaryVertical dialogPrimarySecondaryVertical) {
        this.f12157a = function0;
        this.f12158b = dialogPrimarySecondaryVertical;
    }

    public final void onClick(View view) {
        DialogPrimarySecondaryVertical.d(this.f12157a, this.f12158b, view);
    }
}
