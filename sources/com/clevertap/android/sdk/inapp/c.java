package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.p;
import i4.f;
import i4.u;
import i4.v;
import java.net.URLDecoder;
import java.util.HashMap;
import v4.e;

public abstract class c extends b {

    /* renamed from: h  reason: collision with root package name */
    protected w f10392h;

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            c.this.B0((Bundle) null);
        }
    }

    private class b extends WebViewClient {
        b() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String string;
            try {
                Bundle a10 = e.a(str, false);
                if (a10.containsKey("wzrk_c2a") && (string = a10.getString("wzrk_c2a")) != null) {
                    String[] split = string.split("__dl__");
                    if (split.length == 2) {
                        a10.putString("wzrk_c2a", URLDecoder.decode(split[0], "UTF-8"));
                        str = split[1];
                    }
                }
                c.this.A0(a10, (HashMap<String, String>) null);
                p.a("Executing call to action for in-app: " + str);
                c.this.D0(str, a10);
            } catch (Throwable th2) {
                p.r("Error parsing the in-app notification action!", th2);
            }
            return true;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private View U0(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            View inflate = layoutInflater.inflate(v.inapp_html_full, viewGroup, false);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(u.inapp_html_full_relative_layout);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            W0(layoutParams);
            this.f10392h = new w(this.f10383c, this.f10385e.H(), this.f10385e.l(), this.f10385e.I(), this.f10385e.m());
            this.f10392h.setWebViewClient(new b());
            if (this.f10385e.P()) {
                this.f10392h.getSettings().setJavaScriptEnabled(true);
                this.f10392h.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                this.f10392h.getSettings().setAllowContentAccess(false);
                this.f10392h.getSettings().setAllowFileAccess(false);
                this.f10392h.getSettings().setAllowFileAccessFromFileURLs(false);
                this.f10392h.addJavascriptInterface(new f(CleverTapAPI.F(getActivity(), this.f10382b)), "CleverTap");
            }
            if (Y0()) {
                relativeLayout.setBackground(new ColorDrawable(-1157627904));
            } else {
                relativeLayout.setBackground(new ColorDrawable(0));
            }
            relativeLayout.addView(this.f10392h, layoutParams);
            if (X0()) {
                this.f10381a = new CloseImageView(this.f10383c);
                RelativeLayout.LayoutParams V0 = V0();
                this.f10381a.setOnClickListener(new a());
                relativeLayout.addView(this.f10381a, V0);
            }
            return inflate;
        } catch (Throwable th2) {
            this.f10382b.n().u(this.f10382b.e(), "Fragment view not created", th2);
            return null;
        }
    }

    private void W0(RelativeLayout.LayoutParams layoutParams) {
        char z10 = this.f10385e.z();
        if (z10 == 'b') {
            layoutParams.addRule(12);
        } else if (z10 == 'c') {
            layoutParams.addRule(13);
        } else if (z10 == 'l') {
            layoutParams.addRule(9);
        } else if (z10 == 'r') {
            layoutParams.addRule(11);
        } else if (z10 == 't') {
            layoutParams.addRule(10);
        }
        layoutParams.setMargins(0, 0, 0, 0);
    }

    private boolean X0() {
        return this.f10385e.T();
    }

    private boolean Y0() {
        return this.f10385e.L();
    }

    private void Z0() {
        this.f10392h.a();
        if (this.f10385e.j().isEmpty()) {
            Point point = this.f10392h.f10460a;
            int i10 = point.y;
            int i11 = point.x;
            float f10 = getResources().getDisplayMetrics().density;
            String replaceFirst = this.f10385e.n().replaceFirst("<head>", "<head>" + ("<style>body{width:" + ((int) (((float) i11) / f10)) + "px; height: " + ((int) (((float) i10) / f10)) + "px; margin: 0; padding:0;}</style>"));
            p.o("Density appears to be " + f10);
            this.f10392h.setInitialScale((int) (f10 * 100.0f));
            this.f10392h.loadDataWithBaseURL((String) null, replaceFirst, "text/html", "utf-8", (String) null);
            return;
        }
        String j10 = this.f10385e.j();
        this.f10392h.setWebViewClient(new WebViewClient());
        this.f10392h.loadUrl(j10);
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams V0() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, this.f10392h.getId());
        layoutParams.addRule(1, this.f10392h.getId());
        int i10 = -(G0(40) / 2);
        layoutParams.setMargins(i10, 0, 0, i10);
        return layoutParams;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Z0();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return U0(layoutInflater, viewGroup);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Z0();
    }
}
