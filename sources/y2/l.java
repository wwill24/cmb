package y2;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.a;
import t2.c;
import t2.r;
import x2.h;

public class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18627a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18628b;

    /* renamed from: c  reason: collision with root package name */
    private final h f18629c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18630d;

    public l(String str, int i10, h hVar, boolean z10) {
        this.f18627a = str;
        this.f18628b = i10;
        this.f18629c = hVar;
        this.f18630d = z10;
    }

    public c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, a aVar) {
        return new r(lottieDrawable, aVar, this);
    }

    public String b() {
        return this.f18627a;
    }

    public h c() {
        return this.f18629c;
    }

    public boolean d() {
        return this.f18630d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f18627a + ", index=" + this.f18628b + '}';
    }
}
