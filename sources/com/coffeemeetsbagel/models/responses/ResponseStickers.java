package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.StickerNetwork;
import java.util.List;

public class ResponseStickers extends ResponseGeneric {
    private List<StickerNetwork> results;

    public List<StickerNetwork> getStickers() {
        return this.results;
    }
}
