package net.pedromartss.pyritemod.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.pedromartss.pyritemod.PyriteMod;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(ResourceLocation.tryParse(PyriteMod.MOD_ID + ":overworld"), 5));
    }
}
