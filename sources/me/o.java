package me;

import androidx.annotation.NonNull;
import com.mparticle.kits.AppsFlyerKit;
import java.util.HashMap;

public class o {
    public static void a(@NonNull StringBuilder sb2, @NonNull HashMap<String, String> hashMap) {
        sb2.append("{");
        boolean z10 = true;
        for (String next : hashMap.keySet()) {
            if (!z10) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            String str = hashMap.get(next);
            sb2.append("\"");
            sb2.append(next);
            sb2.append("\":");
            if (str == null) {
                sb2.append("null");
            } else {
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
            }
            z10 = false;
        }
        sb2.append("}");
    }
}
