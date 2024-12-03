package dh;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbw;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpa;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpc;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpe;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpg;
import com.google.android.gms.internal.mlkit_vision_text_common.zzpi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List f23350a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23351b;

    public static class c extends d {

        /* renamed from: e  reason: collision with root package name */
        private final float f23358e;

        /* renamed from: f  reason: collision with root package name */
        private final float f23359f;

        c(@NonNull zzpi zzpi, Matrix matrix) {
            super(zzpi.zzd(), zzpi.zzc(), zzpi.zze(), "", matrix);
            this.f23358e = zzpi.zzb();
            this.f23359f = zzpi.zza();
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private final String f23360a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f23361b;

        /* renamed from: c  reason: collision with root package name */
        private final Point[] f23362c;

        /* renamed from: d  reason: collision with root package name */
        private final String f23363d;

        d(String str, Rect rect, List list, String str2, Matrix matrix) {
            this.f23360a = str;
            Rect rect2 = new Rect(rect);
            if (matrix != null) {
                ah.b.e(rect2, matrix);
            }
            this.f23361b = rect2;
            Point[] pointArr = new Point[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                pointArr[i10] = new Point((Point) list.get(i10));
            }
            if (matrix != null) {
                ah.b.b(pointArr, matrix);
            }
            this.f23362c = pointArr;
            this.f23363d = str2;
        }

        @NonNull
        public String a() {
            return this.f23363d;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public final String b() {
            String str = this.f23360a;
            return str == null ? "" : str;
        }
    }

    public a(@NonNull zzpg zzpg, Matrix matrix) {
        ArrayList arrayList = new ArrayList();
        this.f23350a = arrayList;
        this.f23351b = zzpg.zza();
        arrayList.addAll(zzbw.zza(zzpg.zzb(), new e(matrix)));
    }

    @NonNull
    public String a() {
        return this.f23351b;
    }

    @NonNull
    public List<e> b() {
        return Collections.unmodifiableList(this.f23350a);
    }

    public a(@NonNull String str, @NonNull List list) {
        ArrayList arrayList = new ArrayList();
        this.f23350a = arrayList;
        arrayList.addAll(list);
        this.f23351b = str;
    }

    public static class b extends d {

        /* renamed from: e  reason: collision with root package name */
        private final List f23355e;

        /* renamed from: f  reason: collision with root package name */
        private final float f23356f;

        /* renamed from: g  reason: collision with root package name */
        private final float f23357g;

        b(@NonNull zzpe zzpe, Matrix matrix, float f10, float f11) {
            super(zzpe.zze(), zzpe.zzc(), zzpe.zzf(), zzpe.zzd(), matrix);
            this.f23355e = zzbw.zza(zzpe.zzg(), new g(matrix));
            this.f23356f = f10;
            this.f23357g = f11;
        }

        @NonNull
        public /* bridge */ /* synthetic */ String a() {
            return super.a();
        }

        @NonNull
        public String c() {
            return b();
        }

        public b(@NonNull String str, @NonNull Rect rect, @NonNull List list, @NonNull String str2, Matrix matrix, @NonNull List list2, float f10, float f11) {
            super(str, rect, list, str2, matrix);
            this.f23355e = list2;
            this.f23356f = f10;
            this.f23357g = f11;
        }
    }

    public static class e extends d {

        /* renamed from: e  reason: collision with root package name */
        private final List f23364e;

        e(@NonNull zzpa zzpa, Matrix matrix) {
            super(zzpa.zzc(), zzpa.zza(), zzpa.zzd(), zzpa.zzb(), matrix);
            this.f23364e = zzbw.zza(zzpa.zze(), new h(matrix));
        }

        @NonNull
        public synchronized List<b> c() {
            return this.f23364e;
        }

        @NonNull
        public String d() {
            return b();
        }

        public e(@NonNull String str, @NonNull Rect rect, @NonNull List list, @NonNull String str2, Matrix matrix, @NonNull List list2) {
            super(str, rect, list, str2, matrix);
            this.f23364e = list2;
        }
    }

    /* renamed from: dh.a$a  reason: collision with other inner class name */
    public static class C0271a extends d {

        /* renamed from: e  reason: collision with root package name */
        private final List f23352e;

        /* renamed from: f  reason: collision with root package name */
        private final float f23353f;

        /* renamed from: g  reason: collision with root package name */
        private final float f23354g;

        C0271a(@NonNull zzpc zzpc, Matrix matrix) {
            super(zzpc.zze(), zzpc.zzc(), zzpc.zzf(), zzpc.zzd(), matrix);
            this.f23353f = zzpc.zzb();
            this.f23354g = zzpc.zza();
            List zzg = zzpc.zzg();
            this.f23352e = zzbw.zza(zzg == null ? new ArrayList() : zzg, new f(matrix));
        }

        public C0271a(@NonNull String str, @NonNull Rect rect, @NonNull List list, @NonNull String str2, Matrix matrix, float f10, float f11, @NonNull List list2) {
            super(str, rect, list, str2, matrix);
            this.f23353f = f10;
            this.f23354g = f11;
            this.f23352e = list2;
        }
    }
}
