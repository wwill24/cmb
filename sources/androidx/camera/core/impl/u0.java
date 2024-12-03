package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface u0 extends s1 {

    /* renamed from: f  reason: collision with root package name */
    public static final Config.a<Integer> f2585f = Config.a.a("camerax.core.imageInput.inputFormat", Integer.TYPE);

    int l() {
        return ((Integer) a(f2585f)).intValue();
    }
}
