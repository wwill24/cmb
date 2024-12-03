package com.coffeemeetsbagel.phone_login;

import com.coffeemeetsbagel.phone_login.api.models.VerifyCodeResponse;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import retrofit2.r;

@d(c = "com.coffeemeetsbagel.phone_login.PhoneLoginRepository$verifyCode$2", f = "PhoneLoginRepository.kt", l = {}, m = "invokeSuspend")
final class PhoneLoginRepository$verifyCode$2 extends SuspendLambda implements Function2<k0, c<? super VerifyCodeResponse>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $phoneNumber;
    int label;
    final /* synthetic */ PhoneLoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneLoginRepository$verifyCode$2(PhoneLoginRepository phoneLoginRepository, String str, String str2, c<? super PhoneLoginRepository$verifyCode$2> cVar) {
        super(2, cVar);
        this.this$0 = phoneLoginRepository;
        this.$phoneNumber = str;
        this.$code = str2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PhoneLoginRepository$verifyCode$2(this.this$0, this.$phoneNumber, this.$code, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super VerifyCodeResponse> cVar) {
        return ((PhoneLoginRepository$verifyCode$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            r j10 = this.this$0.f35692a.b(this.$phoneNumber, this.$code).j();
            if (j10.a() != null) {
                return (VerifyCodeResponse) j10.a();
            }
            return new VerifyCodeResponse("", this.this$0.c(j10.e(), j10.b()).b());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
