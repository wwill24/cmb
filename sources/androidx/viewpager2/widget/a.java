package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f7293b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f7294a;

    /* renamed from: androidx.viewpager2.widget.a$a  reason: collision with other inner class name */
    class C0080a implements Comparator<int[]> {
        C0080a() {
        }

        /* renamed from: a */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f7293b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(@NonNull LinearLayoutManager linearLayoutManager) {
        this.f7294a = linearLayoutManager;
    }

    private boolean a() {
        boolean z10;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i10;
        int i11;
        int i12;
        int i13;
        int K = this.f7294a.K();
        if (K == 0) {
            return true;
        }
        if (this.f7294a.n2() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = K;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i14 = 0;
        while (i14 < K) {
            View J = this.f7294a.J(i14);
            if (J != null) {
                ViewGroup.LayoutParams layoutParams = J.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f7293b;
                }
                int[] iArr3 = iArr2[i14];
                if (z10) {
                    i11 = J.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    i11 = J.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr3[0] = i11 - i10;
                int[] iArr4 = iArr2[i14];
                if (z10) {
                    i13 = J.getRight();
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i13 = J.getBottom();
                    i12 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = i13 + i12;
                i14++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new C0080a());
        for (int i15 = 1; i15 < K; i15++) {
            if (iArr2[i15 - 1][1] != iArr2[i15][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i16 = iArr5[1];
        int i17 = iArr5[0];
        int i18 = i16 - i17;
        if (i17 > 0 || iArr2[K - 1][1] < i18) {
            return false;
        }
        return true;
    }

    private boolean b() {
        int K = this.f7294a.K();
        for (int i10 = 0; i10 < K; i10++) {
            if (c(this.f7294a.J(i10))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if ((!a() || this.f7294a.K() <= 1) && b()) {
            return true;
        }
        return false;
    }
}
