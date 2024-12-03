package yg;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_barcode.zzq;
import xg.a;

public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final zzq f24785a;

    public c(zzq zzq) {
        this.f24785a = zzq;
    }

    public final Rect a() {
        zzq zzq = this.f24785a;
        if (zzq.zze == null) {
            return null;
        }
        int i10 = 0;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzq.zze;
            if (i10 >= pointArr.length) {
                return new Rect(i12, i13, i11, i14);
            }
            Point point = pointArr[i10];
            i12 = Math.min(i12, point.x);
            i11 = Math.max(i11, point.x);
            i13 = Math.min(i13, point.y);
            i14 = Math.max(i14, point.y);
            i10++;
        }
    }

    public final String b() {
        return this.f24785a.zzb;
    }

    public final int c() {
        return this.f24785a.zzd;
    }

    public final Point[] d() {
        return this.f24785a.zze;
    }

    public final int getFormat() {
        return this.f24785a.zza;
    }
}
