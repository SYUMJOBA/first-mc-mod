package com.example.syumjoba.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class Sapphire extends Item {
    public Sapphire() {
        super(new Item.Properties().rarity(Rarity.RARE).fireResistant().stacksTo(1));
    }
    
    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {
        player.kill();
        return true;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        if (context == null) {
            return InteractionResult.FAIL;
        }

        BlockState hitState = context.getLevel().getBlockState(context.getClickedPos());
        Block hitBlock = hitState.getBlock();

        if (hitBlock instanceof LiquidBlockContainer liquidContainer)
            liquidContainer.placeLiquid(context.getLevel(), context.getClickedPos(), hitState, Fluids.WATER.getSource(true));
        else
            context.getLevel().setBlockAndUpdate(context.getClickedPos().relative(context.getClickedFace()), Blocks.WATER.defaultBlockState());
        context.getPlayer().sendSystemMessage(Component.literal("Water should be place now!"));
        return InteractionResult.SUCCESS;
    }
}
