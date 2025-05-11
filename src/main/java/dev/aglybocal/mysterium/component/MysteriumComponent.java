package dev.aglybocal.mysterium.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record MysteriumComponent(boolean unlocked, String mysterium, int tier) {

    public static final MysteriumComponent DEFAULT = new MysteriumComponent(false, "none", 0);

    public static final Codec<MysteriumComponent> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                    Codec.BOOL.fieldOf("unlocked").forGetter(MysteriumComponent::unlocked),
                    Codec.STRING.fieldOf("mysterium").forGetter(MysteriumComponent::mysterium),
                    Codec.INT.fieldOf("tier").forGetter(MysteriumComponent::tier)
            ).apply(builder, MysteriumComponent::new));

    public static final StreamCodec<ByteBuf, MysteriumComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, MysteriumComponent::unlocked,
            ByteBufCodecs.STRING_UTF8, MysteriumComponent::mysterium,
            ByteBufCodecs.INT, MysteriumComponent::tier,
            MysteriumComponent::new
    );

}
