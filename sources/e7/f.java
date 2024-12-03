package e7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class f extends e {
    f(Context context, ComponentName componentName) {
        super(context, componentName);
    }

    public void a(int i10) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", this.f14588b.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i10);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", this.f14588b.getPackageName());
        intent2.putExtra("count", i10);
        this.f14587a.sendBroadcast(intent);
        this.f14587a.sendBroadcast(intent2);
    }

    public void clear() {
        a(0);
    }
}
