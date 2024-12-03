package com.coffeemeetsbagel.models.mappers;

import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.entities.StickerEntity;
import kotlin.jvm.internal.j;

public final class StickerMapper {
    public static final StickerMapper INSTANCE = new StickerMapper();

    private StickerMapper() {
    }

    public final StickerNetwork dbToDomain(StickerEntity stickerEntity) {
        j.g(stickerEntity, "entity");
        return new StickerNetwork(stickerEntity.getImageUrl(), stickerEntity.getName(), stickerEntity.getDescription());
    }
}
