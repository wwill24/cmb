package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f6172a;

    public /* synthetic */ j(Context context) {
        this.f6172a = context;
    }

    public final void run() {
        ProfileInstallerInitializer.l(this.f6172a);
    }
}
