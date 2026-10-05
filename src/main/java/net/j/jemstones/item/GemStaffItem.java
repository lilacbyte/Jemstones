package net.j.jemstones.item;

import net.j.jemstones.entity.GemEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GemStaffItem extends Item {
    public GemStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isSpectator()) return InteractionResultHolder.fail(stack);
        if (!level.isClientSide) {
            for (GemEntity gem : level.getEntitiesOfClass(GemEntity.class,
                    player.getBoundingBox().inflate(24.0D, 8.0D, 24.0D), GemEntity::isAlive)) {
                gem.calm();
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
