package com.coffeemeetsbagel.feature.chatlist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityContactUs;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.chatlist.BannerHolderUtil;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import lc.l;
import q5.f;

public class BannerHolder extends ConstraintLayout {
    private CmbTextView F;
    private CmbTextView G;
    private CmbTextView H;
    private BannerHolderUtil.b I;
    private FirebaseContract.Analytics J;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BannerHolderUtil.Question f12858a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f12859b;

        /* renamed from: com.coffeemeetsbagel.feature.chatlist.BannerHolder$a$a  reason: collision with other inner class name */
        class C0136a extends AnimatorListenerAdapter {
            C0136a() {
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                BannerHolder.this.clearAnimation();
            }
        }

        a(BannerHolderUtil.Question question, Fragment fragment) {
            this.f12858a = question;
            this.f12859b = fragment;
        }

        public void onAnimationEnd(Animator animator) {
            BannerHolderUtil.Question question = this.f12858a;
            if (question == BannerHolderUtil.Question.FEEDBACK) {
                BannerHolder.this.setBannerPromptToAskForFeedback(this.f12859b);
            } else if (question == BannerHolderUtil.Question.RATE) {
                BannerHolder.this.setBannerPromptToAskForRate(this.f12859b);
            }
            BannerHolder.this.clearAnimation();
            BannerHolder.this.animate().alpha(1.0f).setDuration(300).setListener(new C0136a()).start();
        }
    }

    public BannerHolder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void H(Fragment fragment, BannerHolderUtil.Question question) {
        animate().alpha(0.0f).setDuration(200).setStartDelay(200).setListener(new a(question, fragment)).start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        BannerHolderUtil.d((String) null);
        I();
        BannerHolderUtil.h(this.J, false, false, "feedback_leave_feedback");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(Fragment fragment, View view) {
        Intent intent = new Intent(fragment.requireContext(), ActivityContactUs.class);
        intent.putExtra("source", "rating_overlay");
        lc.a.e(fragment, intent, 1610);
        I();
        BannerHolderUtil.h(this.J, false, true, "feedback_leave_feedback");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        BannerHolderUtil.d("value_feedback_seen_rate");
        I();
        BannerHolderUtil.h(this.J, false, false, "feedback_rate_app");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(Fragment fragment, View view) {
        BannerHolderUtil.e();
        l.c(fragment.requireActivity());
        I();
        BannerHolderUtil.h(this.J, false, true, "feedback_rate_app");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(Fragment fragment, View view) {
        Bakery.w().M().w("feedback_banner_first_action_taken", "not_enjoying");
        H(fragment, BannerHolderUtil.Question.FEEDBACK);
        BannerHolderUtil.h(this.J, false, false, "feedback_first_question");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Fragment fragment, View view) {
        Bakery.w().M().w("feedback_banner_first_action_taken", "enjoying");
        H(fragment, BannerHolderUtil.Question.RATE);
        BannerHolderUtil.h(this.J, false, true, "feedback_first_question");
    }

    /* access modifiers changed from: package-private */
    public void I() {
        BannerHolderUtil.b(this, this.I);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.F = (CmbTextView) findViewById(R.id.textView_left_button);
        this.G = (CmbTextView) findViewById(R.id.textView_right_button);
        this.H = (CmbTextView) findViewById(R.id.textView_feedback_prompt);
        f.g(this.F, this.G);
    }

    public void setBannerDismissListener(BannerHolderUtil.b bVar) {
        this.I = bVar;
    }

    /* access modifiers changed from: package-private */
    public void setBannerPromptToAskForFeedback(Fragment fragment) {
        this.H.setText(R.string.feedback_prompt_leave_feedback);
        this.F.setText(R.string.feedback_prompt_no_thanks);
        this.G.setText(R.string.feedback_prompt_ok_sure);
        this.F.setOnClickListener(new c(this));
        this.G.setOnClickListener(new d(this, fragment));
    }

    /* access modifiers changed from: package-private */
    public void setBannerPromptToAskForRate(Fragment fragment) {
        Bakery.w().M().w("feedback_enjoying_prompted_action", "value_feedback_seen_rate");
        this.H.setText(R.string.feedback_prompt_rate_in_store);
        this.F.setText(R.string.feedback_prompt_no_thanks);
        this.G.setText(R.string.feedback_prompt_ok_sure);
        this.F.setOnClickListener(new a(this));
        this.G.setOnClickListener(new b(this, fragment));
    }

    /* access modifiers changed from: package-private */
    public void setBannerPromptToFirstQuestion(Fragment fragment) {
        Bakery.w().M().f("feedback_prompt_started", true);
        this.H.setText(R.string.feedback_prompt_enjoying_cmb);
        this.F.setText(R.string.feedback_prompt_not_really);
        this.G.setText(R.string.feedback_prompt_yes);
        this.F.setOnClickListener(new e(this, fragment));
        this.G.setOnClickListener(new f(this, fragment));
        Bakery.w().z().i("viewed enjoy banner");
    }

    public void setFirebaseAnalytics(FirebaseContract.Analytics analytics) {
        this.J = analytics;
    }
}
