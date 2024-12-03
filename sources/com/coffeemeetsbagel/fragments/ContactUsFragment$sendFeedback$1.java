package com.coffeemeetsbagel.fragments;

import androidx.fragment.app.h;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.FeedbackBody;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import fa.a;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.coffeemeetsbagel.fragments.ContactUsFragment$sendFeedback$1", f = "ContactUsFragment.kt", l = {66}, m = "invokeSuspend")
final class ContactUsFragment$sendFeedback$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ String $feedback;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ ContactUsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContactUsFragment$sendFeedback$1(String str, String str2, ContactUsFragment contactUsFragment, c<? super ContactUsFragment$sendFeedback$1> cVar) {
        super(2, cVar);
        this.$feedback = str;
        this.$source = str2;
        this.this$0 = contactUsFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ContactUsFragment$sendFeedback$1(this.$feedback, this.$source, this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((ContactUsFragment$sendFeedback$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            FeedbackBody feedbackBody = new FeedbackBody(this.$feedback, this.$source, "android");
            ma.d A0 = this.this$0.A0();
            this.label = 1;
            obj = A0.a(feedbackBody, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            try {
                g.b(obj);
            } catch (Throwable th2) {
                a.f40771d.c(this.this$0.f13511b, "", th2);
                h activity = this.this$0.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResponseGeneric responseGeneric = (ResponseGeneric) obj;
        if (responseGeneric.isSuccessful()) {
            return Unit.f32013a;
        }
        CmbErrorCode errorCode = responseGeneric.getErrorCode();
        String errorMessage = responseGeneric.getErrorMessage();
        throw new Throwable("Network Error " + errorCode + " : " + errorMessage);
    }
}
