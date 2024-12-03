package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.internal.ResultProcessor;

public final /* synthetic */ class e implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextSwitchDialog f37832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResultProcessor f37833b;

    public /* synthetic */ e(ContextSwitchDialog contextSwitchDialog, ResultProcessor resultProcessor) {
        this.f37832a = contextSwitchDialog;
        this.f37833b = resultProcessor;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return ContextSwitchDialog.m105registerCallbackImpl$lambda3(this.f37832a, this.f37833b, i10, intent);
    }
}
