package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.squareup.moshi.g;
import com.squareup.moshi.i;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldMap;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import okhttp3.z;
import org.apache.commons.beanutils.PropertyUtils;
import retrofit2.r;
import vn.a;
import vn.k;
import vn.o;
import vn.y;

public interface FallbackModeService {

    @i(generateAdapter = true)
    public static final class SessionIdRequest {

        /* renamed from: a  reason: collision with root package name */
        private final String f26335a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26336b;

        /* renamed from: c  reason: collision with root package name */
        private final InquiryFieldMap f26337c;

        public SessionIdRequest(@g(name = "inquiry-template-id") String str, @g(name = "reference-id") String str2, InquiryFieldMap inquiryFieldMap) {
            j.g(str, "inquiryTemplateId");
            this.f26335a = str;
            this.f26336b = str2;
            this.f26337c = inquiryFieldMap;
        }

        public final InquiryFieldMap a() {
            return this.f26337c;
        }

        public final String b() {
            return this.f26335a;
        }

        public final String c() {
            return this.f26336b;
        }

        public final SessionIdRequest copy(@g(name = "inquiry-template-id") String str, @g(name = "reference-id") String str2, InquiryFieldMap inquiryFieldMap) {
            j.g(str, "inquiryTemplateId");
            return new SessionIdRequest(str, str2, inquiryFieldMap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionIdRequest)) {
                return false;
            }
            SessionIdRequest sessionIdRequest = (SessionIdRequest) obj;
            return j.b(this.f26335a, sessionIdRequest.f26335a) && j.b(this.f26336b, sessionIdRequest.f26336b) && j.b(this.f26337c, sessionIdRequest.f26337c);
        }

        public int hashCode() {
            int hashCode = this.f26335a.hashCode() * 31;
            String str = this.f26336b;
            int i10 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            InquiryFieldMap inquiryFieldMap = this.f26337c;
            if (inquiryFieldMap != null) {
                i10 = inquiryFieldMap.hashCode();
            }
            return hashCode2 + i10;
        }

        public String toString() {
            return "SessionIdRequest(inquiryTemplateId=" + this.f26335a + ", referenceId=" + this.f26336b + ", fields=" + this.f26337c + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class SessionIdResponse {

        /* renamed from: a  reason: collision with root package name */
        private final String f26338a;

        public SessionIdResponse(String str) {
            j.g(str, "token");
            this.f26338a = str;
        }

        public final String a() {
            return this.f26338a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionIdResponse) && j.b(this.f26338a, ((SessionIdResponse) obj).f26338a);
        }

        public int hashCode() {
            return this.f26338a.hashCode();
        }

        public String toString() {
            return "SessionIdResponse(token=" + this.f26338a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class StaticTemplate {

        /* renamed from: a  reason: collision with root package name */
        private final List<NextStep> f26339a;

        public StaticTemplate(List<? extends NextStep> list) {
            j.g(list, "steps");
            this.f26339a = list;
        }

        public final List<NextStep> a() {
            return this.f26339a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StaticTemplate) && j.b(this.f26339a, ((StaticTemplate) obj).f26339a);
        }

        public int hashCode() {
            return this.f26339a.hashCode();
        }

        public String toString() {
            return "StaticTemplate(steps=" + this.f26339a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class StatusRequest {

        /* renamed from: a  reason: collision with root package name */
        private final String f26340a;

        public StatusRequest(@g(name = "inquiry-template-id") String str) {
            j.g(str, "inquiryTemplateId");
            this.f26340a = str;
        }

        public final String a() {
            return this.f26340a;
        }

        public final StatusRequest copy(@g(name = "inquiry-template-id") String str) {
            j.g(str, "inquiryTemplateId");
            return new StatusRequest(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StatusRequest) && j.b(this.f26340a, ((StatusRequest) obj).f26340a);
        }

        public int hashCode() {
            return this.f26340a.hashCode();
        }

        public String toString() {
            return "StatusRequest(inquiryTemplateId=" + this.f26340a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class StatusResponse {

        /* renamed from: a  reason: collision with root package name */
        private final StaticTemplate f26341a;

        public StatusResponse(@g(name = "static-inquiry-template") StaticTemplate staticTemplate) {
            this.f26341a = staticTemplate;
        }

        public final StaticTemplate a() {
            return this.f26341a;
        }

        public final StatusResponse copy(@g(name = "static-inquiry-template") StaticTemplate staticTemplate) {
            return new StatusResponse(staticTemplate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StatusResponse) && j.b(this.f26341a, ((StatusResponse) obj).f26341a);
        }

        public int hashCode() {
            StaticTemplate staticTemplate = this.f26341a;
            if (staticTemplate == null) {
                return 0;
            }
            return staticTemplate.hashCode();
        }

        public String toString() {
            return "StatusResponse(staticInquiryTemplate=" + this.f26341a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class UploadUrlRequest {

        /* renamed from: a  reason: collision with root package name */
        private final long f26342a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26343b;

        public UploadUrlRequest(@g(name = "expected-content-length") long j10, @g(name = "expected-content-type") String str) {
            j.g(str, "expectedContentType");
            this.f26342a = j10;
            this.f26343b = str;
        }

        public final long a() {
            return this.f26342a;
        }

        public final String b() {
            return this.f26343b;
        }

        public final UploadUrlRequest copy(@g(name = "expected-content-length") long j10, @g(name = "expected-content-type") String str) {
            j.g(str, "expectedContentType");
            return new UploadUrlRequest(j10, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UploadUrlRequest)) {
                return false;
            }
            UploadUrlRequest uploadUrlRequest = (UploadUrlRequest) obj;
            return this.f26342a == uploadUrlRequest.f26342a && j.b(this.f26343b, uploadUrlRequest.f26343b);
        }

        public int hashCode() {
            return (Long.hashCode(this.f26342a) * 31) + this.f26343b.hashCode();
        }

        public String toString() {
            return "UploadUrlRequest(expectedContentLength=" + this.f26342a + ", expectedContentType=" + this.f26343b + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @i(generateAdapter = true)
    public static final class UploadUrlResponse {

        /* renamed from: a  reason: collision with root package name */
        private final String f26344a;

        public UploadUrlResponse(String str) {
            j.g(str, "location");
            this.f26344a = str;
        }

        public final String a() {
            return this.f26344a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UploadUrlResponse) && j.b(this.f26344a, ((UploadUrlResponse) obj).f26344a);
        }

        public int hashCode() {
            return this.f26344a.hashCode();
        }

        public String toString() {
            return "UploadUrlResponse(location=" + this.f26344a + PropertyUtils.MAPPED_DELIM2;
        }
    }

    @k({"Content-Type: application/json"})
    @o("https://inquiry-fallback.withpersona.com/part")
    Object a(@vn.i("Authorization") String str, @vn.i("Persona-Fallback-Production-Endpoint") ProductionEndpoint productionEndpoint, @vn.i("Persona-Fallback-Request-Count") int i10, @a UploadUrlRequest uploadUrlRequest, c<? super r<UploadUrlResponse>> cVar);

    @k({"Content-Type: application/json"})
    @o("https://inquiry-fallback.withpersona.com/template")
    Object b(@a StatusRequest statusRequest, c<? super r<StatusResponse>> cVar);

    @o
    Object c(@y String str, @a z zVar, c<? super r<Object>> cVar);

    @k({"Content-Type: application/json"})
    @o("https://inquiry-fallback.withpersona.com/session")
    Object d(@a SessionIdRequest sessionIdRequest, c<? super r<SessionIdResponse>> cVar);
}
