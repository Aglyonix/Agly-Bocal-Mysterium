package dev.aglybocal.mysterium.event;

import dev.aglybocal.mysterium.Mysterium;
import dev.aglybocal.mysterium.component.MysteriumComponent;
import dev.aglybocal.mysterium.component.MysteriumDataComponent;
import dev.aglybocal.mysterium.util.MysteriumTags;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = Mysterium.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class MysteriumToolTips {

    @SubscribeEvent
    public static void mysteriumTooltip(ItemTooltipEvent event) {

        if(event.getItemStack().is(MysteriumTags.Items.MYSTERIUM_ITEMS)) {
            if(event.getItemStack().has(MysteriumDataComponent.MYSTERIUM_SLOTS.get())) {
                int value = event.getItemStack()
                        .getOrDefault(MysteriumDataComponent.MYSTERIUM_SLOTS.get(), MysteriumComponent.DEFAULT)
                        .value();

                event.getToolTip().add(Component.literal("Valeur aléatoire : " + value));
            }
        }
    }
}
