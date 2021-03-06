package io.github.mcalphadev.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.mcalphadev.loader.AlphaModLoader;
import net.minecraft.client.Minecraft;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	@Inject(at = @At(value = "CONSTANT", args = "stringValue=Startup"), method = "initialise")
	private void injectModInit(CallbackInfo info) {
		AlphaModLoader.getInstance().initialise();
	}

	@Inject(at = @At(value = "CONSTANT", args = "stringValue=Post startup"), method = "initialise")
	private void injectModPosInit(CallbackInfo info) {
		AlphaModLoader.getInstance().postInitialise();
	}
}
