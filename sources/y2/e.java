package y2;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;
import x2.b;
import x2.c;
import x2.d;
import x2.f;

public class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final GradientType f18593a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f18594b;

    /* renamed from: c  reason: collision with root package name */
    private final c f18595c;

    /* renamed from: d  reason: collision with root package name */
    private final d f18596d;

    /* renamed from: e  reason: collision with root package name */
    private final f f18597e;

    /* renamed from: f  reason: collision with root package name */
    private final f f18598f;

    /* renamed from: g  reason: collision with root package name */
    private final String f18599g;

    /* renamed from: h  reason: collision with root package name */
    private final b f18600h;

    /* renamed from: i  reason: collision with root package name */
    private final b f18601i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f18602j;

    public e(String str, GradientType gradientType, Path.FillType fillType, c cVar, d dVar, f fVar, f fVar2, b bVar, b bVar2, boolean z10) {
        this.f18593a = gradientType;
        this.f18594b = fillType;
        this.f18595c = cVar;
        this.f18596d = dVar;
        this.f18597e = fVar;
        this.f18598f = fVar2;
        this.f18599g = str;
        this.f18600h = bVar;
        this.f18601i = bVar2;
        this.f18602j = z10;
    }

    public t2.c a(LottieDrawable lottieDrawable, h hVar, a aVar) {
        return new t2.h(lottieDrawable, hVar, aVar, this);
    }

    public f b() {
        return this.f18598f;
    }

    public Path.FillType c() {
        return this.f18594b;
    }

    public c d() {
        return this.f18595c;
    }

    public GradientType e() {
        return this.f18593a;
    }

    public String f() {
        return this.f18599g;
    }

    public d g() {
        return this.f18596d;
    }

    public f h() {
        return this.f18597e;
    }

    public boolean i() {
        return this.f18602j;
    }
}
