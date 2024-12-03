package f5;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.fragments.FragmentMyProfileDetails;
import com.coffeemeetsbagel.products.my_answers.presentation.g;
import f8.n;

public class h extends x {

    /* renamed from: h  reason: collision with root package name */
    private final String[] f14750h;

    /* renamed from: i  reason: collision with root package name */
    private FragmentMyProfileDetails f14751i = new FragmentMyProfileDetails();

    /* renamed from: j  reason: collision with root package name */
    private Fragment f14752j = new n();

    /* renamed from: k  reason: collision with root package name */
    private boolean f14753k;

    public h(Context context, FragmentManager fragmentManager, boolean z10) {
        super(fragmentManager);
        this.f14750h = new String[]{context.getString(R.string.prompt_prompts), context.getString(R.string.photos), context.getString(R.string.details)};
        this.f14753k = z10;
    }

    public int e() {
        if (this.f14753k) {
            return 2;
        }
        return this.f14750h.length;
    }

    public CharSequence g(int i10) {
        return this.f14750h[i10];
    }

    public Fragment u(int i10) {
        if (i10 == 0) {
            return new g();
        }
        if (i10 == 1) {
            return this.f14752j;
        }
        if (i10 != 2) {
            return new Fragment();
        }
        return this.f14751i;
    }

    public FragmentMyProfileDetails x() {
        return this.f14751i;
    }
}
