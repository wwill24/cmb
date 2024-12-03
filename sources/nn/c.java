package nn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import qn.b;

public abstract class c<O> implements a<PGPSecretKeyRing, PGPSecretKeyRingCollection, O> {
    public b<O, PGPSecretKeyRing> selectKeyRingsFromCollections(b<O, PGPSecretKeyRingCollection> bVar) {
        b<O, PGPSecretKeyRing> bVar2 = new b<>();
        for (O next : bVar.b()) {
            for (PGPSecretKeyRingCollection selectKeyRingsFromCollection : bVar.a(next)) {
                bVar2.d(next, selectKeyRingsFromCollection(next, selectKeyRingsFromCollection));
            }
        }
        return bVar2;
    }

    public Set<PGPSecretKeyRing> selectKeyRingsFromCollection(O o10, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) {
        HashSet hashSet = new HashSet();
        Iterator keyRings = pGPSecretKeyRingCollection.getKeyRings();
        while (keyRings.hasNext()) {
            PGPSecretKeyRing pGPSecretKeyRing = (PGPSecretKeyRing) keyRings.next();
            if (accept(o10, pGPSecretKeyRing)) {
                hashSet.add(pGPSecretKeyRing);
            }
        }
        return hashSet;
    }
}
