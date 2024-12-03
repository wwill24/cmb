package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.e0;

public final class GooglePlayServicesUtil extends e {
    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = e.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i10, @NonNull Activity activity, int i11) {
        return getErrorDialog(i10, activity, i11, (DialogInterface.OnCancelListener) null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i10, @NonNull Context context, int i11) {
        return e.getErrorPendingIntent(i10, context, i11);
    }

    @NonNull
    @Deprecated
    public static String getErrorString(int i10) {
        return e.getErrorString(i10);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return e.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return e.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return e.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i10) {
        return e.isUserRecoverableError(i10);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, int i11) {
        return showErrorDialogFragment(i10, activity, i11, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static void showErrorNotification(int i10, @NonNull Context context) {
        c p10 = c.p();
        if (e.isPlayServicesPossiblyUpdating(context, i10) || e.isPlayStorePossiblyUpdating(context, i10)) {
            p10.x(context);
        } else {
            p10.r(context, i10);
        }
    }

    @Deprecated
    public static Dialog getErrorDialog(int i10, @NonNull Activity activity, int i11, DialogInterface.OnCancelListener onCancelListener) {
        if (true == e.isPlayServicesPossiblyUpdating(activity, i10)) {
            i10 = 18;
        }
        return c.p().n(activity, i10, i11, onCancelListener);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i10) {
        return e.isGooglePlayServicesAvailable(context, i10);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i10, activity, (Fragment) null, i11, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, Fragment fragment, int i11, DialogInterface.OnCancelListener onCancelListener) {
        if (true == e.isPlayServicesPossiblyUpdating(activity, i10)) {
            i10 = 18;
        }
        c p10 = c.p();
        if (fragment == null) {
            return p10.q(activity, i10, i11, onCancelListener);
        }
        Dialog s10 = p10.s(activity, i10, e0.c(fragment, c.p().d(activity, i10, "d"), i11), onCancelListener);
        if (s10 == null) {
            return false;
        }
        p10.v(activity, s10, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
