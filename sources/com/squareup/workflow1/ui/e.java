package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007¨\u0006\u0005"}, d2 = {"", "me", "you", "", "a", "wf1-core-common"}, k = 2, mv = {1, 6, 0})
public final class e {
    public static final boolean a(Object obj, Object obj2) {
        j.g(obj, "me");
        j.g(obj2, "you");
        if (!j.b(l.b(obj.getClass()), l.b(obj2.getClass()))) {
            return false;
        }
        if (!(obj instanceof d)) {
            return true;
        }
        return j.b(((d) obj).c(), ((d) obj2).c());
    }
}
