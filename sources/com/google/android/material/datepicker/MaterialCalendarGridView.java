package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.d;
import androidx.core.view.accessibility.k;
import androidx.core.view.n0;
import bf.f;
import com.google.android.material.internal.r;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f19553a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19554b;

    class a extends androidx.core.view.a {
        a() {
        }

        public void g(View view, @NonNull k kVar) {
            super.g(view, kVar);
            kVar.c0((Object) null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter().m());
        } else if (i10 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    private View c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    private static int d(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l10, Long l11, Long l12, Long l13) {
        return l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue();
    }

    @NonNull
    /* renamed from: b */
    public l getAdapter() {
        return (l) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(@NonNull Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        l b10 = getAdapter();
        DateSelector<?> dateSelector = b10.f19650b;
        b bVar = b10.f19652d;
        int max = Math.max(b10.b(), getFirstVisiblePosition());
        int min = Math.min(b10.m(), getLastVisiblePosition());
        Long d10 = b10.getItem(max);
        Long d11 = b10.getItem(min);
        Iterator<d<Long, Long>> it = dateSelector.S0().iterator();
        while (it.hasNext()) {
            d next = it.next();
            F f10 = next.f4735a;
            if (f10 == null) {
                materialCalendarGridView = this;
            } else if (next.f4736b != null) {
                long longValue = ((Long) f10).longValue();
                long longValue2 = ((Long) next.f4736b).longValue();
                if (!e(d10, d11, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean i20 = r.i(this);
                    if (longValue < d10.longValue()) {
                        if (b10.h(max)) {
                            i19 = 0;
                        } else if (!i20) {
                            i19 = materialCalendarGridView.c(max - 1).getRight();
                        } else {
                            i19 = materialCalendarGridView.c(max - 1).getLeft();
                        }
                        i10 = i19;
                        i11 = max;
                    } else {
                        materialCalendarGridView.f19553a.setTimeInMillis(longValue);
                        i11 = b10.a(materialCalendarGridView.f19553a.get(5));
                        i10 = d(materialCalendarGridView.c(i11));
                    }
                    if (longValue2 > d11.longValue()) {
                        if (b10.i(min)) {
                            i18 = getWidth();
                        } else if (!i20) {
                            i18 = materialCalendarGridView.c(min).getRight();
                        } else {
                            i18 = materialCalendarGridView.c(min).getLeft();
                        }
                        i12 = i18;
                        i13 = min;
                    } else {
                        materialCalendarGridView.f19553a.setTimeInMillis(longValue2);
                        i13 = b10.a(materialCalendarGridView.f19553a.get(5));
                        i12 = d(materialCalendarGridView.c(i13));
                    }
                    int itemId = (int) b10.getItemId(i11);
                    int i21 = max;
                    int i22 = min;
                    int itemId2 = (int) b10.getItemId(i13);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View c10 = materialCalendarGridView.c(numColumns);
                        int top = c10.getTop() + bVar.f19591a.c();
                        l lVar = b10;
                        int bottom = c10.getBottom() - bVar.f19591a.b();
                        if (!i20) {
                            if (numColumns > i11) {
                                i15 = 0;
                            } else {
                                i15 = i10;
                            }
                            if (i13 > numColumns2) {
                                i14 = getWidth();
                            } else {
                                i14 = i12;
                            }
                        } else {
                            if (i13 > numColumns2) {
                                i16 = 0;
                            } else {
                                i16 = i12;
                            }
                            if (numColumns > i11) {
                                i17 = getWidth();
                            } else {
                                i17 = i10;
                            }
                            int i23 = i16;
                            i14 = i17;
                            i15 = i23;
                        }
                        canvas.drawRect((float) i15, (float) top, (float) i14, (float) bottom, bVar.f19598h);
                        itemId++;
                        materialCalendarGridView = this;
                        it = it;
                        b10 = lVar;
                    }
                    materialCalendarGridView = this;
                    max = i21;
                    min = i22;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    public void onMeasure(int i10, int i11) {
        if (this.f19554b) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    public void setSelection(int i10) {
        if (i10 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19553a = r.l();
        if (i.R0(getContext())) {
            setNextFocusLeftId(f.cancel_button);
            setNextFocusRightId(f.confirm_button);
        }
        this.f19554b = i.T0(getContext());
        n0.s0(this, new a());
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof l) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), l.class.getCanonicalName()}));
        }
    }
}
