package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.mparticle.identity.IdentityHttpResponse;

@Deprecated
public enum ProtocolVersion implements Parcelable {
    f39421a(IdentityHttpResponse.UNKNOWN),
    V1("U2F_V1"),
    V2("U2F_V2");
    
    @NonNull
    public static final Parcelable.Creator<ProtocolVersion> CREATOR = null;
    private final String zzb;

    public static class UnsupportedProtocolException extends Exception {
        public UnsupportedProtocolException(@NonNull String str) {
            super(String.format("Protocol version %s not supported", new Object[]{str}));
        }
    }

    static {
        CREATOR = new f();
    }

    private ProtocolVersion(String str) {
        this.zzb = str;
    }

    @NonNull
    public static ProtocolVersion a(@NonNull String str) throws UnsupportedProtocolException {
        if (str == null) {
            return f39421a;
        }
        for (ProtocolVersion protocolVersion : values()) {
            if (str.equals(protocolVersion.zzb)) {
                return protocolVersion;
            }
        }
        throw new UnsupportedProtocolException(str);
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeString(this.zzb);
    }
}
