package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.b;
import b2.d;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends d {
    @NonNull
    public b b(@NonNull List<b> list) {
        b.a aVar = new b.a();
        HashMap hashMap = new HashMap();
        for (b h10 : list) {
            hashMap.putAll(h10.h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
