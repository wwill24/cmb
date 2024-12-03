package rf;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import tf.g;
import tf.k;
import tf.n;

public class a extends Drawable implements n {

    /* renamed from: a  reason: collision with root package name */
    private b f24440a;

    @NonNull
    /* renamed from: a */
    public a mutate() {
        this.f24440a = new b(this.f24440a);
        return this;
    }

    public void draw(Canvas canvas) {
        b bVar = this.f24440a;
        if (bVar.f24442b) {
            bVar.f24441a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f24440a;
    }

    public int getOpacity() {
        return this.f24440a.f24441a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.f24440a.f24441a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f24440a.f24441a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e10 = b.e(iArr);
        b bVar = this.f24440a;
        if (bVar.f24442b == e10) {
            return onStateChange;
        }
        bVar.f24442b = e10;
        return true;
    }

    public void setAlpha(int i10) {
        this.f24440a.f24441a.setAlpha(i10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24440a.f24441a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(@NonNull k kVar) {
        this.f24440a.f24441a.setShapeAppearanceModel(kVar);
    }

    public void setTint(int i10) {
        this.f24440a.f24441a.setTint(i10);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f24440a.f24441a.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f24440a.f24441a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    static final class b extends Drawable.ConstantState {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        g f24441a;

        /* renamed from: b  reason: collision with root package name */
        boolean f24442b;

        public b(g gVar) {
            this.f24441a = gVar;
            this.f24442b = false;
        }

        @NonNull
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.f24441a = (g) bVar.f24441a.getConstantState().newDrawable();
            this.f24442b = bVar.f24442b;
        }
    }

    private a(b bVar) {
        this.f24440a = bVar;
    }
}
