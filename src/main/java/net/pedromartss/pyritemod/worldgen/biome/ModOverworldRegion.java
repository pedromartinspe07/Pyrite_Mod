package net.pedromartss.pyritemod.worldgen.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.FOREST, ModBiomes.ATLANTIC_FOREST);

            // VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

            // Parâmetros para Mata Atlântica: quente/morno, úmido/chuvoso, costeiro/interior, erosão variada, superfície, weirdness normal
            //new ParameterUtils.ParameterPointListBuilder()
            //.temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.WARM, ParameterUtils.Temperature.HOT))
            //.humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID))
            //.continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.COAST, ParameterUtils.Continentalness.INLAND))
            //.erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1, ParameterUtils.Erosion.EROSION_2)
            //.depth(ParameterUtils.Depth.SURFACE)
            //.weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
            //.build().forEach(point -> builder.add(point, ModBiomes.ATLANTIC_FOREST));

            // Adiciona os pontos ao mapper
                //builder.build().forEach(mapper::accept);
        });
            }
        }