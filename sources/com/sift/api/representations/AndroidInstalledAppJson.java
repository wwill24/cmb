package com.sift.api.representations;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import lg.a;
import lg.c;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;

public class AndroidInstalledAppJson {
    @a
    @c("app_name")
    public String appName;
    @a
    @c("package_name")
    public String packageName;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidInstalledAppJson)) {
            return false;
        }
        AndroidInstalledAppJson androidInstalledAppJson = (AndroidInstalledAppJson) obj;
        String str = this.appName;
        String str2 = androidInstalledAppJson.appName;
        if (str == str2 || (str != null && str.equals(str2))) {
            String str3 = this.packageName;
            String str4 = androidInstalledAppJson.packageName;
            if (str3 == str4) {
                return true;
            }
            if (str3 != null && str3.equals(str4)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        String str = this.appName;
        int i11 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i12 = (i10 + 31) * 31;
        String str2 = this.packageName;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AndroidInstalledAppJson.class.getName());
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append('[');
        sb2.append(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        sb2.append(SignatureVisitor.INSTANCEOF);
        String str = this.packageName;
        String str2 = "<null>";
        if (str == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(',');
        sb2.append("appName");
        sb2.append(SignatureVisitor.INSTANCEOF);
        String str3 = this.appName;
        if (str3 != null) {
            str2 = str3;
        }
        sb2.append(str2);
        sb2.append(',');
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.setCharAt(sb2.length() - 1, PropertyUtils.INDEXED_DELIM2);
        } else {
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        return sb2.toString();
    }

    public AndroidInstalledAppJson withAppName(String str) {
        this.appName = str;
        return this;
    }

    public AndroidInstalledAppJson withPackageName(String str) {
        this.packageName = str;
        return this;
    }
}
