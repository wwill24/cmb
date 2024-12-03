package qi;

import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import com.withpersona.sdk2.inquiry.sandbox.a;
import fj.d;
import fj.g;
import okhttp3.u;

public final class e implements d<u> {

    /* renamed from: a  reason: collision with root package name */
    private final a f33773a;

    /* renamed from: b  reason: collision with root package name */
    private final fk.a<SandboxFlags> f33774b;

    public e(a aVar, fk.a<SandboxFlags> aVar2) {
        this.f33773a = aVar;
        this.f33774b = aVar2;
    }

    public static e a(a aVar, fk.a<SandboxFlags> aVar2) {
        return new e(aVar, aVar2);
    }

    public static u c(a aVar, SandboxFlags sandboxFlags) {
        return (u) g.e(aVar.b(sandboxFlags));
    }

    /* renamed from: b */
    public u get() {
        return c(this.f33773a, this.f33774b.get());
    }
}
