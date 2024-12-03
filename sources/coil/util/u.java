package coil.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil.RealImageLoader;
import coil.network.b;
import coil.network.c;
import coil.network.d;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001\u000eB\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010'\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0003R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R.\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00138\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010&¨\u0006+"}, d2 = {"Lcoil/util/u;", "Landroid/content/ComponentCallbacks2;", "Lcoil/network/c$a;", "", "c", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "level", "onTrimMemory", "onLowMemory", "", "isOnline", "a", "d", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Ljava/lang/ref/WeakReference;", "Lcoil/RealImageLoader;", "kotlin.jvm.PlatformType", "b", "Ljava/lang/ref/WeakReference;", "getImageLoader$coil_base_release", "()Ljava/lang/ref/WeakReference;", "getImageLoader$coil_base_release$annotations", "()V", "imageLoader", "Lcoil/network/c;", "Lcoil/network/c;", "networkObserver", "Z", "_isOnline", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_isShutdown", "()Z", "isNetworkObserverEnabled", "<init>", "(Lcoil/RealImageLoader;Landroid/content/Context;Z)V", "f", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class u implements ComponentCallbacks2, c.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f8452f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f8453a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<RealImageLoader> f8454b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8455c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f8456d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f8457e;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcoil/util/u$a;", "", "", "OFFLINE", "Ljava/lang/String;", "ONLINE", "TAG", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public u(RealImageLoader realImageLoader, Context context, boolean z10) {
        c cVar;
        this.f8453a = context;
        this.f8454b = new WeakReference<>(realImageLoader);
        if (z10) {
            cVar = d.a(context, this, realImageLoader.g());
        } else {
            cVar = new b();
        }
        this.f8455c = cVar;
        this.f8456d = cVar.a();
        this.f8457e = new AtomicBoolean(false);
    }

    public void a(boolean z10) {
        String str;
        RealImageLoader realImageLoader = this.f8454b.get();
        Unit unit = null;
        if (realImageLoader != null) {
            s g10 = realImageLoader.g();
            if (g10 != null && g10.getLevel() <= 4) {
                if (z10) {
                    str = "ONLINE";
                } else {
                    str = "OFFLINE";
                }
                g10.a("NetworkObserver", 4, str, (Throwable) null);
            }
            this.f8456d = z10;
            unit = Unit.f32013a;
        }
        if (unit == null) {
            d();
        }
    }

    public final boolean b() {
        return this.f8456d;
    }

    public final void c() {
        this.f8453a.registerComponentCallbacks(this);
    }

    public final void d() {
        if (!this.f8457e.getAndSet(true)) {
            this.f8453a.unregisterComponentCallbacks(this);
            this.f8455c.shutdown();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.f8454b.get() == null) {
            d();
            Unit unit = Unit.f32013a;
        }
    }

    public void onLowMemory() {
        onTrimMemory(80);
    }

    public void onTrimMemory(int i10) {
        RealImageLoader realImageLoader = this.f8454b.get();
        Unit unit = null;
        if (realImageLoader != null) {
            s g10 = realImageLoader.g();
            if (g10 != null && g10.getLevel() <= 2) {
                g10.a("NetworkObserver", 2, "trimMemory, level=" + i10, (Throwable) null);
            }
            realImageLoader.k(i10);
            unit = Unit.f32013a;
        }
        if (unit == null) {
            d();
        }
    }
}
