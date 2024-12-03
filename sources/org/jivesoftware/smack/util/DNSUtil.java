package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.dns.DNSResolver;
import org.jivesoftware.smack.util.dns.SmackDaneProvider;

public class DNSUtil {
    private static SmackDaneProvider daneProvider;
    private static DNSResolver dnsResolver;

    public static DNSResolver getDNSResolver() {
        return dnsResolver;
    }

    public static SmackDaneProvider getDaneProvider() {
        return daneProvider;
    }

    public static void setDNSResolver(DNSResolver dNSResolver) {
        dnsResolver = (DNSResolver) Objects.requireNonNull(dNSResolver);
    }

    public static void setDaneProvider(SmackDaneProvider smackDaneProvider) {
        daneProvider = (SmackDaneProvider) Objects.requireNonNull(smackDaneProvider);
    }
}
