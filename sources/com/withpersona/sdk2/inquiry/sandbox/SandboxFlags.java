package com.withpersona.sdk2.inquiry.sandbox;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.sm.packet.StreamManagement;

public final class SandboxFlags {

    /* renamed from: c  reason: collision with root package name */
    public static final a f27148c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f27149a;

    /* renamed from: b  reason: collision with root package name */
    private ForcedStatus f27150b = ForcedStatus.Passed;

    public enum ForcedStatus {
        Failed,
        Passed
    }

    public static final class a {

        /* renamed from: com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0324a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f27154a;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus[] r0 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus r1 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.Failed     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus r1 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.Passed     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f27154a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.a.C0324a.<clinit>():void");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(ForcedStatus forcedStatus) {
            j.g(forcedStatus, "<this>");
            int i10 = C0324a.f27154a[forcedStatus.ordinal()];
            if (i10 == 1) {
                return StreamManagement.Failed.ELEMENT;
            }
            if (i10 == 2) {
                return "passed";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27155a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus[] r0 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus r1 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.Failed     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.sandbox.SandboxFlags$ForcedStatus r1 = com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.ForcedStatus.Passed     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f27155a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.sandbox.SandboxFlags.b.<clinit>():void");
        }
    }

    public final ForcedStatus a() {
        return this.f27150b;
    }

    public final boolean b() {
        return this.f27149a;
    }

    public final void c(boolean z10) {
        this.f27149a = z10;
    }

    public final void d() {
        ForcedStatus forcedStatus;
        int i10 = b.f27155a[this.f27150b.ordinal()];
        if (i10 == 1) {
            forcedStatus = ForcedStatus.Passed;
        } else if (i10 == 2) {
            forcedStatus = ForcedStatus.Failed;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.f27150b = forcedStatus;
    }
}
