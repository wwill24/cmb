package y2;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.c;
import t2.o;
import x2.b;
import x2.m;

public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18603a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f18604b;

    /* renamed from: c  reason: collision with root package name */
    private final m<PointF, PointF> f18605c;

    /* renamed from: d  reason: collision with root package name */
    private final b f18606d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18607e;

    public f(String str, m<PointF, PointF> mVar, m<PointF, PointF> mVar2, b bVar, boolean z10) {
        this.f18603a = str;
        this.f18604b = mVar;
        this.f18605c = mVar2;
        this.f18606d = bVar;
        this.f18607e = z10;
    }

    public c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new o(lottieDrawable, aVar, this);
    }

    public b b() {
        return this.f18606d;
    }

    public String c() {
        return this.f18603a;
    }

    public m<PointF, PointF> d() {
        return this.f18604b;
    }

    public m<PointF, PointF> e() {
        return this.f18605c;
    }

    public boolean f() {
        return this.f18607e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f18604b + ", size=" + this.f18605c + '}';
    }
}
