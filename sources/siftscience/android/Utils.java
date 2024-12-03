package siftscience.android;

import com.sift.api.representations.MobileEventJson;

public class Utils {
    public static boolean equals(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == obj2 : obj.equals(obj2);
    }

    public static boolean eventsAreBasicallyEqual(MobileEventJson mobileEventJson, MobileEventJson mobileEventJson2) {
        boolean z10;
        boolean z11;
        if (mobileEventJson == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (mobileEventJson2 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (mobileEventJson == mobileEventJson2) {
            return true;
        }
        Long l10 = mobileEventJson.time;
        mobileEventJson.time = mobileEventJson2.time;
        boolean equals = mobileEventJson.equals(mobileEventJson2);
        mobileEventJson.time = l10;
        return equals;
    }
}
