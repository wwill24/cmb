package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.domain.repository.m;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

public final class GetMyOwnProfileTmpUseCase {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ProfileRepositoryV2 f36013a;

    /* renamed from: b  reason: collision with root package name */
    private final UserRepository f36014b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final PhotoRepository f36015c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final m f36016d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f36017e = "GetMyOwnProfileTmpUseCase";

    public GetMyOwnProfileTmpUseCase(ProfileRepositoryV2 profileRepositoryV2, UserRepository userRepository, PhotoRepository photoRepository, m mVar) {
        j.g(profileRepositoryV2, "profileRepository");
        j.g(userRepository, "userRepository");
        j.g(photoRepository, "photoRepository");
        j.g(mVar, "capabilityRepository");
        this.f36013a = profileRepositoryV2;
        this.f36014b = userRepository;
        this.f36015c = photoRepository;
        this.f36016d = mVar;
    }

    /* access modifiers changed from: private */
    public static final a g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<Optional<NetworkProfile>> f() {
        h<R> M = this.f36014b.p().M(new d(new GetMyOwnProfileTmpUseCase$invoke$1(this)));
        j.f(M, "operator fun invoke(): F…    }\n            }\n    }");
        return M;
    }
}
