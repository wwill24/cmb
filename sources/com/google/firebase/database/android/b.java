package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.core.TokenProvider;

public final /* synthetic */ class b implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.GetTokenCompletionListener f21033a;

    public /* synthetic */ b(TokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.f21033a = getTokenCompletionListener;
    }

    public final void onFailure(Exception exc) {
        this.f21033a.onError(exc.getMessage());
    }
}
