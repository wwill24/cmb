package com.google.firebase.installations;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f21084a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21085b;

    public /* synthetic */ a(FirebaseInstallations firebaseInstallations, boolean z10) {
        this.f21084a = firebaseInstallations;
        this.f21085b = z10;
    }

    public final void run() {
        this.f21084a.lambda$doRegistrationOrRefresh$3(this.f21085b);
    }
}
