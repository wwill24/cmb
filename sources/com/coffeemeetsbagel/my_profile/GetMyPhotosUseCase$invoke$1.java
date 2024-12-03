package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.photo.Photo;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class GetMyPhotosUseCase$invoke$1 extends Lambda implements Function1<String, a<? extends List<? extends Photo>>> {
    final /* synthetic */ GetMyPhotosUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetMyPhotosUseCase$invoke$1(GetMyPhotosUseCase getMyPhotosUseCase) {
        super(1);
        this.this$0 = getMyPhotosUseCase;
    }

    /* renamed from: a */
    public final a<? extends List<Photo>> invoke(String str) {
        j.g(str, "it");
        return this.this$0.f34736b.f(str);
    }
}
