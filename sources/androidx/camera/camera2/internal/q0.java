package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.n0;
import java.util.List;
import u.a;

public final /* synthetic */ class q0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n0.c f1919a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f1920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f1921c;

    public /* synthetic */ q0(n0.c cVar, List list, int i10) {
        this.f1919a = cVar;
        this.f1920b = list;
        this.f1921c = i10;
    }

    public final zf.a apply(Object obj) {
        return this.f1919a.m(this.f1920b, this.f1921c, (TotalCaptureResult) obj);
    }
}
