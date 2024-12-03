package com.google.firebase.perf.v1;

import com.google.protobuf.w;

public enum ApplicationProcessState implements w.c {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final w.d<ApplicationProcessState> internalValueMap = null;
    private final int value;

    private static final class ApplicationProcessStateVerifier implements w.e {
        static final w.e INSTANCE = null;

        static {
            INSTANCE = new ApplicationProcessStateVerifier();
        }

        private ApplicationProcessStateVerifier() {
        }

        public boolean isInRange(int i10) {
            return ApplicationProcessState.forNumber(i10) != null;
        }
    }

    static {
        internalValueMap = new w.d<ApplicationProcessState>() {
            public ApplicationProcessState findValueByNumber(int i10) {
                return ApplicationProcessState.forNumber(i10);
            }
        };
    }

    private ApplicationProcessState(int i10) {
        this.value = i10;
    }

    public static ApplicationProcessState forNumber(int i10) {
        if (i10 == 0) {
            return APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        if (i10 == 1) {
            return FOREGROUND;
        }
        if (i10 == 2) {
            return BACKGROUND;
        }
        if (i10 != 3) {
            return null;
        }
        return FOREGROUND_BACKGROUND;
    }

    public static w.d<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    public static w.e internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ApplicationProcessState valueOf(int i10) {
        return forNumber(i10);
    }
}
