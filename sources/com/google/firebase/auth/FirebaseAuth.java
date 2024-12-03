package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.p003firebaseauthapi.zzadv;
import com.google.android.gms.internal.p003firebaseauthapi.zzadz;
import com.google.android.gms.internal.p003firebaseauthapi.zzaee;
import com.google.android.gms.internal.p003firebaseauthapi.zzaeo;
import com.google.android.gms.internal.p003firebaseauthapi.zzafn;
import com.google.android.gms.internal.p003firebaseauthapi.zzafx;
import com.google.android.gms.internal.p003firebaseauthapi.zzahb;
import com.google.android.gms.internal.p003firebaseauthapi.zzahl;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbr;
import com.google.firebase.auth.internal.zzbt;
import com.google.firebase.auth.internal.zzbv;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzbz;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public abstract class FirebaseAuth implements InternalAuthProvider {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public final FirebaseApp zzb;
    /* access modifiers changed from: private */
    public final List zzc = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zzd = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final List zze = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public final zzadv zzf;
    /* access modifiers changed from: private */
    public FirebaseUser zzg;
    /* access modifiers changed from: private */
    public final zzw zzh;
    private final Object zzi = new Object();
    /* access modifiers changed from: private */
    public String zzj;
    private final Object zzk = new Object();
    /* access modifiers changed from: private */
    public String zzl;
    private zzbr zzm;
    private final RecaptchaAction zzn = RecaptchaAction.custom("getOobCode");
    private final RecaptchaAction zzo = RecaptchaAction.custom("signInWithPassword");
    private final RecaptchaAction zzp = RecaptchaAction.custom("signUpPassword");
    private final zzbt zzq;
    private final zzbz zzr;
    private final zzf zzs;
    private final Provider zzt;
    private final Provider zzu;
    private zzbv zzv;
    private final Executor zzw;
    private final Executor zzx;
    private final Executor zzy;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(@NonNull FirebaseApp firebaseApp, @NonNull Provider provider, @NonNull Provider provider2, @Background @NonNull Executor executor, @NonNull @Blocking Executor executor2, @Lightweight @NonNull Executor executor3, @Lightweight @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull @UiThread Executor executor4) {
        zzahb zzb2;
        zzadv zzadv = new zzadv(firebaseApp, executor2, scheduledExecutorService);
        zzbt zzbt = new zzbt(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbz zzc2 = zzbz.zzc();
        zzf zzb3 = zzf.zzb();
        this.zzb = (FirebaseApp) p.k(firebaseApp);
        this.zzf = (zzadv) p.k(zzadv);
        zzbt zzbt2 = (zzbt) p.k(zzbt);
        this.zzq = zzbt2;
        this.zzh = new zzw();
        zzbz zzbz = (zzbz) p.k(zzc2);
        this.zzr = zzbz;
        this.zzs = (zzf) p.k(zzb3);
        this.zzt = provider;
        this.zzu = provider2;
        this.zzw = executor2;
        this.zzx = executor3;
        this.zzy = executor4;
        FirebaseUser zza2 = zzbt2.zza();
        this.zzg = zza2;
        if (!(zza2 == null || (zzb2 = zzbt2.zzb(zza2)) == null)) {
            zzT(this, this.zzg, zzb2, false, false);
        }
        zzbz.zze(this);
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    public static zzbv zzD(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.zzv == null) {
            firebaseAuth.zzv = new zzbv((FirebaseApp) p.k(firebaseAuth.zzb));
        }
        return firebaseAuth.zzv;
    }

    public static void zzR(@NonNull FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Notifying auth state listeners about user ( ");
            sb2.append(uid);
            sb2.append(" ).");
        }
        firebaseAuth.zzy.execute(new zzw(firebaseAuth));
    }

    public static void zzS(@NonNull FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Notifying id token listeners about user ( ");
            sb2.append(uid);
            sb2.append(" ).");
        }
        if (firebaseUser != null) {
            str = firebaseUser.zze();
        } else {
            str = null;
        }
        firebaseAuth.zzy.execute(new zzv(firebaseAuth, new InternalTokenResult(str)));
    }

    static void zzT(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzahb zzahb, boolean z10, boolean z11) {
        boolean z12;
        boolean z13;
        p.k(firebaseUser);
        p.k(zzahb);
        boolean z14 = false;
        boolean z15 = true;
        if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.zzg.getUid())) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12 || !z11) {
            FirebaseUser firebaseUser2 = firebaseAuth.zzg;
            if (firebaseUser2 == null) {
                z13 = true;
            } else {
                boolean z16 = !firebaseUser2.zzd().zze().equals(zzahb.zze());
                if (!z12 || z16) {
                    z14 = true;
                }
                z13 = true ^ z12;
                z15 = z14;
            }
            p.k(firebaseUser);
            if (firebaseAuth.zzg == null || !firebaseUser.getUid().equals(firebaseAuth.getUid())) {
                firebaseAuth.zzg = firebaseUser;
            } else {
                firebaseAuth.zzg.zzc(firebaseUser.getProviderData());
                if (!firebaseUser.isAnonymous()) {
                    firebaseAuth.zzg.zzb();
                }
                firebaseAuth.zzg.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
            }
            if (z10) {
                firebaseAuth.zzq.zzd(firebaseAuth.zzg);
            }
            if (z15) {
                FirebaseUser firebaseUser3 = firebaseAuth.zzg;
                if (firebaseUser3 != null) {
                    firebaseUser3.zzh(zzahb);
                }
                zzS(firebaseAuth, firebaseAuth.zzg);
            }
            if (z13) {
                zzR(firebaseAuth, firebaseAuth.zzg);
            }
            if (z10) {
                firebaseAuth.zzq.zze(firebaseUser, zzahb);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.zzg;
            if (firebaseUser4 != null) {
                zzD(firebaseAuth).zze(firebaseUser4.zzd());
            }
        }
    }

    public static final void zzX(@NonNull FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException, @NonNull PhoneAuthOptions phoneAuthOptions, @NonNull String str) {
        "Invoking verification failure callback with MissingActivity exception for phone number/uid - ".concat(String.valueOf(str));
        phoneAuthOptions.zzi().execute(new zzi(zzafn.zza(str, phoneAuthOptions.zze(), (zzaez) null), firebaseAuthMissingActivityForRecaptchaException));
    }

    private final Task zzY(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z10) {
        return new zzab(this, z10, firebaseUser, emailAuthCredential).zzb(this, this.zzl, z10 ? this.zzn : this.zzo);
    }

    private final Task zzZ(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z10) {
        return new zzz(this, str, z10, firebaseUser, str2, str3).zzb(this, str3, this.zzo);
    }

    private final Task zzaa(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z10) {
        return new zzaa(this, z10, firebaseUser, emailAuthCredential).zzb(this, this.zzl, this.zzn);
    }

    /* access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzab(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        zzw zzw2 = this.zzh;
        if (!zzw2.zzd() || str == null || !str.equals(zzw2.zza())) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzl(this, onVerificationStateChangedCallbacks);
    }

    private final boolean zzac(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        if (parseLink == null || TextUtils.equals(this.zzl, parseLink.zza())) {
            return false;
        }
        return true;
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zze.add(authStateListener);
        this.zzy.execute(new zzu(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzc.add(idTokenListener);
        this.zzy.execute(new zzs(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        p.g(str);
        return this.zzf.zza(this.zzb, str, this.zzl);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        p.g(str);
        return this.zzf.zzb(this.zzb, str, this.zzl);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        p.g(str);
        p.g(str2);
        return this.zzf.zzc(this.zzb, str, str2, this.zzl);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        p.g(str);
        p.g(str2);
        return new zzn(this, str, str2).zzb(this, this.zzl, this.zzp);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        p.g(str);
        return this.zzf.zzf(this.zzb, str, this.zzl);
    }

    @NonNull
    public final Task getAccessToken(boolean z10) {
        return zzc(this.zzg, z10);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.zzb;
    }

    public FirebaseUser getCurrentUser() {
        return this.zzg;
    }

    @NonNull
    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzh;
    }

    public String getLanguageCode() {
        String str;
        synchronized (this.zzi) {
            str = this.zzj;
        }
        return str;
    }

    public Task<AuthResult> getPendingAuthResult() {
        return this.zzr.zza();
    }

    public String getTenantId() {
        String str;
        synchronized (this.zzk) {
            str = this.zzl;
        }
        return str;
    }

    public final String getUid() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    @NonNull
    public Task<Void> initializeRecaptchaConfig() {
        if (this.zzm == null) {
            this.zzm = new zzbr(this.zzb, this);
        }
        return this.zzm.zzb(this.zzl, Boolean.FALSE).continueWithTask(new zzy(this));
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.zzi(str);
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zze.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzc.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        p.g(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    @NonNull
    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        p.g(str);
        p.k(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzj;
            if (str2 != null) {
                actionCodeSettings.zzf(str2);
            }
            return new zzp(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    @NonNull
    public Task<Void> setFirebaseUIVersion(String str) {
        return this.zzf.zzA(str);
    }

    public void setLanguageCode(@NonNull String str) {
        p.g(str);
        synchronized (this.zzi) {
            this.zzj = str;
        }
    }

    public void setTenantId(@NonNull String str) {
        p.g(str);
        synchronized (this.zzk) {
            this.zzl = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zzf.zzB(this.zzb, new zzac(this), this.zzl);
        }
        zzx zzx2 = (zzx) this.zzg;
        zzx2.zzq(false);
        return Tasks.forResult(new zzr(zzx2));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        p.k(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzg()) {
                return zzZ(emailAuthCredential.zzd(), (String) p.k(emailAuthCredential.zze()), this.zzl, (FirebaseUser) null, false);
            } else if (zzac(p.g(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzadz.zza(new Status(17072)));
            } else {
                return zzaa(emailAuthCredential, (FirebaseUser) null, false);
            }
        } else if (!(zza2 instanceof PhoneAuthCredential)) {
            return this.zzf.zzC(this.zzb, zza2, this.zzl, new zzac(this));
        } else {
            return this.zzf.zzG(this.zzb, (PhoneAuthCredential) zza2, this.zzl, new zzac(this));
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        p.g(str);
        return this.zzf.zzD(this.zzb, str, this.zzl, new zzac(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        p.g(str);
        p.g(str2);
        return zzZ(str, str2, this.zzl, (FirebaseUser) null, false);
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzO();
        zzbv zzbv = this.zzv;
        if (zzbv != null) {
            zzbv.zzc();
        }
    }

    @NonNull
    public Task<AuthResult> startActivityForSignInWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        p.k(federatedAuthProvider);
        p.k(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzadz.zza(new Status(17057)));
        }
        this.zzr.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Void> updateCurrentUser(@NonNull FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.zzl)) || ((str = this.zzl) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzadz.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.zzb.getOptions().getApiKey();
            if (!firebaseUser.zzd().zzj() || !apiKey2.equals(apiKey)) {
                return zzi(firebaseUser, new zzae(this));
            }
            zzQ(zzx.zzk(this.zzb, firebaseUser), firebaseUser.zzd(), true);
            return Tasks.forResult(null);
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    public void useAppLanguage() {
        synchronized (this.zzi) {
            this.zzj = zzaeo.zza();
        }
    }

    public void useEmulator(@NonNull String str, int i10) {
        p.g(str);
        boolean z10 = false;
        if (i10 >= 0 && i10 <= 65535) {
            z10 = true;
        }
        p.b(z10, "Port number must be in the range 0-65535");
        zzafx.zzf(this.zzb, str, i10);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        p.g(str);
        return this.zzf.zzR(this.zzb, str, this.zzl);
    }

    public final synchronized zzbr zzB() {
        return this.zzm;
    }

    public final synchronized zzbv zzC() {
        return zzD(this);
    }

    @NonNull
    public final Provider zzE() {
        return this.zzt;
    }

    @NonNull
    public final Provider zzF() {
        return this.zzu;
    }

    @NonNull
    public final Executor zzL() {
        return this.zzw;
    }

    @NonNull
    public final Executor zzM() {
        return this.zzx;
    }

    @NonNull
    public final Executor zzN() {
        return this.zzy;
    }

    public final void zzO() {
        p.k(this.zzq);
        FirebaseUser firebaseUser = this.zzg;
        if (firebaseUser != null) {
            zzbt zzbt = this.zzq;
            p.k(firebaseUser);
            zzbt.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzg = null;
        }
        this.zzq.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzS(this, (FirebaseUser) null);
        zzR(this, (FirebaseUser) null);
    }

    public final synchronized void zzP(zzbr zzbr) {
        this.zzm = zzbr;
    }

    public final void zzQ(FirebaseUser firebaseUser, zzahb zzahb, boolean z10) {
        zzT(this, firebaseUser, zzahb, true, false);
    }

    public final void zzU(@NonNull PhoneAuthOptions phoneAuthOptions) {
        String str;
        String str2;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth zzb2 = phoneAuthOptions.zzb();
            if (((zzag) p.k(phoneAuthOptions.zzc())).zzf()) {
                str2 = p.g(phoneAuthOptions.zzh());
                str = str2;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) p.k(phoneAuthOptions.zzf());
                String g10 = p.g(phoneMultiFactorInfo.getUid());
                str2 = phoneMultiFactorInfo.getPhoneNumber();
                str = g10;
            }
            if (phoneAuthOptions.zzd() == null || !zzafn.zzd(str, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb2.zzs.zza(zzb2, str2, phoneAuthOptions.zza(), zzb2.zzW(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzk(zzb2, phoneAuthOptions, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb3 = phoneAuthOptions.zzb();
        String g11 = p.g(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() != null || !zzafn.zzd(g11, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            zzb3.zzs.zza(zzb3, g11, phoneAuthOptions.zza(), zzb3.zzW(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzj(zzb3, phoneAuthOptions, g11));
        }
    }

    public final void zzV(@NonNull PhoneAuthOptions phoneAuthOptions, String str, String str2) {
        boolean z10;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue < 0 || longValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String g10 = p.g(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        zzahl zzahl = new zzahl(g10, longValue, z10, this.zzj, this.zzl, str, str2, zzW());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzab = zzab(g10, phoneAuthOptions.zze());
        if (TextUtils.isEmpty(str)) {
            onVerificationStateChangedCallbacks = zzy(phoneAuthOptions, zzab);
        } else {
            onVerificationStateChangedCallbacks = zzab;
        }
        this.zzf.zzT(this.zzb, zzahl, onVerificationStateChangedCallbacks, phoneAuthOptions.zza(), phoneAuthOptions.zzi());
    }

    /* access modifiers changed from: package-private */
    public final boolean zzW() {
        return zzaee.zza(getApp().getApplicationContext());
    }

    @NonNull
    public final Task zza(@NonNull FirebaseUser firebaseUser) {
        p.k(firebaseUser);
        return this.zzf.zze(firebaseUser, new zzr(this, firebaseUser));
    }

    @NonNull
    public final Task zzb(@NonNull FirebaseUser firebaseUser, @NonNull MultiFactorAssertion multiFactorAssertion, String str) {
        p.k(firebaseUser);
        p.k(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzf.zzg(this.zzb, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzac(this));
        } else if (!(multiFactorAssertion instanceof TotpMultiFactorAssertion)) {
            return Tasks.forException(zzadz.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
        } else {
            return this.zzf.zzh(this.zzb, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.zzl, new zzac(this));
        }
    }

    @NonNull
    public final Task zzc(FirebaseUser firebaseUser, boolean z10) {
        if (firebaseUser == null) {
            return Tasks.forException(zzadz.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzahb zzd2 = firebaseUser.zzd();
        if (!zzd2.zzj() || z10) {
            return this.zzf.zzk(this.zzb, firebaseUser, zzd2.zzf(), new zzx(this));
        }
        return Tasks.forResult(zzba.zza(zzd2.zze()));
    }

    @NonNull
    public final Task zzd() {
        return this.zzf.zzl();
    }

    @NonNull
    public final Task zze(@NonNull String str) {
        return this.zzf.zzm(this.zzl, "RECAPTCHA_ENTERPRISE");
    }

    @NonNull
    public final Task zzf(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        p.k(authCredential);
        p.k(firebaseUser);
        return this.zzf.zzn(this.zzb, firebaseUser, authCredential.zza(), new zzad(this));
    }

    @NonNull
    public final Task zzg(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        p.k(firebaseUser);
        p.k(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzY(firebaseUser, emailAuthCredential, false);
            }
            if (zzac(p.g(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzadz.zza(new Status(17072)));
            }
            return zzY(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzu(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzad(this));
        } else {
            return this.zzf.zzo(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    @NonNull
    public final Task zzh(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        p.k(firebaseUser);
        p.k(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return zzZ(emailAuthCredential.zzd(), p.g(emailAuthCredential.zze()), firebaseUser.getTenantId(), firebaseUser, true);
            } else if (zzac(p.g(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzadz.zza(new Status(17072)));
            } else {
                return zzaa(emailAuthCredential, firebaseUser, true);
            }
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.zzf.zzv(this.zzb, firebaseUser, (PhoneAuthCredential) zza2, this.zzl, new zzad(this));
        } else {
            return this.zzf.zzp(this.zzb, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    public final Task zzi(FirebaseUser firebaseUser, zzbx zzbx) {
        p.k(firebaseUser);
        return this.zzf.zzw(this.zzb, firebaseUser, zzbx);
    }

    public final Task zzj(MultiFactorAssertion multiFactorAssertion, zzag zzag, FirebaseUser firebaseUser) {
        p.k(multiFactorAssertion);
        p.k(zzag);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.zzf.zzi(this.zzb, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, p.g(zzag.zze()), new zzac(this));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.zzf.zzj(this.zzb, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, p.g(zzag.zze()), this.zzl, new zzac(this));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    @NonNull
    public final Task zzk(ActionCodeSettings actionCodeSettings, @NonNull String str) {
        p.g(str);
        if (this.zzj != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.zzj);
        }
        return this.zzf.zzx(this.zzb, actionCodeSettings, str);
    }

    @NonNull
    public final Task zzl(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        p.k(activity);
        p.k(federatedAuthProvider);
        p.k(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzadz.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zzm(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        p.k(activity);
        p.k(federatedAuthProvider);
        p.k(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.zzr.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzadz.zza(new Status(17057)));
        }
        this.zzr.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task zzn(zzag zzag) {
        p.k(zzag);
        return this.zzf.zzI(zzag, this.zzl).continueWithTask(new zzt(this));
    }

    @NonNull
    public final Task zzo(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        p.k(firebaseUser);
        p.g(str);
        return this.zzf.zzK(this.zzb, firebaseUser, str, this.zzl, new zzad(this)).continueWithTask(new zzq(this));
    }

    @NonNull
    public final Task zzp(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        p.g(str);
        p.k(firebaseUser);
        return this.zzf.zzL(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzq(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        p.k(firebaseUser);
        p.g(str);
        return this.zzf.zzM(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzr(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        p.k(firebaseUser);
        p.g(str);
        return this.zzf.zzN(this.zzb, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzs(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        p.k(firebaseUser);
        p.k(phoneAuthCredential);
        return this.zzf.zzO(this.zzb, firebaseUser, phoneAuthCredential.clone(), new zzad(this));
    }

    @NonNull
    public final Task zzt(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        p.k(firebaseUser);
        p.k(userProfileChangeRequest);
        return this.zzf.zzP(this.zzb, firebaseUser, userProfileChangeRequest, new zzad(this));
    }

    @NonNull
    public final Task zzu(@NonNull String str, @NonNull String str2, ActionCodeSettings actionCodeSettings) {
        p.g(str);
        p.g(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.zzj;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.zzf.zzQ(str, str2, actionCodeSettings);
    }

    /* access modifiers changed from: package-private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zzy(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (phoneAuthOptions.zzk()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzm(this, phoneAuthOptions, onVerificationStateChangedCallbacks);
    }

    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        p.k(idTokenListener);
        this.zzd.remove(idTokenListener);
        zzC().zzd(this.zzd.size());
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        p.k(idTokenListener);
        this.zzd.add(idTokenListener);
        zzC().zzd(this.zzd.size());
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, ActionCodeSettings actionCodeSettings) {
        p.g(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.zzj;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return new zzo(this, str, actionCodeSettings).zzb(this, this.zzl, this.zzn);
    }
}
