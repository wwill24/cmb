package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet6Address;
import ym.a;

public class b extends a<Inet6Address> {
    public b(Inet6Address inet6Address) {
        super(inet6Address);
    }

    public static b l(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[16];
        dataInputStream.readFully(bArr);
        return new b(bArr);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f42184c.length; i10 += 2) {
            if (i10 != 0) {
                sb2.append(':');
            }
            byte[] bArr = this.f42184c;
            sb2.append(Integer.toHexString(((bArr[i10] & 255) << 8) + (bArr[i10 + 1] & 255)));
        }
        return sb2.toString();
    }

    public b(byte[] bArr) {
        super(bArr);
        if (bArr.length != 16) {
            throw new IllegalArgumentException("IPv6 address in AAAA record is always 16 byte");
        }
    }
}
