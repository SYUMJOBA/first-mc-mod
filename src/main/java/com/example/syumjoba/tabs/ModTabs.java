package com.example.syumjoba.tabs;

import com.example.syumjoba.FirstMod;
import com.example.syumjoba.block.ModBlocks;
import com.example.syumjoba.item.ModItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GENERAL_TAB = CREATIVE_TABS.register("general_tab", () -> 
        CreativeModeTab.builder().title(Component.translatable("tab.first_mod.general")).displayItems(
            (parameters, output) -> {
                output.accept(ModItems.ZIRCON.get());
                output.accept(ModItems.RAW_ZIRCON.get());
                output.accept(ModItems.SAPPHIRE.get());
                output.accept(ModItems.RAW_SAPPHIRE.get());
                output.accept(ModItems.BLACK_OPAL.get());
                output.accept(ModItems.RAW_BLACK_OPAL.get());
    
                output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                output.accept(ModBlocks.ZIRCON_BLOCK.get());
                output.accept(ModBlocks.BLACK_OPAL_BLOCK.get());
    
                output.accept(ModBlocks.BLACK_OPAL_ORE_BLOCK.get());
                output.accept(ModBlocks.SAPPHIRE_ORE_BLOCK.get());
                output.accept(ModBlocks.SAPPHIRE_ORE_BLOCK.get());
                output.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE_BLOCK.get());
                output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE_BLOCK.get());
                output.accept(ModBlocks.DEEPSLATE_ZIRCON_ORE_BLOCK.get());
                output.accept(ModBlocks.NETHER_BLACK_OPAL_ORE_BLOCK.get());
                output.accept(ModBlocks.NETHER_SAPPHIRE_ORE_BLOCK.get());
                output.accept(ModBlocks.NETHER_ZIRCON_ORE_BLOCK.get());
                output.accept(ModBlocks.END_BLACK_OPAL_ORE_BLOCK.get());
                output.accept(ModBlocks.END_SAPPHIRE_ORE_BLOCK.get());
                output.accept(ModBlocks.END_ZIRCON_ORE_BLOCK.get());
    
            }
        ).build()
    );
}
