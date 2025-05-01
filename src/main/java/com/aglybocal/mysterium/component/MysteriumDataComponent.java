package com.aglybocal.mysterium.component;

import com.aglybocal.mysterium.Mysterium;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class MysteriumDataComponent {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Mysterium.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MysteriumComponent>> RANDOM_VALUE = DATA_COMPONENT_TYPES.register("random_value", () ->
            DataComponentType.<MysteriumComponent>builder()
                    .persistent(Codec.INT.xmap(MysteriumComponent::new, MysteriumComponent::value))
                    .networkSynchronized(MysteriumComponent.STREAM_CODEC)
                    .build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
