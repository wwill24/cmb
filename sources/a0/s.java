package a0;

import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import u.a;

public final /* synthetic */ class s implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f88a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput.GlTransformOptions f89b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Size f90c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f91d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f92e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ boolean f93f;

    public /* synthetic */ s(u uVar, SurfaceOutput.GlTransformOptions glTransformOptions, Size size, Rect rect, int i10, boolean z10) {
        this.f88a = uVar;
        this.f89b = glTransformOptions;
        this.f90c = size;
        this.f91d = rect;
        this.f92e = i10;
        this.f93f = z10;
    }

    public final zf.a apply(Object obj) {
        return this.f88a.E(this.f89b, this.f90c, this.f91d, this.f92e, this.f93f, (Surface) obj);
    }
}
