package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

public class Ed448phSigner implements Signer {
    private final byte[] context;
    private boolean forSigning;
    private final Xof prehash = Ed448.createPrehash();
    private Ed448PrivateKeyParameters privateKey;
    private Ed448PublicKeyParameters publicKey;

    public Ed448phSigner(byte[] bArr) {
        this.context = Arrays.clone(bArr);
    }

    public byte[] generateSignature() {
        if (!this.forSigning || this.privateKey == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 == this.prehash.doFinal(bArr, 0, 64)) {
            byte[] bArr2 = new byte[114];
            this.privateKey.sign(1, this.context, bArr, 0, 64, bArr2, 0);
            return bArr2;
        }
        throw new IllegalStateException("Prehash digest failed");
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forSigning = z10;
        if (z10) {
            this.privateKey = (Ed448PrivateKeyParameters) cipherParameters;
            this.publicKey = null;
        } else {
            this.privateKey = null;
            this.publicKey = (Ed448PublicKeyParameters) cipherParameters;
        }
        reset();
    }

    public void reset() {
        this.prehash.reset();
    }

    public void update(byte b10) {
        this.prehash.update(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.prehash.update(bArr, i10, i11);
    }

    public boolean verifySignature(byte[] bArr) {
        Ed448PublicKeyParameters ed448PublicKeyParameters;
        if (this.forSigning || (ed448PublicKeyParameters = this.publicKey) == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for verification");
        } else if (114 != bArr.length) {
            this.prehash.reset();
            return false;
        } else {
            return Ed448.verifyPrehash(bArr, 0, ed448PublicKeyParameters.getEncoded(), 0, this.context, this.prehash);
        }
    }
}
