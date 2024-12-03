package com.withpersona.sdk2.inquiry.steps.ui.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import coil.ImageLoader;
import coil.a;
import coil.decode.SvgDecoder;
import coil.request.g;
import com.airbnb.lottie.h;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import vi.e;
import vi.f;

public final class ImagesKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27569a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f27570b;

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|35) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage.ContentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r2 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage.ContentType.JSON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r3 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage.ContentType.SVG     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f27569a = r0
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r3 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.START_HERO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.DOCUMENT_START_HERO     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.ANIMATED_CHECK     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.FAILED     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.ID_FRONT_FAILED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.ID_BACK_FAILED     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.SELFIE_FAILED     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.DOCUMENT_FAILED     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.PASSPORT_NFC_START_HERO     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.PASSPORT_NFC_SCAN_HERO     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.PASSPORT_NFC_SCAN_READY_HERO     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r1 = com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage.Image.PASSPORT_NFC_CHECK     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                f27570b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.a.<clinit>():void");
        }
    }

    public static final View d(Context context, UiComponent.CombinedStepImagePreview combinedStepImagePreview) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(combinedStepImagePreview, "component");
        f c10 = f.c(LayoutInflater.from(context));
        ImageView imageView = c10.f33913b;
        j.f(imageView, "this.imageView");
        k.b(imageView, new ImagesKt$imagePreview$1$1(c10, combinedStepImagePreview));
        ImageView b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…nt.styles)\n    }\n  }.root");
        return b10;
    }

    /* access modifiers changed from: private */
    public static final void e(ImageView imageView, String str) {
        Context context = imageView.getContext();
        j.f(context, "imageView.context");
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        a.C0098a aVar = new a.C0098a();
        aVar.a(new SvgDecoder.b(false, 1, (DefaultConstructorMarker) null));
        builder.c(aVar.e()).e(true).d(500).b().a(new g.a(imageView.getContext()).d(str).p(imageView).a());
    }

    /* access modifiers changed from: private */
    public static final void f(ImageView imageView, String str) {
        Context context = imageView.getContext();
        j.f(context, "imageView.context");
        ImageLoader b10 = new ImageLoader.Builder(context).e(true).d(500).b();
        g.a p10 = new g.a(imageView.getContext()).d(str).p(imageView);
        p10.e(new SvgDecoder.b(false, 1, (DefaultConstructorMarker) null));
        b10.a(p10.a());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v56, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: vi.f} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0463, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View g(android.content.Context r23, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.LocalImage r24) {
        /*
            java.lang.String r0 = "context"
            r7 = r23
            kotlin.jvm.internal.j.g(r7, r0)
            java.lang.String r0 = "component"
            r1 = r24
            kotlin.jvm.internal.j.g(r1, r0)
            android.content.res.Resources r0 = r23.getResources()
            int r2 = ti.f.pi2_default_local_image_height
            float r0 = r0.getDimension(r2)
            int r0 = (int) r0
            android.content.res.Resources r2 = r23.getResources()
            int r3 = ti.f.pi2_small_default_local_image_height
            float r2 = r2.getDimension(r3)
            int r2 = (int) r2
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Attributes r3 = r24.z()
            r8 = 0
            if (r3 == 0) goto L_0x0030
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage$Image r3 = r3.a()
            goto L_0x0031
        L_0x0030:
            r3 = r8
        L_0x0031:
            if (r3 != 0) goto L_0x0035
            r3 = -1
            goto L_0x003d
        L_0x0035:
            int[] r4 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.a.f27570b
            int r3 = r3.ordinal()
            r3 = r4[r3]
        L_0x003d:
            java.lang.String r4 = "#F2EAFF"
            java.lang.String r9 = "#FFFFFF"
            java.lang.String r10 = "#190051"
            java.lang.String r11 = "#02214F"
            java.lang.String r5 = "{\n        Pi2UiImageLott…      )\n        }\n      }"
            java.lang.String r6 = "#AA84FF"
            java.lang.String r12 = "{\n        Pi2UiImageView…      }\n        }\n      }"
            java.lang.String r13 = "imageView"
            r14 = 0
            java.lang.String r15 = "lottieView"
            switch(r3) {
                case -1: goto L_0x0465;
                case 0: goto L_0x0053;
                case 1: goto L_0x0413;
                case 2: goto L_0x03c1;
                case 3: goto L_0x0399;
                case 4: goto L_0x0348;
                case 5: goto L_0x02f7;
                case 6: goto L_0x02a6;
                case 7: goto L_0x0255;
                case 8: goto L_0x0200;
                case 9: goto L_0x01ad;
                case 10: goto L_0x0131;
                case 11: goto L_0x00be;
                case 12: goto L_0x0059;
                default: goto L_0x0053;
            }
        L_0x0053:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0059:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_passport_nfc_check
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            java.lang.String r9 = "#280087"
            if (r2 == 0) goto L_0x0085
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r9}
            java.lang.String[] r4 = new java.lang.String[r14]
            java.lang.String[] r5 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r5)
            goto L_0x00af
        L_0x0085:
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r10 = r0.f33911b
            kotlin.jvm.internal.j.f(r10, r15)
            int r2 = ti.e.colorPrimaryVariant
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r23
            int r1 = ti.n.d(r1, r2, r3, r4, r5, r6)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r1)
            r18 = 0
            r19 = 0
            java.lang.String[] r20 = new java.lang.String[]{r9}
            java.lang.String[] r1 = new java.lang.String[r14]
            java.lang.String[] r2 = new java.lang.String[r14]
            r16 = r10
            r21 = r1
            r22 = r2
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.d(r16, r17, r18, r19, r20, r21, r22)
        L_0x00af:
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r0.f33911b
            kotlin.jvm.internal.j.f(r1, r15)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$20$1 r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$20$1
            r2.<init>(r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r2)
            goto L_0x0466
        L_0x00be:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_passport_nfc_scan_ready_hero
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$19$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$19$1
            r3.<init>(r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r2, r3)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            java.lang.String r9 = "#E5E5EA"
            if (r2 == 0) goto L_0x00fa
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r11, r10}
            java.lang.String[] r4 = new java.lang.String[]{r9}
            java.lang.String[] r5 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r5)
            goto L_0x0466
        L_0x00fa:
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r12 = r0.f33911b
            kotlin.jvm.internal.j.f(r12, r15)
            int r2 = ti.e.colorPrimaryVariant
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r23
            int r1 = ti.n.d(r1, r2, r3, r4, r5, r6)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            int r2 = ti.e.colorSecondary
            r1 = r23
            int r1 = ti.n.d(r1, r2, r3, r4, r5, r6)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[]{r11, r10}
            java.lang.String[] r4 = new java.lang.String[]{r9}
            java.lang.String[] r15 = new java.lang.String[r14]
            r9 = r12
            r10 = r13
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.d(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0466
        L_0x0131:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_passport_nfc_scan_hero
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            r2.y()
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            java.lang.String r10 = "#8552FF"
            java.lang.String r11 = "#F1EBFF"
            java.lang.String r12 = "#190052"
            if (r2 == 0) goto L_0x016a
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r12}
            java.lang.String[] r4 = new java.lang.String[]{r11, r10}
            java.lang.String[] r5 = new java.lang.String[]{r9}
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r5)
            goto L_0x019e
        L_0x016a:
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r13 = r0.f33911b
            kotlin.jvm.internal.j.f(r13, r15)
            int r2 = ti.e.colorPrimaryVariant
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            r1 = r23
            int r1 = ti.n.d(r1, r2, r3, r4, r5, r6)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r1)
            int r2 = ti.e.colorSecondary
            r1 = r23
            int r1 = ti.n.d(r1, r2, r3, r4, r5, r6)
            java.lang.Integer r18 = java.lang.Integer.valueOf(r1)
            r19 = 0
            java.lang.String[] r20 = new java.lang.String[]{r12}
            java.lang.String[] r21 = new java.lang.String[]{r11, r10}
            java.lang.String[] r22 = new java.lang.String[]{r9}
            r16 = r13
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.d(r16, r17, r18, r19, r20, r21, r22)
        L_0x019e:
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r0.f33911b
            kotlin.jvm.internal.j.f(r1, r15)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$18$1 r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$18$1
            r2.<init>(r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r2)
            goto L_0x0466
        L_0x01ad:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            if (r2 == 0) goto L_0x01df
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_passport_nfc_start_hero
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r10, r11}
            java.lang.String[] r4 = new java.lang.String[]{r6}
            java.lang.String[] r6 = new java.lang.String[]{r6}
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x01df:
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r23)
            vi.f r1 = vi.f.c(r1)
            android.widget.ImageView r2 = r1.f33913b
            int r3 = ti.g.pi2_passport_nfc_start_hero
            r2.setImageResource(r3)
            android.widget.ImageView r2 = r1.f33913b
            kotlin.jvm.internal.j.f(r2, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$17$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$17$1
            r3.<init>(r1, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r2, r3)
            kotlin.jvm.internal.j.f(r1, r12)
            goto L_0x0463
        L_0x0200:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            if (r2 == 0) goto L_0x0234
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_document_failed
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String r3 = "#4C4293"
            java.lang.String[] r3 = new java.lang.String[]{r3}
            java.lang.String r4 = "#B5B5CC"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            java.lang.String[] r6 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x0234:
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r23)
            vi.f r1 = vi.f.c(r1)
            android.widget.ImageView r2 = r1.f33913b
            int r3 = ti.g.pi2_document_failed
            r2.setImageResource(r3)
            android.widget.ImageView r2 = r1.f33913b
            kotlin.jvm.internal.j.f(r2, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$15$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$15$1
            r3.<init>(r1, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r2, r3)
            kotlin.jvm.internal.j.f(r1, r12)
            goto L_0x0463
        L_0x0255:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r0 = r24.D()
            if (r0 == 0) goto L_0x0285
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_selfie_fail
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r10}
            java.lang.String[] r4 = new java.lang.String[]{r6}
            java.lang.String[] r6 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x0285:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.f r0 = vi.f.c(r0)
            android.widget.ImageView r1 = r0.f33913b
            int r3 = ti.g.pi2_selfie_fail
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r0.f33913b
            kotlin.jvm.internal.j.f(r1, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$13$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$13$1
            r3.<init>(r0, r2)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r3)
            kotlin.jvm.internal.j.f(r0, r12)
            goto L_0x0466
        L_0x02a6:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r0 = r24.D()
            if (r0 == 0) goto L_0x02d6
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_id_back_fail
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r10}
            java.lang.String[] r4 = new java.lang.String[]{r6}
            java.lang.String[] r6 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x02d6:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.f r0 = vi.f.c(r0)
            android.widget.ImageView r1 = r0.f33913b
            int r3 = ti.g.pi2_id_back_fail
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r0.f33913b
            kotlin.jvm.internal.j.f(r1, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$11$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$11$1
            r3.<init>(r0, r2)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r3)
            kotlin.jvm.internal.j.f(r0, r12)
            goto L_0x0466
        L_0x02f7:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r0 = r24.D()
            if (r0 == 0) goto L_0x0327
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_id_front_fail
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r10}
            java.lang.String[] r4 = new java.lang.String[]{r6}
            java.lang.String[] r6 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x0327:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.f r0 = vi.f.c(r0)
            android.widget.ImageView r1 = r0.f33913b
            int r3 = ti.g.pi2_id_front_fail
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r0.f33913b
            kotlin.jvm.internal.j.f(r1, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$9$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$9$1
            r3.<init>(r0, r2)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r3)
            kotlin.jvm.internal.j.f(r0, r12)
            goto L_0x0466
        L_0x0348:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r0 = r24.D()
            if (r0 == 0) goto L_0x0378
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_inquiry_failed
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r11}
            java.lang.String[] r4 = new java.lang.String[]{r6}
            java.lang.String[] r6 = new java.lang.String[r14]
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x0378:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.f r0 = vi.f.c(r0)
            android.widget.ImageView r1 = r0.f33913b
            int r3 = ti.g.pi2_inquiry_failed
            r1.setImageResource(r3)
            android.widget.ImageView r1 = r0.f33913b
            kotlin.jvm.internal.j.f(r1, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$7$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$7$1
            r3.<init>(r0, r2)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r3)
            kotlin.jvm.internal.j.f(r0, r12)
            goto L_0x0466
        L_0x0399:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r0.f33911b
            int r2 = ti.j.pi2_inquiry_successanimation
            r1.setAnimation((int) r2)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r0.f33911b
            kotlin.jvm.internal.j.f(r1, r15)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$5$1 r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$5$1
            r2.<init>(r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r2)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r0.f33911b
            com.withpersona.sdk2.inquiry.steps.ui.components.c r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.c
            r2.<init>(r0)
            r1.j(r2)
            goto L_0x0466
        L_0x03c1:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            if (r2 == 0) goto L_0x03f3
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_document_start_hero
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r11}
            java.lang.String[] r4 = new java.lang.String[]{r6, r4}
            java.lang.String[] r6 = new java.lang.String[]{r9}
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x03f3:
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r23)
            vi.f r1 = vi.f.c(r1)
            android.widget.ImageView r2 = r1.f33913b
            int r3 = ti.g.pi2_document_start_hero
            r2.setImageResource(r3)
            android.widget.ImageView r2 = r1.f33913b
            kotlin.jvm.internal.j.f(r2, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$4$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$4$1
            r3.<init>(r1, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r2, r3)
            kotlin.jvm.internal.j.f(r1, r12)
            goto L_0x0463
        L_0x0413:
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r2 = r24.D()
            if (r2 == 0) goto L_0x0444
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r23)
            vi.e r0 = vi.e.c(r0)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            int r3 = ti.j.pi2_inquiry_start_hero
            r2.setAnimation((int) r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r2 = r0.f33911b
            kotlin.jvm.internal.j.f(r2, r15)
            com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle r1 = r24.D()
            java.lang.String[] r3 = new java.lang.String[]{r11}
            java.lang.String[] r4 = new java.lang.String[]{r6, r4}
            java.lang.String[] r6 = new java.lang.String[]{r9}
            com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt.b(r2, r1, r3, r4, r6)
            kotlin.jvm.internal.j.f(r0, r5)
            goto L_0x0466
        L_0x0444:
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r23)
            vi.f r1 = vi.f.c(r1)
            android.widget.ImageView r2 = r1.f33913b
            int r3 = ti.g.pi2_inquiry_start_hero
            r2.setImageResource(r3)
            android.widget.ImageView r2 = r1.f33913b
            kotlin.jvm.internal.j.f(r2, r13)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$2$1 r3 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$localImageView$2$1
            r3.<init>(r1, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r2, r3)
            kotlin.jvm.internal.j.f(r1, r12)
        L_0x0463:
            r0 = r1
            goto L_0x0466
        L_0x0465:
            r0 = r8
        L_0x0466:
            if (r0 == 0) goto L_0x046c
            android.view.View r8 = r0.getRoot()
        L_0x046c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.g(android.content.Context, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$LocalImage):android.view.View");
    }

    /* access modifiers changed from: private */
    public static final void h(e eVar, h hVar) {
        j.g(eVar, "$this_apply");
        eVar.f33911b.y();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: vi.f} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.view.View i(android.content.Context r5, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage r6) {
        /*
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r0 = r6.z()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.g()
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            if (r0 == 0) goto L_0x009c
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r0 = r6.z()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r0 = r0.f()
            if (r0 != 0) goto L_0x001b
            goto L_0x009c
        L_0x001b:
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r0 = r6.z()
            java.lang.String r0 = r0.g()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r2 = r6.z()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r2 = r2.f()
            r3 = -1
            if (r2 != 0) goto L_0x0030
            r2 = r3
            goto L_0x0038
        L_0x0030:
            int[] r4 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.a.f27569a
            int r2 = r2.ordinal()
            r2 = r4[r2]
        L_0x0038:
            r4 = 1
            if (r2 != r4) goto L_0x0042
            com.withpersona.sdk2.inquiry.shared.ResourceType r2 = com.withpersona.sdk2.inquiry.shared.ResourceType.raw
            java.lang.Integer r0 = ti.n.g(r5, r0, r2)
            goto L_0x0048
        L_0x0042:
            com.withpersona.sdk2.inquiry.shared.ResourceType r2 = com.withpersona.sdk2.inquiry.shared.ResourceType.drawable
            java.lang.Integer r0 = ti.n.g(r5, r0, r2)
        L_0x0048:
            if (r0 == 0) goto L_0x009c
            int r0 = r0.intValue()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r1 = r6.z()
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r1 = r1.f()
            if (r1 != 0) goto L_0x0059
            goto L_0x0061
        L_0x0059:
            int[] r2 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.a.f27569a
            int r1 = r1.ordinal()
            r3 = r2[r1]
        L_0x0061:
            if (r3 != r4) goto L_0x0080
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            vi.e r5 = vi.e.c(r5)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r1 = r5.f33911b
            java.lang.String r2 = "lottieView"
            kotlin.jvm.internal.j.f(r1, r2)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromBundledResource$1$1 r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromBundledResource$1$1
            r2.<init>(r5, r6)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r2)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r6 = r5.f33911b
            r6.setAnimation((int) r0)
            goto L_0x0097
        L_0x0080:
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            vi.f r5 = vi.f.c(r5)
            android.widget.ImageView r1 = r5.f33913b
            java.lang.String r2 = "imageView"
            kotlin.jvm.internal.j.f(r1, r2)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromBundledResource$2$1 r2 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromBundledResource$2$1
            r2.<init>(r5, r6, r0)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r1, r2)
        L_0x0097:
            android.view.View r5 = r5.getRoot()
            return r5
        L_0x009c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.i(android.content.Context, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage):android.view.View");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: vi.f} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: vi.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: vi.e} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final android.view.View j(android.content.Context r3, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage r4) {
        /*
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r0 = r4.z()
            if (r0 == 0) goto L_0x000b
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$ContentType r0 = r0.d()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0010
            r0 = -1
            goto L_0x0018
        L_0x0010:
            int[] r1 = com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.a.f27569a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x0018:
            r1 = 1
            if (r0 == r1) goto L_0x004c
            r1 = 2
            java.lang.String r2 = "imageView"
            if (r0 == r1) goto L_0x0036
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            vi.f r3 = vi.f.c(r3)
            android.widget.ImageView r0 = r3.f33913b
            kotlin.jvm.internal.j.f(r0, r2)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$3$1 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$3$1
            r1.<init>(r3, r4)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r0, r1)
            goto L_0x0070
        L_0x0036:
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            vi.f r3 = vi.f.c(r3)
            android.widget.ImageView r0 = r3.f33913b
            kotlin.jvm.internal.j.f(r0, r2)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$1$1 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$1$1
            r1.<init>(r3, r4)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r0, r1)
            goto L_0x0070
        L_0x004c:
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            vi.e r3 = vi.e.c(r3)
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r0 = r3.f33911b
            java.lang.String r1 = "lottieView"
            kotlin.jvm.internal.j.f(r0, r1)
            com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$2$1 r1 = new com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt$remoteImageFromUrl$2$1
            r1.<init>(r3, r4)
            com.withpersona.sdk2.inquiry.shared.ui.k.b(r0, r1)
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage$Attributes r4 = r4.z()
            java.lang.String r4 = r4.h()
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r0 = r3.f33911b
            r0.J(r4)
        L_0x0070:
            android.view.View r3 = r3.getRoot()
            java.lang.String r4 = "when (component.attribut… }\n      }\n    }\n  }.root"
            kotlin.jvm.internal.j.f(r3, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.ImagesKt.j(android.content.Context, com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent$RemoteImage):android.view.View");
    }

    public static final View k(Context context, UiComponent.RemoteImage remoteImage) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(remoteImage, "component");
        View i10 = i(context, remoteImage);
        return i10 == null ? j(context, remoteImage) : i10;
    }
}
