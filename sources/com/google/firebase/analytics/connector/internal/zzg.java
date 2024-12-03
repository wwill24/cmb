package com.google.firebase.analytics.connector.internal;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;
import ve.a;

public final class zzg implements zza {
    /* access modifiers changed from: private */
    public final AnalyticsConnector.AnalyticsConnectorListener zza;
    private final a zzb;
    private final zzf zzc;

    public zzg(a aVar, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = aVar;
        zzf zzf = new zzf(this);
        this.zzc = zzf;
        aVar.f(zzf);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    public final void zzb(Set set) {
    }

    public final void zzc() {
    }
}
