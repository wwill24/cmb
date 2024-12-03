package coil.request;

import android.graphics.Bitmap;
import androidx.lifecycle.Lifecycle;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.h;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineDispatcher;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010)\u001a\u0004\u0018\u00010%\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u0012\b\u00104\u001a\u0004\u0018\u000100\u0012\b\u00107\u001a\u0004\u0018\u00010\u0003\u0012\b\u00108\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010<\u001a\u0004\u0018\u000109\u0012\b\u0010=\u001a\u0004\u0018\u000109\u0012\b\u0010>\u001a\u0004\u0018\u000109¢\u0006\u0004\b?\u0010@J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010!\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001a\u0010\u001dR\u0019\u0010$\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0019\u0010)\u001a\u0004\u0018\u00010%8\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010/\u001a\u0004\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00104\u001a\u0004\u0018\u0001008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b\u0014\u00103R\u0019\u00107\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b-\u00105\u001a\u0004\b\b\u00106R\u0019\u00108\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0016\u00105\u001a\u0004\b\u000e\u00106R\u0019\u0010<\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\b\u0010\u0010:\u001a\u0004\b+\u0010;R\u0019\u0010=\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b\u001f\u0010;R\u0019\u0010>\u001a\u0004\u0018\u0001098\u0006¢\u0006\f\n\u0004\b'\u0010:\u001a\u0004\b1\u0010;¨\u0006A"}, d2 = {"Lcoil/request/b;", "", "other", "", "equals", "", "hashCode", "Landroidx/lifecycle/Lifecycle;", "a", "Landroidx/lifecycle/Lifecycle;", "h", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcoil/size/h;", "b", "Lcoil/size/h;", "m", "()Lcoil/size/h;", "sizeResolver", "Lcoil/size/Scale;", "c", "Lcoil/size/Scale;", "l", "()Lcoil/size/Scale;", "scale", "Lkotlinx/coroutines/CoroutineDispatcher;", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "g", "()Lkotlinx/coroutines/CoroutineDispatcher;", "interceptorDispatcher", "e", "f", "fetcherDispatcher", "decoderDispatcher", "n", "transformationDispatcher", "Lr2/c$a;", "Lr2/c$a;", "o", "()Lr2/c$a;", "transitionFactory", "Lcoil/size/Precision;", "i", "Lcoil/size/Precision;", "k", "()Lcoil/size/Precision;", "precision", "Landroid/graphics/Bitmap$Config;", "j", "Landroid/graphics/Bitmap$Config;", "()Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "allowHardware", "allowRgb565", "Lcoil/request/CachePolicy;", "Lcoil/request/CachePolicy;", "()Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcoil/size/h;Lcoil/size/Scale;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lr2/c$a;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f8286a;

    /* renamed from: b  reason: collision with root package name */
    private final h f8287b;

    /* renamed from: c  reason: collision with root package name */
    private final Scale f8288c;

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineDispatcher f8289d;

    /* renamed from: e  reason: collision with root package name */
    private final CoroutineDispatcher f8290e;

    /* renamed from: f  reason: collision with root package name */
    private final CoroutineDispatcher f8291f;

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineDispatcher f8292g;

    /* renamed from: h  reason: collision with root package name */
    private final c.a f8293h;

    /* renamed from: i  reason: collision with root package name */
    private final Precision f8294i;

    /* renamed from: j  reason: collision with root package name */
    private final Bitmap.Config f8295j;

    /* renamed from: k  reason: collision with root package name */
    private final Boolean f8296k;

    /* renamed from: l  reason: collision with root package name */
    private final Boolean f8297l;

    /* renamed from: m  reason: collision with root package name */
    private final CachePolicy f8298m;

    /* renamed from: n  reason: collision with root package name */
    private final CachePolicy f8299n;

    /* renamed from: o  reason: collision with root package name */
    private final CachePolicy f8300o;

    public b(Lifecycle lifecycle, h hVar, Scale scale, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, c.a aVar, Precision precision, Bitmap.Config config, Boolean bool, Boolean bool2, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f8286a = lifecycle;
        this.f8287b = hVar;
        this.f8288c = scale;
        this.f8289d = coroutineDispatcher;
        this.f8290e = coroutineDispatcher2;
        this.f8291f = coroutineDispatcher3;
        this.f8292g = coroutineDispatcher4;
        this.f8293h = aVar;
        this.f8294i = precision;
        this.f8295j = config;
        this.f8296k = bool;
        this.f8297l = bool2;
        this.f8298m = cachePolicy;
        this.f8299n = cachePolicy2;
        this.f8300o = cachePolicy3;
    }

    public final Boolean a() {
        return this.f8296k;
    }

    public final Boolean b() {
        return this.f8297l;
    }

    public final Bitmap.Config c() {
        return this.f8295j;
    }

    public final CoroutineDispatcher d() {
        return this.f8291f;
    }

    public final CachePolicy e() {
        return this.f8299n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (!j.b(this.f8286a, bVar.f8286a) || !j.b(this.f8287b, bVar.f8287b) || this.f8288c != bVar.f8288c || !j.b(this.f8289d, bVar.f8289d) || !j.b(this.f8290e, bVar.f8290e) || !j.b(this.f8291f, bVar.f8291f) || !j.b(this.f8292g, bVar.f8292g) || !j.b(this.f8293h, bVar.f8293h) || this.f8294i != bVar.f8294i || this.f8295j != bVar.f8295j || !j.b(this.f8296k, bVar.f8296k) || !j.b(this.f8297l, bVar.f8297l) || this.f8298m != bVar.f8298m || this.f8299n != bVar.f8299n || this.f8300o != bVar.f8300o) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final CoroutineDispatcher f() {
        return this.f8290e;
    }

    public final CoroutineDispatcher g() {
        return this.f8289d;
    }

    public final Lifecycle h() {
        return this.f8286a;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Lifecycle lifecycle = this.f8286a;
        int i24 = 0;
        if (lifecycle != null) {
            i10 = lifecycle.hashCode();
        } else {
            i10 = 0;
        }
        int i25 = i10 * 31;
        h hVar = this.f8287b;
        if (hVar != null) {
            i11 = hVar.hashCode();
        } else {
            i11 = 0;
        }
        int i26 = (i25 + i11) * 31;
        Scale scale = this.f8288c;
        if (scale != null) {
            i12 = scale.hashCode();
        } else {
            i12 = 0;
        }
        int i27 = (i26 + i12) * 31;
        CoroutineDispatcher coroutineDispatcher = this.f8289d;
        if (coroutineDispatcher != null) {
            i13 = coroutineDispatcher.hashCode();
        } else {
            i13 = 0;
        }
        int i28 = (i27 + i13) * 31;
        CoroutineDispatcher coroutineDispatcher2 = this.f8290e;
        if (coroutineDispatcher2 != null) {
            i14 = coroutineDispatcher2.hashCode();
        } else {
            i14 = 0;
        }
        int i29 = (i28 + i14) * 31;
        CoroutineDispatcher coroutineDispatcher3 = this.f8291f;
        if (coroutineDispatcher3 != null) {
            i15 = coroutineDispatcher3.hashCode();
        } else {
            i15 = 0;
        }
        int i30 = (i29 + i15) * 31;
        CoroutineDispatcher coroutineDispatcher4 = this.f8292g;
        if (coroutineDispatcher4 != null) {
            i16 = coroutineDispatcher4.hashCode();
        } else {
            i16 = 0;
        }
        int i31 = (i30 + i16) * 31;
        c.a aVar = this.f8293h;
        if (aVar != null) {
            i17 = aVar.hashCode();
        } else {
            i17 = 0;
        }
        int i32 = (i31 + i17) * 31;
        Precision precision = this.f8294i;
        if (precision != null) {
            i18 = precision.hashCode();
        } else {
            i18 = 0;
        }
        int i33 = (i32 + i18) * 31;
        Bitmap.Config config = this.f8295j;
        if (config != null) {
            i19 = config.hashCode();
        } else {
            i19 = 0;
        }
        int i34 = (i33 + i19) * 31;
        Boolean bool = this.f8296k;
        if (bool != null) {
            i20 = bool.hashCode();
        } else {
            i20 = 0;
        }
        int i35 = (i34 + i20) * 31;
        Boolean bool2 = this.f8297l;
        if (bool2 != null) {
            i21 = bool2.hashCode();
        } else {
            i21 = 0;
        }
        int i36 = (i35 + i21) * 31;
        CachePolicy cachePolicy = this.f8298m;
        if (cachePolicy != null) {
            i22 = cachePolicy.hashCode();
        } else {
            i22 = 0;
        }
        int i37 = (i36 + i22) * 31;
        CachePolicy cachePolicy2 = this.f8299n;
        if (cachePolicy2 != null) {
            i23 = cachePolicy2.hashCode();
        } else {
            i23 = 0;
        }
        int i38 = (i37 + i23) * 31;
        CachePolicy cachePolicy3 = this.f8300o;
        if (cachePolicy3 != null) {
            i24 = cachePolicy3.hashCode();
        }
        return i38 + i24;
    }

    public final CachePolicy i() {
        return this.f8298m;
    }

    public final CachePolicy j() {
        return this.f8300o;
    }

    public final Precision k() {
        return this.f8294i;
    }

    public final Scale l() {
        return this.f8288c;
    }

    public final h m() {
        return this.f8287b;
    }

    public final CoroutineDispatcher n() {
        return this.f8292g;
    }

    public final c.a o() {
        return this.f8293h;
    }
}
