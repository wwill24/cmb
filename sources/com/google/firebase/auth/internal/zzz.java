package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import fe.a;
import org.json.JSONException;
import org.json.b;

public final class zzz implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    private final long zza;
    private final long zzb;

    public zzz(long j10, long j11) {
        this.zza = j10;
        this.zzb = j11;
    }

    public final int describeContents() {
        return 0;
    }

    public final long getCreationTimestamp() {
        return this.zzb;
    }

    public final long getLastSignInTimestamp() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.zza);
        a.v(parcel, 2, this.zzb);
        a.b(parcel, a10);
    }

    public final b zza() {
        b bVar = new b();
        try {
            bVar.put("lastSignInTimestamp", this.zza);
            bVar.put("creationTimestamp", this.zzb);
        } catch (JSONException unused) {
        }
        return bVar;
    }
}
