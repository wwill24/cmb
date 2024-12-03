package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.mparticle.identity.IdentityHttpResponse;
import com.skydoves.balloon.internals.b;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.j;
import wk.l;
import yh.a;
import yh.c;
import yh.d;

public final class BalloonAnchorOverlayView extends View {

    /* renamed from: m  reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f22826m = {kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorView", "getAnchorView()Landroid/view/View;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorViewList", "getAnchorViewList()Ljava/util/List;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayColor", "getOverlayColor()I", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPaddingColor", "getOverlayPaddingColor()I", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPadding", "getOverlayPadding()F", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPosition", "getOverlayPosition()Landroid/graphics/Point;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "balloonOverlayShape", "getBalloonOverlayShape()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final b f22827a;

    /* renamed from: b  reason: collision with root package name */
    private final b f22828b;

    /* renamed from: c  reason: collision with root package name */
    private final b f22829c;

    /* renamed from: d  reason: collision with root package name */
    private final b f22830d;

    /* renamed from: e  reason: collision with root package name */
    private final b f22831e;

    /* renamed from: f  reason: collision with root package name */
    private final b f22832f;

    /* renamed from: g  reason: collision with root package name */
    private final b f22833g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f22834h;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f22835j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f22836k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f22837l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void a(View view, Canvas canvas) {
        RectF rectF;
        if (view != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            Point overlayPosition = getOverlayPosition();
            if (overlayPosition != null) {
                rectF = new RectF(((float) overlayPosition.x) - getOverlayPadding(), (((float) overlayPosition.y) - getOverlayPadding()) + ((float) getStatusBarHeight()), ((float) (overlayPosition.x + view.getWidth())) + getOverlayPadding(), ((float) (overlayPosition.y + view.getHeight())) + getOverlayPadding() + ((float) getStatusBarHeight()));
            } else {
                rectF = new RectF(((float) rect.left) - getOverlayPadding(), ((float) rect.top) - getOverlayPadding(), ((float) rect.right) + getOverlayPadding(), ((float) rect.bottom) + getOverlayPadding());
            }
            float overlayPadding = getOverlayPadding() / ((float) 2);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(overlayPadding, overlayPadding);
            d balloonOverlayShape = getBalloonOverlayShape();
            if (balloonOverlayShape instanceof yh.b) {
                canvas.drawOval(rectF, this.f22835j);
                canvas.drawOval(rectF2, this.f22836k);
            } else if (balloonOverlayShape instanceof a) {
                a aVar = (a) balloonOverlayShape;
                Float a10 = aVar.a();
                if (a10 != null) {
                    float floatValue = a10.floatValue();
                    canvas.drawCircle(rectF.centerX(), rectF.centerY(), floatValue, this.f22835j);
                    canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), floatValue - overlayPadding, this.f22836k);
                }
                Integer b10 = aVar.b();
                if (b10 != null) {
                    int intValue = b10.intValue();
                    float centerX = rectF.centerX();
                    float centerY = rectF.centerY();
                    Context context = getContext();
                    j.f(context, IdentityHttpResponse.CONTEXT);
                    canvas.drawCircle(centerX, centerY, j.g(context, "<this>"), this.f22835j);
                    float centerX2 = rectF2.centerX();
                    float centerY2 = rectF2.centerY();
                    Context context2 = getContext();
                    j.f(context2, IdentityHttpResponse.CONTEXT);
                    canvas.drawCircle(centerX2, centerY2, j.g(context2, "<this>") - overlayPadding, this.f22836k);
                }
            } else if (balloonOverlayShape instanceof c) {
                c cVar = (c) balloonOverlayShape;
                Pair<Float, Float> a11 = cVar.a();
                if (a11 != null) {
                    canvas.drawRoundRect(rectF, a11.c().floatValue(), a11.d().floatValue(), this.f22835j);
                    canvas.drawRoundRect(rectF2, a11.c().floatValue() - overlayPadding, a11.d().floatValue() - overlayPadding, this.f22836k);
                }
                Pair<Integer, Integer> b11 = cVar.b();
                if (b11 != null) {
                    Context context3 = getContext();
                    j.f(context3, IdentityHttpResponse.CONTEXT);
                    float c10 = j.g(context3, "<this>");
                    Context context4 = getContext();
                    j.f(context4, IdentityHttpResponse.CONTEXT);
                    canvas.drawRoundRect(rectF, c10, j.g(context4, "<this>"), this.f22835j);
                    Context context5 = getContext();
                    j.f(context5, IdentityHttpResponse.CONTEXT);
                    Context context6 = getContext();
                    j.f(context6, IdentityHttpResponse.CONTEXT);
                    canvas.drawRoundRect(rectF2, j.g(context5, "<this>") - overlayPadding, j.g(context6, "<this>") - overlayPadding, this.f22836k);
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final void b() {
        boolean z10;
        boolean z11;
        if (getWidth() != 0 && getHeight() != 0) {
            View anchorView = getAnchorView();
            boolean z12 = true;
            if (anchorView == null || anchorView.getWidth() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                View anchorView2 = getAnchorView();
                if (anchorView2 == null || anchorView2.getHeight() != 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (!z11) {
                    Bitmap bitmap = this.f22834h;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    this.f22834h = createBitmap;
                    Canvas canvas = new Canvas(createBitmap);
                    Paint paint = this.f22835j;
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                    paint.setColor(getOverlayColor());
                    canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f22835j);
                    Paint paint2 = this.f22835j;
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    paint2.setColor(0);
                    Paint paint3 = this.f22836k;
                    paint3.setColor(getOverlayPaddingColor());
                    paint3.setStyle(Paint.Style.STROKE);
                    paint3.setStrokeWidth(getOverlayPadding());
                    List<View> anchorViewList = getAnchorViewList();
                    if (anchorViewList != null && !anchorViewList.isEmpty()) {
                        z12 = false;
                    }
                    if (z12) {
                        a(getAnchorView(), canvas);
                    } else {
                        List<View> anchorViewList2 = getAnchorViewList();
                        if (anchorViewList2 != null) {
                            for (View a10 : anchorViewList2) {
                                a(a10, canvas);
                            }
                        }
                    }
                    this.f22837l = false;
                }
            }
        }
    }

    private final int getStatusBarHeight() {
        Rect rect = new Rect();
        Context context = getContext();
        if (!(context instanceof Activity)) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r1 != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r4) {
        /*
            r3 = this;
            boolean r0 = r3.f22837l
            if (r0 != 0) goto L_0x0016
            android.graphics.Bitmap r0 = r3.f22834h
            if (r0 == 0) goto L_0x0016
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.isRecycled()
            if (r0 != r1) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            if (r1 == 0) goto L_0x0019
        L_0x0016:
            r3.b()
        L_0x0019:
            android.graphics.Bitmap r0 = r3.f22834h
            if (r0 == 0) goto L_0x002a
            boolean r1 = r0.isRecycled()
            if (r1 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x002a
            r1 = 0
            r2 = 0
            r4.drawBitmap(r0, r2, r2, r1)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.balloon.overlay.BalloonAnchorOverlayView.dispatchDraw(android.graphics.Canvas):void");
    }

    public final View getAnchorView() {
        return (View) this.f22827a.getValue(this, f22826m[0]);
    }

    public final List<View> getAnchorViewList() {
        return (List) this.f22828b.getValue(this, f22826m[1]);
    }

    public final d getBalloonOverlayShape() {
        return (d) this.f22833g.getValue(this, f22826m[6]);
    }

    public final int getOverlayColor() {
        return ((Number) this.f22829c.getValue(this, f22826m[2])).intValue();
    }

    public final float getOverlayPadding() {
        return ((Number) this.f22831e.getValue(this, f22826m[4])).floatValue();
    }

    public final int getOverlayPaddingColor() {
        return ((Number) this.f22830d.getValue(this, f22826m[3])).intValue();
    }

    public final Point getOverlayPosition() {
        return (Point) this.f22832f.getValue(this, f22826m[5]);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f22837l = true;
    }

    public final void setAnchorView(View view) {
        this.f22827a.setValue(this, f22826m[0], view);
    }

    public final void setAnchorViewList(List<? extends View> list) {
        this.f22828b.setValue(this, f22826m[1], list);
    }

    public final void setBalloonOverlayShape(d dVar) {
        j.g(dVar, "<set-?>");
        this.f22833g.setValue(this, f22826m[6], dVar);
    }

    public final void setOverlayColor(int i10) {
        this.f22829c.setValue(this, f22826m[2], Integer.valueOf(i10));
    }

    public final void setOverlayPadding(float f10) {
        this.f22831e.setValue(this, f22826m[4], Float.valueOf(f10));
    }

    public final void setOverlayPaddingColor(int i10) {
        this.f22830d.setValue(this, f22826m[3], Integer.valueOf(i10));
    }

    public final void setOverlayPosition(Point point) {
        this.f22832f.setValue(this, f22826m[5], point);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f22827a = j.g(this, "<this>");
        this.f22828b = j.g(this, "<this>");
        this.f22829c = j.g(this, "<this>");
        this.f22830d = j.g(this, "<this>");
        this.f22831e = j.g(this, "<this>");
        this.f22832f = j.g(this, "<this>");
        this.f22833g = j.g(this, "<this>");
        Paint paint = new Paint(1);
        this.f22835j = paint;
        Paint paint2 = new Paint(1);
        this.f22836k = paint2;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        paint2.setDither(true);
    }
}
