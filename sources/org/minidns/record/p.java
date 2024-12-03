package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import ym.b;

public class p extends b {
    p(DnsName dnsName) {
        super(dnsName);
    }

    public static p i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new p(DnsName.v(dataInputStream, bArr));
    }
}
