package com.coffeemeetsbagel.like_pass.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import ba.d;
import j5.x;
import java.util.List;
import qj.q;

public class LikePassButtonsSpreadView extends RelativeLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private MatchActionFab f14076a;

    /* renamed from: b  reason: collision with root package name */
    private MatchActionFab f14077b;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14078a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.coffeemeetsbagel.like_pass.view.MatchActionType[] r0 = com.coffeemeetsbagel.like_pass.view.MatchActionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14078a = r0
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.LIKE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14078a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.like_pass.view.MatchActionType r1 = com.coffeemeetsbagel.like_pass.view.MatchActionType.PASS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.like_pass.view.LikePassButtonsSpreadView.a.<clinit>():void");
        }
    }

    public LikePassButtonsSpreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setButtonsClickableAndEnabled(boolean z10) {
        this.f14076a.setClickable(z10);
        this.f14077b.setClickable(z10);
        this.f14076a.setEnabled(z10);
        this.f14077b.setEnabled(z10);
    }

    public void a(List<MatchActionType> list, Long l10) {
        for (MatchActionType ordinal : list) {
            int i10 = a.f14078a[ordinal.ordinal()];
            if (i10 == 1) {
                this.f14076a.setVisibility(0);
            } else if (i10 == 2) {
                this.f14077b.setVisibility(0);
            } else {
                throw new IllegalStateException("Illegal button type");
            }
        }
    }

    public q<x> b(MatchActionType matchActionType) {
        setButtonsClickableAndEnabled(false);
        int i10 = a.f14078a[matchActionType.ordinal()];
        if (i10 == 1) {
            return this.f14076a.A();
        }
        if (i10 != 2) {
            return null;
        }
        return this.f14077b.A();
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14076a = (MatchActionFab) findViewById(d.button_like_v2);
        this.f14077b = (MatchActionFab) findViewById(d.button_pass_v2);
    }

    public void setCommentButtonImageResource(int i10) {
    }

    public void setIsEnabled(Boolean bool) {
    }

    public void setLikeButtonImageResource(int i10) {
        this.f14076a.setImageResource(i10);
    }
}
