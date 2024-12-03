package com.coffeemeetsbagel.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import b6.n;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.view.CmbToolbar;
import com.uber.autodispose.p;
import j5.h;
import j5.x;
import lc.f;
import net.bytebuddy.jar.asm.Opcodes;

public class d1 extends n {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public CmbEditText f13635c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CmbTextView f13636d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f13637e;

    /* renamed from: f  reason: collision with root package name */
    private String f13638f;

    /* renamed from: g  reason: collision with root package name */
    private String f13639g;

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            int length = obj.length();
            int i10 = 0;
            if (length > 140) {
                d1.this.f13635c.setText(obj.substring(0, Opcodes.F2L));
                d1.this.f13635c.setSelection(Opcodes.F2L);
            } else {
                i10 = 140 - length;
            }
            d1.this.f13636d.setText(String.valueOf(i10));
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    private static class b extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final int f13641a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13642b;

        /* renamed from: c  reason: collision with root package name */
        private final c f13643c;

        private b(int i10, String str, c cVar) {
            this.f13641a = i10;
            this.f13642b = str;
            this.f13643c = cVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.f13642b);
            int i10 = this.f13641a;
            return f.c(decodeFile, i10, i10);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.f13643c.a(bitmap);
        }
    }

    interface c {
        void a(Bitmap bitmap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0(Bitmap bitmap) {
        this.f13637e.setImageBitmap(bitmap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        M0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(x xVar) throws Exception {
        M0();
    }

    private void M0() {
        Intent intent = new Intent();
        intent.putExtra("caption", H0());
        requireActivity().setResult(-1, intent);
        requireActivity().finish();
    }

    private void N0() {
        CmbToolbar T0 = ((h) requireActivity()).T0();
        if (T0 != null) {
            CmbLinearLayout cmbLinearLayout = (CmbLinearLayout) requireActivity().getLayoutInflater().inflate(R.layout.upload_menu_item, T0, false);
            ((p) cmbLinearLayout.a().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new c1(this));
            T0.C(cmbLinearLayout);
        }
    }

    private boolean O0() {
        return getArguments() != null && getArguments().getBoolean(Extra.USE_2020_DESIGN_LANGUAGE, false);
    }

    public String H0() {
        return this.f13635c.getText().toString();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f13638f = getArguments().getString(Extra.IMAGE_PATH);
            this.f13639g = getArguments().getString("caption");
        }
        if (bundle != null) {
            this.f13639g = bundle.getString("caption");
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        if (O0()) {
            i10 = R.layout.fragment_caption_dls2;
        } else {
            i10 = R.layout.fragment_caption_dls;
        }
        View inflate = layoutInflater.inflate(i10, viewGroup, false);
        CmbEditText cmbEditText = (CmbEditText) inflate.findViewById(R.id.editText_caption);
        this.f13635c = cmbEditText;
        cmbEditText.requestFocus();
        if (!TextUtils.isEmpty(this.f13639g)) {
            this.f13635c.setText(this.f13639g);
        }
        this.f13636d = (CmbTextView) inflate.findViewById(R.id.textView_chars_remaining);
        this.f13635c.addTextChangedListener(new a());
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.length_photo_caption);
        this.f13637e = (ImageView) inflate.findViewById(R.id.imageView_photo_caption);
        new b(dimensionPixelOffset, this.f13638f, new a1(this)).execute(new Void[0]);
        if (O0()) {
            View findViewById = inflate.findViewById(R.id.upload_button);
            if (findViewById != null) {
                findViewById.setOnClickListener(new b1(this));
            }
        } else {
            N0();
        }
        return inflate;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        String obj = this.f13635c.getText().toString();
        this.f13639g = obj;
        bundle.putString("caption", obj);
        super.onSaveInstanceState(bundle);
    }
}
