package com.withpersona.sdk2.inquiry.governmentid;

import android.os.Parcel;
import android.os.Parcelable;
import com.withpersona.sdk2.inquiry.steps.ui.NestedUiStep;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class PassportNfcConfirmDetailsPage implements NestedUiStep {
    public static final Parcelable.Creator<PassportNfcConfirmDetailsPage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f25677a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f25678b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25679c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25680d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25681e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25682f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25683g;

    /* renamed from: h  reason: collision with root package name */
    private final String f25684h;

    /* renamed from: j  reason: collision with root package name */
    private final String f25685j;

    /* renamed from: k  reason: collision with root package name */
    private final String f25686k;

    /* renamed from: l  reason: collision with root package name */
    private final String f25687l;

    /* renamed from: m  reason: collision with root package name */
    private final String f25688m;

    /* renamed from: n  reason: collision with root package name */
    private final String f25689n;

    /* renamed from: p  reason: collision with root package name */
    private final String f25690p;

    public static final class a implements Parcelable.Creator<PassportNfcConfirmDetailsPage> {
        /* renamed from: a */
        public final PassportNfcConfirmDetailsPage createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            j.g(parcel2, "parcel");
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList2.add(parcel2.readParcelable(PassportNfcConfirmDetailsPage.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            return new PassportNfcConfirmDetailsPage(arrayList, (StepStyles$UiStepStyle) parcel2.readParcelable(PassportNfcConfirmDetailsPage.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final PassportNfcConfirmDetailsPage[] newArray(int i10) {
            return new PassportNfcConfirmDetailsPage[i10];
        }
    }

    public PassportNfcConfirmDetailsPage(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.f25677a = list;
        this.f25678b = stepStyles$UiStepStyle;
        this.f25679c = str;
        this.f25680d = str2;
        this.f25681e = str3;
        this.f25682f = str4;
        this.f25683g = str5;
        this.f25684h = str6;
        this.f25685j = str7;
        this.f25686k = str8;
        this.f25687l = str9;
        this.f25688m = str10;
        this.f25689n = str11;
        this.f25690p = str12;
    }

    public final String a() {
        return this.f25688m;
    }

    public StepStyles$UiStepStyle b() {
        return this.f25678b;
    }

    public final String c() {
        return this.f25689n;
    }

    public final String d() {
        return this.f25681e;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f25682f;
    }

    public final String f() {
        return this.f25683g;
    }

    public final String g() {
        return this.f25685j;
    }

    public List<UiComponent> getComponents() {
        return this.f25677a;
    }

    public final String h() {
        return this.f25679c;
    }

    public final String i() {
        return this.f25686k;
    }

    public final String j() {
        return this.f25684h;
    }

    public final String k() {
        return this.f25687l;
    }

    public final String l() {
        return this.f25680d;
    }

    public final String m() {
        return this.f25690p;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f25677a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        parcel.writeParcelable(this.f25678b, i10);
        parcel.writeString(this.f25679c);
        parcel.writeString(this.f25680d);
        parcel.writeString(this.f25681e);
        parcel.writeString(this.f25682f);
        parcel.writeString(this.f25683g);
        parcel.writeString(this.f25684h);
        parcel.writeString(this.f25685j);
        parcel.writeString(this.f25686k);
        parcel.writeString(this.f25687l);
        parcel.writeString(this.f25688m);
        parcel.writeString(this.f25689n);
        parcel.writeString(this.f25690p);
    }
}
