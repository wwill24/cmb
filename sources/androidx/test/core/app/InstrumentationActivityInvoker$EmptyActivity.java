package androidx.test.core.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class InstrumentationActivityInvoker$EmptyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f7049a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            InstrumentationActivityInvoker$EmptyActivity.this.finish();
        }
    };

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerReceiver(this.f7049a, new IntentFilter("androidx.test.core.app.InstrumentationActivityInvoker.FINISH_EMPTY_ACTIVITIES"));
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f7049a);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        sendBroadcast(new Intent("androidx.test.core.app.InstrumentationActivityInvoker.EMPTY_ACTIVITY_RESUMED"));
    }
}
