package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.photo.Photo;
import ja.b;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

public final class GetMyOwnProfileLocalUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ProfileRepositoryV2 f36011a;

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f36012b;

    public GetMyOwnProfileLocalUseCase(ProfileRepositoryV2 profileRepositoryV2, UserRepository userRepository) {
        j.g(profileRepositoryV2, "profileRepository");
        j.g(userRepository, "userRepository");
        this.f36011a = profileRepositoryV2;
        this.f36012b = userRepository;
    }

    /* access modifiers changed from: private */
    public static final a d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<Triple<b, l, List<Photo>>> c() {
        h<R> M = this.f36012b.p().M(new a(new GetMyOwnProfileLocalUseCase$invoke$1(this)));
        j.f(M, "operator fun invoke(): F…    }\n            }\n    }");
        return M;
    }
}
