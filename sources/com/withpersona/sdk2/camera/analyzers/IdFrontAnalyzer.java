package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Rect;
import bh.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.withpersona.sdk2.camera.ImageIdMetadata;
import com.withpersona.sdk2.camera.analyzers.AnalysisError;
import com.withpersona.sdk2.camera.analyzers.a;
import com.withpersona.sdk2.camera.s;
import dh.a;
import dh.c;
import gk.f;
import gk.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.jvm.internal.j;
import zg.a;

public final class IdFrontAnalyzer implements b {

    /* renamed from: a  reason: collision with root package name */
    private final f f14231a = b.b(IdFrontAnalyzer$faceDetector$2.f14233a);

    /* renamed from: b  reason: collision with root package name */
    private final f f14232b = b.b(IdFrontAnalyzer$textDetector$2.f14234a);

    private final d b() {
        return (d) this.f14231a.getValue();
    }

    private final c c() {
        return (c) this.f14232b.getValue();
    }

    public Object a(s sVar, Rect rect, kotlin.coroutines.c<? super Result<? extends a>> cVar) {
        a c10 = sVar.c();
        Task<List<bh.a>> i10 = b().i(c10);
        j.f(i10, "faceDetector.process(inputImage)");
        Task<dh.a> i11 = c().i(c10);
        j.f(i11, "textDetector.process(inputImage)");
        try {
            Tasks.await(Tasks.whenAll((Task<?>[]) new Task[]{i10, i11}));
            List<bh.a> result = i10.getResult();
            j.f(result, "faceTask.result");
            bh.a aVar = (bh.a) CollectionsKt___CollectionsKt.Q(result, 0);
            if (aVar == null) {
                Result.a aVar2 = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
            List<a.e> b10 = i11.getResult().b();
            j.f(b10, "textTask.result.textBlocks");
            ArrayList arrayList = new ArrayList(r.t(b10, 10));
            for (a.e c11 : b10) {
                List<a.b> c12 = c11.c();
                j.f(c12, "it.lines");
                ArrayList arrayList2 = new ArrayList(r.t(c12, 10));
                for (a.b c13 : c12) {
                    arrayList2.add(c13.c());
                }
                arrayList.add(arrayList2);
            }
            if (r.u(arrayList).size() < 5) {
                Result.a aVar3 = Result.f32010a;
                return Result.b(a.b.f14241a);
            }
            Rect rect2 = new Rect(0, 0, c10.l(), c10.h());
            rect2.inset(1, 1);
            if (rect2.contains(aVar.a())) {
                Result.a aVar4 = Result.f32010a;
                String a10 = i11.getResult().a();
                j.f(a10, "textTask.result.text");
                return Result.b(new a.d(new ImageIdMetadata(a10)));
            }
            Result.a aVar5 = Result.f32010a;
            return Result.b(a.b.f14241a);
        } catch (ExecutionException unused) {
            Result.a aVar6 = Result.f32010a;
            return Result.b(g.a(new AnalysisError.DetectorError()));
        }
    }
}
