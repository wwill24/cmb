package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.j;

final class d extends ByteArrayOutputStream {
    public d(int i10) {
        super(i10);
    }

    public final byte[] a() {
        byte[] bArr = this.buf;
        j.f(bArr, "buf");
        return bArr;
    }
}
