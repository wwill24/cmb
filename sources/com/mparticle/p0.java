package com.mparticle;

import com.mparticle.internal.SideloadedKit;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\n"}, d2 = {"Lcom/mparticle/p0;", "", "Lorg/json/a;", "kitConfig", "", "Lcom/mparticle/internal/SideloadedKit;", "kits", "a", "<init>", "()V", "android-core_release"}, k = 1, mv = {1, 7, 1})
public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final p0 f22631a = new p0();

    private p0() {
    }

    public final a a(a aVar, List<? extends SideloadedKit> list) {
        b jsonConfig;
        j.g(list, "kits");
        a aVar2 = new a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (aVar != null) {
            int o10 = aVar.o();
            for (int i10 = 0; i10 < o10; i10++) {
                b j10 = aVar.j(i10);
                int optInt = j10.optInt("id", -1);
                if (optInt != -1 && optInt < 1000000 && !linkedHashSet.contains(Integer.valueOf(optInt))) {
                    aVar2.E(j10);
                    linkedHashSet.add(Integer.valueOf(optInt));
                }
            }
        }
        for (SideloadedKit sideloadedKit : list) {
            if (!linkedHashSet.contains(Integer.valueOf(sideloadedKit.kitId())) && (jsonConfig = sideloadedKit.getJsonConfig()) != null) {
                aVar2.E(jsonConfig);
                linkedHashSet.add(Integer.valueOf(sideloadedKit.kitId()));
            }
        }
        return aVar2;
    }
}
