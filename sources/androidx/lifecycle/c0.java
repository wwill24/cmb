package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.i0;
import androidx.savedstate.a;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import r1.d;

public final class c0 extends i0.d implements i0.b {

    /* renamed from: b  reason: collision with root package name */
    private Application f6010b;

    /* renamed from: c  reason: collision with root package name */
    private final i0.b f6011c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f6012d;

    /* renamed from: e  reason: collision with root package name */
    private Lifecycle f6013e;

    /* renamed from: f  reason: collision with root package name */
    private a f6014f;

    @SuppressLint({"LambdaLast"})
    public c0(Application application, d dVar, Bundle bundle) {
        i0.a aVar;
        j.g(dVar, "owner");
        this.f6014f = dVar.getSavedStateRegistry();
        this.f6013e = dVar.getLifecycle();
        this.f6012d = bundle;
        this.f6010b = application;
        if (application != null) {
            aVar = i0.a.f6036f.b(application);
        } else {
            aVar = new i0.a();
        }
        this.f6011c = aVar;
    }

    public <T extends f0> T a(Class<T> cls) {
        j.g(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends f0> T b(Class<T> cls, m1.a aVar) {
        Constructor<T> constructor;
        j.g(cls, "modelClass");
        j.g(aVar, "extras");
        String str = (String) aVar.a(i0.c.f6045d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (aVar.a(SavedStateHandleSupport.f5977a) != null && aVar.a(SavedStateHandleSupport.f5978b) != null) {
            Application application = (Application) aVar.a(i0.a.f6038h);
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = d0.c(cls, d0.f6016b);
            } else {
                constructor = d0.c(cls, d0.f6015a);
            }
            if (constructor == null) {
                return this.f6011c.b(cls, aVar);
            }
            if (!isAssignableFrom || application == null) {
                return d0.d(cls, constructor, SavedStateHandleSupport.a(aVar));
            }
            return d0.d(cls, constructor, application, SavedStateHandleSupport.a(aVar));
        } else if (this.f6013e != null) {
            return d(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public void c(f0 f0Var) {
        j.g(f0Var, "viewModel");
        if (this.f6013e != null) {
            a aVar = this.f6014f;
            j.d(aVar);
            Lifecycle lifecycle = this.f6013e;
            j.d(lifecycle);
            LegacySavedStateHandleController.a(f0Var, aVar, lifecycle);
        }
    }

    public final <T extends f0> T d(String str, Class<T> cls) {
        Constructor<T> constructor;
        T t10;
        Application application;
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(cls, "modelClass");
        Lifecycle lifecycle = this.f6013e;
        if (lifecycle != null) {
            boolean isAssignableFrom = a.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.f6010b == null) {
                constructor = d0.c(cls, d0.f6016b);
            } else {
                constructor = d0.c(cls, d0.f6015a);
            }
            if (constructor != null) {
                a aVar = this.f6014f;
                j.d(aVar);
                SavedStateHandleController b10 = LegacySavedStateHandleController.b(aVar, lifecycle, str, this.f6012d);
                if (!isAssignableFrom || (application = this.f6010b) == null) {
                    t10 = d0.d(cls, constructor, b10.b());
                } else {
                    j.d(application);
                    t10 = d0.d(cls, constructor, application, b10.b());
                }
                t10.e("androidx.lifecycle.savedstate.vm.tag", b10);
                return t10;
            } else if (this.f6010b != null) {
                return this.f6011c.a(cls);
            } else {
                return i0.c.f6043b.a().a(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
