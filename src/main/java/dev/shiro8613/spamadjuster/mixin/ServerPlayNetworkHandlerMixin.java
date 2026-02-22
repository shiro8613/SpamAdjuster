package dev.shiro8613.spamadjuster.mixin;

import dev.shiro8613.spamadjuster.ModConfig;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Cooldown;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Final
    @Shadow
    @Mutable
    private Cooldown messageCooldown;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void sp$cooldownInit(MinecraftServer server, ClientConnection connection,
        ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci) {

        this.messageCooldown = new Cooldown(ModConfig.getIncrement(), ModConfig.getThreshold());
    }
}
