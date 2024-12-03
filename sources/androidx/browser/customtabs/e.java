package androidx.browser.customtabs;

import a.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;

public abstract class e implements ServiceConnection {
    private Context mApplicationContext;

    class a extends c {
        a(b bVar, ComponentName componentName, Context context) {
            super(bVar, componentName, context);
        }
    }

    /* access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(@NonNull ComponentName componentName, @NonNull c cVar);

    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.mApplicationContext != null) {
            onCustomTabsServiceConnected(componentName, new a(b.a.c(iBinder), componentName, this.mApplicationContext));
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }

    /* access modifiers changed from: package-private */
    public void setApplicationContext(@NonNull Context context) {
        this.mApplicationContext = context;
    }
}
