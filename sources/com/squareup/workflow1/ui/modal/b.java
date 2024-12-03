package com.squareup.workflow1.ui.modal;

import android.content.DialogInterface;
import com.squareup.workflow1.ui.modal.AlertScreen;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AlertScreen f23283a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AlertScreen.Button f23284b;

    public /* synthetic */ b(AlertScreen alertScreen, AlertScreen.Button button) {
        this.f23283a = alertScreen;
        this.f23284b = button;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        AlertContainer.j(this.f23283a, this.f23284b, dialogInterface, i10);
    }
}
