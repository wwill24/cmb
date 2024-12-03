package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.f;
import coil.b;
import coil.decode.DataSource;
import coil.disk.a;
import coil.intercept.RealInterceptorChain;
import coil.intercept.a;
import coil.request.l;
import coil.request.p;
import coil.size.Scale;
import coil.size.c;
import com.google.android.gms.common.api.a;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.s;

@Metadata(bv = {}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u000e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0000\u001a\u000e\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000\u001a\u000e\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0000\u001a\b\u0010\u000e\u001a\u00020\rH\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u000f*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0012H\u0000\u001a\f\u0010\u0014\u001a\u00020\r*\u00020\u000fH\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u000f*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000\u001a\u0014\u0010\u001e\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!H\u0000\" \u0010*\u001a\b\u0012\u0004\u0012\u00020&0%8\u0000X\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u001a\u0010.\u001a\u00020&8\u0000X\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010-\"\u001a\u00102\u001a\u00020\u00078\u0000X\u0004¢\u0006\f\n\u0004\b$\u0010/\u001a\u0004\b0\u00101\"\u0018\u00107\u001a\u000204*\u0002038@X\u0004¢\u0006\u0006\u001a\u0004\b5\u00106\"\u0018\u0010;\u001a\u00020\u0004*\u0002088@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:\"\u0018\u0010?\u001a\u00020\u000f*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>\"\u0018\u0010A\u001a\u00020\u000f*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>\"\u0018\u0010D\u001a\u00020\r*\u00020<8@X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\"\u0018\u0010\u0017\u001a\u00020\u0016*\u00020E8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G\"\u001a\u0010J\u001a\u0004\u0018\u00010\u0004*\u00020\u00198@X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I\"\u0018\u0010N\u001a\u00020\u000f*\u00020K8@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010M\"\u0018\u0010R\u001a\u00020O*\u00020\u001f8@X\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q\"\u0018\u0010V\u001a\u00020\r*\u00020S8@X\u0004¢\u0006\u0006\u001a\u0004\bT\u0010U\"\u0018\u0010Z\u001a\u00020W*\u00020S8@X\u0004¢\u0006\u0006\u001a\u0004\bX\u0010Y¨\u0006["}, d2 = {"Ljava/io/Closeable;", "", "d", "Landroid/webkit/MimeTypeMap;", "", "url", "k", "Lokhttp3/s;", "y", "Lcoil/request/p;", "x", "Lcoil/request/l;", "w", "", "s", "", "defaultValue", "z", "Lcoil/disk/a$b;", "a", "t", "Lcoil/size/c;", "Lcoil/size/Scale;", "scale", "A", "Landroid/net/Uri;", "uri", "r", "Lokhttp3/s$a;", "line", "b", "Landroid/content/Context;", "context", "", "e", "percent", "c", "", "Landroid/graphics/Bitmap$Config;", "[Landroid/graphics/Bitmap$Config;", "p", "()[Landroid/graphics/Bitmap$Config;", "VALID_TRANSFORMATION_CONFIGS", "Landroid/graphics/Bitmap$Config;", "f", "()Landroid/graphics/Bitmap$Config;", "DEFAULT_BITMAP_CONFIG", "Lokhttp3/s;", "getEMPTY_HEADERS", "()Lokhttp3/s;", "EMPTY_HEADERS", "Landroid/view/View;", "Lcoil/request/ViewTargetRequestManager;", "m", "(Landroid/view/View;)Lcoil/request/ViewTargetRequestManager;", "requestManager", "Lcoil/decode/DataSource;", "g", "(Lcoil/decode/DataSource;)Ljava/lang/String;", "emoji", "Landroid/graphics/drawable/Drawable;", "q", "(Landroid/graphics/drawable/Drawable;)I", "width", "j", "height", "v", "(Landroid/graphics/drawable/Drawable;)Z", "isVector", "Landroid/widget/ImageView;", "o", "(Landroid/widget/ImageView;)Lcoil/size/Scale;", "i", "(Landroid/net/Uri;)Ljava/lang/String;", "firstPathSegment", "Landroid/content/res/Configuration;", "l", "(Landroid/content/res/Configuration;)I", "nightMode", "Ljava/io/File;", "n", "(Landroid/content/Context;)Ljava/io/File;", "safeCacheDir", "Lcoil/intercept/a$a;", "u", "(Lcoil/intercept/a$a;)Z", "isPlaceholderCached", "Lcoil/b;", "h", "(Lcoil/intercept/a$a;)Lcoil/b;", "eventListener", "coil-base_release"}, k = 2, mv = {1, 7, 1})
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f8427a;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config f8428b;

    /* renamed from: c  reason: collision with root package name */
    private static final s f8429c = new s.a().f();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8430a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f8431b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f8432c;

        static {
            int[] iArr = new int[DataSource.values().length];
            iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            iArr[DataSource.MEMORY.ordinal()] = 2;
            iArr[DataSource.DISK.ordinal()] = 3;
            iArr[DataSource.NETWORK.ordinal()] = 4;
            f8430a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            f8431b = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            iArr3[Scale.FILL.ordinal()] = 1;
            iArr3[Scale.FIT.ordinal()] = 2;
            f8432c = iArr3;
        }
    }

    static {
        Bitmap.Config config;
        int i10 = Build.VERSION.SDK_INT;
        f8427a = i10 >= 26 ? new Bitmap.Config[]{Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16} : new Bitmap.Config[]{Bitmap.Config.ARGB_8888};
        if (i10 >= 26) {
            config = Bitmap.Config.HARDWARE;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        f8428b = config;
    }

    public static final int A(c cVar, Scale scale) {
        if (cVar instanceof c.a) {
            return ((c.a) cVar).f8407a;
        }
        int i10 = a.f8432c[scale.ordinal()];
        if (i10 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i10 == 2) {
            return a.e.API_PRIORITY_OTHER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(a.b bVar) {
        try {
            bVar.abort();
        } catch (Exception unused) {
        }
    }

    public static final s.a b(s.a aVar, String str) {
        boolean z10;
        int a02 = StringsKt__StringsKt.a0(str, ':', 0, false, 6, (Object) null);
        if (a02 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String substring = str.substring(0, a02);
            kotlin.jvm.internal.j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String obj = StringsKt__StringsKt.W0(substring).toString();
            String substring2 = str.substring(a02 + 1);
            kotlin.jvm.internal.j.f(substring2, "this as java.lang.String).substring(startIndex)");
            aVar.e(obj, substring2);
            return aVar;
        }
        throw new IllegalArgumentException(("Unexpected header: " + str).toString());
    }

    public static final int c(Context context, double d10) {
        int i10;
        boolean z10;
        try {
            Object systemService = androidx.core.content.a.getSystemService(context, ActivityManager.class);
            kotlin.jvm.internal.j.d(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            if ((context.getApplicationInfo().flags & 1048576) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = activityManager.getLargeMemoryClass();
            } else {
                i10 = activityManager.getMemoryClass();
            }
        } catch (Exception unused) {
            i10 = 256;
        }
        double d11 = (double) 1024;
        return (int) (d10 * ((double) i10) * d11 * d11);
    }

    public static final void d(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final double e(Context context) {
        try {
            Object systemService = androidx.core.content.a.getSystemService(context, ActivityManager.class);
            kotlin.jvm.internal.j.d(systemService);
            if (((ActivityManager) systemService).isLowRamDevice()) {
                return 0.15d;
            }
            return 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final Bitmap.Config f() {
        return f8428b;
    }

    public static final String g(DataSource dataSource) {
        int i10 = a.f8430a[dataSource.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return "🧠";
        }
        if (i10 == 3) {
            return "💾";
        }
        if (i10 == 4) {
            return "☁️ ";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final b h(a.C0104a aVar) {
        return aVar instanceof RealInterceptorChain ? ((RealInterceptorChain) aVar).e() : b.f8061b;
    }

    public static final String i(Uri uri) {
        return (String) CollectionsKt___CollectionsKt.P(uri.getPathSegments());
    }

    public static final int j(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final String k(MimeTypeMap mimeTypeMap, String str) {
        boolean z10;
        if (str == null || r.w(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt__StringsKt.O0(StringsKt__StringsKt.P0(StringsKt__StringsKt.V0(StringsKt__StringsKt.V0(str, '#', (String) null, 2, (Object) null), '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null), '.', ""));
    }

    public static final int l(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: coil.request.ViewTargetRequestManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final coil.request.ViewTargetRequestManager m(android.view.View r4) {
        /*
            int r0 = k2.a.coil_request_manager
            java.lang.Object r1 = r4.getTag(r0)
            boolean r2 = r1 instanceof coil.request.ViewTargetRequestManager
            r3 = 0
            if (r2 == 0) goto L_0x000e
            coil.request.ViewTargetRequestManager r1 = (coil.request.ViewTargetRequestManager) r1
            goto L_0x000f
        L_0x000e:
            r1 = r3
        L_0x000f:
            if (r1 != 0) goto L_0x0031
            monitor-enter(r4)
            java.lang.Object r1 = r4.getTag(r0)     // Catch:{ all -> 0x002e }
            boolean r2 = r1 instanceof coil.request.ViewTargetRequestManager     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x001d
            r3 = r1
            coil.request.ViewTargetRequestManager r3 = (coil.request.ViewTargetRequestManager) r3     // Catch:{ all -> 0x002e }
        L_0x001d:
            if (r3 == 0) goto L_0x0021
            r1 = r3
            goto L_0x002c
        L_0x0021:
            coil.request.ViewTargetRequestManager r1 = new coil.request.ViewTargetRequestManager     // Catch:{ all -> 0x002e }
            r1.<init>(r4)     // Catch:{ all -> 0x002e }
            r4.addOnAttachStateChangeListener(r1)     // Catch:{ all -> 0x002e }
            r4.setTag(r0, r1)     // Catch:{ all -> 0x002e }
        L_0x002c:
            monitor-exit(r4)
            goto L_0x0031
        L_0x002e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.j.m(android.view.View):coil.request.ViewTargetRequestManager");
    }

    public static final File n(Context context) {
        File cacheDir = context.getCacheDir();
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final Scale o(ImageView imageView) {
        int i10;
        ImageView.ScaleType scaleType = imageView.getScaleType();
        if (scaleType == null) {
            i10 = -1;
        } else {
            i10 = a.f8431b[scaleType.ordinal()];
        }
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            return Scale.FIT;
        }
        return Scale.FILL;
    }

    public static final Bitmap.Config[] p() {
        return f8427a;
    }

    public static final int q(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean r(Uri uri) {
        return kotlin.jvm.internal.j.b(uri.getScheme(), "file") && kotlin.jvm.internal.j.b(i(uri), "android_asset");
    }

    public static final boolean s() {
        return kotlin.jvm.internal.j.b(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean t(int i10) {
        return i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE;
    }

    public static final boolean u(a.C0104a aVar) {
        return (aVar instanceof RealInterceptorChain) && ((RealInterceptorChain) aVar).f();
    }

    public static final boolean v(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof f);
    }

    public static final l w(l lVar) {
        return lVar == null ? l.f8376c : lVar;
    }

    public static final p x(p pVar) {
        return pVar == null ? p.f8392c : pVar;
    }

    public static final s y(s sVar) {
        return sVar == null ? f8429c : sVar;
    }

    public static final int z(String str, int i10) {
        Long l10 = q.l(str);
        if (l10 == null) {
            return i10;
        }
        long longValue = l10.longValue();
        if (longValue > 2147483647L) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }
}
