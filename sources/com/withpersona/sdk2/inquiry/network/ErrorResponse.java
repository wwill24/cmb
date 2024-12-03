package com.withpersona.sdk2.inquiry.network;

import ai.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import org.apache.commons.beanutils.PropertyUtils;
import ti.d;

@i(generateAdapter = true)
public final class ErrorResponse {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<Error> errors;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorResponse create(String str) {
            return new ErrorResponse(p.e(new Error.UnknownError(str, (String) null)));
        }

        public final h.e getAdapter() {
            return ErrorJsonAdapterFactory.INSTANCE;
        }
    }

    public static abstract class Error implements Parcelable {

        @i(generateAdapter = true)
        public static final class FieldNotFoundError extends Error {
            public static final Parcelable.Creator<FieldNotFoundError> CREATOR = new Creator();
            private final String details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<FieldNotFoundError> {
                public final FieldNotFoundError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new FieldNotFoundError(parcel.readString(), parcel.readString());
                }

                public final FieldNotFoundError[] newArray(int i10) {
                    return new FieldNotFoundError[i10];
                }
            }

            public FieldNotFoundError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.details = str2;
            }

            public static /* synthetic */ FieldNotFoundError copy$default(FieldNotFoundError fieldNotFoundError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = fieldNotFoundError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = fieldNotFoundError.details;
                }
                return fieldNotFoundError.copy(str, str2);
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.details;
            }

            public final FieldNotFoundError copy(String str, String str2) {
                return new FieldNotFoundError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FieldNotFoundError)) {
                    return false;
                }
                FieldNotFoundError fieldNotFoundError = (FieldNotFoundError) obj;
                return j.b(getTitle(), fieldNotFoundError.getTitle()) && j.b(this.details, fieldNotFoundError.details);
            }

            public String getDescription() {
                return this.details;
            }

            public final String getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.details;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "FieldNotFoundError(title=" + getTitle() + ", details=" + this.details + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.details);
            }
        }

        @i(generateAdapter = true)
        public static final class InactiveTemplateError extends Error {
            public static final Parcelable.Creator<InactiveTemplateError> CREATOR = new Creator();
            private final String details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<InactiveTemplateError> {
                public final InactiveTemplateError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new InactiveTemplateError(parcel.readString(), parcel.readString());
                }

                public final InactiveTemplateError[] newArray(int i10) {
                    return new InactiveTemplateError[i10];
                }
            }

            public InactiveTemplateError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.details = str2;
            }

            public static /* synthetic */ InactiveTemplateError copy$default(InactiveTemplateError inactiveTemplateError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = inactiveTemplateError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = inactiveTemplateError.details;
                }
                return inactiveTemplateError.copy(str, str2);
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.details;
            }

            public final InactiveTemplateError copy(String str, String str2) {
                return new InactiveTemplateError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InactiveTemplateError)) {
                    return false;
                }
                InactiveTemplateError inactiveTemplateError = (InactiveTemplateError) obj;
                return j.b(getTitle(), inactiveTemplateError.getTitle()) && j.b(this.details, inactiveTemplateError.details);
            }

            public String getDescription() {
                return this.details;
            }

            public final String getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.details;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "InactiveTemplateError(title=" + getTitle() + ", details=" + this.details + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.details);
            }
        }

        @i(generateAdapter = true)
        public static final class InconsistentTransitionError extends Error {
            public static final Parcelable.Creator<InconsistentTransitionError> CREATOR = new Creator();
            private final String details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<InconsistentTransitionError> {
                public final InconsistentTransitionError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new InconsistentTransitionError(parcel.readString(), parcel.readString());
                }

                public final InconsistentTransitionError[] newArray(int i10) {
                    return new InconsistentTransitionError[i10];
                }
            }

            public InconsistentTransitionError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.details = str2;
            }

            public static /* synthetic */ InconsistentTransitionError copy$default(InconsistentTransitionError inconsistentTransitionError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = inconsistentTransitionError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = inconsistentTransitionError.details;
                }
                return inconsistentTransitionError.copy(str, str2);
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.details;
            }

            public final InconsistentTransitionError copy(String str, String str2) {
                return new InconsistentTransitionError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InconsistentTransitionError)) {
                    return false;
                }
                InconsistentTransitionError inconsistentTransitionError = (InconsistentTransitionError) obj;
                return j.b(getTitle(), inconsistentTransitionError.getTitle()) && j.b(this.details, inconsistentTransitionError.details);
            }

            public String getDescription() {
                return this.details;
            }

            public final String getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.details;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "InconsistentTransitionError(title=" + getTitle() + ", details=" + this.details + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.details);
            }
        }

        @i(generateAdapter = true)
        public static final class InvalidConfigError extends Error {
            public static final Parcelable.Creator<InvalidConfigError> CREATOR = new Creator();
            private final String details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<InvalidConfigError> {
                public final InvalidConfigError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new InvalidConfigError(parcel.readString(), parcel.readString());
                }

                public final InvalidConfigError[] newArray(int i10) {
                    return new InvalidConfigError[i10];
                }
            }

            public InvalidConfigError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.details = str2;
            }

            public static /* synthetic */ InvalidConfigError copy$default(InvalidConfigError invalidConfigError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = invalidConfigError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = invalidConfigError.details;
                }
                return invalidConfigError.copy(str, str2);
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.details;
            }

            public final InvalidConfigError copy(String str, String str2) {
                return new InvalidConfigError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InvalidConfigError)) {
                    return false;
                }
                InvalidConfigError invalidConfigError = (InvalidConfigError) obj;
                return j.b(getTitle(), invalidConfigError.getTitle()) && j.b(this.details, invalidConfigError.details);
            }

            public String getDescription() {
                return this.details;
            }

            public final String getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.details;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "InvalidConfigError(title=" + getTitle() + ", details=" + this.details + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.details);
            }
        }

        @i(generateAdapter = true)
        public static final class UnauthenticatedError extends Error {
            public static final Parcelable.Creator<UnauthenticatedError> CREATOR = new Creator();
            private final String details;
            private final String title;

            public static final class Creator implements Parcelable.Creator<UnauthenticatedError> {
                public final UnauthenticatedError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new UnauthenticatedError(parcel.readString(), parcel.readString());
                }

                public final UnauthenticatedError[] newArray(int i10) {
                    return new UnauthenticatedError[i10];
                }
            }

            public UnauthenticatedError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.details = str2;
            }

            public static /* synthetic */ UnauthenticatedError copy$default(UnauthenticatedError unauthenticatedError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = unauthenticatedError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = unauthenticatedError.details;
                }
                return unauthenticatedError.copy(str, str2);
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.details;
            }

            public final UnauthenticatedError copy(String str, String str2) {
                return new UnauthenticatedError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UnauthenticatedError)) {
                    return false;
                }
                UnauthenticatedError unauthenticatedError = (UnauthenticatedError) obj;
                return j.b(getTitle(), unauthenticatedError.getTitle()) && j.b(this.details, unauthenticatedError.details);
            }

            public String getDescription() {
                return this.details;
            }

            public final String getDetails() {
                return this.details;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.details;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public String toString() {
                return "UnauthenticatedError(title=" + getTitle() + ", details=" + this.details + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.details);
            }
        }

        @i(generateAdapter = true)
        public static final class UnknownError extends Error {
            public static final Parcelable.Creator<UnknownError> CREATOR = new Creator();
            private transient b0 errorBody;
            private final String originalCode;
            private final String title;

            public static final class Creator implements Parcelable.Creator<UnknownError> {
                public final UnknownError createFromParcel(Parcel parcel) {
                    j.g(parcel, "parcel");
                    return new UnknownError(parcel.readString(), parcel.readString());
                }

                public final UnknownError[] newArray(int i10) {
                    return new UnknownError[i10];
                }
            }

            public UnknownError(String str, String str2) {
                super((DefaultConstructorMarker) null);
                this.title = str;
                this.originalCode = str2;
            }

            public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = unknownError.getTitle();
                }
                if ((i10 & 2) != 0) {
                    str2 = unknownError.originalCode;
                }
                return unknownError.copy(str, str2);
            }

            public static /* synthetic */ void getErrorBody$annotations() {
            }

            public final String component1() {
                return getTitle();
            }

            public final String component2() {
                return this.originalCode;
            }

            public final UnknownError copy(String str, String str2) {
                return new UnknownError(str, str2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UnknownError)) {
                    return false;
                }
                UnknownError unknownError = (UnknownError) obj;
                return j.b(getTitle(), unknownError.getTitle()) && j.b(this.originalCode, unknownError.originalCode);
            }

            public String getDescription() {
                return getTitle();
            }

            public final b0 getErrorBody() {
                return this.errorBody;
            }

            public final String getOriginalCode() {
                return this.originalCode;
            }

            public String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int i10 = 0;
                int hashCode = (getTitle() == null ? 0 : getTitle().hashCode()) * 31;
                String str = this.originalCode;
                if (str != null) {
                    i10 = str.hashCode();
                }
                return hashCode + i10;
            }

            public final void setErrorBody(b0 b0Var) {
                this.errorBody = b0Var;
            }

            public String toString() {
                return "UnknownError(title=" + getTitle() + ", originalCode=" + this.originalCode + PropertyUtils.MAPPED_DELIM2;
            }

            public void writeToParcel(Parcel parcel, int i10) {
                j.g(parcel, "out");
                parcel.writeString(this.title);
                parcel.writeString(this.originalCode);
            }
        }

        private Error() {
        }

        public /* synthetic */ Error(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getDescription();

        public abstract String getTitle();
    }

    public static final class ErrorJsonAdapterFactory implements h.e {
        public static final ErrorJsonAdapterFactory INSTANCE = new ErrorJsonAdapterFactory();
        private static final String LABEL_KEY = "code";
        private static final b<Error> adapterFactory;

        static {
            b<Error> e10 = b.b(Error.class, "code").e(Error.InactiveTemplateError.class, "inactive_template_error").e(Error.InvalidConfigError.class, "invalid_config").e(Error.UnauthenticatedError.class, "unauthenticated").e(Error.InconsistentTransitionError.class, "inconsistent_transition_error").e(Error.FieldNotFoundError.class, "field_not_found_error").e(Error.UnknownError.class, "unknown_error");
            UnknownErrorAdapter unknownErrorAdapter = UnknownErrorAdapter.INSTANCE;
            j.e(unknownErrorAdapter, "null cannot be cast to non-null type com.squareup.moshi.JsonAdapter<kotlin.Any>");
            adapterFactory = e10.d(unknownErrorAdapter);
        }

        private ErrorJsonAdapterFactory() {
        }

        public h<?> create(Type type, Set<? extends Annotation> set, s sVar) {
            j.g(type, "type");
            j.g(set, "annotations");
            j.g(sVar, "moshi");
            h<?> create = adapterFactory.create(type, set, sVar);
            if (create == null) {
                return null;
            }
            return new ErrorResponse$ErrorJsonAdapterFactory$create$1(create).nullSafe();
        }

        public final boolean hasLabel(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            jsonReader.b();
            while (jsonReader.g()) {
                if (j.b(jsonReader.u(), "code")) {
                    return true;
                }
                jsonReader.Y();
            }
            return false;
        }
    }

    private static final class UnknownErrorAdapter extends h<Error.UnknownError> {
        public static final UnknownErrorAdapter INSTANCE = new UnknownErrorAdapter();

        private UnknownErrorAdapter() {
        }

        public Error.UnknownError fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            jsonReader.b();
            String str = null;
            String str2 = null;
            while (jsonReader.g()) {
                String u10 = jsonReader.u();
                if (j.b(u10, "code")) {
                    str2 = d.a(jsonReader);
                } else if (j.b(u10, "title")) {
                    str = d.a(jsonReader);
                } else {
                    jsonReader.Y();
                }
            }
            jsonReader.e();
            return new Error.UnknownError(str, str2);
        }

        public void toJson(q qVar, Error.UnknownError unknownError) {
            j.g(qVar, "writer");
            qVar.c();
            qVar.u("originalCode");
            String str = null;
            qVar.S(unknownError != null ? unknownError.getOriginalCode() : null);
            qVar.u("title");
            if (unknownError != null) {
                str = unknownError.getTitle();
            }
            qVar.S(str);
            qVar.h();
        }
    }

    public ErrorResponse(List<? extends Error> list) {
        this.errors = list;
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, List<Error> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = errorResponse.errors;
        }
        return errorResponse.copy(list);
    }

    public final List<Error> component1() {
        return this.errors;
    }

    public final ErrorResponse copy(List<? extends Error> list) {
        return new ErrorResponse(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ErrorResponse) && j.b(this.errors, ((ErrorResponse) obj).errors);
    }

    public final List<Error> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        List<Error> list = this.errors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final /* synthetic */ <T extends Error> boolean isAnyError() {
        List<Error> errors2 = getErrors();
        if (errors2 == null || errors2.isEmpty()) {
            return false;
        }
        for (Error error : errors2) {
            j.m(3, "T");
            if (error instanceof Error) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "ErrorResponse(errors=" + this.errors + PropertyUtils.MAPPED_DELIM2;
    }
}
