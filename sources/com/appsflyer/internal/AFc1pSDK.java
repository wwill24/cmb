package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.internal.Constants;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.b;

public final class AFc1pSDK {
    private static String AFKeystoreWrapper = "https://%sonelink.%s/shortlink-sdk/v2";
    private static char AFLogger = '\u0000';
    private static int AFVersionDeclaration = 1;
    private static int afInfoLog;
    private static char[] afRDLog;
    public static String valueOf = "https://%sgcdsdk.%s/install_data/v5.0/";
    private static String values = "https://%smonitorsdk.%s/remote-debug?app_id=";
    private final CreateOneLinkHttpTask AFInAppEventParameterName;
    private final AFb1fSDK AFInAppEventType;
    private final AppsFlyerProperties afDebugLog;
    private final AFc1cSDK afErrorLog;

    static {
        values();
        int i10 = AFVersionDeclaration + 99;
        afInfoLog = i10 % 128;
        int i11 = i10 % 2;
    }

    public AFc1pSDK(CreateOneLinkHttpTask createOneLinkHttpTask, AFb1fSDK aFb1fSDK, AppsFlyerProperties appsFlyerProperties, AFc1cSDK aFc1cSDK) {
        this.AFInAppEventParameterName = createOneLinkHttpTask;
        this.AFInAppEventType = aFb1fSDK;
        this.afDebugLog = appsFlyerProperties;
        this.afErrorLog = aFc1cSDK;
    }

    private <T> AFc1oSDK<T> AFKeystoreWrapper(AFc1sSDK aFc1sSDK, AFc1hSDK<T> aFc1hSDK) {
        boolean z10;
        int i10 = AFVersionDeclaration + 21;
        afInfoLog = i10 % 128;
        if (i10 % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            AFc1oSDK<T> AFInAppEventType2 = AFInAppEventType(aFc1sSDK, aFc1hSDK, AFInAppEventParameterName());
            int i11 = afInfoLog + 97;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            return AFInAppEventType2;
        }
        AFInAppEventType(aFc1sSDK, aFc1hSDK, AFInAppEventParameterName());
        throw null;
    }

    static void values() {
        AFLogger = 4;
        afRDLog = new char[]{13820, 13769, 13807, 13811, 13825, 13819, 13821, 13824, 13800, 13751, 13816, 13823, 13822, 13806, 13787, 13812};
    }

    @NonNull
    public final AFc1oSDK<AFb1oSDK> AFInAppEventParameterName(boolean z10, boolean z11, @NonNull String str, int i10) {
        String str2;
        String str3;
        String str4;
        AFc1cSDK aFc1cSDK = this.afErrorLog;
        j.g(str, "");
        if ((z10 ? 10 : 'T') != 'T') {
            int i11 = afInfoLog + 49;
            AFVersionDeclaration = i11 % 128;
            int i12 = i11 % 2;
            str2 = AFc1cSDK.values;
            int i13 = AFVersionDeclaration + 39;
            afInfoLog = i13 % 128;
            int i14 = i13 % 2;
        } else {
            str2 = AFc1cSDK.valueOf;
        }
        if (z11) {
            str3 = "stg";
        } else {
            str3 = "";
        }
        o oVar = o.f32141a;
        Object[] objArr = new Object[4];
        if (AFc1cSDK.AFInAppEventType()) {
            str4 = (String) aFc1cSDK.AFInAppEventType.getValue();
        } else {
            int i15 = afInfoLog + 47;
            AFVersionDeclaration = i15 % 128;
            int i16 = i15 % 2;
            str4 = "";
        }
        objArr[0] = str4;
        objArr[1] = str3;
        objArr[2] = aFc1cSDK.AFKeystoreWrapper();
        objArr[3] = str;
        String format2 = String.format(str2, Arrays.copyOf(objArr, 4));
        j.f(format2, "");
        AFc1sSDK aFc1sSDK = new AFc1sSDK(format2, "GET");
        aFc1sSDK.AFInAppEventParameterName(1500);
        return AFKeystoreWrapper(aFc1sSDK, new AFc1lSDK());
    }

