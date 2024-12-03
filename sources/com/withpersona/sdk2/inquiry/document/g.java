package com.withpersona.sdk2.inquiry.document;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import coil.ImageLoader;
import coil.request.g;
import coil.util.k;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$DocumentStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.TextBasedComponentStyle;
import com.withpersona.sdk2.inquiry.steps.ui.styling.ImageStylingKt;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class g extends RecyclerView.Adapter<RecyclerView.d0> {

    /* renamed from: d  reason: collision with root package name */
    private final ImageLoader f25144d;

    /* renamed from: e  reason: collision with root package name */
    private final Function0<Unit> f25145e;

    /* renamed from: f  reason: collision with root package name */
    private final StepStyles$DocumentStepStyle f25146f;

    /* renamed from: g  reason: collision with root package name */
    private final LayoutInflater f25147g;

    /* renamed from: h  reason: collision with root package name */
    private List<? extends c> f25148h = q.j();

    /* renamed from: j  reason: collision with root package name */
    private Function1<? super DocumentFile, Unit> f25149j;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final ii.b f25150u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ii.b bVar) {
            super(bVar.getRoot());
            j.g(bVar, "binding");
            this.f25150u = bVar;
        }

        public final ii.b V() {
            return this.f25150u;
        }
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final ii.d f25151u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ii.d dVar) {
            super(dVar.getRoot());
            j.g(dVar, "binding");
            this.f25151u = dVar;
        }

        public final ii.d V() {
            return this.f25151u;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* renamed from: a  reason: collision with root package name */
            private final boolean f25152a;

            public a(boolean z10) {
                super((DefaultConstructorMarker) null);
                this.f25152a = z10;
            }

            public final boolean a() {
                return this.f25152a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && this.f25152a == ((a) obj).f25152a;
            }

            public int hashCode() {
                boolean z10 = this.f25152a;
                if (z10) {
                    return 1;
                }
                return z10 ? 1 : 0;
            }

            public String toString() {
                return "AddButtonItem(isEnabled=" + this.f25152a + PropertyUtils.MAPPED_DELIM2;
            }
        }

        public static abstract class b extends c {

            public static final class a extends b {

                /* renamed from: a  reason: collision with root package name */
                private final File f25153a;

                /* renamed from: b  reason: collision with root package name */
                private final DocumentFile.Local f25154b;

                /* renamed from: c  reason: collision with root package name */
                private final String f25155c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(File file, DocumentFile.Local local, String str) {
                    super((DefaultConstructorMarker) null);
                    j.g(file, "file");
                    j.g(local, "document");
                    this.f25153a = file;
                    this.f25154b = local;
                    this.f25155c = str;
                }

                public String b() {
                    return this.f25155c;
                }

                /* renamed from: c */
                public DocumentFile.Local a() {
                    return this.f25154b;
                }

                public final File d() {
                    return this.f25153a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof a)) {
                        return false;
                    }
                    a aVar = (a) obj;
                    return j.b(this.f25153a, aVar.f25153a) && j.b(a(), aVar.a()) && j.b(b(), aVar.b());
                }

                public int hashCode() {
                    return (((this.f25153a.hashCode() * 31) + a().hashCode()) * 31) + (b() == null ? 0 : b().hashCode());
                }

                public String toString() {
                    return "Local(file=" + this.f25153a + ", document=" + a() + ", mimeType=" + b() + PropertyUtils.MAPPED_DELIM2;
                }
            }

            /* renamed from: com.withpersona.sdk2.inquiry.document.g$c$b$b  reason: collision with other inner class name */
            public static final class C0302b extends b {

                /* renamed from: a  reason: collision with root package name */
                private final String f25156a;

                /* renamed from: b  reason: collision with root package name */
                private final String f25157b;

                /* renamed from: c  reason: collision with root package name */
                private final DocumentFile.Remote f25158c;

                /* renamed from: d  reason: collision with root package name */
                private final String f25159d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0302b(String str, String str2, DocumentFile.Remote remote, String str3) {
                    super((DefaultConstructorMarker) null);
                    j.g(str, "remoteUrl");
                    j.g(remote, "document");
                    this.f25156a = str;
                    this.f25157b = str2;
                    this.f25158c = remote;
                    this.f25159d = str3;
                }

                public String b() {
                    return this.f25159d;
                }

                /* renamed from: c */
                public DocumentFile.Remote a() {
                    return this.f25158c;
                }

                public final String d() {
                    return this.f25157b;
                }

                public final String e() {
                    return this.f25156a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0302b)) {
                        return false;
                    }
                    C0302b bVar = (C0302b) obj;
                    return j.b(this.f25156a, bVar.f25156a) && j.b(this.f25157b, bVar.f25157b) && j.b(a(), bVar.a()) && j.b(b(), bVar.b());
                }

                public int hashCode() {
                    int hashCode = this.f25156a.hashCode() * 31;
                    String str = this.f25157b;
                    int i10 = 0;
                    int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a().hashCode()) * 31;
                    if (b() != null) {
                        i10 = b().hashCode();
                    }
                    return hashCode2 + i10;
                }

                public String toString() {
                    return "Remote(remoteUrl=" + this.f25156a + ", filename=" + this.f25157b + ", document=" + a() + ", mimeType=" + b() + PropertyUtils.MAPPED_DELIM2;
                }
            }

            private b() {
                super((DefaultConstructorMarker) null);
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public abstract DocumentFile a();

            public abstract String b();
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class d extends h.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List<c> f25160a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List<c> f25161b;

        d(List<? extends c> list, List<? extends c> list2) {
            this.f25160a = list;
            this.f25161b = list2;
        }

        public boolean a(int i10, int i11) {
            boolean z10;
            c cVar = this.f25160a.get(i10);
            c cVar2 = this.f25161b.get(i11);
            if (b(i10, i11)) {
                if (cVar instanceof c.a) {
                    z10 = j.b(cVar, cVar2);
                } else if (cVar instanceof c.b) {
                    z10 = true;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (z10) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int i10, int i11) {
            c cVar = this.f25160a.get(i10);
            c cVar2 = this.f25161b.get(i11);
            if (cVar.getClass() != cVar2.getClass()) {
                return false;
            }
            if (cVar instanceof c.a) {
                return true;
            }
            if (cVar instanceof c.b.a) {
                String absolutePath = ((c.b.a) cVar).d().getAbsolutePath();
                j.e(cVar2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.document.DocumentTileAdapter.Item.DocumentItem.Local");
                return j.b(absolutePath, ((c.b.a) cVar2).d().getAbsolutePath());
            } else if (cVar instanceof c.b.C0302b) {
                String e10 = ((c.b.C0302b) cVar).e();
                j.e(cVar2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.document.DocumentTileAdapter.Item.DocumentItem.Remote");
                return j.b(e10, ((c.b.C0302b) cVar2).e());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public int d() {
            return this.f25161b.size();
        }

        public int e() {
            return this.f25160a.size();
        }
    }

    public g(Context context, ImageLoader imageLoader, Function0<Unit> function0, StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(imageLoader, "imageLoader");
        j.g(function0, "onClickAddButton");
        this.f25144d = imageLoader;
        this.f25145e = function0;
        this.f25146f = stepStyles$DocumentStepStyle;
        this.f25147g = LayoutInflater.from(context);
    }

    private final void I(ii.b bVar) {
        StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = this.f25146f;
        if (stepStyles$DocumentStepStyle != null) {
            Double q10 = stepStyles$DocumentStepStyle.q();
            if (q10 != null) {
                bVar.f29952c.setRadius((float) ti.b.a(q10.doubleValue()));
            }
            Double r10 = this.f25146f.r();
            if (r10 != null) {
                bVar.f29952c.setStrokeWidth((int) Math.ceil(ti.b.a(r10.doubleValue())));
            }
            String p10 = this.f25146f.p();
            if (p10 != null) {
                bVar.f29952c.setStrokeColor(Color.parseColor(p10));
            }
            String t10 = this.f25146f.t();
            if (t10 != null) {
                bVar.f29951b.setBackgroundColor(Color.parseColor(t10));
            }
            ThemeableLottieAnimationView themeableLottieAnimationView = bVar.f29951b;
            j.f(themeableLottieAnimationView, "binding.addButton");
            ImageStylingKt.e(themeableLottieAnimationView, this.f25146f.w(), this.f25146f.u(), (String) null, new String[]{"#FFFFFF"}, new String[]{"#5B3FD3"}, new String[0]);
        }
    }

    private final void J(ii.d dVar) {
        StepStyles$DocumentStepStyle stepStyles$DocumentStepStyle = this.f25146f;
        if (stepStyles$DocumentStepStyle != null) {
            String C = stepStyles$DocumentStepStyle.C();
            if (C != null) {
                dVar.f29968f.setIndicatorColor(Color.parseColor(C));
            }
            String A0 = this.f25146f.A0();
            if (A0 != null) {
                dVar.f29968f.setTrackColor(Color.parseColor(A0));
            }
            String s10 = this.f25146f.s();
            if (s10 != null) {
                dVar.f29966d.setBackgroundColor(Color.parseColor(s10));
            }
            Double q10 = this.f25146f.q();
            if (q10 != null) {
                dVar.f29964b.setRadius((float) ti.b.a(q10.doubleValue()));
            }
            Double r10 = this.f25146f.r();
            if (r10 != null) {
                dVar.f29964b.setStrokeWidth((int) Math.ceil(ti.b.a(r10.doubleValue())));
            }
            String p10 = this.f25146f.p();
            if (p10 != null) {
                dVar.f29964b.setStrokeColor(Color.parseColor(p10));
            }
            TextBasedComponentStyle o10 = this.f25146f.o();
            if (o10 != null) {
                TextView textView = dVar.f29965c;
                j.f(textView, "binding.filenameView");
                m.e(textView, o10);
            }
            String t10 = this.f25146f.t();
            if (t10 != null) {
                dVar.f29967e.setBackgroundColor(Color.parseColor(t10));
            }
            ThemeableLottieAnimationView themeableLottieAnimationView = dVar.f29969g;
            j.f(themeableLottieAnimationView, "binding.removeButton");
            ImageStylingKt.e(themeableLottieAnimationView, this.f25146f.z(), this.f25146f.x(), (String) null, new String[]{"#6B6D82"}, new String[]{"#FFFFFF"}, new String[0]);
        }
    }

    private final List<c> K(boolean z10, List<? extends DocumentFile> list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (DocumentFile documentFile : list) {
            if (documentFile instanceof DocumentFile.Local) {
                DocumentFile.Local local = (DocumentFile.Local) documentFile;
                File file = new File(local.d());
                obj = new c.b.a(file, local, MimeTypeMap.getSingleton().getMimeTypeFromExtension(j.l(file)));
            } else if (documentFile instanceof DocumentFile.Remote) {
                DocumentFile.Remote remote = (DocumentFile.Remote) documentFile;
                obj = new c.b.C0302b(remote.e(), remote.d(), remote, MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(remote.e())));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
        }
        arrayList.add(new c.a(z10));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void L(g gVar, View view) {
        j.g(gVar, "this$0");
        gVar.f25145e.invoke();
    }

    /* access modifiers changed from: private */
    public static final void M(g gVar, c cVar, View view) {
        j.g(gVar, "this$0");
        j.g(cVar, "$item");
        Function1<? super DocumentFile, Unit> function1 = gVar.f25149j;
        if (function1 != null) {
            function1.invoke(((c.b) cVar).a());
        }
    }

    public final void N(Function1<? super DocumentFile, Unit> function1) {
        this.f25149j = function1;
    }

    public final void O(boolean z10, List<? extends DocumentFile> list) {
        j.g(list, "documents");
        List<c> K = K(z10, list);
        List<? extends c> list2 = this.f25148h;
        h.e b10 = h.b(new d(list2, K));
        j.f(b10, "newItems = generateItems…\n        }\n      }\n    })");
        this.f25148h = K;
        b10.c(this);
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(list2, 10)), 16));
        for (T next : list2) {
            linkedHashMap.put(next, (c) next);
        }
        for (IndexedValue indexedValue : CollectionsKt___CollectionsKt.D0(K)) {
            int a10 = indexedValue.a();
            c cVar = (c) indexedValue.b();
            c cVar2 = (c) linkedHashMap.get(cVar);
            if ((cVar2 instanceof c.b.a) && (cVar instanceof c.b.a)) {
                c.b.a aVar = (c.b.a) cVar;
                if (((c.b.a) cVar2).a().f() != aVar.a().f()) {
                    if (aVar.a().f() == 100) {
                        m(a10);
                    } else {
                        n(a10, Unit.f32013a);
                    }
                }
            }
        }
    }

    public int g() {
        return this.f25148h.size();
    }

    public int i(int i10) {
        c cVar = (c) this.f25148h.get(i10);
        if (cVar instanceof c.a) {
            return l.pi2_document_review_add_document_tile;
        }
        if (cVar instanceof c.b) {
            return l.pi2_document_review_document_tile;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        int i11;
        j.g(d0Var, "holder");
        c cVar = (c) this.f25148h.get(i10);
        if (cVar instanceof c.a) {
            ii.b V = ((a) d0Var).V();
            V.f29951b.setEnabled(((c.a) cVar).a());
            V.f29951b.setOnClickListener(new e(this));
        } else if (cVar instanceof c.b) {
            ii.d V2 = ((b) d0Var).V();
            V2.f29969g.setOnClickListener(new f(this, cVar));
            ImageView imageView = V2.f29966d;
            j.f(imageView, "binding.imageView");
            k.a(imageView);
            V2.f29966d.setImageDrawable((Drawable) null);
            c.b bVar = (c.b) cVar;
            int i12 = 8;
            if (bVar instanceof c.b.a) {
                ImageView imageView2 = V2.f29966d;
                c.b.a aVar = (c.b.a) cVar;
                if (aVar.a().f() < 100) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                imageView2.setVisibility(i11);
                V2.f29969g.setVisibility(8);
                V2.f29965c.setText(aVar.d().getName());
                CircularProgressIndicator circularProgressIndicator = V2.f29968f;
                if (aVar.a().f() < 100) {
                    i12 = 0;
                }
                circularProgressIndicator.setVisibility(i12);
                V2.f29968f.setProgress(aVar.a().f());
            } else if (bVar instanceof c.b.C0302b) {
                V2.f29966d.setVisibility(0);
                if (j.b(bVar.b(), "application/pdf")) {
                    ImageView imageView3 = V2.f29966d;
                    j.f(imageView3, "binding.imageView");
                    Integer valueOf = Integer.valueOf(j.pi2_ic_file_pdf);
                    ImageLoader imageLoader = this.f25144d;
                    g.a p10 = new g.a(imageView3.getContext()).d(valueOf).p(imageView3);
                    p10.m(100, 100);
                    imageLoader.a(p10.a());
                } else {
                    ImageView imageView4 = V2.f29966d;
                    j.f(imageView4, "binding.imageView");
                    String e10 = ((c.b.C0302b) cVar).e();
                    ImageLoader imageLoader2 = this.f25144d;
                    g.a p11 = new g.a(imageView4.getContext()).d(e10).p(imageView4);
                    p11.c(true);
                    p11.b(100);
                    p11.m(500, 500);
                    imageLoader2.a(p11.a());
                }
                V2.f29968f.setVisibility(8);
                V2.f29969g.setVisibility(0);
                V2.f29965c.setText(((c.b.C0302b) cVar).d());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.withpersona.sdk2.inquiry.document.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.withpersona.sdk2.inquiry.document.g$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.withpersona.sdk2.inquiry.document.g$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.withpersona.sdk2.inquiry.document.g$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.recyclerview.widget.RecyclerView.d0 x(android.view.ViewGroup r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.j.g(r3, r0)
            android.view.LayoutInflater r0 = r2.f25147g
            r1 = 0
            android.view.View r3 = r0.inflate(r4, r3, r1)
            int r0 = com.withpersona.sdk2.inquiry.document.l.pi2_document_review_add_document_tile
            java.lang.String r1 = "bind(view)"
            if (r4 != r0) goto L_0x004b
            com.withpersona.sdk2.inquiry.document.g$a r4 = new com.withpersona.sdk2.inquiry.document.g$a
            ii.b r3 = ii.b.a(r3)
            kotlin.jvm.internal.j.f(r3, r1)
            r4.<init>(r3)
            ii.b r3 = r4.V()
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.getRoot()
            android.content.Context r3 = r3.getContext()
            int r0 = com.withpersona.sdk2.inquiry.document.m.pi2_add_document_button
            com.airbnb.lottie.i0 r3 = com.airbnb.lottie.p.u(r3, r0)
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r3.b()
            com.airbnb.lottie.h r3 = (com.airbnb.lottie.h) r3
            if (r3 == 0) goto L_0x0043
            ii.b r0 = r4.V()
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r0 = r0.f29951b
            r0.setComposition(r3)
        L_0x0043:
            ii.b r3 = r4.V()
            r2.I(r3)
            goto L_0x0087
        L_0x004b:
            int r0 = com.withpersona.sdk2.inquiry.document.l.pi2_document_review_document_tile
            if (r4 != r0) goto L_0x0088
            com.withpersona.sdk2.inquiry.document.g$b r4 = new com.withpersona.sdk2.inquiry.document.g$b
            ii.d r3 = ii.d.a(r3)
            kotlin.jvm.internal.j.f(r3, r1)
            r4.<init>(r3)
            ii.d r3 = r4.V()
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.getRoot()
            android.content.Context r3 = r3.getContext()
            int r0 = com.withpersona.sdk2.inquiry.document.m.pi2_remove_document_button
            com.airbnb.lottie.i0 r3 = com.airbnb.lottie.p.u(r3, r0)
            if (r3 == 0) goto L_0x0080
            java.lang.Object r3 = r3.b()
            com.airbnb.lottie.h r3 = (com.airbnb.lottie.h) r3
            if (r3 == 0) goto L_0x0080
            ii.d r0 = r4.V()
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r0 = r0.f29969g
            r0.setComposition(r3)
        L_0x0080:
            ii.d r3 = r4.V()
            r2.J(r3)
        L_0x0087:
            return r4
        L_0x0088:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown view type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.g.x(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$d0");
    }
}
