package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.network.SubmitVerificationWorker;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$28 extends Lambda implements Function1<SubmitVerificationWorker.b, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflow$renderScreen$28(GovernmentIdWorkflow governmentIdWorkflow) {
        super(1);
        this.this$0 = governmentIdWorkflow;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final SubmitVerificationWorker.b bVar) {
        final String str;
        j.g(bVar, "it");
        if (bVar instanceof SubmitVerificationWorker.b.c) {
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, AnonymousClass1.f25639a, 1, (Object) null);
        }
        if (bVar instanceof SubmitVerificationWorker.b.C0311b) {
            SubmitVerificationWorker.b.C0311b bVar2 = (SubmitVerificationWorker.b.C0311b) bVar;
            if (bVar2.a() instanceof GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError) {
                str = this.this$0.f25506a.getString(o0.pi2_governmentid_error_min_dimension_size, new Object[]{Integer.valueOf(((GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError) bVar2.a()).getDetails().getMinDimensionSize())});
                j.f(str, "applicationContext.getSt…nSize\n                  )");
            } else {
                str = this.this$0.f25506a.getString(o0.pi2_governmentid_error_unable_to_upload_file);
                j.f(str, "applicationContext.getSt…or_unable_to_upload_file)");
            }
            return Workflows__StatefulWorkflowKt.d(this.this$0, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    GovernmentIdState f10 = ((GovernmentIdState) cVar.c()).f();
                    if (f10 != null) {
                        cVar.e(f10.d(str));
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else if (bVar instanceof SubmitVerificationWorker.b.a) {
            final GovernmentIdWorkflow governmentIdWorkflow = this.this$0;
            return Workflows__StatefulWorkflowKt.d(governmentIdWorkflow, (String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    j.g(cVar, "$this$action");
                    GovernmentIdState f10 = ((GovernmentIdState) cVar.c()).f();
                    if (!((SubmitVerificationWorker.b.a) bVar).a().isRecoverable() || f10 == null) {
                        cVar.d(new GovernmentIdWorkflow.b.c(((SubmitVerificationWorker.b.a) bVar).a()));
                        return;
                    }
                    String string = governmentIdWorkflow.f25506a.getString(o0.pi2_network_connection_error);
                    j.f(string, "applicationContext.getSt…network_connection_error)");
                    cVar.e(f10.d(string));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
