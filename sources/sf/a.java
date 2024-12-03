package sf;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;

public class a {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f24473i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f24474j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f24475k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f24476l = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f24477a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f24478b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f24479c;

    /* renamed from: d  reason: collision with root package name */
    private int f24480d;

    /* renamed from: e  reason: collision with root package name */
    private int f24481e;

    /* renamed from: f  reason: collision with root package name */
    private int f24482f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f24483g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f24484h;

    public a() {
        this(-16777216);
    }

    public void a(@NonNull Canvas canvas, Matrix matrix, @NonNull RectF rectF, int i10, float f10, float f11) {
        boolean z10;
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        int i11 = i10;
        float f12 = f11;
        if (f12 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Path path = this.f24483g;
        if (z10) {
            int[] iArr = f24475k;
            iArr[0] = 0;
            iArr[1] = this.f24482f;
            iArr[2] = this.f24481e;
            iArr[3] = this.f24480d;
            float f13 = f10;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f10, f12);
            path.close();
            float f14 = (float) (-i11);
            rectF2.inset(f14, f14);
            int[] iArr2 = f24475k;
            iArr2[0] = 0;
            iArr2[1] = this.f24480d;
            iArr2[2] = this.f24481e;
            iArr2[3] = this.f24482f;
        }
        float width = rectF.width() / 2.0f;
        if (width > 0.0f) {
            float f15 = 1.0f - (((float) i11) / width);
            float[] fArr = f24476l;
            fArr[1] = f15;
            fArr[2] = ((1.0f - f15) / 2.0f) + f15;
            this.f24478b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f24475k, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, rectF.height() / rectF.width());
            if (!z10) {
                canvas2.clipPath(path, Region.Op.DIFFERENCE);
                canvas2.drawPath(path, this.f24484h);
            }
            canvas.drawArc(rectF, f10, f11, true, this.f24478b);
            canvas.restore();
        }
    }

    public void b(@NonNull Canvas canvas, Matrix matrix, @NonNull RectF rectF, int i10) {
        rectF.bottom += (float) i10;
        rectF.offset(0.0f, (float) (-i10));
        int[] iArr = f24473i;
        iArr[0] = this.f24482f;
        iArr[1] = this.f24481e;
        iArr[2] = this.f24480d;
        Paint paint = this.f24479c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f24474j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f24479c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f24477a;
    }

    public void d(int i10) {
        this.f24480d = androidx.core.graphics.a.l(i10, 68);
        this.f24481e = androidx.core.graphics.a.l(i10, 20);
        this.f24482f = androidx.core.graphics.a.l(i10, 0);
        this.f24477a.setColor(this.f24480d);
    }

    public a(int i10) {
        this.f24483g = new Path();
        Paint paint = new Paint();
        this.f24484h = paint;
        this.f24477a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f24478b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f24479c = new Paint(paint2);
    }
}
