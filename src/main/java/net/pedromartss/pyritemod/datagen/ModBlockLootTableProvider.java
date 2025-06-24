package net.pedromartss.pyritemod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.pedromartss.pyritemod.block.ModBlocks;
import net.pedromartss.pyritemod.block.custom.PeachCropBlock;
import net.pedromartss.pyritemod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PYRITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_PYRITE_BLOCK.get());
        // dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.PYRITE_ORE.get(),
                block -> createOreDrop(ModBlocks.PYRITE_ORE.get(), ModItems.RAW_PYRITE.get()));
        this.add(ModBlocks.PYRITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PYRITE_DEEPSLATE_ORE.get(), ModItems.RAW_PYRITE.get(), 2, 6));

        this.add(ModBlocks.PYRITE_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PYRITE_END_ORE.get(), ModItems.RAW_PYRITE.get(), 4, 8));
        this.add(ModBlocks.PYRITE_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.PYRITE_NETHER_ORE.get(), ModItems.RAW_PYRITE.get(), 1, 6));


        dropSelf(ModBlocks.PYRITE_STAIRS.get());
        this.add(ModBlocks.PYRITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PYRITE_SLAB.get()));

        dropSelf(ModBlocks.PYRITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PYRITE_BUTTON.get());
        dropSelf(ModBlocks.PYRITE_FENCE.get());
        dropSelf(ModBlocks.PYRITE_FENCE_GATE.get());
        dropSelf(ModBlocks.PYRITE_WALL.get());
        dropSelf(ModBlocks.PYRITE_TRAPDOOR.get());

        this.add(ModBlocks.PYRITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.PYRITE_DOOR.get()));

        dropSelf(ModBlocks.PYRITE_LAMP.get());

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.PEACH_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeachCropBlock.AGE, PeachCropBlock.MAX_AGE));

        this.add(ModBlocks.PEACH_CROP.get(), this.createCropDrops(ModBlocks.PEACH_CROP.get(),
                ModItems.PEACH.get(), ModItems.PEACH_SEEDS.get(), lootItemConditionBuilder));


        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.GOLDEN_RASPBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOLDEN_RASPBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.GOLDEN_RASPBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOLDEN_RASPBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.GOLDEN_RASPBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
