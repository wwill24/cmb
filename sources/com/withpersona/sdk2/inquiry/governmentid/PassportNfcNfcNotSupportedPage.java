package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcNfcNotSupportedPage implements PassportNfcErrorPage {
    public static final Parcelable.Creator<PassportNfcNfcNotSupportedPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25697a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25698b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25699c;

    public static final class a implements Parcelable.Creator<PassportNfcNfcNotSupportedPage> {
        /* renamed from: a */
        public final PassportNfcNfcNotSupportedPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcNfcNotSupportedPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcNfcNotSupportedPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcNfcNotSupportedPage.class.getClassLoader()), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcNfcNotSupportedPage[] newArray(int i10) {
            return new PassportNfcNfcNotSupportedPage[i10];
        }
    }

    public PassportNfcNfcNotSupportedPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str) {
        this.f25697a = list;
        this.f25698b = stepStyles$UiStepStyle;
        this.f25699c = str;
    }

    public String J() {
        return this.f25699c;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25698b;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f25697a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25697a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25698b, i10);
        parcel.writeString(this.f25699c);
    }
}
