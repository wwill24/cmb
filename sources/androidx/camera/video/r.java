package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.q;
import androidx.camera.core.v1;
import androidx.camera.video.m;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final List<q> f3412a;

    /* renamed from: b  reason: collision with root package name */
    private final m f3413b;

    r(@NonNull List<q> list, @NonNull m mVar) {
        boolean z10;
        if (!list.isEmpty() || mVar != m.f3396a) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.b(z10, "No preferred quality and fallback strategy.");
        this.f3412a = Collections.unmodifiableList(new ArrayList(list));
        this.f3413b = mVar;
    }

    private void a(@NonNull List<q> list, @NonNull Set<q> set) {
        q qVar;
        if (!list.isEmpty() && !set.containsAll(list)) {
            v1.a("QualitySelector", "Select quality by fallbackStrategy = " + this.f3413b);
            m mVar = this.f3413b;
            if (mVar != m.f3396a) {
                h.j(mVar instanceof m.b, "Currently only support type RuleStrategy");
                m.b bVar = (m.b) this.f3413b;
                List<q> b10 = q.b();
                boolean z10 = false;
                if (bVar.b() == q.f3408f) {
                    qVar = b10.get(0);
                } else if (bVar.b() == q.f3407e) {
                    qVar = b10.get(b10.size() - 1);
                } else {
                    qVar = bVar.b();
                }
                int indexOf = b10.indexOf(qVar);
                if (indexOf != -1) {
                    z10 = true;
                }
                h.i(z10);
                ArrayList arrayList = new ArrayList();
                for (int i10 = indexOf - 1; i10 >= 0; i10--) {
                    q qVar2 = b10.get(i10);
                    if (list.contains(qVar2)) {
                        arrayList.add(qVar2);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i11 = indexOf + 1; i11 < b10.size(); i11++) {
                    q qVar3 = b10.get(i11);
                    if (list.contains(qVar3)) {
                        arrayList2.add(qVar3);
                    }
                }
                v1.a("QualitySelector", "sizeSortedQualities = " + b10 + ", fallback quality = " + qVar + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
                int c10 = bVar.c();
                if (c10 == 0) {
                    return;
                }
                if (c10 == 1) {
                    set.addAll(arrayList);
                    set.addAll(arrayList2);
                } else if (c10 == 2) {
                    set.addAll(arrayList);
                } else if (c10 == 3) {
                    set.addAll(arrayList2);
                    set.addAll(arrayList);
                } else if (c10 == 4) {
                    set.addAll(arrayList2);
                } else {
                    throw new AssertionError("Unhandled fallback strategy: " + this.f3413b);
                }
            }
        }
    }

    private static void b(@NonNull q qVar) {
        boolean a10 = q.a(qVar);
        h.b(a10, "Invalid quality: " + qVar);
    }

    private static void c(@NonNull List<q> list) {
        for (q next : list) {
            boolean a10 = q.a(next);
            h.b(a10, "qualities contain invalid quality: " + next);
        }
    }

    @NonNull
    public static r d(@NonNull q qVar) {
        return e(qVar, m.f3396a);
    }

    @NonNull
    public static r e(@NonNull q qVar, @NonNull m mVar) {
        h.h(qVar, "quality cannot be null");
        h.h(mVar, "fallbackStrategy cannot be null");
        b(qVar);
        return new r(Arrays.asList(new q[]{qVar}), mVar);
    }

    @NonNull
    public static r f(@NonNull List<q> list, @NonNull m mVar) {
        h.h(list, "qualities cannot be null");
        h.h(mVar, "fallbackStrategy cannot be null");
        h.b(!list.isEmpty(), "qualities cannot be empty");
        c(list);
        return new r(list, mVar);
    }

    public static Size h(@NonNull q qVar, @NonNull q qVar2) {
        b(qVar2);
        androidx.camera.core.impl.m e10 = f0.d(qVar).e(qVar2);
        if (e10 != null) {
            return new Size(e10.p(), e10.n());
        }
        return null;
    }

    @NonNull
    public static List<q> i(@NonNull q qVar) {
        return f0.d(qVar).f();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<q> g(@NonNull q qVar) {
        List<q> f10 = f0.d(qVar).f();
        if (f10.isEmpty()) {
            v1.l("QualitySelector", "No supported quality on the device.");
            return new ArrayList();
        }
        v1.a("QualitySelector", "supportedQualities = " + f10);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<q> it = this.f3412a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            q next = it.next();
            if (next == q.f3408f) {
                linkedHashSet.addAll(f10);
                break;
            } else if (next == q.f3407e) {
                ArrayList arrayList = new ArrayList(f10);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            } else if (f10.contains(next)) {
                linkedHashSet.add(next);
            } else {
                v1.l("QualitySelector", "quality is not supported and will be ignored: " + next);
            }
        }
        a(f10, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    @NonNull
    public String toString() {
        return "QualitySelector{preferredQualities=" + this.f3412a + ", fallbackStrategy=" + this.f3413b + "}";
    }
}
