package org.apache.commons.digester;

import org.xml.sax.Attributes;

public abstract class Substitutor {
    public abstract String substitute(String str);

    public abstract Attributes substitute(Attributes attributes);
}
