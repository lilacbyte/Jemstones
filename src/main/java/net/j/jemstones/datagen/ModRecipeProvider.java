package net.j.jemstones.datagen;

import net.j.jemstones.block.ModBlocks;
import net.j.jemstones.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRAWBERRY_SEEDS.get())
                .requires(ModItems.STRAWBERRY_SLICE.get())
                .unlockedBy("has_strawberry_slice", has(ModItems.STRAWBERRY_SLICE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GIANT_STRAWBERRY.get())
                .pattern("sss").pattern("sss").pattern("sss")
                .define('s', ModItems.STRAWBERRY_SLICE.get())
                .unlockedBy("has_strawberry_slice", has(ModItems.STRAWBERRY_SLICE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE.get(), 8)
                .pattern("sss").pattern("sps").pattern("sss")
                .define('s', Items.SANDSTONE).define('p', Items.PINK_DYE)
                .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE_STAIRS.get(), 8)
                .pattern("s  ").pattern("ss ").pattern("sss")
                .define('s', ModBlocks.PINK_SANDSTONE.get())
                .unlockedBy("has_pink_sandstone", has(ModBlocks.PINK_SANDSTONE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE_SLAB.get(), 6)
                .pattern("sss").define('s', ModBlocks.PINK_SANDSTONE.get())
                .unlockedBy("has_pink_sandstone", has(ModBlocks.PINK_SANDSTONE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_PINK_SANDSTONE.get(), 1)
                .pattern("s").pattern("s").define('s', ModBlocks.PINK_SANDSTONE_SLAB.get())
                .unlockedBy("has_pink_sandstone_slab", has(ModBlocks.PINK_SANDSTONE_SLAB.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_PINK_SANDSTONE.get(), 4)
                .pattern("ss").pattern("ss").define('s', ModBlocks.PINK_SANDSTONE.get())
                .unlockedBy("has_pink_sandstone", has(ModBlocks.PINK_SANDSTONE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAVY_PINK_SANDSTONE.get(), 3)
                .pattern(" s ").pattern("s s").define('s', ModBlocks.PINK_SANDSTONE.get())
                .unlockedBy("has_pink_sandstone", has(ModBlocks.PINK_SANDSTONE.get()))
                .save(output);
    }
}
