package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import coil.b;
import coil.decode.BitmapFactoryDecoder;
import coil.fetch.HttpUriFetcher;
import coil.fetch.a;
import coil.fetch.b;
import coil.fetch.c;
import coil.fetch.e;
import coil.fetch.f;
import coil.fetch.j;
import coil.fetch.k;
import coil.intercept.EngineInterceptor;
import coil.memory.MemoryCache;
import coil.request.g;
import coil.request.m;
import coil.util.g;
import coil.util.p;
import coil.util.s;
import coil.util.u;
import gk.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import n2.c;
import okhttp3.e;
import okhttp3.t;

@Metadata(bv = {}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 g2\u00020\u0001:\u0001\u0016Bg\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020 \u0012\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\u000e\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0&\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002010&\u0012\u0006\u00108\u001a\u000204\u0012\u0006\u0010>\u001a\u000209\u0012\u0006\u0010C\u001a\u00020?\u0012\b\u0010G\u001a\u0004\u0018\u00010D¢\u0006\u0004\be\u0010fJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010%\u001a\u00020 8\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001f\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0&8\u0006¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002010&8\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b2\u0010+R\u0017\u00108\u001a\u0002048\u0006¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010C\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b\u0014\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010G\u001a\u0004\u0018\u00010D8\u0006¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\b:\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001d\u0010T\u001a\u0004\u0018\u00010'8VX\u0002¢\u0006\f\n\u0004\bR\u0010)\u001a\u0004\b!\u0010SR\u001d\u0010X\u001a\u0004\u0018\u00010-8VX\u0002¢\u0006\f\n\u0004\bU\u0010)\u001a\u0004\bV\u0010WR\u001a\u0010[\u001a\u0002098\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010;\u001a\u0004\bZ\u0010=R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010c\u0002\u0004\n\u0002\b\u0019¨\u0006h"}, d2 = {"Lcoil/RealImageLoader;", "Lcoil/ImageLoader;", "Lcoil/request/g;", "initialRequest", "", "type", "Lcoil/request/h;", "e", "(Lcoil/request/g;ILkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/request/n;", "result", "Lp2/a;", "target", "Lcoil/b;", "eventListener", "", "j", "Lcoil/request/d;", "i", "request", "h", "Lcoil/request/c;", "a", "level", "k", "(I)V", "shutdown", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcoil/request/a;", "b", "Lcoil/request/a;", "f", "()Lcoil/request/a;", "defaults", "Lgk/f;", "Lcoil/memory/MemoryCache;", "c", "Lgk/f;", "getMemoryCacheLazy", "()Lgk/f;", "memoryCacheLazy", "Lcoil/disk/a;", "d", "getDiskCacheLazy", "diskCacheLazy", "Lokhttp3/e$a;", "getCallFactoryLazy", "callFactoryLazy", "Lcoil/b$d;", "Lcoil/b$d;", "getEventListenerFactory", "()Lcoil/b$d;", "eventListenerFactory", "Lcoil/a;", "g", "Lcoil/a;", "getComponentRegistry", "()Lcoil/a;", "componentRegistry", "Lcoil/util/p;", "Lcoil/util/p;", "getOptions", "()Lcoil/util/p;", "options", "Lcoil/util/s;", "Lcoil/util/s;", "()Lcoil/util/s;", "logger", "Lkotlinx/coroutines/k0;", "Lkotlinx/coroutines/k0;", "scope", "Lcoil/util/u;", "Lcoil/util/u;", "systemCallbacks", "Lcoil/request/m;", "l", "Lcoil/request/m;", "requestService", "m", "()Lcoil/memory/MemoryCache;", "memoryCache", "n", "getDiskCache", "()Lcoil/disk/a;", "diskCache", "o", "getComponents", "components", "", "Lcoil/intercept/a;", "p", "Ljava/util/List;", "interceptors", "Ljava/util/concurrent/atomic/AtomicBoolean;", "q", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShutdown", "<init>", "(Landroid/content/Context;Lcoil/request/a;Lgk/f;Lgk/f;Lgk/f;Lcoil/b$d;Lcoil/a;Lcoil/util/p;Lcoil/util/s;)V", "r", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class RealImageLoader implements ImageLoader {

    /* renamed from: r  reason: collision with root package name */
    public static final a f8031r = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Context f8032a;

    /* renamed from: b  reason: collision with root package name */
    private final coil.request.a f8033b;

    /* renamed from: c  reason: collision with root package name */
    private final f<MemoryCache> f8034c;

    /* renamed from: d  reason: collision with root package name */
    private final f<coil.disk.a> f8035d;

    /* renamed from: e  reason: collision with root package name */
    private final f<e.a> f8036e;

    /* renamed from: f  reason: collision with root package name */
    private final b.d f8037f;

    /* renamed from: g  reason: collision with root package name */
    private final a f8038g;

    /* renamed from: h  reason: collision with root package name */
    private final p f8039h;

    /* renamed from: i  reason: collision with root package name */
    private final s f8040i;

    /* renamed from: j  reason: collision with root package name */
    private final k0 f8041j = l0.a(o2.b((s1) null, 1, (Object) null).e0(x0.c().Y()).e0(new b(g0.f32489u, this)));

    /* renamed from: k  reason: collision with root package name */
    private final u f8042k;

    /* renamed from: l  reason: collision with root package name */
    private final m f8043l;

    /* renamed from: m  reason: collision with root package name */
    private final f f8044m;

    /* renamed from: n  reason: collision with root package name */
    private final f f8045n;

    /* renamed from: o  reason: collision with root package name */
    private final a f8046o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final List<coil.intercept.a> f8047p;

    /* renamed from: q  reason: collision with root package name */
    private final AtomicBoolean f8048q;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcoil/RealImageLoader$a;", "", "", "REQUEST_TYPE_ENQUEUE", "I", "REQUEST_TYPE_EXECUTE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"coil/RealImageLoader$b", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/g0;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "P", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    public static final class b extends kotlin.coroutines.a implements g0 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RealImageLoader f8049b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g0.a aVar, RealImageLoader realImageLoader) {
            super(aVar);
            this.f8049b = realImageLoader;
        }

        public void P(CoroutineContext coroutineContext, Throwable th2) {
            s g10 = this.f8049b.g();
            if (g10 != null) {
                g.a(g10, "RealImageLoader", th2);
            }
        }
    }

    public RealImageLoader(Context context, coil.request.a aVar, f<? extends MemoryCache> fVar, f<? extends coil.disk.a> fVar2, f<? extends e.a> fVar3, b.d dVar, a aVar2, p pVar, s sVar) {
        this.f8032a = context;
        this.f8033b = aVar;
        this.f8034c = fVar;
        this.f8035d = fVar2;
        this.f8036e = fVar3;
        this.f8037f = dVar;
        this.f8038g = aVar2;
        this.f8039h = pVar;
        this.f8040i = sVar;
        u uVar = new u(this, context, pVar.d());
        this.f8042k = uVar;
        m mVar = new m(this, uVar, sVar);
        this.f8043l = mVar;
        this.f8044m = fVar;
        this.f8045n = fVar2;
        this.f8046o = aVar2.h().d(new c(), t.class).d(new n2.g(), String.class).d(new n2.b(), Uri.class).d(new n2.f(), Uri.class).d(new n2.e(), Integer.class).d(new n2.a(), byte[].class).c(new m2.c(), Uri.class).c(new m2.a(pVar.a()), File.class).b(new HttpUriFetcher.b(fVar3, fVar2, pVar.e()), Uri.class).b(new j.a(), File.class).b(new a.C0103a(), Uri.class).b(new e.a(), Uri.class).b(new k.b(), Uri.class).b(new f.a(), Drawable.class).b(new b.a(), Bitmap.class).b(new c.a(), ByteBuffer.class).a(new BitmapFactoryDecoder.c(pVar.c(), pVar.b())).e();
        this.f8047p = CollectionsKt___CollectionsKt.i0(getComponents().c(), new EngineInterceptor(this, mVar, sVar));
        this.f8048q = new AtomicBoolean(false);
        uVar.c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: coil.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: coil.request.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: coil.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: coil.RealImageLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: coil.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: coil.request.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: coil.request.RequestDelegate} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: coil.RealImageLoader} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f6 A[Catch:{ all -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010c A[Catch:{ all -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011a A[Catch:{ all -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0124 A[Catch:{ all -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0130 A[Catch:{ all -> 0x01a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x014c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0189 A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0194 A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ba A[Catch:{ all -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cb A[SYNTHETIC, Splitter:B:92:0x01cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(coil.request.g r21, int r22, kotlin.coroutines.c<? super coil.request.h> r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r2 = r23
            boolean r3 = r2 instanceof coil.RealImageLoader$executeMain$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            coil.RealImageLoader$executeMain$1 r3 = (coil.RealImageLoader$executeMain$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.label = r4
            goto L_0x001e
        L_0x0019:
            coil.RealImageLoader$executeMain$1 r3 = new coil.RealImageLoader$executeMain$1
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.b.d()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0097
            if (r5 == r8) goto L_0x0078
            if (r5 == r7) goto L_0x0056
            if (r5 != r6) goto L_0x004e
            java.lang.Object r0 = r3.L$3
            r4 = r0
            coil.b r4 = (coil.b) r4
            java.lang.Object r0 = r3.L$2
            r5 = r0
            coil.request.g r5 = (coil.request.g) r5
            java.lang.Object r0 = r3.L$1
            r6 = r0
            coil.request.RequestDelegate r6 = (coil.request.RequestDelegate) r6
            java.lang.Object r0 = r3.L$0
            r3 = r0
            coil.RealImageLoader r3 = (coil.RealImageLoader) r3
            gk.g.b(r2)     // Catch:{ all -> 0x004b }
            goto L_0x0183
        L_0x004b:
            r0 = move-exception
            goto L_0x01b6
        L_0x004e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0056:
            java.lang.Object r0 = r3.L$4
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            java.lang.Object r5 = r3.L$3
            coil.b r5 = (coil.b) r5
            java.lang.Object r7 = r3.L$2
            coil.request.g r7 = (coil.request.g) r7
            java.lang.Object r8 = r3.L$1
            coil.request.RequestDelegate r8 = (coil.request.RequestDelegate) r8
            java.lang.Object r10 = r3.L$0
            coil.RealImageLoader r10 = (coil.RealImageLoader) r10
            gk.g.b(r2)     // Catch:{ all -> 0x0071 }
            r17 = r0
            goto L_0x0156
        L_0x0071:
            r0 = move-exception
            r4 = r5
            r5 = r7
            r6 = r8
            r3 = r10
            goto L_0x01b6
        L_0x0078:
            java.lang.Object r0 = r3.L$3
            r5 = r0
            coil.b r5 = (coil.b) r5
            java.lang.Object r0 = r3.L$2
            r8 = r0
            coil.request.g r8 = (coil.request.g) r8
            java.lang.Object r0 = r3.L$1
            r10 = r0
            coil.request.RequestDelegate r10 = (coil.request.RequestDelegate) r10
            java.lang.Object r0 = r3.L$0
            r11 = r0
            coil.RealImageLoader r11 = (coil.RealImageLoader) r11
            gk.g.b(r2)     // Catch:{ all -> 0x0090 }
            goto L_0x00eb
        L_0x0090:
            r0 = move-exception
            r4 = r5
            r5 = r8
            r6 = r10
        L_0x0094:
            r3 = r11
            goto L_0x01b6
        L_0x0097:
            gk.g.b(r2)
            coil.request.m r2 = r1.f8043l
            kotlin.coroutines.CoroutineContext r5 = r3.getContext()
            kotlinx.coroutines.s1 r5 = kotlinx.coroutines.v1.k(r5)
            coil.request.RequestDelegate r2 = r2.g(r0, r5)
            r2.a()
            coil.request.g$a r0 = coil.request.g.R(r0, r9, r8, r9)
            coil.request.a r5 = r20.f()
            coil.request.g$a r0 = r0.f(r5)
            coil.request.g r5 = r0.a()
            coil.b$d r0 = r1.f8037f
            coil.b r10 = r0.a(r5)
            java.lang.Object r0 = r5.m()     // Catch:{ all -> 0x01b2 }
            coil.request.i r11 = coil.request.i.f8358a     // Catch:{ all -> 0x01b2 }
            boolean r0 = kotlin.jvm.internal.j.b(r0, r11)     // Catch:{ all -> 0x01b2 }
            if (r0 != 0) goto L_0x01ac
            r2.c()     // Catch:{ all -> 0x01b2 }
            if (r22 != 0) goto L_0x00ed
            androidx.lifecycle.Lifecycle r0 = r5.z()     // Catch:{ all -> 0x01b2 }
            r3.L$0 = r1     // Catch:{ all -> 0x01b2 }
            r3.L$1 = r2     // Catch:{ all -> 0x01b2 }
            r3.L$2 = r5     // Catch:{ all -> 0x01b2 }
            r3.L$3 = r10     // Catch:{ all -> 0x01b2 }
            r3.label = r8     // Catch:{ all -> 0x01b2 }
            java.lang.Object r0 = coil.util.Lifecycles.a(r0, r3)     // Catch:{ all -> 0x01b2 }
            if (r0 != r4) goto L_0x00e7
            return r4
        L_0x00e7:
            r11 = r1
            r8 = r5
            r5 = r10
            r10 = r2
        L_0x00eb:
            r2 = r10
            goto L_0x00f0
        L_0x00ed:
            r11 = r1
            r8 = r5
            r5 = r10
        L_0x00f0:
            coil.memory.MemoryCache r0 = r11.b()     // Catch:{ all -> 0x01a6 }
            if (r0 == 0) goto L_0x0109
            coil.memory.MemoryCache$Key r10 = r8.G()     // Catch:{ all -> 0x01a6 }
            if (r10 == 0) goto L_0x0101
            coil.memory.MemoryCache$b r0 = r0.c(r10)     // Catch:{ all -> 0x01a6 }
            goto L_0x0102
        L_0x0101:
            r0 = r9
        L_0x0102:
            if (r0 == 0) goto L_0x0109
            android.graphics.Bitmap r0 = r0.a()     // Catch:{ all -> 0x01a6 }
            goto L_0x010a
        L_0x0109:
            r0 = r9
        L_0x010a:
            if (r0 == 0) goto L_0x011a
            android.content.Context r10 = r8.l()     // Catch:{ all -> 0x01a6 }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ all -> 0x01a6 }
            android.graphics.drawable.BitmapDrawable r12 = new android.graphics.drawable.BitmapDrawable     // Catch:{ all -> 0x01a6 }
            r12.<init>(r10, r0)     // Catch:{ all -> 0x01a6 }
            goto L_0x011e
        L_0x011a:
            android.graphics.drawable.Drawable r12 = r8.F()     // Catch:{ all -> 0x01a6 }
        L_0x011e:
            p2.a r10 = r8.M()     // Catch:{ all -> 0x01a6 }
            if (r10 == 0) goto L_0x0127
            r10.b(r12)     // Catch:{ all -> 0x01a6 }
        L_0x0127:
            r5.b(r8)     // Catch:{ all -> 0x01a6 }
            coil.request.g$b r10 = r8.A()     // Catch:{ all -> 0x01a6 }
            if (r10 == 0) goto L_0x0133
            r10.b(r8)     // Catch:{ all -> 0x01a6 }
        L_0x0133:
            r5.p(r8)     // Catch:{ all -> 0x01a6 }
            coil.size.h r10 = r8.K()     // Catch:{ all -> 0x01a6 }
            r3.L$0 = r11     // Catch:{ all -> 0x01a6 }
            r3.L$1 = r2     // Catch:{ all -> 0x01a6 }
            r3.L$2 = r8     // Catch:{ all -> 0x01a6 }
            r3.L$3 = r5     // Catch:{ all -> 0x01a6 }
            r3.L$4 = r0     // Catch:{ all -> 0x01a6 }
            r3.label = r7     // Catch:{ all -> 0x01a6 }
            java.lang.Object r7 = r10.b(r3)     // Catch:{ all -> 0x01a6 }
            if (r7 != r4) goto L_0x014d
            return r4
        L_0x014d:
            r17 = r0
            r10 = r11
            r19 = r8
            r8 = r2
            r2 = r7
            r7 = r19
        L_0x0156:
            r15 = r2
            coil.size.g r15 = (coil.size.g) r15     // Catch:{ all -> 0x0071 }
            r5.l(r7, r15)     // Catch:{ all -> 0x0071 }
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.y()     // Catch:{ all -> 0x0071 }
            coil.RealImageLoader$executeMain$result$1 r2 = new coil.RealImageLoader$executeMain$result$1     // Catch:{ all -> 0x0071 }
            r18 = 0
            r12 = r2
            r13 = r7
            r14 = r10
            r16 = r5
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0071 }
            r3.L$0 = r10     // Catch:{ all -> 0x0071 }
            r3.L$1 = r8     // Catch:{ all -> 0x0071 }
            r3.L$2 = r7     // Catch:{ all -> 0x0071 }
            r3.L$3 = r5     // Catch:{ all -> 0x0071 }
            r3.L$4 = r9     // Catch:{ all -> 0x0071 }
            r3.label = r6     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = kotlinx.coroutines.h.g(r0, r2, r3)     // Catch:{ all -> 0x0071 }
            if (r2 != r4) goto L_0x017f
            return r4
        L_0x017f:
            r4 = r5
            r5 = r7
            r6 = r8
            r3 = r10
        L_0x0183:
            coil.request.h r2 = (coil.request.h) r2     // Catch:{ all -> 0x004b }
            boolean r0 = r2 instanceof coil.request.n     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0194
            r0 = r2
            coil.request.n r0 = (coil.request.n) r0     // Catch:{ all -> 0x004b }
            p2.a r7 = r5.M()     // Catch:{ all -> 0x004b }
            r3.j(r0, r7, r4)     // Catch:{ all -> 0x004b }
            goto L_0x01a2
        L_0x0194:
            boolean r0 = r2 instanceof coil.request.d     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x01a2
            r0 = r2
            coil.request.d r0 = (coil.request.d) r0     // Catch:{ all -> 0x004b }
            p2.a r7 = r5.M()     // Catch:{ all -> 0x004b }
            r3.i(r0, r7, r4)     // Catch:{ all -> 0x004b }
        L_0x01a2:
            r6.b()
            return r2
        L_0x01a6:
            r0 = move-exception
            r6 = r2
            r4 = r5
            r5 = r8
            goto L_0x0094
        L_0x01ac:
            coil.request.NullRequestDataException r0 = new coil.request.NullRequestDataException     // Catch:{ all -> 0x01b2 }
            r0.<init>()     // Catch:{ all -> 0x01b2 }
            throw r0     // Catch:{ all -> 0x01b2 }
        L_0x01b2:
            r0 = move-exception
            r3 = r1
            r6 = r2
            r4 = r10
        L_0x01b6:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x01cf }
            if (r2 != 0) goto L_0x01cb
            coil.request.m r2 = r3.f8043l     // Catch:{ all -> 0x01cf }
            coil.request.d r0 = r2.b(r5, r0)     // Catch:{ all -> 0x01cf }
            p2.a r2 = r5.M()     // Catch:{ all -> 0x01cf }
            r3.i(r0, r2, r4)     // Catch:{ all -> 0x01cf }
            r6.b()
            return r0
        L_0x01cb:
            r3.h(r5, r4)     // Catch:{ all -> 0x01cf }
            throw r0     // Catch:{ all -> 0x01cf }
        L_0x01cf:
            r0 = move-exception
            r6.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.e(coil.request.g, int, kotlin.coroutines.c):java.lang.Object");
    }

    private final void h(coil.request.g gVar, b bVar) {
        s sVar = this.f8040i;
        if (sVar != null && sVar.getLevel() <= 4) {
            sVar.a("RealImageLoader", 4, "🏗  Cancelled - " + gVar.m(), (Throwable) null);
        }
        bVar.a(gVar);
        g.b A = gVar.A();
        if (A != null) {
            A.a(gVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r8 != null) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void i(coil.request.d r7, p2.a r8, coil.b r9) {
        /*
            r6 = this;
            coil.request.g r0 = r7.b()
            coil.util.s r1 = r6.f8040i
            if (r1 == 0) goto L_0x0036
            r2 = 4
            int r3 = r1.getLevel()
            if (r3 > r2) goto L_0x0036
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "🚨 Failed - "
            r3.append(r4)
            java.lang.Object r4 = r0.m()
            r3.append(r4)
            java.lang.String r4 = " - "
            r3.append(r4)
            java.lang.Throwable r4 = r7.c()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r1.a(r5, r2, r3, r4)
        L_0x0036:
            boolean r1 = r8 instanceof r2.d
            if (r1 != 0) goto L_0x003d
            if (r8 == 0) goto L_0x0069
            goto L_0x0050
        L_0x003d:
            coil.request.g r1 = r7.b()
            r2.c$a r1 = r1.P()
            r2 = r8
            r2.d r2 = (r2.d) r2
            r2.c r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof r2.b
            if (r2 == 0) goto L_0x0058
        L_0x0050:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.c(r1)
            goto L_0x0069
        L_0x0058:
            coil.request.g r8 = r7.b()
            r9.q(r8, r1)
            r1.a()
            coil.request.g r8 = r7.b()
            r9.r(r8, r1)
        L_0x0069:
            r9.c(r0, r7)
            coil.request.g$b r8 = r0.A()
            if (r8 == 0) goto L_0x0075
            r8.c(r0, r7)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.i(coil.request.d, p2.a, coil.b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0045, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void j(coil.request.n r7, p2.a r8, coil.b r9) {
        /*
            r6 = this;
            coil.request.g r0 = r7.b()
            coil.decode.DataSource r1 = r7.c()
            coil.util.s r2 = r6.f8040i
            if (r2 == 0) goto L_0x0041
            r3 = 4
            int r4 = r2.getLevel()
            if (r4 > r3) goto L_0x0041
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = coil.util.j.g(r1)
            r4.append(r5)
            java.lang.String r5 = " Successful ("
            r4.append(r5)
            java.lang.String r1 = r1.name()
            r4.append(r1)
            java.lang.String r1 = ") - "
            r4.append(r1)
            java.lang.Object r1 = r0.m()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r4 = 0
            java.lang.String r5 = "RealImageLoader"
            r2.a(r5, r3, r1, r4)
        L_0x0041:
            boolean r1 = r8 instanceof r2.d
            if (r1 != 0) goto L_0x0048
            if (r8 == 0) goto L_0x0074
            goto L_0x005b
        L_0x0048:
            coil.request.g r1 = r7.b()
            r2.c$a r1 = r1.P()
            r2 = r8
            r2.d r2 = (r2.d) r2
            r2.c r1 = r1.a(r2, r7)
            boolean r2 = r1 instanceof r2.b
            if (r2 == 0) goto L_0x0063
        L_0x005b:
            android.graphics.drawable.Drawable r1 = r7.a()
            r8.a(r1)
            goto L_0x0074
        L_0x0063:
            coil.request.g r8 = r7.b()
            r9.q(r8, r1)
            r1.a()
            coil.request.g r8 = r7.b()
            r9.r(r8, r1)
        L_0x0074:
            r9.d(r0, r7)
            coil.request.g$b r8 = r0.A()
            if (r8 == 0) goto L_0x0080
            r8.d(r0, r7)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.j(coil.request.n, p2.a, coil.b):void");
    }

    public coil.request.c a(coil.request.g gVar) {
        p0 b10 = j.b(this.f8041j, (CoroutineContext) null, (CoroutineStart) null, new RealImageLoader$enqueue$job$1(this, gVar, (kotlin.coroutines.c<? super RealImageLoader$enqueue$job$1>) null), 3, (Object) null);
        if (gVar.M() instanceof p2.b) {
            return coil.util.j.m(((p2.b) gVar.M()).getView()).b(b10);
        }
        return new coil.request.j(b10);
    }

    public MemoryCache b() {
        return (MemoryCache) this.f8044m.getValue();
    }

    public coil.request.a f() {
        return this.f8033b;
    }

    public final s g() {
        return this.f8040i;
    }

    public a getComponents() {
        return this.f8046o;
    }

    public final void k(int i10) {
        MemoryCache value;
        gk.f<MemoryCache> fVar = this.f8034c;
        if (fVar != null && (value = fVar.getValue()) != null) {
            value.a(i10);
        }
    }

    public void shutdown() {
        if (!this.f8048q.getAndSet(true)) {
            l0.f(this.f8041j, (CancellationException) null, 1, (Object) null);
            this.f8042k.d();
            MemoryCache b10 = b();
            if (b10 != null) {
                b10.clear();
            }
        }
    }
}
