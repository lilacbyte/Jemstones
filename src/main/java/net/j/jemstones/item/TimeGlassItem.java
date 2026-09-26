package net.j.jemstones.item;

import net.j.jemstones.event.TimeGlassEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.common.MinecraftForge;

public class TimeGlassItem extends Item {
    public TimeGlassItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        if (player == null || player.isSpectator() || stack.isEmpty()
                || !context.getLevel().mayInteract(player, context.getClickedPos())
                || !player.mayUseItemAt(context.getClickedPos(), context.getClickedFace(), stack)) {
            return InteractionResult.FAIL;
        }
        if (!(context.getLevel() instanceof ServerLevel level)) return InteractionResult.SUCCESS;
        if (MinecraftForge.EVENT_BUS.post(new TimeGlassEvent(player, stack))) return InteractionResult.CONSUME;

        // time and weather are shared through the overworld
        ServerLevel overworld = level.getServer().overworld();
        overworld.setDayTime(-overworld.getDayTime());
        if (level.random.nextBoolean()) {
            if (overworld.getLevelData().isRaining()) {
                overworld.setWeatherParameters(level.random.nextInt(12000) + 12000, 0, false, false);
            } else {
                overworld.setWeatherParameters(0, level.random.nextInt(12000) + 12000,
                        true, overworld.getLevelData().isThundering());
            }
        }
        return InteractionResult.CONSUME;
    }
}
