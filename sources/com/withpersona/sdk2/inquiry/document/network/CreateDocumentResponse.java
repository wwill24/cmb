package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.moshi.i;
import java.util.List;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class CreateDocumentResponse {

    /* renamed from: a  reason: collision with root package name */
    private final Data f25182a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DocumentFileData> f25183b;

    @i(generateAdapter = true)
    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        private final String f25184a;

        public Data(String str) {
            j.g(str, "id");
            this.f25184a = str;
        }

        public final String a() {
            return this.f25184a;
        }
    }

    public CreateDocumentResponse(Data data, List<DocumentFileData> list) {
        j.g(data, "data");
        this.f25182a = data;
        this.f25183b = list;
    }

    public final Data a() {
        return this.f25182a;
    }

    public final List<DocumentFileData> b() {
        return this.f25183b;
    }
}
