package sd;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import rd.m;

public class a {

    /* renamed from: a  reason: collision with root package name */
    Map<String, String> f41933a = new HashMap();

    @NonNull
    public final Map<String, String> a(@NonNull String str) {
        String str2;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f41933a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) next.getKey());
            if (valueOf2.length() != 0) {
                str2 = valueOf.concat(valueOf2);
            } else {
                str2 = new String(valueOf);
            }
            hashMap.put(str2, (String) next.getValue());
        }
        return hashMap;
    }

    @NonNull
    public String toString() {
        return m.zzb(this.f41933a);
    }
}
