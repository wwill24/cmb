package t2;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import u2.m;
import y2.l;

public class r implements m, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17777a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f17778b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17779c;

    /* renamed from: d  reason: collision with root package name */
    private final LottieDrawable f17780d;

    /* renamed from: e  reason: collision with root package name */
    private final m f17781e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17782f;

    /* renamed from: g  reason: collision with root package name */
    private final b f17783g = new b();

    public r(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, l lVar) {
        this.f17778b = lVar.b();
        this.f17779c = lVar.d();
        this.f17780d = lottieDrawable;
        m c10 = lVar.c().a();
        this.f17781e = c10;
        aVar.i(c10);
        c10.a(this);
    }

    private void c() {
        this.f17782f = false;
        this.f17780d.invalidateSelf();
    }

    public void a() {
        c();
    }

    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f17783g.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof s) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((s) cVar);
            }
        }
        this.f17781e.q(arrayList);
    }

    public Path getPath() {
        if (this.f17782f) {
            return this.f17777a;
        }
        this.f17777a.reset();
        if (this.f17779c) {
            this.f17782f = true;
            return this.f17777a;
        }
        Path path = (Path) this.f17781e.h();
        if (path == null) {
            return this.f17777a;
        }
        this.f17777a.set(path);
        this.f17777a.setFillType(Path.FillType.EVEN_ODD);
        this.f17783g.b(this.f17777a);
        this.f17782f = true;
        return this.f17777a;
    }
}
