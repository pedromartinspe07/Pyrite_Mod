package net.pedromartss.pyritemod.block.custom;

import net.pedromartss.pyritemod.worldgen.dimension.ModDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ModPortalBlock extends Block {
    public ModPortalBlock(Properties properties) {
        super(properties);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            // Sempre teleporta para a dimensão Pyrithea
            ServerLevel targetLevel = level.getServer().getLevel(ModDimensions.PYRITHEA_LEVEL_KEY);
            if (targetLevel != null && player instanceof ServerPlayer serverPlayer) {
                double x = player.getX();
                double z = player.getZ();
                int y = targetLevel.getHeightmapPos(
                    net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BlockPos.containing(x, 0, z)
                ).getY() + 1;
                serverPlayer.teleportTo(targetLevel, x, y, z, player.getYRot(), player.getXRot());
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.CONSUME;
    }
}
