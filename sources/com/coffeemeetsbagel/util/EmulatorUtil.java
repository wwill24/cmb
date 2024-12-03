package com.coffeemeetsbagel.util;

import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class EmulatorUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final EmulatorUtil f37578a = new EmulatorUtil();

    public enum COMPARE_TYPE {
        CONTAINS,
        EQUALS,
        STARTS_WITH
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37583a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.coffeemeetsbagel.util.EmulatorUtil$COMPARE_TYPE[] r0 = com.coffeemeetsbagel.util.EmulatorUtil.COMPARE_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.util.EmulatorUtil$COMPARE_TYPE r1 = com.coffeemeetsbagel.util.EmulatorUtil.COMPARE_TYPE.CONTAINS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.util.EmulatorUtil$COMPARE_TYPE r1 = com.coffeemeetsbagel.util.EmulatorUtil.COMPARE_TYPE.EQUALS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.util.EmulatorUtil$COMPARE_TYPE r1 = com.coffeemeetsbagel.util.EmulatorUtil.COMPARE_TYPE.STARTS_WITH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f37583a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.util.EmulatorUtil.a.<clinit>():void");
        }
    }

    private EmulatorUtil() {
    }

    private final boolean b(String str, String str2) {
        return r.J(str, "generic", false, 2, (Object) null) && r.J(str2, "generic", false, 2, (Object) null);
    }

    private final boolean c(String str, List<? extends Pair<String, ? extends COMPARE_TYPE>> list) {
        for (Pair pair : list) {
            String str2 = (String) pair.c();
            int i10 = a.f37583a[((COMPARE_TYPE) pair.d()).ordinal()];
            if (i10 == 1) {
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase2 = str2.toLowerCase(locale);
                j.f(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (StringsKt__StringsKt.O(lowerCase, lowerCase2, false, 2, (Object) null)) {
                    return true;
                }
            } else if (i10 == 2) {
                Locale locale2 = Locale.ROOT;
                String lowerCase3 = str.toLowerCase(locale2);
                j.f(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase4 = str2.toLowerCase(locale2);
                j.f(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (j.b(lowerCase3, lowerCase4)) {
                    return true;
                }
            } else if (i10 != 3) {
                continue;
            } else {
                Locale locale3 = Locale.ROOT;
                String lowerCase5 = str.toLowerCase(locale3);
                j.f(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase6 = str2.toLowerCase(locale3);
                j.f(lowerCase6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (r.J(lowerCase5, lowerCase6, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final List<Pair<String, COMPARE_TYPE>> d() {
        return p.e(new Pair("nox", COMPARE_TYPE.CONTAINS));
    }

    private final List<Pair<String, COMPARE_TYPE>> f() {
        COMPARE_TYPE compare_type = COMPARE_TYPE.STARTS_WITH;
        return q.m(new Pair("generic", compare_type), new Pair("unknown", compare_type));
    }

    private final List<Pair<String, COMPARE_TYPE>> g() {
        COMPARE_TYPE compare_type = COMPARE_TYPE.EQUALS;
        COMPARE_TYPE compare_type2 = COMPARE_TYPE.CONTAINS;
        return q.m(new Pair("goldfish", compare_type), new Pair("vbox86", compare_type), new Pair("ranchu", compare_type2), new Pair("nox", compare_type2));
    }

    private final List<Pair<String, COMPARE_TYPE>> h() {
        return p.e(new Pair("Genymotion", COMPARE_TYPE.CONTAINS));
    }

    private final List<Pair<String, COMPARE_TYPE>> i() {
        COMPARE_TYPE compare_type = COMPARE_TYPE.CONTAINS;
        return q.m(new Pair("google_sdk", compare_type), new Pair("droid4x", compare_type), new Pair("Emulator", compare_type), new Pair("Android SDK built for x86", compare_type));
    }

    private final List<Pair<String, COMPARE_TYPE>> j() {
        COMPARE_TYPE compare_type = COMPARE_TYPE.EQUALS;
        COMPARE_TYPE compare_type2 = COMPARE_TYPE.CONTAINS;
        return q.m(new Pair("sdk", compare_type), new Pair("google_sdk", compare_type), new Pair("sdk_x86", compare_type), new Pair("vbox86p", compare_type), new Pair("nox", compare_type2), new Pair("sdk_google", compare_type2), new Pair("sdk_gphone64_arm64", compare_type2), new Pair("emulator", compare_type2), new Pair("simulator", compare_type2));
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        j.g(str, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        j.g(str2, "manufacturer");
        j.g(str3, "hardware");
        j.g(str4, "fingerprint");
        j.g(str5, "product");
        j.g(str6, "board");
        j.g(str7, "brand");
        j.g(str8, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        if (c(str, i()) || c(str2, h()) || c(str3, g()) || c(str4, f()) || c(str5, j()) || c(str6, d()) || b(str7, str8)) {
            return true;
        }
        return false;
    }

    public final String e() {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.HARDWARE;
        String str4 = Build.FINGERPRINT;
        String str5 = Build.PRODUCT;
        String str6 = Build.BOARD;
        String str7 = Build.BRAND;
        String str8 = Build.DEVICE;
        return "MODEL=" + str + " MANUFACTURER=" + str2 + " HARDWARE=" + str3 + " FINGERPRINT=" + str4 + " PRODUCT=" + str5 + " BOARD=" + str6 + " BRAND=" + str7 + " DEVICE=" + str8 + " ";
    }

    public final boolean k() {
        String str = Build.MODEL;
        j.f(str, "MODEL");
        String str2 = Build.MANUFACTURER;
        j.f(str2, "MANUFACTURER");
        String str3 = Build.HARDWARE;
        j.f(str3, "HARDWARE");
        String str4 = Build.FINGERPRINT;
        j.f(str4, "FINGERPRINT");
        String str5 = Build.PRODUCT;
        j.f(str5, "PRODUCT");
        String str6 = Build.BOARD;
        j.f(str6, "BOARD");
        String str7 = Build.BRAND;
        j.f(str7, "BRAND");
        String str8 = Build.DEVICE;
        j.f(str8, "DEVICE");
        return a(str, str2, str3, str4, str5, str6, str7, str8);
    }
}
