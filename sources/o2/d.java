package o2;

import coil.memory.MemoryCache;
import coil.util.c;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lo2/d;", "Lcoil/memory/MemoryCache;", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$b;", "c", "value", "", "d", "clear", "", "level", "a", "Lo2/g;", "Lo2/g;", "strongMemoryCache", "Lo2/h;", "b", "Lo2/h;", "weakMemoryCache", "<init>", "(Lo2/g;Lo2/h;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class d implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private final g f16787a;

    /* renamed from: b  reason: collision with root package name */
    private final h f16788b;

    public d(g gVar, h hVar) {
        this.f16787a = gVar;
        this.f16788b = hVar;
    }

    public void a(int i10) {
        this.f16787a.a(i10);
        this.f16788b.a(i10);
    }

    public MemoryCache.b c(MemoryCache.Key key) {
        MemoryCache.b c10 = this.f16787a.c(key);
        return c10 == null ? this.f16788b.c(key) : c10;
    }

    public void clear() {
        this.f16787a.b();
        this.f16788b.b();
    }

    public void d(MemoryCache.Key key, MemoryCache.b bVar) {
        this.f16787a.d(MemoryCache.Key.c(key, (String) null, c.b(key.d()), 1, (Object) null), bVar.a(), c.b(bVar.b()));
    }
}
