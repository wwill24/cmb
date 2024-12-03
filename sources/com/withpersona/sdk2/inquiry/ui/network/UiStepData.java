package com.withpersona.sdk2.inquiry.ui.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiStepData implements StepData {
    public static final Parcelable.Creator<UiStepData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f29475a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, ComponentParam> f29476b;

    public static final class a implements Parcelable.Creator<UiStepData> {
        /* renamed from: a */
        public final UiStepData createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                linkedHashMap.put(parcel.readString(), parcel.readParcelable(UiStepData.class.getClassLoader()));
            }
            return new UiStepData(readString, linkedHashMap);
        }

        /* renamed from: b */
        public final UiStepData[] newArray(int i10) {
            return new UiStepData[i10];
        }
    }

    public UiStepData(String str, Map<String, ? extends ComponentParam> map) {
        j.g(str, "stepName");
        j.g(map, "componentParams");
        this.f29475a = str;
        this.f29476b = map;
    }

    public final Map<String, ComponentParam> a() {
        return this.f29476b;
    }

    public String c() {
        return this.f29475a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiStepData)) {
            return false;
        }
        UiStepData uiStepData = (UiStepData) obj;
        return j.b(c(), uiStepData.c()) && j.b(this.f29476b, uiStepData.f29476b);
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f29476b.hashCode();
    }

    public String toString() {
        return "UiStepData(stepName=" + c() + ", componentParams=" + this.f29476b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f29475a);
        Map<String, ComponentParam> map = this.f29476b;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeParcelable((Parcelable) next.getValue(), i10);
        }
    }
}
