package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.qna.data.QuestionRepository;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

public final class SaveProfilesLocalUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileRepositoryV2 f36068a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final PhotoRepository f36069b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final QuestionRepository f36070c;

    public SaveProfilesLocalUseCase(ProfileRepositoryV2 profileRepositoryV2, PhotoRepository photoRepository, QuestionRepository questionRepository) {
        j.g(profileRepositoryV2, "repositoryV2");
        j.g(photoRepository, "photoRepository");
        j.g(questionRepository, "qnaRepo");
        this.f36068a = profileRepositoryV2;
        this.f36069b = photoRepository;
        this.f36070c = questionRepository;
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final w<List<Long>> e(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        w<R> v10 = this.f36068a.t(list).v(new o0(new SaveProfilesLocalUseCase$invoke$1(this, list))).v(new p0(new SaveProfilesLocalUseCase$invoke$2(this, list)));
        j.f(v10, "operator fun invoke(prof…Answers(profiles) }\n    }");
        return v10;
    }
}
