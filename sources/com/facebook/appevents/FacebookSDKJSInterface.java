package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J&\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068GXD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/FacebookSDKJSInterface;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "protocol", "", "getProtocol", "()Ljava/lang/String;", "sendEvent", "", "pixelId", "eventName", "jsonString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookSDKJSInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String TAG = FacebookSDKJSInterface.class.getSimpleName();
    private final Context context;
    private final String protocol = "fbmq-0.1";

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u001f\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/FacebookSDKJSInterface$Companion;", "", "Lorg/json/b;", "jsonObject", "Landroid/os/Bundle;", "jsonToBundle", "", "jsonString", "jsonStringToBundle", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "PARAMETER_FBSDK_PIXEL_REFERRAL", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Bundle jsonStringToBundle(String str) {
            try {
                return jsonToBundle(new b(str));
            } catch (JSONException unused) {
                return new Bundle();
            }
        }

        private final Bundle jsonToBundle(b bVar) throws JSONException {
            Bundle bundle = new Bundle();
            Iterator<String> keys = bVar.keys();
            j.f(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null) {
                    String str = next;
                    bundle.putString(str, bVar.getString(str));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            return bundle;
        }

        public final String getTAG() {
            return FacebookSDKJSInterface.access$getTAG$cp();
        }
    }

    public FacebookSDKJSInterface(Context context2) {
        this.context = context2;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        Class<FacebookSDKJSInterface> cls = FacebookSDKJSInterface.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    @JavascriptInterface
    public final String getProtocol() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.protocol;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    @JavascriptInterface
    public final void sendEvent(String str, String str2, String str3) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (str == null) {
                try {
                    Logger.Companion companion = Logger.Companion;
                    LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                    String str4 = TAG;
                    j.f(str4, "TAG");
                    companion.log(loggingBehavior, str4, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            } else {
                InternalAppEventsLogger createInstance$default = InternalAppEventsLogger.Companion.createInstance$default(InternalAppEventsLogger.Companion, this.context, (String) null, 2, (Object) null);
                Bundle access$jsonStringToBundle = Companion.jsonStringToBundle(str3);
                access$jsonStringToBundle.putString(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
                createInstance$default.logEvent(str2, access$jsonStringToBundle);
            }
        }
    }
}
