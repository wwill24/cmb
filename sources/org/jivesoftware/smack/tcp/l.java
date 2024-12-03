package org.jivesoftware.smack.tcp;

import java.nio.Buffer;
import org.jivesoftware.smack.util.CollectionUtil;

public final /* synthetic */ class l implements CollectionUtil.Predicate {
    public final boolean test(Object obj) {
        return ((Buffer) obj).hasRemaining();
    }
}
