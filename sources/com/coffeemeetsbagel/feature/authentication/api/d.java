package com.coffeemeetsbagel.feature.authentication.api;

import android.text.TextUtils;
import c7.c;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.HashMap;
import java.util.Map;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final d7.c f12687a;

    /* renamed from: b  reason: collision with root package name */
    private final ProfileContract$Manager f12688b;

    public d(d7.c cVar, ProfileContract$Manager profileContract$Manager) {
        this.f12687a = cVar;
        this.f12688b = profileContract$Manager;
    }

    public Map<String, String> a() {
        String id2;
        String e10 = this.f12687a.e();
        if (TextUtils.isEmpty(e10)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", "Bearer " + e10);
        hashMap.put("Bundle-Id", Bakery.w().getPackageName());
        NetworkProfile j10 = this.f12688b.j();
        if (!(j10 == null || (id2 = j10.getId()) == null)) {
            hashMap.put("Profile-Id", id2);
        }
        return hashMap;
    }
}
