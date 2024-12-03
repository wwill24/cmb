package com.google.android.gms.location;

import com.google.android.gms.common.internal.p;
import java.util.Comparator;

final class b0 implements Comparator {
    b0() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        p.k(activityTransition);
        p.k(activityTransition2);
        int S = activityTransition.S();
        int S2 = activityTransition2.S();
        if (S == S2) {
            int Y = activityTransition.Y();
            int Y2 = activityTransition2.Y();
            if (Y == Y2) {
                return 0;
            }
            if (Y < Y2) {
                return -1;
            }
            return 1;
        } else if (S >= S2) {
            return 1;
        } else {
            return -1;
        }
    }
}
