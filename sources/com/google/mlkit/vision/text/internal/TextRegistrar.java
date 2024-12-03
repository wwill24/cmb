package com.google.mlkit.vision.text.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_text_common.zzbm;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.i;
import eh.e;
import java.util.List;

public class TextRegistrar implements ComponentRegistrar {
    @NonNull
    public final List getComponents() {
        Class<k> cls = k.class;
        return zzbm.zzk(Component.builder(cls).add(Dependency.required((Class<?>) i.class)).factory(e.f23399a).build(), Component.builder(j.class).add(Dependency.required((Class<?>) cls)).add(Dependency.required((Class<?>) d.class)).factory(n.f21602a).build());
    }
}
