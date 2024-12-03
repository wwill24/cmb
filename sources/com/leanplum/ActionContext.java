package com.leanplum;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import com.leanplum.actions.internal.ActionDidDismiss;
import com.leanplum.actions.internal.ActionDidExecute;
import com.leanplum.actions.internal.ActionManagerDefinitionKt;
import com.leanplum.actions.internal.ActionManagerTriggeringKt;
import com.leanplum.actions.internal.Priority;
import com.leanplum.callbacks.ForceContentUpdateCallback;
import com.leanplum.internal.ActionManager;
import com.leanplum.internal.BaseActionContext;
import com.leanplum.internal.CollectionUtil;
import com.leanplum.internal.Constants;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.JsonConverter;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.internal.VarCache;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.b;

public class ActionContext extends BaseActionContext implements Comparable<ActionContext> {
    private ActionDidDismiss actionDidDismiss;
    private ActionDidExecute actionDidExecute;
    private final int contentVersion;
    private ContextualValues contextualValues;
    private boolean isChainedMessage;
    private String key;
    private final String name;
    private ActionContext parentContext;
    private boolean preventRealtimeUpdating;

    public static class ContextualValues {
        public Map<String, Object> arguments;
        public Object attributeValue;
        public Map<String, ?> parameters;
        public Object previousAttributeValue;
    }

    public ActionContext(String str, Map<String, Object> map, String str2) {
        this(str, map, str2, (String) null, 1000);
    }

    private static boolean convertToBoolean(String str) {
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) || "on".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private ActionContext createChainedContext(String str, Map<String, Object> map, String str2, String str3) {
        ActionContext actionContext = new ActionContext(str, map, str2);
        actionContext.contextualValues = this.contextualValues;
        actionContext.preventRealtimeUpdating = this.preventRealtimeUpdating;
        actionContext.isRooted = this.isRooted;
        actionContext.key = str3;
        actionContext.parentContext = this;
        return actionContext;
    }

    private Map<String, Object> defaultValues() {
        Map<String, Object> map = (Map) CollectionUtil.uncheckedCast(getDefinition(this.name).get("values"));
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    private String eventWithParentEventNames(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (ActionContext actionContext = this; actionContext.parentContext != null; actionContext = actionContext.parentContext) {
            arrayList.add(actionContext);
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < -1) {
                break;
            }
            if (sb2.length() > 0) {
                sb2.append(' ');
            }
            if (size > -1) {
                str2 = ((ActionContext) arrayList.get(size)).key;
            } else {
                str2 = str;
            }
            if (str2 == null) {
                sb2 = new StringBuilder("");
                break;
            }
            sb2.append(str2.replace(" action", ""));
        }
        return sb2.toString();
    }

    private boolean executeChainedMessage(String str, String str2) {
        Map map;
        Map<String, Object> messages = VarCache.messages();
        if (!(messages == null || (map = (Map) CollectionUtil.uncheckedCast(messages.get(str))) == null)) {
            Map map2 = (Map) CollectionUtil.uncheckedCast(map.get("vars"));
            Object obj = map.get("action");
            if (obj != null) {
                ActionContext createChainedContext = createChainedContext(obj.toString(), map2, str, str2);
                createChainedContext.isChainedMessage = true;
                ActionManagerTriggeringKt.trigger(ActionManager.getInstance(), createChainedContext, Priority.HIGH);
                return true;
            }
        }
        return false;
    }

    public static String filePath(String str) {
        return FileManager.fileValue(str);
    }

    static String getChainedMessageId(Map<String, Object> map) {
        if (map == null || !Constants.Values.CHAIN_MESSAGE_ACTION_NAME.equals(map.get(Constants.Values.ACTION_ARG))) {
            return null;
        }
        return (String) map.get(Constants.Values.CHAIN_MESSAGE_ARG);
    }

