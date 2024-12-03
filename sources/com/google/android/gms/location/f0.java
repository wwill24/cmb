package com.google.android.gms.location;

import com.google.android.gms.common.internal.p;
import java.util.Comparator;

final class f0 implements Comparator {
    f0() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        p.k(detectedActivity);
        p.k(detectedActivity2);
        int compareTo = Integer.valueOf(detectedActivity2.S()).compareTo(Integer.valueOf(detectedActivity.S()));
        if (compareTo == 0) {
            return Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType()));
        }
        return compareTo;
    }
}
