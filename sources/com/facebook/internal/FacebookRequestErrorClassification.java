package com.facebook.internal;

import com.facebook.FacebookRequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import gk.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\b\u0000\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012R'\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R'\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification;", "", "otherErrors", "", "", "", "transientErrors", "loginRecoverableErrors", "otherRecoveryMessage", "", "transientRecoveryMessage", "loginRecoverableRecoveryMessage", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginRecoverableErrors", "()Ljava/util/Map;", "getOtherErrors", "getTransientErrors", "classify", "Lcom/facebook/FacebookRequestError$Category;", "errorCode", "errorSubCode", "isTransient", "", "getRecoveryMessage", "category", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookRequestErrorClassification {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    public static final String KEY_NAME = "name";
    public static final String KEY_OTHER = "other";
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    public static final String KEY_TRANSIENT = "transient";
    /* access modifiers changed from: private */
    public static FacebookRequestErrorClassification defaultInstance;
    private final Map<Integer, Set<Integer>> loginRecoverableErrors;
    private final String loginRecoverableRecoveryMessage;
    private final Map<Integer, Set<Integer>> otherErrors;
    private final String otherRecoveryMessage;
    private final Map<Integer, Set<Integer>> transientErrors;
    private final String transientRecoveryMessage;

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010\u0011J&\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007R\u0014\u0010\u000e\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\n8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u001e8\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0006XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0006XT¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u001e8\u0006XT¢\u0006\u0006\n\u0004\b$\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification$Companion;", "", "Lorg/json/b;", "definition", "", "", "", "parseJSONDefinition", "Lorg/json/a;", "jsonArray", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "createFromJSON", "getDefaultErrorClassificationImpl", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "defaultErrorClassificationImpl", "getDefaultErrorClassification", "getDefaultErrorClassification$annotations", "()V", "defaultErrorClassification", "EC_APP_NOT_INSTALLED", "I", "EC_APP_TOO_MANY_CALLS", "EC_INVALID_SESSION", "EC_INVALID_TOKEN", "EC_RATE", "EC_SERVICE_UNAVAILABLE", "EC_TOO_MANY_USER_ACTION_CALLS", "EC_USER_TOO_MANY_CALLS", "ESC_APP_INACTIVE", "ESC_APP_NOT_INSTALLED", "", "KEY_LOGIN_RECOVERABLE", "Ljava/lang/String;", "KEY_NAME", "KEY_OTHER", "KEY_RECOVERY_MESSAGE", "KEY_TRANSIENT", "defaultInstance", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "<init>", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDefaultErrorClassification$annotations() {
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification((Map<Integer, ? extends Set<Integer>>) null, h0.k(h.a(2, null), h.a(4, null), h.a(9, null), h.a(17, null), h.a(Integer.valueOf(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS), null)), h0.k(h.a(102, null), h.a(190, null), h.a(Integer.valueOf(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED), null)), (String) null, (String) null, (String) null);
        }

        private final Map<Integer, Set<Integer>> parseJSONDefinition(b bVar) {
            int optInt;
            HashSet hashSet;
            a optJSONArray = bVar.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray.o() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    b s10 = optJSONArray.s(i10);
                    if (!(s10 == null || (optInt = s10.optInt("code")) == 0)) {
                        a optJSONArray2 = s10.optJSONArray("subcodes");
                        if (optJSONArray2 == null || optJSONArray2.o() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int o11 = optJSONArray2.o();
                            if (o11 > 0) {
                                int i12 = 0;
                                while (true) {
                                    int i13 = i12 + 1;
                                    int q10 = optJSONArray2.q(i12);
                                    if (q10 != 0) {
                                        hashSet.add(Integer.valueOf(q10));
                                    }
                                    if (i13 >= o11) {
                                        break;
                                    }
                                    i12 = i13;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(optInt), hashSet);
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return hashMap;
        }

        public final FacebookRequestErrorClassification createFromJSON(a aVar) {
            String str;
            String str2;
            String str3;
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String optString;
            a aVar2 = aVar;
            if (aVar2 == null) {
                return null;
            }
            int i10 = 0;
            int o10 = aVar.o();
            if (o10 > 0) {
                Map<Integer, Set<Integer>> map4 = null;
                Map<Integer, Set<Integer>> map5 = null;
                Map<Integer, Set<Integer>> map6 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                while (true) {
                    int i11 = i10 + 1;
                    b s10 = aVar2.s(i10);
                    if (!(s10 == null || (optString = s10.optString("name")) == null)) {
                        if (r.t(optString, "other", true)) {
                            str4 = s10.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map4 = parseJSONDefinition(s10);
                        } else if (r.t(optString, FacebookRequestErrorClassification.KEY_TRANSIENT, true)) {
                            str5 = s10.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map5 = parseJSONDefinition(s10);
                        } else if (r.t(optString, FacebookRequestErrorClassification.KEY_LOGIN_RECOVERABLE, true)) {
                            str6 = s10.optString(FacebookRequestErrorClassification.KEY_RECOVERY_MESSAGE, (String) null);
                            map6 = parseJSONDefinition(s10);
                        }
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
                map3 = map4;
                map2 = map5;
                map = map6;
                str3 = str4;
                str2 = str5;
                str = str6;
            } else {
                map3 = null;
                map2 = null;
                map = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            return new FacebookRequestErrorClassification(map3, map2, map, str3, str2, str);
        }

        public final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
            FacebookRequestErrorClassification access$getDefaultInstance$cp;
            if (FacebookRequestErrorClassification.defaultInstance == null) {
                FacebookRequestErrorClassification.defaultInstance = getDefaultErrorClassificationImpl();
            }
            access$getDefaultInstance$cp = FacebookRequestErrorClassification.defaultInstance;
            if (access$getDefaultInstance$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return access$getDefaultInstance$cp;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FacebookRequestError.Category.values().length];
            iArr[FacebookRequestError.Category.OTHER.ordinal()] = 1;
            iArr[FacebookRequestError.Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            iArr[FacebookRequestError.Category.TRANSIENT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FacebookRequestErrorClassification(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.otherErrors = map;
        this.transientErrors = map2;
        this.loginRecoverableErrors = map3;
        this.otherRecoveryMessage = str;
        this.transientRecoveryMessage = str2;
        this.loginRecoverableRecoveryMessage = str3;
    }

    public static final FacebookRequestErrorClassification createFromJSON(a aVar) {
        return Companion.createFromJSON(aVar);
    }

    public static final synchronized FacebookRequestErrorClassification getDefaultErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestErrorClassification.class) {
            defaultErrorClassification = Companion.getDefaultErrorClassification();
        }
        return defaultErrorClassification;
    }

    public final FacebookRequestError.Category classify(int i10, int i11, boolean z10) {
        Set set;
        Set set2;
        Set set3;
        if (z10) {
            return FacebookRequestError.Category.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.otherErrors;
        if (map != null && map.containsKey(Integer.valueOf(i10)) && ((set3 = this.otherErrors.get(Integer.valueOf(i10))) == null || set3.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.Category.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.loginRecoverableErrors;
        if (map2 != null && map2.containsKey(Integer.valueOf(i10)) && ((set2 = this.loginRecoverableErrors.get(Integer.valueOf(i10))) == null || set2.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.Category.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.transientErrors;
        if (map3 == null || !map3.containsKey(Integer.valueOf(i10)) || ((set = this.transientErrors.get(Integer.valueOf(i10))) != null && !set.contains(Integer.valueOf(i11)))) {
            return FacebookRequestError.Category.OTHER;
        }
        return FacebookRequestError.Category.TRANSIENT;
    }

    public final Map<Integer, Set<Integer>> getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    public final Map<Integer, Set<Integer>> getOtherErrors() {
        return this.otherErrors;
    }

    public final String getRecoveryMessage(FacebookRequestError.Category category) {
        int i10;
        if (category == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[category.ordinal()];
        }
        if (i10 == 1) {
            return this.otherRecoveryMessage;
        }
        if (i10 == 2) {
            return this.loginRecoverableRecoveryMessage;
        }
        if (i10 != 3) {
            return null;
        }
        return this.transientRecoveryMessage;
    }

    public final Map<Integer, Set<Integer>> getTransientErrors() {
        return this.transientErrors;
    }
}
