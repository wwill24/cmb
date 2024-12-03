package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.dto.Question;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.coffeemeetsbagel.models.responses.ResponseQuestionGroup;
import com.coffeemeetsbagel.qna.data.network.AnswerJson;
import com.coffeemeetsbagel.qna.data.network.AnswerType;
import com.coffeemeetsbagel.qna.data.network.NetworkAnswer;
import com.coffeemeetsbagel.qna.data.network.NetworkOption;
import com.coffeemeetsbagel.qna.data.network.NetworkPeriodicQuestion;
import com.coffeemeetsbagel.qna.data.network.NetworkPeriodicQuestionGroup;
import com.coffeemeetsbagel.qna.data.network.NetworkQuestion;
import com.coffeemeetsbagel.qna.data.network.NetworkQuestionGroup;
import com.coffeemeetsbagel.qna.data.network.QuestionGroupInteractionPolicy;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import za.b;
import za.c;
import za.f;
import za.g;

public final class r {
    public static final List<b> a(NetworkAnswer networkAnswer, String str) {
        boolean z10;
        String str2;
        Location location;
        String str3;
        Location location2;
        j.g(networkAnswer, "<this>");
        j.g(str, "profileId");
        List<String> optionIds = networkAnswer.getOptionIds();
        boolean z11 = false;
        if (optionIds == null || optionIds.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String id2 = networkAnswer.getId();
            String questionId = networkAnswer.getQuestionId();
            String textValue = networkAnswer.getTextValue();
            if (textValue == null || r.w(textValue)) {
                z11 = true;
            }
            if (z11) {
                str2 = "";
            } else {
                str2 = networkAnswer.getTextValue();
                j.d(str2);
            }
            String str4 = str2;
            Integer integerValue = networkAnswer.getIntegerValue();
            Float floatValue = networkAnswer.getFloatValue();
            Float minValue = networkAnswer.getMinValue();
            Float maxValue = networkAnswer.getMaxValue();
            AnswerJson jsonValue = networkAnswer.getJsonValue();
            if (jsonValue != null) {
                if (j.b(jsonValue.getType(), AnswerType.LOCATION.getApiString())) {
                    location2 = new Location(jsonValue.getCity(), jsonValue.getState(), jsonValue.getCountry(), jsonValue.getZipcode(), jsonValue.getLatitude(), jsonValue.getLongitude());
                } else {
                    location2 = null;
                }
                location = location2;
            } else {
                location = null;
            }
            AnswerJson jsonValue2 = networkAnswer.getJsonValue();
            if (jsonValue2 != null) {
                str3 = jsonValue2.getType();
            } else {
                str3 = null;
            }
            return p.e(new b(id2, (String) null, str, questionId, str4, integerValue, floatValue, maxValue, minValue, location, networkAnswer.isDealbreaker(), str3, 2, (DefaultConstructorMarker) null));
        }
        List<String> optionIds2 = networkAnswer.getOptionIds();
        j.d(optionIds2);
        ArrayList arrayList = new ArrayList(r.t(optionIds2, 10));
        for (String bVar : optionIds2) {
            b bVar2 = r2;
            b bVar3 = new b(networkAnswer.getId(), bVar, str, networkAnswer.getQuestionId(), (String) null, (Integer) null, (Float) null, (Float) null, (Float) null, (Location) null, networkAnswer.isDealbreaker(), (String) null, 3056, (DefaultConstructorMarker) null);
            ArrayList arrayList2 = arrayList;
            arrayList2.add(bVar2);
            String str5 = str;
            arrayList = arrayList2;
        }
        return CollectionsKt___CollectionsKt.x0(arrayList);
    }

    public static final List<f> b(NetworkPeriodicQuestionGroup networkPeriodicQuestionGroup) {
        Iterator<T> it;
        ArrayList arrayList;
        j.g(networkPeriodicQuestionGroup, "<this>");
        List<NetworkPeriodicQuestion> questions = networkPeriodicQuestionGroup.getQuestions();
        int i10 = 10;
        ArrayList arrayList2 = new ArrayList(r.t(questions, 10));
        Iterator<T> it2 = questions.iterator();
        while (it2.hasNext()) {
            NetworkPeriodicQuestion networkPeriodicQuestion = (NetworkPeriodicQuestion) it2.next();
            String id2 = networkPeriodicQuestion.getQuestion().getId();
            QuestionGroupType fromApiString = QuestionGroupType.Companion.fromApiString(networkPeriodicQuestion.getQuestionGroupName());
            String placeholder = networkPeriodicQuestion.getQuestion().getPlaceholder();
            QuestionType fromApiString2 = QuestionType.Companion.fromApiString(networkPeriodicQuestion.getQuestion().getType());
            String label = networkPeriodicQuestion.getQuestion().getLabel();
            String text = networkPeriodicQuestion.getQuestion().getText();
            String name = networkPeriodicQuestion.getQuestion().getName();
            List<NetworkOption> options = networkPeriodicQuestion.getQuestion().getOptions();
            if (options != null) {
                ArrayList arrayList3 = new ArrayList(r.t(options, i10));
                for (NetworkOption networkOption : options) {
                    arrayList3.add(new c(networkOption.getId(), networkPeriodicQuestion.getQuestion().getId(), networkOption.getTitle(), networkOption.getName()));
                    it2 = it2;
                }
                it = it2;
                arrayList = arrayList3;
            } else {
                it = it2;
                arrayList = q.j();
            }
            arrayList2.add(new f(id2, fromApiString, placeholder, fromApiString2, label, text, name, arrayList, networkPeriodicQuestion.getQuestion().getInteractionPolicy()));
            it2 = it;
            i10 = 10;
        }
        return arrayList2;
    }

