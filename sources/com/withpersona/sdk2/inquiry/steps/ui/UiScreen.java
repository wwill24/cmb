package com.withpersona.sdk2.inquiry.steps.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HeaderButtonColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$StepBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@i(generateAdapter = true)
public final class UiScreen implements Parcelable {
    public static final Parcelable.Creator<UiScreen> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<UiComponent> f27539a;

    /* renamed from: b  reason: collision with root package name */
    private final StepStyles$UiStepStyle f27540b;

    public static final class a implements Parcelable.Creator<UiScreen> {
        /* renamed from: a */
        public final UiScreen createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            j.g(parcel, "parcel");
            StepStyles$UiStepStyle stepStyles$UiStepStyle = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i10 = 0; i10 != readInt; i10++) {
                    arrayList.add(parcel.readParcelable(UiScreen.class.getClassLoader()));
                }
            }
            if (parcel.readInt() != 0) {
                stepStyles$UiStepStyle = StepStyles$UiStepStyle.CREATOR.createFromParcel(parcel);
            }
            return new UiScreen(arrayList, stepStyles$UiStepStyle);
        }

        /* renamed from: b */
        public final UiScreen[] newArray(int i10) {
            return new UiScreen[i10];
        }
    }

    public UiScreen(List<? extends UiComponent> list, StepStyles$UiStepStyle stepStyles$UiStepStyle) {
        this.f27539a = list;
        this.f27540b = stepStyles$UiStepStyle;
    }

    public final String a() {
        StepStyles$StepBackgroundColorStyle c10;
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle == null || (c10 = stepStyles$UiStepStyle.c()) == null || (a10 = c10.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StepStyles$UiStepStyle b() {
        return this.f27540b;
    }

    public final String c() {
        AttributeStyles$HeaderButtonColorStyle i10;
        StyleElements.SimpleElementColor a10;
        StyleElements.SimpleElementColorValue a11;
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle == null || (i10 = stepStyles$UiStepStyle.i()) == null || (a10 = i10.a()) == null || (a11 = a10.a()) == null) {
            return null;
        }
        return a11.a();
    }

    public final StyleElements.PositionType d() {
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle != null) {
            return stepStyles$UiStepStyle.k();
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiScreen)) {
            return false;
        }
        UiScreen uiScreen = (UiScreen) obj;
        return j.b(this.f27539a, uiScreen.f27539a) && j.b(this.f27540b, uiScreen.f27540b);
    }

    public final List<UiComponent> getComponents() {
        return this.f27539a;
    }

    public int hashCode() {
        List<UiComponent> list = this.f27539a;
        int i10 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle != null) {
            i10 = stepStyles$UiStepStyle.hashCode();
        }
        return hashCode + i10;
    }

    public final Drawable r1(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle != null) {
            return stepStyles$UiStepStyle.r1(context);
        }
        return null;
    }

    public String toString() {
        return "UiScreen(components=" + this.f27539a + ", styles=" + this.f27540b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        List<UiComponent> list = this.f27539a;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UiComponent writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i10);
            }
        }
        StepStyles$UiStepStyle stepStyles$UiStepStyle = this.f27540b;
        if (stepStyles$UiStepStyle == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        stepStyles$UiStepStyle.writeToParcel(parcel, i10);
    }
}
