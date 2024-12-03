package org.apache.commons.digester;

import java.util.List;

public abstract class AbstractRulesImpl implements Rules {
    private Digester digester;
    private String namespaceURI;

    public void add(String str, Rule rule) {
        Digester digester2 = this.digester;
        if (digester2 != null) {
            rule.setDigester(digester2);
        }
        String str2 = this.namespaceURI;
        if (str2 != null) {
            rule.setNamespaceURI(str2);
        }
        registerRule(str, rule);
    }

    public abstract void clear();

    public Digester getDigester() {
        return this.digester;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public List match(String str) {
        return match(this.namespaceURI, str);
    }

    public abstract List match(String str, String str2);

    /* access modifiers changed from: protected */
    public abstract void registerRule(String str, Rule rule);

    public abstract List rules();

    public void setDigester(Digester digester2) {
        this.digester = digester2;
    }

    public void setNamespaceURI(String str) {
        this.namespaceURI = str;
    }
}
