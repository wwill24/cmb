package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;

public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;
    private final int height;
    private final byte[] value;

    protected XMSSNode(int i10, byte[] bArr) {
        this.height = i10;
        this.value = bArr;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getValue() {
        return XMSSUtil.cloneArray(this.value);
    }
}
