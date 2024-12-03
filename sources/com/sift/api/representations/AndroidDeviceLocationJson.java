package com.sift.api.representations;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import lg.a;
import lg.c;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;

public class AndroidDeviceLocationJson {
    @a
    @c("latitude")
    public Double latitude;
    @a
    @c("longitude")
    public Double longitude;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidDeviceLocationJson)) {
            return false;
        }
        AndroidDeviceLocationJson androidDeviceLocationJson = (AndroidDeviceLocationJson) obj;
        Double d10 = this.latitude;
        Double d11 = androidDeviceLocationJson.latitude;
        if (d10 == d11 || (d10 != null && d10.equals(d11))) {
            Double d12 = this.longitude;
            Double d13 = androidDeviceLocationJson.longitude;
            if (d12 == d13) {
                return true;
            }
            if (d12 != null && d12.equals(d13)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        Double d10 = this.latitude;
        int i11 = 0;
        if (d10 == null) {
            i10 = 0;
        } else {
            i10 = d10.hashCode();
        }
        int i12 = (i10 + 31) * 31;
        Double d11 = this.longitude;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AndroidDeviceLocationJson.class.getName());
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append('[');
        sb2.append(ProfileConstants.Field.LATITUDE);
        sb2.append(SignatureVisitor.INSTANCEOF);
        Object obj = this.latitude;
        Object obj2 = "<null>";
        if (obj == null) {
            obj = obj2;
        }
        sb2.append(obj);
        sb2.append(',');
        sb2.append(ProfileConstants.Field.LONGITUDE);
        sb2.append(SignatureVisitor.INSTANCEOF);
        Object obj3 = this.longitude;
        if (obj3 != null) {
            obj2 = obj3;
        }
        sb2.append(obj2);
        sb2.append(',');
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.setCharAt(sb2.length() - 1, PropertyUtils.INDEXED_DELIM2);
        } else {
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        return sb2.toString();
    }

    public AndroidDeviceLocationJson withLatitude(Double d10) {
        this.latitude = d10;
        return this;
    }

    public AndroidDeviceLocationJson withLongitude(Double d10) {
        this.longitude = d10;
        return this;
    }
}
