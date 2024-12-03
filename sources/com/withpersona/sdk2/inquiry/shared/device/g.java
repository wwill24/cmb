package com.withpersona.sdk2.inquiry.shared.device;

import android.os.Build;

public final class g implements c {
    public String a() {
        return Build.MODEL;
    }

    public String b() {
        return Build.MANUFACTURER;
    }

    public String c() {
        return Build.VERSION.RELEASE;
    }
}
