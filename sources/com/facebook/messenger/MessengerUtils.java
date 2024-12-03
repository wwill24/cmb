package com.facebook.messenger;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.messenger.MessengerThreadParams;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040$2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J \u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010)\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/messenger/MessengerUtils;", "", "()V", "EXTRA_APP_ID", "", "EXTRA_EXTERNAL_URI", "EXTRA_IS_COMPOSE", "EXTRA_IS_REPLY", "EXTRA_METADATA", "EXTRA_PARTICIPANTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_REPLY_TOKEN_KEY", "EXTRA_THREAD_TOKEN_KEY", "ORCA_THREAD_CATEGORY_20150314", "PACKAGE_NAME", "PROTOCOL_VERSION_20150314", "", "TAG", "finishShareToMessenger", "", "activity", "Landroid/app/Activity;", "shareToMessengerParams", "Lcom/facebook/messenger/ShareToMessengerParams;", "getAllAvailableProtocolVersions", "", "context", "Landroid/content/Context;", "getMessengerThreadParamsForIntent", "Lcom/facebook/messenger/MessengerThreadParams;", "intent", "Landroid/content/Intent;", "hasMessengerInstalled", "", "openMessengerInPlayStore", "parseParticipants", "", "s", "shareToMessenger", "requestCode", "shareToMessenger20150314", "startViewUri", "uri", "facebook-messenger_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MessengerUtils {
    public static final String EXTRA_APP_ID = "com.facebook.orca.extra.APPLICATION_ID";
    public static final String EXTRA_EXTERNAL_URI = "com.facebook.orca.extra.EXTERNAL_URI";
    public static final String EXTRA_IS_COMPOSE = "com.facebook.orca.extra.IS_COMPOSE";
    public static final String EXTRA_IS_REPLY = "com.facebook.orca.extra.IS_REPLY";
    public static final String EXTRA_METADATA = "com.facebook.orca.extra.METADATA";
    public static final String EXTRA_PARTICIPANTS = "com.facebook.orca.extra.PARTICIPANTS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.orca.extra.PROTOCOL_VERSION";
    public static final String EXTRA_REPLY_TOKEN_KEY = "com.facebook.orca.extra.REPLY_TOKEN";
    public static final String EXTRA_THREAD_TOKEN_KEY = "com.facebook.orca.extra.THREAD_TOKEN";
    public static final MessengerUtils INSTANCE = new MessengerUtils();
    public static final String ORCA_THREAD_CATEGORY_20150314 = "com.facebook.orca.category.PLATFORM_THREAD_20150314";
    public static final String PACKAGE_NAME = "com.facebook.orca";
    public static final int PROTOCOL_VERSION_20150314 = 20150314;
    private static final String TAG = "MessengerUtils";

    private MessengerUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        kotlin.io.b.a(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set<java.lang.Integer> getAllAvailableProtocolVersions(android.content.Context r8) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r8.getContentResolver()
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            java.lang.String r1 = "content://com.facebook.orca.provider.MessengerPlatformProvider/versions"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r6 = "version"
            java.lang.String[] r2 = new java.lang.String[]{r6}
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x001f
            goto L_0x003b
        L_0x001f:
            r1 = 0
            int r2 = r0.getColumnIndex(r6)     // Catch:{ all -> 0x003c }
        L_0x0024:
            boolean r3 = r0.moveToNext()     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x0036
            int r3 = r0.getInt(r2)     // Catch:{ all -> 0x003c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003c }
            r8.add(r3)     // Catch:{ all -> 0x003c }
            goto L_0x0024
        L_0x0036:
            kotlin.Unit r2 = kotlin.Unit.f32013a     // Catch:{ all -> 0x003c }
            kotlin.io.b.a(r0, r1)
        L_0x003b:
            return r8
        L_0x003c:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003e }
        L_0x003e:
            r1 = move-exception
            kotlin.io.b.a(r0, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messenger.MessengerUtils.getAllAvailableProtocolVersions(android.content.Context):java.util.Set");
    }

    private final List<String> parseParticipants(String str) {
        boolean z10;
        int i10;
        boolean z11;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return q.j();
        }
        Object[] array2 = StringsKt__StringsKt.C0(str, new String[]{AppsFlyerKit.COMMA}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (array2 != null) {
            String[] strArr = (String[]) array2;
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str2 : strArr) {
                int length = str2.length() - 1;
                int i11 = 0;
                boolean z12 = false;
                while (i11 <= length) {
                    if (!z12) {
                        i10 = i11;
                    } else {
                        i10 = length;
                    }
                    if (j.i(str2.charAt(i10), 32) <= 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z12) {
                        if (!z11) {
                            z12 = true;
                        } else {
                            i11++;
                        }
                    } else if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                }
                arrayList.add(str2.subSequence(i11, length + 1).toString());
            }
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void shareToMessenger20150314(Activity activity, int i10, ShareToMessengerParams shareToMessengerParams) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(1);
            intent.setPackage(PACKAGE_NAME);
            intent.putExtra("android.intent.extra.STREAM", shareToMessengerParams.getUri());
            intent.setType(shareToMessengerParams.getMimeType());
            intent.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
            intent.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
            intent.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
            intent.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
            activity.startActivityForResult(intent, i10);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME));
        }
    }

    private final void startViewUri(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void finishShareToMessenger(Activity activity, ShareToMessengerParams shareToMessengerParams) {
        j.g(activity, "activity");
        j.g(shareToMessengerParams, "shareToMessengerParams");
        Intent intent = activity.getIntent();
        Set<String> categories = intent.getCategories();
        if (categories == null) {
            activity.setResult(0, (Intent) null);
            activity.finish();
        } else if (categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
            AppLinks appLinks = AppLinks.INSTANCE;
            j.f(intent, "originalIntent");
            Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
            Intent intent2 = new Intent();
            if (appLinkExtras == null || !categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                throw new RuntimeException();
            }
            intent2.putExtra(EXTRA_PROTOCOL_VERSION, PROTOCOL_VERSION_20150314);
            intent2.putExtra(EXTRA_THREAD_TOKEN_KEY, appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY));
            intent2.setDataAndType(shareToMessengerParams.getUri(), shareToMessengerParams.getMimeType());
            intent2.setFlags(1);
            intent2.putExtra(EXTRA_APP_ID, FacebookSdk.getApplicationId());
            intent2.putExtra(EXTRA_METADATA, shareToMessengerParams.getMetaData());
            intent2.putExtra(EXTRA_EXTERNAL_URI, shareToMessengerParams.getExternalUri());
            activity.setResult(-1, intent2);
            activity.finish();
        } else {
            activity.setResult(0, (Intent) null);
            activity.finish();
        }
    }

    public final MessengerThreadParams getMessengerThreadParamsForIntent(Intent intent) {
        String str;
        String str2;
        String str3;
        Boolean bool;
        Boolean bool2;
        MessengerThreadParams.Origin origin;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            j.g(intent, SDKConstants.PARAM_INTENT);
            Set<String> categories = intent.getCategories();
            if (categories != null && categories.contains(ORCA_THREAD_CATEGORY_20150314)) {
                Bundle appLinkExtras = AppLinks.getAppLinkExtras(intent);
                if (appLinkExtras == null) {
                    str = null;
                } else {
                    str = appLinkExtras.getString(EXTRA_THREAD_TOKEN_KEY);
                }
                if (appLinkExtras == null) {
                    str2 = null;
                } else {
                    str2 = appLinkExtras.getString(EXTRA_METADATA);
                }
                if (appLinkExtras == null) {
                    str3 = null;
                } else {
                    str3 = appLinkExtras.getString(EXTRA_PARTICIPANTS);
                }
                if (appLinkExtras == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_REPLY));
                }
                if (appLinkExtras == null) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(appLinkExtras.getBoolean(EXTRA_IS_COMPOSE));
                }
                Boolean bool3 = Boolean.TRUE;
                if (j.b(bool, bool3)) {
                    origin = MessengerThreadParams.Origin.REPLY_FLOW;
                } else if (j.b(bool2, bool3)) {
                    origin = MessengerThreadParams.Origin.COMPOSE_FLOW;
                } else {
                    origin = MessengerThreadParams.Origin.UNKNOWN;
                }
                if (!(str == null || str2 == null)) {
                    return new MessengerThreadParams(origin, str, str2, parseParticipants(str3));
                }
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final boolean hasMessengerInstalled(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return FacebookSignatureValidator.validateSignature(context, PACKAGE_NAME);
    }

    public final void openMessengerInPlayStore(Context context) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(context, IdentityHttpResponse.CONTEXT);
                startViewUri(context, "market://details?id=com.facebook.orca");
            } catch (ActivityNotFoundException unused) {
                startViewUri(context, "http://play.google.com/store/apps/details?id=com.facebook.orca");
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void shareToMessenger(Activity activity, int i10, ShareToMessengerParams shareToMessengerParams) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(activity, "activity");
                j.g(shareToMessengerParams, "shareToMessengerParams");
                if (!hasMessengerInstalled(activity)) {
                    openMessengerInPlayStore(activity);
                } else if (getAllAvailableProtocolVersions(activity).contains(Integer.valueOf(PROTOCOL_VERSION_20150314))) {
                    shareToMessenger20150314(activity, i10, shareToMessengerParams);
                } else {
                    openMessengerInPlayStore(activity);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}
