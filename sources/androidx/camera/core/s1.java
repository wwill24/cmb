package androidx.camera.core;

import android.net.Uri;

public final /* synthetic */ class s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f2888a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f2889b;

    public /* synthetic */ s1(ImageSaver imageSaver, Uri uri) {
        this.f2888a = imageSaver;
        this.f2889b = uri;
    }

    public final void run() {
        this.f2888a.l(this.f2889b);
    }
}
