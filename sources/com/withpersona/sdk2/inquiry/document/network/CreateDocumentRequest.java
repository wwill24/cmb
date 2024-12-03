package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CreateDocumentRequest {

    /* renamed from: c  reason: collision with root package name */
    public static final a f25163c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Data f25164a;

    /* renamed from: b  reason: collision with root package name */
    private final Meta f25165b;

    @i(generateAdapter = true)
    public static final class Attributes {

        /* renamed from: a  reason: collision with root package name */
        private final String f25166a;

        /* renamed from: b  reason: collision with root package name */
        private final int f25167b;

        public Attributes(String str, int i10) {
            j.g(str, "kind");
            this.f25166a = str;
            this.f25167b = i10;
        }

        public final int a() {
            return this.f25167b;
        }

        public final String b() {
            return this.f25166a;
        }
    }

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f25168a;

        /* renamed from: b  reason: collision with root package name */
        private final Attributes f25169b;

        public Data(String str, Attributes attributes) {
            j.g(str, "type");
            j.g(attributes, "attributes");
            this.f25168a = str;
            this.f25169b = attributes;
        }

        public final Attributes a() {
            return this.f25169b;
        }

        public final String b() {
            return this.f25168a;
        }
    }

    @i(generateAdapter = true)
    public static final class Meta {

        /* renamed from: a  reason: collision with root package name */
        private final String f25170a;

        public Meta(String str) {
            j.g(str, "fieldKeyDocument");
            this.f25170a = str;
        }

        public final String a() {
            return this.f25170a;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreateDocumentRequest a(String str, String str2, int i10, String str3) {
            j.g(str, "type");
            j.g(str2, "kind");
            j.g(str3, "fieldKeyDocument");
            return new CreateDocumentRequest(new Data(str, new Attributes(str2, i10)), new Meta(str3));
        }
    }

    public CreateDocumentRequest(Data data, Meta meta) {
        j.g(data, "data");
        j.g(meta, "meta");
        this.f25164a = data;
        this.f25165b = meta;
    }

    public final Data a() {
        return this.f25164a;
    }

    public final Meta b() {
        return this.f25165b;
    }
}
