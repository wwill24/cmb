package com.withpersona.sdk2.inquiry.internal.fallbackmode;

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
import okhttp3.z;
import retrofit2.r;

@d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$uploadResult$1", f = "ApiController.kt", l = {157}, m = "invokeSuspend")
final class FallbackModeApiController$transitionWithRequestBody$uploadResult$1 extends SuspendLambda implements Function2<k0, c<? super NetworkCallResult<Object>>, Object> {
    final /* synthetic */ z $body;
    final /* synthetic */ String $uploadUrl;
    int label;
    final /* synthetic */ FallbackModeApiController this$0;

    @d(c = "com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$uploadResult$1$1", f = "ApiController.kt", l = {158}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.inquiry.internal.fallbackmode.FallbackModeApiController$transitionWithRequestBody$uploadResult$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<c<? super r<Object>>, Object> {
        int label;

        public final c<Unit> create(c<?> cVar) {
            return new AnonymousClass1(fallbackModeApiController, str, zVar, cVar);
        }

        /* renamed from: i */
        public final Object invoke(c<? super r<Object>> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                FallbackModeService e10 = fallbackModeApiController.e();
                String str = str;
                z zVar = zVar;
                this.label = 1;
                obj = e10.c(str, zVar, this);
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
    FallbackModeApiController$transitionWithRequestBody$uploadResult$1(FallbackModeApiController fallbackModeApiController, String str, z zVar, c<? super FallbackModeApiController$transitionWithRequestBody$uploadResult$1> cVar) {
        super(2, cVar);
        this.this$0 = fallbackModeApiController;
        this.$uploadUrl = str;
        this.$body = zVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FallbackModeApiController$transitionWithRequestBody$uploadResult$1(this.this$0, this.$uploadUrl, this.$body, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super NetworkCallResult<Object>> cVar) {
        return ((FallbackModeApiController$transitionWithRequestBody$uploadResult$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final FallbackModeApiController fallbackModeApiController = this.this$0;
            final String str = this.$uploadUrl;
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
