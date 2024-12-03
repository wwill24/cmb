package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class g1<C> {

    /* renamed from: a  reason: collision with root package name */
    private Set<C> f2537a = new HashSet();

    public void a(@NonNull List<C> list) {
        this.f2537a.addAll(list);
    }

    @NonNull
    /* renamed from: b */
    public abstract g1<C> clone();

    @NonNull
    public List<C> c() {
        return Collections.unmodifiableList(new ArrayList(this.f2537a));
    }
}
