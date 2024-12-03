package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.x;

public enum OutputPrefixType implements x.c {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: g  reason: collision with root package name */
    private static final x.d<OutputPrefixType> f20612g = null;
    private final int value;

    class a implements x.d<OutputPrefixType> {
        a() {
        }

        /* renamed from: a */
        public OutputPrefixType findValueByNumber(int i10) {
            return OutputPrefixType.a(i10);
        }
    }

    static {
        f20612g = new a();
    }

    private OutputPrefixType(int i10) {
        this.value = i10;
    }

    public static OutputPrefixType a(int i10) {
        if (i10 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i10 == 1) {
            return TINK;
        }
        if (i10 == 2) {
            return LEGACY;
        }
        if (i10 == 3) {
            return RAW;
        }
        if (i10 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
