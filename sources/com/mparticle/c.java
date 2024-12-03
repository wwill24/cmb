package com.mparticle;

import android.location.Location;
import com.mparticle.internal.InternalSession;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.ReportingMessage;
import org.json.JSONException;
import org.json.b;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private long f22272a;

    public static class a extends d {
        public a(String str) {
            super(str);
        }
    }

    protected c() {
    }

    public String a() {
        return optString("dt");
    }

    public long b() {
        return this.f22272a;
    }

    public String c() {
        return optString("n");
    }

    public String d() {
        if (ReportingMessage.MessageType.SESSION_START.equals(a())) {
            return optString("id", "NO-SESSION");
        }
        return optString("sid", "NO-SESSION");
    }

    public int e() {
        return MPUtility.mpHash(a() + c());
    }

    protected c(d dVar, InternalSession internalSession, Location location, long j10) throws JSONException {
        super((b) dVar, dVar.a());
        this.f22272a = j10;
        if (!has("ct")) {
            put("ct", internalSession.mLastEventTime);
        }
        if (ReportingMessage.MessageType.SESSION_START.equals(dVar.b())) {
            put("id", (Object) internalSession.mSessionID);
        } else {
            put("sid", (Object) internalSession.mSessionID);
            long j11 = internalSession.mSessionStartTime;
            if (j11 > 0) {
                put("sct", j11);
            }
        }
        if ((!"x".equals(dVar.b()) || ReportingMessage.MessageType.OPT_OUT.equals(dVar.b())) && location != null) {
            b bVar = new b();
            bVar.put("lat", location.getLatitude());
            bVar.put("lng", location.getLongitude());
            bVar.put("acc", (double) location.getAccuracy());
            put("lc", (Object) bVar);
        }
    }
}
