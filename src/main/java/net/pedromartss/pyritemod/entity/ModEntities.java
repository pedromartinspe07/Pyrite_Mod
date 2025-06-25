package net.pedromartss.pyritemod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.entity.custom.CapivaraEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PyriteMod.MOD_ID);

    public static final RegistryObject<EntityType<CapivaraEntity>>  CAPIVARA =
            ENTITY_TYPES.register("capivara", () -> EntityType.Builder.of(CapivaraEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("capivara"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
