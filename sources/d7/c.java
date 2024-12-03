package d7;

import android.app.Activity;
import android.content.Context;
import com.coffeemeetsbagel.analytics_common.AnalyticsConstants$Logout;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.coffeemeetsbagel.models.enums.UpgradeAvailability;
import okhttp3.l;
import z9.g;

public interface c {

    public interface a {
        void a(CmbErrorCode cmbErrorCode);

        void b(UpgradeAvailability upgradeAvailability, String str);
    }

    void a(Context context, AnalyticsConstants$Logout analyticsConstants$Logout, BannedReason bannedReason, VerificationStatus verificationStatus, String... strArr);

    void b(Activity activity, boolean z10, g gVar, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr);

    void c(Context context, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr);

    void d(String str, a aVar);

    String e();

    void f(l lVar);

    l g();

    String getProfileId();

    void h(String str);

    void i(String str);

    boolean isLoggedIn();

    void j(Activity activity, boolean z10, g gVar, String str, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr);

    void k(b bVar);

    void l(Context context, g gVar, AnalyticsConstants$Logout analyticsConstants$Logout, String... strArr);

    boolean m();
}
