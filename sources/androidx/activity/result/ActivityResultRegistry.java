package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f359a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f360b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f361c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, d> f362d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f363e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, c<?>> f364f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f365g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f366h = new Bundle();

    class a extends c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f372b;

        a(String str, c.a aVar) {
            this.f371a = str;
            this.f372b = aVar;
        }

        @NonNull
        public c.a<I, ?> a() {
            return this.f372b;
        }

        public void c(I i10, androidx.core.app.c cVar) {
            Integer num = ActivityResultRegistry.this.f361c.get(this.f371a);
            if (num != null) {
                ActivityResultRegistry.this.f363e.add(this.f371a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f372b, i10, cVar);
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f363e.remove(this.f371a);
                    throw e10;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f372b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void d() {
            ActivityResultRegistry.this.l(this.f371a);
        }
    }

    class b extends c<I> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f374a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c.a f375b;

        b(String str, c.a aVar) {
            this.f374a = str;
            this.f375b = aVar;
        }

        @NonNull
        public c.a<I, ?> a() {
            return this.f375b;
        }

        public void c(I i10, androidx.core.app.c cVar) {
            Integer num = ActivityResultRegistry.this.f361c.get(this.f374a);
            if (num != null) {
                ActivityResultRegistry.this.f363e.add(this.f374a);
                try {
                    ActivityResultRegistry.this.f(num.intValue(), this.f375b, i10, cVar);
                } catch (Exception e10) {
                    ActivityResultRegistry.this.f363e.remove(this.f374a);
                    throw e10;
                }
            } else {
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.f375b + " and input " + i10 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }
        }

        public void d() {
            ActivityResultRegistry.this.l(this.f374a);
        }
    }

    private static class c<O> {

        /* renamed from: a  reason: collision with root package name */
        final a<O> f377a;

        /* renamed from: b  reason: collision with root package name */
        final c.a<?, O> f378b;

        c(a<O> aVar, c.a<?, O> aVar2) {
            this.f377a = aVar;
            this.f378b = aVar2;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f379a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<i> f380b = new ArrayList<>();

        d(@NonNull Lifecycle lifecycle) {
            this.f379a = lifecycle;
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull i iVar) {
            this.f379a.a(iVar);
            this.f380b.add(iVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Iterator<i> it = this.f380b.iterator();
            while (it.hasNext()) {
                this.f379a.d(it.next());
            }
            this.f380b.clear();
        }
    }

    private void a(int i10, String str) {
        this.f360b.put(Integer.valueOf(i10), str);
        this.f361c.put(str, Integer.valueOf(i10));
    }

    private <O> void d(String str, int i10, Intent intent, c<O> cVar) {
        if (cVar == null || cVar.f377a == null || !this.f363e.contains(str)) {
            this.f365g.remove(str);
            this.f366h.putParcelable(str, new ActivityResult(i10, intent));
            return;
        }
        cVar.f377a.a(cVar.f378b.parseResult(i10, intent));
        this.f363e.remove(str);
    }

    private int e() {
        int nextInt = this.f359a.nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            if (!this.f360b.containsKey(Integer.valueOf(i10))) {
                return i10;
            }
            nextInt = this.f359a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f361c.get(str) == null) {
            a(e(), str);
        }
    }

    public final boolean b(int i10, int i11, Intent intent) {
        String str = this.f360b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        d(str, i11, intent, this.f364f.get(str));
        return true;
    }

    public final <O> boolean c(int i10, @SuppressLint({"UnknownNullness"}) O o10) {
        a<O> aVar;
        String str = this.f360b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        c cVar = this.f364f.get(str);
        if (cVar == null || (aVar = cVar.f377a) == null) {
            this.f366h.remove(str);
            this.f365g.put(str, o10);
            return true;
        } else if (!this.f363e.remove(str)) {
            return true;
        } else {
            aVar.a(o10);
            return true;
        }
    }

    public abstract <I, O> void f(int i10, @NonNull c.a<I, O> aVar, @SuppressLint({"UnknownNullness"}) I i11, androidx.core.app.c cVar);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f363e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f359a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f366h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                    String str = stringArrayList.get(i10);
                    if (this.f361c.containsKey(str)) {
                        Integer remove = this.f361c.remove(str);
                        if (!this.f366h.containsKey(str)) {
                            this.f360b.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i10).intValue(), stringArrayList.get(i10));
                }
            }
        }
    }

    public final void h(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f361c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f361c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f363e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f366h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f359a);
    }

    @NonNull
    public final <I, O> c<I> i(@NonNull final String str, @NonNull l lVar, @NonNull final c.a<I, O> aVar, @NonNull final a<O> aVar2) {
        Lifecycle lifecycle = lVar.getLifecycle();
        if (!lifecycle.b().b(Lifecycle.State.STARTED)) {
            k(str);
            d dVar = this.f362d.get(str);
            if (dVar == null) {
                dVar = new d(lifecycle);
            }
            dVar.a(new i() {
                public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f364f.put(str, new c(aVar2, aVar));
                        if (ActivityResultRegistry.this.f365g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f365g.get(str);
                            ActivityResultRegistry.this.f365g.remove(str);
                            aVar2.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f366h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f366h.remove(str);
                            aVar2.a(aVar.parseResult(activityResult.c(), activityResult.a()));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f364f.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f362d.put(str, dVar);
            return new a(str, aVar);
        }
        throw new IllegalStateException("LifecycleOwner " + lVar + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    @NonNull
    public final <I, O> c<I> j(@NonNull String str, @NonNull c.a<I, O> aVar, @NonNull a<O> aVar2) {
        k(str);
        this.f364f.put(str, new c(aVar2, aVar));
        if (this.f365g.containsKey(str)) {
            Object obj = this.f365g.get(str);
            this.f365g.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f366h.getParcelable(str);
        if (activityResult != null) {
            this.f366h.remove(str);
            aVar2.a(aVar.parseResult(activityResult.c(), activityResult.a()));
        }
        return new b(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public final void l(@NonNull String str) {
        Integer remove;
        if (!this.f363e.contains(str) && (remove = this.f361c.remove(str)) != null) {
            this.f360b.remove(remove);
        }
        this.f364f.remove(str);
        if (this.f365g.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.f365g.get(str));
            this.f365g.remove(str);
        }
        if (this.f366h.containsKey(str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Dropping pending result for request ");
            sb3.append(str);
            sb3.append(": ");
            sb3.append(this.f366h.getParcelable(str));
            this.f366h.remove(str);
        }
        d dVar = this.f362d.get(str);
        if (dVar != null) {
            dVar.b();
            this.f362d.remove(str);
        }
    }
}
