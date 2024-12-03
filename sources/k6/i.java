package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbRecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.discoverV2.empty.DiscoverFeedEmptyView;
import com.coffeemeetsbagel.discoverV2.filters.DiscoverFeedFiltersView;
import com.coffeemeetsbagel.discoverV2.list.DiscoverFeedListView;
import z1.a;
import z1.b;

public final class i implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f15751a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15752b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15753c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15754d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f15755e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DiscoverFeedFiltersView f15756f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final DiscoverFeedListView f15757g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f15758h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final View f15759j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ImageView f15760k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f15761l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final ImageView f15762m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final CmbTextView f15763n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final DiscoverFeedEmptyView f15764p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final CmbRecyclerView f15765q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final kc.a f15766t;

    private i(@NonNull RelativeLayout relativeLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull ImageView imageView, @NonNull DiscoverFeedFiltersView discoverFeedFiltersView, @NonNull DiscoverFeedListView discoverFeedListView, @NonNull CmbTextView cmbTextView4, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull CmbTextView cmbTextView5, @NonNull DiscoverFeedEmptyView discoverFeedEmptyView, @NonNull CmbRecyclerView cmbRecyclerView, @NonNull kc.a aVar) {
        this.f15751a = relativeLayout;
        this.f15752b = cmbTextView;
        this.f15753c = cmbTextView2;
        this.f15754d = cmbTextView3;
        this.f15755e = imageView;
        this.f15756f = discoverFeedFiltersView;
        this.f15757g = discoverFeedListView;
        this.f15758h = cmbTextView4;
        this.f15759j = view;
        this.f15760k = imageView2;
        this.f15761l = textView;
        this.f15762m = imageView3;
        this.f15763n = cmbTextView5;
        this.f15764p = discoverFeedEmptyView;
        this.f15765q = cmbRecyclerView;
        this.f15766t = aVar;
    }

    @NonNull
    public static i a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.discover_empty_button;
        CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.discover_empty_button);
        if (cmbTextView != null) {
            i10 = R.id.discover_empty_description;
            CmbTextView cmbTextView2 = (CmbTextView) b.a(view2, R.id.discover_empty_description);
            if (cmbTextView2 != null) {
                i10 = R.id.discover_empty_heading;
                CmbTextView cmbTextView3 = (CmbTextView) b.a(view2, R.id.discover_empty_heading);
                if (cmbTextView3 != null) {
                    i10 = R.id.discover_empty_icon;
                    ImageView imageView = (ImageView) b.a(view2, R.id.discover_empty_icon);
                    if (imageView != null) {
                        i10 = R.id.discover_filters;
                        DiscoverFeedFiltersView discoverFeedFiltersView = (DiscoverFeedFiltersView) b.a(view2, R.id.discover_filters);
                        if (discoverFeedFiltersView != null) {
                            i10 = R.id.discover_list_view;
                            DiscoverFeedListView discoverFeedListView = (DiscoverFeedListView) b.a(view2, R.id.discover_list_view);
                            if (discoverFeedListView != null) {
                                i10 = R.id.discover_reset_search;
                                CmbTextView cmbTextView4 = (CmbTextView) b.a(view2, R.id.discover_reset_search);
                                if (cmbTextView4 != null) {
                                    i10 = R.id.discover_search_divider;
                                    View a10 = b.a(view2, R.id.discover_search_divider);
                                    if (a10 != null) {
                                        i10 = R.id.discover_search_icon;
                                        ImageView imageView2 = (ImageView) b.a(view2, R.id.discover_search_icon);
                                        if (imageView2 != null) {
                                            i10 = R.id.discover_search_text;
                                            TextView textView = (TextView) b.a(view2, R.id.discover_search_text);
                                            if (textView != null) {
                                                i10 = R.id.flower;
                                                ImageView imageView3 = (ImageView) b.a(view2, R.id.flower);
                                                if (imageView3 != null) {
                                                    i10 = R.id.flower_count;
                                                    CmbTextView cmbTextView5 = (CmbTextView) b.a(view2, R.id.flower_count);
                                                    if (cmbTextView5 != null) {
                                                        i10 = R.id.give_take_no_items;
                                                        DiscoverFeedEmptyView discoverFeedEmptyView = (DiscoverFeedEmptyView) b.a(view2, R.id.give_take_no_items);
                                                        if (discoverFeedEmptyView != null) {
                                                            i10 = R.id.recycler_view;
                                                            CmbRecyclerView cmbRecyclerView = (CmbRecyclerView) b.a(view2, R.id.recycler_view);
                                                            if (cmbRecyclerView != null) {
                                                                i10 = R.id.upsell_banner;
                                                                View a11 = b.a(view2, R.id.upsell_banner);
                                                                if (a11 != null) {
                                                                    return new i((RelativeLayout) view2, cmbTextView, cmbTextView2, cmbTextView3, imageView, discoverFeedFiltersView, discoverFeedListView, cmbTextView4, a10, imageView2, textView, imageView3, cmbTextView5, discoverFeedEmptyView, cmbRecyclerView, kc.a.a(a11));
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
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.discover_tab_view, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f15751a;
    }
}
