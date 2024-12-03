package com.leanplum.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.leanplum.ActionContext;
import com.leanplum.CacheUpdateBlock;
import com.leanplum.Leanplum;
import com.leanplum.LocationManager;
import com.leanplum.SecuredVars;
import com.leanplum.Var;
import com.leanplum.actions.internal.ActionManagerDefinitionKt;
import com.leanplum.internal.Constants;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.Request;
import com.leanplum.utils.SharedPreferencesUtil;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.Field;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class VarCache {
    private static final String LEANPLUM = "__leanplum__";
    private static final Pattern NAME_COMPONENT_PATTERN = Pattern.compile(NAME_COMPONENT_REGEX);
    private static final String NAME_COMPONENT_REGEX = "(?:[^\\.\\[.(\\\\]+|\\\\.)+";
    private static int contentVersion;
    private static final Map<String, String> defaultKinds = new HashMap();
    private static Map<String, Object> devModeFileAttributesFromServer;
    private static Map<String, Object> devModeValuesFromServer;
    private static Map<String, Object> diffs = new HashMap();
    private static final Map<String, Object> fileAttributes = new HashMap();
    private static final Map<String, StreamProvider> fileStreams = new HashMap();
    private static boolean hasReceivedDiffs = false;
    private static volatile List<Map<String, Object>> localCaps = new ArrayList();
    private static Object merged;
    private static Map<String, Object> messageDiffs = new HashMap();
    private static Map<String, Object> messages = new HashMap();
    private static Map<String, Object> regions = new HashMap();
    private static boolean silent;
    private static CacheUpdateBlock updateBlock;
    private static Map<String, Object> userAttributes;
    public static final Map<String, Object> valuesFromClient = new HashMap();
    private static Map<String, Object> variantDebugInfo = new HashMap();
    private static volatile List<Map<String, Object>> variants = new ArrayList();
    private static final Map<String, Var<?>> vars = new ConcurrentHashMap();
    private static volatile String varsJson;
    private static volatile String varsSignature;

    @FunctionalInterface
    public interface StreamProvider {
        InputStream openStream();
    }

    public static void applyVariableDiffs(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, List<Map<String, Object>> list, List<Map<String, Object>> list2, Map<String, Object> map4, String str, String str2) {
        Map<String, Object> map5 = map3;
        if (map != null) {
            diffs = map;
            computeMergedDictionary();
            for (String str3 : new HashMap(vars).keySet()) {
                Var var = vars.get(str3);
                if (var != null) {
                    var.update();
                }
            }
            fileVariableFinish();
        }
        if (map2 != null) {
            messageDiffs = map2;
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map2.entrySet()) {
                Map map6 = (Map) CollectionUtil.uncheckedCast(next.getValue());
                HashMap hashMap2 = new HashMap(map6);
                Map map7 = (Map) Util.multiIndex(ActionManagerDefinitionKt.getActionDefinitionMaps(ActionManager.getInstance()), hashMap2.get("action"), "values");
                hashMap.put((String) next.getKey(), hashMap2);
                hashMap2.put("vars", (Map) CollectionUtil.uncheckedCast(mergeHelper(map7, (Map) CollectionUtil.uncheckedCast(map6.get("vars")))));
            }
            messages = hashMap;
            for (Map.Entry key : hashMap.entrySet()) {
                String str4 = (String) key.getKey();
                Map map8 = (Map) CollectionUtil.uncheckedCast(messages.get(str4));
                if (!(map8 == null || map8.get("action") == null)) {
                    new ActionContext(map8.get("action").toString(), (Map) CollectionUtil.uncheckedCast(map8.get("vars")), str4).update();
                }
            }
        }
        if (map5 != null) {
            regions = map5;
        }
        if (!(map2 == null && map5 == null)) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ActionManager.getForegroundandBackgroundRegionNames(hashSet, hashSet2);
            LocationManager locationManager = ActionManager.getLocationManager();
            if (locationManager != null) {
                locationManager.setRegionsData(map3, hashSet, hashSet2);
            }
        }
        if (list != null) {
            variants = list;
        }
        if (list2 != null) {
            localCaps = list2;
        }
        if (map4 != null) {
            setVariantDebugInfo(map4);
        }
        if (str != null) {
            varsJson = str;
            varsSignature = str2;
        }
        contentVersion++;
        if (!silent) {
            saveDiffs();
            triggerHasReceivedDiffs();
        }
    }

    public static void clearUserContent() {
        vars.clear();
        variants = new ArrayList();
        localCaps = new ArrayList();
        variantDebugInfo.clear();
        varsJson = null;
        varsSignature = null;
        diffs.clear();
        messageDiffs.clear();
        messages = null;
        userAttributes = null;
        merged = null;
        devModeValuesFromServer = null;
        devModeFileAttributesFromServer = null;
        ActionManagerDefinitionKt.setDevModeActionDefinitionsFromServer(ActionManager.getInstance(), (Map<String, ? extends Object>) null);
    }

    private static void computeMergedDictionary() {
        Map<String, Object> map = valuesFromClient;
        synchronized (map) {
            merged = mergeHelper(map, diffs);
        }
    }

    public static int contentVersion() {
        return contentVersion;
    }

    private static void fileVariableFinish() {
        for (String str : new HashMap(vars).keySet()) {
            Var var = vars.get(str);
            if (var != null) {
                String str2 = var.stringValue;
                if (var.isResource && "file".equals(var.kind()) && str2 != null && !str2.equals(var.defaultValue())) {
                    Map map = (Map) CollectionUtil.uncheckedCast(fileAttributes.get(str2));
                    StreamProvider streamProvider = fileStreams.get(str2);
                    if (!(map == null || streamProvider == null)) {
                        var.setOverrideResId(getResIdFromPath(var.stringValue()));
                    }
                }
            }
        }
    }

    public static Map<String, Object> getDiffs() {
        return diffs;
    }

    public static <T> T getMergedValueFromComponentArray(Object[] objArr, T t10) {
        for (Object traverse : objArr) {
            t10 = traverse(t10, traverse, false);
        }
        return t10;
    }

    public static Map<String, Object> getMessageDiffs() {
        return messageDiffs;
    }

    public static String[] getNameComponents(String str) {
        Matcher matcher = NAME_COMPONENT_PATTERN.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            arrayList.add(str.substring(matcher.start(), matcher.end()));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    static int getResIdFromPath(String str) {
        try {
            String replace = str.replace("res/", "");
            String substring = replace.substring(0, replace.lastIndexOf(46));
            String substring2 = substring.substring(substring.lastIndexOf(47) + 1);
            String replace2 = substring.substring(0, substring.lastIndexOf(47)).replace('/', '.');
            Context context = Leanplum.getContext();
            return context.getResources().getIdentifier(substring2, replace2, context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static SecuredVars getSecuredVars() {
        if (TextUtils.isEmpty(varsJson) || TextUtils.isEmpty(varsSignature)) {
            return null;
        }
        return new SecuredVars(varsJson, varsSignature);
    }

    public static <T> Var<T> getVariable(String str) {
        return vars.get(str);
    }

    public static Map<String, Object> getVariantDebugInfo() {
        return variantDebugInfo;
    }

    public static boolean hasReceivedDiffs() {
        return hasReceivedDiffs;
    }

    private static boolean isStreamAvailable(StreamProvider streamProvider) {
        if (streamProvider == null) {
            return false;
        }
        try {
            InputStream openStream = streamProvider.openStream();
            if (openStream != null) {
                openStream.close();
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static <T> String kindFromValue(T t10) {
        if ((t10 instanceof Integer) || (t10 instanceof Long) || (t10 instanceof Short) || (t10 instanceof Character) || (t10 instanceof Byte) || (t10 instanceof BigInteger)) {
            return Constants.Kinds.INT;
        }
        if ((t10 instanceof Float) || (t10 instanceof Double) || (t10 instanceof BigDecimal)) {
            return Constants.Kinds.FLOAT;
        }
        if (t10 instanceof String) {
            return "string";
        }
        if ((t10 instanceof List) || (t10 instanceof Array)) {
            return "list";
        }
        if (t10 instanceof Map) {
            return "group";
        }
        if (t10 instanceof Boolean) {
            return Constants.Kinds.BOOLEAN;
        }
        return null;
    }

    public static void loadDiffs() {
        if (!Constants.isNoop()) {
            SharedPreferences sharedPreferences = Leanplum.getContext().getSharedPreferences("__leanplum__", 0);
            if (APIConfig.getInstance().token() == null) {
                applyVariableDiffs(new HashMap(), new HashMap(), new HashMap(), new ArrayList(), new ArrayList(), new HashMap(), "", "");
                return;
            }
            try {
                AESCrypt aESCrypt = new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token());
                String decodePreference = aESCrypt.decodePreference(sharedPreferences, Constants.Defaults.VARIABLES_KEY, "{}");
                String decodePreference2 = aESCrypt.decodePreference(sharedPreferences, Constants.Defaults.MESSAGES_KEY, "{}");
                String decodePreference3 = aESCrypt.decodePreference(sharedPreferences, "regions", "{}");
                String decodePreference4 = aESCrypt.decodePreference(sharedPreferences, Constants.Keys.VARIANTS, Field.TOKEN_INDEXED);
                String decodePreference5 = aESCrypt.decodePreference(sharedPreferences, Constants.Keys.LOCAL_CAPS, Field.TOKEN_INDEXED);
                String decodePreference6 = aESCrypt.decodePreference(sharedPreferences, Constants.Keys.VARIANT_DEBUG_INFO, "{}");
                applyVariableDiffs(JsonConverter.fromJson(decodePreference), JsonConverter.fromJson(decodePreference2), JsonConverter.fromJson(decodePreference3), JsonConverter.listFromJson(new a(decodePreference4)), JsonConverter.listFromJson(new a(decodePreference5)), JsonConverter.fromJson(decodePreference6), aESCrypt.decodePreference(sharedPreferences, Constants.Defaults.VARIABLES_JSON_KEY, "{}"), aESCrypt.decodePreference(sharedPreferences, Constants.Defaults.VARIABLES_SIGN_KEY, (String) null));
                String decodePreference7 = aESCrypt.decodePreference(sharedPreferences, Constants.Params.DEVICE_ID, (String) null);
                if (decodePreference7 != null) {
                    APIConfig.getInstance().setDeviceId(decodePreference7);
                }
                String decodePreference8 = aESCrypt.decodePreference(sharedPreferences, Constants.Params.USER_ID, (String) null);
                if (decodePreference8 != null) {
                    APIConfig.getInstance().setUserId(decodePreference8);
                }
                if (Boolean.parseBoolean(aESCrypt.decodePreference(sharedPreferences, Constants.Keys.LOGGING_ENABLED, "false"))) {
                    Constants.loggingEnabled = true;
                }
            } catch (Exception e10) {
                Log.e("Could not load variable diffs.\n" + Log.getStackTraceString(e10), new Object[0]);
            }
            userAttributes();
        }
    }

    public static List<Map<String, Object>> localCaps() {
        return localCaps;
    }

    static void maybeUploadNewFiles() {
        Object obj;
        if (!Constants.isNoop() && devModeFileAttributesFromServer != null && Leanplum.hasStartedAndRegisteredAsDeveloper() && Constants.enableFileUploadingInDevelopmentMode) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i10 = 0;
            for (Map.Entry next : fileAttributes.entrySet()) {
                String str = (String) next.getKey();
                Map map = (Map) CollectionUtil.uncheckedCast(devModeFileAttributesFromServer.get(str));
                Map map2 = (Map) CollectionUtil.uncheckedCast(((Map) CollectionUtil.uncheckedCast(next.getValue())).get(""));
                InputStream inputStream = null;
                if (map != null) {
                    obj = map.get("");
                } else {
                    obj = null;
                }
                Map map3 = (Map) CollectionUtil.uncheckedCast(obj);
                if (FileManager.isNewerLocally(map2, map3)) {
                    Log.d("Will upload file " + str + ". Local attributes: " + map2 + "; server attributes: " + map3, new Object[0]);
                    String str2 = (String) map2.get("hash");
                    if (str2 == null) {
                        str2 = "";
                    }
                    String fileRelativeToAppBundle = FileManager.fileRelativeToAppBundle(str);
                    if ((i10 > 26214400 && arrayList.size() > 0) || arrayList.size() >= 16) {
                        FileTransferManager.getInstance().sendFilesNow(arrayList2, arrayList, arrayList3);
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        i10 = 0;
                    }
                    i10 += ((Integer) map2.get("size")).intValue();
                    arrayList.add(fileRelativeToAppBundle);
                    b bVar = new b();
                    try {
                        bVar.put("hash", (Object) str2);
                        bVar.put("size", (Object) map2.get("size") + "");
                        bVar.put(Constants.Keys.FILENAME, (Object) str);
                        arrayList2.add(bVar);
                    } catch (JSONException e10) {
                        Log.e("Unable to upload files.\n" + Log.getStackTraceString(e10), new Object[0]);
                        arrayList2.add(new b());
                    }
                    StreamProvider streamProvider = fileStreams.get(str);
                    if (streamProvider != null) {
                        inputStream = streamProvider.openStream();
                    }
                    arrayList3.add(inputStream);
                }
            }
            if (arrayList.size() > 0) {
                FileTransferManager.getInstance().sendFilesNow(arrayList2, arrayList, arrayList3);
            }
        }
    }

    public static Object mergeHelper(Object obj, Object obj2) {
        Iterable iterable;
        Iterable<Object> iterable2;
        Map map;
        Map map2;
        Object obj3;
        Object obj4;
        if (obj2 == null) {
            return obj;
        }
        if ((obj2 instanceof Number) || (obj2 instanceof Boolean) || (obj2 instanceof String) || (obj2 instanceof Character) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String) || (obj instanceof Character)) {
            return obj2;
        }
        boolean z10 = obj2 instanceof Map;
        if (z10) {
            iterable = ((Map) obj2).keySet();
        } else {
            iterable = (Iterable) obj2;
        }
        boolean z11 = obj instanceof Map;
        if (z11) {
            iterable2 = ((Map) obj).keySet();
        } else {
            iterable2 = (Iterable) obj;
        }
        if (z10) {
            map = (Map) obj2;
        } else {
            map = null;
        }
        if (z11) {
            map2 = (Map) obj;
        } else {
            map2 = null;
        }
        boolean z12 = false;
        if (obj == null && z10 && ((Map) obj2).size() > 0) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z12 = true;
                    break;
                }
                Object next = it.next();
                if (next instanceof String) {
                    String str = (String) next;
                    if (str.length() < 3 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']') {
                        break;
                    }
                    String substring = str.substring(1, str.length() - 1);
                    if (!("" + Integer.getInteger(substring)).equals(substring)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if ((obj instanceof List) || z12) {
            ArrayList arrayList = new ArrayList();
            for (Object add : iterable2) {
                arrayList.add(add);
            }
            if (map != null) {
                for (Object next2 : iterable) {
                    if (next2 instanceof String) {
                        String str2 = (String) next2;
                        if (str2.length() > 2 && str2.startsWith("[") && str2.endsWith("]")) {
                            int parseInt = Integer.parseInt(str2.substring(1, str2.length() - 1));
                            Object obj5 = map.get(str2);
                            while (parseInt >= arrayList.size() && arrayList.size() < 32767) {
                                arrayList.add((Object) null);
                            }
                            arrayList.set(parseInt, mergeHelper(arrayList.get(parseInt), obj5));
                        }
                    }
                }
            }
            return arrayList;
        } else if (!z11 && !z10) {
            return null;
        } else {
            HashMap hashMap = new HashMap();
            if (iterable2 != null) {
                for (Object next3 : iterable2) {
                    if (!(map == null || map2 == null)) {
                        Object obj6 = map.get(next3);
                        Object obj7 = map2.get(next3);
                        if (obj6 == null && obj7 != null) {
                            hashMap.put(next3, obj7);
                        }
                    }
                }
            }
            for (Object next4 : iterable) {
                if (map != null) {
                    obj3 = map.get(next4);
                } else {
                    obj3 = null;
                }
                if (map2 != null) {
                    obj4 = map2.get(next4);
                } else {
                    obj4 = null;
                }
                hashMap.put(next4, mergeHelper(obj4, obj3));
            }
            return hashMap;
        }
    }

    public static Map<String, Object> messages() {
        return messages;
    }

    public static void onUpdate(CacheUpdateBlock cacheUpdateBlock) {
        updateBlock = cacheUpdateBlock;
    }

    public static Map<String, Object> regions() {
        return regions;
    }

    public static void registerFile(String str, StreamProvider streamProvider, String str2, int i10) {
        if (isStreamAvailable(streamProvider) && Constants.isDevelopmentModeEnabled && !Constants.isNoop()) {
            HashMap hashMap = new HashMap();
            hashMap.put("hash", str2);
            hashMap.put("size", Integer.valueOf(i10));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", hashMap);
            fileStreams.put(str, streamProvider);
            fileAttributes.put(str, hashMap2);
            maybeUploadNewFiles();
        }
    }

    public static void registerVariable(Var<?> var) {
        vars.put(var.name(), var);
        Map<String, Object> map = valuesFromClient;
        synchronized (map) {
            updateValues(var.name(), var.nameComponents(), var.defaultValue(), var.kind(), map, defaultKinds);
        }
    }

    public static void reset() {
        vars.clear();
        variantDebugInfo.clear();
        fileAttributes.clear();
        fileStreams.clear();
        valuesFromClient.clear();
        defaultKinds.clear();
        ActionManager.getInstance().getDefinitions().getActionDefinitions().clear();
        diffs.clear();
        messageDiffs.clear();
        regions.clear();
        devModeValuesFromServer = null;
        devModeFileAttributesFromServer = null;
        ActionManagerDefinitionKt.setDevModeActionDefinitionsFromServer(ActionManager.getInstance(), (Map<String, ? extends Object>) null);
        variants = new ArrayList();
        localCaps = new ArrayList();
        updateBlock = null;
        hasReceivedDiffs = false;
        messages = null;
        merged = null;
        silent = false;
        contentVersion = 0;
        userAttributes = null;
        varsJson = null;
        varsSignature = null;
    }

    public static void saveDiffs() {
        if (!Constants.isNoop() && APIConfig.getInstance().token() != null) {
            SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences("__leanplum__", 0).edit();
            AESCrypt aESCrypt = new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token());
            edit.putString(Constants.Defaults.VARIABLES_KEY, aESCrypt.encrypt(JsonConverter.toJson(diffs)));
            edit.putString(Constants.Defaults.MESSAGES_KEY, aESCrypt.encrypt(JsonConverter.toJson(messages)));
            edit.putString("regions", aESCrypt.encrypt(JsonConverter.toJson(regions)));
            try {
                if (variants != null && !variants.isEmpty()) {
                    edit.putString(Constants.Keys.VARIANTS, aESCrypt.encrypt(JsonConverter.listToJsonArray(variants).toString()));
                }
            } catch (JSONException e10) {
                Log.e("Error converting " + variants + " to JSON.\n" + Log.getStackTraceString(e10), new Object[0]);
            }
            try {
                if (localCaps != null) {
                    edit.putString(Constants.Keys.LOCAL_CAPS, aESCrypt.encrypt(JsonConverter.listToJsonArray(localCaps).toString()));
                }
            } catch (JSONException e11) {
                Log.e("Error converting " + localCaps + " to JSON.\n" + Log.getStackTraceString(e11), new Object[0]);
            }
            Map<String, Object> map = variantDebugInfo;
            if (map != null) {
                edit.putString(Constants.Keys.VARIANT_DEBUG_INFO, aESCrypt.encrypt(JsonConverter.toJson(map)));
            }
            edit.putString(Constants.Defaults.VARIABLES_JSON_KEY, aESCrypt.encrypt(varsJson));
            edit.putString(Constants.Defaults.VARIABLES_SIGN_KEY, aESCrypt.encrypt(varsSignature));
            edit.putString(Constants.Params.DEVICE_ID, aESCrypt.encrypt(APIConfig.getInstance().deviceId()));
            edit.putString(Constants.Params.USER_ID, aESCrypt.encrypt(APIConfig.getInstance().userId()));
            edit.putString(Constants.Keys.LOGGING_ENABLED, aESCrypt.encrypt(String.valueOf(Constants.loggingEnabled)));
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    public static void saveUserAttributes() {
        if (!Constants.isNoop() && APIConfig.getInstance().appId() != null && userAttributes != null) {
            SharedPreferences.Editor edit = Leanplum.getContext().getSharedPreferences("__leanplum__", 0).edit();
            edit.putString(Constants.Defaults.ATTRIBUTES_KEY, new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token()).encrypt(JsonConverter.toJson(userAttributes)));
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    static boolean sendActionsIfChanged() {
        return sendContentIfChanged(false, true);
    }

    private static boolean sendContentIfChanged(boolean z10, boolean z11) {
        boolean z12;
        Map<String, Object> map;
        boolean z13 = true;
        if (!z10 || (map = devModeValuesFromServer) == null || valuesFromClient.equals(map)) {
            z12 = false;
        } else {
            z12 = true;
        }
        Map<String, Object> actionDefinitionMaps = ActionManagerDefinitionKt.getActionDefinitionMaps(ActionManager.getInstance());
        boolean areLocalAndServerDefinitionsEqual = ActionManagerDefinitionKt.areLocalAndServerDefinitionsEqual(ActionManager.getInstance());
        if (!z11 || areLocalAndServerDefinitionsEqual) {
            z13 = z12;
        }
        if (z13) {
            HashMap hashMap = new HashMap();
            if (z10) {
                hashMap.put("vars", JsonConverter.toJson(valuesFromClient));
                hashMap.put(Constants.Params.KINDS, JsonConverter.toJson(defaultKinds));
            }
            if (z11) {
                hashMap.put(Constants.Params.ACTION_DEFINITIONS, JsonConverter.toJson(actionDefinitionMaps));
            }
            hashMap.put(Constants.Params.FILE_ATTRIBUTES, JsonConverter.toJson(fileAttributes));
            RequestSender.getInstance().send(RequestBuilder.withSetVarsAction().andParams(hashMap).andType(Request.RequestType.IMMEDIATE).create());
        }
        return z13;
    }

    static boolean sendVariablesIfChanged() {
        return sendContentIfChanged(true, false);
    }

    public static void setDevModeValuesFromServer(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3) {
        devModeValuesFromServer = map;
        ActionManagerDefinitionKt.setDevModeActionDefinitionsFromServer(ActionManager.getInstance(), map3);
        devModeFileAttributesFromServer = map2;
    }

    public static void setSilent(boolean z10) {
        silent = z10;
    }

    public static void setVariantDebugInfo(Map<String, Object> map) {
        if (map != null) {
            variantDebugInfo = map;
        } else {
            variantDebugInfo = new HashMap();
        }
    }

    public static boolean silent() {
        return silent;
    }

    private static Object traverse(Object obj, Object obj2, boolean z10) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            Map map = (Map) CollectionUtil.uncheckedCast(obj);
            Object obj3 = map.get(obj2);
            if (!z10 || obj3 != null || !(obj2 instanceof String)) {
                return obj3;
            }
            HashMap hashMap = new HashMap();
            map.put(obj2, hashMap);
            return hashMap;
        } else if (!(obj instanceof List)) {
            return null;
        } else {
            List list = (List) CollectionUtil.uncheckedCast(obj);
            Integer num = (Integer) obj2;
            Object obj4 = list.get(num.intValue());
            if (!z10 || obj4 != null) {
                return obj4;
            }
            HashMap hashMap2 = new HashMap();
            list.set(num.intValue(), hashMap2);
            return hashMap2;
        }
    }

    private static void triggerHasReceivedDiffs() {
        hasReceivedDiffs = true;
        CacheUpdateBlock cacheUpdateBlock = updateBlock;
        if (cacheUpdateBlock != null) {
            cacheUpdateBlock.updateCache();
        }
    }

    public static void updateValues(String str, String[] strArr, Object obj, String str2, Map<String, Object> map, Map<String, String> map2) {
        if (strArr != null && strArr.length > 0) {
            int i10 = 0;
            Object obj2 = map;
            while (i10 < strArr.length - 1) {
                i10++;
                obj2 = traverse(obj2, strArr[i10], true);
            }
            if (obj2 instanceof Map) {
                ((Map) CollectionUtil.uncheckedCast(obj2)).put(strArr[strArr.length - 1], obj);
            }
        }
        if (map2 != null) {
            map2.put(str, str2);
        }
    }

    static Map<String, Object> userAttributes() {
        if (userAttributes == null) {
            try {
                userAttributes = JsonConverter.fromJson(new AESCrypt(APIConfig.getInstance().appId(), APIConfig.getInstance().token()).decodePreference(Leanplum.getContext().getSharedPreferences("__leanplum__", 0), Constants.Defaults.ATTRIBUTES_KEY, "{}"));
            } catch (Exception e10) {
                Log.e("Could not load user attributes.\n" + Log.getStackTraceString(e10), new Object[0]);
                userAttributes = new HashMap();
            }
        }
        return userAttributes;
    }

    public static List<Map<String, Object>> variants() {
        return variants;
    }

    public static <T> T getMergedValueFromComponentArray(Object[] objArr) {
        Object obj = merged;
        if (obj == null) {
            obj = valuesFromClient;
        }
        return getMergedValueFromComponentArray(objArr, obj);
    }

    public static void registerFile(String str, String str2, StreamProvider streamProvider) {
        if (isStreamAvailable(streamProvider) && Constants.isDevelopmentModeEnabled && !Constants.isNoop()) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (Util.isSimulator()) {
                FileManager.HashResults fileMD5HashCreateWithPath = FileManager.fileMD5HashCreateWithPath(streamProvider.openStream());
                if (fileMD5HashCreateWithPath != null) {
                    hashMap2.put("hash", fileMD5HashCreateWithPath.hash);
                    hashMap2.put("size", Integer.valueOf(fileMD5HashCreateWithPath.size));
                }
            } else {
                hashMap2.put("size", Integer.valueOf(FileManager.getFileSize(FileManager.fileValue(str, str2, (Boolean) null))));
            }
            hashMap.put("", hashMap2);
            fileStreams.put(str, streamProvider);
            fileAttributes.put(str, hashMap);
            maybeUploadNewFiles();
        }
    }
}
