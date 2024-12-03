package org.apache.commons.digester;

import org.xml.sax.Attributes;

public abstract class AbstractObjectCreationFactory implements ObjectCreationFactory {
    protected Digester digester = null;

    public abstract Object createObject(Attributes attributes) throws Exception;

    public Digester getDigester() {
        return this.digester;
    }

    public void setDigester(Digester digester2) {
        this.digester = digester2;
    }
}
