package xm;

import java.net.IDN;
import org.minidns.dnsname.DnsName;

public class a implements b {
    public String a(String str) {
        return IDN.toUnicode(str);
    }

    public String b(String str) {
        DnsName dnsName = DnsName.f33658g;
        if (dnsName.ace.equals(str)) {
            return dnsName.ace;
        }
        return IDN.toASCII(str);
    }
}
