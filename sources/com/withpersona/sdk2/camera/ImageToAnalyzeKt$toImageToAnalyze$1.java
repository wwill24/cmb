package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import android.media.Image;
import gk.f;
import zg.a;

public final class ImageToAnalyzeKt$toImageToAnalyze$1 implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Image f14137a;

    /* renamed from: b  reason: collision with root package name */
    private final f f14138b;

    /* renamed from: c  reason: collision with root package name */
    private final f f14139c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14140d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14141e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14142f;

    ImageToAnalyzeKt$toImageToAnalyze$1(Image image, int i10) {
        this.f14137a = image;
        this.f14138b = b.b(new ImageToAnalyzeKt$toImageToAnalyze$1$inputImage$2(image, i10));
        this.f14139c = b.b(new ImageToAnalyzeKt$toImageToAnalyze$1$bitmap$2(image, i10));
        this.f14140d = image.getWidth();
        this.f14141e = image.getHeight();
        this.f14142f = i10;
    }

    public int a() {
        return this.f14142f;
    }

    public Bitmap b() {
        return (Bitmap) this.f14139c.getValue();
    }

    public a c() {
        return (a) this.f14138b.getValue();
    }

    public int getHeight() {
        return this.f14141e;
    }

    public int getWidth() {
        return this.f14140d;
    }

    public Image t() {
        return this.f14137a;
    }
}
