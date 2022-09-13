package CustomEnchantment;

import me.muratcan.cursedplugin.CursedPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class AntiHealEnchantment extends Enchantment {
    private final String name;
    private final int maxLevel;


    public AntiHealEnchantment(String namespace, String name, int level) {
        super(NamespacedKey.minecraft(namespace));

        this.name = name;
        this.maxLevel = level;

    }

    @Override
    public String getName() {
        return "Şifa Engelleme";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
