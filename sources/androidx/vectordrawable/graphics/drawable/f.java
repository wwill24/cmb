package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.m;
import androidx.core.graphics.d;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f extends e {

    /* renamed from: l  reason: collision with root package name */
    static final PorterDuff.Mode f7085l = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private h f7086b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f7087c;

    /* renamed from: d  reason: collision with root package name */
    private ColorFilter f7088d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7089e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7090f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable.ConstantState f7091g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f7092h;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f7093j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f7094k;

    private static class b extends C0079f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f7121b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f7120a = androidx.core.graphics.d.d(string2);
            }
            this.f7122c = m.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (m.h(xmlPullParser, "pathData")) {
                TypedArray i10 = m.i(resources, theme, attributeSet, a.f7058d);
                f(i10, xmlPullParser);
                i10.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f7141a;

        /* renamed from: b  reason: collision with root package name */
        g f7142b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f7143c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f7144d;

        /* renamed from: e  reason: collision with root package name */
        boolean f7145e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f7146f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f7147g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f7148h;

        /* renamed from: i  reason: collision with root package name */
        int f7149i;

        /* renamed from: j  reason: collision with root package name */
        boolean f7150j;

        /* renamed from: k  reason: collision with root package name */
        boolean f7151k;

        /* renamed from: l  reason: collision with root package name */
        Paint f7152l;

        public h(h hVar) {
            this.f7143c = null;
            this.f7144d = f.f7085l;
            if (hVar != null) {
                this.f7141a = hVar.f7141a;
                g gVar = new g(hVar.f7142b);
                this.f7142b = gVar;
                if (hVar.f7142b.f7129e != null) {
                    gVar.f7129e = new Paint(hVar.f7142b.f7129e);
                }
                if (hVar.f7142b.f7128d != null) {
                    this.f7142b.f7128d = new Paint(hVar.f7142b.f7128d);
                }
                this.f7143c = hVar.f7143c;
                this.f7144d = hVar.f7144d;
                this.f7145e = hVar.f7145e;
            }
        }

        public boolean a(int i10, int i11) {
            if (i10 == this.f7146f.getWidth() && i11 == this.f7146f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean b() {
            if (!this.f7151k && this.f7147g == this.f7143c && this.f7148h == this.f7144d && this.f7150j == this.f7145e && this.f7149i == this.f7142b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void c(int i10, int i11) {
            if (this.f7146f == null || !a(i10, i11)) {
                this.f7146f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f7151k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f7146f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f7152l == null) {
                Paint paint = new Paint();
                this.f7152l = paint;
                paint.setFilterBitmap(true);
            }
            this.f7152l.setAlpha(this.f7142b.getRootAlpha());
            this.f7152l.setColorFilter(colorFilter);
            return this.f7152l;
        }

        public boolean f() {
            return this.f7142b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f7142b.f();
        }

        public int getChangingConfigurations() {
            return this.f7141a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f7142b.g(iArr);
            this.f7151k |= g10;
            return g10;
        }

        public void i() {
            this.f7147g = this.f7143c;
            this.f7148h = this.f7144d;
            this.f7149i = this.f7142b.getRootAlpha();
            this.f7150j = this.f7145e;
            this.f7151k = false;
        }

        public void j(int i10, int i11) {
            this.f7146f.eraseColor(0);
            this.f7142b.b(new Canvas(this.f7146f), i10, i11, (ColorFilter) null);
        }

        @NonNull
        public Drawable newDrawable() {
            return new f(this);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }

        public h() {
            this.f7143c = null;
            this.f7144d = f.f7085l;
            this.f7142b = new g();
        }
    }

    f() {
        this.f7090f = true;
        this.f7092h = new float[9];
        this.f7093j = new Matrix();
        this.f7094k = new Rect();
        this.f7086b = new h();
    }

    static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (((float) Color.alpha(i10)) * f10)) << 24);
    }

    public static f b(@NonNull Resources resources, int i10, Resources.Theme theme) {
        f fVar = new f();
        fVar.f7084a = androidx.core.content.res.h.e(resources, i10, theme);
        fVar.f7091g = new i(fVar.f7084a.getConstantState());
        return fVar;
    }

    private void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f7086b;
        g gVar = hVar.f7142b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f7132h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f7108b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f7140p.put(cVar.getPathName(), cVar);
                    }
                    z10 = false;
                    hVar.f7141a = cVar.f7123d | hVar.f7141a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f7108b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f7140p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f7141a = bVar.f7123d | hVar.f7141a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f7108b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f7140p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f7141a = dVar2.f7117k | hVar.f7141a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean e() {
        if (!isAutoMirrored() || androidx.core.graphics.drawable.a.f(this) != 1) {
            return false;
        }
        return true;
    }

    private static PorterDuff.Mode f(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f7086b;
        g gVar = hVar.f7142b;
        hVar.f7144d = f(m.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = m.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            hVar.f7143c = c10;
        }
        hVar.f7145e = m.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f7145e);
        gVar.f7135k = m.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f7135k);
        float f10 = m.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f7136l);
        gVar.f7136l = f10;
        if (gVar.f7135k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (f10 > 0.0f) {
            gVar.f7133i = typedArray.getDimension(3, gVar.f7133i);
            float dimension = typedArray.getDimension(2, gVar.f7134j);
            gVar.f7134j = dimension;
            if (gVar.f7133i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(m.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f7138n = string;
                    gVar.f7140p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    /* access modifiers changed from: package-private */
    public Object c(String str) {
        return this.f7086b.f7142b.f7140p.get(str);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f7084a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f7094k);
        if (this.f7094k.width() > 0 && this.f7094k.height() > 0) {
            ColorFilter colorFilter = this.f7088d;
            if (colorFilter == null) {
                colorFilter = this.f7087c;
            }
            canvas.getMatrix(this.f7093j);
            this.f7093j.getValues(this.f7092h);
            float abs = Math.abs(this.f7092h[0]);
            float abs2 = Math.abs(this.f7092h[4]);
            float abs3 = Math.abs(this.f7092h[1]);
            float abs4 = Math.abs(this.f7092h[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f7094k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f7094k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f7094k;
                canvas.translate((float) rect.left, (float) rect.top);
                if (e()) {
                    canvas.translate((float) this.f7094k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f7094k.offsetTo(0, 0);
                this.f7086b.c(min, min2);
                if (!this.f7090f) {
                    this.f7086b.j(min, min2);
                } else if (!this.f7086b.b()) {
                    this.f7086b.j(min, min2);
                    this.f7086b.i();
                }
                this.f7086b.d(canvas, colorFilter, this.f7094k);
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z10) {
        this.f7090f = z10;
    }

    public int getAlpha() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f7086b.f7142b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7086b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f7088d;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f7084a != null) {
            return new i(this.f7084a.getConstantState());
        }
        this.f7086b.f7141a = getChangingConfigurations();
        return this.f7086b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f7086b.f7142b.f7134j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f7086b.f7142b.f7133i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f7086b.f7145e;
    }

    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful() || ((hVar = this.f7086b) != null && (hVar.g() || ((colorStateList = this.f7086b.f7143c) != null && colorStateList.isStateful())))) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f7089e && super.mutate() == this) {
            this.f7086b = new h(this.f7086b);
            this.f7089e = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z10 = false;
        h hVar = this.f7086b;
        ColorStateList colorStateList = hVar.f7143c;
        if (!(colorStateList == null || (mode = hVar.f7144d) == null)) {
            this.f7087c = i(this.f7087c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f7086b.f7142b.getRootAlpha() != i10) {
            this.f7086b.f7142b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f7086b.f7145e = z10;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f7086b;
        if (hVar.f7143c != colorStateList) {
            hVar.f7143c = colorStateList;
            this.f7087c = i(this.f7087c, colorStateList, hVar.f7144d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f7086b;
        if (hVar.f7144d != mode) {
            hVar.f7144d = mode;
            this.f7087c = i(this.f7087c, hVar.f7143c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f7153a;

        public i(Drawable.ConstantState constantState) {
            this.f7153a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f7153a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f7153a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f7084a = (VectorDrawable) this.f7153a.newDrawable();
            return fVar;
        }

        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f7084a = (VectorDrawable) this.f7153a.newDrawable(resources);
            return fVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f7084a = (VectorDrawable) this.f7153a.newDrawable(resources, theme);
            return fVar;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f7088d = colorFilter;
        invalidateSelf();
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.f$f  reason: collision with other inner class name */
    private static abstract class C0079f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected d.b[] f7120a = null;

        /* renamed from: b  reason: collision with root package name */
        String f7121b;

        /* renamed from: c  reason: collision with root package name */
        int f7122c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f7123d;

        public C0079f() {
            super();
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f7120a;
            if (bVarArr != null) {
                d.b.d(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f7120a;
        }

        public String getPathName() {
            return this.f7121b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (!androidx.core.graphics.d.b(this.f7120a, bVarArr)) {
                this.f7120a = androidx.core.graphics.d.f(bVarArr);
            } else {
                androidx.core.graphics.d.j(this.f7120a, bVarArr);
            }
        }

        public C0079f(C0079f fVar) {
            super();
            this.f7121b = fVar.f7121b;
            this.f7123d = fVar.f7123d;
            this.f7120a = androidx.core.graphics.d.f(fVar.f7120a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f7086b;
        hVar.f7142b = new g();
        TypedArray i10 = m.i(resources, theme, attributeSet, a.f7055a);
        h(i10, xmlPullParser, theme);
        i10.recycle();
        hVar.f7141a = getChangingConfigurations();
        hVar.f7151k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f7087c = i(this.f7087c, hVar.f7143c, hVar.f7144d);
    }

    f(@NonNull h hVar) {
        this.f7090f = true;
        this.f7092h = new float[9];
        this.f7093j = new Matrix();
        this.f7094k = new Rect();
        this.f7086b = hVar;
        this.f7087c = i(this.f7087c, hVar.f7143c, hVar.f7144d);
    }

    private static class c extends C0079f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f7095e;

        /* renamed from: f  reason: collision with root package name */
        androidx.core.content.res.d f7096f;

        /* renamed from: g  reason: collision with root package name */
        float f7097g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        androidx.core.content.res.d f7098h;

        /* renamed from: i  reason: collision with root package name */
        float f7099i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        float f7100j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f7101k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        float f7102l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        float f7103m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f7104n = Paint.Cap.BUTT;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f7105o = Paint.Join.MITER;

        /* renamed from: p  reason: collision with root package name */
        float f7106p = 4.0f;

        c() {
        }

        private Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i10 == 1) {
                return Paint.Cap.ROUND;
            }
            if (i10 != 2) {
                return cap;
            }
            return Paint.Cap.SQUARE;
        }

        private Paint.Join f(int i10, Paint.Join join) {
            if (i10 == 0) {
                return Paint.Join.MITER;
            }
            if (i10 == 1) {
                return Paint.Join.ROUND;
            }
            if (i10 != 2) {
                return join;
            }
            return Paint.Join.BEVEL;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f7095e = null;
            if (m.h(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f7121b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f7120a = androidx.core.graphics.d.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f7098h = m.e(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f7100j = m.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f7100j);
                this.f7104n = e(m.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f7104n);
                this.f7105o = f(m.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f7105o);
                this.f7106p = m.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f7106p);
                this.f7096f = m.e(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f7099i = m.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f7099i);
                this.f7097g = m.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f7097g);
                this.f7102l = m.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f7102l);
                this.f7103m = m.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f7103m);
                this.f7101k = m.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f7101k);
                this.f7122c = m.g(typedArray, xmlPullParser, "fillType", 13, this.f7122c);
            }
        }

        public boolean a() {
            return this.f7098h.i() || this.f7096f.i();
        }

        public boolean b(int[] iArr) {
            return this.f7096f.j(iArr) | this.f7098h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i10 = m.i(resources, theme, attributeSet, a.f7057c);
            h(i10, xmlPullParser, theme);
            i10.recycle();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f7100j;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f7098h.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f7099i;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f7096f.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f7097g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f7102l;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f7103m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f7101k;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f10) {
            this.f7100j = f10;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i10) {
            this.f7098h.k(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f10) {
            this.f7099i = f10;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i10) {
            this.f7096f.k(i10);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f10) {
            this.f7097g = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f10) {
            this.f7102l = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f10) {
            this.f7103m = f10;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f10) {
            this.f7101k = f10;
        }

        c(c cVar) {
            super(cVar);
            this.f7095e = cVar.f7095e;
            this.f7096f = cVar.f7096f;
            this.f7097g = cVar.f7097g;
            this.f7099i = cVar.f7099i;
            this.f7098h = cVar.f7098h;
            this.f7122c = cVar.f7122c;
            this.f7100j = cVar.f7100j;
            this.f7101k = cVar.f7101k;
            this.f7102l = cVar.f7102l;
            this.f7103m = cVar.f7103m;
            this.f7104n = cVar.f7104n;
            this.f7105o = cVar.f7105o;
            this.f7106p = cVar.f7106p;
        }
    }

    private static class g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f7124q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f7125a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f7126b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f7127c;

        /* renamed from: d  reason: collision with root package name */
        Paint f7128d;

        /* renamed from: e  reason: collision with root package name */
        Paint f7129e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f7130f;

        /* renamed from: g  reason: collision with root package name */
        private int f7131g;

        /* renamed from: h  reason: collision with root package name */
        final d f7132h;

        /* renamed from: i  reason: collision with root package name */
        float f7133i;

        /* renamed from: j  reason: collision with root package name */
        float f7134j;

        /* renamed from: k  reason: collision with root package name */
        float f7135k;

        /* renamed from: l  reason: collision with root package name */
        float f7136l;

        /* renamed from: m  reason: collision with root package name */
        int f7137m;

        /* renamed from: n  reason: collision with root package name */
        String f7138n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f7139o;

        /* renamed from: p  reason: collision with root package name */
        final androidx.collection.a<String, Object> f7140p;

        public g() {
            this.f7127c = new Matrix();
            this.f7133i = 0.0f;
            this.f7134j = 0.0f;
            this.f7135k = 0.0f;
            this.f7136l = 0.0f;
            this.f7137m = 255;
            this.f7138n = null;
            this.f7139o = null;
            this.f7140p = new androidx.collection.a<>();
            this.f7132h = new d();
            this.f7125a = new Path();
            this.f7126b = new Path();
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f7107a.set(matrix);
            dVar.f7107a.preConcat(dVar.f7116j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f7108b.size(); i12++) {
                e eVar = dVar.f7108b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f7107a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof C0079f) {
                    d(dVar, (C0079f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, C0079f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f10 = ((float) i10) / this.f7135k;
            float f11 = ((float) i11) / this.f7136l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f7107a;
            this.f7127c.set(matrix);
            this.f7127c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 != 0.0f) {
                fVar.d(this.f7125a);
                Path path = this.f7125a;
                this.f7126b.reset();
                if (fVar.c()) {
                    Path path2 = this.f7126b;
                    if (fVar.f7122c == 0) {
                        fillType2 = Path.FillType.WINDING;
                    } else {
                        fillType2 = Path.FillType.EVEN_ODD;
                    }
                    path2.setFillType(fillType2);
                    this.f7126b.addPath(path, this.f7127c);
                    canvas.clipPath(this.f7126b);
                    return;
                }
                c cVar = (c) fVar;
                float f12 = cVar.f7101k;
                if (!(f12 == 0.0f && cVar.f7102l == 1.0f)) {
                    float f13 = cVar.f7103m;
                    float f14 = (f12 + f13) % 1.0f;
                    float f15 = (cVar.f7102l + f13) % 1.0f;
                    if (this.f7130f == null) {
                        this.f7130f = new PathMeasure();
                    }
                    this.f7130f.setPath(this.f7125a, false);
                    float length = this.f7130f.getLength();
                    float f16 = f14 * length;
                    float f17 = f15 * length;
                    path.reset();
                    if (f16 > f17) {
                        this.f7130f.getSegment(f16, length, path, true);
                        this.f7130f.getSegment(0.0f, f17, path, true);
                    } else {
                        this.f7130f.getSegment(f16, f17, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f7126b.addPath(path, this.f7127c);
                if (cVar.f7098h.l()) {
                    androidx.core.content.res.d dVar2 = cVar.f7098h;
                    if (this.f7129e == null) {
                        Paint paint = new Paint(1);
                        this.f7129e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f7129e;
                    if (dVar2.h()) {
                        Shader f18 = dVar2.f();
                        f18.setLocalMatrix(this.f7127c);
                        paint2.setShader(f18);
                        paint2.setAlpha(Math.round(cVar.f7100j * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(f.a(dVar2.e(), cVar.f7100j));
                    }
                    paint2.setColorFilter(colorFilter);
                    Path path3 = this.f7126b;
                    if (cVar.f7122c == 0) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    path3.setFillType(fillType);
                    canvas.drawPath(this.f7126b, paint2);
                }
                if (cVar.f7096f.l()) {
                    androidx.core.content.res.d dVar3 = cVar.f7096f;
                    if (this.f7128d == null) {
                        Paint paint3 = new Paint(1);
                        this.f7128d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f7128d;
                    Paint.Join join = cVar.f7105o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f7104n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f7106p);
                    if (dVar3.h()) {
                        Shader f19 = dVar3.f();
                        f19.setLocalMatrix(this.f7127c);
                        paint4.setShader(f19);
                        paint4.setAlpha(Math.round(cVar.f7099i * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(f.a(dVar3.e(), cVar.f7099i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f7097g * min * e10);
                    canvas.drawPath(this.f7126b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f7132h, f7124q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f7139o == null) {
                this.f7139o = Boolean.valueOf(this.f7132h.a());
            }
            return this.f7139o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f7132h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f7137m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f7137m = i10;
        }

        public g(g gVar) {
            this.f7127c = new Matrix();
            this.f7133i = 0.0f;
            this.f7134j = 0.0f;
            this.f7135k = 0.0f;
            this.f7136l = 0.0f;
            this.f7137m = 255;
            this.f7138n = null;
            this.f7139o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f7140p = aVar;
            this.f7132h = new d(gVar.f7132h, aVar);
            this.f7125a = new Path(gVar.f7125a);
            this.f7126b = new Path(gVar.f7126b);
            this.f7133i = gVar.f7133i;
            this.f7134j = gVar.f7134j;
            this.f7135k = gVar.f7135k;
            this.f7136l = gVar.f7136l;
            this.f7131g = gVar.f7131g;
            this.f7137m = gVar.f7137m;
            this.f7138n = gVar.f7138n;
            String str = gVar.f7138n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f7139o = gVar.f7139o;
        }
    }

    private static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f7107a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f7108b;

        /* renamed from: c  reason: collision with root package name */
        float f7109c;

        /* renamed from: d  reason: collision with root package name */
        private float f7110d;

        /* renamed from: e  reason: collision with root package name */
        private float f7111e;

        /* renamed from: f  reason: collision with root package name */
        private float f7112f;

        /* renamed from: g  reason: collision with root package name */
        private float f7113g;

        /* renamed from: h  reason: collision with root package name */
        private float f7114h;

        /* renamed from: i  reason: collision with root package name */
        private float f7115i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f7116j;

        /* renamed from: k  reason: collision with root package name */
        int f7117k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f7118l;

        /* renamed from: m  reason: collision with root package name */
        private String f7119m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            super();
            C0079f fVar;
            this.f7107a = new Matrix();
            this.f7108b = new ArrayList<>();
            this.f7109c = 0.0f;
            this.f7110d = 0.0f;
            this.f7111e = 0.0f;
            this.f7112f = 1.0f;
            this.f7113g = 1.0f;
            this.f7114h = 0.0f;
            this.f7115i = 0.0f;
            Matrix matrix = new Matrix();
            this.f7116j = matrix;
            this.f7119m = null;
            this.f7109c = dVar.f7109c;
            this.f7110d = dVar.f7110d;
            this.f7111e = dVar.f7111e;
            this.f7112f = dVar.f7112f;
            this.f7113g = dVar.f7113g;
            this.f7114h = dVar.f7114h;
            this.f7115i = dVar.f7115i;
            this.f7118l = dVar.f7118l;
            String str = dVar.f7119m;
            this.f7119m = str;
            this.f7117k = dVar.f7117k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f7116j);
            ArrayList<e> arrayList = dVar.f7108b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f7108b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f7108b.add(fVar);
                    String str2 = fVar.f7121b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f7116j.reset();
            this.f7116j.postTranslate(-this.f7110d, -this.f7111e);
            this.f7116j.postScale(this.f7112f, this.f7113g);
            this.f7116j.postRotate(this.f7109c, 0.0f, 0.0f);
            this.f7116j.postTranslate(this.f7114h + this.f7110d, this.f7115i + this.f7111e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f7118l = null;
            this.f7109c = m.f(typedArray, xmlPullParser, "rotation", 5, this.f7109c);
            this.f7110d = typedArray.getFloat(1, this.f7110d);
            this.f7111e = typedArray.getFloat(2, this.f7111e);
            this.f7112f = m.f(typedArray, xmlPullParser, "scaleX", 3, this.f7112f);
            this.f7113g = m.f(typedArray, xmlPullParser, "scaleY", 4, this.f7113g);
            this.f7114h = m.f(typedArray, xmlPullParser, "translateX", 6, this.f7114h);
            this.f7115i = m.f(typedArray, xmlPullParser, "translateY", 7, this.f7115i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f7119m = string;
            }
            d();
        }

        public boolean a() {
            for (int i10 = 0; i10 < this.f7108b.size(); i10++) {
                if (this.f7108b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f7108b.size(); i10++) {
                z10 |= this.f7108b.get(i10).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray i10 = m.i(resources, theme, attributeSet, a.f7056b);
            e(i10, xmlPullParser);
            i10.recycle();
        }

        public String getGroupName() {
            return this.f7119m;
        }

        public Matrix getLocalMatrix() {
            return this.f7116j;
        }

        public float getPivotX() {
            return this.f7110d;
        }

        public float getPivotY() {
            return this.f7111e;
        }

        public float getRotation() {
            return this.f7109c;
        }

        public float getScaleX() {
            return this.f7112f;
        }

        public float getScaleY() {
            return this.f7113g;
        }

        public float getTranslateX() {
            return this.f7114h;
        }

        public float getTranslateY() {
            return this.f7115i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f7110d) {
                this.f7110d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f7111e) {
                this.f7111e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f7109c) {
                this.f7109c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f7112f) {
                this.f7112f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f7113g) {
                this.f7113g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f7114h) {
                this.f7114h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f7115i) {
                this.f7115i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f7107a = new Matrix();
            this.f7108b = new ArrayList<>();
            this.f7109c = 0.0f;
            this.f7110d = 0.0f;
            this.f7111e = 0.0f;
            this.f7112f = 1.0f;
            this.f7113g = 1.0f;
            this.f7114h = 0.0f;
            this.f7115i = 0.0f;
            this.f7116j = new Matrix();
            this.f7119m = null;
        }
    }
}
