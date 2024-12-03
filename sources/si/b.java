package si;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Guideline;
import com.withpersona.sdk2.inquiry.selfie.i;
import com.withpersona.sdk2.inquiry.selfie.j;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f33817a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Guideline f33818b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f33819c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ThemeableLottieAnimationView f33820d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Guideline f33821e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Pi2NavigationBar f33822f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final Guideline f33823g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Button f33824h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f33825j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f33826k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f33827l;

    private b(@NonNull ScrollView scrollView, @NonNull Guideline guideline, @NonNull ImageView imageView, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull Guideline guideline2, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull Guideline guideline3, @NonNull Button button, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f33817a = scrollView;
        this.f33818b = guideline;
        this.f33819c = imageView;
        this.f33820d = themeableLottieAnimationView;
        this.f33821e = guideline2;
        this.f33822f = pi2NavigationBar;
        this.f33823g = guideline3;
        this.f33824h = button;
        this.f33825j = textView;
        this.f33826k = textView2;
        this.f33827l = textView3;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = i.bottom_guideline;
        Guideline guideline = (Guideline) z1.b.a(view, i10);
        if (guideline != null) {
            i10 = i.imageview_selfie_header_image;
            ImageView imageView = (ImageView) z1.b.a(view, i10);
            if (imageView != null) {
                i10 = i.instruction_animation;
                ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) z1.b.a(view, i10);
                if (themeableLottieAnimationView != null) {
                    i10 = i.left_guideline;
                    Guideline guideline2 = (Guideline) z1.b.a(view, i10);
                    if (guideline2 != null) {
                        i10 = i.navigation_bar;
                        Pi2NavigationBar pi2NavigationBar = (Pi2NavigationBar) z1.b.a(view, i10);
                        if (pi2NavigationBar != null) {
                            i10 = i.right_guideline;
                            Guideline guideline3 = (Guideline) z1.b.a(view, i10);
                            if (guideline3 != null) {
                                i10 = i.start_button;
                                Button button = (Button) z1.b.a(view, i10);
                                if (button != null) {
                                    i10 = i.textview_selfie_disclosure;
                                    TextView textView = (TextView) z1.b.a(view, i10);
                                    if (textView != null) {
                                        i10 = i.textview_selfie_start_body;
                                        TextView textView2 = (TextView) z1.b.a(view, i10);
                                        if (textView2 != null) {
                                            i10 = i.textview_selfie_start_title;
                                            TextView textView3 = (TextView) z1.b.a(view, i10);
                                            if (textView3 != null) {
                                                return new b((ScrollView) view, guideline, imageView, themeableLottieAnimationView, guideline2, pi2NavigationBar, guideline3, button, textView, textView2, textView3);
                                            }
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
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(j.pi2_selfie_instructions, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f33817a;
    }
}
