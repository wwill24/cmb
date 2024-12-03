package com.coffeemeetsbagel.today_view.today_bagel;

import android.view.View;
import com.coffeemeetsbagel.today_view.like_with_comment.LikeWithCommentBottomSheet;

public final /* synthetic */ class c1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TodayBagelView f37446a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LikeWithCommentBottomSheet f37447b;

    public /* synthetic */ c1(TodayBagelView todayBagelView, LikeWithCommentBottomSheet likeWithCommentBottomSheet) {
        this.f37446a = todayBagelView;
        this.f37447b = likeWithCommentBottomSheet;
    }

    public final void onClick(View view) {
        this.f37446a.q(this.f37447b, view);
    }
}
