package com.coffeemeetsbagel.qna.data.network;

import java.io.Serializable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AnswerJson implements Serializable {
    private final String city;
    private final String country;
    private final Float latitude;
    private final Float longitude;
    private final String state;
    private final String type;
    private final String zipcode;

    public AnswerJson(String str, Float f10, Float f11, String str2, String str3, String str4, String str5) {
        j.g(str, "type");
        this.type = str;
        this.latitude = f10;
        this.longitude = f11;
        this.city = str2;
        this.state = str3;
        this.country = str4;
        this.zipcode = str5;
    }

    public static /* synthetic */ AnswerJson copy$default(AnswerJson answerJson, String str, Float f10, Float f11, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = answerJson.type;
        }
        if ((i10 & 2) != 0) {
            f10 = answerJson.latitude;
        }
        Float f12 = f10;
        if ((i10 & 4) != 0) {
            f11 = answerJson.longitude;
        }
        Float f13 = f11;
        if ((i10 & 8) != 0) {
            str2 = answerJson.city;
        }
        String str6 = str2;
        if ((i10 & 16) != 0) {
            str3 = answerJson.state;
        }
        String str7 = str3;
        if ((i10 & 32) != 0) {
            str4 = answerJson.country;
        }
        String str8 = str4;
        if ((i10 & 64) != 0) {
            str5 = answerJson.zipcode;
        }
        return answerJson.copy(str, f12, f13, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.type;
    }

    public final Float component2() {
        return this.latitude;
    }

    public final Float component3() {
        return this.longitude;
    }

    public final String component4() {
        return this.city;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.country;
    }

    public final String component7() {
        return this.zipcode;
    }

    public final AnswerJson copy(String str, Float f10, Float f11, String str2, String str3, String str4, String str5) {
        j.g(str, "type");
        return new AnswerJson(str, f10, f11, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnswerJson)) {
            return false;
        }
        AnswerJson answerJson = (AnswerJson) obj;
        return j.b(this.type, answerJson.type) && j.b(this.latitude, answerJson.latitude) && j.b(this.longitude, answerJson.longitude) && j.b(this.city, answerJson.city) && j.b(this.state, answerJson.state) && j.b(this.country, answerJson.country) && j.b(this.zipcode, answerJson.zipcode);
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

    public final String getType() {
        return this.type;
    }

    public final String getZipcode() {
        return this.zipcode;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Float f10 = this.latitude;
        int i10 = 0;
        int hashCode2 = (hashCode + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.longitude;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str = this.city;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.state;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.country;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zipcode;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode6 + i10;
    }

    public String toString() {
        return "AnswerJson(type=" + this.type + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", city=" + this.city + ", state=" + this.state + ", country=" + this.country + ", zipcode=" + this.zipcode + PropertyUtils.MAPPED_DELIM2;
    }
}
