package cn.ng;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    private final Example plugin;
    private String msg(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public Command(Example plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("ind")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("ind.admin")) {
                    if (args.length == 0) {
                        player.sendMessage(msg("&aExample Plugin &7- &b"+plugin.version+"  &eAuthor.&b念国"));
                        player.sendMessage(msg("&f/ind&b help &7- &a显示帮助信息"));
                        player.sendMessage(msg("&f/ind&b reload &7- &a重新加载插件"));
                        player.sendMessage(msg("&f/ind&b setTarget &e<玩家1> <玩家2> &7- &a设置玩家1和玩家2的目标"));
                        player.sendMessage(msg("&f/ind&b delTarget &e<玩家> &7- &a移除玩家当前追踪的目标"));
                    }else if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(msg("&aExample Plugin &7- &b"+plugin.version+"  &eAuthor.&b念国"));
                        player.sendMessage(msg("&f/ind&b help &7- &a显示帮助信息"));
                        player.sendMessage(msg("&f/ind&b reload &7- &a重新加载插件"));
                        player.sendMessage(msg("&f/ind&b setTarget &e<玩家1> <玩家2> &7- &a设置玩家1和玩家2的目标"));
                        player.sendMessage(msg("&f/ind&b delTarget &e<玩家> &7- &a移除玩家当前追踪的目标"));
                    }else if (args[0].equalsIgnoreCase("reload")) {
                        plugin.ReStart();
                        player.sendMessage("插件已重新加载.");
                    }else if (args[0].equalsIgnoreCase("delTarget")){
                        if (args.length == 2) {
                            String playerName = args[1];

                            Player player1 = Bukkit.getPlayer(playerName);

                            if (player1 != null) {
                                Example.targets.remove(player1);
                            }
                            player.sendMessage(playerName + "的目标已移除.");
                        }else{
                            player.sendMessage(msg("&f/ind&b delTarget &e<玩家>"));
                        }
                    }else if (args[0].equalsIgnoreCase("setTarget")) {
                        if (args.length == 3) {
                            String player1Name = args[1];
                            String player2Name = args[2];

                            Player player1 = Bukkit.getPlayer(player1Name);
                            Player player2 = Bukkit.getPlayer(player2Name);

                            if (player1 != null && player2 != null) {
                                Example.targets.put(player1, player2);
                                Example.targets.put(player2, player1);
                            } else {
                                player.sendMessage("一个或两个玩家都不在线.");
                            }
                        } else {
                            player.sendMessage(msg("&f/ind&b setTarget &e<玩家1> <玩家2>"));
                        }
                    }
                }else {
                    player.sendMessage(ChatColor.RED + "你没有权限执行该命令!");
                }
            }else if (sender instanceof ConsoleCommandSender){
                if (args.length == 0) {
                    Bukkit.getLogger().info(msg("&aExample Plugin &7- &b"+plugin.version+"  &eAuthor.&b念国"));
                    Bukkit.getLogger().info(msg("&f/ind&b help &7- &a显示帮助信息"));
                    Bukkit.getLogger().info(msg("&f/ind&b reload &7- &a重新加载插件"));
                    Bukkit.getLogger().info(msg("&f/ind&b setTarget &e<玩家1> <玩家2> &7- &a设置玩家1和玩家2的目标"));
                    Bukkit.getLogger().info(msg("&f/ind&b delTarget &e<玩家> &7- &a移除玩家当前追踪的目标"));
                }else if (args[0].equalsIgnoreCase("help")){
                    Bukkit.getLogger().info(msg("&aExample Plugin &7- &b"+plugin.version+"  &eAuthor.&b念国"));
                    Bukkit.getLogger().info(msg("&f/ind&b help &7- &a显示帮助信息"));
                    Bukkit.getLogger().info(msg("&f/ind&b reload &7- &a重新加载插件"));
                    Bukkit.getLogger().info(msg("&f/ind&b setTarget &e<玩家1> <玩家2> &7- &a设置玩家1和玩家2的目标"));
                    Bukkit.getLogger().info(msg("&f/ind&b delTarget &e<玩家> &7- &a移除玩家当前追踪的目标"));
                }else if (args[0].equalsIgnoreCase("reload")) {
                    plugin.ReStart();
                    Bukkit.getLogger().info("插件已重新加载.");
                }else if (args[0].equalsIgnoreCase("delTarget")){
                    if (args.length == 2) {
                        String playerName = args[1];
                        Player player = Bukkit.getPlayer(playerName);

                        if (player != null) {
                            Example.targets.remove(player);
                            Bukkit.getLogger().info(playerName + "的目标已移除.");
                        } else {
                            Bukkit.getLogger().info("玩家不在线.");
                        }
                    }else{
                        Bukkit.getLogger().info(msg("&f/ind&b delTarget &e<玩家>"));
                    }
                }else if (args[0].equalsIgnoreCase("setTarget")) {
                    if (args.length == 3) {
                        String player1Name = args[1];
                        String player2Name = args[2];

                        Player player1 = Bukkit.getPlayer(player1Name);
                        Player player2 = Bukkit.getPlayer(player2Name);

                        if (player1 != null && player2 != null) {
                            Example.targets.put(player1, player2);
                            Example.targets.put(player2, player1);
                        } else {
                            Bukkit.getLogger().info("一个或两个玩家都不在线.");
                        }
                    } else {
                        Bukkit.getLogger().info(msg("&f/ind&b setTarget &e<玩家1> <玩家2>"));
                    }
                }
            }
        }
        return false;
    }
}
