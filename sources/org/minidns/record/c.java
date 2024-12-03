package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import ym.b;

public class c extends b {
    public c(DnsName dnsName) {
        super(dnsName);
    }

    public static c i(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new c(DnsName.v(dataInputStream, bArr));
    }
}
