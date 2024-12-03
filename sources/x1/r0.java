package x1;

import android.view.View;

public abstract class r0 extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f18487a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    private static int d(u uVar, int i10) {
        int[] iArr;
        if (uVar == null || (iArr = (int[]) uVar.f18492a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i10];
    }

    public void a(u uVar) {
        View view = uVar.f18493b;
        Integer num = (Integer) uVar.f18492a.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        uVar.f18492a.put("android:visibilityPropagation:visibility", num);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = round;
        iArr[0] = round + (view.getWidth() / 2);
        int round2 = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = round2;
        iArr[1] = round2 + (view.getHeight() / 2);
        uVar.f18492a.put("android:visibilityPropagation:center", iArr);
    }

    public String[] b() {
        return f18487a;
    }

    public int e(u uVar) {
        Integer num;
        if (uVar == null || (num = (Integer) uVar.f18492a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int f(u uVar) {
        return d(uVar, 0);
    }

    public int g(u uVar) {
        return d(uVar, 1);
    }
}
