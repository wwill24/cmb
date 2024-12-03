package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import bf.h;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

class TimePickerView extends ConstraintLayout {
    private final Chip F;
    private final Chip G;
    private final ClockHandView H;
    private final ClockFaceView I;
    private final MaterialButtonToggleGroup J;
    private final View.OnClickListener K;
    private e L;
    /* access modifiers changed from: private */
    public f M;
    /* access modifiers changed from: private */
    public d N;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (TimePickerView.this.M != null) {
                TimePickerView.this.M.a(((Integer) view.getTag(bf.f.selection_type)).intValue());
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            d D = TimePickerView.this.N;
            if (D == null) {
                return false;
            }
            D.a();
            return true;
        }
    }

    class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f20435a;

        c(GestureDetector gestureDetector) {
            this.f20435a = gestureDetector;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f20435a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface d {
        void a();
    }

    interface e {
        void a(int i10);
    }

    interface f {
        void a(int i10);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
        e eVar;
        int i11;
        if (z10 && (eVar = this.L) != null) {
            if (i10 == bf.f.material_clock_period_pm_button) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            eVar.a(i11);
        }
    }

    private void F() {
        Chip chip = this.F;
        int i10 = bf.f.selection_type;
        chip.setTag(i10, 12);
        this.G.setTag(i10, 10);
        this.F.setOnClickListener(this.K);
        this.G.setOnClickListener(this.K);
        this.F.setAccessibilityClassName("android.view.View");
        this.G.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void G() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.F.setOnTouchListener(cVar);
        this.G.setOnTouchListener(cVar);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.G.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.K = new a();
        LayoutInflater.from(context).inflate(h.material_timepicker, this);
        this.I = (ClockFaceView) findViewById(bf.f.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(bf.f.material_clock_period_toggle);
        this.J = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new e(this));
        this.F = (Chip) findViewById(bf.f.material_minute_tv);
        this.G = (Chip) findViewById(bf.f.material_hour_tv);
        this.H = (ClockHandView) findViewById(bf.f.material_clock_hand);
        G();
        F();
    }
}
