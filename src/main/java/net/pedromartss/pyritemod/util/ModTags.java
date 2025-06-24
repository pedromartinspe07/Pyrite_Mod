package net.pedromartss.pyritemod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pedromartss.pyritemod.PyriteMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PYRITE_TOOL = createTag("needs_pyrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_PYRITE_TOOL = createTag("incorrect_for_pyrite_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, name));
        }
    }
}
