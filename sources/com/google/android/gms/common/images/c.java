package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zam;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected int f38917a;

    /* access modifiers changed from: protected */
    public abstract void a(Drawable drawable, boolean z10, boolean z11, boolean z12);

    /* access modifiers changed from: package-private */
    public final void b(Context context, zam zam, boolean z10) {
        Drawable drawable;
        int i10 = this.f38917a;
        if (i10 != 0) {
            drawable = context.getResources().getDrawable(i10);
        } else {
            drawable = null;
        }
        a(drawable, z10, false, false);
    }

    /* access modifiers changed from: package-private */
    public final void c(Context context, Bitmap bitmap, boolean z10) {
        com.google.android.gms.common.internal.c.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
