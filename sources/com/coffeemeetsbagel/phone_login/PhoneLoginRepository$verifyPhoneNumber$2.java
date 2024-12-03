package com.coffeemeetsbagel.phone_login;

import com.coffeemeetsbagel.phone_login.api.models.VerifyPhoneNumberResponse;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import retrofit2.r;

@d(c = "com.coffeemeetsbagel.phone_login.PhoneLoginRepository$verifyPhoneNumber$2", f = "PhoneLoginRepository.kt", l = {}, m = "invokeSuspend")
final class PhoneLoginRepository$verifyPhoneNumber$2 extends SuspendLambda implements Function2<k0, c<? super VerifyPhoneNumberResponse>, Object> {
    final /* synthetic */ String $phoneNumber;
    int label;
    final /* synthetic */ PhoneLoginRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneLoginRepository$verifyPhoneNumber$2(PhoneLoginRepository phoneLoginRepository, String str, c<? super PhoneLoginRepository$verifyPhoneNumber$2> cVar) {
        super(2, cVar);
        this.this$0 = phoneLoginRepository;
        this.$phoneNumber = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PhoneLoginRepository$verifyPhoneNumber$2(this.this$0, this.$phoneNumber, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super VerifyPhoneNumberResponse> cVar) {
        return ((PhoneLoginRepository$verifyPhoneNumber$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            r j10 = this.this$0.f35692a.c(this.$phoneNumber).j();
            if (j10.a() != null) {
                Object a10 = j10.a();
                j.d(a10);
                j.f(a10, "{\n                    re…ody()!!\n                }");
                return (VerifyPhoneNumberResponse) a10;
            }
            return new VerifyPhoneNumberResponse(String.valueOf(j10.b()), "0", this.this$0.c(j10.e(), j10.b()).b(), VerifyPhoneNumberResponse.VerifyType.SMS.name());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
