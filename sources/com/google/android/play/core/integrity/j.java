package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.b;
import com.google.android.play.integrity.internal.c;
import com.google.android.play.integrity.internal.c0;
import com.google.android.play.integrity.internal.d;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final j f20481a = this;

    /* renamed from: b  reason: collision with root package name */
    private final d f20482b;

    /* renamed from: c  reason: collision with root package name */
    private final d f20483c;

    /* renamed from: d  reason: collision with root package name */
    private final d f20484d;

    /* renamed from: e  reason: collision with root package name */
    private final d f20485e;

    /* synthetic */ j(Context context, i iVar) {
        b b10 = c.b(context);
        this.f20482b = b10;
        d b11 = c0.b(o.f20491a);
        this.f20483c = b11;
        d b12 = c0.b(new v(b10, b11));
        this.f20484d = b12;
        this.f20485e = c0.b(new n(b12));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f20485e.a();
    }
}
