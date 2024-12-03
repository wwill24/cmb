package com.withpersona.sdk2.inquiry.ui.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.v;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@i(generateAdapter = true)
public final class UiTransitionErrorResponse {

    /* renamed from: b  reason: collision with root package name */
    public static final a f29477b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final UiTransitionErrorResponse f29478c = new UiTransitionErrorResponse(q.j());

    /* renamed from: a  reason: collision with root package name */
    private final List<Error> f29479a;

    @i(generateAdapter = true)
    public static final class Error {

        /* renamed from: a  reason: collision with root package name */
        private final String f29480a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, UiComponentError> f29481b;

        public Error(String str, Map<String, ? extends UiComponentError> map) {
            this.f29480a = str;
            this.f29481b = map;
        }

        public final Map<String, UiComponentError> a() {
            return this.f29481b;
        }

        public final String b() {
            return this.f29480a;
        }
    }

    public static abstract class UiComponentError implements Parcelable {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f29482a = new Companion((DefaultConstructorMarker) null);

        public static final class Companion extends h<UiComponentError> {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final String a(JsonReader jsonReader) {
                JsonReader F = jsonReader.F();
                F.b();
                while (F.g()) {
                    if (j.b(F.u(), "type")) {
                        return F.y();
                    }
                    F.Y();
                }
                return null;
            }

            @v
            public void toJson(q qVar, UiComponentError uiComponentError) {
                j.g(qVar, "writer");
            }

            @f
            public UiComponentError fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                s d10 = new s.b().d();
                String a10 = a(jsonReader);
                if (a10 == null) {
                    return null;
                }
                if (j.b(a10, "input_address")) {
                    return d10.c(UiInputAddressComponentError.class).fromJson(jsonReader);
                }
                return d10.c(UiInputComponentError.class).fromJson(jsonReader);
            }
        }

        @i(generateAdapter = true)
        public static final class UiInputAddressComponentError extends UiComponentError {
            public static final Parcelable.Creator<UiInputAddressComponentError> CREATOR = new a();

            /* renamed from: b  reason: collision with root package name */
            private final String f29483b;

            /* renamed from: c  reason: collision with root package name */
            private final String f29484c;

            /* renamed from: d  reason: collision with root package name */
            private final Map<String, String> f29485d;

            public static final class a implements Parcelable.Creator<UiInputAddressComponentError> {
                /* renamed from: a */
                public final UiInputAddressComponentError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                    for (int i10 = 0; i10 != readInt; i10++) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                    }
                    return new UiInputAddressComponentError(readString, readString2, linkedHashMap);
                }

                /* renamed from: b */
                public final UiInputAddressComponentError[] newArray(int i10) {
                    return new UiInputAddressComponentError[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UiInputAddressComponentError(String str, String str2, Map<String, String> map) {
                super((DefaultConstructorMarker) null);
                j.g(str, "name");
                j.g(str2, "type");
                j.g(map, "message");
                this.f29483b = str;
                this.f29484c = str2;
                this.f29485d = map;
            }

            public String a() {
                return this.f29483b;
            }

            public final Map<String, String> c() {
                return this.f29485d;
            }

            public String d() {
                return this.f29484c;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UiInputAddressComponentError)) {
                    return false;
                }
                UiInputAddressComponentError uiInputAddressComponentError = (UiInputAddressComponentError) obj;
                return j.b(a(), uiInputAddressComponentError.a()) && j.b(d(), uiInputAddressComponentError.d()) && j.b(this.f29485d, uiInputAddressComponentError.f29485d);
            }

            public int hashCode() {
                return (((a().hashCode() * 31) + d().hashCode()) * 31) + this.f29485d.hashCode();
            }

            public String toString() {
                return "UiInputAddressComponentError(name=" + a() + ", type=" + d() + ", message=" + this.f29485d + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f29483b);
                parcel.writeString(this.f29484c);
                Map<String, String> map = this.f29485d;
                parcel.writeInt(map.size());
                for (Map.Entry next : map.entrySet()) {
                    parcel.writeString((String) next.getKey());
                    parcel.writeString((String) next.getValue());
                }
            }
        }

        @i(generateAdapter = true)
        public static final class UiInputComponentError extends UiComponentError {
            public static final Parcelable.Creator<UiInputComponentError> CREATOR = new a();

            /* renamed from: b  reason: collision with root package name */
            private final String f29486b;

            /* renamed from: c  reason: collision with root package name */
            private final String f29487c;

            /* renamed from: d  reason: collision with root package name */
            private final String f29488d;

            public static final class a implements Parcelable.Creator<UiInputComponentError> {
                /* renamed from: a */
                public final UiInputComponentError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new UiInputComponentError(parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: b */
                public final UiInputComponentError[] newArray(int i10) {
                    return new UiInputComponentError[i10];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UiInputComponentError(String str, String str2, String str3) {
                super((DefaultConstructorMarker) null);
                j.g(str, "name");
                j.g(str2, "type");
                j.g(str3, "message");
                this.f29486b = str;
                this.f29487c = str2;
                this.f29488d = str3;
            }

            public String a() {
                return this.f29486b;
            }

            public final String c() {
                return this.f29488d;
            }

            public String d() {
                return this.f29487c;
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UiInputComponentError)) {
                    return false;
                }
                UiInputComponentError uiInputComponentError = (UiInputComponentError) obj;
                return j.b(a(), uiInputComponentError.a()) && j.b(d(), uiInputComponentError.d()) && j.b(this.f29488d, uiInputComponentError.f29488d);
            }

            public int hashCode() {
                return (((a().hashCode() * 31) + d().hashCode()) * 31) + this.f29488d.hashCode();
            }

            public String toString() {
                return "UiInputComponentError(name=" + a() + ", type=" + d() + ", message=" + this.f29488d + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.f29486b);
                parcel.writeString(this.f29487c);
                parcel.writeString(this.f29488d);
            }
        }

        private UiComponentError() {
        }

        public /* synthetic */ UiComponentError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String a();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UiTransitionErrorResponse a() {
            return UiTransitionErrorResponse.f29478c;
        }
    }

    public UiTransitionErrorResponse(List<Error> list) {
        this.f29479a = list;
    }

    public final List<Error> b() {
        return this.f29479a;
    }
}
