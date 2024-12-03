package o2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.d;
import coil.intercept.EngineInterceptor;
import coil.intercept.a;
import coil.memory.MemoryCache;
import coil.request.g;
import coil.request.k;
import coil.request.m;
import coil.request.n;
import coil.size.Scale;
import coil.size.b;
import coil.size.c;
import coil.util.h;
import coil.util.s;
import com.google.android.gms.common.api.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001\u0014B!\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010$\u001a\u00020!\u0012\b\u0010'\u001a\u0004\u0018\u00010%¢\u0006\u0004\b.\u0010/J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J(\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ7\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010%8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0018\u0010*\u001a\u00020\f*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\u0004\u0018\u00010+*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010,¨\u00060"}, d2 = {"Lo2/c;", "", "Lcoil/request/g;", "request", "Lcoil/memory/MemoryCache$Key;", "cacheKey", "Lcoil/memory/MemoryCache$b;", "cacheValue", "Lcoil/size/g;", "size", "Lcoil/size/Scale;", "scale", "", "e", "mappedData", "Lcoil/request/k;", "options", "Lcoil/b;", "eventListener", "f", "a", "c", "(Lcoil/request/g;Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$b;Lcoil/size/g;Lcoil/size/Scale;)Z", "Lcoil/intercept/EngineInterceptor$b;", "result", "h", "Lcoil/intercept/a$a;", "chain", "Lcoil/request/n;", "g", "Lcoil/ImageLoader;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/request/m;", "b", "Lcoil/request/m;", "requestService", "Lcoil/util/s;", "Lcoil/util/s;", "logger", "d", "(Lcoil/memory/MemoryCache$b;)Z", "isSampled", "", "(Lcoil/memory/MemoryCache$b;)Ljava/lang/String;", "diskCacheKey", "<init>", "(Lcoil/ImageLoader;Lcoil/request/m;Lcoil/util/s;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f16783d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f16784a;

    /* renamed from: b  reason: collision with root package name */
    private final m f16785b;

    /* renamed from: c  reason: collision with root package name */
    private final s f16786c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u0012\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\t\u0010\u0004\u0012\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u0012\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u000f"}, d2 = {"Lo2/c$a;", "", "", "EXTRA_DISK_CACHE_KEY", "Ljava/lang/String;", "getEXTRA_DISK_CACHE_KEY$coil_base_release$annotations", "()V", "EXTRA_IS_SAMPLED", "getEXTRA_IS_SAMPLED$coil_base_release$annotations", "EXTRA_TRANSFORMATION_INDEX", "getEXTRA_TRANSFORMATION_INDEX$coil_base_release$annotations", "EXTRA_TRANSFORMATION_SIZE", "getEXTRA_TRANSFORMATION_SIZE$coil_base_release$annotations", "TAG", "<init>", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(ImageLoader imageLoader, m mVar, s sVar) {
        this.f16784a = imageLoader;
        this.f16785b = mVar;
        this.f16786c = sVar;
    }

    private final String b(MemoryCache.b bVar) {
        Object obj = bVar.b().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean d(MemoryCache.b bVar) {
        Object obj = bVar.b().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean e(g gVar, MemoryCache.Key key, MemoryCache.b bVar, coil.size.g gVar2, Scale scale) {
        int i10;
        boolean z10;
        Scale scale2 = scale;
        boolean d10 = d(bVar);
        if (!b.b(gVar2)) {
            String str = key.d().get("coil#transformation_size");
            if (str != null) {
                return j.b(str, gVar2.toString());
            }
            int width = bVar.a().getWidth();
            int height = bVar.a().getHeight();
            coil.size.c d11 = gVar2.d();
            boolean z11 = d11 instanceof c.a;
            int i11 = a.e.API_PRIORITY_OTHER;
            if (z11) {
                i10 = ((c.a) d11).f8407a;
            } else {
                i10 = Integer.MAX_VALUE;
            }
            coil.size.c c10 = gVar2.c();
            if (c10 instanceof c.a) {
                i11 = ((c.a) c10).f8407a;
            }
            double c11 = d.c(width, height, i10, i11, scale2);
            boolean a10 = h.a(gVar);
            if (a10) {
                double e10 = j.e(c11, 1.0d);
                if (Math.abs(((double) i10) - (((double) width) * e10)) <= 1.0d || Math.abs(((double) i11) - (e10 * ((double) height))) <= 1.0d) {
                    return true;
                }
            } else if ((coil.util.j.t(i10) || Math.abs(i10 - width) <= 1) && (coil.util.j.t(i11) || Math.abs(i11 - height) <= 1)) {
                return true;
            }
            if (c11 == 1.0d) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 && !a10) {
                s sVar = this.f16786c;
                if (sVar == null || sVar.getLevel() > 3) {
                    return false;
                }
                sVar.a("MemoryCacheService", 3, gVar.m() + ": Cached image's request size (" + width + ", " + height + ") does not exactly match the requested size (" + gVar2.d() + ", " + gVar2.c() + ", " + scale2 + ").", (Throwable) null);
                return false;
            } else if (c11 <= 1.0d || !d10) {
                return true;
            } else {
                s sVar2 = this.f16786c;
                if (sVar2 == null || sVar2.getLevel() > 3) {
                    return false;
                }
                sVar2.a("MemoryCacheService", 3, gVar.m() + ": Cached image's request size (" + width + ", " + height + ") is smaller than the requested size (" + gVar2.d() + ", " + gVar2.c() + ", " + scale2 + ").", (Throwable) null);
                return false;
            }
        } else if (!d10) {
            return true;
        } else {
            s sVar3 = this.f16786c;
            if (sVar3 != null && sVar3.getLevel() <= 3) {
                sVar3.a("MemoryCacheService", 3, gVar.m() + ": Requested original size, but cached image is sampled.", (Throwable) null);
            }
            return false;
        }
    }

    public final MemoryCache.b a(g gVar, MemoryCache.Key key, coil.size.g gVar2, Scale scale) {
        MemoryCache.b bVar;
        if (!gVar.C().b()) {
            return null;
        }
        MemoryCache b10 = this.f16784a.b();
        if (b10 != null) {
            bVar = b10.c(key);
        } else {
            bVar = null;
        }
        if (bVar == null || !c(gVar, key, bVar, gVar2, scale)) {
            return null;
        }
        return bVar;
    }

    public final boolean c(g gVar, MemoryCache.Key key, MemoryCache.b bVar, coil.size.g gVar2, Scale scale) {
        if (this.f16785b.c(gVar, coil.util.a.c(bVar.a()))) {
            return e(gVar, key, bVar, gVar2, scale);
        }
        s sVar = this.f16786c;
        if (sVar == null || sVar.getLevel() > 3) {
            return false;
        }
        sVar.a("MemoryCacheService", 3, gVar.m() + ": Cached bitmap is hardware-backed, which is incompatible with the request.", (Throwable) null);
        return false;
    }

    public final MemoryCache.Key f(g gVar, Object obj, k kVar, coil.b bVar) {
        MemoryCache.Key B = gVar.B();
        if (B != null) {
            return B;
        }
        bVar.m(gVar, obj);
        String f10 = this.f16784a.getComponents().f(obj, kVar);
        bVar.e(gVar, f10);
        if (f10 == null) {
            return null;
        }
        List<q2.a> O = gVar.O();
        Map<String, String> d10 = gVar.E().d();
        if (O.isEmpty() && d10.isEmpty()) {
            return new MemoryCache.Key(f10, (Map) null, 2, (DefaultConstructorMarker) null);
        }
        Map w10 = h0.w(d10);
        if (!O.isEmpty()) {
            List<q2.a> O2 = gVar.O();
            int size = O2.size();
            for (int i10 = 0; i10 < size; i10++) {
                w10.put("coil#transformation_" + i10, O2.get(i10).a());
            }
            w10.put("coil#transformation_size", kVar.o().toString());
        }
        return new MemoryCache.Key(f10, w10);
    }

    public final n g(a.C0104a aVar, g gVar, MemoryCache.Key key, MemoryCache.b bVar) {
        return new n(new BitmapDrawable(gVar.l().getResources(), bVar.a()), gVar, DataSource.MEMORY_CACHE, key, b(bVar), d(bVar), coil.util.j.u(aVar));
    }

    public final boolean h(MemoryCache.Key key, g gVar, EngineInterceptor.b bVar) {
        MemoryCache b10;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        if (!(!gVar.C().c() || (b10 = this.f16784a.b()) == null || key == null)) {
            Drawable e10 = bVar.e();
            if (e10 instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) e10;
            } else {
                bitmapDrawable = null;
            }
            if (!(bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(bVar.f()));
                String d10 = bVar.d();
                if (d10 != null) {
                    linkedHashMap.put("coil#disk_cache_key", d10);
                }
                b10.d(key, new MemoryCache.b(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
