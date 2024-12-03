package com.withpersona.sdk2.inquiry.ui.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.leanplum.internal.Constants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class ComponentParam implements Parcelable {

    public static final class Adapter extends h<ComponentParam> {

        /* renamed from: a  reason: collision with root package name */
        public static final Adapter f29416a = new Adapter();

        private Adapter() {
        }

        @f
        public ComponentParam fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            return null;
        }

        @v
        public void toJson(q qVar, ComponentParam componentParam) {
            j.g(qVar, "writer");
            if (componentParam instanceof ComponentString) {
                qVar.S(((ComponentString) componentParam).a());
            } else if (componentParam instanceof ComponentStringList) {
                qVar.a();
                for (String S : ((ComponentStringList) componentParam).a()) {
                    qVar.S(S);
                }
                qVar.f();
            } else if (componentParam instanceof Address) {
                qVar.c();
                Address address = (Address) componentParam;
                String d10 = address.d();
                if (d10 != null) {
                    qVar.u("street_1");
                    qVar.S(d10);
                }
                String e10 = address.e();
                if (e10 != null) {
                    qVar.u("street_2");
                    qVar.S(e10);
                }
                String a10 = address.a();
                if (a10 != null) {
                    qVar.u(Constants.Keys.CITY);
                    qVar.S(a10);
                }
                String f10 = address.f();
                if (f10 != null) {
                    qVar.u("subdivision");
                    qVar.S(f10);
                }
                String c10 = address.c();
                if (c10 != null) {
                    qVar.u("postal_code");
                    qVar.S(c10);
                }
                qVar.h();
            } else if (componentParam instanceof ComponentBoolean) {
                qVar.Y(((ComponentBoolean) componentParam).a());
            } else if (componentParam instanceof ComponentNumber) {
                qVar.P(((ComponentNumber) componentParam).a());
            } else if (componentParam instanceof ESignature) {
                qVar.S(((ESignature) componentParam).a());
            }
        }
    }

    public static final class Address extends ComponentParam {
        public static final Parcelable.Creator<Address> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private String f29417a;

        /* renamed from: b  reason: collision with root package name */
        private String f29418b;

        /* renamed from: c  reason: collision with root package name */
        private String f29419c;

        /* renamed from: d  reason: collision with root package name */
        private String f29420d;

        /* renamed from: e  reason: collision with root package name */
        private String f29421e;

        public static final class a implements Parcelable.Creator<Address> {
            /* renamed from: a */
            public final Address createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new Address(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* renamed from: b */
            public final Address[] newArray(int i10) {
                return new Address[i10];
            }
        }

        public Address(String str, String str2, String str3, String str4, String str5) {
            super((DefaultConstructorMarker) null);
            this.f29417a = str;
            this.f29418b = str2;
            this.f29419c = str3;
            this.f29420d = str4;
            this.f29421e = str5;
        }

        public final String a() {
            return this.f29419c;
        }

        public final String c() {
            return this.f29421e;
        }

        public final String d() {
            return this.f29417a;
        }

        public int describeContents() {
            return 0;
        }

        public final String e() {
            return this.f29418b;
        }

        public final String f() {
            return this.f29420d;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29417a);
            parcel.writeString(this.f29418b);
            parcel.writeString(this.f29419c);
            parcel.writeString(this.f29420d);
            parcel.writeString(this.f29421e);
        }
    }

    public static final class ComponentBoolean extends ComponentParam {
        public static final Parcelable.Creator<ComponentBoolean> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f29422a;

        public static final class a implements Parcelable.Creator<ComponentBoolean> {
            /* renamed from: a */
            public final ComponentBoolean createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ComponentBoolean(parcel.readInt() != 0);
            }

            /* renamed from: b */
            public final ComponentBoolean[] newArray(int i10) {
                return new ComponentBoolean[i10];
            }
        }

        public ComponentBoolean(boolean z10) {
            super((DefaultConstructorMarker) null);
            this.f29422a = z10;
        }

        public final boolean a() {
            return this.f29422a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeInt(this.f29422a ? 1 : 0);
        }
    }

    public static final class ComponentNumber extends ComponentParam {
        public static final Parcelable.Creator<ComponentNumber> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Number f29423a;

        public static final class a implements Parcelable.Creator<ComponentNumber> {
            /* renamed from: a */
            public final ComponentNumber createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ComponentNumber((Number) parcel.readSerializable());
            }

            /* renamed from: b */
            public final ComponentNumber[] newArray(int i10) {
                return new ComponentNumber[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ComponentNumber(Number number) {
            super((DefaultConstructorMarker) null);
            j.g(number, "value");
            this.f29423a = number;
        }

        public final Number a() {
            return this.f29423a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeSerializable(this.f29423a);
        }
    }

    public static final class ComponentString extends ComponentParam {
        public static final Parcelable.Creator<ComponentString> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f29424a;

        public static final class a implements Parcelable.Creator<ComponentString> {
            /* renamed from: a */
            public final ComponentString createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ComponentString(parcel.readString());
            }

            /* renamed from: b */
            public final ComponentString[] newArray(int i10) {
                return new ComponentString[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ComponentString(String str) {
            super((DefaultConstructorMarker) null);
            j.g(str, "value");
            this.f29424a = str;
        }

        public final String a() {
            return this.f29424a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29424a);
        }
    }

    public static final class ComponentStringList extends ComponentParam {
        public static final Parcelable.Creator<ComponentStringList> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f29425a;

        public static final class a implements Parcelable.Creator<ComponentStringList> {
            /* renamed from: a */
            public final ComponentStringList createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ComponentStringList(parcel.createStringArrayList());
            }

            /* renamed from: b */
            public final ComponentStringList[] newArray(int i10) {
                return new ComponentStringList[i10];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ComponentStringList(List<String> list) {
            super((DefaultConstructorMarker) null);
            j.g(list, "value");
            this.f29425a = list;
        }

        public final List<String> a() {
            return this.f29425a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeStringList(this.f29425a);
        }
    }

    public static final class ESignature extends ComponentParam {
        public static final Parcelable.Creator<ESignature> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private String f29426a;

        public static final class a implements Parcelable.Creator<ESignature> {
            /* renamed from: a */
            public final ESignature createFromParcel(Parcel parcel) {
                j.g(parcel, "parcel");
                return new ESignature(parcel.readString());
            }

            /* renamed from: b */
            public final ESignature[] newArray(int i10) {
                return new ESignature[i10];
            }
        }

        public ESignature(String str) {
            super((DefaultConstructorMarker) null);
            this.f29426a = str;
        }

        public final String a() {
            return this.f29426a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.f29426a);
        }
    }

    private ComponentParam() {
    }

    public /* synthetic */ ComponentParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
