package com.coffeemeetsbagel.feature.logout;

import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BannedActivity$observeStatus$1 extends Lambda implements Function1<Pair<? extends BannedReason, ? extends VerificationStatus>, Unit> {
    final /* synthetic */ BannedActivity this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13068a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.coffeemeetsbagel.models.VerificationStatus[] r0 = com.coffeemeetsbagel.models.VerificationStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.VerificationStatus r1 = com.coffeemeetsbagel.models.VerificationStatus.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.VerificationStatus r1 = com.coffeemeetsbagel.models.VerificationStatus.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.models.VerificationStatus r1 = com.coffeemeetsbagel.models.VerificationStatus.IN_REVIEW     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.models.VerificationStatus r1 = com.coffeemeetsbagel.models.VerificationStatus.REJECTED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f13068a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.feature.logout.BannedActivity$observeStatus$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannedActivity$observeStatus$1(BannedActivity bannedActivity) {
        super(1);
        this.this$0 = bannedActivity;
    }

    public final void a(Pair<? extends BannedReason, ? extends VerificationStatus> pair) {
        if (pair == null) {
            return;
        }
        if (pair.c() == BannedReason.NONE) {
            this.this$0.setResult(72);
            this.this$0.finish();
            return;
        }
        int i10 = a.f13068a[((VerificationStatus) pair.d()).ordinal()];
        if (i10 == 1) {
            this.this$0.V0();
        } else if (i10 == 2) {
            this.this$0.i1(((VerificationStatus) pair.d()).getReferenceId());
        } else if (i10 == 3) {
            this.this$0.Y0();
        } else if (i10 == 4) {
            this.this$0.f1();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
