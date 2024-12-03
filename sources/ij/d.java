package ij;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;

public class d implements c {
    @NonNull
    private static Uri b(@NonNull String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getScheme())) {
            return parse.buildUpon().scheme("https").build();
        }
        return parse;
    }

    public void a(@NonNull View view, @NonNull String str) {
        Uri b10 = b(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", b10);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Actvity was not found for the link: '");
            sb2.append(str);
            sb2.append("'");
        }
    }
}
