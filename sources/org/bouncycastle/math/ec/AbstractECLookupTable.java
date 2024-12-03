package org.bouncycastle.math.ec;

public abstract class AbstractECLookupTable implements ECLookupTable {
    public ECPoint lookupVar(int i10) {
        return lookup(i10);
    }
}
