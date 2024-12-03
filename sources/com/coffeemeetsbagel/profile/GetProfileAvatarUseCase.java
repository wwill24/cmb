package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.photo.Photo;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;

public final class GetProfileAvatarUseCase {

    /* renamed from: a  reason: collision with root package name */
    private final PhotoRepository f36018a;

    public GetProfileAvatarUseCase(PhotoRepository photoRepository) {
        j.g(photoRepository, "repository");
        this.f36018a = photoRepository;
    }

    /* access modifiers changed from: private */
    public static final Optional c(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    public final h<Optional<Photo>> b(String str) {
        j.g(str, "profileId");
        h<R> Y = this.f36018a.f(str).Y(new g(GetProfileAvatarUseCase$invoke$1.f36019a));
        j.f(Y, "repository.getPhotos(pro…          }\n            }");
        return Y;
    }
}
