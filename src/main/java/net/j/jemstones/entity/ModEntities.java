package net.j.jemstones.entity;

import net.j.jemstones.Jemstones;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Jemstones.MOD_ID);

    public static final RegistryObject<EntityType<Ruby>> RUBY = ENTITIES.register("ruby",
            () -> EntityType.Builder.of(Ruby::new, MobCategory.CREATURE)
                    .sized(0.7F, 1.2F).fireImmune().clientTrackingRange(8)
                    .build(Jemstones.MOD_ID + ":ruby"));

    public static final RegistryObject<EntityType<Melon>> MELON = ENTITIES.register("melon",
            () -> EntityType.Builder.of(Melon::new, MobCategory.CREATURE)
                    .sized(0.5F, 1.5F).clientTrackingRange(8)
                    .build(Jemstones.MOD_ID + ":melon"));

    public static final RegistryObject<EntityType<Pumpkin>> PUMPKIN = ENTITIES.register("pumpkin",
            () -> EntityType.Builder.of(Pumpkin::new, MobCategory.CREATURE)
                    .sized(0.5F, 1.5F).clientTrackingRange(8)
                    .build(Jemstones.MOD_ID + ":pumpkin"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
        eventBus.addListener(ModEntities::registerAttributes);
    }

    private static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RUBY.get(), Ruby.createAttributes().build());
        event.put(MELON.get(), Pepo.createAttributes().build());
        event.put(PUMPKIN.get(), Pepo.createAttributes().build());
    }
}
