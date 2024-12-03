package org.apache.commons.digester;

import java.util.List;

public interface Rules {
    void add(String str, Rule rule);

    void clear();

    Digester getDigester();

    String getNamespaceURI();

    List match(String str);

    List match(String str, String str2);

    List rules();

    void setDigester(Digester digester);

    void setNamespaceURI(String str);
}
