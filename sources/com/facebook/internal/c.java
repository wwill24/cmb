package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;

public final /* synthetic */ class c implements WebDialog.OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookDialogFragment f37846a;

    public /* synthetic */ c(FacebookDialogFragment facebookDialogFragment) {
        this.f37846a = facebookDialogFragment;
    }

    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        FacebookDialogFragment.m113initDialog$lambda1(this.f37846a, bundle, facebookException);
    }
}
