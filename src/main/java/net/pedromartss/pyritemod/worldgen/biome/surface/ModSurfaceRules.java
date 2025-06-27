package net.pedromartss.pyritemod.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules

{
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK),
                DIRT
        );

        // Camada de pedra logo abaixo da terra
        SurfaceRules.RuleSource stoneLayer = makeStateRule(Blocks.STONE);

        // Camada mista de gravel, diorite e granite mais abaixo
        SurfaceRules.RuleSource gravelLayer = makeStateRule(Blocks.GRAVEL);
        SurfaceRules.RuleSource dioriteLayer = makeStateRule(Blocks.DIORITE);
        SurfaceRules.RuleSource graniteLayer = makeStateRule(Blocks.GRANITE);

        // Sequência para camadas abaixo da terra
        SurfaceRules.RuleSource undergroundLayers = SurfaceRules.sequence(
                // Primeiro pedra
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, stoneLayer),
                // Depois mistura de gravel, diorite e granite (pode alternar ou randomizar se quiser)
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, gravelLayer),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, dioriteLayer),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, graniteLayer)
        );

        return SurfaceRules.sequence(
                // Mata Atlântica: se for o bioma ATLANTIC_FOREST, usa grama e terra
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(net.pedromartss.pyritemod.worldgen.biome.ModBiomes.ATLANTIC_FOREST),
                        SurfaceRules.sequence(
                                grassSurface,
                                undergroundLayers
                        )
                ),
                // Default para outros biomas: grama e terra
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface),
                undergroundLayers
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
