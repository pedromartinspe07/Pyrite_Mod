package net.pedromartss.pyritemod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BRAZILWOOD = new TreeGrower(PyriteMod.MOD_ID + ":brazilwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BRAZILWOOD_KEY), Optional.empty());
}
