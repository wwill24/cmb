package mn;

import kn.c;
import org.bouncycastle.openpgp.PGPSecretKey;

public class b<O> extends c<O> {

    /* renamed from: a  reason: collision with root package name */
    private final c<O> f41288a;

    /* renamed from: b  reason: collision with root package name */
    private final c<O> f41289b;

    public b(c<O> cVar, c<O> cVar2) {
        this.f41288a = cVar;
        this.f41289b = cVar2;
    }

    /* renamed from: a */
    public boolean accept(O o10, PGPSecretKey pGPSecretKey) {
        return this.f41288a.accept(o10, pGPSecretKey) && this.f41289b.accept(o10, pGPSecretKey);
    }
}
