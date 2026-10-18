package net.j.jemstones.item;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class CrackedGemItem extends Item {
    private final Supplier<? extends Item> repairedItem;

    public CrackedGemItem(Supplier<? extends Item> repairedItem, Properties properties) {
        super(properties);
        this.repairedItem = repairedItem;
    }

    public Item getRepairedItem() {
        return repairedItem.get();
    }
}
