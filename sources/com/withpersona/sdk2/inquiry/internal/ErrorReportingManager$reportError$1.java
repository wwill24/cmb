package com.withpersona.sdk2.inquiry.internal;

import com.withpersona.sdk2.inquiry.internal.network.ErrorRequest;
import com.withpersona.sdk2.inquiry.internal.network.b;
import com.withpersona.sdk2.inquiry.internal.network.p;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.internal.ErrorReportingManager$reportError$1", f = "ErrorReportingManager.kt", l = {33}, m = "invokeSuspend")
final class ErrorReportingManager$reportError$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ InternalErrorInfo $errorInfo;
    final /* synthetic */ String $sessionToken;
    int label;
    final /* synthetic */ ErrorReportingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ErrorReportingManager$reportError$1(ErrorReportingManager errorReportingManager, String str, InternalErrorInfo internalErrorInfo, c<? super ErrorReportingManager$reportError$1> cVar) {
        super(2, cVar);
        this.this$0 = errorReportingManager;
        this.$sessionToken = str;
        this.$errorInfo = internalErrorInfo;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ErrorReportingManager$reportError$1(this.this$0, this.$sessionToken, this.$errorInfo, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ErrorReportingManager$reportError$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            p a10 = this.this$0.f26081a;
            String str = this.$sessionToken;
            ErrorRequest errorRequest = new ErrorRequest(b.a(this.$errorInfo), this.this$0.f26082b.c(InternalErrorInfo.class).toJsonValue(this.$errorInfo));
            this.label = 1;
            if (a10.b(str, errorRequest, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
