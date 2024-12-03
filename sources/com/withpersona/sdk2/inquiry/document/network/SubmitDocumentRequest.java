package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class SubmitDocumentRequest {

    /* renamed from: c  reason: collision with root package name */
    public static final a f25256c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Data f25257a;

    /* renamed from: b  reason: collision with root package name */
    private final Meta f25258b;

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f25260a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25261b;

        public Meta(String str, String str2) {
            j.g(str, "fromStep");
            j.g(str2, "fromComponent");
            this.f25260a = str;
            this.f25261b = str2;
        }

        public final String a() {
            return this.f25261b;
        }

        public final String b() {
            return this.f25260a;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubmitDocumentRequest a(String str, String str2) {
            j.g(str, "fromStep");
            j.g(str2, "fromComponent");
            return new SubmitDocumentRequest((Data) null, new Meta(str, str2), 1, (DefaultConstructorMarker) null);
        }
    }

    public SubmitDocumentRequest(Data data, Meta meta) {
        j.g(data, "data");
        j.g(meta, "meta");
        this.f25257a = data;
        this.f25258b = meta;
    }

    public final Data a() {
        return this.f25257a;
    }

    public final Meta b() {
        return this.f25258b;
    }

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f25259a;

        public Data() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public Data(String str) {
            j.g(str, "type");
            this.f25259a = str;
        }

        public final String a() {
            return this.f25259a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Data(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? "inquiry" : str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitDocumentRequest(Data data, Meta meta, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new Data((String) null, 1, (DefaultConstructorMarker) null) : data, meta);
    }
}
