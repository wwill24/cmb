package com.mparticle.kits;

import com.mparticle.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016R+\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/mparticle/kits/KitOptions;", "Lcom/mparticle/Configuration;", "Lcom/mparticle/kits/KitManagerImpl;", "", "kitId", "Ljava/lang/Class;", "Lcom/mparticle/kits/KitIntegration;", "type", "addKit", "configures", "kitManager", "", "apply", "", "kits", "Ljava/util/Map;", "getKits", "()Ljava/util/Map;", "Lkotlin/Function1;", "initializer", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "android-kit-base_release"}, k = 1, mv = {1, 7, 1})
public class KitOptions implements Configuration<KitManagerImpl> {
    private final Map<Integer, Class<? extends KitIntegration>> kits;

    public KitOptions() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    public KitOptions(Function1<? super KitOptions, Unit> function1) {
        j.g(function1, "initializer");
        this.kits = new LinkedHashMap();
        function1.invoke(this);
    }

    public KitOptions addKit(int i10, Class<? extends KitIntegration> cls) {
        j.g(cls, "type");
        this.kits.put(Integer.valueOf(i10), cls);
        return this;
    }

    public Class<KitManagerImpl> configures() {
        return KitManagerImpl.class;
    }

    public final Map<Integer, Class<? extends KitIntegration>> getKits() {
        return this.kits;
    }

    public void apply(KitManagerImpl kitManagerImpl) {
        j.g(kitManagerImpl, "kitManager");
        kitManagerImpl.setKitOptions(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KitOptions(Function1 function1, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? AnonymousClass1.INSTANCE : function1);
    }
}
