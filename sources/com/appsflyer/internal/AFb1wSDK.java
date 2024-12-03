package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;

public final class AFb1wSDK {
    public static long AFInAppEventType = 500;
    public static AFa1xSDK values;

    public interface AFa1xSDK {
        void valueOf(Activity activity);

        void values(Context context);
    }

    static void values(Context context, AFa1xSDK aFa1xSDK, final Executor executor) {
        values = aFa1xSDK;
        AnonymousClass5 r12 = new Application.ActivityLifecycleCallbacks() {
            boolean AFInAppEventParameterName;
            boolean values = true;

            public final void onActivityCreated(@NonNull final Activity activity, Bundle bundle) {
                executor.execute(new Runnable() {
                    public final void run() {
                        AFa1qSDK.AFInAppEventParameterName();
                        Intent intent = activity.getIntent();
                        if (AFa1qSDK.valueOf(intent) != null && intent != AFa1qSDK.values) {
                            AFa1qSDK.values = intent;
                        }
                    }
                });
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivityPaused(@NonNull final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        AnonymousClass5.this.values = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    AnonymousClass5 r02 = AnonymousClass5.this;
                                    if (r02.AFInAppEventParameterName && r02.values) {
                                        r02.AFInAppEventParameterName = false;
                                        try {
                                            AFb1wSDK.values.values(applicationContext);
                                        } catch (Exception e10) {
                                            AFLogger.afErrorLog("Listener threw exception! ", e10);
                                        }
                                    }
                                }
                            }, AFb1wSDK.AFInAppEventType);
                        } catch (Throwable th2) {
                            AFLogger.afErrorLog("Background task failed with a throwable: ", th2);
                        }
                    }
                });
            }

            public final void onActivityResumed(final Activity activity) {
                executor.execute(new Runnable() {
                    public final void run() {
                        if (!AnonymousClass5.this.AFInAppEventParameterName) {
                            try {
                                AFb1wSDK.values.valueOf(activity);
                            } catch (Exception e10) {
                                AFLogger.afErrorLog("Listener thrown an exception: ", e10, true);
                            }
                        }
                        AnonymousClass5 r02 = AnonymousClass5.this;
                        r02.values = false;
                        r02.AFInAppEventParameterName = true;
                    }
                });
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }
        };
        if (context instanceof Activity) {
            r12.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r12);
    }
}
