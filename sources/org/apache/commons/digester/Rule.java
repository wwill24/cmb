package org.apache.commons.digester;

import org.xml.sax.Attributes;

public abstract class Rule {
    protected Digester digester = null;
    protected String namespaceURI = null;

    public Rule(Digester digester2) {
        setDigester(digester2);
    }

    public void begin(String str, String str2, Attributes attributes) throws Exception {
        begin(attributes);
    }

    public void begin(Attributes attributes) throws Exception {
    }

    public void body(String str) throws Exception {
    }

    public void body(String str, String str2, String str3) throws Exception {
        body(str3);
    }

    public void end() throws Exception {
    }

    public void end(String str, String str2) throws Exception {
        end();
    }

    public void finish() throws Exception {
    }

    public Digester getDigester() {
        return this.digester;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public void setDigester(Digester digester2) {
        this.digester = digester2;
    }

    public void setNamespaceURI(String str) {
        this.namespaceURI = str;
    }

    public Rule() {
    }
}
