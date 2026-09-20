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
        simpleItem(ModItems.ROX);
        simpleItem(ModItems.MOSHLING_EGG);

        ResourceLocation parent = new ResourceLocation("item/generated");
        getBuilder("love_berries")
                .parent(new net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile(parent, existingFileHelper))
                .texture("layer0", modLoc("item/love_berries"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                 ResourceLocation.tryParse("item/generated")).texture("layer0",
                 ResourceLocation.tryBuild(Jemstones.MOD_ID,"item/" + item.getId().getPath()));
    }
}
