package com.coffeemeetsbagel.new_user_experience.photos;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import b6.j;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.new_user_experience.photos.j;
import t8.l;

public final class d extends b6.c<k, a> {

    public interface a {
        l P0();

        b6.d<?, ?> a();

        a7.a c();

        ProfileManager d();

        na.b j();
    }

    public interface b extends j<PhotoManagerInteractor> {
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f35559a;

        /* renamed from: b  reason: collision with root package name */
        private final j.a f35560b;

        public c(ViewGroup viewGroup, j.a aVar) {
            kotlin.jvm.internal.j.g(viewGroup, "parentView");
            kotlin.jvm.internal.j.g(aVar, "listener");
            this.f35559a = viewGroup;
            this.f35560b = aVar;
        }

        public final j a() {
            return new j(this.f35559a, this.f35560b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(a aVar) {
        super(aVar);
        kotlin.jvm.internal.j.g(aVar, "dependency");
    }

    public final k b(ViewGroup viewGroup) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        PhotoManagerInteractor photoManagerInteractor = new PhotoManagerInteractor();
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        b a10 = b.a().c(new c(frameLayout, photoManagerInteractor)).b((a) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new k(frameLayout, a10, photoManagerInteractor);
    }
}
