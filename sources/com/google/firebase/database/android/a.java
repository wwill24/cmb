package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f21032a;

    public /* synthetic */ a(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f21032a = getTokenCompletionListener;
    }

    public final void onSuccess(Object obj) {
        this.f21032a.onSuccess(((AppCheckTokenResult) obj).getToken());
    }
}