    public static final g c(ResponseQuestionGroup responseQuestionGroup, String str) {
        j.g(responseQuestionGroup, "<this>");
        j.g(str, "profileId");
        NetworkQuestionGroup data = responseQuestionGroup.getData();
        j.d(data);
        return d(data, str);
    }

    public static final g d(NetworkQuestionGroup networkQuestionGroup, String str) {
        boolean z10;
        List list;
        Integer num;
        ArrayList arrayList;
        String str2 = str;
        j.g(networkQuestionGroup, "<this>");
        j.g(str2, "profileId");
        QuestionGroupType fromApiString = QuestionGroupType.Companion.fromApiString(networkQuestionGroup.getName());
        List<NetworkQuestion> questions = networkQuestionGroup.getQuestions();
        int i10 = 10;
        ArrayList arrayList2 = new ArrayList(r.t(questions, 10));
        for (NetworkQuestion networkQuestion : questions) {
            List<NetworkOption> options = networkQuestion.getOptions();
            if (options != null) {
                ArrayList arrayList3 = new ArrayList(r.t(options, i10));
                for (NetworkOption networkOption : options) {
                    arrayList3.add(new c(networkOption.getId(), networkQuestion.getId(), networkOption.getTitle(), networkOption.getName()));
                }
                arrayList = arrayList3;
            } else {
                arrayList = q.j();
            }
            f fVar = r4;
            f fVar2 = new f(networkQuestion.getId(), fromApiString, networkQuestion.getPlaceholder(), QuestionType.Companion.fromApiString(networkQuestion.getType()), networkQuestion.getLabel(), networkQuestion.getText(), networkQuestion.getName(), arrayList, networkQuestion.getInteractionPolicy());
            arrayList2.add(fVar);
            i10 = 10;
        }
        List<NetworkAnswer> answers = networkQuestionGroup.getAnswers();
        if (answers == null || answers.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            list = q.j();
        } else {
            List<NetworkAnswer> answers2 = networkQuestionGroup.getAnswers();
            j.d(answers2);
            ArrayList arrayList4 = new ArrayList(r.t(answers2, 10));
            for (NetworkAnswer a10 : answers2) {
                arrayList4.add(a(a10, str2));
            }
            list = r.u(arrayList4);
        }
        String id2 = networkQuestionGroup.getId();
        String lowerCase = networkQuestionGroup.getName().toLowerCase(Locale.ROOT);
        j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        QuestionGroupInteractionPolicy interactionPolicy = networkQuestionGroup.getInteractionPolicy();
        Integer num2 = null;
        if (interactionPolicy != null) {
            num = interactionPolicy.getMax();
        } else {
            num = null;
        }
        QuestionGroupInteractionPolicy interactionPolicy2 = networkQuestionGroup.getInteractionPolicy();
        if (interactionPolicy2 != null) {
            num2 = interactionPolicy2.getMaxSubOptions();
        }
        g gVar = new g(id2, lowerCase, num, num2);
        gVar.g(arrayList2);
        gVar.h(list);
        return gVar;
    }

    public static final Answer e(b bVar) {
        j.g(bVar, "<this>");
        String b10 = bVar.b();
        String h10 = bVar.h();
        if (r.w(h10)) {
            h10 = null;
        }
        return new Answer(b10, h10, bVar.i(), bVar.j(), bVar.k(), bVar.c(), bVar.a(), bVar.g(), bVar.f(), bVar.e(), bVar.l());
    }

    public static final Option f(NetworkOption networkOption, String str) {
        j.g(networkOption, "<this>");
        j.g(str, "questionId");
        return new Option(networkOption.getId(), str, networkOption.getTitle(), networkOption.getName());
    }

    public static final Option g(c cVar, String str) {
        j.g(cVar, "<this>");
        j.g(str, "questionId");
        return new Option(cVar.a(), str, cVar.d(), cVar.b());
    }

    public static final Question h(NetworkQuestion networkQuestion, String str) {
        ArrayList arrayList;
        j.g(networkQuestion, "<this>");
        j.g(str, "questionGroupName");
        String id2 = networkQuestion.getId();
        String name = networkQuestion.getName();
        QuestionGroupType fromApiString = QuestionGroupType.Companion.fromApiString(str);
        String placeholder = networkQuestion.getPlaceholder();
        QuestionType fromApiString2 = QuestionType.Companion.fromApiString(networkQuestion.getType());
        String label = networkQuestion.getLabel();
        String text = networkQuestion.getText();
        List<NetworkOption> options = networkQuestion.getOptions();
        if (options != null) {
            ArrayList arrayList2 = new ArrayList(r.t(options, 10));
            for (NetworkOption f10 : options) {
                arrayList2.add(f(f10, networkQuestion.getId()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = q.j();
        }
        return new Question(id2, name, fromApiString, placeholder, fromApiString2, label, text, arrayList, networkQuestion.getInteractionPolicy());
    }

    public static final Question i(f fVar, List<Option> list) {
        j.g(fVar, "<this>");
        j.g(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new Question(fVar.b(), fVar.e(), fVar.a(), fVar.g(), fVar.i(), fVar.d(), fVar.h(), list, fVar.c());
    }
}
