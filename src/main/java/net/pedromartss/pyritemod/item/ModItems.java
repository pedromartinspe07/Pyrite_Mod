package net.pedromartss.pyritemod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.pedromartss.pyritemod.PyriteMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pedromartss.pyritemod.block.ModBlocks;
import net.pedromartss.pyritemod.item.custom.ChiselItem;
import net.pedromartss.pyritemod.item.custom.FuelItem;
import net.pedromartss.pyritemod.item.custom.HammerItem;
import net.pedromartss.pyritemod.item.custom.ModArmorItem;
import net.pedromartss.pyritemod.sound.ModSounds;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PyriteMod.MOD_ID);

    public static final RegistryObject<Item> PYRITE = ITEMS.register("pyrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PYRITE = ITEMS.register("raw_pyrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> PUDDING = ITEMS.register("pudding",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PUDDING)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.pyritemod.pudding"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

            public static final RegistryObject<Item> PEACH = ITEMS.register("peach",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PEACH)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.pyritemod.peach"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> SMITHING_TEMPLATE_NETHERITE = ITEMS.register("smithing_template_netherite",
            () -> SmithingTemplateItem.createNetheriteUpgradeTemplate());

    public static final RegistryObject<Item> PYRITE_SWORD = ITEMS.register("pyrite_sword",
            () -> new SwordItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PYRITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRITE_PICKAXE = ITEMS.register("pyrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PYRITE, 1, -2.8f))));
    public static final RegistryObject<Item> PYRITE_SHOVEL = ITEMS.register("pyrite_shovel",
            () -> new ShovelItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PYRITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> PYRITE_AXE = ITEMS.register("pyrite_axe",
            () -> new AxeItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.PYRITE, 6, -3.2f))));
    public static final RegistryObject<Item> PYRITE_HOE = ITEMS.register("pyrite_hoe",
            () -> new HoeItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.PYRITE, 0, -3.0f))));

    public static final RegistryObject<Item> PYRITE_HAMMER = ITEMS.register("pyrite_hammer",
            () -> new HammerItem(ModToolTiers.PYRITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PYRITE, 7, -3.5f))));

    public static final RegistryObject<Item> PYRITE_HELMET = ITEMS.register("pyrite_helmet",
            () -> new ArmorItem(ModArmorMaterials.PYRITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(18))));
    public static final RegistryObject<Item> PYRITE_CHESTPLATE = ITEMS.register("pyrite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.PYRITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(18))));
    public static final RegistryObject<Item> PYRITE_LEGGINGS = ITEMS.register("pyrite_leggings",
            () -> new ArmorItem(ModArmorMaterials.PYRITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(18))));
    public static final RegistryObject<Item> PYRITE_BOOTS = ITEMS.register("pyrite_boots",
            () -> new ArmorItem(ModArmorMaterials.PYRITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(18))));

    public static final RegistryObject<Item> PYRITE_HORSE_ARMOR = ITEMS.register("pyrite_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.PYRITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PEDROMARTSS_SMITHING_TEMPLATE = ITEMS.register("pedromartss_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "pedromartss")));

    public static final RegistryObject<Item> PYRITE_BOW = ITEMS.register("pyrite_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).stacksTo(1)));

    public static final RegistryObject<Item> PEACH_SEEDS = ITEMS.register("peach_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PEACH_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> GOLDEN_RASPBERRIES = ITEMS.register("golden_raspberries",
            () -> new ItemNameBlockItem(ModBlocks.GOLDEN_RASPBERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.GOLDEN_RASPBERRY)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
