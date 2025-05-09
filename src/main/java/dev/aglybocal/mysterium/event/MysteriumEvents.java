package dev.aglybocal.mysterium.event;

import dev.aglybocal.mysterium.Mysterium;
import dev.aglybocal.mysterium.component.MysteriumComponent;
import dev.aglybocal.mysterium.component.MysteriumDataComponent;
import dev.aglybocal.mysterium.util.MysteriumTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = Mysterium.MODID)
public class MysteriumEvents {

    @SubscribeEvent
    public static void onCraftedMysteriumItem(PlayerEvent.ItemCraftedEvent event) {
        if(event.getCrafting().is(MysteriumTags.Items.MYSTERIUM_ITEMS)) {
            ItemStack stack = event.getCrafting();
            stack.set(MysteriumDataComponent.RANDOM_VALUE.get(), MysteriumComponent.random());
        }
    }
}
