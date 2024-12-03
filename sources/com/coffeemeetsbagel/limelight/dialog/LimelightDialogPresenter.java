package com.coffeemeetsbagel.limelight.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.uber.autodispose.a;
import java.util.List;
import java.util.Map;
import k6.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;
import w9.b;

public final class LimelightDialogPresenter extends p<ViewGroup> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LimelightDialogInteractor f34374e;

    /* renamed from: f  reason: collision with root package name */
    private final LimelightDialog f34375f;

    /* renamed from: g  reason: collision with root package name */
    private final w f34376g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LimelightDialogPresenter(ViewGroup viewGroup, LimelightDialogInteractor limelightDialogInteractor, LimelightDialog limelightDialog) {
        super(viewGroup);
        j.g(viewGroup, "view");
        j.g(limelightDialogInteractor, "interactor");
        j.g(limelightDialog, "dialog");
        this.f34374e = limelightDialogInteractor;
        this.f34375f = limelightDialog;
        w a10 = limelightDialog.a();
        j.f(a10, "dialog.binding");
        this.f34376g = a10;
    }

    /* access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void q() {
        this.f34375f.dismiss();
    }

    private final void t() {
        this.f34375f.show();
    }

    private final void v(String str, ImageView imageView, int i10) {
        int dimensionPixelSize = this.f34376g.getRoot().getResources().getDimensionPixelSize(R.dimen.zero_dp);
        int dimensionPixelSize2 = this.f34376g.getRoot().getResources().getDimensionPixelSize(R.dimen.four_dp);
        lc.j jVar = lc.j.f41113a;
        Context context = this.f34376g.getRoot().getContext();
        j.f(context, "binding.root.context");
        int a10 = jVar.a(context, R.attr.white);
        Context context2 = this.f34376g.getRoot().getContext();
        j.f(context2, "binding.root.context");
        int a11 = jVar.a(context2, R.attr.main_color);
        b bVar = b.f13967a;
        Context context3 = this.f34376g.getRoot().getContext();
        j.f(context3, "binding.root.context");
        int i11 = i10;
        String str2 = str;
        ImageView imageView2 = imageView;
        ImageLoaderContract.a.a(bVar, context3, str2, imageView2, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, new ImageLoaderContract.b(i11, i11), q.m(b.g.f18337a, b.c.f18331a, b.a.f18329a, new b.d(dimensionPixelSize, dimensionPixelSize2, a10), new b.d(dimensionPixelSize, dimensionPixelSize2, a11)), (Map) null, (Function0) null, (Function1) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0], 3984, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((com.uber.autodispose.p) this.f34375f.c().g(a.a(this))).c(new i(new LimelightDialogPresenter$didLoad$1(this)));
        ((com.uber.autodispose.p) this.f34375f.b().g(a.a(this))).c(new j(new LimelightDialogPresenter$didLoad$2(this)));
    }

    public final void p(String str, String str2, String str3) {
        j.g(str, "imageUrl");
        j.g(str2, "title");
        j.g(str3, "description");
        int dimensionPixelSize = this.f34376g.getRoot().getResources().getDimensionPixelSize(R.dimen.like_dialog_avatar_size);
        this.f34376g.f15843d.setVisibility(8);
        this.f34376g.f15847h.setVisibility(0);
        this.f34376g.f15844e.setVisibility(4);
        this.f34376g.f15846g.setVisibility(4);
        ImageView imageView = this.f34376g.f15845f;
        j.f(imageView, "binding.imageView2");
        v(str, imageView, dimensionPixelSize);
        this.f34376g.f15852n.setText(str2);
        this.f34376g.f15851m.setText(str3);
        t();
    }

    public final void r(List<String> list, String str, String str2) {
        j.g(list, "imageUrlList");
        j.g(str, "title");
        j.g(str2, "description");
        int dimensionPixelSize = this.f34376g.getRoot().getResources().getDimensionPixelSize(R.dimen.photo_size_large);
        int dimensionPixelSize2 = this.f34376g.getRoot().getResources().getDimensionPixelSize(R.dimen.like_dialog_avatar_size);
        this.f34376g.f15843d.setVisibility(8);
        this.f34376g.f15847h.setVisibility(0);
        ImageView imageView = this.f34376g.f15844e;
        j.f(imageView, "binding.imageView1");
        v(list.get(1), imageView, dimensionPixelSize);
        ImageView imageView2 = this.f34376g.f15846g;
        j.f(imageView2, "binding.imageView3");
        v(list.get(2), imageView2, dimensionPixelSize);
        ImageView imageView3 = this.f34376g.f15845f;
        j.f(imageView3, "binding.imageView2");
        v(list.get(0), imageView3, dimensionPixelSize2);
        this.f34376g.f15852n.setText(str);
        this.f34376g.f15851m.setText(str2);
        t();
    }

    public final void u() {
        this.f34376g.f15843d.setVisibility(0);
        this.f34376g.f15847h.setVisibility(8);
        this.f34375f.show();
    }
}
