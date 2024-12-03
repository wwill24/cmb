package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.c;
import androidx.camera.core.impl.utils.q;
import androidx.camera.core.v1;
import androidx.camera.view.PreviewView;
import androidx.core.util.h;

final class f {

    /* renamed from: g  reason: collision with root package name */
    private static final PreviewView.ScaleType f3479g = PreviewView.ScaleType.FILL_CENTER;

    /* renamed from: a  reason: collision with root package name */
    private Size f3480a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f3481b;

    /* renamed from: c  reason: collision with root package name */
    private int f3482c;

    /* renamed from: d  reason: collision with root package name */
    private int f3483d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3484e;

    /* renamed from: f  reason: collision with root package name */
    private PreviewView.ScaleType f3485f = f3479g;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3486a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.view.PreviewView$ScaleType[] r0 = androidx.camera.view.PreviewView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3486a = r0
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3486a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3486a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3486a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f3486a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f3486a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.f.a.<clinit>():void");
        }
    }

    f() {
    }

    private static RectF b(RectF rectF, float f10) {
        float f11 = f10 + f10;
        return new RectF(f11 - rectF.right, rectF.top, f11 - rectF.left, rectF.bottom);
    }

    private Size e() {
        if (q.f(this.f3482c)) {
            return new Size(this.f3481b.height(), this.f3481b.width());
        }
        return new Size(this.f3481b.width(), this.f3481b.height());
    }

    private RectF j(Size size, int i10) {
        h.i(k());
        Matrix h10 = h(size, i10);
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f3480a.getWidth(), (float) this.f3480a.getHeight());
        h10.mapRect(rectF);
        return rectF;
    }

    private boolean k() {
        return (this.f3481b == null || this.f3480a == null || this.f3483d == -1) ? false : true;
    }

    private static void n(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        boolean z10;
        switch (a.f3486a[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                v1.c("PreviewTransform", "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    /* access modifiers changed from: package-private */
    public Bitmap a(@NonNull Bitmap bitmap, Size size, int i10) {
        if (!k()) {
            return bitmap;
        }
        Matrix i11 = i();
        RectF j10 = j(size, i10);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(i11);
        matrix.postScale(j10.width() / ((float) this.f3480a.getWidth()), j10.height() / ((float) this.f3480a.getHeight()));
        matrix.postTranslate(j10.left, j10.top);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public Matrix c(Size size, int i10) {
        if (!k()) {
            return null;
        }
        Matrix matrix = new Matrix();
        h(size, i10).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, (float) this.f3480a.getWidth(), (float) this.f3480a.getHeight()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    /* access modifiers changed from: package-private */
    public RectF d(Size size, int i10) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        Size e10 = e();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) e10.getWidth(), (float) e10.getHeight());
        Matrix matrix = new Matrix();
        n(matrix, rectF2, rectF, this.f3485f);
        matrix.mapRect(rectF2);
        if (i10 == 1) {
            return b(rectF2, ((float) size.getWidth()) / 2.0f);
        }
        return rectF2;
    }

    /* access modifiers changed from: package-private */
    public PreviewView.ScaleType f() {
        return this.f3485f;
    }

    /* access modifiers changed from: package-private */
    public Rect g() {
        return this.f3481b;
    }

    /* access modifiers changed from: package-private */
    public Matrix h(Size size, int i10) {
        RectF rectF;
        h.i(k());
        if (l(size)) {
            rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        } else {
            rectF = d(size, i10);
        }
        Matrix c10 = q.c(new RectF(this.f3481b), rectF, this.f3482c);
        if (this.f3484e) {
            if (q.f(this.f3482c)) {
                c10.preScale(1.0f, -1.0f, (float) this.f3481b.centerX(), (float) this.f3481b.centerY());
            } else {
                c10.preScale(-1.0f, 1.0f, (float) this.f3481b.centerX(), (float) this.f3481b.centerY());
            }
        }
        return c10;
    }

    /* access modifiers changed from: package-private */
    public Matrix i() {
        h.i(k());
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f3480a.getWidth(), (float) this.f3480a.getHeight());
        return q.c(rectF, rectF, -c.b(this.f3483d));
    }

    /* access modifiers changed from: package-private */
    public boolean l(Size size) {
        return q.g(size, true, e(), false);
    }

    /* access modifiers changed from: package-private */
    public void m(int i10, int i11) {
        this.f3482c = i10;
        this.f3483d = i11;
    }

    /* access modifiers changed from: package-private */
    public void o(PreviewView.ScaleType scaleType) {
        this.f3485f = scaleType;
    }

    /* access modifiers changed from: package-private */
    public void p(@NonNull SurfaceRequest.f fVar, Size size, boolean z10) {
        v1.a("PreviewTransform", "Transformation info set: " + fVar + " " + size + " " + z10);
        this.f3481b = fVar.a();
        this.f3482c = fVar.b();
        this.f3483d = fVar.c();
        this.f3480a = size;
        this.f3484e = z10;
    }

    /* access modifiers changed from: package-private */
    public void q(Size size, int i10, @NonNull View view) {
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            v1.l("PreviewTransform", "Transform not applied due to PreviewView size: " + size);
        } else if (k()) {
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(i());
            } else {
                Display display = view.getDisplay();
                if (!(display == null || display.getRotation() == this.f3483d)) {
                    v1.c("PreviewTransform", "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.");
                }
            }
            RectF j10 = j(size, i10);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(j10.width() / ((float) this.f3480a.getWidth()));
            view.setScaleY(j10.height() / ((float) this.f3480a.getHeight()));
            view.setTranslationX(j10.left - ((float) view.getLeft()));
            view.setTranslationY(j10.top - ((float) view.getTop()));
        }
    }
}
