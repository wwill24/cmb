package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.WebView;

@SuppressLint({"ViewConstructor"})
class w extends WebView {

    /* renamed from: a  reason: collision with root package name */
    final Point f10460a = new Point();

    /* renamed from: b  reason: collision with root package name */
    private int f10461b;

    /* renamed from: c  reason: collision with root package name */
    private int f10462c;

    /* renamed from: d  reason: collision with root package name */
    private int f10463d;

    /* renamed from: e  reason: collision with root package name */
    private int f10464e;

    @SuppressLint({"ResourceType"})
    public w(Context context, int i10, int i11, int i12, int i13) {
        super(context);
        this.f10463d = i10;
        this.f10461b = i11;
        this.f10464e = i12;
        this.f10462c = i13;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setOverScrollMode(2);
        setBackgroundColor(0);
        setId(188293);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i10 = this.f10463d;
        if (i10 != 0) {
            this.f10460a.x = (int) TypedValue.applyDimension(1, (float) i10, getResources().getDisplayMetrics());
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f10460a.x = (int) (((float) (displayMetrics.widthPixels * this.f10464e)) / 100.0f);
        }
        int i11 = this.f10461b;
        if (i11 != 0) {
            this.f10460a.y = (int) TypedValue.applyDimension(1, (float) i11, getResources().getDisplayMetrics());
            return;
        }
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.f10460a.y = (int) (((float) (displayMetrics2.heightPixels * this.f10462c)) / 100.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        a();
        Point point = this.f10460a;
        setMeasuredDimension(point.x, point.y);
    }

    public boolean performClick() {
        return super.performClick();
    }
}
