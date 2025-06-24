package net.pedromartss.pyritemod.trim;

import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

    public class ModTrimMaterials {
        public static final ResourceKey<TrimMaterial> PYRITE =
                ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "pyrite"));

        public static void bootstrap(BootstrapContext<TrimMaterial> context) {
            register(context, PYRITE, ModItems.PYRITE.get(), Style.EMPTY.withColor(TextColor.parseColor("#f0fc03").getOrThrow()), 0.8F);
        }

        private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                     Style style, float itemModelIndex) {
            TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                    Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
            context.register(trimKey, trimmaterial);
        }
}
