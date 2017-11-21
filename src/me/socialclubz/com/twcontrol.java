package me.socialclubz.com;

import cn.nukkit.Nukkit;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.ConsoleCommandSender;
import cn.nukkit.command.defaults.TimeCommand;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.event.level.WeatherChangeEvent;
import cn.nukkit.level.Level;
import cn.nukkit.network.protocol.SetTimePacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.LinkedHashMap;

import static cn.nukkit.level.Level.TIME_DAY;
import static cn.nukkit.level.Level.TIME_NIGHT;


public class twcontrol
        extends PluginBase
        implements Listener {
    private String usageMessage;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getDataFolder().mkdir();

        Config config = new Config(new File(getDataFolder(), "config.yml"), 2, new LinkedHashMap() {
        });
        config.save();

        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Enabled!       |");
        getServer().getLogger().info("|      TWControl      |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public void onDisable() {
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Disabled!      |");
        getServer().getLogger().info("|      TWControl      |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = null;
        if ((sender instanceof Player)) {
            player = (Player) sender;
        }
        if (command.getName().equalsIgnoreCase("day")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player.hasPermission("social.day");
            switch ((TIME_DAY)) {
            }

            if (command.getName().equalsIgnoreCase("night")) {
                if (player == null) {
                    sender.sendMessage("You have to be a Player");
                    return true;
                }
                if ((player != null) && (player.hasPermission("social.night"))) {
                    switch ((TIME_NIGHT)) {
                    }
                }
            }
        }
        return false;
    }
}