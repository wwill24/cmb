package org.minidns.iterative;

import java.net.InetAddress;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;

public abstract class IterativeClientException extends MiniDnsException {
    private static final long serialVersionUID = 1;

    public static class LoopDetected extends IterativeClientException {
        private static final long serialVersionUID = 1;
        public final InetAddress address;
        public final a question;

        public LoopDetected(InetAddress inetAddress, a aVar) {
            super("Resolution loop detected: We already asked " + inetAddress + " about " + aVar);
            this.address = inetAddress;
            this.question = aVar;
        }
    }

    public static class MaxIterativeStepsReached extends IterativeClientException {
        private static final long serialVersionUID = 1;

        public MaxIterativeStepsReached() {
            super("Maxmimum steps reached");
        }
    }

    public static class NotAuthoritativeNorGlueRrFound extends IterativeClientException {
        private static final long serialVersionUID = 1;
        private final DnsName authoritativeZone;
        private final DnsMessage request;
        private final DnsQueryResult result;

        public NotAuthoritativeNorGlueRrFound(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName) {
            super("Did not receive an authoritative answer, nor did the result contain any glue records");
            this.request = dnsMessage;
            this.result = dnsQueryResult;
            this.authoritativeZone = dnsName;
        }
    }

    protected IterativeClientException(String str) {
        super(str);
    }
}
