package com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity;

import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.coffeemeetsbagel.feature.profile_completion_helper.ethnicity.EthnicityViewModel", f = "EthnicityViewModel.kt", l = {56}, m = "save")
final class EthnicityViewModel$save$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EthnicityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EthnicityViewModel$save$1(EthnicityViewModel ethnicityViewModel, c<? super EthnicityViewModel$save$1> cVar) {
        super(cVar);
        this.this$0 = ethnicityViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k((List<String>) null, (String) null, (String) null, this);
    }
}
