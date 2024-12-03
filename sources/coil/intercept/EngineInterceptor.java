package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.request.g;
import coil.request.k;
import coil.request.m;
import coil.util.j;
import coil.util.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.h;
import o2.c;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 72\u00020\u0001:\u0002!*B!\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010,\u001a\u00020)\u0012\b\u00100\u001a\u0004\u0018\u00010-¢\u0006\u0004\b5\u00106J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u001b\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J3\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/a;", "Lcoil/request/g;", "request", "", "mappedData", "Lcoil/request/k;", "_options", "Lcoil/b;", "eventListener", "Lcoil/intercept/EngineInterceptor$b;", "i", "(Lcoil/request/g;Ljava/lang/Object;Lcoil/request/k;Lcoil/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/a;", "components", "options", "Lcoil/fetch/h;", "j", "(Lcoil/a;Lcoil/request/g;Ljava/lang/Object;Lcoil/request/k;Lcoil/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/fetch/l;", "fetchResult", "h", "(Lcoil/fetch/l;Lcoil/a;Lcoil/request/g;Ljava/lang/Object;Lcoil/request/k;Lcoil/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "Lq2/a;", "transformations", "Landroid/graphics/Bitmap;", "g", "Lcoil/intercept/a$a;", "chain", "Lcoil/request/h;", "a", "(Lcoil/intercept/a$a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "result", "k", "(Lcoil/intercept/EngineInterceptor$b;Lcoil/request/g;Lcoil/request/k;Lcoil/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/ImageLoader;", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/request/m;", "b", "Lcoil/request/m;", "requestService", "Lcoil/util/s;", "c", "Lcoil/util/s;", "logger", "Lo2/c;", "d", "Lo2/c;", "memoryCacheService", "<init>", "(Lcoil/ImageLoader;Lcoil/request/m;Lcoil/util/s;)V", "e", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class EngineInterceptor implements a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f8204e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ImageLoader f8205a;

    /* renamed from: b  reason: collision with root package name */
    private final m f8206b;

    /* renamed from: c  reason: collision with root package name */
    private final s f8207c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final c f8208d;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcoil/intercept/EngineInterceptor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0018\u0010\u0019J0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcoil/intercept/EngineInterceptor$b;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "isSampled", "Lcoil/decode/DataSource;", "dataSource", "", "diskCacheKey", "a", "Landroid/graphics/drawable/Drawable;", "e", "()Landroid/graphics/drawable/Drawable;", "b", "Z", "f", "()Z", "c", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "<init>", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable f8209a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8210b;

        /* renamed from: c  reason: collision with root package name */
        private final DataSource f8211c;

        /* renamed from: d  reason: collision with root package name */
        private final String f8212d;

        public b(Drawable drawable, boolean z10, DataSource dataSource, String str) {
            this.f8209a = drawable;
            this.f8210b = z10;
            this.f8211c = dataSource;
            this.f8212d = str;
        }

        public static /* synthetic */ b b(b bVar, Drawable drawable, boolean z10, DataSource dataSource, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                drawable = bVar.f8209a;
            }
            if ((i10 & 2) != 0) {
                z10 = bVar.f8210b;
            }
            if ((i10 & 4) != 0) {
                dataSource = bVar.f8211c;
            }
            if ((i10 & 8) != 0) {
                str = bVar.f8212d;
            }
            return bVar.a(drawable, z10, dataSource, str);
        }

        public final b a(Drawable drawable, boolean z10, DataSource dataSource, String str) {
            return new b(drawable, z10, dataSource, str);
        }

        public final DataSource c() {
            return this.f8211c;
        }

        public final String d() {
            return this.f8212d;
        }

        public final Drawable e() {
            return this.f8209a;
        }

        public final boolean f() {
            return this.f8210b;
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, m mVar, s sVar) {
        this.f8205a = imageLoader;
        this.f8206b = mVar;
        this.f8207c = sVar;
        this.f8208d = new c(imageLoader, mVar, sVar);
    }

    /* access modifiers changed from: private */
    public final Bitmap g(Drawable drawable, k kVar, List<? extends q2.a> list) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config c10 = coil.util.a.c(bitmap);
            if (l.v(j.p(), c10)) {
                return bitmap;
            }
            s sVar = this.f8207c;
            if (sVar != null && sVar.getLevel() <= 4) {
                sVar.a("EngineInterceptor", 4, "Converting bitmap with config " + c10 + " to apply transformations: " + list + '.', (Throwable) null);
            }
        } else {
            s sVar2 = this.f8207c;
            if (sVar2 != null && sVar2.getLevel() <= 4) {
                sVar2.a("EngineInterceptor", 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + list + '.', (Throwable) null);
            }
        }
        return coil.util.m.f8436a.a(drawable, kVar.f(), kVar.o(), kVar.n(), kVar.c());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(coil.fetch.l r17, coil.a r18, coil.request.g r19, java.lang.Object r20, coil.request.k r21, coil.b r22, kotlin.coroutines.c<? super coil.intercept.EngineInterceptor.b> r23) {
        /*
            r16 = this;
            r0 = r23
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$decode$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            coil.intercept.EngineInterceptor$decode$1 r1 = (coil.intercept.EngineInterceptor$decode$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r16
            goto L_0x001e
        L_0x0017:
            coil.intercept.EngineInterceptor$decode$1 r1 = new coil.intercept.EngineInterceptor$decode$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.b.d()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0060
            if (r4 != r5) goto L_0x0058
            int r4 = r1.I$0
            java.lang.Object r6 = r1.L$7
            coil.decode.e r6 = (coil.decode.e) r6
            java.lang.Object r7 = r1.L$6
            coil.b r7 = (coil.b) r7
            java.lang.Object r8 = r1.L$5
            coil.request.k r8 = (coil.request.k) r8
            java.lang.Object r9 = r1.L$4
            java.lang.Object r10 = r1.L$3
            coil.request.g r10 = (coil.request.g) r10
            java.lang.Object r11 = r1.L$2
            coil.a r11 = (coil.a) r11
            java.lang.Object r12 = r1.L$1
            coil.fetch.l r12 = (coil.fetch.l) r12
            java.lang.Object r13 = r1.L$0
            coil.intercept.EngineInterceptor r13 = (coil.intercept.EngineInterceptor) r13
            gk.g.b(r0)
            r14 = r10
            r10 = r1
            r1 = r11
            r11 = r3
            r3 = r14
            r15 = r9
            r9 = r4
            r4 = r15
            goto L_0x00b4
        L_0x0058:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0060:
            gk.g.b(r0)
            r0 = 0
            r4 = r20
            r6 = r21
            r7 = r22
            r8 = r0
            r9 = r1
            r13 = r2
            r10 = r3
            r0 = r17
            r1 = r18
            r3 = r19
        L_0x0074:
            coil.ImageLoader r11 = r13.f8205a
            kotlin.Pair r8 = r1.i(r0, r6, r11, r8)
            if (r8 == 0) goto L_0x00e6
            java.lang.Object r11 = r8.c()
            coil.decode.e r11 = (coil.decode.e) r11
            java.lang.Object r8 = r8.d()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r8 = r8 + r5
            r7.o(r3, r11, r6)
            r9.L$0 = r13
            r9.L$1 = r0
            r9.L$2 = r1
            r9.L$3 = r3
            r9.L$4 = r4
            r9.L$5 = r6
            r9.L$6 = r7
            r9.L$7 = r11
            r9.I$0 = r8
            r9.label = r5
            java.lang.Object r12 = r11.a(r9)
            if (r12 != r10) goto L_0x00ab
            return r10
        L_0x00ab:
            r14 = r12
            r12 = r0
            r0 = r14
            r15 = r8
            r8 = r6
            r6 = r11
            r11 = r10
            r10 = r9
            r9 = r15
        L_0x00b4:
            coil.decode.c r0 = (coil.decode.c) r0
            r7.j(r3, r6, r8, r0)
            if (r0 == 0) goto L_0x00e0
            coil.intercept.EngineInterceptor$b r1 = new coil.intercept.EngineInterceptor$b
            android.graphics.drawable.Drawable r3 = r0.a()
            boolean r0 = r0.b()
            coil.decode.DataSource r4 = r12.a()
            coil.decode.k r5 = r12.c()
            boolean r6 = r5 instanceof coil.decode.j
            r7 = 0
            if (r6 == 0) goto L_0x00d5
            coil.decode.j r5 = (coil.decode.j) r5
            goto L_0x00d6
        L_0x00d5:
            r5 = r7
        L_0x00d6:
            if (r5 == 0) goto L_0x00dc
            java.lang.String r7 = r5.e()
        L_0x00dc:
            r1.<init>(r3, r0, r4, r7)
            return r1
        L_0x00e0:
            r6 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0 = r12
            goto L_0x0074
        L_0x00e6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to create a decoder that supports: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.h(coil.fetch.l, coil.a, coil.request.g, java.lang.Object, coil.request.k, coil.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: coil.fetch.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: android.graphics.drawable.BitmapDrawable} */
    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r12v7 */
    /* JADX WARNING: type inference failed for: r12v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015c A[Catch:{ all -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019c A[SYNTHETIC, Splitter:B:53:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(coil.request.g r36, java.lang.Object r37, coil.request.k r38, coil.b r39, kotlin.coroutines.c<? super coil.intercept.EngineInterceptor.b> r40) {
        /*
            r35 = this;
            r8 = r35
            r0 = r40
            boolean r1 = r0 instanceof coil.intercept.EngineInterceptor$execute$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            coil.intercept.EngineInterceptor$execute$1 r1 = (coil.intercept.EngineInterceptor$execute$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001c
        L_0x0017:
            coil.intercept.EngineInterceptor$execute$1 r1 = new coil.intercept.EngineInterceptor$execute$1
            r1.<init>(r8, r0)
        L_0x001c:
            r0 = r1
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r10 = 3
            r11 = 2
            r3 = 1
            r12 = 0
            if (r2 == 0) goto L_0x0087
            if (r2 == r3) goto L_0x005a
            if (r2 == r11) goto L_0x003e
            if (r2 != r10) goto L_0x0036
            gk.g.b(r1)
            goto L_0x01f3
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            java.lang.Object r2 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r3 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            java.lang.Object r4 = r0.L$2
            coil.b r4 = (coil.b) r4
            java.lang.Object r5 = r0.L$1
            coil.request.g r5 = (coil.request.g) r5
            java.lang.Object r6 = r0.L$0
            coil.intercept.EngineInterceptor r6 = (coil.intercept.EngineInterceptor) r6
            gk.g.b(r1)     // Catch:{ all -> 0x0057 }
            goto L_0x0190
        L_0x0057:
            r0 = move-exception
            goto L_0x0214
        L_0x005a:
            java.lang.Object r2 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r3 = r0.L$6
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            java.lang.Object r4 = r0.L$5
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
            java.lang.Object r5 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref$ObjectRef) r5
            java.lang.Object r6 = r0.L$3
            coil.b r6 = (coil.b) r6
            java.lang.Object r7 = r0.L$2
            java.lang.Object r13 = r0.L$1
            coil.request.g r13 = (coil.request.g) r13
            java.lang.Object r14 = r0.L$0
            coil.intercept.EngineInterceptor r14 = (coil.intercept.EngineInterceptor) r14
            gk.g.b(r1)     // Catch:{ all -> 0x0083 }
            r15 = r3
            r19 = r4
            r3 = r5
            r21 = r7
            goto L_0x0151
        L_0x0083:
            r0 = move-exception
            r2 = r3
            goto L_0x0214
        L_0x0087:
            gk.g.b(r1)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            r1 = r38
            r13.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            coil.ImageLoader r1 = r8.f8205a
            coil.a r1 = r1.getComponents()
            r14.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            coil.request.m r1 = r8.f8206b     // Catch:{ all -> 0x0212 }
            T r2 = r13.element     // Catch:{ all -> 0x0212 }
            coil.request.k r2 = (coil.request.k) r2     // Catch:{ all -> 0x0212 }
            boolean r1 = r1.a(r2)     // Catch:{ all -> 0x0212 }
            if (r1 != 0) goto L_0x00df
            T r1 = r13.element     // Catch:{ all -> 0x0212 }
            r16 = r1
            coil.request.k r16 = (coil.request.k) r16     // Catch:{ all -> 0x0212 }
            r17 = 0
            android.graphics.Bitmap$Config r18 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0212 }
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 32765(0x7ffd, float:4.5914E-41)
            r33 = 0
            coil.request.k r1 = coil.request.k.b(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0212 }
            r13.element = r1     // Catch:{ all -> 0x0212 }
        L_0x00df:
            kotlin.Pair r1 = r36.w()     // Catch:{ all -> 0x0212 }
            if (r1 != 0) goto L_0x00eb
            coil.decode.e$a r1 = r36.o()     // Catch:{ all -> 0x0212 }
            if (r1 == 0) goto L_0x0114
        L_0x00eb:
            T r1 = r14.element     // Catch:{ all -> 0x0212 }
            coil.a r1 = (coil.a) r1     // Catch:{ all -> 0x0212 }
            coil.a$a r1 = r1.h()     // Catch:{ all -> 0x0212 }
            kotlin.Pair r2 = r36.w()     // Catch:{ all -> 0x0212 }
            r4 = 0
            if (r2 == 0) goto L_0x0101
            java.util.List r5 = r1.g()     // Catch:{ all -> 0x0212 }
            r5.add(r4, r2)     // Catch:{ all -> 0x0212 }
        L_0x0101:
            coil.decode.e$a r2 = r36.o()     // Catch:{ all -> 0x0212 }
            if (r2 == 0) goto L_0x010e
            java.util.List r5 = r1.f()     // Catch:{ all -> 0x0212 }
            r5.add(r4, r2)     // Catch:{ all -> 0x0212 }
        L_0x010e:
            coil.a r1 = r1.e()     // Catch:{ all -> 0x0212 }
            r14.element = r1     // Catch:{ all -> 0x0212 }
        L_0x0114:
            T r1 = r14.element     // Catch:{ all -> 0x0212 }
            r2 = r1
            coil.a r2 = (coil.a) r2     // Catch:{ all -> 0x0212 }
            T r1 = r13.element     // Catch:{ all -> 0x0212 }
            r5 = r1
            coil.request.k r5 = (coil.request.k) r5     // Catch:{ all -> 0x0212 }
            r0.L$0 = r8     // Catch:{ all -> 0x0212 }
            r7 = r36
            r0.L$1 = r7     // Catch:{ all -> 0x0212 }
            r6 = r37
            r0.L$2 = r6     // Catch:{ all -> 0x0212 }
            r4 = r39
            r0.L$3 = r4     // Catch:{ all -> 0x0212 }
            r0.L$4 = r13     // Catch:{ all -> 0x0212 }
            r0.L$5 = r14     // Catch:{ all -> 0x0212 }
            r0.L$6 = r15     // Catch:{ all -> 0x0212 }
            r0.L$7 = r15     // Catch:{ all -> 0x0212 }
            r0.label = r3     // Catch:{ all -> 0x0212 }
            r1 = r35
            r3 = r36
            r4 = r37
            r6 = r39
            r7 = r0
            java.lang.Object r1 = r1.j(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0212 }
            if (r1 != r9) goto L_0x0146
            return r9
        L_0x0146:
            r21 = r37
            r6 = r39
            r3 = r13
            r19 = r14
            r2 = r15
            r13 = r36
            r14 = r8
        L_0x0151:
            r2.element = r1     // Catch:{ all -> 0x0212 }
            T r1 = r15.element     // Catch:{ all -> 0x0212 }
            r2 = r1
            coil.fetch.h r2 = (coil.fetch.h) r2     // Catch:{ all -> 0x0212 }
            boolean r4 = r2 instanceof coil.fetch.l     // Catch:{ all -> 0x0212 }
            if (r4 == 0) goto L_0x019c
            kotlinx.coroutines.CoroutineDispatcher r1 = r13.n()     // Catch:{ all -> 0x0212 }
            coil.intercept.EngineInterceptor$execute$executeResult$1 r2 = new coil.intercept.EngineInterceptor$execute$executeResult$1     // Catch:{ all -> 0x0212 }
            r24 = 0
            r16 = r2
            r17 = r14
            r18 = r15
            r20 = r13
            r22 = r3
            r23 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0212 }
            r0.L$0 = r14     // Catch:{ all -> 0x0212 }
            r0.L$1 = r13     // Catch:{ all -> 0x0212 }
            r0.L$2 = r6     // Catch:{ all -> 0x0212 }
            r0.L$3 = r3     // Catch:{ all -> 0x0212 }
            r0.L$4 = r15     // Catch:{ all -> 0x0212 }
            r0.L$5 = r12     // Catch:{ all -> 0x0212 }
            r0.L$6 = r12     // Catch:{ all -> 0x0212 }
            r0.L$7 = r12     // Catch:{ all -> 0x0212 }
            r0.label = r11     // Catch:{ all -> 0x0212 }
            java.lang.Object r1 = kotlinx.coroutines.h.g(r1, r2, r0)     // Catch:{ all -> 0x0212 }
            if (r1 != r9) goto L_0x018c
            return r9
        L_0x018c:
            r4 = r6
            r5 = r13
            r6 = r14
            r2 = r15
        L_0x0190:
            coil.intercept.EngineInterceptor$b r1 = (coil.intercept.EngineInterceptor.b) r1     // Catch:{ all -> 0x0057 }
            r15 = r2
            r2 = r6
            r6 = r4
            r4 = r5
            r34 = r3
            r3 = r1
            r1 = r34
            goto L_0x01bf
        L_0x019c:
            boolean r2 = r2 instanceof coil.fetch.g     // Catch:{ all -> 0x0212 }
            if (r2 == 0) goto L_0x020c
            coil.intercept.EngineInterceptor$b r2 = new coil.intercept.EngineInterceptor$b     // Catch:{ all -> 0x0212 }
            coil.fetch.g r1 = (coil.fetch.g) r1     // Catch:{ all -> 0x0212 }
            android.graphics.drawable.Drawable r1 = r1.b()     // Catch:{ all -> 0x0212 }
            T r4 = r15.element     // Catch:{ all -> 0x0212 }
            coil.fetch.g r4 = (coil.fetch.g) r4     // Catch:{ all -> 0x0212 }
            boolean r4 = r4.c()     // Catch:{ all -> 0x0212 }
            T r5 = r15.element     // Catch:{ all -> 0x0212 }
            coil.fetch.g r5 = (coil.fetch.g) r5     // Catch:{ all -> 0x0212 }
            coil.decode.DataSource r5 = r5.a()     // Catch:{ all -> 0x0212 }
            r2.<init>(r1, r4, r5, r12)     // Catch:{ all -> 0x0212 }
            r1 = r3
            r4 = r13
            r3 = r2
            r2 = r14
        L_0x01bf:
            T r5 = r15.element
            boolean r7 = r5 instanceof coil.fetch.l
            if (r7 == 0) goto L_0x01c8
            coil.fetch.l r5 = (coil.fetch.l) r5
            goto L_0x01c9
        L_0x01c8:
            r5 = r12
        L_0x01c9:
            if (r5 == 0) goto L_0x01d4
            coil.decode.k r5 = r5.c()
            if (r5 == 0) goto L_0x01d4
            coil.util.j.d(r5)
        L_0x01d4:
            T r1 = r1.element
            r5 = r1
            coil.request.k r5 = (coil.request.k) r5
            r0.L$0 = r12
            r0.L$1 = r12
            r0.L$2 = r12
            r0.L$3 = r12
            r0.L$4 = r12
            r0.L$5 = r12
            r0.L$6 = r12
            r0.L$7 = r12
            r0.label = r10
            r7 = r0
            java.lang.Object r1 = r2.k(r3, r4, r5, r6, r7)
            if (r1 != r9) goto L_0x01f3
            return r9
        L_0x01f3:
            coil.intercept.EngineInterceptor$b r1 = (coil.intercept.EngineInterceptor.b) r1
            android.graphics.drawable.Drawable r0 = r1.e()
            boolean r2 = r0 instanceof android.graphics.drawable.BitmapDrawable
            if (r2 == 0) goto L_0x0200
            r12 = r0
            android.graphics.drawable.BitmapDrawable r12 = (android.graphics.drawable.BitmapDrawable) r12
        L_0x0200:
            if (r12 == 0) goto L_0x020b
            android.graphics.Bitmap r0 = r12.getBitmap()
            if (r0 == 0) goto L_0x020b
            r0.prepareToDraw()
        L_0x020b:
            return r1
        L_0x020c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0212 }
            r0.<init>()     // Catch:{ all -> 0x0212 }
            throw r0     // Catch:{ all -> 0x0212 }
        L_0x0212:
            r0 = move-exception
            r2 = r15
        L_0x0214:
            T r1 = r2.element
            boolean r2 = r1 instanceof coil.fetch.l
            if (r2 == 0) goto L_0x021d
            r12 = r1
            coil.fetch.l r12 = (coil.fetch.l) r12
        L_0x021d:
            if (r12 == 0) goto L_0x0228
            coil.decode.k r1 = r12.c()
            if (r1 == 0) goto L_0x0228
            coil.util.j.d(r1)
        L_0x0228:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.i(coil.request.g, java.lang.Object, coil.request.k, coil.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(coil.a r10, coil.request.g r11, java.lang.Object r12, coil.request.k r13, coil.b r14, kotlin.coroutines.c<? super coil.fetch.h> r15) {
        /*
            r9 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$fetch$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            coil.intercept.EngineInterceptor$fetch$1 r0 = (coil.intercept.EngineInterceptor$fetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.intercept.EngineInterceptor$fetch$1 r0 = new coil.intercept.EngineInterceptor$fetch$1
            r0.<init>(r9, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$6
            coil.fetch.i r11 = (coil.fetch.i) r11
            java.lang.Object r12 = r0.L$5
            coil.b r12 = (coil.b) r12
            java.lang.Object r13 = r0.L$4
            coil.request.k r13 = (coil.request.k) r13
            java.lang.Object r14 = r0.L$3
            java.lang.Object r2 = r0.L$2
            coil.request.g r2 = (coil.request.g) r2
            java.lang.Object r4 = r0.L$1
            coil.a r4 = (coil.a) r4
            java.lang.Object r5 = r0.L$0
            coil.intercept.EngineInterceptor r5 = (coil.intercept.EngineInterceptor) r5
            gk.g.b(r15)
            r6 = r0
            r0 = r10
            r10 = r4
            r4 = r1
            r1 = r6
            r7 = r2
            r2 = r11
            r11 = r7
            r8 = r14
            r14 = r12
            r12 = r8
            goto L_0x0097
        L_0x0050:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0058:
            gk.g.b(r15)
            r15 = 0
            r5 = r9
        L_0x005d:
            coil.ImageLoader r2 = r5.f8205a
            kotlin.Pair r15 = r10.j(r12, r13, r2, r15)
            if (r15 == 0) goto L_0x00b8
            java.lang.Object r2 = r15.c()
            coil.fetch.i r2 = (coil.fetch.i) r2
            java.lang.Object r15 = r15.d()
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            int r15 = r15 + r3
            r14.h(r11, r2, r13)
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r11
            r0.L$3 = r12
            r0.L$4 = r13
            r0.L$5 = r14
            r0.L$6 = r2
            r0.I$0 = r15
            r0.label = r3
            java.lang.Object r4 = r2.a(r0)
            if (r4 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r6 = r0
            r0 = r15
            r15 = r4
            r4 = r1
            r1 = r6
        L_0x0097:
            coil.fetch.h r15 = (coil.fetch.h) r15
            r14.f(r11, r2, r13, r15)     // Catch:{ all -> 0x00a3 }
            if (r15 == 0) goto L_0x009f
            return r15
        L_0x009f:
            r15 = r0
            r0 = r1
            r1 = r4
            goto L_0x005d
        L_0x00a3:
            r10 = move-exception
            boolean r11 = r15 instanceof coil.fetch.l
            if (r11 == 0) goto L_0x00ab
            coil.fetch.l r15 = (coil.fetch.l) r15
            goto L_0x00ac
        L_0x00ab:
            r15 = 0
        L_0x00ac:
            if (r15 == 0) goto L_0x00b7
            coil.decode.k r11 = r15.c()
            if (r11 == 0) goto L_0x00b7
            coil.util.j.d(r11)
        L_0x00b7:
            throw r10
        L_0x00b8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unable to create a fetcher that supports: "
            r10.append(r11)
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.j(coil.a, coil.request.g, java.lang.Object, coil.request.k, coil.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(coil.intercept.a.C0104a r14, kotlin.coroutines.c<? super coil.request.h> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof coil.intercept.EngineInterceptor$intercept$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            coil.intercept.EngineInterceptor$intercept$1 r0 = (coil.intercept.EngineInterceptor$intercept$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.intercept.EngineInterceptor$intercept$1 r0 = new coil.intercept.EngineInterceptor$intercept$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r14 = r0.L$1
            coil.intercept.a$a r14 = (coil.intercept.a.C0104a) r14
            java.lang.Object r0 = r0.L$0
            coil.intercept.EngineInterceptor r0 = (coil.intercept.EngineInterceptor) r0
            gk.g.b(r15)     // Catch:{ all -> 0x0031 }
            goto L_0x009b
        L_0x0031:
            r15 = move-exception
            goto L_0x009e
        L_0x0033:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003b:
            gk.g.b(r15)
            coil.request.g r6 = r14.a()     // Catch:{ all -> 0x009c }
            java.lang.Object r15 = r6.m()     // Catch:{ all -> 0x009c }
            coil.size.g r2 = r14.getSize()     // Catch:{ all -> 0x009c }
            coil.b r9 = coil.util.j.h(r14)     // Catch:{ all -> 0x009c }
            coil.request.m r4 = r13.f8206b     // Catch:{ all -> 0x009c }
            coil.request.k r8 = r4.f(r6, r2)     // Catch:{ all -> 0x009c }
            coil.size.Scale r4 = r8.n()     // Catch:{ all -> 0x009c }
            r9.i(r6, r15)     // Catch:{ all -> 0x009c }
            coil.ImageLoader r5 = r13.f8205a     // Catch:{ all -> 0x009c }
            coil.a r5 = r5.getComponents()     // Catch:{ all -> 0x009c }
            java.lang.Object r7 = r5.g(r15, r8)     // Catch:{ all -> 0x009c }
            r9.g(r6, r7)     // Catch:{ all -> 0x009c }
            o2.c r15 = r13.f8208d     // Catch:{ all -> 0x009c }
            coil.memory.MemoryCache$Key r10 = r15.f(r6, r7, r8, r9)     // Catch:{ all -> 0x009c }
            if (r10 == 0) goto L_0x0077
            o2.c r15 = r13.f8208d     // Catch:{ all -> 0x009c }
            coil.memory.MemoryCache$b r15 = r15.a(r6, r10, r2, r4)     // Catch:{ all -> 0x009c }
            goto L_0x0078
        L_0x0077:
            r15 = 0
        L_0x0078:
            if (r15 == 0) goto L_0x0081
            o2.c r0 = r13.f8208d     // Catch:{ all -> 0x009c }
            coil.request.n r14 = r0.g(r14, r6, r10, r15)     // Catch:{ all -> 0x009c }
            return r14
        L_0x0081:
            kotlinx.coroutines.CoroutineDispatcher r15 = r6.v()     // Catch:{ all -> 0x009c }
            coil.intercept.EngineInterceptor$intercept$2 r2 = new coil.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x009c }
            r12 = 0
            r4 = r2
            r5 = r13
            r11 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x009c }
            r0.L$0 = r13     // Catch:{ all -> 0x009c }
            r0.L$1 = r14     // Catch:{ all -> 0x009c }
            r0.label = r3     // Catch:{ all -> 0x009c }
            java.lang.Object r15 = kotlinx.coroutines.h.g(r15, r2, r0)     // Catch:{ all -> 0x009c }
            if (r15 != r1) goto L_0x009b
            return r1
        L_0x009b:
            return r15
        L_0x009c:
            r15 = move-exception
            r0 = r13
        L_0x009e:
            boolean r1 = r15 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x00ad
            coil.request.m r0 = r0.f8206b
            coil.request.g r14 = r14.a()
            coil.request.d r14 = r0.b(r14, r15)
            return r14
        L_0x00ad:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.EngineInterceptor.a(coil.intercept.a$a, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object k(b bVar, g gVar, k kVar, coil.b bVar2, kotlin.coroutines.c<? super b> cVar) {
        List<q2.a> O = gVar.O();
        if (O.isEmpty()) {
            return bVar;
        }
        if ((bVar.e() instanceof BitmapDrawable) || gVar.g()) {
            return h.g(gVar.N(), new EngineInterceptor$transform$3(this, bVar, kVar, O, bVar2, gVar, (kotlin.coroutines.c<? super EngineInterceptor$transform$3>) null), cVar);
        }
        s sVar = this.f8207c;
        if (sVar != null && sVar.getLevel() <= 4) {
            String canonicalName = bVar.e().getClass().getCanonicalName();
            sVar.a("EngineInterceptor", 4, "allowConversionToBitmap=false, skipping transformations for type " + canonicalName + '.', (Throwable) null);
        }
        return bVar;
    }
}
