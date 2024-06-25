package cn.ng;

import java.util.HashMap;
import java.util.Map;

public class BiomeTranslator {

    private static final Map<String, String> biomeTranslations = new HashMap<>();


    static {
        addBiomeTranslation("DESERT", "沙漠");
        addBiomeTranslation("PLAINS", "平原");
        addBiomeTranslation("FOREST", "森林");
        addBiomeTranslation("OCEAN", "海洋");
        addBiomeTranslation("Sunflower Plains", "向日葵平原");
        addBiomeTranslation("sunflower_plains", "向日葵平原");
        addBiomeTranslation("Extreme Hills","风袭丘陵");
        addBiomeTranslation("mountains","风袭丘陵");
        addBiomeTranslation("minecraft:windswept_hills","风袭丘陵");
        addBiomeTranslation("Flower Forest","繁花森林");
        addBiomeTranslation("flower_forest","繁花森林");
        addBiomeTranslation("Taiga","针叶林");
        addBiomeTranslation("River","河流");
        addBiomeTranslation("Swampland","沼泽");
        addBiomeTranslation("swamp","沼泽");
        addBiomeTranslation("FrozenRiver","冻河");
        addBiomeTranslation("frozen_river","冻河");
        addBiomeTranslation("FrozenOcean","冻洋");
        addBiomeTranslation("frozen_ocean","冻洋");
        addBiomeTranslation("Ice Plains Spikes","冰刺之地");
        addBiomeTranslation("ice_spikes","冰刺之地");
        addBiomeTranslation("Ice Plains","雪原");
        addBiomeTranslation("snowy_tundra","雪原");
        addBiomeTranslation("minecraft:snowy_plains","雪原");
        addBiomeTranslation("MushroomIsland","蘑菇岛");
        addBiomeTranslation("mushroom_fields","蘑菇岛");
        addBiomeTranslation("Ice Mountains","雪山");
        addBiomeTranslation("snowy_mountains","雪山");
        addBiomeTranslation("Beach","沙滩");
        addBiomeTranslation("MushroomIslandShore","蘑菇岛岸");
        addBiomeTranslation("mushroom_field_shore","蘑菇岛岸");
        addBiomeTranslation("ForestHills","繁茂的丘陵");
        addBiomeTranslation("wooded_hills","繁茂的丘陵");
        addBiomeTranslation("DesertHills","沙漠丘陵");
        addBiomeTranslation("desert_hills","沙漠丘陵");
        addBiomeTranslation("Extreme Hills Edge","山地边缘");
        addBiomeTranslation("mountain_edge","山地边缘");
        addBiomeTranslation("TaigaHills","针叶林丘陵");
        addBiomeTranslation("taiga_hills","针叶林丘陵");
        addBiomeTranslation("JungleHills","丛林丘陵");
        addBiomeTranslation("jungle_hills","丛林丘陵");
        addBiomeTranslation("jungle","丛林");
        addBiomeTranslation("Deep Ocean","深海");
        addBiomeTranslation("deep_ocean","深海");
        addBiomeTranslation("JungleEdge","稀疏丛林");
        addBiomeTranslation("jungle_edge","稀疏丛林");
        addBiomeTranslation("minecraft:sparse_jungle","稀疏丛林");
        addBiomeTranslation("Stone Beach","石岸");
        addBiomeTranslation("stone_shore","石岸");
        addBiomeTranslation("minecraft:stony_shore","石岸");
        addBiomeTranslation("Cold Beach","积雪沙滩");
        addBiomeTranslation("snowy_beach","积雪沙滩");
        addBiomeTranslation("Birch Forest","桦木森林");
        addBiomeTranslation("birch_forest","桦木森林");
        addBiomeTranslation("Birch Forest M","原始桦木森林");
        addBiomeTranslation("tall_birch_forest","原始桦木森林");
        addBiomeTranslation("minecraft:old_growth_birch_forest","原始桦木森林");
        addBiomeTranslation("Birch Forest","桦木森林丘陵");
        addBiomeTranslation("birch_forest","桦木森林丘陵");
        addBiomeTranslation("Roofed Forest","黑森林");
        addBiomeTranslation("dark_forest","黑森林");
        addBiomeTranslation("Cold Taiga","积雪针叶林");
        addBiomeTranslation("snowy_taiga","积雪针叶林");
        addBiomeTranslation("Cold Taiga Hills","积雪的针叶林丘陵");
        addBiomeTranslation("snowy_taiga_hills","积雪的针叶林丘陵");
        addBiomeTranslation("Mega Taiga","原始云杉针叶林");
        addBiomeTranslation("giant_spruce_taiga","原始云杉针叶林");
        addBiomeTranslation("minecraft:old_growth_spruce_taiga","原始云杉针叶林");
        addBiomeTranslation("Mega Taiga Hills","巨型云杉针叶林丘陵");
        addBiomeTranslation("giant_spruce_taiga_hills","巨型云杉针叶林丘陵");
        addBiomeTranslation("Extreme Hills+","风袭森林");
        addBiomeTranslation("wooded_mountains","风袭森林");
        addBiomeTranslation("minecraft:windswept_forest","风袭森林");
        addBiomeTranslation("Savanna","热带草原");
        addBiomeTranslation("Mesa","恶地");
        addBiomeTranslation("badlands","恶地");
        addBiomeTranslation("Savanna Plateau","热带高原");
        addBiomeTranslation("savanna_plateau","热带高原");
        addBiomeTranslation("Mesa Plateau F M","繁茂的恶地高原变种");
        addBiomeTranslation("modified_wooded_badlands_plateau","繁茂的恶地高原变种");
        addBiomeTranslation("Mesa Plateau F","疏林恶地");
        addBiomeTranslation("wooded_badlands_plateau","疏林恶地");
        addBiomeTranslation("minecraft:wooded_badlands","疏林恶地");
        addBiomeTranslation("Hell","下界荒地");
        addBiomeTranslation("nether","下界荒地");
        addBiomeTranslation("nether_wastes","下界荒地");
        addBiomeTranslation("Mesa Plateau","恶地高原");
        addBiomeTranslation("badlands_plateau","恶地高原");
        addBiomeTranslation("The Void","虚空");
        addBiomeTranslation("the_void","虚空");
        addBiomeTranslation("The End","末地");
        addBiomeTranslation("the_end","末地");
        addBiomeTranslation("dark_forest_hills","黑森林丘陵");
        addBiomeTranslation("cold_ocean","冷水海洋");
        addBiomeTranslation("deep_frozen_ocean","冰冻深海");
        addBiomeTranslation("deep_cold_ocean","冷水深海");
        addBiomeTranslation("deep_warm_ocean","暖水深海");
        addBiomeTranslation("deep_lukewarm_ocean","温水深海");
        addBiomeTranslation("Desert M","沙漠湖泊");
        addBiomeTranslation("desert_lakes","沙漠湖泊");
        addBiomeTranslation("end_barrens","末地荒地");
        addBiomeTranslation("end_midlands","末地内陆");
        addBiomeTranslation("end_highlands","末地高地");
        addBiomeTranslation("eroded_badlands","风蚀恶地");
        addBiomeTranslation("small_end_islands","末地小型岛屿");
        addBiomeTranslation("giant_tree_taiga","原始松木针叶林");
        addBiomeTranslation("minecraft:old_growth_pine_taiga","原始松木针叶林");
        addBiomeTranslation("giant_tree_taiga_hills","巨型针叶林丘陵");
        addBiomeTranslation("lukewarm_ocean","温水海洋");
        addBiomeTranslation("gravelly_mountains","风袭砂砾丘陵");
        addBiomeTranslation("minecraft:windswept_gravelly_hills","风袭砂砾丘陵");
        addBiomeTranslation("modified_gravelly_mountains","砂砾山地");
        addBiomeTranslation("Mesa Plateau M","恶地高原变种");
        addBiomeTranslation("modified_badlands_plateau","恶地高原变种");
        addBiomeTranslation("Jungle M","丛林变种");
        addBiomeTranslation("modified_jungle","丛林变种");
        addBiomeTranslation("JungleEdge M","丛林边缘变种");
        addBiomeTranslation("modified_jungle_edge","丛林边缘变种");
        addBiomeTranslation("Savanna M","风袭热带草原");
        addBiomeTranslation("shattered_savanna","风袭热带草原");
        addBiomeTranslation("minecraft:windswept_savanna","风袭热带草原");
        addBiomeTranslation("Savanna Plateau M","破碎的热带高原");
        addBiomeTranslation("shattered_savanna_plateau","破碎的热带高原");
        addBiomeTranslation("swamp_hills","沼泽丘陵");
        addBiomeTranslation("snowy_taiga_mountains","积雪的针叶林山地");
        addBiomeTranslation("tall_birch_hills","高大桦木丘陵");
        addBiomeTranslation("taiga_mountains","针叶林山地");
        addBiomeTranslation("warm_ocean","暖水海洋");
        addBiomeTranslation("bamboo_jungle","竹林");
        addBiomeTranslation("basalt_deltas","玄武岩三角洲");
        addBiomeTranslation("bamboo_jungle_hills","竹林丘陵");
        addBiomeTranslation("warped_forest","诡异森林");
        addBiomeTranslation("crimson_forest","绯红森林");
        addBiomeTranslation("minecraft:dripstone_caves","溶洞");
        addBiomeTranslation("soul_sand_valley","灵魂沙峡谷");
        addBiomeTranslation("minecraft:frozen_peaks","冰封山峰");
        addBiomeTranslation("minecraft:lush_caves","繁茂洞穴");
        addBiomeTranslation("minecraft:jagged_peaks","尖峭山峰");
        addBiomeTranslation("minecraft:grove","雪林");
        addBiomeTranslation("minecraft:snowy_slopes","积雪山坡");
        addBiomeTranslation("minecraft:meadow","草甸");
        addBiomeTranslation("minecraft:deep_dark","深暗之域");
        addBiomeTranslation("minecraft:stony_peaks","裸岩山峰");
        addBiomeTranslation("minecraft:cherry_grove","樱花树林");
        addBiomeTranslation("minecraft:mangrove_swamp","红树林沼泽");
    }

    private static void addBiomeTranslation(String biomeName, String translation) {
        biomeTranslations.put(biomeName.toUpperCase(), translation);
    }


    public static String getTranslatedName(String biomeName) {
        String upperCaseBiomeName = biomeName.toUpperCase();
        return biomeTranslations.getOrDefault(upperCaseBiomeName, upperCaseBiomeName);
    }
}
