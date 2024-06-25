package cn.ng;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/*
 * An example of direction and distance between players
 *
 * By: 念国
 *
 */

public final class Example extends JavaPlugin implements Listener {

    //String Spigot_Version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    public static Map<Player, Player> targets=new HashMap<>();
    FileConfiguration config;
    public final String version = getDescription().getVersion();
    public String msg(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("ExamplePlugin 已启用");
        getCommand("ind").setExecutor(new Command(this));
        getCommand("track").setExecutor(new Command(this));
        getCommand("qx").setExecutor(new Command(this));
        File ConfigFile = new File(getDataFolder(), "Config.yml");
        if (!ConfigFile.exists()) {
            saveResource("Config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(ConfigFile);
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Placeholder(this).register();
        }
        //定时器
        if (config.getBoolean("Config.indicator-enabled")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        Player nearestPlayer = getNearestPlayer(player);
                        String message = null;
                        if (targets.get(player) != null) {
                            message = msg(config.getString("Message.indicator.target-tracking").replace("{target}", targets.get(player).getName()).replace("{ChineseDirection}", getChineseDirection(targets.get(player), player)).replace("{Direction}", getDirection(targets.get(player),player)).replace("{Angle}", String.valueOf(getAngle(player, targets.get(player)))).replace("{Distance}", String.valueOf((int)player.getLocation().distance(targets.get(player).getLocation()))).replace("{Chunk}",getPlayerChunk(targets.get(player))).replace("{Biome}",getPlayerBiome(targets.get(player))));
                        } else {
                            if (config.getBoolean("Config.NearestPlayer-tracking")) {
                                if (nearestPlayer != null) {
                                    message = msg(config.getString("Message.indicator.target-tracking").replace("{target}", nearestPlayer.getName()).replace("{ChineseDirection}", getChineseDirection(nearestPlayer, player)).replace("{Direction}", getDirection(player, nearestPlayer)).replace("{Angle}", String.valueOf(getAngle(nearestPlayer,player))).replace("{Distance}", String.valueOf((int)player.getLocation().distance(nearestPlayer.getLocation()))).replace("{Chunk}",getPlayerChunk(nearestPlayer)).replace("{Biome}",getPlayerBiome(nearestPlayer)));
                                }
                            }
                        }
                        if (message == null) {
                            if (config.getBoolean("Config.Player-Indicator")) {
                                message = msg(config.getString("Message.indicator.Player-Indicator").replace("{Direction}", getPlayerDirection(player)).replace("{Angle}", String.valueOf(getPlayerAngle(player))).replace("{Chunk}",getPlayerChunk(player)).replace("{Biome}",getPlayerBiome(player)));
                            }
                        }
                        sendActionBar(player, message);
                    }
                }
            }.runTaskTimer(this, 0, 10);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ExamplePlugin 已卸载");
    }
    public static String getPlayerBiome(Player player) {
        Biome biome = player.getLocation().getBlock().getBiome();
        return BiomeTranslator.getTranslatedName(biome.name());
    }
    public static String getPlayerChunk(Player player) {
        Chunk chunk = player.getLocation().getChunk();
        return chunk.getX() + "," + chunk.getZ();
    }
    public static String getDirection(Player player1, Player player2) {
        Vector loc1 = player1.getLocation().toVector();
        Vector loc2 = player2.getLocation().toVector();

        Vector direction = loc2.subtract(loc1);

        float yaw = (player1.getLocation().getYaw() - 90) % 360;
        if (yaw < 0) {
            yaw += 360;
        }

        double angleToPlayer2 = Math.toDegrees(Math.atan2(direction.getZ(), direction.getX()));

        double relativeAngle = (angleToPlayer2 - yaw) % 360;
        if (relativeAngle < 0) {
            relativeAngle += 360;
        }

        if (relativeAngle >= 337.5 || relativeAngle < 22.5) {
            return "↓";
        } else if (relativeAngle >= 22.5 && relativeAngle < 67.5) {
            return "↙";
        } else if (relativeAngle >= 67.5 && relativeAngle < 112.5) {
            return "←";
        } else if (relativeAngle >= 112.5 && relativeAngle < 157.5) {
            return "↖";
        } else if (relativeAngle >= 157.5 && relativeAngle < 202.5) {
            return "↑";
        } else if (relativeAngle >= 202.5 && relativeAngle < 247.5) {
            return "↗";
        } else if (relativeAngle >= 247.5 && relativeAngle < 292.5) {
            return "→";
        } else if (relativeAngle >= 292.5) {
            return "↘";
        } else {
            return "未知";
        }
    }
    public String getChineseDirection(Player player1, Player player2) {
        Vector loc1 = player1.getLocation().toVector();
        Vector loc2 = player2.getLocation().toVector();

        Vector direction = loc2.subtract(loc1);

        float yaw = (player1.getLocation().getYaw() - 90) % 360;
        if (yaw < 0) {
            yaw += 360;
        }

        double angleToPlayer2 = Math.toDegrees(Math.atan2(direction.getZ(), direction.getX()));

        double relativeAngle = (angleToPlayer2 - yaw) % 360;
        if (relativeAngle < 0) {
            relativeAngle += 360;
        }

        if ((relativeAngle >= 337.5 && relativeAngle <= 360) || (relativeAngle >= 0 && relativeAngle < 22.5)) {
            return "南";
        } else if (relativeAngle >= 22.5 && relativeAngle < 67.5) {
            return "西南";
        } else if (relativeAngle >= 67.5 && relativeAngle < 112.5) {
            return "西";
        } else if (relativeAngle >= 112.5 && relativeAngle < 157.5) {
            return "西北";
        } else if (relativeAngle >= 157.5 && relativeAngle < 202.5) {
            return "北";
        } else if (relativeAngle >= 202.5 && relativeAngle < 247.5) {
            return "东北";
        } else if (relativeAngle >= 247.5 && relativeAngle < 292.5) {
            return "东";
        } else if (relativeAngle >= 292.5 && relativeAngle < 337.5) {
            return "东南";
        } else {
            return "未知";
        }
    }
    public float getAngle(Player player1, Player player2) {
        Vector loc1 = player1.getLocation().toVector();
        Vector loc2 = player2.getLocation().toVector();

        Vector direction = loc2.subtract(loc1);

        float yaw = (player1.getLocation().getYaw() - 90) % 360;
        if (yaw < 0) {
            yaw += 360;
        }

        double angleToPlayer2 = Math.toDegrees(Math.atan2(direction.getZ(), direction.getX()));

        double relativeAngle = (angleToPlayer2 - yaw) % 360;
        if (relativeAngle < 0) {
            relativeAngle += 360;
        }
        return (float) relativeAngle;
    }
    public String getPlayerDirection(Player player) {
        Location loc = player.getLocation();
        double yaw = (loc.getYaw() + 180) % 360;
        if (yaw < 0) {
            yaw += 360.0;
        }
        if (yaw >= 337.5 || yaw < 22.5) return "北";
        if (yaw >= 22.5 && yaw < 67.5) return "东北";
        if (yaw >= 67.5 && yaw < 112.5) return "东";
        if (yaw >= 112.5 && yaw < 157.5) return "东南";
        if (yaw >= 157.5 && yaw < 202.5) return "南";
        if (yaw >= 202.5 && yaw < 247.5) return "西南";
        if (yaw >= 247.5 && yaw < 292.5) return "西";
        if (yaw >= 292.5) return "西北";

        return "未知方向";
    }
    public float getPlayerAngle(Player player) {
        Location loc = player.getLocation();
        double yaw = (loc.getYaw() + 360) % 360;
        if (yaw < 0) {
            yaw += 360.0;
        }
        return (float) yaw;
    }
    public void sendActionBar(Player player, String message) {

        if (player == null || message == null) return;
        String nmsVersion = Bukkit.getServer().getClass().getPackage().getName();
        nmsVersion = nmsVersion.substring(nmsVersion.lastIndexOf(".") + 1);

        //1.10 and up
        if (!nmsVersion.startsWith("v1_9_R") && !nmsVersion.startsWith("v1_8_R")) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
            return;
        }

        //1.8.x and 1.9.x
        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nmsVersion + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);

            Class<?> ppoc = Class.forName("net.minecraft.server." + nmsVersion + ".PacketPlayOutChat");
            Class<?> packet = Class.forName("net.minecraft.server." + nmsVersion + ".Packet");
            Object packetPlayOutChat;
            Class<?> chat = Class.forName("net.minecraft.server." + nmsVersion + (nmsVersion.equalsIgnoreCase("v1_8_R1") ? ".ChatSerializer" : ".ChatComponentText"));
            Class<?> chatBaseComponent = Class.forName("net.minecraft.server." + nmsVersion + ".IChatBaseComponent");

            Method method = null;
            if (nmsVersion.equalsIgnoreCase("v1_8_R1")) method = chat.getDeclaredMethod("a", String.class);

            Object object = nmsVersion.equalsIgnoreCase("v1_8_R1") ? chatBaseComponent.cast(Objects.requireNonNull(method).invoke(chat, "{'text': '" + message + "'}")) : chat.getConstructor(new Class[]{String.class}).newInstance(message);
            packetPlayOutChat = ppoc.getConstructor(new Class[]{chatBaseComponent, Byte.TYPE}).newInstance(object, (byte) 2);

            Method handle = craftPlayerClass.getDeclaredMethod("getHandle");
            Object iCraftPlayer = handle.invoke(craftPlayer);
            Field playerConnectionField = iCraftPlayer.getClass().getDeclaredField("playerConnection");
            Object playerConnection = playerConnectionField.get(iCraftPlayer);
            Method sendPacket = playerConnection.getClass().getDeclaredMethod("sendPacket", packet);
            sendPacket.invoke(playerConnection, packetPlayOutChat);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Player getNearestPlayer(Player player) {
        Location playerLocation = player.getLocation();
        Player nearestPlayer = null;
        double nearestDistanceSquared = Double.MAX_VALUE;

        for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
            if (otherPlayer.equals(player)) continue;

            Location otherPlayerLocation = otherPlayer.getLocation();
            double distanceSquared = playerLocation.distanceSquared(otherPlayerLocation);

            if (distanceSquared < nearestDistanceSquared) {
                nearestDistanceSquared = distanceSquared;
                nearestPlayer = otherPlayer;
            }
        }

        return nearestPlayer;
    }
    public void ReStart(){
        this.setEnabled(false);
        this.setEnabled(true);
    }
}
