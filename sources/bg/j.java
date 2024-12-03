package bg;

import ag.a;
import com.google.crypto.tink.g;
import hg.x;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class j implements a {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f18921c = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final x f18922a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18923b;

    public j(x xVar, a aVar) {
        this.f18922a = xVar;
        this.f18923b = aVar;
    }

    private byte[] c(byte[] bArr, byte[] bArr2) {
        return ByteBuffer.allocate(bArr.length + 4 + bArr2.length).putInt(bArr.length).put(bArr).put(bArr2).array();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = g.o(this.f18922a).toByteArray();
        return c(this.f18923b.a(byteArray, f18921c), ((a) g.i(this.f18922a.I(), byteArray, a.class)).a(bArr, bArr2));
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i10 = wrap.getInt();
            if (i10 <= 0 || i10 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i10];
            wrap.get(bArr3, 0, i10);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((a) g.i(this.f18922a.I(), this.f18923b.b(bArr3, f18921c), a.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }
}
