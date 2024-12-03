package com.mparticle.internal;

import android.content.Context;
import com.mparticle.h;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.b;

public class InternalSession {
    public long mLastEventTime = 0;
    public b mSessionAttributes = new b();
    public String mSessionID = "NO-SESSION";
    public long mSessionStartTime = 0;
    private long mTimeInBackground = 0;
    private Set<Long> mpids = new TreeSet();

    public InternalSession() {
    }

    public void addMpid(long j10) {
        if (j10 != h.f22319b.longValue()) {
            this.mpids.add(Long.valueOf(j10));
        }
        InternalListenerManager.getListener().onSessionUpdated(this);
    }

    public long getBackgroundTime() {
        return this.mTimeInBackground;
    }

    public long getForegroundTime() {
        return getLength() - getBackgroundTime();
    }

    public long getLength() {
        return this.mLastEventTime - this.mSessionStartTime;
    }

    public Set<Long> getMpids() {
        return this.mpids;
    }

    public boolean isActive() {
        return this.mSessionStartTime > 0 && !"NO-SESSION".equals(this.mSessionID);
    }

    public boolean isTimedOut(int i10) {
        return ((long) i10) < System.currentTimeMillis() - this.mLastEventTime;
    }

    public InternalSession start(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.mSessionStartTime = currentTimeMillis;
        this.mLastEventTime = currentTimeMillis;
        this.mSessionID = UUID.randomUUID().toString().toUpperCase(Locale.US);
        this.mSessionAttributes = new b();
        this.mTimeInBackground = 0;
        addMpid(b.b(context));
        InternalListenerManager.getListener().onSessionUpdated(this);
        return this;
    }

    public void updateBackgroundTime(AtomicLong atomicLong, long j10) {
        this.mTimeInBackground += j10 - atomicLong.get();
    }

    public InternalSession(InternalSession internalSession) {
        this.mSessionID = internalSession.mSessionID;
        this.mSessionStartTime = internalSession.mSessionStartTime;
        this.mLastEventTime = internalSession.mLastEventTime;
        this.mTimeInBackground = internalSession.mTimeInBackground;
        try {
            this.mSessionAttributes = new b(internalSession.mSessionAttributes.toString());
        } catch (JSONException unused) {
        }
    }
}
