package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class a0 implements a {
    @NonNull
    public final LinearLayout B;
    @NonNull
    public final ImageView C;
    @NonNull
    public final CmbTextView D;
    @NonNull
    public final LinearLayout E;
    @NonNull
    public final ImageView F;
    @NonNull
    public final CmbTextView G;
    @NonNull
    public final CmbTextView H;
    @NonNull
    public final CmbTextView I;
    @NonNull
    public final LinearLayout J;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f15675a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f15676b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f15677c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15678d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15679e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbButton f15680f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f15681g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f15682h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f15683j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbImageView f15684k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final ImageView f15685l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f15686m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final LinearLayout f15687n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final LinearLayout f15688p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final ImageView f15689q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final CmbTextView f15690t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public final CmbImageView f15691w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public final LinearLayout f15692x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    public final ImageView f15693y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    public final CmbTextView f15694z;

    private a0(@NonNull NestedScrollView nestedScrollView, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbButton cmbButton, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView3, @NonNull CmbImageView cmbImageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbImageView cmbImageView2, @NonNull LinearLayout linearLayout5, @NonNull ImageView imageView4, @NonNull CmbTextView cmbTextView5, @NonNull LinearLayout linearLayout6, @NonNull ImageView imageView5, @NonNull CmbTextView cmbTextView6, @NonNull LinearLayout linearLayout7, @NonNull ImageView imageView6, @NonNull CmbTextView cmbTextView7, @NonNull CmbTextView cmbTextView8, @NonNull CmbTextView cmbTextView9, @NonNull LinearLayout linearLayout8) {
        this.f15675a = nestedScrollView;
        this.f15676b = constraintLayout;
        this.f15677c = constraintLayout2;
        this.f15678d = cmbTextView;
        this.f15679e = cmbTextView2;
        this.f15680f = cmbButton;
        this.f15681g = linearLayout;
        this.f15682h = imageView;
        this.f15683j = cmbTextView3;
        this.f15684k = cmbImageView;
        this.f15685l = imageView2;
        this.f15686m = linearLayout2;
        this.f15687n = linearLayout3;
        this.f15688p = linearLayout4;
        this.f15689q = imageView3;
        this.f15690t = cmbTextView4;
        this.f15691w = cmbImageView2;
        this.f15692x = linearLayout5;
        this.f15693y = imageView4;
        this.f15694z = cmbTextView5;
        this.B = linearLayout6;
        this.C = imageView5;
        this.D = cmbTextView6;
        this.E = linearLayout7;
        this.F = imageView6;
        this.G = cmbTextView7;
        this.H = cmbTextView8;
        this.I = cmbTextView9;
        this.J = linearLayout8;
    }

    @NonNull
    public static a0 a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.avatar_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view2, R.id.avatar_container);
        if (constraintLayout != null) {
            i10 = R.id.boost_card_container;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) b.a(view2, R.id.boost_card_container);
            if (constraintLayout2 != null) {
                i10 = R.id.boost_subtitle;
                CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.boost_subtitle);
                if (cmbTextView != null) {
                    i10 = R.id.boost_title;
                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view2, R.id.boost_title);
                    if (cmbTextView2 != null) {
                        i10 = R.id.button_boost_me;
                        CmbButton cmbButton = (CmbButton) b.a(view2, R.id.button_boost_me);
                        if (cmbButton != null) {
                            i10 = R.id.help_support;
                            LinearLayout linearLayout = (LinearLayout) b.a(view2, R.id.help_support);
                            if (linearLayout != null) {
                                i10 = R.id.help_support_icon;
                                ImageView imageView = (ImageView) b.a(view2, R.id.help_support_icon);
                                if (imageView != null) {
                                    i10 = R.id.help_support_text;
                                    CmbTextView cmbTextView3 = (CmbTextView) b.a(view2, R.id.help_support_text);
                                    if (cmbTextView3 != null) {
                                        i10 = R.id.imageView_avatar;
                                        CmbImageView cmbImageView = (CmbImageView) b.a(view2, R.id.imageView_avatar);
                                        if (cmbImageView != null) {
                                            i10 = R.id.image_view_boost_card;
                                            ImageView imageView2 = (ImageView) b.a(view2, R.id.image_view_boost_card);
                                            if (imageView2 != null) {
                                                i10 = R.id.list_container;
                                                LinearLayout linearLayout2 = (LinearLayout) b.a(view2, R.id.list_container);
                                                if (linearLayout2 != null) {
                                                    i10 = R.id.main_container;
                                                    LinearLayout linearLayout3 = (LinearLayout) b.a(view2, R.id.main_container);
                                                    if (linearLayout3 != null) {
                                                        i10 = R.id.preferences;
                                                        LinearLayout linearLayout4 = (LinearLayout) b.a(view2, R.id.preferences);
                                                        if (linearLayout4 != null) {
                                                            i10 = R.id.preferences_icon;
                                                            ImageView imageView3 = (ImageView) b.a(view2, R.id.preferences_icon);
                                                            if (imageView3 != null) {
                                                                i10 = R.id.preferences_text;
                                                                CmbTextView cmbTextView4 = (CmbTextView) b.a(view2, R.id.preferences_text);
                                                                if (cmbTextView4 != null) {
                                                                    i10 = R.id.profile_me_trailing_painted_door;
                                                                    CmbImageView cmbImageView2 = (CmbImageView) b.a(view2, R.id.profile_me_trailing_painted_door);
                                                                    if (cmbImageView2 != null) {
                                                                        i10 = R.id.profile_tips;
                                                                        LinearLayout linearLayout5 = (LinearLayout) b.a(view2, R.id.profile_tips);
                                                                        if (linearLayout5 != null) {
                                                                            i10 = R.id.profile_tips_icon;
                                                                            ImageView imageView4 = (ImageView) b.a(view2, R.id.profile_tips_icon);
                                                                            if (imageView4 != null) {
                                                                                i10 = R.id.profile_tips_text;
                                                                                CmbTextView cmbTextView5 = (CmbTextView) b.a(view2, R.id.profile_tips_text);
                                                                                if (cmbTextView5 != null) {
                                                                                    i10 = R.id.safety;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) b.a(view2, R.id.safety);
                                                                                    if (linearLayout6 != null) {
                                                                                        i10 = R.id.safety_icon;
                                                                                        ImageView imageView5 = (ImageView) b.a(view2, R.id.safety_icon);
                                                                                        if (imageView5 != null) {
                                                                                            i10 = R.id.safety_text;
                                                                                            CmbTextView cmbTextView6 = (CmbTextView) b.a(view2, R.id.safety_text);
                                                                                            if (cmbTextView6 != null) {
                                                                                                i10 = R.id.settings;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) b.a(view2, R.id.settings);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i10 = R.id.settings_icon;
                                                                                                    ImageView imageView6 = (ImageView) b.a(view2, R.id.settings_icon);
                                                                                                    if (imageView6 != null) {
                                                                                                        i10 = R.id.settings_text;
                                                                                                        CmbTextView cmbTextView7 = (CmbTextView) b.a(view2, R.id.settings_text);
                                                                                                        if (cmbTextView7 != null) {
                                                                                                            i10 = R.id.textView_name;
                                                                                                            CmbTextView cmbTextView8 = (CmbTextView) b.a(view2, R.id.textView_name);
                                                                                                            if (cmbTextView8 != null) {
                                                                                                                i10 = R.id.textView_viewProfile;
                                                                                                                CmbTextView cmbTextView9 = (CmbTextView) b.a(view2, R.id.textView_viewProfile);
                                                                                                                if (cmbTextView9 != null) {
                                                                                                                    i10 = R.id.whats_new;
                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) b.a(view2, R.id.whats_new);
                                                                                                                    if (linearLayout8 != null) {
                                                                                                                        return new a0((NestedScrollView) view2, constraintLayout, constraintLayout2, cmbTextView, cmbTextView2, cmbButton, linearLayout, imageView, cmbTextView3, cmbImageView, imageView2, linearLayout2, linearLayout3, linearLayout4, imageView3, cmbTextView4, cmbImageView2, linearLayout5, imageView4, cmbTextView5, linearLayout6, imageView5, cmbTextView6, linearLayout7, imageView6, cmbTextView7, cmbTextView8, cmbTextView9, linearLayout8);
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
    public static a0 c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.me_comp, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public NestedScrollView getRoot() {
        return this.f15675a;
    }
}
