package d7;

import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import vj.a;

public final /* synthetic */ class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f14468a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnalyticsConstants$Logout f14469b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String[] f14470c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BannedReason f14471d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ VerificationStatus f14472e;

    public /* synthetic */ e(g gVar, AnalyticsConstants$Logout analyticsConstants$Logout, String[] strArr, BannedReason bannedReason, VerificationStatus verificationStatus) {
        this.f14468a = gVar;
        this.f14469b = analyticsConstants$Logout;
        this.f14470c = strArr;
        this.f14471d = bannedReason;
        this.f14472e = verificationStatus;
    }

    public final void run() {
        this.f14468a.w(this.f14469b, this.f14470c, this.f14471d, this.f14472e);
    }
}
