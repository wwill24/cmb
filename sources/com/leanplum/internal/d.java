package com.leanplum.internal;

import android.content.DialogInterface;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f22208a;

    public /* synthetic */ d(boolean z10) {
        this.f22208a = z10;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        ActionManager.getInstance().setPaused(this.f22208a);
    }
}
