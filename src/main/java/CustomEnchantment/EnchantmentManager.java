package CustomEnchantment;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EnchantmentManager {


    public static final CrippleEnchantment crippleEnchantment = new CrippleEnchantment("cripple", "Sakatla", 1);
    public static final LifeStealEnchantment lifesteal = new LifeStealEnchantment("lifeleech", "Yaşam Yutma", 1);
    public static final PosionEnchantment posion = new PosionEnchantment("posion", "Zehirle", 1);
    public static final BlindEnchantment blind = new BlindEnchantment("blind","Körlük",1);



    public static void register() {
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(crippleEnchantment);
        boolean registered1 = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(lifesteal);
        boolean registered2 = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(posion);
        boolean registered3 = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(blind);



        if (!registered || !registered1 || !registered2 || !registered3) {


            registerEnchantment(crippleEnchantment);
            registerEnchantment(lifesteal);
            registerEnchantment(posion);
            registerEnchantment(blind);


        }


    }


    public static void registerEnchantment(Enchantment enchantment) {

        boolean registered = true;

        try {

            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);

        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if (registered) {
            System.out.println("Büyü eklendi");
        }
    }


}
