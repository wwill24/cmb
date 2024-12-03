package y2;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.c;
import x2.f;
import x2.m;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18586a;

    /* renamed from: b  reason: collision with root package name */
    private final m<PointF, PointF> f18587b;

    /* renamed from: c  reason: collision with root package name */
    private final f f18588c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18589d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18590e;

    public b(String str, m<PointF, PointF> mVar, f fVar, boolean z10, boolean z11) {
        this.f18586a = str;
        this.f18587b = mVar;
        this.f18588c = fVar;
        this.f18589d = z10;
        this.f18590e = z11;
    }

    public c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new t2.f(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f18586a;
    }

    public m<PointF, PointF> c() {
        return this.f18587b;
    }

    public f d() {
        return this.f18588c;
    }

    public boolean e() {
        return this.f18590e;
    }

    public boolean f() {
        return this.f18589d;
    }
}
