package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.v;
import androidx.core.util.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.q0;

public final class b1 implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, q2> f1685a;

    /* renamed from: b  reason: collision with root package name */
    private final c f1686b;

    class a implements c {
        a() {
        }

        public CamcorderProfile a(int i10, int i11) {
            return CamcorderProfile.get(i10, i11);
        }

        public boolean b(int i10, int i11) {
            return CamcorderProfile.hasProfile(i10, i11);
        }
    }

    public b1(@NonNull Context context, Object obj, @NonNull Set<String> set) throws CameraUnavailableException {
        this(context, new a(), obj, set);
    }

    private void c(@NonNull Context context, @NonNull q0 q0Var, @NonNull Set<String> set) throws CameraUnavailableException {
        h.g(context);
        for (String next : set) {
            this.f1685a.put(next, new q2(context, next, q0Var, this.f1686b));
        }
    }

    public SurfaceConfig a(@NonNull String str, int i10, @NonNull Size size) {
        q2 q2Var = this.f1685a.get(str);
        if (q2Var != null) {
            return q2Var.A(i10, size);
        }
        return null;
    }

    @NonNull
    public Map<f2<?>, Size> b(@NonNull String str, @NonNull List<androidx.camera.core.impl.a> list, @NonNull List<f2<?>> list2) {
        h.b(!list2.isEmpty(), "No new use cases to be bound.");
        q2 q2Var = this.f1685a.get(str);
        if (q2Var != null) {
            return q2Var.q(list, list2);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + str);
    }

    b1(@NonNull Context context, @NonNull c cVar, Object obj, @NonNull Set<String> set) throws CameraUnavailableException {
        q0 q0Var;
        this.f1685a = new HashMap();
        h.g(cVar);
        this.f1686b = cVar;
        if (obj instanceof q0) {
            q0Var = (q0) obj;
        } else {
            q0Var = q0.a(context);
        }
        c(context, q0Var, set);
    }
}
