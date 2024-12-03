package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Rect;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.withpersona.sdk2.camera.MrzExtraction;
import com.withpersona.sdk2.camera.analyzers.AnalysisError;
import com.withpersona.sdk2.camera.analyzers.a;
import com.withpersona.sdk2.camera.e;
import com.withpersona.sdk2.camera.s;
import dh.a;
import dh.c;
import gk.f;
import gk.g;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.jvm.internal.j;

public final class MrzAnalyzer implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f14235a = b.b(MrzAnalyzer$textDetector$2.f14236a);

    private final c b() {
        return (c) this.f14235a.getValue();
    }

    public Object a(s sVar, Rect rect, kotlin.coroutines.c<? super Result<? extends a>> cVar) {
        Task<a> i10 = b().i(sVar.c());
        j.f(i10, "textDetector.process(image.inputImage)");
        try {
            Tasks.await(i10);
            String a10 = i10.getResult().a();
            j.f(a10, "task.result.text");
            if (j.b(a10, "")) {
                Result.a aVar = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
            MrzExtraction c10 = MrzExtraction.f14143p.c(a10);
            if (c10 == null) {
                Result.a aVar2 = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
            Result.a aVar3 = Result.f32010a;
            return Result.b(new a.C0150a(new e.a(c10.i(), c10.h(), c10.f(), c10.g())));
        } catch (ExecutionException unused) {
            Result.a aVar4 = Result.f32010a;
            return Result.b(g.a(new AnalysisError.GooglePlayError()));
        }
    }
}
