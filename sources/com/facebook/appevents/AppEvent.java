package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.Regex;
import org.jivesoftware.smack.util.StringUtils;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,BG\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u0006\u0010&\u001a\u00020\u0013\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b'\u0010(B+\b\u0012\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010*J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000bJ\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0011\u0010$\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b$\u0010\u001d¨\u0006-"}, d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", "", "contextName", "eventName", "", "valueToSum", "Landroid/os/Bundle;", "parameters", "Ljava/util/UUID;", "currentSessionId", "Lorg/json/b;", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/b;", "", "validateParameters", "", "writeReplace", "calculateChecksum", "", "getIsImplicit", "getJSONObject", "toString", "jsonObject", "Lorg/json/b;", "getJsonObject", "()Lorg/json/b;", "isImplicit", "Z", "()Z", "inBackground", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "checksum", "isChecksumValid", "isImplicitlyLogged", "isInBackground", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;)V", "jsonString", "(Ljava/lang/String;ZZLjava/lang/String;)V", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AppEvent implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public static final HashSet<String> validatedIdentifiers = new HashSet<>();
    private final String checksum;
    private final boolean inBackground;
    private final boolean isImplicit;
    private final b jsonObject;
    private final String name;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", "", "()V", "MAX_IDENTIFIER_LENGTH", "", "serialVersionUID", "", "validatedIdentifiers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "md5Checksum", "toHash", "validateIdentifier", "", "identifier", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String md5Checksum(String str) {
            try {
                MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
                Charset forName = Charset.forName("UTF-8");
                j.f(forName, "Charset.forName(charsetName)");
                if (str != null) {
                    byte[] bytes = str.getBytes(forName);
                    j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes, 0, bytes.length);
                    byte[] digest = instance.digest();
                    j.f(digest, "digest.digest()");
                    return AppEventUtility.bytesToHex(digest);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (NoSuchAlgorithmException e10) {
                Utility.logd("Failed to generate checksum: ", (Exception) e10);
                return "0";
            } catch (UnsupportedEncodingException e11) {
                Utility.logd("Failed to generate checksum: ", (Exception) e11);
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
        }

        /* access modifiers changed from: private */
        public final void validateIdentifier(String str) {
            boolean z10;
            boolean contains;
            if (str != null) {
                if (str.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10 && str.length() <= 40) {
                    synchronized (AppEvent.validatedIdentifiers) {
                        contains = AppEvent.validatedIdentifiers.contains(str);
                        Unit unit = Unit.f32013a;
                    }
                    if (contains) {
                        return;
                    }
                    if (new Regex("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").e(str)) {
                        synchronized (AppEvent.validatedIdentifiers) {
                            AppEvent.validatedIdentifiers.add(str);
                        }
                        return;
                    }
                    o oVar = o.f32141a;
                    String format2 = String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{str}, 1));
                    j.f(format2, "java.lang.String.format(format, *args)");
                    throw new FacebookException(format2);
                }
            }
            if (str == null) {
                str = "<None Provided>";
            }
            o oVar2 = o.f32141a;
            String format3 = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, 40}, 2));
            j.f(format3, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format3);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", "", "isImplicit", "", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SerializationProxyV2 implements Serializable {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean inBackground;
        private final boolean isImplicit;
        private final String jsonString;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SerializationProxyV2(String str, boolean z10, boolean z11, String str2) {
            j.g(str, "jsonString");
            this.jsonString = str;
            this.isImplicit = z10;
            this.inBackground = z11;
            this.checksum = str2;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            return new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum, (DefaultConstructorMarker) null);
        }
    }

    public AppEvent(String str, String str2, Double d10, Bundle bundle, boolean z10, boolean z11, UUID uuid) throws JSONException, FacebookException {
        j.g(str, "contextName");
        j.g(str2, "eventName");
        this.isImplicit = z10;
        this.inBackground = z11;
        this.name = str2;
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d10, bundle, uuid);
        this.checksum = calculateChecksum();
    }

    public /* synthetic */ AppEvent(String str, boolean z10, boolean z11, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z10, z11, str2);
    }

    private final String calculateChecksum() {
        Companion companion = Companion;
        String bVar = this.jsonObject.toString();
        j.f(bVar, "jsonObject.toString()");
        return companion.md5Checksum(bVar);
    }

    private final b getJSONObjectForAppEvent(String str, String str2, Double d10, Bundle bundle, UUID uuid) {
        Companion companion = Companion;
        companion.validateIdentifier(str2);
        b bVar = new b();
        String processEvent = RestrictiveDataManager.processEvent(str2);
        bVar.put(Constants.EVENT_NAME_EVENT_KEY, (Object) processEvent);
        bVar.put(Constants.EVENT_NAME_MD5_EVENT_KEY, (Object) companion.md5Checksum(processEvent));
        bVar.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / ((long) 1000));
        bVar.put("_ui", (Object) str);
        if (uuid != null) {
            bVar.put("_session_id", (Object) uuid);
        }
        if (bundle != null) {
            Map<String, String> validateParameters = validateParameters(bundle);
            for (String next : validateParameters.keySet()) {
                bVar.put(next, (Object) validateParameters.get(next));
            }
        }
        if (d10 != null) {
            bVar.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d10.doubleValue());
        }
        if (this.inBackground) {
            bVar.put("_inBackground", (Object) AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (this.isImplicit) {
            bVar.put("_implicitlyLogged", (Object) AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } else {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String bVar2 = bVar.toString();
            j.f(bVar2, "eventObject.toString()");
            companion2.log(loggingBehavior, "AppEvents", "Created app event '%s'", bVar2);
        }
        return bVar;
    }

    private final Map<String, String> validateParameters(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Companion companion = Companion;
            j.f(next, SDKConstants.PARAM_KEY);
            companion.validateIdentifier(next);
            Object obj = bundle.get(next);
            if ((obj instanceof String) || (obj instanceof Number)) {
                hashMap.put(next, obj.toString());
            } else {
                o oVar = o.f32141a;
                String format2 = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{obj, next}, 2));
                j.f(format2, "java.lang.String.format(format, *args)");
                throw new FacebookException(format2);
            }
        }
        IntegrityManager.processParameters(hashMap);
        RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
        RestrictiveDataManager.processParameters(hashMap, this.name);
        EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
        EventDeactivationManager.processDeprecatedParameters(hashMap, this.name);
        return hashMap;
    }

    private final Object writeReplace() throws ObjectStreamException {
        String bVar = this.jsonObject.toString();
        j.f(bVar, "jsonObject.toString()");
        return new SerializationProxyV2(bVar, this.isImplicit, this.inBackground, this.checksum);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    public final b getJSONObject() {
        return this.jsonObject;
    }

    public final b getJsonObject() {
        return this.jsonObject;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return j.b(calculateChecksum(), this.checksum);
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    public String toString() {
        o oVar = o.f32141a;
        String format2 = String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3));
        j.f(format2, "java.lang.String.format(format, *args)");
        return format2;
    }

    private AppEvent(String str, boolean z10, boolean z11, String str2) {
        b bVar = new b(str);
        this.jsonObject = bVar;
        this.isImplicit = z10;
        String optString = bVar.optString(Constants.EVENT_NAME_EVENT_KEY);
        j.f(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = optString;
        this.checksum = str2;
        this.inBackground = z11;
    }
}
