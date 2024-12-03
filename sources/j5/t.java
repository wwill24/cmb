package j5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import b6.d;
import b6.f;
import b6.q;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.uber.autodispose.p;
import sj.a;

public abstract class t<D extends f, R extends q> extends d<D, R> {

    /* renamed from: j  reason: collision with root package name */
    protected CmbToolbar f15624j;

    /* renamed from: k  reason: collision with root package name */
    private Toolbar f15625k;

    /* renamed from: l  reason: collision with root package name */
    private AppBarLayout f15626l;

    /* access modifiers changed from: private */
    public /* synthetic */ void R0(x xVar) throws Exception {
        onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_to_right);
    }

    /* access modifiers changed from: protected */
    public int L0() {
        return R.id.main_content;
    }

    public AppBarLayout O0() {
        return this.f15626l;
    }

    public CmbToolbar P0() {
        return this.f15624j;
    }

    /* access modifiers changed from: protected */
    public abstract int Q0();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.component_activity_with_toolbar);
        this.f15625k = (Toolbar) findViewById(R.id.toolbar);
        this.f15626l = (AppBarLayout) findViewById(R.id.app_bar_layout);
        Toolbar toolbar = this.f15625k;
        if (toolbar != null) {
            toolbar.setTitle((CharSequence) null);
            this.f15625k.removeAllViews();
            CmbToolbar cmbToolbar = (CmbToolbar) LayoutInflater.from(this).inflate(R.layout.cmb_toolbar, this.f15625k, false);
            this.f15624j = cmbToolbar;
            cmbToolbar.setTitle(getString(Q0()));
            this.f15624j.X();
            ((p) this.f15624j.T().a0(a.a()).g(com.uber.autodispose.a.a(this))).c(new s(this));
            this.f15625k.addView(this.f15624j);
            this.f15625k.setPadding(0, 0, 0, 0);
            this.f15625k.J(0, 0);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return false;
        } else if (this.f7849f.i(menuItem)) {
            return true;
        } else {
            return super.onOptionsItemSelected(menuItem);
        }
    }
}
