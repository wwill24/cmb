package com.coffeemeetsbagel.image_loader.glide;

import android.renderscript.RenderScript;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class GlideImageLoader$renderScript$2 extends Lambda implements Function0<RenderScript> {
    final /* synthetic */ GlideImageLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlideImageLoader$renderScript$2(GlideImageLoader glideImageLoader) {
        super(0);
        this.this$0 = glideImageLoader;
    }

    /* renamed from: a */
    public final RenderScript invoke() {
        return RenderScript.create(this.this$0.f13973a);
    }
}
