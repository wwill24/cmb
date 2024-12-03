package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public interface XMSSPrivateKey extends XMSSKey, PrivateKey {
    XMSSPrivateKey extractKeyShard(int i10);

    long getIndex();

    long getUsagesRemaining();
}
