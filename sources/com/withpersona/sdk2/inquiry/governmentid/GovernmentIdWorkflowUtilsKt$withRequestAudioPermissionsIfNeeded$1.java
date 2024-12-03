package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.permissions.PermissionRequestWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflowUtilsKt$withRequestAudioPermissionsIfNeeded$1 extends Lambda implements Function1<PermissionRequestWorkflow.b, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $renderContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflowUtilsKt$withRequestAudioPermissionsIfNeeded$1(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar) {
        super(1);
        this.$renderContext = aVar;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final PermissionRequestWorkflow.b bVar) {
        j.g(bVar, "it");
        final h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a aVar = this.$renderContext;
        return Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {

            /* renamed from: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt$withRequestAudioPermissionsIfNeeded$1$1$a */
            public /* synthetic */ class a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f25650a;

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
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult r1 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.SettingsLaunched     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        com.withpersona.sdk2.inquiry.permissions.PermissionResult r1 = com.withpersona.sdk2.inquiry.permissions.PermissionResult.PermissionRejected     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        f25650a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt$withRequestAudioPermissionsIfNeeded$1.AnonymousClass1.a.<clinit>():void");
                }
            }

            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                int i10 = a.f25650a[bVar.a().a().ordinal()];
                if (i10 == 1 || i10 == 2) {
                    aVar.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass1.f25649a, 1, (Object) null));
                } else if (i10 == 3) {
                    GovernmentIdWorkflowUtilsKt.f(aVar);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
