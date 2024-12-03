package com.leanplum.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.LocationManager;
import com.leanplum.actions.MessageDisplayController;
import com.leanplum.actions.MessageDisplayListener;
import com.leanplum.actions.internal.Action;
import com.leanplum.actions.internal.ActionManagerExecutionKt;
import com.leanplum.actions.internal.ActionQueue;
import com.leanplum.actions.internal.ActionScheduler;
import com.leanplum.actions.internal.Definitions;
import com.leanplum.internal.Constants;
import com.leanplum.utils.SharedPreferencesUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smack.packet.Message;

public class ActionManager {
    private static final long DAY_MILLIS = 86400000;
    public static final String HELD_BACK_ACTION_NAME = "__held_back";
    private static final long HOUR_MILLIS = 3600000;
    public static final String PUSH_NOTIFICATION_ACTION_NAME = "__Push Notification";
    private static final long WEEK_MILLIS = 604800000;
    private static ActionManager instance = null;
    private static LocationManager locationManager = null;
    private static boolean loggedLocationManagerFailure = false;
    private boolean continueOnActivityResumed = true;
    private Action currentAction;
    private final Definitions definitions = new Definitions();
    private final ActionQueue delayedQueue = new ActionQueue();
    private boolean dismissOnPushOpened = true;
    private boolean enabled = true;
    private MessageDisplayController messageDisplayController;
    private MessageDisplayListener messageDisplayListener;
    private final Map<String, Map<String, Number>> messageImpressionOccurrences = new HashMap();
    private final Map<String, Number> messageTriggerOccurrences = new HashMap();
    private boolean paused = true;
    private final ActionQueue queue = new ActionQueue();
    private ActionScheduler scheduler = new ActionScheduler();
    private final Map<String, Number> sessionOccurrences = new HashMap();

    public static class MessageMatchResult {
        public boolean matchedActivePeriod;
        public boolean matchedLimit;
        public boolean matchedTrigger;
        public boolean matchedUnlessTrigger;
    }

    private ActionManager() {
    }

    public static void addRegionNamesFromTriggersToSet(Map<String, Object> map, Set<String> set) {
        if (map != null) {
            for (Map map2 : (List) CollectionUtil.uncheckedCast(map.get("children"))) {
                String str = (String) map2.get(Message.Subject.ELEMENT);
                if (str.equals("enterRegion") || str.equals("exitRegion")) {
                    set.add((String) map2.get("noun"));
                }
            }
        }
    }

