package bh;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_face.zzv;
import com.google.android.gms.internal.mlkit_vision_face.zzw;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f18936a;

    /* renamed from: b  reason: collision with root package name */
    private final List f18937b;

    public b(int i10, @NonNull List list) {
        this.f18936a = i10;
        this.f18937b = list;
    }

    @NonNull
    public String toString() {
        zzv zza = zzw.zza("FaceContour");
        zza.zzb("type", this.f18936a);
        zza.zzc("points", this.f18937b.toArray());
        return zza.toString();
    }
}
