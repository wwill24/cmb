package qf;

import android.graphics.Typeface;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f24410a;

    /* renamed from: b  reason: collision with root package name */
    private final C0292a f24411b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24412c;

    /* renamed from: qf.a$a  reason: collision with other inner class name */
    public interface C0292a {
        void a(Typeface typeface);
    }

    public a(C0292a aVar, Typeface typeface) {
        this.f24410a = typeface;
        this.f24411b = aVar;
    }

    private void d(Typeface typeface) {
        if (!this.f24412c) {
            this.f24411b.a(typeface);
        }
    }

    public void a(int i10) {
        d(this.f24410a);
    }

    public void b(Typeface typeface, boolean z10) {
        d(typeface);
    }

    public void c() {
        this.f24412c = true;
    }
}
