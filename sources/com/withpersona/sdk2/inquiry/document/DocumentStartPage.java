package com.withpersona.sdk2.inquiry.document;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class DocumentStartPage implements NestedUiStep {
    public static final Parcelable.Creator<DocumentStartPage> CREATOR = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final a f24999g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25000a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25001b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25002c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25003d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25004e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25005f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DocumentStartPage a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            String str8;
            UiComponent[] uiComponentArr = new UiComponent[5];
            if (str == null) {
                str5 = "";
            } else {
                str5 = str;
            }
            uiComponentArr[0] = new UiComponent.Title("title", new UiComponent.Title.Attributes(str5, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 6, (DefaultConstructorMarker) null), (TextBasedComponentStyle) null, 4, (DefaultConstructorMarker) null);
            if (str2 == null) {
                str6 = "";
            } else {
                str6 = str2;
            }
            uiComponentArr[1] = new UiComponent.Text("body", new UiComponent.Text.Attributes(str6, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 6, (DefaultConstructorMarker) null), (TextBasedComponentStyle) null, 4, (DefaultConstructorMarker) null);
            uiComponentArr[2] = new UiComponent.LocalImage("hero_image", new UiComponent.LocalImage.Attributes(UiComponent.LocalImage.Image.DOCUMENT_START_HERO), (LocalImageComponentStyle) null, 4, (DefaultConstructorMarker) null);
            if (str4 == null) {
                str7 = "";
            } else {
                str7 = str4;
            }
            uiComponentArr[3] = new UiComponent.CombinedStepButton("camera_button", new UiComponent.Button.Attributes(str7, UiComponent.Button.ButtonType.PRIMARY, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 12, (DefaultConstructorMarker) null), (ButtonCombinedStepComponentStyle) null, 4, (DefaultConstructorMarker) null);
            if (str3 == null) {
                str8 = "";
            } else {
                str8 = str3;
            }
            uiComponentArr[4] = new UiComponent.CombinedStepButton("upload_button", new UiComponent.Button.Attributes(str8, UiComponent.Button.ButtonType.SECONDARY, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 12, (DefaultConstructorMarker) null), (ButtonCombinedStepComponentStyle) null, 4, (DefaultConstructorMarker) null);
            return new DocumentStartPage(q.m(uiComponentArr), (StepStyles$UiStepStyle) null, "upload_button", (String) null, "camera_button", (String) null);
        }
    }

    public static final class b implements Parcelable.Creator<DocumentStartPage> {
        /* renamed from: a */
        public final DocumentStartPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel.readParcelable(DocumentStartPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new DocumentStartPage(arrayList, (StepStyles$UiStepStyle) parcel.readParcelable(DocumentStartPage.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final DocumentStartPage[] newArray(int i10) {
            return new DocumentStartPage[i10];
        }
    }

    public DocumentStartPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, String str2, String str3, String str4) {
        this.f25000a = list;
        this.f25001b = stepStyles$UiStepStyle;
        this.f25002c = str;
        this.f25003d = str2;
        this.f25004e = str3;
        this.f25005f = str4;
    }

    public final String a() {
        return this.f25005f;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25001b;
    }

    public final String c() {
        return this.f25002c;
    }

    public final String d() {
        return this.f25003d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f25004e;
    }

    public List<UiComponent> getComponents() {
        return this.f25000a;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25000a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25001b, i10);
        parcel.writeString(this.f25002c);
        parcel.writeString(this.f25003d);
        parcel.writeString(this.f25004e);
        parcel.writeString(this.f25005f);
    }
}
