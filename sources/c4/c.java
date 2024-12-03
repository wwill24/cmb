package c4;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import b4.a;
import f4.k;

public abstract class c<T> implements h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7948a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7949b;

    /* renamed from: c  reason: collision with root package name */
    private a f7950c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final a a() {
        return this.f7950c;
    }

    public void b() {
    }

    public final void c(@NonNull g gVar) {
        gVar.d(this.f7948a, this.f7949b);
    }

    public void d() {
    }

    public final void g(a aVar) {
        this.f7950c = aVar;
    }

    public void i(Drawable drawable) {
    }

    public final void j(@NonNull g gVar) {
    }

    public void l(Drawable drawable) {
    }

    public void m() {
    }

    public c(int i10, int i11) {
        if (k.r(i10, i11)) {
            this.f7948a = i10;
            this.f7949b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }
}
