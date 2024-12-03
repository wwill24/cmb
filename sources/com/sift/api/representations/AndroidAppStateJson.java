package com.sift.api.representations;

import java.util.ArrayList;
import java.util.List;
import lg.a;
import lg.c;

public class AndroidAppStateJson {
    @a
    @c("activity_class_name")
    public String activityClassName;
    @a
    @c("battery_health")
    public Long batteryHealth;
    @a
    @c("battery_level")
    public Double batteryLevel;
    @a
    @c("battery_state")
    public Long batteryState;
    @a
    @c("location")
    public AndroidDeviceLocationJson location;
    @a
    @c("network_addresses")
    public List<String> networkAddresses = new ArrayList();
    @a
    @c("plug_state")
    public Long plugState;
    @a
    @c("sdk_version")
    public String sdkVersion;

    public boolean equals(Object obj) {
        Long l10;
        Long l11;
        String str;
        String str2;
        AndroidDeviceLocationJson androidDeviceLocationJson;
        AndroidDeviceLocationJson androidDeviceLocationJson2;
        String str3;
        String str4;
        Long l12;
        Long l13;
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidAppStateJson)) {
            return false;
        }
        AndroidAppStateJson androidAppStateJson = (AndroidAppStateJson) obj;
        Long l14 = this.plugState;
        Long l15 = androidAppStateJson.plugState;
        if ((l14 == l15 || (l14 != null && l14.equals(l15))) && (((l10 = this.batteryState) == (l11 = androidAppStateJson.batteryState) || (l10 != null && l10.equals(l11))) && (((str = this.activityClassName) == (str2 = androidAppStateJson.activityClassName) || (str != null && str.equals(str2))) && (((androidDeviceLocationJson = this.location) == (androidDeviceLocationJson2 = androidAppStateJson.location) || (androidDeviceLocationJson != null && androidDeviceLocationJson.equals(androidDeviceLocationJson2))) && (((str3 = this.sdkVersion) == (str4 = androidAppStateJson.sdkVersion) || (str3 != null && str3.equals(str4))) && (((l12 = this.batteryHealth) == (l13 = androidAppStateJson.batteryHealth) || (l12 != null && l12.equals(l13))) && ((list = this.networkAddresses) == (list2 = androidAppStateJson.networkAddresses) || (list != null && list.equals(list2))))))))) {
            Double d10 = this.batteryLevel;
            Double d11 = androidAppStateJson.batteryLevel;
            if (d10 == d11) {
                return true;
            }
            if (d10 != null && d10.equals(d11)) {
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
        Long l10 = this.plugState;
        int i17 = 0;
        if (l10 == null) {
            i10 = 0;
        } else {
            i10 = l10.hashCode();
        }
        int i18 = (i10 + 31) * 31;
        Long l11 = this.batteryState;
        if (l11 == null) {
            i11 = 0;
        } else {
            i11 = l11.hashCode();
        }
        int i19 = (i18 + i11) * 31;
        String str = this.activityClassName;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i20 = (i19 + i12) * 31;
        AndroidDeviceLocationJson androidDeviceLocationJson = this.location;
        if (androidDeviceLocationJson == null) {
            i13 = 0;
        } else {
            i13 = androidDeviceLocationJson.hashCode();
        }
        int i21 = (i20 + i13) * 31;
        String str2 = this.sdkVersion;
        if (str2 == null) {
            i14 = 0;
        } else {
            i14 = str2.hashCode();
        }
        int i22 = (i21 + i14) * 31;
        Long l12 = this.batteryHealth;
        if (l12 == null) {
            i15 = 0;
        } else {
            i15 = l12.hashCode();
        }
        int i23 = (i22 + i15) * 31;
        List<String> list = this.networkAddresses;
        if (list == null) {
            i16 = 0;
        } else {
            i16 = list.hashCode();
        }
        int i24 = (i23 + i16) * 31;
        Double d10 = this.batteryLevel;
        if (d10 != null) {
            i17 = d10.hashCode();
        }
        return i24 + i17;
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class<com.sift.api.representations.AndroidAppStateJson> r1 = com.sift.api.representations.AndroidAppStateJson.class
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r5)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = "activityClassName"
            r0.append(r1)
            r1 = 61
            r0.append(r1)
            java.lang.String r2 = r5.activityClassName
            java.lang.String r3 = "<null>"
            if (r2 != 0) goto L_0x0034
            r2 = r3
        L_0x0034:
            r0.append(r2)
            r2 = 44
            r0.append(r2)
            java.lang.String r4 = "location"
            r0.append(r4)
            r0.append(r1)
            com.sift.api.representations.AndroidDeviceLocationJson r4 = r5.location
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
            java.lang.String r4 = "batteryLevel"
            r0.append(r4)
            r0.append(r1)
            java.lang.Double r4 = r5.batteryLevel
            if (r4 != 0) goto L_0x006f
            r4 = r3
        L_0x006f:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "batteryState"
            r0.append(r4)
            r0.append(r1)
            java.lang.Long r4 = r5.batteryState
            if (r4 != 0) goto L_0x0082
            r4 = r3
        L_0x0082:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "batteryHealth"
            r0.append(r4)
            r0.append(r1)
            java.lang.Long r4 = r5.batteryHealth
            if (r4 != 0) goto L_0x0095
            r4 = r3
        L_0x0095:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "plugState"
            r0.append(r4)
            r0.append(r1)
            java.lang.Long r4 = r5.plugState
            if (r4 != 0) goto L_0x00a8
            r4 = r3
        L_0x00a8:
            r0.append(r4)
            r0.append(r2)
            java.lang.String r4 = "networkAddresses"
            r0.append(r4)
            r0.append(r1)
            java.util.List<java.lang.String> r1 = r5.networkAddresses
            if (r1 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r3 = r1
        L_0x00bc:
            r0.append(r3)
            r0.append(r2)
            int r1 = r0.length()
            int r1 = r1 + -1
            char r1 = r0.charAt(r1)
            r3 = 93
            if (r1 != r2) goto L_0x00da
            int r1 = r0.length()
            int r1 = r1 + -1
            r0.setCharAt(r1, r3)
            goto L_0x00dd
        L_0x00da:
            r0.append(r3)
        L_0x00dd:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sift.api.representations.AndroidAppStateJson.toString():java.lang.String");
    }

    public AndroidAppStateJson withActivityClassName(String str) {
        this.activityClassName = str;
        return this;
    }

    public AndroidAppStateJson withBatteryHealth(Long l10) {
        this.batteryHealth = l10;
        return this;
    }

    public AndroidAppStateJson withBatteryLevel(Double d10) {
        this.batteryLevel = d10;
        return this;
    }

    public AndroidAppStateJson withBatteryState(Long l10) {
        this.batteryState = l10;
        return this;
    }

    public AndroidAppStateJson withLocation(AndroidDeviceLocationJson androidDeviceLocationJson) {
        this.location = androidDeviceLocationJson;
        return this;
    }

    public AndroidAppStateJson withNetworkAddresses(List<String> list) {
        this.networkAddresses = list;
        return this;
    }

    public AndroidAppStateJson withPlugState(Long l10) {
        this.plugState = l10;
        return this;
    }

    public AndroidAppStateJson withSdkVersion(String str) {
        this.sdkVersion = str;
        return this;
    }
}
