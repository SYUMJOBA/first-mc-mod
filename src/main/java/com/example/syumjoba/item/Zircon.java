package com.example.syumjoba.item;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;

import com.example.syumjoba.block.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;

public class Zircon extends Item {
    public Zircon() {
        super(new Item.Properties().fireResistant().rarity(Rarity.RARE).stacksTo(1));
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        if (context.getClickedPos() == null)
            return InteractionResult.FAIL;
        if (context.getLevel() == null)
            return InteractionResult.FAIL;
        
        Level world = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Direction face = context.getClickedFace();
        BlockPos blockPosUp = blockPos.relative(face);
        Player playerEntity = context.getPlayer();
        
        if (!BaseFireBlock.canBePlacedAt(world, blockPosUp, context.getClickedFace()))
            return InteractionResult.FAIL;
        

        BlockState fireState = BaseFireBlock.getState(world, blockPosUp);
        world.setBlock(blockPosUp, fireState, EAT_DURATION);
        world.updateNeighborsAt(blockPosUp, fireState.getBlock());

        playerEntity.sendSystemMessage(Component.literal("Fire Should be placed right now!"));
        
        if (world.getBlockState(blockPos).getBlock() == ModBlocks.ZIRCON_BLOCK.get()) {
            playerEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 255, 3));
            playerEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 255, 5));
            playerEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 255, 3));
            playerEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 255, 1));
            playerEntity.sendSystemMessage(Component.literal("There will be some effects going on ..."));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        entity.lavaHurt();
        player.level().setBlockAndUpdate(entity.blockPosition(), BaseFireBlock.getState(player.level(), entity.blockPosition()));

        player.sendSystemMessage(Component.literal("Get Burned!"));

        return super.onLeftClickEntity(stack, player, entity);
    }
}
