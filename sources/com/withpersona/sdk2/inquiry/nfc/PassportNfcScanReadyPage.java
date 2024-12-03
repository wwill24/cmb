package com.withpersona.sdk2.inquiry.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcScanReadyPage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcScanReadyPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f27046a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f27047b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27048c;

    public static final class a implements Parcelable.Creator<PassportNfcScanReadyPage> {
        /* renamed from: a */
        public final PassportNfcScanReadyPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcScanReadyPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcScanReadyPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcScanReadyPage.class.getClassLoader()), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcScanReadyPage[] newArray(int i10) {
            return new PassportNfcScanReadyPage[i10];
        }
    }

    public PassportNfcScanReadyPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str) {
        this.f27046a = list;
        this.f27047b = stepStyles$UiStepStyle;
        this.f27048c = str;
    }

    public StepStyles$UiStepStyle b() {
        return this.f27047b;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f27046a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f27046a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f27047b, i10);
        parcel.writeString(this.f27048c);
    }
}
