package net.pedromartss.pyritemod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.pedromartss.pyritemod.util.ModTags;

public class ModToolTiers {
    public static final Tier PYRITE = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_PYRITE_TOOL, () -> Ingredient.of(ModItems.PYRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_PYRITE_TOOL);
}
