package org.minidns.source;

import com.coffeemeetsbagel.models.util.FacebookParse;

public abstract class AbstractDnsDataSource implements a {

    /* renamed from: a  reason: collision with root package name */
    protected int f41716a = 1024;

    /* renamed from: b  reason: collision with root package name */
    protected int f41717b = FacebookParse.FB_NO_LIMIT;

    /* renamed from: c  reason: collision with root package name */
    private QueryMode f41718c = QueryMode.dontCare;

    public enum QueryMode {
        dontCare,
        udpTcp,
        tcp
    }

    public int b() {
        return this.f41716a;
    }

    public QueryMode c() {
        return this.f41718c;
    }
}
