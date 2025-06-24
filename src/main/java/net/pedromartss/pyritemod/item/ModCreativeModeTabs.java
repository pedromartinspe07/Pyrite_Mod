package net.pedromartss.pyritemod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PyriteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PYRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("pyrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PYRITE.get()))
                    .title(Component.translatable("creativetab.pyritemod.pyrite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PYRITE.get());
                        output.accept(ModItems.RAW_PYRITE.get());

                        output.accept(ModItems.CHISEL.get());

                        output.accept(ModItems.PUDDING.get());
                        output.accept(ModItems.PEACH.get());
                        output.accept(ModItems.AURORA_ASHES.get());

                        output.accept(ModItems.SMITHING_TEMPLATE_NETHERITE.get());

                        output.accept(ModItems.PYRITE_SWORD.get());
                        output.accept(ModItems.PYRITE_PICKAXE.get());
                        output.accept(ModItems.PYRITE_SHOVEL.get());
                        output.accept(ModItems.PYRITE_AXE.get());
                        output.accept(ModItems.PYRITE_HOE.get());

                        output.accept(ModItems.PYRITE_HAMMER.get());

                        output.accept(ModItems.PYRITE_HELMET.get());
                        output.accept(ModItems.PYRITE_CHESTPLATE.get());
                        output.accept(ModItems.PYRITE_LEGGINGS.get());
                        output.accept(ModItems.PYRITE_BOOTS.get());

                        output.accept(ModItems.PYRITE_HORSE_ARMOR.get());
                        output.accept(ModItems.PEDROMARTSS_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.PYRITE_BOW.get());
                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                        output.accept(ModItems.PEACH_SEEDS.get());
                        output.accept(ModItems.GOLDEN_RASPBERRIES.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> PYRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pyrite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PYRITE_BLOCK.get()))
                    .withTabsBefore(PYRITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.pyritemod.pyrite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PYRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_PYRITE_BLOCK.get());

                        output.accept(ModBlocks.PYRITE_ORE.get());
                        output.accept(ModBlocks.PYRITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.PYRITE_NETHER_ORE.get());
                        output.accept(ModBlocks.PYRITE_END_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                        output.accept(ModBlocks.PYRITE_STAIRS.get());
                        output.accept(ModBlocks.PYRITE_SLAB.get());

                        output.accept(ModBlocks.PYRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.PYRITE_BUTTON.get());

                        output.accept(ModBlocks.PYRITE_FENCE.get());
                        output.accept(ModBlocks.PYRITE_FENCE_GATE.get());
                        output.accept(ModBlocks.PYRITE_WALL.get());

                        output.accept(ModBlocks.PYRITE_DOOR.get());
                        output.accept(ModBlocks.PYRITE_TRAPDOOR.get());

                        output.accept(ModBlocks.PYRITE_LAMP.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
