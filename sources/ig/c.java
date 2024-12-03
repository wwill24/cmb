package ig;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class c implements ag.a {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f23494b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final SecretKey f23495a;

    class a extends ThreadLocal<Cipher> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return m.f23528f.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public c(byte[] bArr) throws GeneralSecurityException {
        w.a(bArr.length);
        this.f23495a = new SecretKeySpec(bArr, "AES");
    }

    private static AlgorithmParameterSpec c(byte[] bArr) throws GeneralSecurityException {
        return d(bArr, 0, bArr.length);
    }

    private static AlgorithmParameterSpec d(byte[] bArr, int i10, int i11) throws GeneralSecurityException {
        if (!v.b() || v.a() > 19) {
            return new GCMParameterSpec(128, bArr, i10, i11);
        }
        return new IvParameterSpec(bArr, i10, i11);
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= 2147483619) {
            byte[] bArr3 = new byte[(bArr.length + 12 + 16)];
            byte[] c10 = u.c(12);
            System.arraycopy(c10, 0, bArr3, 0, 12);
            AlgorithmParameterSpec c11 = c(c10);
            ThreadLocal<Cipher> threadLocal = f23494b;
            threadLocal.get().init(1, this.f23495a, c11);
            if (!(bArr2 == null || bArr2.length == 0)) {
                threadLocal.get().updateAAD(bArr2);
            }
            int doFinal = threadLocal.get().doFinal(bArr, 0, bArr.length, bArr3, 12);
            if (doFinal == bArr.length + 16) {
                return bArr3;
            }
            throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - bArr.length)}));
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length >= 28) {
            AlgorithmParameterSpec d10 = d(bArr, 0, 12);
            ThreadLocal<Cipher> threadLocal = f23494b;
            threadLocal.get().init(2, this.f23495a, d10);
            if (!(bArr2 == null || bArr2.length == 0)) {
                threadLocal.get().updateAAD(bArr2);
            }
            return threadLocal.get().doFinal(bArr, 12, bArr.length - 12);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
