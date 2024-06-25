package cn.ng;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

public class Command implements CommandExecutor {
    private final Example plugin;
    private String msg(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
    public Map<Player,Player> Request=new HashMap<>();
    public Command(Example plugin) {
        this.plugin = plugin;
    }
    public static final Map<String, BukkitTask> ET1 = new HashMap<>();
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
        }else if (label.equalsIgnoreCase("track")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (Example.targets.containsKey(player)) {
                        Player target = Example.targets.get(player);
                        player.sendMessage(msg("&a你的目标玩家是: &e" + target.getName()));
                    } else {
                        player.sendMessage(msg("&c你还没有设置目标玩家."));
                    }
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("accept")) {
                        if (player.hasPermission("track.accept")) {
                            if (Request.containsKey(player)) {
                                Player player2 = Request.get(player);
                                if (player2 != null) {
                                    Example.targets.put(player2, player);
                                    Request.remove(player);
                                    player.sendMessage(msg("&a玩家 " + player2.getName() + " 已同意你的追踪请求."));
                                    player2.sendMessage(msg("&a你已同意追踪请求."));
                                    if (ET1.containsKey(player.getName())) {
                                        ET1.get(player.getName()).cancel();
                                    }
                                }
                            } else {
                                player.sendMessage(msg("&c你还没有收到任何追踪请求."));
                            }
                        } else {
                            player.sendMessage(msg("&c你没有权限执行该指令."));
                        }
                    } else if (args[0].equalsIgnoreCase("deny")) {
                        if (player.hasPermission("track.deny")) {
                            if (Request.containsKey(player)) {
                                Player player2 = Request.get(player);
                                if (player2 != null) {
                                    Request.remove(player);
                                    player.sendMessage(msg("&a玩家 " + player2.getName() + " 已拒绝你的追踪请求."));
                                    player2.sendMessage(msg("&c你已拒绝追踪请求."));
                                    if (ET1.containsKey(player.getName())) {
                                        ET1.get(player.getName()).cancel();
                                    }
                                }
                            } else {
                                player.sendMessage(msg("&c你还没有收到任何追踪请求."));
                            }
                        } else {
                            player.sendMessage(msg("&c你没有权限执行该指令."));
                        }
                    } else {
                        if (player.hasPermission("ind.track")) {
                            if (Example.targets.get(player) == null) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null&&!target.equals(player)) {
                                Request.put(target, player);
                                player.sendMessage(msg("&a你已向玩家 " + target.getName() + " 发送追踪请求."));
                                target.sendMessage(msg("&a玩家 " + player.getName() + "请求追踪你. 输入/track accept接受或/track deny拒绝."));
                                BukkitTask task = Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                    if (Request.get(target)!=null) {
                                        player.sendMessage(msg("&c追踪请求已过期. 请重新发送."));
                                        Request.remove(target);
                                    }
                                    ET1.get(player.getName()).cancel();
                                }, plugin.config.getLong("Request-Time",20 * 20L));
                                ET1.put(player.getName(),task);
                            }
                            }else {
                                player.sendMessage(msg("&c你正在追踪其他玩家."));
                            }
                        }else{
                            player.sendMessage(msg("&c你没有权限执行该指令."));
                        }
                    }
                }
            }
        }else if (label.equalsIgnoreCase("qx")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (Example.targets.containsKey(player)) {
                        Player target = Example.targets.get(player);
                        if (target != null) {
                            Example.targets.remove(player);
                            Example.targets.remove(target);
                            player.sendMessage(msg("&a你已停止追踪玩家 " + target.getName() + "."));
                            target.sendMessage(msg("&c玩家 " + player.getName() + "已停止追踪你."));
                        }
                    } else {
                        player.sendMessage(msg("&c你还没有追踪任何玩家."));
                    }
                }
            }
        }
        return false;
    }
}
