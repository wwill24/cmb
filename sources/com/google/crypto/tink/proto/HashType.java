package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.x;

public enum HashType implements x.c {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: g  reason: collision with root package name */
    private static final x.d<HashType> f20588g = null;
    private final int value;

    class a implements x.d<HashType> {
        a() {
        }

        /* renamed from: a */
        public HashType findValueByNumber(int i10) {
            return HashType.a(i10);
        }
    }

    static {
        f20588g = new a();
    }

    private HashType(int i10) {
        this.value = i10;
    }

    public static HashType a(int i10) {
        if (i10 == 0) {
            return UNKNOWN_HASH;
        }
        if (i10 == 1) {
            return SHA1;
        }
        if (i10 == 2) {
            return SHA384;
        }
        if (i10 == 3) {
            return SHA256;
        }
        if (i10 != 4) {
            return null;
        }
        return SHA512;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
