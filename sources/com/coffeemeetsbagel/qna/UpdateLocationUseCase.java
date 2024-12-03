package com.coffeemeetsbagel.qna;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import rn.a;

public final class UpdateLocationUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f36224a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final QuestionRepository f36225b;

    public UpdateLocationUseCase(UserRepository userRepository, QuestionRepository questionRepository) {
        j.g(userRepository, "userRepository");
        j.g(questionRepository, "questionRepository");
        this.f36224a = userRepository;
        this.f36225b = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final b0 g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final a i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Location j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Location) function1.invoke(obj);
    }

    public final w<Location> f(Float f10, Float f11, String str, String str2, String str3, String str4) {
        w<R> D = this.f36224a.p().S(new c0(new UpdateLocationUseCase$invoke$1(this))).S(new d0(new UpdateLocationUseCase$invoke$2(str2, str3, str, str4, f10, f11, this))).M(new e0(new UpdateLocationUseCase$invoke$3(this))).L().D(new f0(UpdateLocationUseCase$invoke$4.f36226a));
        j.f(D, "operator fun invoke(\n   …on.\")\n            }\n    }");
        return D;
    }
}
