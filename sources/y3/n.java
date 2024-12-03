package y3;

import android.util.Log;
import androidx.annotation.NonNull;
import b4.a;
import f4.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f18656a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f18657b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f18658c;

    public boolean a(a aVar) {
        boolean z10 = true;
        if (aVar == null) {
            return true;
        }
        boolean remove = this.f18656a.remove(aVar);
        if (!this.f18657b.remove(aVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            aVar.clear();
        }
        return z10;
    }

    public void b() {
        for (T a10 : k.i(this.f18656a)) {
            a(a10);
        }
        this.f18657b.clear();
    }

    public void c() {
        this.f18658c = true;
        for (T t10 : k.i(this.f18656a)) {
            if (t10.isRunning() || t10.h()) {
                t10.clear();
                this.f18657b.add(t10);
            }
        }
    }

    public void d() {
        this.f18658c = true;
        for (T t10 : k.i(this.f18656a)) {
            if (t10.isRunning()) {
                t10.pause();
                this.f18657b.add(t10);
            }
        }
    }

    public void e() {
        for (T t10 : k.i(this.f18656a)) {
            if (!t10.h() && !t10.f()) {
                t10.clear();
                if (!this.f18658c) {
                    t10.j();
                } else {
                    this.f18657b.add(t10);
                }
            }
        }
    }

    public void f() {
        this.f18658c = false;
        for (T t10 : k.i(this.f18656a)) {
            if (!t10.h() && !t10.isRunning()) {
                t10.j();
            }
        }
        this.f18657b.clear();
    }

    public void g(@NonNull a aVar) {
        this.f18656a.add(aVar);
        if (!this.f18658c) {
            aVar.j();
            return;
        }
        aVar.clear();
        Log.isLoggable("RequestTracker", 2);
        this.f18657b.add(aVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f18656a.size() + ", isPaused=" + this.f18658c + "}";
    }
}
