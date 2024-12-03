package com.appsflyer.internal;

import android.util.Base64;
import com.facebook.appevents.UserDataStore;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.apache.commons.beanutils.PropertyUtils;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0005X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0005X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0011\u0010\u000f\u001a\u00020\u0005X\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0012\u0010\u0003\u001a\u00020\bX\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/appsflyer/internal/AFb1aSDK;", "", "Lorg/json/b;", "AFKeystoreWrapper", "()Lorg/json/b;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "p0", "", "equals", "(Ljava/lang/Object;)Z", "AFInAppEventType", "Ljava/lang/String;", "valueOf", "AFInAppEventParameterName", "I", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "AFa1zSDK"}, k = 1, mv = {1, 6, 0})
public final class AFb1aSDK {
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    public int AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final String AFKeystoreWrapper;
    public final String valueOf;

    public AFb1aSDK(String str, String str2, String str3, int i10) {
        j.g(str, "");
        j.g(str2, "");
        j.g(str3, "");
        this.AFInAppEventType = str;
        this.valueOf = str2;
        this.AFKeystoreWrapper = str3;
        this.AFInAppEventParameterName = i10;
    }

    public final b AFKeystoreWrapper() {
        b bVar = new b();
        bVar.put("label", (Object) this.AFInAppEventType);
        bVar.put("hash_name", (Object) this.valueOf);
        bVar.put(UserDataStore.STATE, (Object) this.AFKeystoreWrapper);
        bVar.put("c", (Object) String.valueOf(this.AFInAppEventParameterName));
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFb1aSDK)) {
            return false;
        }
        AFb1aSDK aFb1aSDK = (AFb1aSDK) obj;
        return j.b(this.AFInAppEventType, aFb1aSDK.AFInAppEventType) && j.b(this.valueOf, aFb1aSDK.valueOf) && j.b(this.AFKeystoreWrapper, aFb1aSDK.AFKeystoreWrapper) && this.AFInAppEventParameterName == aFb1aSDK.AFInAppEventParameterName;
    }

    public final int hashCode() {
        return (((((this.AFInAppEventType.hashCode() * 31) + this.valueOf.hashCode()) * 31) + this.AFKeystoreWrapper.hashCode()) * 31) + Integer.hashCode(this.AFInAppEventParameterName);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AFb1aSDK(valueOf=");
        sb2.append(this.AFInAppEventType);
        sb2.append(", AFInAppEventParameterName=");
        sb2.append(this.valueOf);
        sb2.append(", AFInAppEventType=");
        sb2.append(this.AFKeystoreWrapper);
        sb2.append(", AFKeystoreWrapper=");
        sb2.append(this.AFInAppEventParameterName);
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFb1aSDK(String str, String str2, String str3, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? 1 : i10);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFb1aSDK$AFa1zSDK;", "", "p0", "", "", "p1", "", "AFInAppEventParameterName", "(Ljava/lang/Integer;[Ljava/lang/String;)Z", "Lcom/appsflyer/internal/AFb1aSDK;", "values", "(Ljava/lang/String;)Lcom/appsflyer/internal/AFb1aSDK;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static boolean AFInAppEventParameterName(Integer num, String... strArr) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (num == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            int length = strArr.length;
            for (int i10 = 0; i10 < 3; i10++) {
                String str = strArr[i10];
                if (!z10) {
                    if (str == null || str.length() == 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        z11 = false;
                    }
                }
                z11 = true;
            }
            return z10;
        }

        public static AFb1aSDK values(String str) {
            j.g(str, "");
            List<String> C0 = StringsKt__StringsKt.C0(str, new String[]{"\n"}, false, 0, 6, (Object) null);
            if (C0.size() != 4) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            Integer num = null;
            for (String str5 : C0) {
                if (!r.J(str5, "label=", false, 2, (Object) null)) {
                    if (!r.J(str5, "hashName=", false, 2, (Object) null)) {
                        if (!r.J(str5, "stackTrace=", false, 2, (Object) null)) {
                            if (!r.J(str5, "c=", false, 2, (Object) null)) {
                                break;
                            }
                            String substring = str5.substring(2);
                            j.f(substring, "");
                            num = Integer.valueOf(Integer.parseInt(StringsKt__StringsKt.W0(substring).toString()));
                        } else {
                            str4 = values(str5, "stackTrace=");
                        }
                    } else {
                        str3 = values(str5, "hashName=");
                    }
                } else {
                    str2 = values(str5, "label=");
                }
            }
            if (AFInAppEventParameterName(num, str2, str3, str4)) {
                return null;
            }
            j.d(str2);
            j.d(str3);
            j.d(str4);
            j.d(num);
            return new AFb1aSDK(str2, str3, str4, num.intValue());
        }

        private static String values(String str, String str2) {
            String substring = str.substring(str2.length());
            j.f(substring, "");
            String obj = StringsKt__StringsKt.W0(substring).toString();
            j.g(obj, "");
            Charset charset = d.f32216b;
            byte[] bytes = obj.getBytes(charset);
            j.f(bytes, "");
            j.g(bytes, "");
            byte[] decode = Base64.decode(bytes, 2);
            j.f(decode, "");
            return new String(decode, charset);
        }
    }
}
