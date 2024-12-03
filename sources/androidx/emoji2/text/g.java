package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import f1.a;

public class g {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<a> f5452d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final int f5453a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final m f5454b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f5455c = 0;

    g(@NonNull m mVar, int i10) {
        this.f5454b = mVar;
        this.f5453a = i10;
    }

    private a g() {
        ThreadLocal<a> threadLocal = f5452d;
        a aVar = threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        this.f5454b.d().j(aVar, this.f5453a);
        return aVar;
    }

    public void a(@NonNull Canvas canvas, float f10, float f11, @NonNull Paint paint) {
        Typeface g10 = this.f5454b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g10);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.f5454b.c(), this.f5453a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return g().h(i10);
    }

    public int c() {
        return g().i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int d() {
        return this.f5455c;
    }

    public short e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public short i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void k(boolean z10) {
        this.f5455c = z10 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int c10 = c();
        for (int i10 = 0; i10 < c10; i10++) {
            sb2.append(Integer.toHexString(b(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
