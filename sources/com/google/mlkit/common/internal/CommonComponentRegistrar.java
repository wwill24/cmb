package com.google.mlkit.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.sdkinternal.d;
import com.google.mlkit.common.sdkinternal.i;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.common.sdkinternal.m;
import java.util.List;
import rg.b;
import rg.e;
import rg.f;
import rg.g;
import rg.h;
import sg.a;
import tg.c;

public class CommonComponentRegistrar implements ComponentRegistrar {
    @NonNull
    public final List getComponents() {
        Class<a> cls = a.class;
        Class<com.google.mlkit.common.sdkinternal.a> cls2 = com.google.mlkit.common.sdkinternal.a.class;
        Class<c.a> cls3 = c.a.class;
        Class<i> cls4 = i.class;
        return zzar.zzi(m.f21439b, Component.builder(ug.a.class).add(Dependency.required((Class<?>) cls4)).factory(rg.a.f24455a).build(), Component.builder(j.class).factory(b.f24456a).build(), Component.builder(c.class).add(Dependency.setOf((Class<?>) cls3)).factory(rg.c.f24457a).build(), Component.builder(d.class).add(Dependency.requiredProvider((Class<?>) j.class)).factory(rg.d.f24458a).build(), Component.builder(cls2).factory(e.f24459a).build(), Component.builder(com.google.mlkit.common.sdkinternal.b.class).add(Dependency.required((Class<?>) cls2)).factory(f.f24460a).build(), Component.builder(cls).add(Dependency.required((Class<?>) cls4)).factory(g.f24461a).build(), Component.intoSetBuilder(cls3).add(Dependency.requiredProvider((Class<?>) cls)).factory(h.f24462a).build());
    }
}
