package com.withpersona.sdk2.camera;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AutoCaptureRuleSet implements Parcelable {
    public static final Parcelable.Creator<AutoCaptureRuleSet> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<AutoCaptureRule> f14105a;

    public static final class a implements Parcelable.Creator<AutoCaptureRuleSet> {
        /* renamed from: a */
        public final AutoCaptureRuleSet createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(parcel.readParcelable(AutoCaptureRuleSet.class.getClassLoader()));
            }
            return new AutoCaptureRuleSet(arrayList);
        }

        /* renamed from: b */
        public final AutoCaptureRuleSet[] newArray(int i10) {
            return new AutoCaptureRuleSet[i10];
        }
    }

    public AutoCaptureRuleSet() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public AutoCaptureRuleSet(List<? extends AutoCaptureRule> list) {
        j.g(list, "rules");
        this.f14105a = list;
    }

    public final List<AutoCaptureRule> a() {
        return this.f14105a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AutoCaptureRuleSet) && j.b(this.f14105a, ((AutoCaptureRuleSet) obj).f14105a);
    }

    public int hashCode() {
        return this.f14105a.hashCode();
    }

    public String toString() {
        return "AutoCaptureRuleSet(rules=" + this.f14105a + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<AutoCaptureRule> list = this.f14105a;
        parcel.writeInt(list.size());
        for (AutoCaptureRule writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i10);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoCaptureRuleSet(List list, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? q.j() : list);
    }
}
