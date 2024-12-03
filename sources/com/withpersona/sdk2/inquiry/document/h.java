package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class h {
    /* access modifiers changed from: private */
    public static final List<DocumentFile> c(List<String> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (String local : list) {
            arrayList.add(new DocumentFile.Local(local, CaptureMethod.UPLOAD, 0, 4, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final String d(GenericFileUploadErrorResponse.DocumentErrorResponse documentErrorResponse, Context context) {
        if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError) {
            GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError disabledFileTypeError = (GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError) documentErrorResponse;
            String string = context.getString(n.pi2_document_error_disabled_file_type, new Object[]{disabledFileTypeError.getDetails().getUploadedFileType(), CollectionsKt___CollectionsKt.W(disabledFileTypeError.getDetails().getEnabledFileTypes(), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)});
            j.f(string, "context.getString(\n     …oinToString(\", \")\n      )");
            return string;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.FileLimitExceededError) {
            String string2 = context.getString(n.pi2_document_error_file_limit_exceeded);
            j.f(string2, "context.getString(R.stri…rror_file_limit_exceeded)");
            return string2;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError) {
            String string3 = context.getString(n.pi2_document_error_page_limit_exceeded, new Object[]{Integer.valueOf(((GenericFileUploadErrorResponse.DocumentErrorResponse.PageLimitExceededError) documentErrorResponse).getDetails().getPageLimit())});
            j.f(string3, "context.getString(\n     …details.pageLimit\n      )");
            return string3;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedFileError) {
            String string4 = context.getString(n.pi2_document_error_malformed_image_or_file);
            j.f(string4, "context.getString(R.stri…_malformed_image_or_file)");
            return string4;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedImageError) {
            String string5 = context.getString(n.pi2_document_error_malformed_image_or_file);
            j.f(string5, "context.getString(R.stri…_malformed_image_or_file)");
            return string5;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.MalformedPdfError) {
            String string6 = context.getString(n.pi2_document_error_malformed_pdf);
            j.f(string6, "context.getString(R.stri…ment_error_malformed_pdf)");
            return string6;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError) {
            String string7 = context.getString(n.pi2_document_error_government_id_min_dimension_size, new Object[]{Integer.valueOf(((GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError) documentErrorResponse).getDetails().getMinDimensionSize())});
            j.f(string7, "context.getString(\n     ….minDimensionSize\n      )");
            return string7;
        } else if (documentErrorResponse instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError) {
            String string8 = context.getString(n.pi2_document_error_unable_to_add_file);
            j.f(string8, "context.getString(R.stri…error_unable_to_add_file)");
            return string8;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
