package cn.ng;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
/*
 * An example of direction and distance between players
 *
 * By: 念国
 *
 */

public final class Example extends JavaPlugin implements Listener {

    public final String version = getDescription().getVersion();
    public String msg(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("ExamplePlugin 已启用");

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Placeholder(this).register();
        }
        //定时器
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    Player nearestPlayer = getNearestPlayer(player);
                    String message;
                    if (nearestPlayer != null) {
                        message = msg("&f最近的玩家: &e" + nearestPlayer.getName()+" &8| &f方向: &b"+getChineseDirection(nearestPlayer,player)+" "+getAngle(player, nearestPlayer)+"° &8| &f箭头: &b&l"+getDirection(player,nearestPlayer)+" &8| &f距离: &a" + (int) player.getLocation().distance(nearestPlayer.getLocation()) + " 格");
                    } else {
                        message = msg("&f当前: &b"+getPlayerDirection(player)+" "+getPlayerAngle(player)+"°");
                    }
                    sendActionBar(player, message);
                }
            }
        }.runTaskTimer(this, 0, 10);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ExamplePlugin 已卸载");
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
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
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
}
