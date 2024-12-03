package y2;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.a;
import java.util.Arrays;
import java.util.List;
import t2.c;
import t2.d;

public class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f18624a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f18625b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18626c;

    public k(String str, List<c> list, boolean z10) {
        this.f18624a = str;
        this.f18625b = list;
        this.f18626c = z10;
    }

    public c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new d(lottieDrawable, aVar, this, hVar);
    }

    public List<c> b() {
        return this.f18625b;
    }

    public String c() {
        return this.f18624a;
    }

    public boolean d() {
        return this.f18626c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f18624a + "' Shapes: " + Arrays.toString(this.f18625b.toArray()) + '}';
    }
}
