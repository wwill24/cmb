package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.d0;
import io.reactivex.subjects.PublishSubject;
import j5.x;
import q5.f;
import q5.p;
import qj.q;

public class CmbTextView extends d0 {

    /* renamed from: h  reason: collision with root package name */
    private boolean f11493h = false;

    /* renamed from: j  reason: collision with root package name */
    private int f11494j;

    /* renamed from: k  reason: collision with root package name */
    private int f11495k;

    /* renamed from: l  reason: collision with root package name */
    private int f11496l;

    /* renamed from: m  reason: collision with root package name */
    private int f11497m;

    /* renamed from: n  reason: collision with root package name */
    private int f11498n;

    /* renamed from: p  reason: collision with root package name */
    private final PublishSubject<x> f11499p = PublishSubject.C0();

    public CmbTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v(context, attributeSet);
        t(context, attributeSet);
    }

    private void r() {
        int i10;
        int i11;
        Paint.FontMetricsInt fontMetricsInt = getPaint().getFontMetricsInt();
        int i12 = this.f11494j;
        if (i12 != 0) {
            setLineSpacing((float) (i12 - (fontMetricsInt.descent - fontMetricsInt.ascent)), 1.0f);
        }
        int i13 = this.f11495k;
        if (i13 != 0) {
            i10 = i13 + fontMetricsInt.ascent + this.f11497m;
        } else {
            i10 = getPaddingTop();
        }
        int i14 = this.f11496l;
        if (i14 != 0) {
            i11 = i14 + this.f11498n;
        } else {
            i11 = getPaddingBottom();
        }
        setPadding(getPaddingLeft(), i10, getPaddingRight(), i11);
    }

    /* JADX INFO: finally extract failed */
    private void t(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CmbTextView);
        try {
            int i10 = p.CmbTextView_firstLineLeading;
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i10, 0);
            this.f11494j = dimensionPixelSize;
            this.f11495k = obtainStyledAttributes.getDimensionPixelSize(i10, dimensionPixelSize);
            this.f11496l = obtainStyledAttributes.getDimensionPixelSize(p.CmbTextView_lastLineDescent, 0);
            this.f11497m = getPaddingTop();
            this.f11498n = getPaddingBottom();
            obtainStyledAttributes.recycle();
            if (this.f11495k != 0 || this.f11496l != 0) {
                setIncludeFontPadding(false);
                this.f11493h = true;
            } else if (this.f11494j != 0) {
                this.f11493h = true;
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private void u() {
        this.f11493h = (this.f11494j == 0 && this.f11496l == 0 && this.f11495k == 0) ? false : true;
    }

    private void v(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CmbTextView);
        w(context, obtainStyledAttributes.getString(p.CmbTextView_customFont));
        obtainStyledAttributes.recycle();
    }

    public int getFirstLineLeading() {
        return this.f11495k;
    }

    public int getLastLineDescent() {
        return this.f11496l;
    }

    public int getLeading() {
        return this.f11494j;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.f11493h) {
            r();
        }
        super.onMeasure(i10, i11);
    }

    public boolean performClick() {
        this.f11499p.d(x.a());
        return super.performClick();
    }

    public q<x> s() {
        return this.f11499p.P();
    }

    public void setFirstLineLeading(int i10) {
        if (this.f11495k != i10) {
            this.f11495k = i10;
            u();
            if (this.f11493h) {
                r();
            }
            invalidate();
        }
    }

    public void setLastLineDescent(int i10) {
        if (this.f11496l != i10) {
            this.f11496l = i10;
            u();
            if (this.f11493h) {
                r();
            }
            invalidate();
        }
    }

    public void setLeading(int i10) {
        if (this.f11494j != i10) {
            this.f11494j = i10;
            u();
            if (this.f11493h) {
                r();
            }
            invalidate();
        }
    }

    public boolean w(Context context, String str) {
        Typeface c10 = f.c(context, str);
        if (c10 == null) {
            return false;
        }
        setTypeface(c10);
        return true;
    }

    public void x(Boolean bool) {
        if (bool.booleanValue()) {
            setPaintFlags(getPaintFlags() | 16);
        } else {
            setPaintFlags(getPaintFlags() & -17);
        }
    }
}
