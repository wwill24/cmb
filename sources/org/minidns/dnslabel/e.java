package org.minidns.dnslabel;

public abstract class e extends DnsLabel {
    protected e(String str) {
        super(str);
    }

    protected static DnsLabel i(String str) {
        if (i.j(str)) {
            return new i(str);
        }
        if (d.j(str)) {
            return new d(str);
        }
        return new g(str);
    }
}
