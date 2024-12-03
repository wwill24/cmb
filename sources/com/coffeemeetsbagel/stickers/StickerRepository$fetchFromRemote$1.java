package com.coffeemeetsbagel.stickers;

import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.responses.ResponseStickers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StickerRepository$fetchFromRemote$1 extends Lambda implements Function1<ResponseStickers, List<? extends StickerNetwork>> {
    final /* synthetic */ StickerRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StickerRepository$fetchFromRemote$1(StickerRepository stickerRepository) {
        super(1);
        this.this$0 = stickerRepository;
    }

    /* renamed from: a */
    public final List<StickerNetwork> invoke(ResponseStickers responseStickers) {
        j.g(responseStickers, "networkList");
        List<StickerNetwork> stickers = responseStickers.getStickers();
        j.f(stickers, "networkList.stickers");
        ArrayList arrayList = new ArrayList(r.t(stickers, 10));
        for (StickerNetwork stickerNetwork : stickers) {
            j.f(stickerNetwork, "it");
            arrayList.add(c.b(stickerNetwork));
        }
        this.this$0.f36667b.c(arrayList);
        return responseStickers.getStickers();
    }
}
