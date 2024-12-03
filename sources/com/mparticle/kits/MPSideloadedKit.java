package com.mparticle.kits;

import android.content.Context;
import com.mparticle.internal.SideloadedKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/mparticle/kits/MPSideloadedKit;", "Lcom/mparticle/kits/KitIntegration;", "Lcom/mparticle/internal/SideloadedKit;", "Lcom/mparticle/kits/KitConfiguration;", "Lcom/mparticle/kits/MPSideloadedFilters;", "filters", "applyFilters", "", "kitId", "", "getName", "", "settings", "Landroid/content/Context;", "context", "", "Lcom/mparticle/kits/ReportingMessage;", "onKitCreate", "", "optedOut", "setOptOut", "filter", "addFilters", "Lorg/json/b;", "getJsonConfig", "I", "getKitId", "()I", "<init>", "(I)V", "Companion", "android-kit-base_release"}, k = 1, mv = {1, 7, 1})
public abstract class MPSideloadedKit extends KitIntegration implements SideloadedKit {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MIN_SIDELOADED_KIT = 1000000;
    private final int kitId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mparticle/kits/MPSideloadedKit$Companion;", "", "()V", "MIN_SIDELOADED_KIT", "", "android-kit-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MPSideloadedKit(int i10) {
        this.kitId = i10;
        setConfiguration(KitConfiguration.createKitConfiguration(new b().put("id", i10)));
    }

    private final KitConfiguration applyFilters(KitConfiguration kitConfiguration, MPSideloadedFilters mPSideloadedFilters) {
        KitConfiguration configuration = getConfiguration();
        if (configuration != null) {
            return configuration.applySideloadedKits(mPSideloadedFilters);
        }
        return null;
    }

    public final MPSideloadedKit addFilters(MPSideloadedFilters mPSideloadedFilters) {
        j.g(mPSideloadedFilters, "filter");
        KitConfiguration configuration = getConfiguration();
        j.f(configuration, "configuration");
        setConfiguration(applyFilters(configuration, mPSideloadedFilters));
        return this;
    }

    public b getJsonConfig() {
        return super.getJsonConfig();
    }

    public final int getKitId() {
        return this.kitId;
    }

    public String getName() {
        String name = getClass().getName();
        j.f(name, "this::class.java.name");
        String str = (String) CollectionsKt___CollectionsKt.Y(StringsKt__StringsKt.C0(name, new String[]{"."}, false, 0, 6, (Object) null));
        return str == null ? "" : str;
    }

    public int kitId() {
        return this.kitId;
    }

    /* access modifiers changed from: protected */
    public List<ReportingMessage> onKitCreate(Map<String, String> map, Context context) {
        return new ArrayList();
    }

    public List<ReportingMessage> setOptOut(boolean z10) {
        return new ArrayList();
    }
}
