package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.HashSet;

public class b extends androidx.core.content.a {

    /* renamed from: a  reason: collision with root package name */
    private static d f4402a;

    static class a {
        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i10, Bundle bundle) {
            activity.startActivityForResult(intent, i10, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
        }
    }

    /* renamed from: androidx.core.app.b$b  reason: collision with other inner class name */
    static class C0032b {
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class c {
        static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface d {
        boolean a(@NonNull Activity activity, @NonNull String[] strArr, int i10);
    }

    public interface e {
        void validateRequestPermissionsRequestCode(int i10);
    }

    public static void b(@NonNull Activity activity) {
        a.a(activity);
    }

    public static void c(@NonNull Activity activity) {
        C0032b.a(activity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(Activity activity) {
        if (!activity.isFinishing() && !d.i(activity)) {
            activity.recreate();
        }
    }

    public static void e(@NonNull Activity activity) {
        C0032b.b(activity);
    }

    public static void f(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    public static void g(@NonNull Activity activity, @NonNull String[] strArr, int i10) {
        String[] strArr2;
        d dVar = f4402a;
        if (dVar == null || !dVar.a(activity, strArr, i10)) {
            HashSet hashSet = new HashSet();
            int i11 = 0;
            while (i11 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i11])) {
                    if (!androidx.core.os.a.c() && TextUtils.equals(strArr[i11], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i11));
                    }
                    i11++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            if (size > 0) {
                strArr2 = new String[(strArr.length - size)];
            } else {
                strArr2 = strArr;
            }
            if (size > 0) {
                if (size != strArr.length) {
                    int i12 = 0;
                    for (int i13 = 0; i13 < strArr.length; i13++) {
                        if (!hashSet.contains(Integer.valueOf(i13))) {
                            strArr2[i12] = strArr[i13];
                            i12++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (activity instanceof e) {
                ((e) activity).validateRequestPermissionsRequestCode(i10);
            }
            c.b(activity, strArr, i10);
        }
    }

    public static void h(@NonNull Activity activity, p0 p0Var) {
        C0032b.c(activity, (SharedElementCallback) null);
    }

    public static void i(@NonNull Activity activity, p0 p0Var) {
        C0032b.d(activity, (SharedElementCallback) null);
    }

    public static boolean j(@NonNull Activity activity, @NonNull String str) {
        if (androidx.core.os.a.c() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return c.c(activity, str);
        }
        return false;
    }

    public static void k(@NonNull Activity activity, @NonNull Intent intent, int i10, Bundle bundle) {
        a.b(activity, intent, i10, bundle);
    }

    public static void l(@NonNull Activity activity, @NonNull IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        a.c(activity, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void m(@NonNull Activity activity) {
        C0032b.e(activity);
    }
}
