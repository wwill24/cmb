package com.withpersona.sdk2.inquiry.internal.network;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CreateInquirySessionResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Data f26449a;

    /* renamed from: b  reason: collision with root package name */
    private final Meta f26450b;

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f26451a;

        public Data(String str) {
            j.g(str, "id");
            this.f26451a = str;
        }

        public final String a() {
            return this.f26451a;
        }
    }

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f26452a;

        public Meta(String str) {
            j.g(str, SDKConstants.PARAM_ACCESS_TOKEN);
            this.f26452a = str;
        }

        public final String a() {
            return this.f26452a;
        }
    }

    public CreateInquirySessionResponse(Data data, Meta meta) {
        j.g(data, "data");
        j.g(meta, "meta");
        this.f26449a = data;
        this.f26450b = meta;
    }

    public final Data a() {
        return this.f26449a;
    }

    public final Meta b() {
        return this.f26450b;
    }
}
