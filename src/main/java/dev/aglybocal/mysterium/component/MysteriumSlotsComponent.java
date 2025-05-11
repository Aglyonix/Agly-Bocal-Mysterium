package dev.aglybocal.mysterium.component;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

public record MysteriumSlotsComponent(List<MysteriumComponent> mysteriums) {

    public static final Codec<MysteriumSlotsComponent> CODEC = Codec.list(MysteriumComponent.CODEC).xmap(MysteriumSlotsComponent::new, MysteriumSlotsComponent::mysteriums);

    public static final StreamCodec<ByteBuf, MysteriumSlotsComponent> STREAM_CODEC = MysteriumComponent.STREAM_CODEC
                    .apply(ByteBufCodecs.list(3))
                    .map(MysteriumSlotsComponent::new, MysteriumSlotsComponent::mysteriums);
}
