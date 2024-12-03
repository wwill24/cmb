package com.withpersona.sdk2.inquiry.internal;

import androidx.lifecycle.a0;
import androidx.lifecycle.g0;
import com.squareup.workflow1.ui.AndroidRenderWorkflowKt;
import com.withpersona.sdk2.inquiry.internal.InquiryActivity;
import com.withpersona.sdk2.inquiry.internal.InquiryWorkflow;
import com.withpersona.sdk2.inquiry.modal.ModalWorkflow;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.k0;

final class InquiryActivity$InquiryViewModel$renderings$2 extends Lambda implements Function0<r<? extends Object>> {
    final /* synthetic */ InquiryActivity.InquiryViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InquiryActivity$InquiryViewModel$renderings$2(InquiryActivity.InquiryViewModel inquiryViewModel) {
        super(0);
        this.this$0 = inquiryViewModel;
    }

    /* renamed from: a */
    public final r<Object> invoke() {
        g f10 = this.this$0.f26087e;
        if (f10 != null) {
            ModalWorkflow modalWorkflow = new ModalWorkflow(f10.d());
            k0 a10 = g0.a(this.this$0);
            a0 i10 = this.this$0.f26086d;
            i g10 = this.this$0.f26088f;
            if (g10 == null) {
                j.y("props");
                g10 = null;
            }
            return AndroidRenderWorkflowKt.a(modalWorkflow, a10, g10, i10, m.f26401a.a(), new Function2<InquiryWorkflow.Output, c<? super Unit>, Object>(this.this$0.f26090h) {
                /* renamed from: c */
                public final Object invoke(InquiryWorkflow.Output output, c<? super Unit> cVar) {
                    return ((d) this.receiver).H(output, cVar);
                }
            });
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
