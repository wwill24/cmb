package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.l0;
import androidx.camera.core.o1;
import com.withpersona.sdk2.camera.AutoCaptureRule;
import com.withpersona.sdk2.camera.ParsedIdSideOrNone;
import com.withpersona.sdk2.camera.analyzers.AnalysisError;
import com.withpersona.sdk2.camera.analyzers.BarcodePdf417Analyzer;
import com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer;
import com.withpersona.sdk2.camera.analyzers.IdFrontAnalyzer;
import com.withpersona.sdk2.camera.analyzers.MrzAnalyzer;
import com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer;
import com.withpersona.sdk2.camera.analyzers.a;
import com.withpersona.sdk2.camera.analyzers.b;
import com.withpersona.sdk2.camera.camera2.a;
import gk.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.l;

public final class GovernmentIdFeed implements l0.a, l<Result<? extends ParsedIdSideOrNone>>, a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h<Result<ParsedIdSideOrNone>> f14127a;

    /* renamed from: b  reason: collision with root package name */
    private ParsedIdSideOrNone.Side f14128b;

    /* renamed from: c  reason: collision with root package name */
    private List<? extends b> f14129c = q.j();

    /* renamed from: d  reason: collision with root package name */
    private List<? extends b> f14130d = q.j();

    /* renamed from: e  reason: collision with root package name */
    private y f14131e;

    public GovernmentIdFeed(h<Result<ParsedIdSideOrNone>> hVar) {
        j.g(hVar, "resultFlow");
        this.f14127a = hVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object l(com.withpersona.sdk2.camera.s r14, kotlin.coroutines.c<? super kotlin.Result<? extends com.withpersona.sdk2.camera.ParsedIdSideOrNone>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$1 r0 = (com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$1 r0 = new com.withpersona.sdk2.camera.GovernmentIdFeed$analyze$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x0054
            if (r2 != r3) goto L_0x004c
            java.lang.Object r14 = r0.L$5
            java.util.Collection r14 = (java.util.Collection) r14
            java.lang.Object r2 = r0.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$3
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            java.lang.Object r6 = r0.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$1
            com.withpersona.sdk2.camera.s r7 = (com.withpersona.sdk2.camera.s) r7
            java.lang.Object r8 = r0.L$0
            com.withpersona.sdk2.camera.GovernmentIdFeed r8 = (com.withpersona.sdk2.camera.GovernmentIdFeed) r8
            gk.g.b(r15)
            kotlin.Result r15 = (kotlin.Result) r15
            java.lang.Object r15 = r15.j()
            goto L_0x0100
        L_0x004c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0054:
            java.lang.Object r14 = r0.L$5
            java.util.Collection r14 = (java.util.Collection) r14
            java.lang.Object r2 = r0.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r0.L$3
            android.graphics.Rect r6 = (android.graphics.Rect) r6
            java.lang.Object r7 = r0.L$2
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$1
            com.withpersona.sdk2.camera.s r8 = (com.withpersona.sdk2.camera.s) r8
            java.lang.Object r9 = r0.L$0
            com.withpersona.sdk2.camera.GovernmentIdFeed r9 = (com.withpersona.sdk2.camera.GovernmentIdFeed) r9
            gk.g.b(r15)
            kotlin.Result r15 = (kotlin.Result) r15
            java.lang.Object r15 = r15.j()
            goto L_0x00ca
        L_0x0076:
            gk.g.b(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            android.graphics.Rect r2 = r13.n(r14)
            android.graphics.Rect r6 = new android.graphics.Rect
            int r7 = r14.getWidth()
            int r8 = r14.getHeight()
            r6.<init>(r4, r4, r7, r8)
            if (r2 == 0) goto L_0x0098
            boolean r6 = r6.contains(r2)
            if (r6 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r2 = 0
        L_0x0099:
            java.util.List<? extends com.withpersona.sdk2.camera.analyzers.b> r6 = r13.f14129c
            java.util.Iterator r6 = r6.iterator()
            r9 = r13
            r11 = r15
            r15 = r14
            r14 = r11
            r12 = r6
            r6 = r2
            r2 = r12
        L_0x00a6:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x00d5
            java.lang.Object r7 = r2.next()
            com.withpersona.sdk2.camera.analyzers.b r7 = (com.withpersona.sdk2.camera.analyzers.b) r7
            r0.L$0 = r9
            r0.L$1 = r15
            r0.L$2 = r14
            r0.L$3 = r6
            r0.L$4 = r2
            r0.L$5 = r14
            r0.label = r5
            java.lang.Object r7 = r7.a(r15, r6, r0)
            if (r7 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            r8 = r15
            r15 = r7
            r7 = r14
        L_0x00ca:
            com.withpersona.sdk2.camera.b r10 = new com.withpersona.sdk2.camera.b
            r10.<init>(r15, r5)
            r14.add(r10)
            r14 = r7
            r15 = r8
            goto L_0x00a6
        L_0x00d5:
            java.util.List<? extends com.withpersona.sdk2.camera.analyzers.b> r2 = r9.f14130d
            java.util.Iterator r2 = r2.iterator()
            r7 = r15
            r5 = r6
            r8 = r9
        L_0x00de:
            boolean r15 = r2.hasNext()
            if (r15 == 0) goto L_0x010a
            java.lang.Object r15 = r2.next()
            com.withpersona.sdk2.camera.analyzers.b r15 = (com.withpersona.sdk2.camera.analyzers.b) r15
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r14
            r0.L$3 = r5
            r0.L$4 = r2
            r0.L$5 = r14
            r0.label = r3
            java.lang.Object r15 = r15.a(r7, r5, r0)
            if (r15 != r1) goto L_0x00ff
            return r1
        L_0x00ff:
            r6 = r14
        L_0x0100:
            com.withpersona.sdk2.camera.b r9 = new com.withpersona.sdk2.camera.b
            r9.<init>(r15, r4)
            r14.add(r9)
            r14 = r6
            goto L_0x00de
        L_0x010a:
            java.lang.Object r14 = r8.o(r7, r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.GovernmentIdFeed.l(com.withpersona.sdk2.camera.s, kotlin.coroutines.c):java.lang.Object");
    }

    private final Rect n(s sVar) {
        int i10;
        int i11;
        double d10;
        y yVar = this.f14131e;
        if (yVar == null) {
            return null;
        }
        int width = yVar.b().width();
        int height = yVar.b().height();
        if (width == 0 || height == 0) {
            return null;
        }
        if (sVar.a() == 90 || sVar.a() == 270) {
            i11 = sVar.getHeight();
            i10 = sVar.getWidth();
        } else {
            i11 = sVar.getWidth();
            i10 = sVar.getHeight();
        }
        double d11 = (double) i11;
        double d12 = (double) width;
        double d13 = d11 / d12;
        double d14 = (double) i10;
        double d15 = (double) height;
        double d16 = d14 / d15;
        double min = Math.min(d13, d16);
        double d17 = 0.0d;
        if (d13 > d16) {
            d10 = 0.0d;
            d17 = (d11 - (d12 * min)) / 2.0d;
        } else {
            d10 = (d14 - (d15 * min)) / 2.0d;
        }
        double d18 = d17 + (((double) (yVar.a().left - yVar.b().left)) * min);
        double d19 = d10 + (((double) (yVar.a().top - yVar.b().top)) * min);
        double width2 = ((double) yVar.a().width()) * min;
        double height2 = ((double) yVar.a().height()) * min;
        if (sVar.a() == 90 || sVar.a() == 270) {
            return new Rect((int) d19, (int) d18, (int) (d19 + height2), (int) (d18 + width2));
        }
        return new Rect((int) d18, (int) d19, (int) (d18 + width2), (int) (d19 + height2));
    }

    private static final void p(Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<e> ref$ObjectRef, Ref$ObjectRef<ImageIdMetadata> ref$ObjectRef2, Ref$ObjectRef<ParsedIdSideOrNone.Side> ref$ObjectRef3, Ref$ObjectRef<ExtractedTexts> ref$ObjectRef4, Ref$BooleanRef ref$BooleanRef2, Ref$ObjectRef<ImageLightCondition> ref$ObjectRef5, com.withpersona.sdk2.camera.analyzers.a aVar, boolean z10) {
        Ref$ObjectRef<e> ref$ObjectRef6 = ref$ObjectRef;
        com.withpersona.sdk2.camera.analyzers.a aVar2 = aVar;
        a.b bVar = a.b.f14241a;
        if (j.b(aVar2, bVar) || !z10) {
            Ref$BooleanRef ref$BooleanRef3 = ref$BooleanRef;
        } else {
            ref$BooleanRef.element = true;
        }
        if (aVar2 instanceof a.C0150a) {
            if (ref$ObjectRef6.element == null) {
                ref$ObjectRef6.element = ((a.C0150a) aVar2).a();
            }
        } else if (aVar2 instanceof a.d) {
            ref$ObjectRef2.element = ((a.d) aVar2).a();
        } else {
            Ref$ObjectRef<ImageIdMetadata> ref$ObjectRef7 = ref$ObjectRef2;
            if (aVar2 instanceof a.c) {
                a.c cVar = (a.c) aVar2;
                p(ref$BooleanRef, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4, ref$BooleanRef2, ref$ObjectRef5, cVar.a(), z10);
                ref$ObjectRef3.element = cVar.b();
            } else if (aVar2 instanceof a.f) {
                ref$ObjectRef4.element = ((a.f) aVar2).a();
            } else if (j.b(aVar2, bVar)) {
                ref$BooleanRef2.element = true;
            } else if (aVar2 instanceof a.e) {
                ref$ObjectRef5.element = ((a.e) aVar2).a();
            }
        }
    }

    public Object a(c<? super Result<? extends ParsedIdSideOrNone>> cVar, kotlin.coroutines.c<?> cVar2) {
        return this.f14127a.a(cVar, cVar2);
    }

    public void g(Image image, int i10) {
        j.g(image, "image");
        Object unused = i.b((CoroutineContext) null, new GovernmentIdFeed$analyze$5(image, this, i10, (kotlin.coroutines.c<? super GovernmentIdFeed$analyze$5>) null), 1, (Object) null);
    }

    public void i(o1 o1Var) {
        j.g(o1Var, "imageProxy");
        Object unused = i.b((CoroutineContext) null, new GovernmentIdFeed$analyze$4(o1Var, this, (kotlin.coroutines.c<? super GovernmentIdFeed$analyze$4>) null), 1, (Object) null);
    }

    public final void m(ParsedIdSideOrNone.Side side, List<? extends AutoCaptureRule> list, List<? extends b> list2) {
        Object obj;
        j.g(side, "side");
        j.g(list, "rules");
        j.g(list2, "passiveAnalyzers");
        this.f14128b = side;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (AutoCaptureRule autoCaptureRule : list) {
            if (autoCaptureRule instanceof AutoCaptureRule.BarcodePdf417Rule) {
                obj = new BarcodePdf417Analyzer();
            } else if (autoCaptureRule instanceof AutoCaptureRule.FrontOrBackRule) {
                obj = new FrontOrBackAnalyzer(new IdFrontAnalyzer(), new BarcodePdf417Analyzer());
            } else if (autoCaptureRule instanceof AutoCaptureRule.FrontRule) {
                obj = new IdFrontAnalyzer();
            } else if (autoCaptureRule instanceof AutoCaptureRule.MrzRule) {
                obj = new MrzAnalyzer();
            } else if (autoCaptureRule instanceof AutoCaptureRule.TextExtractionRule) {
                obj = new TextExtractionAnalyzer();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(obj);
        }
        this.f14129c = arrayList;
        this.f14130d = list2;
    }

    public final Object o(s sVar, List<b> list) {
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        j.g(sVar, "imageToAnalyze");
        j.g(list, "analyzerResults");
        if (list.isEmpty()) {
            Result.a aVar = Result.f32010a;
            return Result.b(g.a(new AnalysisError.NoAnalyzerError()));
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        ref$ObjectRef3.element = this.f14128b;
        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef6 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef7 = new Ref$ObjectRef();
        Throwable th2 = null;
        for (b bVar : list) {
            Object a10 = bVar.a();
            if (Result.h(a10)) {
                ref$ObjectRef2 = ref$ObjectRef7;
                ref$ObjectRef = ref$ObjectRef6;
                p(ref$BooleanRef, ref$ObjectRef5, ref$ObjectRef4, ref$ObjectRef3, ref$ObjectRef6, ref$BooleanRef2, ref$ObjectRef7, (com.withpersona.sdk2.camera.analyzers.a) a10, bVar.b());
            } else {
                ref$ObjectRef2 = ref$ObjectRef7;
                ref$ObjectRef = ref$ObjectRef6;
            }
            Throwable e10 = Result.e(a10);
            if (e10 != null && th2 == null && bVar.b()) {
                ref$BooleanRef2.element = true;
                th2 = e10;
            }
            ref$ObjectRef7 = ref$ObjectRef2;
            ref$ObjectRef6 = ref$ObjectRef;
            s sVar2 = sVar;
        }
        Ref$ObjectRef ref$ObjectRef8 = ref$ObjectRef7;
        Ref$ObjectRef ref$ObjectRef9 = ref$ObjectRef6;
        if (ref$BooleanRef2.element) {
            if (th2 != null) {
                Result.a aVar2 = Result.f32010a;
                return Result.b(g.a(th2));
            }
            Result.a aVar3 = Result.f32010a;
            return Result.b(new ParsedIdSideOrNone.a((ImageLightCondition) ref$ObjectRef8.element));
        } else if (!ref$BooleanRef.element) {
            Result.a aVar4 = Result.f32010a;
            return Result.b(new ParsedIdSideOrNone.a((ImageLightCondition) ref$ObjectRef8.element));
        } else {
            ParsedIdSideOrNone.Side side = (ParsedIdSideOrNone.Side) ref$ObjectRef3.element;
            if (side == null) {
                Result.a aVar5 = Result.f32010a;
                return Result.b(new ParsedIdSideOrNone.a((ImageLightCondition) ref$ObjectRef8.element));
            }
            Bitmap b10 = sVar.b();
            if (b10 == null) {
                Result.a aVar6 = Result.f32010a;
                return Result.b(new ParsedIdSideOrNone.a((ImageLightCondition) ref$ObjectRef8.element));
            }
            Result.a aVar7 = Result.f32010a;
            return Result.b(new ParsedIdSideOrNone.b(side, b10, (ImageIdMetadata) ref$ObjectRef4.element, (e) ref$ObjectRef5.element, (ExtractedTexts) ref$ObjectRef9.element, (ImageLightCondition) ref$ObjectRef8.element));
        }
    }

    public final void q(Rect rect, Rect rect2) {
        j.g(rect, "rect");
        j.g(rect2, "previewRect");
        this.f14131e = new y(rect, rect2);
    }
}
