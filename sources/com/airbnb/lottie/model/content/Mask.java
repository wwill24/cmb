package com.airbnb.lottie.model.content;

import x2.d;
import x2.h;

public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f8635a;

    /* renamed from: b  reason: collision with root package name */
    private final h f8636b;

    /* renamed from: c  reason: collision with root package name */
    private final d f8637c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8638d;

    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z10) {
        this.f8635a = maskMode;
        this.f8636b = hVar;
        this.f8637c = dVar;
        this.f8638d = z10;
    }

    public MaskMode a() {
        return this.f8635a;
    }

    public h b() {
        return this.f8636b;
    }

    public d c() {
        return this.f8637c;
    }

    public boolean d() {
        return this.f8638d;
    }
}
