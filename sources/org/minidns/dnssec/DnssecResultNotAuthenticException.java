package org.minidns.dnssec;

import java.util.Collections;
import java.util.Set;
import org.minidns.MiniDnsException;

public final class DnssecResultNotAuthenticException extends MiniDnsException {
    private static final long serialVersionUID = 1;
    private final Set<c> unverifiedReasons;

    private DnssecResultNotAuthenticException(String str, Set<c> set) {
        super(str);
        if (!set.isEmpty()) {
            this.unverifiedReasons = Collections.unmodifiableSet(set);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static DnssecResultNotAuthenticException a(Set<c> set) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DNSSEC result not authentic. Reasons: ");
        for (c append : set) {
            sb2.append(append);
            sb2.append('.');
        }
        return new DnssecResultNotAuthenticException(sb2.toString(), set);
    }
}
