package com.withpersona.sdk2.inquiry.governmentid.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class GovernmentIdStepData implements StepData {
    public static final Parcelable.Creator<GovernmentIdStepData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f25835a;

    /* renamed from: b  reason: collision with root package name */
    private final List<GovernmentId> f25836b;

    public static final class a implements Parcelable.Creator<GovernmentIdStepData> {
        /* renamed from: a */
        public final GovernmentIdStepData createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readParcelable(GovernmentIdStepData.class.getClassLoader()));
            }
            return new GovernmentIdStepData(readString, arrayList);
        }

        /* renamed from: b */
        public final GovernmentIdStepData[] newArray(int i10) {
            return new GovernmentIdStepData[i10];
        }
    }

    public GovernmentIdStepData(String str, List<? extends GovernmentId> list) {
        j.g(str, "stepName");
        j.g(list, "ids");
        this.f25835a = str;
        this.f25836b = list;
    }

    public final List<GovernmentId> a() {
        return this.f25836b;
    }

    public String c() {
        return this.f25835a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f25835a);
        List<GovernmentId> list = this.f25836b;
        parcel.writeInt(list.size());
        for (GovernmentId writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i10);
        }
    }
}
