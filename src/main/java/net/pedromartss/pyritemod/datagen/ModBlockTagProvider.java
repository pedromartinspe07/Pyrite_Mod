package net.pedromartss.pyritemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.block.ModBlocks;
import net.pedromartss.pyritemod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PyriteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.PYRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.PYRITE_NETHER_ORE.get())
                .add(ModBlocks.PYRITE_END_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PYRITE_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_PYRITE_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.PYRITE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.PYRITE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.PYRITE_WALL.get());

        tag(ModTags.Blocks.NEEDS_PYRITE_TOOL)
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PYRITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_PYRITE_TOOL);

            this.tag(BlockTags.LOGS_THAT_BURN)
                    .add(ModBlocks.BRAZILWOOD_LOG.get())
                    .add(ModBlocks.BRAZILWOOD_WOOD.get())
                    .add(ModBlocks.STRIPPED_BRAZILWOOD_LOG.get())
                    .add(ModBlocks.STRIPPED_BRAZILWOOD_WOOD.get());
    }
}
