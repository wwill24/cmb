package com.coffeemeetsbagel.phone_login;

import androidx.lifecycle.t;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$verifyPhoneCode$1", f = "PhoneCodeViewModel.kt", l = {53}, m = "invokeSuspend")
final class PhoneCodeViewModel$verifyPhoneCode$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $code;
    Object L$0;
    int label;
    final /* synthetic */ PhoneCodeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneCodeViewModel$verifyPhoneCode$1(PhoneCodeViewModel phoneCodeViewModel, String str, c<? super PhoneCodeViewModel$verifyPhoneCode$1> cVar) {
        super(2, cVar);
        this.this$0 = phoneCodeViewModel;
        this.$code = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PhoneCodeViewModel$verifyPhoneCode$1(this.this$0, this.$code, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((PhoneCodeViewModel$verifyPhoneCode$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        t tVar;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            t g10 = this.this$0.f35654f;
            PhoneLoginRepository p10 = this.this$0.p();
            String str = this.$code;
            String n10 = this.this$0.n();
            this.L$0 = g10;
            this.label = 1;
            Object d11 = p10.d(str, n10, this);
            if (d11 == d10) {
                return d10;
            }
            tVar = g10;
            obj = d11;
        } else if (i10 == 1) {
            tVar = (t) this.L$0;
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        tVar.o(obj);
        return Unit.f32013a;
    }
}
