package com.withpersona.sdk2.inquiry.permissions;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: com.withpersona.sdk2.inquiry.permissions.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0323a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27146a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.inquiry.permissions.Permission[] r0 = com.withpersona.sdk2.inquiry.permissions.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.permissions.Permission r1 = com.withpersona.sdk2.inquiry.permissions.Permission.Camera     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.permissions.Permission r1 = com.withpersona.sdk2.inquiry.permissions.Permission.RecordAudio     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f27146a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.permissions.a.C0323a.<clinit>():void");
        }
    }

    public static final String a(Permission permission) {
        j.g(permission, "<this>");
        int i10 = C0323a.f27146a[permission.ordinal()];
        if (i10 == 1) {
            return "android.permission.CAMERA";
        }
        if (i10 == 2) {
            return "android.permission.RECORD_AUDIO";
        }
        throw new NoWhenBranchMatchedException();
    }
}
