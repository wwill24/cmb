package w3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.b;
import f4.j;
import i3.h;
import java.nio.ByteBuffer;
import java.util.List;
import w3.g;

public class c extends Drawable implements g.b, Animatable {

    /* renamed from: a  reason: collision with root package name */
    private final a f18198a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18199b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18200c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18201d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18202e;

    /* renamed from: f  reason: collision with root package name */
    private int f18203f;

    /* renamed from: g  reason: collision with root package name */
    private int f18204g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f18205h;

    /* renamed from: j  reason: collision with root package name */
    private Paint f18206j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f18207k;

    /* renamed from: l  reason: collision with root package name */
    private List<b> f18208l;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f18209a;

        a(g gVar) {
            this.f18209a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, g3.a aVar, h<Bitmap> hVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.c(context), aVar, i10, i11, hVar, bitmap)));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f18207k == null) {
            this.f18207k = new Rect();
        }
        return this.f18207k;
    }

    private Paint h() {
        if (this.f18206j == null) {
            this.f18206j = new Paint(2);
        }
        return this.f18206j;
    }

    private void j() {
        List<b> list = this.f18208l;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f18208l.get(i10).b(this);
            }
        }
    }

    private void l() {
        this.f18203f = 0;
    }

    private void n() {
        j.a(!this.f18201d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f18198a.f18209a.f() == 1) {
            invalidateSelf();
        } else if (!this.f18199b) {
            this.f18199b = true;
            this.f18198a.f18209a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f18199b = false;
        this.f18198a.f18209a.s(this);
    }

    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f18203f++;
        }
        int i10 = this.f18204g;
        if (i10 != -1 && this.f18203f >= i10) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f18198a.f18209a.b();
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.f18201d) {
            if (this.f18205h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.f18205h = false;
            }
            canvas.drawBitmap(this.f18198a.f18209a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f18198a.f18209a.e();
    }

    public int f() {
        return this.f18198a.f18209a.f();
    }

    public int g() {
        return this.f18198a.f18209a.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f18198a;
    }

    public int getIntrinsicHeight() {
        return this.f18198a.f18209a.h();
    }

    public int getIntrinsicWidth() {
        return this.f18198a.f18209a.k();
    }

    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f18198a.f18209a.j();
    }

    public boolean isRunning() {
        return this.f18199b;
    }

    public void k() {
        this.f18201d = true;
        this.f18198a.f18209a.a();
    }

    public void m(h<Bitmap> hVar, Bitmap bitmap) {
        this.f18198a.f18209a.o(hVar, bitmap);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f18205h = true;
    }

    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z10, boolean z11) {
        j.a(!this.f18201d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f18202e = z10;
        if (!z10) {
            o();
        } else if (this.f18200c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    public void start() {
        this.f18200c = true;
        l();
        if (this.f18202e) {
            n();
        }
    }

    public void stop() {
        this.f18200c = false;
        o();
    }

    c(a aVar) {
        this.f18202e = true;
        this.f18204g = -1;
        this.f18198a = (a) j.d(aVar);
    }
}
