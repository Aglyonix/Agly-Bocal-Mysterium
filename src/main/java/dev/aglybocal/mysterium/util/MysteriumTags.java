package dev.aglybocal.mysterium.util;

import dev.aglybocal.mysterium.Mysterium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MysteriumTags {

    public static class Items {

        public static final TagKey<Item> MYSTERIUM_ITEMS = createTag("mysterium_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Mysterium.MODID, name));
        }
    }
}
