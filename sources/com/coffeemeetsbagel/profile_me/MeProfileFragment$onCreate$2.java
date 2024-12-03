package com.coffeemeetsbagel.profile_me;

import com.coffeemeetsbagel.photo.Photo;
import fa.a;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class MeProfileFragment$onCreate$2 extends Lambda implements Function1<List<? extends Photo>, Unit> {
    final /* synthetic */ MeProfileFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MeProfileFragment$onCreate$2(MeProfileFragment meProfileFragment) {
        super(1);
        this.this$0 = meProfileFragment;
    }

    public final void a(List<Photo> list) {
        a.C0491a aVar = a.f40771d;
        aVar.a("MeProfileFragment", "userPhotos: " + list);
        if (list != null) {
            this.this$0.A1(list);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((List) obj);
        return Unit.f32013a;
    }
}
