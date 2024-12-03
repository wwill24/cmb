package androidx.camera.core;

import androidx.camera.core.ImageSaver;

public final /* synthetic */ class t1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f2902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageSaver.SaveError f2903b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f2904c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f2905d;

    public /* synthetic */ t1(ImageSaver imageSaver, ImageSaver.SaveError saveError, String str, Throwable th2) {
        this.f2902a = imageSaver;
        this.f2903b = saveError;
        this.f2904c = str;
        this.f2905d = th2;
    }

    public final void run() {
        this.f2902a.k(this.f2903b, this.f2904c, this.f2905d);
    }
}