    private int countOccurrences(long j10, long j11) {
        int i10 = 0;
        String format2 = String.format(Constants.Defaults.MESSAGE_IMPRESSION_OCCURRENCES_KEY, new Object[]{""});
        for (Map.Entry next : Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).getAll().entrySet()) {
            if (((String) next.getKey()).startsWith(format2)) {
                String str = (String) next.getValue();
                if (!TextUtils.isEmpty(str) && !str.equals("{}")) {
                    i10 += countOccurrences(j10, j11, str);
                }
            }
        }
        return i10;
    }

    public static void getForegroundandBackgroundRegionNames(Set<String> set, Set<String> set2) {
        Set<String> set3;
        Map<String, Object> messages = VarCache.messages();
        for (String str : messages.keySet()) {
            Map map = (Map) CollectionUtil.uncheckedCast(messages.get(str));
            Object obj = map.get("action");
            if (obj instanceof String) {
                if (obj.equals(PUSH_NOTIFICATION_ACTION_NAME)) {
                    set3 = set2;
                } else {
                    set3 = set;
                }
                addRegionNamesFromTriggersToSet((Map) CollectionUtil.uncheckedCast(map.get("whenTriggers")), set3);
                addRegionNamesFromTriggersToSet((Map) CollectionUtil.uncheckedCast(map.get("unlessTriggers")), set3);
            }
        }
    }

    public static synchronized ActionManager getInstance() {
        ActionManager actionManager;
        synchronized (ActionManager.class) {
            if (instance == null) {
                instance = new ActionManager();
            }
            actionManager = instance;
        }
        return actionManager;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (loggedLocationManagerFailure == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        com.leanplum.internal.Log.i("Geofencing support requires leanplum-location module and Google Play Services v8.1 and higher.\nAdd this to your build.gradle file:\nimplementation 'com.google.android.gms:play-services-location:8.3.0+'\nimplementation 'com.leanplum:leanplum-location:+'", new java.lang.Object[0]);
        loggedLocationManagerFailure = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.leanplum.LocationManager getLocationManager() {
        /*
            java.lang.Class<com.leanplum.internal.ActionManager> r0 = com.leanplum.internal.ActionManager.class
            monitor-enter(r0)
            com.leanplum.LocationManager r1 = locationManager     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            boolean r1 = com.leanplum.internal.Util.hasPlayServices()     // Catch:{ all -> 0x003b }
            r2 = 0
            if (r1 == 0) goto L_0x0039
            r1 = 0
            java.lang.String r3 = "com.leanplum.LocationManagerImplementation"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "instance"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ all -> 0x002b }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ all -> 0x002b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x002b }
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch:{ all -> 0x002b }
            com.leanplum.LocationManager r3 = (com.leanplum.LocationManager) r3     // Catch:{ all -> 0x002b }
            locationManager = r3     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r3
        L_0x002b:
            boolean r3 = loggedLocationManagerFailure     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0039
            java.lang.String r3 = "Geofencing support requires leanplum-location module and Google Play Services v8.1 and higher.\nAdd this to your build.gradle file:\nimplementation 'com.google.android.gms:play-services-location:8.3.0+'\nimplementation 'com.leanplum:leanplum-location:+'"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x003b }
            com.leanplum.internal.Log.i(r3, r1)     // Catch:{ all -> 0x003b }
            r1 = 1
            loggedLocationManagerFailure = r1     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r0)
            return r2
        L_0x003b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.ActionManager.getLocationManager():com.leanplum.LocationManager");
    }

    private boolean matchedTrigger(Map<String, Object> map, String str, String str2, ActionContext.ContextualValues contextualValues) {
        String str3;
        Map<String, ?> map2;
        Object obj;
        if (!((String) map.get(Message.Subject.ELEMENT)).equals(str) || (((str3 = (String) map.get("noun")) != null || str2 != null) && (str3 == null || !str3.equals(str2)))) {
            return false;
        }
        String str4 = (String) map.get("verb");
        List list = (List) CollectionUtil.uncheckedCast(map.get("objects"));
        if ("changesTo".equals(str4)) {
            if (!(contextualValues == null || list == null)) {
                for (Object next : list) {
                    if ((next == null && contextualValues.attributeValue == null) || (next != null && next.toString().equalsIgnoreCase(contextualValues.attributeValue.toString()))) {
                        return true;
                    }
                }
            }
            return false;
        } else if ("changesFromTo".equals(str4)) {
            if (contextualValues == null || list.size() != 2 || list.get(0) == null || list.get(1) == null || contextualValues.previousAttributeValue == null || contextualValues.attributeValue == null || !list.get(0).toString().equalsIgnoreCase(contextualValues.previousAttributeValue.toString()) || !list.get(1).toString().equalsIgnoreCase(contextualValues.attributeValue.toString())) {
                return false;
            }
            return true;
        } else if (!"triggersWithParameter".equals(str4)) {
            return true;
        } else {
            if (contextualValues == null || list.size() != 2 || list.get(0) == null || list.get(1) == null || (map2 = contextualValues.parameters) == null || (obj = map2.get(list.get(0))) == null || !obj.toString().equalsIgnoreCase(list.get(1).toString())) {
                return false;
            }
            return true;
        }
    }

    private boolean matchedTriggers(Object obj, String str, String str2, ActionContext.ContextualValues contextualValues) {
        if (!(obj instanceof Map)) {
            return false;
        }
        for (Object uncheckedCast : (List) CollectionUtil.uncheckedCast(((Map) CollectionUtil.uncheckedCast(obj)).get("children"))) {
            if (matchedTrigger((Map) CollectionUtil.uncheckedCast(uncheckedCast), str, str2, contextualValues)) {
                return true;
            }
        }
        return false;
    }

    private boolean matchesLimitTimes(int i10, int i11, String str, Map<String, Number> map, String str2) {
        int i12;
        int i13 = i10;
        int i14 = i11;
        String str3 = str;
        Map<String, Number> map2 = map;
        Number number = 0L;
        if (str3.equals("limitSession")) {
            Number number2 = this.sessionOccurrences.get(str2);
            if (number2 != null) {
                number = number2;
            }
        } else {
            if (map2 == null || map.isEmpty()) {
                return true;
            }
            Number number3 = map2.get("min");
            Number number4 = map2.get("max");
            if (number3 == null) {
                number3 = number;
            }
            if (number4 == null) {
                number4 = number;
            }
            long j10 = 1;
            if (str3.equals("limitUser")) {
                number = Long.valueOf((number4.longValue() - number3.longValue()) + 1);
            } else {
                if (str3.equals("limitMinute")) {
                    i14 *= 60;
                } else if (str3.equals("limitHour")) {
                    i14 *= 3600;
                } else {
                    if (str3.equals("limitDay")) {
                        i12 = 86400;
                    } else if (str3.equals("limitWeek")) {
                        i12 = 604800;
                    } else if (str3.equals("limitMonth")) {
                        i12 = 2592000;
                    }
                    i14 *= i12;
                }
                long currentTimeMillis = Clock.getInstance().currentTimeMillis();
                int i15 = 0;
                for (long longValue = number4.longValue(); longValue >= number3.longValue(); longValue -= j10) {
                    if (map2.containsKey("" + longValue)) {
                        if ((currentTimeMillis - map2.get("" + longValue).longValue()) / 1000 > ((long) i14)) {
                            break;
                        }
                        i15++;
                        if (i15 >= i13) {
                            return false;
                        }
                        j10 = 1;
                    }
                }
            }
        }
        if (number.longValue() < ((long) i13)) {
            return true;
        }
        return false;
    }

    private boolean matchesLimits(String str, Map<String, Object> map) {
        int parseInt;
        int i10;
        if (map == null) {
            return true;
        }
        List<Object> list = (List) CollectionUtil.uncheckedCast(map.get("children"));
        if (list.isEmpty()) {
            return true;
        }
        Map<String, Number> messageImpressionOccurrences2 = getMessageImpressionOccurrences(str);
        int messageTriggerOccurrences2 = getMessageTriggerOccurrences(str) + 1;
        for (Object uncheckedCast : list) {
            Map map2 = (Map) CollectionUtil.uncheckedCast(uncheckedCast);
            String obj = map2.get(Message.Subject.ELEMENT).toString();
            String obj2 = map2.get("noun").toString();
            String obj3 = map2.get("verb").toString();
            if (obj.equals("times")) {
                List list2 = (List) CollectionUtil.uncheckedCast(map2.get("objects"));
                if (list2.size() > 0) {
                    i10 = Integer.parseInt(list2.get(0).toString());
                } else {
                    i10 = 0;
                }
                if (!matchesLimitTimes(Integer.parseInt(obj2), i10, obj3, messageImpressionOccurrences2, str)) {
                    return false;
                }
            } else if (obj.equals("onNthOccurrence")) {
                if (messageTriggerOccurrences2 != Integer.parseInt(obj2)) {
                    return false;
                }
            } else if (obj.equals("everyNthOccurrence") && ((parseInt = Integer.parseInt(obj2)) == 0 || messageTriggerOccurrences2 % parseInt != 0)) {
                return false;
            }
        }
        return true;
    }

    private void recordImpression(String str) {
        Number number = this.sessionOccurrences.get(str);
        Number number2 = 0L;
        if (number == null) {
            number = number2;
        }
        this.sessionOccurrences.put(str, Long.valueOf(number.longValue() + 1));
        Map messageImpressionOccurrences2 = getMessageImpressionOccurrences(str);
        if (messageImpressionOccurrences2 == null || messageImpressionOccurrences2.isEmpty()) {
            messageImpressionOccurrences2 = new HashMap();
            messageImpressionOccurrences2.put("min", number2);
            messageImpressionOccurrences2.put("max", number2);
            messageImpressionOccurrences2.put("0", Long.valueOf(Clock.getInstance().currentTimeMillis()));
        } else {
            Number number3 = (Number) messageImpressionOccurrences2.get("min");
            Number number4 = (Number) messageImpressionOccurrences2.get("max");
            if (number3 == null) {
                number3 = number2;
            }
            if (number4 != null) {
                number2 = number4;
            }
            Long valueOf = Long.valueOf(number2.longValue() + 1);
            messageImpressionOccurrences2.put("" + valueOf, Long.valueOf(Clock.getInstance().currentTimeMillis()));
            if ((valueOf.longValue() - number3.longValue()) + 1 > 100) {
                messageImpressionOccurrences2.remove("" + number3);
                messageImpressionOccurrences2.put("min", Long.valueOf(number3.longValue() + 1));
            }
            messageImpressionOccurrences2.put("max", valueOf);
        }
        saveMessageImpressionOccurrences(messageImpressionOccurrences2, str);
    }

    private void trackHeldBackEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Params.MESSAGE_ID, str);
        LeanplumInternal.track(Constants.HELD_BACK_EVENT_NAME, 0.0d, (String) null, (Map<String, ?>) null, hashMap);
    }

    private void trackImpressionEvent(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.Params.MESSAGE_ID, str);
        LeanplumInternal.track((String) null, 0.0d, (String) null, (Map<String, ?>) null, hashMap);
    }

    /* access modifiers changed from: package-private */
    public int dailyOccurrencesCount() {
        long currentTimeMillis = Clock.getInstance().currentTimeMillis();
        return countOccurrences(currentTimeMillis - 86400000, currentTimeMillis);
    }

    public boolean getContinueOnActivityResumed() {
        return this.continueOnActivityResumed;
    }

    public Action getCurrentAction() {
        return this.currentAction;
    }

    public Definitions getDefinitions() {
        return this.definitions;
    }

    public ActionQueue getDelayedQueue() {
        return this.delayedQueue;
    }

    public boolean getDismissOnPushOpened() {
        return this.dismissOnPushOpened;
    }

    public MessageDisplayController getMessageDisplayController() {
        return this.messageDisplayController;
    }

    public MessageDisplayListener getMessageDisplayListener() {
        return this.messageDisplayListener;
    }

    public Map<String, Number> getMessageImpressionOccurrences(String str) {
        Map<String, Number> map = this.messageImpressionOccurrences.get(str);
        if (map != null) {
            return map;
        }
        Map<String, Number> map2 = (Map) CollectionUtil.uncheckedCast(JsonConverter.fromJson(Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).getString(String.format(Constants.Defaults.MESSAGE_IMPRESSION_OCCURRENCES_KEY, new Object[]{str}), "{}")));
        this.messageImpressionOccurrences.put(str, map2);
        return map2;
    }

    public int getMessageTriggerOccurrences(String str) {
        Number number = this.messageTriggerOccurrences.get(str);
        if (number != null) {
            return number.intValue();
        }
        int i10 = Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).getInt(String.format(Constants.Defaults.MESSAGE_TRIGGER_OCCURRENCES_KEY, new Object[]{str}), 0);
        this.messageTriggerOccurrences.put(str, Integer.valueOf(i10));
        return i10;
    }

    public ActionQueue getQueue() {
        return this.queue;
    }

    public ActionScheduler getScheduler() {
        return this.scheduler;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void muteFutureMessagesOfKind(String str) {
        if (str != null) {
            SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).edit();
            edit.putBoolean(String.format(Constants.Defaults.MESSAGE_MUTED_KEY, new Object[]{str}), true);
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    public void recordChainedActionImpression(String str) {
        trackImpressionEvent(str);
    }

    public void recordHeldBackImpression(String str, String str2) {
        trackHeldBackEvent(str2);
        recordImpression(str);
    }

    public void recordLocalPushImpression(String str) {
        trackImpressionEvent(str);
    }

    public void recordMessageImpression(String str) {
        trackImpressionEvent(str);
        recordImpression(str);
    }

    public void recordMessageTrigger(String str) {
        saveMessageTriggerOccurrences(getMessageTriggerOccurrences(str) + 1, str);
    }

    public void saveMessageImpressionOccurrences(Map<String, Number> map, String str) {
        SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).edit();
        edit.putString(String.format(Constants.Defaults.MESSAGE_IMPRESSION_OCCURRENCES_KEY, new Object[]{str}), JsonConverter.toJson(map));
        this.messageImpressionOccurrences.put(str, map);
        SharedPreferencesUtil.commitChanges(edit);
    }

    public void saveMessageTriggerOccurrences(int i10, String str) {
        SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences(Constants.Defaults.MESSAGING_PREF_NAME, 0).edit();
        edit.putInt(String.format(Constants.Defaults.MESSAGE_TRIGGER_OCCURRENCES_KEY, new Object[]{str}), i10);
        this.messageTriggerOccurrences.put(str, Integer.valueOf(i10));
        SharedPreferencesUtil.commitChanges(edit);
    }

    /* access modifiers changed from: package-private */
    public int sessionOccurrencesCount() {
        int i10 = 0;
        for (Map.Entry<String, Number> value : this.sessionOccurrences.entrySet()) {
            Number number = (Number) value.getValue();
            if (number != null) {
                i10 += number.intValue();
            }
        }
        return i10;
    }

    public void setContinueOnActivityResumed(boolean z10) {
        this.continueOnActivityResumed = z10;
    }

    public void setCurrentAction(Action action) {
        this.currentAction = action;
    }

    public void setDismissOnPushOpened(boolean z10) {
        this.dismissOnPushOpened = z10;
    }

    public void setEnabled(boolean z10) {
        Log.d("[ActionManager] isEnabled: " + z10, new Object[0]);
        this.enabled = z10;
        if (z10) {
            ActionManagerExecutionKt.performActions(getInstance());
        }
    }

    public void setMessageDisplayController(MessageDisplayController messageDisplayController2) {
        this.messageDisplayController = messageDisplayController2;
    }

    public void setMessageDisplayListener(MessageDisplayListener messageDisplayListener2) {
        this.messageDisplayListener = messageDisplayListener2;
    }

    public void setPaused(boolean z10) {
        Log.d("[ActionManager] isPaused: " + z10, new Object[0]);
        this.paused = z10;
        if (!z10) {
            ActionManagerExecutionKt.performActions(getInstance());
        }
    }

    public void setScheduler(ActionScheduler actionScheduler) {
        this.scheduler = actionScheduler;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.leanplum.internal.ActionManager.MessageMatchResult shouldShowMessage(java.lang.String r7, java.util.Map<java.lang.String, java.lang.Object> r8, java.lang.String r9, java.lang.String r10, com.leanplum.ActionContext.ContextualValues r11) {
        /*
            r6 = this;
            com.leanplum.internal.ActionManager$MessageMatchResult r0 = new com.leanplum.internal.ActionManager$MessageMatchResult
            r0.<init>()
            android.content.Context r1 = com.leanplum.Leanplum.getContext()
            java.lang.String r2 = "__leanplum_messaging__"
            r3 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r3] = r7
            java.lang.String r5 = "__leanplum_message_muted_%s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            boolean r1 = r1.getBoolean(r4, r3)
            if (r1 == 0) goto L_0x0022
            return r0
        L_0x0022:
            java.lang.String r1 = "whenTriggers"
            java.lang.Object r1 = r8.get(r1)
            boolean r1 = r6.matchedTriggers(r1, r9, r10, r11)
            r0.matchedTrigger = r1
            java.lang.String r1 = "unlessTriggers"
            java.lang.Object r1 = r8.get(r1)
            boolean r9 = r6.matchedTriggers(r1, r9, r10, r11)
            r0.matchedUnlessTrigger = r9
            boolean r10 = r0.matchedTrigger
            if (r10 != 0) goto L_0x0041
            if (r9 != 0) goto L_0x0041
            return r0
        L_0x0041:
            java.lang.String r9 = "whenLimits"
            java.lang.Object r9 = r8.get(r9)
            r10 = 0
            boolean r11 = r9 instanceof java.util.Map
            if (r11 == 0) goto L_0x0053
            java.lang.Object r9 = com.leanplum.internal.CollectionUtil.uncheckedCast(r9)
            r10 = r9
            java.util.Map r10 = (java.util.Map) r10
        L_0x0053:
            boolean r7 = r6.matchesLimits(r7, r10)
            r0.matchedLimit = r7
            java.lang.String r7 = "startTime"
            java.lang.Object r7 = r8.get(r7)
            java.lang.String r9 = "endTime"
            java.lang.Object r8 = r8.get(r9)
            if (r7 == 0) goto L_0x008e
            if (r8 != 0) goto L_0x006a
            goto L_0x008e
        L_0x006a:
            com.leanplum.internal.Clock r9 = com.leanplum.internal.Clock.getInstance()
            java.util.Date r9 = r9.newDate()
            long r9 = r9.getTime()
            java.lang.Long r7 = (java.lang.Long) r7
            long r4 = r7.longValue()
            int r7 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x008b
            java.lang.Long r8 = (java.lang.Long) r8
            long r7 = r8.longValue()
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x008b
            r3 = r2
        L_0x008b:
            r0.matchedActivePeriod = r3
            goto L_0x0090
        L_0x008e:
            r0.matchedActivePeriod = r2
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.ActionManager.shouldShowMessage(java.lang.String, java.util.Map, java.lang.String, java.lang.String, com.leanplum.ActionContext$ContextualValues):com.leanplum.internal.ActionManager$MessageMatchResult");
    }

    public boolean shouldSuppressMessages() {
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (Map next : VarCache.localCaps()) {
            if ("IN_APP".equals(next.get("channel"))) {
                String str = (String) next.get("type");
                Integer num = (Integer) next.get(FacebookParse.FB_PARAM_FIELD_LIMIT);
                if (num != null) {
                    if ("DAY".equals(str)) {
                        i11 = num.intValue();
                    } else if ("WEEK".equals(str)) {
                        i10 = num.intValue();
                    } else if ("SESSION".equals(str)) {
                        i12 = num.intValue();
                    }
                }
            }
        }
        if ((i10 <= 0 || weeklyOccurrencesCount() < i10) && ((i11 <= 0 || dailyOccurrencesCount() < i11) && (i12 <= 0 || sessionOccurrencesCount() < i12))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int weeklyOccurrencesCount() {
        long currentTimeMillis = Clock.getInstance().currentTimeMillis();
        return countOccurrences(currentTimeMillis - 604800000, currentTimeMillis);
    }

    private int countOccurrences(long j10, long j11, String str) {
        Map map = (Map) CollectionUtil.uncheckedCast(JsonConverter.fromJson(str));
        Number number = (Number) map.get("min");
        Number number2 = (Number) map.get("max");
        int i10 = 0;
        if (!(number == null || number2 == null)) {
            long longValue = number.longValue();
            for (long longValue2 = number2.longValue(); longValue2 >= longValue; longValue2--) {
                Number number3 = (Number) map.get("" + longValue2);
                if (number3 != null) {
                    if (j10 > number3.longValue() || number3.longValue() > j11) {
                        return i10;
                    }
                    i10++;
                }
            }
        }
        return i10;
    }
}
