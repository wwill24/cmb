package com.google.mlkit.vision.barcode.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcd;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.i;
import java.util.List;
import yg.a;

public class BarcodeRegistrar implements ComponentRegistrar {
    @NonNull
    public final List getComponents() {
        Class<e> cls = e.class;
        return zzcd.zzh(Component.builder(cls).add(Dependency.required((Class<?>) i.class)).factory(a.f24783a).build(), Component.builder(d.class).add(Dependency.required((Class<?>) cls)).add(Dependency.required((Class<?>) d.class)).factory(c.f21483a).build());
    }
}
