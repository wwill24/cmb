package com.leanplum.messagetemplates.controllers;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.leanplum.messagetemplates.DialogCustomizer;
import com.leanplum.messagetemplates.MessageTemplates;
import com.leanplum.messagetemplates.options.BaseMessageOptions;
import com.leanplum.messagetemplates.options.CenterPopupOptions;
import com.leanplum.utils.SizeUtil;

public class CenterPopupController extends AbstractPopupController {
    public CenterPopupController(Activity activity, CenterPopupOptions centerPopupOptions) {
        super(activity, centerPopupOptions);
    }

    /* access modifiers changed from: protected */
    public void applyWindowDecoration() {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(2);
            window.setDimAmount(0.7f);
            DialogCustomizer customizer = MessageTemplates.getCustomizer();
            if (customizer != null) {
                customizer.customizeCenterPopup(this, this.contentView);
            }
        }
    }

    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams createLayoutParams() {
        Point displaySize = SizeUtil.getDisplaySize(this.activity);
        int dpToPx = SizeUtil.dpToPx(this.activity, ((CenterPopupOptions) this.options).getWidth());
        int dpToPx2 = SizeUtil.dpToPx(this.activity, ((CenterPopupOptions) this.options).getHeight());
        int i10 = displaySize.x;
        int i11 = SizeUtil.dp20;
        int i12 = i10 - i11;
        int i13 = displaySize.y - i11;
        double d10 = (double) dpToPx;
        double d11 = d10 / ((double) dpToPx2);
        if (dpToPx > i12 && ((int) (d10 / d11)) < i13) {
            dpToPx2 = (int) (((double) i12) / d11);
            dpToPx = i12;
        }
        if (dpToPx2 <= i13 || ((int) (((double) dpToPx2) * d11)) >= i12) {
            i13 = dpToPx2;
        } else {
            dpToPx = (int) (((double) i13) * d11);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, i13);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    public /* bridge */ /* synthetic */ View getContentView() {
        return super.getContentView();
    }

    public /* bridge */ /* synthetic */ BaseMessageOptions getOptions() {
        return super.getOptions();
    }

    /* access modifiers changed from: package-private */
    public boolean isFullscreen() {
        return false;
    }

    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }
}
