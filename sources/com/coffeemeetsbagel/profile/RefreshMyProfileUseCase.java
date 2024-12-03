package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class RefreshMyProfileUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final UserRepository f36061a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ProfileRepositoryV2 f36062b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final PhotoRepository f36063c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final QuestionRepository f36064d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final m f36065e;

    public RefreshMyProfileUseCase(UserRepository userRepository, ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository, m mVar) {
        j.g(userRepository, "userRepository");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        j.g(photoRepository, "photoRepository");
        j.g(questionRepository, "questionRepository");
        j.g(mVar, "capabilityRepository");
        this.f36061a = userRepository;
        this.f36062b = profileRepositoryV2;
        this.f36063c = photoRepository;
        this.f36064d = questionRepository;
        this.f36065e = mVar;
    }

    /* access modifiers changed from: private */
    public static final b0 i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<b> h() {
        w<R> v10 = this.f36061a.t().v(new g0(new RefreshMyProfileUseCase$invoke$1(this))).v(new h0(new RefreshMyProfileUseCase$invoke$2(this)));
        j.f(v10, "operator fun invoke(): S…rentUserSingle()) }\n    }");
        return v10;
    }
}
