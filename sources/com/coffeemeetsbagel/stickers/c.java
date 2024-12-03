package com.coffeemeetsbagel.stickers;

import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.entities.StickerEntity;
import kotlin.jvm.internal.j;

public final class c {
    /* access modifiers changed from: private */
    public static final StickerEntity b(StickerNetwork stickerNetwork) {
        String name = stickerNetwork.getName();
        j.f(name, "this@toDb.name");
        String description = stickerNetwork.getDescription();
        j.f(description, "this@toDb.description");
        String imageUrl = stickerNetwork.getImageUrl();
        j.f(imageUrl, "this@toDb.imageUrl");
        return new StickerEntity(name, description, imageUrl);
    }
}