    private Map<String, Object> getChildArgs(String str) {
        Object objectNamed = objectNamed(str);
        if (!(objectNamed instanceof Map)) {
            return null;
        }
        Map map = (Map) CollectionUtil.uncheckedCast(objectNamed);
        return (Map) CollectionUtil.uncheckedCast(VarCache.mergeHelper((Map) CollectionUtil.uncheckedCast(getDefinition((String) map.get(Constants.Values.ACTION_ARG)).get("values")), map));
    }

    private String getDefaultValue(String str) {
        String[] split = str.split("\\.");
        Map<String, Object> defaultValues = defaultValues();
        for (int i10 = 0; i10 < split.length && defaultValues != null; i10++) {
            if (i10 == split.length - 1) {
                Object obj = defaultValues.get(split[i10]);
                if (obj == null) {
                    return null;
                }
                return obj.toString();
            }
            defaultValues = (Map) CollectionUtil.uncheckedCast(defaultValues.get(split[i10]));
        }
        return null;
    }

    private Map<String, Object> getDefinition(String str) {
        Map<String, Object> actionDefinitionMap = ActionManagerDefinitionKt.getActionDefinitionMap(ActionManager.getInstance(), str);
        if (actionDefinitionMap == null) {
            return new HashMap();
        }
        return actionDefinitionMap;
    }

    private Map<String, String> kinds() {
        Map<String, String> map = (Map) CollectionUtil.uncheckedCast(getDefinition(this.name).get(Constants.Params.KINDS));
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$performChainedAction$0(String str, String str2, boolean z10, boolean z11) {
        if (z11) {
            executeChainedMessage(str, str2);
        }
        ActionManager.getInstance().setPaused(z10);
    }

    public static <T> Map<String, T> mapFromJson(b bVar) throws JSONException {
        return JsonConverter.mapFromJson(bVar);
    }

    public static b mapToJsonObject(Map<String, ?> map) throws JSONException {
        return JsonConverter.mapToJsonObject(map);
    }

    private void performChainedAction(String str, Map<String, Object> map) {
        String chainedMessageId = getChainedMessageId(map);
        if (chainedMessageId == null) {
            Object obj = map.get(Constants.Values.ACTION_ARG);
            if (obj != null) {
                ActionManagerTriggeringKt.trigger(ActionManager.getInstance(), createChainedContext(obj.toString(), map, this.messageId, str), Priority.HIGH);
            }
        } else if (shouldFetchChainedMessage(map)) {
            boolean isPaused = ActionManager.getInstance().isPaused();
            ActionManager.getInstance().setPaused(true);
            Leanplum.forceContentUpdate((ForceContentUpdateCallback) new a(this, chainedMessageId, str, isPaused));
        } else {
            executeChainedMessage(chainedMessageId, str);
        }
    }

    public static boolean shouldFetchChainedMessage(@NonNull ActionContext actionContext, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return shouldFetchChainedMessage(actionContext.getChildArgs(str));
    }

    private void updateArgs(Map<String, Object> map, String str, Map<String, Object> map2) {
        Object obj;
        String str2;
        Map<String, String> kinds = kinds();
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            Object value = next.getValue();
            Map map3 = null;
            if (map2 != null) {
                obj = map2.get(str3);
            } else {
                obj = null;
            }
            String str4 = kinds.get(str + str3);
            if ((str4 == null || !str4.equals("action")) && (value instanceof Map)) {
                Map map4 = (Map) value;
                if (!map4.containsKey(Constants.Values.ACTION_ARG)) {
                    if (obj instanceof Map) {
                        map3 = (Map) obj;
                    }
                    updateArgs(map4, str + str3 + ".", map3);
                }
            }
            if ((str4 != null && str4.equals("file")) || str3.contains("__file__")) {
                String obj2 = value.toString();
                if (obj != null) {
                    str2 = obj.toString();
                } else {
                    str2 = null;
                }
                FileManager.maybeDownloadFile(false, obj2, str2, (String) null, (Runnable) null);
            } else if (str4 == null || str4.equals("action")) {
                Object objectNamed = objectNamed(str + str3);
                if (objectNamed instanceof Map) {
                    Map map5 = (Map) objectNamed;
                    new ActionContext((String) map5.get(Constants.Values.ACTION_ARG), map5, this.messageId).update();
                }
            }
        }
    }

