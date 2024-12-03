package coil.decode;

import coil.ImageLoader;
import coil.decode.e;
import coil.fetch.l;
import coil.request.k;
import coil.size.Scale;
import coil.size.g;
import coil.util.i;
import gk.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.InterruptibleKt;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\n\u0010B#\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0013\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcoil/decode/SvgDecoder;", "Lcoil/decode/e;", "", "srcWidth", "srcHeight", "Lcoil/size/Scale;", "scale", "Lkotlin/Pair;", "e", "Lcoil/decode/c;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lcoil/decode/k;", "Lcoil/decode/k;", "source", "Lcoil/request/k;", "b", "Lcoil/request/k;", "options", "", "c", "Z", "f", "()Z", "useViewBoundsAsIntrinsicSize", "<init>", "(Lcoil/decode/k;Lcoil/request/k;Z)V", "d", "coil-svg_release"}, k = 1, mv = {1, 7, 1})
public final class SvgDecoder implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f8083d = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f8084a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final k f8085b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8086c;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcoil/decode/SvgDecoder$a;", "", "", "CSS_KEY", "Ljava/lang/String;", "", "DEFAULT_SIZE", "F", "MIME_TYPE_SVG", "<init>", "()V", "coil-svg_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SvgDecoder(k kVar, k kVar2, boolean z10) {
        this.f8084a = kVar;
        this.f8085b = kVar2;
        this.f8086c = z10;
    }

    /* access modifiers changed from: private */
    public final Pair<Float, Float> e(float f10, float f11, Scale scale) {
        if (coil.size.b.b(this.f8085b.o())) {
            if (f10 <= 0.0f) {
                f10 = 512.0f;
            }
            if (f11 <= 0.0f) {
                f11 = 512.0f;
            }
            return h.a(Float.valueOf(f10), Float.valueOf(f11));
        }
        g o10 = this.f8085b.o();
        return h.a(Float.valueOf(i.c(o10.a(), scale)), Float.valueOf(i.c(o10.b(), scale)));
    }

    public Object a(c<? super c> cVar) {
        return InterruptibleKt.c((CoroutineContext) null, new SvgDecoder$decode$2(this), cVar, 1, (Object) null);
    }

    public final boolean f() {
        return this.f8086c;
    }

    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/decode/SvgDecoder$b;", "Lcoil/decode/e$a;", "Lcoil/fetch/l;", "result", "", "b", "Lcoil/request/k;", "options", "Lcoil/ImageLoader;", "imageLoader", "Lcoil/decode/e;", "a", "", "other", "equals", "", "hashCode", "Z", "getUseViewBoundsAsIntrinsicSize", "()Z", "useViewBoundsAsIntrinsicSize", "<init>", "(Z)V", "coil-svg_release"}, k = 1, mv = {1, 7, 1})
    public static final class b implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f8087a;

        public b() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public b(boolean z10) {
            this.f8087a = z10;
        }

        private final boolean b(l lVar) {
            return j.b(lVar.b(), "image/svg+xml") || o.a(d.f8092a, lVar.c().b());
        }

        public e a(l lVar, k kVar, ImageLoader imageLoader) {
            if (!b(lVar)) {
                return null;
            }
            return new SvgDecoder(lVar.c(), kVar, this.f8087a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b) || this.f8087a != ((b) obj).f8087a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f8087a);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? true : z10);
        }
    }
}
