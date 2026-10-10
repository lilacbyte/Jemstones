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
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COMMANDER_STAFF.get())
                .pattern("  p").pattern(" n ").pattern("n  ")
                .define('n', Items.IRON_NUGGET).define('p', Items.ENDER_PEARL)
                .unlockedBy("has_ender_pearl", has(Items.ENDER_PEARL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_STAFF.get())
                .pattern("  d").pattern(" b ").pattern("b  ")
                .define('b', Items.BLAZE_ROD).define('d', Items.DIAMOND)
                .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TRANSFER_CONTRACT.get())
                .requires(Items.WRITABLE_BOOK).requires(Items.IRON_NUGGET)
                .unlockedBy("has_writable_book", has(Items.WRITABLE_BOOK)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIBERATION_CONTRACT.get())
                .requires(ModItems.TRANSFER_CONTRACT.get()).requires(Items.GUNPOWDER)
                .unlockedBy("has_transfer_contract", has(ModItems.TRANSFER_CONTRACT.get())).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAVY_PINK_SANDSTONE_STAIRS.get(), 8)
                .pattern("s  ").pattern("ss ").pattern("sss")
                .define('s', ModBlocks.WAVY_PINK_SANDSTONE.get())
                .unlockedBy("has_wavy_pink_sandstone", has(ModBlocks.WAVY_PINK_SANDSTONE.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ACTIVATED_GEM_BASE.get())
                .pattern("###").pattern("###").pattern("###")
                .define('#', ModItems.ACTIVATED_GEM_SHARD.get())
                .unlockedBy("has_active_gem_shard", has(ModItems.ACTIVATED_GEM_SHARD.get()))
                .save(output);
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
