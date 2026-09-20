package net.j.jemstones.item;

import net.j.jemstones.entity.ModEntities;
import net.j.jemstones.entity.Ruby;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class RubyGemItem extends Item {
    public RubyGemItem(Properties properties) {
        super(properties);
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

        Ruby ruby = ModEntities.RUBY.get().create(server);
        if (ruby == null) return InteractionResult.FAIL;
        ruby.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, player.getYRot(), 0.0F);
        if (!level.getWorldBorder().isWithinBounds(ruby.getBoundingBox())
                || !level.noCollision(ruby)) return InteractionResult.FAIL;

        ruby.tame(player);
        ruby.setHealth(ruby.getMaxHealth());
        if (stack.hasCustomHoverName()) ruby.setCustomName(stack.getHoverName());
        if (!server.addFreshEntity(ruby)) return InteractionResult.FAIL;

        if (!player.getAbilities().instabuild) stack.shrink(1);
        level.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        return InteractionResult.CONSUME;
    }
}
