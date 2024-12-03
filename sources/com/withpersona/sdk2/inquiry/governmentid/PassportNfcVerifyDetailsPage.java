package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcVerifyDetailsPage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcVerifyDetailsPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25710a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25711b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25712c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25713d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25714e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25715f;

    public static final class a implements Parcelable.Creator<PassportNfcVerifyDetailsPage> {
        /* renamed from: a */
        public final PassportNfcVerifyDetailsPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcVerifyDetailsPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcVerifyDetailsPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcVerifyDetailsPage.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcVerifyDetailsPage[] newArray(int i10) {
            return new PassportNfcVerifyDetailsPage[i10];
        }
    }

    public PassportNfcVerifyDetailsPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, String str2, String str3, String str4) {
        this.f25710a = list;
        this.f25711b = stepStyles$UiStepStyle;
        this.f25712c = str;
        this.f25713d = str2;
        this.f25714e = str3;
        this.f25715f = str4;
    }

    public final String J() {
        return this.f25715f;
    }

    public final String a() {
        return this.f25713d;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25711b;
    }

    public final String c() {
        return this.f25712c;
    }

    public final String d() {
        return this.f25714e;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f25710a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25710a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25711b, i10);
        parcel.writeString(this.f25712c);
        parcel.writeString(this.f25713d);
        parcel.writeString(this.f25714e);
        parcel.writeString(this.f25715f);
    }
}
