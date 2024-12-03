package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;

public final class n {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25800a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.FrontOrBack     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f25800a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.n.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final ParsedIdSideOrNone.Side b(IdConfig.Side side) {
        int i10 = a.f25800a[side.ordinal()];
        if (i10 == 1) {
            return ParsedIdSideOrNone.Side.Front;
        }
        if (i10 != 2) {
            return ParsedIdSideOrNone.Side.Back;
        }
        return ParsedIdSideOrNone.Side.Front;
    }
}
