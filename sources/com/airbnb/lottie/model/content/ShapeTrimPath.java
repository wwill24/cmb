package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.u;
import x2.b;
import y2.c;

public class ShapeTrimPath implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f8687a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f8688b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8689c;

    /* renamed from: d  reason: collision with root package name */
    private final b f8690d;

    /* renamed from: e  reason: collision with root package name */
    private final b f8691e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8692f;

    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type b(int i10) {
            if (i10 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i10 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i10);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z10) {
        this.f8687a = str;
        this.f8688b = type;
        this.f8689c = bVar;
        this.f8690d = bVar2;
        this.f8691e = bVar3;
        this.f8692f = z10;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new u(aVar, this);
    }

    public b b() {
        return this.f8690d;
    }

    public String c() {
        return this.f8687a;
    }

    public b d() {
        return this.f8691e;
    }

    public b e() {
        return this.f8689c;
    }

    public Type f() {
        return this.f8688b;
    }

    public boolean g() {
        return this.f8692f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f8689c + ", end: " + this.f8690d + ", offset: " + this.f8691e + "}";
    }
}
