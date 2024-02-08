package com.example.syumjoba.block;

import java.util.function.Supplier;

import com.example.syumjoba.FirstMod;
import com.example.syumjoba.item.ModItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);


    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block", () ->
        new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST))
    );

    public static final RegistryObject<Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block", () ->
        new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BASALT))
    );

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.MAGMA_BLOCK).sound(SoundType.METAL))
    );

    public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block", () ->
        new Block(BlockBehaviour.Properties.copy(Blocks.NETHERRACK).destroyTime(0.5f).sound(SoundType.AMETHYST).mapColor(MapColor.COLOR_BLACK))
    );
    

    public static final RegistryObject<Block> END_SAPPHIRE_ORE_BLOCK = registerBlock("end_sapphire_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> END_BLACK_OPAL_ORE_BLOCK = registerBlock("end_black_opal_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> END_ZIRCON_ORE_BLOCK = registerBlock("end_zircon_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE_BLOCK = registerBlock("deepslate_sapphire_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE_BLOCK = registerBlock("deepslate_black_opal_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE_BLOCK = registerBlock("deepslate_zircon_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE_BLOCK = registerBlock("nether_sapphire_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> NETHER_BLACK_OPAL_ORE_BLOCK = registerBlock("nether_black_opal_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> NETHER_ZIRCON_ORE_BLOCK = registerBlock("nether_zircon_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> SAPPHIRE_ORE_BLOCK = registerBlock("sapphire_ore_block", () -> 
        new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops(),
        UniformInt.of(3, 6)) //you need to understand why the loot table and the required minimum mining tools in data/minecraft/mineable/block/pickaxe.json and data/minecraft/mineable/needs_<toolmaterial>tool.json don't work
    );

    public static final RegistryObject<Block> BLACK_OPAL_ORE_BLOCK = registerBlock("black_opal_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );

    public static final RegistryObject<Block> ZIRCON_ORE_BLOCK = registerBlock("zircon_ore_block", () -> 
        new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE))
    );



    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block_supplier) {
        RegistryObject<T> block = BLOCKS.register(name, block_supplier);
        registerBlockItem(name, block);
        return block;
    } 

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> 
            new BlockItem(block.get(), new Item.Properties())
        );
    }
}
