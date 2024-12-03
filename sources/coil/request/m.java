package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.size.Scale;
import coil.size.c;
import coil.size.g;
import coil.util.a;
import coil.util.f;
import coil.util.h;
import coil.util.j;
import coil.util.o;
import coil.util.s;
import coil.util.u;
import kotlin.Metadata;
import kotlinx.coroutines.s1;
import p2.b;

@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0007R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010 ¨\u0006&"}, d2 = {"Lcoil/request/m;", "", "Lcoil/request/g;", "request", "Lcoil/size/g;", "size", "", "d", "e", "initialRequest", "Lkotlinx/coroutines/s1;", "job", "Lcoil/request/RequestDelegate;", "g", "", "throwable", "Lcoil/request/d;", "b", "Lcoil/request/k;", "f", "Landroid/graphics/Bitmap$Config;", "requestedConfig", "c", "options", "a", "Lcoil/ImageLoader;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/util/u;", "Lcoil/util/u;", "systemCallbacks", "Lcoil/util/o;", "Lcoil/util/o;", "hardwareBitmapService", "Lcoil/util/s;", "logger", "<init>", "(Lcoil/ImageLoader;Lcoil/util/u;Lcoil/util/s;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f8381a;

    /* renamed from: b  reason: collision with root package name */
    private final u f8382b;

    /* renamed from: c  reason: collision with root package name */
    private final o f8383c;

    public m(ImageLoader imageLoader, u uVar, s sVar) {
        this.f8381a = imageLoader;
        this.f8382b = uVar;
        this.f8383c = f.a(sVar);
    }

    private final boolean d(g gVar, g gVar2) {
        if (!c(gVar, gVar.j()) || !this.f8383c.a(gVar2)) {
            return false;
        }
        return true;
    }

    private final boolean e(g gVar) {
        if (gVar.O().isEmpty() || l.v(j.p(), gVar.j())) {
            return true;
        }
        return false;
    }

    public final boolean a(k kVar) {
        return !a.d(kVar.f()) || this.f8383c.b();
    }

    public final d b(g gVar, Throwable th2) {
        Drawable drawable;
        if (th2 instanceof NullRequestDataException) {
            drawable = gVar.u();
            if (drawable == null) {
                drawable = gVar.t();
            }
        } else {
            drawable = gVar.t();
        }
        return new d(drawable, gVar, th2);
    }

    public final boolean c(g gVar, Bitmap.Config config) {
        boolean z10;
        if (!a.d(config)) {
            return true;
        }
        if (!gVar.h()) {
            return false;
        }
        p2.a M = gVar.M();
        if (M instanceof b) {
            View view = ((b) M).getView();
            if (!view.isAttachedToWindow() || view.isHardwareAccelerated()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return false;
            }
        }
        return true;
    }

    public final k f(g gVar, g gVar2) {
        boolean z10;
        Bitmap.Config config;
        CachePolicy cachePolicy;
        boolean z11;
        Scale scale;
        if (!e(gVar) || !d(gVar, gVar2)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            config = gVar.j();
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap.Config config2 = config;
        if (this.f8382b.b()) {
            cachePolicy = gVar.D();
        } else {
            cachePolicy = CachePolicy.DISABLED;
        }
        CachePolicy cachePolicy2 = cachePolicy;
        if (!gVar.i() || !gVar.O().isEmpty() || config2 == Bitmap.Config.ALPHA_8) {
            z11 = false;
        } else {
            z11 = true;
        }
        c d10 = gVar2.d();
        c.b bVar = c.b.f8408a;
        if (kotlin.jvm.internal.j.b(d10, bVar) || kotlin.jvm.internal.j.b(gVar2.c(), bVar)) {
            scale = Scale.FIT;
        } else {
            scale = gVar.J();
        }
        return new k(gVar.l(), config2, gVar.k(), gVar2, scale, h.a(gVar), z11, gVar.I(), gVar.r(), gVar.x(), gVar.L(), gVar.E(), gVar.C(), gVar.s(), cachePolicy2);
    }

    public final RequestDelegate g(g gVar, s1 s1Var) {
        Lifecycle z10 = gVar.z();
        p2.a M = gVar.M();
        if (!(M instanceof b)) {
            return new BaseRequestDelegate(z10, s1Var);
        }
        return new ViewTargetRequestDelegate(this.f8381a, gVar, (b) M, z10, s1Var);
    }
}
