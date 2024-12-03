package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.renderscript.Range2d;
import com.google.android.renderscript.Toolkit;
import com.withpersona.sdk2.camera.analyzers.AnalysisError;
import com.withpersona.sdk2.camera.analyzers.a;
import com.withpersona.sdk2.camera.e;
import com.withpersona.sdk2.camera.s;
import gk.f;
import gk.g;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class BarcodePdf417Analyzer implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f14224b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f14225c = {-0.15f, -0.15f, -0.15f, -0.15f, 2.2f, -0.15f, -0.15f, -0.15f, -0.15f};

    /* renamed from: a  reason: collision with root package name */
    private final f f14226a = b.b(BarcodePdf417Analyzer$barcodeDetector$2.f14227a);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final vg.a b() {
        return (vg.a) this.f14226a.getValue();
    }

    private final Bitmap c(Bitmap bitmap) {
        try {
            return Toolkit.b(Toolkit.f20544a, bitmap, f14225c, (Range2d) null, 4, (Object) null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }

    public Object a(s sVar, Rect rect, c<? super Result<? extends a>> cVar) {
        Bitmap b10 = sVar.b();
        if (b10 == null) {
            Result.a aVar = Result.f32010a;
            return Result.b(a.b.f14241a);
        }
        Bitmap c10 = c(b10);
        if (c10 != null) {
            b10 = c10;
        }
        zg.a a10 = zg.a.a(b10, sVar.c().k());
        j.f(a10, "fromBitmap(\n      sharpe…age.rotationDegrees\n    )");
        Task<List<wg.a>> i10 = b().i(a10);
        j.f(i10, "barcodeDetector.process(sharpenedImage)");
        try {
            Tasks.await(i10);
            List<wg.a> result = i10.getResult();
            j.f(result, "task.result");
            wg.a aVar2 = (wg.a) CollectionsKt___CollectionsKt.Q(result, 0);
            if (aVar2 == null) {
                Result.a aVar3 = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
            String c11 = aVar2.c();
            if (c11 == null) {
                Result.a aVar4 = Result.f32010a;
                return Result.b(a.b.f14241a);
            } else if (aVar2.b() == 2048) {
                e.b bVar = new e.b(c11);
                Rect rect2 = new Rect(0, 0, sVar.c().l(), sVar.c().h());
                Rect a11 = aVar2.a();
                if (a11 == null) {
                    Result.a aVar5 = Result.f32010a;
                    return Result.b(a.b.f14241a);
                }
                rect2.inset(1, 1);
                if (rect2.contains(a11)) {
                    Result.a aVar6 = Result.f32010a;
                    return Result.b(new a.C0150a(bVar));
                }
                Result.a aVar7 = Result.f32010a;
                return Result.b(a.b.f14241a);
            } else {
                Result.a aVar8 = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
        } catch (ExecutionException unused) {
            Result.a aVar9 = Result.f32010a;
            return Result.b(g.a(new AnalysisError.GooglePlayError()));
        }
    }
}
