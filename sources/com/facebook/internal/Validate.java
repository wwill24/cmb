package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J$\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0014H\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J$\u0010#\u001a\u00020\f\"\u0004\b\u0000\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J$\u0010%\u001a\u00020\f\"\u0004\b\u0000\u0010\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00110\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010&\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010'\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J7\u0010(\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0016\u0010)\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010*\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\fH\u0007J\b\u0010-\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/internal/Validate;", "", "()V", "CONTENT_PROVIDER_BASE", "", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CUSTOM_TAB_REDIRECT_URI_PREFIX", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "NO_INTERNET_PERMISSION_REASON", "TAG", "kotlin.jvm.PlatformType", "containsNoNullOrEmpty", "", "container", "", "name", "containsNoNulls", "T", "hasAppID", "hasBluetoothPermission", "", "context", "Landroid/content/Context;", "hasChangeWifiStatePermission", "hasClientToken", "hasContentProvider", "hasCustomTabRedirectActivity", "redirectURI", "hasFacebookActivity", "shouldThrow", "hasInternetPermissions", "hasLocationPermission", "hasPermission", "permission", "hasWiFiPermission", "notEmpty", "arg", "notEmptyAndContainsNoNulls", "notNull", "notNullOrEmpty", "oneOf", "values", "", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "runningOnUiThread", "sdkInitialized", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    public static final Validate INSTANCE = new Validate();
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG = Validate.class.getName();

    private Validate() {
    }

    public static final void containsNoNullOrEmpty(Collection<String> collection, String str) {
        boolean z10;
        j.g(collection, "container");
        j.g(str, "name");
        for (String next : collection) {
            if (next != null) {
                if (next.length() > 0) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (!z10) {
                    throw new IllegalArgumentException(("Container '" + str + "' cannot contain empty values").toString());
                }
            } else {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static final <T> void containsNoNulls(Collection<? extends T> collection, String str) {
        j.g(collection, "container");
        j.g(str, "name");
        for (Object obj : collection) {
            if (obj == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    public static final boolean hasBluetoothPermission(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (!hasPermission(context, "android.permission.BLUETOOTH") || !hasPermission(context, "android.permission.BLUETOOTH_ADMIN")) {
            return false;
        }
        return true;
    }

    public static final boolean hasChangeWifiStatePermission(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml".toString());
    }

    public static final void hasContentProvider(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        String hasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String p10 = j.p(CONTENT_PROVIDER_BASE, hasAppID);
            if (packageManager.resolveContentProvider(p10, 0) == null) {
                o oVar = o.f32141a;
                String format2 = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(new Object[]{p10}, 1));
                j.f(format2, "java.lang.String.format(format, *args)");
                throw new IllegalStateException(format2.toString());
            }
        }
    }

    public static final boolean hasCustomTabRedirectActivity(Context context, String str) {
        List<ResolveInfo> list;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        boolean z10 = false;
        for (ResolveInfo resolveInfo : list) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!j.b(activityInfo.name, "com.facebook.CustomTabActivity") || !j.b(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z10 = true;
        }
        return z10;
    }

    public static final void hasFacebookActivity(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        hasFacebookActivity(context, true);
    }

    public static final void hasInternetPermissions(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        hasInternetPermissions(context, true);
    }

    public static final boolean hasLocationPermission(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            return true;
        }
        return false;
    }

    public static final boolean hasPermission(Context context, String str) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "permission");
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static final boolean hasWiFiPermission(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    public static final <T> void notEmpty(Collection<? extends T> collection, String str) {
        j.g(collection, "container");
        j.g(str, "name");
        if (!(!collection.isEmpty())) {
            throw new IllegalArgumentException(("Container '" + str + "' cannot be empty").toString());
        }
    }

    public static final <T> void notEmptyAndContainsNoNulls(Collection<? extends T> collection, String str) {
        j.g(collection, "container");
        j.g(str, "name");
        containsNoNulls(collection, str);
        notEmpty(collection, str);
    }

    public static final void notNull(Object obj, String str) {
        j.g(str, "name");
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if ((r3.length() > 0) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String notNullOrEmpty(java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.j.g(r4, r0)
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0015
            int r2 = r3.length()
            if (r2 <= 0) goto L_0x0011
            r2 = r0
            goto L_0x0012
        L_0x0011:
            r2 = r1
        L_0x0012:
            if (r2 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0019
            return r3
        L_0x0019:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Argument '"
            r3.append(r0)
            r3.append(r4)
            java.lang.String r4 = "' cannot be null or empty"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.notNullOrEmpty(java.lang.String, java.lang.String):java.lang.String");
    }

    public static final void oneOf(Object obj, String str, Object... objArr) {
        j.g(str, "name");
        j.g(objArr, "values");
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj2 = objArr[i10];
            i10++;
            if (j.b(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + str + "' was not one of the allowed values");
    }

    public static final void runningOnUiThread() {
        if (!j.b(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void hasFacebookActivity(android.content.Context r4, boolean r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.g(r4, r0)
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r1 = 1
            if (r0 == 0) goto L_0x0018
            android.content.ComponentName r2 = new android.content.ComponentName
            java.lang.String r3 = "com.facebook.FacebookActivity"
            r2.<init>(r4, r3)
            android.content.pm.ActivityInfo r4 = r0.getActivityInfo(r2, r1)     // Catch:{ NameNotFoundException -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            if (r4 != 0) goto L_0x002c
            r4 = r5 ^ 1
            if (r4 == 0) goto L_0x0020
            goto L_0x002c
        L_0x0020:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Validate.hasFacebookActivity(android.content.Context, boolean):void");
    }

    public static final void hasInternetPermissions(Context context, boolean z10) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1 && !(!z10)) {
            throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON.toString());
        }
    }

    public static final void notEmpty(String str, String str2) {
        j.g(str, "arg");
        j.g(str2, "name");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be empty").toString());
        }
    }
}
