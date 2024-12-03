package com.coffeemeetsbagel.dialogs;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class v implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f12161a;

    public /* synthetic */ v(Function0 function0) {
        this.f12161a = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        DialogPrimarySecondaryVertical.f(this.f12161a, dialogInterface);
    }
}
