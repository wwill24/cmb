package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.withpersona.sdk2.inquiry.governmentid.l0;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import z1.a;
import z1.b;

public final class f implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f31987a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31988b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f31989c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f31990d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f31991e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f31992f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CardView f31993g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Pi2NavigationBar f31994h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f31995j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final Button f31996k;

    private f(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull Button button, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull CardView cardView, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull TextView textView3, @NonNull Button button2) {
        this.f31987a = scrollView;
        this.f31988b = textView;
        this.f31989c = button;
        this.f31990d = imageView;
        this.f31991e = textView2;
        this.f31992f = imageView2;
        this.f31993g = cardView;
        this.f31994h = pi2NavigationBar;
        this.f31995j = textView3;
        this.f31996k = button2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i10 = l0.body;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = l0.choose_new_photo_button;
            Button button = (Button) b.a(view, i10);
            if (button != null) {
                i10 = l0.file_icon;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = l0.file_name_textview;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        i10 = l0.image_view;
                        ImageView imageView2 = (ImageView) b.a(view, i10);
                        if (imageView2 != null) {
                            i10 = l0.image_view_container;
                            CardView cardView = (CardView) b.a(view, i10);
                            if (cardView != null) {
                                i10 = l0.navigation_bar;
                                Pi2NavigationBar pi2NavigationBar = (Pi2NavigationBar) b.a(view, i10);
                                if (pi2NavigationBar != null) {
                                    i10 = l0.title;
                                    TextView textView3 = (TextView) b.a(view, i10);
                                    if (textView3 != null) {
                                        i10 = l0.use_photo_button;
                                        Button button2 = (Button) b.a(view, i10);
                                        if (button2 != null) {
                                            return new f((ScrollView) view, textView, button, imageView, textView2, imageView2, cardView, pi2NavigationBar, textView3, button2);
                                        }
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
    public static f c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_review_selected_image, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f31987a;
    }
}
