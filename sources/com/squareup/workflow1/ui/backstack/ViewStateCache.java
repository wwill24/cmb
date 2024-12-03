package com.squareup.workflow1.ui.backstack;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.workflow1.ui.androidx.WorkflowSavedStateRegistryAggregator;
import com.squareup.workflow1.ui.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import r1.d;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u001f\b\u0001\u0012\u0014\b\u0001\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b \u0010!B\t\b\u0016¢\u0006\u0004\b \u0010\"J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0002J*\u0010\r\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013R&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e¨\u0006$"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/ViewStateCache;", "", "", "", "retaining", "", "e", "Lcom/squareup/workflow1/ui/h;", "d", "retainedRenderings", "Landroid/view/View;", "oldViewMaybe", "newView", "h", "key", "Lr1/d;", "parentOwner", "a", "b", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "from", "f", "g", "", "Lcom/squareup/workflow1/ui/backstack/ViewStateFrame;", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "viewStates", "Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator;", "Lcom/squareup/workflow1/ui/androidx/WorkflowSavedStateRegistryAggregator;", "stateRegistryAggregator", "<init>", "(Ljava/util/Map;)V", "()V", "Saved", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
public final class ViewStateCache {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ViewStateFrame> f23228a;

    /* renamed from: b  reason: collision with root package name */
    private final WorkflowSavedStateRegistryAggregator f23229b;

    public ViewStateCache(Map<String, ViewStateFrame> map) {
        j.g(map, "viewStates");
        this.f23228a = map;
        this.f23229b = new WorkflowSavedStateRegistryAggregator();
    }

    private final void e(Collection<String> collection) {
        boolean unused = v.A(this.f23228a.keySet(), o0.j(this.f23228a.keySet(), collection));
        this.f23229b.j(collection);
    }

    public final void a(String str, d dVar) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(dVar, "parentOwner");
        this.f23229b.f(str, dVar);
    }

    public final void b() {
        this.f23229b.g();
    }

    public final Map<String, ViewStateFrame> c() {
        return this.f23228a;
    }

    public final void d(Collection<? extends h<?>> collection) {
        j.g(collection, "retaining");
        ArrayList arrayList = new ArrayList(r.t(collection, 10));
        for (h c10 : collection) {
            arrayList.add(c10.c());
        }
        e(arrayList);
    }

    public final void f(Saved saved) {
        j.g(saved, "from");
        this.f23228a.clear();
        this.f23228a.putAll(saved.a());
    }

    public final Saved g() {
        return new Saved(this);
    }

    public final void h(Collection<? extends h<?>> collection, View view, View view2) {
        boolean z10;
        j.g(collection, "retainedRenderings");
        j.g(view2, "newView");
        String a10 = di.d.b(view2);
        Set v10 = SequencesKt___SequencesKt.v(SequencesKt___SequencesKt.q(CollectionsKt___CollectionsKt.D(collection), ViewStateCache$update$hiddenKeys$1.f23231a));
        if (collection.size() == v10.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f23229b.h(view2, a10);
            ViewStateFrame remove = this.f23228a.remove(a10);
            if (remove != null) {
                view2.restoreHierarchyState(remove.a());
            }
            if (view != null) {
                String a11 = di.d.b(view);
                if (!v10.contains(a11)) {
                    a11 = null;
                }
                if (a11 != null) {
                    SparseArray sparseArray = new SparseArray();
                    view.saveHierarchyState(sparseArray);
                    Map<String, ViewStateFrame> c10 = c();
                    Pair a12 = gk.h.a(a11, new ViewStateFrame(a11, sparseArray));
                    c10.put(a12.c(), a12.d());
                    this.f23229b.m(a11);
                }
            }
            e(o0.k(v10, a10));
            return;
        }
        throw new IllegalArgumentException(("Duplicate entries not allowed in " + collection + '.').toString());
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\fB\u0011\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "out", "flags", "", "writeToParcel", "", "", "Lcom/squareup/workflow1/ui/backstack/ViewStateFrame;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "viewStates", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache;", "viewStateCache", "<init>", "(Lcom/squareup/workflow1/ui/backstack/ViewStateCache;)V", "source", "(Landroid/os/Parcel;)V", "CREATOR", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
    public static final class Saved implements Parcelable {
        public static final a CREATOR = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, ViewStateFrame> f23230a;

        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved$a;", "Landroid/os/Parcelable$Creator;", "Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "Landroid/os/Parcel;", "source", "a", "", "size", "", "b", "(I)[Lcom/squareup/workflow1/ui/backstack/ViewStateCache$Saved;", "<init>", "()V", "wf1-container-android"}, k = 1, mv = {1, 6, 0})
        public static final class a implements Parcelable.Creator<Saved> {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: a */
            public Saved createFromParcel(Parcel parcel) {
                j.g(parcel, "source");
                return new Saved(parcel);
            }

            /* renamed from: b */
            public Saved[] newArray(int i10) {
                return new Saved[i10];
            }
        }

        public Saved(ViewStateCache viewStateCache) {
            j.g(viewStateCache, "viewStateCache");
            this.f23230a = h0.u(viewStateCache.c());
        }

        public final Map<String, ViewStateFrame> a() {
            return this.f23230a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeMap(this.f23230a);
        }

        public Saved(Parcel parcel) {
            j.g(parcel, "source");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            parcel.readMap(p.c(linkedHashMap), ViewStateCache.class.getClassLoader());
            this.f23230a = h0.u(linkedHashMap);
        }
    }

    public ViewStateCache() {
        this(new LinkedHashMap());
    }
}
