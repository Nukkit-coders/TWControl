package me.socialclubz.com;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.LinkedHashMap;

import static cn.nukkit.level.Level.TIME_DAY;
import static cn.nukkit.level.Level.TIME_NIGHT;


public class twcontrol
        extends PluginBase
        implements Listener
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        getDataFolder().mkdir();

        Config config = new Config(new File(
                getDataFolder(), "config.yml"), 2, new LinkedHashMap() {});
        config.save();
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Enabled!       |");
        getServer().getLogger().info("|      TWControl      |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public void onDisable()
    {
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Disabled!      |");
        getServer().getLogger().info("|      TWControl      |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|     SocialClubz     |");
        getServer().getLogger().info("-----------------------");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//Day
        Player player = null;
        if ((sender instanceof Player)) {
            player = (Player) sender;
        }
        if (cmd.getName().equalsIgnoreCase("day")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) {
                if (player.hasPermission("social.day")) {
                    player.getLevel().setTime(TIME_DAY);
                    sender.sendMessage("Time Set To Day");
                }
                return true;
            }
        }
//night
        if (cmd.getName().equalsIgnoreCase("night")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) if (player.hasPermission("social.night")) {
                player.getLevel().setTime(TIME_NIGHT);
                sender.sendMessage("Time Set To Night");
                return true;
            }
        }
//sun
        if (cmd.getName().equalsIgnoreCase("sun")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) if (player.hasPermission("social.sun")) {
                player.getLevel().setRainTime(0);
                sender.sendMessage("Its Sunny Now");
                return true;
            }
        }
//sun
        if (cmd.getName().equalsIgnoreCase("rain")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) if (player.hasPermission("social.rain")) {
                player.getLevel().setRainTime(100);
                sender.sendMessage("Storm Mode Now Active");
                return true;
            }
        }
//stoptime
        if (cmd.getName().equalsIgnoreCase("stoptime")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) if (player.hasPermission("social.stoptime")) {
                player.getLevel().stopTime();
                sender.sendMessage("You Locked The Time");
                return true;
            }
        }
//starttime
        if (cmd.getName().equalsIgnoreCase("starttime")) {
            if (player == null) {
                sender.sendMessage("You have to be a Player");
                return true;
            }
            if (player != null) if (player.hasPermission("social.starttime")) {
                player.getLevel().startTime();
                sender.sendMessage("You Locked The Time");
                return true;
            }
        }
        return false;
    }
}