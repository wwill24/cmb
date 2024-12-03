package org.minidns.hla;

import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;

public class ResolutionUnsuccessfulException extends MiniDnsException {
    private static final long serialVersionUID = 1;
    public final a question;
    public final DnsMessage.RESPONSE_CODE responseCode;

    public ResolutionUnsuccessfulException(a aVar, DnsMessage.RESPONSE_CODE response_code) {
        super("Asking for " + aVar + " yielded an error response " + response_code);
        this.question = aVar;
        this.responseCode = response_code;
    }
}
