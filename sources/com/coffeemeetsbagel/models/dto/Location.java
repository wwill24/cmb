package com.coffeemeetsbagel.models.dto;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Location implements Serializable {
    private final String city;
    private final String country;
    private final Float latitude;
    private final Float longitude;
    private final String state;
    private final String zip;

    public Location() {
        this((String) null, (String) null, (String) null, (String) null, (Float) null, (Float) null, 63, (DefaultConstructorMarker) null);
    }

    public Location(String str, String str2, String str3, String str4, Float f10, Float f11) {
        this.city = str;
        this.state = str2;
        this.country = str3;
        this.zip = str4;
        this.latitude = f10;
        this.longitude = f11;
    }

    public static /* synthetic */ Location copy$default(Location location, String str, String str2, String str3, String str4, Float f10, Float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = location.city;
        }
        if ((i10 & 2) != 0) {
            str2 = location.state;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = location.country;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = location.zip;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            f10 = location.latitude;
        }
        Float f12 = f10;
        if ((i10 & 32) != 0) {
            f11 = location.longitude;
        }
        return location.copy(str, str5, str6, str7, f12, f11);
    }

    public final String component1() {
        return this.city;
    }

    public final String component2() {
        return this.state;
    }

    public final String component3() {
        return this.country;
    }

    public final String component4() {
        return this.zip;
    }

    public final Float component5() {
        return this.latitude;
    }

    public final Float component6() {
        return this.longitude;
    }

    public final Location copy(String str, String str2, String str3, String str4, Float f10, Float f11) {
        return new Location(str, str2, str3, str4, f10, f11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location location = (Location) obj;
        return j.b(this.city, location.city) && j.b(this.state, location.state) && j.b(this.country, location.country) && j.b(this.zip, location.zip) && j.b(this.latitude, location.latitude) && j.b(this.longitude, location.longitude);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final Float getLatitude() {
        return this.latitude;
    }

    public final Float getLongitude() {
        return this.longitude;
    }

    public final String getState() {
        return this.state;
    }

    public final String getZip() {
        return this.zip;
    }

    public int hashCode() {
        String str = this.city;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.state;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.country;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zip;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f10 = this.latitude;
        int hashCode5 = (hashCode4 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.longitude;
        if (f11 != null) {
            i10 = f11.hashCode();
        }
        return hashCode5 + i10;
    }

    public String toString() {
        return "Location(city=" + this.city + ", state=" + this.state + ", country=" + this.country + ", zip=" + this.zip + ", latitude=" + this.latitude + ", longitude=" + this.longitude + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Location(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.Float r10, java.lang.Float r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.dto.Location.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
