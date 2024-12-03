package androidx.camera.core.impl.utils;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.o1;
import androidx.camera.core.v1;
import androidx.core.util.h;
import com.coffeemeetsbagel.models.Height;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ExifData {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f2586c = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: d  reason: collision with root package name */
    private static final l[] f2587d;

    /* renamed from: e  reason: collision with root package name */
    private static final l[] f2588e;

    /* renamed from: f  reason: collision with root package name */
    private static final l[] f2589f;

    /* renamed from: g  reason: collision with root package name */
    static final l[] f2590g = {new l("SubIFDPointer", 330, 4), new l("ExifIFDPointer", 34665, 4), new l("GPSInfoIFDPointer", 34853, 4), new l("InteroperabilityIFDPointer", 40965, 4)};

    /* renamed from: h  reason: collision with root package name */
    private static final l[] f2591h;

    /* renamed from: i  reason: collision with root package name */
    static final l[][] f2592i;

    /* renamed from: j  reason: collision with root package name */
    static final HashSet<String> f2593j = new HashSet<>(Arrays.asList(new String[]{"FNumber", "ExposureTime", "GPSTimeStamp"}));

    /* renamed from: a  reason: collision with root package name */
    private final List<Map<String, j>> f2594a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteOrder f2595b;

    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2599a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2600b;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode[] r0 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2600b = r0
                r1 = 1
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode r2 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2600b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode r3 = androidx.camera.core.impl.utils.ExifData.WhiteBalanceMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState[] r2 = androidx.camera.core.impl.CameraCaptureMetaData$FlashState.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f2599a = r2
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r3 = androidx.camera.core.impl.CameraCaptureMetaData$FlashState.READY     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f2599a     // Catch:{ NoSuchFieldError -> 0x0038 }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r2 = androidx.camera.core.impl.CameraCaptureMetaData$FlashState.NONE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f2599a     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r1 = androidx.camera.core.impl.CameraCaptureMetaData$FlashState.FIRED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.a.<clinit>():void");
        }
    }

    public static final class b {

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f2601c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f2602d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: e  reason: collision with root package name */
        private static final Pattern f2603e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

        /* renamed from: f  reason: collision with root package name */
        static final List<HashMap<String, l>> f2604f = Collections.list(new a());

        /* renamed from: a  reason: collision with root package name */
        final List<Map<String, j>> f2605a = Collections.list(new C0017b());

        /* renamed from: b  reason: collision with root package name */
        private final ByteOrder f2606b;

        class a implements Enumeration<HashMap<String, l>> {

            /* renamed from: a  reason: collision with root package name */
            int f2607a = 0;

            a() {
            }

            /* renamed from: a */
            public HashMap<String, l> nextElement() {
                HashMap<String, l> hashMap = new HashMap<>();
                for (l lVar : ExifData.f2592i[this.f2607a]) {
                    hashMap.put(lVar.f2681b, lVar);
                }
                this.f2607a++;
                return hashMap;
            }

            public boolean hasMoreElements() {
                return this.f2607a < ExifData.f2592i.length;
            }
        }

        /* renamed from: androidx.camera.core.impl.utils.ExifData$b$b  reason: collision with other inner class name */
        class C0017b implements Enumeration<Map<String, j>> {

            /* renamed from: a  reason: collision with root package name */
            int f2608a = 0;

            C0017b() {
            }

            /* renamed from: a */
            public Map<String, j> nextElement() {
                this.f2608a++;
                return new HashMap();
            }

            public boolean hasMoreElements() {
                return this.f2608a < ExifData.f2592i.length;
            }
        }

        class c implements Enumeration<Map<String, j>> {

            /* renamed from: a  reason: collision with root package name */
            final Enumeration<Map<String, j>> f2610a;

            c() {
                this.f2610a = Collections.enumeration(b.this.f2605a);
            }

            /* renamed from: a */
            public Map<String, j> nextElement() {
                return new HashMap(this.f2610a.nextElement());
            }

            public boolean hasMoreElements() {
                return this.f2610a.hasMoreElements();
            }
        }

        b(@NonNull ByteOrder byteOrder) {
            this.f2606b = byteOrder;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            java.lang.Double.parseDouble(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
            return new android.util.Pair<>(12, -1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
            return new android.util.Pair<>(2, -1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static android.util.Pair<java.lang.Integer, java.lang.Integer> b(java.lang.String r10) {
            /*
                java.lang.String r0 = ","
                boolean r1 = r10.contains(r0)
                r2 = 0
                r3 = 1
                r4 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r6 = -1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                if (r1 == 0) goto L_0x00a6
                java.lang.String[] r10 = r10.split(r0, r6)
                r0 = r10[r2]
                android.util.Pair r0 = b(r0)
                java.lang.Object r1 = r0.first
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                if (r1 != r4) goto L_0x0029
                return r0
            L_0x0029:
                int r1 = r10.length
                if (r3 >= r1) goto L_0x00a5
                r1 = r10[r3]
                android.util.Pair r1 = b(r1)
                java.lang.Object r2 = r1.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 != 0) goto L_0x004d
                java.lang.Object r2 = r1.second
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x004b
                goto L_0x004d
            L_0x004b:
                r2 = r6
                goto L_0x0055
            L_0x004d:
                java.lang.Object r2 = r0.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
            L_0x0055:
                java.lang.Object r4 = r0.second
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
                if (r4 == r6) goto L_0x0080
                java.lang.Object r4 = r1.first
                java.lang.Integer r4 = (java.lang.Integer) r4
                java.lang.Object r8 = r0.second
                boolean r4 = r4.equals(r8)
                if (r4 != 0) goto L_0x0077
                java.lang.Object r1 = r1.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                java.lang.Object r4 = r0.second
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0080
            L_0x0077:
                java.lang.Object r1 = r0.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                goto L_0x0081
            L_0x0080:
                r1 = r6
            L_0x0081:
                if (r2 != r6) goto L_0x008b
                if (r1 != r6) goto L_0x008b
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x008b:
                if (r2 != r6) goto L_0x0097
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.<init>(r1, r7)
                goto L_0x00a2
            L_0x0097:
                if (r1 != r6) goto L_0x00a2
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0.<init>(r1, r7)
            L_0x00a2:
                int r3 = r3 + 1
                goto L_0x0029
            L_0x00a5:
                return r0
            L_0x00a6:
                java.lang.String r0 = "/"
                boolean r1 = r10.contains(r0)
                r8 = 0
                if (r1 == 0) goto L_0x0105
                java.lang.String[] r10 = r10.split(r0, r6)
                int r0 = r10.length
                if (r0 != r4) goto L_0x00ff
                r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
                double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
                r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
                double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
                long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
                int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r4 = 10
                if (r10 < 0) goto L_0x00f5
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 >= 0) goto L_0x00d0
                goto L_0x00f5
            L_0x00d0:
                r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r0 = 5
                if (r10 > 0) goto L_0x00eb
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 <= 0) goto L_0x00dd
                goto L_0x00eb
            L_0x00dd:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00eb:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00f5:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00ff:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x0105:
                long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
                int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                r3 = 4
                if (r2 < 0) goto L_0x0124
                r8 = 65535(0xffff, double:3.23786E-319)
                int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r0 > 0) goto L_0x0124
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0124:
                if (r2 >= 0) goto L_0x0132
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 9
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0132:
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x013c:
                java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
                r0 = 12
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
                return r10
            L_0x014b:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.b.b(java.lang.String):android.util.Pair");
        }

        private void d(@NonNull String str, @NonNull String str2, @NonNull List<Map<String, j>> list) {
            for (Map<String, j> containsKey : list) {
                if (containsKey.containsKey(str)) {
                    return;
                }
            }
            e(str, str2, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:56:0x018a, code lost:
            if (r7 != r0) goto L_0x02de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0225, code lost:
            r5 = r6;
            r15 = 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void e(@androidx.annotation.NonNull java.lang.String r18, java.lang.String r19, @androidx.annotation.NonNull java.util.List<java.util.Map<java.lang.String, androidx.camera.core.impl.utils.j>> r20) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r2 = r19
                r3 = r20
                java.lang.String r4 = "DateTime"
                boolean r4 = r4.equals(r0)
                java.lang.String r5 = " : "
                java.lang.String r6 = "Invalid value for "
                java.lang.String r7 = "ExifData"
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeOriginal"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeDigitized"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x006d
            L_0x0026:
                if (r2 == 0) goto L_0x006d
                java.util.regex.Pattern r4 = f2602d
                java.util.regex.Matcher r4 = r4.matcher(r2)
                boolean r4 = r4.find()
                java.util.regex.Pattern r8 = f2603e
                java.util.regex.Matcher r8 = r8.matcher(r2)
                boolean r8 = r8.find()
                int r9 = r19.length()
                r10 = 19
                if (r9 != r10) goto L_0x0054
                if (r4 != 0) goto L_0x0049
                if (r8 != 0) goto L_0x0049
                goto L_0x0054
            L_0x0049:
                if (r8 == 0) goto L_0x006d
                java.lang.String r4 = "-"
                java.lang.String r8 = ":"
                java.lang.String r2 = r2.replaceAll(r4, r8)
                goto L_0x006d
            L_0x0054:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                r3.append(r0)
                r3.append(r5)
                r3.append(r2)
                java.lang.String r0 = r3.toString()
                androidx.camera.core.v1.l(r7, r0)
                return
            L_0x006d:
                java.lang.String r4 = "ISOSpeedRatings"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0077
                java.lang.String r0 = "PhotographicSensitivity"
            L_0x0077:
                r4 = r0
                r0 = 2
                r8 = 1
                if (r2 == 0) goto L_0x0124
                java.util.HashSet<java.lang.String> r9 = androidx.camera.core.impl.utils.ExifData.f2593j
                boolean r9 = r9.contains(r4)
                if (r9 == 0) goto L_0x0124
                java.lang.String r9 = "GPSTimeStamp"
                boolean r9 = r4.equals(r9)
                if (r9 == 0) goto L_0x00fc
                java.util.regex.Pattern r9 = f2601c
                java.util.regex.Matcher r9 = r9.matcher(r2)
                boolean r10 = r9.find()
                if (r10 != 0) goto L_0x00b1
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r6)
                r0.append(r4)
                r0.append(r5)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                androidx.camera.core.v1.l(r7, r0)
                return
            L_0x00b1:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = r9.group(r8)
                java.lang.Object r5 = androidx.core.util.h.g(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1,"
                r2.append(r5)
                java.lang.String r6 = r9.group(r0)
                java.lang.Object r6 = androidx.core.util.h.g(r6)
                java.lang.String r6 = (java.lang.String) r6
                int r6 = java.lang.Integer.parseInt(r6)
                r2.append(r6)
                r2.append(r5)
                r5 = 3
                java.lang.String r5 = r9.group(r5)
                java.lang.Object r5 = androidx.core.util.h.g(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1"
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                goto L_0x0124
            L_0x00fc:
                double r9 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x010a }
                androidx.camera.core.impl.utils.m r11 = new androidx.camera.core.impl.utils.m     // Catch:{ NumberFormatException -> 0x010a }
                r11.<init>(r9)     // Catch:{ NumberFormatException -> 0x010a }
                java.lang.String r2 = r11.toString()     // Catch:{ NumberFormatException -> 0x010a }
                goto L_0x0124
            L_0x010a:
                r0 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                androidx.camera.core.v1.m(r7, r2, r0)
                return
            L_0x0124:
                r5 = 0
                r6 = r5
            L_0x0126:
                androidx.camera.core.impl.utils.l[][] r7 = androidx.camera.core.impl.utils.ExifData.f2592i
                int r7 = r7.length
                if (r6 >= r7) goto L_0x02e7
                java.util.List<java.util.HashMap<java.lang.String, androidx.camera.core.impl.utils.l>> r7 = f2604f
                java.lang.Object r7 = r7.get(r6)
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.lang.Object r7 = r7.get(r4)
                androidx.camera.core.impl.utils.l r7 = (androidx.camera.core.impl.utils.l) r7
                if (r7 == 0) goto L_0x02de
                if (r2 != 0) goto L_0x0148
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                r7.remove(r4)
                goto L_0x02de
            L_0x0148:
                android.util.Pair r9 = b(r2)
                int r10 = r7.f2682c
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                r12 = -1
                if (r10 == r11) goto L_0x018d
                int r10 = r7.f2682c
                java.lang.Object r11 = r9.second
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 != r11) goto L_0x0166
                goto L_0x018d
            L_0x0166:
                int r10 = r7.f2683d
                if (r10 == r12) goto L_0x0183
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 == r11) goto L_0x0180
                int r10 = r7.f2683d
                java.lang.Object r9 = r9.second
                java.lang.Integer r9 = (java.lang.Integer) r9
                int r9 = r9.intValue()
                if (r10 != r9) goto L_0x0183
            L_0x0180:
                int r7 = r7.f2683d
                goto L_0x018f
            L_0x0183:
                int r7 = r7.f2682c
                if (r7 == r8) goto L_0x018f
                r9 = 7
                if (r7 == r9) goto L_0x018f
                if (r7 != r0) goto L_0x02de
                goto L_0x018f
            L_0x018d:
                int r7 = r7.f2682c
            L_0x018f:
                java.lang.String r9 = "/"
                java.lang.String r10 = ","
                switch(r7) {
                    case 1: goto L_0x02ce;
                    case 2: goto L_0x02be;
                    case 3: goto L_0x0296;
                    case 4: goto L_0x026e;
                    case 5: goto L_0x0229;
                    case 6: goto L_0x0196;
                    case 7: goto L_0x02be;
                    case 8: goto L_0x0196;
                    case 9: goto L_0x0200;
                    case 10: goto L_0x01bf;
                    case 11: goto L_0x0196;
                    case 12: goto L_0x0198;
                    default: goto L_0x0196;
                }
            L_0x0196:
                goto L_0x02de
            L_0x0198:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r9 = r7.length
                double[] r9 = new double[r9]
                r10 = r5
            L_0x01a0:
                int r11 = r7.length
                if (r10 >= r11) goto L_0x01ae
                r11 = r7[r10]
                double r11 = java.lang.Double.parseDouble(r11)
                r9[r10] = r11
                int r10 = r10 + 1
                goto L_0x01a0
            L_0x01ae:
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                java.nio.ByteOrder r10 = r1.f2606b
                androidx.camera.core.impl.utils.j r9 = androidx.camera.core.impl.utils.j.b(r9, r10)
                r7.put(r4, r9)
                goto L_0x02de
            L_0x01bf:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r10 = r7.length
                androidx.camera.core.impl.utils.m[] r10 = new androidx.camera.core.impl.utils.m[r10]
                r11 = r5
            L_0x01c7:
                int r13 = r7.length
                if (r11 >= r13) goto L_0x01ee
                r13 = r7[r11]
                java.lang.String[] r13 = r13.split(r9, r12)
                androidx.camera.core.impl.utils.m r14 = new androidx.camera.core.impl.utils.m
                r15 = r13[r5]
                double r0 = java.lang.Double.parseDouble(r15)
                long r0 = (long) r0
                r13 = r13[r8]
                r15 = r9
                double r8 = java.lang.Double.parseDouble(r13)
                long r8 = (long) r8
                r14.<init>(r0, r8)
                r10[r11] = r14
                int r11 = r11 + 1
                r9 = r15
                r0 = 2
                r8 = 1
                r1 = r17
                goto L_0x01c7
            L_0x01ee:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                r1 = r17
                java.nio.ByteOrder r7 = r1.f2606b
                androidx.camera.core.impl.utils.j r7 = androidx.camera.core.impl.utils.j.d(r10, r7)
                r0.put(r4, r7)
                goto L_0x0225
            L_0x0200:
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                int[] r7 = new int[r7]
                r8 = r5
            L_0x0208:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x0216
                r9 = r0[r8]
                int r9 = java.lang.Integer.parseInt(r9)
                r7[r8] = r9
                int r8 = r8 + 1
                goto L_0x0208
            L_0x0216:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r8 = r1.f2606b
                androidx.camera.core.impl.utils.j r7 = androidx.camera.core.impl.utils.j.c(r7, r8)
                r0.put(r4, r7)
            L_0x0225:
                r5 = r6
                r15 = 1
                goto L_0x02e0
            L_0x0229:
                r15 = r9
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                androidx.camera.core.impl.utils.m[] r7 = new androidx.camera.core.impl.utils.m[r7]
                r8 = r5
            L_0x0232:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x025b
                r9 = r0[r8]
                r10 = r15
                java.lang.String[] r9 = r9.split(r10, r12)
                androidx.camera.core.impl.utils.m r11 = new androidx.camera.core.impl.utils.m
                r13 = r9[r5]
                double r13 = java.lang.Double.parseDouble(r13)
                long r13 = (long) r13
                r15 = 1
                r9 = r9[r15]
                r16 = r6
                double r5 = java.lang.Double.parseDouble(r9)
                long r5 = (long) r5
                r11.<init>(r13, r5)
                r7[r8] = r11
                int r8 = r8 + 1
                r15 = r10
                r6 = r16
                r5 = 0
                goto L_0x0232
            L_0x025b:
                r5 = r6
                r15 = 1
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r6 = r1.f2606b
                androidx.camera.core.impl.utils.j r6 = androidx.camera.core.impl.utils.j.h(r7, r6)
                r0.put(r4, r6)
                goto L_0x02e0
            L_0x026e:
                r5 = r6
                r15 = r8
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                long[] r6 = new long[r6]
                r7 = 0
            L_0x0278:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x0286
                r8 = r0[r7]
                long r8 = java.lang.Long.parseLong(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x0278
            L_0x0286:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.f2606b
                androidx.camera.core.impl.utils.j r6 = androidx.camera.core.impl.utils.j.g(r6, r7)
                r0.put(r4, r6)
                goto L_0x02e0
            L_0x0296:
                r5 = r6
                r15 = r8
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                int[] r6 = new int[r6]
                r7 = 0
            L_0x02a0:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x02ae
                r8 = r0[r7]
                int r8 = java.lang.Integer.parseInt(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x02a0
            L_0x02ae:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.f2606b
                androidx.camera.core.impl.utils.j r6 = androidx.camera.core.impl.utils.j.i(r6, r7)
                r0.put(r4, r6)
                goto L_0x02e0
            L_0x02be:
                r5 = r6
                r15 = r8
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.j r6 = androidx.camera.core.impl.utils.j.e(r2)
                r0.put(r4, r6)
                goto L_0x02e0
            L_0x02ce:
                r5 = r6
                r15 = r8
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.j r6 = androidx.camera.core.impl.utils.j.a(r2)
                r0.put(r4, r6)
                goto L_0x02e0
            L_0x02de:
                r5 = r6
                r15 = r8
            L_0x02e0:
                int r6 = r5 + 1
                r8 = r15
                r0 = 2
                r5 = 0
                goto L_0x0126
            L_0x02e7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.b.e(java.lang.String, java.lang.String, java.util.List):void");
        }

        @NonNull
        public ExifData a() {
            ArrayList list = Collections.list(new c());
            if (!((Map) list.get(1)).isEmpty()) {
                d("ExposureProgram", String.valueOf(0), list);
                d("ExifVersion", "0230", list);
                d("ComponentsConfiguration", "1,2,3,0", list);
                d("MeteringMode", String.valueOf(0), list);
                d("LightSource", String.valueOf(0), list);
                d("FlashpixVersion", "0100", list);
                d("FocalPlaneResolutionUnit", String.valueOf(2), list);
                d("FileSource", String.valueOf(3), list);
                d("SceneType", String.valueOf(1), list);
                d("CustomRendered", String.valueOf(0), list);
                d("SceneCaptureType", String.valueOf(0), list);
                d("Contrast", String.valueOf(0), list);
                d("Saturation", String.valueOf(0), list);
                d("Sharpness", String.valueOf(0), list);
            }
            if (!((Map) list.get(2)).isEmpty()) {
                d("GPSVersionID", "2300", list);
                d("GPSSpeedRef", "K", list);
                d("GPSTrackRef", "T", list);
                d("GPSImgDirectionRef", "T", list);
                d("GPSDestBearingRef", "T", list);
                d("GPSDestDistanceRef", "K", list);
            }
            return new ExifData(this.f2606b, list);
        }

        @NonNull
        public b c(@NonNull String str, @NonNull String str2) {
            e(str, str2, this.f2605a);
            return this;
        }

        @NonNull
        public b f(long j10) {
            return c("ExposureTime", String.valueOf(((double) j10) / ((double) TimeUnit.SECONDS.toNanos(1))));
        }

        @NonNull
        public b g(@NonNull CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState) {
            int i10;
            if (cameraCaptureMetaData$FlashState == CameraCaptureMetaData$FlashState.UNKNOWN) {
                return this;
            }
            int i11 = a.f2599a[cameraCaptureMetaData$FlashState.ordinal()];
            if (i11 == 1) {
                i10 = 0;
            } else if (i11 == 2) {
                i10 = 32;
            } else if (i11 != 3) {
                v1.l("ExifData", "Unknown flash state: " + cameraCaptureMetaData$FlashState);
                return this;
            } else {
                i10 = 1;
            }
            if ((i10 & 1) == 1) {
                c("LightSource", String.valueOf(4));
            }
            return c("Flash", String.valueOf(i10));
        }

        @NonNull
        public b h(float f10) {
            return c("FocalLength", new m((long) (f10 * 1000.0f), 1000).toString());
        }

        @NonNull
        public b i(int i10) {
            return c("ImageLength", String.valueOf(i10));
        }

        @NonNull
        public b j(int i10) {
            return c("ImageWidth", String.valueOf(i10));
        }

        @NonNull
        public b k(int i10) {
            return c("SensitivityType", String.valueOf(3)).c("PhotographicSensitivity", String.valueOf(Math.min(65535, i10)));
        }

        @NonNull
        public b l(float f10) {
            return c("FNumber", String.valueOf(f10));
        }

        @NonNull
        public b m(int i10) {
            int i11;
            if (i10 == 0) {
                i11 = 1;
            } else if (i10 == 90) {
                i11 = 6;
            } else if (i10 == 180) {
                i11 = 3;
            } else if (i10 != 270) {
                v1.l("ExifData", "Unexpected orientation value: " + i10 + ". Must be one of 0, 90, 180, 270.");
                i11 = 0;
            } else {
                i11 = 8;
            }
            return c("Orientation", String.valueOf(i11));
        }

        @NonNull
        public b n(@NonNull WhiteBalanceMode whiteBalanceMode) {
            String str;
            int i10 = a.f2600b[whiteBalanceMode.ordinal()];
            if (i10 == 1) {
                str = String.valueOf(0);
            } else if (i10 != 2) {
                str = null;
            } else {
                str = String.valueOf(1);
            }
            return c("WhiteBalance", str);
        }
    }

    static {
        l[] lVarArr = {new l("ImageWidth", 256, 3, 4), new l("ImageLength", 257, 3, 4), new l("Make", 271, 2), new l("Model", Height.CENTIMETRES_MAX, 2), new l("Orientation", 274, 3), new l("XResolution", 282, 5), new l("YResolution", 283, 5), new l("ResolutionUnit", 296, 3), new l("Software", 305, 2), new l("DateTime", 306, 2), new l("YCbCrPositioning", 531, 3), new l("SubIFDPointer", 330, 4), new l("ExifIFDPointer", 34665, 4), new l("GPSInfoIFDPointer", 34853, 4)};
        f2587d = lVarArr;
        l[] lVarArr2 = {new l("ExposureTime", 33434, 5), new l("FNumber", 33437, 5), new l("ExposureProgram", 34850, 3), new l("PhotographicSensitivity", 34855, 3), new l("SensitivityType", 34864, 3), new l("ExifVersion", 36864, 2), new l("DateTimeOriginal", 36867, 2), new l("DateTimeDigitized", 36868, 2), new l("ComponentsConfiguration", 37121, 7), new l("ShutterSpeedValue", 37377, 10), new l("ApertureValue", 37378, 5), new l("BrightnessValue", 37379, 10), new l("ExposureBiasValue", 37380, 10), new l("MaxApertureValue", 37381, 5), new l("MeteringMode", 37383, 3), new l("LightSource", 37384, 3), new l("Flash", 37385, 3), new l("FocalLength", 37386, 5), new l("SubSecTime", 37520, 2), new l("SubSecTimeOriginal", 37521, 2), new l("SubSecTimeDigitized", 37522, 2), new l("FlashpixVersion", 40960, 7), new l("ColorSpace", 40961, 3), new l("PixelXDimension", 40962, 3, 4), new l("PixelYDimension", 40963, 3, 4), new l("InteroperabilityIFDPointer", 40965, 4), new l("FocalPlaneResolutionUnit", 41488, 3), new l("SensingMethod", 41495, 3), new l("FileSource", 41728, 7), new l("SceneType", 41729, 7), new l("CustomRendered", 41985, 3), new l("ExposureMode", 41986, 3), new l("WhiteBalance", 41987, 3), new l("SceneCaptureType", 41990, 3), new l("Contrast", 41992, 3), new l("Saturation", 41993, 3), new l("Sharpness", 41994, 3)};
        f2588e = lVarArr2;
        l[] lVarArr3 = {new l("GPSVersionID", 0, 1), new l("GPSLatitudeRef", 1, 2), new l("GPSLatitude", 2, 5, 10), new l("GPSLongitudeRef", 3, 2), new l("GPSLongitude", 4, 5, 10), new l("GPSAltitudeRef", 5, 1), new l("GPSAltitude", 6, 5), new l("GPSTimeStamp", 7, 5), new l("GPSSpeedRef", 12, 2), new l("GPSTrackRef", 14, 2), new l("GPSImgDirectionRef", 16, 2), new l("GPSDestBearingRef", 23, 2), new l("GPSDestDistanceRef", 25, 2)};
        f2589f = lVarArr3;
        l[] lVarArr4 = {new l("InteroperabilityIndex", 1, 2)};
        f2591h = lVarArr4;
        f2592i = new l[][]{lVarArr, lVarArr2, lVarArr3, lVarArr4};
    }

    ExifData(ByteOrder byteOrder, List<Map<String, j>> list) {
        boolean z10;
        if (list.size() == f2592i.length) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "Malformed attributes list. Number of IFDs mismatch.");
        this.f2595b = byteOrder;
        this.f2594a = list;
    }

    @NonNull
    public static b a() {
        return new b(ByteOrder.BIG_ENDIAN).c("Orientation", String.valueOf(1)).c("XResolution", "72/1").c("YResolution", "72/1").c("ResolutionUnit", String.valueOf(2)).c("YCbCrPositioning", String.valueOf(1)).c("Make", Build.MANUFACTURER).c("Model", Build.MODEL);
    }

    @NonNull
    public static ExifData b(@NonNull o1 o1Var, int i10) {
        b a10 = a();
        o1Var.z1().b(a10);
        a10.m(i10);
        return a10.j(o1Var.getWidth()).i(o1Var.getHeight()).a();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Map<String, j> c(int i10) {
        int length = f2592i.length;
        h.c(i10, 0, length, "Invalid IFD index: " + i10 + ". Index should be between [0, EXIF_TAGS.length] ");
        return this.f2594a.get(i10);
    }

    @NonNull
    public ByteOrder d() {
        return this.f2595b;
    }
}
