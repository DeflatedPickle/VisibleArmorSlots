package sidben.visiblearmorslots.handler;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sidben.visiblearmorslots.reference.Reference;


public class ConfigurationHandler
{
    public static final int     GUI_SLOTS_XOFFSET    = -22;

    public static final int     HOPPER_YOFFSET       = -33;
    public static final int     BEACON_YOFFSET       = 53;
    public static final int     CHEST_SINGLE_YOFFSET = 1;
    public static final int     CHEST_DOUBLE_YOFFSET = 55;


    public static final String  CATEGORY_DEBUG       = "debug";

    public static boolean       overrideEnchantTable = true;
    public static boolean       overrideAnvil        = true;

    // Instance
    public static Configuration config;



    public static void init(File configFile)
    {

        // Create configuration object from config file
        if (config == null) {
            config = new Configuration(configFile);
            loadConfig();
        }

    }



    private static void loadConfig()
    {

        // Load properties - debug
        overrideEnchantTable = config.getBoolean("enabled_on_enchanting", Configuration.CATEGORY_GENERAL, true, "");
        overrideAnvil = config.getBoolean("enabled_on_anvil", Configuration.CATEGORY_GENERAL, true, "");

        // saving the configuration to its file
        if (config.hasChanged()) {
            config.save();
        }
    }



    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equalsIgnoreCase(Reference.ModID)) {
            // Resync config
            loadConfig();
        }
    }

}
