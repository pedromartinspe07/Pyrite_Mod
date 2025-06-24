package net.pedromartss.pyritemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PUDDING = new FoodProperties.Builder().nutrition(8).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.INVISIBILITY, 400), 0.20f).build();

    public static final FoodProperties PEACH = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
                .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.20f).build();

    public static final FoodProperties GOLDEN_RASPBERRY = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.15f).fast().build();

}
