package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class AFa1xSDK {
    private static int AFInAppEventParameterName = 0;
    private static char[] AFInAppEventType = null;
    private static char AFKeystoreWrapper = '\u0000';
    private static int AFLogger = 1;
    private static int afDebugLog;
    private static short[] afErrorLog;
    private static byte[] afInfoLog;
    private static int valueOf;
    private static int values;

    static {
        AFKeystoreWrapper();
        ViewConfiguration.getTouchSlop();
        Color.argb(0, 0, 0, 0);
        View.MeasureSpec.makeMeasureSpec(0, 0);
        KeyEvent.getDeadChar(0, 0);
        ViewConfiguration.getMinimumFlingVelocity();
        ViewConfiguration.getLongPressTimeout();
        SystemClock.elapsedRealtime();
        View.getDefaultSize(0, 0);
        ViewConfiguration.getMaximumFlingVelocity();
        ExpandableListView.getPackedPositionForChild(0, 0);
        ViewConfiguration.getZoomControlsTimeout();
        SystemClock.elapsedRealtime();
        ExpandableListView.getPackedPositionType(0);
        ViewConfiguration.getScrollBarFadeDuration();
        Color.argb(0, 0, 0, 0);
        TextUtils.indexOf("", "");
        ViewConfiguration.getScrollBarSize();
        ViewConfiguration.getJumpTapTimeout();
        Color.rgb(0, 0, 0);
        TypedValue.complexToFloat(0);
        ViewConfiguration.getMaximumDrawingCacheSize();
        ViewConfiguration.getGlobalActionKeyTimeout();
        TextUtils.lastIndexOf("", '0');
        View.combineMeasuredStates(0, 0);
        MotionEvent.axisFromString("");
        TextUtils.getOffsetAfter("", 0);
        ViewConfiguration.getFadingEdgeLength();
        ViewConfiguration.getKeyRepeatTimeout();
        TextUtils.lastIndexOf("", '0');
        ViewConfiguration.getKeyRepeatTimeout();
        View.combineMeasuredStates(0, 0);
        View.resolveSizeAndState(0, 0, 0);
        Color.argb(0, 0, 0, 0);
        int i10 = AFLogger + 107;
        afDebugLog = i10 % 128;
        int i11 = i10 % 2;
    }

    private static boolean AFInAppEventParameterName(String str) {
        int i10 = afDebugLog + 55;
        AFLogger = i10 % 128;
        if ((i10 % 2 == 0 ? 'I' : 4) != 4) {
            try {
                Class.forName(str);
                return false;
            } catch (ClassNotFoundException e10) {
                Object[] objArr = new Object[1];
                AFKeystoreWrapper(Color.red(0) - 79, -1210396294 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0 ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0 ? 0 : -1)), (byte) ((ViewConfiguration.getLongPressTimeout() >> 16) - 23), 696979042 - (Process.myTid() >> 22), (short) (KeyEvent.normalizeMetaState(0) - 74), objArr);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e10);
                return false;
            }
        } else {
            Class.forName(str);
            return true;
        }
    }

    private static String AFInAppEventType(String str, Long l10) {
        long j10;
        if (str != null) {
            if ((l10 != null ? '#' : 23) != 23) {
                int i10 = afDebugLog + 85;
                AFLogger = i10 % 128;
                int i11 = i10 % 2;
                if (str.length() == 32) {
                    StringBuilder sb2 = new StringBuilder(str);
                    String obj = l10.toString();
                    int i12 = 0;
                    int i13 = 0;
                    while (true) {
                        if (!(i12 < obj.length())) {
                            break;
                        }
                        int i14 = AFLogger + 31;
                        afDebugLog = i14 % 128;
                        int i15 = i14 % 2;
                        i13 += Character.getNumericValue(obj.charAt(i12));
                        i12++;
                    }
                    String hexString = Integer.toHexString(i13);
                    sb2.replace(7, hexString.length() + 7, hexString);
                    long j11 = 0;
                    int i16 = 0;
                    while (i16 < sb2.length()) {
                        int i17 = AFLogger + 55;
                        afDebugLog = i17 % 128;
                        if (i17 % 2 == 0) {
                            j11 += (long) Character.getNumericValue(sb2.charAt(i16));
                            i16++;
                        } else {
                            j11 %= (long) Character.getNumericValue(sb2.charAt(i16));
                            i16 += 101;
                        }
                    }
                    while (j11 > 100) {
                        int i18 = afDebugLog + 125;
                        AFLogger = i18 % 128;
                        if (i18 % 2 == 0) {
                            j10 = 100 | j11;
                        } else {
                            j10 = j11 % 100;
                        }
                    }
                    sb2.insert(23, (int) j11);
                    if (j11 < 10) {
                        int i19 = AFLogger + 27;
                        afDebugLog = i19 % 128;
                        if (!(i19 % 2 == 0)) {
                            Object[] objArr = new Object[1];
                            values((byte) (7 << ExpandableListView.getPackedPositionGroup(0)), "㘉", 1 - TextUtils.indexOf("", "", 1, 0), objArr);
                            sb2.insert(1, ((String) objArr[0]).intern());
                        } else {
                            Object[] objArr2 = new Object[1];
                            values((byte) (ExpandableListView.getPackedPositionGroup(0) + 95), "㘉", TextUtils.indexOf("", "", 0, 0) + 1, objArr2);
                            sb2.insert(23, ((String) objArr2[0]).intern());
                        }
                    }
                    return sb2.toString();
                }
            }
        }
        Object[] objArr3 = new Object[1];
        AFKeystoreWrapper(-67 - TextUtils.lastIndexOf("", '0', 0, 0), -1210396326 - KeyEvent.getDeadChar(0, 0), (byte) ((SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)) + 95), (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)) + 696979034, (short) (123 - (ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1))), objArr3);
        String intern = ((String) objArr3[0]).intern();
        int i20 = afDebugLog + 29;
        AFLogger = i20 % 128;
        int i21 = i20 % 2;
        return intern;
    }

    private static String AFKeystoreWrapper(String str) {
        int i10;
        int i11;
        boolean z10 = true;
        int i12 = afDebugLog + 1;
        AFLogger = i12 % 128;
        if (i12 % 2 == 0) {
            z10 = false;
        }
        if (z10) {
            i10 = Integer.parseInt(str, 2);
            i11 = 16;
        } else {
            i10 = Integer.parseInt(str, 5);
            i11 = 46;
        }
        return Integer.toString(i10, i11);
    }

    static void AFKeystoreWrapper() {
        AFKeystoreWrapper = 6;
        AFInAppEventType = new char[]{13800, 13749, 13812, 13821, 13817, 13738, 13810, 13788, 13820, 13803, 13783, 13784, 13744, 13822, 13748, 13774, 13814, 13795, 13819, 13746, 13811, 13813, 13754, 13815, 13802, 13823, 13747, 13807, 13806, 13801, 13809, 13766, 13804, 13770, 13739, 13805};
        valueOf = 1210396370;
        values = 98;
        AFInAppEventParameterName = -696978937;
        afInfoLog = new byte[]{21, -78, -76, -78, -41, -78, 11, 25, -78, -27, 18, -78, -46, 102, -78, -78, -78, 29, 18, -19, -30, -83, 71, -18, -22, -91, 80, 19, -25, 24, -91, 24, -26, 88, 19, -55, 3, -29, 21, 22, -50, 36, -28, 21, -27, -26, 35, Framer.STDOUT_FRAME_PREFIX, -38, 29, 58, -39, Framer.ENTER_FRAME_PREFIX, 52, -42, 52, -42, 51, -41, -26, 31, 60, -26, -45, 35, 54, -48, -23, -22, 48, -23, Framer.ENTER_FRAME_PREFIX, -24, -26, 36, 105, 90, 57, 42, -7, -113, 54, Framer.STDERR_FRAME_PREFIX, -15, 100, 46, -114, 51, 69, 102, 10, -125, Framer.STDIN_FRAME_PREFIX, 24, 53, 30, 34, 7, -2, 98, 40, 10, 63, 8, 39, 10, Framer.STDERR_FRAME_PREFIX, -17, Framer.STDIN_REQUEST_FRAME_PREFIX, 48, 47, 54, 35, 43, 38, 3, 89, 110, -6, -10, -10, 101, 57, 88, -64, 103, -86, Framer.STDOUT_FRAME_PREFIX, 0, 1, -2, 109, -11, 110, -49, -87, -97, 12, -73, -49, -122, -4, -53, -52, -55, -72, -48, -71, -38, 7, 11, 90, 13, 87, -56, -111, 8, 21, 67, 101, -5, 89, 79, -121, -122, 82, -104, -60, 61, -54, 59, 56, 65, -40, Tnaf.POW_2_WIDTH, -25, -57, 65, 55, 55, -59, -62, 26, -34, -12, -57, 62, -51, 60, 59, 66, -37, 51, 125, -120, -52, 59, -46, 111, -120, -52, 51, -47, 112, -117, -59, 61, 66, -58, -125, -108, 55, -58, Byte.MAX_VALUE, -111, -53, 108, -124, -57, -55, 67, 56, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private static String valueOf(Context context) {
        boolean z10;
        boolean z11;
        Properties properties = System.getProperties();
        Object[] objArr = new Object[1];
        AFKeystoreWrapper(-83 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1)), KeyEvent.getDeadChar(0, 0) - 1210396221, (byte) (-34 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), (ViewConfiguration.getScrollBarSize() >> 8) + 696979043, (short) (-48 - Color.blue(0)), objArr);
        if (properties.containsKey(((String) objArr[0]).intern())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        int i10 = afDebugLog + 69;
        AFLogger = i10 % 128;
        int i11 = i10 % 2;
        try {
            String path = context.getCacheDir().getPath();
            Object[] objArr2 = new Object[1];
            AFKeystoreWrapper((ViewConfiguration.getFadingEdgeLength() >> 16) - 92, View.MeasureSpec.getMode(0) - 1210396208, (byte) (((Process.getThreadPriority(0) + 20) >> 6) - 103), TextUtils.lastIndexOf("", '0', 0) + 696978985, (short) (20 - TextUtils.lastIndexOf("", '0')), objArr2);
            String replace = path.replace(((String) objArr2[0]).intern(), "");
            Object[] objArr3 = new Object[1];
            values((byte) (112 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "\u000f\r\u0007\u0001\u0018\u0011\u0014\r\u000e\u0018", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 10, objArr3);
            Matcher matcher = Pattern.compile(((String) objArr3[0]).intern()).matcher(replace);
            if (matcher.find()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return null;
            }
            int i12 = AFLogger + 51;
            afDebugLog = i12 % 128;
            int i13 = i12 % 2;
            String group = matcher.group(1);
            int i14 = afDebugLog + 9;
            AFLogger = i14 % 128;
            int i15 = i14 % 2;
            return group;
        } catch (Exception e10) {
            Object[] objArr4 = new Object[1];
            values((byte) (86 - MotionEvent.axisFromString("")), "\u0006\u0013\u0016\u000e\u001f\u0013\u001c\"\u0016\u0017\u0001\u001b\"\u001c\u0000\u0016\u0000\n\u001c\u0013\u001e\u0018\u0018\n", 23 - TextUtils.indexOf("", '0'), objArr4);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr4[0]).intern(), e10);
            AFb1uSDK AFInAppEventType2 = AFb1uSDK.AFInAppEventType();
            Object[] objArr5 = new Object[1];
            AFKeystoreWrapper(-81 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), -1210396202 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (View.resolveSize(0, 0) + 61), View.resolveSizeAndState(0, 0, 0) + 696979004, (short) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) - 2), objArr5);
            String intern = ((String) objArr5[0]).intern();
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr6 = new Object[1];
            AFKeystoreWrapper(-57 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.getOffsetAfter("", 0) - 1210396187, (byte) (-67 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1))), 696979007 - TextUtils.getTrimmedLength(""), (short) (Color.argb(0, 0, 0, 0) + 124), objArr6);
            sb2.append(((String) objArr6[0]).intern());
            sb2.append(e10);
            AFInAppEventType2.values(intern, sb2.toString());
            return null;
        }
    }

    static String values(Context context, long j10) {
        String str;
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        Object[] objArr = new Object[1];
        values((byte) (97 - MotionEvent.axisFromString("")), "\u0014\u0000\f\u0001\u0016\u0015\u000e\u000f\u001d\u001a\r\u001c\u001e\f\u0014\u0003\f\u000f\r\u001b\r\u001c\u001e\f\u0014\u0003\u0010\u000b\u0014\u0000\u0015\u0000\u0018\u0001", 35 - (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)), objArr);
        if (AFInAppEventParameterName(((String) objArr[0]).intern())) {
            int i10 = afDebugLog + 69;
            AFLogger = i10 % 128;
            if ((i10 % 2 == 0 ? '!' : 27) != 27) {
                Object[] objArr2 = new Object[1];
                values((byte) (6 % (Process.getElapsedCpuTime() > 1 ? 1 : (Process.getElapsedCpuTime() == 1 ? 0 : -1))), "㘐", -ExpandableListView.getPackedPositionChild(1), objArr2);
                str = ((String) objArr2[0]).intern();
                sb3.append(str);
                sb2.append(AFInAppEventType(context, sb3));
                long j11 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                Object[] objArr3 = new Object[1];
                AFKeystoreWrapper(-80 - TextUtils.indexOf("", "", 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1210396371, (byte) (-16777142 - Color.rgb(0, 0, 0)), 696979058 - ExpandableListView.getPackedPositionGroup(0), (short) (KeyEvent.normalizeMetaState(0) - 104), objArr3);
                sb2.append(new SimpleDateFormat(((String) objArr3[0]).intern(), Locale.US).format(new Date(j11)));
                int i11 = afDebugLog + 65;
                AFLogger = i11 % 128;
                int i12 = i11 % 2;
                sb2.append(j10);
                values(sb4);
                return AFInAppEventType(values(values(values(sb2.toString()), sb3.toString(), 17), sb4.toString(), 27), Long.valueOf(j10));
            }
            Object[] objArr4 = new Object[1];
            values((byte) (102 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1))), "㘐", -ExpandableListView.getPackedPositionChild(0), objArr4);
            obj = objArr4[0];
        } else {
            Object[] objArr5 = new Object[1];
            values((byte) ((ViewConfiguration.getScrollBarSize() >> 8) + 95), "㘉", 1 - (Process.myTid() >> 22), objArr5);
            obj = objArr5[0];
        }
        str = ((String) obj).intern();
        sb3.append(str);
        sb2.append(AFInAppEventType(context, sb3));
        try {
            long j112 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            Object[] objArr32 = new Object[1];
            AFKeystoreWrapper(-80 - TextUtils.indexOf("", "", 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1210396371, (byte) (-16777142 - Color.rgb(0, 0, 0)), 696979058 - ExpandableListView.getPackedPositionGroup(0), (short) (KeyEvent.normalizeMetaState(0) - 104), objArr32);
            sb2.append(new SimpleDateFormat(((String) objArr32[0]).intern(), Locale.US).format(new Date(j112)));
            int i112 = afDebugLog + 65;
            AFLogger = i112 % 128;
            int i122 = i112 % 2;
            sb2.append(j10);
            values(sb4);
            return AFInAppEventType(values(values(values(sb2.toString()), sb3.toString(), 17), sb4.toString(), 27), Long.valueOf(j10));
        } catch (PackageManager.NameNotFoundException e10) {
            Object[] objArr6 = new Object[1];
            AFKeystoreWrapper(-70 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), -1210396353 - View.resolveSizeAndState(0, 0, 0), (byte) (107 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), View.resolveSize(0, 0) + 696979040, (short) ((SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)) - 129), objArr6);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr6[0]).intern(), e10);
            Object[] objArr7 = new Object[1];
            AFKeystoreWrapper(-67 - Process.getGidForName(""), -1210396326 - View.resolveSize(0, 0), (byte) (96 - TextUtils.indexOf("", "", 0)), 696979034 - TextUtils.lastIndexOf("", '0'), (short) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 122), objArr7);
            return ((String) objArr7[0]).intern();
        }
    }

    private static String AFInAppEventParameterName(Context context) {
        int i10 = afDebugLog + 123;
        AFLogger = i10 % 128;
        int i11 = i10 % 2;
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            int i12 = afDebugLog + 71;
            AFLogger = i12 % 128;
            int i13 = i12 % 2;
            return str;
        } catch (PackageManager.NameNotFoundException e10) {
            Object[] objArr = new Object[1];
            values((byte) ((ViewConfiguration.getTapTimeout() >> 16) + 48), "\u001e\u0015\u0000\"\u0015\u0000\u001f\r\u0003\u0012\u0016\u000b\u0014\u0000\u001a\u000e\u001a\u0018\"\u001c\u0003\u0014\"\u001c\t\u0014\u001a\u0003㘮", View.getDefaultSize(0, 0) + 29, objArr);
            AFLogger.afErrorLogForExcManagerOnly(((String) objArr[0]).intern(), e10);
            return null;
        }
    }

    private static void AFKeystoreWrapper(int i10, int i11, byte b10, int i12, short s10, Object[] objArr) {
        String obj;
        synchronized (AFf1bSDK.values) {
            StringBuilder sb2 = new StringBuilder();
            int i13 = values;
            int i14 = i10 + i13;
            boolean z10 = i14 == -1;
            if (z10) {
                byte[] bArr = afInfoLog;
                if (bArr != null) {
                    i14 = (byte) (bArr[valueOf + i11] + i13);
                } else {
                    i14 = (short) (afErrorLog[valueOf + i11] + i13);
                }
            }
            if (i14 > 0) {
                AFf1bSDK.AFInAppEventType = ((i11 + i14) - 2) + valueOf + (z10 ? 1 : 0);
                char c10 = (char) (i12 + AFInAppEventParameterName);
                AFf1bSDK.valueOf = c10;
                sb2.append(c10);
                AFf1bSDK.AFInAppEventParameterName = AFf1bSDK.valueOf;
                AFf1bSDK.AFKeystoreWrapper = 1;
                while (AFf1bSDK.AFKeystoreWrapper < i14) {
                    byte[] bArr2 = afInfoLog;
                    if (bArr2 != null) {
                        int i15 = AFf1bSDK.AFInAppEventType;
                        AFf1bSDK.AFInAppEventType = i15 - 1;
                        AFf1bSDK.valueOf = (char) (AFf1bSDK.AFInAppEventParameterName + (((byte) (bArr2[i15] + s10)) ^ b10));
                    } else {
                        short[] sArr = afErrorLog;
                        int i16 = AFf1bSDK.AFInAppEventType;
                        AFf1bSDK.AFInAppEventType = i16 - 1;
                        AFf1bSDK.valueOf = (char) (AFf1bSDK.AFInAppEventParameterName + (((short) (sArr[i16] + s10)) ^ b10));
                    }
                    sb2.append(AFf1bSDK.valueOf);
                    AFf1bSDK.AFInAppEventParameterName = AFf1bSDK.valueOf;
                    AFf1bSDK.AFKeystoreWrapper++;
                }
            }
            obj = sb2.toString();
        }
        objArr[0] = obj;
    }

    public static class AFa1wSDK extends HashMap<String, Object> {
        private static int AFInAppEventType = 0;
        private static int AFKeystoreWrapper = 0;
        private static short[] AFLogger = null;
        private static int afDebugLog = 0;
        private static char[] afErrorLog = null;
        private static byte[] afInfoLog = null;
        private static long afRDLog = 0;
        private static int afWarnLog = 1;
        private static int values;
        private final Context AFInAppEventParameterName;
        private final Map<String, Object> valueOf;

        /* renamed from: com.appsflyer.internal.AFa1xSDK$AFa1wSDK$AFa1wSDK  reason: collision with other inner class name */
        static class C0108AFa1wSDK {
            private static int AFKeystoreWrapper = 0;
            private static char[] valueOf = {24};
            private static int values = 1;

            C0108AFa1wSDK() {
            }

            @NonNull
            private static byte[] AFInAppEventParameterName(@NonNull String str) throws Exception {
                int i10 = values + 91;
                AFKeystoreWrapper = i10 % 128;
                char c10 = i10 % 2 != 0 ? 14 : '/';
                byte[] bytes = str.getBytes();
                if (c10 != '/') {
                    int i11 = 18 / 0;
                }
                return bytes;
            }

            @NonNull
            static String values(String str) throws Exception {
                String str2;
                int i10 = values + 29;
                AFKeystoreWrapper = i10 % 128;
                boolean z10 = i10 % 2 == 0;
                byte[] AFInAppEventParameterName = AFInAppEventParameterName(str);
                if (!z10) {
                    str2 = values(AFInAppEventParameterName(AFInAppEventParameterName));
                    int i11 = 97 / 0;
                } else {
                    str2 = values(AFInAppEventParameterName(AFInAppEventParameterName));
                }
                int i12 = AFKeystoreWrapper + 27;
                values = i12 % 128;
                int i13 = i12 % 2;
                return str2;
            }

            private static byte[] AFInAppEventParameterName(@NonNull byte[] bArr) throws Exception {
                int i10 = 0;
                while (true) {
                    if (i10 >= bArr.length) {
                        return bArr;
                    }
                    int i11 = AFKeystoreWrapper;
                    int i12 = i11 + 9;
                    values = i12 % 128;
                    int i13 = i12 % 2;
                    bArr[i10] = (byte) (bArr[i10] ^ ((i10 % 2) + 42));
                    i10++;
                    int i14 = i11 + 17;
                    values = i14 % 128;
                    int i15 = i14 % 2;
                }
            }

            @NonNull
            private static String values(@NonNull byte[] bArr) throws Exception {
                StringBuilder sb2 = new StringBuilder();
                int length = bArr.length;
                int i10 = values + 59;
                AFKeystoreWrapper = i10 % 128;
                int i11 = i10 % 2;
                int i12 = 0;
                while (true) {
                    if ((i12 < length ? 27 : SignatureVisitor.EXTENDS) != 27) {
                        String obj = sb2.toString();
                        int i13 = values + 15;
                        AFKeystoreWrapper = i13 % 128;
                        int i14 = i13 % 2;
                        return obj;
                    }
                    String hexString = Integer.toHexString(bArr[i12]);
                    if (hexString.length() == 1) {
                        StringBuilder sb3 = new StringBuilder();
                        Object[] objArr = new Object[1];
                        values(true, new int[]{0, 1, 0, 0}, "\u0000", objArr);
                        sb3.append(((String) objArr[0]).intern());
                        sb3.append(hexString);
                        hexString = sb3.toString();
                    }
                    sb2.append(hexString);
                    i12++;
                    int i15 = values + 73;
                    AFKeystoreWrapper = i15 % 128;
                    int i16 = i15 % 2;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: byte[]} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: java.lang.String} */
            /* JADX WARNING: Failed to insert additional move for type inference */
            /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=int, for r8v3, types: [char] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static void values(boolean r12, int[] r13, java.lang.String r14, java.lang.Object[] r15) {
                /*
                    if (r14 == 0) goto L_0x0008
                    java.lang.String r0 = "ISO-8859-1"
                    byte[] r14 = r14.getBytes(r0)
                L_0x0008:
                    byte[] r14 = (byte[]) r14
                    java.lang.Object r0 = com.appsflyer.internal.AFf1iSDK.valueOf
                    monitor-enter(r0)
                    r1 = 0
                    r2 = r13[r1]     // Catch:{ all -> 0x008b }
                    r3 = 1
                    r4 = r13[r3]     // Catch:{ all -> 0x008b }
                    r5 = 2
                    r6 = r13[r5]     // Catch:{ all -> 0x008b }
                    r7 = 3
                    r7 = r13[r7]     // Catch:{ all -> 0x008b }
                    char[] r8 = valueOf     // Catch:{ all -> 0x008b }
                    char[] r9 = new char[r4]     // Catch:{ all -> 0x008b }
                    java.lang.System.arraycopy(r8, r2, r9, r1, r4)     // Catch:{ all -> 0x008b }
                    if (r14 == 0) goto L_0x0047
                    char[] r2 = new char[r4]     // Catch:{ all -> 0x008b }
                    com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
                    r8 = r1
                L_0x0027:
                    int r10 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
                    if (r10 >= r4) goto L_0x0046
                    byte r11 = r14[r10]     // Catch:{ all -> 0x008b }
                    if (r11 != r3) goto L_0x0038
                    char r11 = r9[r10]     // Catch:{ all -> 0x008b }
                    int r11 = r11 << r3
                    int r11 = r11 + r3
                    int r11 = r11 - r8
                    char r8 = (char) r11     // Catch:{ all -> 0x008b }
                    r2[r10] = r8     // Catch:{ all -> 0x008b }
                    goto L_0x003f
                L_0x0038:
                    char r11 = r9[r10]     // Catch:{ all -> 0x008b }
                    int r11 = r11 << r3
                    int r11 = r11 - r8
                    char r8 = (char) r11     // Catch:{ all -> 0x008b }
                    r2[r10] = r8     // Catch:{ all -> 0x008b }
                L_0x003f:
                    char r8 = r2[r10]     // Catch:{ all -> 0x008b }
                    int r10 = r10 + 1
                    com.appsflyer.internal.AFf1iSDK.values = r10     // Catch:{ all -> 0x008b }
                    goto L_0x0027
                L_0x0046:
                    r9 = r2
                L_0x0047:
                    if (r7 <= 0) goto L_0x0056
                    char[] r14 = new char[r4]     // Catch:{ all -> 0x008b }
                    java.lang.System.arraycopy(r9, r1, r14, r1, r4)     // Catch:{ all -> 0x008b }
                    int r2 = r4 - r7
                    java.lang.System.arraycopy(r14, r1, r9, r2, r7)     // Catch:{ all -> 0x008b }
                    java.lang.System.arraycopy(r14, r7, r9, r1, r2)     // Catch:{ all -> 0x008b }
                L_0x0056:
                    if (r12 == 0) goto L_0x006d
                    char[] r12 = new char[r4]     // Catch:{ all -> 0x008b }
                    com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
                L_0x005c:
                    int r14 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
                    if (r14 >= r4) goto L_0x006c
                    int r2 = r4 - r14
                    int r2 = r2 - r3
                    char r2 = r9[r2]     // Catch:{ all -> 0x008b }
                    r12[r14] = r2     // Catch:{ all -> 0x008b }
                    int r14 = r14 + 1
                    com.appsflyer.internal.AFf1iSDK.values = r14     // Catch:{ all -> 0x008b }
                    goto L_0x005c
                L_0x006c:
                    r9 = r12
                L_0x006d:
                    if (r6 <= 0) goto L_0x0082
                    com.appsflyer.internal.AFf1iSDK.values = r1     // Catch:{ all -> 0x008b }
                L_0x0071:
                    int r12 = com.appsflyer.internal.AFf1iSDK.values     // Catch:{ all -> 0x008b }
                    if (r12 >= r4) goto L_0x0082
                    char r14 = r9[r12]     // Catch:{ all -> 0x008b }
                    r2 = r13[r5]     // Catch:{ all -> 0x008b }
                    int r14 = r14 - r2
                    char r14 = (char) r14     // Catch:{ all -> 0x008b }
                    r9[r12] = r14     // Catch:{ all -> 0x008b }
                    int r12 = r12 + 1
                    com.appsflyer.internal.AFf1iSDK.values = r12     // Catch:{ all -> 0x008b }
                    goto L_0x0071
                L_0x0082:
                    java.lang.String r12 = new java.lang.String     // Catch:{ all -> 0x008b }
                    r12.<init>(r9)     // Catch:{ all -> 0x008b }
                    monitor-exit(r0)     // Catch:{ all -> 0x008b }
                    r15[r1] = r12
                    return
                L_0x008b:
                    r12 = move-exception
                    monitor-exit(r0)
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1xSDK.AFa1wSDK.C0108AFa1wSDK.values(boolean, int[], java.lang.String, java.lang.Object[]):void");
            }
        }

        static {
            AFKeystoreWrapper();
            ViewConfiguration.getKeyRepeatDelay();
            SystemClock.currentThreadTimeMillis();
            AndroidCharacter.getMirror('0');
            ViewConfiguration.getTapTimeout();
            ViewConfiguration.getGlobalActionKeyTimeout();
            KeyEvent.keyCodeFromString("");
            ExpandableListView.getPackedPositionType(0);
            ViewConfiguration.getKeyRepeatTimeout();
            TextUtils.indexOf("", '0', 0);
            SystemClock.currentThreadTimeMillis();
            ViewConfiguration.getMaximumFlingVelocity();
            TypedValue.complexToFloat(0);
            TypedValue.complexToFraction(0, 0.0f, 0.0f);
            TextUtils.indexOf("", "", 0, 0);
            SystemClock.currentThreadTimeMillis();
            ViewConfiguration.getFadingEdgeLength();
            AudioTrack.getMinVolume();
            ViewConfiguration.getDoubleTapTimeout();
            View.resolveSizeAndState(0, 0, 0);
            ViewConfiguration.getMinimumFlingVelocity();
            Process.getGidForName("");
            ViewConfiguration.getWindowTouchSlop();
            View.MeasureSpec.getSize(0);
            ViewConfiguration.getMinimumFlingVelocity();
            ExpandableListView.getPackedPositionType(0);
            Process.getGidForName("");
            View.combineMeasuredStates(0, 0);
            Process.getThreadPriority(0);
            Process.myTid();
            TextUtils.getOffsetAfter("", 0);
            TextUtils.indexOf("", "", 0, 0);
            ExpandableListView.getPackedPositionType(0);
            ViewConfiguration.getZoomControlsTimeout();
            int i10 = afWarnLog + 47;
            afDebugLog = i10 % 128;
            int i11 = i10 % 2;
        }

        public AFa1wSDK(Map<String, Object> map, Context context) {
            this.valueOf = map;
            this.AFInAppEventParameterName = context;
            put(valueOf(), AFInAppEventType());
        }

        private static StringBuilder AFInAppEventParameterName(@NonNull String... strArr) throws Exception {
            char c10;
            ArrayList arrayList = new ArrayList();
            int length = strArr.length;
            int i10 = 0;
            while (i10 < 3) {
                arrayList.add(Integer.valueOf(strArr[i10].length()));
                i10++;
                int i11 = afWarnLog + 59;
                afDebugLog = i11 % 128;
                int i12 = i11 % 2;
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb2 = new StringBuilder();
            int i13 = afWarnLog + 79;
            afDebugLog = i13 % 128;
            int i14 = i13 % 2;
            for (int i15 = 0; i15 < intValue; i15++) {
                Integer num = null;
                int i16 = afDebugLog + 125;
                afWarnLog = i16 % 128;
                int i17 = i16 % 2;
                int i18 = 0;
                while (true) {
                    if (i18 < 3) {
                        c10 = 22;
                    } else {
                        c10 = 6;
                    }
                    if (c10 == 6) {
                        break;
                    }
                    char charAt = strArr[i18].charAt(i15);
                    if (num != null) {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                    i18++;
                }
                sb2.append(Integer.toHexString(num.intValue()));
            }
            return sb2;
        }

        private String AFInAppEventType() {
            String str;
            int i10;
            char c10;
            char c11;
            int intExtra;
            try {
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                values((Process.myPid() >> 22) - 114, AndroidCharacter.getMirror('0') + 32735, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), ExpandableListView.getPackedPositionGroup(0) - 1226652127, (short) (Color.red(0) + 108), objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                valueOf(Color.blue(0) + 7, 15 - View.MeasureSpec.getSize(0), (char) (16279 - MotionEvent.axisFromString("")), objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                Object[] objArr3 = new Object[1];
                valueOf(21 - MotionEvent.axisFromString(""), View.MeasureSpec.makeMeasureSpec(0, 0) + 6, (char) (((Process.getThreadPriority(0) + 20) >> 6) + 39425), objArr3);
                String intern = ((String) objArr3[0]).intern();
                Object[] objArr4 = new Object[1];
                valueOf(28 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 5 - KeyEvent.getDeadChar(0, 0), (char) (Process.getGidForName("") + 1), objArr4);
                String replaceAll = intern.replaceAll(((String) objArr4[0]).intern(), "");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(obj2);
                sb2.append(replaceAll);
                String values2 = AFa1aSDK.values(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(values2.substring(0, 16));
                str = sb3.toString();
            } catch (Exception e10) {
                Object[] objArr5 = new Object[1];
                valueOf(ImageFormat.getBitsPerPixel(0) + 34, View.MeasureSpec.makeMeasureSpec(0, 0) + 38, (char) (Color.rgb(0, 0, 0) + 16803786), objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e10);
                StringBuilder sb4 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                values(-114 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), ExpandableListView.getPackedPositionChild(0) + 90538110, (byte) Color.alpha(0), -1226652122 - TextUtils.indexOf("", ""), (short) (124 - View.MeasureSpec.getSize(0)), objArr6);
                sb4.append(((String) objArr6[0]).intern());
                sb4.append(e10);
                AFLogger.afRDLog(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                Object[] objArr7 = new Object[1];
                values((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 114, TextUtils.getCapsMode("", 0, 0) + 90538153, (byte) KeyEvent.getDeadChar(0, 0), TextUtils.indexOf("", '0') - 1226652125, (short) (((Process.getThreadPriority(0) + 20) >> 6) - 24), objArr7);
                sb5.append(((String) objArr7[0]).intern());
                str = sb5.toString();
            }
            String str2 = str;
            try {
                Context context = this.AFInAppEventParameterName;
                Object[] objArr8 = new Object[1];
                values((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 115, 90538171 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (byte) (-1 - TextUtils.indexOf("", '0')), -1226652127 - KeyEvent.getDeadChar(0, 0), (short) (-121 - TextUtils.indexOf("", "", 0)), objArr8);
                Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter(((String) objArr8[0]).intern()));
                int i11 = -2700;
                if (registerReceiver != null) {
                    int i12 = afWarnLog + 1;
                    afDebugLog = i12 % 128;
                    if (i12 % 2 != 0) {
                        c11 = '5';
                    } else {
                        c11 = ':';
                    }
                    if (c11 != ':') {
                        Object[] objArr9 = new Object[1];
                        valueOf(20 >> TextUtils.indexOf("", ""), Color.rgb(1, 0, 1) + 16777227, (char) (ViewConfiguration.getLongPressTimeout() + 55), objArr9);
                        intExtra = registerReceiver.getIntExtra(((String) objArr9[0]).intern(), 17756);
                    } else {
                        Object[] objArr10 = new Object[1];
                        valueOf(TextUtils.indexOf("", "") + 71, Color.rgb(0, 0, 0) + 16777227, (char) (ViewConfiguration.getLongPressTimeout() >> 16), objArr10);
                        intExtra = registerReceiver.getIntExtra(((String) objArr10[0]).intern(), -2700);
                    }
                    i11 = intExtra;
                }
                String str3 = this.AFInAppEventParameterName.getApplicationInfo().nativeLibraryDir;
                if (str3 != null) {
                    Object[] objArr11 = new Object[1];
                    values((ViewConfiguration.getScrollDefaultDelay() >> 16) - 114, 90538208 - Drawable.resolveOpacity(0, 0), (byte) Color.alpha(0), -1226652104 - TextUtils.indexOf("", "", 0, 0), (short) (57 - View.combineMeasuredStates(0, 0)), objArr11);
                    if (str3.contains(((String) objArr11[0]).intern())) {
                        c10 = 7;
                    } else {
                        c10 = 4;
                    }
                    if (c10 != 4) {
                        i10 = 1;
                        Context context2 = this.AFInAppEventParameterName;
                        Object[] objArr12 = new Object[1];
                        valueOf(130 - AndroidCharacter.getMirror('0'), 6 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) KeyEvent.keyCodeFromString(""), objArr12);
                        int size = ((SensorManager) context2.getSystemService(((String) objArr12[0]).intern())).getSensorList(-1).size();
                        StringBuilder sb6 = new StringBuilder();
                        Object[] objArr13 = new Object[1];
                        valueOf(87 - Process.getGidForName(""), (Process.myPid() >> 22) + 1, (char) View.resolveSizeAndState(0, 0, 0), objArr13);
                        sb6.append(((String) objArr13[0]).intern());
                        sb6.append(i11);
                        Object[] objArr14 = new Object[1];
                        valueOf(89 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2, (char) View.MeasureSpec.makeMeasureSpec(0, 0), objArr14);
                        sb6.append(((String) objArr14[0]).intern());
                        sb6.append(i10);
                        Object[] objArr15 = new Object[1];
                        values(TextUtils.indexOf("", "", 0, 0) - 114, 90538211 - Color.green(0), (byte) View.resolveSizeAndState(0, 0, 0), -1226652186 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (short) (-59 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr15);
                        sb6.append(((String) objArr15[0]).intern());
                        sb6.append(size);
                        Object[] objArr16 = new Object[1];
                        valueOf((ViewConfiguration.getWindowTouchSlop() >> 8) + 91, 2 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 7727), objArr16);
                        sb6.append(((String) objArr16[0]).intern());
                        sb6.append(this.valueOf.size());
                        String obj3 = sb6.toString();
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str2);
                        sb7.append(C0108AFa1wSDK.values(obj3));
                        return sb7.toString();
                    }
                }
                int i13 = afWarnLog + 77;
                afDebugLog = i13 % 128;
                int i14 = i13 % 2;
                i10 = 0;
                Context context22 = this.AFInAppEventParameterName;
                Object[] objArr122 = new Object[1];
                valueOf(130 - AndroidCharacter.getMirror('0'), 6 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) KeyEvent.keyCodeFromString(""), objArr122);
                int size2 = ((SensorManager) context22.getSystemService(((String) objArr122[0]).intern())).getSensorList(-1).size();
                StringBuilder sb62 = new StringBuilder();
                Object[] objArr132 = new Object[1];
                valueOf(87 - Process.getGidForName(""), (Process.myPid() >> 22) + 1, (char) View.resolveSizeAndState(0, 0, 0), objArr132);
                sb62.append(((String) objArr132[0]).intern());
                sb62.append(i11);
                Object[] objArr142 = new Object[1];
                valueOf(89 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 2, (char) View.MeasureSpec.makeMeasureSpec(0, 0), objArr142);
                sb62.append(((String) objArr142[0]).intern());
                sb62.append(i10);
                Object[] objArr152 = new Object[1];
                values(TextUtils.indexOf("", "", 0, 0) - 114, 90538211 - Color.green(0), (byte) View.resolveSizeAndState(0, 0, 0), -1226652186 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (short) (-59 - View.MeasureSpec.makeMeasureSpec(0, 0)), objArr152);
                sb62.append(((String) objArr152[0]).intern());
                sb62.append(size2);
                Object[] objArr162 = new Object[1];
                valueOf((ViewConfiguration.getWindowTouchSlop() >> 8) + 91, 2 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 7727), objArr162);
                sb62.append(((String) objArr162[0]).intern());
                sb62.append(this.valueOf.size());
                String obj32 = sb62.toString();
                StringBuilder sb72 = new StringBuilder();
                sb72.append(str2);
                sb72.append(C0108AFa1wSDK.values(obj32));
                return sb72.toString();
            } catch (Exception e11) {
                Object[] objArr17 = new Object[1];
                values(-114 - Color.blue(0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 90538212, (byte) Color.blue(0), -1226652121 - (ViewConfiguration.getTapTimeout() >> 16), (short) (Color.alpha(0) + 1), objArr17);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr17[0]).intern(), e11);
                StringBuilder sb8 = new StringBuilder();
                Object[] objArr18 = new Object[1];
                values((ViewConfiguration.getLongPressTimeout() >> 16) - 114, 90538109 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (byte) (AndroidCharacter.getMirror('0') - '0'), -1226652122 - (ViewConfiguration.getScrollBarSize() >> 8), (short) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 124), objArr18);
                sb8.append(((String) objArr18[0]).intern());
                sb8.append(e11);
                AFLogger.afRDLog(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str2);
                Object[] objArr19 = new Object[1];
                values((ViewConfiguration.getFadingEdgeLength() >> 16) - 114, TextUtils.getOffsetAfter("", 0) + 90538229, (byte) Drawable.resolveOpacity(0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) - 1226652123, (short) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) - 91), objArr19);
                sb9.append(((String) objArr19[0]).intern());
                return sb9.toString();
            }
        }

        static void AFKeystoreWrapper() {
            AFInAppEventType = -90537999;
            AFKeystoreWrapper = 113;
            values = 1226652224;
            afInfoLog = new byte[]{-101, -105, -96, -127, -107, -94, -116, -104, -119, -87, -115, -103, -108, 87, 110, 80, 113, -105, -9, 14, -16, 17, -28, 17, 2, -110, -120, -127, -73, -97, -74, -99, 2, 82, -65, -91, -10, 101, -84, -91, -10, 100, -92, -80, -96, -66, -102, -72, -94, -76, -87, -14, 103, -86, -92, -82, -77, -90, -15, 82, -65, -59, -60, -121, -115, -70, -87, -14, -71, -90, -116, -65, -58, -75, -60, -53, -62, -85, -45, 5, Framer.EXIT_FRAME_PREFIX, -76, -53, -78, 23, 103, -44, -70, 11, 122, -63, -70, 11, 121, -71, -59, -75, -45, -81, -51, -73, -55, -66, 7, 124, -65, -71, -61, -56, -69, -69, 106, 80, -125, -118, 121, -120, -113, -122, 111, -105, -55, 60, Framer.EXIT_FRAME_PREFIX, -113, 118, -37, 63, 116, -115, -113, 111, -38, 62, -123, 126, -49, 61, 125, -119, 121, -105, 115, -111, 123, -115, -126, -53, 64, -125, 125, -121, -116, Byte.MAX_VALUE, -95, 31, 25, 22, -28, 77, Tnaf.POW_2_WIDTH, -19, 76, 20, 23, 29, -29, 28, 20, 27, 25, 23, -76, Framer.EXIT_FRAME_PREFIX, 119, 114, -122, 114, 126, 93, Byte.MAX_VALUE, Byte.MIN_VALUE, -122, 106, 121, -116, Framer.EXIT_FRAME_PREFIX, -115, 57, Framer.EXIT_FRAME_PREFIX, Byte.MAX_VALUE, 110, -118, 123, -84, 51, Byte.MAX_VALUE, -126, 106, Byte.MAX_VALUE, 126, -76, 67, 116, 115, 118, -121, 111, -122, -110, -59, -121, -111, -120, -97, 2, -4, -1, 12, 68, -70, -17, 8, 10, 10, 35, -37, -31, 14, -3, -97, 103, 72, 103, 96, -116, 91, 29, -102, 28, -102, 27, -100, 26, -100, 37};
            afErrorLog = new char[]{10221, 57176, 54934, 52622, 50515, 64536, 62429, 16382, 51018, 52892, 54746, 56576, 58483, 60315, 62192, 64046, 33128, 35006, 36821, 38717, 40595, 42439, 39479, 25236, 27462, 28672, 30915, 16790, SignatureVisitor.SUPER, 63689, 61717, 59935, 58054, 26541, 40724, 38600, 36269, 34068, 48187, 46025, 43707, 41575, 55612, 53412, 55205, 53103, 50908, 64924, 62810, 60446, 58241, 6795, 4686, 2360, 248, 1962, 16230, 13878, 11744, 9562, 23572, 21406, 19086, 16965, 30985, 28810, 30631, 28541, 26167, 40435, 38056, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 63710, 61723, 59969, 57993, 56277, 54275, 52585, 50605, 48865, 46891, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 63710, 61720, 59970, 57987, 56277, 'b', '&', 63683, 7689, 59108};
            afRDLog = 2137247597649524923L;
        }

        @NonNull
        private String valueOf() {
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                Map<String, Object> map = this.valueOf;
                Object[] objArr = new Object[1];
                values(View.MeasureSpec.getMode(0) - 114, (SystemClock.uptimeMillis() > 0 ? 1 : (SystemClock.uptimeMillis() == 0 ? 0 : -1)) + 90537998, (byte) (ExpandableListView.getPackedPositionChild(0) + 1), -1226652128 - TextUtils.indexOf("", '0'), (short) (108 - View.resolveSize(0, 0)), objArr);
                String obj = map.get(((String) objArr[0]).intern()).toString();
                Map<String, Object> map2 = this.valueOf;
                Object[] objArr2 = new Object[1];
                values(TextUtils.getOffsetBefore("", 0) - 114, 90538011 - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) (ViewConfiguration.getScrollDefaultDelay() >> 16), View.resolveSizeAndState(0, 0, 0) - 1226652126, (short) (-96 - (Process.getElapsedCpuTime() > 0 ? 1 : (Process.getElapsedCpuTime() == 0 ? 0 : -1))), objArr2);
                String obj2 = map2.get(((String) objArr2[0]).intern()).toString();
                if (obj2 == null) {
                    Object[] objArr3 = new Object[1];
                    values(-115 - TextUtils.indexOf("", '0', 0, 0), 90538016 - View.getDefaultSize(0, 0), (byte) Color.alpha(0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 1226652146, (short) (-(ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1))), objArr3);
                    obj2 = ((String) objArr3[0]).intern();
                    int i10 = afDebugLog + 89;
                    afWarnLog = i10 % 128;
                    int i11 = i10 % 2;
                }
                StringBuilder sb2 = new StringBuilder(obj);
                sb2.reverse();
                StringBuilder AFInAppEventParameterName2 = AFInAppEventParameterName(num, obj2, sb2.toString());
                int length = AFInAppEventParameterName2.length();
                if (length > 4) {
                    int i12 = afWarnLog + 23;
                    afDebugLog = i12 % 128;
                    if (i12 % 2 != 0) {
                        AFInAppEventParameterName2.delete(2, length);
                    } else {
                        AFInAppEventParameterName2.delete(4, length);
                    }
                } else {
                    while (length < 4) {
                        length++;
                        AFInAppEventParameterName2.append('1');
                    }
                }
                Object[] objArr4 = new Object[1];
                values((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 114, 90538024 - (Process.myTid() >> 22), (byte) (AndroidCharacter.getMirror('0') - '0'), (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 1226652117, (short) (View.MeasureSpec.getMode(0) + 121), objArr4);
                AFInAppEventParameterName2.insert(0, ((String) objArr4[0]).intern());
                return AFInAppEventParameterName2.toString();
            } catch (Exception e10) {
                Object[] objArr5 = new Object[1];
                values(-114 - Color.argb(0, 0, 0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 90538027, (byte) (-1 - Process.getGidForName("")), AndroidCharacter.getMirror('0') - 14928, (short) ((Process.myPid() >> 22) + 85), objArr5);
                AFLogger.afErrorLogForExcManagerOnly(((String) objArr5[0]).intern(), e10);
                StringBuilder sb3 = new StringBuilder();
                Object[] objArr6 = new Object[1];
                values((ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) - 115, (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)) + 90538068, (byte) (ViewConfiguration.getTapTimeout() >> 16), (KeyEvent.getMaxKeyCode() >> 16) - 1226652122, (short) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 63), objArr6);
                sb3.append(((String) objArr6[0]).intern());
                sb3.append(e10);
                AFLogger.afRDLog(sb3.toString());
                Object[] objArr7 = new Object[1];
                valueOf((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 7 - TextUtils.getCapsMode("", 0, 0), (char) (10118 - View.resolveSizeAndState(0, 0, 0)), objArr7);
                return ((String) objArr7[0]).intern();
            }
        }

        private static void values(int i10, int i11, byte b10, int i12, short s10, Object[] objArr) {
            boolean z10;
            String obj;
            int i13;
            synchronized (AFf1bSDK.values) {
                StringBuilder sb2 = new StringBuilder();
                int i14 = AFKeystoreWrapper;
                int i15 = i10 + i14;
                if (i15 == -1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    byte[] bArr = afInfoLog;
                    if (bArr != null) {
                        i15 = (byte) (bArr[AFInAppEventType + i11] + i14);
                    } else {
                        i15 = (short) (AFLogger[AFInAppEventType + i11] + i14);
                    }
                }
                if (i15 > 0) {
                    int i16 = ((i11 + i15) - 2) + AFInAppEventType;
                    if (z10) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    AFf1bSDK.AFInAppEventType = i16 + i13;
                    char c10 = (char) (i12 + values);
                    AFf1bSDK.valueOf = c10;
                    sb2.append(c10);
                    AFf1bSDK.AFInAppEventParameterName = AFf1bSDK.valueOf;
                    AFf1bSDK.AFKeystoreWrapper = 1;
                    while (AFf1bSDK.AFKeystoreWrapper < i15) {
                        byte[] bArr2 = afInfoLog;
                        if (bArr2 != null) {
                            int i17 = AFf1bSDK.AFInAppEventType;
                            AFf1bSDK.AFInAppEventType = i17 - 1;
                            AFf1bSDK.valueOf = (char) (AFf1bSDK.AFInAppEventParameterName + (((byte) (bArr2[i17] + s10)) ^ b10));
                        } else {
                            short[] sArr = AFLogger;
                            int i18 = AFf1bSDK.AFInAppEventType;
                            AFf1bSDK.AFInAppEventType = i18 - 1;
                            AFf1bSDK.valueOf = (char) (AFf1bSDK.AFInAppEventParameterName + (((short) (sArr[i18] + s10)) ^ b10));
                        }
                        sb2.append(AFf1bSDK.valueOf);
                        AFf1bSDK.AFInAppEventParameterName = AFf1bSDK.valueOf;
                        AFf1bSDK.AFKeystoreWrapper++;
                    }
                }
                obj = sb2.toString();
            }
            objArr[0] = obj;
        }

        private static void valueOf(int i10, int i11, char c10, Object[] objArr) {
            String str;
            synchronized (AFg1wSDK.AFInAppEventParameterName) {
                char[] cArr = new char[i11];
                AFg1wSDK.AFKeystoreWrapper = 0;
                while (true) {
                    int i12 = AFg1wSDK.AFKeystoreWrapper;
                    if (i12 < i11) {
                        cArr[i12] = (char) ((int) ((((long) afErrorLog[i10 + i12]) ^ (((long) i12) * afRDLog)) ^ ((long) c10)));
                        AFg1wSDK.AFKeystoreWrapper = i12 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            }
            objArr[0] = str;
        }
    }

    private static String AFInAppEventType(String str) {
        String str2 = str;
        Object[] objArr = new Object[1];
        AFKeystoreWrapper(-97 - View.getDefaultSize(0, 0), -1210396222 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (byte) (10 - KeyEvent.normalizeMetaState(0)), (Process.myTid() >> 22) + 696978983, (short) (80 - MotionEvent.axisFromString("")), objArr);
        if (!str2.contains(((String) objArr[0]).intern())) {
            return str2;
        }
        Object[] objArr2 = new Object[1];
        AFKeystoreWrapper(65488 - AndroidCharacter.getMirror('0'), ExpandableListView.getPackedPositionChild(0) - 1210396221, (byte) (Color.blue(0) - 94), 696979028 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)), (short) (View.resolveSizeAndState(0, 0, 0) - 106), objArr2);
        String[] split = str2.split(((String) objArr2[0]).intern());
        int length = split.length;
        StringBuilder sb2 = new StringBuilder();
        int i10 = length - 1;
        sb2.append(split[i10]);
        Object[] objArr3 = new Object[1];
        AFKeystoreWrapper((ViewConfiguration.getScrollDefaultDelay() >> 16) - 97, -1210396222 - Color.red(0), (byte) (TextUtils.getTrimmedLength("") + 10), 696978983 - Gravity.getAbsoluteGravity(0, 0), (short) (AndroidCharacter.getMirror('0') + '!'), objArr3);
        sb2.append(((String) objArr3[0]).intern());
        int i11 = 1;
        while (true) {
            if ((i11 < i10 ? 14 : 'G') != 14) {
                sb2.append(split[0]);
                String obj = sb2.toString();
                int i12 = afDebugLog + 53;
                AFLogger = i12 % 128;
                int i13 = i12 % 2;
                return obj;
            }
            int i14 = AFLogger + 49;
            afDebugLog = i14 % 128;
            int i15 = i14 % 2;
            sb2.append(split[i11]);
            Object[] objArr4 = new Object[1];
            AFKeystoreWrapper((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 97, (ViewConfiguration.getTapTimeout() >> 16) - 1210396222, (byte) (10 - Color.red(0)), 696978983 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (short) (View.resolveSize(0, 0) + 81), objArr4);
            sb2.append(((String) objArr4[0]).intern());
            i11++;
        }
    }

    private static String values(String str, String str2, int i10) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.setCharAt(i10, AFKeystoreWrapper(str2).charAt(0));
        String obj = sb2.toString();
        int i11 = AFLogger + 21;
        afDebugLog = i11 % 128;
        int i12 = i11 % 2;
        return obj;
    }

    private static void values(StringBuilder sb2) {
        String str;
        Object obj;
        String str2;
        Object obj2;
        StringBuilder sb3 = sb2;
        Object[] objArr = new Object[1];
        values((byte) (51 - TextUtils.getOffsetAfter("", 0)), "\u0014\u0000\f\u0001\u0016\u0015\u000e\u000f\u0017\u001b\u0011\b\u0016\u0018\u001d\u001a\u0005\f\u0006\u0016\u0000\u0014\u0001\u001b㘛", TextUtils.getOffsetAfter("", 0) + 25, objArr);
        if (!(AFInAppEventParameterName(((String) objArr[0]).intern()))) {
            Object[] objArr2 = new Object[1];
            values((byte) ((ViewConfiguration.getTouchSlop() >> 8) + 95), "㘉", 1 - KeyEvent.normalizeMetaState(0), objArr2);
            str = ((String) objArr2[0]).intern();
            int i10 = afDebugLog + 19;
            AFLogger = i10 % 128;
            int i11 = i10 % 2;
        } else {
            int i12 = AFLogger + 73;
            afDebugLog = i12 % 128;
            if (!(i12 % 2 != 0 ? true : true)) {
                Object[] objArr3 = new Object[1];
                values((byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 101), "㘐", 1 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr3);
                str = ((String) objArr3[0]).intern();
            } else {
                Object[] objArr4 = new Object[1];
                values((byte) (21 << (ViewConfiguration.getScrollDefaultDelay() >> 17)), "㘐", 1 << (ViewConfiguration.getScrollBarFadeDuration() >>> 2), objArr4);
                str = ((String) objArr4[0]).intern();
            }
        }
        sb3.append(str);
        Object[] objArr5 = new Object[1];
        AFKeystoreWrapper(ExpandableListView.getPackedPositionGroup(0) - 75, (ViewConfiguration.getMaximumFlingVelocity() >> 16) - 1210396277, (byte) (KeyEvent.normalizeMetaState(0) + 114), Drawable.resolveOpacity(0, 0) + 696979034, (short) (89 - (Process.myPid() >> 22)), objArr5);
        if ((AFInAppEventParameterName(((String) objArr5[0]).intern()) ? 'B' : 11) != 11) {
            Object[] objArr6 = new Object[1];
            values((byte) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 101), "㘐", (ViewConfiguration.getTapTimeout() >> 16) + 1, objArr6);
            obj = objArr6[0];
        } else {
            Object[] objArr7 = new Object[1];
            values((byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 94), "㘉", 1 - (ViewConfiguration.getEdgeSlop() >> 16), objArr7);
            obj = objArr7[0];
        }
        sb3.append(((String) obj).intern());
        Object[] objArr8 = new Object[1];
        AFKeystoreWrapper(-78 - ExpandableListView.getPackedPositionGroup(0), -1210396255 - TextUtils.indexOf("", "", 0, 0), (byte) (TextUtils.indexOf("", "", 0) - 73), (ViewConfiguration.getFadingEdgeLength() >> 16) + 696979034, (short) (76 - (ViewConfiguration.getLongPressTimeout() >> 16)), objArr8);
        if (AFInAppEventParameterName(((String) objArr8[0]).intern())) {
            int i13 = afDebugLog + 105;
            AFLogger = i13 % 128;
            int i14 = i13 % 2;
            Object[] objArr9 = new Object[1];
            values((byte) (101 - (ViewConfiguration.getEdgeSlop() >> 16)), "㘐", 1 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr9);
            str2 = ((String) objArr9[0]).intern();
        } else {
            Object[] objArr10 = new Object[1];
            values((byte) (Color.green(0) + 95), "㘉", Color.argb(0, 0, 0, 0) + 1, objArr10);
            str2 = ((String) objArr10[0]).intern();
            int i15 = AFLogger + 75;
            afDebugLog = i15 % 128;
            int i16 = i15 % 2;
        }
        sb3.append(str2);
        Object[] objArr11 = new Object[1];
        AFKeystoreWrapper(-83 - Gravity.getAbsoluteGravity(0, 0), (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1)) - 1210396237, (byte) (-(AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 696979034 - Color.alpha(0), (short) (57 - TextUtils.getCapsMode("", 0, 0)), objArr11);
        if (AFInAppEventParameterName(((String) objArr11[0]).intern())) {
            Object[] objArr12 = new Object[1];
            values((byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)) + 102), "㘐", 1 - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr12);
            obj2 = objArr12[0];
        } else {
            Object[] objArr13 = new Object[1];
            values((byte) (95 - View.getDefaultSize(0, 0)), "㘉", 1 - (ViewConfiguration.getTouchSlop() >> 8), objArr13);
            obj2 = objArr13[0];
        }
        sb3.append(((String) obj2).intern());
    }

    private static String AFInAppEventType(Context context, StringBuilder sb2) {
        Object obj;
        StringBuilder sb3 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFInAppEventType2 = AFInAppEventType(packageName);
        Object[] objArr = new Object[1];
        values((byte) (101 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), "㘐", 1 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr);
        sb2.append(((String) objArr[0]).intern());
        sb3.append(AFInAppEventType2);
        if (valueOf(context) != null) {
            Object[] objArr2 = new Object[1];
            values((byte) (MotionEvent.axisFromString("") + 102), "㘐", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1, objArr2);
            sb2.append(((String) objArr2[0]).intern());
            sb3.append(packageName);
        } else {
            int i10 = AFLogger + 109;
            afDebugLog = i10 % 128;
            if ((i10 % 2 != 0 ? '!' : 27) != 27) {
                Object[] objArr3 = new Object[1];
                values((byte) (119 - (KeyEvent.getMaxKeyCode() % 110)), "㘉", Color.argb(1, 1, 0, 1) + 0, objArr3);
                obj = objArr3[0];
            } else {
                Object[] objArr4 = new Object[1];
                values((byte) ((KeyEvent.getMaxKeyCode() >> 16) + 95), "㘉", Color.argb(0, 0, 0, 0) + 1, objArr4);
                obj = objArr4[0];
            }
            sb2.append(((String) obj).intern());
            sb3.append(packageName);
        }
        String AFInAppEventParameterName2 = AFInAppEventParameterName(context);
        if ((AFInAppEventParameterName2 == null ? '`' : 'W') != '`') {
            Object[] objArr5 = new Object[1];
            values((byte) (100 - TextUtils.lastIndexOf("", '0')), "㘐", -16777215 - Color.rgb(0, 0, 0), objArr5);
            sb2.append(((String) objArr5[0]).intern());
            sb3.append(AFInAppEventParameterName2);
            int i11 = AFLogger + 37;
            afDebugLog = i11 % 128;
            int i12 = i11 % 2;
        } else {
            Object[] objArr6 = new Object[1];
            values((byte) (96 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), "㘉", 1 - TextUtils.indexOf("", ""), objArr6);
            sb2.append(((String) objArr6[0]).intern());
            sb3.append(packageName);
        }
        sb3.append(Boolean.TRUE.toString());
        return sb3.toString();
    }

    private static String values(String str) {
        int i10 = AFLogger + 13;
        afDebugLog = i10 % 128;
        if ((i10 % 2 != 0 ? 'V' : 9) == 9) {
            return AFa1aSDK.AFInAppEventParameterName(AFa1aSDK.values(str));
        }
        AFa1aSDK.AFInAppEventParameterName(AFa1aSDK.values(str));
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void values(byte r10, java.lang.String r11, int r12, java.lang.Object[] r13) {
        /*
            if (r11 == 0) goto L_0x0006
            char[] r11 = r11.toCharArray()
        L_0x0006:
            char[] r11 = (char[]) r11
            java.lang.Object r0 = com.appsflyer.internal.AFf1cSDK.afDebugLog
            monitor-enter(r0)
            char[] r1 = AFInAppEventType     // Catch:{ all -> 0x00f1 }
            char r2 = AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            char[] r3 = new char[r12]     // Catch:{ all -> 0x00f1 }
            int r4 = r12 % 2
            if (r4 == 0) goto L_0x001e
            int r4 = r12 + -1
            char r5 = r11[r4]     // Catch:{ all -> 0x00f1 }
            int r5 = r5 - r10
            char r5 = (char) r5     // Catch:{ all -> 0x00f1 }
            r3[r4] = r5     // Catch:{ all -> 0x00f1 }
            goto L_0x001f
        L_0x001e:
            r4 = r12
        L_0x001f:
            r5 = 0
            r6 = 1
            if (r4 <= r6) goto L_0x00db
            com.appsflyer.internal.AFf1cSDK.AFInAppEventType = r5     // Catch:{ all -> 0x00f1 }
        L_0x0025:
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            if (r7 >= r4) goto L_0x00db
            char r7 = r11[r7]     // Catch:{ all -> 0x00f1 }
            com.appsflyer.internal.AFf1cSDK.values = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r6
            char r7 = r11[r7]     // Catch:{ all -> 0x00f1 }
            com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper = r7     // Catch:{ all -> 0x00f1 }
            char r7 = com.appsflyer.internal.AFf1cSDK.values     // Catch:{ all -> 0x00f1 }
            char r8 = com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            if (r7 != r8) goto L_0x004d
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            char r8 = com.appsflyer.internal.AFf1cSDK.values     // Catch:{ all -> 0x00f1 }
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch:{ all -> 0x00f1 }
            r3[r7] = r8     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r6
            char r8 = com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch:{ all -> 0x00f1 }
            r3[r7] = r8     // Catch:{ all -> 0x00f1 }
            goto L_0x00d3
        L_0x004d:
            char r7 = com.appsflyer.internal.AFf1cSDK.values     // Catch:{ all -> 0x00f1 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFf1cSDK.valueOf = r7     // Catch:{ all -> 0x00f1 }
            char r7 = com.appsflyer.internal.AFf1cSDK.values     // Catch:{ all -> 0x00f1 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.AFLogger = r7     // Catch:{ all -> 0x00f1 }
            char r7 = com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f1 }
            char r7 = com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.afErrorLog = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.AFLogger     // Catch:{ all -> 0x00f1 }
            int r8 = com.appsflyer.internal.AFf1cSDK.afErrorLog     // Catch:{ all -> 0x00f1 }
            if (r7 != r8) goto L_0x008e
            int r7 = com.appsflyer.internal.AFf1cSDK.valueOf     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.valueOf = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.valueOf     // Catch:{ all -> 0x00f1 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFf1cSDK.AFLogger     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f1 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFf1cSDK.afErrorLog     // Catch:{ all -> 0x00f1 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
            int r9 = r9 + 1
            char r7 = r1[r8]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
            goto L_0x00d3
        L_0x008e:
            int r7 = com.appsflyer.internal.AFf1cSDK.valueOf     // Catch:{ all -> 0x00f1 }
            int r8 = com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f1 }
            if (r7 != r8) goto L_0x00bb
            int r7 = com.appsflyer.internal.AFf1cSDK.AFLogger     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.AFLogger = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.afErrorLog     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFf1cSDK.afErrorLog = r7     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.valueOf     // Catch:{ all -> 0x00f1 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFf1cSDK.AFLogger     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f1 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFf1cSDK.afErrorLog     // Catch:{ all -> 0x00f1 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
            int r9 = r9 + 1
            char r7 = r1[r8]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
            goto L_0x00d3
        L_0x00bb:
            int r7 = com.appsflyer.internal.AFf1cSDK.valueOf     // Catch:{ all -> 0x00f1 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFf1cSDK.afErrorLog     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFf1cSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f1 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFf1cSDK.AFLogger     // Catch:{ all -> 0x00f1 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
            int r9 = r9 + 1
            char r7 = r1[r8]     // Catch:{ all -> 0x00f1 }
            r3[r9] = r7     // Catch:{ all -> 0x00f1 }
        L_0x00d3:
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + 2
            com.appsflyer.internal.AFf1cSDK.AFInAppEventType = r7     // Catch:{ all -> 0x00f1 }
            goto L_0x0025
        L_0x00db:
            r10 = r5
        L_0x00dc:
            if (r10 >= r12) goto L_0x00e8
            char r11 = r3[r10]     // Catch:{ all -> 0x00f1 }
            r11 = r11 ^ 13722(0x359a, float:1.9229E-41)
            char r11 = (char) r11     // Catch:{ all -> 0x00f1 }
            r3[r10] = r11     // Catch:{ all -> 0x00f1 }
            int r10 = r10 + 1
            goto L_0x00dc
        L_0x00e8:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00f1 }
            r10.<init>(r3)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f1 }
            r13[r5] = r10
            return
        L_0x00f1:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1xSDK.values(byte, java.lang.String, int, java.lang.Object[]):void");
    }
}
