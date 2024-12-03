package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import gk.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final CmbDatabase f11977a;

    public b(CmbDatabase cmbDatabase) {
        j.g(cmbDatabase, "cmbDatabase");
        this.f11977a = cmbDatabase;
    }

    private final Pair<String, List<PhotoEntity>> b(NetworkProfile networkProfile) {
        String id2 = networkProfile.getId();
        List<NetworkPhoto> photos = networkProfile.getPhotos();
        j.f(photos, "profile.photos");
        ArrayList arrayList = new ArrayList();
        for (NetworkPhoto networkPhoto : photos) {
            String id3 = networkPhoto.getId();
            j.f(id3, "photo.id");
            String caption = networkPhoto.getCaption();
            if (caption == null) {
                caption = null;
            }
            int position = networkPhoto.getPosition();
            String id4 = networkProfile.getId();
            j.f(id4, "profile.id");
            String url = networkPhoto.getUrl();
            j.f(url, "photo.url");
            arrayList.add(new PhotoEntity(id3, caption, position, id4, url));
        }
        return h.a(id2, arrayList);
    }

    private final Map<String, List<PhotoEntity>> c(List<? extends NetworkProfile> list) {
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (NetworkProfile b10 : list) {
            arrayList.add(b(b10));
        }
        return h0.s(arrayList);
    }

    public final int a(List<? extends NetworkProfile> list) {
        j.g(list, "profiles");
        return this.f11977a.S().t(c(list));
    }
}
