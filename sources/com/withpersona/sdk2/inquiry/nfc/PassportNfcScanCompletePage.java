package com.withpersona.sdk2.inquiry.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcScanCompletePage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcScanCompletePage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f27044a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f27045b;

    public static final class a implements Parcelable.Creator<PassportNfcScanCompletePage> {
        /* renamed from: a */
        public final PassportNfcScanCompletePage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcScanCompletePage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcScanCompletePage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcScanCompletePage.class.getClassLoader()));
        }

        /* renamed from: b */
        public final PassportNfcScanCompletePage[] newArray(int i10) {
            return new PassportNfcScanCompletePage[i10];
        }
    }

    public PassportNfcScanCompletePage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
        this.f27044a = list;
        this.f27045b = stepStyles$UiStepStyle;
    }

    public StepStyles$UiStepStyle b() {
        return this.f27045b;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f27044a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f27044a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f27045b, i10);
    }
}
