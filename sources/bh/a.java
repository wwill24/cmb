package bh;

import ah.b;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.mlkit_vision_face.zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzn;
import com.google.android.gms.internal.mlkit_vision_face.zzos;
import com.google.android.gms.internal.mlkit_vision_face.zzow;
import com.google.android.gms.internal.mlkit_vision_face.zzpc;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f18926a;

    /* renamed from: b  reason: collision with root package name */
    private int f18927b;

    /* renamed from: c  reason: collision with root package name */
    private final float f18928c;

    /* renamed from: d  reason: collision with root package name */
    private final float f18929d;

    /* renamed from: e  reason: collision with root package name */
    private final float f18930e;

    /* renamed from: f  reason: collision with root package name */
    private final float f18931f;

    /* renamed from: g  reason: collision with root package name */
    private final float f18932g;

    /* renamed from: h  reason: collision with root package name */
    private final float f18933h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray f18934i = new SparseArray();

    /* renamed from: j  reason: collision with root package name */
    private final SparseArray f18935j = new SparseArray();

    public a(@NonNull zzf zzf, Matrix matrix) {
        float f10 = zzf.zzc;
        float f11 = zzf.zze / 2.0f;
        float f12 = zzf.zzd;
        float f13 = zzf.zzf / 2.0f;
        Rect rect = new Rect((int) (f10 - f11), (int) (f12 - f13), (int) (f10 + f11), (int) (f12 + f13));
        this.f18926a = rect;
        if (matrix != null) {
            b.e(rect, matrix);
        }
        this.f18927b = zzf.zzb;
        for (zzn zzn : zzf.zzj) {
            if (i(zzn.zzd)) {
                PointF pointF = new PointF(zzn.zzb, zzn.zzc);
                if (matrix != null) {
                    b.c(pointF, matrix);
                }
                SparseArray sparseArray = this.f18934i;
                int i10 = zzn.zzd;
                sparseArray.put(i10, new f(i10, pointF));
            }
        }
        for (zzd zzd : zzf.zzn) {
            int i11 = zzd.zzb;
            if (h(i11)) {
                PointF[] pointFArr = zzd.zza;
                pointFArr.getClass();
                int length = pointFArr.length;
                long j10 = ((long) length) + 5 + ((long) (length / 10));
                ArrayList arrayList = new ArrayList(j10 > 2147483647L ? a.e.API_PRIORITY_OTHER : (int) j10);
                Collections.addAll(arrayList, pointFArr);
                if (matrix != null) {
                    b.d(arrayList, matrix);
                }
                this.f18935j.put(i11, new b(i11, arrayList));
            }
        }
        this.f18931f = zzf.zzi;
        this.f18932g = zzf.zzg;
        this.f18933h = zzf.zzh;
        this.f18930e = zzf.zzm;
        this.f18929d = zzf.zzk;
        this.f18928c = zzf.zzl;
    }

    private static boolean h(int i10) {
        return i10 <= 15 && i10 > 0;
    }

    private static boolean i(int i10) {
        return i10 == 0 || i10 == 1 || i10 == 7 || i10 == 3 || i10 == 9 || i10 == 4 || i10 == 10 || i10 == 5 || i10 == 11 || i10 == 6;
    }

    @NonNull
    public Rect a() {
        return this.f18926a;
    }

    public b b(int i10) {
        return (b) this.f18935j.get(i10);
    }

    public float c() {
        return this.f18932g;
    }

    public f d(int i10) {
        return (f) this.f18934i.get(i10);
    }

    @NonNull
    public final SparseArray e() {
        return this.f18935j;
    }

    public final void f(@NonNull SparseArray sparseArray) {
        this.f18935j.clear();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            this.f18935j.put(sparseArray.keyAt(i10), (b) sparseArray.valueAt(i10));
        }
    }

    public final void g(int i10) {
        this.f18927b = -1;
    }

    @NonNull
    public String toString() {
        zzv zza = zzw.zza("Face");
        zza.zzc("boundingBox", this.f18926a);
        zza.zzb("trackingId", this.f18927b);
        zza.zza("rightEyeOpenProbability", this.f18928c);
        zza.zza("leftEyeOpenProbability", this.f18929d);
        zza.zza("smileProbability", this.f18930e);
        zza.zza("eulerX", this.f18931f);
        zza.zza("eulerY", this.f18932g);
        zza.zza("eulerZ", this.f18933h);
        zzv zza2 = zzw.zza("Landmarks");
        for (int i10 = 0; i10 <= 11; i10++) {
            if (i(i10)) {
                zza2.zzc("landmark_" + i10, d(i10));
            }
        }
        zza.zzc("landmarks", zza2.toString());
        zzv zza3 = zzw.zza("Contours");
        for (int i11 = 1; i11 <= 15; i11++) {
            zza3.zzc("Contour_" + i11, b(i11));
        }
        zza.zzc("contours", zza3.toString());
        return zza.toString();
    }

    public a(@NonNull zzow zzow, Matrix matrix) {
        Rect zzh = zzow.zzh();
        this.f18926a = zzh;
        if (matrix != null) {
            b.e(zzh, matrix);
        }
        this.f18927b = zzow.zzg();
        for (zzpc zzpc : zzow.zzj()) {
            if (i(zzpc.zza())) {
                PointF zzb = zzpc.zzb();
                if (matrix != null) {
                    b.c(zzb, matrix);
                }
                this.f18934i.put(zzpc.zza(), new f(zzpc.zza(), zzb));
            }
        }
        for (zzos zzos : zzow.zzi()) {
            int zza = zzos.zza();
            if (h(zza)) {
                List zzb2 = zzos.zzb();
                zzb2.getClass();
                ArrayList arrayList = new ArrayList(zzb2);
                if (matrix != null) {
                    b.d(arrayList, matrix);
                }
                this.f18935j.put(zza, new b(zza, arrayList));
            }
        }
        this.f18931f = zzow.zzf();
        this.f18932g = zzow.zzb();
        this.f18933h = -zzow.zzd();
        this.f18930e = zzow.zze();
        this.f18929d = zzow.zza();
        this.f18928c = zzow.zzc();
    }
}
