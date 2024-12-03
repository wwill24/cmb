package com.coffeemeetsbagel.discoverV2.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.coffeemeetsbagel.discoverV2.ActionListenerEvent;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.store.k0;
import fa.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import qj.q;

public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: d  reason: collision with root package name */
    private final ProfileContract$Manager f12331d;

    /* renamed from: e  reason: collision with root package name */
    private final k0 f12332e;

    /* renamed from: f  reason: collision with root package name */
    private final s9.a f12333f;

    /* renamed from: g  reason: collision with root package name */
    private final a6.a f12334g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final String f12335h = "DiscoverFeedListAdapter";
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final List<GiveTakeBase> f12336j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final io.reactivex.subjects.a<com.coffeemeetsbagel.discoverV2.a> f12337k;

    /* renamed from: l  reason: collision with root package name */
    private GiveTakeBase f12338l;

    public final class a extends RecyclerView.d0 implements z7.a {

        /* renamed from: u  reason: collision with root package name */
        private final a f12339u;

        /* renamed from: v  reason: collision with root package name */
        private int f12340v;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ b f12341w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, View view) {
            super(view);
            j.g(view, "itemView");
            this.f12341w = bVar;
            this.f12339u = (a) view;
        }

        public final void V(NetworkProfile networkProfile, boolean z10, boolean z11, int i10, RisingGiveTake risingGiveTake) {
            int i11 = i10;
            a.C0491a aVar = fa.a.f40771d;
            String H = this.f12341w.f12335h;
            aVar.a(H, "bind: " + i11);
            this.f12340v = i11;
            this.f12339u.y(networkProfile, z10, 0, 0, 0, "", z11, (String) null, risingGiveTake);
            this.f12339u.x(this);
        }

        public final void W() {
            this.f12339u.A();
        }

        public final void X(int i10) {
            this.f12339u.setPhotoPosition(i10);
        }

        public final void Y() {
            this.f12339u.N(0);
        }

        public final void Z() {
            this.f12339u.O();
        }

        public final void a0() {
            this.f12339u.P(0);
        }

        public void b() {
            this.f12341w.M(this.f12340v);
        }

        public void d(int i10) {
            this.f12341w.N(this.f12340v, i10, this.f12339u);
        }

        public void p() {
            this.f12341w.O(this.f12340v);
        }
    }

    /* renamed from: com.coffeemeetsbagel.discoverV2.list.b$b  reason: collision with other inner class name */
    public static final class C0133b extends h.b {

        /* renamed from: a  reason: collision with root package name */
        private final List<GiveTakeBase> f12342a;

        /* renamed from: b  reason: collision with root package name */
        private final List<GiveTakeBase> f12343b;

        public C0133b(List<? extends GiveTakeBase> list, List<? extends GiveTakeBase> list2) {
            j.g(list, "oldList");
            j.g(list2, "newList");
            this.f12342a = list;
            this.f12343b = list2;
        }

        public boolean a(int i10, int i11) {
            GiveTakeBase giveTakeBase = this.f12342a.get(i10);
            GiveTakeBase giveTakeBase2 = this.f12343b.get(i11);
            if (!(giveTakeBase instanceof GiveTake) || !(giveTakeBase2 instanceof GiveTake)) {
                return false;
            }
            GiveTake giveTake = (GiveTake) giveTakeBase;
            GiveTake giveTake2 = (GiveTake) giveTakeBase2;
            if (giveTake.isLiked() == giveTake2.isLiked() && giveTake.isGiven() == giveTake2.isGiven() && j.b(giveTake.getLastUpdated(), giveTake2.getLastUpdated())) {
                return true;
            }
            return false;
        }

        public boolean b(int i10, int i11) {
            return this.f12342a.get(i10).getId() == this.f12343b.get(i11).getId();
        }

        public int d() {
            return this.f12343b.size();
        }

        public int e() {
            return this.f12342a.size();
        }
    }

    public static final class c extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f12344a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f12345b;

        c(LinearLayoutManager linearLayoutManager, b bVar) {
            this.f12344a = linearLayoutManager;
            this.f12345b = bVar;
        }

        public void a(RecyclerView recyclerView, int i10) {
            j.g(recyclerView, "recyclerView");
            super.a(recyclerView, i10);
        }

        public void b(RecyclerView recyclerView, int i10, int i11) {
            j.g(recyclerView, "recyclerView");
            super.b(recyclerView, i10, i11);
            LinearLayoutManager linearLayoutManager = this.f12344a;
            j.d(linearLayoutManager);
            int W1 = linearLayoutManager.W1();
            if (W1 >= 0 && W1 < this.f12345b.f12336j.size()) {
                b bVar = this.f12345b;
                bVar.S((GiveTakeBase) bVar.f12336j.get(W1));
            }
        }
    }

    public b(ProfileContract$Manager profileContract$Manager, k0 k0Var, s9.a aVar, a6.a aVar2) {
        j.g(profileContract$Manager, "profileManager");
        j.g(k0Var, "purchaseManager");
        j.g(aVar, "featureManager");
        j.g(aVar2, "coachmarkManager");
        this.f12331d = profileContract$Manager;
        this.f12332e = k0Var;
        this.f12333f = aVar;
        this.f12334g = aVar2;
        io.reactivex.subjects.a<com.coffeemeetsbagel.discoverV2.a> C0 = io.reactivex.subjects.a.C0();
        j.f(C0, "create()");
        this.f12337k = C0;
    }

    /* access modifiers changed from: private */
    public final void M(int i10) {
        this.f12337k.d(new com.coffeemeetsbagel.discoverV2.a(ActionListenerEvent.LIKED, i10, this.f12336j.get(i10) instanceof RisingGiveTake, (Integer) null));
    }

    /* access modifiers changed from: private */
    public final void N(int i10, int i11, a aVar) {
        com.coffeemeetsbagel.discoverV2.a aVar2 = new com.coffeemeetsbagel.discoverV2.a(ActionListenerEvent.PROFILE_PICTURE_CLICKED, i10, this.f12336j.get(i10) instanceof RisingGiveTake, Integer.valueOf(i11));
        aVar2.f(aVar);
        aVar2.g(this.f12336j.get(i10).getProfile());
        this.f12337k.d(aVar2);
    }

    /* access modifiers changed from: private */
    public final void O(int i10) {
        this.f12337k.d(new com.coffeemeetsbagel.discoverV2.a(ActionListenerEvent.FLOWER_CLICKED, i10, this.f12336j.get(i10) instanceof RisingGiveTake, (Integer) null));
    }

    private final boolean T(GiveTakeBase giveTakeBase) {
        boolean z10;
        if (giveTakeBase instanceof RisingGiveTake) {
            if (!this.f12333f.a("LikesYouHardPaywall.Show.Android")) {
                return true;
            }
            String pairLikeComment = ((RisingGiveTake) giveTakeBase).getPairLikeComment();
            if (pairLikeComment != null) {
                if (pairLikeComment.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public final q<com.coffeemeetsbagel.discoverV2.a> L() {
        q<com.coffeemeetsbagel.discoverV2.a> P = this.f12337k.P();
        j.f(P, "actionListenerSubject.hide()");
        return P;
    }

    /* renamed from: P */
    public void v(a aVar, int i10) {
        j.g(aVar, "holder");
        GiveTakeBase giveTakeBase = this.f12336j.get(i10);
        boolean z10 = false;
        RisingGiveTake risingGiveTake = null;
        if (giveTakeBase instanceof GiveTake) {
            z10 = ((GiveTake) giveTakeBase).isLiked();
        } else if (giveTakeBase instanceof RisingGiveTake) {
            risingGiveTake = (RisingGiveTake) giveTakeBase;
            if (risingGiveTake.getAction() == 1) {
                z10 = true;
            }
        }
        aVar.V(giveTakeBase.getProfile(), T(giveTakeBase), z10, i10, risingGiveTake);
    }

    /* renamed from: Q */
    public a x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        return new a(this, new a(viewGroup.getContext(), this.f12331d, this.f12332e, this.f12333f, this.f12334g));
    }

    public final String R(List<? extends GiveTakeBase> list) {
        j.g(list, "newList");
        a.C0491a aVar = fa.a.f40771d;
        String str = this.f12335h;
        int size = list.size();
        aVar.a(str, "setDiscoverBagels: " + size);
        h.e b10 = h.b(new C0133b(this.f12336j, list));
        j.f(b10, "calculateDiff(diffCallback)");
        this.f12336j.clear();
        this.f12336j.addAll(list);
        b10.c(this);
        GiveTakeBase giveTakeBase = this.f12338l;
        if (giveTakeBase == null) {
            return "";
        }
        j.d(giveTakeBase);
        String profileId = giveTakeBase.getProfileId();
        j.f(profileId, "visibleGiveTake!!.profileId");
        return profileId;
    }

    public final void S(GiveTakeBase giveTakeBase) {
        this.f12338l = giveTakeBase;
    }

    public int g() {
        return this.f12336j.size();
    }

    public void u(RecyclerView recyclerView) {
        j.g(recyclerView, "recyclerView");
        super.u(recyclerView);
        recyclerView.l(new c((LinearLayoutManager) recyclerView.getLayoutManager(), this));
    }
}
