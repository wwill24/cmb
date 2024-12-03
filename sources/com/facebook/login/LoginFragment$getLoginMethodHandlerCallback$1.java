package com.facebook.login;

import androidx.activity.result.ActivityResult;
import androidx.fragment.app.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.mam.element.MamElements;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/activity/result/ActivityResult;", "result", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class LoginFragment$getLoginMethodHandlerCallback$1 extends Lambda implements Function1<ActivityResult, Unit> {
    final /* synthetic */ h $activity;
    final /* synthetic */ LoginFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginFragment$getLoginMethodHandlerCallback$1(LoginFragment loginFragment, h hVar) {
        super(1);
        this.this$0 = loginFragment;
        this.$activity = hVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ActivityResult) obj);
        return Unit.f32013a;
    }

    public final void invoke(ActivityResult activityResult) {
        j.g(activityResult, MamElements.MamResultExtension.ELEMENT);
        if (activityResult.c() == -1) {
            this.this$0.getLoginClient().onActivityResult(LoginClient.Companion.getLoginRequestCode(), activityResult.c(), activityResult.a());
        } else {
            this.$activity.finish();
        }
    }
}