    @NonNull
    public final AFc1oSDK<String> AFInAppEventType(Map<String, Object> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sars.%s/api/v2/android/validate_subscription?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.AFInAppEventType.valueOf.values.getPackageName());
        String obj = sb2.toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventType(37 - Color.alpha(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 74, (char) (17157 - (ViewConfiguration.getEdgeSlop() >> 16)))).getMethod("AFInAppEventParameterName", new Class[]{Map.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), true), new AFc1iSDK());
            int i10 = afInfoLog + 115;
            AFVersionDeclaration = i10 % 128;
            if ((i10 % 2 == 0 ? 10 : ')') == ')') {
                return AFKeystoreWrapper2;
            }
            throw null;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    @NonNull
    public final AFc1oSDK<String> valueOf(Map<String, Object> map, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.AFInAppEventType.valueOf.values.getPackageName());
        String obj = sb2.toString();
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            objArr[0] = map;
            AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(obj, (byte[]) ((Class) AFa1vSDK.AFInAppEventType(TextUtils.getOffsetBefore("", 0) + 37, 74 - Drawable.resolveOpacity(0, 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0 ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0 ? 0 : -1)) + 17156))).getMethod("AFInAppEventParameterName", new Class[]{Map.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), true), new AFc1iSDK());
            int i10 = afInfoLog + 89;
            AFVersionDeclaration = i10 % 128;
            int i11 = i10 % 2;
            return AFKeystoreWrapper2;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public final AFc1oSDK<String> values(AFa1sSDK aFa1sSDK, String str) {
        try {
            Object[] objArr = new Object[2];
            objArr[1] = str;
            boolean z10 = false;
            objArr[0] = aFa1sSDK;
            AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(aFa1sSDK.AFLogger, (byte[]) ((Class) AFa1vSDK.AFInAppEventType(ExpandableListView.getPackedPositionChild(0) + 38, View.MeasureSpec.makeMeasureSpec(0, 0) + 74, (char) (17157 - (ViewConfiguration.getJumpTapTimeout() >> 16)))).getMethod("values", new Class[]{AFa1sSDK.class, String.class}).invoke((Object) null, objArr), "POST", Collections.emptyMap(), aFa1sSDK.AFInAppEventParameterName()), new AFc1iSDK());
            int i10 = afInfoLog + 45;
            AFVersionDeclaration = i10 % 128;
            if (i10 % 2 != 0) {
                z10 = true;
            }
            if (z10) {
                return AFKeystoreWrapper2;
            }
            throw null;
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th2;
        }
    }

    public final AFc1oSDK<String> values(AFe1fSDK aFe1fSDK) {
        AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(aFe1fSDK.AFLogger, aFe1fSDK.valueOf(), "POST", Collections.emptyMap(), true), new AFc1iSDK());
        int i10 = afInfoLog + 105;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
        return AFKeystoreWrapper2;
    }

    public final AFc1oSDK<Map<String, String>> AFInAppEventType(@NonNull String str, @NonNull String str2, @NonNull UUID uuid, @NonNull String str3) {
        String str4 = str;
        String str5 = str2;
        String obj = uuid.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb2.append(str4);
        sb2.append("?id=");
        sb2.append(str5);
        String obj2 = sb2.toString();
        Map<String, Object> valueOf2 = valueOf();
        String valueOf3 = String.valueOf(valueOf2.get("build_number"));
        HashMap hashMap = new HashMap();
        hashMap.put("Af-UUID", uuid.toString());
        hashMap.put("Af-Meta-Sdk-Ver", valueOf3);
        hashMap.put("Af-Meta-Counter", String.valueOf(valueOf2.get("counter")));
        hashMap.put("Af-Meta-Model", String.valueOf(valueOf2.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)));
        hashMap.put("Af-Meta-Platform", String.valueOf(valueOf2.get("platformextension")));
        hashMap.put("Af-Meta-System-Version", String.valueOf(valueOf2.get("sdk")));
        Object[] objArr = new Object[1];
        valueOf(11 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0 ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0 ? 0 : -1)), "\f\u0002\r\u0005\u0002\u0007\r\u0007\u000e\u0001\t\b", (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 40), objArr);
        hashMap.put(((String) objArr[0]).intern(), AFInAppEventType(str3, obj, "GET", obj, str4, str5, valueOf3));
        AFc1oSDK<Map<String, String>> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(obj2, (byte[]) null, "GET", hashMap, false), new AFc1fSDK());
        int i10 = afInfoLog + 65;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
        return AFKeystoreWrapper2;
    }

    @NonNull
    public final AFc1oSDK<String> valueOf(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(values, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.AFInAppEventType.valueOf.values.getPackageName());
        AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(sb2.toString(), new b((Map<?, ?>) map).toString().getBytes(), "POST", Collections.emptyMap(), false), new AFc1iSDK());
        int i10 = afInfoLog + 111;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
        return AFKeystoreWrapper2;
    }

    public final AFc1oSDK<String> values(@NonNull String str, @NonNull Map<String, String> map, String str2, @NonNull UUID uuid, @NonNull String str3) {
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put(Constants.Params.UUID, obj);
        hashMap.put("data", map);
        hashMap.put("meta", valueOf());
        if ((str2 != null ? '&' : 'I') != 'I') {
            hashMap.put("brand_domain", str2);
            int i10 = afInfoLog + 65;
            AFVersionDeclaration = i10 % 128;
            int i11 = i10 % 2;
        }
        String bVar = AFa1lSDK.AFInAppEventParameterName((Map<String, ?>) hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        valueOf((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 12, "\f\u0002\r\u0005\u0002\u0007\r\u0007\u000e\u0001\t\b", (byte) (40 - Color.argb(0, 0, 0, 0)), objArr);
        hashMap2.put(((String) objArr[0]).intern(), AFInAppEventType(str3, obj, "POST", bVar));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1zSDK.AFInAppEventType().getHostName()}));
        sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        sb2.append(str);
        AFc1oSDK<String> AFInAppEventType2 = AFInAppEventType(new AFc1sSDK(sb2.toString(), bVar.getBytes(Charset.forName("UTF-8")), "POST", hashMap2, false), new AFc1iSDK(), true);
        int i12 = afInfoLog + 107;
        AFVersionDeclaration = i12 % 128;
        int i13 = i12 % 2;
        return AFInAppEventType2;
    }

    private boolean AFInAppEventParameterName() {
        if (!(!this.afDebugLog.getBoolean(AppsFlyerProperties.HTTP_CACHE, true))) {
            int i10 = AFVersionDeclaration + 117;
            afInfoLog = i10 % 128;
            int i11 = i10 % 2;
            return false;
        }
        int i12 = AFVersionDeclaration + 45;
        afInfoLog = i12 % 128;
        return (i12 % 2 != 0 ? '\'' : '#') != '\'';
    }

    public final AFc1oSDK<Map<String, Object>> valueOf(String str, String str2) {
        AFc1oSDK<Map<String, Object>> AFKeystoreWrapper2 = AFKeystoreWrapper(AFc1qSDK.AFKeystoreWrapper(this.AFInAppEventType.valueOf.values.getPackageName(), AFb1xSDK.AFInAppEventParameterName(new WeakReference(this.AFInAppEventType.valueOf.values)), str, str2), new AFc1kSDK());
        int i10 = AFVersionDeclaration + 83;
        afInfoLog = i10 % 128;
        if (!(i10 % 2 != 0)) {
            return AFKeystoreWrapper2;
        }
        throw null;
    }

    public final AFc1oSDK<String> AFInAppEventType(@NonNull String str) {
        AFc1oSDK<String> AFKeystoreWrapper2 = AFKeystoreWrapper(new AFc1sSDK(str, (byte[]) null, "GET", Collections.emptyMap(), false).AFInAppEventParameterName(10000).afErrorLogForExcManagerOnly(), new AFc1iSDK());
        int i10 = afInfoLog + 35;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
        return AFKeystoreWrapper2;
    }

    private <T> AFc1oSDK<T> AFInAppEventType(AFc1sSDK aFc1sSDK, AFc1hSDK<T> aFc1hSDK, boolean z10) {
        aFc1sSDK.valueOf(z10);
        CreateOneLinkHttpTask createOneLinkHttpTask = this.AFInAppEventParameterName;
        AFc1oSDK<T> aFc1oSDK = new AFc1oSDK<>(aFc1sSDK, createOneLinkHttpTask.AFInAppEventParameterName, createOneLinkHttpTask.AFInAppEventType, aFc1hSDK);
        int i10 = AFVersionDeclaration + 77;
        afInfoLog = i10 % 128;
        if ((i10 % 2 != 0 ? 6 : '4') != 6) {
            return aFc1oSDK;
        }
        throw null;
    }

    private Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.10.0");
        hashMap.put("counter", Integer.valueOf(this.AFInAppEventType.values.AFInAppEventType("appsFlyerCount", 0)));
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        Object[] objArr = new Object[1];
        valueOf(TextUtils.lastIndexOf("", '0', 0, 0) + 6, "\u000b\t\u0007\r㘒", (byte) (20 - Color.red(0)), objArr);
        hashMap.put(((String) objArr[0]).intern(), Build.BRAND);
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        Context context = this.AFInAppEventType.valueOf.values;
        hashMap.put("app_version_name", AFa1dSDK.values(context, context.getPackageName()));
        hashMap.put("app_id", this.AFInAppEventType.valueOf.values.getPackageName());
        hashMap.put("platformextension", new AFb1rSDK().values());
        int i10 = afInfoLog + 59;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            return hashMap;
        }
        int i11 = 91 / 0;
        return hashMap;
    }

    private static String AFInAppEventType(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String values2 = AFa1aSDK.values((String[]) arrayList.toArray(new String[0]));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append("v2");
        String values3 = AFa1aSDK.values(values2, sb2.toString());
        int i10 = afInfoLog + 9;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
        return values3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(int r10, java.lang.String r11, byte r12, java.lang.Object[] r13) {
        /*
            if (r11 == 0) goto L_0x0006
            char[] r11 = r11.toCharArray()
        L_0x0006:
            char[] r11 = (char[]) r11
            java.lang.Object r0 = com.appsflyer.internal.AFf1cSDK.afDebugLog
            monitor-enter(r0)
            char[] r1 = afRDLog     // Catch:{ all -> 0x00f1 }
            char r2 = AFLogger     // Catch:{ all -> 0x00f1 }
            char[] r3 = new char[r10]     // Catch:{ all -> 0x00f1 }
            int r4 = r10 % 2
            if (r4 == 0) goto L_0x001e
            int r4 = r10 + -1
            char r5 = r11[r4]     // Catch:{ all -> 0x00f1 }
            int r5 = r5 - r12
            char r5 = (char) r5     // Catch:{ all -> 0x00f1 }
            r3[r4] = r5     // Catch:{ all -> 0x00f1 }
            goto L_0x001f
        L_0x001e:
            r4 = r10
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
            int r8 = r8 - r12
            char r8 = (char) r8     // Catch:{ all -> 0x00f1 }
            r3[r7] = r8     // Catch:{ all -> 0x00f1 }
            int r7 = com.appsflyer.internal.AFf1cSDK.AFInAppEventType     // Catch:{ all -> 0x00f1 }
            int r7 = r7 + r6
            char r8 = com.appsflyer.internal.AFf1cSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f1 }
            int r8 = r8 - r12
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
            r11 = r5
        L_0x00dc:
            if (r11 >= r10) goto L_0x00e8
            char r12 = r3[r11]     // Catch:{ all -> 0x00f1 }
            r12 = r12 ^ 13722(0x359a, float:1.9229E-41)
            char r12 = (char) r12     // Catch:{ all -> 0x00f1 }
            r3[r11] = r12     // Catch:{ all -> 0x00f1 }
            int r11 = r11 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1pSDK.valueOf(int, java.lang.String, byte, java.lang.Object[]):void");
    }
}
