package org.jivesoftware.smack.util;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.minidns.dnslabel.DnsLabel;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsname.InvalidDnsNameException;
import zm.e;

public abstract class InternetAddress implements CharSequence {
    protected final String originalString;

    public static final class DomainName extends NonNumericInternetAddress {
        private final DnsName dnsName;

        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        public DnsName getDnsName() {
            return this.dnsName;
        }

        private DomainName(String str, DnsName dnsName2) {
            super(str);
            this.dnsName = dnsName2;
        }
    }

    public static final class DomainNameLabel extends NonNumericInternetAddress {
        private final DnsLabel dnsLabel;

        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        public DnsLabel getDnsLabel() {
            return this.dnsLabel;
        }

        private DomainNameLabel(String str, DnsLabel dnsLabel2) {
            super(str);
            this.dnsLabel = dnsLabel2;
        }
    }

    private static class InetAddressInternetAddress extends InternetAddress {
        private final InetAddress inetAddress;

        protected InetAddressInternetAddress(String str, InetAddress inetAddress2) {
            super(str);
            this.inetAddress = inetAddress2;
        }

        public InetAddress asInetAddress() {
            return this.inetAddress;
        }
    }

    public static final class InvalidDomainName extends NonNumericInternetAddress {
        private final InvalidDnsNameException invalidDnsNameException;

        public /* bridge */ /* synthetic */ InetAddress asInetAddress() throws UnknownHostException {
            return super.asInetAddress();
        }

        public InvalidDnsNameException getInvalidDnsNameException() {
            return this.invalidDnsNameException;
        }

        private InvalidDomainName(String str, InvalidDnsNameException invalidDnsNameException2) {
            super(str);
            this.invalidDnsNameException = invalidDnsNameException2;
        }
    }

    private static class NonNumericInternetAddress extends InternetAddress {
        private boolean attemptedToResolveInetAddress;
        private InetAddress inetAddress;

        protected NonNumericInternetAddress(String str) {
            super(str);
        }

        public InetAddress asInetAddress() throws UnknownHostException {
            InetAddress inetAddress2 = this.inetAddress;
            if (inetAddress2 != null || this.attemptedToResolveInetAddress) {
                return inetAddress2;
            }
            this.attemptedToResolveInetAddress = true;
            InetAddress byName = InetAddress.getByName(this.originalString);
            this.inetAddress = byName;
            return byName;
        }
    }

    protected InternetAddress(String str) {
        this.originalString = (String) Objects.requireNonNull(str, "The 'originalString' argument must not be null");
    }

    public static InternetAddress from(String str) {
        InternetAddress internetAddress;
        if (e.d(str)) {
            return new Ipv4(str);
        }
        if (e.e(str)) {
            return new Ipv6(str);
        }
        if (str.contains(".")) {
            try {
                internetAddress = new DomainName(str, DnsName.c(str));
            } catch (InvalidDnsNameException e10) {
                internetAddress = new InvalidDomainName(str, e10);
            }
        } else {
            internetAddress = new DomainNameLabel(str, DnsLabel.c(str));
        }
        return internetAddress;
    }

    public abstract InetAddress asInetAddress() throws UnknownHostException;

    public char charAt(int i10) {
        return this.originalString.charAt(i10);
    }

    public int length() {
        return this.originalString.length();
    }

    public CharSequence subSequence(int i10, int i11) {
        return this.originalString.subSequence(i10, i11);
    }

    public String toString() {
        return this.originalString;
    }

    public static final class Ipv4 extends InetAddressInternetAddress {
        private final Inet4Address inet4Address;

        public /* bridge */ /* synthetic */ InetAddress asInetAddress() {
            return super.asInetAddress();
        }

        public Inet4Address getInet4Address() {
            return this.inet4Address;
        }

        private Ipv4(String str) {
            this(str, e.a(str));
        }

        private Ipv4(String str, Inet4Address inet4Address2) {
            super(str, inet4Address2);
            this.inet4Address = inet4Address2;
        }
    }

    public static final class Ipv6 extends InetAddressInternetAddress {
        private Inet6Address inet6Address;

        public /* bridge */ /* synthetic */ InetAddress asInetAddress() {
            return super.asInetAddress();
        }

        public Inet6Address getInet6Address() {
            return this.inet6Address;
        }

        private Ipv6(String str) {
            this(str, e.b(str));
        }

        private Ipv6(String str, Inet6Address inet6Address2) {
            super(str, inet6Address2);
            this.inet6Address = inet6Address2;
        }
    }

    public static InternetAddress from(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return new Ipv4(inetAddress.getHostAddress(), (Inet4Address) inetAddress);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ipv6(inetAddress.getHostAddress(), (Inet6Address) inetAddress);
        }
        throw new IllegalArgumentException("Unknown type " + inetAddress.getClass() + " of " + inetAddress);
    }
}
