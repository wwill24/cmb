package k6;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.coffeemeetsbagel.R;

public class n extends m {

    /* renamed from: k0  reason: collision with root package name */
    private static final ViewDataBinding.i f15800k0;

    /* renamed from: l0  reason: collision with root package name */
    private static final SparseIntArray f15801l0;
    @NonNull

    /* renamed from: i0  reason: collision with root package name */
    private final LinearLayout f15802i0;

    /* renamed from: j0  reason: collision with root package name */
    private long f15803j0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(32);
        f15800k0 = iVar;
        iVar.a(1, new String[]{"fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_edit_text_dls", "fragment_my_profile_details_edit_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_edit_text_dls", "fragment_my_profile_details_text_dls", "fragment_my_profile_details_text_dls"}, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, new int[]{R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_edit_text_dls, R.layout.fragment_my_profile_details_edit_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_edit_text_dls, R.layout.fragment_my_profile_details_text_dls, R.layout.fragment_my_profile_details_text_dls});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15801l0 = sparseIntArray;
        sparseIntArray.put(R.id.autocomplete_anchor_school1, 17);
        sparseIntArray.put(R.id.edit_profile_field_school0, 18);
        sparseIntArray.put(R.id.schools_autocomplete_loading_indicator1, 19);
        sparseIntArray.put(R.id.autocomplete_anchor_school2, 20);
        sparseIntArray.put(R.id.edit_profile_field_school1, 21);
        sparseIntArray.put(R.id.schools_autocomplete_loading_indicator2, 22);
        sparseIntArray.put(R.id.core_profile_data_questions, 23);
        sparseIntArray.put(R.id.profile_edit_custom_question_container, 24);
        sparseIntArray.put(R.id.edit_profile_field_name, 25);
        sparseIntArray.put(R.id.edit_profile_field_email, 26);
        sparseIntArray.put(R.id.tell_us_something_about_yourself, 27);
        sparseIntArray.put(R.id.editText_icebreaker0, 28);
        sparseIntArray.put(R.id.editText_icebreaker1, 29);
        sparseIntArray.put(R.id.editText_icebreaker2, 30);
        sparseIntArray.put(R.id.fragment_my_profile_details_disclaimer_textview, 31);
    }

    public n(f fVar, @NonNull View view) {
        this(fVar, view, ViewDataBinding.w(fVar, view, 32, f15800k0, f15801l0));
    }

    /* access modifiers changed from: protected */
    public void i() {
        long j10;
        synchronized (this) {
            j10 = this.f15803j0;
            this.f15803j0 = 0;
        }
        if ((j10 & 32768) != 0) {
            this.O.G(getRoot().getResources().getString(R.string.label_age));
            this.Q.G(getRoot().getResources().getString(R.string.label_dating_style));
            this.R.G(getRoot().getResources().getString(R.string.label_degree));
            this.S.G(getRoot().getResources().getString(R.string.label_degree));
            this.T.G(getRoot().getResources().getString(R.string.label_employer));
            this.U.G(getRoot().getResources().getString(R.string.label_ethnicity));
            this.V.G(getRoot().getResources().getString(R.string.label_height));
            this.W.G(getRoot().getResources().getString(R.string.label_hometown));
            this.X.G(getRoot().getResources().getString(R.string.label_interests));
            this.Y.G(getRoot().getResources().getString(R.string.label_languages));
            this.Z.G(getRoot().getResources().getString(R.string.label_current_city));
            this.f15792a0.G(getRoot().getResources().getString(R.string.label_occupation));
            this.f15793b0.G(getRoot().getResources().getString(R.string.label_personality));
            this.f15794c0.G(getRoot().getResources().getString(R.string.label_religion));
            this.f15795d0.G(getRoot().getResources().getString(R.string.label_values));
        }
        ViewDataBinding.k(this.O);
        ViewDataBinding.k(this.Z);
        ViewDataBinding.k(this.U);
        ViewDataBinding.k(this.V);
        ViewDataBinding.k(this.f15794c0);
        ViewDataBinding.k(this.f15792a0);
        ViewDataBinding.k(this.T);
        ViewDataBinding.k(this.R);
        ViewDataBinding.k(this.S);
        ViewDataBinding.k(this.f15793b0);
        ViewDataBinding.k(this.f15795d0);
        ViewDataBinding.k(this.X);
        ViewDataBinding.k(this.W);
        ViewDataBinding.k(this.Y);
        ViewDataBinding.k(this.Q);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.Z.p() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r4.U.p() == false) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (r4.V.p() == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        if (r4.f15794c0.p() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if (r4.f15792a0.p() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r4.T.p() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r4.R.p() == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r4.S.p() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        if (r4.f15793b0.p() == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0066, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006d, code lost:
        if (r4.f15795d0.p() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0076, code lost:
        if (r4.X.p() == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0078, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007f, code lost:
        if (r4.W.p() == false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r4.Y.p() == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0091, code lost:
        if (r4.Q.p() == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0093, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0094, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.O.p() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean p() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.f15803j0     // Catch:{ all -> 0x0096 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0096 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0096 }
            k6.q r0 = r4.O
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            k6.q r0 = r4.Z
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            k6.q r0 = r4.U
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0028
            return r1
        L_0x0028:
            k6.q r0 = r4.V
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0031
            return r1
        L_0x0031:
            k6.q r0 = r4.f15794c0
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x003a
            return r1
        L_0x003a:
            k6.o r0 = r4.f15792a0
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0043
            return r1
        L_0x0043:
            k6.o r0 = r4.T
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x004c
            return r1
        L_0x004c:
            k6.q r0 = r4.R
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0055
            return r1
        L_0x0055:
            k6.q r0 = r4.S
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x005e
            return r1
        L_0x005e:
            k6.q r0 = r4.f15793b0
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0067
            return r1
        L_0x0067:
            k6.q r0 = r4.f15795d0
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0070
            return r1
        L_0x0070:
            k6.q r0 = r4.X
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0079
            return r1
        L_0x0079:
            k6.o r0 = r4.W
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0082
            return r1
        L_0x0082:
            k6.q r0 = r4.Y
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x008b
            return r1
        L_0x008b:
            k6.q r0 = r4.Q
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0094
            return r1
        L_0x0094:
            r0 = 0
            return r0
        L_0x0096:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0096 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.n.p():boolean");
    }

    public void r() {
        synchronized (this) {
            this.f15803j0 = 32768;
        }
        this.O.r();
        this.Z.r();
        this.U.r();
        this.V.r();
        this.f15794c0.r();
        this.f15792a0.r();
        this.T.r();
        this.R.r();
        this.S.r();
        this.f15793b0.r();
        this.f15795d0.r();
        this.X.r();
        this.W.r();
        this.Y.r();
        this.Q.r();
        A();
    }

    private n(f fVar, View view, Object[] objArr) {
        super(fVar, view, 15, objArr[17], objArr[20], objArr[23], objArr[26], objArr[25], objArr[18], objArr[21], objArr[28], objArr[29], objArr[30], objArr[31], objArr[2], objArr[24], objArr[16], objArr[9], objArr[10], objArr[8], objArr[4], objArr[5], objArr[14], objArr[13], objArr[15], objArr[3], objArr[7], objArr[11], objArr[6], objArr[12], objArr[19], objArr[22], objArr[0], objArr[27]);
        this.f15803j0 = -1;
        LinearLayout linearLayout = objArr[1];
        this.f15802i0 = linearLayout;
        linearLayout.setTag((Object) null);
        B(this.O);
        B(this.Q);
        B(this.R);
        B(this.S);
        B(this.T);
        B(this.U);
        B(this.V);
        B(this.W);
        B(this.X);
        B(this.Y);
        B(this.Z);
        B(this.f15792a0);
        B(this.f15793b0);
        B(this.f15794c0);
        B(this.f15795d0);
        this.f15798g0.setTag((Object) null);
        D(view);
        r();
    }
}
