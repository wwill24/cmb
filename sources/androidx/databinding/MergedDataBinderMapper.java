package androidx.databinding;

import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper extends e {

    /* renamed from: a  reason: collision with root package name */
    private Set<Class<? extends e>> f4964a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private List<e> f4965b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f4966c = new CopyOnWriteArrayList();

    private boolean e() {
        boolean z10 = false;
        for (String next : this.f4966c) {
            try {
                Class<?> cls = Class.forName(next);
                if (e.class.isAssignableFrom(cls)) {
                    d((e) cls.newInstance());
                    this.f4966c.remove(next);
                    z10 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unable to add feature mapper for ");
                sb2.append(next);
            } catch (InstantiationException unused3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unable to add feature mapper for ");
                sb3.append(next);
            }
        }
        return z10;
    }

    public ViewDataBinding b(f fVar, View view, int i10) {
        for (e b10 : this.f4965b) {
            ViewDataBinding b11 = b10.b(fVar, view, i10);
            if (b11 != null) {
                return b11;
            }
        }
        if (e()) {
            return b(fVar, view, i10);
        }
        return null;
    }

    public ViewDataBinding c(f fVar, View[] viewArr, int i10) {
        for (e c10 : this.f4965b) {
            ViewDataBinding c11 = c10.c(fVar, viewArr, i10);
            if (c11 != null) {
                return c11;
            }
        }
        if (e()) {
            return c(fVar, viewArr, i10);
        }
        return null;
    }

    public void d(e eVar) {
        if (this.f4964a.add(eVar.getClass())) {
            this.f4965b.add(eVar);
            for (e d10 : eVar.a()) {
                d(d10);
            }
        }
    }
}
