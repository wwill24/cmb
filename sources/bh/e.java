package bh;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.util.concurrent.Executor;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f18938a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18939b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18940c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18941d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18942e;

    /* renamed from: f  reason: collision with root package name */
    private final float f18943f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f18944g;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f18945a = 1;

        /* renamed from: b  reason: collision with root package name */
        private int f18946b = 1;

        /* renamed from: c  reason: collision with root package name */
        private int f18947c = 1;

        /* renamed from: d  reason: collision with root package name */
        private int f18948d = 1;

        /* renamed from: e  reason: collision with root package name */
        private boolean f18949e = false;

        /* renamed from: f  reason: collision with root package name */
        private float f18950f = 0.1f;

        /* renamed from: g  reason: collision with root package name */
        private Executor f18951g;

        @NonNull
        public e a() {
            return new e(this.f18945a, this.f18946b, this.f18947c, this.f18948d, this.f18949e, this.f18950f, this.f18951g, (g) null);
        }

        @NonNull
        public a b(int i10) {
            this.f18945a = i10;
            return this;
        }

        @NonNull
        public a c(float f10) {
            this.f18950f = f10;
            return this;
        }
    }

    /* synthetic */ e(int i10, int i11, int i12, int i13, boolean z10, float f10, Executor executor, g gVar) {
        this.f18938a = i10;
        this.f18939b = i11;
        this.f18940c = i12;
        this.f18941d = i13;
        this.f18942e = z10;
        this.f18943f = f10;
        this.f18944g = executor;
    }

    public final float a() {
        return this.f18943f;
    }

    public final int b() {
        return this.f18940c;
    }

    public final int c() {
        return this.f18939b;
    }

    public final int d() {
        return this.f18938a;
    }

    public final int e() {
        return this.f18941d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (Float.floatToIntBits(this.f18943f) != Float.floatToIntBits(eVar.f18943f) || !n.b(Integer.valueOf(this.f18938a), Integer.valueOf(eVar.f18938a)) || !n.b(Integer.valueOf(this.f18939b), Integer.valueOf(eVar.f18939b)) || !n.b(Integer.valueOf(this.f18941d), Integer.valueOf(eVar.f18941d)) || !n.b(Boolean.valueOf(this.f18942e), Boolean.valueOf(eVar.f18942e)) || !n.b(Integer.valueOf(this.f18940c), Integer.valueOf(eVar.f18940c)) || !n.b(this.f18944g, eVar.f18944g)) {
            return false;
        }
        return true;
    }

    public final Executor f() {
        return this.f18944g;
    }

    public final boolean g() {
        return this.f18942e;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Float.floatToIntBits(this.f18943f)), Integer.valueOf(this.f18938a), Integer.valueOf(this.f18939b), Integer.valueOf(this.f18941d), Boolean.valueOf(this.f18942e), Integer.valueOf(this.f18940c), this.f18944g);
    }

    @NonNull
    public String toString() {
        zzv zza = zzw.zza("FaceDetectorOptions");
        zza.zzb("landmarkMode", this.f18938a);
        zza.zzb("contourMode", this.f18939b);
        zza.zzb("classificationMode", this.f18940c);
        zza.zzb("performanceMode", this.f18941d);
        zza.zzd("trackingEnabled", this.f18942e);
        zza.zza("minFaceSize", this.f18943f);
        return zza.toString();
    }
}
