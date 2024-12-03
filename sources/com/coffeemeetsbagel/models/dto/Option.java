package com.coffeemeetsbagel.models.dto;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Option implements Parcelable {
    public static final Parcelable.Creator<Option> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private final String f34717id;
    private final String name;
    private final String questionId;
    private final String title;

    public static final class Creator implements Parcelable.Creator<Option> {
        public final Option createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new Option(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Option[] newArray(int i10) {
            return new Option[i10];
        }
    }

    public Option(String str, String str2, String str3, String str4) {
        j.g(str, "id");
        j.g(str2, "questionId");
        j.g(str3, "title");
        this.f34717id = str;
        this.questionId = str2;
        this.title = str3;
        this.name = str4;
    }

    public static /* synthetic */ Option copy$default(Option option, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = option.f34717id;
        }
        if ((i10 & 2) != 0) {
            str2 = option.questionId;
        }
        if ((i10 & 4) != 0) {
            str3 = option.title;
        }
        if ((i10 & 8) != 0) {
            str4 = option.name;
        }
        return option.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f34717id;
    }

    public final String component2() {
        return this.questionId;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.name;
    }

    public final Option copy(String str, String str2, String str3, String str4) {
        j.g(str, "id");
        j.g(str2, "questionId");
        j.g(str3, "title");
        return new Option(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Option)) {
            return false;
        }
        Option option = (Option) obj;
        return j.b(this.f34717id, option.f34717id) && j.b(this.questionId, option.questionId) && j.b(this.title, option.title) && j.b(this.name, option.name);
    }

    public final String getId() {
        return this.f34717id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.f34717id.hashCode() * 31) + this.questionId.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.name;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Option(id=" + this.f34717id + ", questionId=" + this.questionId + ", title=" + this.title + ", name=" + this.name + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f34717id);
        parcel.writeString(this.questionId);
        parcel.writeString(this.title);
        parcel.writeString(this.name);
    }
}
