package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import ym.b;

public class e extends b {
    public e(DnsName dnsName) {
        super(dnsName);
    }

    public static e i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new e(DnsName.v(dataInputStream, bArr));
    }
}
