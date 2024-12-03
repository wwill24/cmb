package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new a();
    static final long serialVersionUID = 1;
    private byte mValue;

    class a implements Parcelable.Creator<ObservableByte> {
        a() {
        }

        /* renamed from: a */
        public ObservableByte createFromParcel(Parcel parcel) {
            return new ObservableByte(parcel.readByte());
        }

        /* renamed from: b */
        public ObservableByte[] newArray(int i10) {
            return new ObservableByte[i10];
        }
    }

    public ObservableByte(byte b10) {
        this.mValue = b10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.mValue);
    }

    public ObservableByte() {
    }
}
