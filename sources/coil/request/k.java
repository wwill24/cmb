package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import coil.size.Scale;
import coil.size.g;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.s;

@Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b*\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\bG\u0010HJ \u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0018J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b*\u00100\u001a\u0004\b1\u00102R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b&\u00103\u001a\u0004\b(\u00104R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b,\u00104R\u0017\u0010\u000f\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b5\u00103\u001a\u0004\b6\u00104R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00109R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b:\u0010<R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bA\u0010CR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b6\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u001a\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b1\u0010D\u001a\u0004\b7\u0010FR\u0017\u0010\u001b\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b.\u0010D\u001a\u0004\b=\u0010F¨\u0006I"}, d2 = {"Lcoil/request/k;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/ColorSpace;", "colorSpace", "Lcoil/size/g;", "size", "Lcoil/size/Scale;", "scale", "", "allowInexactSize", "allowRgb565", "premultipliedAlpha", "", "diskCacheKey", "Lokhttp3/s;", "headers", "Lcoil/request/p;", "tags", "Lcoil/request/l;", "parameters", "Lcoil/request/CachePolicy;", "memoryCachePolicy", "diskCachePolicy", "networkCachePolicy", "a", "other", "equals", "", "hashCode", "Landroid/content/Context;", "g", "()Landroid/content/Context;", "b", "Landroid/graphics/Bitmap$Config;", "f", "()Landroid/graphics/Bitmap$Config;", "c", "Landroid/graphics/ColorSpace;", "e", "()Landroid/graphics/ColorSpace;", "d", "Lcoil/size/g;", "o", "()Lcoil/size/g;", "Lcoil/size/Scale;", "n", "()Lcoil/size/Scale;", "Z", "()Z", "h", "m", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "Lokhttp3/s;", "()Lokhttp3/s;", "k", "Lcoil/request/p;", "p", "()Lcoil/request/p;", "l", "Lcoil/request/l;", "()Lcoil/request/l;", "Lcoil/request/CachePolicy;", "getMemoryCachePolicy", "()Lcoil/request/CachePolicy;", "<init>", "(Landroid/content/Context;Landroid/graphics/Bitmap$Config;Landroid/graphics/ColorSpace;Lcoil/size/g;Lcoil/size/Scale;ZZZLjava/lang/String;Lokhttp3/s;Lcoil/request/p;Lcoil/request/l;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8360a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap.Config f8361b;

    /* renamed from: c  reason: collision with root package name */
    private final ColorSpace f8362c;

    /* renamed from: d  reason: collision with root package name */
    private final g f8363d;

    /* renamed from: e  reason: collision with root package name */
    private final Scale f8364e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8365f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8366g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f8367h;

    /* renamed from: i  reason: collision with root package name */
    private final String f8368i;

    /* renamed from: j  reason: collision with root package name */
    private final s f8369j;

    /* renamed from: k  reason: collision with root package name */
    private final p f8370k;

    /* renamed from: l  reason: collision with root package name */
    private final l f8371l;

    /* renamed from: m  reason: collision with root package name */
    private final CachePolicy f8372m;

    /* renamed from: n  reason: collision with root package name */
    private final CachePolicy f8373n;

    /* renamed from: o  reason: collision with root package name */
    private final CachePolicy f8374o;

    public k(Context context, Bitmap.Config config, ColorSpace colorSpace, g gVar, Scale scale, boolean z10, boolean z11, boolean z12, String str, s sVar, p pVar, l lVar, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        this.f8360a = context;
        this.f8361b = config;
        this.f8362c = colorSpace;
        this.f8363d = gVar;
        this.f8364e = scale;
        this.f8365f = z10;
        this.f8366g = z11;
        this.f8367h = z12;
        this.f8368i = str;
        this.f8369j = sVar;
        this.f8370k = pVar;
        this.f8371l = lVar;
        this.f8372m = cachePolicy;
        this.f8373n = cachePolicy2;
        this.f8374o = cachePolicy3;
    }

    public static /* synthetic */ k b(k kVar, Context context, Bitmap.Config config, ColorSpace colorSpace, g gVar, Scale scale, boolean z10, boolean z11, boolean z12, String str, s sVar, p pVar, l lVar, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, int i10, Object obj) {
        k kVar2 = kVar;
        int i11 = i10;
        return kVar.a((i11 & 1) != 0 ? kVar2.f8360a : context, (i11 & 2) != 0 ? kVar2.f8361b : config, (i11 & 4) != 0 ? kVar2.f8362c : colorSpace, (i11 & 8) != 0 ? kVar2.f8363d : gVar, (i11 & 16) != 0 ? kVar2.f8364e : scale, (i11 & 32) != 0 ? kVar2.f8365f : z10, (i11 & 64) != 0 ? kVar2.f8366g : z11, (i11 & 128) != 0 ? kVar2.f8367h : z12, (i11 & 256) != 0 ? kVar2.f8368i : str, (i11 & 512) != 0 ? kVar2.f8369j : sVar, (i11 & 1024) != 0 ? kVar2.f8370k : pVar, (i11 & 2048) != 0 ? kVar2.f8371l : lVar, (i11 & Opcodes.ACC_SYNTHETIC) != 0 ? kVar2.f8372m : cachePolicy, (i11 & 8192) != 0 ? kVar2.f8373n : cachePolicy2, (i11 & Opcodes.ACC_ENUM) != 0 ? kVar2.f8374o : cachePolicy3);
    }

    public final k a(Context context, Bitmap.Config config, ColorSpace colorSpace, g gVar, Scale scale, boolean z10, boolean z11, boolean z12, String str, s sVar, p pVar, l lVar, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3) {
        return new k(context, config, colorSpace, gVar, scale, z10, z11, z12, str, sVar, pVar, lVar, cachePolicy, cachePolicy2, cachePolicy3);
    }

    public final boolean c() {
        return this.f8365f;
    }

    public final boolean d() {
        return this.f8366g;
    }

    public final ColorSpace e() {
        return this.f8362c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (j.b(this.f8360a, kVar.f8360a) && this.f8361b == kVar.f8361b && ((Build.VERSION.SDK_INT < 26 || j.b(this.f8362c, kVar.f8362c)) && j.b(this.f8363d, kVar.f8363d) && this.f8364e == kVar.f8364e && this.f8365f == kVar.f8365f && this.f8366g == kVar.f8366g && this.f8367h == kVar.f8367h && j.b(this.f8368i, kVar.f8368i) && j.b(this.f8369j, kVar.f8369j) && j.b(this.f8370k, kVar.f8370k) && j.b(this.f8371l, kVar.f8371l) && this.f8372m == kVar.f8372m && this.f8373n == kVar.f8373n && this.f8374o == kVar.f8374o)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final Bitmap.Config f() {
        return this.f8361b;
    }

    public final Context g() {
        return this.f8360a;
    }

    public final String h() {
        return this.f8368i;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f8360a.hashCode() * 31) + this.f8361b.hashCode()) * 31;
        ColorSpace colorSpace = this.f8362c;
        int i11 = 0;
        if (colorSpace != null) {
            i10 = colorSpace.hashCode();
        } else {
            i10 = 0;
        }
        int hashCode2 = (((((((((((hashCode + i10) * 31) + this.f8363d.hashCode()) * 31) + this.f8364e.hashCode()) * 31) + Boolean.hashCode(this.f8365f)) * 31) + Boolean.hashCode(this.f8366g)) * 31) + Boolean.hashCode(this.f8367h)) * 31;
        String str = this.f8368i;
        if (str != null) {
            i11 = str.hashCode();
        }
        return ((((((((((((hashCode2 + i11) * 31) + this.f8369j.hashCode()) * 31) + this.f8370k.hashCode()) * 31) + this.f8371l.hashCode()) * 31) + this.f8372m.hashCode()) * 31) + this.f8373n.hashCode()) * 31) + this.f8374o.hashCode();
    }

    public final CachePolicy i() {
        return this.f8373n;
    }

    public final s j() {
        return this.f8369j;
    }

    public final CachePolicy k() {
        return this.f8374o;
    }

    public final l l() {
        return this.f8371l;
    }

    public final boolean m() {
        return this.f8367h;
    }

    public final Scale n() {
        return this.f8364e;
    }

    public final g o() {
        return this.f8363d;
    }

    public final p p() {
        return this.f8370k;
    }
}
