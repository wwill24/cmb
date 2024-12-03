package coil.intercept;

import coil.b;
import coil.intercept.a;
import coil.request.g;
import coil.request.i;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\"\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002J\u001b\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001e\u0010%R\u0017\u0010*\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b#\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/a$a;", "Lcoil/request/g;", "request", "Lcoil/intercept/a;", "interceptor", "", "b", "", "index", "Lcoil/size/g;", "size", "c", "Lcoil/request/h;", "g", "(Lcoil/request/g;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "Lcoil/request/g;", "getInitialRequest", "()Lcoil/request/g;", "initialRequest", "", "Ljava/util/List;", "getInterceptors", "()Ljava/util/List;", "interceptors", "I", "getIndex", "()I", "d", "e", "Lcoil/size/g;", "getSize", "()Lcoil/size/g;", "Lcoil/b;", "f", "Lcoil/b;", "()Lcoil/b;", "eventListener", "", "Z", "()Z", "isPlaceholderCached", "<init>", "(Lcoil/request/g;Ljava/util/List;ILcoil/request/g;Lcoil/size/g;Lcoil/b;Z)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class RealInterceptorChain implements a.C0104a {

    /* renamed from: a  reason: collision with root package name */
    private final g f8213a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f8214b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8215c;

    /* renamed from: d  reason: collision with root package name */
    private final g f8216d;

    /* renamed from: e  reason: collision with root package name */
    private final coil.size.g f8217e;

    /* renamed from: f  reason: collision with root package name */
    private final b f8218f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f8219g;

    public RealInterceptorChain(g gVar, List<? extends a> list, int i10, g gVar2, coil.size.g gVar3, b bVar, boolean z10) {
        this.f8213a = gVar;
        this.f8214b = list;
        this.f8215c = i10;
        this.f8216d = gVar2;
        this.f8217e = gVar3;
        this.f8218f = bVar;
        this.f8219g = z10;
    }

    private final void b(g gVar, a aVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        if (gVar.l() == this.f8213a.l()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (gVar.m() != i.f8358a) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (gVar.M() == this.f8213a.M()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (gVar.z() == this.f8213a.z()) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        if (gVar.K() != this.f8213a.K()) {
                            z14 = false;
                        }
                        if (!z14) {
                            throw new IllegalStateException(("Interceptor '" + aVar + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
                        }
                        return;
                    }
                    throw new IllegalStateException(("Interceptor '" + aVar + "' cannot modify the request's lifecycle.").toString());
                }
                throw new IllegalStateException(("Interceptor '" + aVar + "' cannot modify the request's target.").toString());
            }
            throw new IllegalStateException(("Interceptor '" + aVar + "' cannot set the request's data to null.").toString());
        }
        throw new IllegalStateException(("Interceptor '" + aVar + "' cannot modify the request's context.").toString());
    }

    private final RealInterceptorChain c(int i10, g gVar, coil.size.g gVar2) {
        return new RealInterceptorChain(this.f8213a, this.f8214b, i10, gVar, gVar2, this.f8218f, this.f8219g);
    }

    static /* synthetic */ RealInterceptorChain d(RealInterceptorChain realInterceptorChain, int i10, g gVar, coil.size.g gVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = realInterceptorChain.f8215c;
        }
        if ((i11 & 2) != 0) {
            gVar = realInterceptorChain.a();
        }
        if ((i11 & 4) != 0) {
            gVar2 = realInterceptorChain.getSize();
        }
        return realInterceptorChain.c(i10, gVar, gVar2);
    }

    public g a() {
        return this.f8216d;
    }

    public final b e() {
        return this.f8218f;
    }

    public final boolean f() {
        return this.f8219g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(coil.request.g r12, kotlin.coroutines.c<? super coil.request.h> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof coil.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r12 = r0.L$1
            coil.intercept.a r12 = (coil.intercept.a) r12
            java.lang.Object r0 = r0.L$0
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            gk.g.b(r13)
            goto L_0x0074
        L_0x0031:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0039:
            gk.g.b(r13)
            int r13 = r11.f8215c
            if (r13 <= 0) goto L_0x004c
            java.util.List<coil.intercept.a> r2 = r11.f8214b
            int r13 = r13 - r3
            java.lang.Object r13 = r2.get(r13)
            coil.intercept.a r13 = (coil.intercept.a) r13
            r11.b(r12, r13)
        L_0x004c:
            java.util.List<coil.intercept.a> r13 = r11.f8214b
            int r2 = r11.f8215c
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.a r13 = (coil.intercept.a) r13
            int r2 = r11.f8215c
            int r5 = r2 + 1
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r11
            r6 = r12
            coil.intercept.RealInterceptorChain r12 = d(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r11
            r0.L$1 = r13
            r0.label = r3
            java.lang.Object r12 = r13.a(r12, r0)
            if (r12 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0074:
            coil.request.h r13 = (coil.request.h) r13
            coil.request.g r1 = r13.b()
            r0.b(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.g(coil.request.g, kotlin.coroutines.c):java.lang.Object");
    }

    public coil.size.g getSize() {
        return this.f8217e;
    }
}
