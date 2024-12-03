package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import com.coffeemeetsbagel.models.ReportMetadata;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import gk.h;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0002J0\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J(\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J+\u0010!\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0002J(\u0010-\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\r2\n\u0010+\u001a\u00060)j\u0002`*2\n\u0010,\u001a\u00060)j\u0002`*H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\r2\u0006\u0010(\u001a\u00020\rH\u0002R\u0014\u00100\u001a\u00020/8\u0002XT¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00106\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b6\u00103R\u0014\u00107\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u00108\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b8\u00103R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010;R\"\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "", "isInitialized", "Ljava/io/File;", "file", "", "initialize", "", "buttonText", "activityName", "appName", "getTextFeature", "Lorg/json/b;", "viewHierarchy", "", "getDenseFeatures", "node", "parseFeatures", "Lorg/json/a;", "siblings", "screenName", "formFieldsJSON", "nonparseFeatures", "language", "event", "textType", "matchText", "regexMatched", "pattern", "", "indicators", "values", "matchIndicators", "([Ljava/lang/String;[Ljava/lang/String;)Z", "pruneTree", "a", "b", "sum", "isButton", "view", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "textSB", "hintSB", "updateHintAndTextRecursively", "getInteractedNode", "", "NUM_OF_FEATURES", "I", "REGEX_CR_PASSWORD_FIELD", "Ljava/lang/String;", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_ADD_TO_CART_BUTTON_TEXT", "REGEX_ADD_TO_CART_PAGE_TITLE", "", "languageInfo", "Ljava/util/Map;", "eventInfo", "textTypeInfo", "rules", "Lorg/json/b;", "initialized", "Z", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FeatureExtractor {
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static b rules;
    private static Map<String, String> textTypeInfo;

    private FeatureExtractor() {
    }

    public static final float[] getDenseFeatures(b bVar, String str) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(bVar, "viewHierarchy");
            j.g(str, "appName");
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            try {
                String lowerCase = str.toLowerCase();
                j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                b bVar2 = new b(bVar.optJSONObject("view").toString());
                String optString = bVar.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
                a aVar = new a();
                FeatureExtractor featureExtractor = INSTANCE;
                featureExtractor.pruneTree(bVar2, aVar);
                featureExtractor.sum(fArr, featureExtractor.parseFeatures(bVar2));
                b interactedNode = featureExtractor.getInteractedNode(bVar2);
                if (interactedNode == null) {
                    return null;
                }
                j.f(optString, "screenName");
                String bVar3 = bVar2.toString();
                j.f(bVar3, "viewTree.toString()");
                featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, aVar, optString, bVar3, lowerCase));
                return fArr;
            } catch (JSONException unused) {
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final b getInteractedNode(b bVar) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (bVar.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return bVar;
            }
            a optJSONArray = bVar.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return null;
            }
            int i10 = 0;
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    b j10 = optJSONArray.j(i10);
                    j.f(j10, "children.getJSONObject(i)");
                    b interactedNode = getInteractedNode(j10);
                    if (interactedNode != null) {
                        return interactedNode;
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return null;
        } catch (JSONException unused) {
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }

    public static final String getTextFeature(String str, String str2, String str3) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(str, "buttonText");
            j.g(str2, "activityName");
            j.g(str3, "appName");
            String str4 = str3 + " | " + str2 + ", " + str;
            if (str4 != null) {
                String lowerCase = str4.toLowerCase();
                j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void initialize(File file) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                rules = new b();
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new b(new String(bArr, d.f32216b));
                try {
                    languageInfo = h0.l(h.a(ViewHierarchyConstants.ENGLISH, AppEventsConstants.EVENT_PARAM_VALUE_YES), h.a(ViewHierarchyConstants.GERMAN, "2"), h.a(ViewHierarchyConstants.SPANISH, "3"), h.a(ViewHierarchyConstants.JAPANESE, ReportMetadata.ID_TIPS));
                    eventInfo = h0.l(h.a(ViewHierarchyConstants.VIEW_CONTENT, "0"), h.a(ViewHierarchyConstants.SEARCH, AppEventsConstants.EVENT_PARAM_VALUE_YES), h.a(ViewHierarchyConstants.ADD_TO_CART, "2"), h.a(ViewHierarchyConstants.ADD_TO_WISHLIST, "3"), h.a(ViewHierarchyConstants.INITIATE_CHECKOUT, ReportMetadata.ID_TIPS), h.a(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5"), h.a(ViewHierarchyConstants.PURCHASE, "6"), h.a(ViewHierarchyConstants.LEAD, "7"), h.a(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8"));
                    textTypeInfo = h0.l(h.a(ViewHierarchyConstants.BUTTON_TEXT, AppEventsConstants.EVENT_PARAM_VALUE_YES), h.a(ViewHierarchyConstants.PAGE_TITLE, "2"), h.a(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, "3"), h.a(ViewHierarchyConstants.BUTTON_ID, ReportMetadata.ID_TIPS));
                    initialized = true;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            } catch (Exception unused) {
            }
        }
    }

    private final boolean isButton(b bVar) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (((bVar.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 1) << 5) > 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    public static final boolean isInitialized() {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return initialized;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    private final boolean matchIndicators(String[] strArr, String[] strArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                String str = strArr[i10];
                i10++;
                int length2 = strArr2.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length2) {
                        String str2 = strArr2[i11];
                        i11++;
                        if (StringsKt__StringsKt.O(str2, str, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final float[] nonparseFeatures(b bVar, a aVar, String str, String str2, String str3) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        String str4 = str2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i10 = 0; i10 < 30; i10++) {
                fArr[i10] = 0.0f;
            }
            int o10 = aVar.o();
            if (o10 > 1) {
                f10 = ((float) o10) - 1.0f;
            } else {
                f10 = 0.0f;
            }
            fArr[3] = f10;
            try {
                int o11 = aVar.o();
                if (o11 > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        b j10 = aVar.j(i11);
                        j.f(j10, "siblings.getJSONObject(i)");
                        if (isButton(j10)) {
                            fArr[9] = fArr[9] + 1.0f;
                        }
                        if (i12 >= o11) {
                            break;
                        }
                        i11 = i12;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str5 = str + '|' + str3;
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            updateHintAndTextRecursively(bVar, sb3, sb2);
            String sb4 = sb2.toString();
            j.f(sb4, "hintSB.toString()");
            String sb5 = sb3.toString();
            j.f(sb5, "textSB.toString()");
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            fArr[15] = f11;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str5)) {
                f12 = 1.0f;
            } else {
                f12 = 0.0f;
            }
            fArr[16] = f12;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb4)) {
                f13 = 1.0f;
            } else {
                f13 = 0.0f;
            }
            fArr[17] = f13;
            if (StringsKt__StringsKt.O(str4, "password", false, 2, (Object) null)) {
                f14 = 1.0f;
            } else {
                f14 = 0.0f;
            }
            fArr[18] = f14;
            if (regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str4)) {
                f15 = 1.0f;
            } else {
                f15 = 0.0f;
            }
            fArr[19] = f15;
            if (regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str4)) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            fArr[20] = f16;
            if (regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str4)) {
                f17 = 1.0f;
            } else {
                f17 = 0.0f;
            }
            fArr[21] = f17;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
                f18 = 1.0f;
            } else {
                f18 = 0.0f;
            }
            fArr[22] = f18;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str5)) {
                f19 = 1.0f;
            } else {
                f19 = 0.0f;
            }
            fArr[24] = f19;
            if (regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb5)) {
                f20 = 1.0f;
            } else {
                f20 = 0.0f;
            }
            fArr[25] = f20;
            if (regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str5)) {
                f21 = 1.0f;
            } else {
                f21 = 0.0f;
            }
            fArr[27] = f21;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb5)) {
                f22 = 1.0f;
            } else {
                f22 = 0.0f;
            }
            fArr[28] = f22;
            if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str5)) {
                f23 = 1.0f;
            } else {
                f23 = 0.0f;
            }
            fArr[29] = f23;
            return fArr;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final float[] parseFeatures(b bVar) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i10 = 0;
            for (int i11 = 0; i11 < 30; i11++) {
                fArr[i11] = 0.0f;
            }
            String optString = bVar.optString("text");
            j.f(optString, "node.optString(TEXT_KEY)");
            String lowerCase = optString.toLowerCase();
            j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
            String optString2 = bVar.optString(ViewHierarchyConstants.HINT_KEY);
            j.f(optString2, "node.optString(HINT_KEY)");
            String lowerCase2 = optString2.toLowerCase();
            j.f(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String optString3 = bVar.optString(ViewHierarchyConstants.CLASS_NAME_KEY);
            j.f(optString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = optString3.toLowerCase();
            j.f(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int optInt = bVar.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{FirebaseAnalytics.Event.SEARCH}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (optInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (StringsKt__StringsKt.O(lowerCase3, "checkbox", false, 2, (Object) null)) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (StringsKt__StringsKt.O(lowerCase3, "radio", false, 2, (Object) null) && StringsKt__StringsKt.O(lowerCase3, "button", false, 2, (Object) null)) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                a optJSONArray = bVar.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                int o10 = optJSONArray.o();
                if (o10 > 0) {
                    while (true) {
                        int i12 = i10 + 1;
                        b j10 = optJSONArray.j(i10);
                        j.f(j10, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(j10));
                        if (i12 >= o10) {
                            break;
                        }
                        i10 = i12;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final boolean pruneTree(b bVar, a aVar) {
        boolean z10;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (bVar.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            a optJSONArray = bVar.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int o10 = optJSONArray.o();
            if (o10 > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (optJSONArray.j(i10).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                        z10 = true;
                        break;
                    } else if (i11 >= o10) {
                        break;
                    } else {
                        i10 = i11;
                    }
                }
            }
            z10 = false;
            boolean z11 = z10;
            a aVar2 = new a();
            if (z10) {
                int o11 = optJSONArray.o();
                if (o11 > 0) {
                    int i12 = 0;
                    while (true) {
                        int i13 = i12 + 1;
                        aVar.E(optJSONArray.j(i12));
                        if (i13 >= o11) {
                            break;
                        }
                        i12 = i13;
                    }
                }
            } else {
                int o12 = optJSONArray.o();
                if (o12 > 0) {
                    int i14 = 0;
                    while (true) {
                        int i15 = i14 + 1;
                        b j10 = optJSONArray.j(i14);
                        j.f(j10, "child");
                        if (pruneTree(j10, aVar)) {
                            aVar2.E(j10);
                            z11 = true;
                        }
                        if (i15 >= o12) {
                            break;
                        }
                        i14 = i15;
                    }
                }
                bVar.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) aVar2);
            }
            return z11;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ all -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean regexMatched(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.b r0 = rules     // Catch:{ all -> 0x007a }
            r2 = 0
            if (r0 == 0) goto L_0x0074
            java.lang.String r3 = "rulesForLanguage"
            org.json.b r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0017
            r5 = r2
            goto L_0x0025
        L_0x0017:
            java.util.Map<java.lang.String, java.lang.String> r3 = languageInfo     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x006e
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x007a }
            org.json.b r5 = r0.optJSONObject(r5)     // Catch:{ all -> 0x007a }
        L_0x0025:
            if (r5 != 0) goto L_0x0029
        L_0x0027:
            r5 = r2
            goto L_0x0040
        L_0x0029:
            java.lang.String r0 = "rulesForEvent"
            org.json.b r5 = r5.optJSONObject(r0)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            java.util.Map<java.lang.String, java.lang.String> r0 = eventInfo     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            org.json.b r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
        L_0x0040:
            if (r5 != 0) goto L_0x0043
            goto L_0x005a
        L_0x0043:
            java.lang.String r6 = "positiveRules"
            org.json.b r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            java.util.Map<java.lang.String, java.lang.String> r6 = textTypeInfo     // Catch:{ all -> 0x007a }
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r5.optString(r6)     // Catch:{ all -> 0x007a }
        L_0x005a:
            if (r2 != 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            boolean r1 = r4.regexMatched(r2, r8)     // Catch:{ all -> 0x007a }
        L_0x0061:
            return r1
        L_0x0062:
            java.lang.String r5 = "textTypeInfo"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x0068:
            java.lang.String r5 = "eventInfo"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x006e:
            java.lang.String r5 = "languageInfo"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x0074:
            java.lang.String r5 = "rules"
            kotlin.jvm.internal.j.y(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.FeatureExtractor.regexMatched(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private final void sum(float[] fArr, float[] fArr2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            int i10 = 0;
            try {
                int length = fArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        fArr[i10] = fArr[i10] + fArr2[i10];
                        if (i11 <= length) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final void updateHintAndTextRecursively(b bVar, StringBuilder sb2, StringBuilder sb3) {
        boolean z10;
        int o10;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String optString = bVar.optString("text", "");
                j.f(optString, "view.optString(TEXT_KEY, \"\")");
                String lowerCase = optString.toLowerCase();
                j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                String optString2 = bVar.optString(ViewHierarchyConstants.HINT_KEY, "");
                j.f(optString2, "view.optString(HINT_KEY, \"\")");
                String lowerCase2 = optString2.toLowerCase();
                j.f(lowerCase2, "(this as java.lang.String).toLowerCase()");
                boolean z11 = true;
                int i10 = 0;
                if (lowerCase.length() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    sb2.append(lowerCase);
                    sb2.append(" ");
                }
                if (lowerCase2.length() <= 0) {
                    z11 = false;
                }
                if (z11) {
                    sb3.append(lowerCase2);
                    sb3.append(" ");
                }
                a optJSONArray = bVar.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                if (optJSONArray != null && (o10 = optJSONArray.o()) > 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        try {
                            b j10 = optJSONArray.j(i10);
                            j.f(j10, "currentChildView");
                            updateHintAndTextRecursively(j10, sb2, sb3);
                        } catch (JSONException unused) {
                        }
                        if (i11 < o10) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final boolean regexMatched(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }
}
