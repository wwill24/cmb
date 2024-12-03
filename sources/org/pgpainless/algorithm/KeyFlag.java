package org.pgpainless.algorithm;

public enum KeyFlag {
    CERTIFY_OTHER(1),
    SIGN_DATA(2),
    ENCRYPT_COMMS(4),
    ENCRYPT_STORAGE(8),
    SPLIT(16),
    AUTHENTICATION(32),
    SHARED(128);
    
    private final int flag;

    private KeyFlag(int i10) {
        this.flag = i10;
    }

    public static boolean b(int i10, KeyFlag keyFlag) {
        return (i10 & keyFlag.a()) == keyFlag.a();
    }

    public static int c(KeyFlag... keyFlagArr) {
        int i10 = 0;
        for (KeyFlag a10 : keyFlagArr) {
            i10 |= a10.a();
        }
        return i10;
    }

    public int a() {
        return this.flag;
    }
}
