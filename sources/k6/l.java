package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import z1.a;
import z1.b;

public final class l implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15782a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f15783b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15784c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f15785d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f15786e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final EditText f15787f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f15788g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ConstraintLayout f15789h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f15790j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ConstraintLayout f15791k;

    private l(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout3) {
        this.f15782a = constraintLayout;
        this.f15783b = textView;
        this.f15784c = textView2;
        this.f15785d = textView3;
        this.f15786e = textView4;
        this.f15787f = editText;
        this.f15788g = imageView;
        this.f15789h = constraintLayout2;
        this.f15790j = textView5;
        this.f15791k = constraintLayout3;
    }

    @NonNull
    public static l a(@NonNull View view) {
        int i10 = R.id.bottom_sheet_header;
        TextView textView = (TextView) b.a(view, R.id.bottom_sheet_header);
        if (textView != null) {
            i10 = R.id.bottom_sheet_text;
            TextView textView2 = (TextView) b.a(view, R.id.bottom_sheet_text);
            if (textView2 != null) {
                i10 = R.id.characters_warning_tv;
                TextView textView3 = (TextView) b.a(view, R.id.characters_warning_tv);
                if (textView3 != null) {
                    i10 = R.id.comment_on_like_dialog_cancel;
                    TextView textView4 = (TextView) b.a(view, R.id.comment_on_like_dialog_cancel);
                    if (textView4 != null) {
                        i10 = R.id.comment_on_like_dialog_edittext;
                        EditText editText = (EditText) b.a(view, R.id.comment_on_like_dialog_edittext);
                        if (editText != null) {
                            i10 = R.id.comment_on_like_dialog_image;
                            ImageView imageView = (ImageView) b.a(view, R.id.comment_on_like_dialog_image);
                            if (imageView != null) {
                                i10 = R.id.comment_on_like_dialog_input_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, R.id.comment_on_like_dialog_input_container);
                                if (constraintLayout != null) {
                                    i10 = R.id.comment_on_like_dialog_send_like;
                                    TextView textView5 = (TextView) b.a(view, R.id.comment_on_like_dialog_send_like);
                                    if (textView5 != null) {
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                        return new l(constraintLayout2, textView, textView2, textView3, textView4, editText, imageView, constraintLayout, textView5, constraintLayout2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static l c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_like_with_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15782a;
    }
}
