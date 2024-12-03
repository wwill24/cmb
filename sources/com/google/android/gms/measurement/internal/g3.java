package com.google.android.gms.measurement.internal;

import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import we.b;

public final class g3 {
    public static final f3 A = a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, c0.f39692a);
    public static final f3 A0;
    public static final f3 B;
    public static final f3 B0;
    public static final f3 C = a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, e0.f39733a);
    public static final f3 C0;
    public static final f3 D = a("measurement.upload.retry_time", 1800000L, 1800000L, g0.f39802a);
    public static final f3 D0;
    public static final f3 E = a("measurement.upload.retry_count", 6, 6, h0.f39888a);
    public static final f3 E0;
    public static final f3 F = a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, i0.f39913a);
    public static final f3 F0;
    public static final f3 G = a("measurement.lifetimevalue.max_currency_tracked", 4, 4, k0.f39983a);
    public static final f3 G0;
    public static final f3 H = a("measurement.audience.filter_result_max_count", 200, 200, l0.f39999a);
    public static final f3 H0;
    public static final f3 I = a("measurement.upload.max_public_user_properties", 25, 25, (d3) null);
    public static final f3 I0;
    public static final f3 J = a("measurement.upload.max_event_name_cardinality", 500, 500, (d3) null);
    public static final f3 J0;
    public static final f3 K = a("measurement.upload.max_public_event_params", 25, 25, (d3) null);
    public static final f3 K0;
    public static final f3 L = a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, m0.f40028a);
    public static final f3 M;
    public static final f3 N = a("measurement.test.string_flag", "---", "---", o0.f40096a);
    public static final f3 O = a("measurement.test.long_flag", -1L, -1L, p0.f40128a);
    public static final f3 P = a("measurement.test.int_flag", -2, -2, r0.f40210a);
    public static final f3 Q;
    public static final f3 R = a("measurement.experiment.max_ids", 50, 50, t0.f40267a);
    public static final f3 S = a("measurement.upload.max_item_scoped_custom_parameters", 27, 27, u0.f40292a);
    public static final f3 T = a("measurement.max_bundles_per_iteration", 100, 100, w0.f40374a);
    public static final f3 U;
    public static final f3 V = a("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, z0.f40440a);
    public static final f3 W;
    public static final f3 X;
    public static final f3 Y;
    public static final f3 Z;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final List f39805a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a0  reason: collision with root package name */
    public static final f3 f39806a0;

    /* renamed from: b  reason: collision with root package name */
    private static final Set f39807b = Collections.synchronizedSet(new HashSet());

    /* renamed from: b0  reason: collision with root package name */
    public static final f3 f39808b0;

    /* renamed from: c  reason: collision with root package name */
    public static final f3 f39809c = a("measurement.ad_id_cache_time", 10000L, 10000L, f0.f39774a);

    /* renamed from: c0  reason: collision with root package name */
    public static final f3 f39810c0;

    /* renamed from: d  reason: collision with root package name */
    public static final f3 f39811d;

    /* renamed from: d0  reason: collision with root package name */
    public static final f3 f39812d0;

    /* renamed from: e  reason: collision with root package name */
    public static final f3 f39813e = a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, j0.f39949a);

    /* renamed from: e0  reason: collision with root package name */
    public static final f3 f39814e0;

    /* renamed from: f  reason: collision with root package name */
    public static final f3 f39815f;

    /* renamed from: f0  reason: collision with root package name */
    public static final f3 f39816f0;

    /* renamed from: g  reason: collision with root package name */
    public static final f3 f39817g = a("measurement.config.url_scheme", "https", "https", i1.f39914a);

    /* renamed from: g0  reason: collision with root package name */
    public static final f3 f39818g0;

    /* renamed from: h  reason: collision with root package name */
    public static final f3 f39819h = a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", u1.f40293a);

    /* renamed from: h0  reason: collision with root package name */
    public static final f3 f39820h0;

    /* renamed from: i  reason: collision with root package name */
    public static final f3 f39821i = a("measurement.upload.max_bundles", 100, 100, h2.f39890a);

    /* renamed from: i0  reason: collision with root package name */
    public static final f3 f39822i0;

    /* renamed from: j  reason: collision with root package name */
    public static final f3 f39823j = a("measurement.upload.max_batch_size", 65536, 65536, t2.f40269a);

    /* renamed from: j0  reason: collision with root package name */
    public static final f3 f39824j0 = a("measurement.service.storage_consent_support_version", 203600, 203600, p1.f40129a);

    /* renamed from: k  reason: collision with root package name */
    public static final f3 f39825k = a("measurement.upload.max_bundle_size", 65536, 65536, y2.f40422a);

    /* renamed from: k0  reason: collision with root package name */
    public static final f3 f39826k0;

    /* renamed from: l  reason: collision with root package name */
    public static final f3 f39827l = a("measurement.upload.max_events_per_bundle", 1000, 1000, z2.f40444a);

    /* renamed from: l0  reason: collision with root package name */
    public static final f3 f39828l0;

    /* renamed from: m  reason: collision with root package name */
    public static final f3 f39829m = a("measurement.upload.max_events_per_day", 100000, 100000, q0.f40156a);

    /* renamed from: m0  reason: collision with root package name */
    public static final f3 f39830m0;

    /* renamed from: n  reason: collision with root package name */
    public static final f3 f39831n = a("measurement.upload.max_error_events_per_day", 1000, 1000, c1.f39693a);

    /* renamed from: n0  reason: collision with root package name */
    public static final f3 f39832n0;

    /* renamed from: o  reason: collision with root package name */
    public static final f3 f39833o = a("measurement.upload.max_public_events_per_day", 50000, 50000, n1.f40049a);

    /* renamed from: o0  reason: collision with root package name */
    public static final f3 f39834o0;

    /* renamed from: p  reason: collision with root package name */
    public static final f3 f39835p = a("measurement.upload.max_conversions_per_day", 10000, 10000, y1.f40421a);

    /* renamed from: p0  reason: collision with root package name */
    public static final f3 f39836p0;

    /* renamed from: q  reason: collision with root package name */
    public static final f3 f39837q = a("measurement.upload.max_realtime_events_per_day", 10, 10, k2.f39985a);

    /* renamed from: q0  reason: collision with root package name */
    public static final f3 f39838q0;

    /* renamed from: r  reason: collision with root package name */
    public static final f3 f39839r = a("measurement.store.max_stored_events_per_app", 100000, 100000, v2.f40354a);

    /* renamed from: r0  reason: collision with root package name */
    public static final f3 f39840r0;

    /* renamed from: s  reason: collision with root package name */
    public static final f3 f39841s = a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", b3.f39668a);

    /* renamed from: s0  reason: collision with root package name */
    public static final f3 f39842s0;

    /* renamed from: t  reason: collision with root package name */
    public static final f3 f39843t = a("measurement.upload.backoff_period", 43200000L, 43200000L, c3.f39695a);

    /* renamed from: t0  reason: collision with root package name */
    public static final f3 f39844t0;

    /* renamed from: u  reason: collision with root package name */
    public static final f3 f39845u;

    /* renamed from: u0  reason: collision with root package name */
    public static final f3 f39846u0;

    /* renamed from: v  reason: collision with root package name */
    public static final f3 f39847v;

    /* renamed from: v0  reason: collision with root package name */
    public static final f3 f39848v0;

    /* renamed from: w  reason: collision with root package name */
    public static final f3 f39849w = a("measurement.upload.realtime_upload_interval", 10000L, 10000L, y.f40418a);

    /* renamed from: w0  reason: collision with root package name */
    public static final f3 f39850w0;

    /* renamed from: x  reason: collision with root package name */
    public static final f3 f39851x = a("measurement.upload.debug_upload_interval", 1000L, 1000L, z.f40439a);

    /* renamed from: x0  reason: collision with root package name */
    public static final f3 f39852x0;

    /* renamed from: y  reason: collision with root package name */
    public static final f3 f39853y = a("measurement.upload.minimum_delay", 500L, 500L, a0.f39628a);

    /* renamed from: y0  reason: collision with root package name */
    public static final f3 f39854y0;

    /* renamed from: z  reason: collision with root package name */
    public static final f3 f39855z;

    /* renamed from: z0  reason: collision with root package name */
    public static final f3 f39856z0;

    static {
        Long valueOf = Long.valueOf(DateUtils.MILLIS_IN_HOUR);
        f39811d = a("measurement.app_uninstalled_additional_ad_id_cache_time", valueOf, valueOf, w.f40373a);
        f39815f = a("measurement.config.cache_time", 86400000L, valueOf, v0.f40352a);
        f39845u = a("measurement.upload.window_interval", valueOf, valueOf, u.f40291a);
        f39847v = a("measurement.upload.interval", valueOf, valueOf, v.f40351a);
        Long valueOf2 = Long.valueOf(DateUtils.MILLIS_IN_MINUTE);
        f39855z = a("measurement.alarm_manager.minimum_interval", valueOf2, valueOf2, b0.f39665a);
        Long valueOf3 = Long.valueOf(DateUtils.MILLIS_IN_WEEK);
        B = a("measurement.upload.refresh_blacklisted_config_interval", valueOf3, valueOf3, d0.f39712a);
        Boolean bool = Boolean.FALSE;
        M = a("measurement.test.boolean_flag", bool, bool, n0.f40048a);
        Double valueOf4 = Double.valueOf(-3.0d);
        Q = a("measurement.test.double_flag", valueOf4, valueOf4, s0.f40236a);
        U = a("measurement.sdk.attribution.cache.ttl", valueOf3, valueOf3, x0.f40401a);
        Boolean bool2 = Boolean.TRUE;
        W = a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, a1.f39629a);
        X = a("measurement.quality.checksum", bool, bool, (d3) null);
        Y = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, b1.f39666a);
        Z = a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, d1.f39713a);
        f39806a0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, e1.f39734a);
        f39808b0 = a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, f1.f39775a);
        f39810c0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, g1.f39803a);
        f39812d0 = a("measurement.lifecycle.app_in_background_parameter", bool, bool, h1.f39889a);
        f39814e0 = a("measurement.integration.disable_firebase_instance_id", bool, bool, j1.f39950a);
        f39816f0 = a("measurement.collection.service.update_with_analytics_fix", bool, bool, k1.f39984a);
        f39818g0 = a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, l1.f40000a);
        f39820h0 = a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, m1.f40029a);
        f39822i0 = a("measurement.collection.synthetic_data_mitigation", bool, bool, o1.f40097a);
        f39826k0 = a("measurement.client.click_identifier_control.dev", bool, bool, q1.f40157a);
        f39828l0 = a("measurement.service.click_identifier_control", bool, bool, r1.f40211a);
        f39830m0 = a("measurement.service.store_null_safelist", bool2, bool2, s1.f40237a);
        f39832n0 = a("measurement.service.store_safelist", bool2, bool2, t1.f40268a);
        f39834o0 = a("measurement.collection.enable_session_stitching_token.first_open_fix", bool2, bool2, v1.f40353a);
        f39836p0 = a("measurement.collection.enable_session_stitching_token.client.dev", bool2, bool2, w1.f40375a);
        f39838q0 = a("measurement.session_stitching_token_enabled", bool, bool, x1.f40402a);
        f39840r0 = a("measurement.sgtm.client.dev", bool, bool, a2.f39630a);
        f39842s0 = a("measurement.sgtm.service", bool, bool, b2.f39667a);
        f39844t0 = a("measurement.redaction.retain_major_os_version", bool2, bool2, c2.f39694a);
        f39846u0 = a("measurement.redaction.scion_payload_generator", bool2, bool2, d2.f39714a);
        f39848v0 = a("measurement.service.clear_global_params_on_uninstall", bool2, bool2, e2.f39735a);
        f39850w0 = a("measurement.sessionid.enable_client_session_id", bool2, bool2, f2.f39776a);
        f39852x0 = a("measurement.sfmc.client", bool2, bool2, g2.f39804a);
        f39854y0 = a("measurement.sfmc.service", bool2, bool2, i2.f39915a);
        f39856z0 = a("measurement.gmscore_feature_tracking", bool2, bool2, j2.f39951a);
        A0 = a("measurement.fix_health_monitor_stack_trace", bool2, bool2, l2.f40001a);
        B0 = a("measurement.item_scoped_custom_parameters.client", bool2, bool2, m2.f40030a);
        C0 = a("measurement.item_scoped_custom_parameters.service", bool, bool, n2.f40050a);
        D0 = a("measurement.remove_app_background.client", bool, bool, o2.f40098a);
        E0 = a("measurement.rb.attribution.service", bool, bool, p2.f40130a);
        F0 = a("measurement.collection.client.log_target_api_version", bool2, bool2, q2.f40158a);
        G0 = a("measurement.collection.service.log_target_api_version", bool2, bool2, r2.f40212a);
        H0 = a("measurement.client.deep_link_referrer_fix", bool2, bool2, s2.f40238a);
        I0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, bool, u2.f40294a);
        J0 = a("measurement.link_sst_to_sid", bool2, bool2, w2.f40376a);
        K0 = a("measurement.client.ad_id_consent_fix", bool2, bool2, x2.f40403a);
    }

    static f3 a(String str, Object obj, Object obj2, d3 d3Var) {
        f3 f3Var = new f3(str, obj, obj2, d3Var, (b) null);
        f39805a.add(f3Var);
        return f3Var;
    }
}
