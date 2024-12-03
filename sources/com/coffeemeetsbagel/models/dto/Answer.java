package com.coffeemeetsbagel.models.dto;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Answer implements Parcelable {
    public static final Parcelable.Creator<Answer> CREATOR = new Creator();
    private final Float floatValue;

    /* renamed from: id  reason: collision with root package name */
    private final String f34716id;
    private final Integer integerValue;
    private final Boolean isDealbreaker;
    private final Location location;
    private final Float maxValue;
    private final Float minValue;
    private final String optionId;
    private final String profileId;
    private final String questionId;
    private final String textValue;

    public static final class Creator implements Parcelable.Creator<Answer> {
        public final Answer createFromParcel(Parcel parcel) {
            Boolean bool;
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Float valueOf2 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf3 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf4 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Location location = (Location) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Answer(readString, readString2, readString3, readString4, readString5, valueOf, valueOf2, valueOf3, valueOf4, location, bool);
        }

        public final Answer[] newArray(int i10) {
            return new Answer[i10];
        }
    }

    public Answer(String str, String str2, String str3, String str4, String str5, Integer num, Float f10, Float f11, Float f12, Location location2, Boolean bool) {
        j.g(str, "id");
        j.g(str3, "profileId");
        j.g(str4, "questionId");
        this.f34716id = str;
        this.optionId = str2;
        this.profileId = str3;
        this.questionId = str4;
        this.textValue = str5;
        this.integerValue = num;
        this.floatValue = f10;
        this.minValue = f11;
        this.maxValue = f12;
        this.location = location2;
        this.isDealbreaker = bool;
    }

    public static /* synthetic */ Answer copy$default(Answer answer, String str, String str2, String str3, String str4, String str5, Integer num, Float f10, Float f11, Float f12, Location location2, Boolean bool, int i10, Object obj) {
        Answer answer2 = answer;
        int i11 = i10;
        return answer.copy((i11 & 1) != 0 ? answer2.f34716id : str, (i11 & 2) != 0 ? answer2.optionId : str2, (i11 & 4) != 0 ? answer2.profileId : str3, (i11 & 8) != 0 ? answer2.questionId : str4, (i11 & 16) != 0 ? answer2.textValue : str5, (i11 & 32) != 0 ? answer2.integerValue : num, (i11 & 64) != 0 ? answer2.floatValue : f10, (i11 & 128) != 0 ? answer2.minValue : f11, (i11 & 256) != 0 ? answer2.maxValue : f12, (i11 & 512) != 0 ? answer2.location : location2, (i11 & 1024) != 0 ? answer2.isDealbreaker : bool);
    }

    public final String component1() {
        return this.f34716id;
    }

    public final Location component10() {
        return this.location;
    }

    public final Boolean component11() {
        return this.isDealbreaker;
    }

    public final String component2() {
        return this.optionId;
    }

    public final String component3() {
        return this.profileId;
    }

    public final String component4() {
        return this.questionId;
    }

    public final String component5() {
        return this.textValue;
    }

    public final Integer component6() {
        return this.integerValue;
    }

    public final Float component7() {
        return this.floatValue;
    }

    public final Float component8() {
        return this.minValue;
    }

    public final Float component9() {
        return this.maxValue;
    }

    public final Answer copy(String str, String str2, String str3, String str4, String str5, Integer num, Float f10, Float f11, Float f12, Location location2, Boolean bool) {
        j.g(str, "id");
        String str6 = str3;
        j.g(str6, "profileId");
        String str7 = str4;
        j.g(str7, "questionId");
        return new Answer(str, str2, str6, str7, str5, num, f10, f11, f12, location2, bool);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) obj;
        return j.b(this.f34716id, answer.f34716id) && j.b(this.optionId, answer.optionId) && j.b(this.profileId, answer.profileId) && j.b(this.questionId, answer.questionId) && j.b(this.textValue, answer.textValue) && j.b(this.integerValue, answer.integerValue) && j.b(this.floatValue, answer.floatValue) && j.b(this.minValue, answer.minValue) && j.b(this.maxValue, answer.maxValue) && j.b(this.location, answer.location) && j.b(this.isDealbreaker, answer.isDealbreaker);
    }

    public final Float getFloatValue() {
        return this.floatValue;
    }

    public final String getId() {
        return this.f34716id;
    }

    public final Integer getIntegerValue() {
        return this.integerValue;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final Float getMaxValue() {
        return this.maxValue;
    }

    public final Float getMinValue() {
        return this.minValue;
    }

    public final String getOptionId() {
        return this.optionId;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getTextValue() {
        return this.textValue;
    }

    public int hashCode() {
        int hashCode = this.f34716id.hashCode() * 31;
        String str = this.optionId;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.profileId.hashCode()) * 31) + this.questionId.hashCode()) * 31;
        String str2 = this.textValue;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.integerValue;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Float f10 = this.floatValue;
        int hashCode5 = (hashCode4 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.minValue;
        int hashCode6 = (hashCode5 + (f11 == null ? 0 : f11.hashCode())) * 31;
        Float f12 = this.maxValue;
        int hashCode7 = (hashCode6 + (f12 == null ? 0 : f12.hashCode())) * 31;
        Location location2 = this.location;
        int hashCode8 = (hashCode7 + (location2 == null ? 0 : location2.hashCode())) * 31;
        Boolean bool = this.isDealbreaker;
        if (bool != null) {
            i10 = bool.hashCode();
        }
        return hashCode8 + i10;
    }

    public final Boolean isDealbreaker() {
        return this.isDealbreaker;
    }

    public String toString() {
        return "Answer(id=" + this.f34716id + ", optionId=" + this.optionId + ", profileId=" + this.profileId + ", questionId=" + this.questionId + ", textValue=" + this.textValue + ", integerValue=" + this.integerValue + ", floatValue=" + this.floatValue + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", location=" + this.location + ", isDealbreaker=" + this.isDealbreaker + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f34716id);
        parcel.writeString(this.optionId);
        parcel.writeString(this.profileId);
        parcel.writeString(this.questionId);
        parcel.writeString(this.textValue);
        Integer num = this.integerValue;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Float f10 = this.floatValue;
        if (f10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f10.floatValue());
        }
        Float f11 = this.minValue;
        if (f11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f11.floatValue());
        }
        Float f12 = this.maxValue;
        if (f12 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f12.floatValue());
        }
        parcel.writeSerializable(this.location);
        Boolean bool = this.isDealbreaker;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Answer(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, java.lang.Float r22, java.lang.Float r23, java.lang.Float r24, com.coffeemeetsbagel.models.dto.Location r25, java.lang.Boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000b
        L_0x0009:
            r5 = r17
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0011
            r8 = r2
            goto L_0x0013
        L_0x0011:
            r8 = r20
        L_0x0013:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0019
            r9 = r2
            goto L_0x001b
        L_0x0019:
            r9 = r21
        L_0x001b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0021
            r10 = r2
            goto L_0x0023
        L_0x0021:
            r10 = r22
        L_0x0023:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0029
            r11 = r2
            goto L_0x002b
        L_0x0029:
            r11 = r23
        L_0x002b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0031
            r12 = r2
            goto L_0x0033
        L_0x0031:
            r12 = r24
        L_0x0033:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0039
            r13 = r2
            goto L_0x003b
        L_0x0039:
            r13 = r25
        L_0x003b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0043
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14 = r0
            goto L_0x0045
        L_0x0043:
            r14 = r26
        L_0x0045:
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r19
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.models.dto.Answer.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Float, java.lang.Float, java.lang.Float, com.coffeemeetsbagel.models.dto.Location, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
