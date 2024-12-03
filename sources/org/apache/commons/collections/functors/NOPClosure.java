package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;

public class NOPClosure implements Closure, Serializable {
    public static final Closure INSTANCE = new NOPClosure();
    private static final long serialVersionUID = 3518477308466486130L;

    private NOPClosure() {
    }

    public static Closure getInstance() {
        return INSTANCE;
    }

    public void execute(Object obj) {
    }
}
