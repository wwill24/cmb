package com.withpersona.sdk2.inquiry.steps.ui.network;

import ai.b;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.internal.Constants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.g;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.v;
import com.squareup.workflow1.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.components.d;
import com.withpersona.sdk2.inquiry.steps.ui.components.l;
import com.withpersona.sdk2.inquiry.steps.ui.components.m;
import com.withpersona.sdk2.inquiry.steps.ui.components.utils.inputConfirmation.SubmitConfirmationCodeHelper;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackAlignmentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackAxisStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackChildSizesStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackGapStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackPaddingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$DateSelectTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureFillColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignaturePrimaryButtonStyles;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignaturePrimaryButtonStylesContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureSecondaryButtonStyles;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ESignatureSecondaryButtonStylesContainer;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterPaddingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackAlignmentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackAxisStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackChildSizesStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackGapStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackPaddingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputRadioGroupTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputSelectTextLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBackgroundColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderRadiusStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeFillColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$SpacerHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$SpacerWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontFamilyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontSizeStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedFontWeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedLetterSpacingStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedLineHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$TextBasedTextColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonActionComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCancelComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCompleteComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonSubmitComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.ui.network.Suggestion;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.beanutils.PropertyUtils;
import yi.c;

