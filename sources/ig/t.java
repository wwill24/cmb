package ig;

import ag.i;
import gg.a;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public class t implements i {

    /* renamed from: a  reason: collision with root package name */
    private final a f23546a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23547b;

    public t(a aVar, int i10) throws GeneralSecurityException {
        this.f23546a = aVar;
        this.f23547b = i10;
        if (i10 >= 10) {
            aVar.a(new byte[0], i10);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!g.b(b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    public byte[] b(byte[] bArr) throws GeneralSecurityException {
        return this.f23546a.a(bArr, this.f23547b);
    }
}
