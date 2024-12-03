package com.leanplum.internal;

import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.gms.common.api.a;
import com.mparticle.kits.ReportingMessage;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;

public class ResourceQualifiers {
    public Map<Qualifier, Object> qualifiers = new HashMap();

    public enum Qualifier {
        MCC(new QualifierFilter() {
            public Object getMatch(String str) {
                if (str.startsWith("mcc")) {
                    return Integer.getInteger(str.substring(3));
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.mcc == ((Integer) obj).intValue();
            }
        }),
        MNC(new QualifierFilter() {
            public Object getMatch(String str) {
                if (str.startsWith("mnc")) {
                    return Integer.getInteger(str.substring(3));
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.mnc == ((Integer) obj).intValue();
            }
        }),
        LANGUAGE(new QualifierFilter() {
            public Object getMatch(String str) {
                if (str.length() == 2) {
                    return str;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.locale.getLanguage().equals(obj);
            }
        }),
        REGION(new QualifierFilter() {
            public Object getMatch(String str) {
                if (!str.startsWith(StreamManagement.AckRequest.ELEMENT) || str.length() != 3) {
                    return null;
                }
                return str.substring(1);
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.locale.getCountry().toLowerCase().equals(obj);
            }
        }),
        LAYOUT_DIRECTION(new QualifierFilter() {
            public static final int SCREENLAYOUT_LAYOUTDIR_LTR = 64;
            public static final int SCREENLAYOUT_LAYOUTDIR_MASK = 192;
            public static final int SCREENLAYOUT_LAYOUTDIR_RTL = 128;

            public Object getMatch(String str) {
                if ("ldrtl".equals(str)) {
                    return 128;
                }
                if ("ldltr".equals(str)) {
                    return 64;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return (configuration.screenLayout & 192) == ((Integer) obj).intValue();
            }
        }),
        SMALLEST_WIDTH(new QualifierFilter() {
            public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
                HashMap hashMap = new HashMap();
                int i10 = Integer.MIN_VALUE;
                for (Map.Entry next : map.entrySet()) {
                    Integer num = (Integer) next.getValue();
                    if (num.intValue() > i10) {
                        i10 = num.intValue();
                        hashMap.clear();
                    }
                    if (num.intValue() == i10) {
                        hashMap.put((String) next.getKey(), num);
                    }
                }
                return hashMap;
            }

            public Object getMatch(String str) {
                if (!str.startsWith("sw") || !str.endsWith("dp")) {
                    return null;
                }
                return Integer.getInteger(str.substring(2, str.length() - 2));
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                try {
                    if (((Integer) configuration.getClass().getField("smallestScreenWidthDp").get(configuration)).intValue() >= ((Integer) obj).intValue()) {
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    Log.exception(th2);
                    return false;
                }
            }
        }),
        AVAILABLE_WIDTH(new QualifierFilter() {
            public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
                HashMap hashMap = new HashMap();
                int i10 = Integer.MIN_VALUE;
                for (Map.Entry next : map.entrySet()) {
                    Integer num = (Integer) next.getValue();
                    if (num.intValue() > i10) {
                        i10 = num.intValue();
                        hashMap.clear();
                    }
                    if (num.intValue() == i10) {
                        hashMap.put((String) next.getKey(), num);
                    }
                }
                return hashMap;
            }

            public Object getMatch(String str) {
                if (!str.startsWith("w") || !str.endsWith("dp")) {
                    return null;
                }
                return Integer.getInteger(str.substring(1, str.length() - 2));
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                try {
                    if (((Integer) configuration.getClass().getField("screenWidthDp").get(configuration)).intValue() >= ((Integer) obj).intValue()) {
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    Log.exception(th2);
                    return false;
                }
            }
        }),
        AVAILABLE_HEIGHT(new QualifierFilter() {
            public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
                HashMap hashMap = new HashMap();
                int i10 = Integer.MIN_VALUE;
                for (Map.Entry next : map.entrySet()) {
                    Integer num = (Integer) next.getValue();
                    if (num.intValue() > i10) {
                        i10 = num.intValue();
                        hashMap.clear();
                    }
                    if (num.intValue() == i10) {
                        hashMap.put((String) next.getKey(), num);
                    }
                }
                return hashMap;
            }

            public Object getMatch(String str) {
                if (!str.startsWith("h") || !str.endsWith("dp")) {
                    return null;
                }
                return Integer.getInteger(str.substring(1, str.length() - 2));
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                try {
                    if (((Integer) configuration.getClass().getField("screenHeightDp").get(configuration)).intValue() >= ((Integer) obj).intValue()) {
                        return true;
                    }
                    return false;
                } catch (Throwable th2) {
                    Log.exception(th2);
                    return false;
                }
            }
        }),
        SCREEN_SIZE(new QualifierFilter() {
            public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
                HashMap hashMap = new HashMap();
                int i10 = Integer.MIN_VALUE;
                for (Map.Entry next : map.entrySet()) {
                    Integer num = (Integer) next.getValue();
                    if (num.intValue() > i10) {
                        i10 = num.intValue();
                        hashMap.clear();
                    }
                    if (num.intValue() == i10) {
                        hashMap.put((String) next.getKey(), num);
                    }
                }
                return hashMap;
            }

            public Object getMatch(String str) {
                if ("small".equals(str)) {
                    return 1;
                }
                if ("normal".equals(str)) {
                    return 2;
                }
                if ("large".equals(str)) {
                    return 3;
                }
                if ("xlarge".equals(str)) {
                    return 4;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return (configuration.screenLayout & 15) <= ((Integer) obj).intValue();
            }
        }),
        SCREEN_ASPECT(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("long".equals(str)) {
                    return 32;
                }
                if ("notlong".equals(str)) {
                    return 16;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return (configuration.screenLayout & 48) == ((Integer) obj).intValue();
            }
        }),
        SCREEN_ORIENTATION(new QualifierFilter() {
            public Object getMatch(String str) {
                if (JingleS5BTransportCandidate.ATTR_PORT.equals(str)) {
                    return 1;
                }
                if ("land".equals(str)) {
                    return 2;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.orientation == ((Integer) obj).intValue();
            }
        }),
        UI_MODE(new QualifierFilter() {
            public static final int UI_MODE_TYPE_APPLIANCE = 5;
            public static final int UI_MODE_TYPE_TELEVISION = 4;

            public Object getMatch(String str) {
                if ("car".equals(str)) {
                    return 3;
                }
                if ("desk".equals(str)) {
                    return 2;
                }
                if ("television".equals(str)) {
                    return 4;
                }
                if ("appliance".equals(str)) {
                    return 5;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return (configuration.uiMode & 15) == ((Integer) obj).intValue();
            }
        }),
        NIGHT_MODE(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("night".equals(str)) {
                    return 32;
                }
                if ("notnight".equals(str)) {
                    return 16;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return (configuration.uiMode & 48) == ((Integer) obj).intValue();
            }
        }),
        SCREEN_PIXEL_DENSITY(new QualifierFilter() {
            public static final int DENSITY_NONE = 0;
            public static final int DENSITY_TV = 213;
            public static final int DENSITY_XXHIGH = 480;

            public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
                HashMap hashMap = new HashMap();
                int i10 = a.e.API_PRIORITY_OTHER;
                for (Map.Entry next : map.entrySet()) {
                    Integer num = (Integer) next.getValue();
                    if (num.intValue() < i10 && num.intValue() >= displayMetrics.densityDpi) {
                        i10 = num.intValue();
                        hashMap.clear();
                    }
                    if (num.intValue() == i10) {
                        hashMap.put((String) next.getKey(), num);
                    }
                }
                if (hashMap.size() == 0) {
                    int i11 = Integer.MIN_VALUE;
                    for (String next2 : map.keySet()) {
                        Integer num2 = (Integer) map.get(next2);
                        if (num2.intValue() > i11) {
                            i11 = num2.intValue();
                            hashMap.clear();
                        }
                        if (num2.intValue() == i11) {
                            hashMap.put(next2, num2);
                        }
                    }
                }
                return hashMap;
            }

            public Object getMatch(String str) {
                if ("ldpi".equals(str)) {
                    return 120;
                }
                if ("mdpi".equals(str)) {
                    return 160;
                }
                if ("hdpi".equals(str)) {
                    return 240;
                }
                if ("xhdpi".equals(str)) {
                    return 320;
                }
                if ("nodpi".equals(str)) {
                    return 0;
                }
                if ("tvdpi".equals(str)) {
                    return Integer.valueOf(DENSITY_TV);
                }
                if ("xxhigh".equals(str)) {
                    return Integer.valueOf(DENSITY_XXHIGH);
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return true;
            }
        }),
        TOUCHSCREEN_TYPE(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("notouch".equals(str)) {
                    return 1;
                }
                if ("finger".equals(str)) {
                    return 3;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.touchscreen == ((Integer) obj).intValue();
            }
        }),
        KEYBOARD_AVAILABILITY(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("keysexposed".equals(str)) {
                    return 1;
                }
                if ("keyshidden".equals(str)) {
                    return 2;
                }
                if ("keyssoft".equals(str)) {
                    return 0;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                Integer num = (Integer) obj;
                return num.intValue() == 0 || configuration.keyboardHidden == num.intValue();
            }
        }),
        PRIMARY_TEXT_INPUTMETHOD(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("nokeys".equals(str)) {
                    return 1;
                }
                if ("qwerty".equals(str)) {
                    return 2;
                }
                if ("12key".equals(str)) {
                    return 3;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.keyboard == ((Integer) obj).intValue();
            }
        }),
        NAVIGATION_KEY_AVAILABILITY(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("navexposed".equals(str)) {
                    return 1;
                }
                if ("navhidden".equals(str)) {
                    return 2;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.navigationHidden == ((Integer) obj).intValue();
            }
        }),
        PRIMARY_NON_TOUCH_NAVIGATION_METHOD(new QualifierFilter() {
            public Object getMatch(String str) {
                if ("nonav".equals(str)) {
                    return 1;
                }
                if ("dpad".equals(str)) {
                    return 2;
                }
                if ("trackball".equals(str)) {
                    return 3;
                }
                if ("wheel".equals(str)) {
                    return 4;
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return configuration.navigation == ((Integer) obj).intValue();
            }
        }),
        PLATFORM_VERSION(new QualifierFilter() {
            public Object getMatch(String str) {
                if (str.startsWith(ReportingMessage.MessageType.SCREEN_VIEW)) {
                    return Integer.getInteger(str.substring(1));
                }
                return null;
            }

            public boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics) {
                return Build.VERSION.SDK_INT >= ((Integer) obj).intValue();
            }
        });
        
        private QualifierFilter filter;

        private Qualifier(QualifierFilter qualifierFilter) {
            this.filter = qualifierFilter;
        }

        public QualifierFilter getFilter() {
            return this.filter;
        }
    }

    public static abstract class QualifierFilter {
        public Map<String, Object> bestMatch(Map<String, Object> map, Configuration configuration, DisplayMetrics displayMetrics) {
            return map;
        }

        /* access modifiers changed from: package-private */
        public abstract Object getMatch(String str);

        public abstract boolean isMatch(Object obj, Configuration configuration, DisplayMetrics displayMetrics);
    }

    public static ResourceQualifiers fromFolder(String str) {
        ResourceQualifiers resourceQualifiers = new ResourceQualifiers();
        int i10 = 0;
        for (String str2 : str.toLowerCase().split(HelpFormatter.DEFAULT_OPT_PREFIX)) {
            boolean z10 = false;
            while (!z10 && i10 < Qualifier.values().length) {
                Qualifier qualifier = Qualifier.values()[i10];
                Object match = qualifier.getFilter().getMatch(str2);
                if (match != null) {
                    resourceQualifiers.qualifiers.put(qualifier, match);
                    z10 = true;
                }
                i10++;
            }
        }
        return resourceQualifiers;
    }
}
