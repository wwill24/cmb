package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.facebook.messenger.MessengerUtils;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u000eÕ\u0001Ö\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J.\u0010\u0001\u001a\u00020A2\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020A2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u0001H\u0007J½\u0001\u0010§\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010®\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010´\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007J.\u0010µ\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¶\u0001\u001a\u00030\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0001H\u0007JÆ\u0001\u0010¹\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010~2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J\u0016\u0010»\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010¿\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010Á\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u001d\u0010Ã\u0001\u001a\u00030²\u00012\u0007\u0010°\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0007J%\u0010Ä\u0001\u001a\u00030²\u00012\u000f\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u00010~2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010Æ\u0001\u001a\u00020A2\u0007\u0010Ç\u0001\u001a\u00020AH\u0007J\t\u0010È\u0001\u001a\u00020AH\u0007J\u0016\u0010É\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Ê\u0001\u001a\u00020A2\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0016\u0010Ë\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0014\u0010Ì\u0001\u001a\u00030\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Í\u0001\u001a\u00030\u00012\u0007\u0010Î\u0001\u001a\u00020AH\u0007J?\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010¼\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Î\u0001\u001a\u00020A2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\n\u0010Ò\u0001\u001a\u00030Ð\u0001H\u0007J-\u0010Ó\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007J-\u0010Ô\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010v\u001a\n w*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010|\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Ü\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "()V", "ACTION_APPINVITE_DIALOG", "", "ACTION_CAMERA_EFFECT", "ACTION_FEED_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_SHARE_STORY", "AUDIENCE_EVERYONE", "AUDIENCE_FRIENDS", "AUDIENCE_ME", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_JSON", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_TYPE", "CONTENT_SCHEME", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_PROTOCOL_ERROR", "ERROR_SERVICE_DISABLED", "ERROR_UNKNOWN_ERROR", "ERROR_USER_CANCELED", "EXTRA_ACCESS_TOKEN", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_AUTHENTICATION_TOKEN", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_GRAPH_API_VERSION", "EXTRA_LOGGER_REF", "EXTRA_NONCE", "EXTRA_PERMISSIONS", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_VERSIONS", "EXTRA_TOAST_DURATION_MS", "EXTRA_USER_ID", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_SDK_VERSION_KEY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "IMAGE_URL_KEY", "IMAGE_USER_GENERATED_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "KNOWN_PROTOCOL_VERSIONS", "", "", "[Ljava/lang/Integer;", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "NO_PROTOCOL_AVAILABLE", "OPEN_GRAPH_CREATE_OBJECT_KEY", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131024", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140313", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20150401", "PROTOCOL_VERSION_20150702", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20161017", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_PERMISSIONS", "RESULT_ARGS_SIGNED_REQUEST", "STATUS_ERROR_CODE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_JSON", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_TYPE", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_ACTION", "WEB_DIALOG_IS_FALLBACK", "WEB_DIALOG_PARAMS", "WEB_DIALOG_URL", "actionToAppInfoMap", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "effectCameraAppInfoList", "facebookAppInfoList", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildActionToAppInfoMap", "buildEffectCameraAppInfoList", "buildFacebookAppList", "buildPlatformProviderVersionURI", "Landroid/net/Uri;", "appInfo", "computeLatestAvailableVersionFromVersionSpec", "allAvailableFacebookAppVersions", "Ljava/util/TreeSet;", "latestSdkVersion", "versionSpec", "", "createBundleForException", "Landroid/os/Bundle;", "e", "Lcom/facebook/FacebookException;", "createInstagramIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applicationId", "permissions", "", "e2e", "isRerequest", "", "isForPublish", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createNativeAppIntent", "ignoreAppSwitchToLoggedOut", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeChallenge", "codeChallengeMethod", "createPlatformActivityIntent", "callId", "action", "versionResult", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "extras", "createPlatformServiceIntent", "createProtocolResultIntent", "requestIntent", "results", "error", "createProxyAuthIntents", "fetchAllAvailableProtocolVersionsForAppInfo", "getBridgeArgumentsFromIntent", "intent", "getCallIdFromIntent", "Ljava/util/UUID;", "getErrorDataFromResultIntent", "resultIntent", "getExceptionFromErrorData", "errorData", "getLatestAvailableProtocolVersionForAction", "getLatestAvailableProtocolVersionForAppInfoList", "appInfoList", "getLatestAvailableProtocolVersionForService", "minimumVersion", "getLatestKnownVersion", "getMethodArgumentsFromIntent", "getProtocolVersionFromIntent", "getSuccessResultsFromIntent", "isErrorResult", "isVersionCompatibleWithBucketedIntent", "version", "setupProtocolRequestIntent", "", "params", "updateAllAvailableProtocolVersionsAsync", "validateActivityIntent", "validateServiceIntent", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    public static final NativeProtocol INSTANCE;
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS = {Integer.valueOf(PROTOCOL_VERSION_20210906), Integer.valueOf(PROTOCOL_VERSION_20171115), Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20170411), Integer.valueOf(PROTOCOL_VERSION_20170213), Integer.valueOf(PROTOCOL_VERSION_20161017), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20150702), Integer.valueOf(PROTOCOL_VERSION_20150401), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140313), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20131024), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG = NativeProtocol.class.getName();
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    private static final List<NativeAppInfo> facebookAppInfoList;
    private static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class EffectTestAppInfo extends NativeAppInfo {
        public Void getLoginActivity() {
            return null;
        }

        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class InstagramAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        public String getPackage() {
            return "com.instagram.android";
        }

        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "isAndroidAPIVersionNotLessThan30", "", "onAvailableVersionsNullOrEmpty", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            if (FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30) {
                return true;
            }
            return false;
        }

        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        public String getPackage() {
            return "com.facebook.katana";
        }

        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                NativeProtocol.access$getTAG$p();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class MessengerAppInfo extends NativeAppInfo {
        public Void getLoginActivity() {
            return null;
        }

        public String getPackage() {
            return MessengerUtils.PACKAGE_NAME;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "()V", "availableVersions", "Ljava/util/TreeSet;", "", "fetchAvailableVersions", "", "force", "", "getAvailableVersions", "getLoginActivity", "", "getPackage", "getResponseType", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (kotlin.jvm.internal.j.b(r2, java.lang.Boolean.FALSE) == false) goto L_0x001b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void fetchAvailableVersions(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L_0x001b
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x001b
                if (r2 != 0) goto L_0x000b
                r2 = 0
                goto L_0x0013
            L_0x000b:
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0038 }
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0038 }
            L_0x0013:
                java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0038 }
                boolean r2 = kotlin.jvm.internal.j.b(r2, r0)     // Catch:{ all -> 0x0038 }
                if (r2 != 0) goto L_0x0023
            L_0x001b:
                com.facebook.internal.NativeProtocol r2 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0038 }
                java.util.TreeSet r2 = com.facebook.internal.NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(r2, r1)     // Catch:{ all -> 0x0038 }
                r1.availableVersions = r2     // Catch:{ all -> 0x0038 }
            L_0x0023:
                java.util.TreeSet<java.lang.Integer> r2 = r1.availableVersions     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x0030
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0038 }
                if (r2 == 0) goto L_0x002e
                goto L_0x0030
            L_0x002e:
                r2 = 0
                goto L_0x0031
            L_0x0030:
                r2 = 1
            L_0x0031:
                if (r2 == 0) goto L_0x0036
                r1.onAvailableVersionsNullOrEmpty()     // Catch:{ all -> 0x0038 }
            L_0x0036:
                monitor-exit(r1)
                return
            L_0x0038:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            if (kotlin.jvm.internal.j.b(r0, java.lang.Boolean.FALSE) == false) goto L_0x0018;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.TreeSet<java.lang.Integer> getAvailableVersions() {
            /*
                r2 = this;
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                if (r0 == 0) goto L_0x0018
                if (r0 != 0) goto L_0x0008
                r0 = 0
                goto L_0x0010
            L_0x0008:
                boolean r0 = r0.isEmpty()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            L_0x0010:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE
                boolean r0 = kotlin.jvm.internal.j.b(r0, r1)
                if (r0 != 0) goto L_0x001c
            L_0x0018:
                r0 = 0
                r2.fetchAvailableVersions(r0)
            L_0x001c:
                java.util.TreeSet<java.lang.Integer> r0 = r2.availableVersions
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.getAvailableVersions():java.util.TreeSet");
        }

        public abstract String getLoginActivity();

        public abstract String getPackage();

        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST;
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProtocolVersionQueryResult {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public NativeAppInfo appInfo;
        /* access modifiers changed from: private */
        public int protocolVersion;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", "", "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", "", "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i10) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult((DefaultConstructorMarker) null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i10;
                return protocolVersionQueryResult;
            }

            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult((DefaultConstructorMarker) null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }
        }

        private ProtocolVersionQueryResult() {
        }

        public /* synthetic */ ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i10) {
            return Companion.create(nativeAppInfo, i10);
        }

        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class WakizashiAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        public String getPackage() {
            return RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE_WAKIZASHI;
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
            hashMap.put(ACTION_FEED_DIALOG, list);
            hashMap.put(ACTION_LIKE_DIALOG, list);
            hashMap.put(ACTION_APPINVITE_DIALOG, list);
            hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
            hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            hashMap.put(ACTION_SHARE_STORY, list);
            return hashMap;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList f10 = q.f(new EffectTestAppInfo());
            f10.addAll(buildFacebookAppList());
            return f10;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return q.f(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            j.f(parse, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i10, int[] iArr) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            j.g(iArr, "versionSpec");
            if (treeSet == null) {
                return -1;
            }
            int length = iArr.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i11 = -1;
            while (descendingIterator.hasNext()) {
                Integer next = descendingIterator.next();
                j.f(next, "fbAppVersion");
                i11 = Math.max(i11, next.intValue());
                while (length >= 0 && iArr[length] > next.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == next.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(i11, i10);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    public static final Bundle createBundleForException(FacebookException facebookException) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", ERROR_USER_CANCELED);
            }
            return bundle;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Intent createInstagramIntent(Context context, String str, Collection<String> collection, String str2, boolean z10, boolean z11, DefaultAudience defaultAudience, String str3, String str4, String str5, boolean z12, boolean z13, boolean z14) {
        Context context2 = context;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context2, IdentityHttpResponse.CONTEXT);
            j.g(str, "applicationId");
            j.g(collection, "permissions");
            j.g(str2, "e2e");
            j.g(defaultAudience, "defaultAudience");
            j.g(str3, "clientState");
            j.g(str4, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context2, INSTANCE.createNativeAppIntent(instagramAppInfo, str, collection, str2, z11, defaultAudience, str3, str4, false, str5, z12, LoginTargetApp.INSTAGRAM, z13, z14, "", (String) null, (String) null), instagramAppInfo);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z10, DefaultAudience defaultAudience, String str3, String str4, boolean z11, String str5, boolean z12, LoginTargetApp loginTargetApp, boolean z13, boolean z14, String str6, String str7, String str8) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            String str9 = str;
            Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
            j.f(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
            if (!Utility.isNullOrEmpty((Collection<?>) collection)) {
                Collection<String> collection2 = collection;
                putExtra.putExtra("scope", TextUtils.join(AppsFlyerKit.COMMA, collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                String str10 = str2;
                putExtra.putExtra("e2e", str2);
            }
            String str11 = str3;
            putExtra.putExtra("state", str3);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, nativeAppInfo.getResponseType());
            putExtra.putExtra("nonce", str6);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (z10) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
            String str12 = str4;
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
            if (z11) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
            }
            String str13 = str5;
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, str5);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, z12);
            if (z13) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, loginTargetApp.toString());
            }
            if (z14) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
            }
            return putExtra;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        NativeAppInfo appInfo;
        Intent validateActivityIntent;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
            return validateActivityIntent;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Intent createPlatformServiceIntent(Context context) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            for (NativeAppInfo next : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(next.getPackage()).addCategory("android.intent.category.DEFAULT"), next);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(intent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(intent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", callIdFromIntent.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", createBundleForException(facebookException));
            }
            intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle != null) {
                intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
            }
            return intent2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final List<Intent> createProxyAuthIntents(Context context, String str, Collection<String> collection, String str2, boolean z10, boolean z11, DefaultAudience defaultAudience, String str3, String str4, boolean z12, String str5, boolean z13, boolean z14, boolean z15, String str6, String str7, String str8) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(str, "applicationId");
            j.g(collection, "permissions");
            j.g(str2, "e2e");
            j.g(defaultAudience, "defaultAudience");
            j.g(str3, "clientState");
            j.g(str4, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            for (NativeAppInfo createNativeAppIntent : list) {
                ArrayList arrayList2 = arrayList;
                Intent createNativeAppIntent2 = INSTANCE.createNativeAppIntent(createNativeAppIntent, str, collection, str2, z11, defaultAudience, str3, str4, z12, str5, z13, LoginTargetApp.FACEBOOK, z14, z15, str6, str7, str8);
                if (createNativeAppIntent2 != null) {
                    arrayList2.add(createNativeAppIntent2);
                }
                String str9 = str;
                Collection<String> collection2 = collection;
                String str10 = str2;
                DefaultAudience defaultAudience2 = defaultAudience;
                String str11 = str3;
                String str12 = str4;
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static /* synthetic */ List createProxyAuthIntents$default(Context context, String str, Collection collection, String str2, boolean z10, boolean z11, DefaultAudience defaultAudience, String str3, String str4, boolean z12, String str5, boolean z13, boolean z14, boolean z15, String str6, String str7, String str8, int i10, Object obj) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return createProxyAuthIntents(context, str, collection, str2, z10, z11, defaultAudience, str3, str4, z12, str5, z13, z14, z15, str6, str7, (i10 & 65536) != 0 ? "S256" : str8);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[Catch:{ all -> 0x0068, all -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d A[Catch:{ all -> 0x0068, all -> 0x0071 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r12) {
        /*
            r11 = this;
            java.lang.String r0 = "version"
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.TreeSet r1 = new java.util.TreeSet     // Catch:{ all -> 0x0071 }
            r1.<init>()     // Catch:{ all -> 0x0071 }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0071 }
            android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ all -> 0x0071 }
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0071 }
            android.net.Uri r5 = r11.buildPlatformProviderVersionURI(r12)     // Catch:{ all -> 0x0071 }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0068 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x0068 }
            java.lang.String r12 = r12.getPackage()     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = ".provider.PlatformProvider"
            java.lang.String r12 = kotlin.jvm.internal.j.p(r12, r7)     // Catch:{ all -> 0x0068 }
            r7 = 0
            android.content.pm.ProviderInfo r12 = r3.resolveContentProvider(r12, r7)     // Catch:{ RuntimeException -> 0x0037 }
            goto L_0x0038
        L_0x0037:
            r12 = r2
        L_0x0038:
            if (r12 == 0) goto L_0x0060
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ IllegalArgumentException | NullPointerException | SecurityException -> 0x0042 }
            goto L_0x0043
        L_0x0042:
            r12 = r2
        L_0x0043:
            if (r12 == 0) goto L_0x0061
        L_0x0045:
            boolean r3 = r12.moveToNext()     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x0061
            int r3 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x005b }
            int r3 = r12.getInt(r3)     // Catch:{ all -> 0x005b }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x005b }
            r1.add(r3)     // Catch:{ all -> 0x005b }
            goto L_0x0045
        L_0x005b:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x006a
        L_0x0060:
            r12 = r2
        L_0x0061:
            if (r12 != 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            r12.close()     // Catch:{ all -> 0x0071 }
        L_0x0067:
            return r1
        L_0x0068:
            r12 = move-exception
            r0 = r2
        L_0x006a:
            if (r0 != 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r0.close()     // Catch:{ all -> 0x0071 }
        L_0x0070:
            throw r12     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    public static final Bundle getBridgeArgumentsFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(intent, SDKConstants.PARAM_INTENT);
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return null;
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final UUID getCallIdFromIntent(Intent intent) {
        String str;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                if (bundleExtra != null) {
                    str = bundleExtra.getString("action_id");
                } else {
                    str = null;
                }
            } else {
                str = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (str == null) {
                return null;
            }
            try {
                return UUID.fromString(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Bundle getErrorDataFromResultIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(intent, "resultIntent");
            if (!isErrorResult(intent)) {
                return null;
            }
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent != null) {
                return bridgeArgumentsFromIntent.getBundle("error");
            }
            return intent.getExtras();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final FacebookException getExceptionFromErrorData(Bundle bundle) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString(STATUS_ERROR_TYPE);
            }
            String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
            }
            if (string == null || !r.t(string, ERROR_USER_CANCELED, true)) {
                return new FacebookException(string2);
            }
            return new FacebookOperationCanceledException(string2);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(str, "action");
            j.g(iArr, "versionSpec");
            List list = actionToAppInfoMap.get(str);
            if (list == null) {
                list = q.j();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list, iArr);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : list) {
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final int getLatestAvailableProtocolVersionForService(int i10) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i10}).getProtocolVersion();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    public static final int getLatestKnownVersion() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(intent, SDKConstants.PARAM_INTENT);
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final int getProtocolVersionFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            j.g(intent, SDKConstants.PARAM_INTENT);
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    public static final Bundle getSuccessResultsFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(intent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
            Bundle extras = intent.getExtras();
            if (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent)) {
                return extras;
            }
            if (extras == null) {
                return extras;
            }
            return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final boolean isErrorResult(Intent intent) {
        Boolean bool;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            j.g(intent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(bridgeArgumentsFromIntent.containsKey("error"));
            }
            if (bool == null) {
                return intent.hasExtra(STATUS_ERROR_TYPE);
            }
            return bool.booleanValue();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int i10) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return l.v(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i10)) && i10 >= 20140701;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final void setupProtocolRequestIntent(Intent intent, String str, String str2, int i10, Bundle bundle) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(intent, SDKConstants.PARAM_INTENT);
                String applicationId = FacebookSdk.getApplicationId();
                String applicationName = FacebookSdk.getApplicationName();
                intent.putExtra(EXTRA_PROTOCOL_VERSION, i10).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
                if (isVersionCompatibleWithBucketedIntent(i10)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("action_id", str);
                    Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
                    intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
                    return;
                }
                intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
                if (!Utility.isNullOrEmpty(applicationName)) {
                    intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
                }
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                    FacebookSdk.getExecutor().execute(new p());
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1  reason: not valid java name */
    public static final void m126updateAllAvailableProtocolVersionsAsync$lambda1() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                for (NativeAppInfo fetchAvailableVersions : facebookAppInfoList) {
                    fetchAvailableVersions.fetchAvailableVersions(true);
                }
                protocolVersionsAsyncUpdating.set(false);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveActivity.activityInfo.packageName;
            j.f(str, "resolveInfo.activityInfo.packageName");
            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveService.serviceInfo.packageName;
            j.f(str, "resolveInfo.serviceInfo.packageName");
            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                return null;
            }
            return intent;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }
}
