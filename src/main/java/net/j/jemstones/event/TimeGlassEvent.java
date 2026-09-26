package net.j.jemstones.event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

@Cancelable
public class TimeGlassEvent extends Event {
    public final Player player;
    public final ItemStack stack;

    public TimeGlassEvent(Player player, ItemStack stack) {
        this.player = player;
        this.stack = stack;
    }
}
