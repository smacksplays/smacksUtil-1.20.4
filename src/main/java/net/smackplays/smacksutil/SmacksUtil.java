package net.smackplays.smacksutil;

import com.terraformersmc.modmenu.ModMenu;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.config.ModMenuConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.smackplays.smacksutil.backpacks.LargeBackpackScreenHandler;
import net.smackplays.smacksutil.config.SmackUtilConfig;
import net.smackplays.smacksutil.events.veinminer.PlayerBlockBreak;
import net.smackplays.smacksutil.veinminer.Miner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmacksUtil implements ModInitializer {
    public static final String MOD_ID = "smacksutil";
    public static final Logger LOGGER = LoggerFactory.getLogger("veinminer");
    public static final ScreenHandlerType<LargeBackpackScreenHandler> GENERIC_13X9 = new ExtendedScreenHandlerType<>(LargeBackpackScreenHandler::createGeneric13x9);
    public static Miner veinMiner;
    public static boolean fastPlace;

    public static void toggleFastPlace() {
        fastPlace = !fastPlace;
    }

    public static boolean getFastPlace() {
        return fastPlace;
    }

    @Override
    public void onInitialize() {
        PlayerBlockBreakEvents.BEFORE.register(new PlayerBlockBreak());
        veinMiner = new Miner();

        Registry.register(Registries.SCREEN_HANDLER, new Identifier(SmacksUtil.MOD_ID, "generic_13x9"), GENERIC_13X9);
        AutoConfig.register(SmackUtilConfig.class, GsonConfigSerializer::new);

    }
}