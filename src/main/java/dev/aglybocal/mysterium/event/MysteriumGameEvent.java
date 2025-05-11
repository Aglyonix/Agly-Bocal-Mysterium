package dev.aglybocal.mysterium.event;

import dev.aglybocal.mysterium.Mysterium;
import dev.aglybocal.mysterium.component.MysteriumComponent;
import dev.aglybocal.mysterium.component.MysteriumDataComponent;
import dev.aglybocal.mysterium.util.MysteriumTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = Mysterium.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.DEDICATED_SERVER)
public class MysteriumGameEvent {

    @SubscribeEvent
    public static void onModifyComponents(ModifyDefaultComponentsEvent event) {

        BuiltInRegistries.ITEM.getTagOrEmpty(MysteriumTags.Items.MYSTERIUM_ITEMS).forEach(holder -> {
            event.modify(holder.value(), builder -> {
                builder.set(MysteriumDataComponent.MYSTERIUM_SLOTS.get(), MysteriumComponent.DEFAULT);
            });
        });
    }
}
