package m3;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class j implements d {

    /* renamed from: k  reason: collision with root package name */
    private static final Bitmap.Config f16301k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final k f16302a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f16303b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16304c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16305d;

    /* renamed from: e  reason: collision with root package name */
    private long f16306e;

    /* renamed from: f  reason: collision with root package name */
    private long f16307f;

    /* renamed from: g  reason: collision with root package name */
    private int f16308g;

    /* renamed from: h  reason: collision with root package name */
    private int f16309h;

    /* renamed from: i  reason: collision with root package name */
    private int f16310i;

    /* renamed from: j  reason: collision with root package name */
    private int f16311j;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements a {
        b() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    j(long j10, k kVar, Set<Bitmap.Config> set) {
        this.f16304c = j10;
        this.f16306e = j10;
        this.f16302a = kVar;
        this.f16303b = set;
        this.f16305d = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap g(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f16301k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Hits=");
        sb2.append(this.f16308g);
        sb2.append(", misses=");
        sb2.append(this.f16309h);
        sb2.append(", puts=");
        sb2.append(this.f16310i);
        sb2.append(", evictions=");
        sb2.append(this.f16311j);
        sb2.append(", currentSize=");
        sb2.append(this.f16307f);
        sb2.append(", maxSize=");
        sb2.append(this.f16306e);
        sb2.append("\nStrategy=");
        sb2.append(this.f16302a);
    }

    private void j() {
        q(this.f16306e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static k l() {
        return new m();
    }

    private synchronized Bitmap m(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap d10;
        f(config);
        k kVar = this.f16302a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f16301k;
        }
        d10 = kVar.d(i10, i11, config2);
        if (d10 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing bitmap=");
                sb2.append(this.f16302a.b(i10, i11, config));
            }
            this.f16309h++;
        } else {
            this.f16308g++;
            this.f16307f -= (long) this.f16302a.e(d10);
            this.f16305d.a(d10);
            p(d10);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Get bitmap=");
            sb3.append(this.f16302a.b(i10, i11, config));
        }
        h();
        return d10;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j10) {
        while (this.f16307f > j10) {
            Bitmap removeLast = this.f16302a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    i();
                }
                this.f16307f = 0;
                return;
            }
            this.f16305d.a(removeLast);
            this.f16307f -= (long) this.f16302a.e(removeLast);
            this.f16311j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Evicting bitmap=");
                sb2.append(this.f16302a.a(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("trimMemory, level=");
            sb2.append(i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            q(n() / 2);
        }
    }

    public void b() {
        Log.isLoggable("LruBitmapPool", 3);
        q(0);
    }

    public synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f16302a.e(bitmap)) <= this.f16306e) {
                        if (this.f16303b.contains(bitmap.getConfig())) {
                            int e10 = this.f16302a.e(bitmap);
                            this.f16302a.c(bitmap);
                            this.f16305d.b(bitmap);
                            this.f16310i++;
                            this.f16307f += (long) e10;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Put bitmap in pool=");
                                sb2.append(this.f16302a.a(bitmap));
                            }
                            h();
                            j();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Reject bitmap from pool, bitmap: ");
                        sb3.append(this.f16302a.a(bitmap));
                        sb3.append(", is mutable: ");
                        sb3.append(bitmap.isMutable());
                        sb3.append(", is allowed config: ");
                        sb3.append(this.f16303b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    @NonNull
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        if (m10 == null) {
            return g(i10, i11, config);
        }
        m10.eraseColor(0);
        return m10;
    }

    @NonNull
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        if (m10 == null) {
            return g(i10, i11, config);
        }
        return m10;
    }

    public long n() {
        return this.f16306e;
    }

    public j(long j10) {
        this(j10, l(), k());
    }
}
