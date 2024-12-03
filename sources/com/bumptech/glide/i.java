package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.i;
import d4.e;
import d4.g;
import f4.j;

public abstract class i<CHILD extends i<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private g<? super TranscodeType> f9215a = e.c();

    private CHILD c() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (i) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public final g<? super TranscodeType> b() {
        return this.f9215a;
    }

    @NonNull
    public final CHILD d(@NonNull g<? super TranscodeType> gVar) {
        this.f9215a = (g) j.d(gVar);
        return c();
    }
}
