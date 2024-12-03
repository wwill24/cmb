package mn;

import kn.b;
import org.bouncycastle.openpgp.PGPPublicKey;

public class a<O> extends b<O> {

    /* renamed from: a  reason: collision with root package name */
    private final b<O> f41286a;

    /* renamed from: b  reason: collision with root package name */
    private final b<O> f41287b;

    public a(b<O> bVar, b<O> bVar2) {
        this.f41286a = bVar;
        this.f41287b = bVar2;
    }

    /* renamed from: a */
    public boolean accept(O o10, PGPPublicKey pGPPublicKey) {
        return this.f41286a.accept(o10, pGPPublicKey) && this.f41287b.accept(o10, pGPPublicKey);
    }
}
