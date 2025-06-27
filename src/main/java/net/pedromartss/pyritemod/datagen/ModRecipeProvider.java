package net.pedromartss.pyritemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.block.ModBlocks;
import net.pedromartss.pyritemod.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> PYRITE_SMELTABLES = List.of(ModItems.RAW_PYRITE.get(),
                 ModBlocks.PYRITE_ORE.get(), ModBlocks.PYRITE_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PYRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.PYRITE.get())
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PYRITE.get(), 9)
                .requires(ModBlocks.PYRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PYRITE_BLOCK.get()), has(ModBlocks.PYRITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PYRITE.get(), 32)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PYRITE_BLOCK.get()), has(ModBlocks.PYRITE_BLOCK.get()))
                .save(pRecipeOutput, PyriteMod.MOD_ID + ":pyrite_from_magic_block");

        oreSmelting(pRecipeOutput, PYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRITE.get(), 0.25f, 200, "pyrite");
        oreBlasting(pRecipeOutput, PYRITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRITE.get(), 0.25f, 100, "pyrite");

        stairBuilder(ModBlocks.PYRITE_STAIRS.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYRITE_SLAB.get(), ModItems.PYRITE.get());

        buttonBuilder(ModBlocks.PYRITE_BUTTON.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.PYRITE_PRESSURE_PLATE.get(), ModItems.PYRITE.get());

        fenceBuilder(ModBlocks.PYRITE_FENCE.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.PYRITE_FENCE_GATE.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYRITE_WALL.get(), ModBlocks.PYRITE_BLOCK.get());

        doorBuilder(ModBlocks.PYRITE_DOOR.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.PYRITE_TRAPDOOR.get(), Ingredient.of(ModItems.PYRITE.get())).group("pyrite")
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get())).save(pRecipeOutput);

        trimSmithing(pRecipeOutput, ModItems.PEDROMARTSS_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "pedromartss"));
        
        netheriteSmithing(pRecipeOutput, ModItems.SMITHING_TEMPLATE_NETHERITE.get(), ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "smithing_template_netherite"));
        
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.PYRITE_LAMP.get())
            .pattern(" R ")
            .pattern("RPR")
            .pattern(" R ")
            .define('R', net.minecraft.world.item.Items.REDSTONE)
            .define('P', ModBlocks.PYRITE_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.PYRITE_BLOCK.get()), has(ModBlocks.PYRITE_BLOCK.get()))
            .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_SWORD.get())
                .pattern("P")
                .pattern("P")
                .pattern("S")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_PICKAXE.get())
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_AXE.get())
                .pattern("PP")
                .pattern("PS")
                .pattern(" S")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_SHOVEL.get())
                .pattern("P")
                .pattern("S")
                .pattern("S")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_HOE.get())
                .pattern("PP")
                .pattern(" S")
                .pattern(" S")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_HAMMER.get())
                .pattern("PBP")
                .pattern("PSP")
                .pattern(" S ")
                .define('P', ModItems.PYRITE.get())
                .define('B', ModBlocks.PYRITE_BLOCK.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SMITHING_TEMPLATE_NETHERITE.get())
                .pattern("RPR")
                .pattern("RNR")
                .pattern("RRR")
                .define('N', net.minecraft.world.item.Items.NETHERITE_INGOT)
                .define('P', ModItems.RAW_PYRITE.get())
                .define('R', net.minecraft.world.level.block.Blocks.NETHERRACK)
                .unlockedBy(getHasName(ModItems.RAW_PYRITE.get()), has(ModItems.RAW_PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                .pattern("P")
                .pattern("S")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.PUDDING.get())
                .pattern("HHH")
                .pattern("SES")
                .pattern("MMM")
                .define('E', net.minecraft.world.item.Items.EGG)
                .define('S', net.minecraft.world.item.Items.SUGAR)
                .define('M', net.minecraft.world.item.Items.MILK_BUCKET)
                .define('H', net.minecraft.world.item.Items.HONEY_BOTTLE)
                .unlockedBy(getHasName(ModItems.PUDDING.get()), has(ModItems.PUDDING.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRITE_BOW.get())
                .pattern(" PS")
                .pattern("B S")
                .pattern(" PS")
                .define('P', ModItems.PYRITE.get())
                .define('S', net.minecraft.world.item.Items.STRING)
                .define('B', net.minecraft.world.item.Items.STICK)
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRAZILWOOD_PLANKS.get(), 4)
                .requires(ModBlocks.BRAZILWOOD_LOG.get())
                .unlockedBy(getHasName(ModBlocks.BRAZILWOOD_LOG.get()), has(ModBlocks.BRAZILWOOD_LOG.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AURORA_ASHES.get())
                .pattern(" P ")
                .pattern("P P")
                .pattern(" P ")
                .define('P', ModItems.PYRITE.get())
                .unlockedBy(getHasName(ModItems.PYRITE.get()), has(ModItems.PYRITE.get()))
                .save(pRecipeOutput);
    }

    private void netheriteSmithing(RecipeOutput pRecipeOutput, @NotNull Item item, ResourceLocation smithingTemplateNetherite) {
    }

    private void wall(RecipeOutput pRecipeOutput, RecipeCategory recipeCategory, @NotNull WallBlock wallBlock, @NotNull ItemLike item) {
        ShapedRecipeBuilder.shaped(recipeCategory, wallBlock, 6)
            .pattern("AAA")
            .pattern("AAA")
            .define('A', item)
            .unlockedBy(getHasName(item), has(item))
            .save(pRecipeOutput);
    }

    private void pressurePlate(RecipeOutput pRecipeOutput, @NotNull PressurePlateBlock pressurePlateBlock, @NotNull Item item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pressurePlateBlock)
            .pattern("AA")
            .define('A', item)
            .unlockedBy(getHasName(item), has(item))
            .save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory,
                                                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, PyriteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
