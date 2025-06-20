package net.pedromartss.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pedromartss.tutorialmod.TutorialMod;
import net.pedromartss.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PYRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("pyrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PYRITE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.pyrite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PYRITE.get());
                        output.accept(ModItems.RAW_PYRITE.get());

                        output.accept(ModItems.CHISEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> PYRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("pyrite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PYRITE_BLOCK.get()))
                    .withTabsBefore(PYRITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.pyrite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PYRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_PYRITE_BLOCK.get());

                        output.accept(ModBlocks.PYRITE_ORE.get());
                        output.accept(ModBlocks.PYRITE_DEEPSLATE_ORE.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
