package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class ObservableFloat extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new a();
    static final long serialVersionUID = 1;
    private float mValue;

    class a implements Parcelable.Creator<ObservableFloat> {
        a() {
        }

        /* renamed from: a */
        public ObservableFloat createFromParcel(Parcel parcel) {
            return new ObservableFloat(parcel.readFloat());
        }

        /* renamed from: b */
        public ObservableFloat[] newArray(int i10) {
            return new ObservableFloat[i10];
        }
    }

    public ObservableFloat(float f10) {
        this.mValue = f10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.mValue);
    }

    public ObservableFloat() {
    }
}
