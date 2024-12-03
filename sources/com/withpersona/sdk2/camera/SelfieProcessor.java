package com.withpersona.sdk2.camera;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.o1;
import bh.d;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.withpersona.sdk2.camera.SelfieCaptureException;
import com.withpersona.sdk2.camera.w;
import gk.f;
import gk.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class SelfieProcessor {

    /* renamed from: b  reason: collision with root package name */
    public static final a f14195b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final f f14196a = b.b(SelfieProcessor$faceDetector$2.f14197a);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Rect d(zg.a aVar) {
        if (aVar.k() == 90 || aVar.k() == 270) {
            return new Rect(0, 0, aVar.h(), aVar.l());
        }
        return new Rect(0, 0, aVar.l(), aVar.h());
    }

    private final d e() {
        return (d) this.f14196a.getValue();
    }

    private final boolean f(bh.a aVar, Rect rect) {
        int width = rect.width();
        int height = rect.height();
        bh.f d10 = aVar.d(6);
        if (d10 == null) {
            return false;
        }
        double d11 = (double) (width / 2);
        double min = (((double) Math.min(width, height)) * 0.4d) / ((double) 2);
        double d12 = (double) (height / 2);
        return new Rect((int) (d11 - min), (int) (d12 - min), (int) (d11 + min), (int) (d12 + min)).contains((int) d10.a().x, (int) d10.a().y);
    }

    private final boolean g(Rect rect, Rect rect2) {
        int width = rect2.width();
        int height = rect2.height();
        int i10 = width / 2;
        int i11 = height / 2;
        int min = Math.min(width, height) / 2;
        Rect rect3 = new Rect(0, 0, width, height);
        rect3.inset(25, 25);
        if (rect3.contains(rect) && ((double) Math.abs(j.c(rect2.width() - rect.right, 1) - j.c(rect.left, 1))) / ((double) rect2.width()) <= 0.3d && rect.left > i10 - min && rect.right < i10 + min && rect.top > i11 - min && rect.bottom < i11 + min) {
            return true;
        }
        return false;
    }

    private final boolean h(Rect rect, Rect rect2) {
        int width = rect2.width();
        int height = rect2.height();
        if (((double) Math.max(rect.width(), rect.height())) > ((double) Math.min(width, height)) * 0.8d) {
            return true;
        }
        return false;
    }

    public final Object a(o1 o1Var) {
        j.g(o1Var, "image");
        s e10 = ImageToAnalyzeKt.e(o1Var);
        if (e10 != null) {
            return b(e10);
        }
        Result.a aVar = Result.f32010a;
        return Result.b(g.a(new RuntimeException("Null input image")));
    }

    public final Object b(s sVar) {
        j.g(sVar, "imageToAnalyze");
        zg.a c10 = sVar.c();
        Rect d10 = d(c10);
        Task<List<bh.a>> i10 = e().i(c10);
        j.f(i10, "faceDetector.process(inputImage)");
        try {
            Tasks.await(i10);
            List result = i10.getResult();
            if (result.isEmpty()) {
                Result.a aVar = Result.f32010a;
                return Result.b(g.a(new SelfieCaptureException.NoFaceError()));
            }
            j.f(result, "faces");
            ArrayList arrayList = new ArrayList();
            for (Object next : result) {
                Rect a10 = ((bh.a) next).a();
                j.f(a10, "it.boundingBox");
                if (true ^ h(a10, d10)) {
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                Result.a aVar2 = Result.f32010a;
                return Result.b(g.a(new SelfieCaptureException.FaceTooCloseError()));
            }
            List<bh.a> result2 = i10.getResult();
            j.f(result2, "task.result");
            ArrayList arrayList2 = new ArrayList();
            for (Object next2 : result2) {
                Rect a11 = ((bh.a) next2).a();
                j.f(a11, "it.boundingBox");
                if (g(a11, d10)) {
                    arrayList2.add(next2);
                }
            }
            if (arrayList2.isEmpty()) {
                Result.a aVar3 = Result.f32010a;
                return Result.b(g.a(new SelfieCaptureException.FaceNotCenteredError()));
            } else if (arrayList2.size() == 1) {
                bh.a aVar4 = (bh.a) arrayList2.get(0);
                float c11 = aVar4.c();
                Bitmap b10 = sVar.b();
                if (b10 == null) {
                    Result.a aVar5 = Result.f32010a;
                    return Result.b(g.a(new RuntimeException("Error converting bitmap")));
                } else if (-10.0f < c11 && c11 < 10.0f) {
                    j.f(aVar4, "face");
                    if (!f(aVar4, d10)) {
                        Result.a aVar6 = Result.f32010a;
                        return Result.b(g.a(new SelfieCaptureException.FaceNotCenteredError()));
                    }
                    Result.a aVar7 = Result.f32010a;
                    return Result.b(new w.a(b10));
                } else if (c11 < -15.0f) {
                    Result.a aVar8 = Result.f32010a;
                    return Result.b(new w.c(b10));
                } else if (15.0f < c11) {
                    Result.a aVar9 = Result.f32010a;
                    return Result.b(new w.b(b10));
                } else {
                    Result.a aVar10 = Result.f32010a;
                    return Result.b(g.a(new SelfieCaptureException.InvalidPoseError()));
                }
            } else {
                Result.a aVar11 = Result.f32010a;
                return Result.b(g.a(new SelfieCaptureException.TooManyFacesError()));
            }
        } catch (ExecutionException unused) {
            Result.a aVar12 = Result.f32010a;
            return Result.b(g.a(new SelfieCaptureException.FaceDetectionUnsupportedError()));
        }
    }

    public final Object c(Image image, int i10) {
        j.g(image, "image");
        return b(ImageToAnalyzeKt.d(image, i10));
    }
}
