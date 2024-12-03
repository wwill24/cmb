package com.mparticle.kits;

import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.internal.Logger;
import com.mparticle.internal.SideloadedKit;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

public class KitIntegrationFactory {
    private Map<Integer, String> knownIntegrations = new HashMap();
    private Map<Integer, MPSideloadedKit> sideloadedKitMap = new HashMap();
    final Map<Integer, Class> supportedKits;

    public KitIntegrationFactory(MParticleOptions mParticleOptions) {
        HashMap hashMap = new HashMap();
        this.supportedKits = hashMap;
        hashMap.clear();
        this.knownIntegrations.clear();
        setupKnownIntegrations();
        loadIntegrations(mParticleOptions);
    }

    private void loadIntegrations(MParticleOptions mParticleOptions) {
        loadSideloadedIntegrations(mParticleOptions);
        for (Map.Entry next : this.knownIntegrations.entrySet()) {
            Class loadKit = loadKit((String) next.getValue());
            if (loadKit != null) {
                this.supportedKits.put((Integer) next.getKey(), loadKit);
                Logger.debug(((String) next.getValue()).substring(((String) next.getValue()).lastIndexOf(".") + 1) + " detected.");
            }
        }
    }

    private Class loadKit(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            Logger.verbose("Kit not bundled: ", str);
            return null;
        }
    }

    private void loadSideloadedIntegrations(MParticleOptions mParticleOptions) {
        this.sideloadedKitMap.clear();
        for (SideloadedKit next : mParticleOptions.getSideloadedKits()) {
            if (next instanceof MPSideloadedKit) {
                MPSideloadedKit mPSideloadedKit = (MPSideloadedKit) next;
                if (!this.supportedKits.containsKey(Integer.valueOf(mPSideloadedKit.getConfiguration().getKitId()))) {
                    int kitId = mPSideloadedKit.getConfiguration().getKitId();
                    this.supportedKits.put(Integer.valueOf(kitId), next.getClass());
                    MPSideloadedKit mPSideloadedKit2 = (MPSideloadedKit) next;
                    this.sideloadedKitMap.put(Integer.valueOf(kitId), mPSideloadedKit2);
                    Logger.debug(mPSideloadedKit2.getName() + " detected with kit id " + kitId);
                }
            }
        }
    }

    private void setupKnownIntegrations() {
        this.knownIntegrations.put(68, "com.mparticle.kits.AdjustKit");
        this.knownIntegrations.put(28, "com.mparticle.kits.AppboyKit");
        this.knownIntegrations.put(80, "com.mparticle.kits.BranchMetricsKit");
        this.knownIntegrations.put(39, "com.mparticle.kits.ComscoreKit");
        this.knownIntegrations.put(37, "com.mparticle.kits.KochavaKit");
        this.knownIntegrations.put(64, "com.mparticle.kits.ForeseeKit");
        this.knownIntegrations.put(84, "com.mparticle.kits.LocalyticsKit");
        this.knownIntegrations.put(83, "com.mparticle.kits.FlurryKit");
        this.knownIntegrations.put(90, "com.mparticle.kits.WootricKit");
        this.knownIntegrations.put(86, "com.mparticle.kits.CrittercismKit");
        this.knownIntegrations.put(32, "com.mparticle.kits.TuneKit");
        this.knownIntegrations.put(92, "com.mparticle.kits.AppsFlyerKit");
        this.knownIntegrations.put(97, "com.mparticle.kits.ApptentiveKit");
        this.knownIntegrations.put(Integer.valueOf(MParticle.ServiceProviders.BUTTON), "com.mparticle.kits.ButtonKit");
        this.knownIntegrations.put(25, "com.mparticle.kits.UrbanAirshipKit");
        this.knownIntegrations.put(98, "com.mparticle.kits.LeanplumKit");
        this.knownIntegrations.put(105, "com.mparticle.kits.ApptimizeKit");
        this.knownIntegrations.put(112, "com.mparticle.kits.RevealMobileKit");
        this.knownIntegrations.put(117, "com.mparticle.kits.RadarKit");
        this.knownIntegrations.put(1003, "com.mparticle.kits.IterableKit");
        this.knownIntegrations.put(121, "com.mparticle.kits.SkyhookKit");
        this.knownIntegrations.put(119, "com.mparticle.kits.SingularKit");
        this.knownIntegrations.put(124, "com.mparticle.kits.AdobeKit");
        this.knownIntegrations.put(129, "com.mparticle.kits.TaplyticsKit");
        this.knownIntegrations.put(54, "com.mparticle.kits.OptimizelyKit");
        this.knownIntegrations.put(102, "com.mparticle.kits.ResponsysKit");
        this.knownIntegrations.put(135, "com.mparticle.kits.CleverTapKit");
        this.knownIntegrations.put(136, "com.mparticle.kits.GoogleAnalyticsFirebaseKit");
        this.knownIntegrations.put(160, "com.mparticle.kits.GoogleAnalyticsFirebaseGA4Kit");
        this.knownIntegrations.put(211, "com.mparticle.kits.PilgrimKit");
        this.knownIntegrations.put(134, "com.mparticle.kits.OneTrustKit");
        this.knownIntegrations.put(Integer.valueOf(MParticle.ServiceProviders.SWRVE), "com.mparticle.kits.SwrveKit");
        this.knownIntegrations.put(Integer.valueOf(MParticle.ServiceProviders.BLUESHIFT), "com.mparticle.kits.BlueshiftKit");
        this.knownIntegrations.put(147, "com.mparticle.kits.NeuraKit");
    }

    public void addSupportedKit(int i10, Class<? extends KitIntegration> cls) {
        Class cls2 = this.supportedKits.get(Integer.valueOf(i10));
        if (cls2 != null) {
            Logger.warning("Overriding kitId " + i10 + ". KitIntegration: " + cls.getName() + " will replace existing KitIntegration: " + cls2.getName());
        }
        this.supportedKits.put(Integer.valueOf(i10), cls);
    }

    public KitIntegration createInstance(KitManagerImpl kitManagerImpl, KitConfiguration kitConfiguration) throws JSONException, ClassNotFoundException {
        KitIntegration kitIntegration;
        if (kitConfiguration.getKitId() >= 1000000) {
            kitIntegration = this.sideloadedKitMap.get(Integer.valueOf(kitConfiguration.getKitId()));
            if (kitIntegration != null && kitIntegration.getKitManager() == null) {
                kitIntegration.setKitManager(kitManagerImpl);
            }
        } else {
            kitIntegration = createInstance(kitManagerImpl, kitConfiguration.getKitId());
        }
        if (kitIntegration != null) {
            kitIntegration.setConfiguration(kitConfiguration);
        }
        return kitIntegration;
    }

    public Set<Integer> getSupportedKits() {
        return this.supportedKits.keySet();
    }

    public boolean isSupported(int i10) {
        return this.supportedKits.containsKey(Integer.valueOf(i10)) || i10 >= 1000000;
    }

    public KitIntegration createInstance(KitManagerImpl kitManagerImpl, int i10) throws JSONException, ClassNotFoundException {
        if (this.supportedKits.isEmpty()) {
            return null;
        }
        try {
            Constructor constructor = this.supportedKits.get(Integer.valueOf(i10)).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return ((KitIntegration) constructor.newInstance(new Object[0])).setKitManager(kitManagerImpl);
        } catch (Exception e10) {
            Logger.debug(e10, "Failed to create Kit with ID: " + i10);
            return null;
        }
    }
}
