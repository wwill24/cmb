package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SensitiveUserDataUtils {
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    private SensitiveUserDataUtils() {
    }

    private final boolean isCreditCard(TextView textView) {
        int i10;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String f10 = new Regex("\\s").f(ViewHierarchy.getTextOfView(textView), "");
            int length = f10.length();
            if (length < 12) {
                return false;
            }
            if (length > 19) {
                return false;
            }
            int i11 = length - 1;
            if (i11 >= 0) {
                boolean z10 = false;
                i10 = 0;
                while (true) {
                    int i12 = i11 - 1;
                    char charAt = f10.charAt(i11);
                    if (!Character.isDigit(charAt)) {
                        return false;
                    }
                    int d10 = c.d(charAt);
                    if (z10 && (d10 = d10 * 2) > 9) {
                        d10 = (d10 % 10) + 1;
                    }
                    i10 += d10;
                    z10 = !z10;
                    if (i12 < 0) {
                        break;
                    }
                    i11 = i12;
                }
            } else {
                i10 = 0;
            }
            if (i10 % 10 == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isEmail(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean z10 = true;
            if (textView.getInputType() == 32) {
                return true;
            }
            String textOfView = ViewHierarchy.getTextOfView(textView);
            if (textOfView == null) {
                return false;
            }
            if (textOfView.length() != 0) {
                z10 = false;
            }
            if (z10) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isPassword(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isPersonName(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 96) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isPhoneNumber(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 3) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isPostalAddress(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 112) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    public static final boolean isSensitiveUserData(View view) {
        Class<SensitiveUserDataUtils> cls = SensitiveUserDataUtils.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            SensitiveUserDataUtils sensitiveUserDataUtils = INSTANCE;
            if (sensitiveUserDataUtils.isPassword((TextView) view) || sensitiveUserDataUtils.isCreditCard((TextView) view) || sensitiveUserDataUtils.isPersonName((TextView) view) || sensitiveUserDataUtils.isPostalAddress((TextView) view) || sensitiveUserDataUtils.isPhoneNumber((TextView) view) || sensitiveUserDataUtils.isEmail((TextView) view)) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }
}
