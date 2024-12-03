package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import r1.d;

public final class Recreator implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final a f6972b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f6973a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<String> f6974a = new LinkedHashSet();

        public b(a aVar) {
            j.g(aVar, "registry");
            aVar.h("androidx.savedstate.Restarter", this);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f6974a));
            return bundle;
        }

        public final void b(String str) {
            j.g(str, "className");
            this.f6974a.add(str);
        }
    }

    public Recreator(d dVar) {
        j.g(dVar, "owner");
        this.f6973a = dVar;
    }

    private final void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.C0077a.class);
            j.f(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    j.f(newInstance, "{\n                constr…wInstance()\n            }");
                    ((a.C0077a) newInstance).a(this.f6973a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            lVar.getLifecycle().d(this);
            Bundle b10 = this.f6973a.getSavedStateRegistry().b("androidx.savedstate.Restarter");
            if (b10 != null) {
                ArrayList<String> stringArrayList = b10.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    for (String a10 : stringArrayList) {
                        a(a10);
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
