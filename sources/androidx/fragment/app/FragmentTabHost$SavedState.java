package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;

class FragmentTabHost$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<FragmentTabHost$SavedState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    String f5698a;

    class a implements Parcelable.Creator<FragmentTabHost$SavedState> {
        a() {
        }

        /* renamed from: a */
        public FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
            return new FragmentTabHost$SavedState(parcel);
        }

        /* renamed from: b */
        public FragmentTabHost$SavedState[] newArray(int i10) {
            return new FragmentTabHost$SavedState[i10];
        }
    }

    FragmentTabHost$SavedState(Parcel parcel) {
        super(parcel);
        this.f5698a = parcel.readString();
    }

    @NonNull
    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f5698a + "}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f5698a);
    }
}
