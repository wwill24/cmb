package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcScanPage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcScanPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25704a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25705b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25706c;

    public static final class a implements Parcelable.Creator<PassportNfcScanPage> {
        /* renamed from: a */
        public final PassportNfcScanPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcScanPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcScanPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcScanPage.class.getClassLoader()), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcScanPage[] newArray(int i10) {
            return new PassportNfcScanPage[i10];
        }
    }

    public PassportNfcScanPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str) {
        this.f25704a = list;
        this.f25705b = stepStyles$UiStepStyle;
        this.f25706c = str;
    }

    public final String J() {
        return this.f25706c;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25705b;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f25704a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25704a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25705b, i10);
        parcel.writeString(this.f25706c);
    }
}
