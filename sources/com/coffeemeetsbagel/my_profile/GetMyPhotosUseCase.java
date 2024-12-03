package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import com.coffeemeetsbagel.photo.Photo;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;

public final class GetMyPhotosUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f34735a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final PhotoRepository f34736b;

    public GetMyPhotosUseCase(UserRepository userRepository, PhotoRepository photoRepository) {
        j.g(userRepository, "userRepository");
        j.g(photoRepository, "photoRepository");
        this.f34735a = userRepository;
        this.f34736b = photoRepository;
    }

    /* access modifiers changed from: private */
    public static final a d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (a) function1.invoke(obj);
    }

    public final h<List<Photo>> c() {
        h<R> M = this.f34735a.m().M(new e(new GetMyPhotosUseCase$invoke$1(this)));
        j.f(M, "operator fun invoke(): F…s(it)\n            }\n    }");
        return M;
    }
}
