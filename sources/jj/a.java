package jj;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Locale;
import pj.b;

public class a {

    /* renamed from: x  reason: collision with root package name */
    private static final float[] f31843x = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};

    /* renamed from: a  reason: collision with root package name */
    protected final int f31844a;

    /* renamed from: b  reason: collision with root package name */
    protected final boolean f31845b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f31846c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f31847d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f31848e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f31849f;

    /* renamed from: g  reason: collision with root package name */
    protected final int f31850g;

    /* renamed from: h  reason: collision with root package name */
    protected final int f31851h;

    /* renamed from: i  reason: collision with root package name */
    protected final int f31852i;

    /* renamed from: j  reason: collision with root package name */
    protected final int f31853j;

    /* renamed from: k  reason: collision with root package name */
    protected final int f31854k;

    /* renamed from: l  reason: collision with root package name */
    protected final int f31855l;

    /* renamed from: m  reason: collision with root package name */
    protected final int f31856m;

    /* renamed from: n  reason: collision with root package name */
    protected final Typeface f31857n;

    /* renamed from: o  reason: collision with root package name */
    protected final Typeface f31858o;

    /* renamed from: p  reason: collision with root package name */
    protected final int f31859p;

    /* renamed from: q  reason: collision with root package name */
    protected final int f31860q;

    /* renamed from: r  reason: collision with root package name */
    protected final int f31861r;

    /* renamed from: s  reason: collision with root package name */
    protected final int f31862s;

    /* renamed from: t  reason: collision with root package name */
    protected final Typeface f31863t;

    /* renamed from: u  reason: collision with root package name */
    protected final float[] f31864u;

    /* renamed from: v  reason: collision with root package name */
    protected final int f31865v;

    /* renamed from: w  reason: collision with root package name */
    protected final int f31866w;

    /* renamed from: jj.a$a  reason: collision with other inner class name */
    public static class C0363a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f31867a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f31868b = true;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f31869c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f31870d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f31871e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f31872f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f31873g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f31874h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f31875i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f31876j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f31877k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public int f31878l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f31879m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public Typeface f31880n;
        /* access modifiers changed from: private */

        /* renamed from: o  reason: collision with root package name */
        public Typeface f31881o;
        /* access modifiers changed from: private */

        /* renamed from: p  reason: collision with root package name */
        public int f31882p;
        /* access modifiers changed from: private */

        /* renamed from: q  reason: collision with root package name */
        public int f31883q;
        /* access modifiers changed from: private */

        /* renamed from: r  reason: collision with root package name */
        public int f31884r = -1;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public int f31885s;
        /* access modifiers changed from: private */

        /* renamed from: t  reason: collision with root package name */
        public Typeface f31886t;
        /* access modifiers changed from: private */

        /* renamed from: u  reason: collision with root package name */
        public float[] f31887u;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public int f31888v;
        /* access modifiers changed from: private */

        /* renamed from: w  reason: collision with root package name */
        public int f31889w = -1;

        C0363a() {
        }

        @NonNull
        public C0363a A(int i10) {
            this.f31873g = i10;
            return this;
        }

        @NonNull
        public C0363a B(int i10) {
            this.f31879m = i10;
            return this;
        }

        @NonNull
        public C0363a C(int i10) {
            this.f31884r = i10;
            return this;
        }

        @NonNull
        public C0363a D(int i10) {
            this.f31889w = i10;
            return this;
        }

        @NonNull
        public C0363a x(int i10) {
            this.f31869c = i10;
            return this;
        }

        @NonNull
        public C0363a y(int i10) {
            this.f31870d = i10;
            return this;
        }

        @NonNull
        public a z() {
            return new a(this);
        }
    }

    protected a(@NonNull C0363a aVar) {
        this.f31844a = aVar.f31867a;
        this.f31845b = aVar.f31868b;
        this.f31846c = aVar.f31869c;
        this.f31847d = aVar.f31870d;
        this.f31848e = aVar.f31871e;
        this.f31849f = aVar.f31872f;
        this.f31850g = aVar.f31873g;
        this.f31851h = aVar.f31874h;
        this.f31852i = aVar.f31875i;
        this.f31853j = aVar.f31876j;
        this.f31854k = aVar.f31877k;
        this.f31855l = aVar.f31878l;
        this.f31856m = aVar.f31879m;
        this.f31857n = aVar.f31880n;
        this.f31858o = aVar.f31881o;
        this.f31859p = aVar.f31882p;
        this.f31860q = aVar.f31883q;
        this.f31861r = aVar.f31884r;
        this.f31862s = aVar.f31885s;
        this.f31863t = aVar.f31886t;
        this.f31864u = aVar.f31887u;
        this.f31865v = aVar.f31888v;
        this.f31866w = aVar.f31889w;
    }

    @NonNull
    public static C0363a i(@NonNull Context context) {
        b a10 = b.a(context);
        return new C0363a().B(a10.b(8)).x(a10.b(24)).y(a10.b(4)).A(a10.b(1)).C(a10.b(1)).D(a10.b(4));
    }

    public void a(@NonNull Paint paint) {
        int i10 = this.f31848e;
        if (i10 == 0) {
            i10 = pj.a.a(paint.getColor(), 25);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i10);
    }

    public void b(@NonNull Paint paint) {
        int i10 = this.f31853j;
        if (i10 == 0) {
            i10 = this.f31852i;
        }
        if (i10 != 0) {
            paint.setColor(i10);
        }
        Typeface typeface = this.f31858o;
        if (typeface == null) {
            typeface = this.f31857n;
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i11 = this.f31860q;
            if (i11 <= 0) {
                i11 = this.f31859p;
            }
            if (i11 > 0) {
                paint.setTextSize((float) i11);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i12 = this.f31860q;
        if (i12 <= 0) {
            i12 = this.f31859p;
        }
        if (i12 > 0) {
            paint.setTextSize((float) i12);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void c(@NonNull Paint paint) {
        int i10 = this.f31852i;
        if (i10 != 0) {
            paint.setColor(i10);
        }
        Typeface typeface = this.f31857n;
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i11 = this.f31859p;
            if (i11 > 0) {
                paint.setTextSize((float) i11);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i12 = this.f31859p;
        if (i12 > 0) {
            paint.setTextSize((float) i12);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void d(@NonNull Paint paint) {
        int i10 = this.f31862s;
        if (i10 == 0) {
            i10 = pj.a.a(paint.getColor(), 75);
        }
        paint.setColor(i10);
        paint.setStyle(Paint.Style.FILL);
        int i11 = this.f31861r;
        if (i11 >= 0) {
            paint.setStrokeWidth((float) i11);
        }
    }

    public void e(@NonNull Paint paint, int i10) {
        Typeface typeface = this.f31863t;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.f31864u;
        if (fArr == null) {
            fArr = f31843x;
        }
        if (fArr == null || fArr.length < i10) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", new Object[]{Integer.valueOf(i10), Arrays.toString(fArr)}));
        }
        paint.setTextSize(paint.getTextSize() * fArr[i10 - 1]);
    }

    public void f(@NonNull TextPaint textPaint) {
        textPaint.setUnderlineText(this.f31845b);
        int i10 = this.f31844a;
        if (i10 != 0) {
            textPaint.setColor(i10);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public void g(@NonNull Paint paint) {
        int i10 = this.f31849f;
        if (i10 == 0) {
            i10 = paint.getColor();
        }
        paint.setColor(i10);
        int i11 = this.f31850g;
        if (i11 != 0) {
            paint.setStrokeWidth((float) i11);
        }
    }

    public void h(@NonNull Paint paint) {
        int i10 = this.f31865v;
        if (i10 == 0) {
            i10 = pj.a.a(paint.getColor(), 25);
        }
        paint.setColor(i10);
        paint.setStyle(Paint.Style.FILL);
        int i11 = this.f31866w;
        if (i11 >= 0) {
            paint.setStrokeWidth((float) i11);
        }
    }

    public int j() {
        return this.f31846c;
    }

    public int k() {
        int i10 = this.f31847d;
        if (i10 == 0) {
            return (int) ((((float) this.f31846c) * 0.25f) + 0.5f);
        }
        return i10;
    }

    public int l(int i10) {
        int min = Math.min(this.f31846c, i10) / 2;
        int i11 = this.f31851h;
        if (i11 == 0 || i11 > min) {
            return min;
        }
        return i11;
    }

    public int m(@NonNull Paint paint) {
        int i10 = this.f31854k;
        if (i10 != 0) {
            return i10;
        }
        return pj.a.a(paint.getColor(), 25);
    }

    public int n(@NonNull Paint paint) {
        int i10 = this.f31855l;
        if (i10 == 0) {
            i10 = this.f31854k;
        }
        if (i10 != 0) {
            return i10;
        }
        return pj.a.a(paint.getColor(), 25);
    }

    public int o() {
        return this.f31856m;
    }
}
