package com.leanplum.messagetemplates.controllers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.leanplum.core.R;
import com.leanplum.messagetemplates.options.BaseMessageOptions;
import com.leanplum.utils.BitmapUtil;
import com.leanplum.utils.SizeUtil;
import com.leanplum.views.BackgroundImageView;

abstract class AbstractPopupController extends BaseController {
    protected BaseMessageOptions options;

    protected AbstractPopupController(Activity activity, BaseMessageOptions baseMessageOptions) {
        super(activity);
        this.options = baseMessageOptions;
        init();
    }

    private TextView createAcceptButton(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.accept_button);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        layoutParams.setMargins(0, 0, 0, SizeUtil.dp5);
        textView.setPadding(SizeUtil.dp20, SizeUtil.dp5, SizeUtil.dp20, SizeUtil.dp5);
        textView.setLayoutParams(layoutParams);
        textView.setText(this.options.getAcceptButtonText());
        textView.setTextColor(this.options.getAcceptButtonTextColor());
        textView.setTypeface((Typeface) null, 1);
        BitmapUtil.stateBackgroundDarkerByPercentage(textView, this.options.getAcceptButtonBackgroundColor(), 30);
        textView.setTextSize(2, 18.0f);
        textView.setOnClickListener(new a(this));
        return textView;
    }

    private ImageView createBackgroundImageView(Context context) {
        BackgroundImageView backgroundImageView = new BackgroundImageView(context, this.options.getBackgroundColor(), this.options.getBackgroundImage(), !isFullscreen());
        backgroundImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return backgroundImageView;
    }

    private TextView createMessageView(Context context) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setText(this.options.getMessageText());
        textView.setTextColor(this.options.getMessageColor());
        textView.setTextSize(2, 18.0f);
        return textView;
    }

    private RelativeLayout createTitleView(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(R.id.title_view);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        int i10 = SizeUtil.dp5;
        textView.setPadding(0, i10, 0, i10);
        textView.setGravity(17);
        textView.setText(this.options.getTitle());
        textView.setTextColor(this.options.getTitleColor());
        textView.setTextSize(2, 20.0f);
        textView.setTypeface((Typeface) null, 1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createAcceptButton$0(View view) {
        if (!this.isClosing) {
            this.options.accept();
            cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void addMessageChildViews(RelativeLayout relativeLayout) {
        relativeLayout.addView(createBackgroundImageView(this.activity));
        RelativeLayout createTitleView = createTitleView(this.activity);
        relativeLayout.addView(createTitleView);
        TextView createAcceptButton = createAcceptButton(this.activity);
        relativeLayout.addView(createAcceptButton);
        TextView createMessageView = createMessageView(this.activity);
        ((RelativeLayout.LayoutParams) createMessageView.getLayoutParams()).addRule(3, createTitleView.getId());
        ((RelativeLayout.LayoutParams) createMessageView.getLayoutParams()).addRule(2, createAcceptButton.getId());
        relativeLayout.addView(createMessageView);
    }

    public BaseMessageOptions getOptions() {
        return this.options;
    }

    /* access modifiers changed from: protected */
    public boolean hasDismissButton() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void runDismissAction() {
        this.options.dismiss();
    }
}
