package siftscience.android;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Looper;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.core.content.a;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.d;
import com.google.android.gms.location.h;
import com.google.android.gms.location.j;
import com.google.android.gms.location.k;
import com.google.android.gms.location.m;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sift.api.representations.AndroidAppStateJson;
import com.sift.api.representations.AndroidDeviceLocationJson;
import com.sift.api.representations.MobileEventJson;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AppStateCollector {
    /* access modifiers changed from: private */
    public static final String TAG = "AppStateCollector";
    /* access modifiers changed from: private */
    public boolean acquiredNewLocation;
    private String activityClassName;
    private final Context context;
    /* access modifiers changed from: private */
    public Location lastLocation;
    /* access modifiers changed from: private */
    public Location location;
    /* access modifiers changed from: private */
    public LocationRequest locationRequest;
    /* access modifiers changed from: private */
    public d mFusedLocationClient;
    /* access modifiers changed from: private */
    public h mLocationCallback;
    private LocationSettingsRequest mLocationSettingsRequest;
    /* access modifiers changed from: private */
    public boolean mRequestingLocationUpdates = false;
    private m mSettingsClient;
    /* access modifiers changed from: private */
    public final SiftImpl sift;

    public AppStateCollector(SiftImpl siftImpl, Context context2) {
        this.sift = siftImpl;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.acquiredNewLocation = false;
        if (!siftImpl.getConfig().disallowLocationCollection) {
            this.mFusedLocationClient = j.a(applicationContext);
            this.mSettingsClient = j.b(applicationContext);
            createLocationCallback();
            createLocationRequest();
            buildLocationSettingsRequest();
        }
    }

    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.a aVar = new LocationSettingsRequest.a();
        aVar.a(this.locationRequest);
        this.mLocationSettingsRequest = aVar.b();
    }

    private boolean checkPermissions() {
        if (a.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 && a.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private void createLocationCallback() {
        this.mLocationCallback = new h() {
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                if (locationResult != null) {
                    String unused = AppStateCollector.TAG;
                    boolean unused2 = AppStateCollector.this.acquiredNewLocation = true;
                    Location unused3 = AppStateCollector.this.location = locationResult.S();
                    AppStateCollector.this.doCollect();
                    try {
                        if (!AppStateCollector.this.sift.getConfig().disallowLocationCollection && AppStateCollector.this.mFusedLocationClient != null) {
                            AppStateCollector.this.disconnectLocationServices();
                        }
                    } catch (Exception unused4) {
                        String unused5 = AppStateCollector.TAG;
                    }
                }
            }
        };
    }

    private void createLocationRequest() {
        this.locationRequest = LocationRequest.S().h1(100).c1(TimeUnit.MINUTES.toMillis(1)).W0(TimeUnit.SECONDS.toMillis(10));
    }

    /* access modifiers changed from: private */
    public void doCollect() {
        this.sift.appendAppStateEvent(new MobileEventJson().withAndroidAppState(get()).withInstallationId(Settings.Secure.getString(this.context.getContentResolver(), "android_id")).withTime(Long.valueOf(Time.now())));
    }

    private AndroidAppStateJson get() {
        int i10;
        int i11;
        int i12;
        int i13;
        Intent registerReceiver = this.context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i14 = -1;
        if (registerReceiver != null) {
            i10 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        } else {
            i10 = -1;
        }
        if (registerReceiver != null) {
            i11 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i11 = -1;
        }
        double d10 = -1.0d;
        if (!(i10 == -1 || i11 == -1)) {
            d10 = ((double) i10) / ((double) i11);
        }
        if (registerReceiver != null) {
            i12 = registerReceiver.getIntExtra("status", -1);
        } else {
            i12 = -1;
        }
        if (registerReceiver != null) {
            i13 = registerReceiver.getIntExtra("plugged", -1);
        } else {
            i13 = -1;
        }
        if (registerReceiver != null) {
            i14 = registerReceiver.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, -1);
        }
        AndroidAppStateJson withSdkVersion = new AndroidAppStateJson().withActivityClassName(this.activityClassName).withBatteryLevel(Double.valueOf(d10)).withBatteryState(Long.valueOf((long) i12)).withBatteryHealth(Long.valueOf((long) i14)).withPlugState(Long.valueOf((long) i13)).withNetworkAddresses(getIpAddresses()).withSdkVersion(BuildConfig.VERSION_NAME);
        if (hasLocation()) {
            withSdkVersion.withLocation(getLocation());
        }
        return withSdkVersion;
    }

    private List<String> getIpAddresses() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        String lowerCase = nextElement.getHostAddress().toLowerCase(Locale.US);
                        if (lowerCase.indexOf(37) > -1) {
                            lowerCase = lowerCase.substring(0, lowerCase.indexOf(37));
                        }
                        arrayList.add(lowerCase);
                    }
                }
            }
        } catch (SocketException e10) {
            e10.toString();
        }
        return arrayList;
    }

    private AndroidDeviceLocationJson getLocation() {
        String str;
        Location location2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Using ");
        if (this.acquiredNewLocation) {
            str = "new location";
        } else {
            str = "last location";
        }
        sb2.append(str);
        if (this.acquiredNewLocation) {
            location2 = this.location;
        } else {
            location2 = this.lastLocation;
        }
        return new AndroidDeviceLocationJson().withLatitude(Double.valueOf(location2.getLatitude())).withLongitude(Double.valueOf(location2.getLongitude()));
    }

    private boolean hasLocation() {
        return (this.location == null && this.lastLocation == null) ? false : true;
    }

    @SuppressLint({"MissingPermission"})
    private void startLocationUpdates() {
        if (checkPermissions()) {
            this.mFusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    String unused = AppStateCollector.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Got last known location: ");
                    sb2.append(location);
                    if (location != null) {
                        Location unused2 = AppStateCollector.this.lastLocation = location;
                    }
                }
            });
            this.mRequestingLocationUpdates = true;
            this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest).addOnSuccessListener(new OnSuccessListener<k>() {
                @SuppressLint({"MissingPermission"})
                public void onSuccess(k kVar) {
                    String unused = AppStateCollector.TAG;
                    AppStateCollector.this.mFusedLocationClient.requestLocationUpdates(AppStateCollector.this.locationRequest, AppStateCollector.this.mLocationCallback, Looper.myLooper());
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(@NonNull Exception exc) {
                    if (exc instanceof ApiException) {
                        int statusCode = ((ApiException) exc).getStatusCode();
                        if (statusCode == 6) {
                            String unused = AppStateCollector.TAG;
                        } else if (statusCode == 8502) {
                            String unused2 = AppStateCollector.TAG;
                            boolean unused3 = AppStateCollector.this.mRequestingLocationUpdates = false;
                        }
                    } else {
                        String unused4 = AppStateCollector.TAG;
                        boolean unused5 = AppStateCollector.this.mRequestingLocationUpdates = false;
                    }
                }
            });
            return;
        }
        doCollect();
    }

    public void collect() {
        if (this.sift.getConfig().disallowLocationCollection || this.mFusedLocationClient == null || this.mRequestingLocationUpdates) {
            doCollect();
        } else {
            startLocationUpdates();
        }
    }

    public void disconnectLocationServices() {
        try {
            if (!this.sift.getConfig().disallowLocationCollection && this.mFusedLocationClient != null && this.mRequestingLocationUpdates) {
                this.mFusedLocationClient.removeLocationUpdates(this.mLocationCallback).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        boolean unused = AppStateCollector.this.mRequestingLocationUpdates = false;
                    }
                });
            }
        } catch (Exception e10) {
            e10.toString();
        }
    }

    public void reconnectLocationServices() {
        try {
            if (!this.sift.getConfig().disallowLocationCollection && this.mFusedLocationClient != null && !this.mRequestingLocationUpdates) {
                startLocationUpdates();
            }
        } catch (Exception e10) {
            e10.toString();
        }
    }

    public void setActivityName(String str) {
        this.activityClassName = str;
    }
}
