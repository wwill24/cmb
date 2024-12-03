package com.facebook.appevents.aam;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule;", "", "name", "", "keyRules", "", "valRule", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKeyRules", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getValRule", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MetadataRule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_K = "k";
    private static final String FIELD_K_DELIMITER = ",";
    private static final String FIELD_V = "v";
    private static final Set<MetadataRule> rules = new CopyOnWriteArraySet();
    private final List<String> keyRules;
    private final String name;
    private final String valRule;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0007R\u0014\u0010\r\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule$Companion;", "", "Lorg/json/b;", "jsonObject", "", "constructRules", "", "Lcom/facebook/appevents/aam/MetadataRule;", "getRules", "", "rulesFromServer", "updateRules", "getEnabledRuleNames", "FIELD_K", "Ljava/lang/String;", "FIELD_K_DELIMITER", "FIELD_V", "", "rules", "Ljava/util/Set;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void constructRules(b bVar) {
            boolean z10;
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b optJSONObject = bVar.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MetadataRule.FIELD_K);
                    String optString2 = optJSONObject.optString("v");
                    j.f(optString, MetadataRule.FIELD_K);
                    if (optString.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        Set access$getRules$cp = MetadataRule.access$getRules$cp();
                        j.f(next, SDKConstants.PARAM_KEY);
                        List C0 = StringsKt__StringsKt.C0(optString, new String[]{","}, false, 0, 6, (Object) null);
                        j.f(optString2, "v");
                        access$getRules$cp.add(new MetadataRule(next, C0, optString2, (DefaultConstructorMarker) null));
                    }
                }
            }
        }

        public final Set<String> getEnabledRuleNames() {
            HashSet hashSet = new HashSet();
            for (MetadataRule name : MetadataRule.access$getRules$cp()) {
                hashSet.add(name.getName());
            }
            return hashSet;
        }

        public final Set<MetadataRule> getRules() {
            return new HashSet(MetadataRule.access$getRules$cp());
        }

        public final void updateRules(String str) {
            j.g(str, "rulesFromServer");
            try {
                MetadataRule.access$getRules$cp().clear();
                constructRules(new b(str));
            } catch (JSONException unused) {
            }
        }
    }

    private MetadataRule(String str, List<String> list, String str2) {
        this.name = str;
        this.valRule = str2;
        this.keyRules = list;
    }

    public /* synthetic */ MetadataRule(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    public static final /* synthetic */ Set access$getRules$cp() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return rules;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Set<String> getEnabledRuleNames() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getEnabledRuleNames();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Set<MetadataRule> getRules() {
        Class<MetadataRule> cls = MetadataRule.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Companion.getRules();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void updateRules(String str) {
        Class<MetadataRule> cls = MetadataRule.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Companion.updateRules(str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final List<String> getKeyRules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new ArrayList(this.keyRules);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final String getName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.name;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public final String getValRule() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.valRule;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}
