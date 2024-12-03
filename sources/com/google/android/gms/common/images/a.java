package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.c;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f38912a;

    /* renamed from: b  reason: collision with root package name */
    private final ParcelFileDescriptor f38913b;

    public a(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f38912a = uri;
        this.f38913b = parcelFileDescriptor;
    }

    public final void run() {
        boolean z10;
        Bitmap bitmap;
        Bitmap bitmap2;
        c.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f38913b;
        boolean z11 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError unused) {
                "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f38912a));
                z11 = true;
                bitmap2 = null;
            }
            try {
                this.f38913b.close();
            } catch (IOException unused2) {
            }
            bitmap = bitmap2;
            z10 = z11;
        } else {
            z10 = false;
            bitmap = null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager.b((ImageManager) null).post(new b((ImageManager) null, this.f38912a, bitmap, z10, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused3) {
            "Latch interrupted while posting ".concat(String.valueOf(this.f38912a));
        }
    }
}
