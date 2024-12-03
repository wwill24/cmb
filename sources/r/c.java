package r;

import android.util.Size;
import androidx.camera.core.impl.m;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import q.e;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final e f17213a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Size> f17214b;

    public c(e eVar) {
        Set<Size> set;
        this.f17213a = eVar;
        if (eVar != null) {
            set = new HashSet<>(eVar.b());
        } else {
            set = Collections.emptySet();
        }
        this.f17214b = set;
    }

    public boolean a() {
        return this.f17213a != null;
    }

    public boolean b(m mVar) {
        if (mVar == null) {
            return false;
        }
        if (this.f17213a == null) {
            return true;
        }
        return this.f17214b.contains(new Size(mVar.p(), mVar.n()));
    }
}
