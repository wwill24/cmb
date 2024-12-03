package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

abstract class h<S extends b> {

    /* renamed from: a  reason: collision with root package name */
    S f19978a;

    /* renamed from: b  reason: collision with root package name */
    protected g f19979b;

    public h(S s10) {
        this.f19978a = s10;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(@NonNull Canvas canvas, @NonNull Rect rect, float f10);

    /* access modifiers changed from: package-private */
    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, float f10, float f11, int i10);

    /* access modifiers changed from: package-private */
    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    /* access modifiers changed from: package-private */
    public abstract int d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: protected */
    public void f(@NonNull g gVar) {
        this.f19979b = gVar;
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Canvas canvas, @NonNull Rect rect, float f10) {
        this.f19978a.e();
        a(canvas, rect, f10);
    }
}
