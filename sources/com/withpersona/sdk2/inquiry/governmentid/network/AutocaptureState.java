package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.camera.ImageIdMetadata;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AutocaptureState implements Parcelable {
    public static final Parcelable.Creator<AutocaptureState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageIdMetadata> f25801a;

    public static final class a implements Parcelable.Creator<AutocaptureState> {
        /* renamed from: a */
        public final AutocaptureState createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readParcelable(AutocaptureState.class.getClassLoader()));
            }
            return new AutocaptureState(arrayList);
        }

        /* renamed from: b */
        public final AutocaptureState[] newArray(int i10) {
            return new AutocaptureState[i10];
        }
    }

    public AutocaptureState() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public AutocaptureState(List<ImageIdMetadata> list) {
        j.g(list, "previousFramesMetadata");
        this.f25801a = list;
    }

    public final AutocaptureState a(List<ImageIdMetadata> list) {
        j.g(list, "previousFramesMetadata");
        return new AutocaptureState(list);
    }

    public final List<ImageIdMetadata> c() {
        return this.f25801a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutocaptureState) && j.b(this.f25801a, ((AutocaptureState) obj).f25801a);
    }

    public int hashCode() {
        return this.f25801a.hashCode();
    }

    public String toString() {
        return "AutocaptureState(previousFramesMetadata=" + this.f25801a + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<ImageIdMetadata> list = this.f25801a;
        parcel.writeInt(list.size());
        for (ImageIdMetadata writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i10);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutocaptureState(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? q.j() : list);
    }
}
