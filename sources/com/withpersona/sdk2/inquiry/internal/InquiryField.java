package com.withpersona.sdk2.inquiry.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.leanplum.internal.Constants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class InquiryField implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f26099b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f26100a;

    @i(generateAdapter = true)
    public static final class BooleanField extends InquiryField {
        public static final Parcelable.Creator<BooleanField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26101e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final Boolean f26102c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26103d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<BooleanField> {
            /* renamed from: a */
            public final BooleanField createFromParcel(Parcel parcel) {
                Boolean bool;
                j.g(parcel, "parcel");
                if (parcel.readInt() == 0) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new BooleanField(bool, parcel.readString());
            }

            /* renamed from: b */
            public final BooleanField[] newArray(int i10) {
                return new BooleanField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BooleanField(Boolean bool, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, (i10 & 2) != 0 ? "boolean" : str);
        }

        public String a() {
            return this.f26103d;
        }

        public final Boolean c() {
            return this.f26102c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BooleanField)) {
                return false;
            }
            BooleanField booleanField = (BooleanField) obj;
            return j.b(this.f26102c, booleanField.f26102c) && j.b(a(), booleanField.a());
        }

        public int hashCode() {
            Boolean bool = this.f26102c;
            return ((bool == null ? 0 : bool.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "BooleanField(value=" + this.f26102c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            boolean booleanValue;
            j.g(parcel, "out");
            Boolean bool = this.f26102c;
            if (bool == null) {
                booleanValue = false;
            } else {
                parcel.writeInt(1);
                booleanValue = bool.booleanValue();
            }
            parcel.writeInt(booleanValue ? 1 : 0);
            parcel.writeString(this.f26103d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BooleanField(Boolean bool, String str) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "type");
            this.f26102c = bool;
            this.f26103d = str;
        }
    }

    @i(generateAdapter = true)
    public static final class DateField extends InquiryField {
        public static final Parcelable.Creator<DateField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26104e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f26105c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26106d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<DateField> {
            /* renamed from: a */
            public final DateField createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new DateField(parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final DateField[] newArray(int i10) {
                return new DateField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DateField(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? "date" : str2);
        }

        public String a() {
            return this.f26106d;
        }

        public final String c() {
            return this.f26105c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DateField)) {
                return false;
            }
            DateField dateField = (DateField) obj;
            return j.b(this.f26105c, dateField.f26105c) && j.b(a(), dateField.a());
        }

        public int hashCode() {
            String str = this.f26105c;
            return ((str == null ? 0 : str.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "DateField(value=" + this.f26105c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26105c);
            parcel.writeString(this.f26106d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DateField(String str, String str2) {
            super(str2, (DefaultConstructorMarker) null);
            j.g(str2, "type");
            this.f26105c = str;
            this.f26106d = str2;
        }
    }

    @i(generateAdapter = true)
    public static final class DatetimeField extends InquiryField {
        public static final Parcelable.Creator<DatetimeField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26107e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f26108c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26109d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<DatetimeField> {
            /* renamed from: a */
            public final DatetimeField createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new DatetimeField(parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final DatetimeField[] newArray(int i10) {
                return new DatetimeField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DatetimeField(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? "datetime" : str2);
        }

        public String a() {
            return this.f26109d;
        }

        public final String c() {
            return this.f26108c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DatetimeField)) {
                return false;
            }
            DatetimeField datetimeField = (DatetimeField) obj;
            return j.b(this.f26108c, datetimeField.f26108c) && j.b(a(), datetimeField.a());
        }

        public int hashCode() {
            String str = this.f26108c;
            return ((str == null ? 0 : str.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "DatetimeField(value=" + this.f26108c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26108c);
            parcel.writeString(this.f26109d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DatetimeField(String str, String str2) {
            super(str2, (DefaultConstructorMarker) null);
            j.g(str2, "type");
            this.f26108c = str;
            this.f26109d = str2;
        }
    }

    @i(generateAdapter = true)
    public static final class FloatField extends InquiryField {
        public static final Parcelable.Creator<FloatField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26110e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final Float f26111c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26112d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<FloatField> {
            /* renamed from: a */
            public final FloatField createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new FloatField(parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString());
            }

            /* renamed from: b */
            public final FloatField[] newArray(int i10) {
                return new FloatField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FloatField(Float f10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(f10, (i10 & 2) != 0 ? Constants.Kinds.FLOAT : str);
        }

        public String a() {
            return this.f26112d;
        }

        public final Float c() {
            return this.f26111c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FloatField)) {
                return false;
            }
            FloatField floatField = (FloatField) obj;
            return j.b(this.f26111c, floatField.f26111c) && j.b(a(), floatField.a());
        }

        public int hashCode() {
            Float f10 = this.f26111c;
            return ((f10 == null ? 0 : f10.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "FloatField(value=" + this.f26111c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            Float f10 = this.f26111c;
            if (f10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeFloat(f10.floatValue());
            }
            parcel.writeString(this.f26112d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FloatField(Float f10, String str) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "type");
            this.f26111c = f10;
            this.f26112d = str;
        }
    }

    @i(generateAdapter = true)
    public static final class IntegerField extends InquiryField {
        public static final Parcelable.Creator<IntegerField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26113e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final Integer f26114c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26115d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<IntegerField> {
            /* renamed from: a */
            public final IntegerField createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new IntegerField(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
            }

            /* renamed from: b */
            public final IntegerField[] newArray(int i10) {
                return new IntegerField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IntegerField(Integer num, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, (i10 & 2) != 0 ? Constants.Kinds.INT : str);
        }

        public String a() {
            return this.f26115d;
        }

        public final Integer c() {
            return this.f26114c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntegerField)) {
                return false;
            }
            IntegerField integerField = (IntegerField) obj;
            return j.b(this.f26114c, integerField.f26114c) && j.b(a(), integerField.a());
        }

        public int hashCode() {
            Integer num = this.f26114c;
            return ((num == null ? 0 : num.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "IntegerField(value=" + this.f26114c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            int i11;
            j.g(parcel, "out");
            Integer num = this.f26114c;
            if (num == null) {
                i11 = 0;
            } else {
                parcel.writeInt(1);
                i11 = num.intValue();
            }
            parcel.writeInt(i11);
            parcel.writeString(this.f26115d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IntegerField(Integer num, String str) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "type");
            this.f26114c = num;
            this.f26115d = str;
        }
    }

    @i(generateAdapter = true)
    public static final class StringField extends InquiryField {
        public static final Parcelable.Creator<StringField> CREATOR = new b();

        /* renamed from: e  reason: collision with root package name */
        public static final a f26116e = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f26117c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26118d;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final class b implements Parcelable.Creator<StringField> {
            /* renamed from: a */
            public final StringField createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new StringField(parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final StringField[] newArray(int i10) {
                return new StringField[i10];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ StringField(String str, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? "string" : str2);
        }

        public String a() {
            return this.f26118d;
        }

        public final String c() {
            return this.f26117c;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringField)) {
                return false;
            }
            StringField stringField = (StringField) obj;
            return j.b(this.f26117c, stringField.f26117c) && j.b(a(), stringField.a());
        }

        public int hashCode() {
            String str = this.f26117c;
            return ((str == null ? 0 : str.hashCode()) * 31) + a().hashCode();
        }

        public String toString() {
            return "StringField(value=" + this.f26117c + ", type=" + a() + PropertyUtils.MAPPED_DELIM2;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26117c);
            parcel.writeString(this.f26118d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StringField(String str, String str2) {
            super(str2, (DefaultConstructorMarker) null);
            j.g(str2, "type");
            this.f26117c = str;
            this.f26118d = str2;
        }
    }

    public static final class Unknown extends InquiryField {
        public static final Parcelable.Creator<Unknown> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        private final String f26119c;

        public static final class a implements Parcelable.Creator<Unknown> {
            /* renamed from: a */
            public final Unknown createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Unknown(parcel.readString());
            }

            /* renamed from: b */
            public final Unknown[] newArray(int i10) {
                return new Unknown[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unknown(String str) {
            super(str, (DefaultConstructorMarker) null);
            j.g(str, "type");
            this.f26119c = str;
        }

        public String a() {
            return this.f26119c;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f26119c);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.e a() {
            ai.b<InquiryField> b10 = ai.b.b(InquiryField.class, "type");
            b bVar = b.f26120a;
            j.e(bVar, "null cannot be cast to non-null type com.squareup.moshi.JsonAdapter<kotlin.Any>");
            ai.b<InquiryField> e10 = b10.d(bVar).e(StringField.class, "string").e(IntegerField.class, Constants.Kinds.INT).e(BooleanField.class, "boolean").e(FloatField.class, Constants.Kinds.FLOAT).e(FloatField.class, "number").e(DateField.class, "date").e(DatetimeField.class, "datetime");
            j.f(e10, "of(InquiryField::class.j…java, DatetimeField.type)");
            return e10;
        }
    }

    private static final class b extends h<InquiryField> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f26120a = new b();

        private b() {
        }

        /* renamed from: a */
        public InquiryField fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            jsonReader.b();
            String str = "";
            while (jsonReader.g()) {
                if (j.b(jsonReader.u(), "type")) {
                    str = jsonReader.y();
                    j.f(str, "reader.nextString()");
                } else {
                    jsonReader.Y();
                }
            }
            jsonReader.e();
            return new Unknown(str);
        }

        /* renamed from: b */
        public void toJson(q qVar, InquiryField inquiryField) {
            String str;
            j.g(qVar, "writer");
            qVar.c();
            qVar.u("type");
            if (inquiryField != null) {
                str = inquiryField.a();
            } else {
                str = null;
            }
            qVar.S(str);
            qVar.h();
        }
    }

    private InquiryField(String str) {
        this.f26100a = str;
    }

    public /* synthetic */ InquiryField(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public String a() {
        return this.f26100a;
    }
}
