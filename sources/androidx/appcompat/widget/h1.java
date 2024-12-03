package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;
import e.a;

public class h1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1292a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1293b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1294c;

    private h1(Context context, TypedArray typedArray) {
        this.f1292a = context;
        this.f1293b = typedArray;
    }

    public static h1 t(Context context, int i10, int[] iArr) {
        return new h1(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static h1 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new h1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static h1 v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new h1(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1293b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1293b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList a10;
        if (!this.f1293b.hasValue(i10) || (resourceId = this.f1293b.getResourceId(i10, 0)) == 0 || (a10 = a.a(this.f1292a, resourceId)) == null) {
            return this.f1293b.getColorStateList(i10);
        }
        return a10;
    }

    public float d(int i10, float f10) {
        return this.f1293b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1293b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1293b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        if (!this.f1293b.hasValue(i10) || (resourceId = this.f1293b.getResourceId(i10, 0)) == 0) {
            return this.f1293b.getDrawable(i10);
        }
        return a.b(this.f1292a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1293b.hasValue(i10) || (resourceId = this.f1293b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return h.b().d(this.f1292a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1293b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.f fVar) {
        int resourceId = this.f1293b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1294c == null) {
            this.f1294c = new TypedValue();
        }
        return h.i(this.f1292a, resourceId, this.f1294c, i11, fVar);
    }

    public int k(int i10, int i11) {
        return this.f1293b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1293b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1293b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1293b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1293b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1293b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1293b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f1293b;
    }

    public boolean s(int i10) {
        return this.f1293b.hasValue(i10);
    }

    public void w() {
        this.f1293b.recycle();
    }
}
