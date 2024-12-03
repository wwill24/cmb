package com.leanplum.internal;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import androidx.annotation.NonNull;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumException;
import com.leanplum.LeanplumLocationAccuracyType;
import com.leanplum.actions.internal.ActionManagerTriggeringKt;
import com.leanplum.actions.internal.ActionsTrigger;
import com.leanplum.actions.internal.Priority;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.Constants;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.Request;
import com.leanplum.migration.MigrationManager;
import com.leanplum.models.GeofenceEventType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.json.JSONException;
import org.json.b;

public class LeanplumInternal {
    private static final String ACTION = "action";
    private static final String LEANPLUM_LOCAL_PUSH_HELPER = "com.leanplum.internal.LeanplumLocalPushHelper";
    private static boolean calledStart;
    private static boolean hasStarted;
    private static boolean hasStartedAndRegisteredAsDeveloper;
    /* access modifiers changed from: private */
    public static boolean inForeground;
    private static final Object inForegroundLock = new Object();
    private static boolean isPaused;
    private static boolean isScreenTrackingEnabled = false;
    private static boolean isVariantDebugInfoEnabled = false;
    private static boolean issuedStart;
    private static final ArrayList<Runnable> startIssuedHandlers = new ArrayList<>();
    private static boolean startSuccessful;
    private static boolean startedInBackground;
    private static final Queue<Map<String, ?>> userAttributeChanges = new ConcurrentLinkedQueue();

    public interface locationAttributeRequestsCallback {
        void response(boolean z10);
    }

