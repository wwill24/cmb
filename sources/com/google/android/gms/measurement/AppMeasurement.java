package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.measurement.internal.u4;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.csi.packet.ClientStateIndication;
import we.n;
import we.u;

@Deprecated
public class AppMeasurement {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AppMeasurement f39615b;

    /* renamed from: a  reason: collision with root package name */
    private final d f39616a;

    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @NonNull
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @NonNull
        @Keep
        public String mExpiredEventName;
        @NonNull
        @Keep
        public Bundle mExpiredEventParams;
        @NonNull
        @Keep
        public String mName;
        @NonNull
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @NonNull
        @Keep
        public String mTimedOutEventName;
        @NonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @NonNull
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @NonNull
        @Keep
        public String mTriggeredEventName;
        @NonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @NonNull
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(@NonNull Bundle bundle) {
            Class<Long> cls = Long.class;
            Class<String> cls2 = String.class;
            p.k(bundle);
            this.mAppId = (String) n.a(bundle, "app_id", cls2, (Object) null);
            this.mOrigin = (String) n.a(bundle, FirebaseAnalytics.Param.ORIGIN, cls2, (Object) null);
            this.mName = (String) n.a(bundle, "name", cls2, (Object) null);
            this.mValue = n.a(bundle, "value", Object.class, (Object) null);
            this.mTriggerEventName = (String) n.a(bundle, "trigger_event_name", cls2, (Object) null);
            this.mTriggerTimeout = ((Long) n.a(bundle, "trigger_timeout", cls, 0L)).longValue();
            this.mTimedOutEventName = (String) n.a(bundle, "timed_out_event_name", cls2, (Object) null);
            this.mTimedOutEventParams = (Bundle) n.a(bundle, "timed_out_event_params", Bundle.class, (Object) null);
            this.mTriggeredEventName = (String) n.a(bundle, "triggered_event_name", cls2, (Object) null);
            this.mTriggeredEventParams = (Bundle) n.a(bundle, "triggered_event_params", Bundle.class, (Object) null);
            this.mTimeToLive = ((Long) n.a(bundle, "time_to_live", cls, 0L)).longValue();
            this.mExpiredEventName = (String) n.a(bundle, "expired_event_name", cls2, (Object) null);
            this.mExpiredEventParams = (Bundle) n.a(bundle, "expired_event_params", Bundle.class, (Object) null);
            this.mActive = ((Boolean) n.a(bundle, ClientStateIndication.Active.ELEMENT, Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) n.a(bundle, "creation_timestamp", cls, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) n.a(bundle, "triggered_timestamp", cls, 0L)).longValue();
        }
    }

    public AppMeasurement(u4 u4Var) {
        this.f39616a = new a(u4Var);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.NonNull
    @java.lang.Deprecated
    @androidx.annotation.Keep
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.measurement.AppMeasurement getInstance(@androidx.annotation.NonNull android.content.Context r14) {
        /*
            com.google.android.gms.measurement.AppMeasurement r0 = f39615b
            if (r0 != 0) goto L_0x0059
            java.lang.Class<com.google.android.gms.measurement.AppMeasurement> r0 = com.google.android.gms.measurement.AppMeasurement.class
            monitor-enter(r0)
            com.google.android.gms.measurement.AppMeasurement r1 = f39615b     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0054
            r1 = 0
            java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r2 = com.google.firebase.analytics.FirebaseAnalytics.class
            java.lang.String r3 = "getScionFrontendApiImplementation"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{  }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch:{  }
            java.lang.Class<android.os.Bundle> r6 = android.os.Bundle.class
            r8 = 1
            r5[r8] = r6     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r5)     // Catch:{  }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{  }
            r3[r7] = r14     // Catch:{  }
            r3[r8] = r1     // Catch:{  }
            java.lang.Object r2 = r2.invoke(r1, r3)     // Catch:{  }
            we.u r2 = (we.u) r2     // Catch:{  }
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.AppMeasurement r14 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0056 }
            r14.<init>((we.u) r2)     // Catch:{ all -> 0x0056 }
            f39615b = r14     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x0039:
            com.google.android.gms.internal.measurement.zzcl r13 = new com.google.android.gms.internal.measurement.zzcl     // Catch:{ all -> 0x0056 }
            r3 = 0
            r5 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r13
            r2.<init>(r3, r5, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0056 }
            com.google.android.gms.measurement.internal.u4 r14 = com.google.android.gms.measurement.internal.u4.H(r14, r13, r1)     // Catch:{ all -> 0x0056 }
            com.google.android.gms.measurement.AppMeasurement r1 = new com.google.android.gms.measurement.AppMeasurement     // Catch:{ all -> 0x0056 }
            r1.<init>((com.google.android.gms.measurement.internal.u4) r14)     // Catch:{ all -> 0x0056 }
            f39615b = r1     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0059
        L_0x0056:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r14
        L_0x0059:
            com.google.android.gms.measurement.AppMeasurement r14 = f39615b
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.AppMeasurement.getInstance(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    @Keep
    public void beginAdUnitExposure(@NonNull String str) {
        this.f39616a.zzp(str);
    }

    @Keep
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f39616a.zzq(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@NonNull String str) {
        this.f39616a.zzr(str);
    }

    @Keep
    public long generateEventId() {
        return this.f39616a.zzb();
    }

    @NonNull
    @Keep
    public String getAppInstanceId() {
        return this.f39616a.zzh();
    }

    @NonNull
    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @NonNull String str2) {
        int i10;
        List<Bundle> zzm = this.f39616a.zzm(str, str2);
        if (zzm == null) {
            i10 = 0;
        } else {
            i10 = zzm.size();
        }
        ArrayList arrayList = new ArrayList(i10);
        for (Bundle conditionalUserProperty : zzm) {
            arrayList.add(new ConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    @NonNull
    @Keep
    public String getCurrentScreenClass() {
        return this.f39616a.zzi();
    }

    @NonNull
    @Keep
    public String getCurrentScreenName() {
        return this.f39616a.zzj();
    }

    @NonNull
    @Keep
    public String getGmpAppId() {
        return this.f39616a.zzk();
    }

    @Keep
    public int getMaxUserProperties(@NonNull String str) {
        return this.f39616a.zza(str);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @Keep
    public Map<String, Object> getUserProperties(@NonNull String str, @NonNull String str2, boolean z10) {
        return this.f39616a.zzo(str, str2, z10);
    }

    @Keep
    public void logEventInternal(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        this.f39616a.zzs(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        p.k(conditionalUserProperty);
        d dVar = this.f39616a;
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            n.b(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean(ClientStateIndication.Active.ELEMENT, conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        dVar.zzv(bundle);
    }

    public AppMeasurement(u uVar) {
        this.f39616a = new b(uVar);
    }
}
