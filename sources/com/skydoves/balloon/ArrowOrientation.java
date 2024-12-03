package com.skydoves.balloon;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum ArrowOrientation {
    BOTTOM,
    TOP,
    START,
    END;
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f22655a = null;

    public static final class a {

        /* renamed from: com.skydoves.balloon.ArrowOrientation$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0263a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f22661a = null;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    com.skydoves.balloon.ArrowOrientation[] r0 = com.skydoves.balloon.ArrowOrientation.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.skydoves.balloon.ArrowOrientation r1 = com.skydoves.balloon.ArrowOrientation.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.skydoves.balloon.ArrowOrientation r1 = com.skydoves.balloon.ArrowOrientation.END     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    f22661a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.skydoves.balloon.ArrowOrientation.a.C0263a.<clinit>():void");
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArrowOrientation a(ArrowOrientation arrowOrientation, boolean z10) {
            j.g(arrowOrientation, "<this>");
            if (!z10) {
                return arrowOrientation;
            }
            int i10 = C0263a.f22661a[arrowOrientation.ordinal()];
            if (i10 == 1) {
                return ArrowOrientation.END;
            }
            if (i10 != 2) {
                return arrowOrientation;
            }
            return ArrowOrientation.START;
        }
    }

    static {
        f22655a = new a((DefaultConstructorMarker) null);
    }
}
