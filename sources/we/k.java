package we;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.g;

public final class k {
    public static String a(Context context) {
        try {
            return context.getResources().getResourcePackageName(g.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static final String b(String str, Resources resources, String str2) {
        int identifier = resources.getIdentifier(str, "string", str2);
        if (identifier == 0) {
            return null;
        }
        try {
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
