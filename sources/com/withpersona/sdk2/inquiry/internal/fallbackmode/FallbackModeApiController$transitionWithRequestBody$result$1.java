package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeService;
import com.withpersona.sdk2.inquiry.network.NetworkCallResult;
import com.withpersona.sdk2.inquiry.network.NetworkUtilsKt;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import okhttp3.v;
import okhttp3.z;
import retrofit2.r;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$result$1", f = "ApiController.kt", l = {122}, m = "invokeSuspend")
final class FallbackModeApiController$transitionWithRequestBody$result$1 extends SuspendLambda implements Function2<k0, c<? super NetworkCallResult<FallbackModeService.UploadUrlResponse>>, Object> {
    final /* synthetic */ z $body;
    final /* synthetic */ String $sessionToken;
    int label;
    final /* synthetic */ FallbackModeApiController this$0;

    @d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$result$1$1", f = "ApiController.kt", l = {123}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$result$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<c<? super r<FallbackModeService.UploadUrlResponse>>, Object> {
        int label;

        public final c<Unit> create(c<?> cVar) {
            return new AnonymousClass1(fallbackModeApiController, str, zVar, cVar);
        }

        /* renamed from: i */
        public final Object invoke(c<? super r<FallbackModeService.UploadUrlResponse>> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                FallbackModeService e10 = fallbackModeApiController.e();
                String str2 = str;
                ProductionEndpoint productionEndpoint = ProductionEndpoint.Transition;
                int c10 = fallbackModeApiController.d();
                long a10 = zVar.a();
                v b10 = zVar.b();
                if (b10 == null || (str = b10.i()) == null) {
                    str = "application/json";
                }
                FallbackModeService.UploadUrlRequest uploadUrlRequest = new FallbackModeService.UploadUrlRequest(a10, str);
                this.label = 1;
                obj = e10.a(str2, productionEndpoint, c10, uploadUrlRequest, this);
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
    FallbackModeApiController$transitionWithRequestBody$result$1(FallbackModeApiController fallbackModeApiController, String str, z zVar, c<? super FallbackModeApiController$transitionWithRequestBody$result$1> cVar) {
        super(2, cVar);
        this.this$0 = fallbackModeApiController;
        this.$sessionToken = str;
        this.$body = zVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FallbackModeApiController$transitionWithRequestBody$result$1(this.this$0, this.$sessionToken, this.$body, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super NetworkCallResult<FallbackModeService.UploadUrlResponse>> cVar) {
        return ((FallbackModeApiController$transitionWithRequestBody$result$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final FallbackModeApiController fallbackModeApiController = this.this$0;
            final String str = this.$sessionToken;
            final z zVar = this.$body;
            AnonymousClass1 r72 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = NetworkUtilsKt.enqueueRetriableRequestWithRetry(r72, this);
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
