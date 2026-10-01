package net.j.jemstones.block;

import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;

public class GiantStrawberryBlock extends StemGrownBlock {
    public GiantStrawberryBlock(Properties properties) {
        super(properties);
    }

    @Override
    public StemBlock getStem() {
        return ModBlocks.GIANT_STRAWBERRY_STEM.get();
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return ModBlocks.ATTACHED_GIANT_STRAWBERRY_STEM.get();
    }
}
