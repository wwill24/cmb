package org.minidns.source;

import java.io.IOException;
import java.net.InetAddress;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

public interface a {

    /* renamed from: org.minidns.source.a$a  reason: collision with other inner class name */
    public interface C0502a {
        void a(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult);
    }

    DnsQueryResult a(DnsMessage dnsMessage, InetAddress inetAddress, int i10) throws IOException;

    int b();
}
