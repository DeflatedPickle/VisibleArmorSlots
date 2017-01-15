package sidben.visiblearmorslots.proxy;

import net.minecraftforge.common.MinecraftForge;
import sidben.visiblearmorslots.handler.GuiEventHandler;


public class ClientProxy extends CommonProxy
{

    @Override
    public void initialize()
    {
        super.initialize();

        // Event Handlers
        MinecraftForge.EVENT_BUS.register(new GuiEventHandler());
    }

}
