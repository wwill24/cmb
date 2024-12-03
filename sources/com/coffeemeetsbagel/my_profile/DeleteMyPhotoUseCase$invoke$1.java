package com.coffeemeetsbagel.my_profile;

import com.coffeemeetsbagel.photo.Photo;
import com.leanplum.internal.Constants;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.f;
import qj.w;

final class DeleteMyPhotoUseCase$invoke$1 extends Lambda implements Function1<String, f> {
    final /* synthetic */ int $index;
    final /* synthetic */ DeleteMyPhotoUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeleteMyPhotoUseCase$invoke$1(DeleteMyPhotoUseCase deleteMyPhotoUseCase, int i10) {
        super(1);
        this.this$0 = deleteMyPhotoUseCase;
        this.$index = i10;
    }

    /* access modifiers changed from: private */
    public static final f d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (f) function1.invoke(obj);
    }

    /* renamed from: c */
    public final f invoke(String str) {
        j.g(str, Constants.Params.USER_ID);
        w<List<Photo>> L = this.this$0.f34734b.f(str).L();
        final DeleteMyPhotoUseCase deleteMyPhotoUseCase = this.this$0;
        final int i10 = this.$index;
        return L.w(new b(new Function1<List<? extends Photo>, f>() {
            /* renamed from: a */
            public final f invoke(List<Photo> list) {
                j.g(list, "photos");
                return deleteMyPhotoUseCase.f34734b.h(list.get(i10));
            }
        }));
    }
}
