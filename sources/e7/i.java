package e7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class i extends e {
    i(Context context, ComponentName componentName) {
        super(context, componentName);
    }

    public void a(int i10) {
        boolean z10;
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", this.f14588b.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", this.f14588b.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i10));
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z10);
        this.f14587a.sendBroadcast(intent);
    }

    public void clear() {
        a(0);
    }
}
