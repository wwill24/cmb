package com.google.android.gms.location;

import com.google.android.gms.common.api.b;

public final class f extends b {
    public static int b(int i10) {
        if (i10 == 0) {
            return i10;
        }
        if (i10 < 1000 || i10 >= 1006) {
            return 13;
        }
        return i10;
    }
}