    public static void addStartIssuedHandler(Runnable runnable) {
        if (runnable == null) {
            Log.e("addStartIssuedHandler - Invalid handler parameter provided.", new Object[0]);
            return;
        }
        ArrayList<Runnable> arrayList = startIssuedHandlers;
        synchronized (arrayList) {
            if (!issuedStart) {
                arrayList.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    private static void cancelLocalPush(@NonNull String str) {
        try {
            if (((Boolean) LeanplumLocalPushHelper.class.getDeclaredMethod("cancelLocalPush", new Class[]{String.class}).invoke((Object) null, new Object[]{str})).booleanValue()) {
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.Params.MESSAGE_ID, str);
                track("Cancel", 0.0d, (String) null, (Map<String, ?>) null, hashMap);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void connectDevelopmentServer() {
        Leanplum.addStartResponseHandler(new StartCallback() {
            public void onResponse(boolean z10) {
                if (z10 && LeanplumInternal.inForeground && MigrationManager.getState().useLeanplum() && Constants.isDevelopmentModeEnabled && !Constants.isNoop()) {
                    Socket.connectSocket();
                }
            }
        });
    }

    public static void enableAutomaticScreenTracking() {
        isScreenTrackingEnabled = true;
    }

    private static int fetchCountDown(ActionContext actionContext, Map<String, Object> map) {
        if (!(actionContext == null || map == null)) {
            if (actionContext.isPreview()) {
                return 5;
            }
            String originalMessageId = actionContext.getOriginalMessageId();
            if (originalMessageId == null) {
                return 0;
            }
            Object obj = ((Map) CollectionUtil.uncheckedCast(map.get(originalMessageId))).get("countdown");
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
        }
        return 0;
    }

    public static boolean getIsScreenTrackingEnabled() {
        return isScreenTrackingEnabled;
    }

    public static boolean getIsVariantDebugInfoEnabled() {
        return isVariantDebugInfoEnabled;
    }

    public static Queue<Map<String, ?>> getUserAttributeChanges() {
        return userAttributeChanges;
    }

    public static boolean hasCalledStart() {
        return calledStart;
    }

    public static boolean hasStarted() {
        return hasStarted;
    }

    public static boolean hasStartedAndRegisteredAsDeveloper() {
        return hasStartedAndRegisteredAsDeveloper;
    }

    public static boolean hasStartedInBackground() {
        return startedInBackground;
    }

    public static boolean isPaused() {
        return isPaused;
    }

    public static boolean isStartSuccessful() {
        return startSuccessful;
    }

    private static boolean isValidScalarValue(Object obj, String str) {
        if ((obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean)) {
            return true;
        }
        maybeThrowException(new LeanplumException(str + " values must be of type String, Number, or Boolean."));
        return false;
    }

    public static boolean issuedStart() {
        return issuedStart;
    }

    private static Map<String, Object> makeTrackArgs(String str, double d10, String str2, Map<String, ?> map, Map<String, String> map2) {
        HashMap hashMap = new HashMap();
        if (map2 != null) {
            hashMap.putAll(map2);
        }
        hashMap.put("value", Double.toString(d10));
        hashMap.put("info", str2);
        if (str != null) {
            hashMap.put("event", str);
        }
        if (map != null) {
            hashMap.put("params", JsonConverter.toJson(validateAttributes(map, "params", false)));
        }
        if (!inForeground || LeanplumActivityHelper.isActivityPaused()) {
            hashMap.put("allowOffline", Boolean.TRUE.toString());
        }
        return hashMap;
    }

    public static void maybePerformActions(String str, String str2, int i10, String str3, ActionContext.ContextualValues contextualValues) {
        maybePerformActions(new String[]{str}, str2, i10, str3, contextualValues);
    }

    public static void maybeThrowException(RuntimeException runtimeException) {
        if (!Constants.isDevelopmentModeEnabled) {
            Log.e(runtimeException.getMessage() + " This error is only thrown in development mode.", (Throwable) runtimeException);
            return;
        }
        throw runtimeException;
    }

    public static void moveToForeground() {
        synchronized (inForegroundLock) {
            if (!inForeground) {
                inForeground = true;
                Leanplum.addStartResponseHandler(new StartCallback() {
                    public void onResponse(boolean z10) {
                        if (z10) {
                            LeanplumInternal.maybePerformActions(new String[]{"start", StreamManagement.Resume.ELEMENT}, (String) null, 3, (String) null, (ActionContext.ContextualValues) null);
                            LeanplumInternal.recordAttributeChanges();
                        }
                    }
                });
                connectDevelopmentServer();
            }
        }
    }

    public static void onHasStartedAndRegisteredAsDeveloper() {
        synchronized (FileManager.initializingLock) {
            if (FileManager.initializing()) {
                FileManager.setResourceSyncFinishBlock(new FileManager.ResourceUpdateCallback() {
                    public void onResourceSyncFinish() {
                        try {
                            LeanplumInternal.onHasStartedAndRegisteredAsDeveloperAndFinishedSyncing();
                        } catch (Throwable th2) {
                            Log.exception(th2);
                        }
                    }
                });
            } else {
                onHasStartedAndRegisteredAsDeveloperAndFinishedSyncing();
            }
        }
    }

    /* access modifiers changed from: private */
    public static void onHasStartedAndRegisteredAsDeveloperAndFinishedSyncing() {
        if (!hasStartedAndRegisteredAsDeveloper) {
            hasStartedAndRegisteredAsDeveloper = true;
        }
    }

    public static void performTrackedAction(String str, String str2) {
        Map map;
        Map<String, Object> messages = VarCache.messages();
        if (messages != null && (map = (Map) CollectionUtil.uncheckedCast(messages.get(str2))) != null) {
            new ActionContext(map.get("action").toString(), (Map) CollectionUtil.uncheckedCast(map.get("vars")), str2).runTrackedActionNamed(str);
        }
    }

    public static void recordAttributeChanges() {
        boolean z10 = false;
        for (Map next : userAttributeChanges) {
            Map userAttributes = VarCache.userAttributes();
            if (userAttributes == null) {
                userAttributes = new HashMap();
            }
            for (String str : next.keySet()) {
                Object obj = userAttributes.get(str);
                Object obj2 = next.get(str);
                if ((obj == null && obj2 != null) || (obj != null && !obj.equals(obj2))) {
                    ActionContext.ContextualValues contextualValues = new ActionContext.ContextualValues();
                    contextualValues.previousAttributeValue = obj;
                    contextualValues.attributeValue = obj2;
                    userAttributes.put(str, obj2);
                    maybePerformActions("userAttribute", str, 3, (String) null, contextualValues);
                    z10 = true;
                }
            }
        }
        userAttributeChanges.clear();
        if (z10) {
            VarCache.saveUserAttributes();
        }
    }

    private static void scheduleLocalPush(ActionContext actionContext) {
        try {
            if (((Boolean) LeanplumLocalPushHelper.class.getDeclaredMethod("scheduleLocalPush", new Class[]{ActionContext.class}).invoke(new Object(), new Object[]{actionContext})).booleanValue()) {
                ActionManager.getInstance().recordLocalPushImpression(actionContext.getMessageId());
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public static void setCalledStart(boolean z10) {
        calledStart = z10;
    }

    public static void setHasStarted(boolean z10) {
        hasStarted = z10;
    }

    public static void setIsPaused(boolean z10) {
        isPaused = z10;
    }

    public static void setIsVariantDebugInfoEnabled(boolean z10) {
        isVariantDebugInfoEnabled = z10;
    }

    private static void setIssuedStart(boolean z10) {
        issuedStart = z10;
    }

    public static void setStartSuccessful(boolean z10) {
        startSuccessful = z10;
    }

    public static void setStartedInBackground(boolean z10) {
        startedInBackground = z10;
    }

    public static void setUserLocationAttribute(final Location location, final LeanplumLocationAccuracyType leanplumLocationAccuracyType, final locationAttributeRequestsCallback locationattributerequestscallback) {
        Leanplum.addStartResponseHandler(new StartCallback() {
            public void onResponse(final boolean z10) {
                OperationQueue.sharedInstance().addParallelOperation(new Runnable() {
                    public void run() {
                        if (z10) {
                            Location location = location;
                            if (location == null) {
                                Log.e("Location can't be null in setUserLocationAttribute.", new Object[0]);
                                return;
                            }
                            Locale locale = Locale.US;
                            String format2 = String.format(locale, "%.6f,%.6f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())});
                            HashMap hashMap = new HashMap();
                            hashMap.put("location", format2);
                            hashMap.put(Constants.Keys.LOCATION_ACCURACY_TYPE, leanplumLocationAccuracyType.name().toLowerCase());
                            if (!(Leanplum.getContext() == null || locale == null)) {
                                try {
                                    List<Address> fromLocation = new Geocoder(Leanplum.getContext(), locale).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    if (fromLocation != null && fromLocation.size() > 0) {
                                        Address address = fromLocation.get(0);
                                        hashMap.put(Constants.Keys.CITY, address.getLocality());
                                        hashMap.put(Constants.Keys.REGION, address.getAdminArea());
                                        hashMap.put("country", address.getCountryCode());
                                    }
                                } catch (IOException e10) {
                                    Log.e("Failed to connect to Geocoder: " + e10, new Object[0]);
                                } catch (IllegalArgumentException e11) {
                                    Log.e("Invalid latitude or longitude values: " + e11, new Object[0]);
                                } catch (Throwable unused) {
                                }
                            }
                            Request create = RequestBuilder.withSetUserAttributesAction().andParams(hashMap).create();
                            create.onResponse(new Request.ResponseCallback() {
                                public void response(b bVar) {
                                    locationattributerequestscallback.response(true);
                                }
                            });
                            create.onError(new Request.ErrorCallback() {
                                public void error(Exception exc) {
                                    locationattributerequestscallback.response(false);
                                    Log.e("setUserAttributes failed when specifying location with error: " + exc.getMessage(), new Object[0]);
                                }
                            });
                            RequestSender.getInstance().send(create);
                        }
                    }
                });
            }
        });
    }

    public static boolean shouldSuppressMessage(@NonNull ActionContext actionContext) {
        if (ActionManager.PUSH_NOTIFICATION_ACTION_NAME.equals(actionContext.actionName())) {
            return false;
        }
        return ActionManager.getInstance().shouldSuppressMessages();
    }

    public static void track(String str, double d10, String str2, Map<String, ?> map, Map<String, String> map2) {
        if (!Constants.isNoop()) {
            try {
                trackInternalWhenStarted(str, map, makeTrackArgs(str, d10, str2, map, map2));
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    public static void trackGeofence(GeofenceEventType geofenceEventType, double d10, String str, Map<String, ?> map, Map<String, String> map2) {
        if (!Constants.isNoop()) {
            try {
                RequestSender.getInstance().send(RequestBuilder.withTrackGeofenceAction().andParams(makeTrackArgs(geofenceEventType.getName(), d10, str, map, map2)).andType(Request.RequestType.IMMEDIATE).create());
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void trackInternal(String str, Map<String, ?> map, Map<String, Object> map2) {
        String str2;
        RequestSender.getInstance().send(RequestBuilder.withTrackAction().andParams(map2).create());
        if (map2.get(Constants.Params.MESSAGE_ID) != null) {
            str2 = map2.get(Constants.Params.MESSAGE_ID).toString();
            String str3 = ".m" + str2;
            if (str == null || str.length() <= 0) {
                str = str3;
            } else {
                str = str3 + " " + str;
            }
        } else {
            str2 = null;
        }
        ActionContext.ContextualValues contextualValues = new ActionContext.ContextualValues();
        contextualValues.parameters = map;
        contextualValues.arguments = map2;
        if (map2.containsKey("params")) {
            try {
                contextualValues.arguments.put("params", new b(contextualValues.arguments.get("params").toString()));
            } catch (JSONException unused) {
            }
        }
        maybePerformActions("event", str, 3, str2, contextualValues);
    }

    private static void trackInternalWhenStarted(final String str, final Map<String, ?> map, final Map<String, Object> map2) {
        if (issuedStart) {
            trackInternal(str, map, map2);
        } else {
            addStartIssuedHandler(new Runnable() {
                public void run() {
                    try {
                        LeanplumInternal.trackInternal(str, map, map2);
                    } catch (Throwable th2) {
                        Log.exception(th2);
                    }
                }
            });
        }
    }

    public static void triggerStartIssued() {
        ArrayList<Runnable> arrayList = startIssuedHandlers;
        synchronized (arrayList) {
            setIssuedStart(true);
            Iterator<Runnable> it = arrayList.iterator();
            while (it.hasNext()) {
                OperationQueue.sharedInstance().addUiOperation(it.next());
            }
            startIssuedHandlers.clear();
        }
    }

    public static <T> Map<String, T> validateAttributes(Map<String, T> map, String str, boolean z10) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                if (!z10 || !(value instanceof Iterable)) {
                    if (value instanceof Date) {
                        value = CollectionUtil.uncheckedCast(Long.valueOf(((Date) CollectionUtil.uncheckedCast(value)).getTime()));
                    }
                    if (value != null && !isValidScalarValue(value, str)) {
                    }
                } else {
                    boolean z11 = true;
                    Iterator it = ((Iterable) CollectionUtil.uncheckedCast(value)).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!isValidScalarValue(it.next(), str)) {
                                z11 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z11) {
                    }
                }
                hashMap.put((String) next.getKey(), value);
            }
            return hashMap;
        } catch (ConcurrentModificationException unused) {
            maybeThrowException(new LeanplumException("ConcurrentModificationException: You cannot modify Map<String, ?> attributes/parameters. Will override with an empty map"));
            return new HashMap();
        }
    }

    static void maybePerformActions(String[] strArr, String str, int i10, String str2, ActionContext.ContextualValues contextualValues) {
        String str3;
        String[] strArr2 = strArr;
        ActionContext.ContextualValues contextualValues2 = contextualValues;
        Map<String, Object> messages = VarCache.messages();
        if (messages != null) {
            ArrayList arrayList = new ArrayList();
            for (String next : messages.keySet()) {
                String str4 = str2;
                if (next == null || !next.equals(str4)) {
                    Map map = (Map) CollectionUtil.uncheckedCast(messages.get(next));
                    String str5 = (String) map.get("action");
                    if (str5 != null) {
                        if (str5.equals(ActionManager.HELD_BACK_ACTION_NAME)) {
                            str3 = Constants.HELD_BACK_MESSAGE_PREFIX + next;
                        } else {
                            str3 = next;
                        }
                        if (!(!str5.equals(ActionManager.PUSH_NOTIFICATION_ACTION_NAME)) || (i10 & 1) != 0) {
                            ActionManager.MessageMatchResult messageMatchResult = new ActionManager.MessageMatchResult();
                            int length = strArr2.length;
                            int i11 = 0;
                            while (i11 < length) {
                                String str6 = strArr2[i11];
                                ActionManager.MessageMatchResult messageMatchResult2 = messageMatchResult;
                                ActionManager.MessageMatchResult shouldShowMessage = ActionManager.getInstance().shouldShowMessage(str3, map, str6, str, contextualValues);
                                messageMatchResult2.matchedTrigger |= shouldShowMessage.matchedTrigger;
                                messageMatchResult2.matchedUnlessTrigger |= shouldShowMessage.matchedUnlessTrigger;
                                messageMatchResult2.matchedLimit |= shouldShowMessage.matchedLimit;
                                messageMatchResult2.matchedActivePeriod = shouldShowMessage.matchedActivePeriod | messageMatchResult2.matchedActivePeriod;
                                i11++;
                                messageMatchResult = messageMatchResult2;
                                str3 = str3;
                                length = length;
                                messages = messages;
                                strArr2 = strArr;
                            }
                            ActionManager.MessageMatchResult messageMatchResult3 = messageMatchResult;
                            Map<String, Object> map2 = messages;
                            String str7 = str3;
                            if (messageMatchResult3.matchedUnlessTrigger && ActionManager.PUSH_NOTIFICATION_ACTION_NAME.equals(map.get("action"))) {
                                cancelLocalPush(next);
                            }
                            if (messageMatchResult3.matchedActivePeriod && messageMatchResult3.matchedTrigger) {
                                ActionManager.getInstance().recordMessageTrigger(str7);
                                if (messageMatchResult3.matchedLimit) {
                                    ActionContext actionContext = new ActionContext(map.get("action").toString(), (Map) CollectionUtil.uncheckedCast(map.get("vars")), str7, next, map.containsKey(JingleS5BTransportCandidate.ATTR_PRIORITY) ? ((Integer) map.get(JingleS5BTransportCandidate.ATTR_PRIORITY)).intValue() : 1000);
                                    actionContext.setContextualValues(contextualValues2);
                                    arrayList.add(actionContext);
                                }
                            }
                            strArr2 = strArr;
                            messages = map2;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList, new Comparator<ActionContext>() {
                    public int compare(ActionContext actionContext, ActionContext actionContext2) {
                        return actionContext.getPriority() - actionContext2.getPriority();
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ActionContext actionContext2 = (ActionContext) it.next();
                    if (actionContext2.actionName().equals(ActionManager.HELD_BACK_ACTION_NAME)) {
                        ActionManager.getInstance().recordHeldBackImpression(actionContext2.getMessageId(), actionContext2.getOriginalMessageId());
                    } else if (ActionManager.PUSH_NOTIFICATION_ACTION_NAME.equals(actionContext2.actionName())) {
                        scheduleLocalPush(actionContext2);
                    } else if (shouldSuppressMessage(actionContext2)) {
                        Log.i("Local IAM caps reached, suppressing messageId=" + actionContext2.getMessageId(), new Object[0]);
                    } else {
                        arrayList2.add(actionContext2);
                    }
                }
                ActionManagerTriggeringKt.trigger(ActionManager.getInstance(), arrayList2, Priority.DEFAULT, new ActionsTrigger(str, Arrays.asList(strArr), contextualValues2));
            }
        }
    }
}
