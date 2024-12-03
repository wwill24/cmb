package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f5677a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f5678b;

    /* renamed from: c  reason: collision with root package name */
    BackStackRecordState[] f5679c;

    /* renamed from: d  reason: collision with root package name */
    int f5680d;

    /* renamed from: e  reason: collision with root package name */
    String f5681e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f5682f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<BackStackState> f5683g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<FragmentManager.LaunchedFragmentInfo> f5684h;

    class a implements Parcelable.Creator<FragmentManagerState> {
        a() {
        }

        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f5677a);
        parcel.writeStringList(this.f5678b);
        parcel.writeTypedArray(this.f5679c, i10);
        parcel.writeInt(this.f5680d);
        parcel.writeString(this.f5681e);
        parcel.writeStringList(this.f5682f);
        parcel.writeTypedList(this.f5683g);
        parcel.writeTypedList(this.f5684h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f5677a = parcel.createStringArrayList();
        this.f5678b = parcel.createStringArrayList();
        this.f5679c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f5680d = parcel.readInt();
        this.f5681e = parcel.readString();
        this.f5682f = parcel.createStringArrayList();
        this.f5683g = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f5684h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
