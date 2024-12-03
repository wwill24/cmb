package ig;

import com.google.android.gms.common.api.a;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b implements ag.a {

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f23488e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<Cipher> f23489f = new C0282b();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f23490a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f23491b;

    /* renamed from: c  reason: collision with root package name */
    private final SecretKeySpec f23492c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23493d;

    class a extends ThreadLocal<Cipher> {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return m.f23528f.a("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    /* renamed from: ig.b$b  reason: collision with other inner class name */
    class C0282b extends ThreadLocal<Cipher> {
        C0282b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Cipher initialValue() {
            try {
                return m.f23528f.a("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public b(byte[] bArr, int i10) throws GeneralSecurityException {
        if (i10 == 12 || i10 == 16) {
            this.f23493d = i10;
            w.a(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f23492c = secretKeySpec;
            Cipher cipher = f23488e.get();
            cipher.init(1, secretKeySpec);
            byte[] c10 = c(cipher.doFinal(new byte[16]));
            this.f23490a = c10;
            this.f23491b = c(c10);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i10 = 0;
        int i11 = 0;
        while (i11 < 15) {
            int i12 = i11 + 1;
            bArr2[i11] = (byte) (((bArr[i11] << 1) ^ ((bArr[i12] & 255) >>> 7)) & 255);
            i11 = i12;
        }
        int i13 = bArr[15] << 1;
        if ((bArr[0] & 128) != 0) {
            i10 = 135;
        }
        bArr2[15] = (byte) (i13 ^ i10);
        return bArr2;
    }

    private byte[] d(Cipher cipher, int i10, byte[] bArr, int i11, int i12) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i10;
        if (i12 == 0) {
            return cipher.doFinal(f(bArr2, this.f23490a));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i13 = 0;
        while (i12 - i13 > 16) {
            for (int i14 = 0; i14 < 16; i14++) {
                doFinal[i14] = (byte) (doFinal[i14] ^ bArr[(i11 + i13) + i14]);
            }
            doFinal = cipher.doFinal(doFinal);
            i13 += 16;
        }
        return cipher.doFinal(f(doFinal, e(Arrays.copyOfRange(bArr, i13 + i11, i11 + i12))));
    }

    private byte[] e(byte[] bArr) {
        if (bArr.length == 16) {
            return f(bArr, this.f23490a);
        }
        byte[] copyOf = Arrays.copyOf(this.f23491b, 16);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            copyOf[i10] = (byte) (copyOf[i10] ^ bArr[i10]);
        }
        copyOf[bArr.length] = (byte) (copyOf[bArr.length] ^ 128);
        return copyOf;
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4 = bArr;
        int length = bArr4.length;
        int i10 = this.f23493d;
        if (length <= (a.e.API_PRIORITY_OTHER - i10) - 16) {
            byte[] bArr5 = new byte[(bArr4.length + i10 + 16)];
            byte[] c10 = u.c(i10);
            System.arraycopy(c10, 0, bArr5, 0, this.f23493d);
            Cipher cipher = f23488e.get();
            cipher.init(1, this.f23492c);
            byte[] d10 = d(cipher, 0, c10, 0, c10.length);
            if (bArr2 == null) {
                bArr3 = new byte[0];
            } else {
                bArr3 = bArr2;
            }
            byte[] d11 = d(cipher, 1, bArr3, 0, bArr3.length);
            Cipher cipher2 = f23489f.get();
            cipher2.init(1, this.f23492c, new IvParameterSpec(d10));
            cipher2.doFinal(bArr, 0, bArr4.length, bArr5, this.f23493d);
            byte[] d12 = d(cipher, 2, bArr5, this.f23493d, bArr4.length);
            int length2 = bArr4.length + this.f23493d;
            for (int i11 = 0; i11 < 16; i11++) {
                bArr5[length2 + i11] = (byte) ((d11[i11] ^ d10[i11]) ^ d12[i11]);
            }
            return bArr5;
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.f23493d) - 16;
        if (length >= 0) {
            Cipher cipher = f23488e.get();
            cipher.init(1, this.f23492c);
            byte[] d10 = d(cipher, 0, bArr, 0, this.f23493d);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] d11 = d(cipher, 1, bArr3, 0, bArr3.length);
            byte[] d12 = d(cipher, 2, bArr, this.f23493d, length);
            int length2 = bArr.length - 16;
            byte b10 = 0;
            for (int i10 = 0; i10 < 16; i10++) {
                b10 = (byte) (b10 | (((bArr[length2 + i10] ^ d11[i10]) ^ d10[i10]) ^ d12[i10]));
            }
            if (b10 == 0) {
                Cipher cipher2 = f23489f.get();
                cipher2.init(1, this.f23492c, new IvParameterSpec(d10));
                return cipher2.doFinal(bArr, this.f23493d, length);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
