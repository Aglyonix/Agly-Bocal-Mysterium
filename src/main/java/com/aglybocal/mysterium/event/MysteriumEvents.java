package com.aglybocal.mysterium.event;

import com.aglybocal.mysterium.Mysterium;
import com.aglybocal.mysterium.component.MysteriumComponent;
import com.aglybocal.mysterium.component.MysteriumDataComponent;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = Mysterium.MODID)
public class MysteriumEvents {

    @SubscribeEvent
    public void onModifyComponents(ModifyDefaultComponentsEvent event) {
        event.modify(Items.WOODEN_SWORD, builder ->
                builder.set(MysteriumDataComponent.RANDOM_VALUE.get(), MysteriumComponent.random())
        );
    }
}
