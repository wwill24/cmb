package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import gk.f;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.Regex;
import kotlin.text.d;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.cli.HelpFormatter;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\tX\u0002¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u00020\tX\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\r8CX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0010"}, d2 = {"Lcom/appsflyer/internal/AFc1cSDK;", "", "Lcom/appsflyer/internal/AFb1fSDK;", "AFInAppEventParameterName", "Lcom/appsflyer/internal/AFb1fSDK;", "AFKeystoreWrapper", "Lcom/appsflyer/internal/AFb1gSDK;", "Lcom/appsflyer/internal/AFb1gSDK;", "afInfoLog", "", "Lgk/f;", "valueOf", "AFInAppEventType", "", "()Z", "values", "()Ljava/lang/String;", "afRDLog", "p0", "p1", "<init>", "(Lcom/appsflyer/internal/AFb1fSDK;Lcom/appsflyer/internal/AFb1gSDK;)V", "AFa1ySDK"}, k = 1, mv = {1, 6, 0})
public class AFc1cSDK {
    public static final AFa1ySDK AFa1ySDK = new AFa1ySDK((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> afDebugLog = q.m("googleplay", "playstore", "googleplaystore");
    /* access modifiers changed from: private */
    public static AFc1eSDK afRDLog;
    public static String valueOf = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    public static String values = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    /* access modifiers changed from: private */
    public final AFb1fSDK AFInAppEventParameterName;
    public final f AFInAppEventType = b.b(new Function0<String>(this) {
        private /* synthetic */ AFc1cSDK AFKeystoreWrapper;

        {
            this.AFKeystoreWrapper = r1;
        }

        /* renamed from: values */
        public final String invoke() {
            String packageName = this.AFKeystoreWrapper.AFInAppEventParameterName.valueOf.values.getPackageName();
            j.f(packageName, "");
            return AFc1cSDK.valueOf(packageName, AFc1cSDK.valueOf(this.AFKeystoreWrapper));
        }
    });
    /* access modifiers changed from: private */
    public final AFb1gSDK AFKeystoreWrapper;
    private final f afInfoLog = b.b(new Function0<String>(this) {
        private /* synthetic */ AFc1cSDK values;

        {
            this.values = r1;
        }

        /* renamed from: AFInAppEventParameterName */
        public final String invoke() {
            boolean z10;
            String AFKeystoreWrapper = AFb1zSDK.AFKeystoreWrapper(this.values.AFKeystoreWrapper, this.values.AFInAppEventParameterName.values());
            if (AFKeystoreWrapper == null || r.w(AFKeystoreWrapper)) {
                z10 = true;
            } else {
                z10 = false;
            }
            String str = "";
            if (!z10) {
                String obj = StringsKt__StringsKt.W0(AFKeystoreWrapper).toString();
                List<String> AFInAppEventType = AFa1ySDK.AFInAppEventType();
                Locale locale = Locale.getDefault();
                j.f(locale, str);
                String lowerCase = obj.toLowerCase(locale);
                j.f(lowerCase, str);
                if (!AFInAppEventType.contains(lowerCase)) {
                    AFKeystoreWrapper = HelpFormatter.DEFAULT_OPT_PREFIX.concat(obj);
                } else {
                    o oVar = o.f32141a;
                    String format2 = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{obj}, 1));
                    j.f(format2, str);
                    AFLogger.afWarnLog(format2);
                    AFKeystoreWrapper = str;
                }
            }
            if (AFKeystoreWrapper != null) {
                str = AFKeystoreWrapper;
            }
            return StringsKt__StringsKt.W0(str).toString();
        }
    });

    public /* synthetic */ class AFa1xSDK {
        public static final /* synthetic */ int[] AFInAppEventType;

        static {
            int[] iArr = new int[AFd1ySDK.values().length];
            iArr[AFd1ySDK.DEFAULT.ordinal()] = 1;
            iArr[AFd1ySDK.API.ordinal()] = 2;
            iArr[AFd1ySDK.RC.ordinal()] = 3;
            AFInAppEventType = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\n\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\t\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b@\u0007X\n¢\u0006\f\n\u0004\b\f\u0010\r\"\u0004\b\t\u0010\u000e"}, d2 = {"Lcom/appsflyer/internal/AFc1cSDK$AFa1ySDK;", "", "", "afDebugLog", "Ljava/util/List;", "AFInAppEventType", "()Ljava/util/List;", "valueOf", "Ljava/lang/String;", "values", "AFKeystoreWrapper", "Lcom/appsflyer/internal/AFc1eSDK;", "afRDLog", "Lcom/appsflyer/internal/AFc1eSDK;", "(Lcom/appsflyer/internal/AFc1eSDK;)V", "AFInAppEventParameterName", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1ySDK {
        private AFa1ySDK() {
        }

        public /* synthetic */ AFa1ySDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static List<String> AFInAppEventType() {
            return AFc1cSDK.afDebugLog;
        }

        public static void values(AFc1eSDK aFc1eSDK) {
            AFc1cSDK.afRDLog = aFc1eSDK;
        }
    }

    public AFc1cSDK(AFb1fSDK aFb1fSDK, AFb1gSDK aFb1gSDK) {
        j.g(aFb1fSDK, "");
        j.g(aFb1gSDK, "");
        this.AFInAppEventParameterName = aFb1fSDK;
        this.AFKeystoreWrapper = aFb1gSDK;
    }

    public static boolean AFInAppEventType() {
        return afRDLog == null;
    }

    public static final void values(AFc1eSDK aFc1eSDK) {
        AFa1ySDK.values(aFc1eSDK);
    }

    public final String AFInAppEventParameterName() {
        AFd1ySDK aFd1ySDK;
        String str;
        if (AFInAppEventType()) {
            aFd1ySDK = AFd1ySDK.DEFAULT;
        } else {
            aFd1ySDK = AFd1ySDK.API;
        }
        int i10 = AFa1xSDK.AFInAppEventType[aFd1ySDK.ordinal()];
        if (i10 == 1) {
            return (String) this.AFInAppEventType.getValue();
        }
        if (i10 == 2) {
            AFc1eSDK aFc1eSDK = afRDLog;
            if (aFc1eSDK != null) {
                str = aFc1eSDK.valueOf;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        } else if (i10 == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ String valueOf(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(str2);
        String obj = sb3.toString();
        j.g(obj, "");
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = obj.getBytes(d.f32216b);
        j.f(bytes, "");
        byte[] digest = instance.digest(bytes);
        j.f(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        j.f(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        j.f(lowerCase, "");
        String substring = new Regex("[^\\w]+").f(lowerCase, "").substring(0, 6);
        j.f(substring, "");
        sb2.append(substring);
        sb2.append(SignatureVisitor.SUPER);
        return sb2.toString();
    }

    public final String AFKeystoreWrapper() {
        AFd1ySDK aFd1ySDK;
        if (AFInAppEventType()) {
            aFd1ySDK = AFd1ySDK.DEFAULT;
        } else {
            aFd1ySDK = AFd1ySDK.API;
        }
        int i10 = AFa1xSDK.AFInAppEventType[aFd1ySDK.ordinal()];
        if (i10 == 1) {
            return "appsflyersdk.com";
        }
        if (i10 == 2) {
            AFc1eSDK aFc1eSDK = afRDLog;
            String str = aFc1eSDK != null ? aFc1eSDK.AFKeystoreWrapper : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i10 == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ String valueOf(AFc1cSDK aFc1cSDK) {
        return (String) aFc1cSDK.afInfoLog.getValue();
    }
}
