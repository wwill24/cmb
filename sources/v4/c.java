package v4;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.LruCache;
import com.clevertap.android.sdk.p;
import java.io.File;
import java.security.MessageDigest;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18066a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f18067b;

    /* renamed from: c  reason: collision with root package name */
    private static LruCache<String, Bitmap> f18068c;

    /* renamed from: d  reason: collision with root package name */
    private static File f18069d;

    /* renamed from: e  reason: collision with root package name */
    private static MessageDigest f18070e;

    class a extends LruCache<String, Bitmap> {
        a(int i10) {
            super(i10);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            int a10 = c.h(bitmap);
            p.o("CleverTap.ImageCache: have image of size: " + a10 + "KB for key: " + str);
            return a10;
        }
    }

    static {
        int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / 1024;
        f18066a = maxMemory;
        f18067b = Math.max(maxMemory / 32, 20480);
    }

    public static boolean b(String str, Bitmap bitmap) {
        if (f18068c == null) {
            return false;
        }
        if (f(str) != null) {
            return true;
        }
        synchronized (c.class) {
            int h10 = h(bitmap);
            int d10 = d();
            p.o("CleverTap.ImageCache: image size: " + h10 + "KB. Available mem: " + d10 + "KB.");
            if (h10 > d()) {
                p.o("CleverTap.ImageCache: insufficient memory to add image: " + str);
                return false;
            }
            f18068c.put(str, bitmap);
            p.o("CleverTap.ImageCache: added image for key: " + str);
            return true;
        }
    }

    private static void c() {
        synchronized (c.class) {
            if (j()) {
                p.o("CTInAppNotification.ImageCache: cache is empty, removing it");
                f18068c = null;
            }
        }
    }

    private static int d() {
        int i10;
        synchronized (c.class) {
            LruCache<String, Bitmap> lruCache = f18068c;
            if (lruCache == null) {
                i10 = 0;
            } else {
                i10 = f18067b - lruCache.size();
            }
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap e(java.lang.String r3) {
        /*
            java.lang.Class<v4.c> r0 = v4.c.class
            monitor-enter(r0)
            r1 = 0
            if (r3 == 0) goto L_0x0014
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r2 = f18068c     // Catch:{ all -> 0x0016 }
            if (r2 != 0) goto L_0x000b
            goto L_0x0012
        L_0x000b:
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0016 }
            r1 = r3
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1     // Catch:{ all -> 0x0016 }
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r1
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r1
        L_0x0016:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.c.e(java.lang.String):android.graphics.Bitmap");
    }

    private static Bitmap f(String str) {
        LruCache<String, Bitmap> lruCache;
        if (str == null || (lruCache = f18068c) == null) {
            return null;
        }
        return lruCache.get(str);
    }

    private static File g(String str) {
        MessageDigest messageDigest = f18070e;
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        return new File(f18069d, "CT_IMAGE_" + Base64.encodeToString(digest, 10));
    }

    /* access modifiers changed from: private */
    public static int h(Bitmap bitmap) {
        return bitmap.getByteCount() / 1024;
    }

    public static void i() {
        synchronized (c.class) {
            if (f18068c == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CleverTap.ImageCache: init with max device memory: ");
                sb2.append(f18066a);
                sb2.append("KB and allocated cache size: ");
                int i10 = f18067b;
                sb2.append(i10);
                sb2.append("KB");
                p.o(sb2.toString());
                try {
                    f18068c = new a(i10);
                } catch (Throwable th2) {
                    p.r("CleverTap.ImageCache: unable to initialize cache: ", th2.getCause());
                }
            }
        }
    }

    private static boolean j() {
        boolean z10;
        synchronized (c.class) {
            if (f18068c.size() <= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public static void k(String str, boolean z10) {
        synchronized (c.class) {
            if (z10) {
                l(str);
            }
            LruCache<String, Bitmap> lruCache = f18068c;
            if (lruCache != null) {
                lruCache.remove(str);
                p.o("CleverTap.ImageCache: removed image for key: " + str);
                c();
            }
        }
    }

    private static void l(String str) {
        File g10 = g(str);
        if (g10 != null && g10.exists()) {
            g10.delete();
        }
    }
}
