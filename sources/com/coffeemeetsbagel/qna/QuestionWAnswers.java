package com.coffeemeetsbagel.qna;

import android.os.Parcel;
import android.os.Parcelable;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Question;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class QuestionWAnswers implements Parcelable {
    public static final Parcelable.Creator<QuestionWAnswers> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Question f36220a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Answer> f36221b;

    public static final class a implements Parcelable.Creator<QuestionWAnswers> {
        /* renamed from: a */
        public final QuestionWAnswers createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            Question createFromParcel = Question.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i10 = 0; i10 != readInt; i10++) {
                arrayList.add(Answer.CREATOR.createFromParcel(parcel));
            }
            return new QuestionWAnswers(createFromParcel, arrayList);
        }

        /* renamed from: b */
        public final QuestionWAnswers[] newArray(int i10) {
            return new QuestionWAnswers[i10];
        }
    }

    public QuestionWAnswers(Question question, List<Answer> list) {
        j.g(question, "question");
        j.g(list, "answers");
        this.f36220a = question;
        this.f36221b = list;
    }

    public final Question a() {
        return this.f36220a;
    }

    public final List<Answer> c() {
        return this.f36221b;
    }

    public final List<Answer> d() {
        return this.f36221b;
    }

    public int describeContents() {
        return 0;
    }

    public final Question e() {
        return this.f36220a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionWAnswers)) {
            return false;
        }
        QuestionWAnswers questionWAnswers = (QuestionWAnswers) obj;
        return j.b(this.f36220a, questionWAnswers.f36220a) && j.b(this.f36221b, questionWAnswers.f36221b);
    }

    public int hashCode() {
        return (this.f36220a.hashCode() * 31) + this.f36221b.hashCode();
    }

    public String toString() {
        return "QuestionWAnswers(question=" + this.f36220a + ", answers=" + this.f36221b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        this.f36220a.writeToParcel(parcel, i10);
        List<Answer> list = this.f36221b;
        parcel.writeInt(list.size());
        for (Answer writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i10);
        }
    }
}
