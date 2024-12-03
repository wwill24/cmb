package com.coffeemeetsbagel.dialogs;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class z implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f12165a;

    public /* synthetic */ z(Function0 function0) {
        this.f12165a = function0;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a0.e(this.f12165a, dialogInterface);
    }
}
