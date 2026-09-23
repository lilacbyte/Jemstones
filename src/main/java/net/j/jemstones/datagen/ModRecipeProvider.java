package net.j.jemstones.datagen;

import net.j.jemstones.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> output) {
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
    }
}
