package y3;

import androidx.annotation.NonNull;
import c4.h;
import f4.k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<h<?>> f18666a = Collections.newSetFromMap(new WeakHashMap());

    public void b() {
        for (T b10 : k.i(this.f18666a)) {
            b10.b();
        }
    }

    public void d() {
        for (T d10 : k.i(this.f18666a)) {
            d10.d();
        }
    }

    public void e() {
        this.f18666a.clear();
    }

    @NonNull
    public List<h<?>> h() {
        return k.i(this.f18666a);
    }

    public void m() {
        for (T m10 : k.i(this.f18666a)) {
            m10.m();
        }
    }

    public void n(@NonNull h<?> hVar) {
        this.f18666a.add(hVar);
    }

    public void o(@NonNull h<?> hVar) {
        this.f18666a.remove(hVar);
    }
}
