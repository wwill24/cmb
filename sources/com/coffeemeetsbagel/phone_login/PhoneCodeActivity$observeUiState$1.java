package com.coffeemeetsbagel.phone_login;

import android.content.Intent;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.phone_login.PhoneCodeViewModel;
import com.coffeemeetsbagel.phone_login.country_code_picker.CountryCodePickerFragment;
import com.coffeemeetsbagel.phone_login.phone_number_input.PhoneInputFragment;
import com.coffeemeetsbagel.phone_login.verification_code.VerificationCodeFragment;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PhoneCodeActivity$observeUiState$1 extends Lambda implements Function1<PhoneCodeViewModel.ViewState, Unit> {
    final /* synthetic */ PhoneCodeActivity this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35651a;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState[] r0 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.PHONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.CODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.COUNTRY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.MAINTENANCE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.AUTHENTICATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.AUTH_FAILED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.coffeemeetsbagel.phone_login.PhoneCodeViewModel$ViewState r1 = com.coffeemeetsbagel.phone_login.PhoneCodeViewModel.ViewState.BANNED     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                f35651a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.phone_login.PhoneCodeActivity$observeUiState$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneCodeActivity$observeUiState$1(PhoneCodeActivity phoneCodeActivity) {
        super(1);
        this.this$0 = phoneCodeActivity;
    }

    public final void a(PhoneCodeViewModel.ViewState viewState) {
        int i10;
        a.C0491a aVar = fa.a.f40771d;
        String C0 = this.this$0.f35649g;
        aVar.a(C0, "observeUiState: " + viewState);
        if (viewState == null) {
            i10 = -1;
        } else {
            i10 = a.f35651a[viewState.ordinal()];
        }
        switch (i10) {
            case 1:
                this.this$0.G0().u();
                this.this$0.K0(new PhoneInputFragment());
                return;
            case 2:
                this.this$0.K0(new VerificationCodeFragment());
                return;
            case 3:
                this.this$0.K0(new CountryCodePickerFragment());
                return;
            case 4:
                this.this$0.setResult(66);
                this.this$0.finish();
                return;
            case 5:
                this.this$0.F0().start();
                this.this$0.setResult(61);
                this.this$0.finish();
                return;
            case 6:
                this.this$0.setResult(65);
                this.this$0.finish();
                return;
            case 7:
                Intent intent = new Intent();
                CmbErrorCode f10 = this.this$0.G0().j().f();
                if (f10 != null) {
                    intent.putExtra(Extra.BANNED_REASON, f10.getBannedReason().getApiReason());
                    intent.putExtra(Extra.VERIFICATION_STATUS, f10.getVerificationStatus().getApiStatus());
                    intent.putExtra(Extra.VERIFICATION_REFERENCE_ID, f10.getVerificationStatus().getReferenceId());
                }
                this.this$0.setResult(71, intent);
                this.this$0.finish();
                return;
            default:
                return;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((PhoneCodeViewModel.ViewState) obj);
        return Unit.f32013a;
    }
}
