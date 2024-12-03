package androidx.lifecycle;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class SavedStateHandlesProvider$viewModel$2 extends Lambda implements Function0<b0> {
    final /* synthetic */ l0 $viewModelStoreOwner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedStateHandlesProvider$viewModel$2(l0 l0Var) {
        super(0);
        this.$viewModelStoreOwner = l0Var;
    }

    /* renamed from: a */
    public final b0 invoke() {
        return SavedStateHandleSupport.e(this.$viewModelStoreOwner);
    }
}
