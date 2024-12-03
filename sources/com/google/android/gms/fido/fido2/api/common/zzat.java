package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import org.jivesoftware.smackx.xdata.FormField;

public enum zzat implements Parcelable {
    USER_VERIFICATION_REQUIRED(FormField.Required.ELEMENT),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");
    
    public static final Parcelable.Creator<zzat> CREATOR = null;
    @NonNull
    private final String zze;

    static {
        CREATOR = new j();
    }

    private zzat(@NonNull String str) {
        this.zze = str;
    }

    public static zzat a(String str) throws zzas {
        for (zzat zzat : values()) {
            if (str.equals(zzat.zze)) {
                return zzat;
            }
        }
        throw new zzas(str);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return this.zze;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zze);
    }
}
