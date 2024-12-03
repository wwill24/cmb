package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class StyleElements {

    /* renamed from: a  reason: collision with root package name */
    public static final a f29170a = new a((DefaultConstructorMarker) null);

    @i(generateAdapter = false)
    public enum Axis {
        HORIZONTAL,
        VERTICAL;
        
        public static final Companion Companion = null;

        public static final class Companion extends h<Axis> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, Axis axis) {
                j.g(qVar, "writer");
            }

            @f
            public Axis fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                Object J = jsonReader.J();
                if (j.b(J, "horizontal")) {
                    return Axis.HORIZONTAL;
                }
                if (j.b(J, "vertical")) {
                    return Axis.VERTICAL;
                }
                return Axis.HORIZONTAL;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @i(generateAdapter = true)
    public static final class AxisContainer implements Parcelable {
        public static final Parcelable.Creator<AxisContainer> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Axis f29171a;

        public static final class a implements Parcelable.Creator<AxisContainer> {
            /* renamed from: a */
            public final AxisContainer createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new AxisContainer(parcel.readInt() == 0 ? null : Axis.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final AxisContainer[] newArray(int i10) {
                return new AxisContainer[i10];
            }
        }

        public AxisContainer(Axis axis) {
            this.f29171a = axis;
        }

        public final Axis a() {
            return this.f29171a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            Axis axis = this.f29171a;
            if (axis == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(axis.name());
        }
    }

    @i(generateAdapter = true)
    public static final class ChildSizes implements Parcelable {
        public static final Parcelable.Creator<ChildSizes> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int[] f29172a;

        public static final class a implements Parcelable.Creator<ChildSizes> {
            /* renamed from: a */
            public final ChildSizes createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ChildSizes(parcel.createIntArray());
            }

            /* renamed from: b */
            public final ChildSizes[] newArray(int i10) {
                return new ChildSizes[i10];
            }
        }

        public ChildSizes(int[] iArr) {
            this.f29172a = iArr;
        }

        public final int[] a() {
            return this.f29172a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeIntArray(this.f29172a);
        }
    }

    @i(generateAdapter = false)
    public static final class ComplexElementColor implements Parcelable {
        public static final Parcelable.Creator<ComplexElementColor> CREATOR = new a();

        /* renamed from: f  reason: collision with root package name */
        public static final Companion f29173f = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f29174a;

        /* renamed from: b  reason: collision with root package name */
        private final String f29175b;

        /* renamed from: c  reason: collision with root package name */
        private final String f29176c;

        /* renamed from: d  reason: collision with root package name */
        private final String f29177d;

        /* renamed from: e  reason: collision with root package name */
        private final String f29178e;

        public static final class Companion extends h<ComplexElementColor> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final String a(JsonReader jsonReader) {
                String str = null;
                if (jsonReader.E() == JsonReader.Token.BEGIN_OBJECT) {
                    jsonReader.b();
                    while (jsonReader.g()) {
                        if (j.b(jsonReader.u(), "value")) {
                            str = StyleElements.f29170a.d(jsonReader);
                        } else {
                            jsonReader.Y();
                        }
                    }
                    jsonReader.e();
                } else {
                    jsonReader.Y();
                }
                return str;
            }

            @v
            public void toJson(q qVar, ComplexElementColor complexElementColor) {
                j.g(qVar, "writer");
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            @com.squareup.moshi.f
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.ComplexElementColor fromJson(com.squareup.moshi.JsonReader r12) {
                /*
                    r11 = this;
                    java.lang.String r0 = "reader"
                    kotlin.jvm.internal.j.g(r12, r0)
                    com.squareup.moshi.JsonReader$Token r0 = r12.E()
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
                    r2 = 0
                    if (r0 != r1) goto L_0x007c
                    r12.b()
                    r0 = r2
                    r1 = r0
                    r3 = r1
                    r4 = r3
                L_0x0015:
                    boolean r5 = r12.g()
                    if (r5 == 0) goto L_0x0073
                    java.lang.String r5 = r12.u()
                    if (r5 == 0) goto L_0x006f
                    int r6 = r5.hashCode()
                    switch(r6) {
                        case -1478984537: goto L_0x0061;
                        case -1422950650: goto L_0x0053;
                        case -691041417: goto L_0x0045;
                        case 3016401: goto L_0x0037;
                        case 270940796: goto L_0x0029;
                        default: goto L_0x0028;
                    }
                L_0x0028:
                    goto L_0x006f
                L_0x0029:
                    java.lang.String r6 = "disabled"
                    boolean r5 = r5.equals(r6)
                    if (r5 != 0) goto L_0x0032
                    goto L_0x006f
                L_0x0032:
                    java.lang.String r3 = r11.a(r12)
                    goto L_0x0015
                L_0x0037:
                    java.lang.String r6 = "base"
                    boolean r5 = r5.equals(r6)
                    if (r5 != 0) goto L_0x0040
                    goto L_0x006f
                L_0x0040:
                    java.lang.String r2 = r11.a(r12)
                    goto L_0x0015
                L_0x0045:
                    java.lang.String r6 = "focused"
                    boolean r5 = r5.equals(r6)
                    if (r5 != 0) goto L_0x004e
                    goto L_0x006f
                L_0x004e:
                    java.lang.String r0 = r11.a(r12)
                    goto L_0x0015
                L_0x0053:
                    java.lang.String r6 = "active"
                    boolean r5 = r5.equals(r6)
                    if (r5 != 0) goto L_0x005c
                    goto L_0x006f
                L_0x005c:
                    java.lang.String r1 = r11.a(r12)
                    goto L_0x0015
                L_0x0061:
                    java.lang.String r6 = "errored"
                    boolean r5 = r5.equals(r6)
                    if (r5 != 0) goto L_0x006a
                    goto L_0x006f
                L_0x006a:
                    java.lang.String r4 = r11.a(r12)
                    goto L_0x0015
                L_0x006f:
                    r12.Y()
                    goto L_0x0015
                L_0x0073:
                    r12.e()
                    r7 = r0
                    r8 = r1
                    r6 = r2
                    r9 = r3
                    r10 = r4
                    goto L_0x0084
                L_0x007c:
                    r12.Y()
                    r6 = r2
                    r7 = r6
                    r8 = r7
                    r9 = r8
                    r10 = r9
                L_0x0084:
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor r12 = new com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor
                    r5 = r12
                    r5.<init>(r6, r7, r8, r9, r10)
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.ComplexElementColor.Companion.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$ComplexElementColor");
            }
        }

        public static final class a implements Parcelable.Creator<ComplexElementColor> {
            /* renamed from: a */
            public final ComplexElementColor createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ComplexElementColor(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final ComplexElementColor[] newArray(int i10) {
                return new ComplexElementColor[i10];
            }
        }

        public ComplexElementColor(String str, String str2, String str3, String str4, String str5) {
            this.f29174a = str;
            this.f29175b = str2;
            this.f29176c = str3;
            this.f29177d = str4;
            this.f29178e = str5;
        }

        public final String a() {
            return this.f29176c;
        }

        public final String c() {
            return this.f29174a;
        }

        public final String d() {
            return this.f29177d;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f29178e;
        }

        public final String f() {
            return this.f29175b;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29174a);
            parcel.writeString(this.f29175b);
            parcel.writeString(this.f29176c);
            parcel.writeString(this.f29177d);
            parcel.writeString(this.f29178e);
        }
    }

    @i(generateAdapter = true)
    public static final class DPMeasurement implements Parcelable {
        public static final Parcelable.Creator<DPMeasurement> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final DPSize f29179a;

        public static final class a implements Parcelable.Creator<DPMeasurement> {
            /* renamed from: a */
            public final DPMeasurement createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new DPMeasurement(parcel.readInt() == 0 ? null : DPSize.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final DPMeasurement[] newArray(int i10) {
                return new DPMeasurement[i10];
            }
        }

        public DPMeasurement(DPSize dPSize) {
            this.f29179a = dPSize;
        }

        public final DPSize a() {
            return this.f29179a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            DPSize dPSize = this.f29179a;
            if (dPSize == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            dPSize.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class DPMeasurementSet implements Parcelable {
        public static final Parcelable.Creator<DPMeasurementSet> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final DPSizeSet f29180a;

        public static final class a implements Parcelable.Creator<DPMeasurementSet> {
            /* renamed from: a */
            public final DPMeasurementSet createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new DPMeasurementSet(parcel.readInt() == 0 ? null : DPSizeSet.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final DPMeasurementSet[] newArray(int i10) {
                return new DPMeasurementSet[i10];
            }
        }

        public DPMeasurementSet(DPSizeSet dPSizeSet) {
            this.f29180a = dPSizeSet;
        }

        public final DPSizeSet a() {
            return this.f29180a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            DPSizeSet dPSizeSet = this.f29180a;
            if (dPSizeSet == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            dPSizeSet.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = false)
    public static final class DPSize extends Size {
        public static final Parcelable.Creator<DPSize> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        public static final Companion f29181c = new Companion((DefaultConstructorMarker) null);

        /* renamed from: b  reason: collision with root package name */
        private final Double f29182b;

        public static final class Companion extends h<DPSize> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, DPSize dPSize) {
                j.g(qVar, "writer");
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
            /* JADX WARNING: Multi-variable type inference failed */
            @com.squareup.moshi.f
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.DPSize fromJson(com.squareup.moshi.JsonReader r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "reader"
                    kotlin.jvm.internal.j.g(r7, r0)
                    com.squareup.moshi.JsonReader$Token r0 = r7.E()
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
                    r2 = 0
                    if (r0 != r1) goto L_0x0044
                    r7.b()
                    r0 = r2
                L_0x0012:
                    boolean r1 = r7.g()
                    if (r1 == 0) goto L_0x003e
                    java.lang.String r1 = r7.u()
                    java.lang.String r3 = "unit"
                    boolean r3 = kotlin.jvm.internal.j.b(r1, r3)
                    if (r3 == 0) goto L_0x002b
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$a r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.f29170a
                    java.lang.String r0 = r0.d(r7)
                    goto L_0x0012
                L_0x002b:
                    java.lang.String r3 = "value"
                    boolean r1 = kotlin.jvm.internal.j.b(r1, r3)
                    if (r1 == 0) goto L_0x003a
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$a r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.f29170a
                    java.lang.Double r2 = r1.c(r7)
                    goto L_0x0012
                L_0x003a:
                    r7.Y()
                    goto L_0x0012
                L_0x003e:
                    r7.e()
                    r7 = r2
                    r2 = r0
                    goto L_0x0048
                L_0x0044:
                    r7.Y()
                    r7 = r2
                L_0x0048:
                    java.lang.String r0 = "%"
                    boolean r0 = kotlin.jvm.internal.j.b(r2, r0)
                    if (r0 == 0) goto L_0x006d
                    if (r7 == 0) goto L_0x006d
                    android.content.res.Resources r0 = android.content.res.Resources.getSystem()
                    android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
                    int r0 = r0.widthPixels
                    double r0 = (double) r0
                    double r0 = ti.b.c(r0)
                    double r2 = r7.doubleValue()
                    r4 = 4636737291354636288(0x4059000000000000, double:100.0)
                    double r2 = r2 / r4
                    double r0 = r0 * r2
                    java.lang.Double r7 = java.lang.Double.valueOf(r0)
                L_0x006d:
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = new com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize
                    r0.<init>(r7)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.DPSize.Companion.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize");
            }
        }

        public static final class a implements Parcelable.Creator<DPSize> {
            /* renamed from: a */
            public final DPSize createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new DPSize(parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()));
            }

            /* renamed from: b */
            public final DPSize[] newArray(int i10) {
                return new DPSize[i10];
            }
        }

        public DPSize(Double d10) {
            super((DefaultConstructorMarker) null);
            this.f29182b = d10;
        }

        public final Double a() {
            return this.f29182b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            Double d10 = this.f29182b;
            if (d10 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeDouble(d10.doubleValue());
        }
    }

    @i(generateAdapter = true)
    public static final class DPSizeSet implements Parcelable {
        public static final Parcelable.Creator<DPSizeSet> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final DPSize f29183a;

        /* renamed from: b  reason: collision with root package name */
        private final DPSize f29184b;

        /* renamed from: c  reason: collision with root package name */
        private final DPSize f29185c;

        /* renamed from: d  reason: collision with root package name */
        private final DPSize f29186d;

        public static final class a implements Parcelable.Creator<DPSizeSet> {
            /* renamed from: a */
            public final DPSizeSet createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                DPSize dPSize = null;
                DPSize createFromParcel = parcel.readInt() == 0 ? null : DPSize.CREATOR.createFromParcel(parcel);
                DPSize createFromParcel2 = parcel.readInt() == 0 ? null : DPSize.CREATOR.createFromParcel(parcel);
                DPSize createFromParcel3 = parcel.readInt() == 0 ? null : DPSize.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    dPSize = DPSize.CREATOR.createFromParcel(parcel);
                }
                return new DPSizeSet(createFromParcel, createFromParcel2, createFromParcel3, dPSize);
            }

            /* renamed from: b */
            public final DPSizeSet[] newArray(int i10) {
                return new DPSizeSet[i10];
            }
        }

        public DPSizeSet(DPSize dPSize, DPSize dPSize2, DPSize dPSize3, DPSize dPSize4) {
            this.f29183a = dPSize;
            this.f29184b = dPSize2;
            this.f29185c = dPSize3;
            this.f29186d = dPSize4;
        }

        public final DPSize a() {
            return this.f29184b;
        }

        public final DPSize c() {
            return this.f29185c;
        }

        public final DPSize d() {
            return this.f29186d;
        }

        public int describeContents() {
            return 0;
        }

        public final DPSize e() {
            return this.f29183a;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            DPSize dPSize = this.f29183a;
            if (dPSize == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                dPSize.writeToParcel(parcel, i10);
            }
            DPSize dPSize2 = this.f29184b;
            if (dPSize2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                dPSize2.writeToParcel(parcel, i10);
            }
            DPSize dPSize3 = this.f29185c;
            if (dPSize3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                dPSize3.writeToParcel(parcel, i10);
            }
            DPSize dPSize4 = this.f29186d;
            if (dPSize4 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            dPSize4.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = false)
    public enum FontWeight {
        LIGHT,
        NORMAL,
        MEDIUM,
        BOLD,
        HEAVY;
        
        public static final Companion Companion = null;

        public static final class Companion extends h<FontWeight> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, FontWeight fontWeight) {
                j.g(qVar, "writer");
            }

            @f
            public FontWeight fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                Object J = jsonReader.J();
                if (j.b(J, "light")) {
                    return FontWeight.LIGHT;
                }
                if (j.b(J, "normal")) {
                    return FontWeight.NORMAL;
                }
                if (j.b(J, "medium")) {
                    return FontWeight.MEDIUM;
                }
                if (j.b(J, "bold")) {
                    return FontWeight.BOLD;
                }
                if (j.b(J, "heavy")) {
                    return FontWeight.HEAVY;
                }
                return FontWeight.NORMAL;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @i(generateAdapter = true)
    public static final class FontWeightContainer implements Parcelable {
        public static final Parcelable.Creator<FontWeightContainer> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final FontWeight f29189a;

        public static final class a implements Parcelable.Creator<FontWeightContainer> {
            /* renamed from: a */
            public final FontWeightContainer createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new FontWeightContainer(parcel.readInt() == 0 ? null : FontWeight.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final FontWeightContainer[] newArray(int i10) {
                return new FontWeightContainer[i10];
            }
        }

        public FontWeightContainer(FontWeight fontWeight) {
            this.f29189a = fontWeight;
        }

        public final FontWeight a() {
            return this.f29189a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            FontWeight fontWeight = this.f29189a;
            if (fontWeight == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(fontWeight.name());
        }
    }

    @i(generateAdapter = true)
    public static final class Measurement implements Parcelable {
        public static final Parcelable.Creator<Measurement> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Size f29190a;

        public static final class a implements Parcelable.Creator<Measurement> {
            /* renamed from: a */
            public final Measurement createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Measurement((Size) parcel.readParcelable(Measurement.class.getClassLoader()));
            }

            /* renamed from: b */
            public final Measurement[] newArray(int i10) {
                return new Measurement[i10];
            }
        }

        public Measurement(Size size) {
            this.f29190a = size;
        }

        public final Size a() {
            return this.f29190a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeParcelable(this.f29190a, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class Position implements Parcelable {
        public static final Parcelable.Creator<Position> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final PositionType f29191a;

        public static final class a implements Parcelable.Creator<Position> {
            /* renamed from: a */
            public final Position createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Position(parcel.readInt() == 0 ? null : PositionType.valueOf(parcel.readString()));
            }

            /* renamed from: b */
            public final Position[] newArray(int i10) {
                return new Position[i10];
            }
        }

        public Position(PositionType positionType) {
            this.f29191a = positionType;
        }

        public final PositionType a() {
            return this.f29191a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            PositionType positionType = this.f29191a;
            if (positionType == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(positionType.name());
        }
    }

    @i(generateAdapter = false)
    public enum PositionType {
        START,
        CENTER,
        END;
        
        public static final Companion Companion = null;

        public static final class Companion extends h<PositionType> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, PositionType positionType) {
                j.g(qVar, "writer");
            }

            @f
            public PositionType fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                Object J = jsonReader.J();
                if (j.b(J, "start")) {
                    return PositionType.START;
                }
                if (j.b(J, "center")) {
                    return PositionType.CENTER;
                }
                if (j.b(J, "end")) {
                    return PositionType.END;
                }
                return PositionType.START;
            }
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }

    @i(generateAdapter = true)
    public static final class SimpleElementColor implements Parcelable {
        public static final Parcelable.Creator<SimpleElementColor> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final SimpleElementColorValue f29192a;

        public static final class a implements Parcelable.Creator<SimpleElementColor> {
            /* renamed from: a */
            public final SimpleElementColor createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new SimpleElementColor(parcel.readInt() == 0 ? null : SimpleElementColorValue.CREATOR.createFromParcel(parcel));
            }

            /* renamed from: b */
            public final SimpleElementColor[] newArray(int i10) {
                return new SimpleElementColor[i10];
            }
        }

        public SimpleElementColor(SimpleElementColorValue simpleElementColorValue) {
            this.f29192a = simpleElementColorValue;
        }

        public final SimpleElementColorValue a() {
            return this.f29192a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            SimpleElementColorValue simpleElementColorValue = this.f29192a;
            if (simpleElementColorValue == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            simpleElementColorValue.writeToParcel(parcel, i10);
        }
    }

    @i(generateAdapter = true)
    public static final class SimpleElementColorValue implements Parcelable {
        public static final Parcelable.Creator<SimpleElementColorValue> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f29193a;

        public static final class a implements Parcelable.Creator<SimpleElementColorValue> {
            /* renamed from: a */
            public final SimpleElementColorValue createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new SimpleElementColorValue(parcel.readString());
            }

            /* renamed from: b */
            public final SimpleElementColorValue[] newArray(int i10) {
                return new SimpleElementColorValue[i10];
            }
        }

        public SimpleElementColorValue(String str) {
            this.f29193a = str;
        }

        public final String a() {
            return this.f29193a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29193a);
        }
    }

    public static abstract class Size implements Parcelable {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f29194a = new Companion((DefaultConstructorMarker) null);

        public static final class Companion extends h<Size> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, Size size) {
                j.g(qVar, "writer");
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.Double} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
            /* JADX WARNING: Multi-variable type inference failed */
            @com.squareup.moshi.f
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Size fromJson(com.squareup.moshi.JsonReader r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "reader"
                    kotlin.jvm.internal.j.g(r6, r0)
                    com.squareup.moshi.JsonReader$Token r0 = r6.E()
                    com.squareup.moshi.JsonReader$Token r1 = com.squareup.moshi.JsonReader.Token.BEGIN_OBJECT
                    r2 = 0
                    if (r0 != r1) goto L_0x0044
                    r6.b()
                    r0 = r2
                L_0x0012:
                    boolean r1 = r6.g()
                    if (r1 == 0) goto L_0x003e
                    java.lang.String r1 = r6.u()
                    java.lang.String r3 = "unit"
                    boolean r3 = kotlin.jvm.internal.j.b(r1, r3)
                    if (r3 == 0) goto L_0x002b
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$a r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.f29170a
                    java.lang.String r0 = r0.d(r6)
                    goto L_0x0012
                L_0x002b:
                    java.lang.String r3 = "value"
                    boolean r1 = kotlin.jvm.internal.j.b(r1, r3)
                    if (r1 == 0) goto L_0x003a
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$a r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.f29170a
                    java.lang.Double r2 = r1.c(r6)
                    goto L_0x0012
                L_0x003a:
                    r6.Y()
                    goto L_0x0012
                L_0x003e:
                    r6.e()
                    r6 = r2
                    r2 = r0
                    goto L_0x0048
                L_0x0044:
                    r6.Y()
                    r6 = r2
                L_0x0048:
                    java.lang.String r0 = "%"
                    boolean r0 = kotlin.jvm.internal.j.b(r2, r0)
                    if (r0 == 0) goto L_0x005f
                    if (r6 == 0) goto L_0x005f
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Size$PercentSize r0 = new com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Size$PercentSize
                    double r1 = r6.doubleValue()
                    r3 = 4636737291354636288(0x4059000000000000, double:100.0)
                    double r1 = r1 / r3
                    r0.<init>(r1)
                    goto L_0x0064
                L_0x005f:
                    com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize r0 = new com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$DPSize
                    r0.<init>(r6)
                L_0x0064:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.Size.Companion.fromJson(com.squareup.moshi.JsonReader):com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$Size");
            }
        }

        @i(generateAdapter = true)
        public static final class PercentSize extends Size {
            public static final Parcelable.Creator<PercentSize> CREATOR = new a();

            /* renamed from: b  reason: collision with root package name */
            private final double f29195b;

            public static final class a implements Parcelable.Creator<PercentSize> {
                /* renamed from: a */
                public final PercentSize createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PercentSize(parcel.readDouble());
                }

                /* renamed from: b */
                public final PercentSize[] newArray(int i10) {
                    return new PercentSize[i10];
                }
            }

            public PercentSize(double d10) {
                super((DefaultConstructorMarker) null);
                this.f29195b = d10;
            }

            public final double a() {
                return this.f29195b;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeDouble(this.f29195b);
            }
        }

        private Size() {
        }

        public /* synthetic */ Size(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Double c(JsonReader jsonReader) {
            if (jsonReader.E() != JsonReader.Token.NULL) {
                return Double.valueOf(jsonReader.l());
            }
            jsonReader.Y();
            return null;
        }

        /* access modifiers changed from: private */
        public final String d(JsonReader jsonReader) {
            if (jsonReader.E() != JsonReader.Token.NULL) {
                return jsonReader.y();
            }
            jsonReader.Y();
            return null;
        }
    }

    @i(generateAdapter = false)
    public static final class FontName implements Parcelable {
        public static final Parcelable.Creator<FontName> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Companion f29187b = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final String f29188a;

        public static final class Companion extends h<FontName> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @v
            public void toJson(q qVar, FontName fontName) {
                j.g(qVar, "writer");
            }

            @f
            public FontName fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                String str = null;
                if (jsonReader.E() == JsonReader.Token.BEGIN_OBJECT) {
                    jsonReader.b();
                    while (jsonReader.g()) {
                        if (j.b(jsonReader.u(), "base")) {
                            str = StyleElements.f29170a.d(jsonReader);
                        } else {
                            jsonReader.Y();
                        }
                    }
                    jsonReader.e();
                } else {
                    jsonReader.Y();
                }
                return new FontName(str);
            }
        }

        public static final class a implements Parcelable.Creator<FontName> {
            /* renamed from: a */
            public final FontName createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new FontName(parcel.readString());
            }

            /* renamed from: b */
            public final FontName[] newArray(int i10) {
                return new FontName[i10];
            }
        }

        public FontName() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public FontName(String str) {
            this.f29188a = str;
        }

        public final String a() {
            return this.f29188a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29188a);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FontName(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : str);
        }
    }
}
