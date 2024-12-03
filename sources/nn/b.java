package nn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;

public abstract class b<O> implements a<PGPPublicKeyRing, PGPPublicKeyRingCollection, O> {
    public qn.b<O, PGPPublicKeyRing> selectKeyRingsFromCollections(qn.b<O, PGPPublicKeyRingCollection> bVar) {
        qn.b<O, PGPPublicKeyRing> bVar2 = new qn.b<>();
        for (O next : bVar.b()) {
            for (PGPPublicKeyRingCollection selectKeyRingsFromCollection : bVar.a(next)) {
                bVar2.d(next, selectKeyRingsFromCollection(next, selectKeyRingsFromCollection));
            }
        }
        return bVar2;
    }

    public Set<PGPPublicKeyRing> selectKeyRingsFromCollection(O o10, PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
        HashSet hashSet = new HashSet();
        Iterator keyRings = pGPPublicKeyRingCollection.getKeyRings();
        while (keyRings.hasNext()) {
            PGPPublicKeyRing pGPPublicKeyRing = (PGPPublicKeyRing) keyRings.next();
            if (accept(o10, pGPPublicKeyRing)) {
                hashSet.add(pGPPublicKeyRing);
            }
        }
        return hashSet;
    }
}
