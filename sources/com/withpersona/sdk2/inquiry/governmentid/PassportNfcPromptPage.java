package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcPromptPage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcPromptPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25700a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25701b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25702c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25703d;

    public static final class a implements Parcelable.Creator<PassportNfcPromptPage> {
        /* renamed from: a */
        public final PassportNfcPromptPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(PassportNfcPromptPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcPromptPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(PassportNfcPromptPage.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcPromptPage[] newArray(int i10) {
            return new PassportNfcPromptPage[i10];
        }
    }

    public PassportNfcPromptPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, String str2) {
        this.f25700a = list;
        this.f25701b = stepStyles$UiStepStyle;
        this.f25702c = str;
        this.f25703d = str2;
    }

    public final String J() {
        return this.f25702c;
    }

    public final String a() {
        return this.f25703d;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25701b;
    }

    public int describeContents() {
        return 0;
    }

    public List<UiComponent> getComponents() {
        return this.f25700a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25700a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25701b, i10);
        parcel.writeString(this.f25702c);
        parcel.writeString(this.f25703d);
    }
}
