package net.j.jemstones.item;

import java.util.function.Supplier;
import net.minecraft.world.entity.EntityType;
import net.j.jemstones.entity.QuartzGem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class QuartzGemItem extends Item {
    private final Supplier<EntityType<QuartzGem>> entityType;

    public QuartzGemItem(Supplier<EntityType<QuartzGem>> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        BlockPos clicked = context.getClickedPos();
        BlockPos pos = level.getBlockState(clicked).getCollisionShape(level, clicked).isEmpty()
                ? clicked : clicked.relative(context.getClickedFace());
        if (player == null || player.isSpectator() || stack.isEmpty()
                || !level.mayInteract(player, clicked)
                || !player.mayUseItemAt(pos, context.getClickedFace(), stack)) {
            return InteractionResult.FAIL;
        }
        if (!(level instanceof ServerLevel server)) return InteractionResult.SUCCESS;

        QuartzGem gem = entityType.get().create(server);
        if (gem == null) return InteractionResult.FAIL;
        gem.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, player.getYRot(), 0.0F);
        if (!level.getWorldBorder().isWithinBounds(gem.getBoundingBox())
                || !level.noCollision(gem)) return InteractionResult.FAIL;

        gem.tame(player);
        gem.setHealth(gem.getMaxHealth());
        if (stack.hasCustomHoverName()) gem.setCustomName(stack.getHoverName());
        if (!server.addFreshEntity(gem)) return InteractionResult.FAIL;

        if (!player.getAbilities().instabuild) stack.shrink(1);
        level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        return InteractionResult.CONSUME;
    }
}
