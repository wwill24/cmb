package nm;

import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;

public abstract class a {
    public final org.minidns.dnsqueryresult.a a(DnsMessage dnsMessage) {
        return b(dnsMessage.c());
    }

    /* access modifiers changed from: protected */
    public abstract org.minidns.dnsqueryresult.a b(DnsMessage dnsMessage);

    public abstract void c(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName);

    public final void d(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        e(dnsMessage.c(), dnsQueryResult);
    }

    /* access modifiers changed from: protected */
    public abstract void e(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult);
}
