package net.j.jemstones.entity;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.Map;

public class RoseQuartz extends QuartzGem {
    private static final Map<Item, Item> RECIPES = Map.of(
            Items.POISONOUS_POTATO, Items.POTATO,
            Items.ROTTEN_FLESH, Items.LEATHER,
            Items.WHEAT, Items.BREAD);

    public RoseQuartz(EntityType<? extends RoseQuartz> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return createQuartzAttributes(8.0D);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Item result = RECIPES.get(stack.getItem());
        if (hand != InteractionHand.MAIN_HAND || result == null) return super.mobInteract(player, hand);
        if (player.isSpectator() || !isAlive() || stack.isEmpty() || !isOwnedBy(player)) {
            return InteractionResult.FAIL;
        }
        if (!level().isClientSide) {
            if (spawnAtLocation(new ItemStack(result), 1.0F) == null) return InteractionResult.FAIL;
            if (!player.getAbilities().instabuild) stack.shrink(1);
        }
        return InteractionResult.sidedSuccess(level().isClientSide);
    }
}
