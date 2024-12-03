package com.google.firebase.installations;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f21087a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21088b;

    public /* synthetic */ c(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f21087a = firebaseInstallations;
        this.f21088b = z10;
    }

    public final void run() {
        this.f21087a.lambda$getToken$2(this.f21088b);
    }
}
