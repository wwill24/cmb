package i4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.a;
import com.clevertap.android.sdk.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONException;
import org.json.b;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15508a = a();

    private static boolean a() {
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("com.google.android.exoplayer2.ExoPlayer");
            Class<?> cls3 = Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource");
            cls = Class.forName("com.google.android.exoplayer2.ui.StyledPlayerView");
            p.a("ExoPlayer is present");
            return true;
        } catch (Throwable unused) {
            p.a("ExoPlayer library files are missing!!!");
            p.a("Please add ExoPlayer dependencies to render InApp or Inbox messages playing video. For more information checkout CleverTap documentation.");
            if (cls != null) {
                p.a("ExoPlayer classes not found " + cls.getName());
            } else {
                p.a("ExoPlayer classes not found");
            }
            return false;
        }
    }

    public static boolean b(Collection<String> collection, String str) {
        if (!(collection == null || str == null)) {
            for (String equalsIgnoreCase : collection) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static HashMap<String, Object> c(@NonNull Bundle bundle) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj instanceof Bundle) {
                hashMap.putAll(c((Bundle) obj));
            } else {
                hashMap.put(next, bundle.get(next));
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> d(b bVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                Object obj = bVar.get(next);
                if (obj instanceof b) {
                    hashMap.putAll(d((b) obj));
                } else {
                    hashMap.put(next, bVar.get(next));
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static String e(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (char c10 : str.toCharArray()) {
            if (Character.isSpaceChar(c10)) {
                z10 = true;
            } else if (z10) {
                c10 = Character.toTitleCase(c10);
                z10 = false;
            } else {
                c10 = Character.toLowerCase(c10);
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    static Bitmap f(@NonNull Drawable drawable) throws NullPointerException {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static Bitmap g(Context context) throws NullPointerException {
        try {
            Drawable applicationLogo = context.getPackageManager().getApplicationLogo(context.getApplicationInfo());
            if (applicationLogo != null) {
                return f(applicationLogo);
            }
            throw new Exception("Logo is null");
        } catch (Exception e10) {
            e10.printStackTrace();
            return f(context.getPackageManager().getApplicationIcon(context.getApplicationInfo()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[SYNTHETIC, Splitter:B:18:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[SYNTHETIC, Splitter:B:26:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap h(@androidx.annotation.NonNull java.lang.String r6) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r6 = r6.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r6 = r6.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x0044 }
            r2.connect()     // Catch:{ IOException -> 0x0044 }
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x0044 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ IOException -> 0x0044 }
            r2.disconnect()     // Catch:{ all -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r1 = move-exception
            com.clevertap.android.sdk.p.r(r0, r1)
        L_0x0043:
            return r6
        L_0x0044:
            r3 = move-exception
            goto L_0x004a
        L_0x0046:
            r6 = move-exception
            goto L_0x006e
        L_0x0048:
            r3 = move-exception
            r2 = r1
        L_0x004a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r4.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r5 = "Couldn't download the notification icon. URL was: "
            r4.append(r5)     // Catch:{ all -> 0x006c }
            r4.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x006c }
            com.clevertap.android.sdk.p.o(r6)     // Catch:{ all -> 0x006c }
            r3.printStackTrace()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x006b
            r2.disconnect()     // Catch:{ all -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r6 = move-exception
            com.clevertap.android.sdk.p.r(r0, r6)
        L_0x006b:
            return r1
        L_0x006c:
            r6 = move-exception
            r1 = r2
        L_0x006e:
            if (r1 == 0) goto L_0x0078
            r1.disconnect()     // Catch:{ all -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r1 = move-exception
            com.clevertap.android.sdk.p.r(r0, r1)
        L_0x0078:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.x.h(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ef, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f0, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f2, code lost:
        r2 = r0;
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f7, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r4.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x021d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x021e, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        r3.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x022d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x022e, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        if (r4.getContentEncoding().contains("gzip") != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0104, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r0 = new byte[net.bytebuddy.jar.asm.Opcodes.ACC_ENUM];
        com.clevertap.android.sdk.p.o("Total download size for bitmap = " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011e, code lost:
        if (r5 == false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0120, code lost:
        r2 = new java.io.ByteArrayInputStream(r13.toByteArray());
        r5 = new java.io.ByteArrayOutputStream();
        r9 = new java.util.zip.GZIPInputStream(r2);
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0135, code lost:
        r2 = r9.read(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0139, code lost:
        if (r2 == r3) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013b, code lost:
        r16 = r4;
        r11 = r11 + ((long) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r5.write(r0, 0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0142, code lost:
        r4 = r16;
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0146, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0147, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014b, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        com.clevertap.android.sdk.p.o("Total decompressed download size for bitmap = " + r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0165, code lost:
        if (r6 == -1) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0169, code lost:
        if (r6 == r14) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016b, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("File not loaded completely not going forward. URL was: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0173, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.append(r2);
        com.clevertap.android.sdk.p.a(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r16.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0184, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0185, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x018b, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r2 = android.graphics.BitmapFactory.decodeByteArray(r5.toByteArray(), 0, (int) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r16.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x019b, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a1, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a4, code lost:
        r16 = r4;
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ac, code lost:
        if (r6 == -1) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b0, code lost:
        if (r6 == r14) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        com.clevertap.android.sdk.p.a("File not loaded completely not going forward. URL was: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r16.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ca, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r2 = android.graphics.BitmapFactory.decodeByteArray(r13.toByteArray(), 0, (int) r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r16.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01de, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e6, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01ef A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0219 A[SYNTHETIC, Splitter:B:114:0x0219] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0229 A[SYNTHETIC, Splitter:B:121:0x0229] */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e3 A[ExcHandler: all (th java.lang.Throwable), PHI: r16 
      PHI: (r16v6 java.net.HttpURLConnection) = (r16v7 java.net.HttpURLConnection), (r16v7 java.net.HttpURLConnection), (r16v7 java.net.HttpURLConnection), (r16v8 java.net.HttpURLConnection), (r16v8 java.net.HttpURLConnection), (r16v8 java.net.HttpURLConnection), (r16v8 java.net.HttpURLConnection), (r16v9 java.net.HttpURLConnection), (r16v9 java.net.HttpURLConnection) binds: [B:89:0x01d0, B:83:0x01b2, B:84:?, B:56:0x014d, B:70:0x018d, B:63:0x0175, B:64:?, B:50:0x013f, B:51:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:50:0x013f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap i(java.lang.String r18, int r19) {
        /*
            r0 = r19
            java.lang.String r1 = "Couldn't close connection!"
            java.lang.String r2 = "///"
            java.lang.String r3 = "/"
            r4 = r18
            java.lang.String r2 = r4.replace(r2, r3)
            java.lang.String r4 = "//"
            java.lang.String r2 = r2.replace(r4, r3)
            java.lang.String r3 = "http:/"
            java.lang.String r4 = "http://"
            java.lang.String r2 = r2.replace(r3, r4)
            java.lang.String r3 = "https:/"
            java.lang.String r4 = "https://"
            java.lang.String r2 = r2.replace(r3, r4)
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x01fe, all -> 0x01fa }
            r4.<init>(r2)     // Catch:{ IOException -> 0x01fe, all -> 0x01fa }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x01fe, all -> 0x01fa }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x01fe, all -> 0x01fa }
            r5 = 1
            r4.setDoInput(r5)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r4.setUseCaches(r5)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.String r6 = "Accept-Encoding"
            java.lang.String r7 = "gzip, deflate"
            r4.addRequestProperty(r6, r7)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r4.connect()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            int r6 = r4.getResponseCode()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r7 = 200(0xc8, float:2.8E-43)
            java.lang.String r8 = "File not loaded completely not going forward. URL was: "
            if (r6 == r7) goto L_0x006a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0067 }
            r0.<init>()     // Catch:{ IOException -> 0x0067 }
            r0.append(r8)     // Catch:{ IOException -> 0x0067 }
            r0.append(r2)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0067 }
            com.clevertap.android.sdk.p.a(r0)     // Catch:{ IOException -> 0x0067 }
            r4.disconnect()     // Catch:{ all -> 0x0061 }
            goto L_0x0066
        L_0x0061:
            r0 = move-exception
            r2 = r0
            com.clevertap.android.sdk.p.r(r1, r2)
        L_0x0066:
            return r3
        L_0x0067:
            r0 = move-exception
            goto L_0x0200
        L_0x006a:
            int r6 = r4.getContentLength()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            long r6 = (long) r6     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.String r9 = r4.getContentEncoding()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r10 = 0
            if (r9 == 0) goto L_0x0083
            java.lang.String r9 = r4.getContentEncoding()     // Catch:{ IOException -> 0x0067 }
            java.lang.String r11 = "gzip"
            boolean r9 = r9.contains(r11)     // Catch:{ IOException -> 0x0067 }
            if (r9 == 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r5 = r10
        L_0x0084:
            java.io.InputStream r9 = r4.getInputStream()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r11 = 16384(0x4000, float:2.2959E-41)
            byte[] r12 = new byte[r11]     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.io.ByteArrayOutputStream r13 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r13.<init>()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r14.<init>()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.String r15 = "Downloading "
            r14.append(r15)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r14.append(r2)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.String r15 = "...."
            r14.append(r15)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            java.lang.String r14 = r14.toString()     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            com.clevertap.android.sdk.p.o(r14)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r14 = 0
        L_0x00ac:
            int r11 = r9.read(r12)     // Catch:{ IOException -> 0x01f6, all -> 0x01ef }
            r3 = -1
            if (r11 == r3) goto L_0x0104
            r17 = r2
            long r2 = (long) r11
            long r14 = r14 + r2
            r13.write(r12, r10, r11)     // Catch:{ IOException -> 0x0101 }
            long r2 = (long) r0     // Catch:{ IOException -> 0x0101 }
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00e4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0101 }
            r2.<init>()     // Catch:{ IOException -> 0x0101 }
            java.lang.String r3 = "Image size is larger than "
            r2.append(r3)     // Catch:{ IOException -> 0x0101 }
            r2.append(r0)     // Catch:{ IOException -> 0x0101 }
            java.lang.String r0 = " bytes. Cancelling download!"
            r2.append(r0)     // Catch:{ IOException -> 0x0101 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x0101 }
            com.clevertap.android.sdk.p.o(r0)     // Catch:{ IOException -> 0x0101 }
            r4.disconnect()     // Catch:{ all -> 0x00dd }
        L_0x00db:
            r1 = 0
            goto L_0x00e3
        L_0x00dd:
            r0 = move-exception
            r2 = r0
            com.clevertap.android.sdk.p.r(r1, r2)
            goto L_0x00db
        L_0x00e3:
            return r1
        L_0x00e4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0101 }
            r2.<init>()     // Catch:{ IOException -> 0x0101 }
            java.lang.String r3 = "Downloaded "
            r2.append(r3)     // Catch:{ IOException -> 0x0101 }
            r2.append(r14)     // Catch:{ IOException -> 0x0101 }
            java.lang.String r3 = " bytes"
            r2.append(r3)     // Catch:{ IOException -> 0x0101 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0101 }
            com.clevertap.android.sdk.p.o(r2)     // Catch:{ IOException -> 0x0101 }
            r2 = r17
            r3 = 0
            goto L_0x00ac
        L_0x0101:
            r0 = move-exception
            goto L_0x01ec
        L_0x0104:
            r17 = r2
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r2.<init>()     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            java.lang.String r9 = "Total download size for bitmap = "
            r2.append(r9)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r2.append(r14)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            com.clevertap.android.sdk.p.o(r2)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            if (r5 == 0) goto L_0x01a4
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            byte[] r5 = r13.toByteArray()     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r2.<init>(r5)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r5.<init>()     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            java.util.zip.GZIPInputStream r9 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r9.<init>(r2)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            r11 = 0
        L_0x0135:
            int r2 = r9.read(r0)     // Catch:{ IOException -> 0x01e9, all -> 0x01ef }
            if (r2 == r3) goto L_0x014b
            r16 = r4
            long r3 = (long) r2
            long r11 = r11 + r3
            r5.write(r0, r10, r2)     // Catch:{ IOException -> 0x0146, all -> 0x01e3 }
            r4 = r16
            r3 = -1
            goto L_0x0135
        L_0x0146:
            r0 = move-exception
            r4 = r16
            goto L_0x01ec
        L_0x014b:
            r16 = r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r0.<init>()     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            java.lang.String r2 = "Total decompressed download size for bitmap = "
            r0.append(r2)     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r0.append(r11)     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            com.clevertap.android.sdk.p.o(r0)     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r2 = -1
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x018b
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x018b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r0.<init>()     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r0.append(r8)     // Catch:{ IOException -> 0x01a0, all -> 0x01e3 }
            r2 = r17
            r0.append(r2)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            com.clevertap.android.sdk.p.a(r0)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r16.disconnect()     // Catch:{ all -> 0x0184 }
        L_0x0182:
            r1 = 0
            goto L_0x018a
        L_0x0184:
            r0 = move-exception
            r2 = r0
            com.clevertap.android.sdk.p.r(r1, r2)
            goto L_0x0182
        L_0x018a:
            return r1
        L_0x018b:
            r2 = r17
            byte[] r0 = r5.toByteArray()     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            int r3 = (int) r11     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r0, r10, r3)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r16.disconnect()     // Catch:{ all -> 0x019a }
            goto L_0x019f
        L_0x019a:
            r0 = move-exception
            r3 = r0
            com.clevertap.android.sdk.p.r(r1, r3)
        L_0x019f:
            return r2
        L_0x01a0:
            r0 = move-exception
            r2 = r17
            goto L_0x01e6
        L_0x01a4:
            r16 = r4
            r2 = r17
            r3 = -1
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01d0
            int r0 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r0.<init>()     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r0.append(r8)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r0.append(r2)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            com.clevertap.android.sdk.p.a(r0)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r16.disconnect()     // Catch:{ all -> 0x01c9 }
        L_0x01c7:
            r1 = 0
            goto L_0x01cf
        L_0x01c9:
            r0 = move-exception
            r2 = r0
            com.clevertap.android.sdk.p.r(r1, r2)
            goto L_0x01c7
        L_0x01cf:
            return r1
        L_0x01d0:
            byte[] r0 = r13.toByteArray()     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            int r3 = (int) r14     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r0, r10, r3)     // Catch:{ IOException -> 0x01e5, all -> 0x01e3 }
            r16.disconnect()     // Catch:{ all -> 0x01dd }
            goto L_0x01e2
        L_0x01dd:
            r0 = move-exception
            r3 = r0
            com.clevertap.android.sdk.p.r(r1, r3)
        L_0x01e2:
            return r2
        L_0x01e3:
            r0 = move-exception
            goto L_0x01f2
        L_0x01e5:
            r0 = move-exception
        L_0x01e6:
            r4 = r16
            goto L_0x0200
        L_0x01e9:
            r0 = move-exception
            r16 = r4
        L_0x01ec:
            r2 = r17
            goto L_0x0200
        L_0x01ef:
            r0 = move-exception
            r16 = r4
        L_0x01f2:
            r2 = r0
            r3 = r16
            goto L_0x0227
        L_0x01f6:
            r0 = move-exception
            r16 = r4
            goto L_0x0200
        L_0x01fa:
            r0 = move-exception
            r2 = r0
            r3 = 0
            goto L_0x0227
        L_0x01fe:
            r0 = move-exception
            r4 = 0
        L_0x0200:
            r0.printStackTrace()     // Catch:{ all -> 0x0224 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
            r0.<init>()     // Catch:{ all -> 0x0224 }
            java.lang.String r3 = "Couldn't download the file. URL was: "
            r0.append(r3)     // Catch:{ all -> 0x0224 }
            r0.append(r2)     // Catch:{ all -> 0x0224 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0224 }
            com.clevertap.android.sdk.p.o(r0)     // Catch:{ all -> 0x0224 }
            if (r4 == 0) goto L_0x0222
            r4.disconnect()     // Catch:{ all -> 0x021d }
            goto L_0x0222
        L_0x021d:
            r0 = move-exception
            r2 = r0
            com.clevertap.android.sdk.p.r(r1, r2)
        L_0x0222:
            r1 = 0
            return r1
        L_0x0224:
            r0 = move-exception
            r2 = r0
            r3 = r4
        L_0x0227:
            if (r3 == 0) goto L_0x0232
            r3.disconnect()     // Catch:{ all -> 0x022d }
            goto L_0x0232
        L_0x022d:
            r0 = move-exception
            r3 = r0
            com.clevertap.android.sdk.p.r(r1, r3)
        L_0x0232:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.x.i(java.lang.String, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|(2:20|21)|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.clevertap.android.sdk.p.o("Error processing image bytes from url: " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r2 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007d, code lost:
        com.clevertap.android.sdk.p.r("Couldn't close connection!", r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0055 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[SYNTHETIC, Splitter:B:28:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] j(java.lang.String r8) {
        /*
            java.lang.String r0 = "Couldn't close connection!"
            java.lang.String r1 = "///"
            java.lang.String r2 = "/"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "//"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "http:/"
            java.lang.String r2 = "http://"
            java.lang.String r8 = r8.replace(r1, r2)
            java.lang.String r1 = "https:/"
            java.lang.String r2 = "https://"
            java.lang.String r8 = r8.replace(r1, r2)
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            r2.<init>(r8)     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ IOException -> 0x0054, all -> 0x0052 }
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x0055 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0055 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0055 }
            r5.<init>()     // Catch:{ IOException -> 0x0055 }
        L_0x0039:
            int r6 = r3.read(r4)     // Catch:{ IOException -> 0x0055 }
            r7 = -1
            if (r6 == r7) goto L_0x0045
            r7 = 0
            r5.write(r4, r7, r6)     // Catch:{ IOException -> 0x0055 }
            goto L_0x0039
        L_0x0045:
            byte[] r8 = r5.toByteArray()     // Catch:{ IOException -> 0x0055 }
            r2.disconnect()     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r1 = move-exception
            com.clevertap.android.sdk.p.r(r0, r1)
        L_0x0051:
            return r8
        L_0x0052:
            r8 = move-exception
            goto L_0x0076
        L_0x0054:
            r2 = r1
        L_0x0055:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r3.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = "Error processing image bytes from url: "
            r3.append(r4)     // Catch:{ all -> 0x0074 }
            r3.append(r8)     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0074 }
            com.clevertap.android.sdk.p.o(r8)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0073
            r2.disconnect()     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r8 = move-exception
            com.clevertap.android.sdk.p.r(r0, r8)
        L_0x0073:
            return r1
        L_0x0074:
            r8 = move-exception
            r1 = r2
        L_0x0076:
            if (r1 == 0) goto L_0x0080
            r1.disconnect()     // Catch:{ all -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r1 = move-exception
            com.clevertap.android.sdk.p.r(r0, r1)
        L_0x0080:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.x.j(java.lang.String):byte[]");
    }

    @SuppressLint({"MissingPermission"})
    public static String k(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "Unavailable";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                return l(context);
            }
            return "WiFi";
        } catch (Throwable unused) {
            return "Unavailable";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String l(@NonNull Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "Unavailable";
        }
        int i10 = 0;
        if (Build.VERSION.SDK_INT < 30) {
            i10 = telephonyManager.getNetworkType();
        } else if (s(context, "android.permission.READ_PHONE_STATE")) {
            try {
                i10 = telephonyManager.getDataNetworkType();
            } catch (SecurityException e10) {
                p.a("Security Exception caught while fetch network type" + e10.getMessage());
            }
        } else {
            p.a("READ_PHONE_STATE permission not asked by the app or not granted by the user");
        }
        if (i10 == 20) {
            return "5G";
        }
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    public static long m() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static Bitmap n(String str, boolean z10, Context context) throws NullPointerException {
        return o(str, z10, context, -1);
    }

    public static Bitmap o(String str, boolean z10, Context context, int i10) throws NullPointerException {
        Bitmap bitmap;
        if (str != null && !str.equals("")) {
            if (!str.startsWith("http")) {
                str = "http://static.wizrocket.com/android/ico//" + str;
            }
            if (i10 == -1) {
                bitmap = h(str);
            } else {
                bitmap = i(str, i10);
            }
            if (bitmap != null) {
                return bitmap;
            }
            if (z10) {
                return g(context);
            }
            return null;
        } else if (z10) {
            return g(context);
        } else {
            return null;
        }
    }

    public static int p() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String q(String str) {
        String[] split = str.split("\\.", 2);
        return split[0] + "." + SaslNonza.AuthMechanism.ELEMENT + "." + split[1];
    }

    public static int r(Context context, String str) {
        if (context != null) {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        }
        return -1;
    }

    public static boolean s(@NonNull Context context, @NonNull String str) {
        try {
            return a.checkSelfPermission(context, str) == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean t(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static boolean u(@NonNull Context context, Class cls) {
        if (cls == null) {
            return false;
        }
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services) {
                if (serviceInfo.name.equals(cls.getName())) {
                    p.o("Service " + serviceInfo.name + " found");
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            p.a("Intent Service name not found exception - " + e10.getLocalizedMessage());
        }
        return false;
    }

    public static void v(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void w(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    intent.setPackage(packageName);
                    return;
                }
            }
        }
    }

    public static Bundle x(String str) throws JSONException {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            b bVar = new b(str);
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, bVar.getString(next));
            }
        }
        return bundle;
    }

    public static boolean y(String str) {
        if (str == null) {
            p.j("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is NULL.");
            return false;
        } else if (str.isEmpty()) {
            p.j("CLEVERTAP_USE_CUSTOM_ID has been set as 1 in AndroidManifest.xml but custom CleverTap ID passed is empty.");
            return false;
        } else if (str.length() > 64) {
            p.j("Custom CleverTap ID passed is greater than 64 characters. ");
            return false;
        } else if (str.matches("[=|<>;+.A-Za-z0-9()!:$@_-]*")) {
            return true;
        } else {
            p.j("Custom CleverTap ID cannot contain special characters apart from : =,(,),_,!,@,$,|<,>,;,+,. and - ");
            return false;
        }
    }
}
