package ve;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.zzef;
import java.util.List;
import java.util.Map;
import we.t;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final zzef f42100a;

    /* renamed from: ve.a$a  reason: collision with other inner class name */
    public interface C0511a extends t {
    }

    public a(zzef zzef) {
        this.f42100a = zzef;
    }

    public void a(@NonNull String str, String str2, Bundle bundle) {
        this.f42100a.zzw(str, str2, bundle);
    }

    @NonNull
    public List<Bundle> b(String str, String str2) {
        return this.f42100a.zzq(str, str2);
    }

    public int c(@NonNull String str) {
        return this.f42100a.zza(str);
    }

    @NonNull
    public Map<String, Object> d(String str, String str2, boolean z10) {
        return this.f42100a.zzr(str, str2, z10);
    }

    public void e(@NonNull String str, @NonNull String str2, Bundle bundle) {
        this.f42100a.zzz(str, str2, bundle);
    }

    public void f(@NonNull C0511a aVar) {
        this.f42100a.zzC(aVar);
    }

    public void g(@NonNull Bundle bundle) {
        this.f42100a.zzE(bundle);
    }

    public void h(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        this.f42100a.zzO(str, str2, obj, true);
    }

    public final void i(boolean z10) {
        this.f42100a.zzI(z10);
    }
}
