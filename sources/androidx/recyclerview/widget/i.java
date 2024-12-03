package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class i extends RecyclerView.n {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f6581d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    private Drawable f6582a;

    /* renamed from: b  reason: collision with root package name */
    private int f6583b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f6584c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public i(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f6581d);
        this.f6582a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        p(i10);
    }

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingTop();
            i10 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i11, recyclerView.getWidth() - recyclerView.getPaddingRight(), i10);
        } else {
            i10 = recyclerView.getHeight();
            i11 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getLayoutManager().Q(childAt, this.f6584c);
            int round = this.f6584c.right + Math.round(childAt.getTranslationX());
            this.f6582a.setBounds(round - this.f6582a.getIntrinsicWidth(), i11, round, i10);
            this.f6582a.draw(canvas);
        }
        canvas.restore();
    }

    private void m(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingLeft();
            i10 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i11, recyclerView.getPaddingTop(), i10, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i10 = recyclerView.getWidth();
            i11 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.m0(childAt, this.f6584c);
            int round = this.f6584c.bottom + Math.round(childAt.getTranslationY());
            this.f6582a.setBounds(i11, round - this.f6582a.getIntrinsicHeight(), i10, round);
            this.f6582a.draw(canvas);
        }
        canvas.restore();
    }

    @SuppressLint({"UnknownNullness"})
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        Drawable drawable = this.f6582a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f6583b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (recyclerView.getLayoutManager() != null && this.f6582a != null) {
            if (this.f6583b == 1) {
                m(canvas, recyclerView);
            } else {
                l(canvas, recyclerView);
            }
        }
    }

    public Drawable n() {
        return this.f6582a;
    }

    public void o(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.f6582a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void p(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f6583b = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
