package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.b;

abstract class i<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected j f19980a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f19981b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f19982c;

    protected i(int i10) {
        this.f19981b = new float[(i10 * 2)];
        this.f19982c = new int[i10];
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: protected */
    public float b(int i10, int i11, int i12) {
        return ((float) (i10 - i11)) / ((float) i12);
    }

    public abstract void c();

    public abstract void d(@NonNull b bVar);

    /* access modifiers changed from: protected */
    public void e(@NonNull j jVar) {
        this.f19980a = jVar;
    }

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
