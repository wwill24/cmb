package com.google.mlkit.vision.face.internal;

import androidx.annotation.NonNull;
import ch.c;
import com.google.android.gms.internal.mlkit_vision_face.zzbn;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.i;
import java.util.List;

public class FaceRegistrar implements ComponentRegistrar {
    @NonNull
    public final List getComponents() {
        Class<d> cls = d.class;
        return zzbn.zzi(Component.builder(cls).add(Dependency.required((Class<?>) i.class)).factory(c.f19004a).build(), Component.builder(c.class).add(Dependency.required((Class<?>) cls)).add(Dependency.required((Class<?>) d.class)).factory(i.f21564a).build());
    }
}
