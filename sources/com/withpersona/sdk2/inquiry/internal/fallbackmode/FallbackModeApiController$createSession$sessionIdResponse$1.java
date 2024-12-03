package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldMap;
import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import com.withpersona.sdk2.inquiry.network.NetworkCallResult;
import com.withpersona.sdk2.inquiry.network.NetworkUtilsKt;
import gk.g;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import retrofit2.r;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$sessionIdResponse$1", f = "ApiController.kt", l = {94}, m = "invokeSuspend")
final class FallbackModeApiController$createSession$sessionIdResponse$1 extends SuspendLambda implements Function2<k0, c<? super NetworkCallResult<FallbackModeService.SessionIdResponse>>, Object> {
    final /* synthetic */ Map<String, InquiryField> $fields;
    final /* synthetic */ String $referenceId;
    final /* synthetic */ String $templateId;
    int label;
    final /* synthetic */ FallbackModeApiController this$0;

    @d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$sessionIdResponse$1$1", f = "ApiController.kt", l = {95}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$createSession$sessionIdResponse$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<c<? super r<FallbackModeService.SessionIdResponse>>, Object> {
        int label;

        public final c<Unit> create(c<?> cVar) {
            return new AnonymousClass1(fallbackModeApiController, str, str2, map, cVar);
        }

        /* renamed from: i */
        public final Object invoke(c<? super r<FallbackModeService.SessionIdResponse>> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            InquiryFieldMap inquiryFieldMap;
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                FallbackModeService e10 = fallbackModeApiController.e();
                String str = str;
                String str2 = str2;
                Map<String, InquiryField> map = map;
                if (map != null) {
                    inquiryFieldMap = new InquiryFieldMap(map);
                } else {
                    inquiryFieldMap = null;
                }
                FallbackModeService.SessionIdRequest sessionIdRequest = new FallbackModeService.SessionIdRequest(str, str2, inquiryFieldMap);
                this.label = 1;
                obj = e10.d(sessionIdRequest, this);
                if (obj == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                g.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FallbackModeApiController$createSession$sessionIdResponse$1(FallbackModeApiController fallbackModeApiController, String str, String str2, Map<String, ? extends InquiryField> map, c<? super FallbackModeApiController$createSession$sessionIdResponse$1> cVar) {
        super(2, cVar);
        this.this$0 = fallbackModeApiController;
        this.$templateId = str;
        this.$referenceId = str2;
        this.$fields = map;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FallbackModeApiController$createSession$sessionIdResponse$1(this.this$0, this.$templateId, this.$referenceId, this.$fields, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super NetworkCallResult<FallbackModeService.SessionIdResponse>> cVar) {
        return ((FallbackModeApiController$createSession$sessionIdResponse$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final FallbackModeApiController fallbackModeApiController = this.this$0;
            final String str = this.$templateId;
            final String str2 = this.$referenceId;
            final Map<String, InquiryField> map = this.$fields;
            AnonymousClass1 r32 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = NetworkUtilsKt.enqueueRetriableRequestWithRetry(r32, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
