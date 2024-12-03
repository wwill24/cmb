package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

public final class XMSSMTPrivateKeyParameters extends XMSSMTKeyParameters implements XMSSStoreableObjectInterface, Encodable {
    private volatile BDSStateMap bdsState;
    private volatile long index;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;
    private volatile boolean used;

    public static class Builder {
        /* access modifiers changed from: private */
        public BDSStateMap bdsState = null;
        /* access modifiers changed from: private */
        public long index = 0;
        /* access modifiers changed from: private */
        public long maxIndex = -1;
        /* access modifiers changed from: private */
        public final XMSSMTParameters params;
        /* access modifiers changed from: private */
        public byte[] privateKey = null;
        /* access modifiers changed from: private */
        public byte[] publicSeed = null;
        /* access modifiers changed from: private */
        public byte[] root = null;
        /* access modifiers changed from: private */
        public byte[] secretKeyPRF = null;
        /* access modifiers changed from: private */
        public byte[] secretKeySeed = null;
        /* access modifiers changed from: private */
        public XMSSParameters xmss = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.params = xMSSMTParameters;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this);
        }

        public Builder withBDSState(BDSStateMap bDSStateMap) {
            if (bDSStateMap.getMaxIndex() == 0) {
                this.bdsState = new BDSStateMap(bDSStateMap, (1 << this.params.getHeight()) - 1);
            } else {
                this.bdsState = bDSStateMap;
            }
            return this;
        }

        public Builder withIndex(long j10) {
            this.index = j10;
            return this;
        }

        public Builder withMaxIndex(long j10) {
            this.maxIndex = j10;
            return this;
        }

        public Builder withPrivateKey(byte[] bArr) {
            this.privateKey = XMSSUtil.cloneArray(bArr);
            this.xmss = this.params.getXMSSParameters();
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSMTPrivateKeyParameters(Builder builder) {
        super(true, builder.params.getTreeDigest());
        XMSSMTParameters access$000 = builder.params;
        this.params = access$000;
        if (access$000 != null) {
            int treeDigestSize = access$000.getTreeDigestSize();
            byte[] access$100 = builder.privateKey;
            if (access$100 == null) {
                this.index = builder.index;
                byte[] access$400 = builder.secretKeySeed;
                if (access$400 == null) {
                    this.secretKeySeed = new byte[treeDigestSize];
                } else if (access$400.length == treeDigestSize) {
                    this.secretKeySeed = access$400;
                } else {
                    throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
                }
                byte[] access$500 = builder.secretKeyPRF;
                if (access$500 == null) {
                    this.secretKeyPRF = new byte[treeDigestSize];
                } else if (access$500.length == treeDigestSize) {
                    this.secretKeyPRF = access$500;
                } else {
                    throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
                }
                byte[] access$600 = builder.publicSeed;
                if (access$600 == null) {
                    this.publicSeed = new byte[treeDigestSize];
                } else if (access$600.length == treeDigestSize) {
                    this.publicSeed = access$600;
                } else {
                    throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
                }
                byte[] access$700 = builder.root;
                if (access$700 == null) {
                    this.root = new byte[treeDigestSize];
                } else if (access$700.length == treeDigestSize) {
                    this.root = access$700;
                } else {
                    throw new IllegalArgumentException("size of root needs to be equal size of digest");
                }
                BDSStateMap access$800 = builder.bdsState;
                if (access$800 == null) {
                    access$800 = (!XMSSUtil.isIndexValid(access$000.getHeight(), builder.index) || access$600 == null || access$400 == null) ? new BDSStateMap(builder.maxIndex + 1) : new BDSStateMap(access$000, builder.index, access$600, access$400);
                }
                this.bdsState = access$800;
                if (builder.maxIndex >= 0 && builder.maxIndex != this.bdsState.getMaxIndex()) {
                    throw new IllegalArgumentException("maxIndex set but not reflected in state");
                }
            } else if (builder.xmss != null) {
                int height = access$000.getHeight();
                int i10 = (height + 7) / 8;
                this.index = XMSSUtil.bytesToXBigEndian(access$100, 0, i10);
                if (XMSSUtil.isIndexValid(height, this.index)) {
                    int i11 = i10 + 0;
                    this.secretKeySeed = XMSSUtil.extractBytesAtOffset(access$100, i11, treeDigestSize);
                    int i12 = i11 + treeDigestSize;
                    this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(access$100, i12, treeDigestSize);
                    int i13 = i12 + treeDigestSize;
                    this.publicSeed = XMSSUtil.extractBytesAtOffset(access$100, i13, treeDigestSize);
                    int i14 = i13 + treeDigestSize;
                    this.root = XMSSUtil.extractBytesAtOffset(access$100, i14, treeDigestSize);
                    int i15 = i14 + treeDigestSize;
                    try {
                        this.bdsState = ((BDSStateMap) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(access$100, i15, access$100.length - i15), BDSStateMap.class)).withWOTSDigest(builder.xmss.getTreeDigestOID());
                    } catch (IOException e10) {
                        throw new IllegalArgumentException(e10.getMessage(), e10);
                    } catch (ClassNotFoundException e11) {
                        throw new IllegalArgumentException(e11.getMessage(), e11);
                    }
                } else {
                    throw new IllegalArgumentException("index out of bounds");
                }
            } else {
                throw new NullPointerException("xmss == null");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public XMSSMTPrivateKeyParameters extractKeyShard(int i10) {
        XMSSMTPrivateKeyParameters build;
        if (i10 >= 1) {
            synchronized (this) {
                long j10 = (long) i10;
                if (j10 <= getUsagesRemaining()) {
                    build = new Builder(this.params).withSecretKeySeed(this.secretKeySeed).withSecretKeyPRF(this.secretKeyPRF).withPublicSeed(this.publicSeed).withRoot(this.root).withIndex(getIndex()).withBDSState(new BDSStateMap(this.bdsState, (getIndex() + j10) - 1)).build();
                    for (int i11 = 0; i11 != i10; i11++) {
                        rollKey();
                    }
                } else {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining");
                }
            }
            return build;
        }
        throw new IllegalArgumentException("cannot ask for a shard with 0 keys");
    }

    /* access modifiers changed from: package-private */
    public BDSStateMap getBDSState() {
        return this.bdsState;
    }

    public byte[] getEncoded() throws IOException {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public long getIndex() {
        return this.index;
    }

    public XMSSMTPrivateKeyParameters getNextKey() {
        XMSSMTPrivateKeyParameters extractKeyShard;
        synchronized (this) {
            extractKeyShard = extractKeyShard(1);
        }
        return extractKeyShard;
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }

    public byte[] getPublicSeed() {
        return XMSSUtil.cloneArray(this.publicSeed);
    }

    public byte[] getRoot() {
        return XMSSUtil.cloneArray(this.root);
    }

    public byte[] getSecretKeyPRF() {
        return XMSSUtil.cloneArray(this.secretKeyPRF);
    }

    public byte[] getSecretKeySeed() {
        return XMSSUtil.cloneArray(this.secretKeySeed);
    }

    public long getUsagesRemaining() {
        long maxIndex;
        synchronized (this) {
            maxIndex = (this.bdsState.getMaxIndex() - getIndex()) + 1;
        }
        return maxIndex;
    }

    /* access modifiers changed from: package-private */
    public XMSSMTPrivateKeyParameters rollKey() {
        synchronized (this) {
            if (getIndex() < this.bdsState.getMaxIndex()) {
                this.bdsState.updateState(this.params, this.index, this.publicSeed, this.secretKeySeed);
                this.index++;
            } else {
                this.index = this.bdsState.getMaxIndex() + 1;
                this.bdsState = new BDSStateMap(this.bdsState.getMaxIndex());
            }
            this.used = false;
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] concatenate;
        synchronized (this) {
            int treeDigestSize = this.params.getTreeDigestSize();
            int height = (this.params.getHeight() + 7) / 8;
            byte[] bArr = new byte[(height + treeDigestSize + treeDigestSize + treeDigestSize + treeDigestSize)];
            XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.index, height), 0);
            int i10 = height + 0;
            XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, i10);
            int i11 = i10 + treeDigestSize;
            XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i11);
            int i12 = i11 + treeDigestSize;
            XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i12);
            XMSSUtil.copyBytesAtOffset(bArr, this.root, i12 + treeDigestSize);
            try {
                concatenate = Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
            } catch (IOException e10) {
                throw new IllegalStateException("error serializing bds state: " + e10.getMessage(), e10);
            }
        }
        return concatenate;
    }
}
