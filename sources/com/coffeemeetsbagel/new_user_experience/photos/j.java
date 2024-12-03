package com.coffeemeetsbagel.new_user_experience.photos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.b0;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.k0;
import f8.n;

public final class j extends p<ViewGroup> {

    /* renamed from: e  reason: collision with root package name */
    private final a f35564e;

    /* renamed from: f  reason: collision with root package name */
    private FragmentManager f35565f;

    /* renamed from: g  reason: collision with root package name */
    private final String f35566g = "MyPhotosFragmentTag";

    public interface a {
        void Y();

        void l();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ViewGroup viewGroup, a aVar) {
        super(viewGroup);
        kotlin.jvm.internal.j.g(viewGroup, "view");
        kotlin.jvm.internal.j.g(aVar, "listener");
        this.f35564e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void l(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f35564e.Y();
    }

    /* access modifiers changed from: private */
    public static final void m(j jVar, View view) {
        kotlin.jvm.internal.j.g(jVar, "this$0");
        jVar.f35564e.l();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        View inflate = LayoutInflater.from(((ViewGroup) this.f7869c).getContext()).inflate(R.layout.component_onboarding_photos_grid, (ViewGroup) this.f7869c, false);
        kotlin.jvm.internal.j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        viewGroup.findViewById(R.id.photos_done_button).setOnClickListener(new h(this));
        viewGroup.findViewById(R.id.photos_back_button).setOnClickListener(new i(this));
        ((ViewGroup) this.f7869c).addView(viewGroup);
    }

    /* access modifiers changed from: protected */
    public void i() {
        Fragment j02;
        FragmentManager fragmentManager;
        b0 p10;
        b0 r10;
        super.i();
        FragmentManager fragmentManager2 = this.f35565f;
        if (fragmentManager2 != null && (j02 = fragmentManager2.j0(this.f35566g)) != null && (fragmentManager = this.f35565f) != null && (p10 = fragmentManager.p()) != null && (r10 = p10.r(j02)) != null) {
            r10.k();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0011
            int r2 = r5.length()
            if (r2 <= 0) goto L_0x000c
            r2 = r0
            goto L_0x000d
        L_0x000c:
            r2 = r1
        L_0x000d:
            if (r2 != r0) goto L_0x0011
            r2 = r0
            goto L_0x0012
        L_0x0011:
            r2 = r1
        L_0x0012:
            if (r2 == 0) goto L_0x003f
            V r2 = r4.f7869c
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131886912(0x7f120340, float:1.9408416E38)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r5
            java.lang.String r5 = r2.getString(r3, r0)
            java.lang.String r0 = "view.resources.getString…hotos_grid_caption, name)"
            kotlin.jvm.internal.j.f(r5, r0)
            V r0 = r4.f7869c
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = 2131297362(0x7f090452, float:1.8212667E38)
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            if (r0 != 0) goto L_0x003c
            goto L_0x003f
        L_0x003c:
            r0.setText(r5)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.new_user_experience.photos.j.n(java.lang.String):void");
    }

    public final void o(FragmentManager fragmentManager) {
        Fragment fragment;
        b0 p10;
        b0 c10;
        this.f35565f = fragmentManager;
        if (fragmentManager != null) {
            fragment = fragmentManager.j0(this.f35566g);
        } else {
            fragment = null;
        }
        if (fragment == null) {
            fragment = new n();
        }
        if (!fragment.isAdded() && fragmentManager != null && (p10 = fragmentManager.p()) != null && (c10 = p10.c(R.id.my_photos_fragment, fragment, this.f35566g)) != null) {
            c10.i();
        }
    }

    public final void p(k0.a aVar) {
        kotlin.jvm.internal.j.g(aVar, "skipListener");
        Context context = ((ViewGroup) this.f7869c).getContext();
        kotlin.jvm.internal.j.f(context, "view.context");
        k0 k0Var = new k0(aVar, context);
        k0Var.c(R.string.onboarding_photos_grid_skip);
        k0Var.show();
    }
}
