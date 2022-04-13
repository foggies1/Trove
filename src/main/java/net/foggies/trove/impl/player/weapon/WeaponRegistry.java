package net.foggies.trove.impl.player.weapon;

import net.foggies.trove.Trove;
import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.impl.player.weapon.weapons.ubereight.*;
import net.foggies.trove.impl.player.weapon.weapons.uberfive.*;
import net.foggies.trove.impl.player.weapon.weapons.uberfour.*;
import net.foggies.trove.impl.player.weapon.weapons.ubernine.*;
import net.foggies.trove.impl.player.weapon.weapons.uberone.*;
import net.foggies.trove.impl.player.weapon.weapons.uberseven.*;
import net.foggies.trove.impl.player.weapon.weapons.ubersix.*;
import net.foggies.trove.impl.player.weapon.weapons.uberthree.*;
import net.foggies.trove.impl.player.weapon.weapons.ubertwo.*;
import net.foggies.trove.utils.PDUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class WeaponRegistry {

    private final Trove plugin;
    private final Map<String, Weapon> weaponMap; // Weapon Identifier -> Weapon Object.

    public WeaponRegistry(Trove plugin) {
        this.plugin = plugin;
        this.weaponMap = new ConcurrentHashMap<>();
        loadWeapons();
    }

    public List<Weapon> getAllFromUber(UberType uberType){
        return this.weaponMap.values().stream().filter(weapon -> weapon.getUberType() == uberType).collect(Collectors.toList());
    }

    public WeaponAttackResult preformAttack(ItemStack itemStack, TroveBoss boss, Trovian trovian) {
       return getWeapon(itemStack).onAttack(boss, trovian);
    }

    public Weapon getWeapon(ItemStack itemStack) {
        return getWeapon(new PDUtils(plugin, itemStack).get("weapon", PersistentDataType.STRING));
    }

    public Weapon getWeapon(String identifier) {
        return this.weaponMap.get(identifier);
    }

    public boolean isWeapon(ItemStack itemStack){
        return getWeapon(itemStack) != null;
    }

    private void loadWeapons() {
        // Uber One
        this.weaponMap.put("Anthrax", new Anthrax());
        this.weaponMap.put("Plague", new Plague());
        this.weaponMap.put("Ricin", new Ricin());
        this.weaponMap.put("Yellow Rain", new YellowRain());
        this.weaponMap.put("Sling", new Sling());

        // Uber Two
        this.weaponMap.put("Club", new Club());
        this.weaponMap.put("Pike", new Pike());
        this.weaponMap.put("Sabre", new Sabre());
        this.weaponMap.put("Depth Charge", new DepthCharge());
        this.weaponMap.put("Shrapnel", new Shrapnel());

        // Uber Three
        this.weaponMap.put("Torpedo", new Torpedo());
        this.weaponMap.put("Trident", new Trident());
        this.weaponMap.put("Polaris", new Polaris());
        this.weaponMap.put("Peacekeeper", new Peacekeeper());
        this.weaponMap.put("Lance", new Lance());

        // Uber Four
        this.weaponMap.put("Carbine", new Carbine());
        this.weaponMap.put("Gatling", new Gatling());
        this.weaponMap.put("Musket", new Musket());
        this.weaponMap.put("Big Bertha", new BigBertha());
        this.weaponMap.put("Culverin", new Culverin());
        this.weaponMap.put("Vulcan", new Vulcan());

        // Uber Five
        this.weaponMap.put("Name Taker", new NameTaker());
        this.weaponMap.put("Typhoon", new Typhoon());
        this.weaponMap.put("Soul Sniper", new SoulSniper());
        this.weaponMap.put("Little Tiger", new LittleTiger());
        this.weaponMap.put("Felons Foil", new FelonsFoil());

        // Uber Six
        this.weaponMap.put("Epilogue", new Epilogue());
        this.weaponMap.put("Reflector", new Reflector());
        this.weaponMap.put("Reaper", new Reaper());
        this.weaponMap.put("Boom Stick", new BoomStick());
        this.weaponMap.put("Jaw Breaker", new JawBreaker());

        // Uber Seven
        this.weaponMap.put("Infamy", new Infamy());
        this.weaponMap.put("Ebon Blade", new EbonBlade());
        this.weaponMap.put("Reckless Reaver", new RecklessReaver());
        this.weaponMap.put("Doom Caster", new DoomCaster());
        this.weaponMap.put("Bull Dog", new BullDog());

        // Uber Eight
        this.weaponMap.put("Spell Shard", new SpellShard());
        this.weaponMap.put("Guard", new Guard());
        this.weaponMap.put("Little Tiger V2", new LittleTigerV2());
        this.weaponMap.put("Flesh Reaper", new FleshReaper());
        this.weaponMap.put("Phantom", new Phantom());
        this.weaponMap.put("Tome", new Tome());

        // Uber Nine
        this.weaponMap.put("Time Saver", new TimeSaver());
        this.weaponMap.put("Angel Maker", new AngelMaker());
        this.weaponMap.put("Splinter Caster", new SplinterCaster());
        this.weaponMap.put("Sabre Of The Outer Planes", new SabreOfTheOuterPlanes());
        this.weaponMap.put("Brackium", new Brackium());
    }

}
