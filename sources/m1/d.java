package m1;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import m1.a;

public final class d extends a {
    public d() {
        this((a) null, 1, (DefaultConstructorMarker) null);
    }

    public d(a aVar) {
        j.g(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public <T> T a(a.b<T> bVar) {
        j.g(bVar, SDKConstants.PARAM_KEY);
        return b().get(bVar);
    }

    public final <T> void c(a.b<T> bVar, T t10) {
        j.g(bVar, SDKConstants.PARAM_KEY);
        b().put(bVar, t10);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(a aVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? a.C0171a.f16279b : aVar);
    }
}
