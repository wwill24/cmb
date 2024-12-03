package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.vision.common.internal.a;
import java.util.List;

public class VisionCommonRegistrar implements ComponentRegistrar {
    @NonNull
    public final List getComponents() {
        return zzp.zzi(Component.builder(a.class).add(Dependency.setOf((Class<?>) a.C0249a.class)).factory(d.f21534a).build());
    }
}
