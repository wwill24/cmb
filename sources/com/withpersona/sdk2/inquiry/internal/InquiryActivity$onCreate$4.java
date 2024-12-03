package com.withpersona.sdk2.inquiry.internal;

import android.content.Intent;
import com.withpersona.sdk2.inquiry.internal.InquiryActivity;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.inquiry.internal.InquiryActivity$onCreate$4", f = "InquiryActivity.kt", l = {225}, m = "invokeSuspend")
final class InquiryActivity$onCreate$4 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ g $component;
    int label;
    final /* synthetic */ InquiryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryActivity$onCreate$4(InquiryActivity inquiryActivity, g gVar, c<? super InquiryActivity$onCreate$4> cVar) {
        super(2, cVar);
        this.this$0 = inquiryActivity;
        this.$component = gVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new InquiryActivity$onCreate$4(this.this$0, this.$component, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((InquiryActivity$onCreate$4) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            InquiryActivity.InquiryViewModel C0 = this.this$0.S0();
            this.label = 1;
            obj = C0.v(this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        InquiryWorkflow.Output output = (InquiryWorkflow.Output) obj;
        if (output instanceof InquiryWorkflow.Output.Complete) {
            InquiryActivity inquiryActivity = this.this$0;
            Intent intent = new Intent();
            InquiryActivity inquiryActivity2 = this.this$0;
            intent.putExtra("PERSONA_ACTIVITY_RESULT", "INQUIRY_COMPLETE");
            InquiryWorkflow.Output.Complete complete = (InquiryWorkflow.Output.Complete) output;
            intent.putExtra("INQUIRY_ID_KEY", complete.e());
            intent.putExtra("INQUIRY_STATUS_KEY", complete.f());
            intent.putExtra("FIELDS_MAP_KEY", new InquiryFieldsMap(complete.d()));
            intent.putExtra("COLLECTED_DATA", inquiryActivity2.S0().j().c());
            Unit unit = Unit.f32013a;
            inquiryActivity.setResult(-1, intent);
        } else if (output instanceof InquiryWorkflow.Output.Cancel) {
            InquiryWorkflow.Output.Cancel cancel = (InquiryWorkflow.Output.Cancel) output;
            String e10 = cancel.e();
            if (e10 != null) {
                this.$component.e().d(e10);
            }
            InquiryActivity inquiryActivity3 = this.this$0;
            Intent intent2 = new Intent();
            intent2.putExtra("PERSONA_ACTIVITY_RESULT", "INQUIRY_CANCELED");
            intent2.putExtra("INQUIRY_ID_KEY", cancel.d());
            intent2.putExtra("SESSION_TOKEN_KEY", InquiryActivity.f26084d.a(cancel.e()));
            Unit unit2 = Unit.f32013a;
            inquiryActivity3.setResult(0, intent2);
        } else if (output instanceof InquiryWorkflow.Output.Error) {
            InquiryWorkflow.Output.Error error = (InquiryWorkflow.Output.Error) output;
            if (error.f() != null) {
                this.$component.e().c(error.f(), error.d());
            }
            InquiryActivity inquiryActivity4 = this.this$0;
            Intent intent3 = new Intent();
            intent3.putExtra("PERSONA_ACTIVITY_RESULT", "INQUIRY_ERROR");
            intent3.putExtra("ERROR_DEBUG_MESSAGE_KEY", error.e());
            Unit unit3 = Unit.f32013a;
            inquiryActivity4.setResult(0, intent3);
        }
        this.this$0.finish();
        return Unit.f32013a;
    }
}
