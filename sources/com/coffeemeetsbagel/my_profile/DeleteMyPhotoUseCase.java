package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.domain.repository.UserRepository;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.a;
import qj.f;

public final class DeleteMyPhotoUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final UserRepository f34733a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final PhotoRepository f34734b;

    public DeleteMyPhotoUseCase(UserRepository userRepository, PhotoRepository photoRepository) {
        j.g(userRepository, "userRepository");
        j.g(photoRepository, "photoRepository");
        this.f34733a = userRepository;
        this.f34734b = photoRepository;
    }

    /* access modifiers changed from: private */
    public static final f d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    public final a c(int i10) {
        a w10 = this.f34733a.m().L().w(new a(new DeleteMyPhotoUseCase$invoke$1(this, i10)));
        j.f(w10, "operator fun invoke(inde…    }\n            }\n    }");
        return w10;
    }
}
