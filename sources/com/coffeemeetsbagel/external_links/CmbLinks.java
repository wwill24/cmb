package com.coffeemeetsbagel.external_links;

import android.app.Activity;
import android.net.Uri;
import androidx.browser.customtabs.d;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.mparticle.kits.ReportingMessage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CmbLinks {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launchCasualAppsSearch(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://www.google.com/search?q=casual+dating+apps"));
        }

        public final void launchCmbStatusPage(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://status.coffeemeetsbagel.com/"));
        }

        public final void launchCommunityGuidelines(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.zendesk.com/hc/en-us/articles/360016483874-Coffee-Meets-Bagel-Community-Guidelines"));
        }

        public final void launchMetSomeoneOnCmbSurvey(Activity activity, PayItForwardSurveyParameters payItForwardSurveyParameters) {
            j.g(activity, "parentActivity");
            j.g(payItForwardSurveyParameters, "payload");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.surveysparrow.com/s/survey-onhold/tt-hrN31jEVxr8ZjKSKWC9gWd").buildUpon().appendQueryParameter("age", String.valueOf(payItForwardSurveyParameters.getAge())).appendQueryParameter("g", payItForwardSurveyParameters.getGender()).appendQueryParameter(NetworkProfile.MALE, payItForwardSurveyParameters.getMatchRegion()).appendQueryParameter("c", payItForwardSurveyParameters.getCountry()).appendQueryParameter("sub", String.valueOf(payItForwardSurveyParameters.getSubscriptionStatus())).appendQueryParameter("i", payItForwardSurveyParameters.getId()).appendQueryParameter(ReportingMessage.MessageType.OPT_OUT, "android").build());
        }

        public final void launchPhoneLoginSupport(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.zendesk.com/hc/en-us/requests/new?ticket_form_id=13159053975315"));
        }

        public final void launchSubscriptionTerms(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://androidsubscriptionpolicy.coffeemeetsbagel.com"));
        }

        public final void launchTermsAndConditions(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.com/privacy-terms"));
        }

        public final void launchTinderWebsite(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://tinder.com/"));
        }

        public final void launchTips(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.com/blog/cmb-101/dating-profile-tips/"));
        }

        public final void launchVerificationSupport(Activity activity) {
            j.g(activity, "parentActivity");
            new d.a().a().a(activity, Uri.parse("https://coffeemeetsbagel.zendesk.com/hc/en-us/requests/new?ticket_form_id=12193856619283"));
        }

        public final void launchWhatsNew(Activity activity) {
            j.g(activity, "parentActivity");
            try {
                new d.a().a().a(activity, Uri.parse(LeanPlumCmbLinks.whatsNewUrls));
            } catch (Exception unused) {
            }
        }
    }

    public static final class PayItForwardSurveyParameters {
        private final int age;
        private final String country;
        private final String gender;

        /* renamed from: id  reason: collision with root package name */
        private final String f12668id;
        private final String matchRegion;
        private final boolean subscriptionStatus;

        public PayItForwardSurveyParameters(int i10, String str, String str2, String str3, boolean z10, String str4) {
            j.g(str, ProfileConstants.Field.GENDER);
            j.g(str3, "country");
            j.g(str4, "id");
            this.age = i10;
            this.gender = str;
            this.matchRegion = str2;
            this.country = str3;
            this.subscriptionStatus = z10;
            this.f12668id = str4;
        }

        public static /* synthetic */ PayItForwardSurveyParameters copy$default(PayItForwardSurveyParameters payItForwardSurveyParameters, int i10, String str, String str2, String str3, boolean z10, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = payItForwardSurveyParameters.age;
            }
            if ((i11 & 2) != 0) {
                str = payItForwardSurveyParameters.gender;
            }
            String str5 = str;
            if ((i11 & 4) != 0) {
                str2 = payItForwardSurveyParameters.matchRegion;
            }
            String str6 = str2;
            if ((i11 & 8) != 0) {
                str3 = payItForwardSurveyParameters.country;
            }
            String str7 = str3;
            if ((i11 & 16) != 0) {
                z10 = payItForwardSurveyParameters.subscriptionStatus;
            }
            boolean z11 = z10;
            if ((i11 & 32) != 0) {
                str4 = payItForwardSurveyParameters.f12668id;
            }
            return payItForwardSurveyParameters.copy(i10, str5, str6, str7, z11, str4);
        }

        public final int component1() {
            return this.age;
        }

        public final String component2() {
            return this.gender;
        }

        public final String component3() {
            return this.matchRegion;
        }

        public final String component4() {
            return this.country;
        }

        public final boolean component5() {
            return this.subscriptionStatus;
        }

        public final String component6() {
            return this.f12668id;
        }

        public final PayItForwardSurveyParameters copy(int i10, String str, String str2, String str3, boolean z10, String str4) {
            j.g(str, ProfileConstants.Field.GENDER);
            j.g(str3, "country");
            j.g(str4, "id");
            return new PayItForwardSurveyParameters(i10, str, str2, str3, z10, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PayItForwardSurveyParameters)) {
                return false;
            }
            PayItForwardSurveyParameters payItForwardSurveyParameters = (PayItForwardSurveyParameters) obj;
            return this.age == payItForwardSurveyParameters.age && j.b(this.gender, payItForwardSurveyParameters.gender) && j.b(this.matchRegion, payItForwardSurveyParameters.matchRegion) && j.b(this.country, payItForwardSurveyParameters.country) && this.subscriptionStatus == payItForwardSurveyParameters.subscriptionStatus && j.b(this.f12668id, payItForwardSurveyParameters.f12668id);
        }

        public final int getAge() {
            return this.age;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getGender() {
            return this.gender;
        }

        public final String getId() {
            return this.f12668id;
        }

        public final String getMatchRegion() {
            return this.matchRegion;
        }

        public final boolean getSubscriptionStatus() {
            return this.subscriptionStatus;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.age) * 31) + this.gender.hashCode()) * 31;
            String str = this.matchRegion;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.country.hashCode()) * 31;
            boolean z10 = this.subscriptionStatus;
            if (z10) {
                z10 = true;
            }
            return ((hashCode2 + (z10 ? 1 : 0)) * 31) + this.f12668id.hashCode();
        }

        public String toString() {
            return "PayItForwardSurveyParameters(age=" + this.age + ", gender=" + this.gender + ", matchRegion=" + this.matchRegion + ", country=" + this.country + ", subscriptionStatus=" + this.subscriptionStatus + ", id=" + this.f12668id + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
