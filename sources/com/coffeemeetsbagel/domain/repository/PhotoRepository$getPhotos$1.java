package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.photo.Photo;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import v6.c;

final class PhotoRepository$getPhotos$1 extends Lambda implements Function1<List<? extends PhotoEntity>, List<? extends Photo>> {

    /* renamed from: a  reason: collision with root package name */
    public static final PhotoRepository$getPhotos$1 f12411a = new PhotoRepository$getPhotos$1();

    PhotoRepository$getPhotos$1() {
        super(1);
    }

    /* renamed from: a */
    public final List<Photo> invoke(List<PhotoEntity> list) {
        j.g(list, "list");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (PhotoEntity c10 : list) {
            arrayList.add(c.c(c10));
        }
        return arrayList;
    }
}
