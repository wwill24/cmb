package org.minidns.iterative;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsmessage.a;
import org.minidns.iterative.IterativeClientException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f33752a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<InetAddress, Set<a>> f33753b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private int f33754c;

    b(a aVar) {
        this.f33752a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f33754c--;
    }

    /* access modifiers changed from: package-private */
    public void b(InetAddress inetAddress, DnsMessage dnsMessage) throws IterativeClientException.LoopDetected, IterativeClientException.MaxIterativeStepsReached {
        a q10 = dnsMessage.q();
        if (!this.f33753b.containsKey(inetAddress)) {
            this.f33753b.put(inetAddress, new HashSet());
        } else if (this.f33753b.get(inetAddress).contains(q10)) {
            throw new IterativeClientException.LoopDetected(inetAddress, q10);
        }
        int i10 = this.f33754c + 1;
        this.f33754c = i10;
        if (i10 <= this.f33752a.f33745j) {
            this.f33753b.get(inetAddress).add(q10);
            return;
        }
        throw new IterativeClientException.MaxIterativeStepsReached();
    }
}
