package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003/0&B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J0\u0010!\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001e2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001eH\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "c", "", "previousFragmentId", "", "h", "Landroid/view/ViewGroup;", "container", "i", "m", "j", "", "isVisibleToUser", "o", "violatingFragment", "targetFragment", "", "requestCode", "n", "l", "k", "p", "Landroidx/fragment/app/strictmode/Violation;", "violation", "g", "policy", "Ljava/lang/Class;", "fragmentClass", "violationClass", "r", "d", "Ljava/lang/Runnable;", "runnable", "q", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;)V", "defaultPolicy", "<init>", "()V", "Flag", "a", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentStrictMode {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentStrictMode f5877a = new FragmentStrictMode();

    /* renamed from: b  reason: collision with root package name */
    private static b f5878b = b.f5889e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "", "Landroidx/fragment/app/strictmode/Violation;", "violation", "", "a", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a(Violation violation);
    }

    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0004BC\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00150\r¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR4\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00020\r8\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "listener", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "mAllowedViolations", "", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$a;Ljava/util/Map;)V", "d", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* renamed from: d  reason: collision with root package name */
        public static final a f5888d = new a((DefaultConstructorMarker) null);

        /* renamed from: e  reason: collision with root package name */
        public static final b f5889e = new b(n0.e(), (a) null, h0.i());

        /* renamed from: a  reason: collision with root package name */
        private final Set<Flag> f5890a;

        /* renamed from: b  reason: collision with root package name */
        private final a f5891b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Set<Class<? extends Violation>>> f5892c;

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b$a;", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "<init>", "()V", "fragment_release"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(Set<? extends Flag> set, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> map) {
            j.g(set, "flags");
            j.g(map, "allowedViolations");
            this.f5890a = set;
            this.f5891b = aVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), (Set) next.getValue());
            }
            this.f5892c = linkedHashMap;
        }

        public final Set<Flag> a() {
            return this.f5890a;
        }

        public final a b() {
            return this.f5891b;
        }

        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f5892c;
        }
    }

    private FragmentStrictMode() {
    }

    private final b c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                j.f(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.C0() != null) {
                    b C0 = parentFragmentManager.C0();
                    j.d(C0);
                    return C0;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f5878b;
    }

    private final void d(b bVar, Violation violation) {
        Fragment a10 = violation.a();
        String name = a10.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Policy violation in ");
            sb2.append(name);
        }
        if (bVar.b() != null) {
            q(a10, new i1.a(bVar, violation));
        }
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            q(a10, new i1.b(name, violation));
        }
    }

    /* access modifiers changed from: private */
    public static final void e(b bVar, Violation violation) {
        j.g(bVar, "$policy");
        j.g(violation, "$violation");
        bVar.b().a(violation);
    }

    /* access modifiers changed from: private */
    public static final void f(String str, Violation violation) {
        j.g(violation, "$violation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Policy violation with PENALTY_DEATH in ");
        sb2.append(str);
        throw violation;
    }

    private final void g(Violation violation) {
        if (FragmentManager.J0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("StrictMode violation in ");
            sb2.append(violation.a().getClass().getName());
        }
    }

    public static final void h(Fragment fragment, String str) {
        j.g(fragment, "fragment");
        j.g(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(fragmentReuseViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.r(c10, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.d(c10, fragmentReuseViolation);
        }
    }

    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        j.g(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(fragmentTagUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, fragmentTagUsageViolation);
        }
    }

    public static final void j(Fragment fragment) {
        j.g(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(getRetainInstanceUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getRetainInstanceUsageViolation);
        }
    }

    public static final void k(Fragment fragment) {
        j.g(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(getTargetFragmentRequestCodeUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void l(Fragment fragment) {
        j.g(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(getTargetFragmentUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, getTargetFragmentUsageViolation);
        }
    }

    public static final void m(Fragment fragment) {
        j.g(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(setRetainInstanceUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, setRetainInstanceUsageViolation);
        }
    }

    public static final void n(Fragment fragment, Fragment fragment2, int i10) {
        j.g(fragment, "violatingFragment");
        j.g(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i10);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(setTargetFragmentUsageViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.r(c10, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.d(c10, setTargetFragmentUsageViolation);
        }
    }

    public static final void o(Fragment fragment, boolean z10) {
        j.g(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(setUserVisibleHintViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.r(c10, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.d(c10, setUserVisibleHintViolation);
        }
    }

    public static final void p(Fragment fragment, ViewGroup viewGroup) {
        j.g(fragment, "fragment");
        j.g(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f5877a;
        fragmentStrictMode.g(wrongFragmentContainerViolation);
        b c10 = fragmentStrictMode.c(fragment);
        if (c10.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.r(c10, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.d(c10, wrongFragmentContainerViolation);
        }
    }

    private final void q(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler g10 = fragment.getParentFragmentManager().w0().g();
            j.f(g10, "fragment.parentFragmentManager.host.handler");
            if (j.b(g10.getLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                g10.post(runnable);
            }
        } else {
            runnable.run();
        }
    }

    private final boolean r(b bVar, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set set = bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (j.b(cls2.getSuperclass(), Violation.class) || !CollectionsKt___CollectionsKt.E(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
