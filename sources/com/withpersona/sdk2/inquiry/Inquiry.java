package com.withpersona.sdk2.inquiry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.InquiryField;
import com.withpersona.sdk2.inquiry.InquiryResponse;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryFieldsMap;
import com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status;
import com.withpersona.sdk2.inquiry.internal.network.q;
import dj.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import mi.d;

public final class Inquiry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String accountId;
    private final Boolean enableErrorLogging;
    private final Environment environment;
    private final Fields fields;
    private final String inquiryId;
    private final String referenceId;
    private final Boolean returnCollectedData;
    private final String sessionToken;
    private final Boolean shouldAutoFallback;
    private final StaticInquiryTemplate staticInquiryTemplate;
    private final String templateId;
    private final String templateVersion;
    private final Integer theme;
    private final Boolean useServerStyles;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status[] r0 = com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status r1 = com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status.INQUIRY_COMPLETE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status r1 = com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status.INQUIRY_CANCELED     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status r1 = com.withpersona.sdk2.inquiry.internal.InquiryIntentKeys$Status.INQUIRY_ERROR     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.Inquiry.Companion.WhenMappings.<clinit>():void");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final InquiryIntentKeys$Status getStatus(Intent intent, Context context) {
            InquiryIntentKeys$Status inquiryIntentKeys$Status;
            Bundle extras;
            String string;
            if (intent == null || (extras = intent.getExtras()) == null || (string = extras.getString("PERSONA_ACTIVITY_RESULT")) == null) {
                inquiryIntentKeys$Status = null;
            } else {
                inquiryIntentKeys$Status = InquiryIntentKeys$Status.valueOf(string);
            }
            if (inquiryIntentKeys$Status != null) {
                return inquiryIntentKeys$Status;
            }
            if (context == null) {
                return InquiryIntentKeys$Status.INQUIRY_CANCELED;
            }
            if (d.c(context).d()) {
                return InquiryIntentKeys$Status.INQUIRY_ERROR;
            }
            return InquiryIntentKeys$Status.INQUIRY_CANCELED;
        }

        public static /* synthetic */ InquiryResponse onActivityResult$default(Companion companion, Intent intent, Context context, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                context = null;
            }
            return companion.onActivityResult(intent, context);
        }

        public final InquiryBuilder fromInquiry(String str) {
            j.g(str, "inquiryId");
            return new InquiryBuilder(str);
        }

        @ExperimentalInquiryFlow
        public final InquiryTemplateBuilder fromStaticTemplate(StaticInquiryTemplate staticInquiryTemplate) {
            j.g(staticInquiryTemplate, "staticInquiryTemplate");
            return new InquiryTemplateBuilder((String) null, (String) null, staticInquiryTemplate, 3, (DefaultConstructorMarker) null);
        }

        public final InquiryTemplateBuilder fromTemplate(String str) {
            j.g(str, "templateId");
            return new InquiryTemplateBuilder(str, (String) null, (StaticInquiryTemplate) null, 6, (DefaultConstructorMarker) null);
        }

        public final InquiryTemplateBuilder fromTemplateVersion(String str) {
            j.g(str, RemoteConfigConstants.ResponseFieldKey.TEMPLATE_VERSION_NUMBER);
            return new InquiryTemplateBuilder((String) null, str, (StaticInquiryTemplate) null, 5, (DefaultConstructorMarker) null);
        }

        public final InquiryResponse onActivityResult(Intent intent) {
            return onActivityResult$default(this, intent, (Context) null, 2, (Object) null);
        }

        public final InquiryResponse onActivityResult(Intent intent, Context context) {
            String str;
            InquiryFieldsMap inquiryFieldsMap;
            String str2;
            a aVar;
            Object obj;
            InquiryField.DateField dateField;
            Bundle extras;
            Bundle extras2;
            Bundle extras3;
            Bundle extras4;
            String str3;
            Bundle extras5;
            Bundle extras6;
            InquiryIntentKeys$Status status = getStatus(intent, context);
            String str4 = null;
            if (intent == null || (extras6 = intent.getExtras()) == null) {
                str = null;
            } else {
                str = extras6.getString("INQUIRY_ID_KEY");
            }
            int i10 = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            if (i10 == 1) {
                if (intent == null || (extras3 = intent.getExtras()) == null) {
                    inquiryFieldsMap = null;
                } else {
                    inquiryFieldsMap = (InquiryFieldsMap) extras3.getParcelable("FIELDS_MAP_KEY");
                }
                if (inquiryFieldsMap == null) {
                    inquiryFieldsMap = new InquiryFieldsMap(h0.i());
                }
                if (intent == null || (extras2 = intent.getExtras()) == null) {
                    str2 = null;
                } else {
                    str2 = extras2.getString("INQUIRY_STATUS_KEY");
                }
                if (intent == null || (extras = intent.getExtras()) == null) {
                    aVar = null;
                } else {
                    aVar = com.withpersona.sdk2.inquiry.internal.a.a(extras);
                }
                j.d(str);
                j.d(str2);
                Map<String, com.withpersona.sdk2.inquiry.internal.InquiryField> a10 = inquiryFieldsMap.a();
                LinkedHashMap linkedHashMap = new LinkedHashMap(g0.e(a10.size()));
                for (Map.Entry entry : a10.entrySet()) {
                    Object key = entry.getKey();
                    com.withpersona.sdk2.inquiry.internal.InquiryField inquiryField = (com.withpersona.sdk2.inquiry.internal.InquiryField) entry.getValue();
                    if (inquiryField instanceof InquiryField.StringField) {
                        obj = new InquiryField.StringField(((InquiryField.StringField) inquiryField).c());
                    } else if (inquiryField instanceof InquiryField.IntegerField) {
                        obj = new InquiryField.IntegerField(((InquiryField.IntegerField) inquiryField).c());
                    } else if (inquiryField instanceof InquiryField.BooleanField) {
                        obj = new InquiryField.BooleanField(((InquiryField.BooleanField) inquiryField).c());
                    } else if (inquiryField instanceof InquiryField.FloatField) {
                        obj = new InquiryField.FloatField(((InquiryField.FloatField) inquiryField).c());
                    } else {
                        if (inquiryField instanceof InquiryField.DateField) {
                            String c10 = ((InquiryField.DateField) inquiryField).c();
                            if (c10 != null) {
                                dateField = new InquiryField.DateField(new SimpleDateFormat(DateUtils.DATE_PATTERN, Locale.US).parse(c10));
                            } else {
                                obj = new InquiryField.DateField((Date) null);
                            }
                        } else if (inquiryField instanceof InquiryField.DatetimeField) {
                            String c11 = ((InquiryField.DatetimeField) inquiryField).c();
                            if (c11 != null) {
                                dateField = new InquiryField.DateField(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).parse(c11));
                            } else {
                                obj = new InquiryField.DatetimeField((Date) null);
                            }
                        } else if (inquiryField instanceof InquiryField.Unknown) {
                            obj = new InquiryField.UnknownField(inquiryField.a());
                        } else {
                            obj = new InquiryField.UnknownField("unknown");
                        }
                        obj = dateField;
                    }
                    linkedHashMap.put(key, obj);
                }
                return new InquiryResponse.Complete(str, str2, linkedHashMap, aVar);
            } else if (i10 == 2) {
                if (!(intent == null || (extras4 = intent.getExtras()) == null)) {
                    str4 = extras4.getString("SESSION_TOKEN_KEY");
                }
                return new InquiryResponse.Cancel(str, str4);
            } else if (i10 == 3) {
                if (intent == null || (extras5 = intent.getExtras()) == null) {
                    str3 = null;
                } else {
                    str3 = extras5.getString("ERROR_DEBUG_MESSAGE_KEY");
                }
                if (context != null) {
                    str4 = d.c(context).c();
                }
                if (str3 == null) {
                    str3 = "An otherwise unexpected error occurred.";
                }
                return new InquiryResponse.Error(str3, str4);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public final void prefetchModels() {
            q.f26918a.a();
        }
    }

    public static class Contract extends c.a<Inquiry, InquiryResponse> {
        private Context context;

        public Contract() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Contract(Context context2) {
            this();
            j.g(context2, IdentityHttpResponse.CONTEXT);
            this.context = context2;
        }

        public Intent createIntent(Context context2, Inquiry inquiry) {
            j.g(context2, IdentityHttpResponse.CONTEXT);
            j.g(inquiry, "input");
            return inquiry.toInquiryActivityIntent(context2);
        }

        public InquiryResponse parseResult(int i10, Intent intent) {
            return Inquiry.Companion.onActivityResult(intent, this.context);
        }
    }

    public Inquiry(String str, String str2, String str3, String str4, String str5, String str6, Fields fields2, Integer num, Environment environment2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, StaticInquiryTemplate staticInquiryTemplate2) {
        this.templateId = str;
        this.templateVersion = str2;
        this.inquiryId = str3;
        this.sessionToken = str4;
        this.referenceId = str5;
        this.accountId = str6;
        this.fields = fields2;
        this.theme = num;
        this.environment = environment2;
        this.enableErrorLogging = bool;
        this.returnCollectedData = bool2;
        this.shouldAutoFallback = bool3;
        this.useServerStyles = bool4;
        this.staticInquiryTemplate = staticInquiryTemplate2;
    }

    public static final InquiryBuilder fromInquiry(String str) {
        return Companion.fromInquiry(str);
    }

    @ExperimentalInquiryFlow
    public static final InquiryTemplateBuilder fromStaticTemplate(StaticInquiryTemplate staticInquiryTemplate2) {
        return Companion.fromStaticTemplate(staticInquiryTemplate2);
    }

    public static final InquiryTemplateBuilder fromTemplate(String str) {
        return Companion.fromTemplate(str);
    }

    public static final InquiryTemplateBuilder fromTemplateVersion(String str) {
        return Companion.fromTemplateVersion(str);
    }

    public static final InquiryResponse onActivityResult(Intent intent) {
        return Companion.onActivityResult(intent);
    }

    public static final InquiryResponse onActivityResult(Intent intent, Context context) {
        return Companion.onActivityResult(intent, context);
    }

    /* access modifiers changed from: private */
    public final Intent toInquiryActivityIntent(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.withpersona.sdk2.inquiry.internal.InquiryActivity");
        String str = this.templateId;
        if (str != null) {
            intent.putExtra("TEMPLATE_ID_KEY", str);
        }
        String str2 = this.templateVersion;
        if (str2 != null) {
            intent.putExtra("TEMPLATE_VERSION_KEY", str2);
        }
        String str3 = this.inquiryId;
        if (str3 != null) {
            intent.putExtra("INQUIRY_ID_KEY", str3);
        }
        String str4 = this.sessionToken;
        if (str4 != null) {
            intent.putExtra("SESSION_TOKEN_KEY", str4);
        }
        String str5 = this.referenceId;
        if (str5 != null) {
            intent.putExtra("REFERENCE_ID_KEY", str5);
        }
        String str6 = this.accountId;
        if (str6 != null) {
            intent.putExtra("ACCOUNT_ID_KEY", str6);
        }
        Fields fields2 = this.fields;
        if (fields2 != null) {
            intent.putExtra("FIELDS_MAP_KEY", new InquiryFieldsMap(fields2.getFields$inquiry_public_release()));
        }
        Integer num = this.theme;
        if (num != null) {
            intent.putExtra("THEME_KEY", num.intValue());
        }
        StaticInquiryTemplate staticInquiryTemplate2 = this.staticInquiryTemplate;
        if (staticInquiryTemplate2 != null) {
            intent.putExtra("STATIC_INQUIRY_TEMPLATE_KEY", StaticInquiryTemplateKt.to(staticInquiryTemplate2));
        }
        Environment environment2 = this.environment;
        if (environment2 != null) {
            intent.putExtra("ENVIRONMENT_KEY", environment2.name());
        }
        Boolean bool = this.enableErrorLogging;
        if (bool != null) {
            intent.putExtra("ENABLE_ERROR_LOGGING", bool.booleanValue());
        }
        Boolean bool2 = this.returnCollectedData;
        if (bool2 != null) {
            intent.putExtra("RETURN_COLLECTED_DATA", bool2.booleanValue());
        }
        Boolean bool3 = this.shouldAutoFallback;
        if (bool3 != null) {
            intent.putExtra("SHOULD_AUTO_FALLBACK", bool3.booleanValue());
        }
        Boolean bool4 = this.useServerStyles;
        if (bool4 != null) {
            intent.putExtra("USE_SERVER_STYLES", bool4.booleanValue());
        }
        return intent;
    }

    public final void start(Activity activity, int i10) {
        j.g(activity, "activity");
        activity.startActivityForResult(toInquiryActivityIntent(activity), i10);
    }
}
