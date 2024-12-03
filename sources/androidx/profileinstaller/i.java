package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f6170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f6171b;

    public /* synthetic */ i(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f6170a = profileInstallerInitializer;
        this.f6171b = context;
    }

    public final void run() {
        this.f6170a.i(this.f6171b);
    }
}
