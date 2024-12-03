package org.bouncycastle.crypto.signers;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

public class Ed25519ctxSigner implements Signer {
    private final Buffer buffer = new Buffer();
    private final byte[] context;
    private boolean forSigning;
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    private static class Buffer extends ByteArrayOutputStream {
        private Buffer() {
        }

        /* access modifiers changed from: package-private */
        public synchronized byte[] generateSignature(Ed25519PrivateKeyParameters ed25519PrivateKeyParameters, byte[] bArr) {
            byte[] bArr2;
            bArr2 = new byte[64];
            ed25519PrivateKeyParameters.sign(1, bArr, this.buf, 0, this.count, bArr2, 0);
            reset();
            return bArr2;
        }

        public synchronized void reset() {
            Arrays.fill(this.buf, 0, this.count, (byte) 0);
            this.count = 0;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean verifySignature(Ed25519PublicKeyParameters ed25519PublicKeyParameters, byte[] bArr, byte[] bArr2) {
            if (64 != bArr2.length) {
                reset();
                return false;
            }
            boolean verify = Ed25519.verify(bArr2, 0, ed25519PublicKeyParameters.getEncoded(), 0, bArr, this.buf, 0, this.count);
            reset();
            return verify;
        }
    }

    public Ed25519ctxSigner(byte[] bArr) {
        this.context = Arrays.clone(bArr);
    }

    public byte[] generateSignature() {
        Ed25519PrivateKeyParameters ed25519PrivateKeyParameters;
        if (this.forSigning && (ed25519PrivateKeyParameters = this.privateKey) != null) {
            return this.buffer.generateSignature(ed25519PrivateKeyParameters, this.context);
        }
        throw new IllegalStateException("Ed25519ctxSigner not initialised for signature generation.");
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        this.forSigning = z10;
        if (z10) {
            this.privateKey = (Ed25519PrivateKeyParameters) cipherParameters;
            this.publicKey = null;
        } else {
            this.privateKey = null;
            this.publicKey = (Ed25519PublicKeyParameters) cipherParameters;
        }
        reset();
    }

    public void reset() {
        this.buffer.reset();
    }

    public void update(byte b10) {
        this.buffer.write(b10);
    }

    public void update(byte[] bArr, int i10, int i11) {
        this.buffer.write(bArr, i10, i11);
    }

    public boolean verifySignature(byte[] bArr) {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        if (!this.forSigning && (ed25519PublicKeyParameters = this.publicKey) != null) {
            return this.buffer.verifySignature(ed25519PublicKeyParameters, this.context, bArr);
        }
        throw new IllegalStateException("Ed25519ctxSigner not initialised for verification");
    }
}
