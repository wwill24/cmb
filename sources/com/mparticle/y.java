package com.mparticle;

import android.location.Location;
import com.mparticle.MParticle;
import com.mparticle.internal.InternalSession;
import org.json.JSONException;

public class y extends c {
    protected y(a aVar, InternalSession internalSession, Location location, long j10) throws JSONException {
        super(aVar, internalSession, location, j10);
    }

    public static class a extends d {
        public a(String str) {
            super(str);
        }

        public d a(MParticle.EventType eventType) {
            try {
                put("et", (Object) eventType);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            return this;
        }

        public c a(InternalSession internalSession, Location location, long j10) throws JSONException {
            return new y(this, internalSession, location, j10);
        }
    }
}
