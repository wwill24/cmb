package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

final class e implements Sequence<IntRange> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f32224a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f32225b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f32226c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f32227d;

    public static final class a implements Iterator<IntRange>, qk.a {

        /* renamed from: a  reason: collision with root package name */
        private int f32228a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f32229b;

        /* renamed from: c  reason: collision with root package name */
        private int f32230c;

        /* renamed from: d  reason: collision with root package name */
        private IntRange f32231d;

        /* renamed from: e  reason: collision with root package name */
        private int f32232e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f32233f;

        a(e eVar) {
            this.f32233f = eVar;
            int j10 = j.j(eVar.f32225b, 0, eVar.f32224a.length());
            this.f32229b = j10;
            this.f32230c = j10;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
            if (r0 < kotlin.text.e.d(r6.f32233f)) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f32230c
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r6.f32228a = r1
                r0 = 0
                r6.f32231d = r0
                goto L_0x009e
            L_0x000c:
                kotlin.text.e r0 = r6.f32233f
                int r0 = r0.f32226c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0023
                int r0 = r6.f32232e
                int r0 = r0 + r3
                r6.f32232e = r0
                kotlin.text.e r4 = r6.f32233f
                int r4 = r4.f32226c
                if (r0 >= r4) goto L_0x0031
            L_0x0023:
                int r0 = r6.f32230c
                kotlin.text.e r4 = r6.f32233f
                java.lang.CharSequence r4 = r4.f32224a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0047
            L_0x0031:
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f32229b
                kotlin.text.e r4 = r6.f32233f
                java.lang.CharSequence r4 = r4.f32224a
                int r4 = kotlin.text.StringsKt__StringsKt.V(r4)
                r0.<init>(r1, r4)
                r6.f32231d = r0
                r6.f32230c = r2
                goto L_0x009c
            L_0x0047:
                kotlin.text.e r0 = r6.f32233f
                kotlin.jvm.functions.Function2 r0 = r0.f32227d
                kotlin.text.e r4 = r6.f32233f
                java.lang.CharSequence r4 = r4.f32224a
                int r5 = r6.f32230c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L_0x0077
                kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
                int r1 = r6.f32229b
                kotlin.text.e r4 = r6.f32233f
                java.lang.CharSequence r4 = r4.f32224a
                int r4 = kotlin.text.StringsKt__StringsKt.V(r4)
                r0.<init>(r1, r4)
                r6.f32231d = r0
                r6.f32230c = r2
                goto L_0x009c
            L_0x0077:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f32229b
                kotlin.ranges.IntRange r4 = vk.j.o(r4, r2)
                r6.f32231d = r4
                int r2 = r2 + r0
                r6.f32229b = r2
                if (r0 != 0) goto L_0x0099
                r1 = r3
            L_0x0099:
                int r2 = r2 + r1
                r6.f32230c = r2
            L_0x009c:
                r6.f32228a = r3
            L_0x009e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.a():void");
        }

        /* renamed from: c */
        public IntRange next() {
            if (this.f32228a == -1) {
                a();
            }
            if (this.f32228a != 0) {
                IntRange intRange = this.f32231d;
                j.e(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f32231d = null;
                this.f32228a = -1;
                return intRange;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f32228a == -1) {
                a();
            }
            if (this.f32228a == 1) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(CharSequence charSequence, int i10, int i11, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        j.g(charSequence, "input");
        j.g(function2, "getNextMatch");
        this.f32224a = charSequence;
        this.f32225b = i10;
        this.f32226c = i11;
        this.f32227d = function2;
    }

    public Iterator<IntRange> iterator() {
        return new a(this);
    }
}
