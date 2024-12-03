package com.coffeemeetsbagel.new_user_experience.carousel;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.a;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.new_user_experience.carousel.CarouselPresenter;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.IllegalFormatException;
import kotlin.jvm.internal.j;

public final class g extends a {

    /* renamed from: c  reason: collision with root package name */
    private final CarouselPresenter.a f34940c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f34941d = new Handler();

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<TextView> f34942e;

    /* renamed from: f  reason: collision with root package name */
    private final int f34943f = 3;

    public g(CarouselPresenter.a aVar) {
        j.g(aVar, "listener");
        this.f34940c = aVar;
    }

    /* access modifiers changed from: private */
    public static final void A(g gVar, View view) {
        j.g(gVar, "this$0");
        gVar.f34940c.L();
        gVar.f34940c.B(2);
    }

    private final Runnable w(int i10) {
        return new f(this, i10);
    }

    /* access modifiers changed from: private */
    public static final void x(g gVar, int i10) {
        TextView textView;
        j.g(gVar, "this$0");
        WeakReference<TextView> weakReference = gVar.f34942e;
        if (weakReference != null && (textView = weakReference.get()) != null) {
            String format2 = new DecimalFormat("#,###,###").format(Integer.valueOf(i10));
            try {
                String str = t9.a.onboardingMatchCounterPart1;
                j.f(str, "onboardingMatchCounterPart1");
                String format3 = String.format(str, Arrays.copyOf(new Object[]{format2}, 1));
                j.f(format3, "format(this, *args)");
                textView.setText(format3);
                gVar.f34941d.postDelayed(gVar.w(i10 + 1), new m().b(t9.a.matchesPerSecond));
            } catch (IllegalFormatException e10) {
                fa.a.f40771d.f(e10);
            }
        }
    }

    private final ViewGroup y(ViewGroup viewGroup, String str, String str2, int i10) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onboarding_carousel_slide, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        TextView textView = (TextView) viewGroup2.findViewById(R.id.message_primary);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.message_secondary);
        if (textView2 != null) {
            textView2.setText(str2);
        }
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.illustration);
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
        return viewGroup2;
    }

    private final ViewGroup z(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onboarding_carousel_slide_end, viewGroup, false);
        j.e(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        TextView textView = (TextView) viewGroup2.findViewById(R.id.message_secondary);
        if (textView != null) {
            textView.setText(t9.a.onboardingMatchCounterPart2);
        }
        this.f34942e = new WeakReference<>(viewGroup2.findViewById(R.id.match_counter));
        this.f34941d.post(w(new m().a(System.currentTimeMillis(), t9.a.lastMatchCountAt, t9.a.matchesPerSecond, t9.a.lastMatchCount)));
        ((CmbButton) viewGroup2.findViewById(R.id.continue_button)).setOnClickListener(new e(this));
        return viewGroup2;
    }

    public void b(ViewGroup viewGroup, int i10, Object obj) {
        j.g(viewGroup, "container");
        j.g(obj, "anyObject");
        viewGroup.removeView((ViewGroup) obj);
        if (i10 == this.f34943f - 1) {
            this.f34941d.removeCallbacksAndMessages((Object) null);
        }
    }

    public int e() {
        return this.f34943f;
    }

    public Object i(ViewGroup viewGroup, int i10) {
        ViewGroup viewGroup2;
        j.g(viewGroup, "container");
        if (i10 == 0) {
            String str = t9.a.onboardingCarouselSlide1Part1;
            j.f(str, "onboardingCarouselSlide1Part1");
            String str2 = t9.a.onboardingCarouselSlide1Part2;
            j.f(str2, "onboardingCarouselSlide1Part2");
            viewGroup2 = y(viewGroup, str, str2, R.drawable.onboarding_matchmaker);
        } else if (i10 == 1) {
            String str3 = t9.a.onboardingCarouselSlide2Part1;
            j.f(str3, "onboardingCarouselSlide2Part1");
            String str4 = t9.a.onboardingCarouselSlide2Part2;
            j.f(str4, "onboardingCarouselSlide2Part2");
            viewGroup2 = y(viewGroup, str3, str4, R.drawable.onboarding_noon);
        } else if (i10 == 2) {
            viewGroup2 = z(viewGroup);
        } else {
            String format2 = String.format("CarouselPager has no item %d.", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
            j.f(format2, "format(this, *args)");
            throw new UnsupportedOperationException(format2);
        }
        viewGroup2.setId(View.generateViewId());
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    public boolean j(View view, Object obj) {
        j.g(view, "view");
        j.g(obj, "anyObject");
        return j.b(view, obj);
    }
}
