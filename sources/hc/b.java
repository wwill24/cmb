package hc;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.coffeemeetsbagel.today_view.like_with_comment.LikeWithCommentBottomSheet;

public final /* synthetic */ class b implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LikeWithCommentBottomSheet f40891a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f40892b;

    public /* synthetic */ b(LikeWithCommentBottomSheet likeWithCommentBottomSheet, View view) {
        this.f40891a = likeWithCommentBottomSheet;
        this.f40892b = view;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return LikeWithCommentBottomSheet.N0(this.f40891a, this.f40892b, textView, i10, keyEvent);
    }
}
