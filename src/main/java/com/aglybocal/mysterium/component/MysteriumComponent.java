package com.aglybocal.mysterium.component;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.Random;

public record MysteriumComponent(int value) {
    public static final MysteriumComponent DEFAULT = new MysteriumComponent(0);

    public static final StreamCodec<ByteBuf, MysteriumComponent> STREAM_CODEC = ByteBufCodecs.INT.map(MysteriumComponent::new, MysteriumComponent::value);

    public static MysteriumComponent random() {
        return new MysteriumComponent(new Random().nextInt(11));
    }
}
