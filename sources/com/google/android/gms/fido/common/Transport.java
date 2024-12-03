package com.google.android.gms.fido.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public enum Transport implements ReflectedParcelable {
    BLUETOOTH_CLASSIC("bt"),
    BLUETOOTH_LOW_ENERGY("ble"),
    NFC("nfc"),
    USB("usb"),
    INTERNAL("internal"),
    CABLE("cable");
    
    @NonNull
    public static final Parcelable.Creator<Transport> CREATOR = null;
    private final String zzc;

    public static class UnsupportedTransportException extends Exception {
        public UnsupportedTransportException(@NonNull String str) {
            super(str);
        }
    }

    static {
        CREATOR = new a();
    }

    private Transport(String str) {
        this.zzc = str;
    }

    @NonNull
    public static Transport a(@NonNull String str) throws UnsupportedTransportException {
        for (Transport transport : values()) {
            if (str.equals(transport.zzc)) {
                return transport;
            }
        }
        throw new UnsupportedTransportException(String.format("Transport %s not supported", new Object[]{str}));
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return this.zzc;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeString(this.zzc);
    }
}
