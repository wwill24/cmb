package com.google.mlkit.vision.text.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.util.SparseArray;
import com.google.android.gms.internal.mlkit_vision_text_common.zzab;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbj;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbm;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzcr;
import com.google.android.gms.internal.mlkit_vision_text_common.zzf;
import com.google.android.gms.internal.mlkit_vision_text_common.zzl;
import com.google.android.gms.internal.mlkit_vision_text_common.zzv;
import dh.a;
import eh.b;
import eh.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class h {

    /* renamed from: a  reason: collision with root package name */
    static final zzv f21592a = zzv.zza("\n");

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator f21593b = c.f23396a;

    static a a(zzl[] zzlArr, Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (zzl zzl : zzlArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzl.zzj);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(zzl.zzj, sparseArray2);
            }
            sparseArray2.append(zzl.zzk, zzl);
        }
        zzbj zzg = zzbm.zzg();
        int i11 = 0;
        while (i11 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i11);
            zzbj zzg2 = zzbm.zzg();
            for (int i12 = i10; i12 < sparseArray3.size(); i12++) {
                zzg2.zzb((zzl) sparseArray3.valueAt(i12));
            }
            zzbm zzc = zzg2.zzc();
            List zza = zzbw.zza(zzc, new f(matrix));
            zzf zzf = ((zzl) zzc.get(i10)).zzb;
            zzcr zzl2 = zzc.listIterator(i10);
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            int i16 = Integer.MIN_VALUE;
            while (zzl2.hasNext()) {
                zzf zzf2 = ((zzl) zzl2.next()).zzb;
                int i17 = zzf.zza;
                int i18 = zzf.zzb;
                zzcr zzcr = zzl2;
                double sin = Math.sin(Math.toRadians((double) zzf.zze));
                SparseArray sparseArray4 = sparseArray;
                int i19 = i11;
                double cos = Math.cos(Math.toRadians((double) zzf.zze));
                Point[] pointArr = new Point[4];
                zzbj zzbj = zzg;
                List list = zza;
                Point point = new Point(zzf2.zza, zzf2.zzb);
                pointArr[0] = point;
                point.offset(-i17, -i18);
                Point point2 = pointArr[0];
                int i20 = point2.x;
                int i21 = point2.y;
                int i22 = i13;
                int i23 = (int) ((((double) i20) * cos) + (((double) i21) * sin));
                int i24 = (int) ((((double) (-i20)) * sin) + (((double) i21) * cos));
                point2.x = i23;
                point2.y = i24;
                pointArr[1] = new Point(zzf2.zzc + i23, i24);
                pointArr[2] = new Point(zzf2.zzc + i23, zzf2.zzd + i24);
                pointArr[3] = new Point(i23, i24 + zzf2.zzd);
                i13 = i22;
                i16 = i16;
                for (int i25 = 0; i25 < 4; i25++) {
                    Point point3 = pointArr[i25];
                    i14 = Math.min(i14, point3.x);
                    i13 = Math.max(i13, point3.x);
                    i15 = Math.min(i15, point3.y);
                    i16 = Math.max(i16, point3.y);
                }
                Matrix matrix2 = matrix;
                zzl2 = zzcr;
                sparseArray = sparseArray4;
                i11 = i19;
                zzg = zzbj;
                zza = list;
            }
            zzbj zzbj2 = zzg;
            SparseArray sparseArray5 = sparseArray;
            int i26 = i11;
            List list2 = zza;
            int i27 = zzf.zza;
            int i28 = zzf.zzb;
            double sin2 = Math.sin(Math.toRadians((double) zzf.zze));
            double cos2 = Math.cos(Math.toRadians((double) zzf.zze));
            int i29 = i13;
            int i30 = i16;
            Point[] pointArr2 = {new Point(i14, i15), new Point(i29, i15), new Point(i29, i30), new Point(i14, i30)};
            for (int i31 = 0; i31 < 4; i31++) {
                Point point4 = pointArr2[i31];
                int i32 = point4.x;
                int i33 = point4.y;
                Point point5 = point4;
                point5.x = (int) ((((double) i32) * cos2) - (((double) i33) * sin2));
                point5.y = (int) ((((double) i32) * sin2) + (((double) i33) * cos2));
                point5.offset(i27, i28);
            }
            List asList = Arrays.asList(pointArr2);
            List list3 = list2;
            zzbj zzbj3 = zzbj2;
            zzbj3.zzb(new a.e(f21592a.zzb(zzbw.zza(list3, eh.a.f23394a)), c.a(asList), asList, b(list3), matrix, list3));
            i11 = i26 + 1;
            zzg = zzbj3;
            i10 = 0;
            sparseArray = sparseArray5;
        }
        zzbm zzc2 = zzg.zzc();
        return new a(f21592a.zzb(zzbw.zza(zzc2, b.f23395a)), (List) zzc2);
    }

    private static String b(List list) {
        int i10;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String a10 = ((a.b) it.next()).a();
            if (hashMap.containsKey(a10)) {
                i10 = ((Integer) hashMap.get(a10)).intValue();
            } else {
                i10 = 0;
            }
            hashMap.put(a10, Integer.valueOf(i10 + 1));
        }
        Set entrySet = hashMap.entrySet();
        if (entrySet.isEmpty()) {
            return "und";
        }
        String str = (String) ((Map.Entry) Collections.max(entrySet, f21593b)).getKey();
        if (zzab.zzb(str)) {
            return "und";
        }
        return str;
    }
}
