package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.os.e;
import androidx.core.view.k0;
import androidx.core.view.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
public abstract class e0 {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f5836a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f5837b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f5838c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f5839d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f5840e;

        a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f5836a = i10;
            this.f5837b = arrayList;
            this.f5838c = arrayList2;
            this.f5839d = arrayList3;
            this.f5840e = arrayList4;
        }

        public void run() {
            for (int i10 = 0; i10 < this.f5836a; i10++) {
                n0.N0((View) this.f5837b.get(i10), (String) this.f5838c.get(i10));
                n0.N0((View) this.f5839d.get(i10), (String) this.f5840e.get(i10));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (!g(list, view, size)) {
            if (n0.K(view) != null) {
                list.add(view);
            }
            for (int i10 = size; i10 < list.size(); i10++) {
                View view2 = list.get(i10);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (!g(list, childAt, size) && n0.K(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean g(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    /* access modifiers changed from: protected */
    public void h(View view, Rect rect) {
        if (n0.V(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    public ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(n0.K(view));
            n0.N0(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList<View> arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(@NonNull Fragment fragment, @NonNull Object obj, @NonNull e eVar, @NonNull Runnable runnable) {
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    public void r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String K = n0.K(view2);
            arrayList4.add(K);
            if (K != null) {
                n0.N0(view2, (String) null);
                String str = map.get(K);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i11))) {
                        n0.N0(arrayList2.get(i11), K);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        k0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object u(Object obj);
}
