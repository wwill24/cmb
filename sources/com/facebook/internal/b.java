package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;

public final /* synthetic */ class b implements WebDialog.OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FacebookDialogFragment f37845a;

    public /* synthetic */ b(FacebookDialogFragment facebookDialogFragment) {
        this.f37845a = facebookDialogFragment;
    }

    public final void onComplete(Bundle bundle, FacebookException facebookException) {
        FacebookDialogFragment.m112initDialog$lambda0(this.f37845a, bundle, facebookException);
    }
}
