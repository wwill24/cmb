package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u0004H\u0007J\r\u0010#\u001a\u00020\u0004H\u0001¢\u0006\u0002\b$J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0002J\u001c\u0010,\u001a\u00020!2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016H\u0007J\u0012\u0010.\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010/H\u0007Jl\u0010.\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\u00042\b\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u00106\u001a\u0004\u0018\u00010\u00042\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010:\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010/H\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/UserDataStore;", "", "()V", "CITY", "", "COUNTRY", "DATA_SEPARATOR", "DATE_OF_BIRTH", "EMAIL", "FIRST_NAME", "GENDER", "INTERNAL_USER_DATA_KEY", "LAST_NAME", "MAX_NUM", "", "PHONE", "STATE", "TAG", "kotlin.jvm.PlatformType", "USER_DATA_KEY", "ZIP", "enabledInternalUserData", "", "getEnabledInternalUserData", "()Ljava/util/Map;", "externalHashedUserData", "Ljava/util/concurrent/ConcurrentHashMap;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "internalHashedUserData", "sharedPreferences", "Landroid/content/SharedPreferences;", "clear", "", "getAllHashedUserData", "getHashedUserData", "getHashedUserData$facebook_core_release", "initAndWait", "initStore", "maybeSHA256Hashed", "", "data", "normalizeData", "type", "setInternalUd", "ud", "setUserDataAndHash", "Landroid/os/Bundle;", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "updateHashUserData", "writeDataIntoCache", "key", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserDataStore {
    public static final String CITY = "ct";
    public static final String COUNTRY = "country";
    private static final String DATA_SEPARATOR = ",";
    public static final String DATE_OF_BIRTH = "db";
    public static final String EMAIL = "em";
    public static final String FIRST_NAME = "fn";
    public static final String GENDER = "ge";
    public static final UserDataStore INSTANCE = new UserDataStore();
    private static final String INTERNAL_USER_DATA_KEY = "com.facebook.appevents.UserDataStore.internalUserData";
    public static final String LAST_NAME = "ln";
    private static final int MAX_NUM = 5;
    public static final String PHONE = "ph";
    public static final String STATE = "st";
    private static final String TAG = UserDataStore.class.getSimpleName();
    private static final String USER_DATA_KEY = "com.facebook.appevents.UserDataStore.userData";
    public static final String ZIP = "zp";
    private static final ConcurrentHashMap<String, String> externalHashedUserData = new ConcurrentHashMap<>();
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, String> internalHashedUserData = new ConcurrentHashMap<>();
    private static SharedPreferences sharedPreferences;

    private UserDataStore() {
    }

    public static final void clear() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new r());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: clear$lambda-2  reason: not valid java name */
    public static final void m51clear$lambda2() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                externalHashedUserData.clear();
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(USER_DATA_KEY, (String) null).apply();
                } else {
                    j.y("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final String getAllHashedUserData() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(externalHashedUserData);
            hashMap.putAll(INSTANCE.getEnabledInternalUserData());
            return Utility.mapToJsonStr(hashMap);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final Map<String, String> getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> enabledRuleNames = MetadataRule.Companion.getEnabledRuleNames();
            for (String next : internalHashedUserData.keySet()) {
                if (enabledRuleNames.contains(next)) {
                    hashMap.put(next, internalHashedUserData.get(next));
                }
            }
            return hashMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final String getHashedUserData$facebook_core_release() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (!initialized.get()) {
                INSTANCE.initAndWait();
            }
            Utility utility = Utility.INSTANCE;
            return Utility.mapToJsonStr(externalHashedUserData);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final synchronized void initAndWait() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                AtomicBoolean atomicBoolean = initialized;
                if (!atomicBoolean.get()) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
                    j.f(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
                    sharedPreferences = defaultSharedPreferences;
                    if (defaultSharedPreferences != null) {
                        String string = defaultSharedPreferences.getString(USER_DATA_KEY, "");
                        if (string == null) {
                            string = "";
                        }
                        SharedPreferences sharedPreferences2 = sharedPreferences;
                        if (sharedPreferences2 != null) {
                            String string2 = sharedPreferences2.getString(INTERNAL_USER_DATA_KEY, "");
                            if (string2 == null) {
                                string2 = "";
                            }
                            externalHashedUserData.putAll(Utility.jsonStrToMap(string));
                            internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
                            atomicBoolean.set(true);
                            return;
                        }
                        j.y("sharedPreferences");
                        throw null;
                    }
                    j.y("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final void initStore() {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final boolean maybeSHA256Hashed(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return new Regex("[A-Fa-f0-9]{64}").e(str);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final String normalizeData(String str, String str2) {
        boolean z10;
        String str3;
        int i10;
        boolean z11;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i11 = 0;
            boolean z12 = false;
            while (true) {
                if (i11 > length) {
                    break;
                }
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
            String obj = str2.subSequence(i11, length + 1).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (j.b("em", str)) {
                    if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                        return lowerCase;
                    }
                    return "";
                } else if (j.b(PHONE, str)) {
                    return new Regex("[^0-9]").f(lowerCase, "");
                } else {
                    if (!j.b(GENDER, str)) {
                        return lowerCase;
                    }
                    if (lowerCase.length() > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        str3 = "";
                    } else if (lowerCase != null) {
                        str3 = lowerCase.substring(0, 1);
                        j.f(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    if (j.b(NetworkProfile.FEMALE, str3) || j.b(NetworkProfile.MALE, str3)) {
                        return str3;
                    }
                    return "";
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final void setInternalUd(Map<String, String> map) {
        boolean z10;
        int i10;
        boolean z11;
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(map, "ud");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    Utility utility = Utility.INSTANCE;
                    UserDataStore userDataStore = INSTANCE;
                    int i11 = 1;
                    int length = str2.length() - 1;
                    int i12 = 0;
                    boolean z12 = false;
                    while (true) {
                        if (i12 > length) {
                            break;
                        }
                        if (!z12) {
                            i10 = i12;
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
                                i12++;
                            }
                        } else if (!z11) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String sha256hash = Utility.sha256hash(userDataStore.normalizeData(str, str2.subSequence(i12, length + 1).toString()));
                    ConcurrentHashMap<String, String> concurrentHashMap = internalHashedUserData;
                    if (concurrentHashMap.containsKey(str)) {
                        String str3 = concurrentHashMap.get(str);
                        String[] strArr = null;
                        if (str3 != null) {
                            List<String> h10 = new Regex(",").h(str3, 0);
                            if (h10 != null) {
                                Object[] array2 = h10.toArray(new String[0]);
                                if (array2 != null) {
                                    strArr = (String[]) array2;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                        }
                        if (strArr == null) {
                            strArr = new String[0];
                        }
                        Set g10 = n0.g(Arrays.copyOf(strArr, strArr.length));
                        if (!g10.contains(sha256hash)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (strArr.length == 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                sb2.append(sha256hash);
                            } else if (strArr.length < 5) {
                                sb2.append(str3);
                                sb2.append(",");
                                sb2.append(sha256hash);
                            } else {
                                while (true) {
                                    int i13 = i11 + 1;
                                    sb2.append(strArr[i11]);
                                    sb2.append(",");
                                    if (i13 >= 5) {
                                        break;
                                    }
                                    i11 = i13;
                                }
                                sb2.append(sha256hash);
                                g10.remove(strArr[0]);
                            }
                            internalHashedUserData.put(str, sb2.toString());
                        } else {
                            return;
                        }
                    } else {
                        concurrentHashMap.put(str, sha256hash);
                    }
                }
                UserDataStore userDataStore2 = INSTANCE;
                Utility utility2 = Utility.INSTANCE;
                userDataStore2.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setUserDataAndHash(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger.Companion.getAnalyticsExecutor().execute(new q(bundle));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUserDataAndHash$lambda-1  reason: not valid java name */
    public static final void m52setUserDataAndHash$lambda1(Bundle bundle) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                UserDataStore userDataStore = INSTANCE;
                userDataStore.updateHashUserData(bundle);
                Utility utility = Utility.INSTANCE;
                userDataStore.writeDataIntoCache(USER_DATA_KEY, Utility.mapToJsonStr(externalHashedUserData));
                userDataStore.writeDataIntoCache(INTERNAL_USER_DATA_KEY, Utility.mapToJsonStr(internalHashedUserData));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final void updateHashUserData(Bundle bundle) {
        if (!CrashShieldHandler.isObjectCrashing(this) && bundle != null) {
            try {
                for (String next : bundle.keySet()) {
                    Object obj = bundle.get(next);
                    if (obj != null) {
                        String obj2 = obj.toString();
                        if (maybeSHA256Hashed(obj2)) {
                            ConcurrentHashMap<String, String> concurrentHashMap = externalHashedUserData;
                            if (obj2 != null) {
                                String lowerCase = obj2.toLowerCase();
                                j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                                concurrentHashMap.put(next, lowerCase);
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            Utility utility = Utility.INSTANCE;
                            j.f(next, SDKConstants.PARAM_KEY);
                            String sha256hash = Utility.sha256hash(normalizeData(next, obj2));
                            if (sha256hash != null) {
                                externalHashedUserData.put(next, sha256hash);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void writeDataIntoCache(String str, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk.getExecutor().execute(new s(str, str2));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: writeDataIntoCache$lambda-0  reason: not valid java name */
    public static final void m53writeDataIntoCache$lambda0(String str, String str2) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(str, "$key");
                j.g(str2, "$value");
                if (!initialized.get()) {
                    INSTANCE.initAndWait();
                }
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putString(str, str2).apply();
                } else {
                    j.y("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void setUserDataAndHash(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Class<UserDataStore> cls = UserDataStore.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                if (str != null) {
                    bundle.putString("em", str);
                }
                if (str2 != null) {
                    bundle.putString(FIRST_NAME, str2);
                }
                if (str3 != null) {
                    bundle.putString(LAST_NAME, str3);
                }
                if (str4 != null) {
                    bundle.putString(PHONE, str4);
                }
                if (str5 != null) {
                    bundle.putString(DATE_OF_BIRTH, str5);
                }
                if (str6 != null) {
                    bundle.putString(GENDER, str6);
                }
                if (str7 != null) {
                    bundle.putString("ct", str7);
                }
                if (str8 != null) {
                    bundle.putString(STATE, str8);
                }
                if (str9 != null) {
                    bundle.putString(ZIP, str9);
                }
                if (str10 != null) {
                    bundle.putString("country", str10);
                }
                setUserDataAndHash(bundle);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }
}
