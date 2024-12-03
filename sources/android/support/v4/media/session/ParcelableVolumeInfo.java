package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f259a;

    /* renamed from: b  reason: collision with root package name */
    public int f260b;

    /* renamed from: c  reason: collision with root package name */
    public int f261c;

    /* renamed from: d  reason: collision with root package name */
    public int f262d;

    /* renamed from: e  reason: collision with root package name */
    public int f263e;

    static class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f259a = parcel.readInt();
        this.f261c = parcel.readInt();
        this.f262d = parcel.readInt();
        this.f263e = parcel.readInt();
        this.f260b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f259a);
        parcel.writeInt(this.f261c);
        parcel.writeInt(this.f262d);
        parcel.writeInt(this.f263e);
        parcel.writeInt(this.f260b);
    }
}
