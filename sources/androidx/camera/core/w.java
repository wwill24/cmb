package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.f0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class w {

    static final class a implements c0 {

        /* renamed from: a  reason: collision with root package name */
        final List<f0> f2928a;

        a(List<f0> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
            }
            this.f2928a = Collections.unmodifiableList(new ArrayList(list));
        }

        public List<f0> a() {
            return this.f2928a;
        }
    }

    @NonNull
    static c0 a(@NonNull List<f0> list) {
        return new a(list);
    }

    @NonNull
    static c0 b(@NonNull f0... f0VarArr) {
        return new a(Arrays.asList(f0VarArr));
    }

    @NonNull
    public static c0 c() {
        return b(new f0.a());
    }
}
