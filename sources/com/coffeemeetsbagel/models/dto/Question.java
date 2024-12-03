package com.coffeemeetsbagel.models.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class Question implements Parcelable {
    public static final Parcelable.Creator<Question> CREATOR = new Creator();
    private final QuestionGroupType group;

    /* renamed from: id  reason: collision with root package name */
    private final String f34718id;
    private final QuestionInteractionPolicy interactionPolicy;
    private final String label;
    private final String name;
    private final List<Option> options;
    private final String placeholder;
    private final String text;
    private final QuestionType type;

    public static final class Creator implements Parcelable.Creator<Question> {
        public final Question createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            QuestionGroupType valueOf = QuestionGroupType.valueOf(parcel.readString());
            String readString3 = parcel.readString();
            QuestionType valueOf2 = QuestionType.valueOf(parcel.readString());
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(Option.CREATOR.createFromParcel(parcel));
            }
            return new Question(readString, readString2, valueOf, readString3, valueOf2, readString4, readString5, arrayList, (QuestionInteractionPolicy) parcel.readSerializable());
        }

        public final Question[] newArray(int i10) {
            return new Question[i10];
        }
    }

    public Question(String str, String str2, QuestionGroupType questionGroupType, String str3, QuestionType questionType, String str4, String str5, List<Option> list, QuestionInteractionPolicy questionInteractionPolicy) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(questionGroupType, "group");
        j.g(questionType, "type");
        j.g(str4, "label");
        j.g(str5, "text");
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.f34718id = str;
        this.name = str2;
        this.group = questionGroupType;
        this.placeholder = str3;
        this.type = questionType;
        this.label = str4;
        this.text = str5;
        this.options = list;
        this.interactionPolicy = questionInteractionPolicy;
    }

    public static /* synthetic */ Question copy$default(Question question, String str, String str2, QuestionGroupType questionGroupType, String str3, QuestionType questionType, String str4, String str5, List list, QuestionInteractionPolicy questionInteractionPolicy, int i10, Object obj) {
        Question question2 = question;
        int i11 = i10;
        return question.copy((i11 & 1) != 0 ? question2.f34718id : str, (i11 & 2) != 0 ? question2.name : str2, (i11 & 4) != 0 ? question2.group : questionGroupType, (i11 & 8) != 0 ? question2.placeholder : str3, (i11 & 16) != 0 ? question2.type : questionType, (i11 & 32) != 0 ? question2.label : str4, (i11 & 64) != 0 ? question2.text : str5, (i11 & 128) != 0 ? question2.options : list, (i11 & 256) != 0 ? question2.interactionPolicy : questionInteractionPolicy);
    }

    public final String component1() {
        return this.f34718id;
    }

    public final String component2() {
        return this.name;
    }

    public final QuestionGroupType component3() {
        return this.group;
    }

    public final String component4() {
        return this.placeholder;
    }

    public final QuestionType component5() {
        return this.type;
    }

    public final String component6() {
        return this.label;
    }

    public final String component7() {
        return this.text;
    }

    public final List<Option> component8() {
        return this.options;
    }

    public final QuestionInteractionPolicy component9() {
        return this.interactionPolicy;
    }

    public final Question copy(String str, String str2, QuestionGroupType questionGroupType, String str3, QuestionType questionType, String str4, String str5, List<Option> list, QuestionInteractionPolicy questionInteractionPolicy) {
        j.g(str, "id");
        j.g(str2, "name");
        j.g(questionGroupType, "group");
        QuestionType questionType2 = questionType;
        j.g(questionType2, "type");
        String str6 = str4;
        j.g(str6, "label");
        String str7 = str5;
        j.g(str7, "text");
        List<Option> list2 = list;
        j.g(list2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new Question(str, str2, questionGroupType, str3, questionType2, str6, str7, list2, questionInteractionPolicy);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question question = (Question) obj;
        return j.b(this.f34718id, question.f34718id) && j.b(this.name, question.name) && this.group == question.group && j.b(this.placeholder, question.placeholder) && this.type == question.type && j.b(this.label, question.label) && j.b(this.text, question.text) && j.b(this.options, question.options) && j.b(this.interactionPolicy, question.interactionPolicy);
    }

    public final QuestionGroupType getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.f34718id;
    }

    public final QuestionInteractionPolicy getInteractionPolicy() {
        return this.interactionPolicy;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Option> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getText() {
        return this.text;
    }

    public final QuestionType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((this.f34718id.hashCode() * 31) + this.name.hashCode()) * 31) + this.group.hashCode()) * 31;
        String str = this.placeholder;
        int i10 = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.label.hashCode()) * 31) + this.text.hashCode()) * 31) + this.options.hashCode()) * 31;
        QuestionInteractionPolicy questionInteractionPolicy = this.interactionPolicy;
        if (questionInteractionPolicy != null) {
            i10 = questionInteractionPolicy.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "Question(id=" + this.f34718id + ", name=" + this.name + ", group=" + this.group + ", placeholder=" + this.placeholder + ", type=" + this.type + ", label=" + this.label + ", text=" + this.text + ", options=" + this.options + ", interactionPolicy=" + this.interactionPolicy + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f34718id);
        parcel.writeString(this.name);
        parcel.writeString(this.group.name());
        parcel.writeString(this.placeholder);
        parcel.writeString(this.type.name());
        parcel.writeString(this.label);
        parcel.writeString(this.text);
        List<Option> list = this.options;
        parcel.writeInt(list.size());
        for (Option writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i10);
        }
        parcel.writeSerializable(this.interactionPolicy);
    }
}
