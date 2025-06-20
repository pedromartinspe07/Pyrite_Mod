package net.pedromartss.tutorialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.pedromartss.tutorialmod.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.IRON_BLOCK, Blocks.DIAMOND_BLOCK,
                    Blocks.DIRT, ModBlocks.PYRITE_BLOCK.get()
            );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedblock = level.getBlockState(pContext.getClickedPos()).getBlock();

       if(CHISEL_MAP.containsKey(clickedblock)) {
           if(!level.isClientSide()) {
              level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedblock).defaultBlockState());

              pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                      item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));


              level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
           }
       }

        return InteractionResult.SUCCESS;
    }
}
