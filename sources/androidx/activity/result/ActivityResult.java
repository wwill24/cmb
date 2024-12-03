package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f357a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f358b;

    class a implements Parcelable.Creator<ActivityResult> {
        a() {
        }

        /* renamed from: a */
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i10) {
            return new ActivityResult[i10];
        }
    }

    public ActivityResult(int i10, Intent intent) {
        this.f357a = i10;
        this.f358b = intent;
    }

    @NonNull
    public static String d(int i10) {
        return i10 != -1 ? i10 != 0 ? String.valueOf(i10) : "RESULT_CANCELED" : "RESULT_OK";
    }

    public Intent a() {
        return this.f358b;
    }

    public int c() {
        return this.f357a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + d(this.f357a) + ", data=" + this.f358b + '}';
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int i11;
        parcel.writeInt(this.f357a);
        if (this.f358b == null) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        parcel.writeInt(i11);
        Intent intent = this.f358b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f357a = parcel.readInt();
        this.f358b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
