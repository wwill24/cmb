package v6;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.photo.Photo;
import kotlin.jvm.internal.j;

public final class c {
    public static final PhotoEntity a(NetworkPhoto networkPhoto) {
        j.g(networkPhoto, "<this>");
        String id2 = networkPhoto.getId();
        j.f(id2, "this.id");
        String caption = networkPhoto.getCaption();
        int position = networkPhoto.getPosition();
        String idProfile = networkPhoto.getIdProfile();
        j.f(idProfile, "this.idProfile");
        String url = networkPhoto.getUrl();
        j.f(url, "this.url");
        return new PhotoEntity(id2, caption, position, idProfile, url);
    }

    public static final PhotoEntity b(Photo photo) {
        j.g(photo, "<this>");
        return new PhotoEntity(photo.c(), photo.a(), photo.d(), photo.e(), photo.getUrl());
    }

    public static final Photo c(PhotoEntity photoEntity) {
        j.g(photoEntity, "<this>");
        return new Photo(photoEntity.getPhotoId(), photoEntity.getCaption(), photoEntity.getPosition(), photoEntity.getProfileId(), photoEntity.getUrl());
    }

    public static final NetworkPhoto d(PhotoEntity photoEntity) {
        j.g(photoEntity, "<this>");
        return new NetworkPhoto(photoEntity.getPosition(), photoEntity.getUrl(), photoEntity.getPhotoId(), photoEntity.getProfileId(), photoEntity.getCaption());
    }

    public static final NetworkPhoto e(Photo photo) {
        j.g(photo, "<this>");
        return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
    }
}
