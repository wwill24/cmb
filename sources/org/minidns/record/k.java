package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import ym.b;

public class k extends b {
    public k(DnsName dnsName) {
        super(dnsName);
    }

    public static k i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new k(DnsName.v(dataInputStream, bArr));
    }
}
