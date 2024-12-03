package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CreateInquirySessionRequest {

    /* renamed from: c  reason: collision with root package name */
    public static final a f26436c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Data f26437a;

    /* renamed from: b  reason: collision with root package name */
    private final Meta f26438b;

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f26440a;

        public Meta(String str) {
            j.g(str, "inquiryId");
            this.f26440a = str;
        }

        public final String a() {
            return this.f26440a;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateInquirySessionRequest a(String str) {
            j.g(str, "inquiryId");
            return new CreateInquirySessionRequest(new Data((String) null, 1, (DefaultConstructorMarker) null), new Meta(str));
        }
    }

    public CreateInquirySessionRequest(Data data, Meta meta) {
        j.g(data, "data");
        j.g(meta, "meta");
        this.f26437a = data;
        this.f26438b = meta;
    }

    public final Data a() {
        return this.f26437a;
    }

    public final Meta b() {
        return this.f26438b;
    }

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f26439a;

        public Data() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public Data(String str) {
            j.g(str, "type");
            this.f26439a = str;
        }

        public final String a() {
            return this.f26439a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? "inquiry-session" : str);
        }
    }
}
