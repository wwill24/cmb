package org.apache.commons.digester;

import org.xml.sax.Attributes;

public interface ObjectCreationFactory {
    Object createObject(Attributes attributes) throws Exception;

    Digester getDigester();

    void setDigester(Digester digester);
}
