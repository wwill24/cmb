package yg;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsm;
import xg.a;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final zzsm f24784a;

    public b(zzsm zzsm) {
        this.f24784a = zzsm;
    }

    public final Rect a() {
        Point[] zzo = this.f24784a.zzo();
        if (zzo == null) {
            return null;
        }
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        for (Point point : zzo) {
            i11 = Math.min(i11, point.x);
            i10 = Math.max(i10, point.x);
            i12 = Math.min(i12, point.y);
            i13 = Math.max(i13, point.y);
        }
        return new Rect(i11, i12, i10, i13);
    }

    public final String b() {
        return this.f24784a.zzm();
    }

    public final int c() {
        return this.f24784a.zzb();
    }

    public final Point[] d() {
        return this.f24784a.zzo();
    }

    public final int getFormat() {
        return this.f24784a.zza();
    }
}
