package lc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.f;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.enums.Icon;
import java.lang.reflect.Field;
import z9.k;

public class c {

    class a implements k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f41100a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f41101b;

        a(EditText editText, Activity activity) {
            this.f41100a = editText;
            this.f41101b = activity;
        }

        public void a(EditText editText) {
            this.f41100a.setText("");
            this.f41100a.requestFocus();
            c.e(this.f41101b);
        }
    }

    class b implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f41102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f41103b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f41104c;

        b(int i10, EditText editText, k kVar) {
            this.f41102a = i10;
            this.f41103b = editText;
            this.f41104c = kVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText;
            if (motionEvent.getAction() != 1 || this.f41102a != 2 || (editText = this.f41103b) == null || editText.getCompoundDrawables().length <= 2 || this.f41103b.getCompoundDrawables()[2] == null || motionEvent.getRawX() < ((float) (this.f41103b.getRight() - this.f41103b.getCompoundDrawables()[2].getBounds().width()))) {
                return false;
            }
            this.f41104c.a(this.f41103b);
            return true;
        }
    }

    public static void a(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    public static void b(Context context, CmbTextView cmbTextView) {
        cmbTextView.setBackgroundColor(androidx.core.content.a.getColor(context, R.color.transparent));
        cmbTextView.setTextColor(androidx.core.content.a.getColor(context, R.color.light_gray));
    }

    public static Bitmap c(Context context, int i10) {
        f b10 = f.b(context.getResources(), i10, (Resources.Theme) null);
        Bitmap createBitmap = Bitmap.createBitmap(b10.getIntrinsicWidth(), b10.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        b10.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        b10.draw(canvas);
        return createBitmap;
    }

    public static int d() {
        Display defaultDisplay = ((WindowManager) Bakery.w().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static void e(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (inputMethodManager != null && currentFocus != null) {
            inputMethodManager.showSoftInput(currentFocus, 1);
        }
    }

    public static void f(Activity activity, EditText editText) {
        ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(editText, 1);
    }

    public static void g(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    public static boolean h(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        try {
            dialog.dismiss();
            return true;
        } catch (IllegalArgumentException e10) {
            fa.a.i(e10);
            return true;
        }
    }

    public static boolean i(Dialog... dialogArr) {
        boolean z10 = true;
        for (Dialog h10 : dialogArr) {
            if (!h(h10) || !z10) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        return z10;
    }

    public static void j(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    public static void k(Context context, CmbTextView cmbTextView) {
        cmbTextView.setBackground(androidx.core.content.a.getDrawable(context, R.drawable.rounded_solid_main_radius_12));
        cmbTextView.setTextColor(androidx.core.content.a.getColor(context, R.color.white));
    }

    public static void l(int i10, ImageView imageView) {
        imageView.setBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public static void m(NumberPicker numberPicker, int i10) {
        Field[] declaredFields = NumberPicker.class.getDeclaredFields();
        int length = declaredFields.length;
        int i11 = 0;
        while (i11 < length) {
            Field field = declaredFields[i11];
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, new ColorDrawable(i10));
                    return;
                } catch (IllegalArgumentException e10) {
                    e10.printStackTrace();
                    return;
                } catch (Resources.NotFoundException e11) {
                    e11.printStackTrace();
                    return;
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                    return;
                }
            } else {
                i11++;
            }
        }
    }

    public static void n(EditText editText, int i10, k kVar) {
        editText.setOnTouchListener(new b(i10, editText, kVar));
    }

    public static void o(TextView textView, Icon icon) {
        p(textView, icon.getUtfCode());
    }

    public static void p(TextView textView, String str) {
        if (textView != null) {
            textView.setTypeface(Typeface.createFromAsset(Bakery.w().getAssets(), "fonts/CMB.ttf"));
            textView.setText(str);
        }
    }

    public static void q(Activity activity, EditText editText) {
        n(editText, 2, new a(editText, activity));
    }
}
