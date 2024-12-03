package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import kotlin.jvm.internal.j;
import r1.d;

public final class LegacySavedStateHandleController {

    /* renamed from: a  reason: collision with root package name */
    public static final LegacySavedStateHandleController f5919a = new LegacySavedStateHandleController();

    public static final class a implements a.C0077a {
        public void a(d dVar) {
            j.g(dVar, "owner");
            if (dVar instanceof l0) {
                k0 viewModelStore = ((l0) dVar).getViewModelStore();
                androidx.savedstate.a savedStateRegistry = dVar.getSavedStateRegistry();
                for (String b10 : viewModelStore.c()) {
                    f0 b11 = viewModelStore.b(b10);
                    j.d(b11);
                    LegacySavedStateHandleController.a(b11, savedStateRegistry, dVar.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    private LegacySavedStateHandleController() {
    }

    public static final void a(f0 f0Var, androidx.savedstate.a aVar, Lifecycle lifecycle) {
        j.g(f0Var, "viewModel");
        j.g(aVar, "registry");
        j.g(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) f0Var.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.c()) {
            savedStateHandleController.a(aVar, lifecycle);
            f5919a.c(aVar, lifecycle);
        }
    }

    public static final SavedStateHandleController b(androidx.savedstate.a aVar, Lifecycle lifecycle, String str, Bundle bundle) {
        j.g(aVar, "registry");
        j.g(lifecycle, "lifecycle");
        j.d(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, a0.f5992f.a(aVar.b(str), bundle));
        savedStateHandleController.a(aVar, lifecycle);
        f5919a.c(aVar, lifecycle);
        return savedStateHandleController;
    }

    private final void c(androidx.savedstate.a aVar, Lifecycle lifecycle) {
        Lifecycle.State b10 = lifecycle.b();
        if (b10 == Lifecycle.State.INITIALIZED || b10.b(Lifecycle.State.STARTED)) {
            aVar.i(a.class);
        } else {
            lifecycle.a(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, aVar));
        }
    }
}
