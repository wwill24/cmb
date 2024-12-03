package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.d;
import aj.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import ti.b;

public final class StacksKt {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27575a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType[] r0 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType r1 = com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType.END     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f27575a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt.a.<clinit>():void");
        }
    }

    public static final ConstraintLayout a(Context context, List<com.withpersona.sdk2.inquiry.steps.ui.a> list, List<? extends View> list2, UiComponent.ClickableStackComponentStyle clickableStackComponentStyle) {
        double d10;
        StyleElements.Axis axis;
        StyleElements.PositionType positionType;
        int[] iArr;
        StyleElements.PositionType positionType2;
        StyleElements.DPSize u10;
        Double a10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "componentViews");
        j.g(list2, "children");
        d c10 = d.c(LayoutInflater.from(context));
        c cVar = new c();
        cVar.f(c10.getRoot());
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        for (View view : list2) {
            view.setId(View.generateViewId());
            c10.getRoot().addView(view);
            arrayList.add(Integer.valueOf(view.getId()));
        }
        if (clickableStackComponentStyle == null || (u10 = clickableStackComponentStyle.u()) == null || (a10 = u10.a()) == null) {
            d10 = 16.0d;
        } else {
            d10 = a10.doubleValue();
        }
        int a11 = (int) b.a(d10);
        if (clickableStackComponentStyle == null || (axis = clickableStackComponentStyle.g()) == null) {
            axis = StyleElements.Axis.HORIZONTAL;
        }
        if (axis == StyleElements.Axis.HORIZONTAL) {
            ConstraintLayout b10 = c10.getRoot();
            j.f(b10, "root");
            if (clickableStackComponentStyle != null) {
                iArr = clickableStackComponentStyle.q();
            } else {
                iArr = null;
            }
            if (clickableStackComponentStyle != null) {
                positionType2 = clickableStackComponentStyle.e();
            } else {
                positionType2 = null;
            }
            b(b10, cVar, list, arrayList, iArr, positionType2, a11);
        } else {
            ConstraintLayout b11 = c10.getRoot();
            j.f(b11, "root");
            if (clickableStackComponentStyle != null) {
                positionType = clickableStackComponentStyle.e();
            } else {
                positionType = null;
            }
            c(b11, cVar, list, arrayList, positionType, a11);
        }
        if (clickableStackComponentStyle != null) {
            ConstraintLayout b12 = c10.getRoot();
            j.f(b12, "root");
            k.b(b12, new StacksKt$clickableStack$1$1(c10, clickableStackComponentStyle));
        }
        cVar.c(c10.getRoot());
        ConstraintLayout b13 = c10.getRoot();
        j.f(b13, "inflate(LayoutInflater.f…tSet.applyTo(root)\n}.root");
        return b13;
    }

    /* JADX WARNING: type inference failed for: r9v19, types: [com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void b(android.view.ViewGroup r17, androidx.constraintlayout.widget.c r18, java.util.List<com.withpersona.sdk2.inquiry.steps.ui.a> r19, java.util.List<java.lang.Integer> r20, int[] r21, com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements.PositionType r22, int r23) {
        /*
            r0 = r17
            r1 = r18
            if (r21 == 0) goto L_0x000c
            int r4 = kotlin.collections.l.g0(r21)
            double r4 = (double) r4
            goto L_0x000e
        L_0x000c:
            r4 = 0
        L_0x000e:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r20.iterator()
            r8 = 0
            r9 = r8
        L_0x0019:
            boolean r10 = r7.hasNext()
            r12 = 1
            if (r10 == 0) goto L_0x00c4
            java.lang.Object r10 = r7.next()
            int r13 = r9 + 1
            if (r9 >= 0) goto L_0x002b
            kotlin.collections.q.s()
        L_0x002b:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            cj.c r14 = new cj.c
            android.content.Context r15 = r17.getContext()
            java.lang.String r11 = "root.context"
            kotlin.jvm.internal.j.f(r15, r11)
            r14.<init>(r15)
            int r11 = android.view.View.generateViewId()
            r14.setId(r11)
            int r11 = kotlin.collections.q.l(r20)
            if (r9 == r11) goto L_0x00bf
            java.util.Iterator r9 = r19.iterator()
        L_0x0050:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x006d
            java.lang.Object r11 = r9.next()
            r15 = r11
            com.withpersona.sdk2.inquiry.steps.ui.a r15 = (com.withpersona.sdk2.inquiry.steps.ui.a) r15
            android.view.View r15 = r15.d()
            int r15 = r15.getId()
            if (r15 != r10) goto L_0x0069
            r15 = r12
            goto L_0x006a
        L_0x0069:
            r15 = r8
        L_0x006a:
            if (r15 == 0) goto L_0x0050
            goto L_0x006e
        L_0x006d:
            r11 = 0
        L_0x006e:
            com.withpersona.sdk2.inquiry.steps.ui.a r11 = (com.withpersona.sdk2.inquiry.steps.ui.a) r11
            if (r11 == 0) goto L_0x007d
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r9 = r11.c()
            if (r9 == 0) goto L_0x007d
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponentAttributes r9 = r9.z()
            goto L_0x007e
        L_0x007d:
            r9 = 0
        L_0x007e:
            boolean r10 = r9 instanceof com.withpersona.sdk2.inquiry.steps.ui.network.c
            if (r10 == 0) goto L_0x0086
            r11 = r9
            com.withpersona.sdk2.inquiry.steps.ui.network.c r11 = (com.withpersona.sdk2.inquiry.steps.ui.network.c) r11
            goto L_0x0087
        L_0x0086:
            r11 = 0
        L_0x0087:
            if (r11 == 0) goto L_0x0092
            java.util.List r9 = r11.a()
            if (r9 == 0) goto L_0x0092
            r9.add(r14)
        L_0x0092:
            r0.addView(r14)
            int r9 = r14.getId()
            r10 = r23
            r1.n(r9, r10)
            int r9 = r14.getId()
            r1.p(r9, r12)
            int r9 = r14.getId()
            r1.m(r9, r12)
            int r9 = r14.getId()
            r1.o(r9, r12)
            int r9 = r14.getId()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r6.add(r9)
            goto L_0x00c1
        L_0x00bf:
            r10 = r23
        L_0x00c1:
            r9 = r13
            goto L_0x0019
        L_0x00c4:
            java.util.Iterator r7 = r20.iterator()
            r9 = r8
        L_0x00c9:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto L_0x01e4
            java.lang.Object r10 = r7.next()
            int r11 = r9 + 1
            if (r9 >= 0) goto L_0x00da
            kotlin.collections.q.s()
        L_0x00da:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r9 <= 0) goto L_0x00eb
            int r13 = r9 + -1
            java.lang.Object r13 = r6.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            goto L_0x00ec
        L_0x00eb:
            r13 = 0
        L_0x00ec:
            int r14 = kotlin.collections.q.l(r20)
            r15 = 6
            r2 = 7
            if (r9 != r14) goto L_0x0148
            r1.h(r10, r2, r8, r2)
            java.util.Iterator r3 = r19.iterator()
        L_0x00fb:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x011b
            java.lang.Object r14 = r3.next()
            r16 = r14
            com.withpersona.sdk2.inquiry.steps.ui.a r16 = (com.withpersona.sdk2.inquiry.steps.ui.a) r16
            android.view.View r16 = r16.d()
            int r12 = r16.getId()
            if (r12 != r10) goto L_0x0115
            r12 = 1
            goto L_0x0116
        L_0x0115:
            r12 = r8
        L_0x0116:
            if (r12 == 0) goto L_0x0119
            goto L_0x011c
        L_0x0119:
            r12 = 1
            goto L_0x00fb
        L_0x011b:
            r14 = 0
        L_0x011c:
            com.withpersona.sdk2.inquiry.steps.ui.a r14 = (com.withpersona.sdk2.inquiry.steps.ui.a) r14
            if (r14 == 0) goto L_0x0125
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r3 = r14.c()
            goto L_0x0126
        L_0x0125:
            r3 = 0
        L_0x0126:
            if (r3 == 0) goto L_0x0144
            if (r13 == 0) goto L_0x0144
            int r3 = r13.intValue()
            android.view.View r3 = r0.findViewById(r3)
            cj.c r3 = (cj.c) r3
            java.util.List r3 = r3.getAssociatedComponents()
            java.lang.ref.WeakReference r12 = new java.lang.ref.WeakReference
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r14 = r14.c()
            r12.<init>(r14)
            r3.add(r12)
        L_0x0144:
            r14 = r20
            r3 = 0
            goto L_0x016f
        L_0x0148:
            java.lang.Object r3 = r6.get(r9)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r12 = r3.intValue()
            r1.h(r10, r2, r12, r15)
            int r12 = r3.intValue()
            r14 = r20
            java.lang.Object r16 = r14.get(r11)
            java.lang.Number r16 = (java.lang.Number) r16
            int r8 = r16.intValue()
            r1.h(r12, r2, r8, r15)
            int r8 = r3.intValue()
            r1.h(r8, r15, r10, r2)
        L_0x016f:
            if (r13 == 0) goto L_0x0179
            int r8 = r13.intValue()
            r1.h(r10, r15, r8, r2)
            goto L_0x017d
        L_0x0179:
            r2 = 0
            r1.h(r10, r15, r2, r15)
        L_0x017d:
            r2 = -2
            r1.m(r10, r2)
            r8 = 1
            r1.o(r10, r8)
            r12 = 0
            int r8 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x01a1
            if (r21 == 0) goto L_0x0190
            r8 = r21[r9]
            goto L_0x0191
        L_0x0190:
            r8 = 0
        L_0x0191:
            double r8 = (double) r8
            double r8 = r8 / r4
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x019c
            float r2 = (float) r8
            r1.F(r10, r2)
            goto L_0x019f
        L_0x019c:
            r1.n(r10, r2)
        L_0x019f:
            r2 = 0
            goto L_0x01a5
        L_0x01a1:
            r2 = 0
            r1.l(r10, r2)
        L_0x01a5:
            r8 = 3
            r1.h(r10, r8, r2, r8)
            r9 = 4
            r1.h(r10, r9, r2, r9)
            if (r3 == 0) goto L_0x01bd
            int r15 = r3.intValue()
            r1.h(r15, r8, r2, r8)
            int r3 = r3.intValue()
            r1.h(r3, r9, r2, r9)
        L_0x01bd:
            if (r22 != 0) goto L_0x01c1
            r3 = -1
            goto L_0x01c9
        L_0x01c1:
            int[] r3 = com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt.a.f27575a
            int r8 = r22.ordinal()
            r3 = r3[r8]
        L_0x01c9:
            r8 = 1
            if (r3 == r8) goto L_0x01db
            r9 = 2
            if (r3 == r9) goto L_0x01d5
            r3 = 1056964608(0x3f000000, float:0.5)
            r1.H(r10, r3)
            goto L_0x01df
        L_0x01d5:
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.H(r10, r3)
            goto L_0x01df
        L_0x01db:
            r3 = 0
            r1.H(r10, r3)
        L_0x01df:
            r12 = r8
            r9 = r11
            r8 = r2
            goto L_0x00c9
        L_0x01e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.steps.ui.components.StacksKt.b(android.view.ViewGroup, androidx.constraintlayout.widget.c, java.util.List, java.util.List, int[], com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements$PositionType, int):void");
    }

    private static final void c(ViewGroup viewGroup, c cVar, List<com.withpersona.sdk2.inquiry.steps.ui.a> list, List<Integer> list2, StyleElements.PositionType positionType, int i10) {
        Integer num;
        Integer num2;
        int i11;
        T t10;
        UiComponent uiComponent;
        boolean z10;
        T t11;
        UiComponentAttributes uiComponentAttributes;
        List<cj.a> a10;
        UiComponent c10;
        boolean z11;
        ViewGroup viewGroup2 = viewGroup;
        c cVar2 = cVar;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        int i12 = 0;
        while (true) {
            com.withpersona.sdk2.inquiry.steps.ui.network.c cVar3 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            int i13 = i12 + 1;
            if (i12 < 0) {
                q.s();
            }
            int intValue = ((Number) next).intValue();
            Context context = viewGroup.getContext();
            j.f(context, "root.context");
            cj.c cVar4 = new cj.c(context);
            cVar4.setId(View.generateViewId());
            if (i12 != q.l(list2)) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t11 = null;
                        break;
                    }
                    t11 = it2.next();
                    if (((com.withpersona.sdk2.inquiry.steps.ui.a) t11).d().getId() == intValue) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        break;
                    }
                }
                com.withpersona.sdk2.inquiry.steps.ui.a aVar = (com.withpersona.sdk2.inquiry.steps.ui.a) t11;
                if (aVar == null || (c10 = aVar.c()) == null) {
                    uiComponentAttributes = null;
                } else {
                    uiComponentAttributes = c10.z();
                }
                if (uiComponentAttributes instanceof com.withpersona.sdk2.inquiry.steps.ui.network.c) {
                    cVar3 = (com.withpersona.sdk2.inquiry.steps.ui.network.c) uiComponentAttributes;
                }
                if (!(cVar3 == null || (a10 = cVar3.a()) == null)) {
                    a10.add(cVar4);
                }
                viewGroup2.addView(cVar4);
                cVar2.n(cVar4.getId(), 1);
                cVar2.p(cVar4.getId(), true);
                cVar2.m(cVar4.getId(), i10);
                cVar2.o(cVar4.getId(), true);
                arrayList.add(Integer.valueOf(cVar4.getId()));
            } else {
                int i14 = i10;
            }
            i12 = i13;
        }
        int i15 = 0;
        for (T next2 : list2) {
            int i16 = i15 + 1;
            if (i15 < 0) {
                q.s();
            }
            int intValue2 = ((Number) next2).intValue();
            if (i15 > 0) {
                num = (Integer) arrayList.get(i15 - 1);
            } else {
                num = null;
            }
            if (i15 == q.l(list2)) {
                cVar2.h(intValue2, 4, 0, 4);
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        t10 = null;
                        break;
                    }
                    t10 = it3.next();
                    if (((com.withpersona.sdk2.inquiry.steps.ui.a) t10).d().getId() == intValue2) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        break;
                    }
                }
                com.withpersona.sdk2.inquiry.steps.ui.a aVar2 = (com.withpersona.sdk2.inquiry.steps.ui.a) t10;
                if (aVar2 != null) {
                    uiComponent = aVar2.c();
                } else {
                    uiComponent = null;
                }
                if (!(uiComponent == null || num == null)) {
                    ((cj.c) viewGroup2.findViewById(num.intValue())).getAssociatedComponents().add(new WeakReference(aVar2.c()));
                }
                num2 = null;
            } else {
                num2 = (Integer) arrayList.get(i15);
                cVar2.h(num2.intValue(), 3, intValue2, 4);
            }
            if (i15 == 0) {
                cVar2.h(intValue2, 3, 0, 3);
            }
            if (num != null) {
                cVar2.h(num.intValue(), 4, intValue2, 3);
                cVar2.h(intValue2, 3, num.intValue(), 4);
            }
            cVar2.h(intValue2, 6, 0, 6);
            cVar2.h(intValue2, 7, 0, 7);
            if (num2 != null) {
                cVar2.h(num2.intValue(), 6, 0, 6);
                cVar2.h(num2.intValue(), 7, 0, 7);
            }
            cVar2.m(intValue2, -2);
            cVar2.n(intValue2, 0);
            if (positionType == null) {
                i11 = -1;
            } else {
                i11 = a.f27575a[positionType.ordinal()];
            }
            if (i11 == 1) {
                cVar2.E(intValue2, 0.0f);
            } else if (i11 != 2) {
                cVar2.E(intValue2, 0.5f);
            } else {
                cVar2.E(intValue2, 1.0f);
            }
            i15 = i16;
        }
    }

    public static final ConstraintLayout d(Context context, List<com.withpersona.sdk2.inquiry.steps.ui.a> list, List<? extends View> list2, UiComponent.HorizontalStackComponentStyle horizontalStackComponentStyle) {
        double d10;
        StyleElements.Axis axis;
        StyleElements.PositionType positionType;
        int[] iArr;
        StyleElements.PositionType positionType2;
        StyleElements.DPSize q10;
        Double a10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(list, "componentViews");
        j.g(list2, "children");
        g c10 = g.c(LayoutInflater.from(context));
        c cVar = new c();
        cVar.f(c10.getRoot());
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        for (View view : list2) {
            view.setId(View.generateViewId());
            c10.getRoot().addView(view);
            arrayList.add(Integer.valueOf(view.getId()));
        }
        if (horizontalStackComponentStyle == null || (q10 = horizontalStackComponentStyle.q()) == null || (a10 = q10.a()) == null) {
            d10 = 16.0d;
        } else {
            d10 = a10.doubleValue();
        }
        int a11 = (int) b.a(d10);
        if (horizontalStackComponentStyle == null || (axis = horizontalStackComponentStyle.e()) == null) {
            axis = StyleElements.Axis.HORIZONTAL;
        }
        if (axis == StyleElements.Axis.HORIZONTAL) {
            ConstraintLayout b10 = c10.getRoot();
            j.f(b10, "root");
            if (horizontalStackComponentStyle != null) {
                iArr = horizontalStackComponentStyle.o();
            } else {
                iArr = null;
            }
            if (horizontalStackComponentStyle != null) {
                positionType2 = horizontalStackComponentStyle.c();
            } else {
                positionType2 = null;
            }
            b(b10, cVar, list, arrayList, iArr, positionType2, a11);
        } else {
            ConstraintLayout b11 = c10.getRoot();
            j.f(b11, "root");
            if (horizontalStackComponentStyle != null) {
                positionType = horizontalStackComponentStyle.c();
            } else {
                positionType = null;
            }
            c(b11, cVar, list, arrayList, positionType, a11);
        }
        if (horizontalStackComponentStyle != null) {
            ConstraintLayout b12 = c10.getRoot();
            j.f(b12, "root");
            k.b(b12, new StacksKt$stack$1$1(c10, horizontalStackComponentStyle));
        }
        cVar.c(c10.getRoot());
        ConstraintLayout b13 = c10.getRoot();
        j.f(b13, "inflate(LayoutInflater.f…tSet.applyTo(root)\n}.root");
        return b13;
    }
}
