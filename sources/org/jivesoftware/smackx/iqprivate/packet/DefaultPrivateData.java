package org.jivesoftware.smackx.iqprivate.packet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultPrivateData implements PrivateData {
    private final String elementName;
    private Map<String, String> map;
    private final String namespace;

    public DefaultPrivateData(String str, String str2) {
        this.elementName = str;
        this.namespace = str2;
    }

    public String getElementName() {
        return this.elementName;
    }

    public synchronized Set<String> getNames() {
        Map<String, String> map2 = this.map;
        if (map2 == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map2.keySet());
    }

    public String getNamespace() {
        return this.namespace;
    }

    public synchronized String getValue(String str) {
        Map<String, String> map2 = this.map;
        if (map2 == null) {
            return null;
        }
        return map2.get(str);
    }

    public synchronized void setValue(String str, String str2) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(str, str2);
    }

    public String toXML() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('<');
        sb2.append(this.elementName);
        sb2.append(" xmlns=\"");
        sb2.append(this.namespace);
        sb2.append("\">");
        for (String next : getNames()) {
            String value = getValue(next);
            sb2.append('<');
            sb2.append(next);
            sb2.append('>');
            sb2.append(value);
            sb2.append("</");
            sb2.append(next);
            sb2.append('>');
        }
        sb2.append("</");
        sb2.append(this.elementName);
        sb2.append('>');
        return sb2.toString();
    }
}
