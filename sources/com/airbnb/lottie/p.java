package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import b3.w;
import c3.f;
import c3.j;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.bytebuddy.jar.asm.Opcodes;
import okio.BufferedSource;
import okio.Okio;
import w2.b;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, k0<h>> f8792a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Set<l0> f8793b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f8794c = {80, 75, 3, 4};

    private static boolean A(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean B(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b10 : f8794c) {
                if (peek.readByte() != b10) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        } catch (Exception e10) {
            f.b("Failed to check zip file header", e10);
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th2) {
        Map<String, k0<h>> map = f8792a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ i0 D(h hVar) throws Exception {
        return new i0(hVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, h hVar) {
        Map<String, k0<h>> map = f8792a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ i0 H(WeakReference weakReference, Context context, int i10, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i10, str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ i0 I(Context context, String str, String str2) throws Exception {
        i0<h> c10 = c.e(context).c(context, str, str2);
        if (!(str2 == null || c10.b() == null)) {
            w2.f.b().c(str2, c10.b());
        }
        return c10;
    }

    private static void J(boolean z10) {
        ArrayList arrayList = new ArrayList(f8793b);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((l0) arrayList.get(i10)).a(z10);
        }
    }

    private static String K(Context context, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(A(context) ? "_night_" : "_day_");
        sb2.append(i10);
        return sb2.toString();
    }

    private static k0<h> h(String str, Callable<i0<h>> callable) {
        h hVar;
        if (str == null) {
            hVar = null;
        } else {
            hVar = w2.f.b().a(str);
        }
        if (hVar != null) {
            return new k0<>(new k(hVar));
        }
        if (str != null) {
            Map<String, k0<h>> map = f8792a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        k0<h> k0Var = new k0<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            k0Var.d(new l(str, atomicBoolean));
            k0Var.c(new m(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                Map<String, k0<h>> map2 = f8792a;
                map2.put(str, k0Var);
                if (map2.size() == 1) {
                    J(false);
                }
            }
        }
        return k0Var;
    }

    private static d0 i(h hVar, String str) {
        for (d0 next : hVar.j().values()) {
            if (next.b().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static k0<h> j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static k0<h> k(Context context, String str, String str2) {
        return h(str2, new n(context.getApplicationContext(), str, str2));
    }

    public static i0<h> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static i0<h> m(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return o(context.getAssets().open(str), str2);
                }
            }
            return y(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e10) {
            return new i0<>((Throwable) e10);
        }
    }

    public static k0<h> n(InputStream inputStream, String str) {
        return h(str, new j(inputStream, str));
    }

    public static i0<h> o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    private static i0<h> p(InputStream inputStream, String str, boolean z10) {
        try {
            return q(JsonReader.u(Okio.c(Okio.j(inputStream))), str);
        } finally {
            if (z10) {
                j.c(inputStream);
            }
        }
    }

    public static i0<h> q(JsonReader jsonReader, String str) {
        return r(jsonReader, str, true);
    }

    private static i0<h> r(JsonReader jsonReader, String str, boolean z10) {
        try {
            h a10 = w.a(jsonReader);
            if (str != null) {
                w2.f.b().c(str, a10);
            }
            i0<h> i0Var = new i0<>(a10);
            if (z10) {
                j.c(jsonReader);
            }
            return i0Var;
        } catch (Exception e10) {
            i0<h> i0Var2 = new i0<>((Throwable) e10);
            if (z10) {
                j.c(jsonReader);
            }
            return i0Var2;
        } catch (Throwable th2) {
            if (z10) {
                j.c(jsonReader);
            }
            throw th2;
        }
    }

    public static k0<h> s(Context context, int i10) {
        return t(context, i10, K(context, i10));
    }

    public static k0<h> t(Context context, int i10, String str) {
        return h(str, new o(new WeakReference(context), context.getApplicationContext(), i10, str));
    }

    public static i0<h> u(Context context, int i10) {
        return v(context, i10, K(context, i10));
    }

    public static i0<h> v(Context context, int i10, String str) {
        try {
            BufferedSource c10 = Okio.c(Okio.j(context.getResources().openRawResource(i10)));
            if (B(c10).booleanValue()) {
                return y(context, new ZipInputStream(c10.Z1()), str);
            }
            return o(c10.Z1(), str);
        } catch (Resources.NotFoundException e10) {
            return new i0<>((Throwable) e10);
        }
    }

    public static k0<h> w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static k0<h> x(Context context, String str, String str2) {
        return h(str2, new i(context, str, str2));
    }

    public static i0<h> y(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return z(context, zipInputStream, str);
        } finally {
            j.c(zipInputStream);
        }
    }

    private static i0<h> z(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            h hVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    hVar = r(JsonReader.u(Okio.c(Okio.j(zipInputStream))), (String) null, false).b();
                } else {
                    if (!name.contains(".png")) {
                        if (!name.contains(".webp") && !name.contains(".jpg")) {
                            if (!name.contains(".jpeg")) {
                                if (!name.contains(".ttf")) {
                                    if (!name.contains(".otf")) {
                                        zipInputStream.closeEntry();
                                    }
                                }
                                String[] split = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                                String str2 = split[split.length - 1];
                                String str3 = str2.split("\\.")[0];
                                File file = new File(context.getCacheDir(), str2);
                                new FileOutputStream(file);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    byte[] bArr = new byte[Opcodes.ACC_SYNTHETIC];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    f.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th2);
                                }
                                Typeface createFromFile = Typeface.createFromFile(file);
                                if (!file.delete()) {
                                    f.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                                }
                                hashMap2.put(str3, createFromFile);
                            }
                        }
                    }
                    String[] split2 = name.split(RemoteSettings.FORWARD_SLASH_STRING);
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (hVar == null) {
                return new i0<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                d0 i10 = i(hVar, (String) entry.getKey());
                if (i10 != null) {
                    i10.f(j.l((Bitmap) entry.getValue(), i10.e(), i10.c()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z10 = false;
                for (b next : hVar.g().values()) {
                    if (next.a().equals(entry2.getKey())) {
                        next.e((Typeface) entry2.getValue());
                        z10 = true;
                    }
                }
                if (!z10) {
                    f.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                for (Map.Entry<String, d0> value : hVar.j().entrySet()) {
                    d0 d0Var = (d0) value.getValue();
                    if (d0Var == null) {
                        return null;
                    }
                    String b10 = d0Var.b();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (b10.startsWith("data:") && b10.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(b10.substring(b10.indexOf(44) + 1), 0);
                            d0Var.f(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e10) {
                            f.d("data URL did not have correct base64 format.", e10);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry next2 : hVar.j().entrySet()) {
                if (((d0) next2.getValue()).a() == null) {
                    return new i0<>((Throwable) new IllegalStateException("There is no image for " + ((d0) next2.getValue()).b()));
                }
            }
            if (str != null) {
                w2.f.b().c(str, hVar);
            }
            return new i0<>(hVar);
            throw th;
        } catch (IOException e11) {
            return new i0<>((Throwable) e11);
        }
    }
}
