package y3;

import androidx.annotation.NonNull;
import f4.k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f18631a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f18632b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18633c;

    a() {
    }

    public void a(@NonNull i iVar) {
        this.f18631a.remove(iVar);
    }

    public void b(@NonNull i iVar) {
        this.f18631a.add(iVar);
        if (this.f18633c) {
            iVar.d();
        } else if (this.f18632b) {
            iVar.b();
        } else {
            iVar.m();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f18633c = true;
        for (T d10 : k.i(this.f18631a)) {
            d10.d();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f18632b = true;
        for (T b10 : k.i(this.f18631a)) {
            b10.b();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f18632b = false;
        for (T m10 : k.i(this.f18631a)) {
            m10.m();
        }
    }
}
