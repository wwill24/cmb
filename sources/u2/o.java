package u2;

import com.airbnb.lottie.model.DocumentData;
import d3.b;
import d3.c;
import java.util.List;

public class o extends g<DocumentData> {

    class a extends c<DocumentData> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f17993d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f17994e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ DocumentData f17995f;

        a(b bVar, c cVar, DocumentData documentData) {
            this.f17993d = bVar;
            this.f17994e = cVar;
            this.f17995f = documentData;
        }

        /* JADX WARNING: type inference failed for: r17v0, types: [d3.b<com.airbnb.lottie.model.DocumentData>, d3.b] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.airbnb.lottie.model.DocumentData a(d3.b<com.airbnb.lottie.model.DocumentData> r17) {
            /*
                r16 = this;
                r0 = r16
                d3.b r1 = r0.f17993d
                float r2 = r17.f()
                float r3 = r17.a()
                java.lang.Object r4 = r17.g()
                com.airbnb.lottie.model.DocumentData r4 = (com.airbnb.lottie.model.DocumentData) r4
                java.lang.String r4 = r4.f8615a
                java.lang.Object r5 = r17.b()
                com.airbnb.lottie.model.DocumentData r5 = (com.airbnb.lottie.model.DocumentData) r5
                java.lang.String r5 = r5.f8615a
                float r6 = r17.d()
                float r7 = r17.c()
                float r8 = r17.e()
                r1.h(r2, r3, r4, r5, r6, r7, r8)
                d3.c r1 = r0.f17994e
                d3.b r2 = r0.f17993d
                java.lang.Object r1 = r1.a(r2)
                r3 = r1
                java.lang.String r3 = (java.lang.String) r3
                float r1 = r17.c()
                r2 = 1065353216(0x3f800000, float:1.0)
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 != 0) goto L_0x0045
                java.lang.Object r1 = r17.b()
                goto L_0x0049
            L_0x0045:
                java.lang.Object r1 = r17.g()
            L_0x0049:
                com.airbnb.lottie.model.DocumentData r1 = (com.airbnb.lottie.model.DocumentData) r1
                com.airbnb.lottie.model.DocumentData r2 = r0.f17995f
                java.lang.String r4 = r1.f8616b
                float r5 = r1.f8617c
                com.airbnb.lottie.model.DocumentData$Justification r6 = r1.f8618d
                int r7 = r1.f8619e
                float r8 = r1.f8620f
                float r9 = r1.f8621g
                int r10 = r1.f8622h
                int r11 = r1.f8623i
                float r12 = r1.f8624j
                boolean r13 = r1.f8625k
                android.graphics.PointF r14 = r1.f8626l
                android.graphics.PointF r15 = r1.f8627m
                r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                com.airbnb.lottie.model.DocumentData r1 = r0.f17995f
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: u2.o.a.a(d3.b):com.airbnb.lottie.model.DocumentData");
        }
    }

    public o(List<d3.a<DocumentData>> list) {
        super(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public DocumentData i(d3.a<DocumentData> aVar, float f10) {
        T t10;
        float f11;
        DocumentData documentData;
        c<A> cVar = this.f17953e;
        if (cVar != null) {
            float f12 = aVar.f14411g;
            Float f13 = aVar.f14412h;
            if (f13 == null) {
                f11 = Float.MAX_VALUE;
            } else {
                f11 = f13.floatValue();
            }
            T t11 = aVar.f14406b;
            DocumentData documentData2 = (DocumentData) t11;
            T t12 = aVar.f14407c;
            if (t12 == null) {
                documentData = (DocumentData) t11;
            } else {
                documentData = (DocumentData) t12;
            }
            return (DocumentData) cVar.b(f12, f11, documentData2, documentData, f10, d(), f());
        } else if (f10 != 1.0f || (t10 = aVar.f14407c) == null) {
            return (DocumentData) aVar.f14406b;
        } else {
            return (DocumentData) t10;
        }
    }

    public void q(c<String> cVar) {
        super.n(new a(new b(), cVar, new DocumentData()));
    }
}
