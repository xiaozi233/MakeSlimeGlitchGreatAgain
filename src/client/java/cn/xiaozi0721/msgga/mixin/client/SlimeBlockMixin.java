package cn.xiaozi0721.msgga.mixin.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SlimeBlock.class)
public abstract class SlimeBlockMixin extends TranslucentBlock {
	public SlimeBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(method = "onLandedUpon", at = @At("HEAD"))
	private void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
		if (entity.bypassesLandingEffects()) {
			super.onLandedUpon(world, state, pos, entity, fallDistance);
		}
	}
}