package com.example.syumjoba.item;

import com.example.syumjoba.FirstMod;
import com.example.syumjoba.block.ModBlocks;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon", () -> 
        new Zircon()
    );
    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon", () ->
        new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().stacksTo(64))
    );

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> 
        new Sapphire()
    );

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> 
        new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant().stacksTo(64))
    );

    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal", () -> 
        new Item(new Item.Properties().rarity(Rarity.UNCOMMON))
    );

    public static final RegistryObject<Item> RAW_BLACK_OPAL = ITEMS.register("raw_black_opal", () -> 
        new Item(new Item.Properties().rarity(Rarity.UNCOMMON))
    );

    public static void tabify(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ZIRCON);
            event.accept(RAW_ZIRCON);
            event.accept(SAPPHIRE);
            event.accept(RAW_SAPPHIRE);
            event.accept(BLACK_OPAL);
            event.accept(RAW_BLACK_OPAL);
        }
    }
}