    public void actionDismissed() {
        ActionDidDismiss actionDidDismiss2 = this.actionDidDismiss;
        if (actionDidDismiss2 != null) {
            actionDidDismiss2.onDismiss();
        }
    }

    public String actionName() {
        return this.name;
    }

    public boolean booleanNamed(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("booleanNamed - Invalid name parameter provided.", new Object[0]);
            return false;
        }
        Object objectNamed = objectNamed(str);
        if (objectNamed == null) {
            return false;
        }
        try {
            if (objectNamed instanceof Boolean) {
                return ((Boolean) objectNamed).booleanValue();
            }
            return convertToBoolean(objectNamed.toString());
        } catch (Throwable th2) {
            Log.exception(th2);
            return false;
        }
    }

    public String fillTemplate(String str) {
        if (this.contextualValues == null || str == null || !str.contains("##")) {
            return str;
        }
        Map<String, ?> map = this.contextualValues.parameters;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                str = str.replace("##Parameter " + ((String) next.getKey()) + "##", "" + next.getValue());
            }
        }
        Object obj = this.contextualValues.previousAttributeValue;
        if (obj != null) {
            str = str.replace("##Previous Value##", obj.toString());
        }
        Object obj2 = this.contextualValues.attributeValue;
        if (obj2 != null) {
            return str.replace("##Value##", obj2.toString());
        }
        return str;
    }

    public ContextualValues getContextualValues() {
        return this.contextualValues;
    }

    public ActionContext getParentContext() {
        return this.parentContext;
    }

    public boolean isChainedMessage() {
        return this.isChainedMessage;
    }

    public void muteFutureMessagesOfSameKind() {
        try {
            ActionManager.getInstance().muteFutureMessagesOfKind(this.messageId);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public Number numberNamed(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("numberNamed - Invalid name parameter provided.", new Object[0]);
            return null;
        }
        Object objectNamed = objectNamed(str);
        if (objectNamed != null) {
            try {
                if (!TextUtils.isEmpty(objectNamed.toString())) {
                    if (objectNamed instanceof Number) {
                        return (Number) objectNamed;
                    }
                    return Double.valueOf(objectNamed.toString());
                }
            } catch (Throwable th2) {
                Log.exception(th2);
                return Double.valueOf(0.0d);
            }
        }
        return Double.valueOf(0.0d);
    }

    public <T> T objectNamed(String str) {
        Map map;
        if (TextUtils.isEmpty(str)) {
            Log.e("objectNamed - Invalid name parameter provided.", new Object[0]);
            return null;
        }
        try {
            if (!this.preventRealtimeUpdating && VarCache.contentVersion() > this.contentVersion) {
                ActionContext actionContext = this.parentContext;
                if (actionContext != null) {
                    this.args = actionContext.getChildArgs(this.key);
                } else if (!(this.messageId == null || (map = (Map) CollectionUtil.uncheckedCast(VarCache.messages().get(this.messageId))) == null)) {
                    this.args = (Map) CollectionUtil.uncheckedCast(map.get("vars"));
                }
            }
            return VarCache.getMergedValueFromComponentArray(VarCache.getNameComponents(str), this.args);
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    public void preventRealtimeUpdating() {
        this.preventRealtimeUpdating = true;
    }

    public void runActionNamed(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("runActionNamed - Invalid name parameter provided.", new Object[0]);
            return;
        }
        Map<String, Object> childArgs = getChildArgs(str);
        if (this.actionDidExecute != null) {
            ActionContext actionContext = new ActionContext(str, childArgs, this.messageId);
            actionContext.parentContext = this;
            this.actionDidExecute.onActionExecuted(actionContext);
        }
        if (childArgs != null) {
            performChainedAction(str, childArgs);
        }
    }

    public void runTrackedActionNamed(String str) {
        try {
            if (!Constants.isNoop() && this.messageId != null && this.isRooted) {
                if (TextUtils.isEmpty(str)) {
                    Log.e("runTrackedActionNamed - Invalid name parameter provided.", new Object[0]);
                    return;
                }
                trackMessageEvent(str, 0.0d, (String) null, (Map<String, Object>) null);
            }
            runActionNamed(str);
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void setActionDidDismiss(ActionDidDismiss actionDidDismiss2) {
        this.actionDidDismiss = actionDidDismiss2;
    }

    public void setActionDidExecute(ActionDidExecute actionDidExecute2) {
        this.actionDidExecute = actionDidExecute2;
    }

    public void setContextualValues(ContextualValues contextualValues2) {
        this.contextualValues = contextualValues2;
    }

    public void setParentContext(ActionContext actionContext) {
        this.parentContext = actionContext;
    }

    public InputStream streamNamed(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                Log.e("streamNamed - Invalid name parameter provided.", new Object[0]);
                return null;
            }
            String stringNamed = stringNamed(str);
            String defaultValue = getDefaultValue(str);
            if (stringNamed == null || stringNamed.length() == 0) {
                if (defaultValue != null) {
                    if (defaultValue.length() == 0) {
                    }
                }
                return null;
            }
            InputStream stream = FileManager.stream(false, (Boolean) null, (Boolean) null, FileManager.fileValue(stringNamed, defaultValue, (Boolean) null), defaultValue, (byte[]) null);
            if (stream == null) {
                Log.e("Could not open stream named " + str, new Object[0]);
            }
            return stream;
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    public String stringNamed(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("stringNamed - Invalid name parameter provided.", new Object[0]);
            return null;
        }
        Object objectNamed = objectNamed(str);
        if (objectNamed == null) {
            return null;
        }
        try {
            return fillTemplate(objectNamed.toString());
        } catch (Throwable th2) {
            Log.exception(th2);
            return objectNamed.toString();
        }
    }

    @NonNull
    public String toString() {
        String str;
        if (this.parentContext != null) {
            str = "(parent=" + this.parentContext + ")";
        } else {
            str = "";
        }
        return this.name + CertificateUtil.DELIMITER + this.messageId + str;
    }

    public void track(String str, double d10, Map<String, Object> map) {
        try {
            if (!Constants.isNoop() && this.messageId != null) {
                if (TextUtils.isEmpty(str)) {
                    Log.e("track - Invalid event parameter provided.", new Object[0]);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.Params.MESSAGE_ID, this.messageId);
                LeanplumInternal.track(str, d10, (String) null, map, hashMap);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void trackMessageEvent(String str, double d10, String str2, Map<String, Object> map) {
        try {
            if (!Constants.isNoop() && this.messageId != null) {
                if (TextUtils.isEmpty(str)) {
                    Log.e("trackMessageEvent - Invalid event parameter provided.", new Object[0]);
                    return;
                }
                String eventWithParentEventNames = eventWithParentEventNames(str);
                if (TextUtils.isEmpty(eventWithParentEventNames)) {
                    Log.e("trackMessageEvent - Failed to generate parent action names.", new Object[0]);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.Params.MESSAGE_ID, this.messageId);
                LeanplumInternal.track(eventWithParentEventNames, d10, str2, map, hashMap);
            }
        } catch (Throwable th2) {
            Log.exception(th2);
        }
    }

    public void update() {
        updateArgs(this.args, "", defaultValues());
    }

    public ActionContext(String str, Map<String, Object> map, String str2, String str3, int i10) {
        super(str2, str3);
        this.preventRealtimeUpdating = false;
        this.name = str;
        this.args = map;
        this.contentVersion = VarCache.contentVersion();
        this.priority = i10;
    }

    public int compareTo(@NonNull ActionContext actionContext) {
        return this.priority - actionContext.getPriority();
    }

    static boolean shouldFetchChainedMessage(Map<String, Object> map) {
        String chainedMessageId;
        if (map == null || (chainedMessageId = getChainedMessageId(map)) == null) {
            return false;
        }
        if (VarCache.messages() == null || !VarCache.messages().containsKey(chainedMessageId)) {
            return true;
        }
        return false;
    }
}
