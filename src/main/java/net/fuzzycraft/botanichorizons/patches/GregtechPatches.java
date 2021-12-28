package net.fuzzycraft.botanichorizons.patches;

import gregtech.api.enums.Materials;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import net.fuzzycraft.botanichorizons.util.Constants;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.block.ModFluffBlocks;
import vazkii.botania.common.crafting.ModCraftingRecipes;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibOreDict;

import javax.annotation.Nullable;
import java.util.List;

public class GregtechPatches {
    public static void applyPatches() {

        // GT mortar for petals into floral powder
        for (int i = 0; i < 16; i++) {
            ItemStack flower = new ItemStack(ModBlocks.flower, 1, i);
            ItemStack petal = new ItemStack(ModItems.petal, 1, i);
            ItemStack powder = new ItemStack(ModItems.dye, 1, i);

            // petals
            GT_ModHandler.addShapelessCraftingRecipe(powder, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ToolDictNames.craftingToolMortar, petal});
            GT_ModHandler.addPulverisationRecipe(petal, powder);

            // flowers
            GT_ModHandler.addShapelessCraftingRecipe(powder, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ToolDictNames.craftingToolMortar, flower});
            GT_ModHandler.addPulverisationRecipe(flower, powder);
        }

        // Petal Block from 9x in compressor + reverse in extractor
        for(int i = 0; i < 16; i++) {
            GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.petal, 9, i), new ItemStack(ModBlocks.petalBlock, 1, i));
            GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.petalBlock, 1, i), new ItemStack(ModItems.petal, 9, i));
        }

        // Petals from flowers
        for(int i = 0; i < 16; i++) {
            GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.petal, 1, i), new ItemStack(ModBlocks.petalBlock, 1, i));
        }

        // Better floral fertiliser
        List<ItemStack> mutandis = OreDictionary.getOres("itemMutandis");
        List<ItemStack> dustEV = OreDictionary.getOres("dustDraconium");
        for (ItemStack option: mutandis) {
            addMixerRecipe(new ItemStack(ModItems.fertilizer, 2, 0), 16, 80, option, new ItemStack(Items.dye, 1, 15));
        }
        for (ItemStack option: dustEV) {
            addMixerRecipe(new ItemStack(ModItems.fertilizer, 2, 0), 16, 80, option, new ItemStack(Items.dye, 1, 15));
        }

        // Slabs
        addSlabRecipe(new ItemStack(ModFluffBlocks.blazeQuartzSlab, 2),       new ItemStack(ModFluffBlocks.blazeQuartz, 1),     1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.darkPrismarineSlab, 2), new ItemStack(??, 1), 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.darkQuartzSlab, 2),        new ItemStack(ModFluffBlocks.darkQuartz, 1),      1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.dirtPathSlab, 2),          new ItemStack(ModBlocks.dirtPath, 1),             1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.elfQuartzSlab, 2),         new ItemStack(ModFluffBlocks.elfQuartz, 1),       1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.enderBrickSlab, 2), new ItemStack(??, 1), 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.endStoneSlab, 2), new ItemStack(??, 1), 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.lavenderQuartzSlab, 2),    new ItemStack(ModFluffBlocks.lavenderQuartz, 1),  1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.livingrockBrickSlab, 2), new ItemStack(??, 1), 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.livingrockSlab, 2),        new ItemStack(ModBlocks.livingrock, 1),           1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.manaQuartzSlab, 2),        new ItemStack(ModFluffBlocks.manaQuartz, 1),      1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.netherBrickSlab, 2),       new ItemStack(Blocks.nether_brick, 1),            1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.prismarineBrickSlab, 2), new ItemStack(??, 1), 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.prismarineSlab, 2),        new ItemStack(ModBlocks.prismarine, 1),           1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.redQuartzSlab, 2),         new ItemStack(ModFluffBlocks.redQuartz, 1),       1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.reedSlab, 2),              new ItemStack(ModBlocks.reedBlock, 1),            1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.shimmerrockSlab, 2),       new ItemStack(ModBlocks.shimmerrock, 1),          1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.shimmerwoodPlankSlab, 2),  new ItemStack(ModBlocks.shimmerwoodPlanks, 1),    1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.soulBrickSlab, 2), new ItemStack(??, 1), 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.snowBrickSlab, 2), new ItemStack(??, 2), 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.sunnyQuartzSlab, 2),       new ItemStack(ModFluffBlocks.sunnyQuartz, 1),     1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.thatchSlab, 2),            new ItemStack(ModBlocks.thatch, 1),               1, 16, 80);
        //addSlabRecipe(new ItemStack(ModFluffBlocks.tileSlab, 2), new ItemStack(??, 1), 16, 80);

        // Blocks to either planks or slabs
        ModCraftingRecipes.recipeLivingwoodDecor1 = addSlabRecipe(new ItemStack(ModBlocks.livingwood, 4, Constants.LIVINGWOOD_META_PLANK), new ItemStack(ModBlocks.livingwood, 1, Constants.LIVINGWOOD_META_BLOCK), 2, 16, 200);
        addSlabRecipe(new ItemStack(ModBlocks.dreamwood,  4, Constants.LIVINGWOOD_META_PLANK), new ItemStack(ModBlocks.dreamwood, 1,  Constants.LIVINGWOOD_META_BLOCK), 2, 16, 200);
        addSlabRecipe(new ItemStack(ModFluffBlocks.livingwoodSlab, 2),      new ItemStack(ModBlocks.livingwood, 1, Constants.LIVINGWOOD_META_BLOCK),  1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.livingwoodPlankSlab, 2), new ItemStack(ModBlocks.livingwood, 1, Constants.LIVINGWOOD_META_PLANK),  1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.dreamwoodSlab, 2),      new ItemStack(ModBlocks.dreamwood, 1, Constants.LIVINGWOOD_META_BLOCK),   1, 16, 80);
        addSlabRecipe(new ItemStack(ModFluffBlocks.dreamwoodPlankSlab, 2), new ItemStack(ModBlocks.dreamwood, 1, Constants.LIVINGWOOD_META_PLANK),   1, 16, 80);
        ModCraftingRecipes.recipeLivingwoodTwig = addSlabRecipe(new ItemStack(ModItems.manaResource, 2, Constants.MANARESOURCE_META_TWIG_WOOD), new ItemStack(ModBlocks.livingwood, 1, Constants.LIVINGWOOD_META_PLANK), 2, 16, 200);
        ModCraftingRecipes.recipeDreamwoodTwig = addSlabRecipe(new ItemStack(ModItems.manaResource, 2, Constants.MANARESOURCE_META_TWIG_DREAM), new ItemStack(ModBlocks.dreamwood, 1, Constants.LIVINGWOOD_META_PLANK), 2, 16, 200);

        // Cracked blocks
        ModCraftingRecipes.recipeLivingrockDecor3 = addHammerRecipe(new ItemStack(ModBlocks.livingrock, 1, Constants.LIVINGSTONE_META_CRACKED), new ItemStack(ModBlocks.livingrock, 1, Constants.LIVINGSTONE_META_BRICK));

        // Ingots into blocks. Wouldn't be surprised if this becomes unnecessary when GT provides its own ingots
        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_MANASTEEL), new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_MANASTEELBLOCK));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_MANASTEELBLOCK), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_MANASTEEL));
        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_TERRASTEEL), new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_TERRASTEELBLOCK));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_TERRASTEELBLOCK), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_TERRASTEEL));
        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_ELEMENTIUM), new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_ELEMENTIUMBLOCK));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_ELEMENTIUMBLOCK), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_ELEMENTIUM));
        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_DRAGONSTONE), new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_DRAGONSTONEBLOCK));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_DRAGONSTONEBLOCK), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_DRAGONSTONE));
        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_DIAMOND), new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_DIAMONDBLOCK));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.storage, 1, Constants.STORAGE_META_DIAMONDBLOCK), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_DIAMOND));

        GT_ModHandler.addCompressionRecipe(new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_PRISMARINE), new ItemStack(ModBlocks.prismarine));
        GT_ModHandler.addExtractionRecipe(new ItemStack(ModBlocks.prismarine), new ItemStack(ModItems.manaResource, 9, Constants.MANARESOURCE_META_PRISMARINE));

        // Decorative baubles
        for(int i = 0; i < 32; i++) {
            Item choice = (i < 16) ? ModItems.petal : ModItems.dye;
            ItemStack fabric = new ItemStack(ModItems.manaResource, 2, Constants.MANARESOURCE_META_CLOTH);
            ItemStack output = new ItemStack(ModItems.cosmetic, 1, i);
            CraftingPatches.addOreDictRecipe(output,
                    "SPS", "PSP", "SPS",
                    'P', new ItemStack(choice, 1, i % 16),
                    'S', LibOreDict.MANAWEAVE_CLOTH
            );
            GT_Recipe.GT_Recipe_Map.sAssemblerRecipes.addRecipe(true,
                    new ItemStack[]{fabric, new ItemStack(choice, 2, i % 16), GT_Utility.getIntegratedCircuit(4)},
                    new ItemStack[]{output},
                    null, null, null,
                    120, 80, 0
            );
            GT_ModHandler.addExtractionRecipe(new ItemStack(ModItems.cosmetic, 1, i), fabric);
        }
        ModCraftingRecipes.recipesCosmeticItems = BotaniaAPI.getLatestAddedRecipes(32);

    }

    private static void addMixerRecipe(ItemStack output, int volt, int ticks, ItemStack... input) {
        GT_Recipe.GT_Recipe_Map.sMixerRecipes.addRecipe(
                true,
                input,
                new ItemStack[]{output},
                null, null, null, null,
                ticks, volt,
                0
        );
    }

    @Nullable
    private static IRecipe addSlabRecipe(ItemStack output, ItemStack input, int circuit, int volt, int ticks) {
        ItemStack[] inputs;
        if (circuit == 0) {
            inputs = new ItemStack[]{input};
        } else {
            ItemStack circuitStack = GT_Utility.getIntegratedCircuit(circuit);
            inputs = new ItemStack[]{input, circuitStack};
        }
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(
                true,
                inputs,
                new ItemStack[]{output},
                null, null,
                new FluidStack[]{Materials.Water.getFluid(4)},
                null,
                ticks, volt, 0
        );
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(
                true,
                inputs,
                new ItemStack[]{output},
                null, null,
                new FluidStack[]{GT_ModHandler.getDistilledWater(3)},
                null,
                ticks, volt, 0
        );
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(
                true,
                inputs,
                new ItemStack[]{output},
                null, null,
                new FluidStack[]{Materials.Lubricant.getFluid(1)},
                null,
                ticks / 2, volt, 0
        );
        if (volt < 32 && (output.stackSize % 2) == 0) {
            ItemStack half_output = new ItemStack(output.getItem(), output.stackSize / 2, output.getItemDamage());
            String r1 = (circuit <= 1) ? "sR" : "s ";
            String r2 = (circuit <= 1) ? "  " : "R ";
            GT_ModHandler.addCraftingRecipe(
                    half_output,
                    new Object[]{
                            r1, r2,
                            'R', input
                    }
            );
            return new ShapedOreRecipe(
                    half_output,
                    r1, r2,
                    's', ToolDictNames.craftingToolSaw.name(),
                    'R', input
            );
        } else return null;
    }

    public static IRecipe addHammerRecipe(ItemStack output, ItemStack input) {
        GT_Recipe.GT_Recipe_Map.sHammerRecipes.addRecipe(
                true,
                new ItemStack[]{input},
                new ItemStack[]{output},
                null, null, null,null,
                32, 4, 0
        );
        GT_ModHandler.addCraftingRecipe(
                output,
                new Object[]{
                        "h", "R",
                        'R', input
                }
        );
        return new ShapedOreRecipe(
                output, "h", "R",
                'R', input,
                'h', ToolDictNames.craftingToolHardHammer.name()
        );
    }
}
