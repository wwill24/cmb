package com.coffeemeetsbagel.limelight.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b6.j;
import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import java.util.List;

public final class d extends b6.c<k, c> {

    public interface a extends j<LimelightDialogInteractor> {
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f34382a;

        /* renamed from: b  reason: collision with root package name */
        private final LimelightDialogInteractor f34383b;

        public b(ViewGroup viewGroup, LimelightDialogInteractor limelightDialogInteractor) {
            kotlin.jvm.internal.j.g(viewGroup, "limelightDialogView");
            kotlin.jvm.internal.j.g(limelightDialogInteractor, "interactor");
            this.f34382a = viewGroup;
            this.f34383b = limelightDialogInteractor;
        }

        public final LimelightDialogPresenter a() {
            Context context = this.f34382a.getContext();
            kotlin.jvm.internal.j.f(context, "limelightDialogView.context");
            return new LimelightDialogPresenter(this.f34382a, this.f34383b, new LimelightDialog(context));
        }
    }

    public interface c {
        NavStateManager A();

        LikesYouMatchRepository C();

        hb.c P();

        s9.a b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super(cVar);
        kotlin.jvm.internal.j.g(cVar, "dependency");
    }

    public final k b(ViewGroup viewGroup, List<String> list, String str, String str2, boolean z10, boolean z11) {
        kotlin.jvm.internal.j.g(viewGroup, "parentViewGroup");
        kotlin.jvm.internal.j.g(list, "imageUrls");
        kotlin.jvm.internal.j.g(str, "title");
        kotlin.jvm.internal.j.g(str2, "description");
        LimelightDialogInteractor limelightDialogInteractor = new LimelightDialogInteractor(list, str, str2, z10, z11);
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        a a10 = b.a().b(new b(frameLayout, limelightDialogInteractor)).c((c) a()).a();
        kotlin.jvm.internal.j.f(a10, "component");
        return new k(frameLayout, a10, limelightDialogInteractor);
    }
}
