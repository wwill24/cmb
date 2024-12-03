package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public class s {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Integer> f6067a = new HashMap();

    public boolean a(String str, int i10) {
        int i11;
        j.g(str, "name");
        Integer num = this.f6067a.get(str);
        boolean z10 = false;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        if ((i11 & i10) != 0) {
            z10 = true;
        }
        this.f6067a.put(str, Integer.valueOf(i10 | i11));
        return !z10;
    }
}
