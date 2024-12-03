package com.withpersona.sdk2.inquiry.governmentid.network;

import com.withpersona.sdk2.camera.ImageIdMetadata;
import kotlin.jvm.internal.j;

public final class a {
    public static final boolean a(AutocaptureState autocaptureState) {
        j.g(autocaptureState, "<this>");
        if (autocaptureState.c().size() < 3) {
            return false;
        }
        int i10 = 0;
        for (ImageIdMetadata a10 : autocaptureState.c()) {
            i10 += a10.a().length();
        }
        double size = ((double) i10) / ((double) autocaptureState.c().size());
        double d10 = 0.0d;
        for (ImageIdMetadata imageIdMetadata : autocaptureState.c()) {
            d10 += (((double) imageIdMetadata.a().length()) - size) * (((double) imageIdMetadata.a().length()) - size);
        }
        if (Math.sqrt(d10 / ((double) autocaptureState.c().size())) / size < 0.05d) {
            return true;
        }
        return false;
    }

    public static final AutocaptureState b(AutocaptureState autocaptureState, ImageIdMetadata imageIdMetadata) {
        j.g(autocaptureState, "<this>");
        j.g(imageIdMetadata, "newFrame");
        return autocaptureState.a(CollectionsKt___CollectionsKt.i0(CollectionsKt___CollectionsKt.t0(autocaptureState.c(), 2), imageIdMetadata));
    }
}
