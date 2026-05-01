package net.tearpelato.deco_lib.platform;

import net.tearpelato.deco_lib.Constants;
import net.tearpelato.deco_lib.platform.services.FluidItemHelper;
import net.tearpelato.deco_lib.platform.services.FluidRenderHelper;
import net.tearpelato.deco_lib.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final FluidRenderHelper FLUID_RENDER_HELPER = load(FluidRenderHelper.class);
    public static final FluidItemHelper FLUID_ITEM_HELPER = load(FluidItemHelper.class);

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
