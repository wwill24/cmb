package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r1 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<q1> f2582a;

    public r1(@NonNull List<q1> list) {
        this.f2582a = new ArrayList(list);
    }

    public boolean a(@NonNull Class<? extends q1> cls) {
        for (q1 q1Var : this.f2582a) {
            if (cls.isAssignableFrom(q1Var.getClass())) {
                return true;
            }
        }
        return false;
    }

    public <T extends q1> T b(@NonNull Class<T> cls) {
        Iterator<q1> it = this.f2582a.iterator();
        while (it.hasNext()) {
            T t10 = (q1) it.next();
            if (t10.getClass() == cls) {
                return t10;
            }
        }
        return null;
    }
}
