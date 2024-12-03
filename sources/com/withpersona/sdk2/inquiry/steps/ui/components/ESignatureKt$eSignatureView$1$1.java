package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.r;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.request.g;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class ESignatureKt$eSignatureView$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UiComponent.ESignature $component;
    final /* synthetic */ r $this_apply;

    public static final class a implements p2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r f27565a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f27566b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UiComponent.ESignature f27567c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r f27568d;

        public a(r rVar, r rVar2, UiComponent.ESignature eSignature, r rVar3) {
            this.f27565a = rVar;
            this.f27566b = rVar2;
            this.f27567c = eSignature;
            this.f27568d = rVar3;
        }

        public void a(Drawable drawable) {
            BitmapDrawable bitmapDrawable;
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) drawable;
            } else {
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                j.f(bitmap, "bitmap");
                this.f27567c.h().c(bitmap);
                this.f27568d.f24887f.setVisibility(0);
                this.f27568d.f24884c.setVisibility(0);
            }
        }

        public void b(Drawable drawable) {
            this.f27565a.f24883b.setVisibility(8);
            this.f27565a.f24884c.setVisibility(8);
            this.f27565a.f24887f.setVisibility(8);
        }

        public void c(Drawable drawable) {
            this.f27566b.f24883b.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ESignatureKt$eSignatureView$1$1(UiComponent.ESignature eSignature, r rVar) {
        super(0);
        this.$component = eSignature;
        this.$this_apply = rVar;
    }

    public final void invoke() {
        String j10;
        UiComponent.ESignature.Attributes E = this.$component.z();
        if (!(E == null || (j10 = E.j()) == null)) {
            r rVar = this.$this_apply;
            UiComponent.ESignature eSignature = this.$component;
            Context context = rVar.f24887f.getContext();
            j.f(context, "signaturePreview.context");
            ImageLoader b10 = new ImageLoader.Builder(context).e(true).d(100).b();
            Context context2 = rVar.f24887f.getContext();
            j.f(context2, "signaturePreview.context");
            b10.a(new g.a(context2).d(j10).q(new a(rVar, rVar, eSignature, rVar)).a());
        }
        UiComponent.ESignatureComponentStyle F = this.$component.F();
        if (F != null) {
            r rVar2 = this.$this_apply;
            j.f(rVar2, "invoke$lambda$5");
            ESignatureKt.b(rVar2, F);
        }
    }
}
