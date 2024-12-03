package org.bouncycastle.math.ec;

public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int i10);

    ECPoint lookupVar(int i10);
}
