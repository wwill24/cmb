package org.minidns.cache;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.LinkedHashMap;
import java.util.Map;
import nm.a;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;

public class LruCache extends a {

    /* renamed from: a  reason: collision with root package name */
    protected long f33543a;

    /* renamed from: b  reason: collision with root package name */
    protected long f33544b;

    /* renamed from: c  reason: collision with root package name */
    protected long f33545c;

    /* renamed from: d  reason: collision with root package name */
    protected int f33546d;

    /* renamed from: e  reason: collision with root package name */
    protected long f33547e;

    /* renamed from: f  reason: collision with root package name */
    protected LinkedHashMap<DnsMessage, org.minidns.dnsqueryresult.a> f33548f;

    public LruCache(int i10, long j10) {
        this.f33543a = 0;
        this.f33544b = 0;
        this.f33545c = 0;
        this.f33546d = i10;
        this.f33547e = j10;
        final int i11 = i10;
        this.f33548f = new LinkedHashMap<DnsMessage, org.minidns.dnsqueryresult.a>(Math.min(((i10 + 3) / 4) + i10 + 2, 11), 0.75f, true) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<DnsMessage, org.minidns.dnsqueryresult.a> entry) {
                return size() > i11;
            }
        };
    }

    /* access modifiers changed from: protected */
    public synchronized org.minidns.dnsqueryresult.a b(DnsMessage dnsMessage) {
        org.minidns.dnsqueryresult.a aVar = this.f33548f.get(dnsMessage);
        if (aVar == null) {
            this.f33543a++;
            return null;
        }
        DnsMessage dnsMessage2 = aVar.f33670c;
        if (dnsMessage2.f33598q + (Math.min(dnsMessage2.l(), this.f33547e) * 1000) < System.currentTimeMillis()) {
            this.f33543a++;
            this.f33544b++;
            this.f33548f.remove(dnsMessage);
            return null;
        }
        this.f33545c++;
        return aVar;
    }

    public void c(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName) {
    }

    /* access modifiers changed from: protected */
    public synchronized void e(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
        if (dnsQueryResult.f33670c.f33598q > 0) {
            this.f33548f.put(dnsMessage, new qm.a(dnsMessage, dnsQueryResult));
        }
    }

    public String toString() {
        return "LRUCache{usage=" + this.f33548f.size() + RemoteSettings.FORWARD_SLASH_STRING + this.f33546d + ", hits=" + this.f33545c + ", misses=" + this.f33543a + ", expires=" + this.f33544b + "}";
    }

    public LruCache(int i10) {
        this(i10, Long.MAX_VALUE);
    }

    public LruCache() {
        this(512);
    }
}
