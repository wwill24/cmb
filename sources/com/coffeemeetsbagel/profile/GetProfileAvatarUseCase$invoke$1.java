package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.photo.Photo;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GetProfileAvatarUseCase$invoke$1 extends Lambda implements Function1<List<? extends Photo>, Optional<Photo>> {

    /* renamed from: a  reason: collision with root package name */
    public static final GetProfileAvatarUseCase$invoke$1 f36019a = new GetProfileAvatarUseCase$invoke$1();

    GetProfileAvatarUseCase$invoke$1() {
        super(1);
    }

    /* renamed from: a */
    public final Optional<Photo> invoke(List<Photo> list) {
        T t10;
        boolean z10;
        j.g(list, "photos");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (((Photo) t10).d() == 0) {
                z10 = true;
                continue;
            } else {
                z10 = false;
                continue;
            }
            if (z10) {
                break;
            }
        }
        Photo photo = (Photo) t10;
        if (photo != null) {
            return Optional.of(photo);
        }
        return Optional.empty();
    }
}
