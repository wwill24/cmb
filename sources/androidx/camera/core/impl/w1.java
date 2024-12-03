package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.l1;
import androidx.camera.core.o1;
import java.util.Collections;
import java.util.List;
import u.f;
import zf.a;

public final class w1 implements w0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f2697a;

    /* renamed from: b  reason: collision with root package name */
    private final o1 f2698b;

    public w1(@NonNull o1 o1Var, @NonNull String str) {
        l1 z12 = o1Var.z1();
        if (z12 != null) {
            Integer num = (Integer) z12.c().c(str);
            if (num != null) {
                this.f2697a = num.intValue();
                this.f2698b = o1Var;
                return;
            }
            throw new IllegalArgumentException("ImageProxy has no associated tag");
        }
        throw new IllegalArgumentException("ImageProxy has no associated ImageInfo");
    }

    @NonNull
    public List<Integer> a() {
        return Collections.singletonList(Integer.valueOf(this.f2697a));
    }

    @NonNull
    public a<o1> b(int i10) {
        if (i10 != this.f2697a) {
            return f.f(new IllegalArgumentException("Capture id does not exist in the bundle"));
        }
        return f.h(this.f2698b);
    }

    public void c() {
        this.f2698b.close();
    }
}
