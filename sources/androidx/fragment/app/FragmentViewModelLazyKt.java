package androidx.fragment.app;

import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.k0;
import gk.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import m1.a;
import wk.c;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aZ\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H\u0007¨\u0006\u0010²\u0006\u0018\u0010\u000f\u001a\u00020\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u0002²\u0006\u0018\u0010\u000f\u001a\u00020\u000e\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00008\nX\u0002"}, d2 = {"Landroidx/lifecycle/f0;", "VM", "Landroidx/fragment/app/Fragment;", "Lwk/c;", "viewModelClass", "Lkotlin/Function0;", "Landroidx/lifecycle/k0;", "storeProducer", "Lm1/a;", "extrasProducer", "Landroidx/lifecycle/i0$b;", "factoryProducer", "Lgk/f;", "a", "Landroidx/lifecycle/l0;", "owner", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0})
public final class FragmentViewModelLazyKt {
    public static final <VM extends f0> f<VM> a(Fragment fragment, c<VM> cVar, Function0<? extends k0> function0, Function0<? extends a> function02, Function0<? extends i0.b> function03) {
        j.g(fragment, "<this>");
        j.g(cVar, "viewModelClass");
        j.g(function0, "storeProducer");
        j.g(function02, "extrasProducer");
        if (function03 == null) {
            function03 = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new h0(cVar, function0, function03, function02);
    }
}
