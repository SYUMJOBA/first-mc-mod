package com.example.syumjoba.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class ZirconBlock extends Block {
    public ZirconBlock() {
        super(Block.Properties.copy(Blocks.MAGMA_BLOCK).sound(SoundType.METAL));
    }

    @Override
    public void onCaughtFire(BlockState state, Level level, BlockPos pos, @Nullable Direction direction, @Nullable LivingEntity igniter) {
        if (igniter == null) 
            return;

        igniter.heal(6.0f);
    }
}
