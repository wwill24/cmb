package com.leanplum.messagetemplates.controllers;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.leanplum.core.R;
import com.leanplum.utils.SizeUtil;
import com.leanplum.views.CloseButton;
import com.leanplum.views.ViewUtils;

abstract class BaseController extends Dialog {
    protected Activity activity;
    protected RelativeLayout contentView;
    protected boolean isClosing = false;

    protected BaseController(Activity activity2) {
        super(activity2, ViewUtils.getThemeId(activity2));
        this.activity = activity2;
        SizeUtil.init(activity2);
    }

    private CloseButton createCloseButton(View view) {
        CloseButton closeButton = new CloseButton(this.activity);
        closeButton.setId(R.id.close_button);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (isFullscreen()) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i10 = SizeUtil.dp5;
            layoutParams.setMargins(0, i10, i10, 0);
        } else {
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(7, view.getId());
            int i11 = SizeUtil.dp7;
            layoutParams.setMargins(0, -i11, -i11, 0);
        }
        closeButton.setLayoutParams(layoutParams);
        closeButton.setOnClickListener(new b(this));
        return closeButton;
    }

    private RelativeLayout createContentView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setLayoutParams(layoutParams);
        return relativeLayout;
    }

    private RelativeLayout createMessageView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        relativeLayout.setId(R.id.container_view);
        relativeLayout.setLayoutParams(createLayoutParams());
        ViewUtils.applyBackground(relativeLayout, 0, !isFullscreen());
        addMessageChildViews(relativeLayout);
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createCloseButton$0(View view) {
        runDismissAction();
        cancel();
    }

    /* access modifiers changed from: package-private */
    public abstract void addMessageChildViews(RelativeLayout relativeLayout);

    /* access modifiers changed from: package-private */
    public abstract void applyWindowDecoration();

    public void cancel() {
        if (!this.isClosing) {
            this.isClosing = true;
            Animation createFadeOutAnimation = ViewUtils.createFadeOutAnimation(350);
            createFadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    BaseController.this.onFadeOutAnimationEnd();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            this.contentView.startAnimation(createFadeOutAnimation);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract RelativeLayout.LayoutParams createLayoutParams();

    public View getContentView() {
        return this.contentView;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean hasDismissButton();

    /* access modifiers changed from: protected */
    public void init() {
        this.contentView = createContentView();
        RelativeLayout createMessageView = createMessageView();
        this.contentView.addView(createMessageView);
        if (hasDismissButton()) {
            this.contentView.addView(createCloseButton(createMessageView));
        }
        applyWindowDecoration();
        RelativeLayout relativeLayout = this.contentView;
        setContentView(relativeLayout, relativeLayout.getLayoutParams());
        this.contentView.setAnimation(ViewUtils.createFadeInAnimation(350));
    }

    /* access modifiers changed from: package-private */
    public abstract boolean isFullscreen();

    public void onBackPressed() {
        runDismissAction();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onFadeOutAnimationEnd() {
        super.cancel();
    }

    /* access modifiers changed from: protected */
    public abstract void runDismissAction();
}
