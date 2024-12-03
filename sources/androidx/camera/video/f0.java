package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.l;
import androidx.camera.core.impl.m;
import androidx.camera.core.impl.utils.e;
import androidx.camera.core.impl.x;
import androidx.camera.core.v1;
import androidx.camera.video.q;
import androidx.core.util.h;
import f0.p;
import f0.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<q, m> f3106a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final TreeMap<Size, q> f3107b = new TreeMap<>(new e());

    /* renamed from: c  reason: collision with root package name */
    private final m f3108c;

    /* renamed from: d  reason: collision with root package name */
    private final m f3109d;

    f0(@NonNull x xVar) {
        l d10 = xVar.d();
        for (q next : q.b()) {
            h.j(next instanceof q.b, "Currently only support ConstantQuality");
            int d11 = ((q.b) next).d();
            if (d10.a(d11) && g(next)) {
                m mVar = (m) h.g(d10.get(d11));
                Size size = new Size(mVar.p(), mVar.n());
                v1.a("VideoCapabilities", "profile = " + mVar);
                this.f3106a.put(next, mVar);
                this.f3107b.put(size, next);
            }
        }
        if (this.f3106a.isEmpty()) {
            v1.c("VideoCapabilities", "No supported CamcorderProfile");
            this.f3109d = null;
            this.f3108c = null;
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque(this.f3106a.values());
        this.f3108c = (m) arrayDeque.peekFirst();
        this.f3109d = (m) arrayDeque.peekLast();
    }

    private static void a(@NonNull q qVar) {
        boolean a10 = q.a(qVar);
        h.b(a10, "Unknown quality: " + qVar);
    }

    @NonNull
    public static f0 d(@NonNull androidx.camera.core.q qVar) {
        return new f0((x) qVar);
    }

    private boolean g(@NonNull q qVar) {
        for (Class a10 : Arrays.asList(new Class[]{f0.h.class, p.class, f0.q.class})) {
            s sVar = (s) f0.e.a(a10);
            if (sVar != null && sVar.a(qVar)) {
                return false;
            }
        }
        return true;
    }

    public m b(@NonNull Size size) {
        q c10 = c(size);
        v1.a("VideoCapabilities", "Using supported quality of " + c10 + " for size " + size);
        if (c10 == q.f3409g) {
            return null;
        }
        m e10 = e(c10);
        if (e10 != null) {
            return e10;
        }
        throw new AssertionError("Camera advertised available quality but did not produce CamcorderProfile for advertised quality.");
    }

    @NonNull
    public q c(@NonNull Size size) {
        Map.Entry<Size, q> ceilingEntry = this.f3107b.ceilingEntry(size);
        if (ceilingEntry != null) {
            return ceilingEntry.getValue();
        }
        Map.Entry<Size, q> floorEntry = this.f3107b.floorEntry(size);
        if (floorEntry != null) {
            return floorEntry.getValue();
        }
        return q.f3409g;
    }

    public m e(@NonNull q qVar) {
        a(qVar);
        if (qVar == q.f3408f) {
            return this.f3108c;
        }
        if (qVar == q.f3407e) {
            return this.f3109d;
        }
        return this.f3106a.get(qVar);
    }

    @NonNull
    public List<q> f() {
        return new ArrayList(this.f3106a.keySet());
    }
}
