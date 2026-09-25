package net.j.jemstones.datagen;

import net.j.jemstones.Jemstones;
import net.j.jemstones.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Jemstones.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY_GEM);
        simpleItem(ModItems.AMETHYST_GEM);
        withExistingParent("melon_spawn_egg", mcLoc("item/template_spawn_egg"));
        withExistingParent("pumpkin_spawn_egg", mcLoc("item/template_spawn_egg"));
        simpleItem(ModItems.ACTIVATED_GEM_SHARD);
        simpleItem(ModItems.ACTIVATED_GEM_BASE);
        simpleItem(ModItems.INACTIVE_GEM_BASE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                 ResourceLocation.tryParse("item/generated")).texture("layer0",
                 ResourceLocation.tryBuild(Jemstones.MOD_ID,"item/" + item.getId().getPath()));
    }
}
