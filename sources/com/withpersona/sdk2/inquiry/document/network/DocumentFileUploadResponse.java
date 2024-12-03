package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.moshi.i;
import kotlin.jvm.internal.j;

@i(generateAdapter = true)
public final class DocumentFileUploadResponse {

    /* renamed from: a  reason: collision with root package name */
    private final DocumentFileData f25217a;

    public DocumentFileUploadResponse(DocumentFileData documentFileData) {
        j.g(documentFileData, "data");
        this.f25217a = documentFileData;
    }

    public final DocumentFileData a() {
        return this.f25217a;
    }
}
