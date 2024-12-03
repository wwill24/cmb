package com.google.firebase.platforminfo;

import gk.d;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return d.f29688f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
