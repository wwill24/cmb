package org.jxmpp.xml.splitter;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class h extends XmlSplitter {

    /* renamed from: n  reason: collision with root package name */
    private final g f24368n;

    /* renamed from: p  reason: collision with root package name */
    private final int f24369p;

    /* renamed from: q  reason: collision with root package name */
    private String f24370q;

    public h(f fVar) {
        this(-1, (g) null, fVar);
    }

    /* access modifiers changed from: protected */
    public void g(String str) {
        g gVar;
        String str2 = this.f24370q;
        if (str2 != null && str.startsWith(str2)) {
            if ((this.f24370q + ":stream").equals(str) && (gVar = this.f24368n) != null) {
                gVar.streamClosed();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() throws IOException {
        if (this.f24369p > 0 && c() >= this.f24369p) {
            throw new IOException("Max element size exceeded");
        }
    }

    /* access modifiers changed from: protected */
    public void m(String str, String str2, Map<String, String> map) {
        if ("stream".equals(str2)) {
            if ("http://etherx.jabber.org/streams".equals(map.get("xmlns:" + str))) {
                this.f24370q = str;
                f();
                g gVar = this.f24368n;
                if (gVar != null) {
                    gVar.streamOpened(str, Collections.unmodifiableMap(map));
                }
            }
        }
    }

    public h(int i10, g gVar, f fVar) {
        this(i10, gVar, (b) null, (c) null, fVar);
    }

    public h(int i10, g gVar, b bVar, c cVar, f fVar) {
        super(i10, gVar, bVar, cVar, fVar);
        this.f24369p = i10;
        this.f24368n = gVar;
    }
}
