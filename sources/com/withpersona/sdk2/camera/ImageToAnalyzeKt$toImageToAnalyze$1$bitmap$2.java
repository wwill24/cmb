package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import android.media.Image;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ImageToAnalyzeKt$toImageToAnalyze$1$bitmap$2 extends Lambda implements Function0<Bitmap> {
    final /* synthetic */ Image $image;
    final /* synthetic */ int $rotationDegrees;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageToAnalyzeKt$toImageToAnalyze$1$bitmap$2(Image image, int i10) {
        super(0);
        this.$image = image;
        this.$rotationDegrees = i10;
    }

    /* renamed from: a */
    public final Bitmap invoke() {
        return ImageToAnalyzeKt.c(this.$image, this.$rotationDegrees);
    }
}
