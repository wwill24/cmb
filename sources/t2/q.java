package t2;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import y2.h;
import y2.i;

public class q implements s, a.b {

    /* renamed from: a  reason: collision with root package name */
    private final LottieDrawable f17773a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17774b;

    /* renamed from: c  reason: collision with root package name */
    private final a<Float, Float> f17775c;

    /* renamed from: d  reason: collision with root package name */
    private i f17776d;

    public q(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, h hVar) {
        this.f17773a = lottieDrawable;
        this.f17774b = hVar.c();
        a<Float, Float> a10 = hVar.b().a();
        this.f17775c = a10;
        aVar.i(a10);
        a10.a(this);
    }

    private static int c(int i10, int i11) {
        int i12 = i10 / i11;
        return ((i10 ^ i11) >= 0 || i11 * i12 == i10) ? i12 : i12 - 1;
    }

    private static int e(int i10, int i11) {
        return i10 - (c(i10, i11) * i11);
    }

    @NonNull
    private i i(i iVar) {
        PointF pointF;
        PointF pointF2;
        boolean z10;
        List<w2.a> a10 = iVar.a();
        boolean d10 = iVar.d();
        int i10 = 0;
        for (int size = a10.size() - 1; size >= 0; size--) {
            w2.a aVar = a10.get(size);
            w2.a aVar2 = a10.get(e(size - 1, a10.size()));
            if (size != 0 || d10) {
                pointF = aVar2.c();
            } else {
                pointF = iVar.b();
            }
            if (size != 0 || d10) {
                pointF2 = aVar2.b();
            } else {
                pointF2 = pointF;
            }
            PointF a11 = aVar.a();
            if (!iVar.d() && size == 0 && size == a10.size() - 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!pointF2.equals(pointF) || !a11.equals(pointF) || z10) {
                i10++;
            } else {
                i10 += 2;
            }
        }
        i iVar2 = this.f17776d;
        if (iVar2 == null || iVar2.a().size() != i10) {
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(new w2.a());
            }
            this.f17776d = new i(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f17776d.e(d10);
        return this.f17776d;
    }

    public void a() {
        this.f17773a.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
    }

    public i d(i iVar) {
        PointF pointF;
        PointF pointF2;
        boolean z10;
        List<w2.a> list;
        List<w2.a> a10 = iVar.a();
        if (a10.size() <= 2) {
            return iVar;
        }
        float floatValue = this.f17775c.h().floatValue();
        if (floatValue == 0.0f) {
            return iVar;
        }
        i i10 = i(iVar);
        i10.f(iVar.b().x, iVar.b().y);
        List<w2.a> a11 = i10.a();
        boolean d10 = iVar.d();
        int i11 = 0;
        int i12 = 0;
        while (i11 < a10.size()) {
            w2.a aVar = a10.get(i11);
            w2.a aVar2 = a10.get(e(i11 - 1, a10.size()));
            w2.a aVar3 = a10.get(e(i11 - 2, a10.size()));
            if (i11 != 0 || d10) {
                pointF = aVar2.c();
            } else {
                pointF = iVar.b();
            }
            if (i11 != 0 || d10) {
                pointF2 = aVar2.b();
            } else {
                pointF2 = pointF;
            }
            PointF a12 = aVar.a();
            PointF c10 = aVar3.c();
            PointF c11 = aVar.c();
            if (!iVar.d() && i11 == 0 && i11 == a10.size() - 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!pointF2.equals(pointF) || !a12.equals(pointF) || z10) {
                list = a10;
                w2.a aVar4 = a11.get(e(i12 - 1, a11.size()));
                aVar4.e(aVar2.b().x, aVar2.b().y);
                aVar4.f(aVar2.c().x, aVar2.c().y);
                a11.get(i12).d(aVar.a().x, aVar.a().y);
            } else {
                float f10 = pointF.x;
                float f11 = f10 - c10.x;
                float f12 = pointF.y;
                float f13 = c11.x - f10;
                list = a10;
                float min = Math.min(floatValue / ((float) Math.hypot((double) f11, (double) (f12 - c10.y))), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot((double) f13, (double) (c11.y - f12))), 0.5f);
                float f14 = pointF.x;
                float f15 = ((c10.x - f14) * min) + f14;
                float f16 = pointF.y;
                float f17 = ((c10.y - f16) * min) + f16;
                float f18 = ((c11.x - f14) * min2) + f14;
                float f19 = ((c11.y - f16) * min2) + f16;
                float f20 = f15 - ((f15 - f14) * 0.5519f);
                float f21 = f17 - ((f17 - f16) * 0.5519f);
                float f22 = f18 - ((f18 - f14) * 0.5519f);
                float f23 = f19 - ((f19 - f16) * 0.5519f);
                w2.a aVar5 = a11.get(e(i12 - 1, a11.size()));
                w2.a aVar6 = a11.get(i12);
                aVar5.e(f15, f17);
                aVar5.f(f15, f17);
                if (i11 == 0) {
                    i10.f(f15, f17);
                }
                aVar6.d(f20, f21);
                i12++;
                aVar6.e(f22, f23);
                aVar6.f(f18, f19);
                a11.get(i12).d(f18, f19);
            }
            i12++;
            i11++;
            a10 = list;
        }
        return i10;
    }

    public a<Float, Float> g() {
        return this.f17775c;
    }
}
