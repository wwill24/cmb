package com.mparticle;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.mparticle.MParticle;
import com.mparticle.identity.AliasRequest;
import java.util.UUID;
import org.json.JSONException;
import org.json.b;

public class s extends b {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22633a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mparticle.MParticle$Environment[] r0 = com.mparticle.MParticle.Environment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22633a = r0
                com.mparticle.MParticle$Environment r1 = com.mparticle.MParticle.Environment.Development     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22633a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.MParticle$Environment r1 = com.mparticle.MParticle.Environment.Production     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.s.a.<clinit>():void");
        }
    }

    public s(String str) throws JSONException {
        super(str);
    }

    public AliasRequest a() throws JSONException {
        b jSONObject = getJSONObject("data");
        return AliasRequest.builder().destinationMpid(jSONObject.getLong("destination_mpid")).sourceMpid(jSONObject.getLong("source_mpid")).endTime(jSONObject.optLong("end_unixtime_ms", 0)).startTime(jSONObject.optLong("start_unixtime_ms", 0)).build();
    }

    public String b() throws JSONException {
        return getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
    }

    public s(AliasRequest aliasRequest, String str, String str2) throws JSONException {
        String a10 = a(com.mparticle.internal.b.u());
        String uuid = UUID.randomUUID().toString();
        b put = new b().put("source_mpid", aliasRequest.getSourceMpid()).put("destination_mpid", aliasRequest.getDestinationMpid()).put("device_application_stamp", (Object) str);
        if (aliasRequest.getStartTime() != 0) {
            put.put("start_unixtime_ms", aliasRequest.getStartTime());
        }
        if (aliasRequest.getEndTime() != 0) {
            put.put("end_unixtime_ms", aliasRequest.getEndTime());
        }
        put("data", (Object) put);
        put("request_type", (Object) "alias");
        put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, (Object) uuid);
        put("environment", (Object) a10);
        put("api_key", (Object) str2);
    }

    /* access modifiers changed from: protected */
    public String a(MParticle.Environment environment) {
        int i10 = a.f22633a[environment.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? "" : "production";
        }
        return "development";
    }
}
