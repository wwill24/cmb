package bh;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f18952a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f18953b;

    f(int i10, @NonNull PointF pointF) {
        this.f18952a = i10;
        this.f18953b = pointF;
    }

    @NonNull
    public PointF a() {
        return this.f18953b;
    }

    @NonNull
    public String toString() {
        zzv zza = zzw.zza("FaceLandmark");
        zza.zzb("type", this.f18952a);
        zza.zzc("position", this.f18953b);
        return zza.toString();
    }
}
