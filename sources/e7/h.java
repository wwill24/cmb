package e7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.coffeemeetsbagel.models.constants.ProfileConstants;

public class h extends e {
    h(Context context, ComponentName componentName) {
        super(context, componentName);
    }

    public void a(int i10) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra(ProfileConstants.Field.BADGE_COUNT, i10);
        intent.putExtra("badge_count_package_name", this.f14587a.getPackageName());
        intent.putExtra("badge_count_class_name", this.f14588b.getClassName());
        this.f14587a.sendBroadcast(intent);
    }

    public void clear() {
        a(0);
    }
}
