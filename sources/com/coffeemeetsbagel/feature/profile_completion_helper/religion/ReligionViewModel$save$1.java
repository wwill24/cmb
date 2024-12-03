package com.coffeemeetsbagel.feature.profile_completion_helper.religion;

import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.religion.ReligionViewModel", f = "ReligionViewModel.kt", l = {56}, m = "save")
final class ReligionViewModel$save$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReligionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReligionViewModel$save$1(ReligionViewModel religionViewModel, c<? super ReligionViewModel$save$1> cVar) {
        super(cVar);
        this.this$0 = religionViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k((List<String>) null, (String) null, (String) null, this);
    }
}
