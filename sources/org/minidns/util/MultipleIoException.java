package org.minidns.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MultipleIoException extends IOException {
    private static final long serialVersionUID = -5932211337552319515L;
    private final List<IOException> ioExceptions;

    static {
        Class<MultipleIoException> cls = MultipleIoException.class;
    }

    private MultipleIoException(List<? extends IOException> list) {
        super(a(list));
        this.ioExceptions = Collections.unmodifiableList(list);
    }

    private static String a(Collection<? extends Exception> collection) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<? extends Exception> it = collection.iterator();
        while (it.hasNext()) {
            sb2.append(((Exception) it.next()).getMessage());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public static void b(List<? extends IOException> list) throws IOException {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                throw ((IOException) list.get(0));
            }
            throw new MultipleIoException(list);
        }
    }
}
