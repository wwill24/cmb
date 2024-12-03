package ig;

import ag.a;
import com.google.android.gms.common.api.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

abstract class k implements a {

    /* renamed from: a  reason: collision with root package name */
    private final i f23521a;

    /* renamed from: b  reason: collision with root package name */
    private final i f23522b;

    public k(byte[] bArr) throws InvalidKeyException {
        this.f23521a = g(bArr, 1);
        this.f23522b = g(bArr, 0);
    }

    private byte[] c(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= this.f23521a.g() + 16) {
            int position = byteBuffer.position();
            byte[] bArr2 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr2);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            byte[] bArr3 = new byte[this.f23521a.g()];
            byteBuffer.get(bArr3);
            if (bArr == null) {
                bArr = new byte[0];
            }
            try {
                q.f(e(bArr3), f(bArr, byteBuffer), bArr2);
                byteBuffer.position(position);
                return this.f23521a.e(byteBuffer);
            } catch (GeneralSecurityException e10) {
                throw new AEADBadTagException(e10.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }

    private void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr.length + this.f23521a.g() + 16) {
            int position = byteBuffer.position();
            this.f23521a.f(byteBuffer, bArr);
            byteBuffer.position(position);
            byte[] bArr3 = new byte[this.f23521a.g()];
            byteBuffer.get(bArr3);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] a10 = q.a(e(bArr3), f(bArr2, byteBuffer));
            byteBuffer.limit(byteBuffer.limit() + 16);
            byteBuffer.put(a10);
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    private byte[] e(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = new byte[32];
        this.f23522b.c(bArr, 0).get(bArr2);
        return bArr2;
    }

    private static byte[] f(byte[] bArr, ByteBuffer byteBuffer) {
        int i10;
        int i11;
        if (bArr.length % 16 == 0) {
            i10 = bArr.length;
        } else {
            i10 = (bArr.length + 16) - (bArr.length % 16);
        }
        int remaining = byteBuffer.remaining();
        int i12 = remaining % 16;
        if (i12 == 0) {
            i11 = remaining;
        } else {
            i11 = (remaining + 16) - i12;
        }
        int i13 = i11 + i10;
        ByteBuffer order = ByteBuffer.allocate(i13 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(i10);
        order.put(byteBuffer);
        order.position(i13);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }

    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length <= (a.e.API_PRIORITY_OTHER - this.f23521a.g()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.f23521a.g() + 16);
            d(allocate, bArr, bArr2);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return c(ByteBuffer.wrap(bArr), bArr2);
    }

    /* access modifiers changed from: package-private */
    public abstract i g(byte[] bArr, int i10) throws InvalidKeyException;
}
