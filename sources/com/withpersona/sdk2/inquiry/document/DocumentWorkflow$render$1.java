package com.withpersona.sdk2.inquiry.document;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.document.DocumentWorkflow;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DocumentWorkflow$render$1 extends Lambda implements Function1<PermissionRequestWorkflow.b, l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>> {
    final /* synthetic */ DocumentWorkflow.State $renderState;
    final /* synthetic */ DocumentWorkflow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentWorkflow$render$1(DocumentWorkflow documentWorkflow, DocumentWorkflow.State state) {
        super(1);
        this.this$0 = documentWorkflow;
        this.$renderState = state;
    }

    /* renamed from: a */
    public final l<DocumentWorkflow.b, DocumentWorkflow.State, DocumentWorkflow.c> invoke(final PermissionRequestWorkflow.b bVar) {
        j.g(bVar, "it");
        final DocumentWorkflow documentWorkflow = this.this$0;
        final DocumentWorkflow.State state = this.$renderState;
        return Workflows__StatefulWorkflowKt.d(documentWorkflow, (String) null, new Function1<l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c, Unit>() {

            /* renamed from: com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$1$1$a */
            public /* synthetic */ class a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f25125a;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult[] r0 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult r1 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.PermissionGranted     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult r1 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.PermissionRejected     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult r1 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.SettingsLaunched     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        f25125a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentWorkflow$render$1.AnonymousClass1.a.<clinit>():void");
                }
            }

            public final void a(l<? super DocumentWorkflow.b, DocumentWorkflow.State, ? extends DocumentWorkflow.c>.c cVar) {
                DocumentWorkflow.State state;
                j.g(cVar, "$this$action");
                int i10 = a.f25125a[bVar.a().a().ordinal()];
                if (i10 == 1) {
                    DocumentCameraWorker i11 = documentWorkflow.f25009d;
                    String string = documentWorkflow.f25007b.getString(n.pi2_camera_error);
                    j.f(string, "applicationContext.getSt….string.pi2_camera_error)");
                    if (i11.d(string)) {
                        state = state.a(DocumentWorkflow.State.CaptureState.CameraRunning);
                    } else {
                        state = state.a(DocumentWorkflow.State.CaptureState.None);
                    }
                    cVar.e(state);
                } else if (i10 == 2 || i10 == 3) {
                    cVar.e(state.a(DocumentWorkflow.State.CaptureState.None));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
