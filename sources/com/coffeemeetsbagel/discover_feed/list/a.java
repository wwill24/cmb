package com.coffeemeetsbagel.discover_feed.list;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.discover_feed.ActionListenerEvent;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.GiveTake;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.RisingGiveTake;
import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import com.coffeemeetsbagel.store.k0;
import java.util.ArrayList;
import java.util.List;
import qj.q;
import r6.d;

public class a extends RecyclerView.Adapter<C0134a> {

    /* renamed from: d  reason: collision with root package name */
    private final List<GiveTakeBase> f12376d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ProfileContract$Manager f12377e;

    /* renamed from: f  reason: collision with root package name */
    private final k0 f12378f;

    /* renamed from: g  reason: collision with root package name */
    private final s9.a f12379g;

    /* renamed from: h  reason: collision with root package name */
    private final a6.a f12380h;

    /* renamed from: j  reason: collision with root package name */
    private final io.reactivex.subjects.a<o6.a> f12381j = io.reactivex.subjects.a.C0();

    /* renamed from: com.coffeemeetsbagel.discover_feed.list.a$a  reason: collision with other inner class name */
    public class C0134a extends RecyclerView.d0 implements z7.a {

        /* renamed from: u  reason: collision with root package name */
        private d f12382u;

        /* renamed from: v  reason: collision with root package name */
        private int f12383v;

        public C0134a(View view) {
            super(view);
            this.f12382u = (d) view;
        }

        public void V(NetworkProfile networkProfile, boolean z10, boolean z11, int i10, RisingGiveTake risingGiveTake) {
            this.f12383v = i10;
            this.f12382u.y(networkProfile, z10, 0, 0, 0, "", z11, (String) null, risingGiveTake);
            this.f12382u.x(this);
        }

        public void W() {
            this.f12382u.A();
        }

        public void X(int i10) {
            this.f12382u.setPhotoPosition(i10);
        }

        public void Y() {
            this.f12382u.N(0);
        }

        public void Z() {
            this.f12382u.O();
        }

        public void a0() {
            this.f12382u.P(0);
        }

        public void b() {
            a.this.K(this.f12383v);
        }

        public void d(int i10) {
            a.this.L(this.f12383v, i10, this.f12382u);
        }

        public void p() {
            a.this.M(this.f12383v);
        }
    }

    public a(ProfileContract$Manager profileContract$Manager, k0 k0Var, s9.a aVar, a6.a aVar2) {
        this.f12377e = profileContract$Manager;
        this.f12378f = k0Var;
        this.f12379g = aVar;
        this.f12380h = aVar2;
    }

    /* access modifiers changed from: private */
    public void K(int i10) {
        this.f12381j.d(new o6.a(ActionListenerEvent.LIKED, i10, this.f12376d.get(i10) instanceof RisingGiveTake, (Integer) null));
    }

    /* access modifiers changed from: private */
    public void L(int i10, int i11, d dVar) {
        o6.a aVar = new o6.a(ActionListenerEvent.PROFILE_PICTURE_CLICKED, i10, this.f12376d.get(i10) instanceof RisingGiveTake, Integer.valueOf(i11));
        aVar.f(dVar);
        aVar.g(this.f12376d.get(i10).getProfile());
        this.f12381j.d(aVar);
    }

    /* access modifiers changed from: private */
    public void M(int i10) {
        this.f12381j.d(new o6.a(ActionListenerEvent.FLOWER_CLICKED, i10, this.f12376d.get(i10) instanceof RisingGiveTake, (Integer) null));
    }

    private boolean Q(GiveTakeBase giveTakeBase) {
        if (!(giveTakeBase instanceof RisingGiveTake)) {
            return false;
        }
        if (!this.f12379g.a("LikesYouHardPaywall.Show.Android") && !this.f12379g.a("LYDF.Milestone4.Show.Android")) {
            return true;
        }
        String pairLikeComment = ((RisingGiveTake) giveTakeBase).getPairLikeComment();
        if (pairLikeComment == null || pairLikeComment.isEmpty()) {
            return false;
        }
        return true;
    }

    public q<o6.a> J() {
        return this.f12381j.P();
    }

    /* renamed from: N */
    public void v(@NonNull C0134a aVar, int i10) {
        GiveTakeBase giveTakeBase = this.f12376d.get(i10);
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
        aVar.V(giveTakeBase.getProfile(), Q(giveTakeBase), z10, i10, risingGiveTake);
    }

    @NonNull
    /* renamed from: O */
    public C0134a x(@NonNull ViewGroup viewGroup, int i10) {
        return new C0134a(new d(viewGroup.getContext(), this.f12377e, this.f12378f, this.f12379g, this.f12380h));
    }

    public void P(List<GiveTakeBase> list) {
        this.f12376d.clear();
        this.f12376d.addAll(list);
        l();
    }

    public int g() {
        return this.f12376d.size();
    }
}
