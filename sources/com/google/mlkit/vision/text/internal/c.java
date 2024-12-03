package com.google.mlkit.vision.text.internal;

import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.internal.mlkit_vision_text_common.zzf;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class c {
    static Rect a(List list) {
        Iterator it = list.iterator();
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            i11 = Math.min(i11, point.x);
            i10 = Math.max(i10, point.x);
            i12 = Math.min(i12, point.y);
            i13 = Math.max(i13, point.y);
        }
        return new Rect(i11, i12, i10, i13);
    }

    static List b(zzf zzf) {
        Point[] pointArr = new Point[4];
        double sin = Math.sin(Math.toRadians((double) zzf.zze));
        double cos = Math.cos(Math.toRadians((double) zzf.zze));
        pointArr[0] = new Point(zzf.zza, zzf.zzb);
        int i10 = zzf.zza;
        double d10 = (double) zzf.zzc;
        Point point = new Point((int) (((double) i10) + (d10 * cos)), (int) (((double) zzf.zzb) + (d10 * sin)));
        pointArr[1] = point;
        int i11 = zzf.zzd;
        pointArr[2] = new Point((int) (((double) point.x) - (((double) i11) * sin)), (int) (((double) pointArr[1].y) + (((double) i11) * cos)));
        Point point2 = pointArr[0];
        int i12 = point2.x;
        Point point3 = pointArr[2];
        int i13 = point3.x;
        Point point4 = pointArr[1];
        pointArr[3] = new Point(i12 + (i13 - point4.x), point2.y + (point3.y - point4.y));
        return Arrays.asList(pointArr);
    }
}
