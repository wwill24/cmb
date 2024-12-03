package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;

public final /* synthetic */ class b implements CallbackManagerImpl.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextChooseDialog f37827a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContextChooseDialog$registerCallbackImpl$resultProcessor$1 f37828b;

    public /* synthetic */ b(ContextChooseDialog contextChooseDialog, ContextChooseDialog$registerCallbackImpl$resultProcessor$1 contextChooseDialog$registerCallbackImpl$resultProcessor$1) {
        this.f37827a = contextChooseDialog;
        this.f37828b = contextChooseDialog$registerCallbackImpl$resultProcessor$1;
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return ContextChooseDialog.m101registerCallbackImpl$lambda4(this.f37827a, this.f37828b, i10, intent);
    }
}
