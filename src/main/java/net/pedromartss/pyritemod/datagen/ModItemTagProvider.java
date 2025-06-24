package net.pedromartss.pyritemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.item.ModItems;
import net.pedromartss.pyritemod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, PyriteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.PYRITE.get())
                .add(ModItems.RAW_PYRITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.PYRITE_HELMET.get())
                .add(ModItems.PYRITE_CHESTPLATE.get())
                .add(ModItems.PYRITE_LEGGINGS.get())
                .add(ModItems.PYRITE_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.PYRITE.get());

        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.PEDROMARTSS_SMITHING_TEMPLATE.get());
    }
}
