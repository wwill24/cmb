package ig;

import ag.a;
import ag.i;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private final p f23523a;

    /* renamed from: b  reason: collision with root package name */
    private final i f23524b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23525c;

    public l(p pVar, i iVar, int i10) {
        this.f23523a = pVar;
        this.f23524b = iVar;
        this.f23525c = i10;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] a10 = this.f23523a.a(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return g.a(a10, this.f23524b.b(g.a(bArr2, a10, copyOf)));
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f23525c;
        if (length >= i10) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i10);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.f23525c, bArr.length);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            this.f23524b.a(copyOfRange2, g.a(bArr2, copyOfRange, copyOf));
            return this.f23523a.b(copyOfRange);
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
