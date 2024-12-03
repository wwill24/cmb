package y2;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.a;
import t2.c;
import t2.q;
import x2.m;

public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18613a;

    /* renamed from: b  reason: collision with root package name */
    private final m<Float, Float> f18614b;

    public h(String str, m<Float, Float> mVar) {
        this.f18613a = str;
        this.f18614b = mVar;
    }

    public c a(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, a aVar) {
        return new q(lottieDrawable, aVar, this);
    }

    public m<Float, Float> b() {
        return this.f18614b;
    }

    public String c() {
        return this.f18613a;
    }
}
