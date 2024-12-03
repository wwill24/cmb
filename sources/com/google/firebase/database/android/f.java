package com.google.firebase.database.android;

import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.database.core.TokenProvider;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class f implements AppCheckTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f21039a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TokenProvider.TokenChangeListener f21040b;

    public /* synthetic */ f(ExecutorService executorService, TokenProvider.TokenChangeListener tokenChangeListener) {
        this.f21039a = executorService;
        this.f21040b = tokenChangeListener;
    }

    public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
        this.f21039a.execute(new c(this.f21040b, appCheckTokenResult));
    }
}
