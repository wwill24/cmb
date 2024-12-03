package com.coffeemeetsbagel.new_user_experience.photos;

import android.content.Intent;
import b6.d;
import b6.s;
import com.coffeemeetsbagel.dialogs.k0;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.new_user_experience.photos.j;
import com.uber.autodispose.p;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import na.b;
import t8.l;

public final class PhotoManagerInteractor extends s<j, k> implements j.a {

    /* renamed from: f  reason: collision with root package name */
    public d<?, ?> f35548f;

    /* renamed from: g  reason: collision with root package name */
    public l f35549g;

    /* renamed from: h  reason: collision with root package name */
    public b f35550h;

    /* renamed from: j  reason: collision with root package name */
    public ProfileManager f35551j;

    /* renamed from: k  reason: collision with root package name */
    public a7.a f35552k;

    public static final class a implements k0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoManagerInteractor f35553a;

        a(PhotoManagerInteractor photoManagerInteractor) {
            this.f35553a = photoManagerInteractor;
        }

        public void a() {
            String format2 = String.format("Onboarding - No Photo Prompt - %s", Arrays.copyOf(new Object[]{"Skip Button Tapped"}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            this.f35553a.K1().d(format2);
            b.f(this.f35553a.M1(), (Map) null, 1, (Object) null);
        }

        public void b() {
            String format2 = String.format("Onboarding - No Photo Prompt - %s", Arrays.copyOf(new Object[]{"Hardware Back Button Tapped"}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            this.f35553a.K1().d(format2);
        }

        public void onCancel() {
            String format2 = String.format("Onboarding - No Photo Prompt - %s", Arrays.copyOf(new Object[]{"Continue Button Tapped"}, 1));
            kotlin.jvm.internal.j.f(format2, "format(this, *args)");
            this.f35553a.K1().d(format2);
        }
    }

    /* access modifiers changed from: private */
    public static final void J1(Function1 function1, Object obj) {
        kotlin.jvm.internal.j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void P1(c6.a aVar) {
        h5.l.h().onActivityResult(aVar.b(), aVar.c(), aVar.a());
        Intent a10 = aVar.a();
        if (a10 != null) {
            a10.putExtra(Extra.USE_2020_DESIGN_LANGUAGE, true);
        }
        int b10 = aVar.b();
        if (b10 == 1003 || b10 == 6600 || b10 == 6500 || b10 == 6501) {
            N1().i(L1(), aVar.b(), aVar.c(), aVar.a());
        }
    }

    public final a7.a K1() {
        a7.a aVar = this.f35552k;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.j.y("analyticsManager");
        return null;
    }

    public final d<?, ?> L1() {
        d<?, ?> dVar = this.f35548f;
        if (dVar != null) {
            return dVar;
        }
        kotlin.jvm.internal.j.y("componentActivity");
        return null;
    }

    public final b M1() {
        b bVar = this.f35550h;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.j.y("interactionListener");
        return null;
    }

    public final l N1() {
        l lVar = this.f35549g;
        if (lVar != null) {
            return lVar;
        }
        kotlin.jvm.internal.j.y("photoManager");
        return null;
    }

    public final ProfileManager O1() {
        ProfileManager profileManager = this.f35551j;
        if (profileManager != null) {
            return profileManager;
        }
        kotlin.jvm.internal.j.y("profileManager");
        return null;
    }

    public void Y() {
        int i10;
        List<NetworkPhoto> photos;
        NetworkProfile j10 = O1().j();
        if (j10 == null || (photos = j10.getPhotos()) == null) {
            i10 = 0;
        } else {
            i10 = photos.size();
        }
        if (i10 > 0) {
            b.f(M1(), (Map) null, 1, (Object) null);
            return;
        }
        a aVar = new a(this);
        K1().f("Onboarding - No Photo Prompt");
        ((j) this.f7875e).p(aVar);
    }

    public void l() {
        M1().d();
    }

    /* access modifiers changed from: protected */
    public void y1() {
        String userFirstName;
        super.y1();
        NetworkProfile j10 = O1().j();
        if (!(j10 == null || (userFirstName = j10.getUserFirstName()) == null)) {
            ((j) this.f7875e).n(userFirstName);
        }
        ((j) this.f7875e).o(L1().getSupportFragmentManager());
        ((p) L1().F0().a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new f(new PhotoManagerInteractor$didBecomeActive$2(this)));
    }
}
