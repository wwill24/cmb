package com.withpersona.sdk2.inquiry.network;

import ai.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.g;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.i18n.ErrorBundle;
import ti.d;

@i(generateAdapter = true)
public final class GenericFileUploadErrorResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<DocumentErrorResponse> errors;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h.e getAdapter() {
            b<DocumentErrorResponse> e10 = b.b(DocumentErrorResponse.class, "code").e(DocumentErrorResponse.DisabledFileTypeError.class, "document-generic-disabled-file-type-error").e(DocumentErrorResponse.FileLimitExceededError.class, "document-generic-file-limit-exceeded-error").e(DocumentErrorResponse.PageLimitExceededError.class, "document-generic-page-limit-exceeded-error").e(DocumentErrorResponse.MalformedFileError.class, "document-generic-malformed-file-error").e(DocumentErrorResponse.MalformedImageError.class, "document-generic-malformed-image-error").e(DocumentErrorResponse.MalformedPdfError.class, "document-generic-malformed-pdf-error").e(DocumentErrorResponse.GovernmentIdDimensionSizeError.class, "document-government-id-dimension-size-error");
            UnknownErrorAdapter unknownErrorAdapter = UnknownErrorAdapter.INSTANCE;
            j.e(unknownErrorAdapter, "null cannot be cast to non-null type com.squareup.moshi.JsonAdapter<kotlin.Any>");
            b<DocumentErrorResponse> d10 = e10.d(unknownErrorAdapter);
            j.f(d10, "of(DocumentErrorResponse…pter as JsonAdapter<Any>)");
            return d10;
        }
    }

    public static abstract class DocumentErrorResponse implements Parcelable {

        @i(generateAdapter = true)
        public static final class DisabledFileTypeError extends DocumentErrorResponse {
            public static final Parcelable.Creator<DisabledFileTypeError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<DisabledFileTypeError> {
                public final DisabledFileTypeError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new DisabledFileTypeError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final DisabledFileTypeError[] newArray(int i10) {
                    return new DisabledFileTypeError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();
                private final List<String> enabledFileTypes;
                private final String uploadedFileType;

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        return new Details(parcel.readString(), parcel.createStringArrayList());
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public Details(@g(name = "uploaded_file_type") String str, @g(name = "enabled_file_types") List<String> list) {
                    j.g(str, "uploadedFileType");
                    j.g(list, "enabledFileTypes");
                    this.uploadedFileType = str;
                    this.enabledFileTypes = list;
                }

                public int describeContents() {
                    return 0;
                }

                public final List<String> getEnabledFileTypes() {
                    return this.enabledFileTypes;
                }

                public final String getUploadedFileType() {
                    return this.uploadedFileType;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeString(this.uploadedFileType);
                    parcel.writeStringList(this.enabledFileTypes);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DisabledFileTypeError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class FileLimitExceededError extends DocumentErrorResponse {
            public static final Parcelable.Creator<FileLimitExceededError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<FileLimitExceededError> {
                public final FileLimitExceededError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new FileLimitExceededError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final FileLimitExceededError[] newArray(int i10) {
                    return new FileLimitExceededError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        parcel.readInt();
                        return new Details();
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FileLimitExceededError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class GovernmentIdDimensionSizeError extends DocumentErrorResponse {
            public static final Parcelable.Creator<GovernmentIdDimensionSizeError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<GovernmentIdDimensionSizeError> {
                public final GovernmentIdDimensionSizeError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new GovernmentIdDimensionSizeError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final GovernmentIdDimensionSizeError[] newArray(int i10) {
                    return new GovernmentIdDimensionSizeError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();
                private final int maxDimensionSize;
                private final int minDimensionSize;

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        return new Details(parcel.readInt(), parcel.readInt());
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public Details(@g(name = "min_dimension_size") int i10, @g(name = "max_dimension_size") int i11) {
                    this.minDimensionSize = i10;
                    this.maxDimensionSize = i11;
                }

                public int describeContents() {
                    return 0;
                }

                public final int getMaxDimensionSize() {
                    return this.maxDimensionSize;
                }

                public final int getMinDimensionSize() {
                    return this.minDimensionSize;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(this.minDimensionSize);
                    parcel.writeInt(this.maxDimensionSize);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GovernmentIdDimensionSizeError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class MalformedFileError extends DocumentErrorResponse {
            public static final Parcelable.Creator<MalformedFileError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<MalformedFileError> {
                public final MalformedFileError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new MalformedFileError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final MalformedFileError[] newArray(int i10) {
                    return new MalformedFileError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        parcel.readInt();
                        return new Details();
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MalformedFileError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class MalformedImageError extends DocumentErrorResponse {
            public static final Parcelable.Creator<MalformedImageError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<MalformedImageError> {
                public final MalformedImageError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new MalformedImageError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final MalformedImageError[] newArray(int i10) {
                    return new MalformedImageError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        parcel.readInt();
                        return new Details();
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MalformedImageError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class MalformedPdfError extends DocumentErrorResponse {
            public static final Parcelable.Creator<MalformedPdfError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<MalformedPdfError> {
                public final MalformedPdfError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new MalformedPdfError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final MalformedPdfError[] newArray(int i10) {
                    return new MalformedPdfError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        parcel.readInt();
                        return new Details();
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public int describeContents() {
                    return 0;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(1);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MalformedPdfError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class PageLimitExceededError extends DocumentErrorResponse {
            public static final Parcelable.Creator<PageLimitExceededError> CREATOR = new Creator();
            private final String code;
            private final Details details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<PageLimitExceededError> {
                public final PageLimitExceededError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new PageLimitExceededError(parcel.readString(), parcel.readString(), Details.CREATOR.createFromParcel(parcel));
                }

                public final PageLimitExceededError[] newArray(int i10) {
                    return new PageLimitExceededError[i10];
                }
            }

            @i(generateAdapter = true)
            public static final class Details implements ErrorDetails {
                public static final Parcelable.Creator<Details> CREATOR = new Creator();
                private final int pageLimit;

                public static final class Creator implements Parcelable.Creator<Details> {
                    public final Details createFromParcel(Parcel parcel) {
                        j.g(parcel, "parcel");
                        return new Details(parcel.readInt());
                    }

                    public final Details[] newArray(int i10) {
                        return new Details[i10];
                    }
                }

                public Details(@g(name = "page_limit") int i10) {
                    this.pageLimit = i10;
                }

                public int describeContents() {
                    return 0;
                }

                public final int getPageLimit() {
                    return this.pageLimit;
                }

                public void writeToParcel(Parcel parcel, int i10) {
                    j.g(parcel, "out");
                    parcel.writeInt(this.pageLimit);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PageLimitExceededError(String str, String str2, Details details2) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                j.g(str2, "code");
                j.g(details2, ErrorBundle.DETAIL_ENTRY);
                this.title = str;
                this.code = str2;
                this.details = details2;
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                this.details.writeToParcel(parcel, i10);
            }

            public Details getDetails() {
                return this.details;
            }
        }

        @i(generateAdapter = true)
        public static final class UnknownError extends DocumentErrorResponse {
            public static final Parcelable.Creator<UnknownError> CREATOR = new Creator();
            private final String code;
            private final ErrorDetails details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<UnknownError> {
                public final UnknownError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new UnknownError(parcel.readString(), parcel.readString(), (ErrorDetails) parcel.readParcelable(UnknownError.class.getClassLoader()));
                }

                public final UnknownError[] newArray(int i10) {
                    return new UnknownError[i10];
                }
            }

            public UnknownError() {
                this((String) null, (String) null, (ErrorDetails) null, 7, (DefaultConstructorMarker) null);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ UnknownError(String str, String str2, ErrorDetails errorDetails, int i10, DefaultConstructorMarker defaultConstructorMarker) {
                this((i10 & 1) != 0 ? "Unknown Error" : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : errorDetails);
            }

            public int describeContents() {
                return 0;
            }

            public String getCode() {
                return this.code;
            }

            public ErrorDetails getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.code);
                parcel.writeParcelable(this.details, i10);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public UnknownError(String str, String str2, ErrorDetails errorDetails) {
                super((DefaultConstructorMarker) null);
                j.g(str, "title");
                this.title = str;
                this.code = str2;
                this.details = errorDetails;
            }
        }

        private DocumentErrorResponse() {
        }

        public /* synthetic */ DocumentErrorResponse(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getCode();

        public abstract ErrorDetails getDetails();

        public abstract String getTitle();
    }

    private static final class UnknownErrorAdapter extends h<DocumentErrorResponse.UnknownError> {
        public static final UnknownErrorAdapter INSTANCE = new UnknownErrorAdapter();

        private UnknownErrorAdapter() {
        }

        public DocumentErrorResponse.UnknownError fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            jsonReader.b();
            String str = null;
            String str2 = null;
            while (jsonReader.g()) {
                String u10 = jsonReader.u();
                if (j.b(u10, "title")) {
                    str = d.a(jsonReader);
                } else if (j.b(u10, "code")) {
                    str2 = d.a(jsonReader);
                } else {
                    jsonReader.Y();
                }
            }
            jsonReader.e();
            if (str == null) {
                str = "Unknown Error";
            }
            return new DocumentErrorResponse.UnknownError(str, str2, (ErrorDetails) null, 4, (DefaultConstructorMarker) null);
        }

        public void toJson(q qVar, DocumentErrorResponse.UnknownError unknownError) {
            j.g(qVar, "writer");
            qVar.c();
            qVar.u("title");
            String str = null;
            qVar.S(unknownError != null ? unknownError.getTitle() : null);
            qVar.u("code");
            if (unknownError != null) {
                str = unknownError.getCode();
            }
            qVar.S(str);
            qVar.h();
        }
    }

    public GenericFileUploadErrorResponse(List<? extends DocumentErrorResponse> list) {
        j.g(list, IdentityHttpResponse.ERRORS);
        this.errors = list;
    }

    public static /* synthetic */ GenericFileUploadErrorResponse copy$default(GenericFileUploadErrorResponse genericFileUploadErrorResponse, List<DocumentErrorResponse> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = genericFileUploadErrorResponse.errors;
        }
        return genericFileUploadErrorResponse.copy(list);
    }

    public final List<DocumentErrorResponse> component1() {
        return this.errors;
    }

    public final GenericFileUploadErrorResponse copy(List<? extends DocumentErrorResponse> list) {
        j.g(list, IdentityHttpResponse.ERRORS);
        return new GenericFileUploadErrorResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GenericFileUploadErrorResponse) && j.b(this.errors, ((GenericFileUploadErrorResponse) obj).errors);
    }

    public final List<DocumentErrorResponse> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        return this.errors.hashCode();
    }

    public String toString() {
        return "GenericFileUploadErrorResponse(errors=" + this.errors + PropertyUtils.MAPPED_DELIM2;
    }
}
