package dev.aglybocal.mysterium.event.commands;

import dev.aglybocal.mysterium.Mysterium;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber(modid = Mysterium.MODID)
public class MysteriumCommandEvent {

    @SubscribeEvent
    public static void onRegisterCommand(RegisterCommandsEvent event) {

        event.getDispatcher().register(MysteriumCommand.build());

    }

}
