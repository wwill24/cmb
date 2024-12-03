package com.withpersona.sdk2.camera;

import android.media.Image;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import zg.a;

final class ImageToAnalyzeKt$toImageToAnalyze$1$inputImage$2 extends Lambda implements Function0<a> {
    final /* synthetic */ Image $image;
    final /* synthetic */ int $rotationDegrees;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageToAnalyzeKt$toImageToAnalyze$1$inputImage$2(Image image, int i10) {
        super(0);
        this.$image = image;
        this.$rotationDegrees = i10;
    }

    /* renamed from: a */
    public final a invoke() {
        a c10 = a.c(this.$image, this.$rotationDegrees);
        j.f(c10, "fromMediaImage(\n        …  rotationDegrees\n      )");
        return c10;
    }
}
