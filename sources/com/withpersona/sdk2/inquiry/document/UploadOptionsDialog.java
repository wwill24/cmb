package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class UploadOptionsDialog implements NestedUiStep {
    public static final Parcelable.Creator<UploadOptionsDialog> CREATOR = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final a f25130g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25131a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25132b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25133c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25134d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25135e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25136f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UploadOptionsDialog a(String str, String str2, String str3) {
            String str4;
            String str5;
            String str6;
            UiComponent[] uiComponentArr = new UiComponent[3];
            if (str == null) {
                str4 = "";
            } else {
                str4 = str;
            }
            uiComponentArr[0] = new UiComponent.Title("title", new UiComponent.Title.Attributes(str4, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 6, (DefaultConstructorMarker) null), (TextBasedComponentStyle) null, 4, (DefaultConstructorMarker) null);
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            uiComponentArr[1] = new UiComponent.CombinedStepButton("take_photo", new UiComponent.Button.Attributes(str5, UiComponent.Button.ButtonType.PRIMARY, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 12, (DefaultConstructorMarker) null), (ButtonCombinedStepComponentStyle) null, 4, (DefaultConstructorMarker) null);
            if (str3 == null) {
                str6 = "";
            } else {
                str6 = str3;
            }
            uiComponentArr[2] = new UiComponent.CombinedStepButton("select_file", new UiComponent.Button.Attributes(str6, UiComponent.Button.ButtonType.SECONDARY, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 12, (DefaultConstructorMarker) null), (ButtonCombinedStepComponentStyle) null, 4, (DefaultConstructorMarker) null);
            return new UploadOptionsDialog(q.m(uiComponentArr), (StepStyles$UiStepStyle) null, "select_file", (String) null, "take_photo", (String) null);
        }
    }

    public static final class b implements Parcelable.Creator<UploadOptionsDialog> {
        /* renamed from: a */
        public final UploadOptionsDialog createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(UploadOptionsDialog.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new UploadOptionsDialog(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(UploadOptionsDialog.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final UploadOptionsDialog[] newArray(int i10) {
            return new UploadOptionsDialog[i10];
        }
    }

    public UploadOptionsDialog(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, String str2, String str3, String str4) {
        this.f25131a = list;
        this.f25132b = stepStyles$UiStepStyle;
        this.f25133c = str;
        this.f25134d = str2;
        this.f25135e = str3;
        this.f25136f = str4;
    }

    public final String a() {
        return this.f25136f;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25132b;
    }

    public final String c() {
        return this.f25133c;
    }

    public final String d() {
        return this.f25134d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f25135e;
    }

    public List<UiComponent> getComponents() {
        return this.f25131a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25131a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25132b, i10);
        parcel.writeString(this.f25133c);
        parcel.writeString(this.f25134d);
        parcel.writeString(this.f25135e);
        parcel.writeString(this.f25136f);
    }
}
