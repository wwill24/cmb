package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;

public class a extends ym.a<Inet4Address> {
    public a(Inet4Address inet4Address) {
        super(inet4Address);
    }

    public static a l(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return new a(bArr);
    }

    public String toString() {
        return Integer.toString(this.f42184c[0] & 255) + "." + Integer.toString(this.f42184c[1] & 255) + "." + Integer.toString(this.f42184c[2] & 255) + "." + Integer.toString(this.f42184c[3] & 255);
    }

    public a(byte[] bArr) {
        super(bArr);
        if (bArr.length != 4) {
            throw new IllegalArgumentException("IPv4 address in A record is always 4 byte");
        }
    }
}
