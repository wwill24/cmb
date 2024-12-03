package org.jivesoftware.smackx.httpfileupload.element;

import java.net.URL;
import java.util.Collections;
import java.util.Map;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.shim.packet.Header;

public class Slot extends IQ {
    public static final String ELEMENT = "slot";
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    protected final URL getUrl;
    private final Map<String, String> headers;
    protected final URL putUrl;

    public Slot(URL url, URL url2) {
        this(url, url2, (Map<String, String>) null);
    }

    public URL getGetUrl() {
        return this.getUrl;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.halfOpenElement("put").attribute("url", this.putUrl.toString());
        if (this.headers.isEmpty()) {
            iQChildElementXmlStringBuilder.closeEmptyElement();
        } else {
            iQChildElementXmlStringBuilder.rightAngleBracket();
            for (Map.Entry next : getHeaders().entrySet()) {
                iQChildElementXmlStringBuilder.halfOpenElement(Header.ELEMENT).attribute("name", (String) next.getKey()).rightAngleBracket();
                iQChildElementXmlStringBuilder.escape((String) next.getValue());
                iQChildElementXmlStringBuilder.closeElement(Header.ELEMENT);
            }
            iQChildElementXmlStringBuilder.closeElement("put");
        }
        iQChildElementXmlStringBuilder.halfOpenElement("get").attribute("url", this.getUrl.toString()).closeEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public URL getPutUrl() {
        return this.putUrl;
    }

    public Slot(URL url, URL url2, Map<String, String> map) {
        this(url, url2, map, "urn:xmpp:http:upload:0");
    }

    protected Slot(URL url, URL url2, Map<String, String> map, String str) {
        super(ELEMENT, str);
        setType(IQ.Type.result);
        this.putUrl = url;
        this.getUrl = url2;
        if (map == null) {
            this.headers = Collections.emptyMap();
        } else {
            this.headers = Collections.unmodifiableMap(map);
        }
    }
}
