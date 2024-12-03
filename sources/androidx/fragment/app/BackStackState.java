package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final List<String> f5585a;

    /* renamed from: b  reason: collision with root package name */
    final List<BackStackRecordState> f5586b;

    class a implements Parcelable.Creator<BackStackState> {
        a() {
        }

        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i10) {
            return new BackStackState[i10];
        }
    }

    BackStackState(@NonNull Parcel parcel) {
        this.f5585a = parcel.createStringArrayList();
        this.f5586b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        parcel.writeStringList(this.f5585a);
        parcel.writeTypedList(this.f5586b);
    }
}
