package w4;

import android.app.Application;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.b;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.l;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.pushnotification.CTNotificationIntentService;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationReceiver;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundIntentService;
import com.clevertap.android.sdk.pushnotification.amp.CTBackgroundJobService;
import com.clevertap.android.sdk.pushnotification.j;
import com.clevertap.android.sdk.q;
import i4.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static void a(Context context) {
        String str = context.getApplicationInfo().className;
        if (str == null || str.isEmpty()) {
            p.j("Unable to determine Application Class");
        } else if (str.equals("com.clevertap.android.sdk.Application")) {
            p.j("AndroidManifest.xml uses the CleverTap Application class, be sure you have properly added the CleverTap Account ID and Token to your AndroidManifest.xml, \nor set them programmatically in the onCreate method of your custom application class prior to calling super.onCreate()");
        } else {
            p.j("Application Class is " + str);
        }
    }

    private static void b(Context context, j jVar) {
        try {
            f((Application) context.getApplicationContext(), CTPushNotificationReceiver.class.getName());
            g((Application) context.getApplicationContext(), CTNotificationIntentService.class.getName());
            e((Application) context.getApplicationContext(), InAppNotificationActivity.class);
            e((Application) context.getApplicationContext(), CTInboxActivity.class);
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTGeofenceReceiver");
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTLocationUpdateReceiver");
            f((Application) context.getApplicationContext(), "com.clevertap.android.geofence.CTGeofenceBootReceiver");
            g((Application) context.getApplicationContext(), CTBackgroundJobService.class.getName());
            g((Application) context.getApplicationContext(), CTBackgroundIntentService.class.getName());
        } catch (Exception e10) {
            p.o("Receiver/Service issue : " + e10.toString());
        }
        ArrayList<PushConstants.PushType> x10 = jVar.x();
        if (x10 != null) {
            Iterator<PushConstants.PushType> it = x10.iterator();
            while (it.hasNext()) {
                PushConstants.PushType next = it.next();
                if (next == PushConstants.PushType.FCM) {
                    try {
                        g((Application) context.getApplicationContext(), "com.clevertap.android.sdk.pushnotification.fcm.FcmMessageListenerService");
                    } catch (Exception e11) {
                        p.o("Receiver/Service issue : " + e11.toString());
                    } catch (Error e12) {
                        p.o("FATAL : " + e12.getMessage());
                    }
                } else if (next == PushConstants.PushType.HPS) {
                    try {
                        g((Application) context.getApplicationContext(), "com.clevertap.android.hms.CTHmsMessageService");
                    } catch (Exception e13) {
                        p.o("Receiver/Service issue : " + e13.toString());
                    } catch (Error e14) {
                        p.o("FATAL : " + e14.getMessage());
                    }
                } else if (next == PushConstants.PushType.XPS) {
                    try {
                        f((Application) context.getApplicationContext(), "com.clevertap.android.xps.XiaomiMessageReceiver");
                    } catch (Exception e15) {
                        p.o("Receiver/Service issue : " + e15.toString());
                    } catch (Error e16) {
                        p.o("FATAL : " + e16.getMessage());
                    }
                }
            }
        }
    }

    private static void c(l lVar) {
        p.j("SDK Version Code is " + lVar.L());
    }

    public static void d(Context context, l lVar, j jVar) {
        if (!x.s(context, "android.permission.INTERNET")) {
            p.a("Missing Permission: android.permission.INTERNET");
        }
        c(lVar);
        h(context);
        b(context, jVar);
        if (!TextUtils.isEmpty(q.h(context).g())) {
            p.j("We have noticed that your app is using a custom FCM Sender ID, this feature will be DISCONTINUED from the next version of the CleverTap Android SDK. With the next release, CleverTap Android SDK will only fetch the token using the google-services.json. Please reach out to CleverTap Support for any questions.");
        }
    }

    private static void e(Application application, Class cls) throws PackageManager.NameNotFoundException {
        ActivityInfo[] activityInfoArr = application.getPackageManager().getPackageInfo(application.getPackageName(), 1).activities;
        String name = cls.getName();
        for (ActivityInfo activityInfo : activityInfoArr) {
            if (activityInfo.name.equals(name)) {
                p.j(name.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        p.j(name.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    private static void f(Application application, String str) throws PackageManager.NameNotFoundException {
        for (ActivityInfo activityInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 2).receivers) {
            if (activityInfo.name.equals(str)) {
                p.j(str.replaceFirst("com.clevertap.android.", "") + " is present");
                return;
            }
        }
        p.j(str.replaceFirst("com.clevertap.android.", "") + " not present");
    }

    private static void g(Application application, String str) throws PackageManager.NameNotFoundException {
        for (ServiceInfo serviceInfo : application.getPackageManager().getPackageInfo(application.getPackageName(), 4).services) {
            if (serviceInfo.name.equals(str)) {
                p.j(str.replaceFirst("com.clevertap.android.sdk.", "") + " is present");
                return;
            }
        }
        p.j(str.replaceFirst("com.clevertap.android.sdk.", "") + " not present");
    }

    private static void h(Context context) {
        if (!b.f10117a && !CleverTapAPI.H()) {
            p.j("Activity Lifecycle Callback not registered. Either set the android:name in your AndroidManifest.xml application tag to com.clevertap.android.sdk.Application, \n or, if you have a custom Application class, call ActivityLifecycleCallback.register(this); before super.onCreate() in your class");
            a(context);
        }
    }
}
