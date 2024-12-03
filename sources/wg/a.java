package wg;

import ah.b;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final xg.a f24672a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f24673b;

    /* renamed from: c  reason: collision with root package name */
    private final Point[] f24674c;

    public a(@NonNull xg.a aVar, Matrix matrix) {
        this.f24672a = (xg.a) p.k(aVar);
        Rect a10 = aVar.a();
        if (!(a10 == null || matrix == null)) {
            b.e(a10, matrix);
        }
        this.f24673b = a10;
        Point[] d10 = aVar.d();
        if (!(d10 == null || matrix == null)) {
            b.b(d10, matrix);
        }
        this.f24674c = d10;
    }

    public Rect a() {
        return this.f24673b;
    }

    public int b() {
        int format2 = this.f24672a.getFormat();
        if (format2 > 4096) {
            return -1;
        }
        if (format2 == 0) {
            return -1;
        }
        return format2;
    }

    public String c() {
        return this.f24672a.b();
    }

    public int d() {
        return this.f24672a.c();
    }
}
