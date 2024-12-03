package ij;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class t implements Appendable, CharSequence {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f30014a;

    /* renamed from: b  reason: collision with root package name */
    private final Deque<a> f30015b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f30016a;

        /* renamed from: b  reason: collision with root package name */
        public int f30017b;

        /* renamed from: c  reason: collision with root package name */
        public int f30018c;

        /* renamed from: d  reason: collision with root package name */
        public final int f30019d;

        a(@NonNull Object obj, int i10, int i11, int i12) {
            this.f30016a = obj;
            this.f30017b = i10;
            this.f30018c = i11;
            this.f30019d = i12;
        }
    }

    static class b extends SpannableStringBuilder {
        b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public t() {
        this("");
    }

    private void e(int i10, CharSequence charSequence) {
        int i11;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z10 = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            if (spans != null) {
                i11 = spans.length;
            } else {
                i11 = 0;
            }
            if (i11 <= 0) {
                return;
            }
            if (z10) {
                for (int i12 = i11 - 1; i12 >= 0; i12--) {
                    Object obj = spans[i12];
                    i(obj, spanned.getSpanStart(obj) + i10, spanned.getSpanEnd(obj) + i10, spanned.getSpanFlags(obj));
                }
                return;
            }
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj2 = spans[i13];
                i(obj2, spanned.getSpanStart(obj2) + i10, spanned.getSpanEnd(obj2) + i10, spanned.getSpanFlags(obj2));
            }
        }
    }

    static boolean g(int i10, int i11, int i12) {
        return i12 > i11 && i11 >= 0 && i12 <= i10;
    }

    public static void j(@NonNull t tVar, Object obj, int i10, int i11) {
        if (obj != null && g(tVar.length(), i10, i11)) {
            k(tVar, obj, i10, i11);
        }
    }

    private static void k(@NonNull t tVar, Object obj, int i10, int i11) {
        if (obj == null) {
            return;
        }
        if (obj.getClass().isArray()) {
            for (Object k10 : (Object[]) obj) {
                k(tVar, k10, i10, i11);
            }
            return;
        }
        tVar.i(obj, i10, i11, 33);
    }

    @NonNull
    /* renamed from: a */
    public t append(char c10) {
        this.f30014a.append(c10);
        return this;
    }

    @NonNull
    /* renamed from: b */
    public t append(@NonNull CharSequence charSequence) {
        e(length(), charSequence);
        this.f30014a.append(charSequence);
        return this;
    }

    @NonNull
    /* renamed from: c */
    public t append(CharSequence charSequence, int i10, int i11) {
        CharSequence subSequence = charSequence.subSequence(i10, i11);
        e(length(), subSequence);
        this.f30014a.append(subSequence);
        return this;
    }

    public char charAt(int i10) {
        return this.f30014a.charAt(i10);
    }

    @NonNull
    public t d(@NonNull String str) {
        this.f30014a.append(str);
        return this;
    }

    @NonNull
    public List<a> f(int i10, int i11) {
        int i12;
        int length = length();
        if (!g(length, i10, i11)) {
            return Collections.emptyList();
        }
        if (i10 == 0 && length == i11) {
            ArrayList arrayList = new ArrayList(this.f30015b);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator<a> descendingIterator = this.f30015b.descendingIterator();
        while (descendingIterator.hasNext()) {
            a next = descendingIterator.next();
            int i13 = next.f30017b;
            if ((i13 >= i10 && i13 < i11) || (((i12 = next.f30018c) <= i11 && i12 > i10) || (i13 < i10 && i12 > i11))) {
                arrayList2.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.f30014a.charAt(length() - 1);
    }

    @NonNull
    public t i(@NonNull Object obj, int i10, int i11, int i12) {
        this.f30015b.push(new a(obj, i10, i11, i12));
        return this;
    }

    @NonNull
    public SpannableStringBuilder l() {
        b bVar = new b(this.f30014a);
        for (a next : this.f30015b) {
            bVar.setSpan(next.f30016a, next.f30017b, next.f30018c, next.f30019d);
        }
        return bVar;
    }

    public int length() {
        return this.f30014a.length();
    }

    public CharSequence subSequence(int i10, int i11) {
        List<a> f10 = f(i10, i11);
        if (f10.isEmpty()) {
            return this.f30014a.subSequence(i10, i11);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f30014a.subSequence(i10, i11));
        int length = spannableStringBuilder.length();
        for (a next : f10) {
            int max = Math.max(0, next.f30017b - i10);
            spannableStringBuilder.setSpan(next.f30016a, max, Math.min(length, (next.f30018c - next.f30017b) + max), next.f30019d);
        }
        return spannableStringBuilder;
    }

    @NonNull
    public String toString() {
        return this.f30014a.toString();
    }

    public t(@NonNull CharSequence charSequence) {
        this.f30015b = new ArrayDeque(8);
        this.f30014a = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
