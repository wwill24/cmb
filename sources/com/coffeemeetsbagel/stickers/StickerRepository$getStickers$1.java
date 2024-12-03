package com.coffeemeetsbagel.stickers;

import com.coffeemeetsbagel.models.StickerNetwork;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class StickerRepository$getStickers$1 extends Lambda implements Function1<List<? extends StickerNetwork>, b0<? extends List<? extends StickerNetwork>>> {
    final /* synthetic */ StickerRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StickerRepository$getStickers$1(StickerRepository stickerRepository) {
        super(1);
        this.this$0 = stickerRepository;
    }

    /* renamed from: a */
    public final b0<? extends List<StickerNetwork>> invoke(List<? extends StickerNetwork> list) {
        j.g(list, "dbList");
        if (list.isEmpty() || this.this$0.j()) {
            return this.this$0.f();
        }
        return w.C(list);
    }
}
