package com.withpersona.sdk2.inquiry.document.network;

import java.util.List;
import kotlin.coroutines.c;
import okhttp3.w;
import retrofit2.r;
import vn.b;
import vn.f;
import vn.i;
import vn.k;
import vn.l;
import vn.o;
import vn.q;
import vn.s;

public interface a {
    @o("/api/internal/verify/v1/documents")
    Object a(@i("Authorization") String str, @vn.a CreateDocumentRequest createDocumentRequest, c<? super r<CreateDocumentResponse>> cVar);

    @f("/api/internal/verify/v1/documents/{documentId}")
    Object b(@i("Authorization") String str, @s("documentId") String str2, c<? super r<CreateDocumentResponse>> cVar);

    @l
    @k({"Accept: multipart/form-data"})
    @o("/api/internal/verify/v1/document-files")
    Object c(@i("Authorization") String str, @q List<w.c> list, c<? super r<DocumentFileUploadResponse>> cVar);

    @b("/api/internal/verify/v1/document-files/{fileId}")
    Object d(@i("Authorization") String str, @s("fileId") String str2, c<? super r<?>> cVar);

    @o("/api/internal/verify/v1/inquiries/{inquiryId}/transition")
    Object e(@i("Authorization") String str, @s("inquiryId") String str2, @vn.a SubmitDocumentRequest submitDocumentRequest, c<? super r<?>> cVar);
}
