package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import coil.b;
import coil.decode.ExifOrientationPolicy;
import coil.memory.MemoryCache;
import coil.request.CachePolicy;
import coil.request.a;
import coil.request.g;
import coil.size.Precision;
import coil.util.h;
import coil.util.p;
import coil.util.s;
import gk.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.e;
import r2.a;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcoil/ImageLoader;", "", "Lcoil/request/g;", "request", "Lcoil/request/c;", "a", "", "shutdown", "Lcoil/a;", "getComponents", "()Lcoil/a;", "components", "Lcoil/memory/MemoryCache;", "b", "()Lcoil/memory/MemoryCache;", "memoryCache", "Builder", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface ImageLoader {

    @Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020\u0010¢\u0006\u0004\b.\u0010/J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R \u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcoil/ImageLoader$Builder;", "", "Lcoil/a;", "components", "c", "", "enable", "e", "", "durationMillis", "d", "Lr2/c$a;", "factory", "f", "Lcoil/ImageLoader;", "b", "Landroid/content/Context;", "a", "Landroid/content/Context;", "applicationContext", "Lcoil/request/a;", "Lcoil/request/a;", "defaults", "Lgk/f;", "Lcoil/memory/MemoryCache;", "Lgk/f;", "memoryCache", "Lcoil/disk/a;", "diskCache", "Lokhttp3/e$a;", "callFactory", "Lcoil/b$d;", "Lcoil/b$d;", "eventListenerFactory", "g", "Lcoil/a;", "componentRegistry", "Lcoil/util/p;", "h", "Lcoil/util/p;", "options", "Lcoil/util/s;", "i", "Lcoil/util/s;", "logger", "context", "<init>", "(Landroid/content/Context;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Context f8021a;

        /* renamed from: b  reason: collision with root package name */
        private a f8022b = h.b();

        /* renamed from: c  reason: collision with root package name */
        private f<? extends MemoryCache> f8023c = null;

        /* renamed from: d  reason: collision with root package name */
        private f<? extends coil.disk.a> f8024d = null;

        /* renamed from: e  reason: collision with root package name */
        private f<? extends e.a> f8025e = null;

        /* renamed from: f  reason: collision with root package name */
        private b.d f8026f = null;

        /* renamed from: g  reason: collision with root package name */
        private a f8027g = null;

        /* renamed from: h  reason: collision with root package name */
        private p f8028h = new p(false, false, false, 0, (ExifOrientationPolicy) null, 31, (DefaultConstructorMarker) null);

        /* renamed from: i  reason: collision with root package name */
        private s f8029i = null;

        public Builder(Context context) {
            this.f8021a = context.getApplicationContext();
        }

        public final ImageLoader b() {
            Context context = this.f8021a;
            a aVar = this.f8022b;
            f<? extends MemoryCache> fVar = this.f8023c;
            if (fVar == null) {
                fVar = b.b(new ImageLoader$Builder$build$1(this));
            }
            f<? extends MemoryCache> fVar2 = fVar;
            f<? extends coil.disk.a> fVar3 = this.f8024d;
            if (fVar3 == null) {
                fVar3 = b.b(new ImageLoader$Builder$build$2(this));
            }
            f<? extends coil.disk.a> fVar4 = fVar3;
            f<? extends e.a> fVar5 = this.f8025e;
            if (fVar5 == null) {
                fVar5 = b.b(ImageLoader$Builder$build$3.f8030a);
            }
            f<? extends e.a> fVar6 = fVar5;
            b.d dVar = this.f8026f;
            if (dVar == null) {
                dVar = b.d.f8064b;
            }
            b.d dVar2 = dVar;
            a aVar2 = this.f8027g;
            if (aVar2 == null) {
                aVar2 = new a();
            }
            return new RealImageLoader(context, aVar, fVar2, fVar4, fVar6, dVar2, aVar2, this.f8028h, this.f8029i);
        }

        public final Builder c(a aVar) {
            this.f8027g = aVar;
            return this;
        }

        public final Builder d(int i10) {
            c.a aVar;
            if (i10 > 0) {
                aVar = new a.C0197a(i10, false, 2, (DefaultConstructorMarker) null);
            } else {
                aVar = c.a.f17259b;
            }
            f(aVar);
            return this;
        }

        public final Builder e(boolean z10) {
            return d(z10 ? 100 : 0);
        }

        public final Builder f(c.a aVar) {
            this.f8022b = coil.request.a.b(this.f8022b, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, aVar, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32751, (Object) null);
            return this;
        }
    }

    coil.request.c a(g gVar);

    MemoryCache b();

    a getComponents();

    void shutdown();
}
