package com.aglybocal.mysterium.event;

import com.aglybocal.mysterium.Mysterium;
import com.aglybocal.mysterium.component.MysteriumComponent;
import com.aglybocal.mysterium.component.MysteriumDataComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(modid = Mysterium.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class MysteriumToolTips {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if(event.getItemStack().is(Items.WOODEN_SWORD)) {
            int value = event.getItemStack()
                    .getOrDefault(MysteriumDataComponent.RANDOM_VALUE.get(), MysteriumComponent.DEFAULT)
                    .value();

            event.getToolTip().add(Component.literal("Valeur aléatoire : " + value));
        }
    }
}
