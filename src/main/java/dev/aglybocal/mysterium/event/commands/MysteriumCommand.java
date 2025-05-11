package dev.aglybocal.mysterium.event.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import dev.aglybocal.mysterium.component.MysteriumComponent;
import dev.aglybocal.mysterium.component.MysteriumDataComponent;
import dev.aglybocal.mysterium.util.MysteriumTags;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;


public class MysteriumCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal("mysterium").requires(r -> r.hasPermission(2));

    public static LiteralArgumentBuilder<CommandSourceStack> build() {

        builder.then(Commands.literal("apply")
                .executes(context -> applyMysterium(context)));

        return builder;
    }

    public static int applyMysterium(CommandContext<CommandSourceStack> context) {

        Entity entity = context.getSource().getEntity();
        if (entity instanceof LivingEntity living) {

            ItemStack held = living.getMainHandItem();

            if (held.isEmpty()) {
                return sendErrorMessage(context, "The target entity must have an item in their main hand", -1);
            }

            if (!held.is(MysteriumTags.Items.MYSTERIUM_ITEMS)) {
                return sendErrorMessage(context, "The target item is not a mysterium", -2);
            }

            held.set(MysteriumDataComponent.MYSTERIUM_SLOTS.get(), MysteriumComponent.random());

            return 0;
        } else {
            return sendErrorMessage(context, "The command /mysterium must be executed by a living entity", -3);
        }
    }

    public static int sendErrorMessage(CommandContext<CommandSourceStack> context, String message, int code) {
        context.getSource().sendFailure(Component.translatable(message));
        return code;
    }

}
