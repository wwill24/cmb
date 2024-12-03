package o2;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0002\u0013\u0011B\u0007¢\u0006\u0004\b\"\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J4\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u000f\u0010\u0014\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\\\u0010\u001f\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00190\u0016j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019`\u001a8\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010 ¨\u0006#"}, d2 = {"Lo2/f;", "Lo2/h;", "", "f", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$b;", "c", "Landroid/graphics/Bitmap;", "bitmap", "", "", "", "extras", "", "size", "d", "b", "level", "a", "e", "()V", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lo2/f$b;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "getCache$coil_base_release", "()Ljava/util/LinkedHashMap;", "getCache$coil_base_release$annotations", "cache", "I", "operationsSinceCleanUp", "<init>", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class f implements h {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16795c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<MemoryCache.Key, ArrayList<b>> f16796a = new LinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private int f16797b;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lo2/f$a;", "", "", "CLEAN_UP_INTERVAL", "I", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0003\u0010\fR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0017"}, d2 = {"Lo2/f$b;", "", "", "a", "I", "c", "()I", "identityHashCode", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "b", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "bitmap", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "extras", "d", "size", "<init>", "(ILjava/lang/ref/WeakReference;Ljava/util/Map;I)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f16798a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Bitmap> f16799b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Object> f16800c;

        /* renamed from: d  reason: collision with root package name */
        private final int f16801d;

        public b(int i10, WeakReference<Bitmap> weakReference, Map<String, ? extends Object> map, int i11) {
            this.f16798a = i10;
            this.f16799b = weakReference;
            this.f16800c = map;
            this.f16801d = i11;
        }

        public final WeakReference<Bitmap> a() {
            return this.f16799b;
        }

        public final Map<String, Object> b() {
            return this.f16800c;
        }

        public final int c() {
            return this.f16798a;
        }

        public final int d() {
            return this.f16801d;
        }
    }

    private final void f() {
        int i10 = this.f16797b;
        this.f16797b = i10 + 1;
        if (i10 >= 10) {
            e();
        }
    }

    public synchronized void a(int i10) {
        if (i10 >= 10 && i10 != 20) {
            e();
        }
    }

    public synchronized void b() {
        this.f16797b = 0;
        this.f16796a.clear();
    }

    public synchronized MemoryCache.b c(MemoryCache.Key key) {
        MemoryCache.b bVar;
        ArrayList arrayList = this.f16796a.get(key);
        MemoryCache.b bVar2 = null;
        if (arrayList == null) {
            return null;
        }
        int i10 = 0;
        int size = arrayList.size();
        while (true) {
            if (i10 >= size) {
                break;
            }
            b bVar3 = (b) arrayList.get(i10);
            Bitmap bitmap = bVar3.a().get();
            if (bitmap != null) {
                bVar = new MemoryCache.b(bitmap, bVar3.b());
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar2 = bVar;
                break;
            }
            i10++;
        }
        f();
        return bVar2;
    }

    public synchronized void d(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> map, int i10) {
        LinkedHashMap<MemoryCache.Key, ArrayList<b>> linkedHashMap = this.f16796a;
        ArrayList<b> arrayList = linkedHashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(key, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        int identityHashCode = System.identityHashCode(bitmap);
        b bVar = new b(identityHashCode, new WeakReference(bitmap), map, i10);
        int i11 = 0;
        int size = arrayList2.size();
        while (true) {
            if (i11 >= size) {
                arrayList2.add(bVar);
                break;
            }
            b bVar2 = (b) arrayList2.get(i11);
            if (i10 < bVar2.d()) {
                i11++;
            } else if (bVar2.c() == identityHashCode && bVar2.a().get() == bitmap) {
                arrayList2.set(i11, bVar);
            } else {
                arrayList2.add(i11, bVar);
            }
        }
        f();
    }

    public final void e() {
        boolean z10;
        Bitmap bitmap;
        WeakReference<Bitmap> a10;
        this.f16797b = 0;
        Iterator<ArrayList<b>> it = this.f16796a.values().iterator();
        while (it.hasNext()) {
            ArrayList next = it.next();
            if (next.size() <= 1) {
                b bVar = (b) CollectionsKt___CollectionsKt.P(next);
                if (bVar == null || (a10 = bVar.a()) == null) {
                    bitmap = null;
                } else {
                    bitmap = a10.get();
                }
                if (bitmap == null) {
                    it.remove();
                }
            } else {
                int size = next.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    int i12 = i11 - i10;
                    if (((b) next.get(i12)).a().get() == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        next.remove(i12);
                        i10++;
                    }
                }
                if (next.isEmpty()) {
                    it.remove();
                }
            }
        }
    }
}
