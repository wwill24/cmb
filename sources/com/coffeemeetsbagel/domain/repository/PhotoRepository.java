package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.photo.Photo;
import dk.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import qj.h;
import qj.w;
import u6.i;
import v6.c;

public final class PhotoRepository {

    /* renamed from: a  reason: collision with root package name */
    private final i f12410a;

    public PhotoRepository(i iVar) {
        j.g(iVar, "localDb");
        this.f12410a = iVar;
    }

    /* access modifiers changed from: private */
    public static final List g(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void i(PhotoRepository photoRepository, PhotoEntity photoEntity) {
        j.g(photoRepository, "this$0");
        j.g(photoEntity, "$entity");
        photoRepository.f12410a.a(photoEntity);
    }

    /* access modifiers changed from: private */
    public static final void k(PhotoRepository photoRepository, NetworkPhoto networkPhoto, NetworkPhoto networkPhoto2) {
        j.g(photoRepository, "this$0");
        j.g(networkPhoto2, "$new");
        photoRepository.f12410a.g(networkPhoto != null ? c.a(networkPhoto) : null, c.a(networkPhoto2));
    }

    /* access modifiers changed from: private */
    public static final Integer m(List list, PhotoRepository photoRepository) {
        j.g(list, "$profiles");
        j.g(photoRepository, "this$0");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NetworkProfile networkProfile = (NetworkProfile) it.next();
            List<NetworkPhoto> photos = networkProfile.getPhotos();
            j.f(photos, "networkProfile.photos");
            ArrayList arrayList2 = new ArrayList(r.t(photos, 10));
            for (NetworkPhoto networkPhoto : photos) {
                String id2 = networkPhoto.getId();
                j.f(id2, "networkPhoto.id");
                String caption = networkPhoto.getCaption();
                int position = networkPhoto.getPosition();
                String id3 = networkProfile.getId();
                j.f(id3, "networkProfile.id");
                String url = networkPhoto.getUrl();
                j.f(url, "networkPhoto.url");
                arrayList2.add(new PhotoEntity(id2, caption, position, id3, url));
            }
            arrayList.add(arrayList2);
        }
        return Integer.valueOf(photoRepository.f12410a.f(r.u(arrayList)));
    }

    /* access modifiers changed from: private */
    public static final Integer o(PhotoRepository photoRepository, List list) {
        j.g(photoRepository, "this$0");
        j.g(list, "$entities");
        return Integer.valueOf(photoRepository.f12410a.c(list));
    }

    public final h<List<Photo>> f(String str) {
        j.g(str, "profileId");
        h<R> Y = this.f12410a.i(str).o0(a.c()).Y(new c0(PhotoRepository$getPhotos$1.f12411a));
        j.f(Y, "localDb.getPhotos(profil…hotoEntity.toDomain() } }");
        return Y;
    }

    public final qj.a h(Photo photo) {
        j.g(photo, "replacedPhoto");
        qj.a F = qj.a.w(new g0(this, c.b(photo))).F(a.c());
        j.f(F, "fromAction {\n           …scribeOn(Schedulers.io())");
        return F;
    }

    public final qj.a j(NetworkPhoto networkPhoto, NetworkPhoto networkPhoto2) {
        j.g(networkPhoto2, "new");
        qj.a F = qj.a.w(new d0(this, networkPhoto, networkPhoto2)).F(a.c());
        j.f(F, "fromAction {\n           …scribeOn(Schedulers.io())");
        return F;
    }

    public final w<Integer> l(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        w<Integer> K = w.A(new e0(list, this)).K(a.c());
        j.f(K, "fromCallable {\n         …scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Integer> n(List<Photo> list) {
        j.g(list, "photoList");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Photo b10 : list) {
            arrayList.add(c.b(b10));
        }
        w<Integer> K = w.A(new f0(this, arrayList)).K(a.c());
        j.f(K, "fromCallable { localDb.u…scribeOn(Schedulers.io())");
        return K;
    }
}
