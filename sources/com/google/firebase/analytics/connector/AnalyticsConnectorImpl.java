package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzef;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;
import ve.a;
import we.n;
import we.v;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final a zza;
    final Map zzb = new ConcurrentHashMap();

    AnalyticsConnectorImpl(a aVar) {
        p.k(aVar);
        this.zza = aVar;
    }

    @NonNull
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    static /* synthetic */ void zza(Event event) {
        boolean z10 = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) p.k(zzc)).zza.i(z10);
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzc(@NonNull String str) {
        return !str.isEmpty() && this.zzb.containsKey(str) && this.zzb.get(str) != null;
    }

    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.a(str, str2, bundle);
        }
    }

    @NonNull
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @NonNull String str2) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        ArrayList arrayList = new ArrayList();
        for (Bundle next : this.zza.b(str, str2)) {
            int i10 = zzc.zza;
            p.k(next);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.origin = (String) p.k((String) n.a(next, FirebaseAnalytics.Param.ORIGIN, cls2, (Object) null));
            conditionalUserProperty.name = (String) p.k((String) n.a(next, "name", cls2, (Object) null));
            conditionalUserProperty.value = n.a(next, "value", Object.class, (Object) null);
            conditionalUserProperty.triggerEventName = (String) n.a(next, "trigger_event_name", cls2, (Object) null);
            conditionalUserProperty.triggerTimeout = ((Long) n.a(next, "trigger_timeout", cls, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) n.a(next, "timed_out_event_name", cls2, (Object) null);
            conditionalUserProperty.timedOutEventParams = (Bundle) n.a(next, "timed_out_event_params", Bundle.class, (Object) null);
            conditionalUserProperty.triggeredEventName = (String) n.a(next, "triggered_event_name", cls2, (Object) null);
            conditionalUserProperty.triggeredEventParams = (Bundle) n.a(next, "triggered_event_params", Bundle.class, (Object) null);
            conditionalUserProperty.timeToLive = ((Long) n.a(next, "time_to_live", cls, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) n.a(next, "expired_event_name", cls2, (Object) null);
            conditionalUserProperty.expiredEventParams = (Bundle) n.a(next, "expired_event_params", Bundle.class, (Object) null);
            conditionalUserProperty.active = ((Boolean) n.a(next, ClientStateIndication.Active.ELEMENT, Boolean.class, Boolean.FALSE)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) n.a(next, "creation_timestamp", cls, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) n.a(next, "triggered_timestamp", cls, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public int getMaxUserProperties(@NonNull String str) {
        return this.zza.c(str);
    }

    @NonNull
    public Map<String, Object> getUserProperties(boolean z10) {
        return this.zza.d((String) null, (String) null, z10);
    }

    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzd(str) && zzc.zzb(str2, bundle) && zzc.zza(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1);
            }
            this.zza.e(str, str2, bundle);
        }
    }

    @NonNull
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull final String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        p.k(analyticsConnectorListener);
        if (!zzc.zzd(str) || zzc(str)) {
            return null;
        }
        a aVar = this.zza;
        if (FirebaseABTesting.OriginService.INAPP_MESSAGING.equals(str)) {
            obj = new zze(aVar, analyticsConnectorListener);
        } else if ("clx".equals(str)) {
            obj = new zzg(aVar, analyticsConnectorListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.zzb.put(str, obj);
        return new AnalyticsConnector.AnalyticsConnectorHandle() {
            public void registerEventNames(Set<String> set) {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING) && set != null && !set.isEmpty()) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzb(set);
                }
            }

            public final void unregister() {
                if (AnalyticsConnectorImpl.this.zzc(str)) {
                    AnalyticsConnector.AnalyticsConnectorListener zza2 = ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zza();
                    if (zza2 != null) {
                        zza2.onMessageTriggered(0, (Bundle) null);
                    }
                    AnalyticsConnectorImpl.this.zzb.remove(str);
                }
            }

            public void unregisterEventNames() {
                if (AnalyticsConnectorImpl.this.zzc(str) && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING)) {
                    ((zza) AnalyticsConnectorImpl.this.zzb.get(str)).zzc();
                }
            }
        };
    }

    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i10 = zzc.zza;
        if (conditionalUserProperty != null && (str = conditionalUserProperty.origin) != null && !str.isEmpty()) {
            Object obj = conditionalUserProperty.value;
            if ((obj == null || v.a(obj) != null) && zzc.zzd(str) && zzc.zze(str, conditionalUserProperty.name)) {
                String str2 = conditionalUserProperty.expiredEventName;
                if (str2 == null || (zzc.zzb(str2, conditionalUserProperty.expiredEventParams) && zzc.zza(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                    String str3 = conditionalUserProperty.triggeredEventName;
                    if (str3 == null || (zzc.zzb(str3, conditionalUserProperty.triggeredEventParams) && zzc.zza(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                        String str4 = conditionalUserProperty.timedOutEventName;
                        if (str4 == null || (zzc.zzb(str4, conditionalUserProperty.timedOutEventParams) && zzc.zza(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                            a aVar = this.zza;
                            Bundle bundle = new Bundle();
                            String str5 = conditionalUserProperty.origin;
                            if (str5 != null) {
                                bundle.putString(FirebaseAnalytics.Param.ORIGIN, str5);
                            }
                            String str6 = conditionalUserProperty.name;
                            if (str6 != null) {
                                bundle.putString("name", str6);
                            }
                            Object obj2 = conditionalUserProperty.value;
                            if (obj2 != null) {
                                n.b(bundle, obj2);
                            }
                            String str7 = conditionalUserProperty.triggerEventName;
                            if (str7 != null) {
                                bundle.putString("trigger_event_name", str7);
                            }
                            bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
                            String str8 = conditionalUserProperty.timedOutEventName;
                            if (str8 != null) {
                                bundle.putString("timed_out_event_name", str8);
                            }
                            Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
                            if (bundle2 != null) {
                                bundle.putBundle("timed_out_event_params", bundle2);
                            }
                            String str9 = conditionalUserProperty.triggeredEventName;
                            if (str9 != null) {
                                bundle.putString("triggered_event_name", str9);
                            }
                            Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
                            if (bundle3 != null) {
                                bundle.putBundle("triggered_event_params", bundle3);
                            }
                            bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
                            String str10 = conditionalUserProperty.expiredEventName;
                            if (str10 != null) {
                                bundle.putString("expired_event_name", str10);
                            }
                            Bundle bundle4 = conditionalUserProperty.expiredEventParams;
                            if (bundle4 != null) {
                                bundle.putBundle("expired_event_params", bundle4);
                            }
                            bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
                            bundle.putBoolean(ClientStateIndication.Active.ELEMENT, conditionalUserProperty.active);
                            bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
                            aVar.g(bundle);
                        }
                    }
                }
            }
        }
    }

    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (zzc.zzd(str) && zzc.zze(str, str2)) {
            this.zza.h(str, str2, obj);
        }
    }

    @NonNull
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @NonNull
    public static AnalyticsConnector getInstance(@NonNull FirebaseApp firebaseApp, @NonNull Context context, @NonNull Subscriber subscriber) {
        p.k(firebaseApp);
        p.k(context);
        p.k(subscriber);
        p.k(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zza, zzb.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzef.zzg(context, (String) null, (String) null, (String) null, bundle).zzd());
                }
            }
        }
        return zzc;
    }
}
