package com.google.firebase.perf.v1;

import com.google.protobuf.w;

public enum SessionVerbosity implements w.c {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    public static final int GAUGES_AND_SYSTEM_EVENTS_VALUE = 1;
    public static final int SESSION_VERBOSITY_NONE_VALUE = 0;
    private static final w.d<SessionVerbosity> internalValueMap = null;
    private final int value;

    private static final class SessionVerbosityVerifier implements w.e {
        static final w.e INSTANCE = null;

        static {
            INSTANCE = new SessionVerbosityVerifier();
        }

        private SessionVerbosityVerifier() {
        }

        public boolean isInRange(int i10) {
            return SessionVerbosity.forNumber(i10) != null;
        }
    }

    static {
        internalValueMap = new w.d<SessionVerbosity>() {
            public SessionVerbosity findValueByNumber(int i10) {
                return SessionVerbosity.forNumber(i10);
            }
        };
    }

    private SessionVerbosity(int i10) {
        this.value = i10;
    }

    public static SessionVerbosity forNumber(int i10) {
        if (i10 == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i10 != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static w.d<SessionVerbosity> internalGetValueMap() {
        return internalValueMap;
    }

    public static w.e internalGetVerifier() {
        return SessionVerbosityVerifier.INSTANCE;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static SessionVerbosity valueOf(int i10) {
        return forNumber(i10);
    }
}
