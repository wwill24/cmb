package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.k;
import androidx.core.view.h;
import androidx.core.view.n0;
import bf.k;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import tf.k;

public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: l  reason: collision with root package name */
    private static final int f19343l = k.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f19344a;

    /* renamed from: b  reason: collision with root package name */
    private final e f19345b;

    /* renamed from: c  reason: collision with root package name */
    private final LinkedHashSet<d> f19346c;

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<MaterialButton> f19347d;

    /* renamed from: e  reason: collision with root package name */
    private Integer[] f19348e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19349f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19350g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19351h;

    /* renamed from: j  reason: collision with root package name */
    private final int f19352j;

    /* renamed from: k  reason: collision with root package name */
    private Set<Integer> f19353k;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        public void g(View view, @NonNull androidx.core.view.accessibility.k kVar) {
            super.g(view, kVar);
            kVar.d0(k.c.a(0, 1, MaterialButtonToggleGroup.this.i(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private static class c {

        /* renamed from: e  reason: collision with root package name */
        private static final tf.c f19356e = new tf.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        tf.c f19357a;

        /* renamed from: b  reason: collision with root package name */
        tf.c f19358b;

        /* renamed from: c  reason: collision with root package name */
        tf.c f19359c;

        /* renamed from: d  reason: collision with root package name */
        tf.c f19360d;

        c(tf.c cVar, tf.c cVar2, tf.c cVar3, tf.c cVar4) {
            this.f19357a = cVar;
            this.f19358b = cVar3;
            this.f19359c = cVar4;
            this.f19360d = cVar2;
        }

        public static c a(c cVar) {
            tf.c cVar2 = f19356e;
            return new c(cVar2, cVar.f19360d, cVar2, cVar.f19359c);
        }

        public static c b(c cVar, View view) {
            return r.i(view) ? c(cVar) : d(cVar);
        }

        public static c c(c cVar) {
            tf.c cVar2 = cVar.f19357a;
            tf.c cVar3 = cVar.f19360d;
            tf.c cVar4 = f19356e;
            return new c(cVar2, cVar3, cVar4, cVar4);
        }

        public static c d(c cVar) {
            tf.c cVar2 = f19356e;
            return new c(cVar2, cVar2, cVar.f19358b, cVar.f19359c);
        }

        public static c e(c cVar, View view) {
            return r.i(view) ? d(cVar) : c(cVar);
        }

        public static c f(c cVar) {
            tf.c cVar2 = cVar.f19357a;
            tf.c cVar3 = f19356e;
            return new c(cVar2, cVar3, cVar.f19358b, cVar3);
        }
    }

    public interface d {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    private class e implements MaterialButton.b {
        private e() {
        }

        public void a(@NonNull MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ e(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, bf.b.materialButtonToggleGroupStyle);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
                MaterialButton h10 = h(i10);
                int min = Math.min(h10.getStrokeWidth(), h(i10 - 1).getStrokeWidth());
                LinearLayout.LayoutParams d10 = d(h10);
                if (getOrientation() == 0) {
                    h.c(d10, 0);
                    h.d(d10, -min);
                    d10.topMargin = 0;
                } else {
                    d10.bottomMargin = 0;
                    d10.topMargin = -min;
                    h.d(d10, 0);
                }
                h10.setLayoutParams(d10);
            }
            n(firstVisibleChildIndex);
        }
    }

    @NonNull
    private LinearLayout.LayoutParams d(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void e(int i10, boolean z10) {
        if (i10 == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Button ID is not valid: ");
            sb2.append(i10);
            return;
        }
        HashSet hashSet = new HashSet(this.f19353k);
        if (z10 && !hashSet.contains(Integer.valueOf(i10))) {
            if (this.f19350g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i10));
        } else if (!z10 && hashSet.contains(Integer.valueOf(i10))) {
            if (!this.f19351h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i10));
            }
        } else {
            return;
        }
        q(hashSet);
    }

    private void g(int i10, boolean z10) {
        Iterator<d> it = this.f19346c.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, z10);
        }
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (k(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (k(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private MaterialButton h(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    /* access modifiers changed from: private */
    public int i(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && k(i11)) {
                i10++;
            }
        }
        return -1;
    }

    private c j(int i10, int i11, int i12) {
        boolean z10;
        c cVar = this.f19344a.get(i10);
        if (i11 == i12) {
            return cVar;
        }
        if (getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 == i11) {
            if (z10) {
                return c.e(cVar, this);
            }
            return c.f(cVar);
        } else if (i10 != i12) {
            return null;
        } else {
            if (z10) {
                return c.b(cVar, this);
            }
            return c.a(cVar);
        }
    }

    private boolean k(int i10) {
        if (getChildAt(i10).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void n(int i10) {
        if (getChildCount() != 0 && i10 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) h(i10).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            h.c(layoutParams, 0);
            h.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void o(int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof MaterialButton) {
            this.f19349f = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.f19349f = false;
        }
    }

    private static void p(k.b bVar, c cVar) {
        if (cVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(cVar.f19357a).t(cVar.f19360d).F(cVar.f19358b).x(cVar.f19359c);
        }
    }

    private void q(Set<Integer> set) {
        Set<Integer> set2 = this.f19353k;
        this.f19353k = new HashSet(set);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = h(i10).getId();
            o(id2, set.contains(Integer.valueOf(id2)));
            if (set2.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                g(id2, set.contains(Integer.valueOf(id2)));
            }
        }
        invalidate();
    }

    private void r() {
        TreeMap treeMap = new TreeMap(this.f19347d);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(h(i10), Integer.valueOf(i10));
        }
        this.f19348e = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(n0.k());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f19345b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i10, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            e(materialButton.getId(), materialButton.isChecked());
            tf.k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f19344a.add(new c(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
            materialButton.setEnabled(isEnabled());
            n0.s0(materialButton, new b());
        }
    }

    public void b(@NonNull d dVar) {
        this.f19346c.add(dVar);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        r();
        super.dispatchDraw(canvas);
    }

    public void f() {
        q(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.f19350g || this.f19353k.isEmpty()) {
            return -1;
        }
        return this.f19353k.iterator().next().intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            int id2 = h(i10).getId();
            if (this.f19353k.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f19348e;
        if (numArr == null || i11 >= numArr.length) {
            return i11;
        }
        return numArr[i11].intValue();
    }

    public boolean l() {
        return this.f19350g;
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull MaterialButton materialButton, boolean z10) {
        if (!this.f19349f) {
            e(materialButton.getId(), z10);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f19352j;
        if (i10 != -1) {
            q(Collections.singleton(Integer.valueOf(i10)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.accessibility.k C0 = androidx.core.view.accessibility.k.C0(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (l()) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        C0.c0(k.b.a(1, visibleButtonCount, false, i10));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        s();
        c();
        super.onMeasure(i10, i11);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal((MaterialButton.b) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f19344a.remove(indexOfChild);
        }
        s();
        c();
    }

    /* access modifiers changed from: package-private */
    public void s() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton h10 = h(i10);
            if (h10.getVisibility() != 8) {
                k.b v10 = h10.getShapeAppearanceModel().v();
                p(v10, j(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                h10.setShapeAppearanceModel(v10.m());
            }
        }
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            h(i10).setEnabled(z10);
        }
    }

    public void setSelectionRequired(boolean z10) {
        this.f19351h = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f19350g != z10) {
            this.f19350g = z10;
            f();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = f19343l
            android.content.Context r7 = wf.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f19344a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$e r7 = new com.google.android.material.button.MaterialButtonToggleGroup$e
            r0 = 0
            r7.<init>(r6, r0)
            r6.f19345b = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f19346c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f19347d = r7
            r7 = 0
            r6.f19349f = r7
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.f19353k = r0
            android.content.Context r0 = r6.getContext()
            int[] r2 = bf.l.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.p.i(r0, r1, r2, r3, r4, r5)
            int r9 = bf.l.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection((boolean) r9)
            int r9 = bf.l.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f19352j = r9
            int r9 = bf.l.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f19351h = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            int r9 = bf.l.MaterialButtonToggleGroup_android_enabled
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setEnabled(r9)
            r8.recycle()
            androidx.core.view.n0.D0(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
