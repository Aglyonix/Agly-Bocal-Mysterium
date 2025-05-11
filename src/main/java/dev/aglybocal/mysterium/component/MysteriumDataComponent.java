package dev.aglybocal.mysterium.component;

import dev.aglybocal.mysterium.Mysterium;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MysteriumDataComponent {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Mysterium.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MysteriumSlotsComponent>> MYSTERIUM_SLOTS = DATA_COMPONENT_TYPES.register("mysterium_slots", () ->
            DataComponentType.<MysteriumSlotsComponent>builder()
                    .persistent(MysteriumSlotsComponent.CODEC)
                    .networkSynchronized(MysteriumSlotsComponent.STREAM_CODEC)
                    .build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
