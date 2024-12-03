package t2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import u2.b;
import u2.q;

public class t extends a {

    /* renamed from: r  reason: collision with root package name */
    private final a f17784r;

    /* renamed from: s  reason: collision with root package name */
    private final String f17785s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f17786t;

    /* renamed from: u  reason: collision with root package name */
    private final u2.a<Integer, Integer> f17787u;

    /* renamed from: v  reason: collision with root package name */
    private u2.a<ColorFilter, ColorFilter> f17788v;

    public t(LottieDrawable lottieDrawable, a aVar, ShapeStroke shapeStroke) {
        super(lottieDrawable, aVar, shapeStroke.b().b(), shapeStroke.e().b(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f17784r = aVar;
        this.f17785s = shapeStroke.h();
        this.f17786t = shapeStroke.k();
        u2.a<Integer, Integer> a10 = shapeStroke.c().a();
        this.f17787u = a10;
        a10.a(this);
        aVar.i(a10);
    }

    public <T> void c(T t10, c<T> cVar) {
        super.c(t10, cVar);
        if (t10 == h0.f8566b) {
            this.f17787u.n(cVar);
        } else if (t10 == h0.K) {
            u2.a<ColorFilter, ColorFilter> aVar = this.f17788v;
            if (aVar != null) {
                this.f17784r.G(aVar);
            }
            if (cVar == null) {
                this.f17788v = null;
                return;
            }
            q qVar = new q(cVar);
            this.f17788v = qVar;
            qVar.a(this);
            this.f17784r.i(this.f17787u);
        }
    }

    public String getName() {
        return this.f17785s;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f17786t) {
            this.f17655i.setColor(((b) this.f17787u).p());
            u2.a<ColorFilter, ColorFilter> aVar = this.f17788v;
            if (aVar != null) {
                this.f17655i.setColorFilter(aVar.h());
            }
            super.h(canvas, matrix, i10);
        }
    }
}
