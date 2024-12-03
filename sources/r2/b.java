package r2;

import coil.request.d;
import coil.request.h;
import coil.request.n;
import kotlin.Metadata;
import r2.c;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lr2/b;", "Lr2/c;", "", "a", "Lr2/d;", "Lr2/d;", "target", "Lcoil/request/h;", "b", "Lcoil/request/h;", "result", "<init>", "(Lr2/d;Lcoil/request/h;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d f17256a;

    /* renamed from: b  reason: collision with root package name */
    private final h f17257b;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0010"}, d2 = {"Lr2/b$a;", "Lr2/c$a;", "Lr2/d;", "target", "Lcoil/request/h;", "result", "Lr2/c;", "a", "", "other", "", "equals", "", "hashCode", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements c.a {
        public c a(d dVar, h hVar) {
            return new b(dVar, hVar);
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public b(d dVar, h hVar) {
        this.f17256a = dVar;
        this.f17257b = hVar;
    }

    public void a() {
        h hVar = this.f17257b;
        if (hVar instanceof n) {
            this.f17256a.a(((n) hVar).a());
        } else if (hVar instanceof d) {
            this.f17256a.c(hVar.a());
        }
    }
}
