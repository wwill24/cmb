package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.mparticle.identity.IdentityHttpResponse;
import gk.h;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility;", "", "Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "activityType", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "", "anonymousAppDeviceGUID", "", "limitEventUsage", "Landroid/content/Context;", "context", "Lorg/json/b;", "getJSONObjectForGraphAPICall", "", "API_ACTIVITY_TYPE_TO_STRING", "Ljava/util/Map;", "<init>", "()V", "GraphAPIActivityType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = h0.k(h.a(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), h.a(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));
    public static final AppEventsLoggerUtility INSTANCE = new AppEventsLoggerUtility();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "(Ljava/lang/String;I)V", "MOBILE_INSTALL_EVENT", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    private AppEventsLoggerUtility() {
    }

    public static final b getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z10, Context context) throws JSONException {
        j.g(graphAPIActivityType, "activityType");
        j.g(context, IdentityHttpResponse.CONTEXT);
        b bVar = new b();
        bVar.put("event", (Object) API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        String userID = AppEventsLogger.Companion.getUserID();
        if (userID != null) {
            bVar.put("app_user_id", (Object) userID);
        }
        Utility.setAppEventAttributionParameters(bVar, attributionIdentifiers, str, z10, context);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(bVar, context);
        } catch (Exception e10) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e10.toString());
        }
        b dataProcessingOptions = Utility.getDataProcessingOptions();
        if (dataProcessingOptions != null) {
            Iterator<String> keys = dataProcessingOptions.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bVar.put(next, dataProcessingOptions.get(next));
            }
        }
        bVar.put("application_package_name", (Object) context.getPackageName());
        return bVar;
    }
}
