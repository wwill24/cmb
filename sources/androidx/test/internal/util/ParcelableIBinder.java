package androidx.test.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableIBinder implements Parcelable {
    public static final Parcelable.Creator<ParcelableIBinder> CREATOR = new Parcelable.Creator<ParcelableIBinder>() {
        /* renamed from: a */
        public ParcelableIBinder createFromParcel(Parcel parcel) {
            return new ParcelableIBinder(parcel);
        }

        /* renamed from: b */
        public ParcelableIBinder[] newArray(int i10) {
            return new ParcelableIBinder[i10];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f7054a;

    protected ParcelableIBinder(Parcel parcel) {
        this.f7054a = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStrongBinder(this.f7054a);
    }
}
