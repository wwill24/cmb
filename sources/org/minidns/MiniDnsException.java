package org.minidns;

import java.io.IOException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

public abstract class MiniDnsException extends IOException {
    private static final long serialVersionUID = 1;

    public static class ErrorResponseException extends MiniDnsException {
        private static final long serialVersionUID = 1;
        private final DnsMessage request;
        private final DnsQueryResult result;

        public ErrorResponseException(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
            super("Received " + dnsQueryResult.f33670c.f33584c + " error response\n" + dnsQueryResult);
            this.request = dnsMessage;
            this.result = dnsQueryResult;
        }
    }

    public static class IdMismatch extends MiniDnsException {
        private static final long serialVersionUID = 1;
        private final DnsMessage request;
        private final DnsMessage response;

        static {
            Class<MiniDnsException> cls = MiniDnsException.class;
        }

        public IdMismatch(DnsMessage dnsMessage, DnsMessage dnsMessage2) {
            super(a(dnsMessage, dnsMessage2));
            this.request = dnsMessage;
            this.response = dnsMessage2;
        }

        private static String a(DnsMessage dnsMessage, DnsMessage dnsMessage2) {
            return "The response's ID doesn't matches the request ID. Request: " + dnsMessage.f33582a + ". Response: " + dnsMessage2.f33582a;
        }
    }

    public static class NoQueryPossibleException extends MiniDnsException {
        private static final long serialVersionUID = 1;
        private final DnsMessage request;

        public NoQueryPossibleException(DnsMessage dnsMessage) {
            super("No DNS server could be queried");
            this.request = dnsMessage;
        }
    }

    public static class NullResultException extends MiniDnsException {
        private static final long serialVersionUID = 1;
        private final DnsMessage request;

        public NullResultException(DnsMessage dnsMessage) {
            super("The request yielded a 'null' result while resolving.");
            this.request = dnsMessage;
        }
    }

    protected MiniDnsException(String str) {
        super(str);
    }
}
