package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import java.util.concurrent.Executor;

abstract class l {

    /* renamed from: a  reason: collision with root package name */
    Size f3496a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    FrameLayout f3497b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final f f3498c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3499d = false;

    interface a {
        void a();
    }

    l(@NonNull FrameLayout frameLayout, @NonNull f fVar) {
        this.f3497b = frameLayout;
        this.f3498c = fVar;
    }

    /* access modifiers changed from: package-private */
    public Bitmap a() {
        Bitmap c10 = c();
        if (c10 == null) {
            return null;
        }
        return this.f3498c.a(c10, new Size(this.f3497b.getWidth(), this.f3497b.getHeight()), this.f3497b.getLayoutDirection());
    }

    /* access modifiers changed from: package-private */
    public abstract View b();

    /* access modifiers changed from: package-private */
    public abstract Bitmap c();

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public void f() {
        this.f3499d = true;
        h();
    }

    /* access modifiers changed from: package-private */
    public abstract void g(@NonNull SurfaceRequest surfaceRequest, a aVar);

    /* access modifiers changed from: package-private */
    public void h() {
        View b10 = b();
        if (b10 != null && this.f3499d) {
            this.f3498c.q(new Size(this.f3497b.getWidth(), this.f3497b.getHeight()), this.f3497b.getLayoutDirection(), b10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void i(@NonNull Executor executor, @NonNull PreviewView.d dVar);

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract zf.a<Void> j();
}
