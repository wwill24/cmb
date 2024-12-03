package y2;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import t2.c;
import t2.p;
import x2.b;
import x2.l;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18608a;

    /* renamed from: b  reason: collision with root package name */
    private final b f18609b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18610c;

    /* renamed from: d  reason: collision with root package name */
    private final l f18611d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18612e;

    public g(String str, b bVar, b bVar2, l lVar, boolean z10) {
        this.f18608a = str;
        this.f18609b = bVar;
        this.f18610c = bVar2;
        this.f18611d = lVar;
        this.f18612e = z10;
    }

    public c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new p(lottieDrawable, aVar, this);
    }

    public b b() {
        return this.f18609b;
    }

    public String c() {
        return this.f18608a;
    }

    public b d() {
        return this.f18610c;
    }

    public l e() {
        return this.f18611d;
    }

    public boolean f() {
        return this.f18612e;
    }
}
