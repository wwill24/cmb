package af;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzc;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import me.f;
import me.i;
import me.r;
import me.t;

public class a {

    /* renamed from: r  reason: collision with root package name */
    private static final long f34010r = TimeUnit.DAYS.toMillis(366);

    /* renamed from: s  reason: collision with root package name */
    private static volatile ScheduledExecutorService f34011s = null;

    /* renamed from: t  reason: collision with root package name */
    private static final Object f34012t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static volatile e f34013u = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f34014a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PowerManager.WakeLock f34015b;

    /* renamed from: c  reason: collision with root package name */
    private int f34016c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f34017d;

    /* renamed from: e  reason: collision with root package name */
    private long f34018e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<f> f34019f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private boolean f34020g = true;

    /* renamed from: h  reason: collision with root package name */
    private int f34021h;

    /* renamed from: i  reason: collision with root package name */
    zzb f34022i;

    /* renamed from: j  reason: collision with root package name */
    private f f34023j = i.c();

    /* renamed from: k  reason: collision with root package name */
    private WorkSource f34024k;

    /* renamed from: l  reason: collision with root package name */
    private final String f34025l;

    /* renamed from: m  reason: collision with root package name */
    private final String f34026m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f34027n;

    /* renamed from: o  reason: collision with root package name */
    private final Map<String, d> f34028o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private AtomicInteger f34029p = new AtomicInteger(0);

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledExecutorService f34030q;

    public a(@NonNull Context context, int i10, @NonNull String str) {
        String str2;
        String packageName = context.getPackageName();
        p.l(context, "WakeLock: context must not be null");
        p.h(str, "WakeLock: wakeLockName must not be empty");
        this.f34027n = context.getApplicationContext();
        this.f34026m = str;
        this.f34022i = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "*gcore*:".concat(valueOf);
            } else {
                str2 = new String("*gcore*:");
            }
            this.f34025l = str2;
        } else {
            this.f34025l = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(i10, str);
            this.f34015b = newWakeLock;
            if (t.c(context)) {
                WorkSource b10 = t.b(context, r.b(packageName) ? context.getPackageName() : packageName);
                this.f34024k = b10;
                if (b10 != null) {
                    i(newWakeLock, b10);
                }
            }
            ScheduledExecutorService scheduledExecutorService = f34011s;
            if (scheduledExecutorService == null) {
                synchronized (f34012t) {
                    scheduledExecutorService = f34011s;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f34011s = scheduledExecutorService;
                    }
                }
            }
            this.f34030q = scheduledExecutorService;
            return;
        }
        StringBuilder sb2 = new StringBuilder(29);
        sb2.append("expected a non-null reference", 0, 29);
        throw new zzi(sb2.toString());
    }

    public static /* synthetic */ void e(@NonNull a aVar) {
        synchronized (aVar.f34014a) {
            if (aVar.b()) {
                String.valueOf(aVar.f34025l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **");
                aVar.g();
                if (aVar.b()) {
                    aVar.f34016c = 1;
                    aVar.h(0);
                }
            }
        }
    }

    private final String f(String str) {
        if (this.f34020g) {
            TextUtils.isEmpty((CharSequence) null);
        }
        return null;
    }

    private final void g() {
        if (!this.f34019f.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.f34019f);
            this.f34019f.clear();
            if (arrayList.size() > 0) {
                f fVar = (f) arrayList.get(0);
                throw null;
            }
        }
    }

    private final void h(int i10) {
        synchronized (this.f34014a) {
            if (b()) {
                if (this.f34020g) {
                    int i11 = this.f34016c - 1;
                    this.f34016c = i11;
                    if (i11 > 0) {
                        return;
                    }
                } else {
                    this.f34016c = 0;
                }
                g();
                for (d dVar : this.f34028o.values()) {
                    dVar.f34032a = 0;
                }
                this.f34028o.clear();
                Future<?> future = this.f34017d;
                if (future != null) {
                    future.cancel(false);
                    this.f34017d = null;
                    this.f34018e = 0;
                }
                this.f34021h = 0;
                if (this.f34015b.isHeld()) {
                    try {
                        this.f34015b.release();
                        if (this.f34022i != null) {
                            this.f34022i = null;
                        }
                    } catch (RuntimeException e10) {
                        if (e10.getClass().equals(RuntimeException.class)) {
                            String.valueOf(this.f34025l).concat(" failed to release!");
                            if (this.f34022i != null) {
                                this.f34022i = null;
                            }
                            return;
                        }
                        throw e10;
                    } catch (Throwable th2) {
                        if (this.f34022i != null) {
                            this.f34022i = null;
                        }
                        throw th2;
                    }
                } else {
                    String.valueOf(this.f34025l).concat(" should be held!");
                }
            }
        }
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e10) {
            Log.wtf("WakeLock", e10.toString());
        }
    }

    public void a(long j10) {
        this.f34029p.incrementAndGet();
        long j11 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, f34010r), 1);
        if (j10 > 0) {
            max = Math.min(j10, max);
        }
        synchronized (this.f34014a) {
            if (!b()) {
                this.f34022i = zzb.zza(false, (zzc) null);
                this.f34015b.acquire();
                this.f34023j.b();
            }
            this.f34016c++;
            this.f34021h++;
            f((String) null);
            d dVar = this.f34028o.get((Object) null);
            if (dVar == null) {
                dVar = new d((c) null);
                this.f34028o.put((Object) null, dVar);
            }
            dVar.f34032a++;
            long b10 = this.f34023j.b();
            if (Long.MAX_VALUE - b10 > max) {
                j11 = b10 + max;
            }
            if (j11 > this.f34018e) {
                this.f34018e = j11;
                Future<?> future = this.f34017d;
                if (future != null) {
                    future.cancel(false);
                }
                this.f34017d = this.f34030q.schedule(new b(this), max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f34014a) {
            if (this.f34016c > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void c() {
        if (this.f34029p.decrementAndGet() < 0) {
            String.valueOf(this.f34025l).concat(" release without a matched acquire!");
        }
        synchronized (this.f34014a) {
            f((String) null);
            if (this.f34028o.containsKey((Object) null)) {
                d dVar = this.f34028o.get((Object) null);
                if (dVar != null) {
                    int i10 = dVar.f34032a - 1;
                    dVar.f34032a = i10;
                    if (i10 == 0) {
                        this.f34028o.remove((Object) null);
                    }
                }
            } else {
                String.valueOf(this.f34025l).concat(" counter does not exist");
            }
            h(0);
        }
    }

    public void d(boolean z10) {
        synchronized (this.f34014a) {
            this.f34020g = z10;
        }
    }
}
