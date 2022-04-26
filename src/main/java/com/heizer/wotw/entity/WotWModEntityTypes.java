package com.heizer.wotw.entity;

import com.heizer.wotw.WotWMod;
import com.heizer.wotw.entity.custom.BisonEntity;
import com.heizer.wotw.entity.custom.ExampleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WotWModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, WotWMod.MOD_ID);

    public static final RegistryObject<EntityType<BisonEntity>> BISON = ENTITY_TYPES.register("bison",
            () -> EntityType.Builder.of(BisonEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 3f)
                    .build(new ResourceLocation(WotWMod.MOD_ID, "bison").toString()));

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE = ENTITY_TYPES.register("example",
            () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 3f)
                    .build(new ResourceLocation(WotWMod.MOD_ID, "example").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
