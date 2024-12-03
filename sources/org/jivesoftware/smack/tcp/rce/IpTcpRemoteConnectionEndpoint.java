package org.jivesoftware.smack.tcp.rce;

import com.facebook.internal.security.CertificateUtil;
import java.net.InetAddress;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.rce.SingleAddressRemoteConnectionEndpoint;
import ym.a;

public final class IpTcpRemoteConnectionEndpoint<IARR extends a<?>> implements Rfc6120TcpRemoteConnectionEndpoint, SingleAddressRemoteConnectionEndpoint {
    private final CharSequence host;
    private final IARR internetAddressResourceRecord;
    private final UInt16 port;

    public IpTcpRemoteConnectionEndpoint(CharSequence charSequence, UInt16 uInt16, IARR iarr) {
        this.host = (CharSequence) Objects.requireNonNull(charSequence);
        this.port = (UInt16) Objects.requireNonNull(uInt16);
        this.internetAddressResourceRecord = (a) Objects.requireNonNull(iarr);
    }

    public static IpTcpRemoteConnectionEndpoint<a<?>> from(CharSequence charSequence, UInt16 uInt16, InetAddress inetAddress) {
        return new IpTcpRemoteConnectionEndpoint<>(charSequence, uInt16, a.i(inetAddress));
    }

    public String getDescription() {
        return "RFC 6120 A/AAAA Endpoint + [" + this.host + CertificateUtil.DELIMITER + this.port + "]";
    }

    public CharSequence getHost() {
        return this.host;
    }

    public InetAddress getInetAddress() {
        return this.internetAddressResourceRecord.j();
    }

    public UInt16 getPort() {
        return this.port;
    }
}