public abstract class UiComponent implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f27604b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f27605a;

    @i(generateAdapter = true)
    public static final class ActionButton extends Button {
        public static final Parcelable.Creator<ActionButton> CREATOR = new b();

        /* renamed from: j  reason: collision with root package name */
        public static final a f27606j = new a((DefaultConstructorMarker) null);

        /* renamed from: f  reason: collision with root package name */
        private final String f27607f;

        /* renamed from: g  reason: collision with root package name */
        private final Button.Attributes f27608g;

        /* renamed from: h  reason: collision with root package name */
        private final ButtonActionComponentStyle f27609h;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<ActionButton> {
            /* renamed from: a */
            public final ActionButton createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ButtonActionComponentStyle buttonActionComponentStyle = null;
                Button.Attributes createFromParcel = parcel.readInt() == 0 ? null : Button.Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    buttonActionComponentStyle = ButtonActionComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new ActionButton(readString, createFromParcel, buttonActionComponentStyle);
            }

            /* renamed from: b */
            public final ActionButton[] newArray(int i10) {
                return new ActionButton[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActionButton(String str, Button.Attributes attributes, ButtonActionComponentStyle buttonActionComponentStyle) {
            super(str, attributes, buttonActionComponentStyle);
            j.g(str, "name");
            this.f27607f = str;
            this.f27608g = attributes;
            this.f27609h = buttonActionComponentStyle;
        }

        public String A() {
            return this.f27607f;
        }

        /* renamed from: B */
        public Button.Attributes z() {
            return this.f27608g;
        }

        /* renamed from: E */
        public ButtonActionComponentStyle D() {
            return this.f27609h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27607f);
            Button.Attributes attributes = this.f27608g;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ButtonActionComponentStyle buttonActionComponentStyle = this.f27609h;
            if (buttonActionComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            buttonActionComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class Branding extends UiComponent {
        public static final Parcelable.Creator<Branding> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f27610e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27611c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27612d;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final Boolean f27613a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    Boolean bool;
                    j.g(parcel, "parcel");
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    return new Attributes(bool);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(Boolean bool) {
                this.f27613a = bool;
            }

            public final Boolean a() {
                return this.f27613a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                boolean booleanValue;
                j.g(parcel, "out");
                Boolean bool = this.f27613a;
                if (bool == null) {
                    booleanValue = false;
                } else {
                    parcel.writeInt(1);
                    booleanValue = bool.booleanValue();
                }
                parcel.writeInt(booleanValue ? 1 : 0);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<Branding> {
            /* renamed from: a */
            public final Branding createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Branding(parcel.readString(), parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final Branding[] newArray(int i10) {
                return new Branding[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Branding(String str, Attributes attributes) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27611c = str;
            this.f27612d = attributes;
        }

        public String A() {
            return this.f27611c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27612d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27611c);
            Attributes attributes = this.f27612d;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class CancelButton extends Button {
        public static final Parcelable.Creator<CancelButton> CREATOR = new b();

        /* renamed from: j  reason: collision with root package name */
        public static final a f27622j = new a((DefaultConstructorMarker) null);

        /* renamed from: f  reason: collision with root package name */
        private final String f27623f;

        /* renamed from: g  reason: collision with root package name */
        private final Button.Attributes f27624g;

        /* renamed from: h  reason: collision with root package name */
        private final ButtonCancelComponentStyle f27625h;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<CancelButton> {
            /* renamed from: a */
            public final CancelButton createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ButtonCancelComponentStyle buttonCancelComponentStyle = null;
                Button.Attributes createFromParcel = parcel.readInt() == 0 ? null : Button.Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    buttonCancelComponentStyle = ButtonCancelComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new CancelButton(readString, createFromParcel, buttonCancelComponentStyle);
            }

            /* renamed from: b */
            public final CancelButton[] newArray(int i10) {
                return new CancelButton[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CancelButton(String str, Button.Attributes attributes, ButtonCancelComponentStyle buttonCancelComponentStyle) {
            super(str, attributes, buttonCancelComponentStyle);
            j.g(str, "name");
            this.f27623f = str;
            this.f27624g = attributes;
            this.f27625h = buttonCancelComponentStyle;
        }

        public String A() {
            return this.f27623f;
        }

        /* renamed from: B */
        public Button.Attributes z() {
            return this.f27624g;
        }

        /* renamed from: E */
        public ButtonCancelComponentStyle D() {
            return this.f27625h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27623f);
            Button.Attributes attributes = this.f27624g;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ButtonCancelComponentStyle buttonCancelComponentStyle = this.f27625h;
            if (buttonCancelComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            buttonCancelComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class ClickableStack extends UiComponent implements b {
        public static final Parcelable.Creator<ClickableStack> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27626g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27627c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27628d;

        /* renamed from: e  reason: collision with root package name */
        private final ClickableStackComponentStyle f27629e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f27630f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final List<UiComponent> f27631a;

            /* renamed from: b  reason: collision with root package name */
            private final JsonLogicBoolean f27632b;

            /* renamed from: c  reason: collision with root package name */
            private final JsonLogicBoolean f27633c;

            /* renamed from: d  reason: collision with root package name */
            private final List<cj.a> f27634d = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    ArrayList arrayList;
                    j.g(parcel, "parcel");
                    JsonLogicBoolean jsonLogicBoolean = null;
                    if (parcel.readInt() == 0) {
                        arrayList = null;
                    } else {
                        int readInt = parcel.readInt();
                        arrayList = new ArrayList(readInt);
                        for (int i10 = 0; i10 != readInt; i10++) {
                            arrayList.add(parcel.readParcelable(Attributes.class.getClassLoader()));
                        }
                    }
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(arrayList, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(List<? extends UiComponent> list, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27631a = list;
                this.f27632b = jsonLogicBoolean;
                this.f27633c = jsonLogicBoolean2;
            }

            public List<cj.a> a() {
                return this.f27634d;
            }

            public JsonLogicBoolean c() {
                return this.f27632b;
            }

            public JsonLogicBoolean d() {
                return this.f27633c;
            }

            public int describeContents() {
                return 0;
            }

            public final List<UiComponent> e() {
                return this.f27631a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27631a, attributes.f27631a) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public int hashCode() {
                List<UiComponent> list = this.f27631a;
                int i10 = 0;
                int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "Attributes(children=" + this.f27631a + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                List<UiComponent> list = this.f27631a;
                if (list == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(list.size());
                    for (UiComponent writeParcelable : list) {
                        parcel.writeParcelable(writeParcelable, i10);
                    }
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27632b;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27633c;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<ClickableStack> {
            /* renamed from: a */
            public final ClickableStack createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ClickableStackComponentStyle clickableStackComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    clickableStackComponentStyle = ClickableStackComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new ClickableStack(readString, createFromParcel, clickableStackComponentStyle, parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final ClickableStack[] newArray(int i10) {
                return new ClickableStack[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ClickableStack(String str, Attributes attributes, ClickableStackComponentStyle clickableStackComponentStyle, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, clickableStackComponentStyle, (i10 & 8) != 0 ? false : z10);
        }

        public String A() {
            return this.f27627c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27628d;
        }

        public final ClickableStackComponentStyle D() {
            return this.f27629e;
        }

        public final boolean E() {
            return this.f27630f;
        }

        public final void F(boolean z10) {
            this.f27630f = z10;
        }

        public final ClickableStack copy(String str, Attributes attributes, ClickableStackComponentStyle clickableStackComponentStyle, @g(ignore = true) boolean z10) {
            j.g(str, "name");
            return new ClickableStack(str, attributes, clickableStackComponentStyle, z10);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClickableStack)) {
                return false;
            }
            ClickableStack clickableStack = (ClickableStack) obj;
            return j.b(A(), clickableStack.A()) && j.b(z(), clickableStack.z()) && j.b(this.f27629e, clickableStack.f27629e) && this.f27630f == clickableStack.f27630f;
        }

        public List<UiComponent> getChildren() {
            Attributes B = z();
            if (B != null) {
                return B.e();
            }
            return null;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            ClickableStackComponentStyle clickableStackComponentStyle = this.f27629e;
            if (clickableStackComponentStyle != null) {
                i10 = clickableStackComponentStyle.hashCode();
            }
            int i11 = (hashCode + i10) * 31;
            boolean z10 = this.f27630f;
            if (z10) {
                z10 = true;
            }
            return i11 + (z10 ? 1 : 0);
        }

        public String toString() {
            return "ClickableStack(name=" + A() + ", attributes=" + z() + ", styles=" + this.f27629e + ", isActive=" + this.f27630f + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27627c);
            Attributes attributes = this.f27628d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ClickableStackComponentStyle clickableStackComponentStyle = this.f27629e;
            if (clickableStackComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                clickableStackComponentStyle.writeToParcel(parcel, i10);
            }
            parcel.writeInt(this.f27630f ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClickableStack(String str, Attributes attributes, ClickableStackComponentStyle clickableStackComponentStyle, @g(ignore = true) boolean z10) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27627c = str;
            this.f27628d = attributes;
            this.f27629e = clickableStackComponentStyle;
            this.f27630f = z10;
        }
    }

    @i(generateAdapter = true)
    public static final class ClickableStackComponentStyle implements Parcelable {
        public static final Parcelable.Creator<ClickableStackComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$ClickableStackBackgroundColorStyle f27635a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$ClickableStackBorderWidthStyle f27636b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$ClickableStackBorderColorStyle f27637c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$ClickableStackBorderRadiusStyle f27638d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$ClickableStackPaddingStyle f27639e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$ClickableStackMarginStyle f27640f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$ClickableStackAxisStyle f27641g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$ClickableStackChildSizesStyle f27642h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$ClickableStackAlignmentStyle f27643j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$ClickableStackGapStyle f27644k;

        public static final class a implements Parcelable.Creator<ClickableStackComponentStyle> {
            /* renamed from: a */
            public final ClickableStackComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$ClickableStackGapStyle attributeStyles$ClickableStackGapStyle = null;
                AttributeStyles$ClickableStackBackgroundColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackBackgroundColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackBorderWidthStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackBorderWidthStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackBorderColorStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackBorderColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackBorderRadiusStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackBorderRadiusStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackPaddingStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackPaddingStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackMarginStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackMarginStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackAxisStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackAxisStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackChildSizesStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackChildSizesStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ClickableStackAlignmentStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$ClickableStackAlignmentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$ClickableStackGapStyle = AttributeStyles$ClickableStackGapStyle.CREATOR.createFromParcel(parcel);
                }
                return new ClickableStackComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, attributeStyles$ClickableStackGapStyle);
            }

            /* renamed from: b */
            public final ClickableStackComponentStyle[] newArray(int i10) {
                return new ClickableStackComponentStyle[i10];
            }
        }

        public ClickableStackComponentStyle(AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle, AttributeStyles$ClickableStackBorderWidthStyle attributeStyles$ClickableStackBorderWidthStyle, AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle, AttributeStyles$ClickableStackBorderRadiusStyle attributeStyles$ClickableStackBorderRadiusStyle, AttributeStyles$ClickableStackPaddingStyle attributeStyles$ClickableStackPaddingStyle, AttributeStyles$ClickableStackMarginStyle attributeStyles$ClickableStackMarginStyle, AttributeStyles$ClickableStackAxisStyle attributeStyles$ClickableStackAxisStyle, AttributeStyles$ClickableStackChildSizesStyle attributeStyles$ClickableStackChildSizesStyle, AttributeStyles$ClickableStackAlignmentStyle attributeStyles$ClickableStackAlignmentStyle, AttributeStyles$ClickableStackGapStyle attributeStyles$ClickableStackGapStyle) {
            this.f27635a = attributeStyles$ClickableStackBackgroundColorStyle;
            this.f27636b = attributeStyles$ClickableStackBorderWidthStyle;
            this.f27637c = attributeStyles$ClickableStackBorderColorStyle;
            this.f27638d = attributeStyles$ClickableStackBorderRadiusStyle;
            this.f27639e = attributeStyles$ClickableStackPaddingStyle;
            this.f27640f = attributeStyles$ClickableStackMarginStyle;
            this.f27641g = attributeStyles$ClickableStackAxisStyle;
            this.f27642h = attributeStyles$ClickableStackChildSizesStyle;
            this.f27643j = attributeStyles$ClickableStackAlignmentStyle;
            this.f27644k = attributeStyles$ClickableStackGapStyle;
        }

        public final StyleElements.DPSizeSet A() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$ClickableStackPaddingStyle attributeStyles$ClickableStackPaddingStyle = this.f27639e;
            if (attributeStyles$ClickableStackPaddingStyle == null || (a10 = attributeStyles$ClickableStackPaddingStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String a() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle = this.f27635a;
            if (attributeStyles$ClickableStackBackgroundColorStyle == null || (a10 = attributeStyles$ClickableStackBackgroundColorStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String c() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle = this.f27637c;
            if (attributeStyles$ClickableStackBorderColorStyle == null || (a10 = attributeStyles$ClickableStackBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackAlignmentStyle d() {
            return this.f27643j;
        }

        public int describeContents() {
            return 0;
        }

        public final StyleElements.PositionType e() {
            StyleElements.Position a10;
            AttributeStyles$ClickableStackAlignmentStyle attributeStyles$ClickableStackAlignmentStyle = this.f27643j;
            if (attributeStyles$ClickableStackAlignmentStyle == null || (a10 = attributeStyles$ClickableStackAlignmentStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackAxisStyle f() {
            return this.f27641g;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.a()).a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Axis g() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ClickableStackAxisStyle r0 = r1.f27641g
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$AxisContainer r0 = r0.a()
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis r0 = r0.a()
                if (r0 != 0) goto L_0x0012
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Axis.HORIZONTAL
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.ClickableStackComponentStyle.g():com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis");
        }

        public final AttributeStyles$ClickableStackBackgroundColorStyle h() {
            return this.f27635a;
        }

        public final String i() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle = this.f27635a;
            if (attributeStyles$ClickableStackBackgroundColorStyle == null || (a10 = attributeStyles$ClickableStackBackgroundColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final String j() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle = this.f27637c;
            if (attributeStyles$ClickableStackBorderColorStyle == null || (a10 = attributeStyles$ClickableStackBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final AttributeStyles$ClickableStackBorderColorStyle k() {
            return this.f27637c;
        }

        public final AttributeStyles$ClickableStackBorderRadiusStyle l() {
            return this.f27638d;
        }

        public final StyleElements.DPSize m() {
            StyleElements.DPMeasurement a10;
            AttributeStyles$ClickableStackBorderRadiusStyle attributeStyles$ClickableStackBorderRadiusStyle = this.f27638d;
            if (attributeStyles$ClickableStackBorderRadiusStyle == null || (a10 = attributeStyles$ClickableStackBorderRadiusStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackBorderWidthStyle n() {
            return this.f27636b;
        }

        public final StyleElements.DPSizeSet o() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$ClickableStackBorderWidthStyle attributeStyles$ClickableStackBorderWidthStyle = this.f27636b;
            if (attributeStyles$ClickableStackBorderWidthStyle == null || (a10 = attributeStyles$ClickableStackBorderWidthStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackChildSizesStyle p() {
            return this.f27642h;
        }

        public final int[] q() {
            StyleElements.ChildSizes a10;
            AttributeStyles$ClickableStackChildSizesStyle attributeStyles$ClickableStackChildSizesStyle = this.f27642h;
            if (attributeStyles$ClickableStackChildSizesStyle == null || (a10 = attributeStyles$ClickableStackChildSizesStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String r() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle = this.f27635a;
            if (attributeStyles$ClickableStackBackgroundColorStyle == null || (a10 = attributeStyles$ClickableStackBackgroundColorStyle.a()) == null) {
                return null;
            }
            return a10.d();
        }

        public final String s() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle = this.f27637c;
            if (attributeStyles$ClickableStackBorderColorStyle == null || (a10 = attributeStyles$ClickableStackBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.d();
        }

        public final AttributeStyles$ClickableStackGapStyle t() {
            return this.f27644k;
        }

        public final StyleElements.DPSize u() {
            StyleElements.DPMeasurement a10;
            AttributeStyles$ClickableStackGapStyle attributeStyles$ClickableStackGapStyle = this.f27644k;
            if (attributeStyles$ClickableStackGapStyle == null || (a10 = attributeStyles$ClickableStackGapStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackMarginStyle w() {
            return this.f27640f;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$ClickableStackBackgroundColorStyle attributeStyles$ClickableStackBackgroundColorStyle = this.f27635a;
            if (attributeStyles$ClickableStackBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackBorderWidthStyle attributeStyles$ClickableStackBorderWidthStyle = this.f27636b;
            if (attributeStyles$ClickableStackBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackBorderColorStyle attributeStyles$ClickableStackBorderColorStyle = this.f27637c;
            if (attributeStyles$ClickableStackBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackBorderRadiusStyle attributeStyles$ClickableStackBorderRadiusStyle = this.f27638d;
            if (attributeStyles$ClickableStackBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackPaddingStyle attributeStyles$ClickableStackPaddingStyle = this.f27639e;
            if (attributeStyles$ClickableStackPaddingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackPaddingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackMarginStyle attributeStyles$ClickableStackMarginStyle = this.f27640f;
            if (attributeStyles$ClickableStackMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackAxisStyle attributeStyles$ClickableStackAxisStyle = this.f27641g;
            if (attributeStyles$ClickableStackAxisStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackAxisStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackChildSizesStyle attributeStyles$ClickableStackChildSizesStyle = this.f27642h;
            if (attributeStyles$ClickableStackChildSizesStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackChildSizesStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackAlignmentStyle attributeStyles$ClickableStackAlignmentStyle = this.f27643j;
            if (attributeStyles$ClickableStackAlignmentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ClickableStackAlignmentStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ClickableStackGapStyle attributeStyles$ClickableStackGapStyle = this.f27644k;
            if (attributeStyles$ClickableStackGapStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$ClickableStackGapStyle.writeToParcel(parcel, i10);
        }

        public final StyleElements.DPSizeSet x() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$ClickableStackMarginStyle attributeStyles$ClickableStackMarginStyle = this.f27640f;
            if (attributeStyles$ClickableStackMarginStyle == null || (a10 = attributeStyles$ClickableStackMarginStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ClickableStackPaddingStyle z() {
            return this.f27639e;
        }
    }

    @i(generateAdapter = true)
    public static final class CombinedStepButton extends Button {
        public static final Parcelable.Creator<CombinedStepButton> CREATOR = new b();

        /* renamed from: j  reason: collision with root package name */
        public static final a f27645j = new a((DefaultConstructorMarker) null);

        /* renamed from: f  reason: collision with root package name */
        private final String f27646f;

        /* renamed from: g  reason: collision with root package name */
        private final Button.Attributes f27647g;

        /* renamed from: h  reason: collision with root package name */
        private final ButtonCombinedStepComponentStyle f27648h;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<CombinedStepButton> {
            /* renamed from: a */
            public final CombinedStepButton createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ButtonCombinedStepComponentStyle buttonCombinedStepComponentStyle = null;
                Button.Attributes createFromParcel = parcel.readInt() == 0 ? null : Button.Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    buttonCombinedStepComponentStyle = ButtonCombinedStepComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new CombinedStepButton(readString, createFromParcel, buttonCombinedStepComponentStyle);
            }

            /* renamed from: b */
            public final CombinedStepButton[] newArray(int i10) {
                return new CombinedStepButton[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CombinedStepButton(String str, Button.Attributes attributes, ButtonCombinedStepComponentStyle buttonCombinedStepComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : buttonCombinedStepComponentStyle);
        }

        public String A() {
            return this.f27646f;
        }

        /* renamed from: B */
        public Button.Attributes z() {
            return this.f27647g;
        }

        /* renamed from: E */
        public ButtonCombinedStepComponentStyle D() {
            return this.f27648h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27646f);
            Button.Attributes attributes = this.f27647g;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ButtonCombinedStepComponentStyle buttonCombinedStepComponentStyle = this.f27648h;
            if (buttonCombinedStepComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            buttonCombinedStepComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CombinedStepButton(String str, Button.Attributes attributes, ButtonCombinedStepComponentStyle buttonCombinedStepComponentStyle) {
            super(str, attributes, buttonCombinedStepComponentStyle);
            j.g(str, "name");
            this.f27646f = str;
            this.f27647g = attributes;
            this.f27648h = buttonCombinedStepComponentStyle;
        }
    }

    @i(generateAdapter = true)
    public static final class CombinedStepImagePreview extends UiComponent {
        public static final Parcelable.Creator<CombinedStepImagePreview> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27649f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27650c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27651d;

        /* renamed from: e  reason: collision with root package name */
        private final CombinedStepImagePreviewComponentStyle f27652e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    parcel.readInt();
                    return new Attributes();
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeInt(1);
            }
        }

        @i(generateAdapter = true)
        public static final class CombinedStepImagePreviewComponentStyle implements Parcelable {
            public static final Parcelable.Creator<CombinedStepImagePreviewComponentStyle> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final AttributeStyles$RemoteImageHeightStyle f27653a;

            /* renamed from: b  reason: collision with root package name */
            private final AttributeStyles$RemoteImageWidthStyle f27654b;

            /* renamed from: c  reason: collision with root package name */
            private final AttributeStyles$RemoteImageJustifyStyle f27655c;

            /* renamed from: d  reason: collision with root package name */
            private final AttributeStyles$RemoteImageMarginStyle f27656d;

            public static final class a implements Parcelable.Creator<CombinedStepImagePreviewComponentStyle> {
                /* renamed from: a */
                public final CombinedStepImagePreviewComponentStyle createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = null;
                    AttributeStyles$RemoteImageHeightStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageHeightStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$RemoteImageWidthStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageWidthStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$RemoteImageJustifyStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageJustifyStyle.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        attributeStyles$RemoteImageMarginStyle = AttributeStyles$RemoteImageMarginStyle.CREATOR.createFromParcel(parcel);
                    }
                    return new CombinedStepImagePreviewComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, attributeStyles$RemoteImageMarginStyle);
                }

                /* renamed from: b */
                public final CombinedStepImagePreviewComponentStyle[] newArray(int i10) {
                    return new CombinedStepImagePreviewComponentStyle[i10];
                }
            }

            public CombinedStepImagePreviewComponentStyle(AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle, AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle, AttributeStyles$RemoteImageJustifyStyle attributeStyles$RemoteImageJustifyStyle, AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle) {
                this.f27653a = attributeStyles$RemoteImageHeightStyle;
                this.f27654b = attributeStyles$RemoteImageWidthStyle;
                this.f27655c = attributeStyles$RemoteImageJustifyStyle;
                this.f27656d = attributeStyles$RemoteImageMarginStyle;
            }

            public final AttributeStyles$RemoteImageHeightStyle a() {
                return this.f27653a;
            }

            public final StyleElements.Size c() {
                StyleElements.Measurement a10;
                AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle = this.f27653a;
                if (attributeStyles$RemoteImageHeightStyle == null || (a10 = attributeStyles$RemoteImageHeightStyle.a()) == null) {
                    return null;
                }
                return a10.a();
            }

            public final AttributeStyles$RemoteImageJustifyStyle d() {
                return this.f27655c;
            }

            public int describeContents() {
                return 0;
            }

            public final AttributeStyles$RemoteImageMarginStyle e() {
                return this.f27656d;
            }

            public final StyleElements.DPSizeSet f() {
                StyleElements.DPMeasurementSet a10;
                AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = this.f27656d;
                if (attributeStyles$RemoteImageMarginStyle == null || (a10 = attributeStyles$RemoteImageMarginStyle.a()) == null) {
                    return null;
                }
                return a10.a();
            }

            public final AttributeStyles$RemoteImageWidthStyle g() {
                return this.f27654b;
            }

            public final StyleElements.Size h() {
                StyleElements.Measurement a10;
                AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle = this.f27654b;
                if (attributeStyles$RemoteImageWidthStyle == null || (a10 = attributeStyles$RemoteImageWidthStyle.a()) == null) {
                    return null;
                }
                return a10.a();
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle = this.f27653a;
                if (attributeStyles$RemoteImageHeightStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$RemoteImageHeightStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle = this.f27654b;
                if (attributeStyles$RemoteImageWidthStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$RemoteImageWidthStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$RemoteImageJustifyStyle attributeStyles$RemoteImageJustifyStyle = this.f27655c;
                if (attributeStyles$RemoteImageJustifyStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$RemoteImageJustifyStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = this.f27656d;
                if (attributeStyles$RemoteImageMarginStyle == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                attributeStyles$RemoteImageMarginStyle.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<CombinedStepImagePreview> {
            /* renamed from: a */
            public final CombinedStepImagePreview createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    combinedStepImagePreviewComponentStyle = CombinedStepImagePreviewComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new CombinedStepImagePreview(readString, createFromParcel, combinedStepImagePreviewComponentStyle);
            }

            /* renamed from: b */
            public final CombinedStepImagePreview[] newArray(int i10) {
                return new CombinedStepImagePreview[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CombinedStepImagePreview(String str, Attributes attributes, CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : combinedStepImagePreviewComponentStyle);
        }

        public String A() {
            return this.f27650c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27651d;
        }

        public final CombinedStepImagePreviewComponentStyle D() {
            return this.f27652e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27650c);
            Attributes attributes = this.f27651d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle = this.f27652e;
            if (combinedStepImagePreviewComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            combinedStepImagePreviewComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CombinedStepImagePreview(String str, Attributes attributes, CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27650c = str;
            this.f27651d = attributes;
            this.f27652e = combinedStepImagePreviewComponentStyle;
        }
    }

    @i(generateAdapter = true)
    public static final class CompleteButton extends Button {
        public static final Parcelable.Creator<CompleteButton> CREATOR = new b();

        /* renamed from: j  reason: collision with root package name */
        public static final a f27657j = new a((DefaultConstructorMarker) null);

        /* renamed from: f  reason: collision with root package name */
        private final String f27658f;

        /* renamed from: g  reason: collision with root package name */
        private final Button.Attributes f27659g;

        /* renamed from: h  reason: collision with root package name */
        private final ButtonCompleteComponentStyle f27660h;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<CompleteButton> {
            /* renamed from: a */
            public final CompleteButton createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ButtonCompleteComponentStyle buttonCompleteComponentStyle = null;
                Button.Attributes createFromParcel = parcel.readInt() == 0 ? null : Button.Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    buttonCompleteComponentStyle = ButtonCompleteComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new CompleteButton(readString, createFromParcel, buttonCompleteComponentStyle);
            }

            /* renamed from: b */
            public final CompleteButton[] newArray(int i10) {
                return new CompleteButton[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CompleteButton(String str, Button.Attributes attributes, ButtonCompleteComponentStyle buttonCompleteComponentStyle) {
            super(str, attributes, buttonCompleteComponentStyle);
            j.g(str, "name");
            this.f27658f = str;
            this.f27659g = attributes;
            this.f27660h = buttonCompleteComponentStyle;
        }

        public String A() {
            return this.f27658f;
        }

        /* renamed from: B */
        public Button.Attributes z() {
            return this.f27659g;
        }

        /* renamed from: E */
        public ButtonCompleteComponentStyle D() {
            return this.f27660h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27658f);
            Button.Attributes attributes = this.f27659g;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ButtonCompleteComponentStyle buttonCompleteComponentStyle = this.f27660h;
            if (buttonCompleteComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            buttonCompleteComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class ESignature extends UiComponent implements com.withpersona.sdk2.inquiry.steps.ui.components.b<ESignature> {
        public static final Parcelable.Creator<ESignature> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27661g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27662c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27663d;

        /* renamed from: e  reason: collision with root package name */
        private final ESignatureComponentStyle f27664e;

        /* renamed from: f  reason: collision with root package name */
        private yi.a f27665f = new yi.a((Bitmap) null);

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27666a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27667b;

            /* renamed from: c  reason: collision with root package name */
            private final JsonLogicBoolean f27668c;

            /* renamed from: d  reason: collision with root package name */
            private final JsonLogicBoolean f27669d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27670e;

            /* renamed from: f  reason: collision with root package name */
            private final String f27671f;

            /* renamed from: g  reason: collision with root package name */
            private final String f27672g;

            /* renamed from: h  reason: collision with root package name */
            private final String f27673h;

            /* renamed from: j  reason: collision with root package name */
            private final String f27674j;

            /* renamed from: k  reason: collision with root package name */
            private final List<cj.a> f27675k = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, createFromParcel, jsonLogicBoolean, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, String str3, String str4, String str5, String str6, String str7) {
                this.f27666a = str;
                this.f27667b = str2;
                this.f27668c = jsonLogicBoolean;
                this.f27669d = jsonLogicBoolean2;
                this.f27670e = str3;
                this.f27671f = str4;
                this.f27672g = str5;
                this.f27673h = str6;
                this.f27674j = str7;
            }

            public List<cj.a> a() {
                return this.f27675k;
            }

            public JsonLogicBoolean c() {
                return this.f27668c;
            }

            public JsonLogicBoolean d() {
                return this.f27669d;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f27671f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27666a, attributes.f27666a) && j.b(this.f27667b, attributes.f27667b) && j.b(c(), attributes.c()) && j.b(d(), attributes.d()) && j.b(this.f27670e, attributes.f27670e) && j.b(this.f27671f, attributes.f27671f) && j.b(this.f27672g, attributes.f27672g) && j.b(this.f27673h, attributes.f27673h) && j.b(this.f27674j, attributes.f27674j);
            }

            public final String f() {
                return this.f27673h;
            }

            public final String g() {
                return this.f27666a;
            }

            public final String h() {
                return this.f27667b;
            }

            public int hashCode() {
                String str = this.f27666a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27667b;
                int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + (d() == null ? 0 : d().hashCode())) * 31;
                String str3 = this.f27670e;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27671f;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.f27672g;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.f27673h;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.f27674j;
                if (str7 != null) {
                    i10 = str7.hashCode();
                }
                return hashCode6 + i10;
            }

            public final String i() {
                return this.f27670e;
            }

            public final String j() {
                return this.f27674j;
            }

            public final String k() {
                return this.f27672g;
            }

            public String toString() {
                return "Attributes(field=" + this.f27666a + ", label=" + this.f27667b + ", hidden=" + c() + ", disabled=" + d() + ", placeholder=" + this.f27670e + ", addSignatureText=" + this.f27671f + ", saveButtonText=" + this.f27672g + ", clearButtonText=" + this.f27673h + ", prefill=" + this.f27674j + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27666a);
                parcel.writeString(this.f27667b);
                JsonLogicBoolean jsonLogicBoolean = this.f27668c;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27669d;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean2.writeToParcel(parcel, i10);
                }
                parcel.writeString(this.f27670e);
                parcel.writeString(this.f27671f);
                parcel.writeString(this.f27672g);
                parcel.writeString(this.f27673h);
                parcel.writeString(this.f27674j);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<ESignature> {
            /* renamed from: a */
            public final ESignature createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ESignatureComponentStyle eSignatureComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    eSignatureComponentStyle = ESignatureComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new ESignature(readString, createFromParcel, eSignatureComponentStyle);
            }

            /* renamed from: b */
            public final ESignature[] newArray(int i10) {
                return new ESignature[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ESignature(String str, Attributes attributes, ESignatureComponentStyle eSignatureComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27662c = str;
            this.f27663d = attributes;
            this.f27664e = eSignatureComponentStyle;
        }

        public static /* synthetic */ ESignature D(ESignature eSignature, String str, Attributes attributes, ESignatureComponentStyle eSignatureComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = eSignature.A();
            }
            if ((i10 & 2) != 0) {
                attributes = eSignature.z();
            }
            if ((i10 & 4) != 0) {
                eSignatureComponentStyle = eSignature.f27664e;
            }
            return eSignature.B(str, attributes, eSignatureComponentStyle);
        }

        @g(ignore = true)
        public static /* synthetic */ void getBitmapController$annotations() {
        }

        public String A() {
            return this.f27662c;
        }

        public final ESignature B(String str, Attributes attributes, ESignatureComponentStyle eSignatureComponentStyle) {
            j.g(str, "name");
            return new ESignature(str, attributes, eSignatureComponentStyle);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27663d;
        }

        public final ESignatureComponentStyle F() {
            return this.f27664e;
        }

        public void G(yi.a aVar) {
            j.g(aVar, "<set-?>");
            this.f27665f = aVar;
        }

        /* renamed from: H */
        public ESignature o(Bitmap bitmap) {
            ESignature D = D(this, (String) null, (Attributes) null, (ESignatureComponentStyle) null, 7, (Object) null);
            D.G(h());
            return D;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ESignature)) {
                return false;
            }
            ESignature eSignature = (ESignature) obj;
            return j.b(A(), eSignature.A()) && j.b(z(), eSignature.z()) && j.b(this.f27664e, eSignature.f27664e);
        }

        public yi.a h() {
            return this.f27665f;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            ESignatureComponentStyle eSignatureComponentStyle = this.f27664e;
            if (eSignatureComponentStyle != null) {
                i10 = eSignatureComponentStyle.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "ESignature(name=" + A() + ", attributes=" + z() + ", styles=" + this.f27664e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27662c);
            Attributes attributes = this.f27663d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ESignatureComponentStyle eSignatureComponentStyle = this.f27664e;
            if (eSignatureComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            eSignatureComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class ESignatureComponentStyle implements Parcelable {
        public static final Parcelable.Creator<ESignatureComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$ESignaturePrimaryButtonStyles f27676a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$ESignatureSecondaryButtonStyles f27677b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$ESignatureFillColorStyle f27678c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$ESignatureBackgroundColorStyle f27679d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontFamilyStyle f27680e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontSizeStyle f27681f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontWeightStyle f27682g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLetterSpacingStyle f27683h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLineHeightStyle f27684j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$DateSelectTextColorStyle f27685k;

        /* renamed from: l  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderRadiusStyle f27686l;

        /* renamed from: m  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderWidthStyle f27687m;

        /* renamed from: n  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderColorStyle f27688n;

        /* renamed from: p  reason: collision with root package name */
        private final AttributeStyles$InputMarginStyle f27689p;

        /* renamed from: q  reason: collision with root package name */
        private final AttributeStyles$TextBasedJustifyStyle f27690q;

        /* renamed from: t  reason: collision with root package name */
        private final AttributeStyles$DateSelectStrokeColorStyle f27691t;

        public static final class a implements Parcelable.Creator<ESignatureComponentStyle> {
            /* renamed from: a */
            public final ESignatureComponentStyle createFromParcel(Parcel parcel) {
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = null;
                AttributeStyles$ESignaturePrimaryButtonStyles createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$ESignaturePrimaryButtonStyles.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ESignatureSecondaryButtonStyles createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$ESignatureSecondaryButtonStyles.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ESignatureFillColorStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$ESignatureFillColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ESignatureBackgroundColorStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$ESignatureBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedFontFamilyStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontFamilyStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedFontSizeStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontSizeStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedFontWeightStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontWeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedLetterSpacingStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedLineHeightStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLineHeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectTextColorStyle createFromParcel10 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectTextColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderRadiusStyle createFromParcel11 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderRadiusStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderWidthStyle createFromParcel12 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderWidthStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderColorStyle createFromParcel13 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputMarginStyle createFromParcel14 = parcel.readInt() == 0 ? null : AttributeStyles$InputMarginStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$TextBasedJustifyStyle createFromParcel15 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedJustifyStyle.CREATOR.createFromParcel(parcel2);
                if (parcel.readInt() != 0) {
                    attributeStyles$DateSelectStrokeColorStyle = AttributeStyles$DateSelectStrokeColorStyle.CREATOR.createFromParcel(parcel2);
                }
                return new ESignatureComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, createFromParcel13, createFromParcel14, createFromParcel15, attributeStyles$DateSelectStrokeColorStyle);
            }

            /* renamed from: b */
            public final ESignatureComponentStyle[] newArray(int i10) {
                return new ESignatureComponentStyle[i10];
            }
        }

        public ESignatureComponentStyle(AttributeStyles$ESignaturePrimaryButtonStyles attributeStyles$ESignaturePrimaryButtonStyles, AttributeStyles$ESignatureSecondaryButtonStyles attributeStyles$ESignatureSecondaryButtonStyles, AttributeStyles$ESignatureFillColorStyle attributeStyles$ESignatureFillColorStyle, AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle, AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle, AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle, AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle, AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle, AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle, AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle, AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle, AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle, AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle, AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle, AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle, AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle) {
            this.f27676a = attributeStyles$ESignaturePrimaryButtonStyles;
            this.f27677b = attributeStyles$ESignatureSecondaryButtonStyles;
            this.f27678c = attributeStyles$ESignatureFillColorStyle;
            this.f27679d = attributeStyles$ESignatureBackgroundColorStyle;
            this.f27680e = attributeStyles$ComplexTextBasedFontFamilyStyle;
            this.f27681f = attributeStyles$ComplexTextBasedFontSizeStyle;
            this.f27682g = attributeStyles$ComplexTextBasedFontWeightStyle;
            this.f27683h = attributeStyles$ComplexTextBasedLetterSpacingStyle;
            this.f27684j = attributeStyles$ComplexTextBasedLineHeightStyle;
            this.f27685k = attributeStyles$DateSelectTextColorStyle;
            this.f27686l = attributeStyles$DateSelectBorderRadiusStyle;
            this.f27687m = attributeStyles$DateSelectBorderWidthStyle;
            this.f27688n = attributeStyles$DateSelectBorderColorStyle;
            this.f27689p = attributeStyles$InputMarginStyle;
            this.f27690q = attributeStyles$TextBasedJustifyStyle;
            this.f27691t = attributeStyles$DateSelectStrokeColorStyle;
        }

        public final String A0() {
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            AttributeStyles$ESignatureFillColorStyle attributeStyles$ESignatureFillColorStyle = this.f27678c;
            if (attributeStyles$ESignatureFillColorStyle == null || (a10 = attributeStyles$ESignatureFillColorStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final AttributeStyles$ESignatureBackgroundColorStyle a() {
            return this.f27679d;
        }

        public final AttributeStyles$DateSelectBorderColorStyle c() {
            return this.f27688n;
        }

        public final AttributeStyles$DateSelectBorderRadiusStyle d() {
            return this.f27686l;
        }

        public int describeContents() {
            return 0;
        }

        public final AttributeStyles$DateSelectBorderWidthStyle e() {
            return this.f27687m;
        }

        public final AttributeStyles$ESignaturePrimaryButtonStyles f() {
            return this.f27676a;
        }

        public final AttributeStyles$ESignatureSecondaryButtonStyles g() {
            return this.f27677b;
        }

        public final ButtonCancelComponentStyle h() {
            AttributeStyles$ESignatureSecondaryButtonStylesContainer a10;
            AttributeStyles$ESignatureSecondaryButtonStyles attributeStyles$ESignatureSecondaryButtonStyles = this.f27677b;
            if (attributeStyles$ESignatureSecondaryButtonStyles == null || (a10 = attributeStyles$ESignatureSecondaryButtonStyles.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$ESignatureFillColorStyle i() {
            return this.f27678c;
        }

        public final AttributeStyles$ComplexTextBasedFontFamilyStyle j() {
            return this.f27680e;
        }

        public final AttributeStyles$ComplexTextBasedFontSizeStyle k() {
            return this.f27681f;
        }

        public final AttributeStyles$ComplexTextBasedFontWeightStyle l() {
            return this.f27682g;
        }

        public final InputTextBasedComponentStyle m() {
            StyleElements.ComplexElementColor complexElementColor;
            StyleElements.ComplexElementColor complexElementColor2;
            StyleElements.ComplexElementColor complexElementColor3;
            StyleElements.ComplexElementColor complexElementColor4;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.DPMeasurementSet dPMeasurementSet;
            StyleElements.ComplexElementColor complexElementColor5;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27689p;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27680e;
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27681f;
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27682g;
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27683h;
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27684j;
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = this.f27685k;
            StyleElements.ComplexElementColor complexElementColor6 = null;
            if (attributeStyles$DateSelectTextColorStyle != null) {
                complexElementColor = attributeStyles$DateSelectTextColorStyle.f();
            } else {
                complexElementColor = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle2 = this.f27685k;
            if (attributeStyles$DateSelectTextColorStyle2 != null) {
                complexElementColor2 = attributeStyles$DateSelectTextColorStyle2.e();
            } else {
                complexElementColor2 = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle3 = this.f27685k;
            if (attributeStyles$DateSelectTextColorStyle3 != null) {
                complexElementColor3 = attributeStyles$DateSelectTextColorStyle3.d();
            } else {
                complexElementColor3 = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle4 = this.f27685k;
            if (attributeStyles$DateSelectTextColorStyle4 != null) {
                complexElementColor4 = attributeStyles$DateSelectTextColorStyle4.a();
            } else {
                complexElementColor4 = null;
            }
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = new AttributeStyles$ComplexTextBasedTextColorStyle(complexElementColor, complexElementColor2, complexElementColor3, complexElementColor4);
            AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = this.f27686l;
            if (attributeStyles$DateSelectBorderRadiusStyle != null) {
                dPMeasurement = attributeStyles$DateSelectBorderRadiusStyle.a();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle = new AttributeStyles$InputTextBorderRadiusStyle(dPMeasurement);
            AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = this.f27687m;
            if (attributeStyles$DateSelectBorderWidthStyle != null) {
                dPMeasurementSet = attributeStyles$DateSelectBorderWidthStyle.a();
            } else {
                dPMeasurementSet = null;
            }
            AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle = new AttributeStyles$InputTextBorderWidthStyle(dPMeasurementSet);
            AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle = this.f27679d;
            if (attributeStyles$ESignatureBackgroundColorStyle != null) {
                complexElementColor5 = attributeStyles$ESignatureBackgroundColorStyle.a();
            } else {
                complexElementColor5 = null;
            }
            AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle = new AttributeStyles$InputTextBackgroundColorStyle(complexElementColor5);
            AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = this.f27688n;
            if (attributeStyles$DateSelectBorderColorStyle != null) {
                complexElementColor6 = attributeStyles$DateSelectBorderColorStyle.a();
            }
            return new InputTextBasedComponentStyle(attributeStyles$InputMarginStyle, attributeStyles$ComplexTextBasedFontFamilyStyle, attributeStyles$ComplexTextBasedFontSizeStyle, attributeStyles$ComplexTextBasedFontWeightStyle, attributeStyles$ComplexTextBasedLetterSpacingStyle, attributeStyles$ComplexTextBasedLineHeightStyle, attributeStyles$ComplexTextBasedTextColorStyle, attributeStyles$InputTextBorderRadiusStyle, attributeStyles$InputTextBorderWidthStyle, attributeStyles$InputTextBackgroundColorStyle, new AttributeStyles$InputTextBorderColorStyle(complexElementColor6), (AttributeStyles$InputTextStrokeColorStyle) null);
        }

        public final AttributeStyles$TextBasedJustifyStyle n() {
            return this.f27690q;
        }

        public final AttributeStyles$ComplexTextBasedLetterSpacingStyle o() {
            return this.f27683h;
        }

        public final AttributeStyles$ComplexTextBasedLineHeightStyle p() {
            return this.f27684j;
        }

        public final AttributeStyles$InputMarginStyle q() {
            return this.f27689p;
        }

        public final StyleElements.DPSizeSet r() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27689p;
            if (attributeStyles$InputMarginStyle == null || (a10 = attributeStyles$InputMarginStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String s() {
            StyleElements.SimpleElementColor c10;
            StyleElements.SimpleElementColorValue a10;
            AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle = this.f27679d;
            if (attributeStyles$ESignatureBackgroundColorStyle == null || (c10 = attributeStyles$ESignatureBackgroundColorStyle.c()) == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$DateSelectStrokeColorStyle t() {
            return this.f27691t;
        }

        public final ButtonSubmitComponentStyle u() {
            AttributeStyles$ESignaturePrimaryButtonStylesContainer a10;
            AttributeStyles$ESignaturePrimaryButtonStyles attributeStyles$ESignaturePrimaryButtonStyles = this.f27676a;
            if (attributeStyles$ESignaturePrimaryButtonStyles == null || (a10 = attributeStyles$ESignaturePrimaryButtonStyles.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$DateSelectTextColorStyle w() {
            return this.f27685k;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$ESignaturePrimaryButtonStyles attributeStyles$ESignaturePrimaryButtonStyles = this.f27676a;
            if (attributeStyles$ESignaturePrimaryButtonStyles == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ESignaturePrimaryButtonStyles.writeToParcel(parcel, i10);
            }
            AttributeStyles$ESignatureSecondaryButtonStyles attributeStyles$ESignatureSecondaryButtonStyles = this.f27677b;
            if (attributeStyles$ESignatureSecondaryButtonStyles == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ESignatureSecondaryButtonStyles.writeToParcel(parcel, i10);
            }
            AttributeStyles$ESignatureFillColorStyle attributeStyles$ESignatureFillColorStyle = this.f27678c;
            if (attributeStyles$ESignatureFillColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ESignatureFillColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ESignatureBackgroundColorStyle attributeStyles$ESignatureBackgroundColorStyle = this.f27679d;
            if (attributeStyles$ESignatureBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ESignatureBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27680e;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontFamilyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27681f;
            if (attributeStyles$ComplexTextBasedFontSizeStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontSizeStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27682g;
            if (attributeStyles$ComplexTextBasedFontWeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontWeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27683h;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLetterSpacingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27684j;
            if (attributeStyles$ComplexTextBasedLineHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLineHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = this.f27685k;
            if (attributeStyles$DateSelectTextColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectTextColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = this.f27686l;
            if (attributeStyles$DateSelectBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = this.f27687m;
            if (attributeStyles$DateSelectBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = this.f27688n;
            if (attributeStyles$DateSelectBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27689p;
            if (attributeStyles$InputMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f27690q;
            if (attributeStyles$TextBasedJustifyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$TextBasedJustifyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = this.f27691t;
            if (attributeStyles$DateSelectStrokeColorStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$DateSelectStrokeColorStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class Footer extends UiComponent implements b {
        public static final Parcelable.Creator<Footer> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27692f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27693c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27694d;

        /* renamed from: e  reason: collision with root package name */
        private final FooterComponentStyle f27695e;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<Footer> {
            /* renamed from: a */
            public final Footer createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                FooterComponentStyle footerComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    footerComponentStyle = FooterComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new Footer(readString, createFromParcel, footerComponentStyle);
            }

            /* renamed from: b */
            public final Footer[] newArray(int i10) {
                return new Footer[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Footer(String str, Attributes attributes, FooterComponentStyle footerComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : footerComponentStyle);
        }

        public String A() {
            return this.f27693c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27694d;
        }

        public final String D() {
            AttributeStyles$FooterColorStyle a10;
            StyleElements.SimpleElementColor a11;
            StyleElements.SimpleElementColorValue a12;
            FooterComponentStyle footerComponentStyle = this.f27695e;
            if (footerComponentStyle == null || (a10 = footerComponentStyle.a()) == null || (a11 = a10.a()) == null || (a12 = a11.a()) == null) {
                return null;
            }
            return a12.a();
        }

        public final StyleElements.DPSizeSet E() {
            AttributeStyles$FooterBorderWidthStyle c10;
            StyleElements.DPMeasurementSet a10;
            FooterComponentStyle footerComponentStyle = this.f27695e;
            if (footerComponentStyle == null || (c10 = footerComponentStyle.c()) == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final StyleElements.DPSizeSet F() {
            AttributeStyles$FooterPaddingStyle d10;
            StyleElements.DPMeasurementSet a10;
            FooterComponentStyle footerComponentStyle = this.f27695e;
            if (footerComponentStyle == null || (d10 = footerComponentStyle.d()) == null || (a10 = d10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final FooterComponentStyle G() {
            return this.f27695e;
        }

        public int describeContents() {
            return 0;
        }

        public List<UiComponent> getChildren() {
            Attributes B = z();
            if (B != null) {
                return B.a();
            }
            return null;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27693c);
            Attributes attributes = this.f27694d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            FooterComponentStyle footerComponentStyle = this.f27695e;
            if (footerComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            footerComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Footer(String str, Attributes attributes, FooterComponentStyle footerComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27693c = str;
            this.f27694d = attributes;
            this.f27695e = footerComponentStyle;
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final List<UiComponent> f27696a;

            /* renamed from: b  reason: collision with root package name */
            private final Integer f27697b;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(parcel.readParcelable(Attributes.class.getClassLoader()));
                    }
                    return new Attributes(arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes() {
                this((List) null, (Integer) null, 3, (DefaultConstructorMarker) null);
            }

            public Attributes(List<? extends UiComponent> list, Integer num) {
                j.g(list, "children");
                this.f27696a = list;
                this.f27697b = num;
            }

            public final List<UiComponent> a() {
                return this.f27696a;
            }

            public final Integer c() {
                return this.f27697b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                int i11;
                j.g(parcel, "out");
                List<UiComponent> list = this.f27696a;
                parcel.writeInt(list.size());
                for (UiComponent writeParcelable : list) {
                    parcel.writeParcelable(writeParcelable, i10);
                }
                Integer num = this.f27697b;
                if (num == null) {
                    i11 = 0;
                } else {
                    parcel.writeInt(1);
                    i11 = num.intValue();
                }
                parcel.writeInt(i11);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Attributes(List list, Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this((i10 & 1) != 0 ? q.j() : list, (i10 & 2) != 0 ? null : num);
            }
        }
    }

    @i(generateAdapter = true)
    public static final class FooterComponentStyle implements Parcelable {
        public static final Parcelable.Creator<FooterComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$FooterColorStyle f27698a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$FooterPaddingStyle f27699b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$FooterBorderWidthStyle f27700c;

        public static final class a implements Parcelable.Creator<FooterComponentStyle> {
            /* renamed from: a */
            public final FooterComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$FooterBorderWidthStyle attributeStyles$FooterBorderWidthStyle = null;
                AttributeStyles$FooterColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$FooterColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$FooterPaddingStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$FooterPaddingStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$FooterBorderWidthStyle = AttributeStyles$FooterBorderWidthStyle.CREATOR.createFromParcel(parcel);
                }
                return new FooterComponentStyle(createFromParcel, createFromParcel2, attributeStyles$FooterBorderWidthStyle);
            }

            /* renamed from: b */
            public final FooterComponentStyle[] newArray(int i10) {
                return new FooterComponentStyle[i10];
            }
        }

        public FooterComponentStyle(AttributeStyles$FooterColorStyle attributeStyles$FooterColorStyle, AttributeStyles$FooterPaddingStyle attributeStyles$FooterPaddingStyle, AttributeStyles$FooterBorderWidthStyle attributeStyles$FooterBorderWidthStyle) {
            this.f27698a = attributeStyles$FooterColorStyle;
            this.f27699b = attributeStyles$FooterPaddingStyle;
            this.f27700c = attributeStyles$FooterBorderWidthStyle;
        }

        public final AttributeStyles$FooterColorStyle a() {
            return this.f27698a;
        }

        public final AttributeStyles$FooterBorderWidthStyle c() {
            return this.f27700c;
        }

        public final AttributeStyles$FooterPaddingStyle d() {
            return this.f27699b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$FooterColorStyle attributeStyles$FooterColorStyle = this.f27698a;
            if (attributeStyles$FooterColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$FooterColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$FooterPaddingStyle attributeStyles$FooterPaddingStyle = this.f27699b;
            if (attributeStyles$FooterPaddingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$FooterPaddingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$FooterBorderWidthStyle attributeStyles$FooterBorderWidthStyle = this.f27700c;
            if (attributeStyles$FooterBorderWidthStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$FooterBorderWidthStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class HorizontalStack extends UiComponent implements b {
        public static final Parcelable.Creator<HorizontalStack> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27701f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27702c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27703d;

        /* renamed from: e  reason: collision with root package name */
        private final HorizontalStackComponentStyle f27704e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final List<UiComponent> f27705a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    ArrayList arrayList;
                    j.g(parcel, "parcel");
                    if (parcel.readInt() == 0) {
                        arrayList = null;
                    } else {
                        int readInt = parcel.readInt();
                        ArrayList arrayList2 = new ArrayList(readInt);
                        for (int i10 = 0; i10 != readInt; i10++) {
                            arrayList2.add(parcel.readParcelable(Attributes.class.getClassLoader()));
                        }
                        arrayList = arrayList2;
                    }
                    return new Attributes(arrayList);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(List<? extends UiComponent> list) {
                this.f27705a = list;
            }

            public final Attributes a(List<? extends UiComponent> list) {
                return new Attributes(list);
            }

            public final List<UiComponent> c() {
                return this.f27705a;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Attributes) && j.b(this.f27705a, ((Attributes) obj).f27705a);
            }

            public int hashCode() {
                List<UiComponent> list = this.f27705a;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }

            public String toString() {
                return "Attributes(children=" + this.f27705a + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                List<UiComponent> list = this.f27705a;
                if (list == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeInt(list.size());
                for (UiComponent writeParcelable : list) {
                    parcel.writeParcelable(writeParcelable, i10);
                }
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<HorizontalStack> {
            /* renamed from: a */
            public final HorizontalStack createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                HorizontalStackComponentStyle horizontalStackComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    horizontalStackComponentStyle = HorizontalStackComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new HorizontalStack(readString, createFromParcel, horizontalStackComponentStyle);
            }

            /* renamed from: b */
            public final HorizontalStack[] newArray(int i10) {
                return new HorizontalStack[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HorizontalStack(String str, Attributes attributes, HorizontalStackComponentStyle horizontalStackComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : horizontalStackComponentStyle);
        }

        public static /* synthetic */ HorizontalStack D(HorizontalStack horizontalStack, String str, Attributes attributes, HorizontalStackComponentStyle horizontalStackComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = horizontalStack.A();
            }
            if ((i10 & 2) != 0) {
                attributes = horizontalStack.z();
            }
            if ((i10 & 4) != 0) {
                horizontalStackComponentStyle = horizontalStack.f27704e;
            }
            return horizontalStack.B(str, attributes, horizontalStackComponentStyle);
        }

        public String A() {
            return this.f27702c;
        }

        public final HorizontalStack B(String str, Attributes attributes, HorizontalStackComponentStyle horizontalStackComponentStyle) {
            j.g(str, "name");
            return new HorizontalStack(str, attributes, horizontalStackComponentStyle);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27703d;
        }

        public final HorizontalStackComponentStyle F() {
            return this.f27704e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HorizontalStack)) {
                return false;
            }
            HorizontalStack horizontalStack = (HorizontalStack) obj;
            return j.b(A(), horizontalStack.A()) && j.b(z(), horizontalStack.z()) && j.b(this.f27704e, horizontalStack.f27704e);
        }

        public List<UiComponent> getChildren() {
            Attributes E = z();
            if (E != null) {
                return E.c();
            }
            return null;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            HorizontalStackComponentStyle horizontalStackComponentStyle = this.f27704e;
            if (horizontalStackComponentStyle != null) {
                i10 = horizontalStackComponentStyle.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "HorizontalStack(name=" + A() + ", attributes=" + z() + ", styles=" + this.f27704e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27702c);
            Attributes attributes = this.f27703d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            HorizontalStackComponentStyle horizontalStackComponentStyle = this.f27704e;
            if (horizontalStackComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            horizontalStackComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HorizontalStack(String str, Attributes attributes, HorizontalStackComponentStyle horizontalStackComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27702c = str;
            this.f27703d = attributes;
            this.f27704e = horizontalStackComponentStyle;
        }
    }

    @i(generateAdapter = true)
    public static final class HorizontalStackComponentStyle implements Parcelable {
        public static final Parcelable.Creator<HorizontalStackComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackBackgroundColorStyle f27706a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackBorderWidthStyle f27707b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackBorderColorStyle f27708c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackBorderRadiusStyle f27709d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackPaddingStyle f27710e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackMarginStyle f27711f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackAxisStyle f27712g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackChildSizesStyle f27713h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackAlignmentStyle f27714j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$HorizontalStackGapStyle f27715k;

        public static final class a implements Parcelable.Creator<HorizontalStackComponentStyle> {
            /* renamed from: a */
            public final HorizontalStackComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$HorizontalStackGapStyle attributeStyles$HorizontalStackGapStyle = null;
                AttributeStyles$HorizontalStackBackgroundColorStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackBackgroundColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackBorderWidthStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackBorderWidthStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackBorderColorStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackBorderColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackBorderRadiusStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackBorderRadiusStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackPaddingStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackPaddingStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackMarginStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackMarginStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackAxisStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackAxisStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackChildSizesStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackChildSizesStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$HorizontalStackAlignmentStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$HorizontalStackAlignmentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$HorizontalStackGapStyle = AttributeStyles$HorizontalStackGapStyle.CREATOR.createFromParcel(parcel);
                }
                return new HorizontalStackComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, attributeStyles$HorizontalStackGapStyle);
            }

            /* renamed from: b */
            public final HorizontalStackComponentStyle[] newArray(int i10) {
                return new HorizontalStackComponentStyle[i10];
            }
        }

        public HorizontalStackComponentStyle(AttributeStyles$HorizontalStackBackgroundColorStyle attributeStyles$HorizontalStackBackgroundColorStyle, AttributeStyles$HorizontalStackBorderWidthStyle attributeStyles$HorizontalStackBorderWidthStyle, AttributeStyles$HorizontalStackBorderColorStyle attributeStyles$HorizontalStackBorderColorStyle, AttributeStyles$HorizontalStackBorderRadiusStyle attributeStyles$HorizontalStackBorderRadiusStyle, AttributeStyles$HorizontalStackPaddingStyle attributeStyles$HorizontalStackPaddingStyle, AttributeStyles$HorizontalStackMarginStyle attributeStyles$HorizontalStackMarginStyle, AttributeStyles$HorizontalStackAxisStyle attributeStyles$HorizontalStackAxisStyle, AttributeStyles$HorizontalStackChildSizesStyle attributeStyles$HorizontalStackChildSizesStyle, AttributeStyles$HorizontalStackAlignmentStyle attributeStyles$HorizontalStackAlignmentStyle, AttributeStyles$HorizontalStackGapStyle attributeStyles$HorizontalStackGapStyle) {
            this.f27706a = attributeStyles$HorizontalStackBackgroundColorStyle;
            this.f27707b = attributeStyles$HorizontalStackBorderWidthStyle;
            this.f27708c = attributeStyles$HorizontalStackBorderColorStyle;
            this.f27709d = attributeStyles$HorizontalStackBorderRadiusStyle;
            this.f27710e = attributeStyles$HorizontalStackPaddingStyle;
            this.f27711f = attributeStyles$HorizontalStackMarginStyle;
            this.f27712g = attributeStyles$HorizontalStackAxisStyle;
            this.f27713h = attributeStyles$HorizontalStackChildSizesStyle;
            this.f27714j = attributeStyles$HorizontalStackAlignmentStyle;
            this.f27715k = attributeStyles$HorizontalStackGapStyle;
        }

        public final AttributeStyles$HorizontalStackAlignmentStyle a() {
            return this.f27714j;
        }

        public final StyleElements.PositionType c() {
            StyleElements.Position a10;
            AttributeStyles$HorizontalStackAlignmentStyle attributeStyles$HorizontalStackAlignmentStyle = this.f27714j;
            if (attributeStyles$HorizontalStackAlignmentStyle == null || (a10 = attributeStyles$HorizontalStackAlignmentStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackAxisStyle d() {
            return this.f27712g;
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.a()).a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Axis e() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$HorizontalStackAxisStyle r0 = r1.f27712g
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$AxisContainer r0 = r0.a()
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis r0 = r0.a()
                if (r0 != 0) goto L_0x0012
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Axis.HORIZONTAL
            L_0x0012:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.HorizontalStackComponentStyle.e():com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Axis");
        }

        public final AttributeStyles$HorizontalStackBackgroundColorStyle f() {
            return this.f27706a;
        }

        public final String g() {
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            AttributeStyles$HorizontalStackBackgroundColorStyle attributeStyles$HorizontalStackBackgroundColorStyle = this.f27706a;
            if (attributeStyles$HorizontalStackBackgroundColorStyle == null || (a10 = attributeStyles$HorizontalStackBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final String h() {
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            AttributeStyles$HorizontalStackBorderColorStyle attributeStyles$HorizontalStackBorderColorStyle = this.f27708c;
            if (attributeStyles$HorizontalStackBorderColorStyle == null || (a10 = attributeStyles$HorizontalStackBorderColorStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final AttributeStyles$HorizontalStackBorderColorStyle i() {
            return this.f27708c;
        }

        public final AttributeStyles$HorizontalStackBorderRadiusStyle j() {
            return this.f27709d;
        }

        public final StyleElements.DPSize k() {
            StyleElements.DPMeasurement a10;
            AttributeStyles$HorizontalStackBorderRadiusStyle attributeStyles$HorizontalStackBorderRadiusStyle = this.f27709d;
            if (attributeStyles$HorizontalStackBorderRadiusStyle == null || (a10 = attributeStyles$HorizontalStackBorderRadiusStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackBorderWidthStyle l() {
            return this.f27707b;
        }

        public final StyleElements.DPSizeSet m() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$HorizontalStackBorderWidthStyle attributeStyles$HorizontalStackBorderWidthStyle = this.f27707b;
            if (attributeStyles$HorizontalStackBorderWidthStyle == null || (a10 = attributeStyles$HorizontalStackBorderWidthStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackChildSizesStyle n() {
            return this.f27713h;
        }

        public final int[] o() {
            StyleElements.ChildSizes a10;
            AttributeStyles$HorizontalStackChildSizesStyle attributeStyles$HorizontalStackChildSizesStyle = this.f27713h;
            if (attributeStyles$HorizontalStackChildSizesStyle == null || (a10 = attributeStyles$HorizontalStackChildSizesStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackGapStyle p() {
            return this.f27715k;
        }

        public final StyleElements.DPSize q() {
            StyleElements.DPMeasurement a10;
            AttributeStyles$HorizontalStackGapStyle attributeStyles$HorizontalStackGapStyle = this.f27715k;
            if (attributeStyles$HorizontalStackGapStyle == null || (a10 = attributeStyles$HorizontalStackGapStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackMarginStyle r() {
            return this.f27711f;
        }

        public final StyleElements.DPSizeSet s() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$HorizontalStackMarginStyle attributeStyles$HorizontalStackMarginStyle = this.f27711f;
            if (attributeStyles$HorizontalStackMarginStyle == null || (a10 = attributeStyles$HorizontalStackMarginStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$HorizontalStackPaddingStyle t() {
            return this.f27710e;
        }

        public final StyleElements.DPSizeSet u() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$HorizontalStackPaddingStyle attributeStyles$HorizontalStackPaddingStyle = this.f27710e;
            if (attributeStyles$HorizontalStackPaddingStyle == null || (a10 = attributeStyles$HorizontalStackPaddingStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$HorizontalStackBackgroundColorStyle attributeStyles$HorizontalStackBackgroundColorStyle = this.f27706a;
            if (attributeStyles$HorizontalStackBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackBorderWidthStyle attributeStyles$HorizontalStackBorderWidthStyle = this.f27707b;
            if (attributeStyles$HorizontalStackBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackBorderColorStyle attributeStyles$HorizontalStackBorderColorStyle = this.f27708c;
            if (attributeStyles$HorizontalStackBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackBorderRadiusStyle attributeStyles$HorizontalStackBorderRadiusStyle = this.f27709d;
            if (attributeStyles$HorizontalStackBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackPaddingStyle attributeStyles$HorizontalStackPaddingStyle = this.f27710e;
            if (attributeStyles$HorizontalStackPaddingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackPaddingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackMarginStyle attributeStyles$HorizontalStackMarginStyle = this.f27711f;
            if (attributeStyles$HorizontalStackMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackAxisStyle attributeStyles$HorizontalStackAxisStyle = this.f27712g;
            if (attributeStyles$HorizontalStackAxisStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackAxisStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackChildSizesStyle attributeStyles$HorizontalStackChildSizesStyle = this.f27713h;
            if (attributeStyles$HorizontalStackChildSizesStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackChildSizesStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackAlignmentStyle attributeStyles$HorizontalStackAlignmentStyle = this.f27714j;
            if (attributeStyles$HorizontalStackAlignmentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$HorizontalStackAlignmentStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$HorizontalStackGapStyle attributeStyles$HorizontalStackGapStyle = this.f27715k;
            if (attributeStyles$HorizontalStackGapStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$HorizontalStackGapStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputAddress extends UiComponent implements com.withpersona.sdk2.inquiry.steps.ui.components.a {
        public static final Parcelable.Creator<InputAddress> CREATOR = new b();

        /* renamed from: l  reason: collision with root package name */
        public static final a f27716l = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27717c;

        /* renamed from: d  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27718d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27719e;

        /* renamed from: f  reason: collision with root package name */
        private k f27720f;

        /* renamed from: g  reason: collision with root package name */
        private k f27721g;

        /* renamed from: h  reason: collision with root package name */
        private k f27722h;

        /* renamed from: j  reason: collision with root package name */
        private k f27723j;

        /* renamed from: k  reason: collision with root package name */
        private k f27724k;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();
            private List<Suggestion> B;
            private String C;
            private Boolean D;
            private final JsonLogicBoolean E;
            private final JsonLogicBoolean F;
            private final List<cj.a> G = new ArrayList();

            /* renamed from: a  reason: collision with root package name */
            private final String f27725a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27726b;

            /* renamed from: c  reason: collision with root package name */
            private String f27727c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27728d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27729e;

            /* renamed from: f  reason: collision with root package name */
            private String f27730f;

            /* renamed from: g  reason: collision with root package name */
            private final String f27731g;

            /* renamed from: h  reason: collision with root package name */
            private final String f27732h;

            /* renamed from: j  reason: collision with root package name */
            private String f27733j;

            /* renamed from: k  reason: collision with root package name */
            private final String f27734k;

            /* renamed from: l  reason: collision with root package name */
            private final String f27735l;

            /* renamed from: m  reason: collision with root package name */
            private String f27736m;

            /* renamed from: n  reason: collision with root package name */
            private final String f27737n;

            /* renamed from: p  reason: collision with root package name */
            private final String f27738p;

            /* renamed from: q  reason: collision with root package name */
            private final String f27739q;

            /* renamed from: t  reason: collision with root package name */
            private String f27740t;

            /* renamed from: w  reason: collision with root package name */
            private final String f27741w;

            /* renamed from: x  reason: collision with root package name */
            private final String f27742x;

            /* renamed from: y  reason: collision with root package name */
            private final String f27743y;

            /* renamed from: z  reason: collision with root package name */
            private String f27744z;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    String str;
                    ArrayList arrayList;
                    Boolean bool;
                    Parcel parcel2 = parcel;
                    j.g(parcel2, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    String readString10 = parcel.readString();
                    String readString11 = parcel.readString();
                    String readString12 = parcel.readString();
                    String readString13 = parcel.readString();
                    String readString14 = parcel.readString();
                    String readString15 = parcel.readString();
                    String readString16 = parcel.readString();
                    String readString17 = parcel.readString();
                    String readString18 = parcel.readString();
                    String readString19 = parcel.readString();
                    String readString20 = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    if (parcel.readInt() == 0) {
                        str = readString13;
                        arrayList = null;
                    } else {
                        int readInt = parcel.readInt();
                        ArrayList arrayList2 = new ArrayList(readInt);
                        str = readString13;
                        int i10 = 0;
                        while (i10 != readInt) {
                            arrayList2.add(Suggestion.CREATOR.createFromParcel(parcel2));
                            i10++;
                            readInt = readInt;
                        }
                        arrayList = arrayList2;
                    }
                    String readString21 = parcel.readString();
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel2);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel2);
                    }
                    return new Attributes(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, readString10, readString11, readString12, str, readString14, readString15, readString16, readString17, readString18, readString19, readString20, arrayList, readString21, bool, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, List<Suggestion> list, String str21, Boolean bool, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27725a = str;
                this.f27726b = str2;
                this.f27727c = str3;
                this.f27728d = str4;
                this.f27729e = str5;
                this.f27730f = str6;
                this.f27731g = str7;
                this.f27732h = str8;
                this.f27733j = str9;
                this.f27734k = str10;
                this.f27735l = str11;
                this.f27736m = str12;
                this.f27737n = str13;
                this.f27738p = str14;
                this.f27739q = str15;
                this.f27740t = str16;
                this.f27741w = str17;
                this.f27742x = str18;
                this.f27743y = str19;
                this.f27744z = str20;
                this.B = list;
                this.C = str21;
                this.D = bool;
                this.E = jsonLogicBoolean;
                this.F = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, List list, String str21, Boolean bool, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                Attributes attributes2 = attributes;
                int i11 = i10;
                return attributes.e((i11 & 1) != 0 ? attributes2.f27725a : str, (i11 & 2) != 0 ? attributes2.f27726b : str2, (i11 & 4) != 0 ? attributes2.f27727c : str3, (i11 & 8) != 0 ? attributes2.f27728d : str4, (i11 & 16) != 0 ? attributes2.f27729e : str5, (i11 & 32) != 0 ? attributes2.f27730f : str6, (i11 & 64) != 0 ? attributes2.f27731g : str7, (i11 & 128) != 0 ? attributes2.f27732h : str8, (i11 & 256) != 0 ? attributes2.f27733j : str9, (i11 & 512) != 0 ? attributes2.f27734k : str10, (i11 & 1024) != 0 ? attributes2.f27735l : str11, (i11 & 2048) != 0 ? attributes2.f27736m : str12, (i11 & Opcodes.ACC_SYNTHETIC) != 0 ? attributes2.f27737n : str13, (i11 & 8192) != 0 ? attributes2.f27738p : str14, (i11 & Opcodes.ACC_ENUM) != 0 ? attributes2.f27739q : str15, (i11 & 32768) != 0 ? attributes2.f27740t : str16, (i11 & 65536) != 0 ? attributes2.f27741w : str17, (i11 & Opcodes.ACC_DEPRECATED) != 0 ? attributes2.f27742x : str18, (i11 & Opcodes.ASM4) != 0 ? attributes2.f27743y : str19, (i11 & Opcodes.ASM8) != 0 ? attributes2.f27744z : str20, (i11 & 1048576) != 0 ? attributes2.B : list, (i11 & 2097152) != 0 ? attributes2.C : str21, (i11 & 4194304) != 0 ? attributes2.D : bool, (i11 & 8388608) != 0 ? attributes.c() : jsonLogicBoolean, (i11 & 16777216) != 0 ? attributes.d() : jsonLogicBoolean2);
            }

            public final String A() {
                return this.f27744z;
            }

            public final List<Suggestion> B() {
                return this.B;
            }

            public final String D() {
                return this.f27743y;
            }

            public final String E() {
                return this.C;
            }

            public final Boolean F() {
                return this.D;
            }

            public List<cj.a> a() {
                return this.G;
            }

            public JsonLogicBoolean c() {
                return this.E;
            }

            public JsonLogicBoolean d() {
                return this.F;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, List<Suggestion> list, String str21, Boolean bool, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                return new Attributes(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, list, str21, bool, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27725a, attributes.f27725a) && j.b(this.f27726b, attributes.f27726b) && j.b(this.f27727c, attributes.f27727c) && j.b(this.f27728d, attributes.f27728d) && j.b(this.f27729e, attributes.f27729e) && j.b(this.f27730f, attributes.f27730f) && j.b(this.f27731g, attributes.f27731g) && j.b(this.f27732h, attributes.f27732h) && j.b(this.f27733j, attributes.f27733j) && j.b(this.f27734k, attributes.f27734k) && j.b(this.f27735l, attributes.f27735l) && j.b(this.f27736m, attributes.f27736m) && j.b(this.f27737n, attributes.f27737n) && j.b(this.f27738p, attributes.f27738p) && j.b(this.f27739q, attributes.f27739q) && j.b(this.f27740t, attributes.f27740t) && j.b(this.f27741w, attributes.f27741w) && j.b(this.f27742x, attributes.f27742x) && j.b(this.f27743y, attributes.f27743y) && j.b(this.f27744z, attributes.f27744z) && j.b(this.B, attributes.B) && j.b(this.C, attributes.C) && j.b(this.D, attributes.D) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27732h;
            }

            public final String h() {
                return this.f27739q;
            }

            public int hashCode() {
                String str = this.f27725a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27726b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27727c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27728d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.f27729e;
                int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.f27730f;
                int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.f27731g;
                int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.f27732h;
                int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
                String str9 = this.f27733j;
                int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
                String str10 = this.f27734k;
                int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
                String str11 = this.f27735l;
                int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
                String str12 = this.f27736m;
                int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
                String str13 = this.f27737n;
                int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
                String str14 = this.f27738p;
                int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
                String str15 = this.f27739q;
                int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
                String str16 = this.f27740t;
                int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
                String str17 = this.f27741w;
                int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
                String str18 = this.f27742x;
                int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
                String str19 = this.f27743y;
                int hashCode19 = (hashCode18 + (str19 == null ? 0 : str19.hashCode())) * 31;
                String str20 = this.f27744z;
                int hashCode20 = (hashCode19 + (str20 == null ? 0 : str20.hashCode())) * 31;
                List<Suggestion> list = this.B;
                int hashCode21 = (hashCode20 + (list == null ? 0 : list.hashCode())) * 31;
                String str21 = this.C;
                int hashCode22 = (hashCode21 + (str21 == null ? 0 : str21.hashCode())) * 31;
                Boolean bool = this.D;
                int hashCode23 = (((hashCode22 + (bool == null ? 0 : bool.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode23 + i10;
            }

            public final String i() {
                return this.f27726b;
            }

            public final String j() {
                return this.f27729e;
            }

            public final String k() {
                return this.f27735l;
            }

            public final String l() {
                return this.f27725a;
            }

            public final String m() {
                return this.f27734k;
            }

            public final String n() {
                return this.f27741w;
            }

            public final String o() {
                return this.f27742x;
            }

            public final String p() {
                return this.f27728d;
            }

            public final String q() {
                return this.f27731g;
            }

            public final String r() {
                return this.f27737n;
            }

            public final String s() {
                return this.f27738p;
            }

            public final String t() {
                return this.f27733j;
            }

            public String toString() {
                return "Attributes(label=" + this.f27725a + ", fieldKeyAddressStreet1=" + this.f27726b + ", prefillAddressStreet1=" + this.f27727c + ", placeholderAddressStreet1=" + this.f27728d + ", fieldKeyAddressStreet2=" + this.f27729e + ", prefillAddressStreet2=" + this.f27730f + ", placeholderAddressStreet2=" + this.f27731g + ", fieldKeyAddressCity=" + this.f27732h + ", prefillAddressCity=" + this.f27733j + ", placeholderAddressCity=" + this.f27734k + ", fieldKeyAddressSubdivision=" + this.f27735l + ", prefillAddressSubdivision=" + this.f27736m + ", placeholderAddressSubdivision=" + this.f27737n + ", placeholderAddressSubdivisionUs=" + this.f27738p + ", fieldKeyAddressPostalCode=" + this.f27739q + ", prefillAddressPostalCode=" + this.f27740t + ", placeholderAddressPostalCode=" + this.f27741w + ", placeholderAddressPostalCodeUs=" + this.f27742x + ", selectedCountryCode=" + this.f27743y + ", searchQuery=" + this.f27744z + ", searchResults=" + this.B + ", selectedSearchResultId=" + this.C + ", isAddressAutocompleteLoading=" + this.D + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public final String u() {
                return this.f27740t;
            }

            public final String w() {
                return this.f27727c;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27725a);
                parcel.writeString(this.f27726b);
                parcel.writeString(this.f27727c);
                parcel.writeString(this.f27728d);
                parcel.writeString(this.f27729e);
                parcel.writeString(this.f27730f);
                parcel.writeString(this.f27731g);
                parcel.writeString(this.f27732h);
                parcel.writeString(this.f27733j);
                parcel.writeString(this.f27734k);
                parcel.writeString(this.f27735l);
                parcel.writeString(this.f27736m);
                parcel.writeString(this.f27737n);
                parcel.writeString(this.f27738p);
                parcel.writeString(this.f27739q);
                parcel.writeString(this.f27740t);
                parcel.writeString(this.f27741w);
                parcel.writeString(this.f27742x);
                parcel.writeString(this.f27743y);
                parcel.writeString(this.f27744z);
                List<Suggestion> list = this.B;
                if (list == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(list.size());
                    for (Suggestion writeToParcel : list) {
                        writeToParcel.writeToParcel(parcel, i10);
                    }
                }
                parcel.writeString(this.C);
                Boolean bool = this.D;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                JsonLogicBoolean jsonLogicBoolean = this.E;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.F;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }

            public final String x() {
                return this.f27730f;
            }

            public final String z() {
                return this.f27736m;
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputAddress> {
            /* renamed from: a */
            public final InputAddress createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputTextBasedComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputAddress(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputAddress[] newArray(int i10) {
                return new InputAddress[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
            r2 = r2.w();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputAddress(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputAddress.Attributes r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27717c = r2
                r1.f27718d = r3
                r1.f27719e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes r2 = r1.z()
                java.lang.String r3 = ""
                if (r2 == 0) goto L_0x001d
                java.lang.String r2 = r2.w()
                if (r2 != 0) goto L_0x001e
            L_0x001d:
                r2 = r3
            L_0x001e:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27720f = r2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x0030
                java.lang.String r2 = r2.x()
                if (r2 != 0) goto L_0x0031
            L_0x0030:
                r2 = r3
            L_0x0031:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27721g = r2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x0043
                java.lang.String r2 = r2.t()
                if (r2 != 0) goto L_0x0044
            L_0x0043:
                r2 = r3
            L_0x0044:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27722h = r2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x0056
                java.lang.String r2 = r2.z()
                if (r2 != 0) goto L_0x0057
            L_0x0056:
                r2 = r3
            L_0x0057:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27723j = r2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x006b
                java.lang.String r2 = r2.u()
                if (r2 != 0) goto L_0x006a
                goto L_0x006b
            L_0x006a:
                r3 = r2
            L_0x006b:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r3)
                r1.f27724k = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputAddress.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputAddress$Attributes):void");
        }

        public static /* synthetic */ InputAddress D(InputAddress inputAddress, String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputAddress.A();
            }
            if ((i10 & 2) != 0) {
                inputTextBasedComponentStyle = inputAddress.f27718d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputAddress.z();
            }
            return inputAddress.B(str, inputTextBasedComponentStyle, attributes);
        }

        private final InputAddress E(InputAddress inputAddress) {
            K(inputAddress.n());
            L(inputAddress.r());
            H(inputAddress.d());
            M(inputAddress.f());
            I(inputAddress.e());
            return this;
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextControllerForAddressCity$annotations() {
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextControllerForAddressPostalCode$annotations() {
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextControllerForAddressStreet1$annotations() {
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextControllerForAddressStreet2$annotations() {
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextControllerForAddressSubdivision$annotations() {
        }

        public String A() {
            return this.f27717c;
        }

        public final InputAddress B(String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputAddress(str, inputTextBasedComponentStyle, attributes);
        }

        /* renamed from: F */
        public Attributes z() {
            return this.f27719e;
        }

        public final InputTextBasedComponentStyle G() {
            return this.f27718d;
        }

        public void H(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27722h = kVar;
        }

        public void I(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27724k = kVar;
        }

        public void K(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27720f = kVar;
        }

        public void L(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27721g = kVar;
        }

        public void M(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27723j = kVar;
        }

        public InputAddress O(Boolean bool) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, bool, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 29360127, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public InputAddress P(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33030143, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public InputAddress Q(List<Suggestion> list) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, list, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 32505855, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public InputAddress R(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, str, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 31457279, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public k d() {
            return this.f27722h;
        }

        public int describeContents() {
            return 0;
        }

        public k e() {
            return this.f27724k;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputAddress)) {
                return false;
            }
            InputAddress inputAddress = (InputAddress) obj;
            return j.b(A(), inputAddress.A()) && j.b(this.f27718d, inputAddress.f27718d) && j.b(z(), inputAddress.z());
        }

        public k f() {
            return this.f27723j;
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27718d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputTextBasedComponentStyle == null ? 0 : inputTextBasedComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public InputAddress i(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33554399, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public InputAddress m(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33554175, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public k n() {
            return this.f27720f;
        }

        public k r() {
            return this.f27721g;
        }

        public InputAddress s(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33521663, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public String toString() {
            return "InputAddress(name=" + A() + ", styles=" + this.f27718d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public InputAddress u(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33554427, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27717c);
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27718d;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputTextBasedComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27719e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }

        public InputAddress x(String str) {
            Attributes attributes;
            Attributes F = z();
            if (F != null) {
                attributes = Attributes.f(F, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (Boolean) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 33552383, (Object) null);
            } else {
                attributes = null;
            }
            return D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null).E(this);
        }
    }

    @i(generateAdapter = true)
    public static final class InputCheckbox extends UiComponent implements com.withpersona.sdk2.inquiry.steps.ui.components.k<InputCheckbox> {
        public static final Parcelable.Creator<InputCheckbox> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27745g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27746c;

        /* renamed from: d  reason: collision with root package name */
        private final InputCheckboxComponentStyle f27747d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27748e;

        /* renamed from: f  reason: collision with root package name */
        private c f27749f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27750a;

            /* renamed from: b  reason: collision with root package name */
            private final Boolean f27751b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27752c;

            /* renamed from: d  reason: collision with root package name */
            private final JsonLogicBoolean f27753d;

            /* renamed from: e  reason: collision with root package name */
            private final JsonLogicBoolean f27754e;

            /* renamed from: f  reason: collision with root package name */
            private final List<cj.a> f27755f = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    Boolean bool;
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    String readString2 = parcel.readString();
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, bool, readString2, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, Boolean bool, String str2, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27750a = str;
                this.f27751b = bool;
                this.f27752c = str2;
                this.f27753d = jsonLogicBoolean;
                this.f27754e = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, Boolean bool, String str2, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27750a;
                }
                if ((i10 & 2) != 0) {
                    bool = attributes.f27751b;
                }
                Boolean bool2 = bool;
                if ((i10 & 4) != 0) {
                    str2 = attributes.f27752c;
                }
                String str3 = str2;
                if ((i10 & 8) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                JsonLogicBoolean jsonLogicBoolean3 = jsonLogicBoolean;
                if ((i10 & 16) != 0) {
                    jsonLogicBoolean2 = attributes.d();
                }
                return attributes.e(str, bool2, str3, jsonLogicBoolean3, jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27755f;
            }

            public JsonLogicBoolean c() {
                return this.f27753d;
            }

            public JsonLogicBoolean d() {
                return this.f27754e;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, Boolean bool, String str2, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                return new Attributes(str, bool, str2, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27750a, attributes.f27750a) && j.b(this.f27751b, attributes.f27751b) && j.b(this.f27752c, attributes.f27752c) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27750a;
            }

            public final String h() {
                return this.f27752c;
            }

            public int hashCode() {
                String str = this.f27750a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Boolean bool = this.f27751b;
                int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                String str2 = this.f27752c;
                int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode3 + i10;
            }

            public final Boolean i() {
                return this.f27751b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27750a + ", prefill=" + this.f27751b + ", label=" + this.f27752c + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27750a);
                Boolean bool = this.f27751b;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                parcel.writeString(this.f27752c);
                JsonLogicBoolean jsonLogicBoolean = this.f27753d;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27754e;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class InputCheckboxComponentStyle implements Parcelable {
            public static final Parcelable.Creator<InputCheckboxComponentStyle> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final AttributeStyles$TextBasedFontFamilyStyle f27756a;

            /* renamed from: b  reason: collision with root package name */
            private final AttributeStyles$TextBasedFontSizeStyle f27757b;

            /* renamed from: c  reason: collision with root package name */
            private final AttributeStyles$TextBasedFontWeightStyle f27758c;

            /* renamed from: d  reason: collision with root package name */
            private final AttributeStyles$TextBasedLetterSpacingStyle f27759d;

            /* renamed from: e  reason: collision with root package name */
            private final AttributeStyles$TextBasedLineHeightStyle f27760e;

            /* renamed from: f  reason: collision with root package name */
            private final AttributeStyles$TextBasedTextColorStyle f27761f;

            /* renamed from: g  reason: collision with root package name */
            private final AttributeStyles$TextBasedTextColorStyle f27762g;

            public static final class a implements Parcelable.Creator<InputCheckboxComponentStyle> {
                /* renamed from: a */
                public final InputCheckboxComponentStyle createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
                    AttributeStyles$TextBasedFontFamilyStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontFamilyStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$TextBasedFontSizeStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontSizeStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$TextBasedFontWeightStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedFontWeightStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$TextBasedLetterSpacingStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$TextBasedLineHeightStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedLineHeightStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$TextBasedTextColorStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        attributeStyles$TextBasedTextColorStyle = AttributeStyles$TextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
                    }
                    return new InputCheckboxComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, attributeStyles$TextBasedTextColorStyle);
                }

                /* renamed from: b */
                public final InputCheckboxComponentStyle[] newArray(int i10) {
                    return new InputCheckboxComponentStyle[i10];
                }
            }

            public InputCheckboxComponentStyle(AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle, AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle, AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle, AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle, AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle, AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle, AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2) {
                this.f27756a = attributeStyles$TextBasedFontFamilyStyle;
                this.f27757b = attributeStyles$TextBasedFontSizeStyle;
                this.f27758c = attributeStyles$TextBasedFontWeightStyle;
                this.f27759d = attributeStyles$TextBasedLetterSpacingStyle;
                this.f27760e = attributeStyles$TextBasedLineHeightStyle;
                this.f27761f = attributeStyles$TextBasedTextColorStyle;
                this.f27762g = attributeStyles$TextBasedTextColorStyle2;
            }

            public final AttributeStyles$TextBasedFontFamilyStyle a() {
                return this.f27756a;
            }

            public final AttributeStyles$TextBasedFontSizeStyle c() {
                return this.f27757b;
            }

            public final AttributeStyles$TextBasedFontWeightStyle d() {
                return this.f27758c;
            }

            public int describeContents() {
                return 0;
            }

            public final AttributeStyles$TextBasedLetterSpacingStyle e() {
                return this.f27759d;
            }

            public final AttributeStyles$TextBasedLineHeightStyle f() {
                return this.f27760e;
            }

            public final TextBasedComponentStyle g() {
                return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, this.f27756a, this.f27757b, this.f27758c, this.f27759d, this.f27760e, this.f27761f, this.f27762g);
            }

            public final AttributeStyles$TextBasedTextColorStyle h() {
                return this.f27761f;
            }

            public final AttributeStyles$TextBasedTextColorStyle i() {
                return this.f27762g;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = this.f27756a;
                if (attributeStyles$TextBasedFontFamilyStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedFontFamilyStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = this.f27757b;
                if (attributeStyles$TextBasedFontSizeStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedFontSizeStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = this.f27758c;
                if (attributeStyles$TextBasedFontWeightStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedFontWeightStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = this.f27759d;
                if (attributeStyles$TextBasedLetterSpacingStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedLetterSpacingStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = this.f27760e;
                if (attributeStyles$TextBasedLineHeightStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedLineHeightStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = this.f27761f;
                if (attributeStyles$TextBasedTextColorStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedTextColorStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle2 = this.f27762g;
                if (attributeStyles$TextBasedTextColorStyle2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                attributeStyles$TextBasedTextColorStyle2.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputCheckbox> {
            /* renamed from: a */
            public final InputCheckbox createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputCheckboxComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputCheckboxComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputCheckbox(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputCheckbox[] newArray(int i10) {
                return new InputCheckbox[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputCheckbox(String str, InputCheckboxComponentStyle inputCheckboxComponentStyle, Attributes attributes) {
            super(str, (DefaultConstructorMarker) null);
            boolean z10;
            Boolean i10;
            j.g(str, "name");
            this.f27746c = str;
            this.f27747d = inputCheckboxComponentStyle;
            this.f27748e = attributes;
            Attributes E = z();
            if (E == null || (i10 = E.i()) == null) {
                z10 = false;
            } else {
                z10 = i10.booleanValue();
            }
            this.f27749f = new c(z10);
        }

        public static /* synthetic */ InputCheckbox D(InputCheckbox inputCheckbox, String str, InputCheckboxComponentStyle inputCheckboxComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputCheckbox.A();
            }
            if ((i10 & 2) != 0) {
                inputCheckboxComponentStyle = inputCheckbox.f27747d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputCheckbox.z();
            }
            return inputCheckbox.B(str, inputCheckboxComponentStyle, attributes);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTwoStateViewController$annotations() {
        }

        public String A() {
            return this.f27746c;
        }

        public final InputCheckbox B(String str, InputCheckboxComponentStyle inputCheckboxComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputCheckbox(str, inputCheckboxComponentStyle, attributes);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27748e;
        }

        public final InputCheckboxComponentStyle F() {
            return this.f27747d;
        }

        public void G(c cVar) {
            j.g(cVar, "<set-?>");
            this.f27749f = cVar;
        }

        /* renamed from: H */
        public InputCheckbox g(boolean z10) {
            Attributes attributes;
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, Boolean.valueOf(z10), (String) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 29, (Object) null);
            } else {
                attributes = null;
            }
            InputCheckbox D = D(this, (String) null, (InputCheckboxComponentStyle) null, attributes, 3, (Object) null);
            D.G(j());
            return D;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputCheckbox)) {
                return false;
            }
            InputCheckbox inputCheckbox = (InputCheckbox) obj;
            return j.b(A(), inputCheckbox.A()) && j.b(this.f27747d, inputCheckbox.f27747d) && j.b(z(), inputCheckbox.z());
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputCheckboxComponentStyle inputCheckboxComponentStyle = this.f27747d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputCheckboxComponentStyle == null ? 0 : inputCheckboxComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public c j() {
            return this.f27749f;
        }

        public String toString() {
            return "InputCheckbox(name=" + A() + ", styles=" + this.f27747d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27746c);
            InputCheckboxComponentStyle inputCheckboxComponentStyle = this.f27747d;
            if (inputCheckboxComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputCheckboxComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27748e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputConfirmationCode extends UiComponent implements m<InputConfirmationCode> {
        public static final Parcelable.Creator<InputConfirmationCode> CREATOR = new b();

        /* renamed from: h  reason: collision with root package name */
        public static final a f27763h = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27764c;

        /* renamed from: d  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27765d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27766e;

        /* renamed from: f  reason: collision with root package name */
        private k f27767f;

        /* renamed from: g  reason: collision with root package name */
        private final SubmitConfirmationCodeHelper f27768g;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27769a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27770b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27771c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27772d;

            /* renamed from: e  reason: collision with root package name */
            private final JsonLogicBoolean f27773e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27774f;

            /* renamed from: g  reason: collision with root package name */
            private final List<cj.a> f27775g = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, readString4, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27769a = str;
                this.f27770b = str2;
                this.f27771c = str3;
                this.f27772d = str4;
                this.f27773e = jsonLogicBoolean;
                this.f27774f = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27769a;
                }
                if ((i10 & 2) != 0) {
                    str2 = attributes.f27770b;
                }
                String str5 = str2;
                if ((i10 & 4) != 0) {
                    str3 = attributes.f27771c;
                }
                String str6 = str3;
                if ((i10 & 8) != 0) {
                    str4 = attributes.f27772d;
                }
                String str7 = str4;
                if ((i10 & 16) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                JsonLogicBoolean jsonLogicBoolean3 = jsonLogicBoolean;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean2 = attributes.d();
                }
                return attributes.e(str, str5, str6, str7, jsonLogicBoolean3, jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27775g;
            }

            public JsonLogicBoolean c() {
                return this.f27773e;
            }

            public JsonLogicBoolean d() {
                return this.f27774f;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                return new Attributes(str, str2, str3, str4, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27769a, attributes.f27769a) && j.b(this.f27770b, attributes.f27770b) && j.b(this.f27771c, attributes.f27771c) && j.b(this.f27772d, attributes.f27772d) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27769a;
            }

            public final String h() {
                return this.f27771c;
            }

            public int hashCode() {
                String str = this.f27769a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27770b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27771c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27772d;
                int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27772d;
            }

            public final String j() {
                return this.f27770b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27769a + ", prefill=" + this.f27770b + ", label=" + this.f27771c + ", placeholder=" + this.f27772d + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27769a);
                parcel.writeString(this.f27770b);
                parcel.writeString(this.f27771c);
                parcel.writeString(this.f27772d);
                JsonLogicBoolean jsonLogicBoolean = this.f27773e;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27774f;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputConfirmationCode> {
            /* renamed from: a */
            public final InputConfirmationCode createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputTextBasedComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputConfirmationCode(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputConfirmationCode[] newArray(int i10) {
                return new InputConfirmationCode[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r2 = r2.j();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputConfirmationCode(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputConfirmationCode.Attributes r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27764c = r2
                r1.f27765d = r3
                r1.f27766e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputConfirmationCode$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x001b
                java.lang.String r2 = r2.j()
                if (r2 != 0) goto L_0x001d
            L_0x001b:
                java.lang.String r2 = ""
            L_0x001d:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27767f = r2
                com.withpersona.sdk2.inquiry.steps.ui.components.utils.inputConfirmation.SubmitConfirmationCodeHelper r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.utils.inputConfirmation.SubmitConfirmationCodeHelper
                r2.<init>()
                r1.f27768g = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputConfirmationCode.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputConfirmationCode$Attributes):void");
        }

        public static /* synthetic */ InputConfirmationCode D(InputConfirmationCode inputConfirmationCode, String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputConfirmationCode.A();
            }
            if ((i10 & 2) != 0) {
                inputTextBasedComponentStyle = inputConfirmationCode.f27765d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputConfirmationCode.z();
            }
            return inputConfirmationCode.B(str, inputTextBasedComponentStyle, attributes);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27764c;
        }

        public final InputConfirmationCode B(String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputConfirmationCode(str, inputTextBasedComponentStyle, attributes);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27766e;
        }

        public final InputTextBasedComponentStyle F() {
            return this.f27765d;
        }

        public final SubmitConfirmationCodeHelper G() {
            return this.f27768g;
        }

        public void H(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27767f = kVar;
        }

        /* renamed from: I */
        public InputConfirmationCode k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, str, (String) null, (String) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 61, (Object) null);
            } else {
                attributes = null;
            }
            InputConfirmationCode D = D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null);
            D.H(a());
            return D;
        }

        public k a() {
            return this.f27767f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputConfirmationCode)) {
                return false;
            }
            InputConfirmationCode inputConfirmationCode = (InputConfirmationCode) obj;
            return j.b(A(), inputConfirmationCode.A()) && j.b(this.f27765d, inputConfirmationCode.f27765d) && j.b(z(), inputConfirmationCode.z());
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27765d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputTextBasedComponentStyle == null ? 0 : inputTextBasedComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "InputConfirmationCode(name=" + A() + ", styles=" + this.f27765d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27764c);
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27765d;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputTextBasedComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27766e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputDateComponentStyle implements Parcelable {
        public static final Parcelable.Creator<InputDateComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontFamilyStyle f27790a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontSizeStyle f27791b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontWeightStyle f27792c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLetterSpacingStyle f27793d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLineHeightStyle f27794e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$DateSelectTextColorStyle f27795f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderRadiusStyle f27796g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderWidthStyle f27797h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$DateSelectBackgroundColorStyle f27798j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$DateSelectBorderColorStyle f27799k;

        /* renamed from: l  reason: collision with root package name */
        private final AttributeStyles$InputMarginStyle f27800l;

        /* renamed from: m  reason: collision with root package name */
        private final AttributeStyles$TextBasedJustifyStyle f27801m;

        /* renamed from: n  reason: collision with root package name */
        private final AttributeStyles$DateSelectStrokeColorStyle f27802n;

        public static final class a implements Parcelable.Creator<InputDateComponentStyle> {
            /* renamed from: a */
            public final InputDateComponentStyle createFromParcel(Parcel parcel) {
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = null;
                AttributeStyles$ComplexTextBasedFontFamilyStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontFamilyStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedFontSizeStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontSizeStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedFontWeightStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontWeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedLetterSpacingStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$ComplexTextBasedLineHeightStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLineHeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectTextColorStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectTextColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderRadiusStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderRadiusStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderWidthStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderWidthStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBackgroundColorStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$DateSelectBorderColorStyle createFromParcel10 = parcel.readInt() == 0 ? null : AttributeStyles$DateSelectBorderColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputMarginStyle createFromParcel11 = parcel.readInt() == 0 ? null : AttributeStyles$InputMarginStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$TextBasedJustifyStyle createFromParcel12 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedJustifyStyle.CREATOR.createFromParcel(parcel2);
                if (parcel.readInt() != 0) {
                    attributeStyles$DateSelectStrokeColorStyle = AttributeStyles$DateSelectStrokeColorStyle.CREATOR.createFromParcel(parcel2);
                }
                return new InputDateComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, attributeStyles$DateSelectStrokeColorStyle);
            }

            /* renamed from: b */
            public final InputDateComponentStyle[] newArray(int i10) {
                return new InputDateComponentStyle[i10];
            }
        }

        public InputDateComponentStyle(AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle, AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle, AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle, AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle, AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle, AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle, AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle, AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle, AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle, AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle, AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle, AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle, AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle) {
            this.f27790a = attributeStyles$ComplexTextBasedFontFamilyStyle;
            this.f27791b = attributeStyles$ComplexTextBasedFontSizeStyle;
            this.f27792c = attributeStyles$ComplexTextBasedFontWeightStyle;
            this.f27793d = attributeStyles$ComplexTextBasedLetterSpacingStyle;
            this.f27794e = attributeStyles$ComplexTextBasedLineHeightStyle;
            this.f27795f = attributeStyles$DateSelectTextColorStyle;
            this.f27796g = attributeStyles$DateSelectBorderRadiusStyle;
            this.f27797h = attributeStyles$DateSelectBorderWidthStyle;
            this.f27798j = attributeStyles$DateSelectBackgroundColorStyle;
            this.f27799k = attributeStyles$DateSelectBorderColorStyle;
            this.f27800l = attributeStyles$InputMarginStyle;
            this.f27801m = attributeStyles$TextBasedJustifyStyle;
            this.f27802n = attributeStyles$DateSelectStrokeColorStyle;
        }

        public final AttributeStyles$DateSelectBackgroundColorStyle a() {
            return this.f27798j;
        }

        public final AttributeStyles$DateSelectBorderColorStyle c() {
            return this.f27799k;
        }

        public final AttributeStyles$DateSelectBorderRadiusStyle d() {
            return this.f27796g;
        }

        public int describeContents() {
            return 0;
        }

        public final AttributeStyles$DateSelectBorderWidthStyle e() {
            return this.f27797h;
        }

        public final AttributeStyles$ComplexTextBasedFontFamilyStyle f() {
            return this.f27790a;
        }

        public final AttributeStyles$ComplexTextBasedFontSizeStyle g() {
            return this.f27791b;
        }

        public final AttributeStyles$ComplexTextBasedFontWeightStyle h() {
            return this.f27792c;
        }

        public final InputSelectComponentStyle i() {
            StyleElements.FontName fontName;
            StyleElements.FontName fontName2;
            StyleElements.FontName fontName3;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.FontWeightContainer fontWeightContainer2;
            StyleElements.FontWeightContainer fontWeightContainer3;
            StyleElements.DPMeasurement dPMeasurement4;
            StyleElements.DPMeasurement dPMeasurement5;
            StyleElements.DPMeasurement dPMeasurement6;
            StyleElements.DPMeasurement dPMeasurement7;
            StyleElements.DPMeasurement dPMeasurement8;
            StyleElements.DPMeasurement dPMeasurement9;
            StyleElements.SimpleElementColor simpleElementColor;
            String str;
            String str2;
            StyleElements.DPMeasurement dPMeasurement10;
            StyleElements.DPMeasurementSet dPMeasurementSet;
            StyleElements.SimpleElementColor simpleElementColor2;
            StyleElements.ComplexElementColor complexElementColor;
            StyleElements.SimpleElementColor simpleElementColor3;
            StyleElements.SimpleElementColor simpleElementColor4;
            StyleElements.ComplexElementColor a10;
            StyleElements.SimpleElementColor c10;
            StyleElements.SimpleElementColorValue a11;
            StyleElements.ComplexElementColor d10;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27800l;
            AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f27801m;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27790a;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
                fontName = attributeStyles$ComplexTextBasedFontFamilyStyle.a();
            } else {
                fontName = null;
            }
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle2 = this.f27790a;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle2 != null) {
                fontName2 = attributeStyles$ComplexTextBasedFontFamilyStyle2.d();
            } else {
                fontName2 = null;
            }
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle3 = this.f27790a;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle3 != null) {
                fontName3 = attributeStyles$ComplexTextBasedFontFamilyStyle3.c();
            } else {
                fontName3 = null;
            }
            AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = new AttributeStyles$InputSelectTextFontFamilyStyle(fontName, fontName2, fontName3);
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27791b;
            if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
                dPMeasurement = attributeStyles$ComplexTextBasedFontSizeStyle.e();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle2 = this.f27791b;
            if (attributeStyles$ComplexTextBasedFontSizeStyle2 != null) {
                dPMeasurement2 = attributeStyles$ComplexTextBasedFontSizeStyle2.c();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle3 = this.f27791b;
            if (attributeStyles$ComplexTextBasedFontSizeStyle3 != null) {
                dPMeasurement3 = attributeStyles$ComplexTextBasedFontSizeStyle3.a();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = new AttributeStyles$InputSelectTextFontSizeStyle(dPMeasurement, dPMeasurement2, dPMeasurement3);
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27792c;
            if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$ComplexTextBasedFontWeightStyle.e();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle2 = this.f27792c;
            if (attributeStyles$ComplexTextBasedFontWeightStyle2 != null) {
                fontWeightContainer2 = attributeStyles$ComplexTextBasedFontWeightStyle2.c();
            } else {
                fontWeightContainer2 = null;
            }
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle3 = this.f27792c;
            if (attributeStyles$ComplexTextBasedFontWeightStyle3 != null) {
                fontWeightContainer3 = attributeStyles$ComplexTextBasedFontWeightStyle3.a();
            } else {
                fontWeightContainer3 = null;
            }
            AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = new AttributeStyles$InputSelectTextFontWeightStyle(fontWeightContainer, fontWeightContainer2, fontWeightContainer3);
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27793d;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
                dPMeasurement4 = attributeStyles$ComplexTextBasedLetterSpacingStyle.a();
            } else {
                dPMeasurement4 = null;
            }
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle2 = this.f27793d;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle2 != null) {
                dPMeasurement5 = attributeStyles$ComplexTextBasedLetterSpacingStyle2.d();
            } else {
                dPMeasurement5 = null;
            }
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle3 = this.f27793d;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle3 != null) {
                dPMeasurement6 = attributeStyles$ComplexTextBasedLetterSpacingStyle3.c();
            } else {
                dPMeasurement6 = null;
            }
            AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = new AttributeStyles$InputSelectTextLetterSpacingStyle(dPMeasurement4, dPMeasurement5, dPMeasurement6);
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27794e;
            if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
                dPMeasurement7 = attributeStyles$ComplexTextBasedLineHeightStyle.e();
            } else {
                dPMeasurement7 = null;
            }
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle2 = this.f27794e;
            if (attributeStyles$ComplexTextBasedLineHeightStyle2 != null) {
                dPMeasurement8 = attributeStyles$ComplexTextBasedLineHeightStyle2.c();
            } else {
                dPMeasurement8 = null;
            }
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle3 = this.f27794e;
            if (attributeStyles$ComplexTextBasedLineHeightStyle3 != null) {
                dPMeasurement9 = attributeStyles$ComplexTextBasedLineHeightStyle3.a();
            } else {
                dPMeasurement9 = null;
            }
            AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = new AttributeStyles$InputSelectTextLineHeightStyle(dPMeasurement7, dPMeasurement8, dPMeasurement9);
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle != null) {
                simpleElementColor = attributeStyles$DateSelectTextColorStyle.c();
            } else {
                simpleElementColor = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle2 = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle2 == null || (d10 = attributeStyles$DateSelectTextColorStyle2.d()) == null || (str = d10.c()) == null) {
                AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle3 = this.f27795f;
                if (attributeStyles$DateSelectTextColorStyle3 == null || (c10 = attributeStyles$DateSelectTextColorStyle3.c()) == null || (a11 = c10.a()) == null) {
                    str = null;
                } else {
                    str = a11.a();
                }
            }
            StyleElements.SimpleElementColor simpleElementColor5 = new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(str));
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle4 = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle4 == null || (a10 = attributeStyles$DateSelectTextColorStyle4.a()) == null) {
                str2 = null;
            } else {
                str2 = a10.e();
            }
            AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = new AttributeStyles$InputSelectTextColorStyle(simpleElementColor, simpleElementColor5, new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(str2)));
            AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = this.f27796g;
            if (attributeStyles$DateSelectBorderRadiusStyle != null) {
                dPMeasurement10 = attributeStyles$DateSelectBorderRadiusStyle.a();
            } else {
                dPMeasurement10 = null;
            }
            AttributeStyles$InputSelectBorderRadiusStyle attributeStyles$InputSelectBorderRadiusStyle = new AttributeStyles$InputSelectBorderRadiusStyle(dPMeasurement10);
            AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = this.f27797h;
            if (attributeStyles$DateSelectBorderWidthStyle != null) {
                dPMeasurementSet = attributeStyles$DateSelectBorderWidthStyle.a();
            } else {
                dPMeasurementSet = null;
            }
            AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle = new AttributeStyles$InputSelectBorderWidthStyle(dPMeasurementSet);
            AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle = this.f27798j;
            if (attributeStyles$DateSelectBackgroundColorStyle != null) {
                simpleElementColor2 = attributeStyles$DateSelectBackgroundColorStyle.c();
            } else {
                simpleElementColor2 = null;
            }
            AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle = new AttributeStyles$InputSelectBackgroundColorStyle(simpleElementColor2);
            AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = this.f27799k;
            if (attributeStyles$DateSelectBorderColorStyle != null) {
                complexElementColor = attributeStyles$DateSelectBorderColorStyle.a();
            } else {
                complexElementColor = null;
            }
            AttributeStyles$InputSelectBorderColorStyle attributeStyles$InputSelectBorderColorStyle = new AttributeStyles$InputSelectBorderColorStyle(complexElementColor);
            AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = this.f27802n;
            if (attributeStyles$DateSelectStrokeColorStyle != null) {
                simpleElementColor3 = attributeStyles$DateSelectStrokeColorStyle.a();
                simpleElementColor4 = null;
            } else {
                simpleElementColor4 = null;
                simpleElementColor3 = null;
            }
            return new InputSelectComponentStyle(attributeStyles$InputMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$InputSelectTextFontFamilyStyle, attributeStyles$InputSelectTextFontSizeStyle, attributeStyles$InputSelectTextFontWeightStyle, attributeStyles$InputSelectTextLetterSpacingStyle, attributeStyles$InputSelectTextLineHeightStyle, attributeStyles$InputSelectTextColorStyle, attributeStyles$InputSelectBorderRadiusStyle, attributeStyles$InputSelectBorderWidthStyle, attributeStyles$InputSelectBackgroundColorStyle, attributeStyles$InputSelectBorderColorStyle, new AttributeStyles$InputSelectStrokeColorStyle(simpleElementColor3, simpleElementColor4));
        }

        public final InputTextBasedComponentStyle j() {
            StyleElements.ComplexElementColor complexElementColor;
            StyleElements.ComplexElementColor complexElementColor2;
            StyleElements.ComplexElementColor complexElementColor3;
            StyleElements.ComplexElementColor complexElementColor4;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.DPMeasurementSet dPMeasurementSet;
            StyleElements.ComplexElementColor complexElementColor5;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27800l;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27790a;
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27791b;
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27792c;
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27793d;
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27794e;
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = this.f27795f;
            StyleElements.ComplexElementColor complexElementColor6 = null;
            if (attributeStyles$DateSelectTextColorStyle != null) {
                complexElementColor = attributeStyles$DateSelectTextColorStyle.f();
            } else {
                complexElementColor = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle2 = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle2 != null) {
                complexElementColor2 = attributeStyles$DateSelectTextColorStyle2.e();
            } else {
                complexElementColor2 = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle3 = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle3 != null) {
                complexElementColor3 = attributeStyles$DateSelectTextColorStyle3.d();
            } else {
                complexElementColor3 = null;
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle4 = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle4 != null) {
                complexElementColor4 = attributeStyles$DateSelectTextColorStyle4.a();
            } else {
                complexElementColor4 = null;
            }
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = new AttributeStyles$ComplexTextBasedTextColorStyle(complexElementColor, complexElementColor2, complexElementColor3, complexElementColor4);
            AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = this.f27796g;
            if (attributeStyles$DateSelectBorderRadiusStyle != null) {
                dPMeasurement = attributeStyles$DateSelectBorderRadiusStyle.a();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle = new AttributeStyles$InputTextBorderRadiusStyle(dPMeasurement);
            AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = this.f27797h;
            if (attributeStyles$DateSelectBorderWidthStyle != null) {
                dPMeasurementSet = attributeStyles$DateSelectBorderWidthStyle.a();
            } else {
                dPMeasurementSet = null;
            }
            AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle = new AttributeStyles$InputTextBorderWidthStyle(dPMeasurementSet);
            AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle = this.f27798j;
            if (attributeStyles$DateSelectBackgroundColorStyle != null) {
                complexElementColor5 = attributeStyles$DateSelectBackgroundColorStyle.a();
            } else {
                complexElementColor5 = null;
            }
            AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle = new AttributeStyles$InputTextBackgroundColorStyle(complexElementColor5);
            AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = this.f27799k;
            if (attributeStyles$DateSelectBorderColorStyle != null) {
                complexElementColor6 = attributeStyles$DateSelectBorderColorStyle.a();
            }
            return new InputTextBasedComponentStyle(attributeStyles$InputMarginStyle, attributeStyles$ComplexTextBasedFontFamilyStyle, attributeStyles$ComplexTextBasedFontSizeStyle, attributeStyles$ComplexTextBasedFontWeightStyle, attributeStyles$ComplexTextBasedLetterSpacingStyle, attributeStyles$ComplexTextBasedLineHeightStyle, attributeStyles$ComplexTextBasedTextColorStyle, attributeStyles$InputTextBorderRadiusStyle, attributeStyles$InputTextBorderWidthStyle, attributeStyles$InputTextBackgroundColorStyle, new AttributeStyles$InputTextBorderColorStyle(complexElementColor6), (AttributeStyles$InputTextStrokeColorStyle) null);
        }

        public final AttributeStyles$TextBasedJustifyStyle k() {
            return this.f27801m;
        }

        public final AttributeStyles$ComplexTextBasedLetterSpacingStyle l() {
            return this.f27793d;
        }

        public final AttributeStyles$ComplexTextBasedLineHeightStyle m() {
            return this.f27794e;
        }

        public final AttributeStyles$InputMarginStyle n() {
            return this.f27800l;
        }

        public final AttributeStyles$DateSelectStrokeColorStyle o() {
            return this.f27802n;
        }

        public final AttributeStyles$DateSelectTextColorStyle p() {
            return this.f27795f;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27790a;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontFamilyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27791b;
            if (attributeStyles$ComplexTextBasedFontSizeStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontSizeStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27792c;
            if (attributeStyles$ComplexTextBasedFontWeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontWeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27793d;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLetterSpacingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27794e;
            if (attributeStyles$ComplexTextBasedLineHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLineHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectTextColorStyle attributeStyles$DateSelectTextColorStyle = this.f27795f;
            if (attributeStyles$DateSelectTextColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectTextColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderRadiusStyle attributeStyles$DateSelectBorderRadiusStyle = this.f27796g;
            if (attributeStyles$DateSelectBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderWidthStyle attributeStyles$DateSelectBorderWidthStyle = this.f27797h;
            if (attributeStyles$DateSelectBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBackgroundColorStyle attributeStyles$DateSelectBackgroundColorStyle = this.f27798j;
            if (attributeStyles$DateSelectBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectBorderColorStyle attributeStyles$DateSelectBorderColorStyle = this.f27799k;
            if (attributeStyles$DateSelectBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$DateSelectBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27800l;
            if (attributeStyles$InputMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f27801m;
            if (attributeStyles$TextBasedJustifyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$TextBasedJustifyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$DateSelectStrokeColorStyle attributeStyles$DateSelectStrokeColorStyle = this.f27802n;
            if (attributeStyles$DateSelectStrokeColorStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$DateSelectStrokeColorStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputMaskedText extends UiComponent implements m<InputMaskedText> {
        public static final Parcelable.Creator<InputMaskedText> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27803g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27804c;

        /* renamed from: d  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27805d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27806e;

        /* renamed from: f  reason: collision with root package name */
        private k f27807f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27808a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27809b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27810c;

            /* renamed from: d  reason: collision with root package name */
            private final Boolean f27811d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27812e;

            /* renamed from: f  reason: collision with root package name */
            private final String f27813f;

            /* renamed from: g  reason: collision with root package name */
            private final JsonLogicBoolean f27814g;

            /* renamed from: h  reason: collision with root package name */
            private final JsonLogicBoolean f27815h;

            /* renamed from: j  reason: collision with root package name */
            private final List<cj.a> f27816j = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    Boolean bool;
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    if (parcel.readInt() == 0) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    }
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, bool, readString4, readString5, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, Boolean bool, String str4, String str5, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27808a = str;
                this.f27809b = str2;
                this.f27810c = str3;
                this.f27811d = bool;
                this.f27812e = str4;
                this.f27813f = str5;
                this.f27814g = jsonLogicBoolean;
                this.f27815h = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, Boolean bool, String str4, String str5, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                Attributes attributes2 = attributes;
                int i11 = i10;
                return attributes.e((i11 & 1) != 0 ? attributes2.f27808a : str, (i11 & 2) != 0 ? attributes2.f27809b : str2, (i11 & 4) != 0 ? attributes2.f27810c : str3, (i11 & 8) != 0 ? attributes2.f27811d : bool, (i11 & 16) != 0 ? attributes2.f27812e : str4, (i11 & 32) != 0 ? attributes2.f27813f : str5, (i11 & 64) != 0 ? attributes.c() : jsonLogicBoolean, (i11 & 128) != 0 ? attributes.d() : jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27816j;
            }

            public JsonLogicBoolean c() {
                return this.f27814g;
            }

            public JsonLogicBoolean d() {
                return this.f27815h;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, Boolean bool, String str4, String str5, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                return new Attributes(str, str2, str3, bool, str4, str5, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27808a, attributes.f27808a) && j.b(this.f27809b, attributes.f27809b) && j.b(this.f27810c, attributes.f27810c) && j.b(this.f27811d, attributes.f27811d) && j.b(this.f27812e, attributes.f27812e) && j.b(this.f27813f, attributes.f27813f) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27808a;
            }

            public final String h() {
                return this.f27812e;
            }

            public int hashCode() {
                String str = this.f27808a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27809b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27810c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                Boolean bool = this.f27811d;
                int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
                String str4 = this.f27812e;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.f27813f;
                int hashCode6 = (((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode6 + i10;
            }

            public final String i() {
                return this.f27810c;
            }

            public final String j() {
                return this.f27813f;
            }

            public final String k() {
                return this.f27809b;
            }

            public final Boolean l() {
                return this.f27811d;
            }

            public String toString() {
                return "Attributes(field=" + this.f27808a + ", prefill=" + this.f27809b + ", mask=" + this.f27810c + ", secure=" + this.f27811d + ", label=" + this.f27812e + ", placeholder=" + this.f27813f + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27808a);
                parcel.writeString(this.f27809b);
                parcel.writeString(this.f27810c);
                Boolean bool = this.f27811d;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                parcel.writeString(this.f27812e);
                parcel.writeString(this.f27813f);
                JsonLogicBoolean jsonLogicBoolean = this.f27814g;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27815h;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputMaskedText> {
            /* renamed from: a */
            public final InputMaskedText createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputTextBasedComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputMaskedText(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputMaskedText[] newArray(int i10) {
                return new InputMaskedText[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r2 = r2.k();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputMaskedText(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMaskedText.Attributes r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27804c = r2
                r1.f27805d = r3
                r1.f27806e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputMaskedText$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x001b
                java.lang.String r2 = r2.k()
                if (r2 != 0) goto L_0x001d
            L_0x001b:
                java.lang.String r2 = ""
            L_0x001d:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27807f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputMaskedText.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputMaskedText$Attributes):void");
        }

        public static /* synthetic */ InputMaskedText D(InputMaskedText inputMaskedText, String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputMaskedText.A();
            }
            if ((i10 & 2) != 0) {
                inputTextBasedComponentStyle = inputMaskedText.f27805d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputMaskedText.z();
            }
            return inputMaskedText.B(str, inputTextBasedComponentStyle, attributes);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27804c;
        }

        public final InputMaskedText B(String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputMaskedText(str, inputTextBasedComponentStyle, attributes);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27806e;
        }

        public final InputTextBasedComponentStyle F() {
            return this.f27805d;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27807f = kVar;
        }

        /* renamed from: H */
        public InputMaskedText k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, str, (String) null, (Boolean) null, (String) null, (String) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 253, (Object) null);
            } else {
                attributes = null;
            }
            InputMaskedText D = D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null);
            D.G(a());
            return D;
        }

        public k a() {
            return this.f27807f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputMaskedText)) {
                return false;
            }
            InputMaskedText inputMaskedText = (InputMaskedText) obj;
            return j.b(A(), inputMaskedText.A()) && j.b(this.f27805d, inputMaskedText.f27805d) && j.b(z(), inputMaskedText.z());
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27805d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputTextBasedComponentStyle == null ? 0 : inputTextBasedComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "InputMaskedText(name=" + A() + ", styles=" + this.f27805d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27804c);
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27805d;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputTextBasedComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27806e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputMultiSelect extends UiComponent implements com.withpersona.sdk2.inquiry.steps.ui.components.j<InputMultiSelect>, d {
        public static final Parcelable.Creator<InputMultiSelect> CREATOR = new b();

        /* renamed from: m  reason: collision with root package name */
        public static final a f27817m = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27818c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27819d;

        /* renamed from: e  reason: collision with root package name */
        private final InputSelectComponentStyle f27820e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27821f = true;

        /* renamed from: g  reason: collision with root package name */
        private final String f27822g;

        /* renamed from: h  reason: collision with root package name */
        private final String f27823h;

        /* renamed from: j  reason: collision with root package name */
        private final List<String> f27824j;

        /* renamed from: k  reason: collision with root package name */
        private k f27825k;

        /* renamed from: l  reason: collision with root package name */
        private List<String> f27826l;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27827a;

            /* renamed from: b  reason: collision with root package name */
            private final List<String> f27828b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27829c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27830d;

            /* renamed from: e  reason: collision with root package name */
            private final List<Option> f27831e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27832f;

            /* renamed from: g  reason: collision with root package name */
            private final List<cj.a> f27833g = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(Option.CREATOR.createFromParcel(parcel));
                    }
                    return new Attributes(readString, createStringArrayList, readString2, readString3, arrayList, parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, List<String> list, String str2, String str3, List<Option> list2, JsonLogicBoolean jsonLogicBoolean) {
                j.g(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                this.f27827a = str;
                this.f27828b = list;
                this.f27829c = str2;
                this.f27830d = str3;
                this.f27831e = list2;
                this.f27832f = jsonLogicBoolean;
            }

            public static /* synthetic */ Attributes e(Attributes attributes, String str, List<String> list, String str2, String str3, List<Option> list2, JsonLogicBoolean jsonLogicBoolean, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27827a;
                }
                if ((i10 & 2) != 0) {
                    list = attributes.f27828b;
                }
                List<String> list3 = list;
                if ((i10 & 4) != 0) {
                    str2 = attributes.f27829c;
                }
                String str4 = str2;
                if ((i10 & 8) != 0) {
                    str3 = attributes.f27830d;
                }
                String str5 = str3;
                if ((i10 & 16) != 0) {
                    list2 = attributes.f27831e;
                }
                List<Option> list4 = list2;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                return attributes.d(str, list3, str4, str5, list4, jsonLogicBoolean);
            }

            public List<cj.a> a() {
                return this.f27833g;
            }

            public JsonLogicBoolean c() {
                return this.f27832f;
            }

            public final Attributes d(String str, List<String> list, String str2, String str3, List<Option> list2, JsonLogicBoolean jsonLogicBoolean) {
                j.g(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                return new Attributes(str, list, str2, str3, list2, jsonLogicBoolean);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27827a, attributes.f27827a) && j.b(this.f27828b, attributes.f27828b) && j.b(this.f27829c, attributes.f27829c) && j.b(this.f27830d, attributes.f27830d) && j.b(this.f27831e, attributes.f27831e) && j.b(c(), attributes.c());
            }

            public final String f() {
                return this.f27827a;
            }

            public final String g() {
                return this.f27829c;
            }

            public final List<Option> h() {
                return this.f27831e;
            }

            public int hashCode() {
                String str = this.f27827a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                List<String> list = this.f27828b;
                int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
                String str2 = this.f27829c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27830d;
                int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f27831e.hashCode()) * 31;
                if (c() != null) {
                    i10 = c().hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27830d;
            }

            public final List<String> j() {
                return this.f27828b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27827a + ", prefill=" + this.f27828b + ", label=" + this.f27829c + ", placeholder=" + this.f27830d + ", options=" + this.f27831e + ", hidden=" + c() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27827a);
                parcel.writeStringList(this.f27828b);
                parcel.writeString(this.f27829c);
                parcel.writeString(this.f27830d);
                List<Option> list = this.f27831e;
                parcel.writeInt(list.size());
                for (Option writeToParcel : list) {
                    writeToParcel.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27832f;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Option implements Parcelable {
            public static final Parcelable.Creator<Option> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27834a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27835b;

            public static final class a implements Parcelable.Creator<Option> {
                /* renamed from: a */
                public final Option createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Option(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final Option[] newArray(int i10) {
                    return new Option[i10];
                }
            }

            public Option(String str, String str2) {
                j.g(str, "text");
                j.g(str2, "value");
                this.f27834a = str;
                this.f27835b = str2;
            }

            public final String a() {
                return this.f27834a;
            }

            public final String c() {
                return this.f27835b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27834a);
                parcel.writeString(this.f27835b);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputMultiSelect> {
            /* renamed from: a */
            public final InputMultiSelect createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                InputSelectComponentStyle inputSelectComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    inputSelectComponentStyle = InputSelectComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new InputMultiSelect(readString, createFromParcel, inputSelectComponentStyle);
            }

            /* renamed from: b */
            public final InputMultiSelect[] newArray(int i10) {
                return new InputMultiSelect[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputMultiSelect(String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            String str2;
            String str3;
            List<String> list;
            List<String> list2;
            List<Option> h10;
            String str4;
            List<Option> h11;
            j.g(str, "name");
            this.f27818c = str;
            this.f27819d = attributes;
            this.f27820e = inputSelectComponentStyle;
            Attributes F = z();
            if (F != null) {
                str2 = F.g();
            } else {
                str2 = null;
            }
            this.f27822g = str2;
            Attributes F2 = z();
            if (F2 != null) {
                str3 = F2.i();
            } else {
                str3 = null;
            }
            this.f27823h = str3;
            Attributes F3 = z();
            if (F3 == null || (h11 = F3.h()) == null) {
                list = q.j();
            } else {
                list = new ArrayList<>(r.t(h11, 10));
                for (Option a10 : h11) {
                    list.add(a10.a());
                }
            }
            this.f27824j = list;
            this.f27825k = E();
            Attributes F4 = z();
            if (F4 == null || (h10 = F4.h()) == null) {
                list2 = q.j();
            } else {
                list2 = new ArrayList<>();
                for (Option option : h10) {
                    List<String> j10 = z().j();
                    boolean z10 = false;
                    if (j10 != null && j10.contains(option.c())) {
                        z10 = true;
                    }
                    if (z10) {
                        str4 = option.a();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        list2.add(str4);
                    }
                }
            }
            this.f27826l = list2;
        }

        public static /* synthetic */ InputMultiSelect D(InputMultiSelect inputMultiSelect, String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputMultiSelect.A();
            }
            if ((i10 & 2) != 0) {
                attributes = inputMultiSelect.z();
            }
            if ((i10 & 4) != 0) {
                inputSelectComponentStyle = inputMultiSelect.b();
            }
            return inputMultiSelect.B(str, attributes, inputSelectComponentStyle);
        }

        private final k E() {
            ArrayList arrayList;
            String str;
            List<Option> h10;
            String str2;
            Attributes F = z();
            if (F == null || (h10 = F.h()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Option option : h10) {
                    List<String> j10 = z().j();
                    boolean z10 = true;
                    if (j10 == null || !j10.contains(option.c())) {
                        z10 = false;
                    }
                    if (z10) {
                        str2 = option.a();
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        arrayList2.add(str2);
                    }
                }
                arrayList = arrayList2;
            }
            if (arrayList == null || (str = CollectionsKt___CollectionsKt.W(arrayList, com.withpersona.sdk2.inquiry.steps.ui.components.j.f27586r.a(), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) {
                str = "";
            }
            return com.squareup.workflow1.ui.m.a(str);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27818c;
        }

        public final InputMultiSelect B(String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle) {
            j.g(str, "name");
            return new InputMultiSelect(str, attributes, inputSelectComponentStyle);
        }

        /* renamed from: F */
        public Attributes z() {
            return this.f27819d;
        }

        public void G(List<String> list) {
            j.g(list, "<set-?>");
            this.f27826l = list;
        }

        public void H(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27825k = kVar;
        }

        /* renamed from: I */
        public InputMultiSelect c(List<String> list) {
            ArrayList arrayList;
            List<Option> h10;
            String str;
            j.g(list, "newStrings");
            Attributes F = z();
            Attributes attributes = null;
            if (F == null || (h10 = F.h()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Option option : h10) {
                    if (list.contains(option.a())) {
                        str = option.c();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                arrayList = arrayList2;
            }
            Attributes F2 = z();
            if (F2 != null) {
                attributes = Attributes.e(F2, (String) null, arrayList, (String) null, (String) null, (List) null, (JsonLogicBoolean) null, 61, (Object) null);
            }
            InputMultiSelect D = D(this, (String) null, attributes, (InputSelectComponentStyle) null, 5, (Object) null);
            D.H(a());
            D.G(list);
            return D;
        }

        public k a() {
            return this.f27825k;
        }

        public InputSelectComponentStyle b() {
            return this.f27820e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputMultiSelect)) {
                return false;
            }
            InputMultiSelect inputMultiSelect = (InputMultiSelect) obj;
            return j.b(A(), inputMultiSelect.A()) && j.b(z(), inputMultiSelect.z()) && j.b(b(), inputMultiSelect.b());
        }

        public String getLabel() {
            return this.f27822g;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            if (b() != null) {
                i10 = b().hashCode();
            }
            return hashCode + i10;
        }

        public boolean l() {
            return this.f27821f;
        }

        public List<String> p() {
            return this.f27824j;
        }

        public List<String> t() {
            return this.f27826l;
        }

        public String toString() {
            return "InputMultiSelect(name=" + A() + ", attributes=" + z() + ", styles=" + b() + PropertyUtils.MAPPED_DELIM2;
        }

        public String w() {
            return this.f27823h;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27818c);
            Attributes attributes = this.f27819d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            InputSelectComponentStyle inputSelectComponentStyle = this.f27820e;
            if (inputSelectComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            inputSelectComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputNumber extends UiComponent implements l<InputNumber> {
        public static final Parcelable.Creator<InputNumber> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27836g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27837c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27838d;

        /* renamed from: e  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27839e;

        /* renamed from: f  reason: collision with root package name */
        private k f27840f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27841a;

            /* renamed from: b  reason: collision with root package name */
            private final Number f27842b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27843c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27844d;

            /* renamed from: e  reason: collision with root package name */
            private final JsonLogicBoolean f27845e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27846f;

            /* renamed from: g  reason: collision with root package name */
            private final Integer f27847g;

            /* renamed from: h  reason: collision with root package name */
            private final List<cj.a> f27848h = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Attributes(parcel.readString(), (Number) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, Number number, String str2, String str3, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, Integer num) {
                this.f27841a = str;
                this.f27842b = number;
                this.f27843c = str2;
                this.f27844d = str3;
                this.f27845e = jsonLogicBoolean;
                this.f27846f = jsonLogicBoolean2;
                this.f27847g = num;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, Number number, String str2, String str3, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, Integer num, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27841a;
                }
                if ((i10 & 2) != 0) {
                    number = attributes.f27842b;
                }
                Number number2 = number;
                if ((i10 & 4) != 0) {
                    str2 = attributes.f27843c;
                }
                String str4 = str2;
                if ((i10 & 8) != 0) {
                    str3 = attributes.f27844d;
                }
                String str5 = str3;
                if ((i10 & 16) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                JsonLogicBoolean jsonLogicBoolean3 = jsonLogicBoolean;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean2 = attributes.d();
                }
                JsonLogicBoolean jsonLogicBoolean4 = jsonLogicBoolean2;
                if ((i10 & 64) != 0) {
                    num = attributes.f27847g;
                }
                return attributes.e(str, number2, str4, str5, jsonLogicBoolean3, jsonLogicBoolean4, num);
            }

            public List<cj.a> a() {
                return this.f27848h;
            }

            public JsonLogicBoolean c() {
                return this.f27845e;
            }

            public JsonLogicBoolean d() {
                return this.f27846f;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, Number number, String str2, String str3, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, Integer num) {
                return new Attributes(str, number, str2, str3, jsonLogicBoolean, jsonLogicBoolean2, num);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27841a, attributes.f27841a) && j.b(this.f27842b, attributes.f27842b) && j.b(this.f27843c, attributes.f27843c) && j.b(this.f27844d, attributes.f27844d) && j.b(c(), attributes.c()) && j.b(d(), attributes.d()) && j.b(this.f27847g, attributes.f27847g);
            }

            public final String g() {
                return this.f27841a;
            }

            public final String h() {
                return this.f27843c;
            }

            public int hashCode() {
                String str = this.f27841a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Number number = this.f27842b;
                int hashCode2 = (hashCode + (number == null ? 0 : number.hashCode())) * 31;
                String str2 = this.f27843c;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27844d;
                int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31) + (d() == null ? 0 : d().hashCode())) * 31;
                Integer num = this.f27847g;
                if (num != null) {
                    i10 = num.hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27844d;
            }

            public final Integer j() {
                return this.f27847g;
            }

            public final Number k() {
                return this.f27842b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27841a + ", prefill=" + this.f27842b + ", label=" + this.f27843c + ", placeholder=" + this.f27844d + ", hidden=" + c() + ", disabled=" + d() + ", precision=" + this.f27847g + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27841a);
                parcel.writeSerializable(this.f27842b);
                parcel.writeString(this.f27843c);
                parcel.writeString(this.f27844d);
                JsonLogicBoolean jsonLogicBoolean = this.f27845e;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27846f;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean2.writeToParcel(parcel, i10);
                }
                Integer num = this.f27847g;
                if (num == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputNumber> {
            /* renamed from: a */
            public final InputNumber createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                InputTextBasedComponentStyle inputTextBasedComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    inputTextBasedComponentStyle = InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new InputNumber(readString, createFromParcel, inputTextBasedComponentStyle);
            }

            /* renamed from: b */
            public final InputNumber[] newArray(int i10) {
                return new InputNumber[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
            r2 = (r2 = r2.k()).toString();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputNumber(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputNumber.Attributes r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27837c = r2
                r1.f27838d = r3
                r1.f27839e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputNumber$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x0021
                java.lang.Number r2 = r2.k()
                if (r2 == 0) goto L_0x0021
                java.lang.String r2 = r2.toString()
                if (r2 != 0) goto L_0x0023
            L_0x0021:
                java.lang.String r2 = ""
            L_0x0023:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27840f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputNumber.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputNumber$Attributes, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle):void");
        }

        public static /* synthetic */ InputNumber D(InputNumber inputNumber, String str, Attributes attributes, InputTextBasedComponentStyle inputTextBasedComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputNumber.A();
            }
            if ((i10 & 2) != 0) {
                attributes = inputNumber.z();
            }
            if ((i10 & 4) != 0) {
                inputTextBasedComponentStyle = inputNumber.f27839e;
            }
            return inputNumber.B(str, attributes, inputTextBasedComponentStyle);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27837c;
        }

        public final InputNumber B(String str, Attributes attributes, InputTextBasedComponentStyle inputTextBasedComponentStyle) {
            j.g(str, "name");
            return new InputNumber(str, attributes, inputTextBasedComponentStyle);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27838d;
        }

        public final InputTextBasedComponentStyle F() {
            return this.f27839e;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27840f = kVar;
        }

        /* renamed from: H */
        public InputNumber q(Number number) {
            Attributes attributes;
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, number, (String) null, (String) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, (Integer) null, 125, (Object) null);
            } else {
                attributes = null;
            }
            InputNumber D = D(this, (String) null, attributes, (InputTextBasedComponentStyle) null, 5, (Object) null);
            D.G(a());
            return D;
        }

        public k a() {
            return this.f27840f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputNumber)) {
                return false;
            }
            InputNumber inputNumber = (InputNumber) obj;
            return j.b(A(), inputNumber.A()) && j.b(z(), inputNumber.z()) && j.b(this.f27839e, inputNumber.f27839e);
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27839e;
            if (inputTextBasedComponentStyle != null) {
                i10 = inputTextBasedComponentStyle.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "InputNumber(name=" + A() + ", attributes=" + z() + ", styles=" + this.f27839e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27837c);
            Attributes attributes = this.f27838d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27839e;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            inputTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputPhoneNumber extends UiComponent implements m<InputPhoneNumber> {
        public static final Parcelable.Creator<InputPhoneNumber> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27849g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27850c;

        /* renamed from: d  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27851d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27852e;

        /* renamed from: f  reason: collision with root package name */
        private k f27853f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27854a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27855b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27856c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27857d;

            /* renamed from: e  reason: collision with root package name */
            private final JsonLogicBoolean f27858e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27859f;

            /* renamed from: g  reason: collision with root package name */
            private final List<cj.a> f27860g = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, readString4, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27854a = str;
                this.f27855b = str2;
                this.f27856c = str3;
                this.f27857d = str4;
                this.f27858e = jsonLogicBoolean;
                this.f27859f = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27854a;
                }
                if ((i10 & 2) != 0) {
                    str2 = attributes.f27855b;
                }
                String str5 = str2;
                if ((i10 & 4) != 0) {
                    str3 = attributes.f27856c;
                }
                String str6 = str3;
                if ((i10 & 8) != 0) {
                    str4 = attributes.f27857d;
                }
                String str7 = str4;
                if ((i10 & 16) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                JsonLogicBoolean jsonLogicBoolean3 = jsonLogicBoolean;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean2 = attributes.d();
                }
                return attributes.e(str, str5, str6, str7, jsonLogicBoolean3, jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27860g;
            }

            public JsonLogicBoolean c() {
                return this.f27858e;
            }

            public JsonLogicBoolean d() {
                return this.f27859f;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, String str4, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                return new Attributes(str, str2, str3, str4, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27854a, attributes.f27854a) && j.b(this.f27855b, attributes.f27855b) && j.b(this.f27856c, attributes.f27856c) && j.b(this.f27857d, attributes.f27857d) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27854a;
            }

            public final String h() {
                return this.f27856c;
            }

            public int hashCode() {
                String str = this.f27854a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27855b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27856c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27857d;
                int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27857d;
            }

            public final String j() {
                return this.f27855b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27854a + ", prefill=" + this.f27855b + ", label=" + this.f27856c + ", placeholder=" + this.f27857d + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27854a);
                parcel.writeString(this.f27855b);
                parcel.writeString(this.f27856c);
                parcel.writeString(this.f27857d);
                JsonLogicBoolean jsonLogicBoolean = this.f27858e;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27859f;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputPhoneNumber> {
            /* renamed from: a */
            public final InputPhoneNumber createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputTextBasedComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputPhoneNumber(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputPhoneNumber[] newArray(int i10) {
                return new InputPhoneNumber[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r2 = r2.j();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputPhoneNumber(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputPhoneNumber.Attributes r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27850c = r2
                r1.f27851d = r3
                r1.f27852e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputPhoneNumber$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x001b
                java.lang.String r2 = r2.j()
                if (r2 != 0) goto L_0x001d
            L_0x001b:
                java.lang.String r2 = ""
            L_0x001d:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27853f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputPhoneNumber.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputPhoneNumber$Attributes):void");
        }

        public static /* synthetic */ InputPhoneNumber D(InputPhoneNumber inputPhoneNumber, String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputPhoneNumber.A();
            }
            if ((i10 & 2) != 0) {
                inputTextBasedComponentStyle = inputPhoneNumber.f27851d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputPhoneNumber.z();
            }
            return inputPhoneNumber.B(str, inputTextBasedComponentStyle, attributes);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27850c;
        }

        public final InputPhoneNumber B(String str, InputTextBasedComponentStyle inputTextBasedComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputPhoneNumber(str, inputTextBasedComponentStyle, attributes);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27852e;
        }

        public final InputTextBasedComponentStyle F() {
            return this.f27851d;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27853f = kVar;
        }

        /* renamed from: H */
        public InputPhoneNumber k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, str, (String) null, (String) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 61, (Object) null);
            } else {
                attributes = null;
            }
            InputPhoneNumber D = D(this, (String) null, (InputTextBasedComponentStyle) null, attributes, 3, (Object) null);
            D.G(a());
            return D;
        }

        public k a() {
            return this.f27853f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputPhoneNumber)) {
                return false;
            }
            InputPhoneNumber inputPhoneNumber = (InputPhoneNumber) obj;
            return j.b(A(), inputPhoneNumber.A()) && j.b(this.f27851d, inputPhoneNumber.f27851d) && j.b(z(), inputPhoneNumber.z());
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27851d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputTextBasedComponentStyle == null ? 0 : inputTextBasedComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "InputPhoneNumber(name=" + A() + ", styles=" + this.f27851d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27850c);
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27851d;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputTextBasedComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27852e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputRadioGroup extends UiComponent implements m<InputRadioGroup> {
        public static final Parcelable.Creator<InputRadioGroup> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27861g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27862c;

        /* renamed from: d  reason: collision with root package name */
        private final InputRadioGroupComponentStyle f27863d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27864e;

        /* renamed from: f  reason: collision with root package name */
        private k f27865f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27866a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27867b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27868c;

            /* renamed from: d  reason: collision with root package name */
            private final List<Option> f27869d;

            /* renamed from: e  reason: collision with root package name */
            private final JsonLogicBoolean f27870e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27871f;

            /* renamed from: g  reason: collision with root package name */
            private final List<cj.a> f27872g = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(Option.CREATOR.createFromParcel(parcel));
                    }
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, arrayList, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, List<Option> list, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                this.f27866a = str;
                this.f27867b = str2;
                this.f27868c = str3;
                this.f27869d = list;
                this.f27870e = jsonLogicBoolean;
                this.f27871f = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, List<Option> list, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27866a;
                }
                if ((i10 & 2) != 0) {
                    str2 = attributes.f27867b;
                }
                String str4 = str2;
                if ((i10 & 4) != 0) {
                    str3 = attributes.f27868c;
                }
                String str5 = str3;
                if ((i10 & 8) != 0) {
                    list = attributes.f27869d;
                }
                List<Option> list2 = list;
                if ((i10 & 16) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                JsonLogicBoolean jsonLogicBoolean3 = jsonLogicBoolean;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean2 = attributes.d();
                }
                return attributes.e(str, str4, str5, list2, jsonLogicBoolean3, jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27872g;
            }

            public JsonLogicBoolean c() {
                return this.f27870e;
            }

            public JsonLogicBoolean d() {
                return this.f27871f;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, List<Option> list, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                return new Attributes(str, str2, str3, list, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27866a, attributes.f27866a) && j.b(this.f27867b, attributes.f27867b) && j.b(this.f27868c, attributes.f27868c) && j.b(this.f27869d, attributes.f27869d) && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String g() {
                return this.f27866a;
            }

            public final String h() {
                return this.f27868c;
            }

            public int hashCode() {
                String str = this.f27866a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27867b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27868c;
                int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f27869d.hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode3 + i10;
            }

            public final List<Option> i() {
                return this.f27869d;
            }

            public final String j() {
                return this.f27867b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27866a + ", prefill=" + this.f27867b + ", label=" + this.f27868c + ", options=" + this.f27869d + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27866a);
                parcel.writeString(this.f27867b);
                parcel.writeString(this.f27868c);
                List<Option> list = this.f27869d;
                parcel.writeInt(list.size());
                for (Option writeToParcel : list) {
                    writeToParcel.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27870e;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27871f;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class InputRadioGroupComponentStyle implements Parcelable {
            public static final Parcelable.Creator<InputRadioGroupComponentStyle> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final AttributeStyles$TextBasedMarginStyle f27873a;

            /* renamed from: b  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupFontFamilyStyle f27874b;

            /* renamed from: c  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupFontSizeStyle f27875c;

            /* renamed from: d  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupFontWeightStyle f27876d;

            /* renamed from: e  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupLetterSpacingStyle f27877e;

            /* renamed from: f  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupLineHeightStyle f27878f;

            /* renamed from: g  reason: collision with root package name */
            private final AttributeStyles$InputRadioGroupTextColorStyle f27879g;

            /* renamed from: h  reason: collision with root package name */
            private final AttributeStyles$TextBasedTextColorStyle f27880h;

            public static final class a implements Parcelable.Creator<InputRadioGroupComponentStyle> {
                /* renamed from: a */
                public final InputRadioGroupComponentStyle createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = null;
                    AttributeStyles$TextBasedMarginStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedMarginStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupFontFamilyStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupFontFamilyStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupFontSizeStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupFontSizeStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupFontWeightStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupFontWeightStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupLetterSpacingStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupLetterSpacingStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupLineHeightStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupLineHeightStyle.CREATOR.createFromParcel(parcel);
                    AttributeStyles$InputRadioGroupTextColorStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$InputRadioGroupTextColorStyle.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        attributeStyles$TextBasedTextColorStyle = AttributeStyles$TextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
                    }
                    return new InputRadioGroupComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, attributeStyles$TextBasedTextColorStyle);
                }

                /* renamed from: b */
                public final InputRadioGroupComponentStyle[] newArray(int i10) {
                    return new InputRadioGroupComponentStyle[i10];
                }
            }

            public InputRadioGroupComponentStyle(AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle, AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle, AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle, AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle, AttributeStyles$InputRadioGroupLetterSpacingStyle attributeStyles$InputRadioGroupLetterSpacingStyle, AttributeStyles$InputRadioGroupLineHeightStyle attributeStyles$InputRadioGroupLineHeightStyle, AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle, AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle) {
                this.f27873a = attributeStyles$TextBasedMarginStyle;
                this.f27874b = attributeStyles$InputRadioGroupFontFamilyStyle;
                this.f27875c = attributeStyles$InputRadioGroupFontSizeStyle;
                this.f27876d = attributeStyles$InputRadioGroupFontWeightStyle;
                this.f27877e = attributeStyles$InputRadioGroupLetterSpacingStyle;
                this.f27878f = attributeStyles$InputRadioGroupLineHeightStyle;
                this.f27879g = attributeStyles$InputRadioGroupTextColorStyle;
                this.f27880h = attributeStyles$TextBasedTextColorStyle;
            }

            public final TextBasedComponentStyle a() {
                StyleElements.FontName fontName;
                StyleElements.DPMeasurement dPMeasurement;
                StyleElements.FontWeightContainer fontWeightContainer;
                StyleElements.DPMeasurement dPMeasurement2;
                StyleElements.DPMeasurement dPMeasurement3;
                AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle = this.f27874b;
                StyleElements.SimpleElementColor simpleElementColor = null;
                if (attributeStyles$InputRadioGroupFontFamilyStyle != null) {
                    fontName = attributeStyles$InputRadioGroupFontFamilyStyle.c();
                } else {
                    fontName = null;
                }
                AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
                AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle = this.f27875c;
                if (attributeStyles$InputRadioGroupFontSizeStyle != null) {
                    dPMeasurement = attributeStyles$InputRadioGroupFontSizeStyle.c();
                } else {
                    dPMeasurement = null;
                }
                AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
                AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle = this.f27876d;
                if (attributeStyles$InputRadioGroupFontWeightStyle != null) {
                    fontWeightContainer = attributeStyles$InputRadioGroupFontWeightStyle.c();
                } else {
                    fontWeightContainer = null;
                }
                AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
                AttributeStyles$InputRadioGroupLetterSpacingStyle attributeStyles$InputRadioGroupLetterSpacingStyle = this.f27877e;
                if (attributeStyles$InputRadioGroupLetterSpacingStyle != null) {
                    dPMeasurement2 = attributeStyles$InputRadioGroupLetterSpacingStyle.c();
                } else {
                    dPMeasurement2 = null;
                }
                AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
                AttributeStyles$InputRadioGroupLineHeightStyle attributeStyles$InputRadioGroupLineHeightStyle = this.f27878f;
                if (attributeStyles$InputRadioGroupLineHeightStyle != null) {
                    dPMeasurement3 = attributeStyles$InputRadioGroupLineHeightStyle.c();
                } else {
                    dPMeasurement3 = null;
                }
                AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
                AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle = this.f27879g;
                if (attributeStyles$InputRadioGroupTextColorStyle != null) {
                    simpleElementColor = attributeStyles$InputRadioGroupTextColorStyle.c();
                }
                return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(simpleElementColor), (AttributeStyles$TextBasedTextColorStyle) null);
            }

            public final AttributeStyles$InputRadioGroupFontFamilyStyle c() {
                return this.f27874b;
            }

            public final AttributeStyles$InputRadioGroupFontSizeStyle d() {
                return this.f27875c;
            }

            public int describeContents() {
                return 0;
            }

            public final AttributeStyles$InputRadioGroupFontWeightStyle e() {
                return this.f27876d;
            }

            public final AttributeStyles$InputRadioGroupLetterSpacingStyle f() {
                return this.f27877e;
            }

            public final AttributeStyles$InputRadioGroupLineHeightStyle g() {
                return this.f27878f;
            }

            public final AttributeStyles$TextBasedMarginStyle h() {
                return this.f27873a;
            }

            public final StyleElements.DPSizeSet i() {
                StyleElements.DPMeasurementSet a10;
                AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = this.f27873a;
                if (attributeStyles$TextBasedMarginStyle == null || (a10 = attributeStyles$TextBasedMarginStyle.a()) == null) {
                    return null;
                }
                return a10.a();
            }

            public final TextBasedComponentStyle j() {
                StyleElements.FontName fontName;
                StyleElements.DPMeasurement dPMeasurement;
                StyleElements.FontWeightContainer fontWeightContainer;
                StyleElements.DPMeasurement dPMeasurement2;
                StyleElements.DPMeasurement dPMeasurement3;
                AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle = this.f27874b;
                StyleElements.SimpleElementColor simpleElementColor = null;
                if (attributeStyles$InputRadioGroupFontFamilyStyle != null) {
                    fontName = attributeStyles$InputRadioGroupFontFamilyStyle.a();
                } else {
                    fontName = null;
                }
                AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
                AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle = this.f27875c;
                if (attributeStyles$InputRadioGroupFontSizeStyle != null) {
                    dPMeasurement = attributeStyles$InputRadioGroupFontSizeStyle.a();
                } else {
                    dPMeasurement = null;
                }
                AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
                AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle = this.f27876d;
                if (attributeStyles$InputRadioGroupFontWeightStyle != null) {
                    fontWeightContainer = attributeStyles$InputRadioGroupFontWeightStyle.a();
                } else {
                    fontWeightContainer = null;
                }
                AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
                AttributeStyles$InputRadioGroupLetterSpacingStyle attributeStyles$InputRadioGroupLetterSpacingStyle = this.f27877e;
                if (attributeStyles$InputRadioGroupLetterSpacingStyle != null) {
                    dPMeasurement2 = attributeStyles$InputRadioGroupLetterSpacingStyle.a();
                } else {
                    dPMeasurement2 = null;
                }
                AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
                AttributeStyles$InputRadioGroupLineHeightStyle attributeStyles$InputRadioGroupLineHeightStyle = this.f27878f;
                if (attributeStyles$InputRadioGroupLineHeightStyle != null) {
                    dPMeasurement3 = attributeStyles$InputRadioGroupLineHeightStyle.a();
                } else {
                    dPMeasurement3 = null;
                }
                AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
                AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle = this.f27879g;
                if (attributeStyles$InputRadioGroupTextColorStyle != null) {
                    simpleElementColor = attributeStyles$InputRadioGroupTextColorStyle.a();
                }
                return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(simpleElementColor), this.f27880h);
            }

            public final AttributeStyles$InputRadioGroupTextColorStyle k() {
                return this.f27879g;
            }

            public final AttributeStyles$TextBasedTextColorStyle l() {
                return this.f27880h;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = this.f27873a;
                if (attributeStyles$TextBasedMarginStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$TextBasedMarginStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupFontFamilyStyle attributeStyles$InputRadioGroupFontFamilyStyle = this.f27874b;
                if (attributeStyles$InputRadioGroupFontFamilyStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupFontFamilyStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupFontSizeStyle attributeStyles$InputRadioGroupFontSizeStyle = this.f27875c;
                if (attributeStyles$InputRadioGroupFontSizeStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupFontSizeStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupFontWeightStyle attributeStyles$InputRadioGroupFontWeightStyle = this.f27876d;
                if (attributeStyles$InputRadioGroupFontWeightStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupFontWeightStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupLetterSpacingStyle attributeStyles$InputRadioGroupLetterSpacingStyle = this.f27877e;
                if (attributeStyles$InputRadioGroupLetterSpacingStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupLetterSpacingStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupLineHeightStyle attributeStyles$InputRadioGroupLineHeightStyle = this.f27878f;
                if (attributeStyles$InputRadioGroupLineHeightStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupLineHeightStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$InputRadioGroupTextColorStyle attributeStyles$InputRadioGroupTextColorStyle = this.f27879g;
                if (attributeStyles$InputRadioGroupTextColorStyle == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    attributeStyles$InputRadioGroupTextColorStyle.writeToParcel(parcel, i10);
                }
                AttributeStyles$TextBasedTextColorStyle attributeStyles$TextBasedTextColorStyle = this.f27880h;
                if (attributeStyles$TextBasedTextColorStyle == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                attributeStyles$TextBasedTextColorStyle.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Option implements Parcelable {
            public static final Parcelable.Creator<Option> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27881a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27882b;

            public static final class a implements Parcelable.Creator<Option> {
                /* renamed from: a */
                public final Option createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Option(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final Option[] newArray(int i10) {
                    return new Option[i10];
                }
            }

            public Option(String str, String str2) {
                j.g(str, "text");
                j.g(str2, "value");
                this.f27881a = str;
                this.f27882b = str2;
            }

            public final String a() {
                return this.f27881a;
            }

            public final String c() {
                return this.f27882b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27881a);
                parcel.writeString(this.f27882b);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputRadioGroup> {
            /* renamed from: a */
            public final InputRadioGroup createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputRadioGroupComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputRadioGroupComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputRadioGroup(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputRadioGroup[] newArray(int i10) {
                return new InputRadioGroup[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r2 = r2.j();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputRadioGroup(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup.InputRadioGroupComponentStyle r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup.Attributes r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27862c = r2
                r1.f27863d = r3
                r1.f27864e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x001b
                java.lang.String r2 = r2.j()
                if (r2 != 0) goto L_0x001d
            L_0x001b:
                java.lang.String r2 = ""
            L_0x001d:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27865f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputRadioGroup.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup$InputRadioGroupComponentStyle, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputRadioGroup$Attributes):void");
        }

        public static /* synthetic */ InputRadioGroup D(InputRadioGroup inputRadioGroup, String str, InputRadioGroupComponentStyle inputRadioGroupComponentStyle, Attributes attributes, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputRadioGroup.A();
            }
            if ((i10 & 2) != 0) {
                inputRadioGroupComponentStyle = inputRadioGroup.f27863d;
            }
            if ((i10 & 4) != 0) {
                attributes = inputRadioGroup.z();
            }
            return inputRadioGroup.B(str, inputRadioGroupComponentStyle, attributes);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27862c;
        }

        public final InputRadioGroup B(String str, InputRadioGroupComponentStyle inputRadioGroupComponentStyle, Attributes attributes) {
            j.g(str, "name");
            return new InputRadioGroup(str, inputRadioGroupComponentStyle, attributes);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27864e;
        }

        public final InputRadioGroupComponentStyle F() {
            return this.f27863d;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27865f = kVar;
        }

        /* renamed from: H */
        public InputRadioGroup k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, str, (String) null, (List) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 61, (Object) null);
            } else {
                attributes = null;
            }
            InputRadioGroup D = D(this, (String) null, (InputRadioGroupComponentStyle) null, attributes, 3, (Object) null);
            D.G(a());
            return D;
        }

        public k a() {
            return this.f27865f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputRadioGroup)) {
                return false;
            }
            InputRadioGroup inputRadioGroup = (InputRadioGroup) obj;
            return j.b(A(), inputRadioGroup.A()) && j.b(this.f27863d, inputRadioGroup.f27863d) && j.b(z(), inputRadioGroup.z());
        }

        public int hashCode() {
            int hashCode = A().hashCode() * 31;
            InputRadioGroupComponentStyle inputRadioGroupComponentStyle = this.f27863d;
            int i10 = 0;
            int hashCode2 = (hashCode + (inputRadioGroupComponentStyle == null ? 0 : inputRadioGroupComponentStyle.hashCode())) * 31;
            if (z() != null) {
                i10 = z().hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "InputRadioGroup(name=" + A() + ", styles=" + this.f27863d + ", attributes=" + z() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27862c);
            InputRadioGroupComponentStyle inputRadioGroupComponentStyle = this.f27863d;
            if (inputRadioGroupComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputRadioGroupComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27864e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputSelect extends UiComponent implements m<InputSelect>, d {
        public static final Parcelable.Creator<InputSelect> CREATOR = new b();

        /* renamed from: m  reason: collision with root package name */
        public static final a f27883m = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27884c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27885d;

        /* renamed from: e  reason: collision with root package name */
        private final InputSelectComponentStyle f27886e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f27887f;

        /* renamed from: g  reason: collision with root package name */
        private final String f27888g;

        /* renamed from: h  reason: collision with root package name */
        private final String f27889h;

        /* renamed from: j  reason: collision with root package name */
        private final List<String> f27890j;

        /* renamed from: k  reason: collision with root package name */
        private k f27891k;

        /* renamed from: l  reason: collision with root package name */
        private List<String> f27892l;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27893a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27894b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27895c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27896d;

            /* renamed from: e  reason: collision with root package name */
            private final List<Option> f27897e;

            /* renamed from: f  reason: collision with root package name */
            private final JsonLogicBoolean f27898f;

            /* renamed from: g  reason: collision with root package name */
            private final List<cj.a> f27899g = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        arrayList.add(Option.CREATOR.createFromParcel(parcel));
                    }
                    return new Attributes(readString, readString2, readString3, readString4, arrayList, parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel));
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, String str4, List<Option> list, JsonLogicBoolean jsonLogicBoolean) {
                j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                this.f27893a = str;
                this.f27894b = str2;
                this.f27895c = str3;
                this.f27896d = str4;
                this.f27897e = list;
                this.f27898f = jsonLogicBoolean;
            }

            public static /* synthetic */ Attributes e(Attributes attributes, String str, String str2, String str3, String str4, List<Option> list, JsonLogicBoolean jsonLogicBoolean, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = attributes.f27893a;
                }
                if ((i10 & 2) != 0) {
                    str2 = attributes.f27894b;
                }
                String str5 = str2;
                if ((i10 & 4) != 0) {
                    str3 = attributes.f27895c;
                }
                String str6 = str3;
                if ((i10 & 8) != 0) {
                    str4 = attributes.f27896d;
                }
                String str7 = str4;
                if ((i10 & 16) != 0) {
                    list = attributes.f27897e;
                }
                List<Option> list2 = list;
                if ((i10 & 32) != 0) {
                    jsonLogicBoolean = attributes.c();
                }
                return attributes.d(str, str5, str6, str7, list2, jsonLogicBoolean);
            }

            public List<cj.a> a() {
                return this.f27899g;
            }

            public JsonLogicBoolean c() {
                return this.f27898f;
            }

            public final Attributes d(String str, String str2, String str3, String str4, List<Option> list, JsonLogicBoolean jsonLogicBoolean) {
                j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                return new Attributes(str, str2, str3, str4, list, jsonLogicBoolean);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27893a, attributes.f27893a) && j.b(this.f27894b, attributes.f27894b) && j.b(this.f27895c, attributes.f27895c) && j.b(this.f27896d, attributes.f27896d) && j.b(this.f27897e, attributes.f27897e) && j.b(c(), attributes.c());
            }

            public final String f() {
                return this.f27893a;
            }

            public final String g() {
                return this.f27895c;
            }

            public final List<Option> h() {
                return this.f27897e;
            }

            public int hashCode() {
                String str = this.f27893a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27894b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27895c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27896d;
                int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f27897e.hashCode()) * 31;
                if (c() != null) {
                    i10 = c().hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27896d;
            }

            public final String j() {
                return this.f27894b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27893a + ", prefill=" + this.f27894b + ", label=" + this.f27895c + ", placeholder=" + this.f27896d + ", options=" + this.f27897e + ", hidden=" + c() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27893a);
                parcel.writeString(this.f27894b);
                parcel.writeString(this.f27895c);
                parcel.writeString(this.f27896d);
                List<Option> list = this.f27897e;
                parcel.writeInt(list.size());
                for (Option writeToParcel : list) {
                    writeToParcel.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27898f;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = true)
        public static final class Option implements Parcelable {
            public static final Parcelable.Creator<Option> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27900a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27901b;

            public static final class a implements Parcelable.Creator<Option> {
                /* renamed from: a */
                public final Option createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Option(parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final Option[] newArray(int i10) {
                    return new Option[i10];
                }
            }

            public Option(String str, String str2) {
                j.g(str, "text");
                j.g(str2, "value");
                this.f27900a = str;
                this.f27901b = str2;
            }

            public final String a() {
                return this.f27900a;
            }

            public final String c() {
                return this.f27901b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27900a);
                parcel.writeString(this.f27901b);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputSelect> {
            /* renamed from: a */
            public final InputSelect createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                InputSelectComponentStyle inputSelectComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    inputSelectComponentStyle = InputSelectComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new InputSelect(readString, createFromParcel, inputSelectComponentStyle);
            }

            /* renamed from: b */
            public final InputSelect[] newArray(int i10) {
                return new InputSelect[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputSelect(String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            String str2;
            List<String> list;
            List<String> list2;
            List<Option> h10;
            String str3;
            List<Option> h11;
            j.g(str, "name");
            String str4 = null;
            this.f27884c = str;
            this.f27885d = attributes;
            this.f27886e = inputSelectComponentStyle;
            Attributes E = z();
            if (E != null) {
                str2 = E.g();
            } else {
                str2 = null;
            }
            this.f27888g = str2;
            Attributes E2 = z();
            this.f27889h = E2 != null ? E2.i() : str4;
            Attributes E3 = z();
            if (E3 == null || (h11 = E3.h()) == null) {
                list = q.j();
            } else {
                list = new ArrayList<>(r.t(h11, 10));
                for (Option a10 : h11) {
                    list.add(a10.a());
                }
            }
            this.f27890j = list;
            Attributes E4 = z();
            this.f27891k = com.squareup.workflow1.ui.m.a((E4 == null || (str3 = E4.j()) == null) ? "" : str3);
            Attributes E5 = z();
            if (!(E5 == null || (h10 = E5.h()) == null)) {
                ArrayList arrayList = new ArrayList();
                for (T next : h10) {
                    if (j.b(((Option) next).c(), z().j())) {
                        arrayList.add(next);
                    }
                }
                List<Option> s02 = CollectionsKt___CollectionsKt.s0(arrayList, 1);
                if (s02 != null) {
                    list2 = new ArrayList<>(r.t(s02, 10));
                    for (Option a11 : s02) {
                        list2.add(a11.a());
                    }
                    this.f27892l = list2;
                }
            }
            list2 = q.j();
            this.f27892l = list2;
        }

        public static /* synthetic */ InputSelect D(InputSelect inputSelect, String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputSelect.A();
            }
            if ((i10 & 2) != 0) {
                attributes = inputSelect.z();
            }
            if ((i10 & 4) != 0) {
                inputSelectComponentStyle = inputSelect.b();
            }
            return inputSelect.B(str, attributes, inputSelectComponentStyle);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27884c;
        }

        public final InputSelect B(String str, Attributes attributes, InputSelectComponentStyle inputSelectComponentStyle) {
            j.g(str, "name");
            return new InputSelect(str, attributes, inputSelectComponentStyle);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27885d;
        }

        public void F(List<String> list) {
            j.g(list, "<set-?>");
            this.f27892l = list;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27891k = kVar;
        }

        /* renamed from: H */
        public InputSelect k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.e(E, (String) null, str, (String) null, (String) null, (List) null, (JsonLogicBoolean) null, 61, (Object) null);
            } else {
                attributes = null;
            }
            InputSelect D = D(this, (String) null, attributes, (InputSelectComponentStyle) null, 5, (Object) null);
            D.G(a());
            D.F(p.e(str));
            return D;
        }

        public k a() {
            return this.f27891k;
        }

        public InputSelectComponentStyle b() {
            return this.f27886e;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputSelect)) {
                return false;
            }
            InputSelect inputSelect = (InputSelect) obj;
            return j.b(A(), inputSelect.A()) && j.b(z(), inputSelect.z()) && j.b(b(), inputSelect.b());
        }

        public String getLabel() {
            return this.f27888g;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            if (b() != null) {
                i10 = b().hashCode();
            }
            return hashCode + i10;
        }

        public boolean l() {
            return this.f27887f;
        }

        public List<String> p() {
            return this.f27890j;
        }

        public List<String> t() {
            return this.f27892l;
        }

        public String toString() {
            return "InputSelect(name=" + A() + ", attributes=" + z() + ", styles=" + b() + PropertyUtils.MAPPED_DELIM2;
        }

        public String w() {
            return this.f27889h;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27884c);
            Attributes attributes = this.f27885d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            InputSelectComponentStyle inputSelectComponentStyle = this.f27886e;
            if (inputSelectComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            inputSelectComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputSelectComponentStyle implements Parcelable {
        public static final Parcelable.Creator<InputSelectComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$InputMarginStyle f27902a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$TextBasedJustifyStyle f27903b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextFontFamilyStyle f27904c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextFontSizeStyle f27905d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextFontWeightStyle f27906e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextLetterSpacingStyle f27907f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextLineHeightStyle f27908g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$InputSelectTextColorStyle f27909h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$InputSelectBorderRadiusStyle f27910j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$InputSelectBorderWidthStyle f27911k;

        /* renamed from: l  reason: collision with root package name */
        private final AttributeStyles$InputSelectBackgroundColorStyle f27912l;

        /* renamed from: m  reason: collision with root package name */
        private final AttributeStyles$InputSelectBorderColorStyle f27913m;

        /* renamed from: n  reason: collision with root package name */
        private final AttributeStyles$InputSelectStrokeColorStyle f27914n;

        public static final class a implements Parcelable.Creator<InputSelectComponentStyle> {
            /* renamed from: a */
            public final InputSelectComponentStyle createFromParcel(Parcel parcel) {
                Parcel parcel2 = parcel;
                j.g(parcel2, "parcel");
                AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle = null;
                AttributeStyles$InputMarginStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$InputMarginStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$TextBasedJustifyStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$TextBasedJustifyStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextFontFamilyStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextFontFamilyStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextFontSizeStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextFontSizeStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextFontWeightStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextFontWeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextLetterSpacingStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextLetterSpacingStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextLineHeightStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextLineHeightStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectTextColorStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectTextColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectBorderRadiusStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectBorderRadiusStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectBorderWidthStyle createFromParcel10 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectBorderWidthStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectBackgroundColorStyle createFromParcel11 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectBackgroundColorStyle.CREATOR.createFromParcel(parcel2);
                AttributeStyles$InputSelectBorderColorStyle createFromParcel12 = parcel.readInt() == 0 ? null : AttributeStyles$InputSelectBorderColorStyle.CREATOR.createFromParcel(parcel2);
                if (parcel.readInt() != 0) {
                    attributeStyles$InputSelectStrokeColorStyle = AttributeStyles$InputSelectStrokeColorStyle.CREATOR.createFromParcel(parcel2);
                }
                return new InputSelectComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, attributeStyles$InputSelectStrokeColorStyle);
            }

            /* renamed from: b */
            public final InputSelectComponentStyle[] newArray(int i10) {
                return new InputSelectComponentStyle[i10];
            }
        }

        public InputSelectComponentStyle(AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle, AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle, AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle, AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle, AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle, AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle, AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle, AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle, AttributeStyles$InputSelectBorderRadiusStyle attributeStyles$InputSelectBorderRadiusStyle, AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle, AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle, AttributeStyles$InputSelectBorderColorStyle attributeStyles$InputSelectBorderColorStyle, AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle) {
            this.f27902a = attributeStyles$InputMarginStyle;
            this.f27903b = attributeStyles$TextBasedJustifyStyle;
            this.f27904c = attributeStyles$InputSelectTextFontFamilyStyle;
            this.f27905d = attributeStyles$InputSelectTextFontSizeStyle;
            this.f27906e = attributeStyles$InputSelectTextFontWeightStyle;
            this.f27907f = attributeStyles$InputSelectTextLetterSpacingStyle;
            this.f27908g = attributeStyles$InputSelectTextLineHeightStyle;
            this.f27909h = attributeStyles$InputSelectTextColorStyle;
            this.f27910j = attributeStyles$InputSelectBorderRadiusStyle;
            this.f27911k = attributeStyles$InputSelectBorderWidthStyle;
            this.f27912l = attributeStyles$InputSelectBackgroundColorStyle;
            this.f27913m = attributeStyles$InputSelectBorderColorStyle;
            this.f27914n = attributeStyles$InputSelectStrokeColorStyle;
        }

        public final String V1() {
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle = this.f27912l;
            if (attributeStyles$InputSelectBackgroundColorStyle == null || (a10 = attributeStyles$InputSelectBackgroundColorStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final AttributeStyles$InputSelectBackgroundColorStyle a() {
            return this.f27912l;
        }

        public final AttributeStyles$InputSelectBorderColorStyle c() {
            return this.f27913m;
        }

        public final String d() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputSelectBorderColorStyle attributeStyles$InputSelectBorderColorStyle = this.f27913m;
            if (attributeStyles$InputSelectBorderColorStyle == null || (a10 = attributeStyles$InputSelectBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public int describeContents() {
            return 0;
        }

        public final AttributeStyles$InputSelectBorderRadiusStyle e() {
            return this.f27910j;
        }

        public final Double f() {
            StyleElements.DPMeasurement a10;
            StyleElements.DPSize a11;
            AttributeStyles$InputSelectBorderRadiusStyle attributeStyles$InputSelectBorderRadiusStyle = this.f27910j;
            if (attributeStyles$InputSelectBorderRadiusStyle == null || (a10 = attributeStyles$InputSelectBorderRadiusStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final AttributeStyles$InputSelectBorderWidthStyle g() {
            return this.f27911k;
        }

        public final Double h() {
            StyleElements.DPMeasurementSet a10;
            StyleElements.DPSizeSet a11;
            StyleElements.DPSize a12;
            AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle = this.f27911k;
            if (attributeStyles$InputSelectBorderWidthStyle == null || (a10 = attributeStyles$InputSelectBorderWidthStyle.a()) == null || (a11 = a10.a()) == null || (a12 = a11.a()) == null) {
                return null;
            }
            return a12.a();
        }

        public final String i() {
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle = this.f27914n;
            if (attributeStyles$InputSelectStrokeColorStyle == null || (a10 = attributeStyles$InputSelectStrokeColorStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final TextBasedComponentStyle j() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = this.f27904c;
            StyleElements.SimpleElementColor simpleElementColor = null;
            if (attributeStyles$InputSelectTextFontFamilyStyle != null) {
                fontName = attributeStyles$InputSelectTextFontFamilyStyle.c();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = this.f27905d;
            if (attributeStyles$InputSelectTextFontSizeStyle != null) {
                dPMeasurement = attributeStyles$InputSelectTextFontSizeStyle.c();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = this.f27906e;
            if (attributeStyles$InputSelectTextFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$InputSelectTextFontWeightStyle.c();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = this.f27907f;
            if (attributeStyles$InputSelectTextLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$InputSelectTextLetterSpacingStyle.c();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = this.f27908g;
            if (attributeStyles$InputSelectTextLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$InputSelectTextLineHeightStyle.c();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = this.f27909h;
            if (attributeStyles$InputSelectTextColorStyle != null) {
                simpleElementColor = attributeStyles$InputSelectTextColorStyle.c();
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(simpleElementColor), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public final AttributeStyles$InputSelectTextFontFamilyStyle k() {
            return this.f27904c;
        }

        public final AttributeStyles$InputSelectTextFontSizeStyle l() {
            return this.f27905d;
        }

        public final AttributeStyles$InputSelectTextFontWeightStyle m() {
            return this.f27906e;
        }

        public final String n() {
            StyleElements.SimpleElementColor c10;
            StyleElements.SimpleElementColorValue a10;
            AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle = this.f27914n;
            if (attributeStyles$InputSelectStrokeColorStyle == null || (c10 = attributeStyles$InputSelectStrokeColorStyle.c()) == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final StyleElements.DPSizeSet o() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27902a;
            if (attributeStyles$InputMarginStyle == null || (a10 = attributeStyles$InputMarginStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final AttributeStyles$TextBasedJustifyStyle p() {
            return this.f27903b;
        }

        public final TextBasedComponentStyle q() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            StyleElements.SimpleElementColor d10;
            AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = this.f27904c;
            StyleElements.SimpleElementColor simpleElementColor = null;
            if (attributeStyles$InputSelectTextFontFamilyStyle == null || (fontName = attributeStyles$InputSelectTextFontFamilyStyle.d()) == null) {
                AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle2 = this.f27904c;
                if (attributeStyles$InputSelectTextFontFamilyStyle2 != null) {
                    fontName = attributeStyles$InputSelectTextFontFamilyStyle2.a();
                } else {
                    fontName = null;
                }
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = this.f27905d;
            if (attributeStyles$InputSelectTextFontSizeStyle != null) {
                dPMeasurement = attributeStyles$InputSelectTextFontSizeStyle.d();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = this.f27906e;
            if (attributeStyles$InputSelectTextFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$InputSelectTextFontWeightStyle.d();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = this.f27907f;
            if (attributeStyles$InputSelectTextLetterSpacingStyle == null || (dPMeasurement2 = attributeStyles$InputSelectTextLetterSpacingStyle.d()) == null) {
                AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle2 = this.f27907f;
                if (attributeStyles$InputSelectTextLetterSpacingStyle2 != null) {
                    dPMeasurement2 = attributeStyles$InputSelectTextLetterSpacingStyle2.a();
                } else {
                    dPMeasurement2 = null;
                }
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = this.f27908g;
            if (attributeStyles$InputSelectTextLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$InputSelectTextLineHeightStyle.d();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = this.f27909h;
            if (attributeStyles$InputSelectTextColorStyle == null || (d10 = attributeStyles$InputSelectTextColorStyle.d()) == null) {
                AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle2 = this.f27909h;
                if (attributeStyles$InputSelectTextColorStyle2 != null) {
                    simpleElementColor = attributeStyles$InputSelectTextColorStyle2.a();
                }
            } else {
                simpleElementColor = d10;
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(simpleElementColor), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public final AttributeStyles$InputSelectTextLetterSpacingStyle r() {
            return this.f27907f;
        }

        public final AttributeStyles$InputSelectTextLineHeightStyle s() {
            return this.f27908g;
        }

        public final AttributeStyles$InputMarginStyle t() {
            return this.f27902a;
        }

        public final AttributeStyles$InputSelectStrokeColorStyle u() {
            return this.f27914n;
        }

        public final TextBasedComponentStyle w() {
            StyleElements.DPMeasurementSet dPMeasurementSet;
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27902a;
            StyleElements.SimpleElementColor simpleElementColor = null;
            if (attributeStyles$InputMarginStyle != null) {
                dPMeasurementSet = attributeStyles$InputMarginStyle.c();
            } else {
                dPMeasurementSet = null;
            }
            AttributeStyles$TextBasedMarginStyle attributeStyles$TextBasedMarginStyle = new AttributeStyles$TextBasedMarginStyle(dPMeasurementSet);
            AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f27903b;
            AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = this.f27904c;
            if (attributeStyles$InputSelectTextFontFamilyStyle != null) {
                fontName = attributeStyles$InputSelectTextFontFamilyStyle.a();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = this.f27905d;
            if (attributeStyles$InputSelectTextFontSizeStyle != null) {
                dPMeasurement = attributeStyles$InputSelectTextFontSizeStyle.a();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = this.f27906e;
            if (attributeStyles$InputSelectTextFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$InputSelectTextFontWeightStyle.a();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = this.f27907f;
            if (attributeStyles$InputSelectTextLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$InputSelectTextLetterSpacingStyle.a();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = this.f27908g;
            if (attributeStyles$InputSelectTextLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$InputSelectTextLineHeightStyle.a();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = this.f27909h;
            if (attributeStyles$InputSelectTextColorStyle != null) {
                simpleElementColor = attributeStyles$InputSelectTextColorStyle.a();
            }
            return new TextBasedComponentStyle(attributeStyles$TextBasedMarginStyle, attributeStyles$TextBasedJustifyStyle, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(simpleElementColor), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27902a;
            if (attributeStyles$InputMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$TextBasedJustifyStyle attributeStyles$TextBasedJustifyStyle = this.f27903b;
            if (attributeStyles$TextBasedJustifyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$TextBasedJustifyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextFontFamilyStyle attributeStyles$InputSelectTextFontFamilyStyle = this.f27904c;
            if (attributeStyles$InputSelectTextFontFamilyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextFontFamilyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextFontSizeStyle attributeStyles$InputSelectTextFontSizeStyle = this.f27905d;
            if (attributeStyles$InputSelectTextFontSizeStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextFontSizeStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextFontWeightStyle attributeStyles$InputSelectTextFontWeightStyle = this.f27906e;
            if (attributeStyles$InputSelectTextFontWeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextFontWeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextLetterSpacingStyle attributeStyles$InputSelectTextLetterSpacingStyle = this.f27907f;
            if (attributeStyles$InputSelectTextLetterSpacingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextLetterSpacingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextLineHeightStyle attributeStyles$InputSelectTextLineHeightStyle = this.f27908g;
            if (attributeStyles$InputSelectTextLineHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextLineHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectTextColorStyle attributeStyles$InputSelectTextColorStyle = this.f27909h;
            if (attributeStyles$InputSelectTextColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectTextColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectBorderRadiusStyle attributeStyles$InputSelectBorderRadiusStyle = this.f27910j;
            if (attributeStyles$InputSelectBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle = this.f27911k;
            if (attributeStyles$InputSelectBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectBackgroundColorStyle attributeStyles$InputSelectBackgroundColorStyle = this.f27912l;
            if (attributeStyles$InputSelectBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectBorderColorStyle attributeStyles$InputSelectBorderColorStyle = this.f27913m;
            if (attributeStyles$InputSelectBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputSelectBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputSelectStrokeColorStyle attributeStyles$InputSelectStrokeColorStyle = this.f27914n;
            if (attributeStyles$InputSelectStrokeColorStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$InputSelectStrokeColorStyle.writeToParcel(parcel, i10);
        }

        public final AttributeStyles$InputSelectTextColorStyle x() {
            return this.f27909h;
        }

        public final Double z() {
            StyleElements.DPMeasurementSet a10;
            StyleElements.DPSizeSet a11;
            StyleElements.DPSize e10;
            AttributeStyles$InputSelectBorderWidthStyle attributeStyles$InputSelectBorderWidthStyle = this.f27911k;
            if (attributeStyles$InputSelectBorderWidthStyle == null || (a10 = attributeStyles$InputSelectBorderWidthStyle.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
                return null;
            }
            return e10.a();
        }
    }

    @i(generateAdapter = true)
    public static final class InputText extends UiComponent implements m<InputText> {
        public static final Parcelable.Creator<InputText> CREATOR = new b();

        /* renamed from: g  reason: collision with root package name */
        public static final a f27915g = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27916c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27917d;

        /* renamed from: e  reason: collision with root package name */
        private final InputTextBasedComponentStyle f27918e;

        /* renamed from: f  reason: collision with root package name */
        private k f27919f;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27920a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27921b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27922c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27923d;

            /* renamed from: e  reason: collision with root package name */
            private final InputType f27924e;

            /* renamed from: f  reason: collision with root package name */
            private final AutofillHint f27925f;

            /* renamed from: g  reason: collision with root package name */
            private final JsonLogicBoolean f27926g;

            /* renamed from: h  reason: collision with root package name */
            private final JsonLogicBoolean f27927h;

            /* renamed from: j  reason: collision with root package name */
            private final List<cj.a> f27928j = new ArrayList();

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    InputType valueOf = InputType.valueOf(parcel.readString());
                    JsonLogicBoolean jsonLogicBoolean = null;
                    AutofillHint valueOf2 = parcel.readInt() == 0 ? null : AutofillHint.valueOf(parcel.readString());
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, readString4, valueOf, valueOf2, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, String str2, String str3, String str4, InputType inputType, AutofillHint autofillHint, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(inputType, "inputType");
                this.f27920a = str;
                this.f27921b = str2;
                this.f27922c = str3;
                this.f27923d = str4;
                this.f27924e = inputType;
                this.f27925f = autofillHint;
                this.f27926g = jsonLogicBoolean;
                this.f27927h = jsonLogicBoolean2;
            }

            public static /* synthetic */ Attributes f(Attributes attributes, String str, String str2, String str3, String str4, InputType inputType, AutofillHint autofillHint, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, Object obj) {
                Attributes attributes2 = attributes;
                int i11 = i10;
                return attributes.e((i11 & 1) != 0 ? attributes2.f27920a : str, (i11 & 2) != 0 ? attributes2.f27921b : str2, (i11 & 4) != 0 ? attributes2.f27922c : str3, (i11 & 8) != 0 ? attributes2.f27923d : str4, (i11 & 16) != 0 ? attributes2.f27924e : inputType, (i11 & 32) != 0 ? attributes2.f27925f : autofillHint, (i11 & 64) != 0 ? attributes.c() : jsonLogicBoolean, (i11 & 128) != 0 ? attributes.d() : jsonLogicBoolean2);
            }

            public List<cj.a> a() {
                return this.f27928j;
            }

            public JsonLogicBoolean c() {
                return this.f27926g;
            }

            public JsonLogicBoolean d() {
                return this.f27927h;
            }

            public int describeContents() {
                return 0;
            }

            public final Attributes e(String str, String str2, String str3, String str4, InputType inputType, AutofillHint autofillHint, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(inputType, "inputType");
                return new Attributes(str, str2, str3, str4, inputType, autofillHint, jsonLogicBoolean, jsonLogicBoolean2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27920a, attributes.f27920a) && j.b(this.f27921b, attributes.f27921b) && j.b(this.f27922c, attributes.f27922c) && j.b(this.f27923d, attributes.f27923d) && this.f27924e == attributes.f27924e && this.f27925f == attributes.f27925f && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final AutofillHint g() {
                return this.f27925f;
            }

            public final String h() {
                return this.f27920a;
            }

            public int hashCode() {
                String str = this.f27920a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f27921b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27922c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f27923d;
                int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f27924e.hashCode()) * 31;
                AutofillHint autofillHint = this.f27925f;
                int hashCode5 = (((hashCode4 + (autofillHint == null ? 0 : autofillHint.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode5 + i10;
            }

            public final InputType i() {
                return this.f27924e;
            }

            public final String j() {
                return this.f27922c;
            }

            public final String k() {
                return this.f27923d;
            }

            public final String l() {
                return this.f27921b;
            }

            public String toString() {
                return "Attributes(field=" + this.f27920a + ", prefill=" + this.f27921b + ", label=" + this.f27922c + ", placeholder=" + this.f27923d + ", inputType=" + this.f27924e + ", autofillHint=" + this.f27925f + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27920a);
                parcel.writeString(this.f27921b);
                parcel.writeString(this.f27922c);
                parcel.writeString(this.f27923d);
                parcel.writeString(this.f27924e.name());
                AutofillHint autofillHint = this.f27925f;
                if (autofillHint == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeString(autofillHint.name());
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27926g;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27927h;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }
        }

        @i(generateAdapter = false)
        public enum AutofillHint {
            NAME,
            NAME_FIRST,
            NAME_MIDDLE,
            NAME_LAST,
            EMAIL,
            ADDRESS_LINE_1,
            ADDRESS_LINE_2,
            CITY,
            COUNTRY,
            POSTAL_CODE;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<AutofillHint> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, AutofillHint autofillHint) {
                    j.g(qVar, "writer");
                }

                @f
                public AutofillHint fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, "name")) {
                        return AutofillHint.NAME;
                    }
                    if (j.b(J, "name_first")) {
                        return AutofillHint.NAME_FIRST;
                    }
                    if (j.b(J, "name_middle")) {
                        return AutofillHint.NAME_MIDDLE;
                    }
                    if (j.b(J, "name_last")) {
                        return AutofillHint.NAME_LAST;
                    }
                    if (j.b(J, "email")) {
                        return AutofillHint.EMAIL;
                    }
                    if (j.b(J, "address_line_1")) {
                        return AutofillHint.ADDRESS_LINE_1;
                    }
                    if (j.b(J, "address_line_2")) {
                        return AutofillHint.ADDRESS_LINE_2;
                    }
                    if (j.b(J, Constants.Keys.CITY)) {
                        return AutofillHint.CITY;
                    }
                    if (j.b(J, "country")) {
                        return AutofillHint.COUNTRY;
                    }
                    if (j.b(J, "postal_code")) {
                        return AutofillHint.POSTAL_CODE;
                    }
                    return null;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        @i(generateAdapter = false)
        public enum InputType {
            TEXT,
            EMAIL,
            NUMBER_PAD;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<InputType> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, InputType inputType) {
                    j.g(qVar, "writer");
                }

                @f
                public InputType fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, "text")) {
                        return InputType.TEXT;
                    }
                    if (j.b(J, "email")) {
                        return InputType.EMAIL;
                    }
                    if (j.b(J, "number_pad")) {
                        return InputType.NUMBER_PAD;
                    }
                    return InputType.TEXT;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputText> {
            /* renamed from: a */
            public final InputText createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                InputTextBasedComponentStyle inputTextBasedComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    inputTextBasedComponentStyle = InputTextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new InputText(readString, createFromParcel, inputTextBasedComponentStyle);
            }

            /* renamed from: b */
            public final InputText[] newArray(int i10) {
                return new InputText[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
            r2 = r2.l();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InputText(java.lang.String r2, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.Attributes r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle r4) {
            /*
                r1 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.j.g(r2, r0)
                r0 = 0
                r1.<init>(r2, r0)
                r1.f27916c = r2
                r1.f27917d = r3
                r1.f27918e = r4
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$Attributes r2 = r1.z()
                if (r2 == 0) goto L_0x001b
                java.lang.String r2 = r2.l()
                if (r2 != 0) goto L_0x001d
            L_0x001b:
                java.lang.String r2 = ""
            L_0x001d:
                com.squareup.workflow1.ui.k r2 = com.squareup.workflow1.ui.m.a(r2)
                r1.f27919f = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputText.<init>(java.lang.String, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputText$Attributes, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$InputTextBasedComponentStyle):void");
        }

        public static /* synthetic */ InputText D(InputText inputText, String str, Attributes attributes, InputTextBasedComponentStyle inputTextBasedComponentStyle, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = inputText.A();
            }
            if ((i10 & 2) != 0) {
                attributes = inputText.z();
            }
            if ((i10 & 4) != 0) {
                inputTextBasedComponentStyle = inputText.f27918e;
            }
            return inputText.B(str, attributes, inputTextBasedComponentStyle);
        }

        @g(ignore = true)
        public static /* synthetic */ void getTextController$annotations() {
        }

        public String A() {
            return this.f27916c;
        }

        public final InputText B(String str, Attributes attributes, InputTextBasedComponentStyle inputTextBasedComponentStyle) {
            j.g(str, "name");
            return new InputText(str, attributes, inputTextBasedComponentStyle);
        }

        /* renamed from: E */
        public Attributes z() {
            return this.f27917d;
        }

        public final InputTextBasedComponentStyle F() {
            return this.f27918e;
        }

        public void G(k kVar) {
            j.g(kVar, "<set-?>");
            this.f27919f = kVar;
        }

        /* renamed from: H */
        public InputText k(String str) {
            Attributes attributes;
            j.g(str, "newString");
            Attributes E = z();
            if (E != null) {
                attributes = Attributes.f(E, (String) null, str, (String) null, (String) null, (InputType) null, (AutofillHint) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 253, (Object) null);
            } else {
                attributes = null;
            }
            InputText D = D(this, (String) null, attributes, (InputTextBasedComponentStyle) null, 5, (Object) null);
            D.G(a());
            return D;
        }

        public k a() {
            return this.f27919f;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InputText)) {
                return false;
            }
            InputText inputText = (InputText) obj;
            return j.b(A(), inputText.A()) && j.b(z(), inputText.z()) && j.b(this.f27918e, inputText.f27918e);
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode = ((A().hashCode() * 31) + (z() == null ? 0 : z().hashCode())) * 31;
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27918e;
            if (inputTextBasedComponentStyle != null) {
                i10 = inputTextBasedComponentStyle.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "InputText(name=" + A() + ", attributes=" + z() + ", styles=" + this.f27918e + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27916c);
            Attributes attributes = this.f27917d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            InputTextBasedComponentStyle inputTextBasedComponentStyle = this.f27918e;
            if (inputTextBasedComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            inputTextBasedComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class InputTextBasedComponentStyle implements Parcelable {
        public static final Parcelable.Creator<InputTextBasedComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$InputMarginStyle f27929a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontFamilyStyle f27930b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontSizeStyle f27931c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedFontWeightStyle f27932d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLetterSpacingStyle f27933e;

        /* renamed from: f  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedLineHeightStyle f27934f;

        /* renamed from: g  reason: collision with root package name */
        private final AttributeStyles$ComplexTextBasedTextColorStyle f27935g;

        /* renamed from: h  reason: collision with root package name */
        private final AttributeStyles$InputTextBorderRadiusStyle f27936h;

        /* renamed from: j  reason: collision with root package name */
        private final AttributeStyles$InputTextBorderWidthStyle f27937j;

        /* renamed from: k  reason: collision with root package name */
        private final AttributeStyles$InputTextBackgroundColorStyle f27938k;

        /* renamed from: l  reason: collision with root package name */
        private final AttributeStyles$InputTextBorderColorStyle f27939l;

        /* renamed from: m  reason: collision with root package name */
        private final AttributeStyles$InputTextStrokeColorStyle f27940m;

        public static final class a implements Parcelable.Creator<InputTextBasedComponentStyle> {
            /* renamed from: a */
            public final InputTextBasedComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = null;
                AttributeStyles$InputMarginStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$InputMarginStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedFontFamilyStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontFamilyStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedFontSizeStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontSizeStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedFontWeightStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedFontWeightStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedLetterSpacingStyle createFromParcel5 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLetterSpacingStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedLineHeightStyle createFromParcel6 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedLineHeightStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$ComplexTextBasedTextColorStyle createFromParcel7 = parcel.readInt() == 0 ? null : AttributeStyles$ComplexTextBasedTextColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$InputTextBorderRadiusStyle createFromParcel8 = parcel.readInt() == 0 ? null : AttributeStyles$InputTextBorderRadiusStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$InputTextBorderWidthStyle createFromParcel9 = parcel.readInt() == 0 ? null : AttributeStyles$InputTextBorderWidthStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$InputTextBackgroundColorStyle createFromParcel10 = parcel.readInt() == 0 ? null : AttributeStyles$InputTextBackgroundColorStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$InputTextBorderColorStyle createFromParcel11 = parcel.readInt() == 0 ? null : AttributeStyles$InputTextBorderColorStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$InputTextStrokeColorStyle = AttributeStyles$InputTextStrokeColorStyle.CREATOR.createFromParcel(parcel);
                }
                return new InputTextBasedComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, attributeStyles$InputTextStrokeColorStyle);
            }

            /* renamed from: b */
            public final InputTextBasedComponentStyle[] newArray(int i10) {
                return new InputTextBasedComponentStyle[i10];
            }
        }

        public InputTextBasedComponentStyle(AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle, AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle, AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle, AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle, AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle, AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle, AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle, AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle, AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle, AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle, AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle, AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle) {
            this.f27929a = attributeStyles$InputMarginStyle;
            this.f27930b = attributeStyles$ComplexTextBasedFontFamilyStyle;
            this.f27931c = attributeStyles$ComplexTextBasedFontSizeStyle;
            this.f27932d = attributeStyles$ComplexTextBasedFontWeightStyle;
            this.f27933e = attributeStyles$ComplexTextBasedLetterSpacingStyle;
            this.f27934f = attributeStyles$ComplexTextBasedLineHeightStyle;
            this.f27935g = attributeStyles$ComplexTextBasedTextColorStyle;
            this.f27936h = attributeStyles$InputTextBorderRadiusStyle;
            this.f27937j = attributeStyles$InputTextBorderWidthStyle;
            this.f27938k = attributeStyles$InputTextBackgroundColorStyle;
            this.f27939l = attributeStyles$InputTextBorderColorStyle;
            this.f27940m = attributeStyles$InputTextStrokeColorStyle;
        }

        public final String A() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = this.f27940m;
            if (attributeStyles$InputTextStrokeColorStyle == null || (a10 = attributeStyles$InputTextStrokeColorStyle.a()) == null) {
                return null;
            }
            return a10.f();
        }

        public final TextBasedComponentStyle B() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            StyleElements.DPMeasurement dPMeasurement3 = null;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
                fontName = attributeStyles$ComplexTextBasedFontFamilyStyle.f();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
                dPMeasurement = attributeStyles$ComplexTextBasedFontSizeStyle.e();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$ComplexTextBasedFontWeightStyle.e();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$ComplexTextBasedLetterSpacingStyle.f();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$ComplexTextBasedLineHeightStyle.e();
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3), new AttributeStyles$TextBasedTextColorStyle(new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(a0()))), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public final AttributeStyles$ComplexTextBasedFontFamilyStyle D() {
            return this.f27930b;
        }

        public final AttributeStyles$ComplexTextBasedFontSizeStyle E() {
            return this.f27931c;
        }

        public final AttributeStyles$ComplexTextBasedFontWeightStyle F() {
            return this.f27932d;
        }

        public final StyleElements.DPSizeSet G() {
            StyleElements.DPMeasurementSet a10;
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27929a;
            if (attributeStyles$InputMarginStyle == null || (a10 = attributeStyles$InputMarginStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String H() {
            StyleElements.ComplexElementColor c10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (c10 = attributeStyles$ComplexTextBasedTextColorStyle.c()) == null) {
                return null;
            }
            return c10.c();
        }

        public final String I() {
            StyleElements.ComplexElementColor c10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (c10 = attributeStyles$ComplexTextBasedTextColorStyle.c()) == null) {
                return null;
            }
            return c10.d();
        }

        public final String K() {
            StyleElements.ComplexElementColor c10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (c10 = attributeStyles$ComplexTextBasedTextColorStyle.c()) == null) {
                return null;
            }
            return c10.e();
        }

        public final String L() {
            StyleElements.ComplexElementColor c10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (c10 = attributeStyles$ComplexTextBasedTextColorStyle.c()) == null) {
                return null;
            }
            return c10.f();
        }

        public final TextBasedComponentStyle M() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            StyleElements.ComplexElementColor c10;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            String str = null;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
                fontName = attributeStyles$ComplexTextBasedFontFamilyStyle.d();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
                dPMeasurement = attributeStyles$ComplexTextBasedFontSizeStyle.c();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$ComplexTextBasedFontWeightStyle.c();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$ComplexTextBasedLetterSpacingStyle.d();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$ComplexTextBasedLineHeightStyle.c();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (!(attributeStyles$ComplexTextBasedTextColorStyle == null || (c10 = attributeStyles$ComplexTextBasedTextColorStyle.c()) == null)) {
                str = c10.c();
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(str))), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public final AttributeStyles$ComplexTextBasedLetterSpacingStyle O() {
            return this.f27933e;
        }

        public final AttributeStyles$ComplexTextBasedLineHeightStyle P() {
            return this.f27934f;
        }

        public final AttributeStyles$InputMarginStyle Q() {
            return this.f27929a;
        }

        public final String R() {
            StyleElements.ComplexElementColor d10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (d10 = attributeStyles$ComplexTextBasedTextColorStyle.d()) == null) {
                return null;
            }
            return d10.c();
        }

        public final String S() {
            StyleElements.ComplexElementColor d10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (d10 = attributeStyles$ComplexTextBasedTextColorStyle.d()) == null) {
                return null;
            }
            return d10.e();
        }

        public final String T() {
            StyleElements.ComplexElementColor d10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (d10 = attributeStyles$ComplexTextBasedTextColorStyle.d()) == null) {
                return null;
            }
            return d10.f();
        }

        public final TextBasedComponentStyle U() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            StyleElements.ComplexElementColor d10;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            String str = null;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
                fontName = attributeStyles$ComplexTextBasedFontFamilyStyle.e();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
                dPMeasurement = attributeStyles$ComplexTextBasedFontSizeStyle.d();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$ComplexTextBasedFontWeightStyle.d();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$ComplexTextBasedLetterSpacingStyle.e();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$ComplexTextBasedLineHeightStyle.d();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (!(attributeStyles$ComplexTextBasedTextColorStyle == null || (d10 = attributeStyles$ComplexTextBasedTextColorStyle.d()) == null)) {
                str = d10.c();
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(str))), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public final AttributeStyles$InputTextStrokeColorStyle V() {
            return this.f27940m;
        }

        public final AttributeStyles$ComplexTextBasedTextColorStyle W() {
            return this.f27935g;
        }

        public final String X() {
            StyleElements.ComplexElementColor e10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (e10 = attributeStyles$ComplexTextBasedTextColorStyle.e()) == null) {
                return null;
            }
            return e10.c();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.e()).d();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String Y() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedTextColorStyle r0 = r1.f27935g
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.e()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.d()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.X()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.Y():java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.e()).e();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String Z() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedTextColorStyle r0 = r1.f27935g
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.e()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.e()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.X()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.Z():java.lang.String");
        }

        public final AttributeStyles$InputTextBackgroundColorStyle a() {
            return this.f27938k;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.e()).f();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a0() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedTextColorStyle r0 = r1.f27935g
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.e()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.f()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.X()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.a0():java.lang.String");
        }

        public final String b0() {
            StyleElements.FontName f10;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle == null || (f10 = attributeStyles$ComplexTextBasedFontFamilyStyle.f()) == null) {
                return null;
            }
            return f10.a();
        }

        public final String c() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle = this.f27938k;
            if (attributeStyles$InputTextBackgroundColorStyle == null || (a10 = attributeStyles$InputTextBackgroundColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final Double c0() {
            StyleElements.DPMeasurement e10;
            StyleElements.DPSize a10;
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle == null || (e10 = attributeStyles$ComplexTextBasedFontSizeStyle.e()) == null || (a10 = e10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String d() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = this.f27939l;
            if (attributeStyles$InputTextBorderColorStyle == null || (a10 = attributeStyles$InputTextBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final StyleElements.FontWeight d0() {
            StyleElements.FontWeightContainer e10;
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle == null || (e10 = attributeStyles$ComplexTextBasedFontWeightStyle.e()) == null) {
                return null;
            }
            return e10.a();
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            StyleElements.FontName a10;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle == null || (a10 = attributeStyles$ComplexTextBasedFontFamilyStyle.a()) == null) {
                return null;
            }
            return a10.a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            r0 = (r0 = (r0 = r0.f()).a()).a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Double e0() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$ComplexTextBasedLetterSpacingStyle r0 = r1.f27933e
                if (r0 == 0) goto L_0x0016
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPMeasurement r0 = r0.f()
                if (r0 == 0) goto L_0x0016
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = r0.a()
                if (r0 == 0) goto L_0x0016
                java.lang.Double r0 = r0.a()
                if (r0 != 0) goto L_0x001a
            L_0x0016:
                java.lang.Double r0 = r1.f()
            L_0x001a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.e0():java.lang.Double");
        }

        public final Double f() {
            StyleElements.DPMeasurement a10;
            StyleElements.DPSize a11;
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle == null || (a10 = attributeStyles$ComplexTextBasedLetterSpacingStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final Double f0() {
            StyleElements.DPMeasurement e10;
            StyleElements.DPSize a10;
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle == null || (e10 = attributeStyles$ComplexTextBasedLineHeightStyle.e()) == null || (a10 = e10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String g() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = this.f27940m;
            if (attributeStyles$InputTextStrokeColorStyle == null || (a10 = attributeStyles$InputTextStrokeColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final AttributeStyles$InputTextBorderColorStyle h() {
            return this.f27939l;
        }

        public final AttributeStyles$InputTextBorderRadiusStyle i() {
            return this.f27936h;
        }

        public final Double j() {
            StyleElements.DPMeasurement a10;
            StyleElements.DPSize a11;
            AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle = this.f27936h;
            if (attributeStyles$InputTextBorderRadiusStyle == null || (a10 = attributeStyles$InputTextBorderRadiusStyle.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final AttributeStyles$InputTextBorderWidthStyle k() {
            return this.f27937j;
        }

        public final Double l() {
            StyleElements.DPMeasurementSet a10;
            StyleElements.DPSizeSet a11;
            StyleElements.DPSize e10;
            AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle = this.f27937j;
            if (attributeStyles$InputTextBorderWidthStyle == null || (a10 = attributeStyles$InputTextBorderWidthStyle.a()) == null || (a11 = a10.a()) == null || (e10 = a11.e()) == null) {
                return null;
            }
            return e10.a();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.a()).d();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String m() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBackgroundColorStyle r0 = r1.f27938k
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.d()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.c()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.m():java.lang.String");
        }

        public final String n() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = this.f27939l;
            if (attributeStyles$InputTextBorderColorStyle == null || (a10 = attributeStyles$InputTextBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.d();
        }

        public final String o() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = this.f27940m;
            if (attributeStyles$InputTextStrokeColorStyle == null || (a10 = attributeStyles$InputTextStrokeColorStyle.a()) == null) {
                return null;
            }
            return a10.d();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.a()).e();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String p() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBackgroundColorStyle r0 = r1.f27938k
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.e()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.c()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.p():java.lang.String");
        }

        public final String q() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (a10 = attributeStyles$ComplexTextBasedTextColorStyle.a()) == null) {
                return null;
            }
            return a10.c();
        }

        public final String r() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = this.f27939l;
            if (attributeStyles$InputTextBorderColorStyle == null || (a10 = attributeStyles$InputTextBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.e();
        }

        public final String s() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (a10 = attributeStyles$ComplexTextBasedTextColorStyle.a()) == null) {
                return null;
            }
            return a10.d();
        }

        public final String t() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (a10 = attributeStyles$ComplexTextBasedTextColorStyle.a()) == null) {
                return null;
            }
            return a10.e();
        }

        public final String u() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null || (a10 = attributeStyles$ComplexTextBasedTextColorStyle.a()) == null) {
                return null;
            }
            return a10.f();
        }

        public final TextBasedComponentStyle w() {
            StyleElements.FontName fontName;
            StyleElements.DPMeasurement dPMeasurement;
            StyleElements.FontWeightContainer fontWeightContainer;
            StyleElements.DPMeasurement dPMeasurement2;
            StyleElements.DPMeasurement dPMeasurement3;
            StyleElements.ComplexElementColor a10;
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            String str = null;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle != null) {
                fontName = attributeStyles$ComplexTextBasedFontFamilyStyle.c();
            } else {
                fontName = null;
            }
            AttributeStyles$TextBasedFontFamilyStyle attributeStyles$TextBasedFontFamilyStyle = new AttributeStyles$TextBasedFontFamilyStyle(fontName);
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle != null) {
                dPMeasurement = attributeStyles$ComplexTextBasedFontSizeStyle.a();
            } else {
                dPMeasurement = null;
            }
            AttributeStyles$TextBasedFontSizeStyle attributeStyles$TextBasedFontSizeStyle = new AttributeStyles$TextBasedFontSizeStyle(dPMeasurement);
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle != null) {
                fontWeightContainer = attributeStyles$ComplexTextBasedFontWeightStyle.a();
            } else {
                fontWeightContainer = null;
            }
            AttributeStyles$TextBasedFontWeightStyle attributeStyles$TextBasedFontWeightStyle = new AttributeStyles$TextBasedFontWeightStyle(fontWeightContainer);
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle != null) {
                dPMeasurement2 = attributeStyles$ComplexTextBasedLetterSpacingStyle.c();
            } else {
                dPMeasurement2 = null;
            }
            AttributeStyles$TextBasedLetterSpacingStyle attributeStyles$TextBasedLetterSpacingStyle = new AttributeStyles$TextBasedLetterSpacingStyle(dPMeasurement2);
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle != null) {
                dPMeasurement3 = attributeStyles$ComplexTextBasedLineHeightStyle.a();
            } else {
                dPMeasurement3 = null;
            }
            AttributeStyles$TextBasedLineHeightStyle attributeStyles$TextBasedLineHeightStyle = new AttributeStyles$TextBasedLineHeightStyle(dPMeasurement3);
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (!(attributeStyles$ComplexTextBasedTextColorStyle == null || (a10 = attributeStyles$ComplexTextBasedTextColorStyle.a()) == null)) {
                str = a10.c();
            }
            return new TextBasedComponentStyle((AttributeStyles$TextBasedMarginStyle) null, (AttributeStyles$TextBasedJustifyStyle) null, attributeStyles$TextBasedFontFamilyStyle, attributeStyles$TextBasedFontSizeStyle, attributeStyles$TextBasedFontWeightStyle, attributeStyles$TextBasedLetterSpacingStyle, attributeStyles$TextBasedLineHeightStyle, new AttributeStyles$TextBasedTextColorStyle(new StyleElements.SimpleElementColor(new StyleElements.SimpleElementColorValue(str))), (AttributeStyles$TextBasedTextColorStyle) null);
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$InputMarginStyle attributeStyles$InputMarginStyle = this.f27929a;
            if (attributeStyles$InputMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontFamilyStyle attributeStyles$ComplexTextBasedFontFamilyStyle = this.f27930b;
            if (attributeStyles$ComplexTextBasedFontFamilyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontFamilyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontSizeStyle attributeStyles$ComplexTextBasedFontSizeStyle = this.f27931c;
            if (attributeStyles$ComplexTextBasedFontSizeStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontSizeStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedFontWeightStyle attributeStyles$ComplexTextBasedFontWeightStyle = this.f27932d;
            if (attributeStyles$ComplexTextBasedFontWeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedFontWeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLetterSpacingStyle attributeStyles$ComplexTextBasedLetterSpacingStyle = this.f27933e;
            if (attributeStyles$ComplexTextBasedLetterSpacingStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLetterSpacingStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedLineHeightStyle attributeStyles$ComplexTextBasedLineHeightStyle = this.f27934f;
            if (attributeStyles$ComplexTextBasedLineHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedLineHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$ComplexTextBasedTextColorStyle attributeStyles$ComplexTextBasedTextColorStyle = this.f27935g;
            if (attributeStyles$ComplexTextBasedTextColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$ComplexTextBasedTextColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputTextBorderRadiusStyle attributeStyles$InputTextBorderRadiusStyle = this.f27936h;
            if (attributeStyles$InputTextBorderRadiusStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputTextBorderRadiusStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputTextBorderWidthStyle attributeStyles$InputTextBorderWidthStyle = this.f27937j;
            if (attributeStyles$InputTextBorderWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputTextBorderWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputTextBackgroundColorStyle attributeStyles$InputTextBackgroundColorStyle = this.f27938k;
            if (attributeStyles$InputTextBackgroundColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputTextBackgroundColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = this.f27939l;
            if (attributeStyles$InputTextBorderColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$InputTextBorderColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$InputTextStrokeColorStyle attributeStyles$InputTextStrokeColorStyle = this.f27940m;
            if (attributeStyles$InputTextStrokeColorStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$InputTextStrokeColorStyle.writeToParcel(parcel, i10);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = (r0 = r0.a()).f();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String x() {
            /*
                r1 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$InputTextBackgroundColorStyle r0 = r1.f27938k
                if (r0 == 0) goto L_0x0010
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r0 = r0.a()
                if (r0 == 0) goto L_0x0010
                java.lang.String r0 = r0.f()
                if (r0 != 0) goto L_0x0014
            L_0x0010:
                java.lang.String r0 = r1.c()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputTextBasedComponentStyle.x():java.lang.String");
        }

        public final String z() {
            StyleElements.ComplexElementColor a10;
            AttributeStyles$InputTextBorderColorStyle attributeStyles$InputTextBorderColorStyle = this.f27939l;
            if (attributeStyles$InputTextBorderColorStyle == null || (a10 = attributeStyles$InputTextBorderColorStyle.a()) == null) {
                return null;
            }
            return a10.f();
        }
    }

    @i(generateAdapter = true)
    public static final class LocalImage extends UiComponent {
        public static final Parcelable.Creator<LocalImage> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27941f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27942c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27943d;

        /* renamed from: e  reason: collision with root package name */
        private final LocalImageComponentStyle f27944e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final Image f27945a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Attributes(parcel.readInt() == 0 ? null : Image.valueOf(parcel.readString()));
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(Image image) {
                this.f27945a = image;
            }

            public final Image a() {
                return this.f27945a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                Image image = this.f27945a;
                if (image == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                parcel.writeString(image.name());
            }
        }

        @i(generateAdapter = false)
        public enum Image {
            START_HERO,
            DOCUMENT_START_HERO,
            ANIMATED_CHECK,
            FAILED,
            ID_FRONT_FAILED,
            ID_BACK_FAILED,
            SELFIE_FAILED,
            DOCUMENT_FAILED,
            PASSPORT_NFC_START_HERO,
            PASSPORT_NFC_SCAN_HERO,
            PASSPORT_NFC_SCAN_READY_HERO,
            PASSPORT_NFC_CHECK
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* access modifiers changed from: private */
            public static final h c(Type type, Set set, s sVar) {
                Class<Image> cls = Image.class;
                if (j.b(type, cls)) {
                    return ai.a.a(cls).d(null).nullSafe();
                }
                return null;
            }

            public final h.e b() {
                return new e();
            }
        }

        public static final class b implements Parcelable.Creator<LocalImage> {
            /* renamed from: a */
            public final LocalImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                LocalImageComponentStyle localImageComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    localImageComponentStyle = LocalImageComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new LocalImage(readString, createFromParcel, localImageComponentStyle);
            }

            /* renamed from: b */
            public final LocalImage[] newArray(int i10) {
                return new LocalImage[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LocalImage(String str, Attributes attributes, LocalImageComponentStyle localImageComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : localImageComponentStyle);
        }

        public String A() {
            return this.f27942c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27943d;
        }

        public final LocalImageComponentStyle D() {
            return this.f27944e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27942c);
            Attributes attributes = this.f27943d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            LocalImageComponentStyle localImageComponentStyle = this.f27944e;
            if (localImageComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            localImageComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocalImage(String str, Attributes attributes, LocalImageComponentStyle localImageComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27942c = str;
            this.f27943d = attributes;
            this.f27944e = localImageComponentStyle;
        }
    }

    @i(generateAdapter = true)
    public static final class PrivacyPolicy extends UiComponent {
        public static final Parcelable.Creator<PrivacyPolicy> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27946f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27947c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27948d;

        /* renamed from: e  reason: collision with root package name */
        private final TextBasedComponentStyle f27949e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27950a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Attributes(parcel.readString());
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str) {
                j.g(str, "text");
                this.f27950a = str;
            }

            public final String a() {
                return this.f27950a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27950a);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<PrivacyPolicy> {
            /* renamed from: a */
            public final PrivacyPolicy createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                TextBasedComponentStyle textBasedComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    textBasedComponentStyle = TextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new PrivacyPolicy(readString, createFromParcel, textBasedComponentStyle);
            }

            /* renamed from: b */
            public final PrivacyPolicy[] newArray(int i10) {
                return new PrivacyPolicy[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrivacyPolicy(String str, Attributes attributes, TextBasedComponentStyle textBasedComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27947c = str;
            this.f27948d = attributes;
            this.f27949e = textBasedComponentStyle;
        }

        public String A() {
            return this.f27947c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27948d;
        }

        public final TextBasedComponentStyle D() {
            return this.f27949e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27947c);
            Attributes attributes = this.f27948d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            TextBasedComponentStyle textBasedComponentStyle = this.f27949e;
            if (textBasedComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            textBasedComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class QRCode extends UiComponent {
        public static final Parcelable.Creator<QRCode> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27951f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27952c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27953d;

        /* renamed from: e  reason: collision with root package name */
        private final QRCodeComponentStyle f27954e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27955a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Attributes(parcel.readString());
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str) {
                this.f27955a = str;
            }

            public final String a() {
                return this.f27955a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27955a);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<QRCode> {
            /* renamed from: a */
            public final QRCode createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                QRCodeComponentStyle qRCodeComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    qRCodeComponentStyle = QRCodeComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new QRCode(readString, createFromParcel, qRCodeComponentStyle);
            }

            /* renamed from: b */
            public final QRCode[] newArray(int i10) {
                return new QRCode[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QRCode(String str, Attributes attributes, QRCodeComponentStyle qRCodeComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27952c = str;
            this.f27953d = attributes;
            this.f27954e = qRCodeComponentStyle;
        }

        public String A() {
            return this.f27952c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27953d;
        }

        public final String D() {
            AttributeStyles$QRCodeFillColorStyle a10;
            StyleElements.SimpleElementColor a11;
            StyleElements.SimpleElementColorValue a12;
            QRCodeComponentStyle qRCodeComponentStyle = this.f27954e;
            if (qRCodeComponentStyle == null || (a10 = qRCodeComponentStyle.a()) == null || (a11 = a10.a()) == null || (a12 = a11.a()) == null) {
                return null;
            }
            return a12.a();
        }

        public final StyleElements.PositionType E() {
            AttributeStyles$QRCodeJustifyStyle c10;
            StyleElements.Position a10;
            QRCodeComponentStyle qRCodeComponentStyle = this.f27954e;
            if (qRCodeComponentStyle == null || (c10 = qRCodeComponentStyle.c()) == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final StyleElements.DPSizeSet F() {
            AttributeStyles$QRCodeMarginStyle d10;
            StyleElements.DPMeasurementSet a10;
            QRCodeComponentStyle qRCodeComponentStyle = this.f27954e;
            if (qRCodeComponentStyle == null || (d10 = qRCodeComponentStyle.d()) == null || (a10 = d10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final String G() {
            AttributeStyles$QRCodeStrokeColorStyle e10;
            StyleElements.SimpleElementColor a10;
            StyleElements.SimpleElementColorValue a11;
            QRCodeComponentStyle qRCodeComponentStyle = this.f27954e;
            if (qRCodeComponentStyle == null || (e10 = qRCodeComponentStyle.e()) == null || (a10 = e10.a()) == null || (a11 = a10.a()) == null) {
                return null;
            }
            return a11.a();
        }

        public final QRCodeComponentStyle H() {
            return this.f27954e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
            r0 = (r0 = r0.f()).a();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int I() {
            /*
                r3 = this;
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$QRCodeComponentStyle r0 = r3.f27954e
                r1 = 0
                if (r0 == 0) goto L_0x0016
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeWidthStyle r0 = r0.f()
                if (r0 == 0) goto L_0x0016
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Measurement r0 = r0.a()
                if (r0 == 0) goto L_0x0016
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Size r0 = r0.a()
                goto L_0x0017
            L_0x0016:
                r0 = r1
            L_0x0017:
                boolean r2 = r0 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.DPSize
                if (r2 == 0) goto L_0x001e
                r1 = r0
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r1 = (com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.DPSize) r1
            L_0x001e:
                if (r1 == 0) goto L_0x002b
                java.lang.Double r0 = r1.a()
                if (r0 == 0) goto L_0x002b
                double r0 = r0.doubleValue()
                goto L_0x002d
            L_0x002b:
                r0 = 4638707616191610880(0x4060000000000000, double:128.0)
            L_0x002d:
                double r0 = ti.b.a(r0)
                int r0 = (int) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.QRCode.I():int");
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27952c);
            Attributes attributes = this.f27953d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            QRCodeComponentStyle qRCodeComponentStyle = this.f27954e;
            if (qRCodeComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            qRCodeComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class QRCodeComponentStyle implements Parcelable {
        public static final Parcelable.Creator<QRCodeComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$QRCodeWidthStyle f27956a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$QRCodeJustifyStyle f27957b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$QRCodeMarginStyle f27958c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$QRCodeStrokeColorStyle f27959d;

        /* renamed from: e  reason: collision with root package name */
        private final AttributeStyles$QRCodeFillColorStyle f27960e;

        public static final class a implements Parcelable.Creator<QRCodeComponentStyle> {
            /* renamed from: a */
            public final QRCodeComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$QRCodeFillColorStyle attributeStyles$QRCodeFillColorStyle = null;
                AttributeStyles$QRCodeWidthStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$QRCodeWidthStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$QRCodeJustifyStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$QRCodeJustifyStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$QRCodeMarginStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$QRCodeMarginStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$QRCodeStrokeColorStyle createFromParcel4 = parcel.readInt() == 0 ? null : AttributeStyles$QRCodeStrokeColorStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$QRCodeFillColorStyle = AttributeStyles$QRCodeFillColorStyle.CREATOR.createFromParcel(parcel);
                }
                return new QRCodeComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, attributeStyles$QRCodeFillColorStyle);
            }

            /* renamed from: b */
            public final QRCodeComponentStyle[] newArray(int i10) {
                return new QRCodeComponentStyle[i10];
            }
        }

        public QRCodeComponentStyle(AttributeStyles$QRCodeWidthStyle attributeStyles$QRCodeWidthStyle, AttributeStyles$QRCodeJustifyStyle attributeStyles$QRCodeJustifyStyle, AttributeStyles$QRCodeMarginStyle attributeStyles$QRCodeMarginStyle, AttributeStyles$QRCodeStrokeColorStyle attributeStyles$QRCodeStrokeColorStyle, AttributeStyles$QRCodeFillColorStyle attributeStyles$QRCodeFillColorStyle) {
            this.f27956a = attributeStyles$QRCodeWidthStyle;
            this.f27957b = attributeStyles$QRCodeJustifyStyle;
            this.f27958c = attributeStyles$QRCodeMarginStyle;
            this.f27959d = attributeStyles$QRCodeStrokeColorStyle;
            this.f27960e = attributeStyles$QRCodeFillColorStyle;
        }

        public final AttributeStyles$QRCodeFillColorStyle a() {
            return this.f27960e;
        }

        public final AttributeStyles$QRCodeJustifyStyle c() {
            return this.f27957b;
        }

        public final AttributeStyles$QRCodeMarginStyle d() {
            return this.f27958c;
        }

        public int describeContents() {
            return 0;
        }

        public final AttributeStyles$QRCodeStrokeColorStyle e() {
            return this.f27959d;
        }

        public final AttributeStyles$QRCodeWidthStyle f() {
            return this.f27956a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$QRCodeWidthStyle attributeStyles$QRCodeWidthStyle = this.f27956a;
            if (attributeStyles$QRCodeWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$QRCodeWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$QRCodeJustifyStyle attributeStyles$QRCodeJustifyStyle = this.f27957b;
            if (attributeStyles$QRCodeJustifyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$QRCodeJustifyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$QRCodeMarginStyle attributeStyles$QRCodeMarginStyle = this.f27958c;
            if (attributeStyles$QRCodeMarginStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$QRCodeMarginStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$QRCodeStrokeColorStyle attributeStyles$QRCodeStrokeColorStyle = this.f27959d;
            if (attributeStyles$QRCodeStrokeColorStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$QRCodeStrokeColorStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$QRCodeFillColorStyle attributeStyles$QRCodeFillColorStyle = this.f27960e;
            if (attributeStyles$QRCodeFillColorStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$QRCodeFillColorStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class RemoteImageComponentStyle implements Parcelable {
        public static final Parcelable.Creator<RemoteImageComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$RemoteImageHeightStyle f27973a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$RemoteImageWidthStyle f27974b;

        /* renamed from: c  reason: collision with root package name */
        private final AttributeStyles$RemoteImageJustifyStyle f27975c;

        /* renamed from: d  reason: collision with root package name */
        private final AttributeStyles$RemoteImageMarginStyle f27976d;

        public static final class a implements Parcelable.Creator<RemoteImageComponentStyle> {
            /* renamed from: a */
            public final RemoteImageComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = null;
                AttributeStyles$RemoteImageHeightStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageHeightStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$RemoteImageWidthStyle createFromParcel2 = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageWidthStyle.CREATOR.createFromParcel(parcel);
                AttributeStyles$RemoteImageJustifyStyle createFromParcel3 = parcel.readInt() == 0 ? null : AttributeStyles$RemoteImageJustifyStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$RemoteImageMarginStyle = AttributeStyles$RemoteImageMarginStyle.CREATOR.createFromParcel(parcel);
                }
                return new RemoteImageComponentStyle(createFromParcel, createFromParcel2, createFromParcel3, attributeStyles$RemoteImageMarginStyle);
            }

            /* renamed from: b */
            public final RemoteImageComponentStyle[] newArray(int i10) {
                return new RemoteImageComponentStyle[i10];
            }
        }

        public RemoteImageComponentStyle(AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle, AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle, AttributeStyles$RemoteImageJustifyStyle attributeStyles$RemoteImageJustifyStyle, AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle) {
            this.f27973a = attributeStyles$RemoteImageHeightStyle;
            this.f27974b = attributeStyles$RemoteImageWidthStyle;
            this.f27975c = attributeStyles$RemoteImageJustifyStyle;
            this.f27976d = attributeStyles$RemoteImageMarginStyle;
        }

        public final AttributeStyles$RemoteImageHeightStyle a() {
            return this.f27973a;
        }

        public final AttributeStyles$RemoteImageJustifyStyle c() {
            return this.f27975c;
        }

        public final AttributeStyles$RemoteImageMarginStyle d() {
            return this.f27976d;
        }

        public int describeContents() {
            return 0;
        }

        public final AttributeStyles$RemoteImageWidthStyle e() {
            return this.f27974b;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle = this.f27973a;
            if (attributeStyles$RemoteImageHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$RemoteImageHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle = this.f27974b;
            if (attributeStyles$RemoteImageWidthStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$RemoteImageWidthStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$RemoteImageJustifyStyle attributeStyles$RemoteImageJustifyStyle = this.f27975c;
            if (attributeStyles$RemoteImageJustifyStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$RemoteImageJustifyStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = this.f27976d;
            if (attributeStyles$RemoteImageMarginStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$RemoteImageMarginStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class Spacer extends UiComponent {
        public static final Parcelable.Creator<Spacer> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27977f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27978c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27979d;

        /* renamed from: e  reason: collision with root package name */
        private final SpacerComponentStyle f27980e;

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27981a;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new Attributes(parcel.readString());
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str) {
                this.f27981a = str;
            }

            public final String a() {
                return this.f27981a;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27981a);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<Spacer> {
            /* renamed from: a */
            public final Spacer createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                SpacerComponentStyle spacerComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    spacerComponentStyle = SpacerComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new Spacer(readString, createFromParcel, spacerComponentStyle);
            }

            /* renamed from: b */
            public final Spacer[] newArray(int i10) {
                return new Spacer[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Spacer(String str, Attributes attributes, SpacerComponentStyle spacerComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27978c = str;
            this.f27979d = attributes;
            this.f27980e = spacerComponentStyle;
        }

        public String A() {
            return this.f27978c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27979d;
        }

        public final int D() {
            String a10;
            String v02;
            Integer j10;
            AttributeStyles$SpacerHeightStyle a11;
            StyleElements.DPMeasurement a12;
            StyleElements.DPSize a13;
            Double a14;
            SpacerComponentStyle spacerComponentStyle = this.f27980e;
            if (spacerComponentStyle != null && (a11 = spacerComponentStyle.a()) != null && (a12 = a11.a()) != null && (a13 = a12.a()) != null && (a14 = a13.a()) != null) {
                return (int) ti.b.a(a14.doubleValue());
            }
            Attributes B = z();
            if (B == null || (a10 = B.a()) == null || (v02 = StringsKt__StringsKt.v0(a10, "px")) == null || (j10 = q.j(v02)) == null) {
                return 1;
            }
            return j10.intValue();
        }

        public final SpacerComponentStyle E() {
            return this.f27980e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27978c);
            Attributes attributes = this.f27979d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            SpacerComponentStyle spacerComponentStyle = this.f27980e;
            if (spacerComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            spacerComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class SpacerComponentStyle implements Parcelable {
        public static final Parcelable.Creator<SpacerComponentStyle> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final AttributeStyles$SpacerHeightStyle f27982a;

        /* renamed from: b  reason: collision with root package name */
        private final AttributeStyles$SpacerWidthStyle f27983b;

        public static final class a implements Parcelable.Creator<SpacerComponentStyle> {
            /* renamed from: a */
            public final SpacerComponentStyle createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                AttributeStyles$SpacerWidthStyle attributeStyles$SpacerWidthStyle = null;
                AttributeStyles$SpacerHeightStyle createFromParcel = parcel.readInt() == 0 ? null : AttributeStyles$SpacerHeightStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributeStyles$SpacerWidthStyle = AttributeStyles$SpacerWidthStyle.CREATOR.createFromParcel(parcel);
                }
                return new SpacerComponentStyle(createFromParcel, attributeStyles$SpacerWidthStyle);
            }

            /* renamed from: b */
            public final SpacerComponentStyle[] newArray(int i10) {
                return new SpacerComponentStyle[i10];
            }
        }

        public SpacerComponentStyle(AttributeStyles$SpacerHeightStyle attributeStyles$SpacerHeightStyle, AttributeStyles$SpacerWidthStyle attributeStyles$SpacerWidthStyle) {
            this.f27982a = attributeStyles$SpacerHeightStyle;
            this.f27983b = attributeStyles$SpacerWidthStyle;
        }

        public final AttributeStyles$SpacerHeightStyle a() {
            return this.f27982a;
        }

        public final AttributeStyles$SpacerWidthStyle c() {
            return this.f27983b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            AttributeStyles$SpacerHeightStyle attributeStyles$SpacerHeightStyle = this.f27982a;
            if (attributeStyles$SpacerHeightStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributeStyles$SpacerHeightStyle.writeToParcel(parcel, i10);
            }
            AttributeStyles$SpacerWidthStyle attributeStyles$SpacerWidthStyle = this.f27983b;
            if (attributeStyles$SpacerWidthStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributeStyles$SpacerWidthStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class SubmitButton extends Button {
        public static final Parcelable.Creator<SubmitButton> CREATOR = new b();

        /* renamed from: j  reason: collision with root package name */
        public static final a f27984j = new a((DefaultConstructorMarker) null);

        /* renamed from: f  reason: collision with root package name */
        private final String f27985f;

        /* renamed from: g  reason: collision with root package name */
        private final Button.Attributes f27986g;

        /* renamed from: h  reason: collision with root package name */
        private final ButtonSubmitComponentStyle f27987h;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<SubmitButton> {
            /* renamed from: a */
            public final SubmitButton createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                ButtonSubmitComponentStyle buttonSubmitComponentStyle = null;
                Button.Attributes createFromParcel = parcel.readInt() == 0 ? null : Button.Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    buttonSubmitComponentStyle = ButtonSubmitComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new SubmitButton(readString, createFromParcel, buttonSubmitComponentStyle);
            }

            /* renamed from: b */
            public final SubmitButton[] newArray(int i10) {
                return new SubmitButton[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SubmitButton(String str, Button.Attributes attributes, ButtonSubmitComponentStyle buttonSubmitComponentStyle) {
            super(str, attributes, buttonSubmitComponentStyle);
            j.g(str, "name");
            this.f27985f = str;
            this.f27986g = attributes;
            this.f27987h = buttonSubmitComponentStyle;
        }

        public String A() {
            return this.f27985f;
        }

        /* renamed from: B */
        public Button.Attributes z() {
            return this.f27986g;
        }

        /* renamed from: E */
        public ButtonSubmitComponentStyle D() {
            return this.f27987h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27985f);
            Button.Attributes attributes = this.f27986g;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            ButtonSubmitComponentStyle buttonSubmitComponentStyle = this.f27987h;
            if (buttonSubmitComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            buttonSubmitComponentStyle.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class Text extends UiComponent {
        public static final Parcelable.Creator<Text> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27988f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27989c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27990d;

        /* renamed from: e  reason: collision with root package name */
        private final TextBasedComponentStyle f27991e;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<Text> {
            /* renamed from: a */
            public final Text createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                TextBasedComponentStyle textBasedComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    textBasedComponentStyle = TextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new Text(readString, createFromParcel, textBasedComponentStyle);
            }

            /* renamed from: b */
            public final Text[] newArray(int i10) {
                return new Text[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Text(String str, Attributes attributes, TextBasedComponentStyle textBasedComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : textBasedComponentStyle);
        }

        public String A() {
            return this.f27989c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27990d;
        }

        public final TextBasedComponentStyle D() {
            return this.f27991e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27989c);
            Attributes attributes = this.f27990d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            TextBasedComponentStyle textBasedComponentStyle = this.f27991e;
            if (textBasedComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            textBasedComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(String str, Attributes attributes, TextBasedComponentStyle textBasedComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27989c = str;
            this.f27990d = attributes;
            this.f27991e = textBasedComponentStyle;
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27992a;

            /* renamed from: b  reason: collision with root package name */
            private final JsonLogicBoolean f27993b;

            /* renamed from: c  reason: collision with root package name */
            private final JsonLogicBoolean f27994c;

            /* renamed from: d  reason: collision with root package name */
            private final List<cj.a> f27995d;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(str, "text");
                this.f27992a = str;
                this.f27993b = jsonLogicBoolean;
                this.f27994c = jsonLogicBoolean2;
                this.f27995d = new ArrayList();
            }

            public List<cj.a> a() {
                return this.f27995d;
            }

            public JsonLogicBoolean c() {
                return this.f27993b;
            }

            public JsonLogicBoolean d() {
                return this.f27994c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f27992a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27992a);
                JsonLogicBoolean jsonLogicBoolean = this.f27993b;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27994c;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Attributes(String str, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i10 & 2) != 0 ? null : jsonLogicBoolean, (i10 & 4) != 0 ? null : jsonLogicBoolean2);
            }
        }
    }

    @i(generateAdapter = true)
    public static final class Title extends UiComponent {
        public static final Parcelable.Creator<Title> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27996f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27997c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27998d;

        /* renamed from: e  reason: collision with root package name */
        private final TextBasedComponentStyle f27999e;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<Title> {
            /* renamed from: a */
            public final Title createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                TextBasedComponentStyle textBasedComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    textBasedComponentStyle = TextBasedComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new Title(readString, createFromParcel, textBasedComponentStyle);
            }

            /* renamed from: b */
            public final Title[] newArray(int i10) {
                return new Title[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Title(String str, Attributes attributes, TextBasedComponentStyle textBasedComponentStyle, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, attributes, (i10 & 4) != 0 ? null : textBasedComponentStyle);
        }

        public String A() {
            return this.f27997c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27998d;
        }

        public final TextBasedComponentStyle D() {
            return this.f27999e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27997c);
            Attributes attributes = this.f27998d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            TextBasedComponentStyle textBasedComponentStyle = this.f27999e;
            if (textBasedComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            textBasedComponentStyle.writeToParcel(parcel, i10);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Title(String str, Attributes attributes, TextBasedComponentStyle textBasedComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27997c = str;
            this.f27998d = attributes;
            this.f27999e = textBasedComponentStyle;
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f28000a;

            /* renamed from: b  reason: collision with root package name */
            private final JsonLogicBoolean f28001b;

            /* renamed from: c  reason: collision with root package name */
            private final JsonLogicBoolean f28002c;

            /* renamed from: d  reason: collision with root package name */
            private final List<cj.a> f28003d;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(str, "text");
                this.f28000a = str;
                this.f28001b = jsonLogicBoolean;
                this.f28002c = jsonLogicBoolean2;
                this.f28003d = new ArrayList();
            }

            public List<cj.a> a() {
                return this.f28003d;
            }

            public JsonLogicBoolean c() {
                return this.f28001b;
            }

            public JsonLogicBoolean d() {
                return this.f28002c;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f28000a;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f28000a);
                JsonLogicBoolean jsonLogicBoolean = this.f28001b;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f28002c;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Attributes(String str, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i10 & 2) != 0 ? null : jsonLogicBoolean, (i10 & 4) != 0 ? null : jsonLogicBoolean2);
            }
        }
    }

    public static final class Unknown extends UiComponent {
        public static final Parcelable.Creator<Unknown> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final Unknown f28004c = new Unknown();

        public static final class a implements Parcelable.Creator<Unknown> {
            /* renamed from: a */
            public final Unknown createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                parcel.readInt();
                return Unknown.f28004c;
            }

            /* renamed from: b */
            public final Unknown[] newArray(int i10) {
                return new Unknown[i10];
            }
        }

        private Unknown() {
            super("unknown", (DefaultConstructorMarker) null);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(1);
        }

        public UiComponentAttributes z() {
            return null;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.e a() {
            b<UiComponent> e10 = b.b(UiComponent.class, "type").c(Unknown.f28004c).e(Text.class, "text").e(Title.class, "title").e(PrivacyPolicy.class, "privacy_policy").e(LocalImage.class, "image_local").e(RemoteImage.class, "image_remote").e(CompleteButton.class, "button_complete").e(SubmitButton.class, "button_submit").e(ActionButton.class, "button_action").e(CancelButton.class, "button_cancel").e(CombinedStepButton.class, "combined_step/button").e(Footer.class, "footer").e(Branding.class, "persona_branding").e(InputText.class, "input_text").e(InputDate.class, "input_date").e(InputSelect.class, "input_select").e(InputMultiSelect.class, "input_multi_select").e(Spacer.class, "spacer").e(InputMaskedText.class, "input_masked_text").e(HorizontalStack.class, "horizontal_stack").e(InputAddress.class, "input_address").e(InputPhoneNumber.class, "input_phone_number").e(InputConfirmationCode.class, "input_confirmation_code").e(ClickableStack.class, "clickable_stack").e(InputCheckbox.class, "input_checkbox").e(InputNumber.class, "input_number").e(QRCode.class, "qr_code").e(CombinedStepImagePreview.class, "combined_step/image_preview").e(ESignature.class, "input_e_signature").e(InputRadioGroup.class, "input_radio_group");
            j.f(e10, "of(UiComponent::class.ja…va, InputRadioGroup.type)");
            return e10;
        }
    }

    private UiComponent(String str) {
        this.f27605a = str;
    }

    public /* synthetic */ UiComponent(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String A() {
        return this.f27605a;
    }

    public abstract UiComponentAttributes z();

    public static abstract class Button extends UiComponent {

        /* renamed from: c  reason: collision with root package name */
        private final String f27614c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27615d;

        /* renamed from: e  reason: collision with root package name */
        private final com.withpersona.sdk2.inquiry.steps.ui.network.styling.a f27616e;

        @i(generateAdapter = false)
        public enum ButtonType {
            PRIMARY,
            SECONDARY;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<ButtonType> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, ButtonType buttonType) {
                    j.g(qVar, "writer");
                }

                @f
                public ButtonType fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, "primary")) {
                        return ButtonType.PRIMARY;
                    }
                    if (j.b(J, "secondary")) {
                        return ButtonType.SECONDARY;
                    }
                    return ButtonType.PRIMARY;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Button(String str, Attributes attributes, com.withpersona.sdk2.inquiry.steps.ui.network.styling.a aVar) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27614c = str;
            this.f27615d = attributes;
            this.f27616e = aVar;
        }

        public String A() {
            return this.f27614c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27615d;
        }

        public com.withpersona.sdk2.inquiry.steps.ui.network.styling.a D() {
            return this.f27616e;
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27617a;

            /* renamed from: b  reason: collision with root package name */
            private final ButtonType f27618b;

            /* renamed from: c  reason: collision with root package name */
            private final JsonLogicBoolean f27619c;

            /* renamed from: d  reason: collision with root package name */
            private final JsonLogicBoolean f27620d;

            /* renamed from: e  reason: collision with root package name */
            private final List<cj.a> f27621e;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    ButtonType valueOf = parcel.readInt() == 0 ? null : ButtonType.valueOf(parcel.readString());
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, valueOf, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, ButtonType buttonType, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                j.g(str, "text");
                this.f27617a = str;
                this.f27618b = buttonType;
                this.f27619c = jsonLogicBoolean;
                this.f27620d = jsonLogicBoolean2;
                this.f27621e = new ArrayList();
            }

            public List<cj.a> a() {
                return this.f27621e;
            }

            public JsonLogicBoolean c() {
                return this.f27619c;
            }

            public JsonLogicBoolean d() {
                return this.f27620d;
            }

            public int describeContents() {
                return 0;
            }

            public final ButtonType e() {
                return this.f27618b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27617a, attributes.f27617a) && this.f27618b == attributes.f27618b && j.b(c(), attributes.c()) && j.b(d(), attributes.d());
            }

            public final String f() {
                return this.f27617a;
            }

            public int hashCode() {
                int hashCode = this.f27617a.hashCode() * 31;
                ButtonType buttonType = this.f27618b;
                int i10 = 0;
                int hashCode2 = (((hashCode + (buttonType == null ? 0 : buttonType.hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (d() != null) {
                    i10 = d().hashCode();
                }
                return hashCode2 + i10;
            }

            public String toString() {
                return "Attributes(text=" + this.f27617a + ", buttonType=" + this.f27618b + ", hidden=" + c() + ", disabled=" + d() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27617a);
                ButtonType buttonType = this.f27618b;
                if (buttonType == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeString(buttonType.name());
                }
                JsonLogicBoolean jsonLogicBoolean = this.f27619c;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27620d;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Attributes(String str, ButtonType buttonType, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, buttonType, (i10 & 4) != 0 ? null : jsonLogicBoolean, (i10 & 8) != 0 ? null : jsonLogicBoolean2);
            }
        }
    }

    @i(generateAdapter = true)
    public static final class RemoteImage extends UiComponent {
        public static final Parcelable.Creator<RemoteImage> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27961f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27962c;

        /* renamed from: d  reason: collision with root package name */
        private final Attributes f27963d;

        /* renamed from: e  reason: collision with root package name */
        private final RemoteImageComponentStyle f27964e;

        @i(generateAdapter = false)
        public enum ContentType {
            JSON,
            SVG,
            Image;
            
            public static final Companion Companion = null;

            public static final class Companion extends h<ContentType> {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @v
                public void toJson(q qVar, ContentType contentType) {
                    j.g(qVar, "writer");
                }

                @f
                public ContentType fromJson(JsonReader jsonReader) {
                    j.g(jsonReader, "reader");
                    Object J = jsonReader.J();
                    if (j.b(J, "application/json")) {
                        return ContentType.JSON;
                    }
                    if (j.b(J, "image/svg+xml")) {
                        return ContentType.SVG;
                    }
                    return ContentType.Image;
                }
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
            }
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<RemoteImage> {
            /* renamed from: a */
            public final RemoteImage createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                RemoteImageComponentStyle remoteImageComponentStyle = null;
                Attributes createFromParcel = parcel.readInt() == 0 ? null : Attributes.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    remoteImageComponentStyle = RemoteImageComponentStyle.CREATOR.createFromParcel(parcel);
                }
                return new RemoteImage(readString, createFromParcel, remoteImageComponentStyle);
            }

            /* renamed from: b */
            public final RemoteImage[] newArray(int i10) {
                return new RemoteImage[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RemoteImage(String str, Attributes attributes, RemoteImageComponentStyle remoteImageComponentStyle) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27962c = str;
            this.f27963d = attributes;
            this.f27964e = remoteImageComponentStyle;
        }

        public String A() {
            return this.f27962c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27963d;
        }

        public final StyleElements.Size D() {
            String e10;
            String D;
            AttributeStyles$RemoteImageHeightStyle a10;
            StyleElements.Measurement a11;
            StyleElements.Size a12;
            RemoteImageComponentStyle remoteImageComponentStyle = this.f27964e;
            if (remoteImageComponentStyle != null && (a10 = remoteImageComponentStyle.a()) != null && (a11 = a10.a()) != null && (a12 = a11.a()) != null) {
                return a12;
            }
            Attributes B = z();
            if (B == null || (e10 = B.e()) == null || (D = r.D(e10, "px", "", false, 4, (Object) null)) == null) {
                return null;
            }
            return new StyleElements.DPSize(Double.valueOf(Double.parseDouble(D)));
        }

        public final StyleElements.PositionType E() {
            AttributeStyles$RemoteImageJustifyStyle c10;
            StyleElements.Position a10;
            RemoteImageComponentStyle remoteImageComponentStyle = this.f27964e;
            if (remoteImageComponentStyle == null || (c10 = remoteImageComponentStyle.c()) == null || (a10 = c10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final StyleElements.DPSizeSet F() {
            AttributeStyles$RemoteImageMarginStyle d10;
            StyleElements.DPMeasurementSet a10;
            RemoteImageComponentStyle remoteImageComponentStyle = this.f27964e;
            if (remoteImageComponentStyle == null || (d10 = remoteImageComponentStyle.d()) == null || (a10 = d10.a()) == null) {
                return null;
            }
            return a10.a();
        }

        public final RemoteImageComponentStyle G() {
            return this.f27964e;
        }

        public final StyleElements.Size H() {
            String i10;
            String D;
            AttributeStyles$RemoteImageWidthStyle e10;
            StyleElements.Measurement a10;
            StyleElements.Size a11;
            RemoteImageComponentStyle remoteImageComponentStyle = this.f27964e;
            if (remoteImageComponentStyle != null && (e10 = remoteImageComponentStyle.e()) != null && (a10 = e10.a()) != null && (a11 = a10.a()) != null) {
                return a11;
            }
            Attributes B = z();
            if (B == null || (i10 = B.i()) == null || (D = r.D(i10, "px", "", false, 4, (Object) null)) == null) {
                return null;
            }
            return new StyleElements.DPSize(Double.valueOf(Double.parseDouble(D)));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27962c);
            Attributes attributes = this.f27963d;
            if (attributes == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                attributes.writeToParcel(parcel, i10);
            }
            RemoteImageComponentStyle remoteImageComponentStyle = this.f27964e;
            if (remoteImageComponentStyle == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            remoteImageComponentStyle.writeToParcel(parcel, i10);
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27965a;

            /* renamed from: b  reason: collision with root package name */
            private final ContentType f27966b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27967c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27968d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27969e;

            /* renamed from: f  reason: collision with root package name */
            private final ContentType f27970f;

            /* renamed from: g  reason: collision with root package name */
            private final JsonLogicBoolean f27971g;

            /* renamed from: h  reason: collision with root package name */
            private final List<cj.a> f27972h;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    ContentType valueOf = parcel.readInt() == 0 ? null : ContentType.valueOf(parcel.readString());
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    ContentType valueOf2 = ContentType.valueOf(parcel.readString());
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, valueOf, readString2, readString3, readString4, valueOf2, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes(String str, ContentType contentType, String str2, String str3, String str4, ContentType contentType2, JsonLogicBoolean jsonLogicBoolean) {
                j.g(str2, "url");
                j.g(contentType2, "contentType");
                this.f27965a = str;
                this.f27966b = contentType;
                this.f27967c = str2;
                this.f27968d = str3;
                this.f27969e = str4;
                this.f27970f = contentType2;
                this.f27971g = jsonLogicBoolean;
                this.f27972h = new ArrayList();
            }

            public List<cj.a> a() {
                return this.f27972h;
            }

            public JsonLogicBoolean c() {
                return this.f27971g;
            }

            public final ContentType d() {
                return this.f27970f;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f27969e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Attributes)) {
                    return false;
                }
                Attributes attributes = (Attributes) obj;
                return j.b(this.f27965a, attributes.f27965a) && this.f27966b == attributes.f27966b && j.b(this.f27967c, attributes.f27967c) && j.b(this.f27968d, attributes.f27968d) && j.b(this.f27969e, attributes.f27969e) && this.f27970f == attributes.f27970f && j.b(c(), attributes.c());
            }

            public final ContentType f() {
                return this.f27966b;
            }

            public final String g() {
                return this.f27965a;
            }

            public final String h() {
                return this.f27967c;
            }

            public int hashCode() {
                String str = this.f27965a;
                int i10 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                ContentType contentType = this.f27966b;
                int hashCode2 = (((hashCode + (contentType == null ? 0 : contentType.hashCode())) * 31) + this.f27967c.hashCode()) * 31;
                String str2 = this.f27968d;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f27969e;
                int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f27970f.hashCode()) * 31;
                if (c() != null) {
                    i10 = c().hashCode();
                }
                return hashCode4 + i10;
            }

            public final String i() {
                return this.f27968d;
            }

            public String toString() {
                return "Attributes(localAssetName=" + this.f27965a + ", localAssetContentType=" + this.f27966b + ", url=" + this.f27967c + ", width=" + this.f27968d + ", height=" + this.f27969e + ", contentType=" + this.f27970f + ", hidden=" + c() + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27965a);
                ContentType contentType = this.f27966b;
                if (contentType == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeString(contentType.name());
                }
                parcel.writeString(this.f27967c);
                parcel.writeString(this.f27968d);
                parcel.writeString(this.f27969e);
                parcel.writeString(this.f27970f.name());
                JsonLogicBoolean jsonLogicBoolean = this.f27971g;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean.writeToParcel(parcel, i10);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Attributes(String str, ContentType contentType, String str2, String str3, String str4, ContentType contentType2, JsonLogicBoolean jsonLogicBoolean, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, contentType, str2, str3, str4, (i10 & 32) != 0 ? ContentType.Image : contentType2, jsonLogicBoolean);
            }
        }
    }

    @i(generateAdapter = true)
    public static final class InputDate extends UiComponent {
        public static final Parcelable.Creator<InputDate> CREATOR = new b();

        /* renamed from: f  reason: collision with root package name */
        public static final a f27776f = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f27777c;

        /* renamed from: d  reason: collision with root package name */
        private final InputDateComponentStyle f27778d;

        /* renamed from: e  reason: collision with root package name */
        private final Attributes f27779e;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<InputDate> {
            /* renamed from: a */
            public final InputDate createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                String readString = parcel.readString();
                Attributes attributes = null;
                InputDateComponentStyle createFromParcel = parcel.readInt() == 0 ? null : InputDateComponentStyle.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    attributes = Attributes.CREATOR.createFromParcel(parcel);
                }
                return new InputDate(readString, createFromParcel, attributes);
            }

            /* renamed from: b */
            public final InputDate[] newArray(int i10) {
                return new InputDate[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InputDate(String str, InputDateComponentStyle inputDateComponentStyle, Attributes attributes) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "name");
            this.f27777c = str;
            this.f27778d = inputDateComponentStyle;
            this.f27779e = attributes;
        }

        public String A() {
            return this.f27777c;
        }

        /* renamed from: B */
        public Attributes z() {
            return this.f27779e;
        }

        public final InputDateComponentStyle D() {
            return this.f27778d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f27777c);
            InputDateComponentStyle inputDateComponentStyle = this.f27778d;
            if (inputDateComponentStyle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                inputDateComponentStyle.writeToParcel(parcel, i10);
            }
            Attributes attributes = this.f27779e;
            if (attributes == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            attributes.writeToParcel(parcel, i10);
        }

        @i(generateAdapter = true)
        public static final class Attributes implements UiComponentAttributes, a, c {
            public static final Parcelable.Creator<Attributes> CREATOR = new a();

            /* renamed from: a  reason: collision with root package name */
            private final String f27780a;

            /* renamed from: b  reason: collision with root package name */
            private final String f27781b;

            /* renamed from: c  reason: collision with root package name */
            private final String f27782c;

            /* renamed from: d  reason: collision with root package name */
            private final String f27783d;

            /* renamed from: e  reason: collision with root package name */
            private final String f27784e;

            /* renamed from: f  reason: collision with root package name */
            private final String f27785f;

            /* renamed from: g  reason: collision with root package name */
            private final List<String> f27786g;

            /* renamed from: h  reason: collision with root package name */
            private final JsonLogicBoolean f27787h;

            /* renamed from: j  reason: collision with root package name */
            private final JsonLogicBoolean f27788j;

            /* renamed from: k  reason: collision with root package name */
            private final List<cj.a> f27789k;

            public static final class a implements Parcelable.Creator<Attributes> {
                /* renamed from: a */
                public final Attributes createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    String readString6 = parcel.readString();
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    JsonLogicBoolean jsonLogicBoolean = null;
                    JsonLogicBoolean createFromParcel = parcel.readInt() == 0 ? null : JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    if (parcel.readInt() != 0) {
                        jsonLogicBoolean = JsonLogicBoolean.CREATOR.createFromParcel(parcel);
                    }
                    return new Attributes(readString, readString2, readString3, readString4, readString5, readString6, createStringArrayList, createFromParcel, jsonLogicBoolean);
                }

                /* renamed from: b */
                public final Attributes[] newArray(int i10) {
                    return new Attributes[i10];
                }
            }

            public Attributes() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (JsonLogicBoolean) null, (JsonLogicBoolean) null, 511, (DefaultConstructorMarker) null);
            }

            public Attributes(String str, String str2, String str3, String str4, String str5, String str6, List<String> list, JsonLogicBoolean jsonLogicBoolean, JsonLogicBoolean jsonLogicBoolean2) {
                this.f27780a = str;
                this.f27781b = str2;
                this.f27782c = str3;
                this.f27783d = str4;
                this.f27784e = str5;
                this.f27785f = str6;
                this.f27786g = list;
                this.f27787h = jsonLogicBoolean;
                this.f27788j = jsonLogicBoolean2;
                this.f27789k = new ArrayList();
            }

            public List<cj.a> a() {
                return this.f27789k;
            }

            public JsonLogicBoolean c() {
                return this.f27787h;
            }

            public JsonLogicBoolean d() {
                return this.f27788j;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f27780a;
            }

            public final String f() {
                return this.f27782c;
            }

            public final String g() {
                return this.f27784e;
            }

            public final String h() {
                return this.f27783d;
            }

            public final String i() {
                return this.f27785f;
            }

            public final String j() {
                return this.f27781b;
            }

            public final List<String> k() {
                return this.f27786g;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f27780a);
                parcel.writeString(this.f27781b);
                parcel.writeString(this.f27782c);
                parcel.writeString(this.f27783d);
                parcel.writeString(this.f27784e);
                parcel.writeString(this.f27785f);
                parcel.writeStringList(this.f27786g);
                JsonLogicBoolean jsonLogicBoolean = this.f27787h;
                if (jsonLogicBoolean == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    jsonLogicBoolean.writeToParcel(parcel, i10);
                }
                JsonLogicBoolean jsonLogicBoolean2 = this.f27788j;
                if (jsonLogicBoolean2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                jsonLogicBoolean2.writeToParcel(parcel, i10);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Attributes(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.util.List r17, com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean r18, com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
                /*
                    r10 = this;
                    r0 = r20
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000a
                L_0x0009:
                    r1 = r11
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = r2
                    goto L_0x0011
                L_0x0010:
                    r3 = r12
                L_0x0011:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0017
                    r4 = r2
                    goto L_0x0018
                L_0x0017:
                    r4 = r13
                L_0x0018:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x001e
                    r5 = r2
                    goto L_0x001f
                L_0x001e:
                    r5 = r14
                L_0x001f:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0025
                    r6 = r2
                    goto L_0x0026
                L_0x0025:
                    r6 = r15
                L_0x0026:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x002c
                    r7 = r2
                    goto L_0x002e
                L_0x002c:
                    r7 = r16
                L_0x002e:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0034
                    r8 = r2
                    goto L_0x0036
                L_0x0034:
                    r8 = r17
                L_0x0036:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x003c
                    r9 = r2
                    goto L_0x003e
                L_0x003c:
                    r9 = r18
                L_0x003e:
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x0043
                    goto L_0x0045
                L_0x0043:
                    r2 = r19
                L_0x0045:
                    r11 = r10
                    r12 = r1
                    r13 = r3
                    r14 = r4
                    r15 = r5
                    r16 = r6
                    r17 = r7
                    r18 = r8
                    r19 = r9
                    r20 = r2
                    r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.InputDate.Attributes.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean, com.withpersona.sdk2.inquiry.steps.ui.network.JsonLogicBoolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }
        }
    }
}
