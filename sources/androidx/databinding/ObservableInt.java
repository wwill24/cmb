package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableInt extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new a();
    static final long serialVersionUID = 1;
    private int mValue;

    class a implements Parcelable.Creator<ObservableInt> {
        a() {
        }

        /* renamed from: a */
        public ObservableInt createFromParcel(Parcel parcel) {
            return new ObservableInt(parcel.readInt());
        }

        /* renamed from: b */
        public ObservableInt[] newArray(int i10) {
            return new ObservableInt[i10];
        }
    }

    public ObservableInt(int i10) {
        this.mValue = i10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mValue);
    }

    public ObservableInt() {
    }
}
