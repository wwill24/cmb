package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class k implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f21048a;

    public /* synthetic */ k(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f21048a = getTokenCompletionListener;
    }

    public final void onSuccess(Object obj) {
        this.f21048a.onSuccess(((GetTokenResult) obj).getToken());
    }
}
