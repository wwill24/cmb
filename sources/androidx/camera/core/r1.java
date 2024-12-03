package androidx.camera.core;

import java.io.File;

public final /* synthetic */ class r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageSaver f2881a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ File f2882b;

    public /* synthetic */ r1(ImageSaver imageSaver, File file) {
        this.f2881a = imageSaver;
        this.f2882b = file;
    }

    public final void run() {
        this.f2881a.m(this.f2882b);
    }
}
