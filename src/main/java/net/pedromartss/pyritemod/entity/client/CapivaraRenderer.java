package net.pedromartss.pyritemod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.pedromartss.pyritemod.PyriteMod;
import net.pedromartss.pyritemod.entity.custom.CapivaraEntity;

public class CapivaraRenderer extends MobRenderer<CapivaraEntity, CapivaraModel<CapivaraEntity>> {
    public CapivaraRenderer(EntityRendererProvider.Context p_174304_) {
        super(p_174304_, new CapivaraModel<>(p_174304_.bakeLayer(CapivaraModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(CapivaraEntity p_114482_) {
        return ResourceLocation.fromNamespaceAndPath(PyriteMod.MOD_ID, "textures/entity/capybara/capybara_brown.png");
    }

    @Override
    public void render(CapivaraEntity p_115308_, float p_115309_, float p_115310_, PoseStack p_115311_,
                       MultiBufferSource p_115312_, int p_115313_) {
        if(p_115308_.isBaby()) {
            p_115311_.scale(0.5f, 0.5f, 0.5f);
        } else {
            p_115311_.scale(1f, 1f, 1f);
        }

        super.render(p_115308_, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
    }
}
