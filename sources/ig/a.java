package ig;

import com.google.android.gms.common.api.a;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a implements p {

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f23484d = new C0281a();

    /* renamed from: a  reason: collision with root package name */
    private final SecretKeySpec f23485a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23486b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23487c;

    /* renamed from: ig.a$a  reason: collision with other inner class name */
    class C0281a extends ThreadLocal<Cipher> {
        C0281a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return m.f23528f.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public a(byte[] bArr, int i10) throws GeneralSecurityException {
        w.a(bArr.length);
        this.f23485a = new SecretKeySpec(bArr, "AES");
        int blockSize = f23484d.get().getBlockSize();
        this.f23487c = blockSize;
        if (i10 < 12 || i10 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f23486b = i10;
    }

    private void c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, byte[] bArr3, boolean z10) throws GeneralSecurityException {
        Cipher cipher = f23484d.get();
        byte[] bArr4 = new byte[this.f23487c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f23486b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z10) {
            cipher.init(1, this.f23485a, ivParameterSpec);
        } else {
            cipher.init(2, this.f23485a, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i10, i11, bArr2, i12) != i11) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    public byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f23486b;
        if (length <= a.e.API_PRIORITY_OTHER - i10) {
            byte[] bArr2 = new byte[(bArr.length + i10)];
            byte[] c10 = u.c(i10);
            System.arraycopy(c10, 0, bArr2, 0, this.f23486b);
            c(bArr, 0, bArr.length, bArr2, this.f23486b, c10, true);
            return bArr2;
        }
        throw new GeneralSecurityException("plaintext length can not exceed " + (a.e.API_PRIORITY_OTHER - this.f23486b));
    }

    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f23486b;
        if (length >= i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, i10);
            int length2 = bArr.length;
            int i11 = this.f23486b;
            byte[] bArr3 = new byte[(length2 - i11)];
            c(bArr, i11, bArr.length - i11, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
