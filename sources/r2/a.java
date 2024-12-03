package r2;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.request.d;
import coil.request.h;
import coil.request.n;
import coil.size.Scale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l2.b;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0003B-\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lr2/a;", "Lr2/c;", "", "a", "Lr2/d;", "Lr2/d;", "target", "Lcoil/request/h;", "b", "Lcoil/request/h;", "result", "", "c", "I", "getDurationMillis", "()I", "durationMillis", "", "d", "Z", "getPreferExactIntrinsicSize", "()Z", "preferExactIntrinsicSize", "<init>", "(Lr2/d;Lcoil/request/h;IZ)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f17250a;

    /* renamed from: b  reason: collision with root package name */
    private final h f17251b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17252c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17253d;

    public a(d dVar, h hVar, int i10, boolean z10) {
        boolean z11;
        this.f17250a = dVar;
        this.f17251b = hVar;
        this.f17252c = i10;
        this.f17253d = z10;
        if (i10 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("durationMillis must be > 0.".toString());
        }
    }

    public void a() {
        boolean z10;
        Drawable d10 = this.f17250a.d();
        Drawable a10 = this.f17251b.a();
        Scale J = this.f17251b.b().J();
        int i10 = this.f17252c;
        h hVar = this.f17251b;
        if (!(hVar instanceof n) || !((n) hVar).d()) {
            z10 = true;
        } else {
            z10 = false;
        }
        b bVar = new b(d10, a10, J, i10, z10, this.f17253d);
        h hVar2 = this.f17251b;
        if (hVar2 instanceof n) {
            this.f17250a.a(bVar);
        } else if (hVar2 instanceof d) {
            this.f17250a.c(bVar);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lr2/a$a;", "Lr2/c$a;", "Lr2/d;", "target", "Lcoil/request/h;", "result", "Lr2/c;", "a", "", "other", "", "equals", "", "hashCode", "c", "I", "getDurationMillis", "()I", "durationMillis", "d", "Z", "getPreferExactIntrinsicSize", "()Z", "preferExactIntrinsicSize", "<init>", "(IZ)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: r2.a$a  reason: collision with other inner class name */
    public static final class C0197a implements c.a {

        /* renamed from: c  reason: collision with root package name */
        private final int f17254c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f17255d;

        public C0197a() {
            this(0, false, 3, (DefaultConstructorMarker) null);
        }

        public C0197a(int i10, boolean z10) {
            this.f17254c = i10;
            this.f17255d = z10;
            if (!(i10 > 0)) {
                throw new IllegalArgumentException("durationMillis must be > 0.".toString());
            }
        }

        public c a(d dVar, h hVar) {
            if (!(hVar instanceof n)) {
                return c.a.f17259b.a(dVar, hVar);
            }
            if (((n) hVar).c() == DataSource.MEMORY_CACHE) {
                return c.a.f17259b.a(dVar, hVar);
            }
            return new a(dVar, hVar, this.f17254c, this.f17255d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0197a) {
                C0197a aVar = (C0197a) obj;
                if (this.f17254c == aVar.f17254c && this.f17255d == aVar.f17255d) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (this.f17254c * 31) + Boolean.hashCode(this.f17255d);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C0197a(int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? 100 : i10, (i11 & 2) != 0 ? false : z10);
        }
    }
}
