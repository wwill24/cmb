package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.x;

public enum KeyStatusType implements x.c {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: f  reason: collision with root package name */
    private static final x.d<KeyStatusType> f20604f = null;
    private final int value;

    class a implements x.d<KeyStatusType> {
        a() {
        }

        /* renamed from: a */
        public KeyStatusType findValueByNumber(int i10) {
            return KeyStatusType.a(i10);
        }
    }

    static {
        f20604f = new a();
    }

    private KeyStatusType(int i10) {
        this.value = i10;
    }

    public static KeyStatusType a(int i10) {
        if (i10 == 0) {
            return UNKNOWN_STATUS;
        }
        if (i10 == 1) {
            return ENABLED;
        }
        if (i10 == 2) {
            return DISABLED;
        }
        if (i10 != 3) {
            return null;
        }
        return DESTROYED;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
