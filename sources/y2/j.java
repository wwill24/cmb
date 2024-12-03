package y2;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import t2.c;
import t2.g;
import x2.a;
import x2.d;

public class j implements c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18618a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f18619b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18620c;

    /* renamed from: d  reason: collision with root package name */
    private final a f18621d;

    /* renamed from: e  reason: collision with root package name */
    private final d f18622e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18623f;

    public j(String str, boolean z10, Path.FillType fillType, a aVar, d dVar, boolean z11) {
        this.f18620c = str;
        this.f18618a = z10;
        this.f18619b = fillType;
        this.f18621d = aVar;
        this.f18622e = dVar;
        this.f18623f = z11;
    }

    public c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new g(lottieDrawable, aVar, this);
    }

    public a b() {
        return this.f18621d;
    }

    public Path.FillType c() {
        return this.f18619b;
    }

    public String d() {
        return this.f18620c;
    }

    public d e() {
        return this.f18622e;
    }

    public boolean f() {
        return this.f18623f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f18618a + '}';
    }
}
