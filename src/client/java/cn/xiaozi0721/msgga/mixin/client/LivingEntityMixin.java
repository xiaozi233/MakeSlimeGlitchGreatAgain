package cn.xiaozi0721.msgga.mixin.client;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin{
    @Redirect(method = "jump", at = @At(value = "INVOKE", target = "Ljava/lang/Math;max(DD)D"))
    private double setVelocityY(double f, double vec3dY){
        return f;
    }
}
