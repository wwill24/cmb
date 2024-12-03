package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

public final class zzdb {
    public static final zzdb zza = new zzdb();
    private static final List zzb = zzc(q.m("www.recaptcha.net", "www.gstatic.com/recaptcha"));

    private zzdb() {
    }

    public static final boolean zza(Uri uri) {
        if (TextUtils.isEmpty(uri.toString()) || !j.b("https", uri.getScheme()) || TextUtils.isEmpty(uri.getHost()) || !zzb(uri.toString())) {
            return false;
        }
        return true;
    }

    private static final boolean zzb(String str) {
        List<String> list = zzb;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String J : list) {
            if (r.J(str, J, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private static final List zzc(List list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("https://" + ((String) it.next()) + RemoteSettings.FORWARD_SLASH_STRING);
        }
        return arrayList;
    }
}
