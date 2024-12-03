package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

public final /* synthetic */ class c implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextCreateDialog f37829a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResultProcessor f37830b;

    public /* synthetic */ c(ContextCreateDialog contextCreateDialog, ResultProcessor resultProcessor) {
        this.f37829a = contextCreateDialog;
        this.f37830b = resultProcessor;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return ContextCreateDialog.m103registerCallbackImpl$lambda3(this.f37829a, this.f37830b, i10, intent);
    }
}
