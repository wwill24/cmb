package androidx.test.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.test.internal.util.Checks;

public class InstrumentationActivityInvoker$BootstrapActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f7046a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            InstrumentationActivityInvoker$BootstrapActivity.this.finishActivity(0);
            InstrumentationActivityInvoker$BootstrapActivity.this.finish();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f7047b;

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 0) {
            Intent intent2 = new Intent("androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_RECEIVED");
            intent2.putExtra("androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_CODE_KEY", i11);
            if (intent != null) {
                intent2.putExtra("androidx.test.core.app.InstrumentationActivityInvoker.BOOTSTRAP_ACTIVITY_RESULT_DATA_KEY", intent);
            }
            sendBroadcast(intent2);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        registerReceiver(this.f7046a, new IntentFilter("androidx.test.core.app.InstrumentationActivityInvoker.FINISH_BOOTSTRAP_ACTIVITY"));
        if (bundle == null || !bundle.getBoolean("IS_TARGET_ACTIVITY_STARTED_KEY", false)) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f7047b = z10;
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f7046a);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f7047b) {
            this.f7047b = true;
            PendingIntent pendingIntent = (PendingIntent) Checks.a((PendingIntent) getIntent().getParcelableExtra("androidx.test.core.app.InstrumentationActivityInvoker.START_TARGET_ACTIVITY_INTENT_KEY"));
            Bundle bundleExtra = getIntent().getBundleExtra("androidx.test.core.app.InstrumentationActivityInvoker.TARGET_ACTIVITY_OPTIONS_BUNDLE_KEY");
            if (bundleExtra != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 0, (Intent) null, 268435456, 0, 0, bundleExtra);
                } catch (IntentSender.SendIntentException e10) {
                    throw new RuntimeException(e10);
                }
            } else {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 0, (Intent) null, 268435456, 0, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("IS_TARGET_ACTIVITY_STARTED_KEY", this.f7047b);
    }
}
