package org.apache.commons.collections;

import java.util.Collection;
import java.util.HashMap;

public class HashBag extends DefaultMapBag {
    public HashBag() {
        super(new HashMap());
    }

    public HashBag(Collection collection) {
        this();
        addAll(collection);
    }
}
