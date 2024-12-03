package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public abstract class CipherSpiExt extends CipherSpi {
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    protected int opMode;

    public abstract int doFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return doFinal((byte[]) null, 0, 0);
    }

    public final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal(bArr, 0, bArr.length);
    }

    public abstract byte[] doFinal(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException;

    /* access modifiers changed from: protected */
    public final int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return doFinal(bArr, i10, i11, bArr2, i12);
    }

    /* access modifiers changed from: protected */
    public final byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal(bArr, i10, i11);
    }

    /* access modifiers changed from: protected */
    public final int engineGetBlockSize() {
        return getBlockSize();
    }

    /* access modifiers changed from: protected */
    public final byte[] engineGetIV() {
        return getIV();
    }

    /* access modifiers changed from: protected */
    public final int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof Key) {
            return getKeySize(key);
        }
        throw new InvalidKeyException("Unsupported key.");
    }

    /* access modifiers changed from: protected */
    public final int engineGetOutputSize(int i10) {
        return getOutputSize(i10);
    }

    /* access modifiers changed from: protected */
    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i10, key, secureRandom);
        } else {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        }
    }

    /* access modifiers changed from: protected */
    public final void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidParameterException(e10.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key != null) {
            this.opMode = i10;
            if (i10 == 1) {
                initEncrypt(key, algorithmParameterSpec, secureRandom);
            } else if (i10 == 2) {
                initDecrypt(key, algorithmParameterSpec);
            }
        } else {
            throw new InvalidKeyException();
        }
    }

    /* access modifiers changed from: protected */
    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        setMode(str);
    }

    /* access modifiers changed from: protected */
    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        setPadding(str);
    }

    /* access modifiers changed from: protected */
    public final int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException {
        return update(bArr, i10, i11, bArr2, i12);
    }

    /* access modifiers changed from: protected */
    public final byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        return update(bArr, i10, i11);
    }

    public abstract int getBlockSize();

    public abstract byte[] getIV();

    public abstract int getKeySize(Key key) throws InvalidKeyException;

    public abstract String getName();

    public abstract int getOutputSize(int i10);

    public abstract AlgorithmParameterSpec getParameters();

    public abstract void initDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void initEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* access modifiers changed from: protected */
    public abstract void setMode(String str) throws NoSuchAlgorithmException;

    /* access modifiers changed from: protected */
    public abstract void setPadding(String str) throws NoSuchPaddingException;

    public abstract int update(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException;

    public final byte[] update(byte[] bArr) {
        return update(bArr, 0, bArr.length);
    }

    public abstract byte[] update(byte[] bArr, int i10, int i11);
}
