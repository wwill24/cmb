package t2;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import u2.a;

public class u implements c, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f17789a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17790b;

    /* renamed from: c  reason: collision with root package name */
    private final List<a.b> f17791c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeTrimPath.Type f17792d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, Float> f17793e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, Float> f17794f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, Float> f17795g;

    public u(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.f17789a = shapeTrimPath.c();
        this.f17790b = shapeTrimPath.g();
        this.f17792d = shapeTrimPath.f();
        a<Float, Float> a10 = shapeTrimPath.e().a();
        this.f17793e = a10;
        a<Float, Float> a11 = shapeTrimPath.b().a();
        this.f17794f = a11;
        a<Float, Float> a12 = shapeTrimPath.d().a();
        this.f17795g = a12;
        aVar.i(a10);
        aVar.i(a11);
        aVar.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    public void a() {
        for (int i10 = 0; i10 < this.f17791c.size(); i10++) {
            this.f17791c.get(i10).a();
        }
    }

    public void b(List<c> list, List<c> list2) {
    }

    /* access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.f17791c.add(bVar);
    }

    public a<?, Float> e() {
        return this.f17794f;
    }

    public a<?, Float> g() {
        return this.f17795g;
    }

    public a<?, Float> i() {
        return this.f17793e;
    }

    /* access modifiers changed from: package-private */
    public ShapeTrimPath.Type j() {
        return this.f17792d;
    }

    public boolean k() {
        return this.f17790b;
    }
}
