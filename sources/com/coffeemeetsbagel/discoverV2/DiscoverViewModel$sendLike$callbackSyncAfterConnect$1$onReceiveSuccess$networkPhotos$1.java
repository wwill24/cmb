package com.coffeemeetsbagel.discoverV2;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.photo.Photo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DiscoverViewModel$sendLike$callbackSyncAfterConnect$1$onReceiveSuccess$networkPhotos$1 extends Lambda implements Function1<Photo, NetworkPhoto> {

    /* renamed from: a  reason: collision with root package name */
    public static final DiscoverViewModel$sendLike$callbackSyncAfterConnect$1$onReceiveSuccess$networkPhotos$1 f12279a = new DiscoverViewModel$sendLike$callbackSyncAfterConnect$1$onReceiveSuccess$networkPhotos$1();

    DiscoverViewModel$sendLike$callbackSyncAfterConnect$1$onReceiveSuccess$networkPhotos$1() {
        super(1);
    }

    /* renamed from: a */
    public final NetworkPhoto invoke(Photo photo) {
        j.g(photo, "photoDomain");
        return new NetworkPhoto(photo.d(), photo.getUrl(), photo.c(), photo.e(), photo.a());
    }
}
