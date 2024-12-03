package coil.request;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010*J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\r8\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b\u0018\u0010&¨\u0006+"}, d2 = {"Lcoil/request/n;", "Lcoil/request/h;", "", "other", "", "equals", "", "hashCode", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "drawable", "Lcoil/request/g;", "b", "Lcoil/request/g;", "()Lcoil/request/g;", "request", "Lcoil/decode/DataSource;", "c", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "dataSource", "Lcoil/memory/MemoryCache$Key;", "d", "Lcoil/memory/MemoryCache$Key;", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "memoryCacheKey", "", "e", "Ljava/lang/String;", "getDiskCacheKey", "()Ljava/lang/String;", "diskCacheKey", "f", "Z", "isSampled", "()Z", "g", "isPlaceholderCached", "<init>", "(Landroid/graphics/drawable/Drawable;Lcoil/request/g;Lcoil/decode/DataSource;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class n extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f8384a;

    /* renamed from: b  reason: collision with root package name */
    private final g f8385b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f8386c;

    /* renamed from: d  reason: collision with root package name */
    private final MemoryCache.Key f8387d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8388e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8389f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8390g;

    public n(Drawable drawable, g gVar, DataSource dataSource, MemoryCache.Key key, String str, boolean z10, boolean z11) {
        super((DefaultConstructorMarker) null);
        this.f8384a = drawable;
        this.f8385b = gVar;
        this.f8386c = dataSource;
        this.f8387d = key;
        this.f8388e = str;
        this.f8389f = z10;
        this.f8390g = z11;
    }

    public Drawable a() {
        return this.f8384a;
    }

    public g b() {
        return this.f8385b;
    }

    public final DataSource c() {
        return this.f8386c;
    }

    public final boolean d() {
        return this.f8390g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (!j.b(a(), nVar.a()) || !j.b(b(), nVar.b()) || this.f8386c != nVar.f8386c || !j.b(this.f8387d, nVar.f8387d) || !j.b(this.f8388e, nVar.f8388e) || this.f8389f != nVar.f8389f || this.f8390g != nVar.f8390g) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((((a().hashCode() * 31) + b().hashCode()) * 31) + this.f8386c.hashCode()) * 31;
        MemoryCache.Key key = this.f8387d;
        int i11 = 0;
        if (key != null) {
            i10 = key.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (hashCode + i10) * 31;
        String str = this.f8388e;
        if (str != null) {
            i11 = str.hashCode();
        }
        return ((((i12 + i11) * 31) + Boolean.hashCode(this.f8389f)) * 31) + Boolean.hashCode(this.f8390g);
    }
}
