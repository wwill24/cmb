package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

public final class SaveAnswerUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36222a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final QuestionRepository f36223b;

    public SaveAnswerUseCase(UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(userRepository, "userRepo");
        j.g(questionRepository, "repository");
        this.f36222a = userRepository;
        this.f36223b = questionRepository;
    }

    public static /* synthetic */ a d(SaveAnswerUseCase saveAnswerUseCase, List list, String str, String str2, String str3, Integer num, Float f10, Float f11, Float f12, boolean z10, Location location, int i10, Object obj) {
        int i11 = i10;
        return saveAnswerUseCase.c((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str, str2, str3, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : f10, (i11 & 64) != 0 ? null : f11, (i11 & 128) != 0 ? null : f12, (i11 & 256) != 0 ? false : z10, (i11 & 512) != 0 ? null : location);
    }

    /* access modifiers changed from: private */
    public static final f e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    public final a c(List<String> list, String str, String str2, String str3, Integer num, Float f10, Float f11, Float f12, boolean z10, Location location) {
        String str4 = str2;
        j.g(str4, "questionId");
        String str5 = str3;
        j.g(str5, "group");
        a w10 = this.f36222a.m().L().w(new a0(new SaveAnswerUseCase$invoke$1(this, list, str, num, f10, str4, str5, f11, f12, z10, location)));
        j.f(w10, "operator fun invoke(\n   …    )\n            }\n    }");
        return w10;
    }
}
