package com.withpersona.sdk2.inquiry;

import dj.a;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class InquiryResponse {

    public static final class Cancel extends InquiryResponse {
        private final String inquiryId;
        private final String sessionToken;

        public Cancel(String str, String str2) {
            super((DefaultConstructorMarker) null);
            this.inquiryId = str;
            this.sessionToken = str2;
        }

        public final String getInquiryId() {
            return this.inquiryId;
        }

        public final String getSessionToken() {
            return this.sessionToken;
        }
    }

    public static final class Complete extends InquiryResponse {
        private final a collectedData;
        private final Map<String, InquiryField> fields;
        private final String inquiryId;
        private final String status;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Complete(String str, String str2, Map<String, ? extends InquiryField> map, a aVar) {
            super((DefaultConstructorMarker) null);
            j.g(str, "inquiryId");
            j.g(str2, "status");
            j.g(map, "fields");
            this.inquiryId = str;
            this.status = str2;
            this.fields = map;
            this.collectedData = aVar;
        }

        public final a getCollectedData() {
            return this.collectedData;
        }

        public final Map<String, InquiryField> getFields() {
            return this.fields;
        }

        public final String getInquiryId() {
            return this.inquiryId;
        }

        public final String getStatus() {
            return this.status;
        }
    }

    public static final class Error extends InquiryResponse {
        private final String cause;
        private final String debugMessage;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(String str, String str2) {
            super((DefaultConstructorMarker) null);
            j.g(str, "debugMessage");
            this.debugMessage = str;
            this.cause = str2;
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getDebugMessage() {
            return this.debugMessage;
        }
    }

    private InquiryResponse() {
    }

    public /* synthetic */ InquiryResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
