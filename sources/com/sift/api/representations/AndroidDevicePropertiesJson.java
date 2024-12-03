package com.sift.api.representations;

import java.util.ArrayList;
import java.util.List;
import lg.a;
import lg.c;

public class AndroidDevicePropertiesJson {
    @a
    @c("android_id")
    public String androidId;
    @a
    @c("app_name")
    public String appName;
    @a
    @c("app_version")
    public String appVersion;
    @a
    @c("build_tags")
    public String buildTags;
    @a
    @c("device_manufacturer")
    public String deviceManufacturer;
    @a
    @c("device_model")
    public String deviceModel;
    @a
    @c("device_system_version")
    public String deviceSystemVersion;
    @a
    @c("evidence_directories_writable")
    public List<String> evidenceDirectoriesWritable = new ArrayList();
    @a
    @c("evidence_files_present")
    public List<String> evidenceFilesPresent = new ArrayList();
    @a
    @c("evidence_packages_present")
    public List<String> evidencePackagesPresent = new ArrayList();
    @a
    @c("evidence_properties")
    public List<String> evidenceProperties = new ArrayList();
    @a
    @c("installed_apps")
    public List<AndroidInstalledAppJson> installedApps = new ArrayList();
    @a
    @c("mobile_carrier_name")
    public String mobileCarrierName;
    @a
    @c("mobile_iso_country_code")
    public String mobileIsoCountryCode;
    @a
    @c("sdk_version")
    public String sdkVersion;

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        List<String> list;
        List<String> list2;
        String str5;
        String str6;
        String str7;
        String str8;
        List<String> list3;
        List<String> list4;
        List<AndroidInstalledAppJson> list5;
        List<AndroidInstalledAppJson> list6;
        List<String> list7;
        List<String> list8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        List<String> list9;
        List<String> list10;
        String str15;
        String str16;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidDevicePropertiesJson)) {
            return false;
        }
        AndroidDevicePropertiesJson androidDevicePropertiesJson = (AndroidDevicePropertiesJson) obj;
        String str17 = this.appVersion;
        String str18 = androidDevicePropertiesJson.appVersion;
        if ((str17 == str18 || (str17 != null && str17.equals(str18))) && (((str = this.appName) == (str2 = androidDevicePropertiesJson.appName) || (str != null && str.equals(str2))) && (((str3 = this.mobileCarrierName) == (str4 = androidDevicePropertiesJson.mobileCarrierName) || (str3 != null && str3.equals(str4))) && (((list = this.evidencePackagesPresent) == (list2 = androidDevicePropertiesJson.evidencePackagesPresent) || (list != null && list.equals(list2))) && (((str5 = this.mobileIsoCountryCode) == (str6 = androidDevicePropertiesJson.mobileIsoCountryCode) || (str5 != null && str5.equals(str6))) && (((str7 = this.deviceSystemVersion) == (str8 = androidDevicePropertiesJson.deviceSystemVersion) || (str7 != null && str7.equals(str8))) && (((list3 = this.evidenceDirectoriesWritable) == (list4 = androidDevicePropertiesJson.evidenceDirectoriesWritable) || (list3 != null && list3.equals(list4))) && (((list5 = this.installedApps) == (list6 = androidDevicePropertiesJson.installedApps) || (list5 != null && list5.equals(list6))) && (((list7 = this.evidenceProperties) == (list8 = androidDevicePropertiesJson.evidenceProperties) || (list7 != null && list7.equals(list8))) && (((str9 = this.buildTags) == (str10 = androidDevicePropertiesJson.buildTags) || (str9 != null && str9.equals(str10))) && (((str11 = this.sdkVersion) == (str12 = androidDevicePropertiesJson.sdkVersion) || (str11 != null && str11.equals(str12))) && (((str13 = this.deviceModel) == (str14 = androidDevicePropertiesJson.deviceModel) || (str13 != null && str13.equals(str14))) && (((list9 = this.evidenceFilesPresent) == (list10 = androidDevicePropertiesJson.evidenceFilesPresent) || (list9 != null && list9.equals(list10))) && ((str15 = this.deviceManufacturer) == (str16 = androidDevicePropertiesJson.deviceManufacturer) || (str15 != null && str15.equals(str16)))))))))))))))) {
            String str19 = this.androidId;
            String str20 = androidDevicePropertiesJson.androidId;
            if (str19 == str20) {
                return true;
            }
            if (str19 != null && str19.equals(str20)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        String str = this.appVersion;
        int i24 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i25 = (i10 + 31) * 31;
        String str2 = this.appName;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i26 = (i25 + i11) * 31;
        String str3 = this.mobileCarrierName;
        if (str3 == null) {
            i12 = 0;
        } else {
            i12 = str3.hashCode();
        }
        int i27 = (i26 + i12) * 31;
        List<String> list = this.evidencePackagesPresent;
        if (list == null) {
            i13 = 0;
        } else {
            i13 = list.hashCode();
        }
        int i28 = (i27 + i13) * 31;
        String str4 = this.mobileIsoCountryCode;
        if (str4 == null) {
            i14 = 0;
        } else {
            i14 = str4.hashCode();
        }
        int i29 = (i28 + i14) * 31;
        String str5 = this.deviceSystemVersion;
        if (str5 == null) {
            i15 = 0;
        } else {
            i15 = str5.hashCode();
        }
        int i30 = (i29 + i15) * 31;
        List<String> list2 = this.evidenceDirectoriesWritable;
        if (list2 == null) {
            i16 = 0;
        } else {
            i16 = list2.hashCode();
        }
        int i31 = (i30 + i16) * 31;
        List<AndroidInstalledAppJson> list3 = this.installedApps;
        if (list3 == null) {
            i17 = 0;
        } else {
            i17 = list3.hashCode();
        }
        int i32 = (i31 + i17) * 31;
        List<String> list4 = this.evidenceProperties;
        if (list4 == null) {
            i18 = 0;
        } else {
            i18 = list4.hashCode();
        }
        int i33 = (i32 + i18) * 31;
        String str6 = this.buildTags;
        if (str6 == null) {
            i19 = 0;
        } else {
            i19 = str6.hashCode();
        }
        int i34 = (i33 + i19) * 31;
        String str7 = this.sdkVersion;
        if (str7 == null) {
            i20 = 0;
        } else {
            i20 = str7.hashCode();
        }
        int i35 = (i34 + i20) * 31;
        String str8 = this.deviceModel;
        if (str8 == null) {
            i21 = 0;
        } else {
            i21 = str8.hashCode();
        }
        int i36 = (i35 + i21) * 31;
        List<String> list5 = this.evidenceFilesPresent;
        if (list5 == null) {
            i22 = 0;
        } else {
            i22 = list5.hashCode();
        }
        int i37 = (i36 + i22) * 31;
        String str9 = this.deviceManufacturer;
        if (str9 == null) {
            i23 = 0;
        } else {
            i23 = str9.hashCode();
        }
        int i38 = (i37 + i23) * 31;
        String str10 = this.androidId;
        if (str10 != null) {
            i24 = str10.hashCode();
        }
        return i38 + i24;
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [java.util.List<com.sift.api.representations.AndroidInstalledAppJson>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.sift.api.representations.AndroidDevicePropertiesJson> r1 = com.sift.api.representations.AndroidDevicePropertiesJson.class
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r5)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = "appName"
            r0.append(r1)
            r1 = 61
            r0.append(r1)
            java.lang.String r2 = r5.appName
            java.lang.String r3 = "<null>"
            if (r2 != 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r0.append(r2)
            r2 = 44
            r0.append(r2)
            java.lang.String r4 = "appVersion"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.appVersion
            if (r4 != 0) goto L_0x0049
            r4 = r3
        L_0x0049:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "sdkVersion"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.sdkVersion
            if (r4 != 0) goto L_0x005c
            r4 = r3
        L_0x005c:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "mobileCarrierName"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.mobileCarrierName
            if (r4 != 0) goto L_0x006f
            r4 = r3
        L_0x006f:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "mobileIsoCountryCode"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.mobileIsoCountryCode
            if (r4 != 0) goto L_0x0082
            r4 = r3
        L_0x0082:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "deviceManufacturer"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.deviceManufacturer
            if (r4 != 0) goto L_0x0095
            r4 = r3
        L_0x0095:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "deviceModel"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.deviceModel
            if (r4 != 0) goto L_0x00a8
            r4 = r3
        L_0x00a8:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "deviceSystemVersion"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.deviceSystemVersion
            if (r4 != 0) goto L_0x00bb
            r4 = r3
        L_0x00bb:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "androidId"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.androidId
            if (r4 != 0) goto L_0x00ce
            r4 = r3
        L_0x00ce:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "buildTags"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.buildTags
            if (r4 != 0) goto L_0x00e1
            r4 = r3
        L_0x00e1:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "evidenceFilesPresent"
            r0.append(r4)
            r0.append(r1)
            java.util.List<java.lang.String> r4 = r5.evidenceFilesPresent
            if (r4 != 0) goto L_0x00f4
            r4 = r3
        L_0x00f4:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "evidencePackagesPresent"
            r0.append(r4)
            r0.append(r1)
            java.util.List<java.lang.String> r4 = r5.evidencePackagesPresent
            if (r4 != 0) goto L_0x0107
            r4 = r3
        L_0x0107:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "evidenceProperties"
            r0.append(r4)
            r0.append(r1)
            java.util.List<java.lang.String> r4 = r5.evidenceProperties
            if (r4 != 0) goto L_0x011a
            r4 = r3
        L_0x011a:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "evidenceDirectoriesWritable"
            r0.append(r4)
            r0.append(r1)
            java.util.List<java.lang.String> r4 = r5.evidenceDirectoriesWritable
            if (r4 != 0) goto L_0x012d
            r4 = r3
        L_0x012d:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "installedApps"
            r0.append(r4)
            r0.append(r1)
            java.util.List<com.sift.api.representations.AndroidInstalledAppJson> r1 = r5.installedApps
            if (r1 != 0) goto L_0x0140
            goto L_0x0141
        L_0x0140:
            r3 = r1
        L_0x0141:
            r0.append(r3)
            r0.append(r2)
            int r1 = r0.length()
            int r1 = r1 + -1
            char r1 = r0.charAt(r1)
            r3 = 93
            if (r1 != r2) goto L_0x015f
            int r1 = r0.length()
            int r1 = r1 + -1
            r0.setCharAt(r1, r3)
            goto L_0x0162
        L_0x015f:
            r0.append(r3)
        L_0x0162:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sift.api.representations.AndroidDevicePropertiesJson.toString():java.lang.String");
    }

    public AndroidDevicePropertiesJson withAndroidId(String str) {
        this.androidId = str;
        return this;
    }

    public AndroidDevicePropertiesJson withAppName(String str) {
        this.appName = str;
        return this;
    }

    public AndroidDevicePropertiesJson withAppVersion(String str) {
        this.appVersion = str;
        return this;
    }

    public AndroidDevicePropertiesJson withBuildTags(String str) {
        this.buildTags = str;
        return this;
    }

    public AndroidDevicePropertiesJson withDeviceManufacturer(String str) {
        this.deviceManufacturer = str;
        return this;
    }

    public AndroidDevicePropertiesJson withDeviceModel(String str) {
        this.deviceModel = str;
        return this;
    }

    public AndroidDevicePropertiesJson withDeviceSystemVersion(String str) {
        this.deviceSystemVersion = str;
        return this;
    }

    public AndroidDevicePropertiesJson withEvidenceDirectoriesWritable(List<String> list) {
        this.evidenceDirectoriesWritable = list;
        return this;
    }

    public AndroidDevicePropertiesJson withEvidenceFilesPresent(List<String> list) {
        this.evidenceFilesPresent = list;
        return this;
    }

    public AndroidDevicePropertiesJson withEvidencePackagesPresent(List<String> list) {
        this.evidencePackagesPresent = list;
        return this;
    }

    public AndroidDevicePropertiesJson withEvidenceProperties(List<String> list) {
        this.evidenceProperties = list;
        return this;
    }

    public AndroidDevicePropertiesJson withInstalledApps(List<AndroidInstalledAppJson> list) {
        this.installedApps = list;
        return this;
    }

    public AndroidDevicePropertiesJson withMobileCarrierName(String str) {
        this.mobileCarrierName = str;
        return this;
    }

    public AndroidDevicePropertiesJson withMobileIsoCountryCode(String str) {
        this.mobileIsoCountryCode = str;
        return this;
    }

    public AndroidDevicePropertiesJson withSdkVersion(String str) {
        this.sdkVersion = str;
        return this;
    }
}
