package com.withpersona.sdk2.inquiry.internal.network;

import com.leanplum.internal.Constants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import com.withpersona.sdk2.inquiry.internal.Environment;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CreateInquiryRequest {

    /* renamed from: b  reason: collision with root package name */
    public static final b f26422b = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Data f26423a;

    public static final class Data {

        /* renamed from: c  reason: collision with root package name */
        public static final Adapter f26424c = new Adapter((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final a f26425a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26426b;

        public static final class Adapter {
            private Adapter() {
            }

            public /* synthetic */ Adapter(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @f
            public final Data fromJson(JsonReader jsonReader) {
                j.g(jsonReader, "reader");
                jsonReader.b();
                String str = "";
                String str2 = str;
                while (jsonReader.g()) {
                    String u10 = jsonReader.u();
                    if (j.b(u10, "templateId")) {
                        str = jsonReader.y();
                        j.f(str, "reader.nextString()");
                    } else if (j.b(u10, "environment")) {
                        str2 = jsonReader.y();
                        j.f(str2, "reader.nextString()");
                    } else {
                        jsonReader.Y();
                    }
                }
                jsonReader.e();
                return new Data(new a(str, (String) null, str2, (String) null, (String) null, (String) null, (Map) null, 122, (DefaultConstructorMarker) null), (String) null, 2, (DefaultConstructorMarker) null);
            }

            @v
            public final void toJson(q qVar, Data data) {
                j.g(qVar, "jsonWriter");
                j.g(data, "data");
                qVar.c();
                qVar.u("attributes");
                qVar.c();
                String f10 = data.a().f();
                if (f10 != null) {
                    qVar.u("inquiryTemplateId").S(f10);
                }
                String g10 = data.a().g();
                if (g10 != null) {
                    qVar.u("inquiryTemplateVersionId").S(g10);
                }
                qVar.u("environment").S(data.a().b());
                String a10 = data.a().a();
                if (a10 != null) {
                    qVar.u(Constants.Params.CT_ACCOUNT_ID).S(a10);
                }
                String e10 = data.a().e();
                if (e10 != null) {
                    qVar.u("referenceId").S(e10);
                }
                String d10 = data.a().d();
                if (d10 != null) {
                    qVar.u("note").S(d10);
                }
                if (data.a().c() != null) {
                    qVar.u("fields");
                    InquiryFieldMap.f26121b.toJson(qVar, new InquiryFieldMap(data.a().c()));
                }
                qVar.h();
                qVar.h();
            }
        }

        public Data(a aVar, String str) {
            j.g(aVar, "attributes");
            j.g(str, "type");
            this.f26425a = aVar;
            this.f26426b = str;
        }

        public final a a() {
            return this.f26425a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(a aVar, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, (i10 & 2) != 0 ? "inquiry" : str);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateInquiryRequest a(String str, String str2, Environment environment, String str3, String str4, Map<String, ? extends InquiryField> map) {
            j.g(environment, "environment");
            return new CreateInquiryRequest(new Data(new a(str, str2, environment.b(), str3, str4, (String) null, map, 32, (DefaultConstructorMarker) null), (String) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public CreateInquiryRequest(Data data) {
        j.g(data, "data");
        this.f26423a = data;
    }

    public final Data a() {
        return this.f26423a;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f26427a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26428b;

        /* renamed from: c  reason: collision with root package name */
        private final String f26429c;

        /* renamed from: d  reason: collision with root package name */
        private final String f26430d;

        /* renamed from: e  reason: collision with root package name */
        private final String f26431e;

        /* renamed from: f  reason: collision with root package name */
        private final String f26432f;

        /* renamed from: g  reason: collision with root package name */
        private final Map<String, InquiryField> f26433g;

        public a(String str, String str2, String str3, String str4, String str5, String str6, Map<String, ? extends InquiryField> map) {
            j.g(str3, "environment");
            this.f26427a = str;
            this.f26428b = str2;
            this.f26429c = str3;
            this.f26430d = str4;
            this.f26431e = str5;
            this.f26432f = str6;
            this.f26433g = map;
        }

        public final String a() {
            return this.f26430d;
        }

        public final String b() {
            return this.f26429c;
        }

        public final Map<String, InquiryField> c() {
            return this.f26433g;
        }

        public final String d() {
            return this.f26432f;
        }

        public final String e() {
            return this.f26431e;
        }

        public final String f() {
            return this.f26427a;
        }

        public final String g() {
            return this.f26428b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, String str6, Map map, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : map);
        }
    }
}
