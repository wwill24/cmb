package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.p;
import androidx.camera.core.q;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;

public class z0 implements p {

    /* renamed from: b  reason: collision with root package name */
    private int f2719b;

    public z0(int i10) {
        this.f2719b = i10;
    }

    @NonNull
    public List<q> b(@NonNull List<q> list) {
        ArrayList arrayList = new ArrayList();
        for (q next : list) {
            h.b(next instanceof x, "The camera info doesn't contain internal implementation.");
            Integer c10 = ((x) next).c();
            if (c10 != null && c10.intValue() == this.f2719b) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int c() {
        return this.f2719b;
    }
}
