package org.jivesoftware.smackx.dox;

import java.io.IOException;
import org.minidns.dnsmessage.DnsMessage;

public interface DnsOverXmppResolver {
    DnsMessage resolve(DnsMessage dnsMessage) throws IOException;
}
