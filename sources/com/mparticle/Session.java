package com.mparticle;

import com.mparticle.internal.MPUtility;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class Session {
    private final Long mSessionStartTime;
    private final String mUUID;

    private Session() {
        this.mUUID = null;
        this.mSessionStartTime = null;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Session)) {
            return false;
        }
        String sessionUUID = getSessionUUID();
        Long sessionStartTime = getSessionStartTime();
        Session session = (Session) obj;
        String sessionUUID2 = session.getSessionUUID();
        Long sessionStartTime2 = session.getSessionStartTime();
        if (sessionUUID == sessionUUID2 && sessionStartTime == sessionStartTime2) {
            return true;
        }
        if (sessionUUID == null || sessionStartTime == null || !sessionUUID.equals(sessionUUID2) || !sessionStartTime.equals(sessionStartTime2)) {
            return false;
        }
        return true;
    }

    public long getSessionID() {
        String sessionUUID = getSessionUUID();
        if (sessionUUID == null) {
            return 0;
        }
        try {
            return MPUtility.hashFnv1A(sessionUUID.getBytes("UTF-16LE")).longValue();
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    public Long getSessionStartTime() {
        return this.mSessionStartTime;
    }

    public String getSessionUUID() {
        String str = this.mUUID;
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    Session(String str, Long l10) {
        this.mUUID = str;
        this.mSessionStartTime = l10;
    }
}
