package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final a zaa;

    public AvailabilityException(@NonNull a aVar) {
        this.zaa = aVar;
    }

    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (b bVar : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) p.k((ConnectionResult) this.zaa.get(bVar));
            z10 &= !connectionResult.i0();
            arrayList.add(bVar.b() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
