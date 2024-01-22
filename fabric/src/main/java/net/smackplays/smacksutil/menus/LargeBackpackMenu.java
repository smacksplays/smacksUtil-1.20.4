package net.smackplays.smacksutil.menus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.smackplays.smacksutil.SmacksUtil;
import net.smackplays.smacksutil.inventories.BackpackInventory;
import net.smackplays.smacksutil.inventories.LargeBackpackInventory;
import org.jetbrains.annotations.Nullable;

public class LargeBackpackMenu extends AbstractLargeBackpackMenu {

    public LargeBackpackMenu(@Nullable MenuType<?> menuType, int syncId, Inventory playerInv, Container inv) {
        super(menuType, syncId, playerInv, inv);
    }

    @SuppressWarnings("unused")
    public static LargeBackpackMenu createGeneric13x9(int syncId, Inventory playerInventory, FriendlyByteBuf buf) {
        return new LargeBackpackMenu(SmacksUtil.LARGE_BACKPACK_MENU, syncId, playerInventory, new LargeBackpackInventory(playerInventory.getSelected()));
    }
}