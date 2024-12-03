package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.c;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f38914a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f38915b;

    /* renamed from: c  reason: collision with root package name */
    private final CountDownLatch f38916c;

    public b(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
        this.f38914a = uri;
        this.f38915b = bitmap;
        this.f38916c = countDownLatch;
    }

    public final void run() {
        c.a("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f38915b;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) ImageManager.h((ImageManager) null).remove(this.f38914a);
        if (imageReceiver != null) {
            ArrayList a10 = imageReceiver.f38907b;
            int size = a10.size();
            for (int i10 = 0; i10 < size; i10++) {
                c cVar = (c) a10.get(i10);
                Bitmap bitmap2 = this.f38915b;
                if (bitmap2 == null || bitmap == null) {
                    ImageManager.f((ImageManager) null).put(this.f38914a, Long.valueOf(SystemClock.elapsedRealtime()));
                    cVar.b(ImageManager.a((ImageManager) null), ImageManager.c((ImageManager) null), false);
                } else {
                    cVar.c(ImageManager.a((ImageManager) null), bitmap2, false);
                }
                ImageManager.g((ImageManager) null).remove(cVar);
            }
        }
        this.f38916c.countDown();
        synchronized (ImageManager.f38904a) {
            ImageManager.f38905b.remove(this.f38914a);
        }
    }
}
