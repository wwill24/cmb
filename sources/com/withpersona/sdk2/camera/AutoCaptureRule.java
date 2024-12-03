package com.withpersona.sdk2.camera;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class AutoCaptureRule implements Parcelable {

    public static final class BarcodePdf417Rule extends AutoCaptureRule {
        public static final Parcelable.Creator<BarcodePdf417Rule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14100a;

        public static final class a implements Parcelable.Creator<BarcodePdf417Rule> {
            /* renamed from: a */
            public final BarcodePdf417Rule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new BarcodePdf417Rule(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final BarcodePdf417Rule[] newArray(int i10) {
                return new BarcodePdf417Rule[i10];
            }
        }

        public BarcodePdf417Rule() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BarcodePdf417Rule(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10);
        }

        public boolean a() {
            return this.f14100a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BarcodePdf417Rule) && a() == ((BarcodePdf417Rule) obj).a();
        }

        public int hashCode() {
            boolean a10 = a();
            if (a10) {
                return 1;
            }
            return a10 ? 1 : 0;
        }

        public String toString() {
            return "BarcodePdf417Rule(isRequired=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f14100a ? 1 : 0);
        }

        public BarcodePdf417Rule(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f14100a = z10;
        }
    }

    public static final class FrontOrBackRule extends AutoCaptureRule {
        public static final Parcelable.Creator<FrontOrBackRule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14101a;

        public static final class a implements Parcelable.Creator<FrontOrBackRule> {
            /* renamed from: a */
            public final FrontOrBackRule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new FrontOrBackRule(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final FrontOrBackRule[] newArray(int i10) {
                return new FrontOrBackRule[i10];
            }
        }

        public FrontOrBackRule() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FrontOrBackRule(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10);
        }

        public boolean a() {
            return this.f14101a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FrontOrBackRule) && a() == ((FrontOrBackRule) obj).a();
        }

        public int hashCode() {
            boolean a10 = a();
            if (a10) {
                return 1;
            }
            return a10 ? 1 : 0;
        }

        public String toString() {
            return "FrontOrBackRule(isRequired=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f14101a ? 1 : 0);
        }

        public FrontOrBackRule(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f14101a = z10;
        }
    }

    public static final class FrontRule extends AutoCaptureRule {
        public static final Parcelable.Creator<FrontRule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14102a;

        public static final class a implements Parcelable.Creator<FrontRule> {
            /* renamed from: a */
            public final FrontRule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new FrontRule(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final FrontRule[] newArray(int i10) {
                return new FrontRule[i10];
            }
        }

        public FrontRule() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FrontRule(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10);
        }

        public boolean a() {
            return this.f14102a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FrontRule) && a() == ((FrontRule) obj).a();
        }

        public int hashCode() {
            boolean a10 = a();
            if (a10) {
                return 1;
            }
            return a10 ? 1 : 0;
        }

        public String toString() {
            return "FrontRule(isRequired=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f14102a ? 1 : 0);
        }

        public FrontRule(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f14102a = z10;
        }
    }

    public static final class MrzRule extends AutoCaptureRule {
        public static final Parcelable.Creator<MrzRule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14103a;

        public static final class a implements Parcelable.Creator<MrzRule> {
            /* renamed from: a */
            public final MrzRule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new MrzRule(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final MrzRule[] newArray(int i10) {
                return new MrzRule[i10];
            }
        }

        public MrzRule() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MrzRule(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10);
        }

        public boolean a() {
            return this.f14103a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MrzRule) && a() == ((MrzRule) obj).a();
        }

        public int hashCode() {
            boolean a10 = a();
            if (a10) {
                return 1;
            }
            return a10 ? 1 : 0;
        }

        public String toString() {
            return "MrzRule(isRequired=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f14103a ? 1 : 0);
        }

        public MrzRule(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f14103a = z10;
        }
    }

    public static final class TextExtractionRule extends AutoCaptureRule {
        public static final Parcelable.Creator<TextExtractionRule> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f14104a;

        public static final class a implements Parcelable.Creator<TextExtractionRule> {
            /* renamed from: a */
            public final TextExtractionRule createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new TextExtractionRule(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final TextExtractionRule[] newArray(int i10) {
                return new TextExtractionRule[i10];
            }
        }

        public TextExtractionRule() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TextExtractionRule(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? false : z10);
        }

        public boolean a() {
            return this.f14104a;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TextExtractionRule) && a() == ((TextExtractionRule) obj).a();
        }

        public int hashCode() {
            boolean a10 = a();
            if (a10) {
                return 1;
            }
            return a10 ? 1 : 0;
        }

        public String toString() {
            return "TextExtractionRule(isRequired=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f14104a ? 1 : 0);
        }

        public TextExtractionRule(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f14104a = z10;
        }
    }

    private AutoCaptureRule() {
    }

    public /* synthetic */ AutoCaptureRule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
