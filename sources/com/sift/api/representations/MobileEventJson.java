package com.sift.api.representations;

import java.util.Map;
import lg.a;
import lg.c;

public class MobileEventJson {
    @a
    @c("android_app_state")
    public AndroidAppStateJson androidAppState;
    @a
    @c("android_device_properties")
    public AndroidDevicePropertiesJson androidDeviceProperties;
    @a
    @c("device_properties")
    public Map<String, String> deviceProperties;
    @a
    @c("fields")
    public Map<String, String> fields;
    @a
    @c("installation_id")
    public String installationId;
    @a
    @c("mobile_event_type")
    public String mobileEventType;
    @a
    @c("path")
    public String path;
    @a
    @c("time")
    public Long time;
    @a
    @c("user_id")
    public String userId;

    public boolean equals(Object obj) {
        AndroidDevicePropertiesJson androidDevicePropertiesJson;
        AndroidDevicePropertiesJson androidDevicePropertiesJson2;
        String str;
        String str2;
        AndroidAppStateJson androidAppStateJson;
        AndroidAppStateJson androidAppStateJson2;
        Map<String, String> map;
        Map<String, String> map2;
        Long l10;
        Long l11;
        String str3;
        String str4;
        Map<String, String> map3;
        Map<String, String> map4;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MobileEventJson)) {
            return false;
        }
        MobileEventJson mobileEventJson = (MobileEventJson) obj;
        String str5 = this.mobileEventType;
        String str6 = mobileEventJson.mobileEventType;
        if ((str5 == str6 || (str5 != null && str5.equals(str6))) && (((androidDevicePropertiesJson = this.androidDeviceProperties) == (androidDevicePropertiesJson2 = mobileEventJson.androidDeviceProperties) || (androidDevicePropertiesJson != null && androidDevicePropertiesJson.equals(androidDevicePropertiesJson2))) && (((str = this.path) == (str2 = mobileEventJson.path) || (str != null && str.equals(str2))) && (((androidAppStateJson = this.androidAppState) == (androidAppStateJson2 = mobileEventJson.androidAppState) || (androidAppStateJson != null && androidAppStateJson.equals(androidAppStateJson2))) && (((map = this.deviceProperties) == (map2 = mobileEventJson.deviceProperties) || (map != null && map.equals(map2))) && (((l10 = this.time) == (l11 = mobileEventJson.time) || (l10 != null && l10.equals(l11))) && (((str3 = this.installationId) == (str4 = mobileEventJson.installationId) || (str3 != null && str3.equals(str4))) && ((map3 = this.fields) == (map4 = mobileEventJson.fields) || (map3 != null && map3.equals(map4)))))))))) {
            String str7 = this.userId;
            String str8 = mobileEventJson.userId;
            if (str7 == str8) {
                return true;
            }
            if (str7 != null && str7.equals(str8)) {
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
        String str = this.mobileEventType;
        int i18 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i19 = (i10 + 31) * 31;
        AndroidDevicePropertiesJson androidDevicePropertiesJson = this.androidDeviceProperties;
        if (androidDevicePropertiesJson == null) {
            i11 = 0;
        } else {
            i11 = androidDevicePropertiesJson.hashCode();
        }
        int i20 = (i19 + i11) * 31;
        String str2 = this.path;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i21 = (i20 + i12) * 31;
        AndroidAppStateJson androidAppStateJson = this.androidAppState;
        if (androidAppStateJson == null) {
            i13 = 0;
        } else {
            i13 = androidAppStateJson.hashCode();
        }
        int i22 = (i21 + i13) * 31;
        Map<String, String> map = this.deviceProperties;
        if (map == null) {
            i14 = 0;
        } else {
            i14 = map.hashCode();
        }
        int i23 = (i22 + i14) * 31;
        Long l10 = this.time;
        if (l10 == null) {
            i15 = 0;
        } else {
            i15 = l10.hashCode();
        }
        int i24 = (i23 + i15) * 31;
        String str3 = this.installationId;
        if (str3 == null) {
            i16 = 0;
        } else {
            i16 = str3.hashCode();
        }
        int i25 = (i24 + i16) * 31;
        Map<String, String> map2 = this.fields;
        if (map2 == null) {
            i17 = 0;
        } else {
            i17 = map2.hashCode();
        }
        int i26 = (i25 + i17) * 31;
        String str4 = this.userId;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i26 + i18;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Long} */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.sift.api.representations.MobileEventJson> r1 = com.sift.api.representations.MobileEventJson.class
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r5)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = "time"
            r0.append(r1)
            r1 = 61
            r0.append(r1)
            java.lang.Long r2 = r5.time
            java.lang.String r3 = "<null>"
            if (r2 != 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r0.append(r2)
            r2 = 44
            r0.append(r2)
            java.lang.String r4 = "path"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.path
            if (r4 != 0) goto L_0x0049
            r4 = r3
        L_0x0049:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "mobileEventType"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.mobileEventType
            if (r4 != 0) goto L_0x005c
            r4 = r3
        L_0x005c:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "userId"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.userId
            if (r4 != 0) goto L_0x006f
            r4 = r3
        L_0x006f:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "installationId"
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = r5.installationId
            if (r4 != 0) goto L_0x0082
            r4 = r3
        L_0x0082:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "fields"
            r0.append(r4)
            r0.append(r1)
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.fields
            if (r4 != 0) goto L_0x0095
            r4 = r3
        L_0x0095:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "deviceProperties"
            r0.append(r4)
            r0.append(r1)
            java.util.Map<java.lang.String, java.lang.String> r4 = r5.deviceProperties
            if (r4 != 0) goto L_0x00a8
            r4 = r3
        L_0x00a8:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "androidDeviceProperties"
            r0.append(r4)
            r0.append(r1)
            com.sift.api.representations.AndroidDevicePropertiesJson r4 = r5.androidDeviceProperties
            if (r4 != 0) goto L_0x00bb
            r4 = r3
        L_0x00bb:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "androidAppState"
            r0.append(r4)
            r0.append(r1)
            com.sift.api.representations.AndroidAppStateJson r1 = r5.androidAppState
            if (r1 != 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r3 = r1
        L_0x00cf:
            r0.append(r3)
            r0.append(r2)
            int r1 = r0.length()
            int r1 = r1 + -1
            char r1 = r0.charAt(r1)
            r3 = 93
            if (r1 != r2) goto L_0x00ed
            int r1 = r0.length()
            int r1 = r1 + -1
            r0.setCharAt(r1, r3)
            goto L_0x00f0
        L_0x00ed:
            r0.append(r3)
        L_0x00f0:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sift.api.representations.MobileEventJson.toString():java.lang.String");
    }

    public MobileEventJson withAndroidAppState(AndroidAppStateJson androidAppStateJson) {
        this.androidAppState = androidAppStateJson;
        return this;
    }

    public MobileEventJson withAndroidDeviceProperties(AndroidDevicePropertiesJson androidDevicePropertiesJson) {
        this.androidDeviceProperties = androidDevicePropertiesJson;
        return this;
    }

    public MobileEventJson withDeviceProperties(Map<String, String> map) {
        this.deviceProperties = map;
        return this;
    }

    public MobileEventJson withFields(Map<String, String> map) {
        this.fields = map;
        return this;
    }

    public MobileEventJson withInstallationId(String str) {
        this.installationId = str;
        return this;
    }

    public MobileEventJson withMobileEventType(String str) {
        this.mobileEventType = str;
        return this;
    }

    public MobileEventJson withPath(String str) {
        this.path = str;
        return this;
    }

    public MobileEventJson withTime(Long l10) {
        this.time = l10;
        return this;
    }

    public MobileEventJson withUserId(String str) {
        this.userId = str;
        return this;
    }
}
